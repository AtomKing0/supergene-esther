package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Processor implements ForegroundProcessor {
    private static final String FOREGROUND_WAKELOCK_TAG = "ProcessorForegroundLck";
    private static final String TAG = Logger.tagWithPrefix("Processor");
    private Context mAppContext;
    private Configuration mConfiguration;
    private WorkDatabase mWorkDatabase;
    private TaskExecutor mWorkTaskExecutor;
    private Map<String, WorkerWrapper> mEnqueuedWorkMap = new HashMap();
    private Map<String, WorkerWrapper> mForegroundWorkMap = new HashMap();
    private Set<String> mCancelledIds = new HashSet();
    private final List<ExecutionListener> mOuterListeners = new ArrayList();

    @Nullable
    private PowerManager.WakeLock mForegroundLock = null;
    private final Object mLock = new Object();
    private Map<String, Set<StartStopToken>> mWorkRuns = new HashMap();

    public Processor(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull WorkDatabase workDatabase) {
        this.mAppContext = context;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = taskExecutor;
        this.mWorkDatabase = workDatabase;
    }

    @Nullable
    private WorkerWrapper cleanUpWorkerUnsafe(@NonNull String str) {
        WorkerWrapper workerWrapperRemove = this.mForegroundWorkMap.remove(str);
        boolean z10 = workerWrapperRemove != null;
        if (!z10) {
            workerWrapperRemove = this.mEnqueuedWorkMap.remove(str);
        }
        this.mWorkRuns.remove(str);
        if (z10) {
            stopForegroundService();
        }
        return workerWrapperRemove;
    }

    @Nullable
    private WorkerWrapper getWorkerWrapperUnsafe(@NonNull String str) {
        WorkerWrapper workerWrapper = this.mForegroundWorkMap.get(str);
        return workerWrapper == null ? this.mEnqueuedWorkMap.get(str) : workerWrapper;
    }

    private static boolean interrupt(@NonNull String str, @Nullable WorkerWrapper workerWrapper, int i10) {
        if (workerWrapper == null) {
            Logger.get().debug(TAG, "WorkerWrapper could not be found for " + str);
            return false;
        }
        workerWrapper.interrupt(i10);
        Logger.get().debug(TAG, "WorkerWrapper interrupted for " + str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runOnExecuted$2(WorkGenerationalId workGenerationalId, boolean z10) {
        synchronized (this.mLock) {
            Iterator<ExecutionListener> it = this.mOuterListeners.iterator();
            while (it.hasNext()) {
                it.next().onExecuted(workGenerationalId, z10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WorkSpec lambda$startWork$0(ArrayList arrayList, String str) throws Exception {
        arrayList.addAll(this.mWorkDatabase.workTagDao().getTagsForWorkSpecId(str));
        return this.mWorkDatabase.workSpecDao().getWorkSpec(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$startWork$1(m mVar, WorkerWrapper workerWrapper) {
        boolean zBooleanValue;
        try {
            zBooleanValue = ((Boolean) mVar.get()).booleanValue();
        } catch (InterruptedException | ExecutionException unused) {
            zBooleanValue = true;
        }
        onExecuted(workerWrapper, zBooleanValue);
    }

    private void onExecuted(@NonNull WorkerWrapper workerWrapper, boolean z10) {
        synchronized (this.mLock) {
            WorkGenerationalId workGenerationalId = workerWrapper.getWorkGenerationalId();
            String workSpecId = workGenerationalId.getWorkSpecId();
            if (getWorkerWrapperUnsafe(workSpecId) == workerWrapper) {
                cleanUpWorkerUnsafe(workSpecId);
            }
            Logger.get().debug(TAG, getClass().getSimpleName() + " " + workSpecId + " executed; reschedule = " + z10);
            Iterator<ExecutionListener> it = this.mOuterListeners.iterator();
            while (it.hasNext()) {
                it.next().onExecuted(workGenerationalId, z10);
            }
        }
    }

    private void runOnExecuted(@NonNull final WorkGenerationalId workGenerationalId, final boolean z10) {
        this.mWorkTaskExecutor.getMainThreadExecutor().execute(new Runnable() { // from class: androidx.work.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f1766a.lambda$runOnExecuted$2(workGenerationalId, z10);
            }
        });
    }

    private void stopForegroundService() {
        synchronized (this.mLock) {
            if (!(!this.mForegroundWorkMap.isEmpty())) {
                try {
                    this.mAppContext.startService(SystemForegroundDispatcher.createStopForegroundIntent(this.mAppContext));
                } catch (Throwable th) {
                    Logger.get().error(TAG, "Unable to stop foreground service", th);
                }
                PowerManager.WakeLock wakeLock = this.mForegroundLock;
                if (wakeLock != null) {
                    wakeLock.release();
                    this.mForegroundLock = null;
                }
            }
        }
    }

    public void addExecutionListener(@NonNull ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.add(executionListener);
        }
    }

    @Nullable
    public WorkSpec getRunningWorkSpec(@NonNull String str) {
        synchronized (this.mLock) {
            WorkerWrapper workerWrapperUnsafe = getWorkerWrapperUnsafe(str);
            if (workerWrapperUnsafe == null) {
                return null;
            }
            return workerWrapperUnsafe.getWorkSpec();
        }
    }

    public boolean hasWork() {
        boolean z10;
        synchronized (this.mLock) {
            z10 = (this.mEnqueuedWorkMap.isEmpty() && this.mForegroundWorkMap.isEmpty()) ? false : true;
        }
        return z10;
    }

    public boolean isCancelled(@NonNull String str) {
        boolean zContains;
        synchronized (this.mLock) {
            zContains = this.mCancelledIds.contains(str);
        }
        return zContains;
    }

    public boolean isEnqueued(@NonNull String str) {
        boolean z10;
        synchronized (this.mLock) {
            z10 = getWorkerWrapperUnsafe(str) != null;
        }
        return z10;
    }

    public void removeExecutionListener(@NonNull ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.remove(executionListener);
        }
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public void startForeground(@NonNull String str, @NonNull ForegroundInfo foregroundInfo) {
        synchronized (this.mLock) {
            Logger.get().info(TAG, "Moving WorkSpec (" + str + ") to the foreground");
            WorkerWrapper workerWrapperRemove = this.mEnqueuedWorkMap.remove(str);
            if (workerWrapperRemove != null) {
                if (this.mForegroundLock == null) {
                    PowerManager.WakeLock wakeLockNewWakeLock = WakeLocks.newWakeLock(this.mAppContext, FOREGROUND_WAKELOCK_TAG);
                    this.mForegroundLock = wakeLockNewWakeLock;
                    wakeLockNewWakeLock.acquire();
                }
                this.mForegroundWorkMap.put(str, workerWrapperRemove);
                ContextCompat.startForegroundService(this.mAppContext, SystemForegroundDispatcher.createStartForegroundIntent(this.mAppContext, workerWrapperRemove.getWorkGenerationalId(), foregroundInfo));
            }
        }
    }

    public boolean startWork(@NonNull StartStopToken startStopToken) {
        return startWork(startStopToken, null);
    }

    public boolean stopAndCancelWork(@NonNull String str, int i10) {
        WorkerWrapper workerWrapperCleanUpWorkerUnsafe;
        synchronized (this.mLock) {
            Logger.get().debug(TAG, "Processor cancelling " + str);
            this.mCancelledIds.add(str);
            workerWrapperCleanUpWorkerUnsafe = cleanUpWorkerUnsafe(str);
        }
        return interrupt(str, workerWrapperCleanUpWorkerUnsafe, i10);
    }

    public boolean stopForegroundWork(@NonNull StartStopToken startStopToken, int i10) {
        WorkerWrapper workerWrapperCleanUpWorkerUnsafe;
        String workSpecId = startStopToken.getId().getWorkSpecId();
        synchronized (this.mLock) {
            workerWrapperCleanUpWorkerUnsafe = cleanUpWorkerUnsafe(workSpecId);
        }
        return interrupt(workSpecId, workerWrapperCleanUpWorkerUnsafe, i10);
    }

    public boolean stopWork(@NonNull StartStopToken startStopToken, int i10) {
        String workSpecId = startStopToken.getId().getWorkSpecId();
        synchronized (this.mLock) {
            if (this.mForegroundWorkMap.get(workSpecId) == null) {
                Set<StartStopToken> set = this.mWorkRuns.get(workSpecId);
                if (set != null && set.contains(startStopToken)) {
                    return interrupt(workSpecId, cleanUpWorkerUnsafe(workSpecId), i10);
                }
                return false;
            }
            Logger.get().debug(TAG, "Ignored stopWork. WorkerWrapper " + workSpecId + " is in foreground");
            return false;
        }
    }

    public boolean startWork(@NonNull StartStopToken startStopToken, @Nullable WorkerParameters.RuntimeExtras runtimeExtras) {
        WorkGenerationalId id = startStopToken.getId();
        final String workSpecId = id.getWorkSpecId();
        final ArrayList arrayList = new ArrayList();
        WorkSpec workSpec = (WorkSpec) this.mWorkDatabase.runInTransaction(new Callable() { // from class: androidx.work.impl.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f1756a.lambda$startWork$0(arrayList, workSpecId);
            }
        });
        if (workSpec == null) {
            Logger.get().warning(TAG, "Didn't find WorkSpec for id " + id);
            runOnExecuted(id, false);
            return false;
        }
        synchronized (this.mLock) {
            if (isEnqueued(workSpecId)) {
                Set<StartStopToken> set = this.mWorkRuns.get(workSpecId);
                if (set.iterator().next().getId().getGeneration() == id.getGeneration()) {
                    set.add(startStopToken);
                    Logger.get().debug(TAG, "Work " + id + " is already enqueued for processing");
                } else {
                    runOnExecuted(id, false);
                }
                return false;
            }
            if (workSpec.getGeneration() != id.getGeneration()) {
                runOnExecuted(id, false);
                return false;
            }
            final WorkerWrapper workerWrapperBuild = new WorkerWrapper.Builder(this.mAppContext, this.mConfiguration, this.mWorkTaskExecutor, this, this.mWorkDatabase, workSpec, arrayList).withRuntimeExtras(runtimeExtras).build();
            final m<Boolean> future = workerWrapperBuild.getFuture();
            future.addListener(new Runnable() { // from class: androidx.work.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1759a.lambda$startWork$1(future, workerWrapperBuild);
                }
            }, this.mWorkTaskExecutor.getMainThreadExecutor());
            this.mEnqueuedWorkMap.put(workSpecId, workerWrapperBuild);
            HashSet hashSet = new HashSet();
            hashSet.add(startStopToken);
            this.mWorkRuns.put(workSpecId, hashSet);
            this.mWorkTaskExecutor.getSerialTaskExecutor().execute(workerWrapperBuild);
            Logger.get().debug(TAG, getClass().getSimpleName() + ": processing " + id);
            return true;
        }
    }
}

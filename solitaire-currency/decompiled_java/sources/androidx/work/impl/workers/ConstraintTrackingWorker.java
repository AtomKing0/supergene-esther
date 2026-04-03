package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.google.common.util.concurrent.m;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.k0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ConstraintTrackingWorker.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ConstraintTrackingWorker extends ListenableWorker implements OnConstraintsStateChangedListener {
    private volatile boolean areConstraintsUnmet;

    @Nullable
    private ListenableWorker delegate;
    private final SettableFuture<ListenableWorker.Result> future;

    @NotNull
    private final Object lock;

    @NotNull
    private final WorkerParameters workerParameters;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker(@NotNull Context appContext, @NotNull WorkerParameters workerParameters) {
        super(appContext, workerParameters);
        t.i(appContext, "appContext");
        t.i(workerParameters, "workerParameters");
        this.workerParameters = workerParameters;
        this.lock = new Object();
        this.future = SettableFuture.create();
    }

    private final void setupAndRunConstraintTrackingWork() {
        if (this.future.isCancelled()) {
            return;
        }
        String string = getInputData().getString(ConstraintTrackingWorkerKt.ARGUMENT_CLASS_NAME);
        Logger logger = Logger.get();
        t.h(logger, "get()");
        if (string == null || string.length() == 0) {
            logger.error(ConstraintTrackingWorkerKt.TAG, "No worker to delegate to.");
            SettableFuture<ListenableWorker.Result> future = this.future;
            t.h(future, "future");
            ConstraintTrackingWorkerKt.setFailed(future);
            return;
        }
        ListenableWorker listenableWorkerCreateWorkerWithDefaultFallback = getWorkerFactory().createWorkerWithDefaultFallback(getApplicationContext(), string, this.workerParameters);
        this.delegate = listenableWorkerCreateWorkerWithDefaultFallback;
        if (listenableWorkerCreateWorkerWithDefaultFallback == null) {
            logger.debug(ConstraintTrackingWorkerKt.TAG, "No worker to delegate to.");
            SettableFuture<ListenableWorker.Result> future2 = this.future;
            t.h(future2, "future");
            ConstraintTrackingWorkerKt.setFailed(future2);
            return;
        }
        WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(getApplicationContext());
        t.h(workManagerImpl, "getInstance(applicationContext)");
        WorkSpecDao workSpecDao = workManagerImpl.getWorkDatabase().workSpecDao();
        String string2 = getId().toString();
        t.h(string2, "id.toString()");
        WorkSpec workSpec = workSpecDao.getWorkSpec(string2);
        if (workSpec == null) {
            SettableFuture<ListenableWorker.Result> future3 = this.future;
            t.h(future3, "future");
            ConstraintTrackingWorkerKt.setFailed(future3);
            return;
        }
        Trackers trackers = workManagerImpl.getTrackers();
        t.h(trackers, "workManagerImpl.trackers");
        WorkConstraintsTracker workConstraintsTracker = new WorkConstraintsTracker(trackers);
        k0 taskCoroutineDispatcher = workManagerImpl.getWorkTaskExecutor().getTaskCoroutineDispatcher();
        t.h(taskCoroutineDispatcher, "workManagerImpl.workTask…r.taskCoroutineDispatcher");
        final b2 b2VarListen = WorkConstraintsTrackerKt.listen(workConstraintsTracker, workSpec, taskCoroutineDispatcher, this);
        this.future.addListener(new Runnable() { // from class: h.b
            @Override // java.lang.Runnable
            public final void run() {
                ConstraintTrackingWorker.setupAndRunConstraintTrackingWork$lambda$1(b2VarListen);
            }
        }, new SynchronousExecutor());
        if (!workConstraintsTracker.areAllConstraintsMet(workSpec)) {
            logger.debug(ConstraintTrackingWorkerKt.TAG, "Constraints not met for delegate " + string + ". Requesting retry.");
            SettableFuture<ListenableWorker.Result> future4 = this.future;
            t.h(future4, "future");
            ConstraintTrackingWorkerKt.setRetry(future4);
            return;
        }
        logger.debug(ConstraintTrackingWorkerKt.TAG, "Constraints met for delegate " + string);
        try {
            ListenableWorker listenableWorker = this.delegate;
            t.f(listenableWorker);
            final m<ListenableWorker.Result> mVarStartWork = listenableWorker.startWork();
            t.h(mVarStartWork, "delegate!!.startWork()");
            mVarStartWork.addListener(new Runnable() { // from class: h.c
                @Override // java.lang.Runnable
                public final void run() {
                    ConstraintTrackingWorker.setupAndRunConstraintTrackingWork$lambda$3(this.f26378a, mVarStartWork);
                }
            }, getBackgroundExecutor());
        } catch (Throwable th) {
            logger.debug(ConstraintTrackingWorkerKt.TAG, "Delegated worker " + string + " threw exception in startWork.", th);
            synchronized (this.lock) {
                if (!this.areConstraintsUnmet) {
                    SettableFuture<ListenableWorker.Result> future5 = this.future;
                    t.h(future5, "future");
                    ConstraintTrackingWorkerKt.setFailed(future5);
                } else {
                    logger.debug(ConstraintTrackingWorkerKt.TAG, "Constraints were unmet, Retrying.");
                    SettableFuture<ListenableWorker.Result> future6 = this.future;
                    t.h(future6, "future");
                    ConstraintTrackingWorkerKt.setRetry(future6);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupAndRunConstraintTrackingWork$lambda$1(b2 job) {
        t.i(job, "$job");
        job.cancel(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupAndRunConstraintTrackingWork$lambda$3(ConstraintTrackingWorker this$0, m innerFuture) {
        t.i(this$0, "this$0");
        t.i(innerFuture, "$innerFuture");
        synchronized (this$0.lock) {
            if (this$0.areConstraintsUnmet) {
                SettableFuture<ListenableWorker.Result> future = this$0.future;
                t.h(future, "future");
                ConstraintTrackingWorkerKt.setRetry(future);
            } else {
                this$0.future.setFuture(innerFuture);
            }
            v8.k0 k0Var = v8.k0.f35197a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startWork$lambda$0(ConstraintTrackingWorker this$0) {
        t.i(this$0, "this$0");
        this$0.setupAndRunConstraintTrackingWork();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    @Nullable
    public final ListenableWorker getDelegate() {
        return this.delegate;
    }

    @Override // androidx.work.impl.constraints.OnConstraintsStateChangedListener
    public void onConstraintsStateChanged(@NotNull WorkSpec workSpec, @NotNull ConstraintsState state) {
        t.i(workSpec, "workSpec");
        t.i(state, "state");
        Logger.get().debug(ConstraintTrackingWorkerKt.TAG, "Constraints changed for " + workSpec);
        if (state instanceof ConstraintsState.ConstraintsNotMet) {
            synchronized (this.lock) {
                this.areConstraintsUnmet = true;
                v8.k0 k0Var = v8.k0.f35197a;
            }
        }
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.delegate;
        if (listenableWorker == null || listenableWorker.isStopped()) {
            return;
        }
        listenableWorker.stop(Build.VERSION.SDK_INT >= 31 ? getStopReason() : 0);
    }

    @Override // androidx.work.ListenableWorker
    @NotNull
    public m<ListenableWorker.Result> startWork() {
        getBackgroundExecutor().execute(new Runnable() { // from class: h.a
            @Override // java.lang.Runnable
            public final void run() {
                ConstraintTrackingWorker.startWork$lambda$0(this.f26376a);
            }
        });
        SettableFuture<ListenableWorker.Result> future = this.future;
        t.h(future, "future");
        return future;
    }
}

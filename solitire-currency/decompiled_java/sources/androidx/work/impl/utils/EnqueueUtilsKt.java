package androidx.work.impl.utils;

import android.os.Build;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.WorkRequest;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.impl.workers.ConstraintTrackingWorkerKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.a0;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EnqueueUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EnqueueUtilsKt {
    public static final void checkContentUriTriggerWorkerLimits(@NotNull WorkDatabase workDatabase, @NotNull Configuration configuration, @NotNull WorkContinuationImpl continuation) {
        int i10;
        t.i(workDatabase, "workDatabase");
        t.i(configuration, "configuration");
        t.i(continuation, "continuation");
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        List listQ = v.q(continuation);
        int i11 = 0;
        while (!listQ.isEmpty()) {
            WorkContinuationImpl workContinuationImpl = (WorkContinuationImpl) a0.O(listQ);
            List<? extends WorkRequest> work = workContinuationImpl.getWork();
            t.h(work, "current.work");
            List<? extends WorkRequest> list = work;
            if ((list instanceof Collection) && list.isEmpty()) {
                i10 = 0;
            } else {
                Iterator<T> it = list.iterator();
                i10 = 0;
                while (it.hasNext()) {
                    if (((WorkRequest) it.next()).getWorkSpec().constraints.hasContentUriTriggers() && (i10 = i10 + 1) < 0) {
                        v.t();
                    }
                }
            }
            i11 += i10;
            List<WorkContinuationImpl> parents = workContinuationImpl.getParents();
            if (parents != null) {
                listQ.addAll(parents);
            }
        }
        if (i11 == 0) {
            return;
        }
        int iCountNonFinishedContentUriTriggerWorkers = workDatabase.workSpecDao().countNonFinishedContentUriTriggerWorkers();
        int contentUriTriggerWorkersLimit = configuration.getContentUriTriggerWorkersLimit();
        if (iCountNonFinishedContentUriTriggerWorkers + i11 <= contentUriTriggerWorkersLimit) {
            return;
        }
        throw new IllegalArgumentException("Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: " + contentUriTriggerWorkersLimit + ";\nalready enqueued count: " + iCountNonFinishedContentUriTriggerWorkers + ";\ncurrent enqueue operation count: " + i11 + ".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed.");
    }

    @NotNull
    public static final WorkSpec tryDelegateConstrainedWorkSpec(@NotNull WorkSpec workSpec) throws Throwable {
        t.i(workSpec, "workSpec");
        Constraints constraints = workSpec.constraints;
        String str = workSpec.workerClassName;
        if (t.d(str, ConstraintTrackingWorker.class.getName())) {
            return workSpec;
        }
        if (!constraints.requiresBatteryNotLow() && !constraints.requiresStorageNotLow()) {
            return workSpec;
        }
        Data dataBuild = new Data.Builder().putAll(workSpec.input).putString(ConstraintTrackingWorkerKt.ARGUMENT_CLASS_NAME, str).build();
        t.h(dataBuild, "Builder().putAll(workSpe…ame)\n            .build()");
        String name = ConstraintTrackingWorker.class.getName();
        t.h(name, "name");
        return WorkSpec.copy$default(workSpec, null, null, name, null, dataBuild, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, 8388587, null);
    }

    private static final boolean usesScheduler(List<? extends Scheduler> list, String str) {
        try {
            Class<?> cls = Class.forName(str);
            List<? extends Scheduler> list2 = list;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                return false;
            }
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                if (cls.isAssignableFrom(((Scheduler) it.next()).getClass())) {
                    return true;
                }
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @NotNull
    public static final WorkSpec wrapInConstraintTrackingWorkerIfNeeded(@NotNull List<? extends Scheduler> schedulers, @NotNull WorkSpec workSpec) {
        t.i(schedulers, "schedulers");
        t.i(workSpec, "workSpec");
        return Build.VERSION.SDK_INT < 26 ? tryDelegateConstrainedWorkSpec(workSpec) : workSpec;
    }
}

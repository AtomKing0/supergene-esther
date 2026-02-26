package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IdGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IdGenerator {

    @NotNull
    private final WorkDatabase workDatabase;

    public IdGenerator(@NotNull WorkDatabase workDatabase) {
        t.i(workDatabase, "workDatabase");
        this.workDatabase = workDatabase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer nextAlarmManagerId$lambda$1(IdGenerator this$0) {
        t.i(this$0, "this$0");
        return Integer.valueOf(IdGeneratorKt.nextId(this$0.workDatabase, IdGeneratorKt.NEXT_ALARM_MANAGER_ID_KEY));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer nextJobSchedulerIdWithRange$lambda$0(IdGenerator this$0, int i10, int i11) {
        t.i(this$0, "this$0");
        int iNextId = IdGeneratorKt.nextId(this$0.workDatabase, IdGeneratorKt.NEXT_JOB_SCHEDULER_ID_KEY);
        boolean z10 = false;
        if (i10 <= iNextId && iNextId <= i11) {
            z10 = true;
        }
        if (z10) {
            i10 = iNextId;
        } else {
            IdGeneratorKt.updatePreference(this$0.workDatabase, IdGeneratorKt.NEXT_JOB_SCHEDULER_ID_KEY, i10 + 1);
        }
        return Integer.valueOf(i10);
    }

    public final int nextAlarmManagerId() {
        Object objRunInTransaction = this.workDatabase.runInTransaction((Callable<Object>) new Callable() { // from class: androidx.work.impl.utils.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return IdGenerator.nextAlarmManagerId$lambda$1(this.f1797a);
            }
        });
        t.h(objRunInTransaction, "workDatabase.runInTransa…ANAGER_ID_KEY)\n        })");
        return ((Number) objRunInTransaction).intValue();
    }

    public final int nextJobSchedulerIdWithRange(final int i10, final int i11) {
        Object objRunInTransaction = this.workDatabase.runInTransaction((Callable<Object>) new Callable() { // from class: androidx.work.impl.utils.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return IdGenerator.nextJobSchedulerIdWithRange$lambda$0(this.f1798a, i10, i11);
            }
        });
        t.h(objRunInTransaction, "workDatabase.runInTransa…            id\n        })");
        return ((Number) objRunInTransaction).intValue();
    }
}

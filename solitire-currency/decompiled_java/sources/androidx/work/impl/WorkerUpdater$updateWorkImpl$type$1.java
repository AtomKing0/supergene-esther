package androidx.work.impl;

import androidx.work.impl.model.WorkSpec;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WorkerUpdater.kt */
/* JADX INFO: loaded from: classes2.dex */
final class WorkerUpdater$updateWorkImpl$type$1 extends v implements l<WorkSpec, String> {
    public static final WorkerUpdater$updateWorkImpl$type$1 INSTANCE = new WorkerUpdater$updateWorkImpl$type$1();

    WorkerUpdater$updateWorkImpl$type$1() {
        super(1);
    }

    @Override // h9.l
    @NotNull
    public final String invoke(@NotNull WorkSpec spec) {
        t.i(spec, "spec");
        return spec.isPeriodic() ? "Periodic" : "OneTime";
    }
}

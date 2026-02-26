package androidx.work.impl.model;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WorkSpec.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WorkSpecKt {
    private static final long NOT_ENQUEUED = -1;

    @NotNull
    public static final WorkGenerationalId generationalId(@NotNull WorkSpec workSpec) {
        t.i(workSpec, "<this>");
        return new WorkGenerationalId(workSpec.id, workSpec.getGeneration());
    }
}

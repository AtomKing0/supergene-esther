package androidx.work.impl.model;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WorkSpec.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WorkGenerationalId {
    private final int generation;

    @NotNull
    private final String workSpecId;

    public WorkGenerationalId(@NotNull String workSpecId, int i10) {
        t.i(workSpecId, "workSpecId");
        this.workSpecId = workSpecId;
        this.generation = i10;
    }

    public static /* synthetic */ WorkGenerationalId copy$default(WorkGenerationalId workGenerationalId, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = workGenerationalId.workSpecId;
        }
        if ((i11 & 2) != 0) {
            i10 = workGenerationalId.generation;
        }
        return workGenerationalId.copy(str, i10);
    }

    @NotNull
    public final String component1() {
        return this.workSpecId;
    }

    public final int component2() {
        return this.generation;
    }

    @NotNull
    public final WorkGenerationalId copy(@NotNull String workSpecId, int i10) {
        t.i(workSpecId, "workSpecId");
        return new WorkGenerationalId(workSpecId, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkGenerationalId)) {
            return false;
        }
        WorkGenerationalId workGenerationalId = (WorkGenerationalId) obj;
        return t.d(this.workSpecId, workGenerationalId.workSpecId) && this.generation == workGenerationalId.generation;
    }

    public final int getGeneration() {
        return this.generation;
    }

    @NotNull
    public final String getWorkSpecId() {
        return this.workSpecId;
    }

    public int hashCode() {
        return (this.workSpecId.hashCode() * 31) + this.generation;
    }

    @NotNull
    public String toString() {
        return "WorkGenerationalId(workSpecId=" + this.workSpecId + ", generation=" + this.generation + ')';
    }
}

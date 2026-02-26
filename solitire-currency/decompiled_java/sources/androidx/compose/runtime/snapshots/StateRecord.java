package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Snapshot.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public abstract class StateRecord {
    public static final int $stable = 8;

    @Nullable
    private StateRecord next;
    private int snapshotId = SnapshotKt.currentSnapshot().getId();

    public abstract void assign(@NotNull StateRecord stateRecord);

    @NotNull
    public abstract StateRecord create();

    @Nullable
    public final StateRecord getNext$runtime_release() {
        return this.next;
    }

    public final int getSnapshotId$runtime_release() {
        return this.snapshotId;
    }

    public final void setNext$runtime_release(@Nullable StateRecord stateRecord) {
        this.next = stateRecord;
    }

    public final void setSnapshotId$runtime_release(int i10) {
        this.snapshotId = i10;
    }
}

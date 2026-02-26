package androidx.compose.runtime.snapshots;

import h9.l;
import java.util.HashSet;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.h;
import v8.k0;

/* JADX INFO: compiled from: Snapshot.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ReadonlySnapshot extends Snapshot {

    @Nullable
    private final l<Object, k0> readObserver;
    private int snapshots;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadonlySnapshot(int i10, @NotNull SnapshotIdSet invalid, @Nullable l<Object, k0> lVar) {
        super(i10, invalid, null);
        t.i(invalid, "invalid");
        this.readObserver = lVar;
        this.snapshots = 1;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed$runtime_release()) {
            return;
        }
        mo1273nestedDeactivated$runtime_release(this);
        super.dispose();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public HashSet<StateObject> getModified$runtime_release() {
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public l<Object, k0> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return true;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public l<Object, k0> getWriteObserver$runtime_release() {
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: nestedActivated$runtime_release */
    public void mo1272nestedActivated$runtime_release(@NotNull Snapshot snapshot) {
        t.i(snapshot, "snapshot");
        this.snapshots++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: nestedDeactivated$runtime_release */
    public void mo1273nestedDeactivated$runtime_release(@NotNull Snapshot snapshot) {
        t.i(snapshot, "snapshot");
        int i10 = this.snapshots - 1;
        this.snapshots = i10;
        if (i10 == 0) {
            closeAndReleasePinning$runtime_release();
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: recordModified$runtime_release */
    public void mo1274recordModified$runtime_release(@NotNull StateObject state) {
        t.i(state, "state");
        SnapshotKt.reportReadonlySnapshotWrite();
        throw new h();
    }

    public void setModified(@Nullable HashSet<StateObject> hashSet) {
        SnapshotStateMapKt.unsupported();
        throw new h();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public Snapshot takeNestedSnapshot(@Nullable l<Object, k0> lVar) {
        SnapshotKt.validateOpen(this);
        return new NestedReadonlySnapshot(getId(), getInvalid$runtime_release(), lVar, this);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public Snapshot getRoot() {
        return this;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
    }
}

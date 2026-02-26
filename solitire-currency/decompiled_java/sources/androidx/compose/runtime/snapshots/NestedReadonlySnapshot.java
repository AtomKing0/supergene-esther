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
public final class NestedReadonlySnapshot extends Snapshot {

    @NotNull
    private final Snapshot parent;

    @Nullable
    private final l<Object, k0> readObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedReadonlySnapshot(int i10, @NotNull SnapshotIdSet invalid, @Nullable l<Object, k0> lVar, @NotNull Snapshot parent) {
        super(i10, invalid, null);
        t.i(invalid, "invalid");
        t.i(parent, "parent");
        this.parent = parent;
        parent.mo1272nestedActivated$runtime_release(this);
        if (lVar != null) {
            l<Object, k0> readObserver$runtime_release = parent.getReadObserver$runtime_release();
            if (readObserver$runtime_release != null) {
                lVar = new NestedReadonlySnapshot$readObserver$1$1$1(lVar, readObserver$runtime_release);
            }
        } else {
            lVar = parent.getReadObserver$runtime_release();
        }
        this.readObserver = lVar;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed$runtime_release()) {
            return;
        }
        if (getId() != this.parent.getId()) {
            closeAndReleasePinning$runtime_release();
        }
        this.parent.mo1273nestedDeactivated$runtime_release(this);
        super.dispose();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public HashSet<StateObject> getModified$runtime_release() {
        return null;
    }

    @NotNull
    public final Snapshot getParent() {
        return this.parent;
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
    @NotNull
    public Snapshot getRoot() {
        return this.parent.getRoot();
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
    public /* bridge */ /* synthetic */ Snapshot takeNestedSnapshot(l lVar) {
        return takeNestedSnapshot((l<Object, k0>) lVar);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    /* JADX INFO: renamed from: nestedActivated$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void mo1272nestedActivated$runtime_release(@NotNull Snapshot snapshot) {
        t.i(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw new h();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    /* JADX INFO: renamed from: nestedDeactivated$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void mo1273nestedDeactivated$runtime_release(@NotNull Snapshot snapshot) {
        t.i(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw new h();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    /* JADX INFO: renamed from: recordModified$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void mo1274recordModified$runtime_release(@NotNull StateObject state) {
        t.i(state, "state");
        SnapshotKt.reportReadonlySnapshotWrite();
        throw new h();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public NestedReadonlySnapshot takeNestedSnapshot(@Nullable l<Object, k0> lVar) {
        return new NestedReadonlySnapshot(getId(), getInvalid$runtime_release(), lVar, this.parent);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
    }
}

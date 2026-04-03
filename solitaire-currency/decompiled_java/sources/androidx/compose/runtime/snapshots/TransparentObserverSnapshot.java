package androidx.compose.runtime.snapshots;

import h9.l;
import java.util.Set;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.h;
import v8.k0;

/* JADX INFO: compiled from: Snapshot.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TransparentObserverSnapshot extends Snapshot {
    private final boolean mergeParentObservers;
    private final boolean ownsPreviousSnapshot;

    @Nullable
    private final Snapshot previousSnapshot;

    @Nullable
    private final l<Object, k0> readObserver;

    @NotNull
    private final Snapshot root;

    @Nullable
    private final l<Object, k0> writeObserver;

    public TransparentObserverSnapshot(@Nullable Snapshot snapshot, @Nullable l<Object, k0> lVar, boolean z10, boolean z11) {
        l<Object, k0> readObserver$runtime_release;
        super(0, SnapshotIdSet.Companion.getEMPTY(), null);
        this.previousSnapshot = snapshot;
        this.mergeParentObservers = z10;
        this.ownsPreviousSnapshot = z11;
        this.readObserver = SnapshotKt.mergedReadObserver(lVar, (snapshot == null || (readObserver$runtime_release = snapshot.getReadObserver$runtime_release()) == null) ? ((GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get()).getReadObserver$runtime_release() : readObserver$runtime_release, z10);
        this.root = this;
    }

    private final Snapshot getCurrentSnapshot() {
        Snapshot snapshot = this.previousSnapshot;
        if (snapshot != null) {
            return snapshot;
        }
        Object obj = SnapshotKt.currentGlobalSnapshot.get();
        t.h(obj, "currentGlobalSnapshot.get()");
        return (Snapshot) obj;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        Snapshot snapshot;
        setDisposed$runtime_release(true);
        if (!this.ownsPreviousSnapshot || (snapshot = this.previousSnapshot) == null) {
            return;
        }
        snapshot.dispose();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public int getId() {
        return getCurrentSnapshot().getId();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public SnapshotIdSet getInvalid$runtime_release() {
        return getCurrentSnapshot().getInvalid$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public Set<StateObject> getModified$runtime_release() {
        return getCurrentSnapshot().getModified$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public l<Object, k0> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return getCurrentSnapshot().getReadOnly();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public Snapshot getRoot() {
        return this.root;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public l<Object, k0> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        return getCurrentSnapshot().hasPendingChanges();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        getCurrentSnapshot().notifyObjectsInitialized$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: recordModified$runtime_release */
    public void mo1274recordModified$runtime_release(@NotNull StateObject state) {
        t.i(state, "state");
        getCurrentSnapshot().mo1274recordModified$runtime_release(state);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setId$runtime_release(int i10) {
        SnapshotStateMapKt.unsupported();
        throw new h();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setInvalid$runtime_release(@NotNull SnapshotIdSet value) {
        t.i(value, "value");
        SnapshotStateMapKt.unsupported();
        throw new h();
    }

    public void setModified(@Nullable Set<StateObject> set) {
        SnapshotStateMapKt.unsupported();
        throw new h();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public Snapshot takeNestedSnapshot(@Nullable l<Object, k0> lVar) {
        l<Object, k0> lVarMergedReadObserver$default = SnapshotKt.mergedReadObserver$default(lVar, getReadObserver$runtime_release(), false, 4, null);
        return !this.mergeParentObservers ? SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(getCurrentSnapshot().takeNestedSnapshot(null), lVarMergedReadObserver$default, true) : getCurrentSnapshot().takeNestedSnapshot(lVarMergedReadObserver$default);
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
}

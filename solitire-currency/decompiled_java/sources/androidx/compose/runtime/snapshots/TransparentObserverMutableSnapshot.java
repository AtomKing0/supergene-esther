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
public final class TransparentObserverMutableSnapshot extends MutableSnapshot {
    private final boolean mergeParentObservers;
    private final boolean ownsPreviousSnapshot;

    @Nullable
    private final MutableSnapshot previousSnapshot;

    @Nullable
    private final l<Object, k0> specifiedReadObserver;

    @Nullable
    private final l<Object, k0> specifiedWriteObserver;

    public TransparentObserverMutableSnapshot(@Nullable MutableSnapshot mutableSnapshot, @Nullable l<Object, k0> lVar, @Nullable l<Object, k0> lVar2, boolean z10, boolean z11) {
        l<Object, k0> writeObserver$runtime_release;
        l<Object, k0> readObserver$runtime_release;
        super(0, SnapshotIdSet.Companion.getEMPTY(), SnapshotKt.mergedReadObserver(lVar, (mutableSnapshot == null || (readObserver$runtime_release = mutableSnapshot.getReadObserver$runtime_release()) == null) ? ((GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get()).getReadObserver$runtime_release() : readObserver$runtime_release, z10), SnapshotKt.mergedWriteObserver(lVar2, (mutableSnapshot == null || (writeObserver$runtime_release = mutableSnapshot.getWriteObserver$runtime_release()) == null) ? ((GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get()).getWriteObserver$runtime_release() : writeObserver$runtime_release));
        this.previousSnapshot = mutableSnapshot;
        this.specifiedReadObserver = lVar;
        this.specifiedWriteObserver = lVar2;
        this.mergeParentObservers = z10;
        this.ownsPreviousSnapshot = z11;
    }

    private final MutableSnapshot getCurrentSnapshot() {
        MutableSnapshot mutableSnapshot = this.previousSnapshot;
        if (mutableSnapshot != null) {
            return mutableSnapshot;
        }
        Object obj = SnapshotKt.currentGlobalSnapshot.get();
        t.h(obj, "currentGlobalSnapshot.get()");
        return (MutableSnapshot) obj;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    @NotNull
    public SnapshotApplyResult apply() {
        return getCurrentSnapshot().apply();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        MutableSnapshot mutableSnapshot;
        setDisposed$runtime_release(true);
        if (!this.ownsPreviousSnapshot || (mutableSnapshot = this.previousSnapshot) == null) {
            return;
        }
        mutableSnapshot.dispose();
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

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public Set<StateObject> getModified$runtime_release() {
        return getCurrentSnapshot().getModified$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return getCurrentSnapshot().getReadOnly();
    }

    @Nullable
    public final l<Object, k0> getSpecifiedReadObserver$runtime_release() {
        return this.specifiedReadObserver;
    }

    @Nullable
    public final l<Object, k0> getSpecifiedWriteObserver$runtime_release() {
        return this.specifiedWriteObserver;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        return getCurrentSnapshot().hasPendingChanges();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        getCurrentSnapshot().notifyObjectsInitialized$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
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

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public void setModified(@Nullable Set<StateObject> set) {
        SnapshotStateMapKt.unsupported();
        throw new h();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    @NotNull
    public MutableSnapshot takeNestedMutableSnapshot(@Nullable l<Object, k0> lVar, @Nullable l<Object, k0> lVar2) {
        l<Object, k0> lVarMergedReadObserver$default = SnapshotKt.mergedReadObserver$default(lVar, getReadObserver$runtime_release(), false, 4, null);
        l<Object, k0> lVarMergedWriteObserver = SnapshotKt.mergedWriteObserver(lVar2, getWriteObserver$runtime_release());
        return !this.mergeParentObservers ? new TransparentObserverMutableSnapshot(getCurrentSnapshot().takeNestedMutableSnapshot(null, lVarMergedWriteObserver), lVarMergedReadObserver$default, lVarMergedWriteObserver, false, true) : getCurrentSnapshot().takeNestedMutableSnapshot(lVarMergedReadObserver$default, lVarMergedWriteObserver);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public Snapshot takeNestedSnapshot(@Nullable l<Object, k0> lVar) {
        l<Object, k0> lVarMergedReadObserver$default = SnapshotKt.mergedReadObserver$default(lVar, getReadObserver$runtime_release(), false, 4, null);
        return !this.mergeParentObservers ? SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(getCurrentSnapshot().takeNestedSnapshot(null), lVarMergedReadObserver$default, true) : getCurrentSnapshot().takeNestedSnapshot(lVarMergedReadObserver$default);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    /* JADX INFO: renamed from: nestedActivated$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void mo1272nestedActivated$runtime_release(@NotNull Snapshot snapshot) {
        t.i(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw new h();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    /* JADX INFO: renamed from: nestedDeactivated$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void mo1273nestedDeactivated$runtime_release(@NotNull Snapshot snapshot) {
        t.i(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw new h();
    }
}

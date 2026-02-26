package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import h9.l;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Snapshot.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NestedMutableSnapshot extends MutableSnapshot {
    private boolean deactivated;

    @NotNull
    private final MutableSnapshot parent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedMutableSnapshot(int i10, @NotNull SnapshotIdSet invalid, @Nullable l<Object, k0> lVar, @Nullable l<Object, k0> lVar2, @NotNull MutableSnapshot parent) {
        super(i10, invalid, lVar, lVar2);
        t.i(invalid, "invalid");
        t.i(parent, "parent");
        this.parent = parent;
        parent.mo1272nestedActivated$runtime_release(this);
    }

    private final void deactivate() {
        if (this.deactivated) {
            return;
        }
        this.deactivated = true;
        this.parent.mo1273nestedDeactivated$runtime_release(this);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    @NotNull
    public SnapshotApplyResult apply() {
        Map<StateRecord, ? extends StateRecord> mapOptimisticMerges;
        if (this.parent.getApplied$runtime_release() || this.parent.getDisposed$runtime_release()) {
            return new SnapshotApplyResult.Failure(this);
        }
        Set<StateObject> modified$runtime_release = getModified$runtime_release();
        int id = getId();
        if (modified$runtime_release != null) {
            MutableSnapshot mutableSnapshot = this.parent;
            mapOptimisticMerges = SnapshotKt.optimisticMerges(mutableSnapshot, this, mutableSnapshot.getInvalid$runtime_release());
        } else {
            mapOptimisticMerges = null;
        }
        synchronized (SnapshotKt.getLock()) {
            SnapshotKt.validateOpen(this);
            if (modified$runtime_release == null || modified$runtime_release.size() == 0) {
                closeAndReleasePinning$runtime_release();
            } else {
                SnapshotApplyResult snapshotApplyResultInnerApplyLocked$runtime_release = innerApplyLocked$runtime_release(this.parent.getId(), mapOptimisticMerges, this.parent.getInvalid$runtime_release());
                if (!t.d(snapshotApplyResultInnerApplyLocked$runtime_release, SnapshotApplyResult.Success.INSTANCE)) {
                    return snapshotApplyResultInnerApplyLocked$runtime_release;
                }
                Set<StateObject> modified$runtime_release2 = this.parent.getModified$runtime_release();
                if (modified$runtime_release2 == null) {
                    modified$runtime_release2 = new HashSet<>();
                    this.parent.setModified(modified$runtime_release2);
                }
                modified$runtime_release2.addAll(modified$runtime_release);
            }
            if (this.parent.getId() < id) {
                this.parent.advance$runtime_release();
            }
            MutableSnapshot mutableSnapshot2 = this.parent;
            mutableSnapshot2.setInvalid$runtime_release(mutableSnapshot2.getInvalid$runtime_release().clear(id).andNot(getPreviousIds$runtime_release()));
            this.parent.recordPrevious$runtime_release(id);
            this.parent.recordPreviousPinnedSnapshot$runtime_release(takeoverPinnedSnapshot$runtime_release());
            this.parent.recordPreviousList$runtime_release(getPreviousIds$runtime_release());
            this.parent.recordPreviousPinnedSnapshots$runtime_release(getPreviousPinnedSnapshots$runtime_release());
            k0 k0Var = k0.f35197a;
            setApplied$runtime_release(true);
            deactivate();
            return SnapshotApplyResult.Success.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed$runtime_release()) {
            return;
        }
        super.dispose();
        deactivate();
    }

    @NotNull
    public final MutableSnapshot getParent() {
        return this.parent;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public Snapshot getRoot() {
        return this.parent.getRoot();
    }
}

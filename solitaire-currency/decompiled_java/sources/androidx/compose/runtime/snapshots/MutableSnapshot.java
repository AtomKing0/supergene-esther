package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import h9.l;
import h9.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.collections.o;
import kotlin.collections.v;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.h;
import v8.k0;
import v8.s;
import v8.y;

/* JADX INFO: compiled from: Snapshot.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public class MutableSnapshot extends Snapshot {
    public static final int $stable = 8;
    private boolean applied;

    @Nullable
    private Set<StateObject> modified;

    @NotNull
    private SnapshotIdSet previousIds;

    @NotNull
    private int[] previousPinnedSnapshots;

    @Nullable
    private final l<Object, k0> readObserver;
    private int snapshots;

    @Nullable
    private final l<Object, k0> writeObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableSnapshot(int i10, @NotNull SnapshotIdSet invalid, @Nullable l<Object, k0> lVar, @Nullable l<Object, k0> lVar2) {
        super(i10, invalid, null);
        t.i(invalid, "invalid");
        this.readObserver = lVar;
        this.writeObserver = lVar2;
        this.previousIds = SnapshotIdSet.Companion.getEMPTY();
        this.previousPinnedSnapshots = new int[0];
        this.snapshots = 1;
    }

    private final void abandon() {
        Set<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release != null) {
            validateNotApplied$runtime_release();
            setModified(null);
            int id = getId();
            Iterator<StateObject> it = modified$runtime_release.iterator();
            while (it.hasNext()) {
                for (StateRecord firstStateRecord = it.next().getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext$runtime_release()) {
                    if (firstStateRecord.getSnapshotId$runtime_release() == id || d0.b0(this.previousIds, Integer.valueOf(firstStateRecord.getSnapshotId$runtime_release()))) {
                        firstStateRecord.setSnapshotId$runtime_release(0);
                    }
                }
            }
        }
        closeAndReleasePinning$runtime_release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MutableSnapshot takeNestedMutableSnapshot$default(MutableSnapshot mutableSnapshot, l lVar, l lVar2, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedMutableSnapshot");
        }
        if ((i10 & 1) != 0) {
            lVar = null;
        }
        if ((i10 & 2) != 0) {
            lVar2 = null;
        }
        return mutableSnapshot.takeNestedMutableSnapshot(lVar, lVar2);
    }

    public final <T> T advance$runtime_release(@NotNull h9.a<? extends T> block) {
        t.i(block, "block");
        recordPrevious$runtime_release(getId());
        T tInvoke = block.invoke();
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            int id = getId();
            synchronized (SnapshotKt.getLock()) {
                try {
                    int i10 = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId = i10 + 1;
                    setId$runtime_release(i10);
                    SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                    k0 k0Var = k0.f35197a;
                    r.b(1);
                } catch (Throwable th) {
                    r.b(1);
                    r.a(1);
                    throw th;
                }
            }
            r.a(1);
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, getId()));
        }
        return tInvoke;
    }

    @NotNull
    public SnapshotApplyResult apply() {
        Map<StateRecord, ? extends StateRecord> mapOptimisticMerges;
        s sVarA;
        Set<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release != null) {
            Object obj = SnapshotKt.currentGlobalSnapshot.get();
            t.h(obj, "currentGlobalSnapshot.get()");
            mapOptimisticMerges = SnapshotKt.optimisticMerges((MutableSnapshot) obj, this, SnapshotKt.openSnapshots.clear(((GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get()).getId()));
        } else {
            mapOptimisticMerges = null;
        }
        synchronized (SnapshotKt.getLock()) {
            SnapshotKt.validateOpen(this);
            if (modified$runtime_release == null || modified$runtime_release.size() == 0) {
                closeLocked$runtime_release();
                GlobalSnapshot previousGlobalSnapshot = (GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get();
                t.h(previousGlobalSnapshot, "previousGlobalSnapshot");
                SnapshotKt.takeNewGlobalSnapshot(previousGlobalSnapshot, SnapshotKt.emptyLambda);
                Set<StateObject> modified$runtime_release2 = previousGlobalSnapshot.getModified$runtime_release();
                sVarA = (modified$runtime_release2 == null || !(modified$runtime_release2.isEmpty() ^ true)) ? y.a(v.l(), null) : y.a(d0.R0(SnapshotKt.applyObservers), modified$runtime_release2);
            } else {
                GlobalSnapshot previousGlobalSnapshot2 = (GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get();
                SnapshotApplyResult snapshotApplyResultInnerApplyLocked$runtime_release = innerApplyLocked$runtime_release(SnapshotKt.nextSnapshotId, mapOptimisticMerges, SnapshotKt.openSnapshots.clear(previousGlobalSnapshot2.getId()));
                if (!t.d(snapshotApplyResultInnerApplyLocked$runtime_release, SnapshotApplyResult.Success.INSTANCE)) {
                    return snapshotApplyResultInnerApplyLocked$runtime_release;
                }
                closeLocked$runtime_release();
                t.h(previousGlobalSnapshot2, "previousGlobalSnapshot");
                SnapshotKt.takeNewGlobalSnapshot(previousGlobalSnapshot2, SnapshotKt.emptyLambda);
                Set<StateObject> modified$runtime_release3 = previousGlobalSnapshot2.getModified$runtime_release();
                setModified(null);
                previousGlobalSnapshot2.setModified(null);
                sVarA = y.a(d0.R0(SnapshotKt.applyObservers), modified$runtime_release3);
            }
            List list = (List) sVarA.a();
            Set set = (Set) sVarA.b();
            this.applied = true;
            if (set != null && (!set.isEmpty())) {
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((p) list.get(i10)).mo4invoke(set, this);
                }
            }
            if (modified$runtime_release != null && (!modified$runtime_release.isEmpty())) {
                int size2 = list.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    ((p) list.get(i11)).mo4invoke(modified$runtime_release, this);
                }
            }
            synchronized (SnapshotKt.getLock()) {
                releasePinnedSnapshotsForCloseLocked$runtime_release();
                k0 k0Var = k0.f35197a;
            }
            return SnapshotApplyResult.Success.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void closeLocked$runtime_release() {
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(getId()).andNot(this.previousIds);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed$runtime_release()) {
            return;
        }
        super.dispose();
        mo1273nestedDeactivated$runtime_release(this);
    }

    public final boolean getApplied$runtime_release() {
        return this.applied;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public Set<StateObject> getModified$runtime_release() {
        return this.modified;
    }

    @NotNull
    public final SnapshotIdSet getPreviousIds$runtime_release() {
        return this.previousIds;
    }

    @NotNull
    public final int[] getPreviousPinnedSnapshots$runtime_release() {
        return this.previousPinnedSnapshots;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public l<Object, k0> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public l<Object, k0> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        Set<StateObject> modified$runtime_release = getModified$runtime_release();
        return modified$runtime_release != null && (modified$runtime_release.isEmpty() ^ true);
    }

    @NotNull
    public final SnapshotApplyResult innerApplyLocked$runtime_release(int i10, @Nullable Map<StateRecord, ? extends StateRecord> map, @NotNull SnapshotIdSet invalidSnapshots) {
        StateRecord stateRecord;
        StateRecord stateRecordMergeRecords;
        t.i(invalidSnapshots, "invalidSnapshots");
        SnapshotIdSet snapshotIdSetOr = getInvalid$runtime_release().set(getId()).or(this.previousIds);
        Set<StateObject> modified$runtime_release = getModified$runtime_release();
        t.f(modified$runtime_release);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (StateObject stateObject : modified$runtime_release) {
            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
            StateRecord stateRecord2 = SnapshotKt.readable(firstStateRecord, i10, invalidSnapshots);
            if (stateRecord2 != null && (stateRecord = SnapshotKt.readable(firstStateRecord, getId(), snapshotIdSetOr)) != null && !t.d(stateRecord2, stateRecord)) {
                StateRecord stateRecord3 = SnapshotKt.readable(firstStateRecord, getId(), getInvalid$runtime_release());
                if (stateRecord3 == null) {
                    SnapshotKt.readError();
                    throw new h();
                }
                if (map == null || (stateRecordMergeRecords = map.get(stateRecord2)) == null) {
                    stateRecordMergeRecords = stateObject.mergeRecords(stateRecord, stateRecord2, stateRecord3);
                }
                if (stateRecordMergeRecords == null) {
                    return new SnapshotApplyResult.Failure(this);
                }
                if (!t.d(stateRecordMergeRecords, stateRecord3)) {
                    if (t.d(stateRecordMergeRecords, stateRecord2)) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(y.a(stateObject, stateRecord2.create()));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(stateObject);
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(!t.d(stateRecordMergeRecords, stateRecord) ? y.a(stateObject, stateRecordMergeRecords) : y.a(stateObject, stateRecord.create()));
                    }
                }
            }
        }
        if (arrayList != null) {
            advance$runtime_release();
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                s sVar = (s) arrayList.get(i11);
                StateObject stateObject2 = (StateObject) sVar.a();
                StateRecord stateRecord4 = (StateRecord) sVar.b();
                stateRecord4.setSnapshotId$runtime_release(getId());
                synchronized (SnapshotKt.getLock()) {
                    stateRecord4.setNext$runtime_release(stateObject2.getFirstStateRecord());
                    stateObject2.prependStateRecord(stateRecord4);
                    k0 k0Var = k0.f35197a;
                }
            }
        }
        if (arrayList2 != null) {
            modified$runtime_release.removeAll(arrayList2);
        }
        return SnapshotApplyResult.Success.INSTANCE;
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
        int i10 = this.snapshots;
        if (!(i10 > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i11 = i10 - 1;
        this.snapshots = i11;
        if (i11 != 0 || this.applied) {
            return;
        }
        abandon();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        if (this.applied || getDisposed$runtime_release()) {
            return;
        }
        advance$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: recordModified$runtime_release */
    public void mo1274recordModified$runtime_release(@NotNull StateObject state) {
        t.i(state, "state");
        Set<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release == null) {
            modified$runtime_release = new HashSet<>();
            setModified(modified$runtime_release);
        }
        modified$runtime_release.add(state);
    }

    public final void recordPrevious$runtime_release(int i10) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.set(i10);
            k0 k0Var = k0.f35197a;
        }
    }

    public final void recordPreviousList$runtime_release(@NotNull SnapshotIdSet snapshots) {
        t.i(snapshots, "snapshots");
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.or(snapshots);
            k0 k0Var = k0.f35197a;
        }
    }

    public final void recordPreviousPinnedSnapshot$runtime_release(int i10) {
        if (i10 >= 0) {
            this.previousPinnedSnapshots = o.w(this.previousPinnedSnapshots, i10);
        }
    }

    public final void recordPreviousPinnedSnapshots$runtime_release(@NotNull int[] handles) {
        t.i(handles, "handles");
        if (handles.length == 0) {
            return;
        }
        int[] iArr = this.previousPinnedSnapshots;
        if (iArr.length == 0) {
            this.previousPinnedSnapshots = handles;
        } else {
            this.previousPinnedSnapshots = o.x(iArr, handles);
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePreviouslyPinnedSnapshotsLocked$runtime_release();
        super.releasePinnedSnapshotsForCloseLocked$runtime_release();
    }

    public final void releasePreviouslyPinnedSnapshotsLocked$runtime_release() {
        int length = this.previousPinnedSnapshots.length;
        for (int i10 = 0; i10 < length; i10++) {
            SnapshotKt.releasePinningLocked(this.previousPinnedSnapshots[i10]);
        }
    }

    public final void setApplied$runtime_release(boolean z10) {
        this.applied = z10;
    }

    public void setModified(@Nullable Set<StateObject> set) {
        this.modified = set;
    }

    public final void setPreviousIds$runtime_release(@NotNull SnapshotIdSet snapshotIdSet) {
        t.i(snapshotIdSet, "<set-?>");
        this.previousIds = snapshotIdSet;
    }

    public final void setPreviousPinnedSnapshots$runtime_release(@NotNull int[] iArr) {
        t.i(iArr, "<set-?>");
        this.previousPinnedSnapshots = iArr;
    }

    @NotNull
    public MutableSnapshot takeNestedMutableSnapshot(@Nullable l<Object, k0> lVar, @Nullable l<Object, k0> lVar2) {
        NestedMutableSnapshot nestedMutableSnapshot;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned$runtime_release();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            int i10 = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i10 + 1;
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(i10);
            SnapshotIdSet invalid$runtime_release = getInvalid$runtime_release();
            setInvalid$runtime_release(invalid$runtime_release.set(i10));
            nestedMutableSnapshot = new NestedMutableSnapshot(i10, SnapshotKt.addRange(invalid$runtime_release, getId() + 1, i10), SnapshotKt.mergedReadObserver$default(lVar, getReadObserver$runtime_release(), false, 4, null), SnapshotKt.mergedWriteObserver(lVar2, getWriteObserver$runtime_release()), this);
        }
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            int id = getId();
            synchronized (SnapshotKt.getLock()) {
                int i11 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i11 + 1;
                setId$runtime_release(i11);
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                k0 k0Var = k0.f35197a;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, getId()));
        }
        return nestedMutableSnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public Snapshot takeNestedSnapshot(@Nullable l<Object, k0> lVar) {
        NestedReadonlySnapshot nestedReadonlySnapshot;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned$runtime_release();
        int id = getId();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            int i10 = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i10 + 1;
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(i10);
            nestedReadonlySnapshot = new NestedReadonlySnapshot(i10, SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, i10), lVar, this);
        }
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            int id2 = getId();
            synchronized (SnapshotKt.getLock()) {
                int i11 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i11 + 1;
                setId$runtime_release(i11);
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                k0 k0Var = k0.f35197a;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id2 + 1, getId()));
        }
        return nestedReadonlySnapshot;
    }

    public final void validateNotApplied$runtime_release() {
        if (!(!this.applied)) {
            throw new IllegalStateException("Unsupported operation on a snapshot that has been applied".toString());
        }
    }

    public final void validateNotAppliedOrPinned$runtime_release() {
        boolean z10 = true;
        if (this.applied) {
            if (!(((Snapshot) this).pinningTrackingHandle >= 0)) {
                z10 = false;
            }
        }
        if (!z10) {
            throw new IllegalStateException("Unsupported operation on a disposed or applied snapshot".toString());
        }
    }

    public final void advance$runtime_release() {
        recordPrevious$runtime_release(getId());
        k0 k0Var = k0.f35197a;
        if (getApplied$runtime_release() || getDisposed$runtime_release()) {
            return;
        }
        int id = getId();
        synchronized (SnapshotKt.getLock()) {
            int i10 = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i10 + 1;
            setId$runtime_release(i10);
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
        }
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, getId()));
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public Snapshot getRoot() {
        return this;
    }
}

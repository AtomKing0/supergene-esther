package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.SnapshotThreadLocal;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import h9.l;
import h9.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.d0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.h;
import v8.k0;

/* JADX INFO: compiled from: Snapshot.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotKt {
    private static final int INVALID_SNAPSHOT = 0;

    @NotNull
    private static final List<p<Set<? extends Object>, Snapshot, k0>> applyObservers;

    @NotNull
    private static final AtomicReference<GlobalSnapshot> currentGlobalSnapshot;

    @NotNull
    private static final List<l<Object, k0>> globalWriteObservers;
    private static int nextSnapshotId;

    @NotNull
    private static SnapshotIdSet openSnapshots;

    @NotNull
    private static final SnapshotDoubleIndexHeap pinningTable;

    @NotNull
    private static final Snapshot snapshotInitializer;

    @NotNull
    private static final l<SnapshotIdSet, k0> emptyLambda = SnapshotKt$emptyLambda$1.INSTANCE;

    @NotNull
    private static final SnapshotThreadLocal<Snapshot> threadSnapshot = new SnapshotThreadLocal<>();

    @NotNull
    private static final Object lock = new Object();

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotKt$advanceGlobalSnapshot$2, reason: invalid class name */
    /* JADX INFO: compiled from: Snapshot.kt */
    static final class AnonymousClass2 extends v implements l<SnapshotIdSet, k0> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull SnapshotIdSet it) {
            t.i(it, "it");
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(SnapshotIdSet snapshotIdSet) {
            invoke2(snapshotIdSet);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotKt$mergedReadObserver$1, reason: invalid class name */
    /* JADX INFO: compiled from: Snapshot.kt */
    static final class AnonymousClass1 extends v implements l<Object, k0> {
        final /* synthetic */ l<Object, k0> $parentObserver;
        final /* synthetic */ l<Object, k0> $readObserver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(l<Object, k0> lVar, l<Object, k0> lVar2) {
            super(1);
            this.$readObserver = lVar;
            this.$parentObserver = lVar2;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Object obj) {
            invoke2(obj);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Object state) {
            t.i(state, "state");
            this.$readObserver.invoke(state);
            this.$parentObserver.invoke(state);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotKt$mergedWriteObserver$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Snapshot.kt */
    static final class C09921 extends v implements l<Object, k0> {
        final /* synthetic */ l<Object, k0> $parentObserver;
        final /* synthetic */ l<Object, k0> $writeObserver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09921(l<Object, k0> lVar, l<Object, k0> lVar2) {
            super(1);
            this.$writeObserver = lVar;
            this.$parentObserver = lVar2;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Object obj) {
            invoke2(obj);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Object state) {
            t.i(state, "state");
            this.$writeObserver.invoke(state);
            this.$parentObserver.invoke(state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotKt$takeNewSnapshot$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Snapshot.kt */
    static final class C09931<T> extends v implements l<SnapshotIdSet, T> {
        final /* synthetic */ l<SnapshotIdSet, T> $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09931(l<? super SnapshotIdSet, ? extends T> lVar) {
            super(1);
            this.$block = lVar;
        }

        /* JADX WARN: Incorrect return type in method signature: (Landroidx/compose/runtime/snapshots/SnapshotIdSet;)TT; */
        @Override // h9.l
        @NotNull
        public final Snapshot invoke(@NotNull SnapshotIdSet invalid) {
            t.i(invalid, "invalid");
            Snapshot snapshot = (Snapshot) this.$block.invoke(invalid);
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(snapshot.getId());
                k0 k0Var = k0.f35197a;
            }
            return snapshot;
        }
    }

    static {
        SnapshotIdSet.Companion companion = SnapshotIdSet.Companion;
        openSnapshots = companion.getEMPTY();
        nextSnapshotId = 1;
        pinningTable = new SnapshotDoubleIndexHeap();
        applyObservers = new ArrayList();
        globalWriteObservers = new ArrayList();
        int i10 = nextSnapshotId;
        nextSnapshotId = i10 + 1;
        GlobalSnapshot globalSnapshot = new GlobalSnapshot(i10, companion.getEMPTY());
        openSnapshots = openSnapshots.set(globalSnapshot.getId());
        AtomicReference<GlobalSnapshot> atomicReference = new AtomicReference<>(globalSnapshot);
        currentGlobalSnapshot = atomicReference;
        GlobalSnapshot globalSnapshot2 = atomicReference.get();
        t.h(globalSnapshot2, "currentGlobalSnapshot.get()");
        snapshotInitializer = globalSnapshot2;
    }

    @NotNull
    public static final SnapshotIdSet addRange(@NotNull SnapshotIdSet snapshotIdSet, int i10, int i11) {
        t.i(snapshotIdSet, "<this>");
        while (i10 < i11) {
            snapshotIdSet = snapshotIdSet.set(i10);
            i10++;
        }
        return snapshotIdSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T advanceGlobalSnapshot(l<? super SnapshotIdSet, ? extends T> lVar) {
        T t10;
        List listR0;
        GlobalSnapshot previousGlobalSnapshot = currentGlobalSnapshot.get();
        synchronized (getLock()) {
            t.h(previousGlobalSnapshot, "previousGlobalSnapshot");
            t10 = (T) takeNewGlobalSnapshot(previousGlobalSnapshot, lVar);
        }
        Set<StateObject> modified$runtime_release = previousGlobalSnapshot.getModified$runtime_release();
        if (modified$runtime_release != null) {
            synchronized (getLock()) {
                listR0 = d0.R0(applyObservers);
            }
            int size = listR0.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((p) listR0.get(i10)).mo4invoke(modified$runtime_release, previousGlobalSnapshot);
            }
        }
        return t10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Snapshot createTransparentSnapshotWithNoParentReadObserver(Snapshot snapshot, l<Object, k0> lVar, boolean z10) {
        boolean z11 = snapshot instanceof MutableSnapshot;
        if (z11 || snapshot == null) {
            return new TransparentObserverMutableSnapshot(z11 ? (MutableSnapshot) snapshot : null, lVar, null, false, z10);
        }
        return new TransparentObserverSnapshot(snapshot, lVar, false, z10);
    }

    static /* synthetic */ Snapshot createTransparentSnapshotWithNoParentReadObserver$default(Snapshot snapshot, l lVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return createTransparentSnapshotWithNoParentReadObserver(snapshot, lVar, z10);
    }

    @NotNull
    public static final <T extends StateRecord> T current(@NotNull T r10, @NotNull Snapshot snapshot) {
        t.i(r10, "r");
        t.i(snapshot, "snapshot");
        T t10 = (T) readable(r10, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (t10 != null) {
            return t10;
        }
        readError();
        throw new h();
    }

    @NotNull
    public static final Snapshot currentSnapshot() {
        Snapshot snapshot = threadSnapshot.get();
        if (snapshot != null) {
            return snapshot;
        }
        GlobalSnapshot globalSnapshot = currentGlobalSnapshot.get();
        t.h(globalSnapshot, "currentGlobalSnapshot.get()");
        return globalSnapshot;
    }

    @NotNull
    public static final Object getLock() {
        return lock;
    }

    @NotNull
    public static final Snapshot getSnapshotInitializer() {
        return snapshotInitializer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l<Object, k0> mergedReadObserver(l<Object, k0> lVar, l<Object, k0> lVar2, boolean z10) {
        if (!z10) {
            lVar2 = null;
        }
        return (lVar == null || lVar2 == null || t.d(lVar, lVar2)) ? lVar == null ? lVar2 : lVar : new AnonymousClass1(lVar, lVar2);
    }

    static /* synthetic */ l mergedReadObserver$default(l lVar, l lVar2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        return mergedReadObserver(lVar, lVar2, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l<Object, k0> mergedWriteObserver(l<Object, k0> lVar, l<Object, k0> lVar2) {
        return (lVar == null || lVar2 == null || t.d(lVar, lVar2)) ? lVar == null ? lVar2 : lVar : new C09921(lVar, lVar2);
    }

    @NotNull
    public static final <T extends StateRecord> T newOverwritableRecord(@NotNull T t10, @NotNull StateObject state) {
        t.i(t10, "<this>");
        t.i(state, "state");
        T t11 = (T) used(state);
        if (t11 != null) {
            t11.setSnapshotId$runtime_release(Integer.MAX_VALUE);
            return t11;
        }
        T t12 = (T) t10.create();
        t12.setSnapshotId$runtime_release(Integer.MAX_VALUE);
        t12.setNext$runtime_release(state.getFirstStateRecord());
        state.prependStateRecord(t12);
        return t12;
    }

    @NotNull
    public static final <T extends StateRecord> T newWritableRecord(@NotNull T t10, @NotNull StateObject state, @NotNull Snapshot snapshot) {
        t.i(t10, "<this>");
        t.i(state, "state");
        t.i(snapshot, "snapshot");
        T t11 = (T) newOverwritableRecord(t10, state);
        t11.assign(t10);
        t11.setSnapshotId$runtime_release(snapshot.getId());
        return t11;
    }

    public static final void notifyWrite(@NotNull Snapshot snapshot, @NotNull StateObject state) {
        t.i(snapshot, "snapshot");
        t.i(state, "state");
        l<Object, k0> writeObserver$runtime_release = snapshot.getWriteObserver$runtime_release();
        if (writeObserver$runtime_release != null) {
            writeObserver$runtime_release.invoke(state);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<StateRecord, StateRecord> optimisticMerges(MutableSnapshot mutableSnapshot, MutableSnapshot mutableSnapshot2, SnapshotIdSet snapshotIdSet) {
        StateRecord stateRecord;
        Set<StateObject> modified$runtime_release = mutableSnapshot2.getModified$runtime_release();
        int id = mutableSnapshot.getId();
        if (modified$runtime_release == null) {
            return null;
        }
        SnapshotIdSet snapshotIdSetOr = mutableSnapshot2.getInvalid$runtime_release().set(mutableSnapshot2.getId()).or(mutableSnapshot2.getPreviousIds$runtime_release());
        HashMap map = null;
        for (StateObject stateObject : modified$runtime_release) {
            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
            StateRecord stateRecord2 = readable(firstStateRecord, id, snapshotIdSet);
            if (stateRecord2 != null && (stateRecord = readable(firstStateRecord, id, snapshotIdSetOr)) != null && !t.d(stateRecord2, stateRecord)) {
                StateRecord stateRecord3 = readable(firstStateRecord, mutableSnapshot2.getId(), mutableSnapshot2.getInvalid$runtime_release());
                if (stateRecord3 == null) {
                    readError();
                    throw new h();
                }
                StateRecord stateRecordMergeRecords = stateObject.mergeRecords(stateRecord, stateRecord2, stateRecord3);
                if (stateRecordMergeRecords == null) {
                    return null;
                }
                if (map == null) {
                    map = new HashMap();
                }
                map.put(stateRecord2, stateRecordMergeRecords);
                map = map;
            }
        }
        return map;
    }

    public static final <T extends StateRecord, R> R overwritable(@NotNull T t10, @NotNull StateObject state, @NotNull T candidate, @NotNull l<? super T, ? extends R> block) {
        Snapshot current;
        R rInvoke;
        t.i(t10, "<this>");
        t.i(state, "state");
        t.i(candidate, "candidate");
        t.i(block, "block");
        getSnapshotInitializer();
        synchronized (getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                rInvoke = block.invoke(overwritableRecord(t10, state, current, candidate));
                r.b(1);
            } catch (Throwable th) {
                r.b(1);
                r.a(1);
                throw th;
            }
        }
        r.a(1);
        notifyWrite(current, state);
        return rInvoke;
    }

    @NotNull
    public static final <T extends StateRecord> T overwritableRecord(@NotNull T t10, @NotNull StateObject state, @NotNull Snapshot snapshot, @NotNull T candidate) {
        t.i(t10, "<this>");
        t.i(state, "state");
        t.i(snapshot, "snapshot");
        t.i(candidate, "candidate");
        if (snapshot.getReadOnly()) {
            snapshot.mo1274recordModified$runtime_release(state);
        }
        int id = snapshot.getId();
        if (candidate.getSnapshotId$runtime_release() == id) {
            return candidate;
        }
        T t11 = (T) newOverwritableRecord(t10, state);
        t11.setSnapshotId$runtime_release(id);
        snapshot.mo1274recordModified$runtime_release(state);
        return t11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void readError() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends StateRecord> T readable(T t10, int i10, SnapshotIdSet snapshotIdSet) {
        T t11 = null;
        while (t10 != null) {
            if (valid(t10, i10, snapshotIdSet) && (t11 == null || t11.getSnapshotId$runtime_release() < t10.getSnapshotId$runtime_release())) {
                t11 = t10;
            }
            t10 = (T) t10.getNext$runtime_release();
        }
        if (t11 != null) {
            return t11;
        }
        return null;
    }

    public static final void releasePinningLocked(int i10) {
        pinningTable.remove(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void reportReadonlySnapshotWrite() {
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot".toString());
    }

    public static final <T> T sync(@NotNull h9.a<? extends T> block) {
        T tInvoke;
        t.i(block, "block");
        synchronized (getLock()) {
            try {
                tInvoke = block.invoke();
                r.b(1);
            } catch (Throwable th) {
                r.b(1);
                r.a(1);
                throw th;
            }
        }
        r.a(1);
        return tInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T takeNewGlobalSnapshot(Snapshot snapshot, l<? super SnapshotIdSet, ? extends T> lVar) {
        T tInvoke = lVar.invoke(openSnapshots.clear(snapshot.getId()));
        synchronized (getLock()) {
            int i10 = nextSnapshotId;
            nextSnapshotId = i10 + 1;
            openSnapshots = openSnapshots.clear(snapshot.getId());
            currentGlobalSnapshot.set(new GlobalSnapshot(i10, openSnapshots));
            snapshot.dispose();
            openSnapshots = openSnapshots.set(i10);
            k0 k0Var = k0.f35197a;
        }
        return tInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends Snapshot> T takeNewSnapshot(l<? super SnapshotIdSet, ? extends T> lVar) {
        return (T) advanceGlobalSnapshot(new C09931(lVar));
    }

    public static final int trackPinning(int i10, @NotNull SnapshotIdSet invalid) {
        int iAdd;
        t.i(invalid, "invalid");
        int iLowest = invalid.lowest(i10);
        synchronized (getLock()) {
            iAdd = pinningTable.add(iLowest);
        }
        return iAdd;
    }

    private static final StateRecord used(StateObject stateObject) {
        int iLowestOrDefault = pinningTable.lowestOrDefault(nextSnapshotId) - 1;
        SnapshotIdSet empty = SnapshotIdSet.Companion.getEMPTY();
        StateRecord stateRecord = null;
        for (StateRecord firstStateRecord = stateObject.getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext$runtime_release()) {
            if (firstStateRecord.getSnapshotId$runtime_release() == 0) {
                return firstStateRecord;
            }
            if (valid(firstStateRecord, iLowestOrDefault, empty)) {
                if (stateRecord != null) {
                    return firstStateRecord.getSnapshotId$runtime_release() < stateRecord.getSnapshotId$runtime_release() ? firstStateRecord : stateRecord;
                }
                stateRecord = firstStateRecord;
            }
        }
        return null;
    }

    private static final boolean valid(int i10, int i11, SnapshotIdSet snapshotIdSet) {
        return (i11 == 0 || i11 > i10 || snapshotIdSet.get(i11)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateOpen(Snapshot snapshot) {
        if (!openSnapshots.get(snapshot.getId())) {
            throw new IllegalStateException("Snapshot is not open".toString());
        }
    }

    public static final <T extends StateRecord, R> R withCurrent(@NotNull T t10, @NotNull l<? super T, ? extends R> block) {
        t.i(t10, "<this>");
        t.i(block, "block");
        return block.invoke(current(t10, Snapshot.Companion.getCurrent()));
    }

    public static final <T extends StateRecord, R> R writable(@NotNull T t10, @NotNull StateObject state, @NotNull l<? super T, ? extends R> block) {
        Snapshot current;
        R rInvoke;
        t.i(t10, "<this>");
        t.i(state, "state");
        t.i(block, "block");
        getSnapshotInitializer();
        synchronized (getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                rInvoke = block.invoke(writableRecord(t10, state, current));
                r.b(1);
            } catch (Throwable th) {
                r.b(1);
                r.a(1);
                throw th;
            }
        }
        r.a(1);
        notifyWrite(current, state);
        return rInvoke;
    }

    @NotNull
    public static final <T extends StateRecord> T writableRecord(@NotNull T t10, @NotNull StateObject state, @NotNull Snapshot snapshot) {
        t.i(t10, "<this>");
        t.i(state, "state");
        t.i(snapshot, "snapshot");
        if (snapshot.getReadOnly()) {
            snapshot.mo1274recordModified$runtime_release(state);
        }
        T t11 = (T) readable(t10, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (t11 == null) {
            readError();
            throw new h();
        }
        if (t11.getSnapshotId$runtime_release() == snapshot.getId()) {
            return t11;
        }
        T t12 = (T) newWritableRecord(t11, state, snapshot);
        snapshot.mo1274recordModified$runtime_release(state);
        return t12;
    }

    private static final boolean valid(StateRecord stateRecord, int i10, SnapshotIdSet snapshotIdSet) {
        return valid(i10, stateRecord.getSnapshotId$runtime_release(), snapshotIdSet);
    }

    @NotNull
    public static final <T extends StateRecord> T readable(@NotNull T t10, @NotNull StateObject state) {
        t.i(t10, "<this>");
        t.i(state, "state");
        return (T) readable(t10, state, currentSnapshot());
    }

    @NotNull
    public static final <T extends StateRecord> T readable(@NotNull T t10, @NotNull StateObject state, @NotNull Snapshot snapshot) {
        t.i(t10, "<this>");
        t.i(state, "state");
        t.i(snapshot, "snapshot");
        l<Object, k0> readObserver$runtime_release = snapshot.getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(state);
        }
        T t11 = (T) readable(t10, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (t11 != null) {
            return t11;
        }
        readError();
        throw new h();
    }

    public static final <T extends StateRecord, R> R writable(@NotNull T t10, @NotNull StateObject state, @NotNull Snapshot snapshot, @NotNull l<? super T, ? extends R> block) {
        R rInvoke;
        t.i(t10, "<this>");
        t.i(state, "state");
        t.i(snapshot, "snapshot");
        t.i(block, "block");
        synchronized (getLock()) {
            try {
                rInvoke = block.invoke(writableRecord(t10, state, snapshot));
                r.b(1);
            } catch (Throwable th) {
                r.b(1);
                r.a(1);
                throw th;
            }
        }
        r.a(1);
        notifyWrite(snapshot, state);
        return rInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void advanceGlobalSnapshot() {
        advanceGlobalSnapshot(AnonymousClass2.INSTANCE);
    }

    public static /* synthetic */ void getLock$annotations() {
    }

    public static /* synthetic */ void getSnapshotInitializer$annotations() {
    }
}

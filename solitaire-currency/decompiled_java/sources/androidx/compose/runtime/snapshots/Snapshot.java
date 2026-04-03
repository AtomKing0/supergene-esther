package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ExperimentalComposeApi;
import androidx.compose.runtime.InternalComposeApi;
import androidx.compose.runtime.internal.StabilityInferred;
import h9.l;
import h9.p;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Snapshot.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public abstract class Snapshot {
    private boolean disposed;
    private int id;

    @NotNull
    private SnapshotIdSet invalid;
    private int pinningTrackingHandle;

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: Snapshot.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object observe$default(Companion companion, l lVar, l lVar2, h9.a aVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                lVar = null;
            }
            if ((i10 & 2) != 0) {
                lVar2 = null;
            }
            return companion.observe(lVar, lVar2, aVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MutableSnapshot takeMutableSnapshot$default(Companion companion, l lVar, l lVar2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                lVar = null;
            }
            if ((i10 & 2) != 0) {
                lVar2 = null;
            }
            return companion.takeMutableSnapshot(lVar, lVar2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Snapshot takeSnapshot$default(Companion companion, l lVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                lVar = null;
            }
            return companion.takeSnapshot(lVar);
        }

        @NotNull
        public final Snapshot createNonObservableSnapshot() {
            return SnapshotKt.createTransparentSnapshotWithNoParentReadObserver$default((Snapshot) SnapshotKt.threadSnapshot.get(), null, false, 6, null);
        }

        @NotNull
        public final Snapshot getCurrent() {
            return SnapshotKt.currentSnapshot();
        }

        public final <T> T global(@NotNull h9.a<? extends T> block) {
            t.i(block, "block");
            Snapshot snapshotRemoveCurrent = removeCurrent();
            T tInvoke = block.invoke();
            Snapshot.Companion.restoreCurrent(snapshotRemoveCurrent);
            return tInvoke;
        }

        public final void notifyObjectsInitialized() {
            SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime_release();
        }

        public final <T> T observe(@Nullable l<Object, k0> lVar, @Nullable l<Object, k0> lVar2, @NotNull h9.a<? extends T> block) {
            Snapshot transparentObserverMutableSnapshot;
            t.i(block, "block");
            if (lVar == null && lVar2 == null) {
                return block.invoke();
            }
            Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
            if (snapshot == null || (snapshot instanceof MutableSnapshot)) {
                transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null, lVar, lVar2, true, false);
            } else {
                if (lVar == null) {
                    return block.invoke();
                }
                transparentObserverMutableSnapshot = snapshot.takeNestedSnapshot(lVar);
            }
            try {
                Snapshot snapshotMakeCurrent = transparentObserverMutableSnapshot.makeCurrent();
                try {
                    return block.invoke();
                } finally {
                    transparentObserverMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                }
            } finally {
                transparentObserverMutableSnapshot.dispose();
            }
        }

        @InternalComposeApi
        public final int openSnapshotCount() {
            return d0.P0(SnapshotKt.openSnapshots).size();
        }

        @NotNull
        public final ObserverHandle registerApplyObserver(@NotNull final p<? super Set<? extends Object>, ? super Snapshot, k0> observer) {
            t.i(observer, "observer");
            SnapshotKt.advanceGlobalSnapshot(SnapshotKt.emptyLambda);
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.applyObservers.add(observer);
            }
            return new ObserverHandle() { // from class: androidx.compose.runtime.snapshots.Snapshot$Companion$registerApplyObserver$2
                @Override // androidx.compose.runtime.snapshots.ObserverHandle
                public final void dispose() {
                    p<Set<? extends Object>, Snapshot, k0> pVar = observer;
                    synchronized (SnapshotKt.getLock()) {
                        SnapshotKt.applyObservers.remove(pVar);
                        k0 k0Var = k0.f35197a;
                    }
                }
            };
        }

        @NotNull
        public final ObserverHandle registerGlobalWriteObserver(@NotNull final l<Object, k0> observer) {
            t.i(observer, "observer");
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.globalWriteObservers.add(observer);
            }
            SnapshotKt.advanceGlobalSnapshot();
            return new ObserverHandle() { // from class: androidx.compose.runtime.snapshots.Snapshot$Companion$registerGlobalWriteObserver$2
                @Override // androidx.compose.runtime.snapshots.ObserverHandle
                public final void dispose() {
                    l<Object, k0> lVar = observer;
                    synchronized (SnapshotKt.getLock()) {
                        SnapshotKt.globalWriteObservers.remove(lVar);
                    }
                    SnapshotKt.advanceGlobalSnapshot();
                }
            };
        }

        @Nullable
        public final Snapshot removeCurrent() {
            Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
            if (snapshot != null) {
                SnapshotKt.threadSnapshot.set(null);
            }
            return snapshot;
        }

        public final void restoreCurrent(@Nullable Snapshot snapshot) {
            if (snapshot != null) {
                SnapshotKt.threadSnapshot.set(snapshot);
            }
        }

        public final void sendApplyNotifications() {
            boolean z10;
            synchronized (SnapshotKt.getLock()) {
                z10 = false;
                if (((GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get()).getModified$runtime_release() != null) {
                    if (!r1.isEmpty()) {
                        z10 = true;
                    }
                }
            }
            if (z10) {
                SnapshotKt.advanceGlobalSnapshot();
            }
        }

        @NotNull
        public final MutableSnapshot takeMutableSnapshot(@Nullable l<Object, k0> lVar, @Nullable l<Object, k0> lVar2) {
            MutableSnapshot mutableSnapshotTakeNestedMutableSnapshot;
            Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
            MutableSnapshot mutableSnapshot = snapshotCurrentSnapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshotCurrentSnapshot : null;
            if (mutableSnapshot == null || (mutableSnapshotTakeNestedMutableSnapshot = mutableSnapshot.takeNestedMutableSnapshot(lVar, lVar2)) == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot".toString());
            }
            return mutableSnapshotTakeNestedMutableSnapshot;
        }

        @NotNull
        public final Snapshot takeSnapshot(@Nullable l<Object, k0> lVar) {
            return SnapshotKt.currentSnapshot().takeNestedSnapshot(lVar);
        }

        public final <R> R withMutableSnapshot(@NotNull h9.a<? extends R> block) {
            t.i(block, "block");
            MutableSnapshot mutableSnapshotTakeMutableSnapshot$default = takeMutableSnapshot$default(this, null, null, 3, null);
            try {
                Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot$default.makeCurrent();
                try {
                    R rInvoke = block.invoke();
                    r.b(1);
                    mutableSnapshotTakeMutableSnapshot$default.restoreCurrent(snapshotMakeCurrent);
                    r.a(1);
                    mutableSnapshotTakeMutableSnapshot$default.apply().check();
                    return rInvoke;
                } catch (Throwable th) {
                    r.b(1);
                    mutableSnapshotTakeMutableSnapshot$default.restoreCurrent(snapshotMakeCurrent);
                    r.a(1);
                    throw th;
                }
            } finally {
                r.b(1);
                mutableSnapshotTakeMutableSnapshot$default.dispose();
                r.a(1);
            }
        }

        public final <T> T withoutReadObservation(@NotNull h9.a<? extends T> block) {
            t.i(block, "block");
            Snapshot snapshotCreateNonObservableSnapshot = createNonObservableSnapshot();
            try {
                Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
                try {
                    return block.invoke();
                } finally {
                    r.b(1);
                    snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    r.a(1);
                }
            } finally {
                r.b(1);
                snapshotCreateNonObservableSnapshot.dispose();
                r.a(1);
            }
        }
    }

    public /* synthetic */ Snapshot(int i10, SnapshotIdSet snapshotIdSet, k kVar) {
        this(i10, snapshotIdSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Snapshot takeNestedSnapshot$default(Snapshot snapshot, l lVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedSnapshot");
        }
        if ((i10 & 1) != 0) {
            lVar = null;
        }
        return snapshot.takeNestedSnapshot(lVar);
    }

    public final void closeAndReleasePinning$runtime_release() {
        synchronized (SnapshotKt.getLock()) {
            closeLocked$runtime_release();
            releasePinnedSnapshotsForCloseLocked$runtime_release();
            k0 k0Var = k0.f35197a;
        }
    }

    public void closeLocked$runtime_release() {
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(getId());
    }

    public void dispose() {
        this.disposed = true;
        synchronized (SnapshotKt.getLock()) {
            releasePinnedSnapshotLocked$runtime_release();
            k0 k0Var = k0.f35197a;
        }
    }

    public final <T> T enter(@NotNull h9.a<? extends T> block) {
        t.i(block, "block");
        Snapshot snapshotMakeCurrent = makeCurrent();
        try {
            return block.invoke();
        } finally {
            r.b(1);
            restoreCurrent(snapshotMakeCurrent);
            r.a(1);
        }
    }

    public final boolean getDisposed$runtime_release() {
        return this.disposed;
    }

    public int getId() {
        return this.id;
    }

    @NotNull
    public SnapshotIdSet getInvalid$runtime_release() {
        return this.invalid;
    }

    @Nullable
    public abstract Set<StateObject> getModified$runtime_release();

    @Nullable
    public abstract l<Object, k0> getReadObserver$runtime_release();

    public abstract boolean getReadOnly();

    @NotNull
    public abstract Snapshot getRoot();

    @Nullable
    public abstract l<Object, k0> getWriteObserver$runtime_release();

    public abstract boolean hasPendingChanges();

    public final boolean isPinned$runtime_release() {
        return this.pinningTrackingHandle >= 0;
    }

    @Nullable
    public Snapshot makeCurrent() {
        Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
        SnapshotKt.threadSnapshot.set(this);
        return snapshot;
    }

    /* JADX INFO: renamed from: nestedActivated$runtime_release */
    public abstract void mo1272nestedActivated$runtime_release(@NotNull Snapshot snapshot);

    /* JADX INFO: renamed from: nestedDeactivated$runtime_release */
    public abstract void mo1273nestedDeactivated$runtime_release(@NotNull Snapshot snapshot);

    public abstract void notifyObjectsInitialized$runtime_release();

    /* JADX INFO: renamed from: recordModified$runtime_release */
    public abstract void mo1274recordModified$runtime_release(@NotNull StateObject stateObject);

    public final void releasePinnedSnapshotLocked$runtime_release() {
        int i10 = this.pinningTrackingHandle;
        if (i10 >= 0) {
            SnapshotKt.releasePinningLocked(i10);
            this.pinningTrackingHandle = -1;
        }
    }

    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePinnedSnapshotLocked$runtime_release();
    }

    public void restoreCurrent(@Nullable Snapshot snapshot) {
        SnapshotKt.threadSnapshot.set(snapshot);
    }

    public final void setDisposed$runtime_release(boolean z10) {
        this.disposed = z10;
    }

    public void setId$runtime_release(int i10) {
        this.id = i10;
    }

    public void setInvalid$runtime_release(@NotNull SnapshotIdSet snapshotIdSet) {
        t.i(snapshotIdSet, "<set-?>");
        this.invalid = snapshotIdSet;
    }

    @NotNull
    public abstract Snapshot takeNestedSnapshot(@Nullable l<Object, k0> lVar);

    public final int takeoverPinnedSnapshot$runtime_release() {
        int i10 = this.pinningTrackingHandle;
        this.pinningTrackingHandle = -1;
        return i10;
    }

    @ExperimentalComposeApi
    @Nullable
    public final Snapshot unsafeEnter() {
        return makeCurrent();
    }

    @ExperimentalComposeApi
    public final void unsafeLeave(@Nullable Snapshot snapshot) {
        if (SnapshotKt.threadSnapshot.get() == this) {
            restoreCurrent(snapshot);
            return;
        }
        throw new IllegalStateException(("Cannot leave snapshot; " + this + " is not the current snapshot").toString());
    }

    public final void validateNotDisposed$runtime_release() {
        if (!(!this.disposed)) {
            throw new IllegalArgumentException("Cannot use a disposed snapshot".toString());
        }
    }

    private Snapshot(int i10, SnapshotIdSet snapshotIdSet) {
        this.invalid = snapshotIdSet;
        this.id = i10;
        this.pinningTrackingHandle = i10 != 0 ? SnapshotKt.trackPinning(i10, getInvalid$runtime_release()) : -1;
    }
}

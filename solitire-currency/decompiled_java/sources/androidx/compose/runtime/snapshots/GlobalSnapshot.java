package androidx.compose.runtime.snapshots;

import h9.l;
import java.util.List;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.h;
import v8.k0;

/* JADX INFO: compiled from: Snapshot.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GlobalSnapshot extends MutableSnapshot {

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.GlobalSnapshot$takeNestedMutableSnapshot$1, reason: invalid class name */
    /* JADX INFO: compiled from: Snapshot.kt */
    static final class AnonymousClass1 extends v implements l<SnapshotIdSet, MutableSnapshot> {
        final /* synthetic */ l<Object, k0> $readObserver;
        final /* synthetic */ l<Object, k0> $writeObserver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(l<Object, k0> lVar, l<Object, k0> lVar2) {
            super(1);
            this.$readObserver = lVar;
            this.$writeObserver = lVar2;
        }

        @Override // h9.l
        @NotNull
        public final MutableSnapshot invoke(@NotNull SnapshotIdSet invalid) {
            int i10;
            t.i(invalid, "invalid");
            synchronized (SnapshotKt.getLock()) {
                i10 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i10 + 1;
            }
            return new MutableSnapshot(i10, invalid, this.$readObserver, this.$writeObserver);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.GlobalSnapshot$takeNestedSnapshot$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Snapshot.kt */
    static final class C09911 extends v implements l<SnapshotIdSet, ReadonlySnapshot> {
        final /* synthetic */ l<Object, k0> $readObserver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09911(l<Object, k0> lVar) {
            super(1);
            this.$readObserver = lVar;
        }

        @Override // h9.l
        @NotNull
        public final ReadonlySnapshot invoke(@NotNull SnapshotIdSet invalid) {
            int i10;
            t.i(invalid, "invalid");
            synchronized (SnapshotKt.getLock()) {
                i10 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i10 + 1;
            }
            return new ReadonlySnapshot(i10, invalid, this.$readObserver);
        }
    }

    public GlobalSnapshot(int i10, @NotNull SnapshotIdSet invalid) {
        l globalSnapshot$1$1$1;
        t.i(invalid, "invalid");
        synchronized (SnapshotKt.getLock()) {
            List listR0 = SnapshotKt.globalWriteObservers.isEmpty() ^ true ? d0.R0(SnapshotKt.globalWriteObservers) : null;
            if (listR0 != null) {
                globalSnapshot$1$1$1 = (l) d0.F0(listR0);
                if (globalSnapshot$1$1$1 == null) {
                    globalSnapshot$1$1$1 = new GlobalSnapshot$1$1$1(listR0);
                }
            } else {
                globalSnapshot$1$1$1 = null;
            }
        }
        super(i10, invalid, null, globalSnapshot$1$1$1);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    @NotNull
    public SnapshotApplyResult apply() {
        throw new IllegalStateException("Cannot apply the global snapshot directly. Call Snapshot.advanceGlobalSnapshot".toString());
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        synchronized (SnapshotKt.getLock()) {
            releasePinnedSnapshotLocked$runtime_release();
            k0 k0Var = k0.f35197a;
        }
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        SnapshotKt.advanceGlobalSnapshot();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    @NotNull
    public MutableSnapshot takeNestedMutableSnapshot(@Nullable l<Object, k0> lVar, @Nullable l<Object, k0> lVar2) {
        return (MutableSnapshot) SnapshotKt.takeNewSnapshot(new AnonymousClass1(lVar, lVar2));
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public Snapshot takeNestedSnapshot(@Nullable l<Object, k0> lVar) {
        return SnapshotKt.takeNewSnapshot(new C09911(lVar));
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

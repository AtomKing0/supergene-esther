package androidx.compose.runtime.snapshots;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Snapshot.kt */
/* JADX INFO: loaded from: classes.dex */
final class SnapshotKt$emptyLambda$1 extends v implements l<SnapshotIdSet, k0> {
    public static final SnapshotKt$emptyLambda$1 INSTANCE = new SnapshotKt$emptyLambda$1();

    SnapshotKt$emptyLambda$1() {
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

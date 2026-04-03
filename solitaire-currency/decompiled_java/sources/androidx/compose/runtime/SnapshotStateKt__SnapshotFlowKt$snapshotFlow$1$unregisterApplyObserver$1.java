package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.Snapshot;
import h9.p;
import java.util.Set;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: SnapshotFlow.kt */
/* JADX INFO: loaded from: classes.dex */
final class SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1 extends v implements p<Set<? extends Object>, Snapshot, k0> {
    final /* synthetic */ r9.d<Set<Object>> $appliedChanges;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1(r9.d<Set<Object>> dVar) {
        super(2);
        this.$appliedChanges = dVar;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Set<? extends Object> set, Snapshot snapshot) {
        invoke2(set, snapshot);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Set<? extends Object> changed, @NotNull Snapshot snapshot) {
        t.i(changed, "changed");
        t.i(snapshot, "<anonymous parameter 1>");
        this.$appliedChanges.f(changed);
    }
}

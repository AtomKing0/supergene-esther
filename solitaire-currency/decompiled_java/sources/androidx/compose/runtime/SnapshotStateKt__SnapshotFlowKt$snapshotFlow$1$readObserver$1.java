package androidx.compose.runtime;

import h9.l;
import java.util.Set;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: SnapshotFlow.kt */
/* JADX INFO: loaded from: classes.dex */
final class SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1 extends v implements l<Object, k0> {
    final /* synthetic */ Set<Object> $readSet;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1(Set<Object> set) {
        super(1);
        this.$readSet = set;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Object obj) {
        invoke2(obj);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Object it) {
        t.i(it, "it");
        this.$readSet.add(it);
    }
}

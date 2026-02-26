package androidx.compose.runtime.snapshots;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Snapshot.kt */
/* JADX INFO: loaded from: classes.dex */
final class NestedReadonlySnapshot$readObserver$1$1$1 extends v implements l<Object, k0> {
    final /* synthetic */ l<Object, k0> $it;
    final /* synthetic */ l<Object, k0> $readObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NestedReadonlySnapshot$readObserver$1$1$1(l<Object, k0> lVar, l<Object, k0> lVar2) {
        super(1);
        this.$readObserver = lVar;
        this.$it = lVar2;
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
        this.$it.invoke(state);
    }
}

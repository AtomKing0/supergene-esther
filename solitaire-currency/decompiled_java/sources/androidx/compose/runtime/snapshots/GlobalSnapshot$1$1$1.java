package androidx.compose.runtime.snapshots;

import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Snapshot.kt */
/* JADX INFO: loaded from: classes.dex */
final class GlobalSnapshot$1$1$1 extends v implements l<Object, k0> {
    final /* synthetic */ List<l<Object, k0>> $it;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlobalSnapshot$1$1$1(List<l<Object, k0>> list) {
        super(1);
        this.$it = list;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Object obj) {
        invoke2(obj);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Object state) {
        t.i(state, "state");
        List<l<Object, k0>> list = this.$it;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            list.get(i10).invoke(state);
        }
    }
}

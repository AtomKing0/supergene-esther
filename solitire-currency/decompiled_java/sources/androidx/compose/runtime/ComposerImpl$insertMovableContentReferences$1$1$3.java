package androidx.compose.runtime;

import h9.q;
import java.util.List;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposerImpl$insertMovableContentReferences$1$1$3 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
    final /* synthetic */ l0 $effectiveNodeIndex;
    final /* synthetic */ List<Object> $nodesToInsert;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposerImpl$insertMovableContentReferences$1$1$3(l0 l0Var, List<? extends Object> list) {
        super(3);
        this.$effectiveNodeIndex = l0Var;
        this.$nodesToInsert = list;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ k0 invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
        invoke2(applier, slotWriter, rememberManager);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
        t.i(applier, "applier");
        t.i(slotWriter, "<anonymous parameter 1>");
        t.i(rememberManager, "<anonymous parameter 2>");
        int i10 = this.$effectiveNodeIndex.f29831a;
        List<Object> list = this.$nodesToInsert;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            int i12 = i10 + i11;
            applier.insertBottomUp(i12, obj);
            applier.insertTopDown(i12, obj);
        }
    }
}

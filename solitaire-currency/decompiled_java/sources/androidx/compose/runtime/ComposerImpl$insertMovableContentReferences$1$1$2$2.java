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
final class ComposerImpl$insertMovableContentReferences$1$1$2$2 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
    final /* synthetic */ l0 $effectiveNodeIndex;
    final /* synthetic */ List<q<Applier<?>, SlotWriter, RememberManager, k0>> $offsetChanges;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposerImpl$insertMovableContentReferences$1$1$2$2(l0 l0Var, List<q<Applier<?>, SlotWriter, RememberManager, k0>> list) {
        super(3);
        this.$effectiveNodeIndex = l0Var;
        this.$offsetChanges = list;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ k0 invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
        invoke2(applier, slotWriter, rememberManager);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slots, @NotNull RememberManager rememberManager) {
        t.i(applier, "applier");
        t.i(slots, "slots");
        t.i(rememberManager, "rememberManager");
        int i10 = this.$effectiveNodeIndex.f29831a;
        if (i10 > 0) {
            applier = new OffsetApplier(applier, i10);
        }
        List<q<Applier<?>, SlotWriter, RememberManager, k0>> list = this.$offsetChanges;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            list.get(i11).invoke(applier, slots, rememberManager);
        }
    }
}

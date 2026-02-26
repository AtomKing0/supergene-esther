package androidx.compose.runtime;

import h9.q;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposerImpl$insertMovableContentReferences$1$1$1 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
    final /* synthetic */ Anchor $anchor;
    final /* synthetic */ l0 $effectiveNodeIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposerImpl$insertMovableContentReferences$1$1$1(l0 l0Var, Anchor anchor) {
        super(3);
        this.$effectiveNodeIndex = l0Var;
        this.$anchor = anchor;
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
        t.i(rememberManager, "<anonymous parameter 2>");
        this.$effectiveNodeIndex.f29831a = ComposerImpl.insertMovableContentReferences$positionToInsert(slots, this.$anchor, applier);
    }
}

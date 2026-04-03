package androidx.compose.runtime;

import h9.q;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.h;
import v8.k0;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposerImpl$insertMovableContentReferences$1$1$4 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
    final /* synthetic */ MovableContentStateReference $from;
    final /* synthetic */ MovableContentStateReference $to;
    final /* synthetic */ ComposerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposerImpl$insertMovableContentReferences$1$1$4(ComposerImpl composerImpl, MovableContentStateReference movableContentStateReference, MovableContentStateReference movableContentStateReference2) {
        super(3);
        this.this$0 = composerImpl;
        this.$from = movableContentStateReference;
        this.$to = movableContentStateReference2;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ k0 invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
        invoke2(applier, slotWriter, rememberManager);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slots, @NotNull RememberManager rememberManager) {
        t.i(applier, "<anonymous parameter 0>");
        t.i(slots, "slots");
        t.i(rememberManager, "<anonymous parameter 2>");
        MovableContentState movableContentStateMovableContentStateResolve$runtime_release = this.this$0.parentContext.movableContentStateResolve$runtime_release(this.$from);
        if (movableContentStateMovableContentStateResolve$runtime_release == null) {
            ComposerKt.composeRuntimeError("Could not resolve state for movable content");
            throw new h();
        }
        List<Anchor> listMoveIntoGroupFrom = slots.moveIntoGroupFrom(1, movableContentStateMovableContentStateResolve$runtime_release.getSlotTable$runtime_release(), 1);
        if (true ^ listMoveIntoGroupFrom.isEmpty()) {
            CompositionImpl compositionImpl = (CompositionImpl) this.$to.getComposition$runtime_release();
            int size = listMoveIntoGroupFrom.size();
            for (int i10 = 0; i10 < size; i10++) {
                Object objSlot = slots.slot(listMoveIntoGroupFrom.get(i10), 0);
                RecomposeScopeImpl recomposeScopeImpl = objSlot instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) objSlot : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.adoptedBy(compositionImpl);
                }
            }
        }
    }
}

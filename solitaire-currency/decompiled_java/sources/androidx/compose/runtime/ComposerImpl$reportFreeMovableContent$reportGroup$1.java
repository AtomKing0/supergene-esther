package androidx.compose.runtime;

import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposerImpl$reportFreeMovableContent$reportGroup$1 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
    final /* synthetic */ Anchor $anchor;
    final /* synthetic */ MovableContentStateReference $reference;
    final /* synthetic */ ComposerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposerImpl$reportFreeMovableContent$reportGroup$1(ComposerImpl composerImpl, MovableContentStateReference movableContentStateReference, Anchor anchor) {
        super(3);
        this.this$0 = composerImpl;
        this.$reference = movableContentStateReference;
        this.$anchor = anchor;
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
        SlotTable slotTable = new SlotTable();
        Anchor anchor = this.$anchor;
        SlotWriter slotWriterOpenWriter = slotTable.openWriter();
        try {
            slotWriterOpenWriter.beginInsert();
            slots.moveTo(anchor, 1, slotWriterOpenWriter);
            slotWriterOpenWriter.endInsert();
            k0 k0Var = k0.f35197a;
            slotWriterOpenWriter.close();
            this.this$0.parentContext.movableContentStateReleased$runtime_release(this.$reference, new MovableContentState(slotTable));
        } catch (Throwable th) {
            slotWriterOpenWriter.close();
            throw th;
        }
    }
}

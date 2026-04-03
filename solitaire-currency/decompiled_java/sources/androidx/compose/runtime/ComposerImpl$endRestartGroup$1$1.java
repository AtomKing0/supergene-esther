package androidx.compose.runtime;

import h9.l;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposerImpl$endRestartGroup$1$1 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
    final /* synthetic */ l<Composition, k0> $it;
    final /* synthetic */ ComposerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ComposerImpl$endRestartGroup$1$1(l<? super Composition, k0> lVar, ComposerImpl composerImpl) {
        super(3);
        this.$it = lVar;
        this.this$0 = composerImpl;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ k0 invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
        invoke2(applier, slotWriter, rememberManager);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
        t.i(applier, "<anonymous parameter 0>");
        t.i(slotWriter, "<anonymous parameter 1>");
        t.i(rememberManager, "<anonymous parameter 2>");
        this.$it.invoke(this.this$0.getComposition());
    }
}

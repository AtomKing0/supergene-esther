package androidx.compose.runtime;

import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposerImpl$apply$operation$1 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
    final /* synthetic */ p<T, V, k0> $block;
    final /* synthetic */ V $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ComposerImpl$apply$operation$1(p<? super T, ? super V, k0> pVar, V v10) {
        super(3);
        this.$block = pVar;
        this.$value = v10;
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
        this.$block.mo4invoke(applier.getCurrent(), this.$value);
    }
}

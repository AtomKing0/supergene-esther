package androidx.compose.runtime;

import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposerKt$endGroupInstance$1 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
    public static final ComposerKt$endGroupInstance$1 INSTANCE = new ComposerKt$endGroupInstance$1();

    ComposerKt$endGroupInstance$1() {
        super(3);
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
        slots.endGroup();
    }
}

package androidx.compose.runtime;

import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposerImpl$insertMovableContentReferences$1$2 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
    public static final ComposerImpl$insertMovableContentReferences$1$2 INSTANCE = new ComposerImpl$insertMovableContentReferences$1$2();

    ComposerImpl$insertMovableContentReferences$1$2() {
        super(3);
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
        ComposerImpl.insertMovableContentReferences$positionToParentOf(slots, applier, 0);
        slots.endGroup();
    }
}

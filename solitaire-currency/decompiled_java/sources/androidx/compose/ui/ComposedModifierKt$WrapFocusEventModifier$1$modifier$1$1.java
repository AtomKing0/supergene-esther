package androidx.compose.ui;

import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusState;
import h9.l;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ComposedModifier.kt */
/* JADX INFO: loaded from: classes.dex */
/* synthetic */ class ComposedModifierKt$WrapFocusEventModifier$1$modifier$1$1 extends q implements l<FocusState, k0> {
    ComposedModifierKt$WrapFocusEventModifier$1$modifier$1$1(Object obj) {
        super(1, obj, FocusEventModifier.class, "onFocusEvent", "onFocusEvent(Landroidx/compose/ui/focus/FocusState;)V", 0);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(FocusState focusState) {
        invoke2(focusState);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull FocusState p02) {
        t.i(p02, "p0");
        ((FocusEventModifier) this.receiver).onFocusEvent(p02);
    }
}

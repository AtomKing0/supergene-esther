package androidx.compose.foundation.text;

import androidx.compose.ui.layout.LayoutCoordinates;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
final class CoreTextFieldKt$CoreTextField$decorationBoxModifier$1 extends v implements l<LayoutCoordinates, k0> {
    final /* synthetic */ TextFieldState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$decorationBoxModifier$1(TextFieldState textFieldState) {
        super(1);
        this.$state = textFieldState;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(LayoutCoordinates layoutCoordinates) {
        invoke2(layoutCoordinates);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull LayoutCoordinates it) {
        t.i(it, "it");
        TextLayoutResultProxy layoutResult = this.$state.getLayoutResult();
        if (layoutResult == null) {
            return;
        }
        layoutResult.setDecorationBoxCoordinates(it);
    }
}

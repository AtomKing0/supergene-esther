package androidx.compose.foundation.text;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
final class CoreTextFieldKt$CoreTextField$drawModifier$1 extends v implements l<DrawScope, k0> {
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TextFieldValue $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$drawModifier$1(TextFieldState textFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        super(1);
        this.$state = textFieldState;
        this.$value = textFieldValue;
        this.$offsetMapping = offsetMapping;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(DrawScope drawScope) {
        invoke2(drawScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull DrawScope drawBehind) {
        t.i(drawBehind, "$this$drawBehind");
        TextLayoutResultProxy layoutResult = this.$state.getLayoutResult();
        if (layoutResult != null) {
            TextFieldValue textFieldValue = this.$value;
            OffsetMapping offsetMapping = this.$offsetMapping;
            TextFieldState textFieldState = this.$state;
            TextFieldDelegate.Companion.draw$foundation_release(drawBehind.getDrawContext().getCanvas(), textFieldValue, offsetMapping, layoutResult.getValue(), textFieldState.getSelectionPaint());
        }
    }
}

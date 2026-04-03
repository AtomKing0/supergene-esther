package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.TextFieldValue;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldState$onValueChange$1 extends v implements l<TextFieldValue, k0> {
    final /* synthetic */ TextFieldState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldState$onValueChange$1(TextFieldState textFieldState) {
        super(1);
        this.this$0 = textFieldState;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(TextFieldValue textFieldValue) {
        invoke2(textFieldValue);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull TextFieldValue it) {
        t.i(it, "it");
        if (!t.d(it.getText(), this.this$0.getTextDelegate().getText().getText())) {
            this.this$0.setHandleState(HandleState.None);
        }
        this.this$0.onValueChangeOriginal.invoke(it);
        this.this$0.getRecomposeScope().invalidate();
    }
}

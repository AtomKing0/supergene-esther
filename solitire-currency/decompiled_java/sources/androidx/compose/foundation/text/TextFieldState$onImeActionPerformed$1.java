package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.ImeAction;
import h9.l;
import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldState$onImeActionPerformed$1 extends v implements l<ImeAction, k0> {
    final /* synthetic */ TextFieldState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldState$onImeActionPerformed$1(TextFieldState textFieldState) {
        super(1);
        this.this$0 = textFieldState;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(ImeAction imeAction) {
        m740invokeKlQnJC8(imeAction.m3462unboximpl());
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke-KlQnJC8, reason: not valid java name */
    public final void m740invokeKlQnJC8(int i10) {
        this.this$0.keyboardActionRunner.m674runActionKlQnJC8(i10);
    }
}

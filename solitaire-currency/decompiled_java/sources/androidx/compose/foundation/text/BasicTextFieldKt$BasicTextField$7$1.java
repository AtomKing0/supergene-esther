package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.TextFieldValue;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: BasicTextField.kt */
/* JADX INFO: loaded from: classes.dex */
final class BasicTextFieldKt$BasicTextField$7$1 extends v implements l<TextFieldValue, k0> {
    final /* synthetic */ l<TextFieldValue, k0> $onValueChange;
    final /* synthetic */ TextFieldValue $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BasicTextFieldKt$BasicTextField$7$1(TextFieldValue textFieldValue, l<? super TextFieldValue, k0> lVar) {
        super(1);
        this.$value = textFieldValue;
        this.$onValueChange = lVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(TextFieldValue textFieldValue) {
        invoke2(textFieldValue);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull TextFieldValue it) {
        t.i(it, "it");
        if (t.d(this.$value, it)) {
            return;
        }
        this.$onValueChange.invoke(it);
    }
}

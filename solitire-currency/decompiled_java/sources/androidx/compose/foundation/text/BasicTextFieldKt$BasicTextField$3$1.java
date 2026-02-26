package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: BasicTextField.kt */
/* JADX INFO: loaded from: classes.dex */
final class BasicTextFieldKt$BasicTextField$3$1 extends v implements l<TextFieldValue, k0> {
    final /* synthetic */ MutableState<String> $lastTextValue$delegate;
    final /* synthetic */ l<String, k0> $onValueChange;
    final /* synthetic */ MutableState<TextFieldValue> $textFieldValueState$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BasicTextFieldKt$BasicTextField$3$1(l<? super String, k0> lVar, MutableState<TextFieldValue> mutableState, MutableState<String> mutableState2) {
        super(1);
        this.$onValueChange = lVar;
        this.$textFieldValueState$delegate = mutableState;
        this.$lastTextValue$delegate = mutableState2;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(TextFieldValue textFieldValue) {
        invoke2(textFieldValue);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull TextFieldValue newTextFieldValueState) {
        t.i(newTextFieldValueState, "newTextFieldValueState");
        this.$textFieldValueState$delegate.setValue(newTextFieldValueState);
        boolean z10 = !t.d(BasicTextFieldKt.m652BasicTextField$lambda5(this.$lastTextValue$delegate), newTextFieldValueState.getText());
        this.$lastTextValue$delegate.setValue(newTextFieldValueState.getText());
        if (z10) {
            this.$onValueChange.invoke(newTextFieldValueState.getText());
        }
    }
}

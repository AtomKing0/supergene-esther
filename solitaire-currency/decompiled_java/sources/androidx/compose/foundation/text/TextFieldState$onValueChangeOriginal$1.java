package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.TextFieldValue;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldState$onValueChangeOriginal$1 extends v implements l<TextFieldValue, k0> {
    public static final TextFieldState$onValueChangeOriginal$1 INSTANCE = new TextFieldState$onValueChangeOriginal$1();

    TextFieldState$onValueChangeOriginal$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull TextFieldValue it) {
        t.i(it, "it");
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(TextFieldValue textFieldValue) {
        invoke2(textFieldValue);
        return k0.f35197a;
    }
}

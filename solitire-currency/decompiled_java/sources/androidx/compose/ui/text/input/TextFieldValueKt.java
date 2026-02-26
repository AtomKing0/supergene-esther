package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextFieldValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldValueKt {
    @NotNull
    public static final AnnotatedString getSelectedText(@NotNull TextFieldValue textFieldValue) {
        t.i(textFieldValue, "<this>");
        return textFieldValue.getAnnotatedString().m3249subSequence5zctL8(textFieldValue.m3510getSelectiond9O1mEE());
    }

    @NotNull
    public static final AnnotatedString getTextAfterSelection(@NotNull TextFieldValue textFieldValue, int i10) {
        t.i(textFieldValue, "<this>");
        return textFieldValue.getAnnotatedString().subSequence(TextRange.m3332getMaximpl(textFieldValue.m3510getSelectiond9O1mEE()), Math.min(TextRange.m3332getMaximpl(textFieldValue.m3510getSelectiond9O1mEE()) + i10, textFieldValue.getText().length()));
    }

    @NotNull
    public static final AnnotatedString getTextBeforeSelection(@NotNull TextFieldValue textFieldValue, int i10) {
        t.i(textFieldValue, "<this>");
        return textFieldValue.getAnnotatedString().subSequence(Math.max(0, TextRange.m3333getMinimpl(textFieldValue.m3510getSelectiond9O1mEE()) - i10), TextRange.m3333getMinimpl(textFieldValue.m3510getSelectiond9O1mEE()));
    }
}

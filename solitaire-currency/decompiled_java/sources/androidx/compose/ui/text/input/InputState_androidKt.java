package androidx.compose.ui.text.input;

import android.view.inputmethod.ExtractedText;
import androidx.compose.ui.text.TextRange;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.r;

/* JADX INFO: compiled from: InputState.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InputState_androidKt {
    @NotNull
    public static final ExtractedText toExtractedText(@NotNull TextFieldValue textFieldValue) {
        t.i(textFieldValue, "<this>");
        ExtractedText extractedText = new ExtractedText();
        extractedText.text = textFieldValue.getText();
        extractedText.startOffset = 0;
        extractedText.partialEndOffset = textFieldValue.getText().length();
        extractedText.partialStartOffset = -1;
        extractedText.selectionStart = TextRange.m3333getMinimpl(textFieldValue.m3510getSelectiond9O1mEE());
        extractedText.selectionEnd = TextRange.m3332getMaximpl(textFieldValue.m3510getSelectiond9O1mEE());
        extractedText.flags = !r.O(textFieldValue.getText(), '\n', false, 2, null) ? 1 : 0;
        return extractedText;
    }
}

package androidx.compose.ui.text.input;

import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextInputServiceAndroid.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextInputServiceAndroid_androidKt {

    @NotNull
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    private static final boolean hasFlag(int i10, int i11) {
        return (i10 & i11) == i11;
    }

    public static final void update(@NotNull EditorInfo editorInfo, @NotNull ImeOptions imeOptions, @NotNull TextFieldValue textFieldValue) {
        t.i(editorInfo, "<this>");
        t.i(imeOptions, "imeOptions");
        t.i(textFieldValue, "textFieldValue");
        int iM3474getImeActioneUduSuo = imeOptions.m3474getImeActioneUduSuo();
        ImeAction.Companion companion = ImeAction.Companion;
        int i10 = 6;
        if (ImeAction.m3459equalsimpl0(iM3474getImeActioneUduSuo, companion.m3463getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i10 = 0;
            }
        } else if (ImeAction.m3459equalsimpl0(iM3474getImeActioneUduSuo, companion.m3467getNoneeUduSuo())) {
            i10 = 1;
        } else if (ImeAction.m3459equalsimpl0(iM3474getImeActioneUduSuo, companion.m3465getGoeUduSuo())) {
            i10 = 2;
        } else if (ImeAction.m3459equalsimpl0(iM3474getImeActioneUduSuo, companion.m3466getNexteUduSuo())) {
            i10 = 5;
        } else if (ImeAction.m3459equalsimpl0(iM3474getImeActioneUduSuo, companion.m3468getPreviouseUduSuo())) {
            i10 = 7;
        } else if (ImeAction.m3459equalsimpl0(iM3474getImeActioneUduSuo, companion.m3469getSearcheUduSuo())) {
            i10 = 3;
        } else if (ImeAction.m3459equalsimpl0(iM3474getImeActioneUduSuo, companion.m3470getSendeUduSuo())) {
            i10 = 4;
        } else if (!ImeAction.m3459equalsimpl0(iM3474getImeActioneUduSuo, companion.m3464getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        editorInfo.imeOptions = i10;
        int iM3475getKeyboardTypePjHm6EE = imeOptions.m3475getKeyboardTypePjHm6EE();
        KeyboardType.Companion companion2 = KeyboardType.Companion;
        if (KeyboardType.m3492equalsimpl0(iM3475getKeyboardTypePjHm6EE, companion2.m3503getTextPjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m3492equalsimpl0(iM3475getKeyboardTypePjHm6EE, companion2.m3496getAsciiPjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m3492equalsimpl0(iM3475getKeyboardTypePjHm6EE, companion2.m3499getNumberPjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m3492equalsimpl0(iM3475getKeyboardTypePjHm6EE, companion2.m3502getPhonePjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m3492equalsimpl0(iM3475getKeyboardTypePjHm6EE, companion2.m3504getUriPjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m3492equalsimpl0(iM3475getKeyboardTypePjHm6EE, companion2.m3498getEmailPjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m3492equalsimpl0(iM3475getKeyboardTypePjHm6EE, companion2.m3501getPasswordPjHm6EE())) {
            editorInfo.inputType = 129;
        } else if (KeyboardType.m3492equalsimpl0(iM3475getKeyboardTypePjHm6EE, companion2.m3500getNumberPasswordPjHm6EE())) {
            editorInfo.inputType = 18;
        } else {
            if (!KeyboardType.m3492equalsimpl0(iM3475getKeyboardTypePjHm6EE, companion2.m3497getDecimalPjHm6EE())) {
                throw new IllegalStateException("Invalid Keyboard Type".toString());
            }
            editorInfo.inputType = 8194;
        }
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m3459equalsimpl0(imeOptions.m3474getImeActioneUduSuo(), companion.m3463getDefaulteUduSuo())) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int iM3473getCapitalizationIUNYP9k = imeOptions.m3473getCapitalizationIUNYP9k();
            KeyboardCapitalization.Companion companion3 = KeyboardCapitalization.Companion;
            if (KeyboardCapitalization.m3481equalsimpl0(iM3473getCapitalizationIUNYP9k, companion3.m3485getCharactersIUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.m3481equalsimpl0(iM3473getCapitalizationIUNYP9k, companion3.m3488getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m3481equalsimpl0(iM3473getCapitalizationIUNYP9k, companion3.m3487getSentencesIUNYP9k())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.m3335getStartimpl(textFieldValue.m3510getSelectiond9O1mEE());
        editorInfo.initialSelEnd = TextRange.m3330getEndimpl(textFieldValue.m3510getSelectiond9O1mEE());
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textFieldValue.getText());
        editorInfo.imeOptions |= 33554432;
    }
}

package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.TextRange;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EditProcessor.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EditProcessor {

    @NotNull
    private TextFieldValue mBufferState = new TextFieldValue(AnnotatedStringKt.emptyAnnotatedString(), TextRange.Companion.m3340getZerod9O1mEE(), (TextRange) null, (k) null);

    @NotNull
    private EditingBuffer mBuffer = new EditingBuffer(this.mBufferState.getAnnotatedString(), this.mBufferState.m3510getSelectiond9O1mEE(), (k) null);

    @NotNull
    public final TextFieldValue apply(@NotNull List<? extends EditCommand> editCommands) {
        t.i(editCommands, "editCommands");
        int size = editCommands.size();
        for (int i10 = 0; i10 < size; i10++) {
            editCommands.get(i10).applyTo(this.mBuffer);
        }
        TextFieldValue textFieldValue = new TextFieldValue(this.mBuffer.toAnnotatedString$ui_text_release(), this.mBuffer.m3454getSelectiond9O1mEE$ui_text_release(), this.mBuffer.m3453getCompositionMzsxiRA$ui_text_release(), (k) null);
        this.mBufferState = textFieldValue;
        return textFieldValue;
    }

    @NotNull
    public final EditingBuffer getMBuffer$ui_text_release() {
        return this.mBuffer;
    }

    @NotNull
    public final TextFieldValue getMBufferState$ui_text_release() {
        return this.mBufferState;
    }

    public final void reset(@NotNull TextFieldValue value, @Nullable TextInputSession textInputSession) {
        t.i(value, "value");
        boolean z10 = true;
        boolean z11 = !t.d(value.m3509getCompositionMzsxiRA(), this.mBuffer.m3453getCompositionMzsxiRA$ui_text_release());
        boolean z12 = false;
        if (!t.d(this.mBufferState.getAnnotatedString(), value.getAnnotatedString())) {
            this.mBuffer = new EditingBuffer(value.getAnnotatedString(), value.m3510getSelectiond9O1mEE(), (k) null);
        } else if (TextRange.m3328equalsimpl0(this.mBufferState.m3510getSelectiond9O1mEE(), value.m3510getSelectiond9O1mEE())) {
            z10 = false;
        } else {
            this.mBuffer.setSelection$ui_text_release(TextRange.m3333getMinimpl(value.m3510getSelectiond9O1mEE()), TextRange.m3332getMaximpl(value.m3510getSelectiond9O1mEE()));
            z12 = true;
            z10 = false;
        }
        if (value.m3509getCompositionMzsxiRA() == null) {
            this.mBuffer.commitComposition$ui_text_release();
        } else if (!TextRange.m3329getCollapsedimpl(value.m3509getCompositionMzsxiRA().m3339unboximpl())) {
            this.mBuffer.setComposition$ui_text_release(TextRange.m3333getMinimpl(value.m3509getCompositionMzsxiRA().m3339unboximpl()), TextRange.m3332getMaximpl(value.m3509getCompositionMzsxiRA().m3339unboximpl()));
        }
        if (z10 || (!z12 && z11)) {
            this.mBuffer.commitComposition$ui_text_release();
            value = TextFieldValue.m3505copy3r_uNRQ$default(value, (AnnotatedString) null, 0L, (TextRange) null, 3, (Object) null);
        }
        TextFieldValue textFieldValue = this.mBufferState;
        this.mBufferState = value;
        if (textInputSession != null) {
            textInputSession.updateState(textFieldValue, value);
        }
    }

    @NotNull
    public final TextFieldValue toTextFieldValue() {
        return this.mBufferState;
    }
}

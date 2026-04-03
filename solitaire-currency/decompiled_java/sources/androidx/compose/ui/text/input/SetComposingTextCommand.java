package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EditCommand.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SetComposingTextCommand implements EditCommand {

    @NotNull
    private final AnnotatedString annotatedString;
    private final int newCursorPosition;

    public SetComposingTextCommand(@NotNull AnnotatedString annotatedString, int i10) {
        t.i(annotatedString, "annotatedString");
        this.annotatedString = annotatedString;
        this.newCursorPosition = i10;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(@NotNull EditingBuffer buffer) {
        t.i(buffer, "buffer");
        if (buffer.hasComposition$ui_text_release()) {
            int compositionStart$ui_text_release = buffer.getCompositionStart$ui_text_release();
            buffer.replace$ui_text_release(buffer.getCompositionStart$ui_text_release(), buffer.getCompositionEnd$ui_text_release(), getText());
            if (getText().length() > 0) {
                buffer.setComposition$ui_text_release(compositionStart$ui_text_release, getText().length() + compositionStart$ui_text_release);
            }
        } else {
            int selectionStart$ui_text_release = buffer.getSelectionStart$ui_text_release();
            buffer.replace$ui_text_release(buffer.getSelectionStart$ui_text_release(), buffer.getSelectionEnd$ui_text_release(), getText());
            if (getText().length() > 0) {
                buffer.setComposition$ui_text_release(selectionStart$ui_text_release, getText().length() + selectionStart$ui_text_release);
            }
        }
        int cursor$ui_text_release = buffer.getCursor$ui_text_release();
        int i10 = this.newCursorPosition;
        buffer.setCursor$ui_text_release(o.n(i10 > 0 ? (cursor$ui_text_release + i10) - 1 : (cursor$ui_text_release + i10) - getText().length(), 0, buffer.getLength$ui_text_release()));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SetComposingTextCommand)) {
            return false;
        }
        SetComposingTextCommand setComposingTextCommand = (SetComposingTextCommand) obj;
        return t.d(getText(), setComposingTextCommand.getText()) && this.newCursorPosition == setComposingTextCommand.newCursorPosition;
    }

    @NotNull
    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public final int getNewCursorPosition() {
        return this.newCursorPosition;
    }

    @NotNull
    public final String getText() {
        return this.annotatedString.getText();
    }

    public int hashCode() {
        return (getText().hashCode() * 31) + this.newCursorPosition;
    }

    @NotNull
    public String toString() {
        return "SetComposingTextCommand(text='" + getText() + "', newCursorPosition=" + this.newCursorPosition + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SetComposingTextCommand(@NotNull String text, int i10) {
        this(new AnnotatedString(text, null, null, 6, null), i10);
        t.i(text, "text");
    }
}

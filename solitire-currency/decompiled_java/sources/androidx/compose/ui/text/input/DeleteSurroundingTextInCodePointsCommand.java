package androidx.compose.ui.text.input;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EditCommand.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DeleteSurroundingTextInCodePointsCommand implements EditCommand {
    private final int lengthAfterCursor;
    private final int lengthBeforeCursor;

    public DeleteSurroundingTextInCodePointsCommand(int i10, int i11) {
        this.lengthBeforeCursor = i10;
        this.lengthAfterCursor = i11;
        if (i10 >= 0 && i11 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i10 + " and " + i11 + " respectively.").toString());
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(@NotNull EditingBuffer buffer) {
        t.i(buffer, "buffer");
        int i10 = this.lengthBeforeCursor;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11++;
            if (buffer.getSelectionStart$ui_text_release() > i11 && EditCommandKt.isSurrogatePair(buffer.get$ui_text_release((buffer.getSelectionStart$ui_text_release() - i11) - 1), buffer.get$ui_text_release(buffer.getSelectionStart$ui_text_release() - i11))) {
                i11++;
            }
            if (i11 == buffer.getSelectionStart$ui_text_release()) {
                break;
            }
        }
        int i13 = this.lengthAfterCursor;
        int i14 = 0;
        for (int i15 = 0; i15 < i13; i15++) {
            i14++;
            if (buffer.getSelectionEnd$ui_text_release() + i14 < buffer.getLength$ui_text_release() && EditCommandKt.isSurrogatePair(buffer.get$ui_text_release((buffer.getSelectionEnd$ui_text_release() + i14) - 1), buffer.get$ui_text_release(buffer.getSelectionEnd$ui_text_release() + i14))) {
                i14++;
            }
            if (buffer.getSelectionEnd$ui_text_release() + i14 == buffer.getLength$ui_text_release()) {
                break;
            }
        }
        buffer.delete$ui_text_release(buffer.getSelectionEnd$ui_text_release(), buffer.getSelectionEnd$ui_text_release() + i14);
        buffer.delete$ui_text_release(buffer.getSelectionStart$ui_text_release() - i11, buffer.getSelectionStart$ui_text_release());
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteSurroundingTextInCodePointsCommand)) {
            return false;
        }
        DeleteSurroundingTextInCodePointsCommand deleteSurroundingTextInCodePointsCommand = (DeleteSurroundingTextInCodePointsCommand) obj;
        return this.lengthBeforeCursor == deleteSurroundingTextInCodePointsCommand.lengthBeforeCursor && this.lengthAfterCursor == deleteSurroundingTextInCodePointsCommand.lengthAfterCursor;
    }

    public final int getLengthAfterCursor() {
        return this.lengthAfterCursor;
    }

    public final int getLengthBeforeCursor() {
        return this.lengthBeforeCursor;
    }

    public int hashCode() {
        return (this.lengthBeforeCursor * 31) + this.lengthAfterCursor;
    }

    @NotNull
    public String toString() {
        return "DeleteSurroundingTextInCodePointsCommand(lengthBeforeCursor=" + this.lengthBeforeCursor + ", lengthAfterCursor=" + this.lengthAfterCursor + ')';
    }
}

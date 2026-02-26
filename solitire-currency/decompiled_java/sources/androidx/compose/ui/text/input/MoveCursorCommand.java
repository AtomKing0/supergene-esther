package androidx.compose.ui.text.input;

import androidx.compose.ui.text.JvmCharHelpers_androidKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EditCommand.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MoveCursorCommand implements EditCommand {
    private final int amount;

    public MoveCursorCommand(int i10) {
        this.amount = i10;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(@NotNull EditingBuffer buffer) {
        t.i(buffer, "buffer");
        if (buffer.getCursor$ui_text_release() == -1) {
            buffer.setCursor$ui_text_release(buffer.getSelectionStart$ui_text_release());
        }
        int selectionStart$ui_text_release = buffer.getSelectionStart$ui_text_release();
        String string = buffer.toString();
        int i10 = this.amount;
        int i11 = 0;
        if (i10 <= 0) {
            int i12 = -i10;
            while (i11 < i12) {
                int iFindPrecedingBreak = JvmCharHelpers_androidKt.findPrecedingBreak(string, selectionStart$ui_text_release);
                if (iFindPrecedingBreak == -1) {
                    break;
                }
                i11++;
                selectionStart$ui_text_release = iFindPrecedingBreak;
            }
        } else {
            while (i11 < i10) {
                int iFindFollowingBreak = JvmCharHelpers_androidKt.findFollowingBreak(string, selectionStart$ui_text_release);
                if (iFindFollowingBreak == -1) {
                    break;
                }
                i11++;
                selectionStart$ui_text_release = iFindFollowingBreak;
            }
        }
        buffer.setCursor$ui_text_release(selectionStart$ui_text_release);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MoveCursorCommand) && this.amount == ((MoveCursorCommand) obj).amount;
    }

    public final int getAmount() {
        return this.amount;
    }

    public int hashCode() {
        return this.amount;
    }

    @NotNull
    public String toString() {
        return "MoveCursorCommand(amount=" + this.amount + ')';
    }
}

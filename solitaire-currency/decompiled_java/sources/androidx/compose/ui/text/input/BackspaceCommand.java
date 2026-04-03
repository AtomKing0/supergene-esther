package androidx.compose.ui.text.input;

import androidx.compose.ui.text.JvmCharHelpers_androidKt;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EditCommand.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BackspaceCommand implements EditCommand {
    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(@NotNull EditingBuffer buffer) {
        t.i(buffer, "buffer");
        if (buffer.hasComposition$ui_text_release()) {
            buffer.delete$ui_text_release(buffer.getCompositionStart$ui_text_release(), buffer.getCompositionEnd$ui_text_release());
            return;
        }
        if (buffer.getCursor$ui_text_release() != -1) {
            if (buffer.getCursor$ui_text_release() == 0) {
                return;
            }
            buffer.delete$ui_text_release(JvmCharHelpers_androidKt.findPrecedingBreak(buffer.toString(), buffer.getCursor$ui_text_release()), buffer.getCursor$ui_text_release());
        } else {
            int selectionStart$ui_text_release = buffer.getSelectionStart$ui_text_release();
            int selectionEnd$ui_text_release = buffer.getSelectionEnd$ui_text_release();
            buffer.setCursor$ui_text_release(buffer.getSelectionStart$ui_text_release());
            buffer.delete$ui_text_release(selectionStart$ui_text_release, selectionEnd$ui_text_release);
        }
    }

    public boolean equals(@Nullable Object obj) {
        return obj instanceof BackspaceCommand;
    }

    public int hashCode() {
        return o0.b(BackspaceCommand.class).hashCode();
    }

    @NotNull
    public String toString() {
        return "BackspaceCommand()";
    }
}

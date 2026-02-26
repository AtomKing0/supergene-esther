package androidx.compose.ui.text.input;

import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EditCommand.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FinishComposingTextCommand implements EditCommand {
    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(@NotNull EditingBuffer buffer) {
        t.i(buffer, "buffer");
        buffer.commitComposition$ui_text_release();
    }

    public boolean equals(@Nullable Object obj) {
        return obj instanceof FinishComposingTextCommand;
    }

    public int hashCode() {
        return o0.b(FinishComposingTextCommand.class).hashCode();
    }

    @NotNull
    public String toString() {
        return "FinishComposingTextCommand()";
    }
}

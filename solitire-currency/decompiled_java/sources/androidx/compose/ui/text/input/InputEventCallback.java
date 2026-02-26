package androidx.compose.ui.text.input;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InputEventCallback.kt */
/* JADX INFO: loaded from: classes.dex */
public interface InputEventCallback {
    void onEditCommands(@NotNull List<? extends EditCommand> list);

    /* JADX INFO: renamed from: onImeAction-KlQnJC8, reason: not valid java name */
    void m3476onImeActionKlQnJC8(int i10);
}

package androidx.compose.ui.text.input;

import android.view.KeyEvent;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InputEventCallback2.android.kt */
/* JADX INFO: loaded from: classes.dex */
public interface InputEventCallback2 {
    void onEditCommands(@NotNull List<? extends EditCommand> list);

    /* JADX INFO: renamed from: onImeAction-KlQnJC8, reason: not valid java name */
    void mo3477onImeActionKlQnJC8(int i10);

    void onKeyEvent(@NotNull KeyEvent keyEvent);
}

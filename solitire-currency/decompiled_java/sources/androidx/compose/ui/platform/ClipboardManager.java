package androidx.compose.ui.platform;

import androidx.compose.ui.text.AnnotatedString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ClipboardManager.kt */
/* JADX INFO: loaded from: classes.dex */
public interface ClipboardManager {
    @Nullable
    AnnotatedString getText();

    void setText(@NotNull AnnotatedString annotatedString);
}

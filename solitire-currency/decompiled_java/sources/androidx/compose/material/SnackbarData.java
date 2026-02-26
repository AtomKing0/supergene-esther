package androidx.compose.material;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SnackbarHost.kt */
/* JADX INFO: loaded from: classes.dex */
public interface SnackbarData {
    void dismiss();

    @Nullable
    String getActionLabel();

    @NotNull
    SnackbarDuration getDuration();

    @NotNull
    String getMessage();

    void performAction();
}

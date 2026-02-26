package androidx.core.app;

import androidx.core.util.Consumer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: OnMultiWindowModeChangedProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public interface OnMultiWindowModeChangedProvider {
    void addOnMultiWindowModeChangedListener(@NotNull Consumer<MultiWindowModeChangedInfo> consumer);

    void removeOnMultiWindowModeChangedListener(@NotNull Consumer<MultiWindowModeChangedInfo> consumer);
}

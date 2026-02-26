package androidx.compose.runtime.saveable;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Saver.kt */
/* JADX INFO: loaded from: classes.dex */
public interface Saver<Original, Saveable> {
    @Nullable
    Original restore(@NotNull Saveable saveable);

    @Nullable
    Saveable save(@NotNull SaverScope saverScope, Original original);
}

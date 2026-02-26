package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import h9.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SaveableStateHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public interface SaveableStateHolder {
    @Composable
    void SaveableStateProvider(@NotNull Object obj, @NotNull p<? super Composer, ? super Integer, k0> pVar, @Nullable Composer composer, int i10);

    void removeState(@NotNull Object obj);
}

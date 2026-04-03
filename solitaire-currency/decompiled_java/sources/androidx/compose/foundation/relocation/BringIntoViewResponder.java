package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.geometry.Rect;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: BringIntoViewResponder.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
public interface BringIntoViewResponder {
    @ExperimentalFoundationApi
    @Nullable
    Object bringChildIntoView(@NotNull Rect rect, @NotNull d<? super k0> dVar);

    @ExperimentalFoundationApi
    @NotNull
    Rect calculateRectForParent(@NotNull Rect rect);
}

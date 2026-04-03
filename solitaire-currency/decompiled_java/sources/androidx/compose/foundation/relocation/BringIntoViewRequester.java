package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.geometry.Rect;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: BringIntoViewRequester.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
public interface BringIntoViewRequester {
    @Nullable
    Object bringIntoView(@Nullable Rect rect, @NotNull d<? super k0> dVar);
}

package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: BringIntoView.kt */
/* JADX INFO: loaded from: classes.dex */
public interface BringIntoViewParent {
    @Nullable
    Object bringChildIntoView(@NotNull Rect rect, @NotNull LayoutCoordinates layoutCoordinates, @NotNull d<? super k0> dVar);
}

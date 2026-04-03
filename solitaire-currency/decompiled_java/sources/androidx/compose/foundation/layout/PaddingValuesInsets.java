package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WindowInsets.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
final class PaddingValuesInsets implements WindowInsets {

    @NotNull
    private final PaddingValues paddingValues;

    public PaddingValuesInsets(@NotNull PaddingValues paddingValues) {
        t.i(paddingValues, "paddingValues");
        this.paddingValues = paddingValues;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PaddingValuesInsets) {
            return t.d(((PaddingValuesInsets) obj).paddingValues, this.paddingValues);
        }
        return false;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(@NotNull Density density) {
        t.i(density, "density");
        return density.mo290roundToPx0680j_4(this.paddingValues.mo379calculateBottomPaddingD9Ej5fM());
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        t.i(density, "density");
        t.i(layoutDirection, "layoutDirection");
        return density.mo290roundToPx0680j_4(this.paddingValues.mo380calculateLeftPaddingu2uoSUM(layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        t.i(density, "density");
        t.i(layoutDirection, "layoutDirection");
        return density.mo290roundToPx0680j_4(this.paddingValues.mo381calculateRightPaddingu2uoSUM(layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(@NotNull Density density) {
        t.i(density, "density");
        return density.mo290roundToPx0680j_4(this.paddingValues.mo382calculateTopPaddingD9Ej5fM());
    }

    public int hashCode() {
        return this.paddingValues.hashCode();
    }

    @NotNull
    public String toString() {
        LayoutDirection layoutDirection = LayoutDirection.Ltr;
        return "PaddingValues(" + ((Object) Dp.m3684toStringimpl(this.paddingValues.mo380calculateLeftPaddingu2uoSUM(layoutDirection))) + ", " + ((Object) Dp.m3684toStringimpl(this.paddingValues.mo382calculateTopPaddingD9Ej5fM())) + ", " + ((Object) Dp.m3684toStringimpl(this.paddingValues.mo381calculateRightPaddingu2uoSUM(layoutDirection))) + ", " + ((Object) Dp.m3684toStringimpl(this.paddingValues.mo379calculateBottomPaddingD9Ej5fM())) + ')';
    }
}

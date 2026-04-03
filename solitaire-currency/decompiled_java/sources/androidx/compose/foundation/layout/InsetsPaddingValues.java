package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WindowInsets.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
final class InsetsPaddingValues implements PaddingValues {

    @NotNull
    private final Density density;

    @NotNull
    private final WindowInsets insets;

    public InsetsPaddingValues(@NotNull WindowInsets insets, @NotNull Density density) {
        t.i(insets, "insets");
        t.i(density, "density");
        this.insets = insets;
        this.density = density;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM, reason: not valid java name */
    public float mo379calculateBottomPaddingD9Ej5fM() {
        Density density = this.density;
        return density.mo293toDpu2uoSUM(this.insets.getBottom(density));
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM, reason: not valid java name */
    public float mo380calculateLeftPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection) {
        t.i(layoutDirection, "layoutDirection");
        Density density = this.density;
        return density.mo293toDpu2uoSUM(this.insets.getLeft(density, layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM, reason: not valid java name */
    public float mo381calculateRightPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection) {
        t.i(layoutDirection, "layoutDirection");
        Density density = this.density;
        return density.mo293toDpu2uoSUM(this.insets.getRight(density, layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM, reason: not valid java name */
    public float mo382calculateTopPaddingD9Ej5fM() {
        Density density = this.density;
        return density.mo293toDpu2uoSUM(this.insets.getTop(density));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InsetsPaddingValues)) {
            return false;
        }
        InsetsPaddingValues insetsPaddingValues = (InsetsPaddingValues) obj;
        return t.d(this.insets, insetsPaddingValues.insets) && t.d(this.density, insetsPaddingValues.density);
    }

    @NotNull
    public final WindowInsets getInsets() {
        return this.insets;
    }

    public int hashCode() {
        return (this.insets.hashCode() * 31) + this.density.hashCode();
    }

    @NotNull
    public String toString() {
        return "InsetsPaddingValues(insets=" + this.insets + ", density=" + this.density + ')';
    }
}

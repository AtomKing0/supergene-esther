package androidx.compose.foundation.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WindowInsets.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
final class FixedDpInsets implements WindowInsets {
    private final float bottomDp;
    private final float leftDp;
    private final float rightDp;
    private final float topDp;

    public /* synthetic */ FixedDpInsets(float f10, float f11, float f12, float f13, kotlin.jvm.internal.k kVar) {
        this(f10, f11, f12, f13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FixedDpInsets)) {
            return false;
        }
        FixedDpInsets fixedDpInsets = (FixedDpInsets) obj;
        return Dp.m3678equalsimpl0(this.leftDp, fixedDpInsets.leftDp) && Dp.m3678equalsimpl0(this.topDp, fixedDpInsets.topDp) && Dp.m3678equalsimpl0(this.rightDp, fixedDpInsets.rightDp) && Dp.m3678equalsimpl0(this.bottomDp, fixedDpInsets.bottomDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(@NotNull Density density) {
        t.i(density, "density");
        return density.mo290roundToPx0680j_4(this.bottomDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        t.i(density, "density");
        t.i(layoutDirection, "layoutDirection");
        return density.mo290roundToPx0680j_4(this.leftDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        t.i(density, "density");
        t.i(layoutDirection, "layoutDirection");
        return density.mo290roundToPx0680j_4(this.rightDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(@NotNull Density density) {
        t.i(density, "density");
        return density.mo290roundToPx0680j_4(this.topDp);
    }

    public int hashCode() {
        return (((((Dp.m3679hashCodeimpl(this.leftDp) * 31) + Dp.m3679hashCodeimpl(this.topDp)) * 31) + Dp.m3679hashCodeimpl(this.rightDp)) * 31) + Dp.m3679hashCodeimpl(this.bottomDp);
    }

    @NotNull
    public String toString() {
        return "Insets(left=" + ((Object) Dp.m3684toStringimpl(this.leftDp)) + ", top=" + ((Object) Dp.m3684toStringimpl(this.topDp)) + ", right=" + ((Object) Dp.m3684toStringimpl(this.rightDp)) + ", bottom=" + ((Object) Dp.m3684toStringimpl(this.bottomDp)) + ')';
    }

    private FixedDpInsets(float f10, float f11, float f12, float f13) {
        this.leftDp = f10;
        this.topDp = f11;
        this.rightDp = f12;
        this.bottomDp = f13;
    }
}

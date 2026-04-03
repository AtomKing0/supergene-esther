package androidx.compose.foundation.shape;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CornerBasedShape.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public abstract class CornerBasedShape implements Shape {
    public static final int $stable = 0;

    @NotNull
    private final CornerSize bottomEnd;

    @NotNull
    private final CornerSize bottomStart;

    @NotNull
    private final CornerSize topEnd;

    @NotNull
    private final CornerSize topStart;

    public CornerBasedShape(@NotNull CornerSize topStart, @NotNull CornerSize topEnd, @NotNull CornerSize bottomEnd, @NotNull CornerSize bottomStart) {
        t.i(topStart, "topStart");
        t.i(topEnd, "topEnd");
        t.i(bottomEnd, "bottomEnd");
        t.i(bottomStart, "bottomStart");
        this.topStart = topStart;
        this.topEnd = topEnd;
        this.bottomEnd = bottomEnd;
        this.bottomStart = bottomStart;
    }

    public static /* synthetic */ CornerBasedShape copy$default(CornerBasedShape cornerBasedShape, CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        if ((i10 & 1) != 0) {
            cornerSize = cornerBasedShape.topStart;
        }
        if ((i10 & 2) != 0) {
            cornerSize2 = cornerBasedShape.topEnd;
        }
        if ((i10 & 4) != 0) {
            cornerSize3 = cornerBasedShape.bottomEnd;
        }
        if ((i10 & 8) != 0) {
            cornerSize4 = cornerBasedShape.bottomStart;
        }
        return cornerBasedShape.copy(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }

    @NotNull
    public final CornerBasedShape copy(@NotNull CornerSize all) {
        t.i(all, "all");
        return copy(all, all, all, all);
    }

    @NotNull
    public abstract CornerBasedShape copy(@NotNull CornerSize cornerSize, @NotNull CornerSize cornerSize2, @NotNull CornerSize cornerSize3, @NotNull CornerSize cornerSize4);

    @NotNull
    /* JADX INFO: renamed from: createOutline-LjSzlW0 */
    public abstract Outline mo629createOutlineLjSzlW0(long j10, float f10, float f11, float f12, float f13, @NotNull LayoutDirection layoutDirection);

    @Override // androidx.compose.ui.graphics.Shape
    @NotNull
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public final Outline mo201createOutlinePq9zytI(long j10, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
        t.i(layoutDirection, "layoutDirection");
        t.i(density, "density");
        float fMo637toPxTmRCtEA = this.topStart.mo637toPxTmRCtEA(j10, density);
        float fMo637toPxTmRCtEA2 = this.topEnd.mo637toPxTmRCtEA(j10, density);
        float fMo637toPxTmRCtEA3 = this.bottomEnd.mo637toPxTmRCtEA(j10, density);
        float fMo637toPxTmRCtEA4 = this.bottomStart.mo637toPxTmRCtEA(j10, density);
        float fM1435getMinDimensionimpl = Size.m1435getMinDimensionimpl(j10);
        float f10 = fMo637toPxTmRCtEA + fMo637toPxTmRCtEA4;
        if (f10 > fM1435getMinDimensionimpl) {
            float f11 = fM1435getMinDimensionimpl / f10;
            fMo637toPxTmRCtEA *= f11;
            fMo637toPxTmRCtEA4 *= f11;
        }
        float f12 = fMo637toPxTmRCtEA4;
        float f13 = fMo637toPxTmRCtEA2 + fMo637toPxTmRCtEA3;
        if (f13 > fM1435getMinDimensionimpl) {
            float f14 = fM1435getMinDimensionimpl / f13;
            fMo637toPxTmRCtEA2 *= f14;
            fMo637toPxTmRCtEA3 *= f14;
        }
        if (fMo637toPxTmRCtEA >= 0.0f && fMo637toPxTmRCtEA2 >= 0.0f && fMo637toPxTmRCtEA3 >= 0.0f && f12 >= 0.0f) {
            return mo629createOutlineLjSzlW0(j10, fMo637toPxTmRCtEA, fMo637toPxTmRCtEA2, fMo637toPxTmRCtEA3, f12, layoutDirection);
        }
        throw new IllegalArgumentException(("Corner size in Px can't be negative(topStart = " + fMo637toPxTmRCtEA + ", topEnd = " + fMo637toPxTmRCtEA2 + ", bottomEnd = " + fMo637toPxTmRCtEA3 + ", bottomStart = " + f12 + ")!").toString());
    }

    @NotNull
    public final CornerSize getBottomEnd() {
        return this.bottomEnd;
    }

    @NotNull
    public final CornerSize getBottomStart() {
        return this.bottomStart;
    }

    @NotNull
    public final CornerSize getTopEnd() {
        return this.topEnd;
    }

    @NotNull
    public final CornerSize getTopStart() {
        return this.topStart;
    }
}

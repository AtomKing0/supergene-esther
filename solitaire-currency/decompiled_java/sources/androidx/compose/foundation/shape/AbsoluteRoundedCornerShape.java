package androidx.compose.foundation.shape;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AbsoluteRoundedCornerShape.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class AbsoluteRoundedCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsoluteRoundedCornerShape(@NotNull CornerSize topLeft, @NotNull CornerSize topRight, @NotNull CornerSize bottomRight, @NotNull CornerSize bottomLeft) {
        super(topLeft, topRight, bottomRight, bottomLeft);
        t.i(topLeft, "topLeft");
        t.i(topRight, "topRight");
        t.i(bottomRight, "bottomRight");
        t.i(bottomLeft, "bottomLeft");
    }

    /* JADX INFO: renamed from: toRadius-Bz7bX_o, reason: not valid java name */
    private final long m633toRadiusBz7bX_o(float f10) {
        return CornerRadiusKt.CornerRadius$default(f10, 0.0f, 2, null);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    @NotNull
    /* JADX INFO: renamed from: createOutline-LjSzlW0 */
    public Outline mo629createOutlineLjSzlW0(long j10, float f10, float f11, float f12, float f13, @NotNull LayoutDirection layoutDirection) {
        t.i(layoutDirection, "layoutDirection");
        return ((((f10 + f11) + f12) + f13) > 0.0f ? 1 : ((((f10 + f11) + f12) + f13) == 0.0f ? 0 : -1)) == 0 ? new Outline.Rectangle(SizeKt.m1457toRectuvyYCjk(j10)) : new Outline.Rounded(RoundRectKt.m1419RoundRectZAM2FJo(SizeKt.m1457toRectuvyYCjk(j10), CornerRadiusKt.CornerRadius$default(f10, 0.0f, 2, null), CornerRadiusKt.CornerRadius$default(f11, 0.0f, 2, null), CornerRadiusKt.CornerRadius$default(f12, 0.0f, 2, null), CornerRadiusKt.CornerRadius$default(f13, 0.0f, 2, null)));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbsoluteRoundedCornerShape)) {
            return false;
        }
        AbsoluteRoundedCornerShape absoluteRoundedCornerShape = (AbsoluteRoundedCornerShape) obj;
        return t.d(getTopStart(), absoluteRoundedCornerShape.getTopStart()) && t.d(getTopEnd(), absoluteRoundedCornerShape.getTopEnd()) && t.d(getBottomEnd(), absoluteRoundedCornerShape.getBottomEnd()) && t.d(getBottomStart(), absoluteRoundedCornerShape.getBottomStart());
    }

    public int hashCode() {
        return (((((getTopStart().hashCode() * 31) + getTopEnd().hashCode()) * 31) + getBottomEnd().hashCode()) * 31) + getBottomStart().hashCode();
    }

    @NotNull
    public String toString() {
        return "AbsoluteRoundedCornerShape(topLeft = " + getTopStart() + ", topRight = " + getTopEnd() + ", bottomRight = " + getBottomEnd() + ", bottomLeft = " + getBottomStart() + ')';
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    @NotNull
    public AbsoluteRoundedCornerShape copy(@NotNull CornerSize topStart, @NotNull CornerSize topEnd, @NotNull CornerSize bottomEnd, @NotNull CornerSize bottomStart) {
        t.i(topStart, "topStart");
        t.i(topEnd, "topEnd");
        t.i(bottomEnd, "bottomEnd");
        t.i(bottomStart, "bottomStart");
        return new AbsoluteRoundedCornerShape(topStart, topEnd, bottomEnd, bottomStart);
    }
}

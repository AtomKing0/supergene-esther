package androidx.compose.foundation.shape;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RoundedCornerShape.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class RoundedCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedCornerShape(@NotNull CornerSize topStart, @NotNull CornerSize topEnd, @NotNull CornerSize bottomEnd, @NotNull CornerSize bottomStart) {
        super(topStart, topEnd, bottomEnd, bottomStart);
        t.i(topStart, "topStart");
        t.i(topEnd, "topEnd");
        t.i(bottomEnd, "bottomEnd");
        t.i(bottomStart, "bottomStart");
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    @NotNull
    /* JADX INFO: renamed from: createOutline-LjSzlW0 */
    public Outline mo629createOutlineLjSzlW0(long j10, float f10, float f11, float f12, float f13, @NotNull LayoutDirection layoutDirection) {
        t.i(layoutDirection, "layoutDirection");
        if (((f10 + f11) + f12) + f13 == 0.0f) {
            return new Outline.Rectangle(SizeKt.m1457toRectuvyYCjk(j10));
        }
        Rect rectM1457toRectuvyYCjk = SizeKt.m1457toRectuvyYCjk(j10);
        LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
        return new Outline.Rounded(RoundRectKt.m1419RoundRectZAM2FJo(rectM1457toRectuvyYCjk, CornerRadiusKt.CornerRadius$default(layoutDirection == layoutDirection2 ? f10 : f11, 0.0f, 2, null), CornerRadiusKt.CornerRadius$default(layoutDirection == layoutDirection2 ? f11 : f10, 0.0f, 2, null), CornerRadiusKt.CornerRadius$default(layoutDirection == layoutDirection2 ? f12 : f13, 0.0f, 2, null), CornerRadiusKt.CornerRadius$default(layoutDirection == layoutDirection2 ? f13 : f12, 0.0f, 2, null)));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundedCornerShape)) {
            return false;
        }
        RoundedCornerShape roundedCornerShape = (RoundedCornerShape) obj;
        return t.d(getTopStart(), roundedCornerShape.getTopStart()) && t.d(getTopEnd(), roundedCornerShape.getTopEnd()) && t.d(getBottomEnd(), roundedCornerShape.getBottomEnd()) && t.d(getBottomStart(), roundedCornerShape.getBottomStart());
    }

    public int hashCode() {
        return (((((getTopStart().hashCode() * 31) + getTopEnd().hashCode()) * 31) + getBottomEnd().hashCode()) * 31) + getBottomStart().hashCode();
    }

    @NotNull
    public String toString() {
        return "RoundedCornerShape(topStart = " + getTopStart() + ", topEnd = " + getTopEnd() + ", bottomEnd = " + getBottomEnd() + ", bottomStart = " + getBottomStart() + ')';
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    @NotNull
    public RoundedCornerShape copy(@NotNull CornerSize topStart, @NotNull CornerSize topEnd, @NotNull CornerSize bottomEnd, @NotNull CornerSize bottomStart) {
        t.i(topStart, "topStart");
        t.i(topEnd, "topEnd");
        t.i(bottomEnd, "bottomEnd");
        t.i(bottomStart, "bottomStart");
        return new RoundedCornerShape(topStart, topEnd, bottomEnd, bottomStart);
    }
}

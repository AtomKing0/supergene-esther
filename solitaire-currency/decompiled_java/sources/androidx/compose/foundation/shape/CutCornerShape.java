package androidx.compose.foundation.shape;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CutCornerShape.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class CutCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CutCornerShape(@NotNull CornerSize topStart, @NotNull CornerSize topEnd, @NotNull CornerSize bottomEnd, @NotNull CornerSize bottomStart) {
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
        if (((f10 + f11) + f13) + f12 == 0.0f) {
            return new Outline.Rectangle(SizeKt.m1457toRectuvyYCjk(j10));
        }
        Path Path = AndroidPath_androidKt.Path();
        LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
        float f14 = layoutDirection == layoutDirection2 ? f10 : f11;
        Path.moveTo(0.0f, f14);
        Path.lineTo(f14, 0.0f);
        if (layoutDirection == layoutDirection2) {
            f10 = f11;
        }
        Path.lineTo(Size.m1436getWidthimpl(j10) - f10, 0.0f);
        Path.lineTo(Size.m1436getWidthimpl(j10), f10);
        float f15 = layoutDirection == layoutDirection2 ? f12 : f13;
        Path.lineTo(Size.m1436getWidthimpl(j10), Size.m1433getHeightimpl(j10) - f15);
        Path.lineTo(Size.m1436getWidthimpl(j10) - f15, Size.m1433getHeightimpl(j10));
        if (layoutDirection == layoutDirection2) {
            f12 = f13;
        }
        Path.lineTo(f12, Size.m1433getHeightimpl(j10));
        Path.lineTo(0.0f, Size.m1433getHeightimpl(j10) - f12);
        Path.close();
        return new Outline.Generic(Path);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CutCornerShape)) {
            return false;
        }
        CutCornerShape cutCornerShape = (CutCornerShape) obj;
        return t.d(getTopStart(), cutCornerShape.getTopStart()) && t.d(getTopEnd(), cutCornerShape.getTopEnd()) && t.d(getBottomEnd(), cutCornerShape.getBottomEnd()) && t.d(getBottomStart(), cutCornerShape.getBottomStart());
    }

    public int hashCode() {
        return (((((getTopStart().hashCode() * 31) + getTopEnd().hashCode()) * 31) + getBottomEnd().hashCode()) * 31) + getBottomStart().hashCode();
    }

    @NotNull
    public String toString() {
        return "CutCornerShape(topStart = " + getTopStart() + ", topEnd = " + getTopEnd() + ", bottomEnd = " + getBottomEnd() + ", bottomStart = " + getBottomStart() + ')';
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    @NotNull
    public CutCornerShape copy(@NotNull CornerSize topStart, @NotNull CornerSize topEnd, @NotNull CornerSize bottomEnd, @NotNull CornerSize bottomStart) {
        t.i(topStart, "topStart");
        t.i(topEnd, "topEnd");
        t.i(bottomEnd, "bottomEnd");
        t.i(bottomStart, "bottomStart");
        return new CutCornerShape(topStart, topEnd, bottomEnd, bottomStart);
    }
}

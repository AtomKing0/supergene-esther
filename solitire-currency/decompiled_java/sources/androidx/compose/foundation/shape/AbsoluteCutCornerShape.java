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

/* JADX INFO: compiled from: AbsoluteCutCornerShape.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class AbsoluteCutCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsoluteCutCornerShape(@NotNull CornerSize topLeft, @NotNull CornerSize topRight, @NotNull CornerSize bottomRight, @NotNull CornerSize bottomLeft) {
        super(topLeft, topRight, bottomRight, bottomLeft);
        t.i(topLeft, "topLeft");
        t.i(topRight, "topRight");
        t.i(bottomRight, "bottomRight");
        t.i(bottomLeft, "bottomLeft");
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    @NotNull
    /* JADX INFO: renamed from: createOutline-LjSzlW0, reason: not valid java name */
    public Outline mo629createOutlineLjSzlW0(long j10, float f10, float f11, float f12, float f13, @NotNull LayoutDirection layoutDirection) {
        t.i(layoutDirection, "layoutDirection");
        if (((f10 + f11) + f13) + f12 == 0.0f) {
            return new Outline.Rectangle(SizeKt.m1457toRectuvyYCjk(j10));
        }
        Path Path = AndroidPath_androidKt.Path();
        Path.moveTo(0.0f, f10);
        Path.lineTo(f10, 0.0f);
        Path.lineTo(Size.m1436getWidthimpl(j10) - f11, 0.0f);
        Path.lineTo(Size.m1436getWidthimpl(j10), f11);
        Path.lineTo(Size.m1436getWidthimpl(j10), Size.m1433getHeightimpl(j10) - f12);
        Path.lineTo(Size.m1436getWidthimpl(j10) - f12, Size.m1433getHeightimpl(j10));
        Path.lineTo(f13, Size.m1433getHeightimpl(j10));
        Path.lineTo(0.0f, Size.m1433getHeightimpl(j10) - f13);
        Path.close();
        return new Outline.Generic(Path);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbsoluteCutCornerShape)) {
            return false;
        }
        AbsoluteCutCornerShape absoluteCutCornerShape = (AbsoluteCutCornerShape) obj;
        return t.d(getTopStart(), absoluteCutCornerShape.getTopStart()) && t.d(getTopEnd(), absoluteCutCornerShape.getTopEnd()) && t.d(getBottomEnd(), absoluteCutCornerShape.getBottomEnd()) && t.d(getBottomStart(), absoluteCutCornerShape.getBottomStart());
    }

    public int hashCode() {
        return (((((getTopStart().hashCode() * 31) + getTopEnd().hashCode()) * 31) + getBottomEnd().hashCode()) * 31) + getBottomStart().hashCode();
    }

    @NotNull
    public String toString() {
        return "AbsoluteCutCornerShape(topLeft = " + getTopStart() + ", topRight = " + getTopEnd() + ", bottomRight = " + getBottomEnd() + ", bottomLeft = " + getBottomStart() + ')';
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    @NotNull
    public AbsoluteCutCornerShape copy(@NotNull CornerSize topStart, @NotNull CornerSize topEnd, @NotNull CornerSize bottomEnd, @NotNull CornerSize bottomStart) {
        t.i(topStart, "topStart");
        t.i(topEnd, "topEnd");
        t.i(bottomEnd, "bottomEnd");
        t.i(bottomStart, "bottomStart");
        return new AbsoluteCutCornerShape(topStart, topEnd, bottomEnd, bottomStart);
    }
}

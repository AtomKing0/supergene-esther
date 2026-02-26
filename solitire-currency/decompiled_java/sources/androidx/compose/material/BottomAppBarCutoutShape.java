package androidx.compose.material;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.s;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes.dex */
final class BottomAppBarCutoutShape implements Shape {

    @NotNull
    private final Shape cutoutShape;

    @NotNull
    private final FabPlacement fabPlacement;

    public BottomAppBarCutoutShape(@NotNull Shape cutoutShape, @NotNull FabPlacement fabPlacement) {
        t.i(cutoutShape, "cutoutShape");
        t.i(fabPlacement, "fabPlacement");
        this.cutoutShape = cutoutShape;
        this.fabPlacement = fabPlacement;
    }

    private final void addCutoutShape(Path path, LayoutDirection layoutDirection, Density density) {
        float fMo296toPx0680j_4 = density.mo296toPx0680j_4(AppBarKt.BottomAppBarCutoutOffset);
        float f10 = 2 * fMo296toPx0680j_4;
        long jSize = SizeKt.Size(this.fabPlacement.getWidth() + f10, this.fabPlacement.getHeight() + f10);
        float left = this.fabPlacement.getLeft() - fMo296toPx0680j_4;
        float fM1436getWidthimpl = left + Size.m1436getWidthimpl(jSize);
        float fM1433getHeightimpl = Size.m1433getHeightimpl(jSize) / 2.0f;
        OutlineKt.addOutline(path, this.cutoutShape.mo201createOutlinePq9zytI(jSize, layoutDirection, density));
        path.mo1503translatek4lQ0M(OffsetKt.Offset(left, -fM1433getHeightimpl));
        if (t.d(this.cutoutShape, RoundedCornerShapeKt.getCircleShape())) {
            addRoundedEdges(path, left, fM1436getWidthimpl, fM1433getHeightimpl, density.mo296toPx0680j_4(AppBarKt.BottomAppBarRoundedEdgeRadius), 0.0f);
        }
    }

    private final void addRoundedEdges(Path path, float f10, float f11, float f12, float f13, float f14) {
        float f15 = -((float) Math.sqrt((f12 * f12) - (f14 * f14)));
        float f16 = f12 + f15;
        float f17 = f10 + f16;
        float f18 = f11 - f16;
        s<Float, Float> sVarCalculateRoundedEdgeIntercept = AppBarKt.calculateRoundedEdgeIntercept(f15 - 1.0f, f14, f12);
        float fFloatValue = sVarCalculateRoundedEdgeIntercept.a().floatValue() + f12;
        float fFloatValue2 = sVarCalculateRoundedEdgeIntercept.b().floatValue() - f14;
        path.moveTo(f17 - f13, 0.0f);
        path.quadraticBezierTo(f17 - 1.0f, 0.0f, f10 + fFloatValue, fFloatValue2);
        path.lineTo(f11 - fFloatValue, fFloatValue2);
        path.quadraticBezierTo(f18 + 1.0f, 0.0f, f13 + f18, 0.0f);
        path.close();
    }

    public static /* synthetic */ BottomAppBarCutoutShape copy$default(BottomAppBarCutoutShape bottomAppBarCutoutShape, Shape shape, FabPlacement fabPlacement, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            shape = bottomAppBarCutoutShape.cutoutShape;
        }
        if ((i10 & 2) != 0) {
            fabPlacement = bottomAppBarCutoutShape.fabPlacement;
        }
        return bottomAppBarCutoutShape.copy(shape, fabPlacement);
    }

    @NotNull
    public final Shape component1() {
        return this.cutoutShape;
    }

    @NotNull
    public final FabPlacement component2() {
        return this.fabPlacement;
    }

    @NotNull
    public final BottomAppBarCutoutShape copy(@NotNull Shape cutoutShape, @NotNull FabPlacement fabPlacement) {
        t.i(cutoutShape, "cutoutShape");
        t.i(fabPlacement, "fabPlacement");
        return new BottomAppBarCutoutShape(cutoutShape, fabPlacement);
    }

    @Override // androidx.compose.ui.graphics.Shape
    @NotNull
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public Outline mo201createOutlinePq9zytI(long j10, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
        t.i(layoutDirection, "layoutDirection");
        t.i(density, "density");
        Path Path = AndroidPath_androidKt.Path();
        Path.addRect(new Rect(0.0f, 0.0f, Size.m1436getWidthimpl(j10), Size.m1433getHeightimpl(j10)));
        Path Path2 = AndroidPath_androidKt.Path();
        addCutoutShape(Path2, layoutDirection, density);
        Path2.mo1501opN5in7k0(Path, Path2, PathOperation.Companion.m1833getDifferenceb3I0S0c());
        return new Outline.Generic(Path2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BottomAppBarCutoutShape)) {
            return false;
        }
        BottomAppBarCutoutShape bottomAppBarCutoutShape = (BottomAppBarCutoutShape) obj;
        return t.d(this.cutoutShape, bottomAppBarCutoutShape.cutoutShape) && t.d(this.fabPlacement, bottomAppBarCutoutShape.fabPlacement);
    }

    @NotNull
    public final Shape getCutoutShape() {
        return this.cutoutShape;
    }

    @NotNull
    public final FabPlacement getFabPlacement() {
        return this.fabPlacement;
    }

    public int hashCode() {
        return (this.cutoutShape.hashCode() * 31) + this.fabPlacement.hashCode();
    }

    @NotNull
    public String toString() {
        return "BottomAppBarCutoutShape(cutoutShape=" + this.cutoutShape + ", fabPlacement=" + this.fabPlacement + ')';
    }
}

package androidx.compose.ui.graphics;

import android.graphics.Path;
import android.graphics.RectF;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.PathOperation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidPath.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPath implements Path {

    @NotNull
    private final android.graphics.Path internalPath;

    @NotNull
    private final android.graphics.Matrix mMatrix;

    @NotNull
    private final float[] radii;

    @NotNull
    private final RectF rectF;

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidPath() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final boolean _rectIsValid(Rect rect) {
        if (!(!Float.isNaN(rect.getLeft()))) {
            throw new IllegalStateException("Rect.left is NaN".toString());
        }
        if (!(!Float.isNaN(rect.getTop()))) {
            throw new IllegalStateException("Rect.top is NaN".toString());
        }
        if (!(!Float.isNaN(rect.getRight()))) {
            throw new IllegalStateException("Rect.right is NaN".toString());
        }
        if (!Float.isNaN(rect.getBottom())) {
            return true;
        }
        throw new IllegalStateException("Rect.bottom is NaN".toString());
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addArc(@NotNull Rect oval, float f10, float f11) {
        kotlin.jvm.internal.t.i(oval, "oval");
        if (!_rectIsValid(oval)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.rectF.set(RectHelper_androidKt.toAndroidRect(oval));
        this.internalPath.addArc(this.rectF, f10, f11);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addArcRad(@NotNull Rect oval, float f10, float f11) {
        kotlin.jvm.internal.t.i(oval, "oval");
        addArc(oval, DegreesKt.degrees(f10), DegreesKt.degrees(f11));
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addOval(@NotNull Rect oval) {
        kotlin.jvm.internal.t.i(oval, "oval");
        this.rectF.set(RectHelper_androidKt.toAndroidRect(oval));
        this.internalPath.addOval(this.rectF, Path.Direction.CCW);
    }

    @Override // androidx.compose.ui.graphics.Path
    /* JADX INFO: renamed from: addPath-Uv8p0NA, reason: not valid java name */
    public void mo1499addPathUv8p0NA(@NotNull Path path, long j10) {
        kotlin.jvm.internal.t.i(path, "path");
        android.graphics.Path path2 = this.internalPath;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        path2.addPath(((AndroidPath) path).getInternalPath(), Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10));
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addRect(@NotNull Rect rect) {
        kotlin.jvm.internal.t.i(rect, "rect");
        if (!_rectIsValid(rect)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.rectF.set(RectHelper_androidKt.toAndroidRectF(rect));
        this.internalPath.addRect(this.rectF, Path.Direction.CCW);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addRoundRect(@NotNull RoundRect roundRect) {
        kotlin.jvm.internal.t.i(roundRect, "roundRect");
        this.rectF.set(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
        this.radii[0] = CornerRadius.m1342getXimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs());
        this.radii[1] = CornerRadius.m1343getYimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs());
        this.radii[2] = CornerRadius.m1342getXimpl(roundRect.m1418getTopRightCornerRadiuskKHJgLs());
        this.radii[3] = CornerRadius.m1343getYimpl(roundRect.m1418getTopRightCornerRadiuskKHJgLs());
        this.radii[4] = CornerRadius.m1342getXimpl(roundRect.m1416getBottomRightCornerRadiuskKHJgLs());
        this.radii[5] = CornerRadius.m1343getYimpl(roundRect.m1416getBottomRightCornerRadiuskKHJgLs());
        this.radii[6] = CornerRadius.m1342getXimpl(roundRect.m1415getBottomLeftCornerRadiuskKHJgLs());
        this.radii[7] = CornerRadius.m1343getYimpl(roundRect.m1415getBottomLeftCornerRadiuskKHJgLs());
        this.internalPath.addRoundRect(this.rectF, this.radii, Path.Direction.CCW);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void arcTo(@NotNull Rect rect, float f10, float f11, boolean z10) {
        kotlin.jvm.internal.t.i(rect, "rect");
        this.rectF.set(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
        this.internalPath.arcTo(this.rectF, f10, f11, z10);
    }

    @Override // androidx.compose.ui.graphics.Path
    public /* synthetic */ void arcToRad(Rect rect, float f10, float f11, boolean z10) {
        f1.a(this, rect, f10, f11, z10);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void close() {
        this.internalPath.close();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void cubicTo(float f10, float f11, float f12, float f13, float f14, float f15) {
        this.internalPath.cubicTo(f10, f11, f12, f13, f14, f15);
    }

    @Override // androidx.compose.ui.graphics.Path
    @NotNull
    public Rect getBounds() {
        this.internalPath.computeBounds(this.rectF, true);
        RectF rectF = this.rectF;
        return new Rect(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // androidx.compose.ui.graphics.Path
    /* JADX INFO: renamed from: getFillType-Rg-k1Os, reason: not valid java name */
    public int mo1500getFillTypeRgk1Os() {
        return this.internalPath.getFillType() == Path.FillType.EVEN_ODD ? PathFillType.Companion.m1824getEvenOddRgk1Os() : PathFillType.Companion.m1825getNonZeroRgk1Os();
    }

    @NotNull
    public final android.graphics.Path getInternalPath() {
        return this.internalPath;
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean isConvex() {
        return this.internalPath.isConvex();
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean isEmpty() {
        return this.internalPath.isEmpty();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void lineTo(float f10, float f11) {
        this.internalPath.lineTo(f10, f11);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void moveTo(float f10, float f11) {
        this.internalPath.moveTo(f10, f11);
    }

    @Override // androidx.compose.ui.graphics.Path
    /* JADX INFO: renamed from: op-N5in7k0, reason: not valid java name */
    public boolean mo1501opN5in7k0(@NotNull Path path1, @NotNull Path path2, int i10) {
        kotlin.jvm.internal.t.i(path1, "path1");
        kotlin.jvm.internal.t.i(path2, "path2");
        PathOperation.Companion companion = PathOperation.Companion;
        Path.Op op = PathOperation.m1829equalsimpl0(i10, companion.m1833getDifferenceb3I0S0c()) ? Path.Op.DIFFERENCE : PathOperation.m1829equalsimpl0(i10, companion.m1834getIntersectb3I0S0c()) ? Path.Op.INTERSECT : PathOperation.m1829equalsimpl0(i10, companion.m1835getReverseDifferenceb3I0S0c()) ? Path.Op.REVERSE_DIFFERENCE : PathOperation.m1829equalsimpl0(i10, companion.m1836getUnionb3I0S0c()) ? Path.Op.UNION : Path.Op.XOR;
        android.graphics.Path path = this.internalPath;
        if (!(path1 instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        android.graphics.Path internalPath = ((AndroidPath) path1).getInternalPath();
        if (path2 instanceof AndroidPath) {
            return path.op(internalPath, ((AndroidPath) path2).getInternalPath(), op);
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.Path
    public void quadraticBezierTo(float f10, float f11, float f12, float f13) {
        this.internalPath.quadTo(f10, f11, f12, f13);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeCubicTo(float f10, float f11, float f12, float f13, float f14, float f15) {
        this.internalPath.rCubicTo(f10, f11, f12, f13, f14, f15);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeLineTo(float f10, float f11) {
        this.internalPath.rLineTo(f10, f11);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeMoveTo(float f10, float f11) {
        this.internalPath.rMoveTo(f10, f11);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeQuadraticBezierTo(float f10, float f11, float f12, float f13) {
        this.internalPath.rQuadTo(f10, f11, f12, f13);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void reset() {
        this.internalPath.reset();
    }

    @Override // androidx.compose.ui.graphics.Path
    /* JADX INFO: renamed from: setFillType-oQ8Xj4U, reason: not valid java name */
    public void mo1502setFillTypeoQ8Xj4U(int i10) {
        this.internalPath.setFillType(PathFillType.m1820equalsimpl0(i10, PathFillType.Companion.m1824getEvenOddRgk1Os()) ? Path.FillType.EVEN_ODD : Path.FillType.WINDING);
    }

    @Override // androidx.compose.ui.graphics.Path
    /* JADX INFO: renamed from: translate-k-4lQ0M, reason: not valid java name */
    public void mo1503translatek4lQ0M(long j10) {
        this.mMatrix.reset();
        this.mMatrix.setTranslate(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10));
        this.internalPath.transform(this.mMatrix);
    }

    public AndroidPath(@NotNull android.graphics.Path internalPath) {
        kotlin.jvm.internal.t.i(internalPath, "internalPath");
        this.internalPath = internalPath;
        this.rectF = new RectF();
        this.radii = new float[8];
        this.mMatrix = new android.graphics.Matrix();
    }

    public /* synthetic */ AndroidPath(android.graphics.Path path, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? new android.graphics.Path() : path);
    }

    public static /* synthetic */ void isConvex$annotations() {
    }
}

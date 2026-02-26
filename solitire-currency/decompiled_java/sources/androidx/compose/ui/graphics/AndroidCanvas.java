package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Region;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidCanvas.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidCanvas implements Canvas {

    @NotNull
    private android.graphics.Canvas internalCanvas = AndroidCanvas_androidKt.EmptyCanvas;

    @NotNull
    private final Rect srcRect = new Rect();

    @NotNull
    private final Rect dstRect = new Rect();

    private final void drawLines(List<Offset> list, Paint paint, int i10) {
        if (list.size() < 2) {
            return;
        }
        n9.g gVarT = n9.o.t(n9.o.u(0, list.size() - 1), i10);
        int iB = gVarT.b();
        int iE = gVarT.e();
        int iF = gVarT.f();
        if ((iF <= 0 || iB > iE) && (iF >= 0 || iE > iB)) {
            return;
        }
        while (true) {
            long jM1377unboximpl = list.get(iB).m1377unboximpl();
            long jM1377unboximpl2 = list.get(iB + 1).m1377unboximpl();
            this.internalCanvas.drawLine(Offset.m1367getXimpl(jM1377unboximpl), Offset.m1368getYimpl(jM1377unboximpl), Offset.m1367getXimpl(jM1377unboximpl2), Offset.m1368getYimpl(jM1377unboximpl2), paint.asFrameworkPaint());
            if (iB == iE) {
                return;
            } else {
                iB += iF;
            }
        }
    }

    private final void drawPoints(List<Offset> list, Paint paint) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            long jM1377unboximpl = list.get(i10).m1377unboximpl();
            this.internalCanvas.drawPoint(Offset.m1367getXimpl(jM1377unboximpl), Offset.m1368getYimpl(jM1377unboximpl), paint.asFrameworkPaint());
        }
    }

    private final void drawRawLines(float[] fArr, Paint paint, int i10) {
        if (fArr.length < 4 || fArr.length % 2 != 0) {
            return;
        }
        n9.g gVarT = n9.o.t(n9.o.u(0, fArr.length - 3), i10 * 2);
        int iB = gVarT.b();
        int iE = gVarT.e();
        int iF = gVarT.f();
        if ((iF <= 0 || iB > iE) && (iF >= 0 || iE > iB)) {
            return;
        }
        while (true) {
            this.internalCanvas.drawLine(fArr[iB], fArr[iB + 1], fArr[iB + 2], fArr[iB + 3], paint.asFrameworkPaint());
            if (iB == iE) {
                return;
            } else {
                iB += iF;
            }
        }
    }

    private final void drawRawPoints(float[] fArr, Paint paint, int i10) {
        if (fArr.length % 2 != 0) {
            return;
        }
        n9.g gVarT = n9.o.t(n9.o.u(0, fArr.length - 1), i10);
        int iB = gVarT.b();
        int iE = gVarT.e();
        int iF = gVarT.f();
        if ((iF <= 0 || iB > iE) && (iF >= 0 || iE > iB)) {
            return;
        }
        while (true) {
            this.internalCanvas.drawPoint(fArr[iB], fArr[iB + 1], paint.asFrameworkPaint());
            if (iB == iE) {
                return;
            } else {
                iB += iF;
            }
        }
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: clipPath-mtrdD-E, reason: not valid java name */
    public void mo1461clipPathmtrdDE(@NotNull Path path, int i10) {
        kotlin.jvm.internal.t.i(path, "path");
        android.graphics.Canvas canvas = this.internalCanvas;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.clipPath(((AndroidPath) path).getInternalPath(), m1472toRegionOp7u2Bmg(i10));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: clipRect-N_I0leg, reason: not valid java name */
    public void mo1462clipRectN_I0leg(float f10, float f11, float f12, float f13, int i10) {
        this.internalCanvas.clipRect(f10, f11, f12, f13, m1472toRegionOp7u2Bmg(i10));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: clipRect-mtrdD-E, reason: not valid java name */
    public /* synthetic */ void mo1463clipRectmtrdDE(androidx.compose.ui.geometry.Rect rect, int i10) {
        a1.a(this, rect, i10);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: concat-58bKbWc, reason: not valid java name */
    public void mo1464concat58bKbWc(@NotNull float[] matrix) {
        kotlin.jvm.internal.t.i(matrix, "matrix");
        if (MatrixKt.m1800isIdentity58bKbWc(matrix)) {
            return;
        }
        android.graphics.Matrix matrix2 = new android.graphics.Matrix();
        AndroidMatrixConversions_androidKt.m1479setFromEL8BTi8(matrix2, matrix);
        this.internalCanvas.concat(matrix2);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void disableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, false);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public /* synthetic */ void drawArc(androidx.compose.ui.geometry.Rect rect, float f10, float f11, boolean z10, Paint paint) {
        a1.b(this, rect, f10, f11, z10, paint);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public /* synthetic */ void drawArcRad(androidx.compose.ui.geometry.Rect rect, float f10, float f11, boolean z10, Paint paint) {
        a1.c(this, rect, f10, f11, z10, paint);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawCircle-9KIMszo, reason: not valid java name */
    public void mo1465drawCircle9KIMszo(long j10, float f10, @NotNull Paint paint) {
        kotlin.jvm.internal.t.i(paint, "paint");
        this.internalCanvas.drawCircle(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10), f10, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawImage-d-4ec7I, reason: not valid java name */
    public void mo1466drawImaged4ec7I(@NotNull ImageBitmap image, long j10, @NotNull Paint paint) {
        kotlin.jvm.internal.t.i(image, "image");
        kotlin.jvm.internal.t.i(paint, "paint");
        this.internalCanvas.drawBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(image), Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10), paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawImageRect-HPBpro0, reason: not valid java name */
    public void mo1467drawImageRectHPBpro0(@NotNull ImageBitmap image, long j10, long j11, long j12, long j13, @NotNull Paint paint) {
        kotlin.jvm.internal.t.i(image, "image");
        kotlin.jvm.internal.t.i(paint, "paint");
        android.graphics.Canvas canvas = this.internalCanvas;
        Bitmap bitmapAsAndroidBitmap = AndroidImageBitmap_androidKt.asAndroidBitmap(image);
        Rect rect = this.srcRect;
        rect.left = IntOffset.m3791getXimpl(j10);
        rect.top = IntOffset.m3792getYimpl(j10);
        rect.right = IntOffset.m3791getXimpl(j10) + IntSize.m3833getWidthimpl(j11);
        rect.bottom = IntOffset.m3792getYimpl(j10) + IntSize.m3832getHeightimpl(j11);
        v8.k0 k0Var = v8.k0.f35197a;
        Rect rect2 = this.dstRect;
        rect2.left = IntOffset.m3791getXimpl(j12);
        rect2.top = IntOffset.m3792getYimpl(j12);
        rect2.right = IntOffset.m3791getXimpl(j12) + IntSize.m3833getWidthimpl(j13);
        rect2.bottom = IntOffset.m3792getYimpl(j12) + IntSize.m3832getHeightimpl(j13);
        canvas.drawBitmap(bitmapAsAndroidBitmap, rect, rect2, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawLine-Wko1d7g, reason: not valid java name */
    public void mo1468drawLineWko1d7g(long j10, long j11, @NotNull Paint paint) {
        kotlin.jvm.internal.t.i(paint, "paint");
        this.internalCanvas.drawLine(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10), Offset.m1367getXimpl(j11), Offset.m1368getYimpl(j11), paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public /* synthetic */ void drawOval(androidx.compose.ui.geometry.Rect rect, Paint paint) {
        a1.d(this, rect, paint);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawPath(@NotNull Path path, @NotNull Paint paint) {
        kotlin.jvm.internal.t.i(path, "path");
        kotlin.jvm.internal.t.i(paint, "paint");
        android.graphics.Canvas canvas = this.internalCanvas;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.drawPath(((AndroidPath) path).getInternalPath(), paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawPoints-O7TthRY, reason: not valid java name */
    public void mo1469drawPointsO7TthRY(int i10, @NotNull List<Offset> points, @NotNull Paint paint) {
        kotlin.jvm.internal.t.i(points, "points");
        kotlin.jvm.internal.t.i(paint, "paint");
        PointMode.Companion companion = PointMode.Companion;
        if (PointMode.m1842equalsimpl0(i10, companion.m1846getLinesr_lszbg())) {
            drawLines(points, paint, 2);
        } else if (PointMode.m1842equalsimpl0(i10, companion.m1848getPolygonr_lszbg())) {
            drawLines(points, paint, 1);
        } else if (PointMode.m1842equalsimpl0(i10, companion.m1847getPointsr_lszbg())) {
            drawPoints(points, paint);
        }
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawRawPoints-O7TthRY, reason: not valid java name */
    public void mo1470drawRawPointsO7TthRY(int i10, @NotNull float[] points, @NotNull Paint paint) {
        kotlin.jvm.internal.t.i(points, "points");
        kotlin.jvm.internal.t.i(paint, "paint");
        if (points.length % 2 != 0) {
            throw new IllegalArgumentException("points must have an even number of values");
        }
        PointMode.Companion companion = PointMode.Companion;
        if (PointMode.m1842equalsimpl0(i10, companion.m1846getLinesr_lszbg())) {
            drawRawLines(points, paint, 2);
        } else if (PointMode.m1842equalsimpl0(i10, companion.m1848getPolygonr_lszbg())) {
            drawRawLines(points, paint, 1);
        } else if (PointMode.m1842equalsimpl0(i10, companion.m1847getPointsr_lszbg())) {
            drawRawPoints(points, paint, 2);
        }
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public /* synthetic */ void drawRect(androidx.compose.ui.geometry.Rect rect, Paint paint) {
        a1.e(this, rect, paint);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawRoundRect(float f10, float f11, float f12, float f13, float f14, float f15, @NotNull Paint paint) {
        kotlin.jvm.internal.t.i(paint, "paint");
        this.internalCanvas.drawRoundRect(f10, f11, f12, f13, f14, f15, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawVertices-TPEHhCM, reason: not valid java name */
    public void mo1471drawVerticesTPEHhCM(@NotNull Vertices vertices, int i10, @NotNull Paint paint) {
        kotlin.jvm.internal.t.i(vertices, "vertices");
        kotlin.jvm.internal.t.i(paint, "paint");
        this.internalCanvas.drawVertices(AndroidVertexMode_androidKt.m1512toAndroidVertexModeJOOmi9M(vertices.m1934getVertexModec2xauaI()), vertices.getPositions().length, vertices.getPositions(), 0, vertices.getTextureCoordinates(), 0, vertices.getColors(), 0, vertices.getIndices(), 0, vertices.getIndices().length, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void enableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, true);
    }

    @NotNull
    public final android.graphics.Canvas getInternalCanvas() {
        return this.internalCanvas;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void restore() {
        this.internalCanvas.restore();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void rotate(float f10) {
        this.internalCanvas.rotate(f10);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void save() {
        this.internalCanvas.save();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void saveLayer(@NotNull androidx.compose.ui.geometry.Rect bounds, @NotNull Paint paint) {
        kotlin.jvm.internal.t.i(bounds, "bounds");
        kotlin.jvm.internal.t.i(paint, "paint");
        this.internalCanvas.saveLayer(bounds.getLeft(), bounds.getTop(), bounds.getRight(), bounds.getBottom(), paint.asFrameworkPaint(), 31);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void scale(float f10, float f11) {
        this.internalCanvas.scale(f10, f11);
    }

    public final void setInternalCanvas(@NotNull android.graphics.Canvas canvas) {
        kotlin.jvm.internal.t.i(canvas, "<set-?>");
        this.internalCanvas = canvas;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void skew(float f10, float f11) {
        this.internalCanvas.skew(f10, f11);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public /* synthetic */ void skewRad(float f10, float f11) {
        a1.f(this, f10, f11);
    }

    @NotNull
    /* JADX INFO: renamed from: toRegionOp--7u2Bmg, reason: not valid java name */
    public final Region.Op m1472toRegionOp7u2Bmg(int i10) {
        return ClipOp.m1582equalsimpl0(i10, ClipOp.Companion.m1586getDifferencertfAjoo()) ? Region.Op.DIFFERENCE : Region.Op.INTERSECT;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void translate(float f10, float f11) {
        this.internalCanvas.translate(f10, f11);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawArc(float f10, float f11, float f12, float f13, float f14, float f15, boolean z10, @NotNull Paint paint) {
        kotlin.jvm.internal.t.i(paint, "paint");
        this.internalCanvas.drawArc(f10, f11, f12, f13, f14, f15, z10, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawOval(float f10, float f11, float f12, float f13, @NotNull Paint paint) {
        kotlin.jvm.internal.t.i(paint, "paint");
        this.internalCanvas.drawOval(f10, f11, f12, f13, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawRect(float f10, float f11, float f12, float f13, @NotNull Paint paint) {
        kotlin.jvm.internal.t.i(paint, "paint");
        this.internalCanvas.drawRect(f10, f11, f12, f13, paint.asFrameworkPaint());
    }

    public static /* synthetic */ void getInternalCanvas$annotations() {
    }
}

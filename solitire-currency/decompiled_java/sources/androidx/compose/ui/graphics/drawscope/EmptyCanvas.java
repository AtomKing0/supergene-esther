package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Vertices;
import androidx.compose.ui.graphics.a1;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EmptyCanvas.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EmptyCanvas implements Canvas {
    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: clipPath-mtrdD-E */
    public void mo1461clipPathmtrdDE(@NotNull Path path, int i10) {
        t.i(path, "path");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: clipRect-N_I0leg */
    public void mo1462clipRectN_I0leg(float f10, float f11, float f12, float f13, int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: clipRect-mtrdD-E */
    public /* synthetic */ void mo1463clipRectmtrdDE(Rect rect, int i10) {
        a1.a(this, rect, i10);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: concat-58bKbWc */
    public void mo1464concat58bKbWc(@NotNull float[] matrix) {
        t.i(matrix, "matrix");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void disableZ() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public /* synthetic */ void drawArc(Rect rect, float f10, float f11, boolean z10, Paint paint) {
        a1.b(this, rect, f10, f11, z10, paint);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public /* synthetic */ void drawArcRad(Rect rect, float f10, float f11, boolean z10, Paint paint) {
        a1.c(this, rect, f10, f11, z10, paint);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawCircle-9KIMszo */
    public void mo1465drawCircle9KIMszo(long j10, float f10, @NotNull Paint paint) {
        t.i(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawImage-d-4ec7I */
    public void mo1466drawImaged4ec7I(@NotNull ImageBitmap image, long j10, @NotNull Paint paint) {
        t.i(image, "image");
        t.i(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawImageRect-HPBpro0 */
    public void mo1467drawImageRectHPBpro0(@NotNull ImageBitmap image, long j10, long j11, long j12, long j13, @NotNull Paint paint) {
        t.i(image, "image");
        t.i(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawLine-Wko1d7g */
    public void mo1468drawLineWko1d7g(long j10, long j11, @NotNull Paint paint) {
        t.i(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public /* synthetic */ void drawOval(Rect rect, Paint paint) {
        a1.d(this, rect, paint);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawPath(@NotNull Path path, @NotNull Paint paint) {
        t.i(path, "path");
        t.i(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawPoints-O7TthRY */
    public void mo1469drawPointsO7TthRY(int i10, @NotNull List<Offset> points, @NotNull Paint paint) {
        t.i(points, "points");
        t.i(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawRawPoints-O7TthRY */
    public void mo1470drawRawPointsO7TthRY(int i10, @NotNull float[] points, @NotNull Paint paint) {
        t.i(points, "points");
        t.i(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public /* synthetic */ void drawRect(Rect rect, Paint paint) {
        a1.e(this, rect, paint);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawRoundRect(float f10, float f11, float f12, float f13, float f14, float f15, @NotNull Paint paint) {
        t.i(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawVertices-TPEHhCM */
    public void mo1471drawVerticesTPEHhCM(@NotNull Vertices vertices, int i10, @NotNull Paint paint) {
        t.i(vertices, "vertices");
        t.i(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void enableZ() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void restore() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void rotate(float f10) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void save() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void saveLayer(@NotNull Rect bounds, @NotNull Paint paint) {
        t.i(bounds, "bounds");
        t.i(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void scale(float f10, float f11) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void skew(float f10, float f11) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public /* synthetic */ void skewRad(float f10, float f11) {
        a1.f(this, f10, f11);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void translate(float f10, float f11) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawArc(float f10, float f11, float f12, float f13, float f14, float f15, boolean z10, @NotNull Paint paint) {
        t.i(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawOval(float f10, float f11, float f12, float f13, @NotNull Paint paint) {
        t.i(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawRect(float f10, float f11, float f12, float f13, @NotNull Paint paint) {
        t.i(paint, "paint");
        throw new UnsupportedOperationException();
    }
}

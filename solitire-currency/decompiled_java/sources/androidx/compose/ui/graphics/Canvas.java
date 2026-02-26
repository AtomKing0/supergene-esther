package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Canvas.kt */
/* JADX INFO: loaded from: classes.dex */
public interface Canvas {

    /* JADX INFO: compiled from: Canvas.kt */
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: clipRect-mtrdD-E, reason: not valid java name */
        public static void m1576clipRectmtrdDE(@NotNull Canvas canvas, @NotNull Rect rect, int i10) {
            kotlin.jvm.internal.t.i(rect, "rect");
            a1.a(canvas, rect, i10);
        }

        @Deprecated
        public static void drawArc(@NotNull Canvas canvas, @NotNull Rect rect, float f10, float f11, boolean z10, @NotNull Paint paint) {
            kotlin.jvm.internal.t.i(rect, "rect");
            kotlin.jvm.internal.t.i(paint, "paint");
            a1.b(canvas, rect, f10, f11, z10, paint);
        }

        @Deprecated
        public static void drawArcRad(@NotNull Canvas canvas, @NotNull Rect rect, float f10, float f11, boolean z10, @NotNull Paint paint) {
            kotlin.jvm.internal.t.i(rect, "rect");
            kotlin.jvm.internal.t.i(paint, "paint");
            a1.c(canvas, rect, f10, f11, z10, paint);
        }

        @Deprecated
        public static void drawOval(@NotNull Canvas canvas, @NotNull Rect rect, @NotNull Paint paint) {
            kotlin.jvm.internal.t.i(rect, "rect");
            kotlin.jvm.internal.t.i(paint, "paint");
            a1.d(canvas, rect, paint);
        }

        @Deprecated
        public static void drawRect(@NotNull Canvas canvas, @NotNull Rect rect, @NotNull Paint paint) {
            kotlin.jvm.internal.t.i(rect, "rect");
            kotlin.jvm.internal.t.i(paint, "paint");
            a1.e(canvas, rect, paint);
        }

        @Deprecated
        public static void skewRad(@NotNull Canvas canvas, float f10, float f11) {
            a1.f(canvas, f10, f11);
        }
    }

    /* JADX INFO: renamed from: clipPath-mtrdD-E */
    void mo1461clipPathmtrdDE(@NotNull Path path, int i10);

    /* JADX INFO: renamed from: clipRect-N_I0leg */
    void mo1462clipRectN_I0leg(float f10, float f11, float f12, float f13, int i10);

    /* JADX INFO: renamed from: clipRect-mtrdD-E */
    void mo1463clipRectmtrdDE(@NotNull Rect rect, int i10);

    /* JADX INFO: renamed from: concat-58bKbWc */
    void mo1464concat58bKbWc(@NotNull float[] fArr);

    void disableZ();

    void drawArc(float f10, float f11, float f12, float f13, float f14, float f15, boolean z10, @NotNull Paint paint);

    void drawArc(@NotNull Rect rect, float f10, float f11, boolean z10, @NotNull Paint paint);

    void drawArcRad(@NotNull Rect rect, float f10, float f11, boolean z10, @NotNull Paint paint);

    /* JADX INFO: renamed from: drawCircle-9KIMszo */
    void mo1465drawCircle9KIMszo(long j10, float f10, @NotNull Paint paint);

    /* JADX INFO: renamed from: drawImage-d-4ec7I */
    void mo1466drawImaged4ec7I(@NotNull ImageBitmap imageBitmap, long j10, @NotNull Paint paint);

    /* JADX INFO: renamed from: drawImageRect-HPBpro0 */
    void mo1467drawImageRectHPBpro0(@NotNull ImageBitmap imageBitmap, long j10, long j11, long j12, long j13, @NotNull Paint paint);

    /* JADX INFO: renamed from: drawLine-Wko1d7g */
    void mo1468drawLineWko1d7g(long j10, long j11, @NotNull Paint paint);

    void drawOval(float f10, float f11, float f12, float f13, @NotNull Paint paint);

    void drawOval(@NotNull Rect rect, @NotNull Paint paint);

    void drawPath(@NotNull Path path, @NotNull Paint paint);

    /* JADX INFO: renamed from: drawPoints-O7TthRY */
    void mo1469drawPointsO7TthRY(int i10, @NotNull List<Offset> list, @NotNull Paint paint);

    /* JADX INFO: renamed from: drawRawPoints-O7TthRY */
    void mo1470drawRawPointsO7TthRY(int i10, @NotNull float[] fArr, @NotNull Paint paint);

    void drawRect(float f10, float f11, float f12, float f13, @NotNull Paint paint);

    void drawRect(@NotNull Rect rect, @NotNull Paint paint);

    void drawRoundRect(float f10, float f11, float f12, float f13, float f14, float f15, @NotNull Paint paint);

    /* JADX INFO: renamed from: drawVertices-TPEHhCM */
    void mo1471drawVerticesTPEHhCM(@NotNull Vertices vertices, int i10, @NotNull Paint paint);

    void enableZ();

    void restore();

    void rotate(float f10);

    void save();

    void saveLayer(@NotNull Rect rect, @NotNull Paint paint);

    void scale(float f10, float f11);

    void skew(float f10, float f11);

    void skewRad(float f10, float f11);

    void translate(float f10, float f11);
}

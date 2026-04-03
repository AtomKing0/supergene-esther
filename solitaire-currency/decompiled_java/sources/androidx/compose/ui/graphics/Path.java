package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Path.kt */
/* JADX INFO: loaded from: classes.dex */
public interface Path {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: Path.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @NotNull
        /* JADX INFO: renamed from: combine-xh6zSI8, reason: not valid java name */
        public final Path m1814combinexh6zSI8(int i10, @NotNull Path path1, @NotNull Path path2) {
            kotlin.jvm.internal.t.i(path1, "path1");
            kotlin.jvm.internal.t.i(path2, "path2");
            Path Path = AndroidPath_androidKt.Path();
            if (Path.mo1501opN5in7k0(path1, path2, i10)) {
                return Path;
            }
            throw new IllegalArgumentException("Path.combine() failed.  This may be due an invalid path; in particular, check for NaN values.");
        }
    }

    /* JADX INFO: compiled from: Path.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static void arcToRad(@NotNull Path path, @NotNull Rect rect, float f10, float f11, boolean z10) {
            kotlin.jvm.internal.t.i(rect, "rect");
            f1.a(path, rect, f10, f11, z10);
        }
    }

    void addArc(@NotNull Rect rect, float f10, float f11);

    void addArcRad(@NotNull Rect rect, float f10, float f11);

    void addOval(@NotNull Rect rect);

    /* JADX INFO: renamed from: addPath-Uv8p0NA */
    void mo1499addPathUv8p0NA(@NotNull Path path, long j10);

    void addRect(@NotNull Rect rect);

    void addRoundRect(@NotNull RoundRect roundRect);

    void arcTo(@NotNull Rect rect, float f10, float f11, boolean z10);

    void arcToRad(@NotNull Rect rect, float f10, float f11, boolean z10);

    void close();

    void cubicTo(float f10, float f11, float f12, float f13, float f14, float f15);

    @NotNull
    Rect getBounds();

    /* JADX INFO: renamed from: getFillType-Rg-k1Os */
    int mo1500getFillTypeRgk1Os();

    boolean isConvex();

    boolean isEmpty();

    void lineTo(float f10, float f11);

    void moveTo(float f10, float f11);

    /* JADX INFO: renamed from: op-N5in7k0 */
    boolean mo1501opN5in7k0(@NotNull Path path, @NotNull Path path2, int i10);

    void quadraticBezierTo(float f10, float f11, float f12, float f13);

    void relativeCubicTo(float f10, float f11, float f12, float f13, float f14, float f15);

    void relativeLineTo(float f10, float f11);

    void relativeMoveTo(float f10, float f11);

    void relativeQuadraticBezierTo(float f10, float f11, float f12, float f13);

    void reset();

    /* JADX INFO: renamed from: setFillType-oQ8Xj4U */
    void mo1502setFillTypeoQ8Xj4U(int i10);

    /* JADX INFO: renamed from: translate-k-4lQ0M */
    void mo1503translatek4lQ0M(long j10);
}

package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DrawScope.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b {
    static {
        DrawScope.Companion companion = DrawScope.Companion;
    }

    public static /* synthetic */ void A(DrawScope drawScope, ImageBitmap imageBitmap, long j10, float f10, DrawStyle drawStyle, ColorFilter colorFilter, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-gbVJVH8");
        }
        drawScope.mo1982drawImagegbVJVH8(imageBitmap, (i11 & 2) != 0 ? Offset.Companion.m1383getZeroF1C5BW0() : j10, (i11 & 4) != 0 ? 1.0f : f10, (i11 & 8) != 0 ? Fill.INSTANCE : drawStyle, (i11 & 16) != 0 ? null : colorFilter, (i11 & 32) != 0 ? DrawScope.Companion.m2026getDefaultBlendMode0nO6VwU() : i10);
    }

    public static /* synthetic */ void B(DrawScope drawScope, Brush brush, long j10, long j11, float f10, int i10, PathEffect pathEffect, float f11, ColorFilter colorFilter, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-1RTmtNc");
        }
        drawScope.mo1983drawLine1RTmtNc(brush, j10, j11, (i12 & 8) != 0 ? 0.0f : f10, (i12 & 16) != 0 ? Stroke.Companion.m2085getDefaultCapKaPHkGw() : i10, (i12 & 32) != 0 ? null : pathEffect, (i12 & 64) != 0 ? 1.0f : f11, (i12 & 128) != 0 ? null : colorFilter, (i12 & 256) != 0 ? DrawScope.Companion.m2026getDefaultBlendMode0nO6VwU() : i11);
    }

    public static /* synthetic */ void C(DrawScope drawScope, long j10, long j11, long j12, float f10, int i10, PathEffect pathEffect, float f11, ColorFilter colorFilter, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-NGM6Ib0");
        }
        drawScope.mo1984drawLineNGM6Ib0(j10, j11, j12, (i12 & 8) != 0 ? 0.0f : f10, (i12 & 16) != 0 ? Stroke.Companion.m2085getDefaultCapKaPHkGw() : i10, (i12 & 32) != 0 ? null : pathEffect, (i12 & 64) != 0 ? 1.0f : f11, (i12 & 128) != 0 ? null : colorFilter, (i12 & 256) != 0 ? DrawScope.Companion.m2026getDefaultBlendMode0nO6VwU() : i11);
    }

    public static /* synthetic */ void D(DrawScope drawScope, Brush brush, long j10, long j11, float f10, DrawStyle drawStyle, ColorFilter colorFilter, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-AsUm42w");
        }
        long jM1383getZeroF1C5BW0 = (i11 & 2) != 0 ? Offset.Companion.m1383getZeroF1C5BW0() : j10;
        drawScope.mo1985drawOvalAsUm42w(brush, jM1383getZeroF1C5BW0, (i11 & 4) != 0 ? d(drawScope, drawScope.mo1996getSizeNHjbRc(), jM1383getZeroF1C5BW0) : j11, (i11 & 8) != 0 ? 1.0f : f10, (i11 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i11 & 32) != 0 ? null : colorFilter, (i11 & 64) != 0 ? DrawScope.Companion.m2026getDefaultBlendMode0nO6VwU() : i10);
    }

    public static /* synthetic */ void E(DrawScope drawScope, long j10, long j11, long j12, float f10, DrawStyle drawStyle, ColorFilter colorFilter, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-n-J9OG0");
        }
        long jM1383getZeroF1C5BW0 = (i11 & 2) != 0 ? Offset.Companion.m1383getZeroF1C5BW0() : j11;
        drawScope.mo1986drawOvalnJ9OG0(j10, jM1383getZeroF1C5BW0, (i11 & 4) != 0 ? d(drawScope, drawScope.mo1996getSizeNHjbRc(), jM1383getZeroF1C5BW0) : j12, (i11 & 8) != 0 ? 1.0f : f10, (i11 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i11 & 32) != 0 ? null : colorFilter, (i11 & 64) != 0 ? DrawScope.Companion.m2026getDefaultBlendMode0nO6VwU() : i10);
    }

    public static /* synthetic */ void F(DrawScope drawScope, Path path, Brush brush, float f10, DrawStyle drawStyle, ColorFilter colorFilter, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-GBMwjPU");
        }
        if ((i11 & 4) != 0) {
            f10 = 1.0f;
        }
        float f11 = f10;
        if ((i11 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i11 & 16) != 0) {
            colorFilter = null;
        }
        ColorFilter colorFilter2 = colorFilter;
        if ((i11 & 32) != 0) {
            i10 = DrawScope.Companion.m2026getDefaultBlendMode0nO6VwU();
        }
        drawScope.mo1987drawPathGBMwjPU(path, brush, f11, drawStyle2, colorFilter2, i10);
    }

    public static /* synthetic */ void G(DrawScope drawScope, Path path, long j10, float f10, DrawStyle drawStyle, ColorFilter colorFilter, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-LG529CI");
        }
        drawScope.mo1988drawPathLG529CI(path, j10, (i11 & 4) != 0 ? 1.0f : f10, (i11 & 8) != 0 ? Fill.INSTANCE : drawStyle, (i11 & 16) != 0 ? null : colorFilter, (i11 & 32) != 0 ? DrawScope.Companion.m2026getDefaultBlendMode0nO6VwU() : i10);
    }

    public static /* synthetic */ void H(DrawScope drawScope, List list, int i10, long j10, float f10, int i11, PathEffect pathEffect, float f11, ColorFilter colorFilter, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-F8ZwMP8");
        }
        drawScope.mo1989drawPointsF8ZwMP8(list, i10, j10, (i13 & 8) != 0 ? 0.0f : f10, (i13 & 16) != 0 ? StrokeCap.Companion.m1885getButtKaPHkGw() : i11, (i13 & 32) != 0 ? null : pathEffect, (i13 & 64) != 0 ? 1.0f : f11, (i13 & 128) != 0 ? null : colorFilter, (i13 & 256) != 0 ? DrawScope.Companion.m2026getDefaultBlendMode0nO6VwU() : i12);
    }

    public static /* synthetic */ void I(DrawScope drawScope, List list, int i10, Brush brush, float f10, int i11, PathEffect pathEffect, float f11, ColorFilter colorFilter, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-Gsft0Ws");
        }
        drawScope.mo1990drawPointsGsft0Ws(list, i10, brush, (i13 & 8) != 0 ? 0.0f : f10, (i13 & 16) != 0 ? StrokeCap.Companion.m1885getButtKaPHkGw() : i11, (i13 & 32) != 0 ? null : pathEffect, (i13 & 64) != 0 ? 1.0f : f11, (i13 & 128) != 0 ? null : colorFilter, (i13 & 256) != 0 ? DrawScope.Companion.m2026getDefaultBlendMode0nO6VwU() : i12);
    }

    public static /* synthetic */ void J(DrawScope drawScope, Brush brush, long j10, long j11, float f10, DrawStyle drawStyle, ColorFilter colorFilter, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-AsUm42w");
        }
        long jM1383getZeroF1C5BW0 = (i11 & 2) != 0 ? Offset.Companion.m1383getZeroF1C5BW0() : j10;
        drawScope.mo1991drawRectAsUm42w(brush, jM1383getZeroF1C5BW0, (i11 & 4) != 0 ? d(drawScope, drawScope.mo1996getSizeNHjbRc(), jM1383getZeroF1C5BW0) : j11, (i11 & 8) != 0 ? 1.0f : f10, (i11 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i11 & 32) != 0 ? null : colorFilter, (i11 & 64) != 0 ? DrawScope.Companion.m2026getDefaultBlendMode0nO6VwU() : i10);
    }

    public static /* synthetic */ void K(DrawScope drawScope, long j10, long j11, long j12, float f10, DrawStyle drawStyle, ColorFilter colorFilter, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-n-J9OG0");
        }
        long jM1383getZeroF1C5BW0 = (i11 & 2) != 0 ? Offset.Companion.m1383getZeroF1C5BW0() : j11;
        drawScope.mo1992drawRectnJ9OG0(j10, jM1383getZeroF1C5BW0, (i11 & 4) != 0 ? d(drawScope, drawScope.mo1996getSizeNHjbRc(), jM1383getZeroF1C5BW0) : j12, (i11 & 8) != 0 ? 1.0f : f10, (i11 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i11 & 32) != 0 ? null : colorFilter, (i11 & 64) != 0 ? DrawScope.Companion.m2026getDefaultBlendMode0nO6VwU() : i10);
    }

    public static /* synthetic */ void L(DrawScope drawScope, Brush brush, long j10, long j11, long j12, float f10, DrawStyle drawStyle, ColorFilter colorFilter, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-ZuiqVtQ");
        }
        long jM1383getZeroF1C5BW0 = (i11 & 2) != 0 ? Offset.Companion.m1383getZeroF1C5BW0() : j10;
        drawScope.mo1993drawRoundRectZuiqVtQ(brush, jM1383getZeroF1C5BW0, (i11 & 4) != 0 ? d(drawScope, drawScope.mo1996getSizeNHjbRc(), jM1383getZeroF1C5BW0) : j11, (i11 & 8) != 0 ? CornerRadius.Companion.m1352getZerokKHJgLs() : j12, (i11 & 16) != 0 ? 1.0f : f10, (i11 & 32) != 0 ? Fill.INSTANCE : drawStyle, (i11 & 64) != 0 ? null : colorFilter, (i11 & 128) != 0 ? DrawScope.Companion.m2026getDefaultBlendMode0nO6VwU() : i10);
    }

    public static /* synthetic */ void M(DrawScope drawScope, long j10, long j11, long j12, long j13, DrawStyle drawStyle, float f10, ColorFilter colorFilter, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-u-Aw5IA");
        }
        long jM1383getZeroF1C5BW0 = (i11 & 2) != 0 ? Offset.Companion.m1383getZeroF1C5BW0() : j11;
        drawScope.mo1994drawRoundRectuAw5IA(j10, jM1383getZeroF1C5BW0, (i11 & 4) != 0 ? d(drawScope, drawScope.mo1996getSizeNHjbRc(), jM1383getZeroF1C5BW0) : j12, (i11 & 8) != 0 ? CornerRadius.Companion.m1352getZerokKHJgLs() : j13, (i11 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i11 & 32) != 0 ? 1.0f : f10, (i11 & 64) != 0 ? null : colorFilter, (i11 & 128) != 0 ? DrawScope.Companion.m2026getDefaultBlendMode0nO6VwU() : i10);
    }

    public static void a(DrawScope drawScope, @NotNull ImageBitmap image, long j10, long j11, long j12, long j13, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10, int i11) {
        t.i(image, "image");
        t.i(style, "style");
        z(drawScope, image, j10, j11, j12, j13, f10, style, colorFilter, i10, 0, 512, null);
    }

    public static long b(DrawScope drawScope) {
        return SizeKt.m1446getCenteruvyYCjk(drawScope.getDrawContext().mo2002getSizeNHjbRc());
    }

    public static long c(DrawScope drawScope) {
        return drawScope.getDrawContext().mo2002getSizeNHjbRc();
    }

    public static long d(DrawScope drawScope, long j10, long j11) {
        return SizeKt.Size(Size.m1436getWidthimpl(j10) - Offset.m1367getXimpl(j11), Size.m1433getHeightimpl(j10) - Offset.m1368getYimpl(j11));
    }

    public static /* synthetic */ void u(DrawScope drawScope, Brush brush, float f10, float f11, boolean z10, long j10, long j11, float f12, DrawStyle drawStyle, ColorFilter colorFilter, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-illE91I");
        }
        long jM1383getZeroF1C5BW0 = (i11 & 16) != 0 ? Offset.Companion.m1383getZeroF1C5BW0() : j10;
        drawScope.mo1976drawArcillE91I(brush, f10, f11, z10, jM1383getZeroF1C5BW0, (i11 & 32) != 0 ? d(drawScope, drawScope.mo1996getSizeNHjbRc(), jM1383getZeroF1C5BW0) : j11, (i11 & 64) != 0 ? 1.0f : f12, (i11 & 128) != 0 ? Fill.INSTANCE : drawStyle, (i11 & 256) != 0 ? null : colorFilter, (i11 & 512) != 0 ? DrawScope.Companion.m2026getDefaultBlendMode0nO6VwU() : i10);
    }

    public static /* synthetic */ void v(DrawScope drawScope, long j10, float f10, float f11, boolean z10, long j11, long j12, float f12, DrawStyle drawStyle, ColorFilter colorFilter, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-yD3GUKo");
        }
        long jM1383getZeroF1C5BW0 = (i11 & 16) != 0 ? Offset.Companion.m1383getZeroF1C5BW0() : j11;
        drawScope.mo1977drawArcyD3GUKo(j10, f10, f11, z10, jM1383getZeroF1C5BW0, (i11 & 32) != 0 ? d(drawScope, drawScope.mo1996getSizeNHjbRc(), jM1383getZeroF1C5BW0) : j12, (i11 & 64) != 0 ? 1.0f : f12, (i11 & 128) != 0 ? Fill.INSTANCE : drawStyle, (i11 & 256) != 0 ? null : colorFilter, (i11 & 512) != 0 ? DrawScope.Companion.m2026getDefaultBlendMode0nO6VwU() : i10);
    }

    public static /* synthetic */ void w(DrawScope drawScope, Brush brush, float f10, long j10, float f11, DrawStyle drawStyle, ColorFilter colorFilter, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-V9BoPsw");
        }
        drawScope.mo1978drawCircleV9BoPsw(brush, (i11 & 2) != 0 ? Size.m1435getMinDimensionimpl(drawScope.mo1996getSizeNHjbRc()) / 2.0f : f10, (i11 & 4) != 0 ? drawScope.mo1995getCenterF1C5BW0() : j10, (i11 & 8) != 0 ? 1.0f : f11, (i11 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i11 & 32) != 0 ? null : colorFilter, (i11 & 64) != 0 ? DrawScope.Companion.m2026getDefaultBlendMode0nO6VwU() : i10);
    }

    public static /* synthetic */ void x(DrawScope drawScope, long j10, float f10, long j11, float f11, DrawStyle drawStyle, ColorFilter colorFilter, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-VaOC9Bg");
        }
        drawScope.mo1979drawCircleVaOC9Bg(j10, (i11 & 2) != 0 ? Size.m1435getMinDimensionimpl(drawScope.mo1996getSizeNHjbRc()) / 2.0f : f10, (i11 & 4) != 0 ? drawScope.mo1995getCenterF1C5BW0() : j11, (i11 & 8) != 0 ? 1.0f : f11, (i11 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i11 & 32) != 0 ? null : colorFilter, (i11 & 64) != 0 ? DrawScope.Companion.m2026getDefaultBlendMode0nO6VwU() : i10);
    }

    public static /* synthetic */ void y(DrawScope drawScope, ImageBitmap imageBitmap, long j10, long j11, long j12, long j13, float f10, DrawStyle drawStyle, ColorFilter colorFilter, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-9jGpkUE");
        }
        long jM3801getZeronOccac = (i11 & 2) != 0 ? IntOffset.Companion.m3801getZeronOccac() : j10;
        long jIntSize = (i11 & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j11;
        drawScope.mo1980drawImage9jGpkUE(imageBitmap, jM3801getZeronOccac, jIntSize, (i11 & 8) != 0 ? IntOffset.Companion.m3801getZeronOccac() : j12, (i11 & 16) != 0 ? jIntSize : j13, (i11 & 32) != 0 ? 1.0f : f10, (i11 & 64) != 0 ? Fill.INSTANCE : drawStyle, (i11 & 128) != 0 ? null : colorFilter, (i11 & 256) != 0 ? DrawScope.Companion.m2026getDefaultBlendMode0nO6VwU() : i10);
    }

    public static /* synthetic */ void z(DrawScope drawScope, ImageBitmap imageBitmap, long j10, long j11, long j12, long j13, float f10, DrawStyle drawStyle, ColorFilter colorFilter, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-AZ2fEMs");
        }
        long jM3801getZeronOccac = (i12 & 2) != 0 ? IntOffset.Companion.m3801getZeronOccac() : j10;
        long jIntSize = (i12 & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j11;
        drawScope.mo1981drawImageAZ2fEMs(imageBitmap, jM3801getZeronOccac, jIntSize, (i12 & 8) != 0 ? IntOffset.Companion.m3801getZeronOccac() : j12, (i12 & 16) != 0 ? jIntSize : j13, (i12 & 32) != 0 ? 1.0f : f10, (i12 & 64) != 0 ? Fill.INSTANCE : drawStyle, (i12 & 128) != 0 ? null : colorFilter, (i12 & 256) != 0 ? DrawScope.Companion.m2026getDefaultBlendMode0nO6VwU() : i10, (i12 & 512) != 0 ? DrawScope.Companion.m2027getDefaultFilterQualityfv9h1I() : i11);
    }
}

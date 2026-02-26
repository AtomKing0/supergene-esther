package androidx.compose.ui.graphics.drawscope;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DrawScope.kt */
/* JADX INFO: loaded from: classes.dex */
@DrawScopeMarker
public interface DrawScope extends Density {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: DrawScope.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final int DefaultBlendMode = BlendMode.Companion.m1548getSrcOver0nO6VwU();
        private static final int DefaultFilterQuality = FilterQuality.Companion.m1684getLowfv9h1I();

        private Companion() {
        }

        /* JADX INFO: renamed from: getDefaultBlendMode-0nO6VwU, reason: not valid java name */
        public final int m2026getDefaultBlendMode0nO6VwU() {
            return DefaultBlendMode;
        }

        /* JADX INFO: renamed from: getDefaultFilterQuality-f-v9h1I, reason: not valid java name */
        public final int m2027getDefaultFilterQualityfv9h1I() {
            return DefaultFilterQuality;
        }
    }

    /* JADX INFO: compiled from: DrawScope.kt */
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
        public static void m2033drawImageAZ2fEMs(@NotNull DrawScope drawScope, @NotNull ImageBitmap image, long j10, long j11, long j12, long j13, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10, int i11) {
            t.i(image, "image");
            t.i(style, "style");
            b.a(drawScope, image, j10, j11, j12, j13, f10, style, colorFilter, i10, i11);
        }

        @Deprecated
        /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m2048getCenterF1C5BW0(@NotNull DrawScope drawScope) {
            return b.b(drawScope);
        }

        @Deprecated
        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m2049getSizeNHjbRc(@NotNull DrawScope drawScope) {
            return b.c(drawScope);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m2050roundToPxR2X_6o(@NotNull DrawScope drawScope, long j10) {
            return androidx.compose.ui.unit.a.a(drawScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m2051roundToPx0680j_4(@NotNull DrawScope drawScope, float f10) {
            return androidx.compose.ui.unit.a.b(drawScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m2052toDpGaN1DYA(@NotNull DrawScope drawScope, long j10) {
            return androidx.compose.ui.unit.a.c(drawScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m2053toDpu2uoSUM(@NotNull DrawScope drawScope, float f10) {
            return androidx.compose.ui.unit.a.d(drawScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m2055toDpSizekrfVVM(@NotNull DrawScope drawScope, long j10) {
            return androidx.compose.ui.unit.a.f(drawScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m2056toPxR2X_6o(@NotNull DrawScope drawScope, long j10) {
            return androidx.compose.ui.unit.a.g(drawScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m2057toPx0680j_4(@NotNull DrawScope drawScope, float f10) {
            return androidx.compose.ui.unit.a.h(drawScope, f10);
        }

        @Stable
        @Deprecated
        @NotNull
        public static Rect toRect(@NotNull DrawScope drawScope, @NotNull DpRect receiver) {
            t.i(receiver, "receiver");
            return androidx.compose.ui.unit.a.i(drawScope, receiver);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m2058toSizeXkaWNTQ(@NotNull DrawScope drawScope, long j10) {
            return androidx.compose.ui.unit.a.j(drawScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m2059toSp0xMU5do(@NotNull DrawScope drawScope, float f10) {
            return androidx.compose.ui.unit.a.k(drawScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m2060toSpkPz2Gy4(@NotNull DrawScope drawScope, float f10) {
            return androidx.compose.ui.unit.a.l(drawScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m2054toDpu2uoSUM(@NotNull DrawScope drawScope, int i10) {
            return androidx.compose.ui.unit.a.e(drawScope, i10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m2061toSpkPz2Gy4(@NotNull DrawScope drawScope, int i10) {
            return androidx.compose.ui.unit.a.m(drawScope, i10);
        }
    }

    /* JADX INFO: renamed from: drawArc-illE91I */
    void mo1976drawArcillE91I(@NotNull Brush brush, float f10, float f11, boolean z10, long j10, long j11, float f12, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i10);

    /* JADX INFO: renamed from: drawArc-yD3GUKo */
    void mo1977drawArcyD3GUKo(long j10, float f10, float f11, boolean z10, long j11, long j12, float f12, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i10);

    /* JADX INFO: renamed from: drawCircle-V9BoPsw */
    void mo1978drawCircleV9BoPsw(@NotNull Brush brush, float f10, long j10, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i10);

    /* JADX INFO: renamed from: drawCircle-VaOC9Bg */
    void mo1979drawCircleVaOC9Bg(long j10, float f10, long j11, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i10);

    /* JADX INFO: renamed from: drawImage-9jGpkUE */
    /* synthetic */ void mo1980drawImage9jGpkUE(ImageBitmap imageBitmap, long j10, long j11, long j12, long j13, float f10, DrawStyle drawStyle, ColorFilter colorFilter, int i10);

    /* JADX INFO: renamed from: drawImage-AZ2fEMs */
    void mo1981drawImageAZ2fEMs(@NotNull ImageBitmap imageBitmap, long j10, long j11, long j12, long j13, float f10, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i10, int i11);

    /* JADX INFO: renamed from: drawImage-gbVJVH8 */
    void mo1982drawImagegbVJVH8(@NotNull ImageBitmap imageBitmap, long j10, float f10, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i10);

    /* JADX INFO: renamed from: drawLine-1RTmtNc */
    void mo1983drawLine1RTmtNc(@NotNull Brush brush, long j10, long j11, float f10, int i10, @Nullable PathEffect pathEffect, float f11, @Nullable ColorFilter colorFilter, int i11);

    /* JADX INFO: renamed from: drawLine-NGM6Ib0 */
    void mo1984drawLineNGM6Ib0(long j10, long j11, long j12, float f10, int i10, @Nullable PathEffect pathEffect, float f11, @Nullable ColorFilter colorFilter, int i11);

    /* JADX INFO: renamed from: drawOval-AsUm42w */
    void mo1985drawOvalAsUm42w(@NotNull Brush brush, long j10, long j11, float f10, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i10);

    /* JADX INFO: renamed from: drawOval-n-J9OG0 */
    void mo1986drawOvalnJ9OG0(long j10, long j11, long j12, float f10, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i10);

    /* JADX INFO: renamed from: drawPath-GBMwjPU */
    void mo1987drawPathGBMwjPU(@NotNull Path path, @NotNull Brush brush, float f10, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i10);

    /* JADX INFO: renamed from: drawPath-LG529CI */
    void mo1988drawPathLG529CI(@NotNull Path path, long j10, float f10, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i10);

    /* JADX INFO: renamed from: drawPoints-F8ZwMP8 */
    void mo1989drawPointsF8ZwMP8(@NotNull List<Offset> list, int i10, long j10, float f10, int i11, @Nullable PathEffect pathEffect, float f11, @Nullable ColorFilter colorFilter, int i12);

    /* JADX INFO: renamed from: drawPoints-Gsft0Ws */
    void mo1990drawPointsGsft0Ws(@NotNull List<Offset> list, int i10, @NotNull Brush brush, float f10, int i11, @Nullable PathEffect pathEffect, float f11, @Nullable ColorFilter colorFilter, int i12);

    /* JADX INFO: renamed from: drawRect-AsUm42w */
    void mo1991drawRectAsUm42w(@NotNull Brush brush, long j10, long j11, float f10, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i10);

    /* JADX INFO: renamed from: drawRect-n-J9OG0 */
    void mo1992drawRectnJ9OG0(long j10, long j11, long j12, float f10, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i10);

    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ */
    void mo1993drawRoundRectZuiqVtQ(@NotNull Brush brush, long j10, long j11, long j12, float f10, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i10);

    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA */
    void mo1994drawRoundRectuAw5IA(long j10, long j11, long j12, long j13, @NotNull DrawStyle drawStyle, float f10, @Nullable ColorFilter colorFilter, int i10);

    /* JADX INFO: renamed from: getCenter-F1C5BW0 */
    long mo1995getCenterF1C5BW0();

    @NotNull
    DrawContext getDrawContext();

    @NotNull
    LayoutDirection getLayoutDirection();

    /* JADX INFO: renamed from: getSize-NH-jbRc */
    long mo1996getSizeNHjbRc();
}

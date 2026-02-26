package androidx.compose.ui.graphics;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GraphicsLayerScope.kt */
/* JADX INFO: loaded from: classes.dex */
public interface GraphicsLayerScope extends Density {

    /* JADX INFO: compiled from: GraphicsLayerScope.kt */
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
        public static long m1744getAmbientShadowColor0d7_KjU(@NotNull GraphicsLayerScope graphicsLayerScope) {
            return d1.a(graphicsLayerScope);
        }

        @Deprecated
        @Nullable
        public static RenderEffect getRenderEffect(@NotNull GraphicsLayerScope graphicsLayerScope) {
            return d1.b(graphicsLayerScope);
        }

        @Deprecated
        /* JADX INFO: renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
        public static long m1745getSpotShadowColor0d7_KjU(@NotNull GraphicsLayerScope graphicsLayerScope) {
            return d1.c(graphicsLayerScope);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m1746roundToPxR2X_6o(@NotNull GraphicsLayerScope graphicsLayerScope, long j10) {
            return androidx.compose.ui.unit.a.a(graphicsLayerScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m1747roundToPx0680j_4(@NotNull GraphicsLayerScope graphicsLayerScope, float f10) {
            return androidx.compose.ui.unit.a.b(graphicsLayerScope, f10);
        }

        @Deprecated
        /* JADX INFO: renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
        public static void m1748setAmbientShadowColor8_81llA(@NotNull GraphicsLayerScope graphicsLayerScope, long j10) {
            d1.d(graphicsLayerScope, j10);
        }

        @Deprecated
        public static void setRenderEffect(@NotNull GraphicsLayerScope graphicsLayerScope, @Nullable RenderEffect renderEffect) {
            d1.e(graphicsLayerScope, renderEffect);
        }

        @Deprecated
        /* JADX INFO: renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
        public static void m1749setSpotShadowColor8_81llA(@NotNull GraphicsLayerScope graphicsLayerScope, long j10) {
            d1.f(graphicsLayerScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m1750toDpGaN1DYA(@NotNull GraphicsLayerScope graphicsLayerScope, long j10) {
            return androidx.compose.ui.unit.a.c(graphicsLayerScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m1751toDpu2uoSUM(@NotNull GraphicsLayerScope graphicsLayerScope, float f10) {
            return androidx.compose.ui.unit.a.d(graphicsLayerScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m1753toDpSizekrfVVM(@NotNull GraphicsLayerScope graphicsLayerScope, long j10) {
            return androidx.compose.ui.unit.a.f(graphicsLayerScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m1754toPxR2X_6o(@NotNull GraphicsLayerScope graphicsLayerScope, long j10) {
            return androidx.compose.ui.unit.a.g(graphicsLayerScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m1755toPx0680j_4(@NotNull GraphicsLayerScope graphicsLayerScope, float f10) {
            return androidx.compose.ui.unit.a.h(graphicsLayerScope, f10);
        }

        @Stable
        @Deprecated
        @NotNull
        public static Rect toRect(@NotNull GraphicsLayerScope graphicsLayerScope, @NotNull DpRect receiver) {
            kotlin.jvm.internal.t.i(receiver, "receiver");
            return androidx.compose.ui.unit.a.i(graphicsLayerScope, receiver);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m1756toSizeXkaWNTQ(@NotNull GraphicsLayerScope graphicsLayerScope, long j10) {
            return androidx.compose.ui.unit.a.j(graphicsLayerScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m1757toSp0xMU5do(@NotNull GraphicsLayerScope graphicsLayerScope, float f10) {
            return androidx.compose.ui.unit.a.k(graphicsLayerScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m1758toSpkPz2Gy4(@NotNull GraphicsLayerScope graphicsLayerScope, float f10) {
            return androidx.compose.ui.unit.a.l(graphicsLayerScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m1752toDpu2uoSUM(@NotNull GraphicsLayerScope graphicsLayerScope, int i10) {
            return androidx.compose.ui.unit.a.e(graphicsLayerScope, i10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m1759toSpkPz2Gy4(@NotNull GraphicsLayerScope graphicsLayerScope, int i10) {
            return androidx.compose.ui.unit.a.m(graphicsLayerScope, i10);
        }

        public static /* synthetic */ void getClip$annotations() {
        }
    }

    float getAlpha();

    /* JADX INFO: renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
    long mo1738getAmbientShadowColor0d7_KjU();

    float getCameraDistance();

    boolean getClip();

    @Nullable
    RenderEffect getRenderEffect();

    float getRotationX();

    float getRotationY();

    float getRotationZ();

    float getScaleX();

    float getScaleY();

    float getShadowElevation();

    @NotNull
    Shape getShape();

    /* JADX INFO: renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
    long mo1739getSpotShadowColor0d7_KjU();

    /* JADX INFO: renamed from: getTransformOrigin-SzJe1aQ, reason: not valid java name */
    long mo1740getTransformOriginSzJe1aQ();

    float getTranslationX();

    float getTranslationY();

    void setAlpha(float f10);

    /* JADX INFO: renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    void mo1741setAmbientShadowColor8_81llA(long j10);

    void setCameraDistance(float f10);

    void setClip(boolean z10);

    void setRenderEffect(@Nullable RenderEffect renderEffect);

    void setRotationX(float f10);

    void setRotationY(float f10);

    void setRotationZ(float f10);

    void setScaleX(float f10);

    void setScaleY(float f10);

    void setShadowElevation(float f10);

    void setShape(@NotNull Shape shape);

    /* JADX INFO: renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    void mo1742setSpotShadowColor8_81llA(long j10);

    /* JADX INFO: renamed from: setTransformOrigin-__ExYCQ, reason: not valid java name */
    void mo1743setTransformOrigin__ExYCQ(long j10);

    void setTranslationX(float f10);

    void setTranslationY(float f10);
}

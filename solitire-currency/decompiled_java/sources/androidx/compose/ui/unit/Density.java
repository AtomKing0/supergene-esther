package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Density.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public interface Density {

    /* JADX INFO: compiled from: Density.kt */
    public static final class DefaultImpls {
        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m3659roundToPxR2X_6o(@NotNull Density density, long j10) {
            return a.a(density, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m3660roundToPx0680j_4(@NotNull Density density, float f10) {
            return a.b(density, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m3661toDpGaN1DYA(@NotNull Density density, long j10) {
            return a.c(density, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3663toDpu2uoSUM(@NotNull Density density, int i10) {
            return a.e(density, i10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m3664toDpSizekrfVVM(@NotNull Density density, long j10) {
            return a.f(density, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m3665toPxR2X_6o(@NotNull Density density, long j10) {
            return a.g(density, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m3666toPx0680j_4(@NotNull Density density, float f10) {
            return a.h(density, f10);
        }

        @Stable
        @Deprecated
        @NotNull
        public static Rect toRect(@NotNull Density density, @NotNull DpRect receiver) {
            t.i(receiver, "receiver");
            return a.i(density, receiver);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m3667toSizeXkaWNTQ(@NotNull Density density, long j10) {
            return a.j(density, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m3668toSp0xMU5do(@NotNull Density density, float f10) {
            return a.k(density, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3670toSpkPz2Gy4(@NotNull Density density, int i10) {
            return a.m(density, i10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3662toDpu2uoSUM(@NotNull Density density, float f10) {
            return a.d(density, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3669toSpkPz2Gy4(@NotNull Density density, float f10) {
            return a.l(density, f10);
        }

        @Stable
        public static /* synthetic */ void getDensity$annotations() {
        }

        @Stable
        public static /* synthetic */ void getFontScale$annotations() {
        }
    }

    float getDensity();

    float getFontScale();

    @Stable
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    int mo289roundToPxR2X_6o(long j10);

    @Stable
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    int mo290roundToPx0680j_4(float f10);

    @Stable
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    float mo291toDpGaN1DYA(long j10);

    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    float mo292toDpu2uoSUM(float f10);

    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    float mo293toDpu2uoSUM(int i10);

    @Stable
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    long mo294toDpSizekrfVVM(long j10);

    @Stable
    /* JADX INFO: renamed from: toPx--R2X_6o */
    float mo295toPxR2X_6o(long j10);

    @Stable
    /* JADX INFO: renamed from: toPx-0680j_4 */
    float mo296toPx0680j_4(float f10);

    @Stable
    @NotNull
    Rect toRect(@NotNull DpRect dpRect);

    @Stable
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    long mo297toSizeXkaWNTQ(long j10);

    @Stable
    /* JADX INFO: renamed from: toSp-0xMU5do */
    long mo298toSp0xMU5do(float f10);

    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    long mo299toSpkPz2Gy4(float f10);

    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    long mo300toSpkPz2Gy4(int i10);
}

package androidx.compose.ui.graphics.drawscope;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.unit.DpRect;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ContentDrawScope.kt */
/* JADX INFO: loaded from: classes.dex */
public interface ContentDrawScope extends DrawScope {

    /* JADX INFO: compiled from: ContentDrawScope.kt */
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
        public static void m2011drawImageAZ2fEMs(@NotNull ContentDrawScope contentDrawScope, @NotNull ImageBitmap image, long j10, long j11, long j12, long j13, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10, int i11) {
            t.i(image, "image");
            t.i(style, "style");
            b.a(contentDrawScope, image, j10, j11, j12, j13, f10, style, colorFilter, i10, i11);
        }

        @Deprecated
        /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m2012getCenterF1C5BW0(@NotNull ContentDrawScope contentDrawScope) {
            return b.b(contentDrawScope);
        }

        @Deprecated
        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m2013getSizeNHjbRc(@NotNull ContentDrawScope contentDrawScope) {
            return b.c(contentDrawScope);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m2014roundToPxR2X_6o(@NotNull ContentDrawScope contentDrawScope, long j10) {
            return androidx.compose.ui.unit.a.a(contentDrawScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m2015roundToPx0680j_4(@NotNull ContentDrawScope contentDrawScope, float f10) {
            return androidx.compose.ui.unit.a.b(contentDrawScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m2016toDpGaN1DYA(@NotNull ContentDrawScope contentDrawScope, long j10) {
            return androidx.compose.ui.unit.a.c(contentDrawScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m2017toDpu2uoSUM(@NotNull ContentDrawScope contentDrawScope, float f10) {
            return androidx.compose.ui.unit.a.d(contentDrawScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m2019toDpSizekrfVVM(@NotNull ContentDrawScope contentDrawScope, long j10) {
            return androidx.compose.ui.unit.a.f(contentDrawScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m2020toPxR2X_6o(@NotNull ContentDrawScope contentDrawScope, long j10) {
            return androidx.compose.ui.unit.a.g(contentDrawScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m2021toPx0680j_4(@NotNull ContentDrawScope contentDrawScope, float f10) {
            return androidx.compose.ui.unit.a.h(contentDrawScope, f10);
        }

        @Stable
        @Deprecated
        @NotNull
        public static Rect toRect(@NotNull ContentDrawScope contentDrawScope, @NotNull DpRect receiver) {
            t.i(receiver, "receiver");
            return androidx.compose.ui.unit.a.i(contentDrawScope, receiver);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m2022toSizeXkaWNTQ(@NotNull ContentDrawScope contentDrawScope, long j10) {
            return androidx.compose.ui.unit.a.j(contentDrawScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m2023toSp0xMU5do(@NotNull ContentDrawScope contentDrawScope, float f10) {
            return androidx.compose.ui.unit.a.k(contentDrawScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m2024toSpkPz2Gy4(@NotNull ContentDrawScope contentDrawScope, float f10) {
            return androidx.compose.ui.unit.a.l(contentDrawScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m2018toDpu2uoSUM(@NotNull ContentDrawScope contentDrawScope, int i10) {
            return androidx.compose.ui.unit.a.e(contentDrawScope, i10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m2025toSpkPz2Gy4(@NotNull ContentDrawScope contentDrawScope, int i10) {
            return androidx.compose.ui.unit.a.m(contentDrawScope, i10);
        }
    }

    void drawContent();
}

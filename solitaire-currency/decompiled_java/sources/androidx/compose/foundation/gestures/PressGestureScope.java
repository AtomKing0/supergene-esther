package androidx.compose.foundation.gestures;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TapGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
public interface PressGestureScope extends Density {

    /* JADX INFO: compiled from: TapGestureDetector.kt */
    public static final class DefaultImpls {
        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m277roundToPxR2X_6o(@NotNull PressGestureScope pressGestureScope, long j10) {
            return androidx.compose.ui.unit.a.a(pressGestureScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m278roundToPx0680j_4(@NotNull PressGestureScope pressGestureScope, float f10) {
            return androidx.compose.ui.unit.a.b(pressGestureScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m279toDpGaN1DYA(@NotNull PressGestureScope pressGestureScope, long j10) {
            return androidx.compose.ui.unit.a.c(pressGestureScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m280toDpu2uoSUM(@NotNull PressGestureScope pressGestureScope, float f10) {
            return androidx.compose.ui.unit.a.d(pressGestureScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m282toDpSizekrfVVM(@NotNull PressGestureScope pressGestureScope, long j10) {
            return androidx.compose.ui.unit.a.f(pressGestureScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m283toPxR2X_6o(@NotNull PressGestureScope pressGestureScope, long j10) {
            return androidx.compose.ui.unit.a.g(pressGestureScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m284toPx0680j_4(@NotNull PressGestureScope pressGestureScope, float f10) {
            return androidx.compose.ui.unit.a.h(pressGestureScope, f10);
        }

        @Stable
        @Deprecated
        @NotNull
        public static Rect toRect(@NotNull PressGestureScope pressGestureScope, @NotNull DpRect receiver) {
            t.i(receiver, "receiver");
            return androidx.compose.ui.unit.a.i(pressGestureScope, receiver);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m285toSizeXkaWNTQ(@NotNull PressGestureScope pressGestureScope, long j10) {
            return androidx.compose.ui.unit.a.j(pressGestureScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m286toSp0xMU5do(@NotNull PressGestureScope pressGestureScope, float f10) {
            return androidx.compose.ui.unit.a.k(pressGestureScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m287toSpkPz2Gy4(@NotNull PressGestureScope pressGestureScope, float f10) {
            return androidx.compose.ui.unit.a.l(pressGestureScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m281toDpu2uoSUM(@NotNull PressGestureScope pressGestureScope, int i10) {
            return androidx.compose.ui.unit.a.e(pressGestureScope, i10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m288toSpkPz2Gy4(@NotNull PressGestureScope pressGestureScope, int i10) {
            return androidx.compose.ui.unit.a.m(pressGestureScope, i10);
        }
    }

    @Nullable
    Object awaitRelease(@NotNull z8.d<? super k0> dVar);

    @Nullable
    Object tryAwaitRelease(@NotNull z8.d<? super Boolean> dVar);
}

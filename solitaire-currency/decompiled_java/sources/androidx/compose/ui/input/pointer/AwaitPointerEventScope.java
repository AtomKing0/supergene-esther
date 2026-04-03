package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SuspendingPointerInputFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public interface AwaitPointerEventScope extends Density {

    /* JADX INFO: compiled from: SuspendingPointerInputFilter.kt */
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
        public static long m2792getExtendedTouchPaddingNHjbRc(@NotNull AwaitPointerEventScope awaitPointerEventScope) {
            return b.a(awaitPointerEventScope);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m2793roundToPxR2X_6o(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j10) {
            return androidx.compose.ui.unit.a.a(awaitPointerEventScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m2794roundToPx0680j_4(@NotNull AwaitPointerEventScope awaitPointerEventScope, float f10) {
            return androidx.compose.ui.unit.a.b(awaitPointerEventScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m2795toDpGaN1DYA(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j10) {
            return androidx.compose.ui.unit.a.c(awaitPointerEventScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m2796toDpu2uoSUM(@NotNull AwaitPointerEventScope awaitPointerEventScope, float f10) {
            return androidx.compose.ui.unit.a.d(awaitPointerEventScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m2798toDpSizekrfVVM(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j10) {
            return androidx.compose.ui.unit.a.f(awaitPointerEventScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m2799toPxR2X_6o(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j10) {
            return androidx.compose.ui.unit.a.g(awaitPointerEventScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m2800toPx0680j_4(@NotNull AwaitPointerEventScope awaitPointerEventScope, float f10) {
            return androidx.compose.ui.unit.a.h(awaitPointerEventScope, f10);
        }

        @Stable
        @Deprecated
        @NotNull
        public static Rect toRect(@NotNull AwaitPointerEventScope awaitPointerEventScope, @NotNull DpRect receiver) {
            t.i(receiver, "receiver");
            return androidx.compose.ui.unit.a.i(awaitPointerEventScope, receiver);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m2801toSizeXkaWNTQ(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j10) {
            return androidx.compose.ui.unit.a.j(awaitPointerEventScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m2802toSp0xMU5do(@NotNull AwaitPointerEventScope awaitPointerEventScope, float f10) {
            return androidx.compose.ui.unit.a.k(awaitPointerEventScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m2803toSpkPz2Gy4(@NotNull AwaitPointerEventScope awaitPointerEventScope, float f10) {
            return androidx.compose.ui.unit.a.l(awaitPointerEventScope, f10);
        }

        @Deprecated
        @Nullable
        public static <T> Object withTimeout(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j10, @NotNull p<? super AwaitPointerEventScope, ? super z8.d<? super T>, ? extends Object> pVar, @NotNull z8.d<? super T> dVar) {
            return b.b(awaitPointerEventScope, j10, pVar, dVar);
        }

        @Deprecated
        @Nullable
        public static <T> Object withTimeoutOrNull(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j10, @NotNull p<? super AwaitPointerEventScope, ? super z8.d<? super T>, ? extends Object> pVar, @NotNull z8.d<? super T> dVar) {
            return b.c(awaitPointerEventScope, j10, pVar, dVar);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m2797toDpu2uoSUM(@NotNull AwaitPointerEventScope awaitPointerEventScope, int i10) {
            return androidx.compose.ui.unit.a.e(awaitPointerEventScope, i10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m2804toSpkPz2Gy4(@NotNull AwaitPointerEventScope awaitPointerEventScope, int i10) {
            return androidx.compose.ui.unit.a.m(awaitPointerEventScope, i10);
        }
    }

    @Nullable
    Object awaitPointerEvent(@NotNull PointerEventPass pointerEventPass, @NotNull z8.d<? super PointerEvent> dVar);

    @NotNull
    PointerEvent getCurrentEvent();

    /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
    long mo2790getExtendedTouchPaddingNHjbRc();

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    long mo2791getSizeYbymL2g();

    @NotNull
    ViewConfiguration getViewConfiguration();

    @Nullable
    <T> Object withTimeout(long j10, @NotNull p<? super AwaitPointerEventScope, ? super z8.d<? super T>, ? extends Object> pVar, @NotNull z8.d<? super T> dVar);

    @Nullable
    <T> Object withTimeoutOrNull(long j10, @NotNull p<? super AwaitPointerEventScope, ? super z8.d<? super T>, ? extends Object> pVar, @NotNull z8.d<? super T> dVar);
}

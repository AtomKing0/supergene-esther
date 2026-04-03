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
public interface PointerInputScope extends Density {

    /* JADX INFO: compiled from: SuspendingPointerInputFilter.kt */
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
        public static long m2897getExtendedTouchPaddingNHjbRc(@NotNull PointerInputScope pointerInputScope) {
            return f.a(pointerInputScope);
        }

        @Deprecated
        public static boolean getInterceptOutOfBoundsChildEvents(@NotNull PointerInputScope pointerInputScope) {
            return f.b(pointerInputScope);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m2898roundToPxR2X_6o(@NotNull PointerInputScope pointerInputScope, long j10) {
            return androidx.compose.ui.unit.a.a(pointerInputScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m2899roundToPx0680j_4(@NotNull PointerInputScope pointerInputScope, float f10) {
            return androidx.compose.ui.unit.a.b(pointerInputScope, f10);
        }

        @Deprecated
        public static void setInterceptOutOfBoundsChildEvents(@NotNull PointerInputScope pointerInputScope, boolean z10) {
            f.c(pointerInputScope, z10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m2900toDpGaN1DYA(@NotNull PointerInputScope pointerInputScope, long j10) {
            return androidx.compose.ui.unit.a.c(pointerInputScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m2901toDpu2uoSUM(@NotNull PointerInputScope pointerInputScope, float f10) {
            return androidx.compose.ui.unit.a.d(pointerInputScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m2903toDpSizekrfVVM(@NotNull PointerInputScope pointerInputScope, long j10) {
            return androidx.compose.ui.unit.a.f(pointerInputScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m2904toPxR2X_6o(@NotNull PointerInputScope pointerInputScope, long j10) {
            return androidx.compose.ui.unit.a.g(pointerInputScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m2905toPx0680j_4(@NotNull PointerInputScope pointerInputScope, float f10) {
            return androidx.compose.ui.unit.a.h(pointerInputScope, f10);
        }

        @Stable
        @Deprecated
        @NotNull
        public static Rect toRect(@NotNull PointerInputScope pointerInputScope, @NotNull DpRect receiver) {
            t.i(receiver, "receiver");
            return androidx.compose.ui.unit.a.i(pointerInputScope, receiver);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m2906toSizeXkaWNTQ(@NotNull PointerInputScope pointerInputScope, long j10) {
            return androidx.compose.ui.unit.a.j(pointerInputScope, j10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m2907toSp0xMU5do(@NotNull PointerInputScope pointerInputScope, float f10) {
            return androidx.compose.ui.unit.a.k(pointerInputScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m2908toSpkPz2Gy4(@NotNull PointerInputScope pointerInputScope, float f10) {
            return androidx.compose.ui.unit.a.l(pointerInputScope, f10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m2902toDpu2uoSUM(@NotNull PointerInputScope pointerInputScope, int i10) {
            return androidx.compose.ui.unit.a.e(pointerInputScope, i10);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m2909toSpkPz2Gy4(@NotNull PointerInputScope pointerInputScope, int i10) {
            return androidx.compose.ui.unit.a.m(pointerInputScope, i10);
        }

        public static /* synthetic */ void getInterceptOutOfBoundsChildEvents$annotations() {
        }
    }

    @Nullable
    <R> Object awaitPointerEventScope(@NotNull p<? super AwaitPointerEventScope, ? super z8.d<? super R>, ? extends Object> pVar, @NotNull z8.d<? super R> dVar);

    /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
    long mo2895getExtendedTouchPaddingNHjbRc();

    boolean getInterceptOutOfBoundsChildEvents();

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    long m2896getSizeYbymL2g();

    @NotNull
    ViewConfiguration getViewConfiguration();

    void setInterceptOutOfBoundsChildEvents(boolean z10);
}

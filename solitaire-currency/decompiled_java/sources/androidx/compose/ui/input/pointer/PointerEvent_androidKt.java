package androidx.compose.ui.input.pointer;

/* JADX INFO: compiled from: PointerEvent.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PointerEvent_androidKt {
    /* JADX INFO: renamed from: getAreAnyPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m2838getAreAnyPressedaHzCxE(int i10) {
        return i10 != 0;
    }

    /* JADX INFO: renamed from: indexOfFirstPressed-aHzCx-E, reason: not valid java name */
    public static final int m2839indexOfFirstPressedaHzCxE(int i10) {
        if (i10 == 0) {
            return -1;
        }
        int i11 = 0;
        for (int i12 = (i10 & (-97)) | ((i10 & 96) >>> 5); (i12 & 1) == 0; i12 >>>= 1) {
            i11++;
        }
        return i11;
    }

    /* JADX INFO: renamed from: indexOfLastPressed-aHzCx-E, reason: not valid java name */
    public static final int m2840indexOfLastPressedaHzCxE(int i10) {
        int i11 = -1;
        for (int i12 = (i10 & (-97)) | ((i10 & 96) >>> 5); i12 != 0; i12 >>>= 1) {
            i11++;
        }
        return i11;
    }

    /* JADX INFO: renamed from: isAltGraphPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m2841isAltGraphPressed5xRPYO0(int i10) {
        return false;
    }

    /* JADX INFO: renamed from: isAltPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m2842isAltPressed5xRPYO0(int i10) {
        return (i10 & 2) != 0;
    }

    /* JADX INFO: renamed from: isBackPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m2843isBackPressedaHzCxE(int i10) {
        return (i10 & 8) != 0;
    }

    /* JADX INFO: renamed from: isCapsLockOn-5xRPYO0, reason: not valid java name */
    public static final boolean m2844isCapsLockOn5xRPYO0(int i10) {
        return (i10 & 1048576) != 0;
    }

    /* JADX INFO: renamed from: isCtrlPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m2845isCtrlPressed5xRPYO0(int i10) {
        return (i10 & 4096) != 0;
    }

    /* JADX INFO: renamed from: isForwardPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m2846isForwardPressedaHzCxE(int i10) {
        return (i10 & 16) != 0;
    }

    /* JADX INFO: renamed from: isFunctionPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m2847isFunctionPressed5xRPYO0(int i10) {
        return (i10 & 8) != 0;
    }

    /* JADX INFO: renamed from: isMetaPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m2848isMetaPressed5xRPYO0(int i10) {
        return (i10 & 65536) != 0;
    }

    /* JADX INFO: renamed from: isNumLockOn-5xRPYO0, reason: not valid java name */
    public static final boolean m2849isNumLockOn5xRPYO0(int i10) {
        return (i10 & 2097152) != 0;
    }

    /* JADX INFO: renamed from: isPressed-bNIWhpI, reason: not valid java name */
    public static final boolean m2850isPressedbNIWhpI(int i10, int i11) {
        if (i11 == 0) {
            return m2851isPrimaryPressedaHzCxE(i10);
        }
        if (i11 == 1) {
            return m2853isSecondaryPressedaHzCxE(i10);
        }
        if (i11 == 2 || i11 == 3 || i11 == 4) {
            if ((i10 & (1 << i11)) != 0) {
                return true;
            }
        } else if ((i10 & (1 << (i11 + 2))) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: isPrimaryPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m2851isPrimaryPressedaHzCxE(int i10) {
        return (i10 & 33) != 0;
    }

    /* JADX INFO: renamed from: isScrollLockOn-5xRPYO0, reason: not valid java name */
    public static final boolean m2852isScrollLockOn5xRPYO0(int i10) {
        return (i10 & 4194304) != 0;
    }

    /* JADX INFO: renamed from: isSecondaryPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m2853isSecondaryPressedaHzCxE(int i10) {
        return (i10 & 66) != 0;
    }

    /* JADX INFO: renamed from: isShiftPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m2854isShiftPressed5xRPYO0(int i10) {
        return (i10 & 1) != 0;
    }

    /* JADX INFO: renamed from: isSymPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m2855isSymPressed5xRPYO0(int i10) {
        return (i10 & 4) != 0;
    }

    /* JADX INFO: renamed from: isTertiaryPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m2856isTertiaryPressedaHzCxE(int i10) {
        return (i10 & 4) != 0;
    }
}

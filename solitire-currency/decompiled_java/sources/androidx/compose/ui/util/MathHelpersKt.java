package androidx.compose.ui.util;

import j9.c;

/* JADX INFO: compiled from: MathHelpers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MathHelpersKt {
    public static final float lerp(float f10, float f11, float f12) {
        return ((1 - f12) * f10) + (f12 * f11);
    }

    public static final int lerp(int i10, int i11, float f10) {
        return i10 + c.b(((double) (i11 - i10)) * ((double) f10));
    }

    public static final long lerp(long j10, long j11, float f10) {
        return j10 + c.d((j11 - j10) * ((double) f10));
    }
}

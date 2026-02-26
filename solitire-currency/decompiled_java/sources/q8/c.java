package q8;

import v8.h0;

/* JADX INFO: compiled from: EncodeResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final short a(int i10) {
        return f(i10);
    }

    public static final short b(int i10) {
        return e(i10);
    }

    public static int d(short s10, short s11) {
        return c(((s10 & 65535) << 16) | (s11 & 65535));
    }

    public static final short e(int i10) {
        return h0.c((short) (i10 & 65535));
    }

    public static final short f(int i10) {
        return h0.c((short) (i10 >>> 16));
    }

    public static int c(int i10) {
        return i10;
    }
}

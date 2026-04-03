package f5;

import e5.o;

/* JADX INFO: compiled from: DoubleUtils.java */
/* JADX INFO: loaded from: classes3.dex */
final class c {
    static long a(double d10) {
        o.e(b(d10), "not a normal value");
        int exponent = Math.getExponent(d10);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d10) & 4503599627370495L;
        return exponent == -1023 ? jDoubleToRawLongBits << 1 : jDoubleToRawLongBits | 4503599627370496L;
    }

    static boolean b(double d10) {
        return Math.getExponent(d10) <= 1023;
    }
}

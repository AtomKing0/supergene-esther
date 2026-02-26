package f5;

import java.math.RoundingMode;

/* JADX INFO: compiled from: MathPreconditions.java */
/* JADX INFO: loaded from: classes3.dex */
final class f {
    static void a(boolean z10, double d10, RoundingMode roundingMode) {
        if (z10) {
            return;
        }
        throw new ArithmeticException("rounded value is out of range for input " + d10 + " and rounding mode " + roundingMode);
    }

    static long b(String str, long j10) {
        if (j10 >= 0) {
            return j10;
        }
        throw new IllegalArgumentException(str + " (" + j10 + ") must be >= 0");
    }

    static void c(boolean z10) {
        if (!z10) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}

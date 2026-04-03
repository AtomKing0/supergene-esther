package f5;

import java.math.RoundingMode;

/* JADX INFO: compiled from: DoubleMath.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final double f25694a = Math.log(2.0d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final double[] f25695b = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    /* JADX INFO: compiled from: DoubleMath.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25696a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f25696a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25696a[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25696a[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25696a[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25696a[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25696a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25696a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25696a[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static boolean a(double d10) {
        return c.b(d10) && (d10 == 0.0d || 52 - Long.numberOfTrailingZeros(c.a(d10)) <= Math.getExponent(d10));
    }

    static double b(double d10, RoundingMode roundingMode) {
        if (!c.b(d10)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (a.f25696a[roundingMode.ordinal()]) {
            case 1:
                f.c(a(d10));
                return d10;
            case 2:
                return (d10 >= 0.0d || a(d10)) ? d10 : ((long) d10) - 1;
            case 3:
                return (d10 <= 0.0d || a(d10)) ? d10 : ((long) d10) + 1;
            case 4:
                return d10;
            case 5:
                if (a(d10)) {
                    return d10;
                }
                return ((long) d10) + ((long) (d10 > 0.0d ? 1 : -1));
            case 6:
                return Math.rint(d10);
            case 7:
                double dRint = Math.rint(d10);
                return Math.abs(d10 - dRint) == 0.5d ? d10 + Math.copySign(0.5d, d10) : dRint;
            case 8:
                double dRint2 = Math.rint(d10);
                return Math.abs(d10 - dRint2) == 0.5d ? d10 : dRint2;
            default:
                throw new AssertionError();
        }
    }

    public static long c(double d10, RoundingMode roundingMode) {
        double dB = b(d10, roundingMode);
        f.a(((-9.223372036854776E18d) - dB < 1.0d) & (dB < 9.223372036854776E18d), d10, roundingMode);
        return (long) dB;
    }
}

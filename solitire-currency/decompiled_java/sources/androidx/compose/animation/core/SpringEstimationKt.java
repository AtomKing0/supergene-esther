package androidx.compose.animation.core;

import h9.l;
import v8.s;

/* JADX INFO: compiled from: SpringEstimation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SpringEstimationKt {
    public static final long estimateAnimationDurationMillis(float f10, float f11, float f12, float f13, float f14) {
        return estimateAnimationDurationMillis(f10, f11, f12, f13, f14);
    }

    private static final double estimateCriticallyDamped(s<ComplexDouble, ComplexDouble> sVar, double d10, double d11, double d12) {
        double d13;
        double d14;
        double real = sVar.c().getReal();
        double d15 = real * d10;
        double d16 = d11 - d15;
        double dLog = Math.log(Math.abs(d12 / d10)) / real;
        double dEstimateCriticallyDamped$t2Iterate = estimateCriticallyDamped$t2Iterate(Math.log(Math.abs(d12 / d16)), real) / real;
        int i10 = 0;
        if (!((Double.isInfinite(dLog) || Double.isNaN(dLog)) ? false : true)) {
            d13 = dEstimateCriticallyDamped$t2Iterate;
        } else {
            if (!(!((Double.isInfinite(dEstimateCriticallyDamped$t2Iterate) || Double.isNaN(dEstimateCriticallyDamped$t2Iterate)) ? false : true))) {
                dLog = Math.max(dLog, dEstimateCriticallyDamped$t2Iterate);
            }
            d13 = dLog;
        }
        double d17 = (-(d15 + d16)) / (real * d16);
        if (Double.isNaN(d17) || d17 <= 0.0d) {
            d14 = -d12;
        } else if (d17 <= 0.0d || (-estimateCriticallyDamped$xInflection(d10, real, d17, d16)) >= d12) {
            d13 = (-(2.0d / real)) - (d10 / d16);
            d14 = d12;
        } else {
            if (d16 < 0.0d && d10 > 0.0d) {
                d13 = 0.0d;
            }
            d14 = -d12;
        }
        SpringEstimationKt$estimateCriticallyDamped$fn$1 springEstimationKt$estimateCriticallyDamped$fn$1 = new SpringEstimationKt$estimateCriticallyDamped$fn$1(d10, d16, real, d14);
        SpringEstimationKt$estimateCriticallyDamped$fnPrime$1 springEstimationKt$estimateCriticallyDamped$fnPrime$1 = new SpringEstimationKt$estimateCriticallyDamped$fnPrime$1(d16, real, d10);
        double d18 = Double.MAX_VALUE;
        while (d18 > 0.001d && i10 < 100) {
            i10++;
            double dDoubleValue = d13 - (springEstimationKt$estimateCriticallyDamped$fn$1.invoke(Double.valueOf(d13)).doubleValue() / springEstimationKt$estimateCriticallyDamped$fnPrime$1.invoke(Double.valueOf(d13)).doubleValue());
            double dAbs = Math.abs(d13 - dDoubleValue);
            d13 = dDoubleValue;
            d18 = dAbs;
        }
        return d13;
    }

    private static final double estimateCriticallyDamped$t2Iterate(double d10, double d11) {
        double dLog = d10;
        for (int i10 = 0; i10 < 6; i10++) {
            dLog = d10 - Math.log(Math.abs(dLog / d11));
        }
        return dLog;
    }

    private static final double estimateCriticallyDamped$xInflection(double d10, double d11, double d12, double d13) {
        double d14 = d11 * d12;
        return (d10 * Math.exp(d14)) + (d13 * d12 * Math.exp(d14));
    }

    private static final long estimateDurationInternal(s<ComplexDouble, ComplexDouble> sVar, double d10, double d11, double d12, double d13) {
        if (d12 == 0.0d) {
            if (d11 == 0.0d) {
                return 0L;
            }
        }
        if (d12 < 0.0d) {
            d11 = -d11;
        }
        double d14 = d11;
        double dAbs = Math.abs(d12);
        return (long) ((d10 > 1.0d ? estimateOverDamped(sVar, dAbs, d14, d13) : d10 < 1.0d ? estimateUnderDamped(sVar, dAbs, d14, d13) : estimateCriticallyDamped(sVar, dAbs, d14, d13)) * 1000.0d);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ea A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final double estimateOverDamped(v8.s<androidx.compose.animation.core.ComplexDouble, androidx.compose.animation.core.ComplexDouble> r31, double r32, double r34, double r36) {
        /*
            Method dump skipped, instruction units count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SpringEstimationKt.estimateOverDamped(v8.s, double, double, double):double");
    }

    /* JADX INFO: renamed from: estimateOverDamped$xInflection-0, reason: not valid java name */
    private static final double m119estimateOverDamped$xInflection0(double d10, double d11, double d12, double d13, double d14) {
        return (d10 * Math.exp(d11 * d12)) + (d13 * Math.exp(d14 * d12));
    }

    private static final double estimateUnderDamped(s<ComplexDouble, ComplexDouble> sVar, double d10, double d11, double d12) {
        double real = sVar.c().getReal();
        double imaginary = (d11 - (real * d10)) / sVar.c().getImaginary();
        return Math.log(d12 / Math.sqrt((d10 * d10) + (imaginary * imaginary))) / real;
    }

    private static final boolean isNotFinite(double d10) {
        return !((Double.isInfinite(d10) || Double.isNaN(d10)) ? false : true);
    }

    private static final double iterateNewtonsMethod(double d10, l<? super Double, Double> lVar, l<? super Double, Double> lVar2) {
        return d10 - (lVar.invoke(Double.valueOf(d10)).doubleValue() / lVar2.invoke(Double.valueOf(d10)).doubleValue());
    }

    public static final long estimateAnimationDurationMillis(double d10, double d11, double d12, double d13, double d14) {
        return estimateDurationInternal(ComplexDoubleKt.complexQuadraticFormula(1.0d, 2.0d * d11 * Math.sqrt(d10), d10), d11, d12, d13, d14);
    }

    public static final long estimateAnimationDurationMillis(double d10, double d11, double d12, double d13, double d14, double d15) {
        return estimateDurationInternal(ComplexDoubleKt.complexQuadraticFormula(d12, d11, d10), d11 / (Math.sqrt(d10 * d12) * 2.0d), d13, d14, d15);
    }
}

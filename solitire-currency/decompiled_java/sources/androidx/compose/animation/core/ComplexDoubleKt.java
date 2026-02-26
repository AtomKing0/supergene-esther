package androidx.compose.animation.core;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.s;
import v8.y;

/* JADX INFO: compiled from: ComplexDouble.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ComplexDoubleKt {
    @NotNull
    public static final s<ComplexDouble, ComplexDouble> complexQuadraticFormula(double d10, double d11, double d12) {
        double d13 = -d11;
        double d14 = (d11 * d11) - ((4.0d * d10) * d12);
        ComplexDouble complexDoubleComplexSqrt = complexSqrt(d14);
        complexDoubleComplexSqrt._real += d13;
        double d15 = d10 * 2.0d;
        complexDoubleComplexSqrt._real /= d15;
        complexDoubleComplexSqrt._imaginary /= d15;
        ComplexDouble complexDoubleComplexSqrt2 = complexSqrt(d14);
        double d16 = -1;
        complexDoubleComplexSqrt2._real *= d16;
        complexDoubleComplexSqrt2._imaginary *= d16;
        complexDoubleComplexSqrt2._real += d13;
        complexDoubleComplexSqrt2._real /= d15;
        complexDoubleComplexSqrt2._imaginary /= d15;
        return y.a(complexDoubleComplexSqrt, complexDoubleComplexSqrt2);
    }

    @NotNull
    public static final ComplexDouble complexSqrt(double d10) {
        return d10 < 0.0d ? new ComplexDouble(0.0d, Math.sqrt(Math.abs(d10))) : new ComplexDouble(Math.sqrt(d10), 0.0d);
    }

    @NotNull
    public static final ComplexDouble minus(double d10, @NotNull ComplexDouble other) {
        t.i(other, "other");
        double d11 = -1;
        other._real *= d11;
        other._imaginary *= d11;
        other._real += d10;
        return other;
    }

    @NotNull
    public static final ComplexDouble plus(double d10, @NotNull ComplexDouble other) {
        t.i(other, "other");
        other._real += d10;
        return other;
    }

    @NotNull
    public static final ComplexDouble times(double d10, @NotNull ComplexDouble other) {
        t.i(other, "other");
        other._real *= d10;
        other._imaginary *= d10;
        return other;
    }
}

package androidx.compose.animation.core;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ComplexDouble.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ComplexDouble {
    private double _imaginary;
    private double _real;

    public ComplexDouble(double d10, double d11) {
        this._real = d10;
        this._imaginary = d11;
    }

    private final double component1() {
        return this._real;
    }

    private final double component2() {
        return this._imaginary;
    }

    public static /* synthetic */ ComplexDouble copy$default(ComplexDouble complexDouble, double d10, double d11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            d10 = complexDouble._real;
        }
        if ((i10 & 2) != 0) {
            d11 = complexDouble._imaginary;
        }
        return complexDouble.copy(d10, d11);
    }

    @NotNull
    public final ComplexDouble copy(double d10, double d11) {
        return new ComplexDouble(d10, d11);
    }

    @NotNull
    public final ComplexDouble div(double d10) {
        this._real /= d10;
        this._imaginary /= d10;
        return this;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComplexDouble)) {
            return false;
        }
        ComplexDouble complexDouble = (ComplexDouble) obj;
        return t.d(Double.valueOf(this._real), Double.valueOf(complexDouble._real)) && t.d(Double.valueOf(this._imaginary), Double.valueOf(complexDouble._imaginary));
    }

    public final double getImaginary() {
        return this._imaginary;
    }

    public final double getReal() {
        return this._real;
    }

    public int hashCode() {
        return (b.a(this._real) * 31) + b.a(this._imaginary);
    }

    @NotNull
    public final ComplexDouble minus(double d10) {
        this._real += -d10;
        return this;
    }

    @NotNull
    public final ComplexDouble plus(double d10) {
        this._real += d10;
        return this;
    }

    @NotNull
    public final ComplexDouble times(double d10) {
        this._real *= d10;
        this._imaginary *= d10;
        return this;
    }

    @NotNull
    public String toString() {
        return "ComplexDouble(_real=" + this._real + ", _imaginary=" + this._imaginary + ')';
    }

    @NotNull
    public final ComplexDouble unaryMinus() {
        double d10 = -1;
        this._real *= d10;
        this._imaginary *= d10;
        return this;
    }

    @NotNull
    public final ComplexDouble minus(@NotNull ComplexDouble other) {
        t.i(other, "other");
        double d10 = -1;
        other._real *= d10;
        other._imaginary *= d10;
        this._real += other.getReal();
        this._imaginary += other.getImaginary();
        return this;
    }

    @NotNull
    public final ComplexDouble plus(@NotNull ComplexDouble other) {
        t.i(other, "other");
        this._real += other.getReal();
        this._imaginary += other.getImaginary();
        return this;
    }

    @NotNull
    public final ComplexDouble times(@NotNull ComplexDouble other) {
        t.i(other, "other");
        this._real = (getReal() * other.getReal()) - (getImaginary() * other.getImaginary());
        this._imaginary = (getReal() * other.getImaginary()) + (other.getReal() * getImaginary());
        return this;
    }
}

package androidx.compose.ui.input.pointer.util;

import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VelocityTracker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PolynomialFit {

    @NotNull
    private final List<Float> coefficients;
    private final float confidence;

    public PolynomialFit(@NotNull List<Float> coefficients, float f10) {
        t.i(coefficients, "coefficients");
        this.coefficients = coefficients;
        this.confidence = f10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PolynomialFit copy$default(PolynomialFit polynomialFit, List list, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = polynomialFit.coefficients;
        }
        if ((i10 & 2) != 0) {
            f10 = polynomialFit.confidence;
        }
        return polynomialFit.copy(list, f10);
    }

    @NotNull
    public final List<Float> component1() {
        return this.coefficients;
    }

    public final float component2() {
        return this.confidence;
    }

    @NotNull
    public final PolynomialFit copy(@NotNull List<Float> coefficients, float f10) {
        t.i(coefficients, "coefficients");
        return new PolynomialFit(coefficients, f10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolynomialFit)) {
            return false;
        }
        PolynomialFit polynomialFit = (PolynomialFit) obj;
        return t.d(this.coefficients, polynomialFit.coefficients) && t.d(Float.valueOf(this.confidence), Float.valueOf(polynomialFit.confidence));
    }

    @NotNull
    public final List<Float> getCoefficients() {
        return this.coefficients;
    }

    public final float getConfidence() {
        return this.confidence;
    }

    public int hashCode() {
        return (this.coefficients.hashCode() * 31) + Float.floatToIntBits(this.confidence);
    }

    @NotNull
    public String toString() {
        return "PolynomialFit(coefficients=" + this.coefficients + ", confidence=" + this.confidence + ')';
    }
}

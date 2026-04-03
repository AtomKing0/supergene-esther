package androidx.compose.animation;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SplineBasedDecay.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidFlingSpline {

    @NotNull
    public static final AndroidFlingSpline INSTANCE = new AndroidFlingSpline();
    private static final int NbSamples = 100;

    @NotNull
    private static final float[] SplinePositions;

    @NotNull
    private static final float[] SplineTimes;

    /* JADX INFO: compiled from: SplineBasedDecay.kt */
    @StabilityInferred(parameters = 0)
    public static final class FlingResult {
        public static final int $stable = 0;
        private final float distanceCoefficient;
        private final float velocityCoefficient;

        public FlingResult(float f10, float f11) {
            this.distanceCoefficient = f10;
            this.velocityCoefficient = f11;
        }

        public static /* synthetic */ FlingResult copy$default(FlingResult flingResult, float f10, float f11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = flingResult.distanceCoefficient;
            }
            if ((i10 & 2) != 0) {
                f11 = flingResult.velocityCoefficient;
            }
            return flingResult.copy(f10, f11);
        }

        public final float component1() {
            return this.distanceCoefficient;
        }

        public final float component2() {
            return this.velocityCoefficient;
        }

        @NotNull
        public final FlingResult copy(float f10, float f11) {
            return new FlingResult(f10, f11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FlingResult)) {
                return false;
            }
            FlingResult flingResult = (FlingResult) obj;
            return t.d(Float.valueOf(this.distanceCoefficient), Float.valueOf(flingResult.distanceCoefficient)) && t.d(Float.valueOf(this.velocityCoefficient), Float.valueOf(flingResult.velocityCoefficient));
        }

        public final float getDistanceCoefficient() {
            return this.distanceCoefficient;
        }

        public final float getVelocityCoefficient() {
            return this.velocityCoefficient;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.distanceCoefficient) * 31) + Float.floatToIntBits(this.velocityCoefficient);
        }

        @NotNull
        public String toString() {
            return "FlingResult(distanceCoefficient=" + this.distanceCoefficient + ", velocityCoefficient=" + this.velocityCoefficient + ')';
        }
    }

    static {
        float[] fArr = new float[101];
        SplinePositions = fArr;
        float[] fArr2 = new float[101];
        SplineTimes = fArr2;
        SplineBasedDecayKt.computeSplineInfo(fArr, fArr2, 100);
    }

    private AndroidFlingSpline() {
    }

    public final double deceleration(float f10, float f11) {
        return Math.log(((double) (Math.abs(f10) * 0.35f)) / ((double) f11));
    }

    @NotNull
    public final FlingResult flingPosition(float f10) {
        float f11;
        float f12;
        float f13 = 100;
        int i10 = (int) (f13 * f10);
        if (i10 < 100) {
            float f14 = i10 / f13;
            int i11 = i10 + 1;
            float f15 = i11 / f13;
            float[] fArr = SplinePositions;
            float f16 = fArr[i10];
            f12 = (fArr[i11] - f16) / (f15 - f14);
            f11 = f16 + ((f10 - f14) * f12);
        } else {
            f11 = 1.0f;
            f12 = 0.0f;
        }
        return new FlingResult(f11, f12);
    }
}

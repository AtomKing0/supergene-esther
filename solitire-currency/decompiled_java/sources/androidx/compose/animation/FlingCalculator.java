package androidx.compose.animation;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FlingCalculator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FlingCalculator {

    @NotNull
    private final Density density;
    private final float friction;
    private final float magicPhysicalCoefficient;

    /* JADX INFO: compiled from: FlingCalculator.kt */
    @StabilityInferred(parameters = 0)
    public static final class FlingInfo {
        public static final int $stable = 0;
        private final float distance;
        private final long duration;
        private final float initialVelocity;

        public FlingInfo(float f10, float f11, long j10) {
            this.initialVelocity = f10;
            this.distance = f11;
            this.duration = j10;
        }

        public static /* synthetic */ FlingInfo copy$default(FlingInfo flingInfo, float f10, float f11, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = flingInfo.initialVelocity;
            }
            if ((i10 & 2) != 0) {
                f11 = flingInfo.distance;
            }
            if ((i10 & 4) != 0) {
                j10 = flingInfo.duration;
            }
            return flingInfo.copy(f10, f11, j10);
        }

        public final float component1() {
            return this.initialVelocity;
        }

        public final float component2() {
            return this.distance;
        }

        public final long component3() {
            return this.duration;
        }

        @NotNull
        public final FlingInfo copy(float f10, float f11, long j10) {
            return new FlingInfo(f10, f11, j10);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FlingInfo)) {
                return false;
            }
            FlingInfo flingInfo = (FlingInfo) obj;
            return t.d(Float.valueOf(this.initialVelocity), Float.valueOf(flingInfo.initialVelocity)) && t.d(Float.valueOf(this.distance), Float.valueOf(flingInfo.distance)) && this.duration == flingInfo.duration;
        }

        public final float getDistance() {
            return this.distance;
        }

        public final long getDuration() {
            return this.duration;
        }

        public final float getInitialVelocity() {
            return this.initialVelocity;
        }

        public int hashCode() {
            return (((Float.floatToIntBits(this.initialVelocity) * 31) + Float.floatToIntBits(this.distance)) * 31) + a.a(this.duration);
        }

        public final float position(long j10) {
            long j11 = this.duration;
            return this.distance * Math.signum(this.initialVelocity) * AndroidFlingSpline.INSTANCE.flingPosition(j11 > 0 ? j10 / j11 : 1.0f).getDistanceCoefficient();
        }

        @NotNull
        public String toString() {
            return "FlingInfo(initialVelocity=" + this.initialVelocity + ", distance=" + this.distance + ", duration=" + this.duration + ')';
        }

        public final float velocity(long j10) {
            long j11 = this.duration;
            return (((AndroidFlingSpline.INSTANCE.flingPosition(j11 > 0 ? j10 / j11 : 1.0f).getVelocityCoefficient() * Math.signum(this.initialVelocity)) * this.distance) / this.duration) * 1000.0f;
        }
    }

    public FlingCalculator(float f10, @NotNull Density density) {
        t.i(density, "density");
        this.friction = f10;
        this.density = density;
        this.magicPhysicalCoefficient = computeDeceleration(density);
    }

    private final float computeDeceleration(Density density) {
        return FlingCalculatorKt.computeDeceleration(0.84f, density.getDensity());
    }

    private final double getSplineDeceleration(float f10) {
        return AndroidFlingSpline.INSTANCE.deceleration(f10, this.friction * this.magicPhysicalCoefficient);
    }

    public final float flingDistance(float f10) {
        return (float) (((double) (this.friction * this.magicPhysicalCoefficient)) * Math.exp((((double) FlingCalculatorKt.DecelerationRate) / (((double) FlingCalculatorKt.DecelerationRate) - 1.0d)) * getSplineDeceleration(f10)));
    }

    public final long flingDuration(float f10) {
        return (long) (Math.exp(getSplineDeceleration(f10) / (((double) FlingCalculatorKt.DecelerationRate) - 1.0d)) * 1000.0d);
    }

    @NotNull
    public final FlingInfo flingInfo(float f10) {
        double splineDeceleration = getSplineDeceleration(f10);
        double d10 = ((double) FlingCalculatorKt.DecelerationRate) - 1.0d;
        return new FlingInfo(f10, (float) (((double) (this.friction * this.magicPhysicalCoefficient)) * Math.exp((((double) FlingCalculatorKt.DecelerationRate) / d10) * splineDeceleration)), (long) (Math.exp(splineDeceleration / d10) * 1000.0d));
    }

    @NotNull
    public final Density getDensity() {
        return this.density;
    }
}

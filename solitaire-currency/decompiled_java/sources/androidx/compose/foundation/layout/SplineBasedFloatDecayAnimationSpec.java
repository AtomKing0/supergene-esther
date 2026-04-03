package androidx.compose.foundation.layout;

import androidx.compose.animation.core.FloatDecayAnimationSpec;
import androidx.compose.foundation.layout.AndroidFlingSpline;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WindowInsetsConnection.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class SplineBasedFloatDecayAnimationSpec implements FloatDecayAnimationSpec {
    private final float magicPhysicalCoefficient;

    public SplineBasedFloatDecayAnimationSpec(@NotNull Density density) {
        t.i(density, "density");
        this.magicPhysicalCoefficient = density.getDensity() * 386.0878f * 160.0f * 0.84f;
    }

    private final double getSplineDeceleration(float f10) {
        return AndroidFlingSpline.INSTANCE.deceleration(f10, WindowInsetsConnection_androidKt.PlatformFlingScrollFriction * this.magicPhysicalCoefficient);
    }

    public final float flingDistance(float f10) {
        return ((float) (((double) (WindowInsetsConnection_androidKt.PlatformFlingScrollFriction * this.magicPhysicalCoefficient)) * Math.exp((WindowInsetsConnection_androidKt.DecelerationRate / WindowInsetsConnection_androidKt.DecelMinusOne) * getSplineDeceleration(f10)))) * Math.signum(f10);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getAbsVelocityThreshold() {
        return 0.0f;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public long getDurationNanos(float f10, float f11) {
        return (long) (Math.exp(getSplineDeceleration(f11) / WindowInsetsConnection_androidKt.DecelMinusOne) * 1.0E9d);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getTargetValue(float f10, float f11) {
        return f10 + flingDistance(f11);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getValueFromNanos(long j10, float f10, float f11) {
        long durationNanos = getDurationNanos(0.0f, f11);
        return f10 + (flingDistance(f11) * AndroidFlingSpline.FlingResult.m342getDistanceCoefficientimpl(AndroidFlingSpline.INSTANCE.m337flingPositionLfoxSSI(durationNanos > 0 ? j10 / durationNanos : 1.0f)));
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getVelocityFromNanos(long j10, float f10, float f11) {
        long durationNanos = getDurationNanos(0.0f, f11);
        return ((AndroidFlingSpline.FlingResult.m343getVelocityCoefficientimpl(AndroidFlingSpline.INSTANCE.m337flingPositionLfoxSSI(durationNanos > 0 ? j10 / durationNanos : 1.0f)) * flingDistance(f11)) / durationNanos) * 1.0E9f;
    }
}

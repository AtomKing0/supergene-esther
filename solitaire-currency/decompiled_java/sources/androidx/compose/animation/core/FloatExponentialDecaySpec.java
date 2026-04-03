package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: FloatDecayAnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class FloatExponentialDecaySpec implements FloatDecayAnimationSpec {
    public static final int $stable = 0;
    private final float absVelocityThreshold;
    private final float friction;

    /* JADX WARN: Illegal instructions before constructor call */
    public FloatExponentialDecaySpec() {
        float f10 = 0.0f;
        this(f10, f10, 3, null);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getAbsVelocityThreshold() {
        return this.absVelocityThreshold;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public long getDurationNanos(float f10, float f11) {
        return ((long) ((((float) Math.log(getAbsVelocityThreshold() / Math.abs(f11))) * 1000.0f) / this.friction)) * 1000000;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getTargetValue(float f10, float f11) {
        if (Math.abs(f11) <= getAbsVelocityThreshold()) {
            return f10;
        }
        double dLog = Math.log(Math.abs(getAbsVelocityThreshold() / f11));
        float f12 = this.friction;
        return (f10 - (f11 / f12)) + ((f11 / f12) * ((float) Math.exp((((double) f12) * ((dLog / ((double) f12)) * ((double) 1000))) / ((double) 1000.0f))));
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getValueFromNanos(long j10, float f10, float f11) {
        float f12 = this.friction;
        return (f10 - (f11 / f12)) + ((f11 / f12) * ((float) Math.exp((f12 * (j10 / 1000000)) / 1000.0f)));
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getVelocityFromNanos(long j10, float f10, float f11) {
        return f11 * ((float) Math.exp(((j10 / 1000000) / 1000.0f) * this.friction));
    }

    public FloatExponentialDecaySpec(float f10, float f11) {
        this.absVelocityThreshold = Math.max(1.0E-7f, Math.abs(f11));
        this.friction = Math.max(1.0E-4f, f10) * (-4.2f);
    }

    public /* synthetic */ FloatExponentialDecaySpec(float f10, float f11, int i10, k kVar) {
        this((i10 & 1) != 0 ? 1.0f : f10, (i10 & 2) != 0 ? 0.1f : f11);
    }
}

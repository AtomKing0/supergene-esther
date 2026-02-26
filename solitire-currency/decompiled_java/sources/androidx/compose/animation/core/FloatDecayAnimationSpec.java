package androidx.compose.animation.core;

/* JADX INFO: compiled from: FloatDecayAnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
public interface FloatDecayAnimationSpec {
    float getAbsVelocityThreshold();

    long getDurationNanos(float f10, float f11);

    float getTargetValue(float f10, float f11);

    float getValueFromNanos(long j10, float f10, float f11);

    float getVelocityFromNanos(long j10, float f10, float f11);
}

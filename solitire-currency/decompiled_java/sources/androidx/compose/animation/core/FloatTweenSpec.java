package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FloatAnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class FloatTweenSpec implements FloatAnimationSpec {
    public static final int $stable = 0;
    private final int delay;
    private final int duration;

    @NotNull
    private final Easing easing;

    public FloatTweenSpec() {
        this(0, 0, null, 7, null);
    }

    private final long clampPlayTime(long j10) {
        return o.p(j10 - ((long) this.delay), 0L, this.duration);
    }

    public final int getDelay() {
        return this.delay;
    }

    public final int getDuration() {
        return this.duration;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public long getDurationNanos(float f10, float f11, float f12) {
        return ((long) (this.delay + this.duration)) * 1000000;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public /* synthetic */ float getEndVelocity(float f10, float f11, float f12) {
        return c.a(this, f10, f11, f12);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getValueFromNanos(long j10, float f10, float f11, float f12) {
        long jClampPlayTime = clampPlayTime(j10 / 1000000);
        int i10 = this.duration;
        return VectorConvertersKt.lerp(f10, f11, this.easing.transform(o.m(i10 == 0 ? 1.0f : jClampPlayTime / i10, 0.0f, 1.0f)));
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getVelocityFromNanos(long j10, float f10, float f11, float f12) {
        long jClampPlayTime = clampPlayTime(j10 / 1000000);
        if (jClampPlayTime < 0) {
            return 0.0f;
        }
        if (jClampPlayTime == 0) {
            return f12;
        }
        return (getValueFromNanos(jClampPlayTime * 1000000, f10, f11, f12) - getValueFromNanos((jClampPlayTime - 1) * 1000000, f10, f11, f12)) * 1000.0f;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public /* bridge */ /* synthetic */ VectorizedAnimationSpec vectorize(TwoWayConverter twoWayConverter) {
        return vectorize(twoWayConverter);
    }

    public FloatTweenSpec(int i10, int i11, @NotNull Easing easing) {
        t.i(easing, "easing");
        this.duration = i10;
        this.delay = i11;
        this.easing = easing;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public /* synthetic */ VectorizedFloatAnimationSpec vectorize(TwoWayConverter twoWayConverter) {
        return c.c(this, twoWayConverter);
    }

    public /* synthetic */ FloatTweenSpec(int i10, int i11, Easing easing, int i12, k kVar) {
        this((i12 & 1) != 0 ? AnimationConstants.DefaultDurationMillis : i10, (i12 & 2) != 0 ? 0 : i11, (i12 & 4) != 0 ? EasingKt.getFastOutSlowInEasing() : easing);
    }
}

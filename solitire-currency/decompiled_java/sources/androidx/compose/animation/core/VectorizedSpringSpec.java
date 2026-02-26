package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VectorizedAnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class VectorizedSpringSpec<V extends AnimationVector> implements VectorizedFiniteAnimationSpec<V> {
    public static final int $stable = 8;
    private final /* synthetic */ VectorizedFloatAnimationSpec<V> $$delegate_0;
    private final float dampingRatio;
    private final float stiffness;

    private VectorizedSpringSpec(float f10, float f11, Animations animations) {
        this.dampingRatio = f10;
        this.stiffness = f11;
        this.$$delegate_0 = new VectorizedFloatAnimationSpec<>(animations);
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long getDurationNanos(@NotNull V initialValue, @NotNull V targetValue, @NotNull V initialVelocity) {
        t.i(initialValue, "initialValue");
        t.i(targetValue, "targetValue");
        t.i(initialVelocity, "initialVelocity");
        return this.$$delegate_0.getDurationNanos(initialValue, targetValue, initialVelocity);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    @NotNull
    public V getEndVelocity(@NotNull V initialValue, @NotNull V targetValue, @NotNull V initialVelocity) {
        t.i(initialValue, "initialValue");
        t.i(targetValue, "targetValue");
        t.i(initialVelocity, "initialVelocity");
        return (V) this.$$delegate_0.getEndVelocity(initialValue, targetValue, initialVelocity);
    }

    public final float getStiffness() {
        return this.stiffness;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    @NotNull
    public V getValueFromNanos(long j10, @NotNull V initialValue, @NotNull V targetValue, @NotNull V initialVelocity) {
        t.i(initialValue, "initialValue");
        t.i(targetValue, "targetValue");
        t.i(initialVelocity, "initialVelocity");
        return (V) this.$$delegate_0.getValueFromNanos(j10, initialValue, targetValue, initialVelocity);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    @NotNull
    public V getVelocityFromNanos(long j10, @NotNull V initialValue, @NotNull V targetValue, @NotNull V initialVelocity) {
        t.i(initialValue, "initialValue");
        t.i(targetValue, "targetValue");
        t.i(initialVelocity, "initialVelocity");
        return (V) this.$$delegate_0.getVelocityFromNanos(j10, initialValue, targetValue, initialVelocity);
    }

    @Override // androidx.compose.animation.core.VectorizedFiniteAnimationSpec, androidx.compose.animation.core.VectorizedAnimationSpec
    public boolean isInfinite() {
        return this.$$delegate_0.isInfinite();
    }

    public /* synthetic */ VectorizedSpringSpec(float f10, float f11, AnimationVector animationVector, int i10, k kVar) {
        this((i10 & 1) != 0 ? 1.0f : f10, (i10 & 2) != 0 ? 1500.0f : f11, (i10 & 4) != 0 ? null : animationVector);
    }

    public VectorizedSpringSpec(float f10, float f11, @Nullable V v10) {
        this(f10, f11, VectorizedAnimationSpecKt.createSpringAnimations(v10, f10, f11));
    }
}

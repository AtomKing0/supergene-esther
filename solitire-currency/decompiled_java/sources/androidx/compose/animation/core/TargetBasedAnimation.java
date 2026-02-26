package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Animation.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class TargetBasedAnimation<T, V extends AnimationVector> implements Animation<T, V> {
    public static final int $stable = 0;

    @NotNull
    private final VectorizedAnimationSpec<V> animationSpec;
    private final long durationNanos;

    @NotNull
    private final V endVelocity;
    private final T initialValue;

    @NotNull
    private final V initialValueVector;

    @NotNull
    private final V initialVelocityVector;
    private final T targetValue;

    @NotNull
    private final V targetValueVector;

    @NotNull
    private final TwoWayConverter<T, V> typeConverter;

    public TargetBasedAnimation(@NotNull VectorizedAnimationSpec<V> animationSpec, @NotNull TwoWayConverter<T, V> typeConverter, T t10, T t11, @Nullable V v10) {
        t.i(animationSpec, "animationSpec");
        t.i(typeConverter, "typeConverter");
        this.animationSpec = animationSpec;
        this.typeConverter = typeConverter;
        this.initialValue = t10;
        this.targetValue = t11;
        V vInvoke = getTypeConverter().getConvertToVector().invoke(t10);
        this.initialValueVector = vInvoke;
        V vInvoke2 = getTypeConverter().getConvertToVector().invoke(getTargetValue());
        this.targetValueVector = vInvoke2;
        V v11 = (v10 == null || (v11 = (V) AnimationVectorsKt.copy(v10)) == null) ? (V) AnimationVectorsKt.newInstance(getTypeConverter().getConvertToVector().invoke(t10)) : v11;
        this.initialVelocityVector = v11;
        this.durationNanos = animationSpec.getDurationNanos(vInvoke, vInvoke2, v11);
        this.endVelocity = (V) animationSpec.getEndVelocity(vInvoke, vInvoke2, v11);
    }

    @NotNull
    public final VectorizedAnimationSpec<V> getAnimationSpec$animation_core_release() {
        return this.animationSpec;
    }

    @Override // androidx.compose.animation.core.Animation
    public long getDurationNanos() {
        return this.durationNanos;
    }

    public final T getInitialValue() {
        return this.initialValue;
    }

    @Override // androidx.compose.animation.core.Animation
    public T getTargetValue() {
        return this.targetValue;
    }

    @Override // androidx.compose.animation.core.Animation
    @NotNull
    public TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    @Override // androidx.compose.animation.core.Animation
    public T getValueFromNanos(long j10) {
        return !isFinishedFromNanos(j10) ? (T) getTypeConverter().getConvertFromVector().invoke(this.animationSpec.getValueFromNanos(j10, this.initialValueVector, this.targetValueVector, this.initialVelocityVector)) : getTargetValue();
    }

    @Override // androidx.compose.animation.core.Animation
    @NotNull
    public V getVelocityVectorFromNanos(long j10) {
        return !isFinishedFromNanos(j10) ? (V) this.animationSpec.getVelocityFromNanos(j10, this.initialValueVector, this.targetValueVector, this.initialVelocityVector) : this.endVelocity;
    }

    @Override // androidx.compose.animation.core.Animation
    public /* synthetic */ boolean isFinishedFromNanos(long j10) {
        return a.a(this, j10);
    }

    @Override // androidx.compose.animation.core.Animation
    public boolean isInfinite() {
        return this.animationSpec.isInfinite();
    }

    @NotNull
    public String toString() {
        return "TargetBasedAnimation: " + this.initialValue + " -> " + getTargetValue() + ",initial velocity: " + this.initialVelocityVector + ", duration: " + AnimationKt.getDurationMillis(this) + " ms";
    }

    public /* synthetic */ TargetBasedAnimation(VectorizedAnimationSpec vectorizedAnimationSpec, TwoWayConverter twoWayConverter, Object obj, Object obj2, AnimationVector animationVector, int i10, k kVar) {
        this((VectorizedAnimationSpec<AnimationVector>) vectorizedAnimationSpec, (TwoWayConverter<Object, AnimationVector>) twoWayConverter, obj, obj2, (i10 & 16) != 0 ? null : animationVector);
    }

    public /* synthetic */ TargetBasedAnimation(AnimationSpec animationSpec, TwoWayConverter twoWayConverter, Object obj, Object obj2, AnimationVector animationVector, int i10, k kVar) {
        this((AnimationSpec<Object>) animationSpec, (TwoWayConverter<Object, AnimationVector>) twoWayConverter, obj, obj2, (i10 & 16) != 0 ? null : animationVector);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TargetBasedAnimation(@NotNull AnimationSpec<T> animationSpec, @NotNull TwoWayConverter<T, V> typeConverter, T t10, T t11, @Nullable V v10) {
        this(animationSpec.vectorize(typeConverter), typeConverter, t10, t11, v10);
        t.i(animationSpec, "animationSpec");
        t.i(typeConverter, "typeConverter");
    }
}

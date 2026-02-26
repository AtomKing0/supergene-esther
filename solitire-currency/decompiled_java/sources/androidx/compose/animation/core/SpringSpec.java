package androidx.compose.animation.core;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class SpringSpec<T> implements FiniteAnimationSpec<T> {
    private final float dampingRatio;
    private final float stiffness;

    @Nullable
    private final T visibilityThreshold;

    public SpringSpec() {
        this(0.0f, 0.0f, null, 7, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SpringSpec)) {
            return false;
        }
        SpringSpec springSpec = (SpringSpec) obj;
        if (springSpec.dampingRatio == this.dampingRatio) {
            return ((springSpec.stiffness > this.stiffness ? 1 : (springSpec.stiffness == this.stiffness ? 0 : -1)) == 0) && t.d(springSpec.visibilityThreshold, this.visibilityThreshold);
        }
        return false;
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getStiffness() {
        return this.stiffness;
    }

    @Nullable
    public final T getVisibilityThreshold() {
        return this.visibilityThreshold;
    }

    public int hashCode() {
        T t10 = this.visibilityThreshold;
        return ((((t10 != null ? t10.hashCode() : 0) * 31) + Float.floatToIntBits(this.dampingRatio)) * 31) + Float.floatToIntBits(this.stiffness);
    }

    public SpringSpec(float f10, float f11, @Nullable T t10) {
        this.dampingRatio = f10;
        this.stiffness = f11;
        this.visibilityThreshold = t10;
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec, androidx.compose.animation.core.AnimationSpec
    @NotNull
    public <V extends AnimationVector> VectorizedSpringSpec<V> vectorize(@NotNull TwoWayConverter<T, V> converter) {
        t.i(converter, "converter");
        return new VectorizedSpringSpec<>(this.dampingRatio, this.stiffness, AnimationSpecKt.convert(converter, this.visibilityThreshold));
    }

    public /* synthetic */ SpringSpec(float f10, float f11, Object obj, int i10, k kVar) {
        this((i10 & 1) != 0 ? 1.0f : f10, (i10 & 2) != 0 ? 1500.0f : f11, (i10 & 4) != 0 ? null : obj);
    }
}

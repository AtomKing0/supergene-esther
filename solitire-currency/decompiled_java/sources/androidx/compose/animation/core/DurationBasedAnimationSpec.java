package androidx.compose.animation.core;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
public interface DurationBasedAnimationSpec<T> extends FiniteAnimationSpec<T> {
    @Override // androidx.compose.animation.core.FiniteAnimationSpec, androidx.compose.animation.core.AnimationSpec
    @NotNull
    <V extends AnimationVector> VectorizedDurationBasedAnimationSpec<V> vectorize(@NotNull TwoWayConverter<T, V> twoWayConverter);
}

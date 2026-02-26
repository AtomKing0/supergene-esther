package androidx.compose.animation.core;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
public interface AnimationSpec<T> {
    @NotNull
    <V extends AnimationVector> VectorizedAnimationSpec<V> vectorize(@NotNull TwoWayConverter<T, V> twoWayConverter);
}

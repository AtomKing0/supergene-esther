package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorizedAnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
public interface VectorizedDurationBasedAnimationSpec<V extends AnimationVector> extends VectorizedFiniteAnimationSpec<V> {

    /* JADX INFO: compiled from: VectorizedAnimationSpec.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static <V extends AnimationVector> long getDurationNanos(@NotNull VectorizedDurationBasedAnimationSpec<V> vectorizedDurationBasedAnimationSpec, @NotNull V initialValue, @NotNull V targetValue, @NotNull V initialVelocity) {
            t.i(initialValue, "initialValue");
            t.i(targetValue, "targetValue");
            t.i(initialVelocity, "initialVelocity");
            return g.a(vectorizedDurationBasedAnimationSpec, initialValue, targetValue, initialVelocity);
        }

        @Deprecated
        @NotNull
        public static <V extends AnimationVector> V getEndVelocity(@NotNull VectorizedDurationBasedAnimationSpec<V> vectorizedDurationBasedAnimationSpec, @NotNull V initialValue, @NotNull V targetValue, @NotNull V initialVelocity) {
            t.i(initialValue, "initialValue");
            t.i(targetValue, "targetValue");
            t.i(initialVelocity, "initialVelocity");
            return (V) f.a(vectorizedDurationBasedAnimationSpec, initialValue, targetValue, initialVelocity);
        }

        @Deprecated
        public static <V extends AnimationVector> boolean isInfinite(@NotNull VectorizedDurationBasedAnimationSpec<V> vectorizedDurationBasedAnimationSpec) {
            return h.a(vectorizedDurationBasedAnimationSpec);
        }
    }

    int getDelayMillis();

    int getDurationMillis();

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    long getDurationNanos(@NotNull V v10, @NotNull V v11, @NotNull V v12);
}

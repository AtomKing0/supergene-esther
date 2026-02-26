package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorizedAnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
public interface VectorizedFiniteAnimationSpec<V extends AnimationVector> extends VectorizedAnimationSpec<V> {

    /* JADX INFO: compiled from: VectorizedAnimationSpec.kt */
    public static final class DefaultImpls {
        @Deprecated
        @NotNull
        public static <V extends AnimationVector> V getEndVelocity(@NotNull VectorizedFiniteAnimationSpec<V> vectorizedFiniteAnimationSpec, @NotNull V initialValue, @NotNull V targetValue, @NotNull V initialVelocity) {
            t.i(initialValue, "initialValue");
            t.i(targetValue, "targetValue");
            t.i(initialVelocity, "initialVelocity");
            return (V) f.a(vectorizedFiniteAnimationSpec, initialValue, targetValue, initialVelocity);
        }

        @Deprecated
        public static <V extends AnimationVector> boolean isInfinite(@NotNull VectorizedFiniteAnimationSpec<V> vectorizedFiniteAnimationSpec) {
            return h.a(vectorizedFiniteAnimationSpec);
        }
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    boolean isInfinite();
}

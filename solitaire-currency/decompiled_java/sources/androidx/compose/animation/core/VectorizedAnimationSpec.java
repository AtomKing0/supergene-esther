package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorizedAnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
public interface VectorizedAnimationSpec<V extends AnimationVector> {

    /* JADX INFO: compiled from: VectorizedAnimationSpec.kt */
    public static final class DefaultImpls {
        @Deprecated
        @NotNull
        public static <V extends AnimationVector> V getEndVelocity(@NotNull VectorizedAnimationSpec<V> vectorizedAnimationSpec, @NotNull V initialValue, @NotNull V targetValue, @NotNull V initialVelocity) {
            t.i(initialValue, "initialValue");
            t.i(targetValue, "targetValue");
            t.i(initialVelocity, "initialVelocity");
            return (V) f.a(vectorizedAnimationSpec, initialValue, targetValue, initialVelocity);
        }
    }

    long getDurationNanos(@NotNull V v10, @NotNull V v11, @NotNull V v12);

    @NotNull
    V getEndVelocity(@NotNull V v10, @NotNull V v11, @NotNull V v12);

    @NotNull
    V getValueFromNanos(long j10, @NotNull V v10, @NotNull V v11, @NotNull V v12);

    @NotNull
    V getVelocityFromNanos(long j10, @NotNull V v10, @NotNull V v11, @NotNull V v12);

    boolean isInfinite();
}

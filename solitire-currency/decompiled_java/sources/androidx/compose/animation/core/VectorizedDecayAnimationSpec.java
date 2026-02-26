package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorizedDecayAnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
public interface VectorizedDecayAnimationSpec<V extends AnimationVector> {
    float getAbsVelocityThreshold();

    long getDurationNanos(@NotNull V v10, @NotNull V v11);

    @NotNull
    V getTargetValue(@NotNull V v10, @NotNull V v11);

    @NotNull
    V getValueFromNanos(long j10, @NotNull V v10, @NotNull V v11);

    @NotNull
    V getVelocityFromNanos(long j10, @NotNull V v10, @NotNull V v11);
}

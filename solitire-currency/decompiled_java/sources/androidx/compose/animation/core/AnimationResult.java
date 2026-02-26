package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Animatable.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class AnimationResult<T, V extends AnimationVector> {
    public static final int $stable = 0;

    @NotNull
    private final AnimationEndReason endReason;

    @NotNull
    private final AnimationState<T, V> endState;

    public AnimationResult(@NotNull AnimationState<T, V> endState, @NotNull AnimationEndReason endReason) {
        t.i(endState, "endState");
        t.i(endReason, "endReason");
        this.endState = endState;
        this.endReason = endReason;
    }

    @NotNull
    public final AnimationEndReason getEndReason() {
        return this.endReason;
    }

    @NotNull
    public final AnimationState<T, V> getEndState() {
        return this.endState;
    }

    @NotNull
    public String toString() {
        return "AnimationResult(endReason=" + this.endReason + ", endState=" + this.endState + ')';
    }
}

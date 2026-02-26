package androidx.compose.animation.core;

import kotlin.jvm.internal.m;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnimationState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnimationStateKt {
    @NotNull
    public static final AnimationState<Float, AnimationVector1D> AnimationState(float f10, float f11, long j10, long j11, boolean z10) {
        return new AnimationState<>(VectorConvertersKt.getVectorConverter(m.f29832a), Float.valueOf(f10), AnimationVectorsKt.AnimationVector(f11), j10, j11, z10);
    }

    public static /* synthetic */ AnimationState AnimationState$default(float f10, float f11, long j10, long j11, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        long j12 = (i10 & 4) != 0 ? Long.MIN_VALUE : j10;
        long j13 = (i10 & 8) == 0 ? j11 : Long.MIN_VALUE;
        if ((i10 & 16) != 0) {
            z10 = false;
        }
        return AnimationState(f10, f11, j12, j13, z10);
    }

    @NotNull
    public static final <T, V extends AnimationVector> AnimationState<T, V> copy(@NotNull AnimationState<T, V> animationState, T t10, @Nullable V v10, long j10, long j11, boolean z10) {
        t.i(animationState, "<this>");
        return new AnimationState<>(animationState.getTypeConverter(), t10, v10, j10, j11, z10);
    }

    public static /* synthetic */ AnimationState copy$default(AnimationState animationState, Object obj, AnimationVector animationVector, long j10, long j11, boolean z10, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = animationState.getValue();
        }
        if ((i10 & 2) != 0) {
            animationVector = AnimationVectorsKt.copy(animationState.getVelocityVector());
        }
        AnimationVector animationVector2 = animationVector;
        if ((i10 & 4) != 0) {
            j10 = animationState.getLastFrameTimeNanos();
        }
        long j12 = j10;
        if ((i10 & 8) != 0) {
            j11 = animationState.getFinishedTimeNanos();
        }
        long j13 = j11;
        if ((i10 & 16) != 0) {
            z10 = animationState.isRunning();
        }
        return copy((AnimationState<Object, AnimationVector>) animationState, obj, animationVector2, j12, j13, z10);
    }

    @NotNull
    public static final <T, V extends AnimationVector> V createZeroVectorFrom(@NotNull TwoWayConverter<T, V> twoWayConverter, T t10) {
        t.i(twoWayConverter, "<this>");
        return (V) AnimationVectorsKt.newInstance(twoWayConverter.getConvertToVector().invoke(t10));
    }

    public static final boolean isFinished(@NotNull AnimationState<?, ?> animationState) {
        t.i(animationState, "<this>");
        return animationState.getFinishedTimeNanos() != Long.MIN_VALUE;
    }

    @NotNull
    public static final AnimationState<Float, AnimationVector1D> copy(@NotNull AnimationState<Float, AnimationVector1D> animationState, float f10, float f11, long j10, long j11, boolean z10) {
        t.i(animationState, "<this>");
        return new AnimationState<>(animationState.getTypeConverter(), Float.valueOf(f10), AnimationVectorsKt.AnimationVector(f11), j10, j11, z10);
    }

    @NotNull
    public static final <T, V extends AnimationVector> AnimationState<T, V> AnimationState(@NotNull TwoWayConverter<T, V> typeConverter, T t10, T t11, long j10, long j11, boolean z10) {
        t.i(typeConverter, "typeConverter");
        return new AnimationState<>(typeConverter, t10, typeConverter.getConvertToVector().invoke(t11), j10, j11, z10);
    }

    public static /* synthetic */ AnimationState copy$default(AnimationState animationState, float f10, float f11, long j10, long j11, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = ((Number) animationState.getValue()).floatValue();
        }
        if ((i10 & 2) != 0) {
            f11 = ((AnimationVector1D) animationState.getVelocityVector()).getValue();
        }
        float f12 = f11;
        if ((i10 & 4) != 0) {
            j10 = animationState.getLastFrameTimeNanos();
        }
        long j12 = j10;
        if ((i10 & 8) != 0) {
            j11 = animationState.getFinishedTimeNanos();
        }
        long j13 = j11;
        if ((i10 & 16) != 0) {
            z10 = animationState.isRunning();
        }
        return copy((AnimationState<Float, AnimationVector1D>) animationState, f10, f12, j12, j13, z10);
    }
}

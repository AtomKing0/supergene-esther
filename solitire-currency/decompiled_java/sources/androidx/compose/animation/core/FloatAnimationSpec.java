package androidx.compose.animation.core;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FloatAnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
public interface FloatAnimationSpec extends AnimationSpec<Float> {

    /* JADX INFO: compiled from: FloatAnimationSpec.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static float getEndVelocity(@NotNull FloatAnimationSpec floatAnimationSpec, float f10, float f11, float f12) {
            return c.a(floatAnimationSpec, f10, f11, f12);
        }

        @Deprecated
        @NotNull
        public static <V extends AnimationVector> VectorizedFloatAnimationSpec<V> vectorize(@NotNull FloatAnimationSpec floatAnimationSpec, @NotNull TwoWayConverter<Float, V> converter) {
            t.i(converter, "converter");
            return c.c(floatAnimationSpec, converter);
        }
    }

    long getDurationNanos(float f10, float f11, float f12);

    float getEndVelocity(float f10, float f11, float f12);

    float getValueFromNanos(long j10, float f10, float f11, float f12);

    float getVelocityFromNanos(long j10, float f10, float f11, float f12);

    @Override // androidx.compose.animation.core.AnimationSpec
    /* bridge */ /* synthetic */ VectorizedAnimationSpec vectorize(TwoWayConverter twoWayConverter);

    @Override // androidx.compose.animation.core.AnimationSpec
    @NotNull
    <V extends AnimationVector> VectorizedFloatAnimationSpec<V> vectorize(@NotNull TwoWayConverter<Float, V> twoWayConverter);
}

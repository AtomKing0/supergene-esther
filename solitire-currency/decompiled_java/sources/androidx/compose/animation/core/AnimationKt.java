package androidx.compose.animation.core;

import h9.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Animation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnimationKt {
    public static final long MillisToNanos = 1000000;

    /* JADX INFO: Add missing generic type declarations: [V] */
    /* JADX INFO: renamed from: androidx.compose.animation.core.AnimationKt$createAnimation$1, reason: invalid class name */
    /* JADX INFO: compiled from: Animation.kt */
    static final class AnonymousClass1<V> extends v implements l<V, V> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        /* JADX WARN: Incorrect return type in method signature: (TV;)TV; */
        @Override // h9.l
        @NotNull
        public final AnimationVector invoke(@NotNull AnimationVector it) {
            t.i(it, "it");
            return it;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V] */
    /* JADX INFO: renamed from: androidx.compose.animation.core.AnimationKt$createAnimation$2, reason: invalid class name */
    /* JADX INFO: compiled from: Animation.kt */
    static final class AnonymousClass2<V> extends v implements l<V, V> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1);
        }

        /* JADX WARN: Incorrect return type in method signature: (TV;)TV; */
        @Override // h9.l
        @NotNull
        public final AnimationVector invoke(@NotNull AnimationVector it) {
            t.i(it, "it");
            return it;
        }
    }

    @NotNull
    public static final DecayAnimation<Float, AnimationVector1D> DecayAnimation(@NotNull FloatDecayAnimationSpec animationSpec, float f10, float f11) {
        t.i(animationSpec, "animationSpec");
        return new DecayAnimation<>((DecayAnimationSpec<Float>) DecayAnimationSpecKt.generateDecayAnimationSpec(animationSpec), VectorConvertersKt.getVectorConverter(m.f29832a), Float.valueOf(f10), AnimationVectorsKt.AnimationVector(f11));
    }

    public static /* synthetic */ DecayAnimation DecayAnimation$default(FloatDecayAnimationSpec floatDecayAnimationSpec, float f10, float f11, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            f11 = 0.0f;
        }
        return DecayAnimation(floatDecayAnimationSpec, f10, f11);
    }

    @NotNull
    public static final <T, V extends AnimationVector> TargetBasedAnimation<T, V> TargetBasedAnimation(@NotNull AnimationSpec<T> animationSpec, @NotNull TwoWayConverter<T, V> typeConverter, T t10, T t11, T t12) {
        t.i(animationSpec, "animationSpec");
        t.i(typeConverter, "typeConverter");
        return new TargetBasedAnimation<>(animationSpec, typeConverter, t10, t11, typeConverter.getConvertToVector().invoke(t12));
    }

    @NotNull
    public static final <V extends AnimationVector> TargetBasedAnimation<V, V> createAnimation(@NotNull VectorizedAnimationSpec<V> vectorizedAnimationSpec, @NotNull V initialValue, @NotNull V targetValue, @NotNull V initialVelocity) {
        t.i(vectorizedAnimationSpec, "<this>");
        t.i(initialValue, "initialValue");
        t.i(targetValue, "targetValue");
        t.i(initialVelocity, "initialVelocity");
        return new TargetBasedAnimation<>(vectorizedAnimationSpec, (TwoWayConverter<V, V>) VectorConvertersKt.TwoWayConverter(AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE), initialValue, targetValue, initialVelocity);
    }

    public static final long getDurationMillis(@NotNull Animation<?, ?> animation) {
        t.i(animation, "<this>");
        return animation.getDurationNanos() / 1000000;
    }

    public static final <T, V extends AnimationVector> T getVelocityFromNanos(@NotNull Animation<T, V> animation, long j10) {
        t.i(animation, "<this>");
        return (T) animation.getTypeConverter().getConvertFromVector().invoke(animation.getVelocityVectorFromNanos(j10));
    }
}

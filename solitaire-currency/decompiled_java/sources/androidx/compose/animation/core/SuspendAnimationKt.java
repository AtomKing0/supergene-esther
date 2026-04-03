package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.MotionDurationScale;
import h9.l;
import h9.p;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SuspendAnimation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SuspendAnimationKt {

    /* JADX INFO: Add missing generic type declarations: [T, V] */
    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animate$3, reason: invalid class name */
    /* JADX INFO: compiled from: SuspendAnimation.kt */
    static final class AnonymousClass3<T, V> extends v implements l<AnimationScope<T, V>, k0> {
        final /* synthetic */ p<T, T, k0> $block;
        final /* synthetic */ TwoWayConverter<T, V> $typeConverter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(p<? super T, ? super T, k0> pVar, TwoWayConverter<T, V> twoWayConverter) {
            super(1);
            this.$block = pVar;
            this.$typeConverter = twoWayConverter;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Object obj) {
            invoke((AnimationScope) obj);
            return k0.f35197a;
        }

        public final void invoke(@NotNull AnimationScope<T, V> animate) {
            t.i(animate, "$this$animate");
            this.$block.mo4invoke(animate.getValue(), this.$typeConverter.getConvertFromVector().invoke(animate.getVelocityVector()));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animate$4, reason: invalid class name */
    /* JADX INFO: compiled from: SuspendAnimation.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.animation.core.SuspendAnimationKt", f = "SuspendAnimation.kt", l = {233, 272}, m = "animate")
    static final class AnonymousClass4<T, V extends AnimationVector> extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass4(z8.d<? super AnonymousClass4> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SuspendAnimationKt.animate(null, null, 0L, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animate$5, reason: invalid class name */
    /* JADX INFO: compiled from: SuspendAnimation.kt */
    static final class AnonymousClass5 extends v implements l {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        AnonymousClass5() {
            super(1);
        }

        public final void invoke(@NotNull AnimationScope animationScope) {
            t.i(animationScope, "$this$null");
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((AnimationScope) obj);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animate$6, reason: invalid class name */
    /* JADX INFO: compiled from: SuspendAnimation.kt */
    static final class AnonymousClass6 extends v implements l<Long, k0> {
        final /* synthetic */ Animation<T, V> $animation;
        final /* synthetic */ l<AnimationScope<T, V>, k0> $block;
        final /* synthetic */ float $durationScale;
        final /* synthetic */ T $initialValue;

        /* JADX INFO: Incorrect field signature: TV; */
        final /* synthetic */ AnimationVector $initialVelocityVector;
        final /* synthetic */ n0<AnimationScope<T, V>> $lateInitScope;
        final /* synthetic */ AnimationState<T, V> $this_animate;

        /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animate$6$1, reason: invalid class name */
        /* JADX INFO: compiled from: SuspendAnimation.kt */
        static final class AnonymousClass1 extends v implements h9.a<k0> {
            final /* synthetic */ AnimationState<T, V> $this_animate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AnimationState<T, V> animationState) {
                super(0);
                this.$this_animate = animationState;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.$this_animate.setRunning$animation_core_release(false);
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ k0 invoke() {
                invoke2();
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/internal/n0<Landroidx/compose/animation/core/AnimationScope<TT;TV;>;>;TT;Landroidx/compose/animation/core/Animation<TT;TV;>;TV;Landroidx/compose/animation/core/AnimationState<TT;TV;>;FLh9/l<-Landroidx/compose/animation/core/AnimationScope<TT;TV;>;Lv8/k0;>;)V */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass6(n0 n0Var, Object obj, Animation animation, AnimationVector animationVector, AnimationState animationState, float f10, l lVar) {
            super(1);
            this.$lateInitScope = n0Var;
            this.$initialValue = obj;
            this.$animation = animation;
            this.$initialVelocityVector = animationVector;
            this.$this_animate = animationState;
            this.$durationScale = f10;
            this.$block = lVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Long l10) {
            invoke(l10.longValue());
            return k0.f35197a;
        }

        /* JADX WARN: Type inference failed for: r12v0, types: [T, androidx.compose.animation.core.AnimationScope] */
        public final void invoke(long j10) {
            n0<AnimationScope<T, V>> n0Var = this.$lateInitScope;
            ?? animationScope = new AnimationScope(this.$initialValue, this.$animation.getTypeConverter(), this.$initialVelocityVector, j10, this.$animation.getTargetValue(), j10, true, new AnonymousClass1(this.$this_animate));
            SuspendAnimationKt.doAnimationFrameWithScale(animationScope, j10, this.$durationScale, this.$animation, this.$this_animate, this.$block);
            n0Var.f29834a = animationScope;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animate$7, reason: invalid class name */
    /* JADX INFO: compiled from: SuspendAnimation.kt */
    static final class AnonymousClass7 extends v implements h9.a<k0> {
        final /* synthetic */ AnimationState<T, V> $this_animate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(AnimationState<T, V> animationState) {
            super(0);
            this.$this_animate = animationState;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$this_animate.setRunning$animation_core_release(false);
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animate$9, reason: invalid class name */
    /* JADX INFO: compiled from: SuspendAnimation.kt */
    static final class AnonymousClass9 extends v implements l<Long, k0> {
        final /* synthetic */ Animation<T, V> $animation;
        final /* synthetic */ l<AnimationScope<T, V>, k0> $block;
        final /* synthetic */ float $durationScale;
        final /* synthetic */ n0<AnimationScope<T, V>> $lateInitScope;
        final /* synthetic */ AnimationState<T, V> $this_animate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass9(n0<AnimationScope<T, V>> n0Var, float f10, Animation<T, V> animation, AnimationState<T, V> animationState, l<? super AnimationScope<T, V>, k0> lVar) {
            super(1);
            this.$lateInitScope = n0Var;
            this.$durationScale = f10;
            this.$animation = animation;
            this.$this_animate = animationState;
            this.$block = lVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Long l10) {
            invoke(l10.longValue());
            return k0.f35197a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void invoke(long j10) {
            T t10 = this.$lateInitScope.f29834a;
            t.f(t10);
            SuspendAnimationKt.doAnimationFrameWithScale((AnimationScope) t10, j10, this.$durationScale, this.$animation, this.$this_animate, this.$block);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animateDecay$2, reason: invalid class name */
    /* JADX INFO: compiled from: SuspendAnimation.kt */
    static final class AnonymousClass2 extends v implements l<AnimationScope<Float, AnimationVector1D>, k0> {
        final /* synthetic */ p<Float, Float, k0> $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(p<? super Float, ? super Float, k0> pVar) {
            super(1);
            this.$block = pVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
            invoke2(animationScope);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull AnimationScope<Float, AnimationVector1D> animate) {
            t.i(animate, "$this$animate");
            this.$block.mo4invoke(animate.getValue(), Float.valueOf(((AnimationVector1D) animate.getVelocityVector()).getValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animateDecay$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SuspendAnimation.kt */
    public static final class C08084 extends v implements l {
        public static final C08084 INSTANCE = new C08084();

        C08084() {
            super(1);
        }

        public final void invoke(@NotNull AnimationScope animationScope) {
            t.i(animationScope, "$this$null");
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((AnimationScope) obj);
            return k0.f35197a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animateTo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SuspendAnimation.kt */
    public static final class C08092 extends v implements l {
        public static final C08092 INSTANCE = new C08092();

        C08092() {
            super(1);
        }

        public final void invoke(@NotNull AnimationScope animationScope) {
            t.i(animationScope, "$this$null");
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((AnimationScope) obj);
            return k0.f35197a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$callWithFrameNanos$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SuspendAnimation.kt */
    static final class C08102<R> extends v implements l<Long, R> {
        final /* synthetic */ l<Long, R> $onFrame;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08102(l<? super Long, ? extends R> lVar) {
            super(1);
            this.$onFrame = lVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Object invoke(Long l10) {
            return invoke(l10.longValue());
        }

        public final R invoke(long j10) {
            return this.$onFrame.invoke(Long.valueOf(j10 / 1));
        }
    }

    @Nullable
    public static final Object animate(float f10, float f11, float f12, @NotNull AnimationSpec<Float> animationSpec, @NotNull p<? super Float, ? super Float, k0> pVar, @NotNull z8.d<? super k0> dVar) {
        Object objAnimate = animate(VectorConvertersKt.getVectorConverter(m.f29832a), kotlin.coroutines.jvm.internal.b.c(f10), kotlin.coroutines.jvm.internal.b.c(f11), kotlin.coroutines.jvm.internal.b.c(f12), animationSpec, pVar, dVar);
        return objAnimate == a9.d.e() ? objAnimate : k0.f35197a;
    }

    public static /* synthetic */ Object animate$default(float f10, float f11, float f12, AnimationSpec animationSpec, p pVar, z8.d dVar, int i10, Object obj) {
        float f13 = (i10 & 4) != 0 ? 0.0f : f12;
        if ((i10 & 8) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        return animate(f10, f11, f13, animationSpec, pVar, dVar);
    }

    @Nullable
    public static final Object animateDecay(float f10, float f11, @NotNull FloatDecayAnimationSpec floatDecayAnimationSpec, @NotNull p<? super Float, ? super Float, k0> pVar, @NotNull z8.d<? super k0> dVar) {
        Object objAnimate$default = animate$default(AnimationStateKt.AnimationState$default(f10, f11, 0L, 0L, false, 28, null), AnimationKt.DecayAnimation(floatDecayAnimationSpec, f10, f11), 0L, new AnonymousClass2(pVar), dVar, 2, null);
        return objAnimate$default == a9.d.e() ? objAnimate$default : k0.f35197a;
    }

    public static /* synthetic */ Object animateDecay$default(AnimationState animationState, DecayAnimationSpec decayAnimationSpec, boolean z10, l lVar, z8.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            lVar = C08084.INSTANCE;
        }
        return animateDecay(animationState, decayAnimationSpec, z10, lVar, (z8.d<? super k0>) dVar);
    }

    @Nullable
    public static final <T, V extends AnimationVector> Object animateTo(@NotNull AnimationState<T, V> animationState, T t10, @NotNull AnimationSpec<T> animationSpec, boolean z10, @NotNull l<? super AnimationScope<T, V>, k0> lVar, @NotNull z8.d<? super k0> dVar) {
        Object objAnimate = animate(animationState, new TargetBasedAnimation(animationSpec, animationState.getTypeConverter(), animationState.getValue(), t10, animationState.getVelocityVector()), z10 ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, lVar, dVar);
        return objAnimate == a9.d.e() ? objAnimate : k0.f35197a;
    }

    public static /* synthetic */ Object animateTo$default(AnimationState animationState, Object obj, AnimationSpec animationSpec, boolean z10, l lVar, z8.d dVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        boolean z11 = z10;
        if ((i10 & 8) != 0) {
            lVar = C08092.INSTANCE;
        }
        return animateTo(animationState, obj, animationSpec2, z11, lVar, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <R, T, V extends AnimationVector> Object callWithFrameNanos(Animation<T, V> animation, l<? super Long, ? extends R> lVar, z8.d<? super R> dVar) {
        return animation.isInfinite() ? InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(lVar, dVar) : MonotonicFrameClockKt.withFrameNanos(new C08102(lVar), dVar);
    }

    private static final <T, V extends AnimationVector> void doAnimationFrame(AnimationScope<T, V> animationScope, long j10, long j11, Animation<T, V> animation, AnimationState<T, V> animationState, l<? super AnimationScope<T, V>, k0> lVar) {
        animationScope.setLastFrameTimeNanos$animation_core_release(j10);
        animationScope.setValue$animation_core_release(animation.getValueFromNanos(j11));
        animationScope.setVelocityVector$animation_core_release(animation.getVelocityVectorFromNanos(j11));
        if (animation.isFinishedFromNanos(j11)) {
            animationScope.setFinishedTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
            animationScope.setRunning$animation_core_release(false);
        }
        updateState(animationScope, animationState);
        lVar.invoke(animationScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T, V extends AnimationVector> void doAnimationFrameWithScale(AnimationScope<T, V> animationScope, long j10, float f10, Animation<T, V> animation, AnimationState<T, V> animationState, l<? super AnimationScope<T, V>, k0> lVar) {
        doAnimationFrame(animationScope, j10, (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1)) == 0 ? animation.getDurationNanos() : (long) ((j10 - animationScope.getStartTimeNanos()) / f10), animation, animationState, lVar);
    }

    public static final float getDurationScale(@NotNull z8.g gVar) {
        t.i(gVar, "<this>");
        MotionDurationScale motionDurationScale = (MotionDurationScale) gVar.get(MotionDurationScale.Key);
        float scaleFactor = motionDurationScale != null ? motionDurationScale.getScaleFactor() : 1.0f;
        if (scaleFactor >= 0.0f) {
            return scaleFactor;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public static final <T, V extends AnimationVector> void updateState(@NotNull AnimationScope<T, V> animationScope, @NotNull AnimationState<T, V> state) {
        t.i(animationScope, "<this>");
        t.i(state, "state");
        state.setValue$animation_core_release(animationScope.getValue());
        AnimationVectorsKt.copyFrom(state.getVelocityVector(), animationScope.getVelocityVector());
        state.setFinishedTimeNanos$animation_core_release(animationScope.getFinishedTimeNanos());
        state.setLastFrameTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
        state.setRunning$animation_core_release(animationScope.isRunning());
    }

    @Nullable
    public static final <T, V extends AnimationVector> Object animateDecay(@NotNull AnimationState<T, V> animationState, @NotNull DecayAnimationSpec<T> decayAnimationSpec, boolean z10, @NotNull l<? super AnimationScope<T, V>, k0> lVar, @NotNull z8.d<? super k0> dVar) {
        Object objAnimate = animate(animationState, new DecayAnimation((DecayAnimationSpec) decayAnimationSpec, (TwoWayConverter<T, AnimationVector>) animationState.getTypeConverter(), (Object) animationState.getValue(), animationState.getVelocityVector()), z10 ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, lVar, dVar);
        return objAnimate == a9.d.e() ? objAnimate : k0.f35197a;
    }

    public static /* synthetic */ Object animate$default(AnimationState animationState, Animation animation, long j10, l lVar, z8.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = Long.MIN_VALUE;
        }
        long j11 = j10;
        if ((i10 & 4) != 0) {
            lVar = AnonymousClass5.INSTANCE;
        }
        return animate(animationState, animation, j11, lVar, dVar);
    }

    @Nullable
    public static final <T, V extends AnimationVector> Object animate(@NotNull TwoWayConverter<T, V> twoWayConverter, T t10, T t11, @Nullable T t12, @NotNull AnimationSpec<T> animationSpec, @NotNull p<? super T, ? super T, k0> pVar, @NotNull z8.d<? super k0> dVar) {
        V vNewInstance;
        if (t12 == null || (vNewInstance = twoWayConverter.getConvertToVector().invoke(t12)) == null) {
            vNewInstance = AnimationVectorsKt.newInstance(twoWayConverter.getConvertToVector().invoke(t10));
        }
        Object objAnimate$default = animate$default(new AnimationState(twoWayConverter, t10, vNewInstance, 0L, 0L, false, 56, null), new TargetBasedAnimation(animationSpec, twoWayConverter, t10, t11, vNewInstance), 0L, new AnonymousClass3(pVar, twoWayConverter), dVar, 2, null);
        return objAnimate$default == a9.d.e() ? objAnimate$default : k0.f35197a;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r7v0, types: [T, androidx.compose.animation.core.AnimationScope] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T, V extends androidx.compose.animation.core.AnimationVector> java.lang.Object animate(@org.jetbrains.annotations.NotNull androidx.compose.animation.core.AnimationState<T, V> r25, @org.jetbrains.annotations.NotNull androidx.compose.animation.core.Animation<T, V> r26, long r27, @org.jetbrains.annotations.NotNull h9.l<? super androidx.compose.animation.core.AnimationScope<T, V>, v8.k0> r29, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r30) {
        /*
            Method dump skipped, instruction units count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SuspendAnimationKt.animate(androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.Animation, long, h9.l, z8.d):java.lang.Object");
    }
}

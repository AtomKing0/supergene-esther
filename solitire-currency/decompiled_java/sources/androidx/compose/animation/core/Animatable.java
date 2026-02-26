package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: Animatable.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class Animatable<T, V extends AnimationVector> {
    public static final int $stable = 8;

    @NotNull
    private final SpringSpec<T> defaultSpringSpec;

    @NotNull
    private final AnimationState<T, V> internalState;

    @NotNull
    private final MutableState isRunning$delegate;

    @Nullable
    private T lowerBound;

    @NotNull
    private V lowerBoundVector;

    @NotNull
    private final MutatorMutex mutatorMutex;

    @NotNull
    private final V negativeInfinityBounds;

    @NotNull
    private final V positiveInfinityBounds;

    @NotNull
    private final MutableState targetValue$delegate;

    @NotNull
    private final TwoWayConverter<T, V> typeConverter;

    @Nullable
    private T upperBound;

    @NotNull
    private V upperBoundVector;

    @Nullable
    private final T visibilityThreshold;

    /* JADX INFO: renamed from: androidx.compose.animation.core.Animatable$runAnimation$2, reason: invalid class name */
    /* JADX INFO: compiled from: Animatable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.animation.core.Animatable$runAnimation$2", f = "Animatable.kt", l = {291}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements h9.l<z8.d<? super AnimationResult<T, V>>, Object> {
        final /* synthetic */ Animation<T, V> $animation;
        final /* synthetic */ h9.l<Animatable<T, V>, k0> $block;
        final /* synthetic */ T $initialVelocity;
        final /* synthetic */ long $startTime;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ Animatable<T, V> this$0;

        /* JADX INFO: renamed from: androidx.compose.animation.core.Animatable$runAnimation$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Animatable.kt */
        static final class AnonymousClass1 extends v implements h9.l<AnimationScope<T, V>, k0> {
            final /* synthetic */ h9.l<Animatable<T, V>, k0> $block;
            final /* synthetic */ i0 $clampingNeeded;
            final /* synthetic */ AnimationState<T, V> $endState;
            final /* synthetic */ Animatable<T, V> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Animatable<T, V> animatable, AnimationState<T, V> animationState, h9.l<? super Animatable<T, V>, k0> lVar, i0 i0Var) {
                super(1);
                this.this$0 = animatable;
                this.$endState = animationState;
                this.$block = lVar;
                this.$clampingNeeded = i0Var;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(Object obj) {
                invoke((AnimationScope) obj);
                return k0.f35197a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(@NotNull AnimationScope<T, V> animate) {
                t.i(animate, "$this$animate");
                SuspendAnimationKt.updateState(animate, this.this$0.getInternalState$animation_core_release());
                Object objClampToBounds = this.this$0.clampToBounds(animate.getValue());
                if (t.d(objClampToBounds, animate.getValue())) {
                    h9.l<Animatable<T, V>, k0> lVar = this.$block;
                    if (lVar != null) {
                        lVar.invoke(this.this$0);
                        return;
                    }
                    return;
                }
                this.this$0.getInternalState$animation_core_release().setValue$animation_core_release(objClampToBounds);
                this.$endState.setValue$animation_core_release(objClampToBounds);
                h9.l<Animatable<T, V>, k0> lVar2 = this.$block;
                if (lVar2 != null) {
                    lVar2.invoke(this.this$0);
                }
                animate.cancelAnimation();
                this.$clampingNeeded.f29826a = true;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Animatable<T, V> animatable, T t10, Animation<T, V> animation, long j10, h9.l<? super Animatable<T, V>, k0> lVar, z8.d<? super AnonymousClass2> dVar) {
            super(1, dVar);
            this.this$0 = animatable;
            this.$initialVelocity = t10;
            this.$animation = animation;
            this.$startTime = j10;
            this.$block = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@NotNull z8.d<?> dVar) {
            return new AnonymousClass2(this.this$0, this.$initialVelocity, this.$animation, this.$startTime, this.$block, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            AnimationState animationState;
            i0 i0Var;
            Object objE = a9.d.e();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    u.b(obj);
                    this.this$0.getInternalState$animation_core_release().setVelocityVector$animation_core_release(this.this$0.getTypeConverter().getConvertToVector().invoke(this.$initialVelocity));
                    this.this$0.setTargetValue(this.$animation.getTargetValue());
                    this.this$0.setRunning(true);
                    AnimationState animationStateCopy$default = AnimationStateKt.copy$default((AnimationState) this.this$0.getInternalState$animation_core_release(), (Object) null, (AnimationVector) null, 0L, Long.MIN_VALUE, false, 23, (Object) null);
                    i0 i0Var2 = new i0();
                    Animation<T, V> animation = this.$animation;
                    long j10 = this.$startTime;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, animationStateCopy$default, this.$block, i0Var2);
                    this.L$0 = animationStateCopy$default;
                    this.L$1 = i0Var2;
                    this.label = 1;
                    if (SuspendAnimationKt.animate(animationStateCopy$default, animation, j10, anonymousClass1, this) == objE) {
                        return objE;
                    }
                    animationState = animationStateCopy$default;
                    i0Var = i0Var2;
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i0Var = (i0) this.L$1;
                    animationState = (AnimationState) this.L$0;
                    u.b(obj);
                }
                AnimationEndReason animationEndReason = i0Var.f29826a ? AnimationEndReason.BoundReached : AnimationEndReason.Finished;
                this.this$0.endAnimation();
                return new AnimationResult(animationState, animationEndReason);
            } catch (CancellationException e10) {
                this.this$0.endAnimation();
                throw e10;
            }
        }

        @Override // h9.l
        @Nullable
        public final Object invoke(@Nullable z8.d<? super AnimationResult<T, V>> dVar) {
            return ((AnonymousClass2) create(dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.Animatable$snapTo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Animatable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.animation.core.Animatable$snapTo$2", f = "Animatable.kt", l = {}, m = "invokeSuspend")
    static final class C08042 extends l implements h9.l<z8.d<? super k0>, Object> {
        final /* synthetic */ T $targetValue;
        int label;
        final /* synthetic */ Animatable<T, V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08042(Animatable<T, V> animatable, T t10, z8.d<? super C08042> dVar) {
            super(1, dVar);
            this.this$0 = animatable;
            this.$targetValue = t10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@NotNull z8.d<?> dVar) {
            return new C08042(this.this$0, this.$targetValue, dVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            this.this$0.endAnimation();
            Object objClampToBounds = this.this$0.clampToBounds(this.$targetValue);
            this.this$0.getInternalState$animation_core_release().setValue$animation_core_release(objClampToBounds);
            this.this$0.setTargetValue(objClampToBounds);
            return k0.f35197a;
        }

        @Override // h9.l
        @Nullable
        public final Object invoke(@Nullable z8.d<? super k0> dVar) {
            return ((C08042) create(dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.Animatable$stop$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Animatable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.animation.core.Animatable$stop$2", f = "Animatable.kt", l = {}, m = "invokeSuspend")
    static final class C08052 extends l implements h9.l<z8.d<? super k0>, Object> {
        int label;
        final /* synthetic */ Animatable<T, V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08052(Animatable<T, V> animatable, z8.d<? super C08052> dVar) {
            super(1, dVar);
            this.this$0 = animatable;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@NotNull z8.d<?> dVar) {
            return new C08052(this.this$0, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            this.this$0.endAnimation();
            return k0.f35197a;
        }

        @Override // h9.l
        @Nullable
        public final Object invoke(@Nullable z8.d<? super k0> dVar) {
            return ((C08052) create(dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public Animatable(T t10, @NotNull TwoWayConverter<T, V> typeConverter, @Nullable T t11) {
        t.i(typeConverter, "typeConverter");
        this.typeConverter = typeConverter;
        this.visibilityThreshold = t11;
        this.internalState = new AnimationState<>(typeConverter, t10, null, 0L, 0L, false, 60, null);
        this.isRunning$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.targetValue$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t10, null, 2, null);
        this.mutatorMutex = new MutatorMutex();
        this.defaultSpringSpec = new SpringSpec<>(0.0f, 0.0f, t11, 3, null);
        V v10 = (V) createVector(t10, Float.NEGATIVE_INFINITY);
        this.negativeInfinityBounds = v10;
        V v11 = (V) createVector(t10, Float.POSITIVE_INFINITY);
        this.positiveInfinityBounds = v11;
        this.lowerBoundVector = v10;
        this.upperBoundVector = v11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateDecay$default(Animatable animatable, Object obj, DecayAnimationSpec decayAnimationSpec, h9.l lVar, z8.d dVar, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            lVar = null;
        }
        return animatable.animateDecay(obj, decayAnimationSpec, lVar, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(Animatable animatable, Object obj, AnimationSpec animationSpec, Object obj2, h9.l lVar, z8.d dVar, int i10, Object obj3) {
        if ((i10 & 2) != 0) {
            animationSpec = animatable.defaultSpringSpec;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i10 & 4) != 0) {
            obj2 = animatable.getVelocity();
        }
        Object obj4 = obj2;
        if ((i10 & 8) != 0) {
            lVar = null;
        }
        return animatable.animateTo(obj, animationSpec2, obj4, lVar, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T clampToBounds(T t10) {
        if (t.d(this.lowerBoundVector, this.negativeInfinityBounds) && t.d(this.upperBoundVector, this.positiveInfinityBounds)) {
            return t10;
        }
        V vInvoke = this.typeConverter.getConvertToVector().invoke(t10);
        int size$animation_core_release = vInvoke.getSize$animation_core_release();
        boolean z10 = false;
        for (int i10 = 0; i10 < size$animation_core_release; i10++) {
            if (vInvoke.get$animation_core_release(i10) < this.lowerBoundVector.get$animation_core_release(i10) || vInvoke.get$animation_core_release(i10) > this.upperBoundVector.get$animation_core_release(i10)) {
                vInvoke.set$animation_core_release(i10, o.m(vInvoke.get$animation_core_release(i10), this.lowerBoundVector.get$animation_core_release(i10), this.upperBoundVector.get$animation_core_release(i10)));
                z10 = true;
            }
        }
        return z10 ? this.typeConverter.getConvertFromVector().invoke(vInvoke) : t10;
    }

    private final V createVector(T t10, float f10) {
        V vInvoke = this.typeConverter.getConvertToVector().invoke(t10);
        int size$animation_core_release = vInvoke.getSize$animation_core_release();
        for (int i10 = 0; i10 < size$animation_core_release; i10++) {
            vInvoke.set$animation_core_release(i10, f10);
        }
        return vInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void endAnimation() {
        AnimationState<T, V> animationState = this.internalState;
        animationState.getVelocityVector().reset$animation_core_release();
        animationState.setLastFrameTimeNanos$animation_core_release(Long.MIN_VALUE);
        setRunning(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object runAnimation(Animation<T, V> animation, T t10, h9.l<? super Animatable<T, V>, k0> lVar, z8.d<? super AnimationResult<T, V>> dVar) {
        return MutatorMutex.mutate$default(this.mutatorMutex, null, new AnonymousClass2(this, t10, animation, this.internalState.getLastFrameTimeNanos(), lVar, null), dVar, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRunning(boolean z10) {
        this.isRunning$delegate.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTargetValue(T t10) {
        this.targetValue$delegate.setValue(t10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateBounds$default(Animatable animatable, Object obj, Object obj2, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            obj = animatable.lowerBound;
        }
        if ((i10 & 2) != 0) {
            obj2 = animatable.upperBound;
        }
        animatable.updateBounds(obj, obj2);
    }

    @Nullable
    public final Object animateDecay(T t10, @NotNull DecayAnimationSpec<T> decayAnimationSpec, @Nullable h9.l<? super Animatable<T, V>, k0> lVar, @NotNull z8.d<? super AnimationResult<T, V>> dVar) {
        return runAnimation(new DecayAnimation((DecayAnimationSpec) decayAnimationSpec, (TwoWayConverter) this.typeConverter, (Object) getValue(), (AnimationVector) this.typeConverter.getConvertToVector().invoke(t10)), t10, lVar, dVar);
    }

    @Nullable
    public final Object animateTo(T t10, @NotNull AnimationSpec<T> animationSpec, T t11, @Nullable h9.l<? super Animatable<T, V>, k0> lVar, @NotNull z8.d<? super AnimationResult<T, V>> dVar) {
        return runAnimation(AnimationKt.TargetBasedAnimation(animationSpec, this.typeConverter, getValue(), t10, t11), t11, lVar, dVar);
    }

    @NotNull
    public final State<T> asState() {
        return this.internalState;
    }

    @NotNull
    public final SpringSpec<T> getDefaultSpringSpec$animation_core_release() {
        return this.defaultSpringSpec;
    }

    @NotNull
    public final AnimationState<T, V> getInternalState$animation_core_release() {
        return this.internalState;
    }

    @Nullable
    public final T getLowerBound() {
        return this.lowerBound;
    }

    public final T getTargetValue() {
        return this.targetValue$delegate.getValue();
    }

    @NotNull
    public final TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    @Nullable
    public final T getUpperBound() {
        return this.upperBound;
    }

    public final T getValue() {
        return this.internalState.getValue();
    }

    public final T getVelocity() {
        return (T) this.typeConverter.getConvertFromVector().invoke(getVelocityVector());
    }

    @NotNull
    public final V getVelocityVector() {
        return (V) this.internalState.getVelocityVector();
    }

    public final boolean isRunning() {
        return ((Boolean) this.isRunning$delegate.getValue()).booleanValue();
    }

    @Nullable
    public final Object snapTo(T t10, @NotNull z8.d<? super k0> dVar) {
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new C08042(this, t10, null), dVar, 1, null);
        return objMutate$default == a9.d.e() ? objMutate$default : k0.f35197a;
    }

    @Nullable
    public final Object stop(@NotNull z8.d<? super k0> dVar) {
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new C08052(this, null), dVar, 1, null);
        return objMutate$default == a9.d.e() ? objMutate$default : k0.f35197a;
    }

    public final void updateBounds(@Nullable T t10, @Nullable T t11) {
        V vInvoke;
        V vInvoke2;
        if (t10 == null || (vInvoke = this.typeConverter.getConvertToVector().invoke(t10)) == null) {
            vInvoke = this.negativeInfinityBounds;
        }
        if (t11 == null || (vInvoke2 = this.typeConverter.getConvertToVector().invoke(t11)) == null) {
            vInvoke2 = this.positiveInfinityBounds;
        }
        int size$animation_core_release = vInvoke.getSize$animation_core_release();
        for (int i10 = 0; i10 < size$animation_core_release; i10++) {
            if (!(vInvoke.get$animation_core_release(i10) <= vInvoke2.get$animation_core_release(i10))) {
                throw new IllegalStateException(("Lower bound must be no greater than upper bound on *all* dimensions. The provided lower bound: " + vInvoke + " is greater than upper bound " + vInvoke2 + " on index " + i10).toString());
            }
        }
        this.lowerBoundVector = vInvoke;
        this.upperBoundVector = vInvoke2;
        this.upperBound = t11;
        this.lowerBound = t10;
        if (isRunning()) {
            return;
        }
        T tClampToBounds = clampToBounds(getValue());
        if (t.d(tClampToBounds, getValue())) {
            return;
        }
        this.internalState.setValue$animation_core_release(tClampToBounds);
    }

    public /* synthetic */ Animatable(Object obj, TwoWayConverter twoWayConverter, Object obj2, int i10, k kVar) {
        this(obj, twoWayConverter, (i10 & 4) != 0 ? null : obj2);
    }
}

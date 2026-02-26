package androidx.compose.animation.core;

import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import h9.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: InfiniteTransition.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InfiniteTransitionKt {

    /* JADX INFO: renamed from: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$1, reason: invalid class name */
    /* JADX INFO: compiled from: InfiniteTransition.kt */
    static final class AnonymousClass1 extends v implements h9.a<k0> {
        final /* synthetic */ InfiniteRepeatableSpec<T> $animationSpec;
        final /* synthetic */ T $initialValue;
        final /* synthetic */ T $targetValue;
        final /* synthetic */ InfiniteTransition.TransitionAnimationState<T, V> $transitionAnimation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(T t10, InfiniteTransition.TransitionAnimationState<T, V> transitionAnimationState, T t11, InfiniteRepeatableSpec<T> infiniteRepeatableSpec) {
            super(0);
            this.$initialValue = t10;
            this.$transitionAnimation = transitionAnimationState;
            this.$targetValue = t11;
            this.$animationSpec = infiniteRepeatableSpec;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (t.d(this.$initialValue, this.$transitionAnimation.getInitialValue()) && t.d(this.$targetValue, this.$transitionAnimation.getTargetValue())) {
                return;
            }
            this.$transitionAnimation.updateValues(this.$initialValue, this.$targetValue, this.$animationSpec);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$2, reason: invalid class name */
    /* JADX INFO: compiled from: InfiniteTransition.kt */
    static final class AnonymousClass2 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ InfiniteTransition $this_animateValue;
        final /* synthetic */ InfiniteTransition.TransitionAnimationState<T, V> $transitionAnimation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(InfiniteTransition infiniteTransition, InfiniteTransition.TransitionAnimationState<T, V> transitionAnimationState) {
            super(1);
            this.$this_animateValue = infiniteTransition;
            this.$transitionAnimation = transitionAnimationState;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            this.$this_animateValue.addAnimation$animation_core_release(this.$transitionAnimation);
            final InfiniteTransition infiniteTransition = this.$this_animateValue;
            final InfiniteTransition.TransitionAnimationState<T, V> transitionAnimationState = this.$transitionAnimation;
            return new DisposableEffectResult() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$2$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    infiniteTransition.removeAnimation$animation_core_release(transitionAnimationState);
                }
            };
        }
    }

    @Composable
    @NotNull
    public static final State<Float> animateFloat(@NotNull InfiniteTransition infiniteTransition, float f10, float f11, @NotNull InfiniteRepeatableSpec<Float> animationSpec, @Nullable Composer composer, int i10) {
        t.i(infiniteTransition, "<this>");
        t.i(animationSpec, "animationSpec");
        composer.startReplaceableGroup(469472752);
        State<Float> stateAnimateValue = animateValue(infiniteTransition, Float.valueOf(f10), Float.valueOf(f11), VectorConvertersKt.getVectorConverter(m.f29832a), animationSpec, composer, (i10 & 112) | 8 | (i10 & 896) | ((i10 << 3) & 57344));
        composer.endReplaceableGroup();
        return stateAnimateValue;
    }

    @Composable
    @NotNull
    public static final <T, V extends AnimationVector> State<T> animateValue(@NotNull InfiniteTransition infiniteTransition, T t10, T t11, @NotNull TwoWayConverter<T, V> typeConverter, @NotNull InfiniteRepeatableSpec<T> animationSpec, @Nullable Composer composer, int i10) {
        t.i(infiniteTransition, "<this>");
        t.i(typeConverter, "typeConverter");
        t.i(animationSpec, "animationSpec");
        composer.startReplaceableGroup(-1695411770);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new InfiniteTransition.TransitionAnimationState(infiniteTransition, t10, t11, typeConverter, animationSpec);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        InfiniteTransition.TransitionAnimationState transitionAnimationState = (InfiniteTransition.TransitionAnimationState) objRememberedValue;
        EffectsKt.SideEffect(new AnonymousClass1(t10, transitionAnimationState, t11, animationSpec), composer, 0);
        EffectsKt.DisposableEffect(transitionAnimationState, new AnonymousClass2(infiniteTransition, transitionAnimationState), composer, 6);
        composer.endReplaceableGroup();
        return transitionAnimationState;
    }

    @Composable
    @NotNull
    public static final InfiniteTransition rememberInfiniteTransition(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-840193660);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new InfiniteTransition();
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        InfiniteTransition infiniteTransition = (InfiniteTransition) objRememberedValue;
        infiniteTransition.run$animation_core_release(composer, 8);
        composer.endReplaceableGroup();
        return infiniteTransition;
    }
}

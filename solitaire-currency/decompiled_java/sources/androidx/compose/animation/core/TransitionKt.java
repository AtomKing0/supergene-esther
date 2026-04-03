package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import h9.l;
import h9.q;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TransitionKt {
    public static final int AnimationDebugDurationScale = 1;

    /* JADX INFO: Add missing generic type declarations: [S] */
    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$animateDp$1, reason: invalid class name */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class AnonymousClass1<S> extends v implements q<Transition.Segment<S>, Composer, Integer, SpringSpec<Dp>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(3);
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ SpringSpec<Dp> invoke(Object obj, Composer composer, Integer num) {
            return invoke((Transition.Segment) obj, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final SpringSpec<Dp> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer, int i10) {
            t.i(segment, "$this$null");
            composer.startReplaceableGroup(-575880366);
            SpringSpec<Dp> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Dp.m3671boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Dp.Companion)), 3, null);
            composer.endReplaceableGroup();
            return springSpecSpring$default;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S] */
    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$animateFloat$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class C08111<S> extends v implements q<Transition.Segment<S>, Composer, Integer, SpringSpec<Float>> {
        public static final C08111 INSTANCE = new C08111();

        public C08111() {
            super(3);
        }

        @Composable
        @NotNull
        public final SpringSpec<Float> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer, int i10) {
            t.i(segment, "$this$null");
            composer.startReplaceableGroup(-522164544);
            SpringSpec<Float> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            composer.endReplaceableGroup();
            return springSpecSpring$default;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ SpringSpec<Float> invoke(Object obj, Composer composer, Integer num) {
            return invoke((Transition.Segment) obj, composer, num.intValue());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S] */
    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$animateInt$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class C08121<S> extends v implements q<Transition.Segment<S>, Composer, Integer, SpringSpec<Integer>> {
        public static final C08121 INSTANCE = new C08121();

        public C08121() {
            super(3);
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ SpringSpec<Integer> invoke(Object obj, Composer composer, Integer num) {
            return invoke((Transition.Segment) obj, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final SpringSpec<Integer> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer, int i10) {
            t.i(segment, "$this$null");
            composer.startReplaceableGroup(-785273069);
            SpringSpec<Integer> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, 1, 3, null);
            composer.endReplaceableGroup();
            return springSpecSpring$default;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S] */
    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$animateIntOffset$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class C08131<S> extends v implements q<Transition.Segment<S>, Composer, Integer, SpringSpec<IntOffset>> {
        public static final C08131 INSTANCE = new C08131();

        public C08131() {
            super(3);
        }

        @Composable
        @NotNull
        public final SpringSpec<IntOffset> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer, int i10) {
            t.i(segment, "$this$null");
            composer.startReplaceableGroup(-1953479610);
            SpringSpec<IntOffset> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m3782boximpl(IntOffsetKt.IntOffset(1, 1)), 3, null);
            composer.endReplaceableGroup();
            return springSpecSpring$default;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ SpringSpec<IntOffset> invoke(Object obj, Composer composer, Integer num) {
            return invoke((Transition.Segment) obj, composer, num.intValue());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S] */
    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$animateIntSize$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class C08141<S> extends v implements q<Transition.Segment<S>, Composer, Integer, SpringSpec<IntSize>> {
        public static final C08141 INSTANCE = new C08141();

        public C08141() {
            super(3);
        }

        @Composable
        @NotNull
        public final SpringSpec<IntSize> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer, int i10) {
            t.i(segment, "$this$null");
            composer.startReplaceableGroup(967893300);
            SpringSpec<IntSize> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, IntSize.m3825boximpl(IntSizeKt.IntSize(1, 1)), 3, null);
            composer.endReplaceableGroup();
            return springSpecSpring$default;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ SpringSpec<IntSize> invoke(Object obj, Composer composer, Integer num) {
            return invoke((Transition.Segment) obj, composer, num.intValue());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S] */
    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$animateOffset$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class C08151<S> extends v implements q<Transition.Segment<S>, Composer, Integer, SpringSpec<Offset>> {
        public static final C08151 INSTANCE = new C08151();

        public C08151() {
            super(3);
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ SpringSpec<Offset> invoke(Object obj, Composer composer, Integer num) {
            return invoke((Transition.Segment) obj, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final SpringSpec<Offset> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer, int i10) {
            t.i(segment, "$this$null");
            composer.startReplaceableGroup(1623385561);
            SpringSpec<Offset> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Offset.m1356boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.Companion)), 3, null);
            composer.endReplaceableGroup();
            return springSpecSpring$default;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S] */
    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$animateRect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class C08161<S> extends v implements q<Transition.Segment<S>, Composer, Integer, SpringSpec<Rect>> {
        public static final C08161 INSTANCE = new C08161();

        public C08161() {
            super(3);
        }

        @Composable
        @NotNull
        public final SpringSpec<Rect> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer, int i10) {
            t.i(segment, "$this$null");
            composer.startReplaceableGroup(691336298);
            SpringSpec<Rect> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.Companion), 3, null);
            composer.endReplaceableGroup();
            return springSpecSpring$default;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ SpringSpec<Rect> invoke(Object obj, Composer composer, Integer num) {
            return invoke((Transition.Segment) obj, composer, num.intValue());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S] */
    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$animateSize$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class C08171<S> extends v implements q<Transition.Segment<S>, Composer, Integer, SpringSpec<Size>> {
        public static final C08171 INSTANCE = new C08171();

        public C08171() {
            super(3);
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ SpringSpec<Size> invoke(Object obj, Composer composer, Integer num) {
            return invoke((Transition.Segment) obj, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final SpringSpec<Size> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer, int i10) {
            t.i(segment, "$this$null");
            composer.startReplaceableGroup(-1607152761);
            SpringSpec<Size> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Size.m1424boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Size.Companion)), 3, null);
            composer.endReplaceableGroup();
            return springSpecSpring$default;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$animateValue$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class C08181<S, T> extends v implements q<Transition.Segment<S>, Composer, Integer, SpringSpec<T>> {
        public static final C08181 INSTANCE = new C08181();

        public C08181() {
            super(3);
        }

        @Composable
        @NotNull
        public final SpringSpec<T> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer, int i10) {
            t.i(segment, "$this$null");
            composer.startReplaceableGroup(-895531546);
            SpringSpec<T> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            composer.endReplaceableGroup();
            return springSpecSpring$default;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Composer composer, Integer num) {
            return invoke((Transition.Segment) obj, composer, num.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$createChildTransitionInternal$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Transition.kt */
    static final class C08191 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ Transition<S> $this_createChildTransitionInternal;
        final /* synthetic */ Transition<T> $transition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08191(Transition<S> transition, Transition<T> transition2) {
            super(1);
            this.$this_createChildTransitionInternal = transition;
            this.$transition = transition2;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            this.$this_createChildTransitionInternal.addTransition$animation_core_release(this.$transition);
            final Transition<S> transition = this.$this_createChildTransitionInternal;
            final Transition<T> transition2 = this.$transition;
            return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createChildTransitionInternal$1$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    transition.removeTransition$animation_core_release(transition2);
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$createDeferredAnimation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Transition.kt */
    static final class C08201 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ Transition<S>.DeferredAnimation<T, V> $lazyAnim;
        final /* synthetic */ Transition<S> $this_createDeferredAnimation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08201(Transition<S> transition, Transition<S>.DeferredAnimation<T, V> deferredAnimation) {
            super(1);
            this.$this_createDeferredAnimation = transition;
            this.$lazyAnim = deferredAnimation;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            final Transition<S> transition = this.$this_createDeferredAnimation;
            final Transition<S>.DeferredAnimation<T, V> deferredAnimation = this.$lazyAnim;
            return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createDeferredAnimation$1$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    transition.removeAnimation$animation_core_release(deferredAnimation);
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$createTransitionAnimation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Transition.kt */
    static final class C08211 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ Transition<S> $this_createTransitionAnimation;
        final /* synthetic */ Transition<S>.TransitionAnimationState<T, V> $transitionAnimation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08211(Transition<S> transition, Transition<S>.TransitionAnimationState<T, V> transitionAnimationState) {
            super(1);
            this.$this_createTransitionAnimation = transition;
            this.$transitionAnimation = transitionAnimationState;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            this.$this_createTransitionAnimation.addAnimation$animation_core_release(this.$transitionAnimation);
            final Transition<S> transition = this.$this_createTransitionAnimation;
            final Transition<S>.TransitionAnimationState<T, V> transitionAnimationState = this.$transitionAnimation;
            return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createTransitionAnimation$1$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    transition.removeAnimation$animation_core_release(transitionAnimationState);
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$updateTransition$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Transition.kt */
    static final class C08221 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ Transition<T> $transition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08221(Transition<T> transition) {
            super(1);
            this.$transition = transition;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            final Transition<T> transition = this.$transition;
            return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$1$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    transition.onTransitionEnd$animation_core_release();
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.TransitionKt$updateTransition$2, reason: invalid class name */
    /* JADX INFO: compiled from: Transition.kt */
    static final class AnonymousClass2 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ Transition<T> $transition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Transition<T> transition) {
            super(1);
            this.$transition = transition;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            final Transition<T> transition = this.$transition;
            return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$2$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    transition.onTransitionEnd$animation_core_release();
                }
            };
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<Dp> animateDp(@NotNull Transition<S> transition, @Nullable q<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Dp>> qVar, @Nullable String str, @NotNull q<? super S, ? super Composer, ? super Integer, Dp> targetValueByState, @Nullable Composer composer, int i10, int i11) {
        t.i(transition, "<this>");
        t.i(targetValueByState, "targetValueByState");
        composer.startReplaceableGroup(184732935);
        if ((i11 & 1) != 0) {
            qVar = AnonymousClass1.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            str = "DpAnimation";
        }
        String str2 = str;
        TwoWayConverter<Dp, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(Dp.Companion);
        int i12 = i10 & 14;
        int i13 = i10 << 3;
        int i14 = i12 | (i13 & 896) | (i13 & 7168) | (i13 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i15 = (i14 >> 9) & 112;
        State<Dp> stateCreateTransitionAnimation = createTransitionAnimation(transition, targetValueByState.invoke(transition.getCurrentState(), composer, Integer.valueOf(i15)), targetValueByState.invoke(transition.getTargetState(), composer, Integer.valueOf(i15)), qVar.invoke(transition.getSegment(), composer, Integer.valueOf((i14 >> 3) & 112)), vectorConverter, str2, composer, (i14 & 14) | ((i14 << 9) & 57344) | ((i14 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return stateCreateTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<Float> animateFloat(@NotNull Transition<S> transition, @Nullable q<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Float>> qVar, @Nullable String str, @NotNull q<? super S, ? super Composer, ? super Integer, Float> targetValueByState, @Nullable Composer composer, int i10, int i11) {
        t.i(transition, "<this>");
        t.i(targetValueByState, "targetValueByState");
        composer.startReplaceableGroup(-1338768149);
        if ((i11 & 1) != 0) {
            qVar = C08111.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            str = "FloatAnimation";
        }
        String str2 = str;
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(m.f29832a);
        int i12 = i10 & 14;
        int i13 = i10 << 3;
        int i14 = i12 | (i13 & 896) | (i13 & 7168) | (i13 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i15 = (i14 >> 9) & 112;
        State<Float> stateCreateTransitionAnimation = createTransitionAnimation(transition, targetValueByState.invoke(transition.getCurrentState(), composer, Integer.valueOf(i15)), targetValueByState.invoke(transition.getTargetState(), composer, Integer.valueOf(i15)), qVar.invoke(transition.getSegment(), composer, Integer.valueOf((i14 >> 3) & 112)), vectorConverter, str2, composer, (i14 & 14) | ((i14 << 9) & 57344) | ((i14 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return stateCreateTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<Integer> animateInt(@NotNull Transition<S> transition, @Nullable q<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Integer>> qVar, @Nullable String str, @NotNull q<? super S, ? super Composer, ? super Integer, Integer> targetValueByState, @Nullable Composer composer, int i10, int i11) {
        t.i(transition, "<this>");
        t.i(targetValueByState, "targetValueByState");
        composer.startReplaceableGroup(1318902782);
        if ((i11 & 1) != 0) {
            qVar = C08121.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            str = "IntAnimation";
        }
        String str2 = str;
        TwoWayConverter<Integer, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(s.f29839a);
        int i12 = i10 & 14;
        int i13 = i10 << 3;
        int i14 = i12 | (i13 & 896) | (i13 & 7168) | (i13 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i15 = (i14 >> 9) & 112;
        State<Integer> stateCreateTransitionAnimation = createTransitionAnimation(transition, targetValueByState.invoke(transition.getCurrentState(), composer, Integer.valueOf(i15)), targetValueByState.invoke(transition.getTargetState(), composer, Integer.valueOf(i15)), qVar.invoke(transition.getSegment(), composer, Integer.valueOf((i14 >> 3) & 112)), vectorConverter, str2, composer, (i14 & 14) | ((i14 << 9) & 57344) | ((i14 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return stateCreateTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<IntOffset> animateIntOffset(@NotNull Transition<S> transition, @Nullable q<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntOffset>> qVar, @Nullable String str, @NotNull q<? super S, ? super Composer, ? super Integer, IntOffset> targetValueByState, @Nullable Composer composer, int i10, int i11) {
        t.i(transition, "<this>");
        t.i(targetValueByState, "targetValueByState");
        composer.startReplaceableGroup(776131825);
        if ((i11 & 1) != 0) {
            qVar = C08131.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            str = "IntOffsetAnimation";
        }
        String str2 = str;
        TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
        int i12 = i10 & 14;
        int i13 = i10 << 3;
        int i14 = i12 | (i13 & 896) | (i13 & 7168) | (i13 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i15 = (i14 >> 9) & 112;
        State<IntOffset> stateCreateTransitionAnimation = createTransitionAnimation(transition, targetValueByState.invoke(transition.getCurrentState(), composer, Integer.valueOf(i15)), targetValueByState.invoke(transition.getTargetState(), composer, Integer.valueOf(i15)), qVar.invoke(transition.getSegment(), composer, Integer.valueOf((i14 >> 3) & 112)), vectorConverter, str2, composer, (i14 & 14) | ((i14 << 9) & 57344) | ((i14 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return stateCreateTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<IntSize> animateIntSize(@NotNull Transition<S> transition, @Nullable q<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntSize>> qVar, @Nullable String str, @NotNull q<? super S, ? super Composer, ? super Integer, IntSize> targetValueByState, @Nullable Composer composer, int i10, int i11) {
        t.i(transition, "<this>");
        t.i(targetValueByState, "targetValueByState");
        composer.startReplaceableGroup(-2104123233);
        if ((i11 & 1) != 0) {
            qVar = C08141.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            str = "IntSizeAnimation";
        }
        String str2 = str;
        TwoWayConverter<IntSize, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntSize.Companion);
        int i12 = i10 & 14;
        int i13 = i10 << 3;
        int i14 = i12 | (i13 & 896) | (i13 & 7168) | (i13 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i15 = (i14 >> 9) & 112;
        State<IntSize> stateCreateTransitionAnimation = createTransitionAnimation(transition, targetValueByState.invoke(transition.getCurrentState(), composer, Integer.valueOf(i15)), targetValueByState.invoke(transition.getTargetState(), composer, Integer.valueOf(i15)), qVar.invoke(transition.getSegment(), composer, Integer.valueOf((i14 >> 3) & 112)), vectorConverter, str2, composer, (i14 & 14) | ((i14 << 9) & 57344) | ((i14 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return stateCreateTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<Offset> animateOffset(@NotNull Transition<S> transition, @Nullable q<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Offset>> qVar, @Nullable String str, @NotNull q<? super S, ? super Composer, ? super Integer, Offset> targetValueByState, @Nullable Composer composer, int i10, int i11) {
        t.i(transition, "<this>");
        t.i(targetValueByState, "targetValueByState");
        composer.startReplaceableGroup(2078477582);
        if ((i11 & 1) != 0) {
            qVar = C08151.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            str = "OffsetAnimation";
        }
        String str2 = str;
        TwoWayConverter<Offset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(Offset.Companion);
        int i12 = i10 & 14;
        int i13 = i10 << 3;
        int i14 = i12 | (i13 & 896) | (i13 & 7168) | (i13 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i15 = (i14 >> 9) & 112;
        State<Offset> stateCreateTransitionAnimation = createTransitionAnimation(transition, targetValueByState.invoke(transition.getCurrentState(), composer, Integer.valueOf(i15)), targetValueByState.invoke(transition.getTargetState(), composer, Integer.valueOf(i15)), qVar.invoke(transition.getSegment(), composer, Integer.valueOf((i14 >> 3) & 112)), vectorConverter, str2, composer, (i14 & 14) | ((i14 << 9) & 57344) | ((i14 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return stateCreateTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<Rect> animateRect(@NotNull Transition<S> transition, @Nullable q<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Rect>> qVar, @Nullable String str, @NotNull q<? super S, ? super Composer, ? super Integer, Rect> targetValueByState, @Nullable Composer composer, int i10, int i11) {
        t.i(transition, "<this>");
        t.i(targetValueByState, "targetValueByState");
        composer.startReplaceableGroup(1496278239);
        if ((i11 & 1) != 0) {
            qVar = C08161.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            str = "RectAnimation";
        }
        String str2 = str;
        TwoWayConverter<Rect, AnimationVector4D> vectorConverter = VectorConvertersKt.getVectorConverter(Rect.Companion);
        int i12 = i10 & 14;
        int i13 = i10 << 3;
        int i14 = i12 | (i13 & 896) | (i13 & 7168) | (i13 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i15 = (i14 >> 9) & 112;
        State<Rect> stateCreateTransitionAnimation = createTransitionAnimation(transition, targetValueByState.invoke(transition.getCurrentState(), composer, Integer.valueOf(i15)), targetValueByState.invoke(transition.getTargetState(), composer, Integer.valueOf(i15)), qVar.invoke(transition.getSegment(), composer, Integer.valueOf((i14 >> 3) & 112)), vectorConverter, str2, composer, (i14 & 14) | ((i14 << 9) & 57344) | ((i14 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return stateCreateTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<Size> animateSize(@NotNull Transition<S> transition, @Nullable q<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Size>> qVar, @Nullable String str, @NotNull q<? super S, ? super Composer, ? super Integer, Size> targetValueByState, @Nullable Composer composer, int i10, int i11) {
        t.i(transition, "<this>");
        t.i(targetValueByState, "targetValueByState");
        composer.startReplaceableGroup(-802210820);
        if ((i11 & 1) != 0) {
            qVar = C08171.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            str = "SizeAnimation";
        }
        String str2 = str;
        TwoWayConverter<Size, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(Size.Companion);
        int i12 = i10 & 14;
        int i13 = i10 << 3;
        int i14 = i12 | (i13 & 896) | (i13 & 7168) | (i13 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i15 = (i14 >> 9) & 112;
        State<Size> stateCreateTransitionAnimation = createTransitionAnimation(transition, targetValueByState.invoke(transition.getCurrentState(), composer, Integer.valueOf(i15)), targetValueByState.invoke(transition.getTargetState(), composer, Integer.valueOf(i15)), qVar.invoke(transition.getSegment(), composer, Integer.valueOf((i14 >> 3) & 112)), vectorConverter, str2, composer, (i14 & 14) | ((i14 << 9) & 57344) | ((i14 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return stateCreateTransitionAnimation;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S, T, V extends AnimationVector> State<T> animateValue(@NotNull Transition<S> transition, @NotNull TwoWayConverter<T, V> typeConverter, @Nullable q<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<T>> qVar, @Nullable String str, @NotNull q<? super S, ? super Composer, ? super Integer, ? extends T> targetValueByState, @Nullable Composer composer, int i10, int i11) {
        t.i(transition, "<this>");
        t.i(typeConverter, "typeConverter");
        t.i(targetValueByState, "targetValueByState");
        composer.startReplaceableGroup(-142660079);
        if ((i11 & 2) != 0) {
            qVar = C08181.INSTANCE;
        }
        if ((i11 & 4) != 0) {
            str = "ValueAnimation";
        }
        int i12 = (i10 >> 9) & 112;
        State<T> stateCreateTransitionAnimation = createTransitionAnimation(transition, targetValueByState.invoke(transition.getCurrentState(), composer, Integer.valueOf(i12)), targetValueByState.invoke(transition.getTargetState(), composer, Integer.valueOf(i12)), qVar.invoke(transition.getSegment(), composer, Integer.valueOf((i10 >> 3) & 112)), typeConverter, str, composer, (i10 & 14) | (57344 & (i10 << 9)) | ((i10 << 6) & 458752));
        composer.endReplaceableGroup();
        return stateCreateTransitionAnimation;
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    @NotNull
    @ExperimentalTransitionApi
    @Composable
    public static final <S, T> Transition<T> createChildTransition(@NotNull Transition<S> transition, @Nullable String str, @NotNull q<? super S, ? super Composer, ? super Integer, ? extends T> transformToChildState, @Nullable Composer composer, int i10, int i11) {
        t.i(transition, "<this>");
        t.i(transformToChildState, "transformToChildState");
        composer.startReplaceableGroup(1215497572);
        if ((i11 & 1) != 0) {
            str = "ChildTransition";
        }
        String str2 = str;
        int i12 = i10 & 14;
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(transition);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = transition.getCurrentState();
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        if (transition.isSeeking()) {
            objRememberedValue = transition.getCurrentState();
        }
        int i13 = (i10 >> 3) & 112;
        Transition<T> transitionCreateChildTransitionInternal = createChildTransitionInternal(transition, transformToChildState.invoke(objRememberedValue, composer, Integer.valueOf(i13)), transformToChildState.invoke(transition.getTargetState(), composer, Integer.valueOf(i13)), str2, composer, i12 | ((i10 << 6) & 7168));
        composer.endReplaceableGroup();
        return transitionCreateChildTransitionInternal;
    }

    @Composable
    @NotNull
    public static final <S, T> Transition<T> createChildTransitionInternal(@NotNull Transition<S> transition, T t10, T t11, @NotNull String childLabel, @Nullable Composer composer, int i10) {
        t.i(transition, "<this>");
        t.i(childLabel, "childLabel");
        composer.startReplaceableGroup(-198307638);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(transition);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Transition(new MutableTransitionState(t10), transition.getLabel() + " > " + childLabel);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Transition<T> transition2 = (Transition) objRememberedValue;
        EffectsKt.DisposableEffect(transition2, new C08191(transition, transition2), composer, 0);
        if (transition.isSeeking()) {
            transition2.seek(t10, t11, transition.getLastSeekedTimeNanos$animation_core_release());
        } else {
            transition2.updateTarget$animation_core_release(t11, composer, ((i10 >> 3) & 8) | ((i10 >> 6) & 14));
            transition2.setSeeking$animation_core_release(false);
        }
        composer.endReplaceableGroup();
        return transition2;
    }

    @Composable
    @InternalAnimationApi
    @NotNull
    public static final <S, T, V extends AnimationVector> Transition<S>.DeferredAnimation<T, V> createDeferredAnimation(@NotNull Transition<S> transition, @NotNull TwoWayConverter<T, V> typeConverter, @Nullable String str, @Nullable Composer composer, int i10, int i11) {
        t.i(transition, "<this>");
        t.i(typeConverter, "typeConverter");
        composer.startReplaceableGroup(-1714122528);
        if ((i11 & 2) != 0) {
            str = "DeferredAnimation";
        }
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(transition);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Transition.DeferredAnimation(transition, typeConverter, str);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Transition<S>.DeferredAnimation<T, V> deferredAnimation = (Transition.DeferredAnimation) objRememberedValue;
        EffectsKt.DisposableEffect(deferredAnimation, new C08201(transition, deferredAnimation), composer, 8);
        if (transition.isSeeking()) {
            deferredAnimation.setupSeeking$animation_core_release();
        }
        composer.endReplaceableGroup();
        return deferredAnimation;
    }

    @Composable
    @NotNull
    public static final <S, T, V extends AnimationVector> State<T> createTransitionAnimation(@NotNull Transition<S> transition, T t10, T t11, @NotNull FiniteAnimationSpec<T> animationSpec, @NotNull TwoWayConverter<T, V> typeConverter, @NotNull String label, @Nullable Composer composer, int i10) {
        t.i(transition, "<this>");
        t.i(animationSpec, "animationSpec");
        t.i(typeConverter, "typeConverter");
        t.i(label, "label");
        composer.startReplaceableGroup(-304821198);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(transition);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Transition.TransitionAnimationState(transition, t10, AnimationStateKt.createZeroVectorFrom(typeConverter, t11), typeConverter, label);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Transition.TransitionAnimationState transitionAnimationState = (Transition.TransitionAnimationState) objRememberedValue;
        if (transition.isSeeking()) {
            transitionAnimationState.updateInitialAndTargetValue$animation_core_release(t10, t11, animationSpec);
        } else {
            transitionAnimationState.updateTargetValue$animation_core_release(t11, animationSpec);
        }
        EffectsKt.DisposableEffect(transitionAnimationState, new C08211(transition, transitionAnimationState), composer, 0);
        composer.endReplaceableGroup();
        return transitionAnimationState;
    }

    @Composable
    @NotNull
    public static final <T> Transition<T> updateTransition(T t10, @Nullable String str, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(2029166765);
        if ((i11 & 2) != 0) {
            str = null;
        }
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Transition(t10, str);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Transition<T> transition = (Transition) objRememberedValue;
        transition.animateTo$animation_core_release(t10, composer, (i10 & 8) | 48 | (i10 & 14));
        EffectsKt.DisposableEffect(transition, new C08221(transition), composer, 6);
        composer.endReplaceableGroup();
        return transition;
    }

    @Composable
    @NotNull
    public static final <T> Transition<T> updateTransition(@NotNull MutableTransitionState<T> transitionState, @Nullable String str, @Nullable Composer composer, int i10, int i11) {
        t.i(transitionState, "transitionState");
        composer.startReplaceableGroup(882913843);
        if ((i11 & 2) != 0) {
            str = null;
        }
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(transitionState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Transition((MutableTransitionState) transitionState, str);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Transition<T> transition = (Transition) objRememberedValue;
        transition.animateTo$animation_core_release(transitionState.getTargetState(), composer, 0);
        EffectsKt.DisposableEffect(transition, new AnonymousClass2(transition), composer, 0);
        composer.endReplaceableGroup();
        return transition;
    }
}

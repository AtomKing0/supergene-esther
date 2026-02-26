package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import h9.p;
import h9.q;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: TransformableState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TransformableStateKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$animateRotateBy$2, reason: invalid class name */
    /* JADX INFO: compiled from: TransformableState.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TransformableStateKt$animateRotateBy$2", f = "TransformableState.kt", l = {158}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<TransformScope, z8.d<? super k0>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ float $degrees;
        final /* synthetic */ kotlin.jvm.internal.k0 $previous;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$animateRotateBy$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TransformableState.kt */
        static final class AnonymousClass1 extends v implements h9.l<AnimationScope<Float, AnimationVector1D>, k0> {
            final /* synthetic */ TransformScope $$this$transform;
            final /* synthetic */ kotlin.jvm.internal.k0 $previous;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(kotlin.jvm.internal.k0 k0Var, TransformScope transformScope) {
                super(1);
                this.$previous = k0Var;
                this.$$this$transform = transformScope;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                invoke2(animationScope);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull AnimationScope<Float, AnimationVector1D> animateTo) {
                t.i(animateTo, "$this$animateTo");
                e.a(this.$$this$transform, 0.0f, 0L, animateTo.getValue().floatValue() - this.$previous.f29829a, 3, null);
                this.$previous.f29829a = animateTo.getValue().floatValue();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(kotlin.jvm.internal.k0 k0Var, float f10, AnimationSpec<Float> animationSpec, z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$previous = k0Var;
            this.$degrees = f10;
            this.$animationSpec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$previous, this.$degrees, this.$animationSpec, dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull TransformScope transformScope, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass2) create(transformScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                TransformScope transformScope = (TransformScope) this.L$0;
                AnimationState animationStateAnimationState$default = AnimationStateKt.AnimationState$default(this.$previous.f29829a, 0.0f, 0L, 0L, false, 30, null);
                Float fC = kotlin.coroutines.jvm.internal.b.c(this.$degrees);
                AnimationSpec<Float> animationSpec = this.$animationSpec;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$previous, transformScope);
                this.label = 1;
                if (SuspendAnimationKt.animateTo$default(animationStateAnimationState$default, fC, animationSpec, false, anonymousClass1, this, 4, null) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$animateZoomBy$3, reason: invalid class name */
    /* JADX INFO: compiled from: TransformableState.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TransformableStateKt$animateZoomBy$3", f = "TransformableState.kt", l = {138}, m = "invokeSuspend")
    static final class AnonymousClass3 extends l implements p<TransformScope, z8.d<? super k0>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ kotlin.jvm.internal.k0 $previous;
        final /* synthetic */ float $zoomFactor;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$animateZoomBy$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: TransformableState.kt */
        static final class AnonymousClass1 extends v implements h9.l<AnimationScope<Float, AnimationVector1D>, k0> {
            final /* synthetic */ TransformScope $$this$transform;
            final /* synthetic */ kotlin.jvm.internal.k0 $previous;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(kotlin.jvm.internal.k0 k0Var, TransformScope transformScope) {
                super(1);
                this.$previous = k0Var;
                this.$$this$transform = transformScope;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                invoke2(animationScope);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull AnimationScope<Float, AnimationVector1D> animateTo) {
                t.i(animateTo, "$this$animateTo");
                e.a(this.$$this$transform, (this.$previous.f29829a > 0.0f ? 1 : (this.$previous.f29829a == 0.0f ? 0 : -1)) == 0 ? 1.0f : animateTo.getValue().floatValue() / this.$previous.f29829a, 0L, 0.0f, 6, null);
                this.$previous.f29829a = animateTo.getValue().floatValue();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(kotlin.jvm.internal.k0 k0Var, float f10, AnimationSpec<Float> animationSpec, z8.d<? super AnonymousClass3> dVar) {
            super(2, dVar);
            this.$previous = k0Var;
            this.$zoomFactor = f10;
            this.$animationSpec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$previous, this.$zoomFactor, this.$animationSpec, dVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull TransformScope transformScope, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass3) create(transformScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                TransformScope transformScope = (TransformScope) this.L$0;
                AnimationState animationStateAnimationState$default = AnimationStateKt.AnimationState$default(this.$previous.f29829a, 0.0f, 0L, 0L, false, 30, null);
                Float fC = kotlin.coroutines.jvm.internal.b.c(this.$zoomFactor);
                AnimationSpec<Float> animationSpec = this.$animationSpec;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$previous, transformScope);
                this.label = 1;
                if (SuspendAnimationKt.animateTo$default(animationStateAnimationState$default, fC, animationSpec, false, anonymousClass1, this, 4, null) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$rotateBy$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TransformableState.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TransformableStateKt$rotateBy$2", f = "TransformableState.kt", l = {}, m = "invokeSuspend")
    static final class C08562 extends l implements p<TransformScope, z8.d<? super k0>, Object> {
        final /* synthetic */ float $degrees;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08562(float f10, z8.d<? super C08562> dVar) {
            super(2, dVar);
            this.$degrees = f10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C08562 c08562 = new C08562(this.$degrees, dVar);
            c08562.L$0 = obj;
            return c08562;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull TransformScope transformScope, @Nullable z8.d<? super k0> dVar) {
            return ((C08562) create(transformScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            ((TransformScope) this.L$0).mo242transformByd4ec7I(1.0f, Offset.Companion.m1383getZeroF1C5BW0(), this.$degrees);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$stopTransformation$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TransformableState.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TransformableStateKt$stopTransformation$2", f = "TransformableState.kt", l = {}, m = "invokeSuspend")
    static final class C08572 extends l implements p<TransformScope, z8.d<? super k0>, Object> {
        int label;

        C08572(z8.d<? super C08572> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new C08572(dVar);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull TransformScope transformScope, @Nullable z8.d<? super k0> dVar) {
            return ((C08572) create(transformScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$zoomBy$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TransformableState.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TransformableStateKt$zoomBy$2", f = "TransformableState.kt", l = {}, m = "invokeSuspend")
    static final class C08582 extends l implements p<TransformScope, z8.d<? super k0>, Object> {
        final /* synthetic */ float $zoomFactor;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08582(float f10, z8.d<? super C08582> dVar) {
            super(2, dVar);
            this.$zoomFactor = f10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C08582 c08582 = new C08582(this.$zoomFactor, dVar);
            c08582.L$0 = obj;
            return c08582;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull TransformScope transformScope, @Nullable z8.d<? super k0> dVar) {
            return ((C08582) create(transformScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            ((TransformScope) this.L$0).mo242transformByd4ec7I(this.$zoomFactor, Offset.Companion.m1383getZeroF1C5BW0(), 0.0f);
            return k0.f35197a;
        }
    }

    @NotNull
    public static final TransformableState TransformableState(@NotNull q<? super Float, ? super Offset, ? super Float, k0> onTransformation) {
        t.i(onTransformation, "onTransformation");
        return new DefaultTransformableState(onTransformation);
    }

    @Nullable
    /* JADX INFO: renamed from: animatePanBy-ubNVwUQ, reason: not valid java name */
    public static final Object m318animatePanByubNVwUQ(@NotNull TransformableState transformableState, long j10, @NotNull AnimationSpec<Offset> animationSpec, @NotNull z8.d<? super k0> dVar) {
        m0 m0Var = new m0();
        m0Var.f29833a = Offset.Companion.m1383getZeroF1C5BW0();
        Object objA = f.a(transformableState, null, new TransformableStateKt$animatePanBy$2(m0Var, j10, animationSpec, null), dVar, 1, null);
        return objA == a9.d.e() ? objA : k0.f35197a;
    }

    /* JADX INFO: renamed from: animatePanBy-ubNVwUQ$default, reason: not valid java name */
    public static /* synthetic */ Object m319animatePanByubNVwUQ$default(TransformableState transformableState, long j10, AnimationSpec animationSpec, z8.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return m318animatePanByubNVwUQ(transformableState, j10, animationSpec, dVar);
    }

    @Nullable
    public static final Object animateRotateBy(@NotNull TransformableState transformableState, float f10, @NotNull AnimationSpec<Float> animationSpec, @NotNull z8.d<? super k0> dVar) {
        Object objA = f.a(transformableState, null, new AnonymousClass2(new kotlin.jvm.internal.k0(), f10, animationSpec, null), dVar, 1, null);
        return objA == a9.d.e() ? objA : k0.f35197a;
    }

    public static /* synthetic */ Object animateRotateBy$default(TransformableState transformableState, float f10, AnimationSpec animationSpec, z8.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return animateRotateBy(transformableState, f10, animationSpec, dVar);
    }

    @Nullable
    public static final Object animateZoomBy(@NotNull TransformableState transformableState, float f10, @NotNull AnimationSpec<Float> animationSpec, @NotNull z8.d<? super k0> dVar) {
        if (!(f10 > 0.0f)) {
            throw new IllegalArgumentException("zoom value should be greater than 0".toString());
        }
        kotlin.jvm.internal.k0 k0Var = new kotlin.jvm.internal.k0();
        k0Var.f29829a = 1.0f;
        Object objA = f.a(transformableState, null, new AnonymousClass3(k0Var, f10, animationSpec, null), dVar, 1, null);
        return objA == a9.d.e() ? objA : k0.f35197a;
    }

    public static /* synthetic */ Object animateZoomBy$default(TransformableState transformableState, float f10, AnimationSpec animationSpec, z8.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return animateZoomBy(transformableState, f10, animationSpec, dVar);
    }

    @Nullable
    /* JADX INFO: renamed from: panBy-d-4ec7I, reason: not valid java name */
    public static final Object m320panByd4ec7I(@NotNull TransformableState transformableState, long j10, @NotNull z8.d<? super k0> dVar) {
        Object objA = f.a(transformableState, null, new TransformableStateKt$panBy$2(j10, null), dVar, 1, null);
        return objA == a9.d.e() ? objA : k0.f35197a;
    }

    @Composable
    @NotNull
    public static final TransformableState rememberTransformableState(@NotNull q<? super Float, ? super Offset, ? super Float, k0> onTransformation, @Nullable Composer composer, int i10) {
        t.i(onTransformation, "onTransformation");
        composer.startReplaceableGroup(1681419281);
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(onTransformation, composer, i10 & 14);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = TransformableState(new TransformableStateKt$rememberTransformableState$1$1(stateRememberUpdatedState));
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        TransformableState transformableState = (TransformableState) objRememberedValue;
        composer.endReplaceableGroup();
        return transformableState;
    }

    @Nullable
    public static final Object rotateBy(@NotNull TransformableState transformableState, float f10, @NotNull z8.d<? super k0> dVar) {
        Object objA = f.a(transformableState, null, new C08562(f10, null), dVar, 1, null);
        return objA == a9.d.e() ? objA : k0.f35197a;
    }

    @Nullable
    public static final Object stopTransformation(@NotNull TransformableState transformableState, @NotNull MutatePriority mutatePriority, @NotNull z8.d<? super k0> dVar) {
        Object objTransform = transformableState.transform(mutatePriority, new C08572(null), dVar);
        return objTransform == a9.d.e() ? objTransform : k0.f35197a;
    }

    public static /* synthetic */ Object stopTransformation$default(TransformableState transformableState, MutatePriority mutatePriority, z8.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return stopTransformation(transformableState, mutatePriority, dVar);
    }

    @Nullable
    public static final Object zoomBy(@NotNull TransformableState transformableState, float f10, @NotNull z8.d<? super k0> dVar) {
        Object objA = f.a(transformableState, null, new C08582(f10, null), dVar, 1, null);
        return objA == a9.d.e() ? objA : k0.f35197a;
    }
}

package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
final class DefaultFlingBehavior implements FlingBehavior {

    @NotNull
    private final DecayAnimationSpec<Float> flingDecay;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$1, reason: invalid class name */
    /* JADX INFO: compiled from: Scrollable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DefaultFlingBehavior", f = "Scrollable.kt", l = {496}, m = "performFling")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(z8.d<? super AnonymousClass1> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultFlingBehavior.this.performFling(null, 0.0f, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2, reason: invalid class name */
    /* JADX INFO: compiled from: Scrollable.kt */
    static final class AnonymousClass2 extends v implements l<AnimationScope<Float, AnimationVector1D>, k0> {
        final /* synthetic */ kotlin.jvm.internal.k0 $lastValue;
        final /* synthetic */ ScrollScope $this_performFling;
        final /* synthetic */ kotlin.jvm.internal.k0 $velocityLeft;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(kotlin.jvm.internal.k0 k0Var, ScrollScope scrollScope, kotlin.jvm.internal.k0 k0Var2) {
            super(1);
            this.$lastValue = k0Var;
            this.$this_performFling = scrollScope;
            this.$velocityLeft = k0Var2;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
            invoke2(animationScope);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull AnimationScope<Float, AnimationVector1D> animateDecay) {
            t.i(animateDecay, "$this$animateDecay");
            float fFloatValue = animateDecay.getValue().floatValue() - this.$lastValue.f29829a;
            float fScrollBy = this.$this_performFling.scrollBy(fFloatValue);
            this.$lastValue.f29829a = animateDecay.getValue().floatValue();
            this.$velocityLeft.f29829a = animateDecay.getVelocity().floatValue();
            if (Math.abs(fFloatValue - fScrollBy) > 0.5f) {
                animateDecay.cancelAnimation();
            }
        }
    }

    public DefaultFlingBehavior(@NotNull DecayAnimationSpec<Float> flingDecay) {
        t.i(flingDecay, "flingDecay");
        this.flingDecay = flingDecay;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object performFling(@org.jetbrains.annotations.NotNull androidx.compose.foundation.gestures.ScrollScope r18, float r19, @org.jetbrains.annotations.NotNull z8.d<? super java.lang.Float> r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            boolean r2 = r1 instanceof androidx.compose.foundation.gestures.DefaultFlingBehavior.AnonymousClass1
            if (r2 == 0) goto L17
            r2 = r1
            androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$1 r2 = (androidx.compose.foundation.gestures.DefaultFlingBehavior.AnonymousClass1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$1 r2 = new androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$1
            r2.<init>(r1)
        L1c:
            r7 = r2
            java.lang.Object r1 = r7.result
            java.lang.Object r2 = a9.b.e()
            int r3 = r7.label
            r4 = 1
            if (r3 == 0) goto L3a
            if (r3 != r4) goto L32
            java.lang.Object r2 = r7.L$0
            kotlin.jvm.internal.k0 r2 = (kotlin.jvm.internal.k0) r2
            v8.u.b(r1)
            goto L82
        L32:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3a:
            v8.u.b(r1)
            float r1 = java.lang.Math.abs(r19)
            r3 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L85
            kotlin.jvm.internal.k0 r1 = new kotlin.jvm.internal.k0
            r1.<init>()
            r3 = r19
            r1.f29829a = r3
            kotlin.jvm.internal.k0 r5 = new kotlin.jvm.internal.k0
            r5.<init>()
            r8 = 0
            r10 = 0
            r12 = 0
            r14 = 0
            r15 = 28
            r16 = 0
            r9 = r19
            androidx.compose.animation.core.AnimationState r3 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r8, r9, r10, r12, r14, r15, r16)
            androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r6 = r0.flingDecay
            r8 = 0
            androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2 r9 = new androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2
            r10 = r18
            r9.<init>(r5, r10, r1)
            r10 = 2
            r11 = 0
            r7.L$0 = r1
            r7.label = r4
            r4 = r6
            r5 = r8
            r6 = r9
            r8 = r10
            r9 = r11
            java.lang.Object r3 = androidx.compose.animation.core.SuspendAnimationKt.animateDecay$default(r3, r4, r5, r6, r7, r8, r9)
            if (r3 != r2) goto L81
            return r2
        L81:
            r2 = r1
        L82:
            float r1 = r2.f29829a
            goto L88
        L85:
            r3 = r19
            r1 = r3
        L88:
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.b.c(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DefaultFlingBehavior.performFling(androidx.compose.foundation.gestures.ScrollScope, float, z8.d):java.lang.Object");
    }
}

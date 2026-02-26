package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.util.MathHelpersKt;
import h9.p;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.x;
import kotlinx.coroutines.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: RippleAnimation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RippleAnimation {

    @NotNull
    private final Animatable<Float, AnimationVector1D> animatedAlpha;

    @NotNull
    private final Animatable<Float, AnimationVector1D> animatedCenterPercent;

    @NotNull
    private final Animatable<Float, AnimationVector1D> animatedRadiusPercent;
    private final boolean bounded;

    @NotNull
    private final MutableState finishRequested$delegate;

    @NotNull
    private final x<k0> finishSignalDeferred;

    @NotNull
    private final MutableState finishedFadingIn$delegate;

    @Nullable
    private Offset origin;
    private final float radius;

    @Nullable
    private Float startRadius;

    @Nullable
    private Offset targetCenter;

    @Nullable
    private Float targetRadius;

    /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleAnimation$animate$1, reason: invalid class name */
    /* JADX INFO: compiled from: RippleAnimation.kt */
    @f(c = "androidx.compose.material.ripple.RippleAnimation", f = "RippleAnimation.kt", l = {80, 82, 83}, m = "animate")
    static final class AnonymousClass1 extends d {
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
            return RippleAnimation.this.animate(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleAnimation$fadeIn$2, reason: invalid class name */
    /* JADX INFO: compiled from: RippleAnimation.kt */
    @f(c = "androidx.compose.material.ripple.RippleAnimation$fadeIn$2", f = "RippleAnimation.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, z8.d<? super b2>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleAnimation$fadeIn$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: RippleAnimation.kt */
        @f(c = "androidx.compose.material.ripple.RippleAnimation$fadeIn$2$1", f = "RippleAnimation.kt", l = {89}, m = "invokeSuspend")
        static final class AnonymousClass1 extends l implements p<o0, z8.d<? super k0>, Object> {
            int label;
            final /* synthetic */ RippleAnimation this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(RippleAnimation rippleAnimation, z8.d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.this$0 = rippleAnimation;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new AnonymousClass1(this.this$0, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    Animatable animatable = this.this$0.animatedAlpha;
                    Float fC = b.c(1.0f);
                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(75, 0, EasingKt.getLinearEasing(), 2, null);
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable, fC, tweenSpecTween$default, null, null, this, 12, null) == objE) {
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

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleAnimation$fadeIn$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: RippleAnimation.kt */
        @f(c = "androidx.compose.material.ripple.RippleAnimation$fadeIn$2$2", f = "RippleAnimation.kt", l = {95}, m = "invokeSuspend")
        static final class C01152 extends l implements p<o0, z8.d<? super k0>, Object> {
            int label;
            final /* synthetic */ RippleAnimation this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01152(RippleAnimation rippleAnimation, z8.d<? super C01152> dVar) {
                super(2, dVar);
                this.this$0 = rippleAnimation;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new C01152(this.this$0, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    Animatable animatable = this.this$0.animatedRadiusPercent;
                    Float fC = b.c(1.0f);
                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(225, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable, fC, tweenSpecTween$default, null, null, this, 12, null) == objE) {
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

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                return ((C01152) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleAnimation$fadeIn$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: RippleAnimation.kt */
        @f(c = "androidx.compose.material.ripple.RippleAnimation$fadeIn$2$3", f = "RippleAnimation.kt", l = {101}, m = "invokeSuspend")
        static final class AnonymousClass3 extends l implements p<o0, z8.d<? super k0>, Object> {
            int label;
            final /* synthetic */ RippleAnimation this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(RippleAnimation rippleAnimation, z8.d<? super AnonymousClass3> dVar) {
                super(2, dVar);
                this.this$0 = rippleAnimation;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new AnonymousClass3(this.this$0, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    Animatable animatable = this.this$0.animatedCenterPercent;
                    Float fC = b.c(1.0f);
                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(225, 0, EasingKt.getLinearEasing(), 2, null);
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable, fC, tweenSpecTween$default, null, null, this, 12, null) == objE) {
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

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                return ((AnonymousClass3) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        AnonymousClass2(z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass2 anonymousClass2 = RippleAnimation.this.new AnonymousClass2(dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            o0 o0Var = (o0) this.L$0;
            k.d(o0Var, null, null, new AnonymousClass1(RippleAnimation.this, null), 3, null);
            k.d(o0Var, null, null, new C01152(RippleAnimation.this, null), 3, null);
            return k.d(o0Var, null, null, new AnonymousClass3(RippleAnimation.this, null), 3, null);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super b2> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleAnimation$fadeOut$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RippleAnimation.kt */
    @f(c = "androidx.compose.material.ripple.RippleAnimation$fadeOut$2", f = "RippleAnimation.kt", l = {}, m = "invokeSuspend")
    static final class C09612 extends l implements p<o0, z8.d<? super b2>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleAnimation$fadeOut$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: RippleAnimation.kt */
        @f(c = "androidx.compose.material.ripple.RippleAnimation$fadeOut$2$1", f = "RippleAnimation.kt", l = {112}, m = "invokeSuspend")
        static final class AnonymousClass1 extends l implements p<o0, z8.d<? super k0>, Object> {
            int label;
            final /* synthetic */ RippleAnimation this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(RippleAnimation rippleAnimation, z8.d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.this$0 = rippleAnimation;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new AnonymousClass1(this.this$0, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    Animatable animatable = this.this$0.animatedAlpha;
                    Float fC = b.c(0.0f);
                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, EasingKt.getLinearEasing(), 2, null);
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable, fC, tweenSpecTween$default, null, null, this, 12, null) == objE) {
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

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        C09612(z8.d<? super C09612> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C09612 c09612 = RippleAnimation.this.new C09612(dVar);
            c09612.L$0 = obj;
            return c09612;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            return k.d((o0) this.L$0, null, null, new AnonymousClass1(RippleAnimation.this, null), 3, null);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super b2> dVar) {
            return ((C09612) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public /* synthetic */ RippleAnimation(Offset offset, float f10, boolean z10, kotlin.jvm.internal.k kVar) {
        this(offset, f10, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fadeIn(z8.d<? super k0> dVar) {
        Object objF = p0.f(new AnonymousClass2(null), dVar);
        return objF == a9.d.e() ? objF : k0.f35197a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fadeOut(z8.d<? super k0> dVar) {
        Object objF = p0.f(new C09612(null), dVar);
        return objF == a9.d.e() ? objF : k0.f35197a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getFinishRequested() {
        return ((Boolean) this.finishRequested$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getFinishedFadingIn() {
        return ((Boolean) this.finishedFadingIn$delegate.getValue()).booleanValue();
    }

    private final void setFinishRequested(boolean z10) {
        this.finishRequested$delegate.setValue(Boolean.valueOf(z10));
    }

    private final void setFinishedFadingIn(boolean z10) {
        this.finishedFadingIn$delegate.setValue(Boolean.valueOf(z10));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object animate(@org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.compose.material.ripple.RippleAnimation.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.material.ripple.RippleAnimation$animate$1 r0 = (androidx.compose.material.ripple.RippleAnimation.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.material.ripple.RippleAnimation$animate$1 r0 = new androidx.compose.material.ripple.RippleAnimation$animate$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L47
            if (r2 == r5) goto L3f
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            v8.u.b(r7)
            goto L72
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L37:
            java.lang.Object r2 = r0.L$0
            androidx.compose.material.ripple.RippleAnimation r2 = (androidx.compose.material.ripple.RippleAnimation) r2
            v8.u.b(r7)
            goto L66
        L3f:
            java.lang.Object r2 = r0.L$0
            androidx.compose.material.ripple.RippleAnimation r2 = (androidx.compose.material.ripple.RippleAnimation) r2
            v8.u.b(r7)
            goto L56
        L47:
            v8.u.b(r7)
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r7 = r6.fadeIn(r0)
            if (r7 != r1) goto L55
            return r1
        L55:
            r2 = r6
        L56:
            r2.setFinishedFadingIn(r5)
            kotlinx.coroutines.x<v8.k0> r7 = r2.finishSignalDeferred
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r7.i0(r0)
            if (r7 != r1) goto L66
            return r1
        L66:
            r7 = 0
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r7 = r2.fadeOut(r0)
            if (r7 != r1) goto L72
            return r1
        L72:
            v8.k0 r7 = v8.k0.f35197a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ripple.RippleAnimation.animate(z8.d):java.lang.Object");
    }

    /* JADX INFO: renamed from: draw-4WTKRHQ, reason: not valid java name */
    public final void m1230draw4WTKRHQ(@NotNull DrawScope draw, long j10) {
        t.i(draw, "$this$draw");
        if (this.startRadius == null) {
            this.startRadius = Float.valueOf(RippleAnimationKt.m1232getRippleStartRadiusuvyYCjk(draw.mo1996getSizeNHjbRc()));
        }
        if (this.targetRadius == null) {
            this.targetRadius = Float.isNaN(this.radius) ? Float.valueOf(RippleAnimationKt.m1231getRippleEndRadiuscSwnlzA(draw, this.bounded, draw.mo1996getSizeNHjbRc())) : Float.valueOf(draw.mo296toPx0680j_4(this.radius));
        }
        if (this.origin == null) {
            this.origin = Offset.m1356boximpl(draw.mo1995getCenterF1C5BW0());
        }
        if (this.targetCenter == null) {
            this.targetCenter = Offset.m1356boximpl(OffsetKt.Offset(Size.m1436getWidthimpl(draw.mo1996getSizeNHjbRc()) / 2.0f, Size.m1433getHeightimpl(draw.mo1996getSizeNHjbRc()) / 2.0f));
        }
        float fFloatValue = (!getFinishRequested() || getFinishedFadingIn()) ? this.animatedAlpha.getValue().floatValue() : 1.0f;
        Float f10 = this.startRadius;
        t.f(f10);
        float fFloatValue2 = f10.floatValue();
        Float f11 = this.targetRadius;
        t.f(f11);
        float fLerp = MathHelpersKt.lerp(fFloatValue2, f11.floatValue(), this.animatedRadiusPercent.getValue().floatValue());
        Offset offset = this.origin;
        t.f(offset);
        float fM1367getXimpl = Offset.m1367getXimpl(offset.m1377unboximpl());
        Offset offset2 = this.targetCenter;
        t.f(offset2);
        float fLerp2 = MathHelpersKt.lerp(fM1367getXimpl, Offset.m1367getXimpl(offset2.m1377unboximpl()), this.animatedCenterPercent.getValue().floatValue());
        Offset offset3 = this.origin;
        t.f(offset3);
        float fM1368getYimpl = Offset.m1368getYimpl(offset3.m1377unboximpl());
        Offset offset4 = this.targetCenter;
        t.f(offset4);
        long jOffset = OffsetKt.Offset(fLerp2, MathHelpersKt.lerp(fM1368getYimpl, Offset.m1368getYimpl(offset4.m1377unboximpl()), this.animatedCenterPercent.getValue().floatValue()));
        long jM1597copywmQWz5c$default = Color.m1597copywmQWz5c$default(j10, Color.m1600getAlphaimpl(j10) * fFloatValue, 0.0f, 0.0f, 0.0f, 14, null);
        if (!this.bounded) {
            androidx.compose.ui.graphics.drawscope.b.x(draw, jM1597copywmQWz5c$default, fLerp, jOffset, 0.0f, null, null, 0, 120, null);
            return;
        }
        float fM1436getWidthimpl = Size.m1436getWidthimpl(draw.mo1996getSizeNHjbRc());
        float fM1433getHeightimpl = Size.m1433getHeightimpl(draw.mo1996getSizeNHjbRc());
        int iM1587getIntersectrtfAjoo = ClipOp.Companion.m1587getIntersectrtfAjoo();
        DrawContext drawContext = draw.getDrawContext();
        long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo2005clipRectN_I0leg(0.0f, 0.0f, fM1436getWidthimpl, fM1433getHeightimpl, iM1587getIntersectrtfAjoo);
        androidx.compose.ui.graphics.drawscope.b.x(draw, jM1597copywmQWz5c$default, fLerp, jOffset, 0.0f, null, null, 0, 120, null);
        drawContext.getCanvas().restore();
        drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
    }

    public final void finish() {
        setFinishRequested(true);
        this.finishSignalDeferred.O(k0.f35197a);
    }

    private RippleAnimation(Offset offset, float f10, boolean z10) {
        this.origin = offset;
        this.radius = f10;
        this.bounded = z10;
        this.animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.animatedRadiusPercent = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.animatedCenterPercent = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.finishSignalDeferred = z.a(null);
        Boolean bool = Boolean.FALSE;
        this.finishedFadingIn$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.finishRequested$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
    }
}

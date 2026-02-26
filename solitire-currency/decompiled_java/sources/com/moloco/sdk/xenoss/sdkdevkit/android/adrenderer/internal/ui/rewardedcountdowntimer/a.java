package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntSize;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.c0;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a$a, reason: collision with other inner class name */
    public static final class C0410a extends v implements l<DisposableEffectScope, DisposableEffectResult> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f19949g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ o0 f19950h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Animatable<Float, AnimationVector1D> f19951i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ MutableState<Boolean> f19952j;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a$a$a, reason: collision with other inner class name */
        public static final class C0411a implements DisposableEffectResult {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LifecycleOwner f19953a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ LifecycleEventObserver f19954b;

            public C0411a(LifecycleOwner lifecycleOwner, LifecycleEventObserver lifecycleEventObserver) {
                this.f19953a = lifecycleOwner;
                this.f19954b = lifecycleEventObserver;
            }

            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                this.f19953a.getLifecycle().removeObserver(this.f19954b);
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a$a$b */
        public static final class b implements LifecycleEventObserver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ o0 f19955a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Animatable<Float, AnimationVector1D> f19956b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ MutableState<Boolean> f19957c;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a$a$b$a, reason: collision with other inner class name */
            public /* synthetic */ class C0412a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f19958a;

                static {
                    int[] iArr = new int[Lifecycle.Event.values().length];
                    try {
                        iArr[Lifecycle.Event.ON_STOP.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f19958a = iArr;
                }
            }

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a$a$b$b, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.RewardedCountDownTimerCustomKt$RewardedCountDownTimerCustom$3$observer$1$onStateChanged$1", f = "RewardedCountDownTimerCustom.kt", l = {118}, m = "invokeSuspend")
            public static final class C0413b extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public int f19959j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public final /* synthetic */ Animatable<Float, AnimationVector1D> f19960k;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0413b(Animatable<Float, AnimationVector1D> animatable, z8.d<? super C0413b> dVar) {
                    super(2, dVar);
                    this.f19960k = animatable;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                    return ((C0413b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    return new C0413b(this.f19960k, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object objE = a9.d.e();
                    int i10 = this.f19959j;
                    if (i10 == 0) {
                        u.b(obj);
                        Animatable<Float, AnimationVector1D> animatable = this.f19960k;
                        this.f19959j = 1;
                        if (animatable.stop(this) == objE) {
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

            public b(o0 o0Var, Animatable<Float, AnimationVector1D> animatable, MutableState<Boolean> mutableState) {
                this.f19955a = o0Var;
                this.f19956b = animatable;
                this.f19957c = mutableState;
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
                t.i(lifecycleOwner, "<anonymous parameter 0>");
                t.i(event, "event");
                int i10 = C0412a.f19958a[event.ordinal()];
                if (i10 == 1) {
                    a.e(this.f19957c, false);
                    k.d(this.f19955a, null, null, new C0413b(this.f19956b, null), 3, null);
                } else if (i10 == 2 && this.f19956b.getValue().floatValue() > 0.0f) {
                    a.e(this.f19957c, true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0410a(LifecycleOwner lifecycleOwner, o0 o0Var, Animatable<Float, AnimationVector1D> animatable, MutableState<Boolean> mutableState) {
            super(1);
            this.f19949g = lifecycleOwner;
            this.f19950h = o0Var;
            this.f19951i = animatable;
            this.f19952j = mutableState;
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            b bVar = new b(this.f19950h, this.f19951i, this.f19952j);
            this.f19949g.getLifecycle().addObserver(bVar);
            return new C0411a(this.f19949g, bVar);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.RewardedCountDownTimerCustomKt$RewardedCountDownTimerCustom$1", f = "RewardedCountDownTimerCustom.kt", l = {92}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19961j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ Animatable<Float, AnimationVector1D> f19962k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ int f19963l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ MutableState<Boolean> f19964m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Animatable<Float, AnimationVector1D> animatable, int i10, MutableState<Boolean> mutableState, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f19962k = animatable;
            this.f19963l = i10;
            this.f19964m = mutableState;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new b(this.f19962k, this.f19963l, this.f19964m, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f19961j;
            if (i10 == 0) {
                u.b(obj);
                if (a.h(this.f19964m) && this.f19962k.getValue().floatValue() > 0.0f) {
                    long jC = ((long) c0.c(this.f19963l * 1000)) & 4294967295L;
                    Animatable<Float, AnimationVector1D> animatable = this.f19962k;
                    Float fC = kotlin.coroutines.jvm.internal.b.c(0.0f);
                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default((int) jC, 0, EasingKt.getLinearEasing(), 2, null);
                    this.f19961j = 1;
                    if (Animatable.animateTo$default(animatable, fC, tweenSpecTween$default, null, null, this, 12, null) == objE) {
                        return objE;
                    }
                }
                return k0.f35197a;
            }
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.RewardedCountDownTimerCustomKt$RewardedCountDownTimerCustom$2$1", f = "RewardedCountDownTimerCustom.kt", l = {}, m = "invokeSuspend")
    public static final class c extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19965j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ int f19966k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f19967l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i10, h9.a<k0> aVar, z8.d<? super c> dVar) {
            super(2, dVar);
            this.f19966k = i10;
            this.f19967l = aVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((c) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new c(this.f19966k, this.f19967l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f19965j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            if (this.f19966k == 0) {
                this.f19967l.invoke();
            }
            return k0.f35197a;
        }
    }

    public static final class d extends v implements l<SemanticsPropertyReceiver, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f19968g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(1);
            this.f19968g = str;
        }

        public final void a(@NotNull SemanticsPropertyReceiver semantics) {
            t.i(semantics, "$this$semantics");
            String str = this.f19968g;
            SemanticsPropertiesKt.setContentDescription(semantics, str);
            SemanticsPropertiesKt.setTestTag(semantics, str);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            a(semanticsPropertyReceiver);
            return k0.f35197a;
        }
    }

    public static final class e extends v implements l<IntSize, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ MutableState<IntSize> f19969g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(MutableState<IntSize> mutableState) {
            super(1);
            this.f19969g = mutableState;
        }

        public final void a(long j10) {
            a.d(this.f19969g, j10);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(IntSize intSize) {
            a(intSize.m3837unboximpl());
            return k0.f35197a;
        }
    }

    public static final class f extends v implements l<SemanticsPropertyReceiver, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f19970g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str) {
            super(1);
            this.f19970g = str;
        }

        public final void a(@NotNull SemanticsPropertyReceiver semantics) {
            t.i(semantics, "$this$semantics");
            String str = this.f19970g;
            SemanticsPropertiesKt.setContentDescription(semantics, str);
            SemanticsPropertiesKt.setTestTag(semantics, str);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            a(semanticsPropertyReceiver);
            return k0.f35197a;
        }
    }

    public static final class g extends v implements l<DrawScope, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f19971g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ float f19972h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Animatable<Float, AnimationVector1D> f19973i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ long f19974j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ MutableState<IntSize> f19975k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(long j10, float f10, Animatable<Float, AnimationVector1D> animatable, long j11, MutableState<IntSize> mutableState) {
            super(1);
            this.f19971g = j10;
            this.f19972h = f10;
            this.f19973i = animatable;
            this.f19974j = j11;
            this.f19975k = mutableState;
        }

        public final void a(@NotNull DrawScope Canvas) {
            t.i(Canvas, "$this$Canvas");
            long j10 = this.f19971g;
            long jSize = SizeKt.Size(IntSize.m3833getWidthimpl(a.a(this.f19975k)), IntSize.m3832getHeightimpl(a.a(this.f19975k)));
            float fMo296toPx0680j_4 = Canvas.mo296toPx0680j_4(this.f19972h);
            StrokeCap.Companion companion = StrokeCap.Companion;
            androidx.compose.ui.graphics.drawscope.b.v(Canvas, j10, 360.0f, 360.0f, false, 0L, jSize, 0.0f, new Stroke(fMo296toPx0680j_4, 0.0f, companion.m1886getRoundKaPHkGw(), 0, null, 26, null), null, 0, 848, null);
            if (this.f19973i.getValue().floatValue() > 0.0f) {
                androidx.compose.ui.graphics.drawscope.b.v(Canvas, this.f19974j, 270.0f, o.d(this.f19973i.getValue().floatValue(), 0.0f) * (-360.0f), false, 0L, SizeKt.Size(IntSize.m3833getWidthimpl(a.a(this.f19975k)), IntSize.m3832getHeightimpl(a.a(this.f19975k))), 0.0f, new Stroke(Canvas.mo296toPx0680j_4(this.f19972h), 0.0f, companion.m1886getRoundKaPHkGw(), 0, null, 26, null), null, 0, 848, null);
            }
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(DrawScope drawScope) {
            a(drawScope);
            return k0.f35197a;
        }
    }

    public static final class h extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f19976g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ long f19977h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Modifier f19978i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ float f19979j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ float f19980k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f19981l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f19982m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f19983n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ o0 f19984o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ int f19985p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ int f19986q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ int f19987r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final /* synthetic */ int f19988s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final /* synthetic */ int f19989t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(long j10, long j11, Modifier modifier, float f10, float f11, h9.a<k0> aVar, String str, LifecycleOwner lifecycleOwner, o0 o0Var, int i10, int i11, int i12, int i13, int i14) {
            super(2);
            this.f19976g = j10;
            this.f19977h = j11;
            this.f19978i = modifier;
            this.f19979j = f10;
            this.f19980k = f11;
            this.f19981l = aVar;
            this.f19982m = str;
            this.f19983n = lifecycleOwner;
            this.f19984o = o0Var;
            this.f19985p = i10;
            this.f19986q = i11;
            this.f19987r = i12;
            this.f19988s = i13;
            this.f19989t = i14;
        }

        public final void a(@Nullable Composer composer, int i10) {
            a.b(this.f19976g, this.f19977h, this.f19978i, this.f19979j, this.f19980k, this.f19981l, this.f19982m, this.f19983n, this.f19984o, this.f19985p, this.f19986q, composer, this.f19987r | 1, this.f19988s, this.f19989t);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final class i extends v implements h9.a<MutableState<Float>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final i f19990g = new i();

        public i() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MutableState<Float> invoke() {
            return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), null, 2, null);
        }
    }

    public static final long a(MutableState<IntSize> mutableState) {
        return mutableState.getValue().m3837unboximpl();
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0529  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0535  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x05c0  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:209:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0115  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(long r46, long r48, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r50, float r51, float r52, @org.jetbrains.annotations.NotNull h9.a<v8.k0> r53, @org.jetbrains.annotations.NotNull java.lang.String r54, @org.jetbrains.annotations.Nullable androidx.lifecycle.LifecycleOwner r55, @org.jetbrains.annotations.Nullable kotlinx.coroutines.o0 r56, int r57, int r58, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r59, int r60, int r61, int r62) {
        /*
            Method dump skipped, instruction units count: 1526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.b(long, long, androidx.compose.ui.Modifier, float, float, h9.a, java.lang.String, androidx.lifecycle.LifecycleOwner, kotlinx.coroutines.o0, int, int, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final void c(MutableState<Float> mutableState, float f10) {
        mutableState.setValue(Float.valueOf(f10));
    }

    public static final void d(MutableState<IntSize> mutableState, long j10) {
        mutableState.setValue(IntSize.m3825boximpl(j10));
    }

    public static final void e(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    public static final boolean h(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    public static final float i(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }
}

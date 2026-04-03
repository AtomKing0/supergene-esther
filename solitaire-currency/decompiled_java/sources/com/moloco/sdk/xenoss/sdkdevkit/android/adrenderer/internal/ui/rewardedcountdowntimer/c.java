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
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
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
public final class c {

    public static final class a extends v implements l<DisposableEffectScope, DisposableEffectResult> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f19991g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ o0 f19992h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Animatable<Float, AnimationVector1D> f19993i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ MutableState<Boolean> f19994j;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.c$a$a, reason: collision with other inner class name */
        public static final class C0414a implements DisposableEffectResult {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LifecycleOwner f19995a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ LifecycleEventObserver f19996b;

            public C0414a(LifecycleOwner lifecycleOwner, LifecycleEventObserver lifecycleEventObserver) {
                this.f19995a = lifecycleOwner;
                this.f19996b = lifecycleEventObserver;
            }

            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                this.f19995a.getLifecycle().removeObserver(this.f19996b);
            }
        }

        public static final class b implements LifecycleEventObserver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ o0 f19997a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Animatable<Float, AnimationVector1D> f19998b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ MutableState<Boolean> f19999c;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.c$a$b$a, reason: collision with other inner class name */
            public /* synthetic */ class C0415a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f20000a;

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
                    f20000a = iArr;
                }
            }

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.c$a$b$b, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.RewardedCountDownTimerKt$RewardedCountDownTimer$3$observer$1$onStateChanged$1", f = "RewardedCountDownTimer.kt", l = {112}, m = "invokeSuspend")
            public static final class C0416b extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public int f20001j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public final /* synthetic */ Animatable<Float, AnimationVector1D> f20002k;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0416b(Animatable<Float, AnimationVector1D> animatable, z8.d<? super C0416b> dVar) {
                    super(2, dVar);
                    this.f20002k = animatable;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                    return ((C0416b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    return new C0416b(this.f20002k, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object objE = a9.d.e();
                    int i10 = this.f20001j;
                    if (i10 == 0) {
                        u.b(obj);
                        Animatable<Float, AnimationVector1D> animatable = this.f20002k;
                        this.f20001j = 1;
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
                this.f19997a = o0Var;
                this.f19998b = animatable;
                this.f19999c = mutableState;
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
                t.i(lifecycleOwner, "<anonymous parameter 0>");
                t.i(event, "event");
                int i10 = C0415a.f20000a[event.ordinal()];
                if (i10 == 1) {
                    c.c(this.f19999c, false);
                    k.d(this.f19997a, null, null, new C0416b(this.f19998b, null), 3, null);
                } else if (i10 == 2 && this.f19998b.getValue().floatValue() > 0.0f) {
                    c.c(this.f19999c, true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LifecycleOwner lifecycleOwner, o0 o0Var, Animatable<Float, AnimationVector1D> animatable, MutableState<Boolean> mutableState) {
            super(1);
            this.f19991g = lifecycleOwner;
            this.f19992h = o0Var;
            this.f19993i = animatable;
            this.f19994j = mutableState;
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            b bVar = new b(this.f19992h, this.f19993i, this.f19994j);
            this.f19991g.getLifecycle().addObserver(bVar);
            return new C0414a(this.f19991g, bVar);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.RewardedCountDownTimerKt$RewardedCountDownTimer$1", f = "RewardedCountDownTimer.kt", l = {80, 84, 96}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20003j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ Animatable<Float, AnimationVector1D> f20004k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ float f20005l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f20006m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ MutableState<Boolean> f20007n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Animatable<Float, AnimationVector1D> animatable, float f10, int i10, MutableState<Boolean> mutableState, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f20004k = animatable;
            this.f20005l = f10;
            this.f20006m = i10;
            this.f20007n = mutableState;
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
            return new b(this.f20004k, this.f20005l, this.f20006m, this.f20007n, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f20003j;
            if (i10 == 0) {
                u.b(obj);
                Animatable<Float, AnimationVector1D> animatable = this.f20004k;
                Float fC = kotlin.coroutines.jvm.internal.b.c(this.f20005l);
                this.f20003j = 1;
                if (animatable.snapTo(fC, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    if (i10 == 2) {
                        u.b(obj);
                        return k0.f35197a;
                    }
                    if (i10 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                    return k0.f35197a;
                }
                u.b(obj);
            }
            if (!c.d(this.f20007n) || this.f20004k.getValue().floatValue() <= 0.0f) {
                Animatable<Float, AnimationVector1D> animatable2 = this.f20004k;
                this.f20003j = 3;
                if (animatable2.stop(this) == objE) {
                    return objE;
                }
                return k0.f35197a;
            }
            long jC = ((long) c0.c(this.f20006m * 1000)) & 4294967295L;
            Animatable<Float, AnimationVector1D> animatable3 = this.f20004k;
            Float fC2 = kotlin.coroutines.jvm.internal.b.c(0.0f);
            TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default((int) jC, 0, EasingKt.getLinearEasing(), 2, null);
            this.f20003j = 2;
            if (Animatable.animateTo$default(animatable3, fC2, tweenSpecTween$default, null, null, this, 12, null) == objE) {
                return objE;
            }
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.c$c, reason: collision with other inner class name */
    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.RewardedCountDownTimerKt$RewardedCountDownTimer$2$1", f = "RewardedCountDownTimer.kt", l = {}, m = "invokeSuspend")
    public static final class C0417c extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20008j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ int f20009k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f20010l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0417c(int i10, h9.a<k0> aVar, z8.d<? super C0417c> dVar) {
            super(2, dVar);
            this.f20009k = i10;
            this.f20010l = aVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((C0417c) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new C0417c(this.f20009k, this.f20010l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f20008j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            if (this.f20009k == 0) {
                this.f20010l.invoke();
            }
            return k0.f35197a;
        }
    }

    public static final class d extends v implements l<SemanticsPropertyReceiver, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f20011g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(1);
            this.f20011g = str;
        }

        public final void a(@NotNull SemanticsPropertyReceiver semantics) {
            t.i(semantics, "$this$semantics");
            String str = this.f20011g;
            SemanticsPropertiesKt.setContentDescription(semantics, str);
            SemanticsPropertiesKt.setTestTag(semantics, str);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            a(semanticsPropertyReceiver);
            return k0.f35197a;
        }
    }

    public static final class e extends v implements l<DrawScope, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f20012g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ float f20013h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Animatable<Float, AnimationVector1D> f20014i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ long f20015j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(long j10, float f10, Animatable<Float, AnimationVector1D> animatable, long j11) {
            super(1);
            this.f20012g = j10;
            this.f20013h = f10;
            this.f20014i = animatable;
            this.f20015j = j11;
        }

        public final void a(@NotNull DrawScope Canvas) {
            t.i(Canvas, "$this$Canvas");
            long j10 = this.f20012g;
            long jSize = SizeKt.Size(Size.m1436getWidthimpl(Canvas.mo1996getSizeNHjbRc()), Size.m1433getHeightimpl(Canvas.mo1996getSizeNHjbRc()));
            float fMo296toPx0680j_4 = Canvas.mo296toPx0680j_4(this.f20013h);
            StrokeCap.Companion companion = StrokeCap.Companion;
            androidx.compose.ui.graphics.drawscope.b.v(Canvas, j10, 360.0f, 360.0f, false, 0L, jSize, 0.0f, new Stroke(fMo296toPx0680j_4, 0.0f, companion.m1886getRoundKaPHkGw(), 0, null, 26, null), null, 0, 848, null);
            if (this.f20014i.getValue().floatValue() > 0.0f) {
                androidx.compose.ui.graphics.drawscope.b.v(Canvas, this.f20015j, 270.0f, o.d(this.f20014i.getValue().floatValue(), 0.0f) * (-360.0f), false, 0L, SizeKt.Size(Size.m1436getWidthimpl(Canvas.mo1996getSizeNHjbRc()), Size.m1433getHeightimpl(Canvas.mo1996getSizeNHjbRc())), 0.0f, new Stroke(Canvas.mo296toPx0680j_4(this.f20013h), 0.0f, companion.m1886getRoundKaPHkGw(), 0, null, 26, null), null, 0, 848, null);
            }
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(DrawScope drawScope) {
            a(drawScope);
            return k0.f35197a;
        }
    }

    public static final class f extends v implements l<SemanticsPropertyReceiver, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f20016g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str) {
            super(1);
            this.f20016g = str;
        }

        public final void a(@NotNull SemanticsPropertyReceiver semantics) {
            t.i(semantics, "$this$semantics");
            String str = this.f20016g;
            SemanticsPropertiesKt.setContentDescription(semantics, str);
            SemanticsPropertiesKt.setTestTag(semantics, str);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            a(semanticsPropertyReceiver);
            return k0.f35197a;
        }
    }

    public static final class g extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f20017g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ long f20018h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Modifier f20019i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ float f20020j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ float f20021k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f20022l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f20023m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ o0 f20024n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ int f20025o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ int f20026p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ int f20027q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ int f20028r;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(long j10, long j11, Modifier modifier, float f10, float f11, h9.a<k0> aVar, LifecycleOwner lifecycleOwner, o0 o0Var, int i10, int i11, int i12, int i13) {
            super(2);
            this.f20017g = j10;
            this.f20018h = j11;
            this.f20019i = modifier;
            this.f20020j = f10;
            this.f20021k = f11;
            this.f20022l = aVar;
            this.f20023m = lifecycleOwner;
            this.f20024n = o0Var;
            this.f20025o = i10;
            this.f20026p = i11;
            this.f20027q = i12;
            this.f20028r = i13;
        }

        public final void a(@Nullable Composer composer, int i10) {
            c.a(this.f20017g, this.f20018h, this.f20019i, this.f20020j, this.f20021k, this.f20022l, this.f20023m, this.f20024n, this.f20025o, this.f20026p, composer, this.f20027q | 1, this.f20028r);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final class h extends v implements h9.a<MutableState<Float>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final h f20029g = new h();

        public h() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MutableState<Float> invoke() {
            return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), null, 2, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0127  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(long r43, long r45, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r47, float r48, float r49, @org.jetbrains.annotations.NotNull h9.a<v8.k0> r50, @org.jetbrains.annotations.Nullable androidx.lifecycle.LifecycleOwner r51, @org.jetbrains.annotations.Nullable kotlinx.coroutines.o0 r52, int r53, int r54, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r55, int r56, int r57) {
        /*
            Method dump skipped, instruction units count: 1177
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.c.a(long, long, androidx.compose.ui.Modifier, float, float, h9.a, androidx.lifecycle.LifecycleOwner, kotlinx.coroutines.o0, int, int, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void b(MutableState<Float> mutableState, float f10) {
        mutableState.setValue(Float.valueOf(f10));
    }

    public static final void c(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    public static final boolean d(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    public static final float e(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }
}

package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.q;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class j {

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastProgressBarKt$VastProgressBar$1", f = "VastProgressBar.kt", l = {43, 45, 53}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20994j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ Animatable<Float, AnimationVector1D> f20995k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ float f20996l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ boolean f20997m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i f20998n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Animatable<Float, AnimationVector1D> animatable, float f10, boolean z10, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f20995k = animatable;
            this.f20996l = f10;
            this.f20997m = z10;
            this.f20998n = iVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new a(this.f20995k, this.f20996l, this.f20997m, this.f20998n, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f20994j;
            if (i10 == 0) {
                u.b(obj);
                Animatable<Float, AnimationVector1D> animatable = this.f20995k;
                Float fC = kotlin.coroutines.jvm.internal.b.c(this.f20996l);
                this.f20994j = 1;
                if (animatable.snapTo(fC, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    if (i10 != 2 && i10 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                    return k0.f35197a;
                }
                u.b(obj);
            }
            if (this.f20997m && (this.f20998n instanceof i.c)) {
                Animatable<Float, AnimationVector1D> animatable2 = this.f20995k;
                Float fC2 = kotlin.coroutines.jvm.internal.b.c(1.0f);
                TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(j.f(this.f20998n), 0, EasingKt.getLinearEasing(), 2, null);
                this.f20994j = 2;
                if (Animatable.animateTo$default(animatable2, fC2, tweenSpecTween$default, null, null, this, 12, null) == objE) {
                    return objE;
                }
            } else {
                Animatable<Float, AnimationVector1D> animatable3 = this.f20995k;
                this.f20994j = 3;
                if (animatable3.stop(this) == objE) {
                    return objE;
                }
            }
            return k0.f35197a;
        }
    }

    public static final class b extends v implements h9.l<DrawScope, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Animatable<Float, AnimationVector1D> f20999g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ float f21000h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ long f21001i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Animatable<Float, AnimationVector1D> animatable, float f10, long j10) {
            super(1);
            this.f20999g = animatable;
            this.f21000h = f10;
            this.f21001i = j10;
        }

        public final void a(@NotNull DrawScope drawBehind) {
            t.i(drawBehind, "$this$drawBehind");
            long jSize = SizeKt.Size(this.f20999g.getValue().floatValue() * Size.m1436getWidthimpl(drawBehind.mo1996getSizeNHjbRc()), Size.m1433getHeightimpl(drawBehind.mo1996getSizeNHjbRc()));
            float f10 = this.f21000h;
            androidx.compose.ui.graphics.drawscope.b.M(drawBehind, this.f21001i, 0L, jSize, CornerRadiusKt.CornerRadius(f10, f10), null, 0.0f, null, 0, 242, null);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(DrawScope drawScope) {
            a(drawScope);
            return k0.f35197a;
        }
    }

    public static final class c extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f21002g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i f21003h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Modifier f21004i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ long f21005j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ int f21006k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ int f21007l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(boolean z10, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, Modifier modifier, long j10, int i10, int i11) {
            super(2);
            this.f21002g = z10;
            this.f21003h = iVar;
            this.f21004i = modifier;
            this.f21005j = j10;
            this.f21006k = i10;
            this.f21007l = i11;
        }

        public final void a(@Nullable Composer composer, int i10) {
            j.d(this.f21002g, this.f21003h, this.f21004i, this.f21005j, composer, this.f21006k | 1, this.f21007l);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final class d extends v implements h9.a<MutableState<Float>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f21008g = new d();

        public d() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MutableState<Float> invoke() {
            return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
        }
    }

    public static final float a(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    public static final void c(MutableState<Float> mutableState, float f10) {
        mutableState.setValue(Float.valueOf(f10));
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(boolean r20, @org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i r21, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r22, long r23, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            Method dump skipped, instruction units count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.j.d(boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, androidx.compose.ui.Modifier, long, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final float e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar) {
        if (iVar instanceof i.a) {
            return 100.0f;
        }
        if (iVar instanceof i.c) {
            if (((i.c) iVar).b() != 0) {
                return (float) (r4.a() / r4.b());
            }
        } else if (!(iVar instanceof i.d) && !t.d(iVar, i.b.f21315a)) {
            throw new q();
        }
        return 0.0f;
    }

    public static final int f(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar) {
        if (iVar instanceof i.a) {
            return 0;
        }
        if (iVar instanceof i.c) {
            i.c cVar = (i.c) iVar;
            if (cVar.b() == 0) {
                return 0;
            }
            return o.e((int) (cVar.b() - cVar.a()), 0);
        }
        if ((iVar instanceof i.d) || t.d(iVar, i.b.f21315a)) {
            return 0;
        }
        throw new q();
    }
}

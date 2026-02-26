package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;
import s9.y;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class u implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final View f19621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final o0 f19622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public b2 f19623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final View.OnLayoutChangeListener f19624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final y<Boolean> f19625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f19626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final r f19627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final y<a> f19628h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final m0<a> f19629i;

    @StabilityInferred(parameters = 0)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final r f19630a;

        public a(@NotNull r value) {
            kotlin.jvm.internal.t.i(value, "value");
            this.f19630a = value;
        }

        @NotNull
        public final r a() {
            return this.f19630a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidViewVisualMetricsTracker$layoutChangeListener$1$1", f = "MraidViewVisualMetricsTracker.kt", l = {41}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19631j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ int f19633l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f19634m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ int f19635n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ int f19636o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i10, int i11, int i12, int i13, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f19633l = i10;
            this.f19634m = i11;
            this.f19635n = i12;
            this.f19636o = i13;
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
            return u.this.new b(this.f19633l, this.f19634m, this.f19635n, this.f19636o, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f19631j;
            if (i10 == 0) {
                v8.u.b(obj);
                this.f19631j = 1;
                if (y0.a(200L, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            u.this.t();
            u.this.g(this.f19633l, this.f19634m, this.f19635n, this.f19636o);
            return k0.f35197a;
        }
    }

    public u(@NotNull View view, @NotNull Context context, @NotNull o0 scope) {
        kotlin.jvm.internal.t.i(view, "view");
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(scope, "scope");
        this.f19621a = view;
        this.f19622b = p0.i(scope, com.moloco.sdk.internal.scheduling.c.a().getMain());
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.t
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                u.m(this.f19620a, view2, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
        this.f19624d = onLayoutChangeListener;
        view.addOnLayoutChangeListener(onLayoutChangeListener);
        y<Boolean> yVarA = s9.o0.a(Boolean.FALSE);
        this.f19625e = yVarA;
        this.f19626f = yVarA;
        r rVar = new r(context);
        this.f19627g = rVar;
        y<a> yVarA2 = s9.o0.a(new a(rVar));
        this.f19628h = yVarA2;
        this.f19629i = yVarA2;
    }

    public static final void m(u this$0, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        b2 b2Var = this$0.f19623c;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        this$0.f19623c = kotlinx.coroutines.k.d(this$0.f19622b, null, null, this$0.new b(i10, i11, i12, i13, null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public void destroy() {
        b2 b2Var = this.f19623c;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        this.f19621a.removeOnLayoutChangeListener(this.f19624d);
    }

    public final void g(int i10, int i11, int i12, int i13) {
        Rect rect = new Rect(i10, i11, i12, i13);
        int iWidth = rect.width();
        int iHeight = rect.height();
        r rVar = this.f19627g;
        rVar.b(i10, i11, iWidth, iHeight);
        rVar.e(i10, i11, iWidth, iHeight);
        rVar.f(i10, i11, iWidth, iHeight);
        rVar.a(iWidth, iHeight);
        this.f19628h.setValue(new a(this.f19627g));
    }

    @NotNull
    public final m0<a> n() {
        return this.f19629i;
    }

    @NotNull
    public final m0<Boolean> p() {
        return this.f19626f;
    }

    public final void t() {
        this.f19625e.setValue(Boolean.valueOf(this.f19621a.isShown()));
    }
}

package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.FrameLayout;
import com.moloco.sdk.service_locator.a;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"ViewConstructor"})
public final class f0 extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final Context f19247g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r f19248h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.d f19249i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g f19250j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m f19251k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public final e0 f19252l;

    public /* synthetic */ class a extends kotlin.jvm.internal.q implements h9.l<z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object> {
        public a(Object obj) {
            super(1, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m.class, "loadAndReadyMraid", "loadAndReadyMraid(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // h9.l
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> dVar) {
            return ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m) this.receiver).c0(dVar);
        }
    }

    public /* synthetic */ class b extends kotlin.jvm.internal.q implements h9.a<v8.k0> {
        public b(Object obj) {
            super(0, obj, f0.class, "detachMraidViewFromAdViewWrapper", "detachMraidViewFromAdViewWrapper()V", 0);
        }

        public final void c() {
            ((f0) this.receiver).t();
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ v8.k0 invoke() {
            c();
            return v8.k0.f35197a;
        }
    }

    public /* synthetic */ class c extends kotlin.jvm.internal.q implements h9.a<v8.k0> {
        public c(Object obj) {
            super(0, obj, f0.class, "attachMraidViewToAdViewWrapper", "attachMraidViewToAdViewWrapper()V", 0);
        }

        public final void c() {
            ((f0) this.receiver).p();
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ v8.k0 invoke() {
            c();
            return v8.k0.f35197a;
        }
    }

    public static final class d extends kotlin.jvm.internal.v implements h9.a<v8.k0> {
        public d() {
            super(0);
        }

        public final void b() {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c adShowListener = f0.this.getAdShowListener();
            if (adShowListener != null) {
                adShowListener.a();
            }
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ v8.k0 invoke() {
            b();
            return v8.k0.f35197a;
        }
    }

    public static final class e extends kotlin.jvm.internal.v implements h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, v8.k0> {
        public e() {
            super(1);
        }

        public final void a(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d it) {
            kotlin.jvm.internal.t.i(it, "it");
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c adShowListener = f0.this.getAdShowListener();
            if (adShowListener != null) {
                adShowListener.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.e.a(it));
            }
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar) {
            a(dVar);
            return v8.k0.f35197a;
        }
    }

    public /* synthetic */ f0(Context context, String str, z zVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r rVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.d dVar, o0 o0Var, int i10, kotlin.jvm.internal.k kVar) {
        this(context, str, zVar, rVar, (i10 & 16) != 0 ? new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.d() : dVar, o0Var);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public void destroy() {
        super.destroy();
        this.f19251k.destroy();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h
    @NotNull
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g getCreativeType() {
        return this.f19250j;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u
    public void m() {
        FrameLayout frameLayoutA = this.f19249i.a(this.f19247g, this.f19251k.c());
        this.f19248h.a(frameLayoutA);
        setAdView(frameLayoutA);
    }

    public final void p() {
        m();
    }

    public final void t() {
        setAdView(null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u
    @NotNull
    public e0 getAdLoader() {
        return this.f19252l;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(@NotNull Context context, @NotNull String adm, @NotNull z externalLinkHandler, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.d webViewWrapper, @NotNull o0 scope) {
        super(context, scope);
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(adm, "adm");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        kotlin.jvm.internal.t.i(webViewWrapper, "webViewWrapper");
        kotlin.jvm.internal.t.i(scope, "scope");
        this.f19247g = context;
        this.f19248h = watermark;
        this.f19249i = webViewWrapper;
        setTag("MolocoMraidBannerView");
        this.f19250j = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g.MRAID;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m mVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m(context, adm, new b(this), new c(this), new d(), new e(), true, externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.h.a(context, scope, false), null, 512, null);
        this.f19251k = mVar;
        this.f19252l = new e0(scope, null, a.C0337a.f18870a.a(), new a(mVar));
    }
}

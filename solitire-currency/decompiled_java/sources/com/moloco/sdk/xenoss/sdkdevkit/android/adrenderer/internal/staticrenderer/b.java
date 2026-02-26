package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import androidx.webkit.WebViewClientCompat;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.b0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.c0;
import s9.e0;
import s9.j;
import s9.m0;
import s9.x;
import s9.y;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends WebViewClientCompat implements h {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    public static final a f19740m = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final o0 f19741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final b0 f19742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final i f19743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final y<Boolean> f19744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f19745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final y<Boolean> f19746f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f19747g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final y<g> f19748h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final m0<g> f19749i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final x<k0> f19750j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public final c0<k0> f19751k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a f19752l;

    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.b$b, reason: collision with other inner class name */
    @f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.WebViewClientImpl$shouldOverrideUrlLoading$1$1$1", f = "WebViewClientImpl.kt", l = {79}, m = "invokeSuspend")
    public static final class C0395b extends l implements p<o0, d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19753j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f19755l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a f19756m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0395b(String str, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a aVar, d<? super C0395b> dVar) {
            super(2, dVar);
            this.f19755l = str;
            this.f19756m = aVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((C0395b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return b.this.new C0395b(this.f19755l, this.f19756m, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f19753j;
            if (i10 == 0) {
                u.b(obj);
                b0 b0Var = b.this.f19742b;
                String str = this.f19755l;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a aVar = this.f19756m;
                i iVarH = b.this.h();
                x<k0> xVar = b.this.f19750j;
                this.f19753j = 1;
                if (b0Var.a(str, aVar, iVarH, xVar, this) == objE) {
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

    public b(@NotNull o0 scope, @NotNull b0 clickthroughService, @NotNull i buttonTracker) {
        t.i(scope, "scope");
        t.i(clickthroughService, "clickthroughService");
        t.i(buttonTracker, "buttonTracker");
        this.f19741a = scope;
        this.f19742b = clickthroughService;
        this.f19743c = buttonTracker;
        Boolean bool = Boolean.FALSE;
        y<Boolean> yVarA = s9.o0.a(bool);
        this.f19744d = yVarA;
        this.f19745e = yVarA;
        y<Boolean> yVarA2 = s9.o0.a(bool);
        this.f19746f = yVarA2;
        this.f19747g = j.c(yVarA2);
        y<g> yVarA3 = s9.o0.a(null);
        this.f19748h = yVarA3;
        this.f19749i = j.c(yVarA3);
        x<k0> xVarB = e0.b(0, 0, null, 7, null);
        this.f19750j = xVarB;
        this.f19751k = xVarB;
    }

    public final void b(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a adTouch) {
        t.i(adTouch, "adTouch");
        this.f19752l = adTouch;
    }

    public final void e() {
        this.f19744d.setValue(Boolean.TRUE);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h
    public void g(@NotNull a.AbstractC0481a.c button) {
        t.i(button, "button");
        this.f19743c.g(button);
    }

    @NotNull
    public final i h() {
        return this.f19743c;
    }

    @NotNull
    public final c0<k0> i() {
        return this.f19751k;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h
    public void j(@NotNull a.AbstractC0481a.c.EnumC0483a buttonType) {
        t.i(buttonType, "buttonType");
        this.f19743c.j(buttonType);
    }

    @NotNull
    public final m0<g> l() {
        return this.f19749i;
    }

    @NotNull
    public final m0<Boolean> m() {
        return this.f19745e;
    }

    @NotNull
    public final m0<Boolean> o() {
        return this.f19747g;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        super.onPageFinished(webView, str);
        y<Boolean> yVar = this.f19744d;
        Boolean bool = Boolean.TRUE;
        yVar.setValue(bool);
        this.f19746f.setValue(bool);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(@Nullable WebView webView, int i10, @Nullable String str, @Nullable String str2) {
        super.onReceivedError(webView, i10, str, str2);
        this.f19748h.setValue(g.STATIC_AD_WEBVIEW_RECEIVED_ERROR);
        MolocoLogger.error$default(MolocoLogger.INSTANCE, "WebViewClientImpl", "onReceivedError " + str, null, false, 12, null);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(@Nullable WebView webView, @Nullable RenderProcessGoneDetail renderProcessGoneDetail) {
        this.f19748h.setValue(g.STATIC_AD_WEBVIEW_RENDER_PROCESS_GONE_ERROR);
        MolocoLogger.error$default(MolocoLogger.INSTANCE, "WebViewClientImpl", "onRenderProcessGone", null, false, 12, null);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(@Nullable WebView webView, @Nullable String str) {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a aVar;
        if (str == null || (aVar = this.f19752l) == null) {
            return true;
        }
        kotlinx.coroutines.k.d(this.f19741a, null, null, new C0395b(str, aVar, null), 3, null);
        return true;
    }
}

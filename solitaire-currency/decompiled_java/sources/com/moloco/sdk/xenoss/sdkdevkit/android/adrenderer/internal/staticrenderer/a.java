package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.webkit.WebSettings;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.scheduling.c;
import com.moloco.sdk.internal.services.b0;
import com.moloco.sdk.internal.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.k;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.g;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import h9.p;
import h9.q;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.f3;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.c0;
import s9.j;
import s9.m0;
import v8.k0;
import v8.s;
import v8.u;
import v8.y;
import z8.d;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"SetJavaScriptEnabled", "ViewConstructor"})
public final class a extends i implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final o0 f19720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final b0 f19721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i f19722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f19723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final b f19724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final g f19725f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final m0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g> f19726g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final c0<k0> f19727h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f19728i;

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a$a, reason: collision with other inner class name */
    @f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticWebView$loadHtml$2", f = "StaticWebView.kt", l = {114}, m = "invokeSuspend")
    public static final class C0392a extends l implements p<o0, d<? super t<k0, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g>>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19729j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f19731l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ long f19732m;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a$a$a, reason: collision with other inner class name */
        @f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticWebView$loadHtml$2$isLoadOperationTimedOut$1", f = "StaticWebView.kt", l = {120}, m = "invokeSuspend")
        public static final class C0393a extends l implements p<o0, d<? super s<? extends Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g>>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f19733j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ a f19734k;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a$a$a$a, reason: collision with other inner class name */
            @f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticWebView$loadHtml$2$isLoadOperationTimedOut$1$1", f = "StaticWebView.kt", l = {}, m = "invokeSuspend")
            public static final class C0394a extends l implements q<Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g, d<? super s<? extends Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g>>, Object> {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public int f19735j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public /* synthetic */ boolean f19736k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public /* synthetic */ Object f19737l;

                public C0394a(d<? super C0394a> dVar) {
                    super(3, dVar);
                }

                @Nullable
                public final Object f(boolean z10, @Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g gVar, @Nullable d<? super s<Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g>> dVar) {
                    C0394a c0394a = new C0394a(dVar);
                    c0394a.f19736k = z10;
                    c0394a.f19737l = gVar;
                    return c0394a.invokeSuspend(k0.f35197a);
                }

                @Override // h9.q
                public /* bridge */ /* synthetic */ Object invoke(Boolean bool, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g gVar, d<? super s<? extends Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g>> dVar) {
                    return f(bool.booleanValue(), gVar, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    a9.d.e();
                    if (this.f19735j != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                    boolean z10 = this.f19736k;
                    return y.a(kotlin.coroutines.jvm.internal.b.a(z10), (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g) this.f19737l);
                }
            }

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a$a$a$b */
            @f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticWebView$loadHtml$2$isLoadOperationTimedOut$1$2", f = "StaticWebView.kt", l = {}, m = "invokeSuspend")
            public static final class b extends l implements p<s<? extends Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g>, d<? super Boolean>, Object> {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public int f19738j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public /* synthetic */ Object f19739k;

                public b(d<? super b> dVar) {
                    super(2, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                    b bVar = new b(dVar);
                    bVar.f19739k = obj;
                    return bVar;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull s<Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g> sVar, @Nullable d<? super Boolean> dVar) {
                    return ((b) create(sVar, dVar)).invokeSuspend(k0.f35197a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    a9.d.e();
                    if (this.f19738j != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                    s sVar = (s) this.f19739k;
                    return kotlin.coroutines.jvm.internal.b.a(((Boolean) sVar.a()).booleanValue() || ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g) sVar.b()) != null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0393a(a aVar, d<? super C0393a> dVar) {
                super(2, dVar);
                this.f19734k = aVar;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super s<Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g>> dVar) {
                return ((C0393a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                return new C0393a(this.f19734k, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.f19733j;
                if (i10 == 0) {
                    u.b(obj);
                    s9.h hVarA = j.A(this.f19734k.f19724e.m(), this.f19734k.f19724e.l(), new C0394a(null));
                    b bVar = new b(null);
                    this.f19733j = 1;
                    obj = j.v(hVarA, bVar, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                }
                return obj;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0392a(String str, long j10, d<? super C0392a> dVar) {
            super(2, dVar);
            this.f19731l = str;
            this.f19732m = j10;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super t<k0, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g>> dVar) {
            return ((C0392a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return a.this.new C0392a(this.f19731l, this.f19732m, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f19729j;
            if (i10 == 0) {
                u.b(obj);
                try {
                    a aVar = a.this;
                    k.a(aVar, aVar.f19725f.a(this.f19731l));
                    long j10 = this.f19732m;
                    C0393a c0393a = new C0393a(a.this, null);
                    this.f19729j = 1;
                    obj = f3.f(j10, c0393a, this);
                    if (obj == objE) {
                        return objE;
                    }
                } catch (Exception e10) {
                    MolocoLogger.error$default(MolocoLogger.INSTANCE, "StaticWebView", "loadHtml", e10, false, 8, null);
                    return new t.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g.STATIC_AD_WEBVIEW_DATA_WITH_DEFAULT_BASE_URL_ERROR);
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            if (obj == null) {
                a.this.f19724e.e();
            }
            boolean zBooleanValue = a.this.f19724e.m().getValue().booleanValue();
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g value = a.this.f19724e.l().getValue();
            return value != null ? new t.a(value) : zBooleanValue ? new t.b(k0.f35197a) : new t.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g.STATIC_AD_UNKNOWN_ERROR);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ a(Context context, o0 o0Var, b0 b0Var, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i iVar, boolean z10, b bVar, g gVar, int i10, kotlin.jvm.internal.k kVar) {
        o0 o0VarA = (i10 & 2) != 0 ? p0.a(c.a().getMain()) : o0Var;
        this(context, o0VarA, b0Var, iVar, (i10 & 16) != 0 ? false : z10, (i10 & 32) != 0 ? new b(o0VarA, b0Var, iVar) : bVar, (i10 & 64) != 0 ? new g() : gVar);
    }

    @Nullable
    public final Object b(@NotNull String str, long j10, @NotNull d<? super t<k0, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g>> dVar) {
        return kotlinx.coroutines.i.g(c.a().getMain(), new C0392a(str, j10, null), dVar);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i, android.webkit.WebView
    public void destroy() {
        super.destroy();
        p0.e(this.f19720a, null, 1, null);
    }

    @NotNull
    public final m0<Boolean> e() {
        return this.f19728i;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h
    public void g(@NotNull a.AbstractC0481a.c button) {
        kotlin.jvm.internal.t.i(button, "button");
        this.f19724e.g(button);
    }

    @NotNull
    public final c0<k0> getClickthroughEvent() {
        return this.f19727h;
    }

    @NotNull
    public final m0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g> getUnrecoverableError() {
        return this.f19726g;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h
    public void j(@NotNull a.AbstractC0481a.c.EnumC0483a buttonType) {
        kotlin.jvm.internal.t.i(buttonType, "buttonType");
        this.f19724e.j(buttonType);
    }

    @Override // android.webkit.WebView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        kotlin.jvm.internal.t.i(event, "event");
        if (this.f19723d) {
            return false;
        }
        if (event.getAction() == 0) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            this.f19724e.b(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a(kotlin.collections.p.M(iArr), kotlin.collections.p.e0(iArr), getHeight(), getWidth(), (int) (event.getX() + kotlin.collections.p.M(iArr)), (int) (event.getY() + kotlin.collections.p.e0(iArr))));
        }
        return super.onTouchEvent(event);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context, @NotNull o0 scope, @NotNull b0 clickthroughService, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i buttonTracker, boolean z10, @NotNull b webViewClientImpl, @NotNull g htmlCssFixer) {
        super(context);
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(scope, "scope");
        kotlin.jvm.internal.t.i(clickthroughService, "clickthroughService");
        kotlin.jvm.internal.t.i(buttonTracker, "buttonTracker");
        kotlin.jvm.internal.t.i(webViewClientImpl, "webViewClientImpl");
        kotlin.jvm.internal.t.i(htmlCssFixer, "htmlCssFixer");
        this.f19720a = scope;
        this.f19721b = clickthroughService;
        this.f19722c = buttonTracker;
        this.f19723d = z10;
        this.f19724e = webViewClientImpl;
        this.f19725f = htmlCssFixer;
        setWebViewClient(webViewClientImpl);
        setScrollBarStyle(0);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        WebSettings settings = getSettings();
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        setBackgroundColor(0);
        setVisibility(8);
        this.f19726g = webViewClientImpl.l();
        this.f19727h = webViewClientImpl.i();
        this.f19728i = webViewClientImpl.o();
    }
}

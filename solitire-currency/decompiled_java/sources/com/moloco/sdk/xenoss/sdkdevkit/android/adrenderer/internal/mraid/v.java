package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.webkit.WebViewClientCompat;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.t;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;
import v8.k0;
import v8.y;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"SetJavaScriptEnabled", "ViewConstructor"})
public final class v extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f19637d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final w f19638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f19639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final m0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> f19640c;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidWebView$loadHtml$2", f = "MraidWebView.kt", l = {65}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super com.moloco.sdk.internal.t<c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19641j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ boolean f19642k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ v f19643l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f19644m;

        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidWebView$loadHtml$2$1", f = "MraidWebView.kt", l = {90}, m = "invokeSuspend")
        public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super com.moloco.sdk.internal.t<c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f19645j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ boolean f19646k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ v f19647l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ String f19648m;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.v$b$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidWebView$loadHtml$2$1$1", f = "MraidWebView.kt", l = {}, m = "invokeSuspend")
            public static final class C0387a extends kotlin.coroutines.jvm.internal.l implements h9.q<Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, z8.d<? super v8.s<? extends Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object> {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public int f19649j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public /* synthetic */ boolean f19650k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public /* synthetic */ Object f19651l;

                public C0387a(z8.d<? super C0387a> dVar) {
                    super(3, dVar);
                }

                @Nullable
                public final Object f(boolean z10, @Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar, @Nullable z8.d<? super v8.s<Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> dVar2) {
                    C0387a c0387a = new C0387a(dVar2);
                    c0387a.f19650k = z10;
                    c0387a.f19651l = dVar;
                    return c0387a.invokeSuspend(k0.f35197a);
                }

                @Override // h9.q
                public /* bridge */ /* synthetic */ Object invoke(Boolean bool, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar, z8.d<? super v8.s<? extends Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> dVar2) {
                    return f(bool.booleanValue(), dVar, dVar2);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    a9.d.e();
                    if (this.f19649j != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                    boolean z10 = this.f19650k;
                    return y.a(kotlin.coroutines.jvm.internal.b.a(z10), (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d) this.f19651l);
                }
            }

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.v$b$a$b, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidWebView$loadHtml$2$1$2", f = "MraidWebView.kt", l = {}, m = "invokeSuspend")
            public static final class C0388b extends kotlin.coroutines.jvm.internal.l implements h9.p<v8.s<? extends Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>, z8.d<? super Boolean>, Object> {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public int f19652j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public /* synthetic */ Object f19653k;

                public C0388b(z8.d<? super C0388b> dVar) {
                    super(2, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    C0388b c0388b = new C0388b(dVar);
                    c0388b.f19653k = obj;
                    return c0388b;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull v8.s<Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> sVar, @Nullable z8.d<? super Boolean> dVar) {
                    return ((C0388b) create(sVar, dVar)).invokeSuspend(k0.f35197a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    a9.d.e();
                    if (this.f19652j != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                    v8.s sVar = (v8.s) this.f19653k;
                    return kotlin.coroutines.jvm.internal.b.a(((Boolean) sVar.a()).booleanValue() || ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d) sVar.b()) != null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(boolean z10, v vVar, String str, z8.d<? super a> dVar) {
                super(2, dVar);
                this.f19646k = z10;
                this.f19647l = vVar;
                this.f19648m = str;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.internal.t<c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> dVar) {
                return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new a(this.f19646k, this.f19647l, this.f19648m, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.f19645j;
                if (i10 == 0) {
                    v8.u.b(obj);
                    try {
                        if (this.f19646k) {
                            Context context = this.f19647l.getContext();
                            kotlin.jvm.internal.t.h(context, "context");
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.k.a(this.f19647l, new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.h(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.c(context), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.e(), null, 4, null).a(this.f19648m));
                        } else {
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.k.a(this.f19647l, this.f19648m);
                        }
                        s9.h hVarA = s9.j.A(this.f19647l.f19638a.e(), this.f19647l.f19638a.c(), new C0387a(null));
                        C0388b c0388b = new C0388b(null);
                        this.f19645j = 1;
                        obj = s9.j.v(hVarA, c0388b, this);
                        if (obj == objE) {
                            return objE;
                        }
                    } catch (Exception e10) {
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, "MraidWebView", e10.toString(), null, false, 12, null);
                        return new t.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d.MRAID_WEBVIEW_LOAD_DATA_WITH_BASE_URL_ERROR);
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                }
                v8.s sVar = (v8.s) obj;
                boolean zBooleanValue = ((Boolean) sVar.a()).booleanValue();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d) sVar.b();
                return dVar != null ? new t.a(dVar) : zBooleanValue ? new t.b(new c(null, 1, null)) : new t.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d.MRAID_WEBVIEW_PAGE_DIDNT_LOAD_ERROR);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z10, v vVar, String str, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f19642k = z10;
            this.f19643l = vVar;
            this.f19644m = str;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.internal.t<c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> dVar) {
            return ((b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new b(this.f19642k, this.f19643l, this.f19644m, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f19641j;
            if (i10 == 0) {
                v8.u.b(obj);
                z8.g main = com.moloco.sdk.internal.scheduling.c.a().getMain();
                a aVar = new a(this.f19642k, this.f19643l, this.f19644m, null);
                this.f19641j = 1;
                obj = kotlinx.coroutines.i.g(main, aVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return obj;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(@NotNull Context context, @NotNull o mraidJsCommandUrlSource) {
        super(context);
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(mraidJsCommandUrlSource, "mraidJsCommandUrlSource");
        WebView.setWebContentsDebuggingEnabled(false);
        setScrollBarStyle(0);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setScrollContainer(false);
        WebSettings settings = getSettings();
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setMediaPlaybackRequiresUserGesture(true);
        setVisibility(8);
        w wVar = new w(context, mraidJsCommandUrlSource);
        setWebViewClient(wVar);
        this.f19638a = wVar;
        this.f19639b = wVar.e();
        this.f19640c = wVar.c();
    }

    @Nullable
    public final Object b(@NotNull String str, boolean z10, @NotNull z8.d<? super com.moloco.sdk.internal.t<c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> dVar) {
        return p0.f(new b(z10, this, str, null), dVar);
    }

    @NotNull
    public final m0<Boolean> c() {
        return this.f19639b;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i, android.webkit.WebView
    public void destroy() {
        super.destroy();
        setWebViewClient(new WebViewClientCompat());
    }

    @NotNull
    public final m0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> getUnrecoverableError() {
        return this.f19640c;
    }
}

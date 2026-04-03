package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.VisibleForTesting;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"ViewConstructor"})
public final class l0 extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final Context f19331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r f19332h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a f19333i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final k0 f19334j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public final o0 f19335k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.d f19336l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g f19337m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    public final v8.l f19338n;

    public static final class a extends kotlin.jvm.internal.v implements h9.a<m0<? extends Boolean>> {

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.l0$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticBannerView$isAdDisplaying$2$1", f = "StaticBanner.kt", l = {}, m = "invokeSuspend")
        public static final class C0373a extends kotlin.coroutines.jvm.internal.l implements h9.q<Boolean, Boolean, z8.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f19340j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public /* synthetic */ boolean f19341k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public /* synthetic */ boolean f19342l;

            public C0373a(z8.d<? super C0373a> dVar) {
                super(3, dVar);
            }

            @Nullable
            public final Object f(boolean z10, boolean z11, @Nullable z8.d<? super Boolean> dVar) {
                C0373a c0373a = new C0373a(dVar);
                c0373a.f19341k = z10;
                c0373a.f19342l = z11;
                return c0373a.invokeSuspend(v8.k0.f35197a);
            }

            @Override // h9.q
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Boolean bool2, z8.d<? super Boolean> dVar) {
                return f(bool.booleanValue(), bool2.booleanValue(), dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f19340j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
                return kotlin.coroutines.jvm.internal.b.a(this.f19341k && this.f19342l);
            }
        }

        public a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final m0<Boolean> invoke() {
            return s9.j.L(s9.j.A(l0.super.l(), l0.this.f19333i.e(), new C0373a(null)), l0.this.f19335k, s9.i0.f33702a.c(), Boolean.FALSE);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticBannerView$prepareAdViewForDisplay$1", f = "StaticBanner.kt", l = {}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19343j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f19344k;

        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticBannerView$prepareAdViewForDisplay$1$1", f = "StaticBanner.kt", l = {50}, m = "invokeSuspend")
        public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super v8.k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f19346j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ l0 f19347k;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.l0$b$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticBannerView$prepareAdViewForDisplay$1$1$error$1", f = "StaticBanner.kt", l = {}, m = "invokeSuspend")
            public static final class C0374a extends kotlin.coroutines.jvm.internal.l implements h9.p<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g, z8.d<? super Boolean>, Object> {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public int f19348j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public /* synthetic */ Object f19349k;

                public C0374a(z8.d<? super C0374a> dVar) {
                    super(2, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    C0374a c0374a = new C0374a(dVar);
                    c0374a.f19349k = obj;
                    return c0374a;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
                public final Object mo4invoke(@Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g gVar, @Nullable z8.d<? super Boolean> dVar) {
                    return ((C0374a) create(gVar, dVar)).invokeSuspend(v8.k0.f35197a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    a9.d.e();
                    if (this.f19348j != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                    return kotlin.coroutines.jvm.internal.b.a(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g) this.f19349k) != null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(l0 l0Var, z8.d<? super a> dVar) {
                super(2, dVar);
                this.f19347k = l0Var;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
                return ((a) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new a(this.f19347k, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c adShowListener;
                Object objE = a9.d.e();
                int i10 = this.f19346j;
                if (i10 == 0) {
                    v8.u.b(obj);
                    m0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g> unrecoverableError = this.f19347k.f19333i.getUnrecoverableError();
                    C0374a c0374a = new C0374a(null);
                    this.f19346j = 1;
                    obj = s9.j.v(unrecoverableError, c0374a, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g gVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g) obj;
                if (gVar != null && (adShowListener = this.f19347k.getAdShowListener()) != null) {
                    adShowListener.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.h.a(gVar));
                }
                return v8.k0.f35197a;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.l0$b$b, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticBannerView$prepareAdViewForDisplay$1$2", f = "StaticBanner.kt", l = {56}, m = "invokeSuspend")
        public static final class C0375b extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super v8.k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f19350j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ l0 f19351k;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.l0$b$b$a */
            public static final class a implements s9.i<v8.k0> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ l0 f19352a;

                public a(l0 l0Var) {
                    this.f19352a = l0Var;
                }

                @Override // s9.i
                @Nullable
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object emit(@NotNull v8.k0 k0Var, @NotNull z8.d<? super v8.k0> dVar) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c adShowListener = this.f19352a.getAdShowListener();
                    if (adShowListener != null) {
                        adShowListener.a();
                    }
                    return v8.k0.f35197a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0375b(l0 l0Var, z8.d<? super C0375b> dVar) {
                super(2, dVar);
                this.f19351k = l0Var;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
                return ((C0375b) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new C0375b(this.f19351k, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.f19350j;
                if (i10 == 0) {
                    v8.u.b(obj);
                    s9.c0<v8.k0> clickthroughEvent = this.f19351k.f19333i.getClickthroughEvent();
                    a aVar = new a(this.f19351k);
                    this.f19350j = 1;
                    if (clickthroughEvent.collect(aVar, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                }
                throw new v8.h();
            }
        }

        public b(z8.d<? super b> dVar) {
            super(2, dVar);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((b) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            b bVar = l0.this.new b(dVar);
            bVar.f19344k = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f19343j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            o0 o0Var = (o0) this.f19344k;
            kotlinx.coroutines.k.d(o0Var, null, null, new a(l0.this, null), 3, null);
            kotlinx.coroutines.k.d(o0Var, null, null, new C0375b(l0.this, null), 3, null);
            l0 l0Var = l0.this;
            FrameLayout frameLayoutA = l0Var.f19336l.a(l0.this.f19331g, l0.this.f19333i);
            l0.this.getWatermark().a(frameLayoutA);
            l0Var.setAdView(frameLayoutA);
            return v8.k0.f35197a;
        }
    }

    public /* synthetic */ l0(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r rVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a aVar, k0 k0Var, o0 o0Var, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.d dVar, int i10, kotlin.jvm.internal.k kVar) {
        this(context, rVar, aVar, k0Var, o0Var, (i10 & 32) != 0 ? new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.d() : dVar);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public void destroy() {
        super.destroy();
        this.f19333i.destroy();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h
    @NotNull
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g getCreativeType() {
        return this.f19337m;
    }

    @VisibleForTesting
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r getWatermark() {
        return this.f19332h;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a
    @NotNull
    public m0<Boolean> l() {
        return (m0) this.f19338n.getValue();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u
    public void m() {
        kotlinx.coroutines.i.c(this.f19335k, z8.h.f37608a, q0.DEFAULT, new b(null));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u
    @NotNull
    public k0 getAdLoader() {
        return this.f19334j;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(@NotNull Context context, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a staticWebView, @NotNull k0 adLoader, @NotNull o0 scope, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.d webViewWrapper) {
        super(context, scope);
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        kotlin.jvm.internal.t.i(staticWebView, "staticWebView");
        kotlin.jvm.internal.t.i(adLoader, "adLoader");
        kotlin.jvm.internal.t.i(scope, "scope");
        kotlin.jvm.internal.t.i(webViewWrapper, "webViewWrapper");
        this.f19331g = context;
        this.f19332h = watermark;
        this.f19333i = staticWebView;
        this.f19334j = adLoader;
        this.f19335k = scope;
        this.f19336l = webViewWrapper;
        setTag("MolocoStaticBannerView");
        this.f19337m = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g.STATIC;
        this.f19338n = v8.n.a(new a());
    }
}

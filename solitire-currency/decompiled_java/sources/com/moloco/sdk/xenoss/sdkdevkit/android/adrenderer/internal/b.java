package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f19024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r f19025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g f19026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final o0 f19027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a f19028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final k0 f19029f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final s9.y<Boolean> f19030g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final v8.l f19031h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final s9.y<Boolean> f19032i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f19033j;

    public static final class a extends kotlin.jvm.internal.v implements h9.a<m0<? extends Boolean>> {

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticFullscreenAdImpl$isAdDisplaying$2$1", f = "StaticFullscreenAd.kt", l = {}, m = "invokeSuspend")
        public static final class C0355a extends kotlin.coroutines.jvm.internal.l implements h9.q<Boolean, Boolean, z8.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f19035j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public /* synthetic */ boolean f19036k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public /* synthetic */ boolean f19037l;

            public C0355a(z8.d<? super C0355a> dVar) {
                super(3, dVar);
            }

            @Nullable
            public final Object f(boolean z10, boolean z11, @Nullable z8.d<? super Boolean> dVar) {
                C0355a c0355a = new C0355a(dVar);
                c0355a.f19036k = z10;
                c0355a.f19037l = z11;
                return c0355a.invokeSuspend(v8.k0.f35197a);
            }

            @Override // h9.q
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Boolean bool2, z8.d<? super Boolean> dVar) {
                return f(bool.booleanValue(), bool2.booleanValue(), dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f19035j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
                return kotlin.coroutines.jvm.internal.b.a(this.f19036k && this.f19037l);
            }
        }

        public a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final m0<Boolean> invoke() {
            return s9.j.L(s9.j.A(b.this.f19030g, b.this.f19028e.e(), new C0355a(null)), b.this.f19027d, s9.i0.f33702a.c(), Boolean.FALSE);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$b, reason: collision with other inner class name */
    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticFullscreenAdImpl$show$1", f = "StaticFullscreenAd.kt", l = {100}, m = "invokeSuspend")
    public static final class C0356b extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19038j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f19039k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d f19041m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c f19042n;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$b$a */
        public /* synthetic */ class a extends kotlin.jvm.internal.q implements h9.a<v8.k0> {
            public a(Object obj) {
                super(0, obj, b.class, "onClose", "onClose()V", 0);
            }

            public final void c() {
                ((b) this.receiver).t();
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ v8.k0 invoke() {
                c();
                return v8.k0.f35197a;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$b$b, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticFullscreenAdImpl$show$1$eventHandlers$1", f = "StaticFullscreenAd.kt", l = {86}, m = "invokeSuspend")
        public static final class C0357b extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super v8.k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f19043j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ b f19044k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c f19045l;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$b$b$a */
            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticFullscreenAdImpl$show$1$eventHandlers$1$error$1", f = "StaticFullscreenAd.kt", l = {}, m = "invokeSuspend")
            public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g, z8.d<? super Boolean>, Object> {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public int f19046j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public /* synthetic */ Object f19047k;

                public a(z8.d<? super a> dVar) {
                    super(2, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    a aVar = new a(dVar);
                    aVar.f19047k = obj;
                    return aVar;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
                public final Object mo4invoke(@Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g gVar, @Nullable z8.d<? super Boolean> dVar) {
                    return ((a) create(gVar, dVar)).invokeSuspend(v8.k0.f35197a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    a9.d.e();
                    if (this.f19046j != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                    return kotlin.coroutines.jvm.internal.b.a(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g) this.f19047k) != null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0357b(b bVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c cVar, z8.d<? super C0357b> dVar) {
                super(2, dVar);
                this.f19044k = bVar;
                this.f19045l = cVar;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
                return ((C0357b) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new C0357b(this.f19044k, this.f19045l, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c cVar;
                Object objE = a9.d.e();
                int i10 = this.f19043j;
                if (i10 == 0) {
                    v8.u.b(obj);
                    m0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g> unrecoverableError = this.f19044k.f19028e.getUnrecoverableError();
                    a aVar = new a(null);
                    this.f19043j = 1;
                    obj = s9.j.v(unrecoverableError, aVar, this);
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
                if (gVar != null && (cVar = this.f19045l) != null) {
                    cVar.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.h.b(gVar));
                }
                return v8.k0.f35197a;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$b$c */
        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticFullscreenAdImpl$show$1$eventHandlers$2", f = "StaticFullscreenAd.kt", l = {92}, m = "invokeSuspend")
        public static final class c extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super v8.k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f19048j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ b f19049k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c f19050l;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$b$c$a */
            public static final class a implements s9.i<v8.k0> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c f19051a;

                public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c cVar) {
                    this.f19051a = cVar;
                }

                @Override // s9.i
                @Nullable
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object emit(@NotNull v8.k0 k0Var, @NotNull z8.d<? super v8.k0> dVar) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c cVar = this.f19051a;
                    if (cVar != null) {
                        cVar.a();
                    }
                    return v8.k0.f35197a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(b bVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c cVar, z8.d<? super c> dVar) {
                super(2, dVar);
                this.f19049k = bVar;
                this.f19050l = cVar;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
                return ((c) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new c(this.f19049k, this.f19050l, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.f19048j;
                if (i10 == 0) {
                    v8.u.b(obj);
                    s9.c0<v8.k0> clickthroughEvent = this.f19049k.f19028e.getClickthroughEvent();
                    a aVar = new a(this.f19050l);
                    this.f19048j = 1;
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0356b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d dVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c cVar, z8.d<? super C0356b> dVar2) {
            super(2, dVar2);
            this.f19041m = dVar;
            this.f19042n = cVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((C0356b) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C0356b c0356b = b.this.new C0356b(this.f19041m, this.f19042n, dVar);
            c0356b.f19039k = obj;
            return c0356b;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0095 A[LOOP:0: B:18:0x008f->B:20:0x0095, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00bd A[LOOP:1: B:26:0x00b7->B:28:0x00bd, LOOP_END] */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 213
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b.C0356b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public b(@NotNull Context context, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @NotNull String adm, @NotNull z externalLinkHandler, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(customUserEventBuilderService, "customUserEventBuilderService");
        kotlin.jvm.internal.t.i(adm, "adm");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        this.f19024a = context;
        this.f19025b = watermark;
        this.f19026c = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g.STATIC;
        o0 o0VarA = p0.a(com.moloco.sdk.internal.scheduling.c.a().getMain());
        this.f19027d = o0VarA;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a aVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a(context, null, new com.moloco.sdk.internal.services.c0(externalLinkHandler, customUserEventBuilderService), com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.k.a(), false, null, null, 114, null);
        this.f19028e = aVar;
        this.f19029f = new k0(adm, o0VarA, aVar);
        Boolean bool = Boolean.FALSE;
        this.f19030g = s9.o0.a(bool);
        this.f19031h = v8.n.a(new a());
        s9.y<Boolean> yVarA = s9.o0.a(bool);
        this.f19032i = yVarA;
        this.f19033j = yVarA;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public void destroy() {
        p0.e(this.f19027d, null, 1, null);
        this.f19028e.destroy();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    public void g(long j10, @Nullable b.a aVar) {
        this.f19029f.g(j10, aVar);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h
    @NotNull
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g getCreativeType() {
        return this.f19026c;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    @NotNull
    public m0<Boolean> isLoaded() {
        return this.f19029f.isLoaded();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a
    @NotNull
    public m0<Boolean> l() {
        return (m0) this.f19031h.getValue();
    }

    public final void t() {
        this.f19030g.setValue(Boolean.FALSE);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    @NotNull
    public m0<Boolean> j() {
        return this.f19033j;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void f(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d options, @Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c cVar) {
        kotlin.jvm.internal.t.i(options, "options");
        kotlinx.coroutines.k.d(this.f19027d, null, null, new C0356b(options, cVar, null), 3, null);
    }
}

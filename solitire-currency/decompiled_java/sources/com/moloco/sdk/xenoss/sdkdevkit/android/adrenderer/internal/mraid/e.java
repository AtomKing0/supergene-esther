package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import androidx.media3.extractor.ts.TsExtractor;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.u;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public class e implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f19517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final q f19518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public h9.a<k0> f19519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, k0> f19520d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final z f19521e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f19522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f f19523g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final String f19524h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final o0 f19525i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c f19526j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public s f19527k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public final u f19528l;

    public static final class b extends kotlin.jvm.internal.v implements h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f19530g = new b();

        public b() {
            super(1);
        }

        public final void a(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d it) {
            kotlin.jvm.internal.t.i(it, "it");
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar) {
            a(dVar);
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidBaseAd$loadAndReadyMraid$2", f = "MraidBaseAd.kt", l = {TsExtractor.TS_STREAM_TYPE_AC4}, m = "invokeSuspend")
    public static final class c extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19531j;

        public c(z8.d<? super c> dVar) {
            super(2, dVar);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> dVar) {
            return ((c) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return e.this.new c(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c cVar;
            Object objE = a9.d.e();
            int i10 = this.f19531j;
            if (i10 == 0) {
                v8.u.b(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f fVarL0 = e.this.l0();
                String str = e.this.f19517a;
                this.f19531j = 1;
                obj = fVarL0.b(str, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            com.moloco.sdk.internal.t tVar = (com.moloco.sdk.internal.t) obj;
            boolean z10 = tVar instanceof t.a;
            if (z10) {
                return tVar;
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f fVarL02 = e.this.l0();
            e eVar = e.this;
            fVarL02.i(false, false, false, false, true);
            fVarL02.c(eVar.f19518b);
            fVarL02.k(eVar.f19528l.p().getValue().booleanValue());
            fVarL02.d(eVar.f19528l.n().getValue().a());
            eVar.d0(s.Default);
            eVar.C();
            eVar.L();
            eVar.R();
            fVarL02.i();
            e eVar2 = e.this;
            if (tVar instanceof t.b) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, eVar2.f19524h, "Mraid Html data successfully loaded", null, false, 12, null);
                cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c) ((t.b) tVar).a();
            } else {
                if (!z10) {
                    throw new v8.q();
                }
                MolocoLogger.error$default(MolocoLogger.INSTANCE, eVar2.f19524h, "Mraid Html data load failed.", null, false, 12, null);
                cVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c(null, 1, null);
            }
            eVar2.f19526j = cVar;
            return tVar;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidBaseAd$startListeningToErrors$1", f = "MraidBaseAd.kt", l = {59}, m = "invokeSuspend")
    public static final class d extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19533j;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f19535a;

            static {
                int[] iArr = new int[q.values().length];
                try {
                    iArr[q.Interstitial.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[q.Inline.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f19535a = iArr;
            }
        }

        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidBaseAd$startListeningToErrors$1$error$1", f = "MraidBaseAd.kt", l = {}, m = "invokeSuspend")
        public static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, z8.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f19536j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public /* synthetic */ Object f19537k;

            public b(z8.d<? super b> dVar) {
                super(2, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                b bVar = new b(dVar);
                bVar.f19537k = obj;
                return bVar;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar, @Nullable z8.d<? super Boolean> dVar2) {
                return ((b) create(dVar, dVar2)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f19536j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
                return kotlin.coroutines.jvm.internal.b.a(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d) this.f19537k) != null);
            }
        }

        public d(z8.d<? super d> dVar) {
            super(2, dVar);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((d) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return e.this.new d(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f19533j;
            if (i10 == 0) {
                v8.u.b(obj);
                m0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> m0VarX = e.this.l0().x();
                b bVar = new b(null);
                this.f19533j = 1;
                obj = s9.j.v(m0VarX, bVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d) obj;
            if (dVar != null) {
                e eVar = e.this;
                int i11 = a.f19535a[eVar.f19518b.ordinal()];
                if (i11 == 1) {
                    eVar.l().invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.e.b(dVar));
                } else if (i11 == 2) {
                    eVar.l().invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.e.a(dVar));
                }
            }
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e$e, reason: collision with other inner class name */
    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidBaseAd$startListeningToMraidJsCommands$1", f = "MraidBaseAd.kt", l = {}, m = "invokeSuspend")
    public static final class C0385e extends kotlin.coroutines.jvm.internal.l implements h9.p<n, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19538j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f19539k;

        public C0385e(z8.d<? super C0385e> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C0385e c0385e = e.this.new C0385e(dVar);
            c0385e.f19539k = obj;
            return c0385e;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull n nVar, @Nullable z8.d<? super k0> dVar) {
            return ((C0385e) create(nVar, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f19538j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            n nVar = (n) this.f19539k;
            if (kotlin.jvm.internal.t.d(nVar, n.a.f19588c)) {
                e.this.m();
            } else if (nVar instanceof n.d) {
                e.this.Y((n.d) nVar);
            } else if (!(nVar instanceof n.f)) {
                if (nVar instanceof n.c) {
                    e.this.X((n.c) nVar);
                } else {
                    e.this.l0().h(nVar, "unsupported command: " + nVar.a());
                }
            }
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidBaseAd$startListeningToVisualMetricsChanges$1", f = "MraidBaseAd.kt", l = {}, m = "invokeSuspend")
    public static final class f extends kotlin.coroutines.jvm.internal.l implements h9.p<Boolean, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19541j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ boolean f19542k;

        public f(z8.d<? super f> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            f fVar = e.this.new f(dVar);
            fVar.f19542k = ((Boolean) obj).booleanValue();
            return fVar;
        }

        @Nullable
        public final Object f(boolean z10, @Nullable z8.d<? super k0> dVar) {
            return ((f) create(Boolean.valueOf(z10), dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Boolean bool, z8.d<? super k0> dVar) {
            return f(bool.booleanValue(), dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f19541j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            e.this.l0().k(this.f19542k);
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidBaseAd$startListeningToVisualMetricsChanges$2", f = "MraidBaseAd.kt", l = {}, m = "invokeSuspend")
    public static final class g extends kotlin.coroutines.jvm.internal.l implements h9.p<u.a, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19544j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f19545k;

        public g(z8.d<? super g> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            g gVar = e.this.new g(dVar);
            gVar.f19545k = obj;
            return gVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull u.a aVar, @Nullable z8.d<? super k0> dVar) {
            return ((g) create(aVar, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f19544j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            e.this.l0().d(((u.a) this.f19545k).a());
            return k0.f35197a;
        }
    }

    public e(@NotNull Context context, @NotNull String adm, @NotNull q mraidPlacementType, @NotNull h9.a<k0> onClick, @NotNull h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, k0> onError, @NotNull z externalLinkHandler, boolean z10, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f mraidBridge) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(adm, "adm");
        kotlin.jvm.internal.t.i(mraidPlacementType, "mraidPlacementType");
        kotlin.jvm.internal.t.i(onClick, "onClick");
        kotlin.jvm.internal.t.i(onError, "onError");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(mraidBridge, "mraidBridge");
        this.f19517a = adm;
        this.f19518b = mraidPlacementType;
        this.f19519c = onClick;
        this.f19520d = onError;
        this.f19521e = externalLinkHandler;
        this.f19522f = z10;
        this.f19523g = mraidBridge;
        this.f19524h = "MraidBaseAd";
        o0 o0VarA = p0.a(com.moloco.sdk.internal.scheduling.c.a().getMain());
        this.f19525i = o0VarA;
        this.f19528l = new u(mraidBridge.c(), context, o0VarA);
    }

    public final void C() {
        kotlinx.coroutines.k.d(this.f19525i, null, null, new d(null), 3, null);
    }

    public final void L() {
        s9.j.D(s9.j.G(this.f19523g.w(), new C0385e(null)), this.f19525i);
    }

    public final void R() {
        s9.j.D(s9.j.G(this.f19528l.p(), new f(null)), this.f19525i);
        s9.j.D(s9.j.G(this.f19528l.n(), new g(null)), this.f19525i);
    }

    public final void X(n.c cVar) {
        if (this.f19522f) {
            this.f19523g.h(cVar, "expand() is force blocked for the current ad");
            return;
        }
        if (!this.f19528l.p().getValue().booleanValue()) {
            this.f19523g.h(cVar, "Can't expand() when mraid container is not visible to the user");
            return;
        }
        if (this.f19527k != s.Default) {
            this.f19523g.h(cVar, "In order to expand() mraid ad, container must be in Default view state");
            return;
        }
        if (this.f19518b == q.Interstitial) {
            this.f19523g.h(cVar, "expand() is not supported for interstitials");
        } else if (cVar.b() != null) {
            this.f19523g.h(cVar, "Two-part expand is not supported yet");
        } else {
            t();
            d0(s.Expanded);
        }
    }

    public final void Y(n.d dVar) {
        if (!this.f19528l.p().getValue().booleanValue()) {
            this.f19523g.h(dVar, "Can't open links when mraid container is not visible to the user");
            return;
        }
        z zVar = this.f19521e;
        String string = dVar.b().toString();
        kotlin.jvm.internal.t.h(string, "openCmd.uri.toString()");
        zVar.a(string);
        this.f19519c.invoke();
    }

    public final void Z(@NotNull h9.a<k0> aVar) {
        kotlin.jvm.internal.t.i(aVar, "<set-?>");
        this.f19519c = aVar;
    }

    public final void a0(@NotNull h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, k0> lVar) {
        kotlin.jvm.internal.t.i(lVar, "<set-?>");
        this.f19520d = lVar;
    }

    @Nullable
    public final Object c0(@NotNull z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> dVar) {
        return kotlinx.coroutines.k.b(this.f19525i, null, null, new c(null), 3, null).i0(dVar);
    }

    public final void d0(s sVar) {
        this.f19527k = sVar;
        if (sVar != null) {
            this.f19523g.e(sVar);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public void destroy() {
        p0.e(this.f19525i, null, 1, null);
        this.f19523g.destroy();
        this.f19528l.destroy();
    }

    public void k0() {
        if (this.f19527k == s.Expanded) {
            d0(s.Default);
        }
    }

    @NotNull
    public final h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, k0> l() {
        return this.f19520d;
    }

    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f l0() {
        return this.f19523g;
    }

    public final void m() {
        if (this.f19528l.p().getValue().booleanValue()) {
            k0();
        } else {
            this.f19523g.h(n.a.f19588c, "Can't close ad when mraid container is not visible to the user");
        }
    }

    public /* synthetic */ e(Context context, String str, q qVar, h9.a aVar, h9.l lVar, z zVar, boolean z10, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f fVar, int i10, kotlin.jvm.internal.k kVar) {
        this(context, str, qVar, (i10 & 8) != 0 ? a.f19529g : aVar, (i10 & 16) != 0 ? b.f19530g : lVar, zVar, (i10 & 64) != 0 ? false : z10, fVar);
    }

    public static final class a extends kotlin.jvm.internal.v implements h9.a<k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f19529g = new a();

        public a() {
            super(0);
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            b();
            return k0.f35197a;
        }

        public final void b() {
        }
    }

    public void t() {
    }
}

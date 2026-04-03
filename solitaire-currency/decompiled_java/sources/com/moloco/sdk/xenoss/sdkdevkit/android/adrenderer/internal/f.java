package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f19206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a f19207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.ortb.model.c f19208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final z f19209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r f19210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final String f19211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g f19212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final o0 f19213h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.q> f19214i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d> f19215j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d> f19216k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public final c0 f19217l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    public final s9.y<Boolean> f19218m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f19219n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    public final s9.y<Boolean> f19220o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f19221p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NotNull
    public final s9.y<Boolean> f19222q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f19223r;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19224a;

        static {
            int[] iArr = new int[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g.values().length];
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g.VAST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g.MRAID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g.STATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f19224a = iArr;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedFullscreenAd$load$1", f = "AggregatedFullscreenAd.kt", l = {98}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19225j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ long f19227l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ b.a f19228m;

        public static final class a implements b.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b.a f19229a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f f19230b;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.f$b$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0365a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f19231a;

                static {
                    int[] iArr = new int[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g.values().length];
                    try {
                        iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g.VAST.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g.MRAID.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g.STATIC.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f19231a = iArr;
                }
            }

            public a(b.a aVar, f fVar) {
                this.f19229a = aVar;
                this.f19230b = fVar;
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a
            public void a() {
                b.a aVar = this.f19229a;
                if (aVar != null) {
                    aVar.a();
                }
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a
            public void b(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a timeoutError) {
                b.a aVar;
                kotlin.jvm.internal.t.i(timeoutError, "timeoutError");
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g creativeType = this.f19230b.getCreativeType();
                int i10 = creativeType == null ? -1 : C0365a.f19231a[creativeType.ordinal()];
                if (i10 == -1) {
                    MolocoLogger.error$default(MolocoLogger.INSTANCE, this.f19230b.f19211f, "creativeType is null", null, false, 12, null);
                    return;
                }
                if (i10 == 1) {
                    b.a aVar2 = this.f19229a;
                    if (aVar2 != null) {
                        aVar2.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.VAST_FULLSCREEN_AD_LOAD_INTERNAL_TIMEOUT_ERROR);
                        return;
                    }
                    return;
                }
                if (i10 != 2) {
                    if (i10 == 3 && (aVar = this.f19229a) != null) {
                        aVar.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.STATIC_FULLSCREEN_AD_LOAD_INTERNAL_TIMEOUT_ERROR);
                        return;
                    }
                    return;
                }
                b.a aVar3 = this.f19229a;
                if (aVar3 != null) {
                    aVar3.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.MRAID_FULLSCREEN_AD_LOAD_INTERNAL_TIMEOUT_ERROR);
                }
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a
            public void a(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalError) {
                kotlin.jvm.internal.t.i(internalError, "internalError");
                b.a aVar = this.f19229a;
                if (aVar != null) {
                    aVar.a(internalError);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long j10, b.a aVar, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f19227l = j10;
            this.f19228m = aVar;
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
            return f.this.new b(this.f19227l, this.f19228m, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f19225j;
            if (i10 == 0) {
                v8.u.b(obj);
                f fVar = f.this;
                this.f19225j = 1;
                if (fVar.p(this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j jVarY = f.this.y();
            if (jVarY != null) {
                jVarY.g(this.f19227l, new a(this.f19228m, f.this));
            }
            return v8.k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedFullscreenAd", f = "AggregatedFullscreenAd.kt", l = {66}, m = "prepareAd")
    public static final class c extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f19232j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f19233k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f19235m;

        public c(z8.d<? super c> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f19233k = obj;
            this.f19235m |= Integer.MIN_VALUE;
            return f.this.p(this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedFullscreenAd$prepareAd$2", f = "AggregatedFullscreenAd.kt", l = {}, m = "invokeSuspend")
    public static final class d extends kotlin.coroutines.jvm.internal.l implements h9.p<Boolean, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19236j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ boolean f19237k;

        public d(z8.d<? super d> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            d dVar2 = f.this.new d(dVar);
            dVar2.f19237k = ((Boolean) obj).booleanValue();
            return dVar2;
        }

        @Nullable
        public final Object f(boolean z10, @Nullable z8.d<? super v8.k0> dVar) {
            return ((d) create(Boolean.valueOf(z10), dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Boolean bool, z8.d<? super v8.k0> dVar) {
            return f(bool.booleanValue(), dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f19236j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            f.this.f19218m.setValue(kotlin.coroutines.jvm.internal.b.a(this.f19237k));
            return v8.k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedFullscreenAd$prepareAd$3", f = "AggregatedFullscreenAd.kt", l = {}, m = "invokeSuspend")
    public static final class e extends kotlin.coroutines.jvm.internal.l implements h9.p<Boolean, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19239j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ boolean f19240k;

        public e(z8.d<? super e> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            e eVar = f.this.new e(dVar);
            eVar.f19240k = ((Boolean) obj).booleanValue();
            return eVar;
        }

        @Nullable
        public final Object f(boolean z10, @Nullable z8.d<? super v8.k0> dVar) {
            return ((e) create(Boolean.valueOf(z10), dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Boolean bool, z8.d<? super v8.k0> dVar) {
            return f(bool.booleanValue(), dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f19239j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            f.this.f19220o.setValue(kotlin.coroutines.jvm.internal.b.a(this.f19240k));
            return v8.k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.f$f, reason: collision with other inner class name */
    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedFullscreenAd$prepareAd$4", f = "AggregatedFullscreenAd.kt", l = {}, m = "invokeSuspend")
    public static final class C0366f extends kotlin.coroutines.jvm.internal.l implements h9.p<Boolean, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19242j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ boolean f19243k;

        public C0366f(z8.d<? super C0366f> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C0366f c0366f = f.this.new C0366f(dVar);
            c0366f.f19243k = ((Boolean) obj).booleanValue();
            return c0366f;
        }

        @Nullable
        public final Object f(boolean z10, @Nullable z8.d<? super v8.k0> dVar) {
            return ((C0366f) create(Boolean.valueOf(z10), dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Boolean bool, z8.d<? super v8.k0> dVar) {
            return f(bool.booleanValue(), dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f19242j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            f.this.f19222q.setValue(kotlin.coroutines.jvm.internal.b.a(this.f19243k));
            return v8.k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedFullscreenAd$prepareAd$crType$1", f = "AggregatedFullscreenAd.kt", l = {}, m = "invokeSuspend")
    public static final class g extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19245j;

        public g(z8.d<? super g> dVar) {
            super(2, dVar);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g> dVar) {
            return ((g) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return f.this.new g(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f19245j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g gVarC = q.f19696a.c(f.this.f19208c.a());
            f.this.f19212g = gVarC;
            return gVarC;
        }
    }

    public f(@NotNull Context context, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g gVar, @NotNull com.moloco.sdk.internal.ortb.model.c bid, @NotNull z externalLinkHandler, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(customUserEventBuilderService, "customUserEventBuilderService");
        kotlin.jvm.internal.t.i(bid, "bid");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        this.f19206a = context;
        this.f19207b = customUserEventBuilderService;
        this.f19208c = bid;
        this.f19209d = externalLinkHandler;
        this.f19210e = watermark;
        this.f19211f = "AggregatedFullscreenAd";
        this.f19212g = gVar;
        this.f19213h = p0.a(com.moloco.sdk.internal.scheduling.c.a().getMain());
        this.f19217l = new c0();
        Boolean bool = Boolean.FALSE;
        s9.y<Boolean> yVarA = s9.o0.a(bool);
        this.f19218m = yVarA;
        this.f19219n = yVarA;
        s9.y<Boolean> yVarA2 = s9.o0.a(bool);
        this.f19220o = yVarA2;
        this.f19221p = yVarA2;
        s9.y<Boolean> yVarA3 = s9.o0.a(bool);
        this.f19222q = yVarA3;
        this.f19223r = yVarA3;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public void destroy() {
        p0.e(this.f19213h, null, 1, null);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<?, ?> jVarY = y();
        if (jVarY != null) {
            jVarY.destroy();
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    public void g(long j10, @Nullable b.a aVar) {
        kotlinx.coroutines.k.d(this.f19213h, null, null, new b(j10, aVar, null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h
    @Nullable
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g getCreativeType() {
        return this.f19212g;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    @NotNull
    public m0<Boolean> isLoaded() {
        return this.f19219n;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a
    @NotNull
    public m0<Boolean> l() {
        return this.f19221p;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void f(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f options, @Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e eVar) {
        v8.k0 k0Var;
        kotlin.jvm.internal.t.i(options, "options");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.q> jVar = this.f19214i;
        if (jVar != null) {
            jVar.f(options.c(), eVar);
            v8.k0 k0Var2 = v8.k0.f35197a;
            return;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d> jVar2 = this.f19215j;
        if (jVar2 != null) {
            jVar2.f(options.a(), eVar);
            v8.k0 k0Var3 = v8.k0.f35197a;
            return;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d> jVar3 = this.f19216k;
        if (jVar3 != null) {
            jVar3.f(options.b(), eVar);
            k0Var = v8.k0.f35197a;
        } else {
            k0Var = null;
        }
        if (k0Var != null || eVar == null) {
            return;
        }
        eVar.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.b.FULLSCREEN_AD_SHOW_FAILED_NO_SUPPORTED_TYPE);
        v8.k0 k0Var4 = v8.k0.f35197a;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(z8.d<? super v8.k0> r13) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.f.p(z8.d):java.lang.Object");
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<?, ?> y() {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.q> jVar = this.f19214i;
        if (jVar != null) {
            return jVar;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d> jVar2 = this.f19215j;
        return jVar2 == null ? this.f19216k : jVar2;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    @NotNull
    public m0<Boolean> j() {
        return this.f19223r;
    }
}

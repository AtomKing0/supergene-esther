package com.moloco.sdk.internal.publisher;

import androidx.annotation.VisibleForTesting;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.MolocoAdErrorKt;
import com.moloco.sdk.publisher.MolocoAdKt;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b;
import java.util.List;
import java.util.Locale;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
@VisibleForTesting
public final class g implements AdLoad {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    public static final a f17979m = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final h9.l<Long, q9.b> f17980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f17981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final h9.l<com.moloco.sdk.internal.ortb.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b> f17982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.ortb.a f17983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final y f17984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final AdFormatType f17985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final o0 f17986g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f17987h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public String f17988i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.internal.ortb.model.e f17989j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.acm.f f17990k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public b2 f17991l;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.AdLoadImpl$load$1", f = "AdLoad.kt", l = {88}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f17992j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f17994l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ AdLoad.Listener f17995m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ long f17996n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, AdLoad.Listener listener, long j10, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f17994l = str;
            this.f17995m = listener;
            this.f17996n = j10;
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
            return g.this.new b(this.f17994l, this.f17995m, this.f17996n, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            com.moloco.sdk.internal.ortb.model.d dVarD;
            com.moloco.sdk.internal.ortb.model.d dVarD2;
            Object objE = a9.d.e();
            int i10 = this.f17992j;
            if (i10 == 0) {
                v8.u.b(obj);
                g gVar = g.this;
                String str = this.f17994l;
                this.f17992j = 1;
                obj = gVar.e(str, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            String str2 = (String) obj;
            if (str2 == null) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, "AdLoadImpl", "Could not pre-process the bid response. Failing the load() call.", null, false, 12, null);
                AdLoad.Listener listener = this.f17995m;
                if (listener != null) {
                    listener.onAdLoadFailed(MolocoAdErrorKt.createAdErrorInfo(g.this.f17981b, MolocoAdError.ErrorType.AD_BID_PARSE_ERROR));
                }
                com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
                com.moloco.sdk.acm.f fVarF = g.this.f17990k.f(com.moloco.sdk.internal.client_metrics_data.b.Result.c(), "failure");
                com.moloco.sdk.internal.client_metrics_data.b bVar = com.moloco.sdk.internal.client_metrics_data.b.Reason;
                String strC = bVar.c();
                MolocoAdError.ErrorType errorType = MolocoAdError.ErrorType.AD_BID_PARSE_ERROR;
                com.moloco.sdk.acm.f fVarF2 = fVarF.f(strC, String.valueOf(errorType.getErrorCode()));
                com.moloco.sdk.internal.client_metrics_data.b bVar2 = com.moloco.sdk.internal.client_metrics_data.b.AdType;
                String strC2 = bVar2.c();
                String strName = g.this.f17985f.name();
                Locale locale = Locale.ROOT;
                String lowerCase = strName.toLowerCase(locale);
                kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                aVar.u(fVarF2.f(strC2, lowerCase));
                com.moloco.sdk.acm.c cVarD = new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.LoadAdFailed.c()).d(bVar.c(), String.valueOf(errorType.getErrorCode()));
                String strC3 = bVar2.c();
                String lowerCase2 = g.this.f17985f.name().toLowerCase(locale);
                kotlin.jvm.internal.t.h(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                aVar.t(cVarD.d(strC3, lowerCase2));
                return k0.f35197a;
            }
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "AdLoadImpl", "Processed the bidResponse, proceeding with the load() call.", null, false, 12, null);
            g0 g0VarA = n.a(this.f17995m, g.this.f17990k, g.this.f17985f);
            if (kotlin.jvm.internal.t.d(g.this.f17988i, str2)) {
                if (g.this.isLoaded()) {
                    com.moloco.sdk.internal.ortb.model.q qVarE = null;
                    MolocoAd molocoAdCreateAdInfo$default = MolocoAdKt.createAdInfo$default(g.this.f17981b, null, 2, null);
                    long j10 = this.f17996n;
                    g gVar2 = g.this;
                    com.moloco.sdk.internal.ortb.model.c cVarB = gVar2.b(gVar2.f17989j);
                    g0VarA.a(molocoAdCreateAdInfo$default, j10, (cVarB == null || (dVarD2 = cVarB.d()) == null) ? null : dVarD2.e());
                    g gVar3 = g.this;
                    com.moloco.sdk.internal.ortb.model.c cVarB2 = gVar3.b(gVar3.f17989j);
                    if (cVarB2 != null && (dVarD = cVarB2.d()) != null) {
                        qVarE = dVarD.e();
                    }
                    g0VarA.b(molocoAdCreateAdInfo$default, qVarE);
                    return k0.f35197a;
                }
                b2 b2Var = g.this.f17991l;
                if (b2Var != null && b2Var.isActive()) {
                    return k0.f35197a;
                }
            }
            g.this.i(str2, this.f17996n, g0VarA);
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.AdLoadImpl", f = "AdLoad.kt", l = {149}, m = "processBidResponse")
    public static final class c extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f17997j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f17998k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f18000m;

        public c(z8.d<? super c> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f17998k = obj;
            this.f18000m |= Integer.MIN_VALUE;
            return g.this.e(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.AdLoadImpl$startLoadJob$1", f = "AdLoad.kt", l = {170}, m = "invokeSuspend")
    public static final class d extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18001j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f18002k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f18004m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ long f18005n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ g0 f18006o;

        public static final class a implements b.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f18007a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g0 f18008b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.internal.ortb.model.c f18009c;

            /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.g$d$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.AdLoadImpl$startLoadJob$1$2$onLoad$1", f = "AdLoad.kt", l = {}, m = "invokeSuspend")
            public static final class C0312a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public int f18010j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public final /* synthetic */ g f18011k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public final /* synthetic */ g0 f18012l;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                public final /* synthetic */ com.moloco.sdk.internal.ortb.model.c f18013m;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0312a(g gVar, g0 g0Var, com.moloco.sdk.internal.ortb.model.c cVar, z8.d<? super C0312a> dVar) {
                    super(2, dVar);
                    this.f18011k = gVar;
                    this.f18012l = g0Var;
                    this.f18013m = cVar;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                    return ((C0312a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    return new C0312a(this.f18011k, this.f18012l, this.f18013m, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    com.moloco.sdk.internal.ortb.model.d dVarD;
                    a9.d.e();
                    if (this.f18010j != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                    this.f18011k.f17987h = true;
                    g0 g0Var = this.f18012l;
                    MolocoAd molocoAdCreateAdInfo = MolocoAdKt.createAdInfo(this.f18011k.f17981b, kotlin.coroutines.jvm.internal.b.c(this.f18013m.e()));
                    g gVar = this.f18011k;
                    com.moloco.sdk.internal.ortb.model.c cVarB = gVar.b(gVar.f17989j);
                    g0Var.b(molocoAdCreateAdInfo, (cVarB == null || (dVarD = cVarB.d()) == null) ? null : dVarD.e());
                    return k0.f35197a;
                }
            }

            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.AdLoadImpl$startLoadJob$1$2$onLoadError$1", f = "AdLoad.kt", l = {}, m = "invokeSuspend")
            public static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public int f18014j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public final /* synthetic */ g f18015k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public final /* synthetic */ g0 f18016l;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c f18017m;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public b(g gVar, g0 g0Var, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar, z8.d<? super b> dVar) {
                    super(2, dVar);
                    this.f18015k = gVar;
                    this.f18016l = g0Var;
                    this.f18017m = cVar;
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
                    return new b(this.f18015k, this.f18016l, this.f18017m, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    com.moloco.sdk.internal.ortb.model.d dVarD;
                    a9.d.e();
                    if (this.f18014j != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                    this.f18015k.f17987h = false;
                    g0 g0Var = this.f18016l;
                    com.moloco.sdk.internal.q qVarA = com.moloco.sdk.internal.r.a(this.f18015k.f17981b, MolocoAdError.ErrorType.AD_LOAD_FAILED, this.f18017m);
                    g gVar = this.f18015k;
                    com.moloco.sdk.internal.ortb.model.c cVarB = gVar.b(gVar.f17989j);
                    g0Var.c(qVarA, (cVarB == null || (dVarD = cVarB.d()) == null) ? null : dVarD.e());
                    return k0.f35197a;
                }
            }

            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.AdLoadImpl$startLoadJob$1$2$onLoadTimeout$1", f = "AdLoad.kt", l = {}, m = "invokeSuspend")
            public static final class c extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public int f18018j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public final /* synthetic */ g f18019k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public final /* synthetic */ g0 f18020l;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a f18021m;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public c(g gVar, g0 g0Var, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a aVar, z8.d<? super c> dVar) {
                    super(2, dVar);
                    this.f18019k = gVar;
                    this.f18020l = g0Var;
                    this.f18021m = aVar;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                    return ((c) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    return new c(this.f18019k, this.f18020l, this.f18021m, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    com.moloco.sdk.internal.ortb.model.d dVarD;
                    a9.d.e();
                    if (this.f18018j != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                    this.f18019k.f17987h = false;
                    g0 g0Var = this.f18020l;
                    com.moloco.sdk.internal.q qVarA = com.moloco.sdk.internal.r.a(this.f18019k.f17981b, MolocoAdError.ErrorType.AD_LOAD_TIMEOUT_ERROR, this.f18021m);
                    g gVar = this.f18019k;
                    com.moloco.sdk.internal.ortb.model.c cVarB = gVar.b(gVar.f17989j);
                    g0Var.c(qVarA, (cVarB == null || (dVarD = cVarB.d()) == null) ? null : dVarD.e());
                    return k0.f35197a;
                }
            }

            public a(g gVar, g0 g0Var, com.moloco.sdk.internal.ortb.model.c cVar) {
                this.f18007a = gVar;
                this.f18008b = g0Var;
                this.f18009c = cVar;
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a
            public void a() {
                kotlinx.coroutines.k.d(this.f18007a.f17986g, null, null, new C0312a(this.f18007a, this.f18008b, this.f18009c, null), 3, null);
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a
            public void b(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a timeoutError) {
                kotlin.jvm.internal.t.i(timeoutError, "timeoutError");
                kotlinx.coroutines.k.d(this.f18007a.f17986g, null, null, new c(this.f18007a, this.f18008b, timeoutError, null), 3, null);
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a
            public void a(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalError) {
                kotlin.jvm.internal.t.i(internalError, "internalError");
                kotlinx.coroutines.k.d(this.f18007a.f17986g, null, null, new b(this.f18007a, this.f18008b, internalError, null), 3, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, long j10, g0 g0Var, z8.d<? super d> dVar) {
            super(2, dVar);
            this.f18004m = str;
            this.f18005n = j10;
            this.f18006o = g0Var;
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
            d dVar2 = g.this.new d(this.f18004m, this.f18005n, this.f18006o, dVar);
            dVar2.f18002k = obj;
            return dVar2;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x00c2  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00c9  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00cc  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00f6  */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 295
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.g.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull o0 scope, @NotNull h9.l<? super Long, q9.b> timeout, @NotNull String adUnitId, @NotNull h9.l<? super com.moloco.sdk.internal.ortb.model.c, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b> recreateXenossAdLoader, @NotNull com.moloco.sdk.internal.ortb.a parseBidResponse, @NotNull y adLoadPreprocessor, @NotNull AdFormatType adFormatType) {
        kotlin.jvm.internal.t.i(scope, "scope");
        kotlin.jvm.internal.t.i(timeout, "timeout");
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(recreateXenossAdLoader, "recreateXenossAdLoader");
        kotlin.jvm.internal.t.i(parseBidResponse, "parseBidResponse");
        kotlin.jvm.internal.t.i(adLoadPreprocessor, "adLoadPreprocessor");
        kotlin.jvm.internal.t.i(adFormatType, "adFormatType");
        this.f17980a = timeout;
        this.f17981b = adUnitId;
        this.f17982c = recreateXenossAdLoader;
        this.f17983d = parseBidResponse;
        this.f17984e = adLoadPreprocessor;
        this.f17985f = adFormatType;
        this.f17986g = p0.i(scope, com.moloco.sdk.internal.scheduling.c.a().getMain());
        this.f17990k = com.moloco.sdk.acm.a.f17293a.w(com.moloco.sdk.internal.client_metrics_data.c.LoadAd.c());
    }

    public final com.moloco.sdk.internal.ortb.model.c b(com.moloco.sdk.internal.ortb.model.e eVar) {
        List<com.moloco.sdk.internal.ortb.model.r> listC;
        com.moloco.sdk.internal.ortb.model.r rVar;
        List<com.moloco.sdk.internal.ortb.model.c> listC2;
        if (eVar == null || (listC = eVar.c()) == null || (rVar = listC.get(0)) == null || (listC2 = rVar.c()) == null) {
            return null;
        }
        return listC2.get(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.lang.String r5, z8.d<? super java.lang.String> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.moloco.sdk.internal.publisher.g.c
            if (r0 == 0) goto L13
            r0 = r6
            com.moloco.sdk.internal.publisher.g$c r0 = (com.moloco.sdk.internal.publisher.g.c) r0
            int r1 = r0.f18000m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f18000m = r1
            goto L18
        L13:
            com.moloco.sdk.internal.publisher.g$c r0 = new com.moloco.sdk.internal.publisher.g$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f17998k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f18000m
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f17997j
            java.lang.String r5 = (java.lang.String) r5
            v8.u.b(r6)
            goto L45
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            v8.u.b(r6)
            com.moloco.sdk.internal.publisher.y r6 = r4.f17984e
            r0.f17997j = r5
            r0.f18000m = r3
            java.lang.Object r6 = r6.b(r5, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L4a
            return r6
        L4a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.g.e(java.lang.String, z8.d):java.lang.Object");
    }

    public final void i(String str, long j10, g0 g0Var) {
        b2 b2Var = this.f17991l;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        this.f17991l = kotlinx.coroutines.k.d(this.f17986g, null, null, new d(str, j10, g0Var, null), 3, null);
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public boolean isLoaded() {
        return this.f17987h;
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public void load(@NotNull String bidResponseJson, @Nullable AdLoad.Listener listener) {
        kotlin.jvm.internal.t.i(bidResponseJson, "bidResponseJson");
        long jInvoke = a.h.f18920a.f().invoke();
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, "AdLoadImpl", "load() called with bidResponseJson: " + bidResponseJson, false, 4, null);
        this.f17990k.d();
        com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
        com.moloco.sdk.acm.c cVar = new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.LoadAdAttempt.c());
        String strC = com.moloco.sdk.internal.client_metrics_data.b.AdType.c();
        String lowerCase = this.f17985f.name().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        aVar.t(cVar.d(strC, lowerCase));
        kotlinx.coroutines.k.d(this.f17986g, null, null, new b(bidResponseJson, listener, jInvoke, null), 3, null);
    }
}

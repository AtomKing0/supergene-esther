package com.moloco.sdk.internal.publisher;

import android.content.Context;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.AdShowListener;
import com.moloco.sdk.publisher.FullscreenAd;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.MolocoAdKt;
import java.util.Locale;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class d0<T extends AdShowListener> implements FullscreenAd<T>, a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f17899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.m f17900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a f17901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final String f17902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i f17903e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z f17904f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final h9.l<com.moloco.sdk.internal.ortb.model.o, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> f17905g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final c0<T> f17906h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final AdFormatType f17907i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r f17908j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.publisher.a f17909k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public final o0 f17910l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.acm.f f17911m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.acm.f f17912n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    public final AdLoad f17913o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NotNull
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f f17914p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.internal.ortb.model.a f17915q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public h9.l<? super Boolean, k0> f17916r;

    public /* synthetic */ class a extends kotlin.jvm.internal.q implements h9.l<Long, q9.b> {
        public a(Object obj) {
            super(1, obj, com.moloco.sdk.internal.publisher.a.class, "calculateTimeout", "calculateTimeout-5sfh64U(J)J", 0);
        }

        public final long a(long j10) {
            return ((com.moloco.sdk.internal.publisher.a) this.receiver).a(j10);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ q9.b invoke(Long l10) {
            return q9.b.g(a(l10.longValue()));
        }
    }

    public /* synthetic */ class b extends kotlin.jvm.internal.q implements h9.l<com.moloco.sdk.internal.ortb.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b> {
        public b(Object obj) {
            super(1, obj, d0.class, "recreateXenossAd", "recreateXenossAd(Lcom/moloco/sdk/internal/ortb/model/Bid;)Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/AdLoad;", 0);
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b invoke(@NotNull com.moloco.sdk.internal.ortb.model.c p02) {
            kotlin.jvm.internal.t.i(p02, "p0");
            return ((d0) this.receiver).e(p02);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.FullscreenAdImpl$listenToAdDisplayState$1$1", f = "FullscreenAdImpl.kt", l = {230, 232}, m = "invokeSuspend")
    public static final class c extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f17917j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a f17918k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ h0 f17919l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ d0<T> f17920m;

        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.FullscreenAdImpl$listenToAdDisplayState$1$1$1", f = "FullscreenAdImpl.kt", l = {}, m = "invokeSuspend")
        public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<Boolean, z8.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f17921j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public /* synthetic */ boolean f17922k;

            public a(z8.d<? super a> dVar) {
                super(2, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                a aVar = new a(dVar);
                aVar.f17922k = ((Boolean) obj).booleanValue();
                return aVar;
            }

            @Nullable
            public final Object f(boolean z10, @Nullable z8.d<? super Boolean> dVar) {
                return ((a) create(Boolean.valueOf(z10), dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Boolean bool, z8.d<? super Boolean> dVar) {
                return f(bool.booleanValue(), dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f17921j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
                return kotlin.coroutines.jvm.internal.b.a(this.f17922k);
            }
        }

        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.FullscreenAdImpl$listenToAdDisplayState$1$1$2", f = "FullscreenAdImpl.kt", l = {}, m = "invokeSuspend")
        public static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<Boolean, z8.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f17923j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public /* synthetic */ boolean f17924k;

            public b(z8.d<? super b> dVar) {
                super(2, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                b bVar = new b(dVar);
                bVar.f17924k = ((Boolean) obj).booleanValue();
                return bVar;
            }

            @Nullable
            public final Object f(boolean z10, @Nullable z8.d<? super Boolean> dVar) {
                return ((b) create(Boolean.valueOf(z10), dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Boolean bool, z8.d<? super Boolean> dVar) {
                return f(bool.booleanValue(), dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f17923j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
                return kotlin.coroutines.jvm.internal.b.a(!this.f17924k);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a aVar, h0 h0Var, d0<? super T> d0Var, z8.d<? super c> dVar) {
            super(2, dVar);
            this.f17918k = aVar;
            this.f17919l = h0Var;
            this.f17920m = d0Var;
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
            return new c(this.f17918k, this.f17919l, this.f17920m, dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = a9.b.e()
                int r1 = r5.f17917j
                r2 = 1
                r3 = 2
                r4 = 0
                if (r1 == 0) goto L1f
                if (r1 == r2) goto L1b
                if (r1 != r3) goto L13
                v8.u.b(r6)
                goto L5b
            L13:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1b:
                v8.u.b(r6)
                goto L36
            L1f:
                v8.u.b(r6)
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a r6 = r5.f17918k
                s9.m0 r6 = r6.l()
                com.moloco.sdk.internal.publisher.d0$c$a r1 = new com.moloco.sdk.internal.publisher.d0$c$a
                r1.<init>(r4)
                r5.f17917j = r2
                java.lang.Object r6 = s9.j.v(r6, r1, r5)
                if (r6 != r0) goto L36
                return r0
            L36:
                com.moloco.sdk.internal.publisher.h0 r6 = r5.f17919l
                if (r6 == 0) goto L47
                com.moloco.sdk.internal.publisher.d0<T extends com.moloco.sdk.publisher.AdShowListener> r1 = r5.f17920m
                java.lang.String r1 = com.moloco.sdk.internal.publisher.d0.r(r1)
                com.moloco.sdk.publisher.MolocoAd r1 = com.moloco.sdk.publisher.MolocoAdKt.createAdInfo$default(r1, r4, r3, r4)
                r6.onAdShowSuccess(r1)
            L47:
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a r6 = r5.f17918k
                s9.m0 r6 = r6.l()
                com.moloco.sdk.internal.publisher.d0$c$b r1 = new com.moloco.sdk.internal.publisher.d0$c$b
                r1.<init>(r4)
                r5.f17917j = r3
                java.lang.Object r6 = s9.j.v(r6, r1, r5)
                if (r6 != r0) goto L5b
                return r0
            L5b:
                com.moloco.sdk.internal.publisher.h0 r6 = r5.f17919l
                if (r6 == 0) goto L6c
                com.moloco.sdk.internal.publisher.d0<T extends com.moloco.sdk.publisher.AdShowListener> r0 = r5.f17920m
                java.lang.String r0 = com.moloco.sdk.internal.publisher.d0.r(r0)
                com.moloco.sdk.publisher.MolocoAd r0 = com.moloco.sdk.publisher.MolocoAdKt.createAdInfo$default(r0, r4, r3, r4)
                r6.onAdHidden(r0)
            L6c:
                v8.k0 r6 = v8.k0.f35197a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.d0.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.FullscreenAdImpl$load$1", f = "FullscreenAdImpl.kt", l = {}, m = "invokeSuspend")
    public static final class d extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f17925j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ d0<T> f17926k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f17927l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ AdLoad.Listener f17928m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(d0<? super T> d0Var, String str, AdLoad.Listener listener, z8.d<? super d> dVar) {
            super(2, dVar);
            this.f17926k = d0Var;
            this.f17927l = str;
            this.f17928m = listener;
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
            return new d(this.f17926k, this.f17927l, this.f17928m, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f17925j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            this.f17926k.f17913o.load(this.f17927l, this.f17928m);
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.FullscreenAdImpl$show$2", f = "FullscreenAdImpl.kt", l = {}, m = "invokeSuspend")
    public static final class f extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f17931j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ T f17932k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ d0<T> f17933l;

        public static final class a extends kotlin.jvm.internal.v implements h9.a<com.moloco.sdk.internal.ortb.model.q> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ d0<T> f17934g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(d0<? super T> d0Var) {
                super(0);
                this.f17934g = d0Var;
            }

            @Override // h9.a
            @Nullable
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.ortb.model.q invoke() {
                return this.f17934g.o();
            }
        }

        public static final class b extends kotlin.jvm.internal.v implements h9.a<r> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ d0<T> f17935g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(d0<? super T> d0Var) {
                super(0);
                this.f17935g = d0Var;
            }

            @Override // h9.a
            @Nullable
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final r invoke() {
                return this.f17935g.a();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(T t10, d0<? super T> d0Var, z8.d<? super f> dVar) {
            super(2, dVar);
            this.f17932k = t10;
            this.f17933l = d0Var;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((f) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new f(this.f17932k, this.f17933l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f17931j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            if (this.f17932k != null) {
                this.f17933l.f17906h.d(new com.moloco.sdk.internal.publisher.f(this.f17932k, this.f17933l.f17900b, this.f17933l.f17901c, new a(this.f17933l), new b(this.f17933l), this.f17933l.f17907i));
            } else {
                this.f17933l.f17906h.d(null);
            }
            h0 h0VarI = this.f17933l.f17906h.i();
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> jVarA = this.f17933l.f17906h.a();
            if (jVarA == null || !this.f17933l.isLoaded()) {
                if (h0VarI != null) {
                    h0VarI.a(com.moloco.sdk.internal.r.a(this.f17933l.f17902d, MolocoAdError.ErrorType.AD_SHOW_ERROR_NOT_LOADED, com.moloco.sdk.internal.n.AD_SHOW_ERROR_NOT_LOADED));
                }
                return k0.f35197a;
            }
            if (jVarA.l().getValue().booleanValue()) {
                if (h0VarI != null) {
                    h0VarI.a(com.moloco.sdk.internal.r.a(this.f17933l.f17902d, MolocoAdError.ErrorType.AD_SHOW_ERROR_ALREADY_DISPLAYING, com.moloco.sdk.internal.n.AD_SHOW_ERROR_ALREADY_DISPLAYING));
                }
                return k0.f35197a;
            }
            this.f17933l.k(jVarA, h0VarI);
            jVarA.f(this.f17933l.f17914p, this.f17933l.d(h0VarI));
            return k0.f35197a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d0(@NotNull Context context, @NotNull com.moloco.sdk.internal.services.m appLifecycleTrackerService, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @NotNull String adUnitId, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z externalLinkHandler, @NotNull h9.l<? super com.moloco.sdk.internal.ortb.model.o, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> generateAggregatedOptions, @NotNull c0<T> adDataHolder, @NotNull AdFormatType adFormatType, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark, @NotNull com.moloco.sdk.internal.publisher.a adCreateLoadTimeoutManager) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(appLifecycleTrackerService, "appLifecycleTrackerService");
        kotlin.jvm.internal.t.i(customUserEventBuilderService, "customUserEventBuilderService");
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(persistentHttpRequest, "persistentHttpRequest");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(generateAggregatedOptions, "generateAggregatedOptions");
        kotlin.jvm.internal.t.i(adDataHolder, "adDataHolder");
        kotlin.jvm.internal.t.i(adFormatType, "adFormatType");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        kotlin.jvm.internal.t.i(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        this.f17899a = context;
        this.f17900b = appLifecycleTrackerService;
        this.f17901c = customUserEventBuilderService;
        this.f17902d = adUnitId;
        this.f17903e = persistentHttpRequest;
        this.f17904f = externalLinkHandler;
        this.f17905g = generateAggregatedOptions;
        this.f17906h = adDataHolder;
        this.f17907i = adFormatType;
        this.f17908j = watermark;
        this.f17909k = adCreateLoadTimeoutManager;
        o0 o0VarA = p0.a(com.moloco.sdk.internal.scheduling.c.a().getMain());
        this.f17910l = o0VarA;
        com.moloco.sdk.acm.f fVarW = com.moloco.sdk.acm.a.f17293a.w(com.moloco.sdk.internal.client_metrics_data.c.CreateToLoad.c());
        String strC = com.moloco.sdk.internal.client_metrics_data.b.AdType.c();
        String lowerCase = adFormatType.name().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        this.f17911m = fVarW.f(strC, lowerCase);
        this.f17913o = j.a(o0VarA, new a(adCreateLoadTimeoutManager), adUnitId, new b(this), adFormatType);
        this.f17914p = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f) generateAggregatedOptions.invoke(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b e(com.moloco.sdk.internal.ortb.model.c cVar) {
        com.moloco.sdk.internal.ortb.model.o oVarD;
        h(this, null, 1, null);
        h9.l<com.moloco.sdk.internal.ortb.model.o, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> lVar = this.f17905g;
        com.moloco.sdk.internal.ortb.model.d dVarD = cVar.d();
        this.f17914p = lVar.invoke(dVarD != null ? dVarD.d() : null);
        com.moloco.sdk.internal.ortb.model.d dVarD2 = cVar.d();
        this.f17915q = (dVarD2 == null || (oVarD = dVarD2.d()) == null) ? null : oVarD.a();
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> jVarB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l.b(this.f17899a, this.f17901c, null, cVar, this.f17904f, this.f17908j, 4, null);
        c0<T> c0Var = this.f17906h;
        c0Var.e(jVarB);
        com.moloco.sdk.internal.ortb.model.d dVarD3 = cVar.d();
        c0Var.b(dVarD3 != null ? dVarD3.e() : null);
        c0Var.c(cVar.c() != null ? new r(cVar.c(), Float.valueOf(cVar.e())) : null);
        return jVarB;
    }

    public static /* synthetic */ void h(d0 d0Var, com.moloco.sdk.internal.q qVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            qVar = null;
        }
        d0Var.j(qVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(com.moloco.sdk.internal.q qVar) {
        m0<Boolean> m0VarL;
        c0<T> c0Var = this.f17906h;
        b2 b2VarG = c0Var.g();
        if (b2VarG != null) {
            b2.a.a(b2VarG, null, 1, null);
        }
        c0Var.f(null);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> jVarA = this.f17906h.a();
        boolean z10 = (jVarA == null || (m0VarL = jVarA.l()) == null || !m0VarL.getValue().booleanValue()) ? false : true;
        c0<T> c0Var2 = this.f17906h;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> jVarA2 = c0Var2.a();
        if (jVarA2 != null) {
            jVarA2.destroy();
        }
        c0Var2.e(null);
        c0<T> c0Var3 = this.f17906h;
        h0 h0VarI = c0Var3.i();
        c0Var3.d(null);
        if (qVar != null && h0VarI != null) {
            h0VarI.a(qVar);
        }
        if (z10 && h0VarI != null) {
            h0VarI.onAdHidden(MolocoAdKt.createAdInfo$default(this.f17902d, null, 2, null));
        }
        this.f17906h.b(null);
        this.f17906h.c(null);
    }

    @Nullable
    public final r a() {
        return this.f17906h.h();
    }

    public final e d(h0 h0Var) {
        return new e(this, h0Var);
    }

    @Override // com.moloco.sdk.publisher.Destroyable
    public void destroy() {
        p0.e(this.f17910l, null, 1, null);
        h(this, null, 1, null);
        this.f17916r = null;
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public boolean isLoaded() {
        return this.f17913o.isLoaded();
    }

    public final void k(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a aVar, h0 h0Var) {
        c0<T> c0Var = this.f17906h;
        b2 b2VarG = c0Var.g();
        if (b2VarG != null) {
            b2.a.a(b2VarG, null, 1, null);
        }
        c0Var.f(kotlinx.coroutines.k.d(this.f17910l, null, null, new c(aVar, h0Var, this, null), 3, null));
    }

    public final void l(@Nullable h9.l<? super Boolean, k0> lVar) {
        this.f17916r = lVar;
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public void load(@NotNull String bidResponseJson, @Nullable AdLoad.Listener listener) {
        kotlin.jvm.internal.t.i(bidResponseJson, "bidResponseJson");
        com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
        aVar.u(this.f17911m);
        this.f17912n = aVar.w(com.moloco.sdk.internal.client_metrics_data.c.LoadToShow.c());
        kotlinx.coroutines.k.d(this.f17910l, null, null, new d(this, bidResponseJson, listener, null), 3, null);
    }

    @Nullable
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g n() {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> jVarA = this.f17906h.a();
        if (jVarA != null) {
            return jVarA.getCreativeType();
        }
        return null;
    }

    @Nullable
    public final com.moloco.sdk.internal.ortb.model.q o() {
        return this.f17906h.j();
    }

    @Nullable
    public final h9.l<Boolean, k0> q() {
        return this.f17916r;
    }

    @Override // com.moloco.sdk.internal.publisher.a0
    public void setCreateAdObjectStartTime(long j10) {
        this.f17909k.setCreateAdObjectStartTime(j10);
    }

    @Override // com.moloco.sdk.publisher.FullscreenAd
    public void show(@Nullable T t10) {
        com.moloco.sdk.acm.f fVar = this.f17912n;
        if (fVar != null) {
            com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
            String strC = com.moloco.sdk.internal.client_metrics_data.b.AdType.c();
            String lowerCase = this.f17907i.name().toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            aVar.u(fVar.f(strC, lowerCase));
        }
        com.moloco.sdk.acm.a aVar2 = com.moloco.sdk.acm.a.f17293a;
        com.moloco.sdk.acm.c cVar = new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.ShowAdAttempt.c());
        String strC2 = com.moloco.sdk.internal.client_metrics_data.b.AdType.c();
        String lowerCase2 = this.f17907i.name().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.t.h(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        aVar2.t(cVar.d(strC2, lowerCase2));
        kotlinx.coroutines.k.d(this.f17910l, null, null, new f(t10, this, null), 3, null);
    }

    @Nullable
    public final Boolean t() {
        m0<Boolean> m0VarJ;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> jVarA = this.f17906h.a();
        if (jVarA == null || (m0VarJ = jVarA.j()) == null) {
            return null;
        }
        return m0VarJ.getValue();
    }

    public static final class e implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d0<T> f17929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h0 f17930b;

        /* JADX WARN: Multi-variable type inference failed */
        public e(d0<? super T> d0Var, h0 h0Var) {
            this.f17929a = d0Var;
            this.f17930b = h0Var;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p
        public void a(boolean z10) {
            String strC;
            com.moloco.sdk.internal.ortb.model.a aVar = this.f17929a.f17915q;
            if (aVar != null) {
                d0<T> d0Var = this.f17929a;
                if (aVar.b() && ((!z10 || aVar.d()) && (strC = aVar.c()) != null)) {
                    d0Var.f17903e.a(strC);
                }
            }
            h9.l<Boolean, k0> lVarQ = this.f17929a.q();
            if (lVarQ != null) {
                lVarQ.invoke(Boolean.valueOf(z10));
            }
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c
        public void a(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalShowError) {
            kotlin.jvm.internal.t.i(internalShowError, "internalShowError");
            d0<T> d0Var = this.f17929a;
            d0Var.j(com.moloco.sdk.internal.r.a(d0Var.f17902d, MolocoAdError.ErrorType.AD_SHOW_ERROR, internalShowError));
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c
        public void a() {
            h0 h0Var = this.f17930b;
            if (h0Var != null) {
                h0Var.onAdClicked(MolocoAdKt.createAdInfo$default(this.f17929a.f17902d, null, 2, null));
            }
        }
    }
}

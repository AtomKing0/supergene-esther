package com.moloco.sdk.internal.publisher;

import androidx.annotation.VisibleForTesting;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.Initialization;
import com.moloco.sdk.publisher.MediationInfo;
import com.moloco.sdk.publisher.MolocoInitStatus;
import com.moloco.sdk.service_locator.a;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class e0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f17939f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final MolocoInitStatus f17940g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final MolocoInitStatus f17941h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.r f17942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final s9.y<Initialization> f17943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final m0<Initialization> f17944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.i f17945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final s9.y<com.moloco.sdk.internal.b> f17946e;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final MolocoInitStatus a() {
            return e0.f17940g;
        }

        @NotNull
        public final MolocoInitStatus b(@NotNull String errorMessage) {
            kotlin.jvm.internal.t.i(errorMessage, "errorMessage");
            return new MolocoInitStatus(Initialization.FAILURE, errorMessage);
        }

        @NotNull
        public final MolocoInitStatus c() {
            return e0.f17941h;
        }

        public a() {
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.InitializationHandler", f = "InitializationHandler.kt", l = {85}, m = "awaitAdFactory")
    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public /* synthetic */ Object f17947j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f17949l;

        public b(z8.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f17947j = obj;
            this.f17949l |= Integer.MIN_VALUE;
            return e0.this.e(this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.InitializationHandler$awaitAdFactory$adFactory$1", f = "InitializationHandler.kt", l = {}, m = "invokeSuspend")
    public static final class c extends kotlin.coroutines.jvm.internal.l implements h9.p<com.moloco.sdk.internal.b, z8.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f17950j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f17951k;

        public c(z8.d<? super c> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            c cVar = new c(dVar);
            cVar.f17951k = obj;
            return cVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@Nullable com.moloco.sdk.internal.b bVar, @Nullable z8.d<? super Boolean> dVar) {
            return ((c) create(bVar, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f17950j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            return kotlin.coroutines.jvm.internal.b.a(((com.moloco.sdk.internal.b) this.f17951k) != null);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.InitializationHandler", f = "InitializationHandler.kt", l = {144, 147, 173, 177, 185}, m = "handleInitializationResult")
    public static final class d extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f17952j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f17953k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f17954l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f17955m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f17956n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public /* synthetic */ Object f17957o;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f17959q;

        public d(z8.d<? super d> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f17957o = obj;
            this.f17959q |= Integer.MIN_VALUE;
            return e0.this.c(null, 0L, null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.InitializationHandler", f = "InitializationHandler.kt", l = {111, 115, 119}, m = MobileAdsBridgeBase.initializeMethodName)
    public static final class e extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f17960j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f17961k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f17962l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f17964n;

        public e(z8.d<? super e> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f17962l = obj;
            this.f17964n |= Integer.MIN_VALUE;
            return e0.this.d(null, null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.InitializationHandler$startInitialization$2", f = "InitializationHandler.kt", l = {132, 136}, m = "invokeSuspend")
    public static final class f extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.i, com.moloco.sdk.internal.services.init.h>>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f17965j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f17966k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f17967l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f17969n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ MediationInfo f17970o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.services.init.l f17971p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, MediationInfo mediationInfo, com.moloco.sdk.internal.services.init.l lVar, z8.d<? super f> dVar) {
            super(2, dVar);
            this.f17969n = str;
            this.f17970o = mediationInfo;
            this.f17971p = lVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.i, com.moloco.sdk.internal.services.init.h>> dVar) {
            return ((f) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return e0.this.new f(this.f17969n, this.f17970o, this.f17971p, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            com.moloco.sdk.acm.f fVar;
            long j10;
            Object objE = a9.d.e();
            int i10 = this.f17967l;
            if (i10 == 0) {
                v8.u.b(obj);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, "InitializationHandler", "startInitialization switch to Dispatchers.IO", null, false, 12, null);
                com.moloco.sdk.acm.f fVarW = com.moloco.sdk.acm.a.f17293a.w(com.moloco.sdk.internal.client_metrics_data.c.SDKInit.c());
                long jA = e0.this.l().a();
                com.moloco.sdk.internal.services.init.i iVarC = a.f.f18905a.c();
                String str = this.f17969n;
                MediationInfo mediationInfo = this.f17970o;
                this.f17965j = fVarW;
                this.f17966k = jA;
                this.f17967l = 1;
                obj = iVarC.b(str, mediationInfo, this);
                if (obj == objE) {
                    return objE;
                }
                fVar = fVarW;
                j10 = jA;
            } else {
                if (i10 != 1) {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    com.moloco.sdk.internal.t tVar = (com.moloco.sdk.internal.t) this.f17965j;
                    v8.u.b(obj);
                    return tVar;
                }
                j10 = this.f17966k;
                com.moloco.sdk.acm.f fVar2 = (com.moloco.sdk.acm.f) this.f17965j;
                v8.u.b(obj);
                fVar = fVar2;
            }
            com.moloco.sdk.internal.t tVar2 = (com.moloco.sdk.internal.t) obj;
            long jA2 = e0.this.l().a() - j10;
            e0 e0Var = e0.this;
            com.moloco.sdk.internal.services.init.l lVar = this.f17971p;
            this.f17965j = tVar2;
            this.f17967l = 2;
            return e0Var.c(tVar2, jA2, lVar, fVar, this) == objE ? objE : tVar2;
        }
    }

    static {
        Initialization initialization = Initialization.SUCCESS;
        f17940g = new MolocoInitStatus(initialization, "Already Initialized");
        f17941h = new MolocoInitStatus(initialization, "Initialized");
    }

    public e0(@NotNull com.moloco.sdk.internal.services.r timeProviderService) {
        kotlin.jvm.internal.t.i(timeProviderService, "timeProviderService");
        this.f17942a = timeProviderService;
        s9.y<Initialization> yVarA = s9.o0.a(null);
        this.f17943b = yVarA;
        this.f17944c = s9.j.c(yVarA);
        this.f17946e = s9.o0.a(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00e1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01c9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0223 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(com.moloco.sdk.internal.t<com.moloco.sdk.i, com.moloco.sdk.internal.services.init.h> r25, long r26, com.moloco.sdk.internal.services.init.l r28, com.moloco.sdk.acm.f r29, z8.d<? super v8.k0> r30) {
        /*
            Method dump skipped, instruction units count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.e0.c(com.moloco.sdk.internal.t, long, com.moloco.sdk.internal.services.init.l, com.moloco.sdk.acm.f, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00d3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(@org.jetbrains.annotations.NotNull java.lang.String r17, @org.jetbrains.annotations.NotNull com.moloco.sdk.publisher.MediationInfo r18, @org.jetbrains.annotations.NotNull com.moloco.sdk.internal.services.init.l r19, @org.jetbrains.annotations.NotNull z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.i, com.moloco.sdk.internal.services.init.h>> r20) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.e0.d(java.lang.String, com.moloco.sdk.publisher.MediationInfo, com.moloco.sdk.internal.services.init.l, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(@org.jetbrains.annotations.NotNull z8.d<? super com.moloco.sdk.internal.b> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.moloco.sdk.internal.publisher.e0.b
            if (r0 == 0) goto L13
            r0 = r12
            com.moloco.sdk.internal.publisher.e0$b r0 = (com.moloco.sdk.internal.publisher.e0.b) r0
            int r1 = r0.f17949l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f17949l = r1
            goto L18
        L13:
            com.moloco.sdk.internal.publisher.e0$b r0 = new com.moloco.sdk.internal.publisher.e0$b
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.f17947j
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f17949l
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            v8.u.b(r12)
            goto L53
        L29:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L31:
            v8.u.b(r12)
            com.moloco.sdk.internal.MolocoLogger r4 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            java.lang.String r5 = "InitializationHandler"
            java.lang.String r6 = "Moloco SDK awaiting init to receive AdFactory"
            r7 = 0
            r8 = 0
            r9 = 12
            r10 = 0
            com.moloco.sdk.internal.MolocoLogger.info$default(r4, r5, r6, r7, r8, r9, r10)
            s9.y<com.moloco.sdk.internal.b> r12 = r11.f17946e
            com.moloco.sdk.internal.publisher.e0$c r2 = new com.moloco.sdk.internal.publisher.e0$c
            r4 = 0
            r2.<init>(r4)
            r0.f17949l = r3
            java.lang.Object r12 = s9.j.v(r12, r2, r0)
            if (r12 != r1) goto L53
            return r1
        L53:
            java.lang.String r0 = "null cannot be cast to non-null type com.moloco.sdk.internal.AdFactory"
            kotlin.jvm.internal.t.g(r12, r0)
            com.moloco.sdk.internal.b r12 = (com.moloco.sdk.internal.b) r12
            com.moloco.sdk.internal.MolocoLogger r0 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            java.lang.String r1 = "InitializationHandler"
            java.lang.String r2 = "Moloco SDK init completed, AdFactory received"
            r3 = 0
            r4 = 0
            r5 = 12
            r6 = 0
            com.moloco.sdk.internal.MolocoLogger.info$default(r0, r1, r2, r3, r4, r5, r6)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.e0.e(z8.d):java.lang.Object");
    }

    public final Object g(String str, MediationInfo mediationInfo, com.moloco.sdk.internal.services.init.l lVar, z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.i, com.moloco.sdk.internal.services.init.h>> dVar) {
        return kotlinx.coroutines.i.g(com.moloco.sdk.internal.scheduling.c.a().getIo(), new f(str, mediationInfo, lVar, null), dVar);
    }

    @VisibleForTesting(otherwise = 5)
    @Nullable
    public final Object h(@NotNull z8.d<? super k0> dVar) {
        this.f17945d = null;
        this.f17946e.setValue(null);
        this.f17943b.setValue(null);
        Object objA = a.f.f18905a.c().a(dVar);
        return objA == a9.d.e() ? objA : k0.f35197a;
    }

    public final boolean i() {
        return m();
    }

    @NotNull
    public final m0<Initialization> j() {
        return this.f17944c;
    }

    @Nullable
    public final com.moloco.sdk.i k() {
        return this.f17945d;
    }

    @NotNull
    public final com.moloco.sdk.internal.services.r l() {
        return this.f17942a;
    }

    public final boolean m() {
        try {
            a.i.f18932a.c();
            return true;
        } catch (IllegalStateException unused) {
            return false;
        }
    }
}

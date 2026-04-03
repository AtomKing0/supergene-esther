package com.moloco.sdk.internal.services.bidtoken;

import androidx.annotation.VisibleForTesting;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.t;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
@VisibleForTesting(otherwise = 2)
public final class z implements y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.bidtoken.b f18588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final o0 f18589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final v f18590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final String f18591e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f18592f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final y9.a f18593g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public b2 f18594h;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenServiceImpl$bidToken$2", f = "ServerBidTokenService.kt", l = {190, 215}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.l<z8.d<? super l>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18595j;

        public a(z8.d<? super a> dVar) {
            super(1, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@NotNull z8.d<?> dVar) {
            return z.this.new a(dVar);
        }

        @Override // h9.l
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@Nullable z8.d<? super l> dVar) {
            return ((a) create(dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f18595j;
            if (i10 == 0) {
                v8.u.b(obj);
                z.this.h("[Thread: " + Thread.currentThread().getName() + "] Acquired lock, fetching status of current token");
                v vVar = z.this.f18590d;
                this.f18595j = 1;
                obj = vVar.a(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    if (i10 == 2) {
                        v8.u.b(obj);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            com.moloco.sdk.internal.services.bidtoken.c cVar = (com.moloco.sdk.internal.services.bidtoken.c) obj;
            z.this.f("[Thread: " + Thread.currentThread().getName() + "] bidToken status: " + cVar);
            if (!cVar.c()) {
                z.this.h("[Thread: " + Thread.currentThread().getName() + "] bidToken needs refresh, fetching new token");
                z zVar = z.this;
                l lVarC = f.c();
                this.f18595j = 2;
                obj = zVar.c(lVarC, false, false, this);
                return obj == objE ? objE : obj;
            }
            com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
            com.moloco.sdk.acm.c cVar2 = new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.ServerBidTokenCached.c());
            String strC = com.moloco.sdk.internal.client_metrics_data.b.Result.c();
            String str = com.ironsource.mediationsdk.metadata.a.f13688g;
            com.moloco.sdk.acm.c cVarD = cVar2.d(strC, com.ironsource.mediationsdk.metadata.a.f13688g).d("initial_fetch", "false");
            com.moloco.sdk.internal.services.bidtoken.c cVar3 = com.moloco.sdk.internal.services.bidtoken.c.EXPIRING;
            if (cVar != cVar3) {
                str = "false";
            }
            aVar.t(cVarD.d("expiring", str));
            l lVarA = z.this.f18590d.a();
            if (cVar == cVar3) {
                z.this.f("[Thread: " + Thread.currentThread().getName() + "] bidToken is expiring, returning cached, and refreshing async");
                z.this.d();
            } else {
                z.this.f("[Thread: " + Thread.currentThread().getName() + "] bidToken doesn't need refresh, returning cached");
            }
            return lVarA;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenServiceImpl", f = "ServerBidTokenService.kt", l = {129, 173}, m = "fetchServerBidToken$moloco_sdk_release")
    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18597j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18598k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f18599l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f18600m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f18601n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public /* synthetic */ Object f18602o;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f18604q;

        public b(z8.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18602o = obj;
            this.f18604q |= Integer.MIN_VALUE;
            return z.this.c(null, false, false, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenServiceImpl$fetchServerBidToken$bidTokenComponents$1", f = "ServerBidTokenService.kt", l = {174}, m = "invokeSuspend")
    public static final class c extends kotlin.coroutines.jvm.internal.l implements h9.l<z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18605j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.t<l, com.moloco.sdk.internal.l> f18607l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.moloco.sdk.internal.t<l, com.moloco.sdk.internal.l> tVar, z8.d<? super c> dVar) {
            super(1, dVar);
            this.f18607l = tVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@NotNull z8.d<?> dVar) {
            return z.this.new c(this.f18607l, dVar);
        }

        @Override // h9.l
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@Nullable z8.d<? super k0> dVar) {
            return ((c) create(dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f18605j;
            if (i10 == 0) {
                v8.u.b(obj);
                v vVar = z.this.f18590d;
                l lVar = (l) ((t.b) this.f18607l).a();
                this.f18605j = 1;
                if (vVar.b(lVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenServiceImpl$refreshTokenAsyncOnExpiry$1", f = "ServerBidTokenService.kt", l = {107}, m = "invokeSuspend")
    public static final class d extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18608j;

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
            return z.this.new d(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f18608j;
            if (i10 == 0) {
                v8.u.b(obj);
                z.this.h("[Thread: " + Thread.currentThread().getName() + "] Fetching token from server");
                z zVar = z.this;
                l lVarC = f.c();
                this.f18608j = 1;
                if (zVar.c(lVarC, true, true, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            z.this.h("[Thread: " + Thread.currentThread().getName() + "] Finished fetching token from server");
            return k0.f35197a;
        }
    }

    public z(@NotNull com.moloco.sdk.internal.services.bidtoken.b bidTokenApi, @NotNull o0 scope, @NotNull v tokenCache) {
        kotlin.jvm.internal.t.i(bidTokenApi, "bidTokenApi");
        kotlin.jvm.internal.t.i(scope, "scope");
        kotlin.jvm.internal.t.i(tokenCache, "tokenCache");
        this.f18588b = bidTokenApi;
        this.f18589c = scope;
        this.f18590d = tokenCache;
        this.f18591e = "ServerBidTokenServiceImpl";
        this.f18592f = true;
        this.f18593g = y9.c.b(false, 1, null);
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.y
    @Nullable
    public Object a(@NotNull z8.d<? super l> dVar) {
        h("[Thread: " + Thread.currentThread().getName() + "] Fetching bidToken(), acquiring lock");
        return com.moloco.sdk.internal.utils.a.a(this.f18593g, new a(null), dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @androidx.annotation.VisibleForTesting(otherwise = 2)
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(@org.jetbrains.annotations.NotNull com.moloco.sdk.internal.services.bidtoken.l r19, boolean r20, boolean r21, @org.jetbrains.annotations.NotNull z8.d<? super com.moloco.sdk.internal.services.bidtoken.l> r22) {
        /*
            Method dump skipped, instruction units count: 593
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.bidtoken.z.c(com.moloco.sdk.internal.services.bidtoken.l, boolean, boolean, z8.d):java.lang.Object");
    }

    @VisibleForTesting(otherwise = 2)
    public final void d() {
        h("[Thread: " + Thread.currentThread().getName() + "] Refreshing token async");
        com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
        com.moloco.sdk.acm.c cVar = new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.ServerBidTokenAsyncRefresh.c());
        b2 b2Var = this.f18594h;
        aVar.t(cVar.d("async", String.valueOf(b2Var != null ? b2Var.isActive() : false)));
        b2 b2Var2 = this.f18594h;
        if (b2Var2 != null && b2Var2.isActive()) {
            h("[Thread: " + Thread.currentThread().getName() + "] Async refresh already in progress. Returning");
            return;
        }
        h("[Thread: " + Thread.currentThread().getName() + "] Scheduling to fetch token from server");
        this.f18594h = kotlinx.coroutines.k.d(this.f18589c, null, null, new d(null), 3, null);
    }

    public final void f(String str) {
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.f18591e, "[Thread: " + Thread.currentThread().getName() + "] " + str, false, 4, null);
    }

    public final void h(String str) {
        MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f18591e, "[Thread: " + Thread.currentThread().getName() + "][sbt] " + str, null, false, 12, null);
    }
}

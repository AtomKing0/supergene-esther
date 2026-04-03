package com.moloco.sdk.internal.services.bidtoken;

import androidx.annotation.VisibleForTesting;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@VisibleForTesting(otherwise = 2)
public final class n implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final y f18469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final r f18470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final String f18471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final y9.a f18472d;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.bidtoken.BidTokenServiceImpl", f = "BidTokenService.kt", l = {118, 54, 61}, m = "bidToken")
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18473j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18474k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f18475l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f18476m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public /* synthetic */ Object f18477n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f18479p;

        public a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18477n = obj;
            this.f18479p |= Integer.MIN_VALUE;
            return n.this.a(this);
        }
    }

    public n(@NotNull y serverBidTokenService, @NotNull r clientBidTokenService) {
        kotlin.jvm.internal.t.i(serverBidTokenService, "serverBidTokenService");
        kotlin.jvm.internal.t.i(clientBidTokenService, "clientBidTokenService");
        this.f18469a = serverBidTokenService;
        this.f18470b = clientBidTokenService;
        this.f18471c = "BidTokenServiceImpl";
        this.f18472d = y9.c.b(false, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba A[Catch: all -> 0x0068, TRY_LEAVE, TryCatch #0 {all -> 0x0068, blocks: (B:21:0x0064, B:34:0x00ae, B:36:0x00ba), top: B:59:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e7 A[Catch: all -> 0x004d, TryCatch #2 {all -> 0x004d, blocks: (B:14:0x0042, B:40:0x00d8, B:43:0x00df, B:45:0x00e7, B:51:0x0114, B:46:0x00f9), top: B:63:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f9 A[Catch: all -> 0x004d, TRY_LEAVE, TryCatch #2 {all -> 0x004d, blocks: (B:14:0x0042, B:40:0x00d8, B:43:0x00df, B:45:0x00e7, B:51:0x0114, B:46:0x00f9), top: B:63:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.moloco.sdk.internal.services.bidtoken.m
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(@org.jetbrains.annotations.NotNull z8.d<? super java.lang.String> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.bidtoken.n.a(z8.d):java.lang.Object");
    }

    public final void b(com.moloco.sdk.acm.f fVar, String str) {
        if (str == null) {
            com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
            com.moloco.sdk.acm.c cVar = new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.BidTokenFetch.c());
            com.moloco.sdk.internal.client_metrics_data.b bVar = com.moloco.sdk.internal.client_metrics_data.b.Result;
            aVar.t(cVar.d(bVar.c(), "success"));
            aVar.u(fVar.f(bVar.c(), "success"));
            return;
        }
        com.moloco.sdk.acm.a aVar2 = com.moloco.sdk.acm.a.f17293a;
        com.moloco.sdk.acm.c cVar2 = new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.BidTokenFetch.c());
        com.moloco.sdk.internal.client_metrics_data.b bVar2 = com.moloco.sdk.internal.client_metrics_data.b.Result;
        com.moloco.sdk.acm.c cVarD = cVar2.d(bVar2.c(), "failure");
        com.moloco.sdk.internal.client_metrics_data.b bVar3 = com.moloco.sdk.internal.client_metrics_data.b.Reason;
        aVar2.t(cVarD.d(bVar3.c(), str));
        aVar2.u(fVar.f(bVar2.c(), "failure").f(bVar3.c(), str));
    }
}

package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.internal.publisher.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final m f18452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final e0 f18453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.r f18454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.acm.a f18455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final String f18456e;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.bidtoken.BidTokenHandlerImpl", f = "BidTokenHandler.kt", l = {59}, m = "handleBidTokenRequest")
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18457j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18458k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f18459l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f18460m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f18462o;

        public a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18460m = obj;
            this.f18462o |= Integer.MIN_VALUE;
            return j.this.a(null, this);
        }
    }

    public j(@NotNull m bidTokenService, @NotNull e0 initializationHandler, @NotNull com.moloco.sdk.internal.services.r timeProviderService, @NotNull com.moloco.sdk.acm.a acm) {
        kotlin.jvm.internal.t.i(bidTokenService, "bidTokenService");
        kotlin.jvm.internal.t.i(initializationHandler, "initializationHandler");
        kotlin.jvm.internal.t.i(timeProviderService, "timeProviderService");
        kotlin.jvm.internal.t.i(acm, "acm");
        this.f18452a = bidTokenService;
        this.f18453b = initializationHandler;
        this.f18454c = timeProviderService;
        this.f18455d = acm;
        this.f18456e = "BidTokenHandlerImpl";
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // com.moloco.sdk.internal.services.bidtoken.i
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(@org.jetbrains.annotations.NotNull com.moloco.sdk.publisher.MolocoBidTokenListener r18, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r19) {
        /*
            Method dump skipped, instruction units count: 583
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.bidtoken.j.a(com.moloco.sdk.publisher.MolocoBidTokenListener, z8.d):java.lang.Object");
    }
}

package com.moloco.sdk.internal.services.bidtoken;

import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements com.moloco.sdk.internal.services.bidtoken.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f18426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final s7.a f18427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final k f18428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final h f18429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final String f18430e;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.bidtoken.BidTokenApiImpl$fetchBidToken$2", f = "BidTokenApi.kt", l = {80, 127}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super com.moloco.sdk.internal.t<l, com.moloco.sdk.internal.l>>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18431j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18432k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f18433l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f18434m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f18435n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f18436o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f18437p;

        public a(z8.d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.internal.t<l, com.moloco.sdk.internal.l>> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return e.this.new a(dVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00f2  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x01b4  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x023f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0240  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0252  */
        /* JADX WARN: Type inference failed for: r10v1, types: [T, com.moloco.sdk.internal.t, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v0, types: [T, com.moloco.sdk.internal.t$a] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0240 -> B:35:0x0244). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r22) {
            /*
                Method dump skipped, instruction units count: 597
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.bidtoken.e.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.bidtoken.BidTokenApiImpl", f = "BidTokenApi.kt", l = {197, 198}, m = "fetchBidTokenWork")
    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18439j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f18440k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f18442m;

        public b(z8.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18440k = obj;
            this.f18442m |= Integer.MIN_VALUE;
            return e.this.d(null, this);
        }
    }

    public static final class c extends kotlin.jvm.internal.v implements h9.l<e8.l, k0> {
        public c() {
            super(1);
        }

        public final void a(@NotNull e8.l headers) {
            kotlin.jvm.internal.t.i(headers, "$this$headers");
            com.moloco.sdk.internal.m.b(headers, e.this.f18426a, e.this.f18429d.a(), null, 4, null);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(e8.l lVar) {
            a(lVar);
            return k0.f35197a;
        }
    }

    public e(@NotNull String sdkVersion, @NotNull s7.a httpClient, @NotNull k httpRequestInfo, @NotNull h deviceRequestInfo) {
        kotlin.jvm.internal.t.i(sdkVersion, "sdkVersion");
        kotlin.jvm.internal.t.i(httpClient, "httpClient");
        kotlin.jvm.internal.t.i(httpRequestInfo, "httpRequestInfo");
        kotlin.jvm.internal.t.i(deviceRequestInfo, "deviceRequestInfo");
        this.f18426a = sdkVersion;
        this.f18427b = httpClient;
        this.f18428c = httpRequestInfo;
        this.f18429d = deviceRequestInfo;
        this.f18430e = "BidTokenApi";
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.b
    @Nullable
    public Object a(@NotNull z8.d<? super com.moloco.sdk.internal.t<l, com.moloco.sdk.internal.l>> dVar) {
        return kotlinx.coroutines.i.g(com.moloco.sdk.internal.scheduling.c.a().getIo(), new a(null), dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0101 A[Catch: InvalidProtocolBufferException -> 0x0030, TryCatch #2 {InvalidProtocolBufferException -> 0x0030, blocks: (B:12:0x002b, B:46:0x0101, B:47:0x012d, B:48:0x0134, B:42:0x00e0), top: B:64:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012d A[Catch: InvalidProtocolBufferException -> 0x0030, TryCatch #2 {InvalidProtocolBufferException -> 0x0030, blocks: (B:12:0x002b, B:46:0x0101, B:47:0x012d, B:48:0x0134, B:42:0x00e0), top: B:64:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.lang.String r10, z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.internal.services.bidtoken.l, com.moloco.sdk.internal.l>> r11) {
        /*
            Method dump skipped, instruction units count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.bidtoken.e.d(java.lang.String, z8.d):java.lang.Object");
    }

    public final byte[] e() {
        byte[] byteArray = com.moloco.sdk.b.b().build().toByteArray();
        kotlin.jvm.internal.t.h(byteArray, "newBuilder().build().toByteArray()");
        return byteArray;
    }
}

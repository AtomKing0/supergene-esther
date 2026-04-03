package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.internal.MolocoLogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class w implements v {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f18572e = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.bidtoken.b f18573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.r f18574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public l f18575d;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenCacheImpl", f = "ServerBidTokenCache.kt", l = {62}, m = "tokenStatus")
    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18576j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f18577k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f18579m;

        public b(z8.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18577k = obj;
            this.f18579m |= Integer.MIN_VALUE;
            return w.this.a(this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenCacheImpl", f = "ServerBidTokenCache.kt", l = {95, 98}, m = "updateCache")
    public static final class c extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18580j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18581k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f18582l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f18583m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f18585o;

        public c(z8.d<? super c> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18583m = obj;
            this.f18585o |= Integer.MIN_VALUE;
            return w.this.b(null, this);
        }
    }

    public w(@NotNull com.moloco.sdk.internal.bidtoken.b bidTokenParser, @NotNull com.moloco.sdk.internal.services.r timeProviderService) {
        kotlin.jvm.internal.t.i(bidTokenParser, "bidTokenParser");
        kotlin.jvm.internal.t.i(timeProviderService, "timeProviderService");
        this.f18573b = bidTokenParser;
        this.f18574c = timeProviderService;
        this.f18575d = new l("", "", f.a());
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.v
    @NotNull
    public l a() {
        return this.f18575d;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.internal.services.bidtoken.v
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(@org.jetbrains.annotations.NotNull com.moloco.sdk.internal.services.bidtoken.l r8, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r9) {
        /*
            Method dump skipped, instruction units count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.bidtoken.w.b(com.moloco.sdk.internal.services.bidtoken.l, z8.d):java.lang.Object");
    }

    public final void c(String str) {
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, "ServerBidTokenCache", "[Thread: " + Thread.currentThread().getName() + "][sbt] " + str, false, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.moloco.sdk.internal.services.bidtoken.v
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(@org.jetbrains.annotations.NotNull z8.d<? super com.moloco.sdk.internal.services.bidtoken.c> r22) {
        /*
            Method dump skipped, instruction units count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.bidtoken.w.a(z8.d):java.lang.Object");
    }
}

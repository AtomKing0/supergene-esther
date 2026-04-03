package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class v implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f f20067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.error.b f20068b;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.DECLoaderImpl", f = "DECLoader.kt", l = {31}, m = "load")
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20069j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20070k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f20071l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f20072m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public /* synthetic */ Object f20073n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f20075p;

        public a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20073n = obj;
            this.f20075p |= Integer.MIN_VALUE;
            return v.this.a(null, null, this);
        }
    }

    public v(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f mediaCacheRepository, @NotNull com.moloco.sdk.internal.error.b errorReportingService) {
        kotlin.jvm.internal.t.i(mediaCacheRepository, "mediaCacheRepository");
        kotlin.jvm.internal.t.i(errorReportingService, "errorReportingService");
        this.f20067a = mediaCacheRepository;
        this.f20068b = errorReportingService;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.u
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(@org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.s r20, @org.jetbrains.annotations.Nullable java.lang.String r21, @org.jetbrains.annotations.NotNull z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.s> r22) {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.s, java.lang.String, z8.d):java.lang.Object");
    }
}

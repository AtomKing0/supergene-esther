package com.moloco.sdk.internal.services.bidtoken;

import android.util.Base64;
import androidx.media3.extractor.ts.PsExtractor;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.collections.d0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class s implements r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.r f18554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final p f18555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.encryption.a f18556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.bidtoken.providers.l f18557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final String f18558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public String f18559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public String f18560h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public g f18561i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final y9.a f18562j;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.bidtoken.ClientBidTokenServiceImpl", f = "ClientBidTokenService.kt", l = {PsExtractor.PRIVATE_STREAM_1}, m = "bidToken-0E7RQCE")
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18563j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18564k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f18565l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f18566m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public /* synthetic */ Object f18567n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f18569p;

        public a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18567n = obj;
            this.f18569p |= Integer.MIN_VALUE;
            Object objA = s.this.a(null, null, this);
            return objA == a9.d.e() ? objA : v8.t.a(objA);
        }
    }

    public s(@NotNull com.moloco.sdk.internal.services.r timeProviderService, @NotNull p clientBidTokenBuilder, @NotNull com.moloco.sdk.internal.services.encryption.a encryptionService, @NotNull com.moloco.sdk.internal.services.bidtoken.providers.l signalProvider) {
        kotlin.jvm.internal.t.i(timeProviderService, "timeProviderService");
        kotlin.jvm.internal.t.i(clientBidTokenBuilder, "clientBidTokenBuilder");
        kotlin.jvm.internal.t.i(encryptionService, "encryptionService");
        kotlin.jvm.internal.t.i(signalProvider, "signalProvider");
        this.f18554b = timeProviderService;
        this.f18555c = clientBidTokenBuilder;
        this.f18556d = encryptionService;
        this.f18557e = signalProvider;
        this.f18558f = "ClientBidTokenServiceImpl";
        this.f18559g = "";
        this.f18560h = "";
        this.f18561i = f.a();
        this.f18562j = y9.c.b(false, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.internal.services.bidtoken.r
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(@org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull com.moloco.sdk.internal.services.bidtoken.g r12, @org.jetbrains.annotations.NotNull z8.d<? super v8.t<java.lang.String>> r13) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.bidtoken.s.a(java.lang.String, com.moloco.sdk.internal.services.bidtoken.g, z8.d):java.lang.Object");
    }

    public final String b(String str) {
        Exception exc;
        String str2;
        long jA;
        byte[] bArrA;
        byte[] base64clientBidTokenComponent;
        if (str.length() == 0) {
            com.moloco.sdk.acm.a.f17293a.t(new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.ClientBidTokenBuild.c()).d(com.moloco.sdk.internal.client_metrics_data.b.Result.c(), "failure").d(com.moloco.sdk.internal.client_metrics_data.b.Reason.c(), "empty_public_key"));
            return "";
        }
        com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
        com.moloco.sdk.acm.f fVarW = aVar.w(com.moloco.sdk.internal.client_metrics_data.c.ClientBidTokenBuild.c());
        try {
            jA = this.f18554b.a();
            str2 = "rsa";
            try {
                bArrA = this.f18556d.a(str);
                String str3 = "update_signal_state";
                try {
                    this.f18557e.a();
                    str3 = "provide_signal";
                    base64clientBidTokenComponent = Base64.encode(this.f18555c.a(this.f18557e.d(), this.f18561i).toByteArray(), 0);
                } catch (Exception e10) {
                    exc = e10;
                    str2 = str3;
                }
            } catch (Exception e11) {
                exc = e11;
            }
        } catch (Exception e12) {
            exc = e12;
            str2 = "";
        }
        try {
            com.moloco.sdk.internal.services.encryption.a aVar2 = this.f18556d;
            kotlin.jvm.internal.t.h(base64clientBidTokenComponent, "base64clientBidTokenComponent");
            byte[] base64BidToken = Base64.encode(aVar2.a(base64clientBidTokenComponent), 0);
            p pVar = this.f18555c;
            kotlin.jvm.internal.t.h(base64BidToken, "base64BidToken");
            String strEncodeToString = Base64.encodeToString(pVar.b(base64BidToken, bArrA), 0);
            com.moloco.sdk.internal.client_metrics_data.b bVar = com.moloco.sdk.internal.client_metrics_data.b.Result;
            aVar.u(fVarW.f(bVar.c(), "success"));
            aVar.t(new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.ClientBidTokenBuild.c()).d(bVar.c(), "success"));
            MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f18558f, "Client bid token build time: " + (this.f18554b.a() - jA) + " ms", null, false, 12, null);
            return "v2:" + strEncodeToString;
        } catch (Exception e13) {
            exc = e13;
            str2 = "aes";
            String simpleName = exc.getClass().getSimpleName();
            kotlin.jvm.internal.t.h(simpleName, "e.javaClass.simpleName");
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            MolocoLogger.warn$default(molocoLogger, this.f18558f, "Client bid token build failed: " + simpleName, exc, false, 8, null);
            com.moloco.sdk.acm.c cVar = new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.ClientBidTokenBuild.c());
            com.moloco.sdk.internal.client_metrics_data.b bVar2 = com.moloco.sdk.internal.client_metrics_data.b.Result;
            com.moloco.sdk.acm.c cVarD = cVar.d(bVar2.c(), "failure");
            com.moloco.sdk.internal.client_metrics_data.b bVar3 = com.moloco.sdk.internal.client_metrics_data.b.Reason;
            com.moloco.sdk.acm.c cVarD2 = cVarD.d(bVar3.c(), simpleName);
            if (str2.length() > 0) {
                cVarD2.d(com.moloco.sdk.internal.client_metrics_data.b.Step.c(), str2);
            }
            MolocoLogger.debugBuildLog$default(molocoLogger, this.f18558f, "Recording metric failure: " + cVarD2.c() + ", tags: " + d0.r0(cVarD2.b(), ",", null, null, 0, null, null, 62, null), false, 4, null);
            com.moloco.sdk.acm.a aVar3 = com.moloco.sdk.acm.a.f17293a;
            aVar3.t(cVarD2);
            aVar3.u(fVarW.f(bVar2.c(), "failure").f(bVar3.c(), simpleName));
            return "";
        }
    }

    public final boolean c(g gVar) {
        g gVar2 = this.f18561i;
        this.f18561i = gVar;
        boolean z10 = !kotlin.jvm.internal.t.d(gVar2, gVar);
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.f18558f, z10 ? "config updated" : "config didn't change", false, 4, null);
        return z10;
    }

    public final boolean d(String str, g gVar) {
        if (!kotlin.jvm.internal.t.d(this.f18559g, str)) {
            MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.f18558f, "rp changed, needs refresh", false, 4, null);
            return true;
        }
        if (c(gVar)) {
            MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.f18558f, "config changed, needs refresh", false, 4, null);
            return true;
        }
        if (this.f18560h.length() == 0) {
            MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.f18558f, "cached bidToken is empty, needs refresh", false, 4, null);
            return true;
        }
        if (this.f18557e.b()) {
            MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.f18558f, "signal provider updated, needs refresh", false, 4, null);
            return true;
        }
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.f18558f, "Bid token doesn't need refresh", false, 4, null);
        return false;
    }
}

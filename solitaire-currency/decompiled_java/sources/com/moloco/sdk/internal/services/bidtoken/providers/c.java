package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.MolocoLogger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements j<com.moloco.sdk.internal.services.f> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f18491d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.i f18492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public com.moloco.sdk.internal.services.f f18493c;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public c(@NotNull com.moloco.sdk.internal.services.i advertisingService) {
        kotlin.jvm.internal.t.i(advertisingService, "advertisingService");
        this.f18492b = advertisingService;
        this.f18493c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.f18493c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        boolean z10 = !kotlin.jvm.internal.t.d(this.f18493c, e());
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, "AdvertisingSignalProvider", "[CBT][ASP]: needsRefresh: " + z10, false, 4, null);
        return z10;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    public String c() {
        return "AdvertisingSignalProvider";
    }

    public final com.moloco.sdk.internal.services.f e() {
        com.moloco.sdk.internal.services.f fVarA = this.f18492b.a();
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, "AdvertisingSignalProvider", "[CBT][ASP]: adData: " + fVarA, false, 4, null);
        return fVarA;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public com.moloco.sdk.internal.services.f d() {
        return e();
    }
}

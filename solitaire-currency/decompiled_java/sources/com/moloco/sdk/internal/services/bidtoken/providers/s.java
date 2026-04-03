package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.MolocoLogger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class s implements j<r> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f18540d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.e f18541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public r f18542c;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public s(@NotNull com.moloco.sdk.internal.services.e networkInfoService) {
        kotlin.jvm.internal.t.i(networkInfoService, "networkInfoService");
        this.f18541b = networkInfoService;
        this.f18542c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.f18542c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        r rVarE = e();
        boolean z10 = !kotlin.jvm.internal.t.d(rVarE, this.f18542c);
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, "NISignalProvider", "[CBT] NIS needsRefresh: " + z10 + ", with nis: " + rVarE + ", cached: " + this.f18542c, false, 4, null);
        return z10;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    public String c() {
        return "NISignalProvider";
    }

    public final r e() {
        try {
            r rVar = new r(this.f18541b.d(), this.f18541b.b(), Boolean.valueOf(this.f18541b.a()), this.f18541b.c());
            MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, "NISignalProvider", "[CBT] NIS providing " + rVar, false, 4, null);
            return rVar;
        } catch (Exception e10) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "NISignalProvider", "[CBT] NIS Error", e10, false, 8, null);
            return new r(null, null, null, null, 15, null);
        }
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public r d() {
        return this.f18542c;
    }
}

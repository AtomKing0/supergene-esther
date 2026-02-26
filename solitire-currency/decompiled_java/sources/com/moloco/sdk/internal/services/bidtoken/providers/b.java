package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.MolocoLogger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements j<com.moloco.sdk.internal.services.bidtoken.providers.a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f18488d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.c f18489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public com.moloco.sdk.internal.services.bidtoken.providers.a f18490c;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public b(@NotNull com.moloco.sdk.internal.services.c accessibilityInfoService) {
        kotlin.jvm.internal.t.i(accessibilityInfoService, "accessibilityInfoService");
        this.f18489b = accessibilityInfoService;
        this.f18490c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.f18490c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        com.moloco.sdk.internal.services.bidtoken.providers.a aVarE = e();
        boolean z10 = !kotlin.jvm.internal.t.d(aVarE, this.f18490c);
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, "AcSignalProvider", "[CBT] needsRefresh: " + z10 + ", with current: " + aVarE + ", cached: " + this.f18490c, false, 4, null);
        return z10;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    public String c() {
        return "AcSignalProvider";
    }

    public final com.moloco.sdk.internal.services.bidtoken.providers.a e() {
        try {
            return new com.moloco.sdk.internal.services.bidtoken.providers.a(Boolean.valueOf(this.f18489b.c()), Boolean.valueOf(this.f18489b.b()), Boolean.valueOf(this.f18489b.a()), Float.valueOf(this.f18489b.getFontScale()));
        } catch (Exception e10) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "AcSignalProvider", "[CBT] ACS Error", e10, false, 8, null);
            return new com.moloco.sdk.internal.services.bidtoken.providers.a(null, null, null, null, 15, null);
        }
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public com.moloco.sdk.internal.services.bidtoken.providers.a d() {
        return this.f18490c;
    }
}

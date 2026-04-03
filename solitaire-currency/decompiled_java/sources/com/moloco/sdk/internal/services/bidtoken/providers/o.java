package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.h0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class o implements j<n> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f18526e = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final h0 f18527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.l f18528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public n f18529d;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public o(@NotNull h0 deviceInfoService, @NotNull com.moloco.sdk.internal.services.l screenInfoService) {
        kotlin.jvm.internal.t.i(deviceInfoService, "deviceInfoService");
        kotlin.jvm.internal.t.i(screenInfoService, "screenInfoService");
        this.f18527b = deviceInfoService;
        this.f18528c = screenInfoService;
        this.f18529d = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.f18529d = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        n nVarE = e();
        boolean z10 = !kotlin.jvm.internal.t.d(nVarE, this.f18529d);
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, "DSignalProvider", "[CBT] DSP needsRefresh: " + z10 + ", with current: " + nVarE + ", cached: " + this.f18529d, false, 4, null);
        return z10;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    public String c() {
        return "DSignalProvider";
    }

    public final n e() {
        try {
            return new n(this.f18528c.b(), this.f18527b.c(), this.f18527b.d());
        } catch (Exception e10) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "DSignalProvider", "[CBT] DSP Error", e10, false, 8, null);
            return new n(null, null, null, 7, null);
        }
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public n d() {
        return this.f18529d;
    }
}

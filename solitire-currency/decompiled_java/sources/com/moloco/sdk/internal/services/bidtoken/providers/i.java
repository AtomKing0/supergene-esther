package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.z;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements j<h> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f18506d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final z f18507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public h f18508c;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public i(@NotNull z batteryInfoService) {
        kotlin.jvm.internal.t.i(batteryInfoService, "batteryInfoService");
        this.f18507b = batteryInfoService;
        this.f18508c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.f18508c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        boolean z10 = !kotlin.jvm.internal.t.d(this.f18508c, e());
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, "BInfoSignalProvider", "[CBT][BIS]: needsRefresh: " + z10, false, 4, null);
        return z10;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    public String c() {
        return "BInfoSignalProvider";
    }

    public final h e() {
        try {
            h hVar = new h(Integer.valueOf(this.f18507b.b()), Integer.valueOf(this.f18507b.a()), Boolean.valueOf(this.f18507b.c()));
            MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, "BInfoSignalProvider", "[CBT][BIS]: blev: " + hVar.b() + ", bst: " + hVar.a() + ", psm: " + hVar.c(), false, 4, null);
            return hVar;
        } catch (Exception e10) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "BInfoSignalProvider", "[CBT][BIS]: Error", e10, false, 8, null);
            return new h(null, null, null, 7, null);
        }
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public h d() {
        return this.f18508c;
    }
}

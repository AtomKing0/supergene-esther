package com.moloco.sdk.internal.services.bidtoken.providers;

import android.app.ActivityManager;
import com.moloco.sdk.internal.MolocoLogger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class q implements j<p> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f18533d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final ActivityManager f18534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public p f18535c;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public q(@NotNull ActivityManager activityManager) {
        kotlin.jvm.internal.t.i(activityManager, "activityManager");
        this.f18534b = activityManager;
        this.f18535c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, "MemorySignalProvider", "[CBT] Updating m state", false, 4, null);
        this.f18535c = e();
    }

    public final boolean b(p pVar, p pVar2) {
        return (kotlin.jvm.internal.t.d(pVar.a(), pVar2.a()) && kotlin.jvm.internal.t.d(pVar.b(), pVar2.b()) && kotlin.jvm.internal.t.d(pVar.c(), pVar2.c())) ? false : true;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    public String c() {
        return "MemorySignalProvider";
    }

    public final p e() {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            this.f18534b.getMemoryInfo(memoryInfo);
            return new p(Boolean.valueOf(memoryInfo.lowMemory), Long.valueOf(memoryInfo.threshold), Long.valueOf(memoryInfo.totalMem));
        } catch (Exception e10) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "MemorySignalProvider", "[CBT] MI Error", e10, false, 8, null);
            return new p(null, null, null, 7, null);
        }
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public p d() {
        p pVar = this.f18535c;
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, "MemorySignalProvider", "[CBT] lm: " + pVar.a() + ", t: " + pVar.b() + ", tm: " + pVar.c(), false, 4, null);
        return pVar;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        p pVarE = e();
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.debugBuildLog$default(molocoLogger, "MemorySignalProvider", "[CBT] cached lm: " + this.f18535c.a() + ", t: " + this.f18535c.b() + ", tm: " + this.f18535c.c(), false, 4, null);
        MolocoLogger.debugBuildLog$default(molocoLogger, "MemorySignalProvider", "[CBT] current lm: " + pVarE.a() + ", t: " + pVarE.b() + ", tm: " + pVarE.c(), false, 4, null);
        boolean zB = b(pVarE, this.f18535c);
        StringBuilder sb = new StringBuilder();
        sb.append("[CBT] m needsRefresh: ");
        sb.append(zB);
        MolocoLogger.debugBuildLog$default(molocoLogger, "MemorySignalProvider", sb.toString(), false, 4, null);
        return zB;
    }
}

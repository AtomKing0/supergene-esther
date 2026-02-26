package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.x;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements j<f> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f18500d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final x f18501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public f f18502c;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public g(@NotNull x audioService) {
        kotlin.jvm.internal.t.i(audioService, "audioService");
        this.f18501b = audioService;
        this.f18502c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.f18502c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        f fVarE = e();
        boolean z10 = !kotlin.jvm.internal.t.d(fVarE, this.f18502c);
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, "AudSignalProvider", "[CBT] needsRefresh: " + z10 + ", with current: " + fVarE + ", cached: " + this.f18502c, false, 4, null);
        return z10;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    public String c() {
        return "AudSignalProvider";
    }

    public final f e() {
        try {
            return new f(this.f18501b.a(), Integer.valueOf(this.f18501b.b()));
        } catch (Exception e10) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "AudSignalProvider", "[CBT] AS Error", e10, false, 8, null);
            return new f(null, null, 3, null);
        }
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public f d() {
        return this.f18502c;
    }
}

package com.moloco.sdk.internal.services.bidtoken.providers;

import android.content.Context;
import com.moloco.sdk.internal.MolocoLogger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements j<d> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f18495d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final Context f18496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public d f18497c;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public e(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        this.f18496b = context;
        this.f18497c = new d(e());
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.f18497c = new d(e());
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        d dVar = new d(e());
        boolean z10 = !kotlin.jvm.internal.t.d(dVar, this.f18497c);
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, "ADISignalProvider", "[CBT] ADI needsRefresh: " + z10 + ", with adi: " + dVar.a(), false, 4, null);
        return z10;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    public String c() {
        return "ADISignalProvider";
    }

    public final Long e() {
        try {
            return Long.valueOf(this.f18496b.getFilesDir().getTotalSpace());
        } catch (Exception e10) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "ADISignalProvider", "ADI Error", e10, false, 8, null);
            return null;
        }
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public d d() {
        d dVar = this.f18497c;
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, "ADISignalProvider", "[CBT] ADI providing " + dVar.a(), false, 4, null);
        return dVar;
    }
}

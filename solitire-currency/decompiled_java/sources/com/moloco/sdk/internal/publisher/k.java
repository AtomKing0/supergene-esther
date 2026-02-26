package com.moloco.sdk.internal.publisher;

import androidx.annotation.VisibleForTesting;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.u;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.MolocoAd;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@VisibleForTesting
public final class k implements g0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f18037e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final AdLoad.Listener f18038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.u f18039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.acm.f f18040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final AdFormatType f18041d;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public k(@Nullable AdLoad.Listener listener, @NotNull com.moloco.sdk.internal.u sdkEventUrlTracker, @NotNull com.moloco.sdk.acm.f acmLoadTimerEvent, @NotNull AdFormatType adFormatType) {
        kotlin.jvm.internal.t.i(sdkEventUrlTracker, "sdkEventUrlTracker");
        kotlin.jvm.internal.t.i(acmLoadTimerEvent, "acmLoadTimerEvent");
        kotlin.jvm.internal.t.i(adFormatType, "adFormatType");
        this.f18038a = listener;
        this.f18039b = sdkEventUrlTracker;
        this.f18040c = acmLoadTimerEvent;
        this.f18041d = adFormatType;
    }

    @Override // com.moloco.sdk.internal.publisher.g0
    public void a(@NotNull MolocoAd molocoAd, long j10, @Nullable com.moloco.sdk.internal.ortb.model.q qVar) {
        String strE;
        kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "AdLoadListenerTrackerImpl", "onAdLoadStarted: " + molocoAd + ", " + j10, null, false, 12, null);
        if (qVar == null || (strE = qVar.e()) == null) {
            return;
        }
        u.a.a(this.f18039b, strE, j10, null, 4, null);
    }

    @Override // com.moloco.sdk.internal.publisher.g0
    public void b(@NotNull MolocoAd molocoAd, @Nullable com.moloco.sdk.internal.ortb.model.q qVar) {
        String strF;
        kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "AdLoadListenerTrackerImpl", "onAdLoadSuccess: " + molocoAd, null, false, 12, null);
        if (qVar != null && (strF = qVar.f()) != null) {
            u.a.a(this.f18039b, strF, System.currentTimeMillis(), null, 4, null);
        }
        com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
        com.moloco.sdk.acm.f fVarF = this.f18040c.f(com.moloco.sdk.internal.client_metrics_data.b.Result.c(), "success");
        com.moloco.sdk.internal.client_metrics_data.b bVar = com.moloco.sdk.internal.client_metrics_data.b.AdType;
        String strC = bVar.c();
        String strName = this.f18041d.name();
        Locale locale = Locale.ROOT;
        String lowerCase = strName.toLowerCase(locale);
        kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        aVar.u(fVarF.f(strC, lowerCase));
        com.moloco.sdk.acm.c cVar = new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.LoadAdSuccess.c());
        String strC2 = bVar.c();
        String lowerCase2 = this.f18041d.name().toLowerCase(locale);
        kotlin.jvm.internal.t.h(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        aVar.t(cVar.d(strC2, lowerCase2));
        AdLoad.Listener listener = this.f18038a;
        if (listener != null) {
            listener.onAdLoadSuccess(molocoAd);
        }
    }

    @Override // com.moloco.sdk.internal.publisher.g0
    public void c(@NotNull com.moloco.sdk.internal.q internalError, @Nullable com.moloco.sdk.internal.ortb.model.q qVar) {
        String strD;
        kotlin.jvm.internal.t.i(internalError, "internalError");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "AdLoadListenerTrackerImpl", "onAdLoadFailed: " + internalError, null, false, 12, null);
        if (qVar != null && (strD = qVar.d()) != null) {
            this.f18039b.a(strD, System.currentTimeMillis(), internalError);
        }
        com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
        com.moloco.sdk.acm.f fVarF = this.f18040c.f(com.moloco.sdk.internal.client_metrics_data.b.Result.c(), "failure");
        com.moloco.sdk.internal.client_metrics_data.b bVar = com.moloco.sdk.internal.client_metrics_data.b.Reason;
        com.moloco.sdk.acm.f fVarF2 = fVarF.f(bVar.c(), internalError.b().a());
        com.moloco.sdk.internal.client_metrics_data.b bVar2 = com.moloco.sdk.internal.client_metrics_data.b.AdType;
        String strC = bVar2.c();
        String strName = this.f18041d.name();
        Locale locale = Locale.ROOT;
        String lowerCase = strName.toLowerCase(locale);
        kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        aVar.u(fVarF2.f(strC, lowerCase));
        com.moloco.sdk.acm.c cVarD = new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.LoadAdFailed.c()).d("network", internalError.a().getNetworkName()).d(bVar.c(), internalError.b().a());
        String strC2 = bVar2.c();
        String lowerCase2 = this.f18041d.name().toLowerCase(locale);
        kotlin.jvm.internal.t.h(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        aVar.t(cVarD.d(strC2, lowerCase2));
        AdLoad.Listener listener = this.f18038a;
        if (listener != null) {
            listener.onAdLoadFailed(internalError.a());
        }
    }
}

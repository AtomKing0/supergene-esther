package com.vungle.ads.internal.load;

import android.content.Context;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.util.q;
import com.vungle.ads.v1;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.p;

/* JADX INFO: compiled from: RealtimeAdLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class o extends d {

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class a extends v implements h9.a<com.vungle.ads.internal.network.i> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.network.i, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.network.i invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.network.i.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class b extends v implements h9.a<com.vungle.ads.internal.signals.b> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.signals.b, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.signals.b invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.signals.b.class);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NotNull Context context, @NotNull com.vungle.ads.internal.network.i vungleApiClient, @NotNull com.vungle.ads.internal.executor.a sdkExecutors, @NotNull com.vungle.ads.internal.omsdk.c omInjector, @NotNull com.vungle.ads.internal.downloader.e downloader, @NotNull q pathProvider, @NotNull com.vungle.ads.internal.load.b adRequest) {
        super(context, vungleApiClient, sdkExecutors, omInjector, downloader, pathProvider, adRequest);
        t.i(context, "context");
        t.i(vungleApiClient, "vungleApiClient");
        t.i(sdkExecutors, "sdkExecutors");
        t.i(omInjector, "omInjector");
        t.i(downloader, "downloader");
        t.i(pathProvider, "pathProvider");
        t.i(adRequest, "adRequest");
    }

    /* JADX INFO: renamed from: requestAd$lambda-0, reason: not valid java name */
    private static final com.vungle.ads.internal.network.i m4063requestAd$lambda0(v8.l<com.vungle.ads.internal.network.i> lVar) {
        return lVar.getValue();
    }

    private final void sendWinNotification(List<String> list) {
        boolean z10 = false;
        if (list != null && list.isEmpty()) {
            z10 = true;
        }
        if (z10) {
            return;
        }
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        v8.l lVarB = v8.n.b(p.f35201a, new b(getContext()));
        com.vungle.ads.internal.network.i vungleApiClient = getVungleApiClient();
        String referenceId = getAdRequest().getPlacement().getReferenceId();
        com.vungle.ads.internal.model.b advertisement$vungle_ads_release = getAdvertisement$vungle_ads_release();
        String creativeId = advertisement$vungle_ads_release != null ? advertisement$vungle_ads_release.getCreativeId() : null;
        com.vungle.ads.internal.model.b advertisement$vungle_ads_release2 = getAdvertisement$vungle_ads_release();
        com.vungle.ads.internal.network.g gVar = new com.vungle.ads.internal.network.g(vungleApiClient, referenceId, creativeId, advertisement$vungle_ads_release2 != null ? advertisement$vungle_ads_release2.eventId() : null, getSdkExecutors().getIoExecutor(), getPathProvider(), m4064sendWinNotification$lambda2(lVarB));
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                gVar.sendWinNotification((String) it.next(), getSdkExecutors().getJobExecutor());
            }
        }
    }

    /* JADX INFO: renamed from: sendWinNotification$lambda-2, reason: not valid java name */
    private static final com.vungle.ads.internal.signals.b m4064sendWinNotification$lambda2(v8.l<com.vungle.ads.internal.signals.b> lVar) {
        return lVar.getValue();
    }

    @Override // com.vungle.ads.internal.load.d
    public void onAdLoadReady() {
        com.vungle.ads.internal.model.b advertisement$vungle_ads_release = getAdvertisement$vungle_ads_release();
        sendWinNotification(advertisement$vungle_ads_release != null ? advertisement$vungle_ads_release.getWinNotifications() : null);
    }

    @Override // com.vungle.ads.internal.load.d
    protected void requestAd() {
        com.vungle.ads.internal.model.e adMarkup = getAdRequest().getAdMarkup();
        if (adMarkup == null) {
            com.vungle.ads.o.INSTANCE.logError$vungle_ads_release(208, "Unable to create data object from payload string.", (28 & 4) != 0 ? null : getAdRequest().getPlacement().getReferenceId(), (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null);
            onAdLoadFailed(new com.vungle.ads.g());
            return;
        }
        if (com.vungle.ads.internal.k.INSTANCE.rtaDebuggingEnabled()) {
            try {
                String decodedAdsResponse = adMarkup.getDecodedAdsResponse();
                com.vungle.ads.internal.util.p.Companion.d("RTA_DEBUGGER", String.valueOf(decodedAdsResponse));
                ServiceLocator.Companion companion = ServiceLocator.Companion;
                v8.l lVarB = v8.n.b(p.f35201a, new a(getContext()));
                if (decodedAdsResponse != null) {
                    new n(m4063requestAd$lambda0(lVarB)).reportAdMarkup(decodedAdsResponse);
                }
            } catch (Throwable unused) {
            }
        }
        com.vungle.ads.internal.model.b adPayload = adMarkup.getAdPayload();
        Integer version = adMarkup.getVersion();
        if (version != null && version.intValue() == 2 && adPayload != null) {
            handleAdMetaData$vungle_ads_release(adPayload, new v1(Sdk$SDKMetric.b.CONFIG_LOADED_FROM_ADM_LOAD));
        } else {
            com.vungle.ads.o.INSTANCE.logError$vungle_ads_release(213, "The ad response did not contain valid ad markup.", (28 & 4) != 0 ? null : getAdRequest().getPlacement().getReferenceId(), (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : adMarkup.getEventId());
            onAdLoadFailed(new com.vungle.ads.g());
        }
    }
}

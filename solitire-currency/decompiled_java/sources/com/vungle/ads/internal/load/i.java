package com.vungle.ads.internal.load;

import android.content.Context;
import com.vungle.ads.b2;
import com.vungle.ads.internal.load.i;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.util.q;
import com.vungle.ads.k1;
import com.vungle.ads.m0;
import com.vungle.ads.v1;
import com.vungle.ads.z1;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DefaultAdLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i extends d {

    /* JADX INFO: compiled from: DefaultAdLoader.kt */
    public static final class a implements com.vungle.ads.internal.network.b<com.vungle.ads.internal.model.b> {
        final /* synthetic */ com.vungle.ads.internal.model.j $placement;

        a(com.vungle.ads.internal.model.j jVar) {
            this.$placement = jVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onFailure$lambda-1, reason: not valid java name */
        public static final void m4058onFailure$lambda1(i this$0, Throwable th, com.vungle.ads.internal.model.j placement) {
            t.i(this$0, "this$0");
            t.i(placement, "$placement");
            b2 b2VarRetrofitToVungleError = this$0.retrofitToVungleError(th);
            this$0.onAdLoadFailed(b2VarRetrofitToVungleError);
            int code = b2VarRetrofitToVungleError.getCode();
            if (code == 10020) {
                com.vungle.ads.o oVar = com.vungle.ads.o.INSTANCE;
                String referenceId = placement.getReferenceId();
                com.vungle.ads.internal.model.b advertisement$vungle_ads_release = this$0.getAdvertisement$vungle_ads_release();
                String creativeId = advertisement$vungle_ads_release != null ? advertisement$vungle_ads_release.getCreativeId() : null;
                com.vungle.ads.internal.model.b advertisement$vungle_ads_release2 = this$0.getAdvertisement$vungle_ads_release();
                oVar.logError$vungle_ads_release(101, "Ads request error.", referenceId, creativeId, advertisement$vungle_ads_release2 != null ? advertisement$vungle_ads_release2.eventId() : null);
                return;
            }
            if (code != 10047) {
                com.vungle.ads.o oVar2 = com.vungle.ads.o.INSTANCE;
                String referenceId2 = placement.getReferenceId();
                com.vungle.ads.internal.model.b advertisement$vungle_ads_release3 = this$0.getAdvertisement$vungle_ads_release();
                String creativeId2 = advertisement$vungle_ads_release3 != null ? advertisement$vungle_ads_release3.getCreativeId() : null;
                com.vungle.ads.internal.model.b advertisement$vungle_ads_release4 = this$0.getAdvertisement$vungle_ads_release();
                oVar2.logError$vungle_ads_release(103, "Unable to decode ads response.", referenceId2, creativeId2, advertisement$vungle_ads_release4 != null ? advertisement$vungle_ads_release4.eventId() : null);
                return;
            }
            com.vungle.ads.o oVar3 = com.vungle.ads.o.INSTANCE;
            String referenceId3 = placement.getReferenceId();
            com.vungle.ads.internal.model.b advertisement$vungle_ads_release5 = this$0.getAdvertisement$vungle_ads_release();
            String creativeId3 = advertisement$vungle_ads_release5 != null ? advertisement$vungle_ads_release5.getCreativeId() : null;
            com.vungle.ads.internal.model.b advertisement$vungle_ads_release6 = this$0.getAdvertisement$vungle_ads_release();
            oVar3.logError$vungle_ads_release(217, "Timeout for ads call.", referenceId3, creativeId3, advertisement$vungle_ads_release6 != null ? advertisement$vungle_ads_release6.eventId() : null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onResponse$lambda-0, reason: not valid java name */
        public static final void m4059onResponse$lambda0(i this$0, com.vungle.ads.internal.model.j placement, com.vungle.ads.internal.network.d dVar) {
            t.i(this$0, "this$0");
            t.i(placement, "$placement");
            if (this$0.getVungleApiClient().getRetryAfterHeaderValue(placement.getReferenceId()) > 0) {
                this$0.onAdLoadFailed(new com.vungle.ads.j().logError$vungle_ads_release());
                return;
            }
            boolean z10 = false;
            if (dVar != null && !dVar.isSuccessful()) {
                z10 = true;
            }
            if (z10) {
                com.vungle.ads.o.INSTANCE.logError$vungle_ads_release(104, "Failed to get a successful response from the API call", (28 & 4) != 0 ? null : placement.getReferenceId(), (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null);
                this$0.onAdLoadFailed(new k1());
                return;
            }
            com.vungle.ads.internal.model.b bVar = dVar != null ? (com.vungle.ads.internal.model.b) dVar.body() : null;
            if ((bVar != null ? bVar.adUnit() : null) != null) {
                this$0.handleAdMetaData$vungle_ads_release(bVar, new v1(Sdk$SDKMetric.b.CONFIG_LOADED_FROM_AD_LOAD));
            } else {
                com.vungle.ads.o.INSTANCE.logError$vungle_ads_release(215, "Ad response is empty.", (28 & 4) != 0 ? null : placement.getReferenceId(), (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null);
                this$0.onAdLoadFailed(new k1());
            }
        }

        @Override // com.vungle.ads.internal.network.b
        public void onFailure(@Nullable com.vungle.ads.internal.network.a<com.vungle.ads.internal.model.b> aVar, @Nullable final Throwable th) {
            com.vungle.ads.internal.executor.i backgroundExecutor = i.this.getSdkExecutors().getBackgroundExecutor();
            final i iVar = i.this;
            final com.vungle.ads.internal.model.j jVar = this.$placement;
            backgroundExecutor.execute(new Runnable() { // from class: com.vungle.ads.internal.load.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.a.m4058onFailure$lambda1(iVar, th, jVar);
                }
            });
        }

        @Override // com.vungle.ads.internal.network.b
        public void onResponse(@Nullable com.vungle.ads.internal.network.a<com.vungle.ads.internal.model.b> aVar, @Nullable final com.vungle.ads.internal.network.d<com.vungle.ads.internal.model.b> dVar) {
            com.vungle.ads.internal.executor.i backgroundExecutor = i.this.getSdkExecutors().getBackgroundExecutor();
            final i iVar = i.this;
            final com.vungle.ads.internal.model.j jVar = this.$placement;
            backgroundExecutor.execute(new Runnable() { // from class: com.vungle.ads.internal.load.g
                @Override // java.lang.Runnable
                public final void run() {
                    i.a.m4059onResponse$lambda0(iVar, jVar, dVar);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull Context context, @NotNull com.vungle.ads.internal.network.i vungleApiClient, @NotNull com.vungle.ads.internal.executor.a sdkExecutors, @NotNull com.vungle.ads.internal.omsdk.c omInjector, @NotNull com.vungle.ads.internal.downloader.e downloader, @NotNull q pathProvider, @NotNull b adRequest) {
        super(context, vungleApiClient, sdkExecutors, omInjector, downloader, pathProvider, adRequest);
        t.i(context, "context");
        t.i(vungleApiClient, "vungleApiClient");
        t.i(sdkExecutors, "sdkExecutors");
        t.i(omInjector, "omInjector");
        t.i(downloader, "downloader");
        t.i(pathProvider, "pathProvider");
        t.i(adRequest, "adRequest");
    }

    private final void fetchAdMetadata(z1 z1Var, com.vungle.ads.internal.model.j jVar) {
        if (getVungleApiClient().checkIsRetryAfterActive(jVar.getReferenceId())) {
            onAdLoadFailed(new com.vungle.ads.i().logError$vungle_ads_release());
            return;
        }
        com.vungle.ads.internal.network.a<com.vungle.ads.internal.model.b> aVarRequestAd = getVungleApiClient().requestAd(jVar.getReferenceId(), z1Var);
        if (aVarRequestAd == null) {
            onAdLoadFailed(new com.vungle.ads.f());
        } else {
            aVarRequestAd.enqueue(new a(jVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b2 retrofitToVungleError(Throwable th) {
        return th instanceof UnknownHostException ? new com.vungle.ads.f() : th instanceof SocketTimeoutException ? new m0(b2.NETWORK_TIMEOUT, null, 2, null) : th instanceof IOException ? new m0(b2.NETWORK_ERROR, null, 2, null) : new com.vungle.ads.f();
    }

    @Override // com.vungle.ads.internal.load.d
    protected void requestAd() {
        fetchAdMetadata(getAdRequest().getRequestAdSize(), getAdRequest().getPlacement());
    }

    @Override // com.vungle.ads.internal.load.d
    public void onAdLoadReady() {
    }
}

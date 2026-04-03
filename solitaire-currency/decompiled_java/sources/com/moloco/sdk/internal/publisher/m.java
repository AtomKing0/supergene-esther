package com.moloco.sdk.internal.publisher;

import android.content.Context;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.RewardedInterstitialAd;
import com.moloco.sdk.publisher.RewardedInterstitialAdShowListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class m {

    public static final class a extends kotlin.jvm.internal.v implements h9.l<com.moloco.sdk.internal.ortb.model.o, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f18048g = new a();

        public a() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f invoke(@Nullable com.moloco.sdk.internal.ortb.model.o oVar) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f fVarJ;
            return (oVar == null || (fVarJ = com.moloco.sdk.internal.e.j(oVar)) == null) ? com.moloco.sdk.internal.e.i() : fVarJ;
        }
    }

    public static final class b implements RewardedInterstitialAdShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final String f18049a = "RewardedInterstitialAdShowListenerImpl";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f18050b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h9.a<Boolean> f18051c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ RewardedInterstitialAdShowListener f18052d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f18053e;

        public b(h9.a<Boolean> aVar, RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener, boolean z10) {
            this.f18051c = aVar;
            this.f18052d = rewardedInterstitialAdShowListener;
            this.f18053e = z10;
        }

        public final void a(MolocoAd molocoAd) {
            if (this.f18050b) {
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, this.f18049a, "issuing of reward is already handled", false, 4, null);
                return;
            }
            this.f18050b = true;
            if (!kotlin.jvm.internal.t.d(this.f18051c.invoke(), Boolean.FALSE)) {
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, this.f18049a, "reward can't be issued: ad was forcibly closed or ad was missing", false, 4, null);
            } else {
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, this.f18049a, "issuing of reward...", false, 4, null);
                onUserRewarded(molocoAd);
            }
        }

        @Override // com.moloco.sdk.publisher.AdShowListener
        public void onAdClicked(@NotNull MolocoAd molocoAd) {
            kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
            this.f18052d.onAdClicked(molocoAd);
        }

        @Override // com.moloco.sdk.publisher.AdShowListener
        public void onAdHidden(@NotNull MolocoAd molocoAd) {
            kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
            a(molocoAd);
            this.f18052d.onAdHidden(molocoAd);
        }

        @Override // com.moloco.sdk.publisher.AdShowListener
        public void onAdShowFailed(@NotNull MolocoAdError molocoAdError) {
            kotlin.jvm.internal.t.i(molocoAdError, "molocoAdError");
            this.f18052d.onAdShowFailed(molocoAdError);
        }

        @Override // com.moloco.sdk.publisher.AdShowListener
        public void onAdShowSuccess(@NotNull MolocoAd molocoAd) {
            kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
            this.f18052d.onAdShowSuccess(molocoAd);
            if (this.f18053e) {
                onRewardedVideoStarted(molocoAd);
            }
        }

        @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
        public void onRewardedVideoCompleted(@NotNull MolocoAd molocoAd) {
            kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
            a(molocoAd);
            this.f18052d.onRewardedVideoCompleted(molocoAd);
        }

        @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
        public void onRewardedVideoStarted(@NotNull MolocoAd molocoAd) {
            kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
            this.f18052d.onRewardedVideoStarted(molocoAd);
        }

        @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
        public void onUserRewarded(@NotNull MolocoAd molocoAd) {
            kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
            this.f18052d.onUserRewarded(molocoAd);
        }
    }

    @NotNull
    public static final RewardedInterstitialAd a(@NotNull Context context, @NotNull com.moloco.sdk.internal.services.m appLifecycleTrackerService, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @NotNull String adUnitId, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z externalLinkHandler, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest, @NotNull c0<RewardedInterstitialAdShowListener> adDataHolder, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark, @NotNull com.moloco.sdk.internal.publisher.a adCreateLoadTimeoutManager) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(appLifecycleTrackerService, "appLifecycleTrackerService");
        kotlin.jvm.internal.t.i(customUserEventBuilderService, "customUserEventBuilderService");
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(persistentHttpRequest, "persistentHttpRequest");
        kotlin.jvm.internal.t.i(adDataHolder, "adDataHolder");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        kotlin.jvm.internal.t.i(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        return new l(new d0(context, appLifecycleTrackerService, customUserEventBuilderService, adUnitId, persistentHttpRequest, externalLinkHandler, a.f18048g, adDataHolder, AdFormatType.REWARDED, watermark, adCreateLoadTimeoutManager), adUnitId);
    }

    @NotNull
    public static final RewardedInterstitialAdShowListener c(@Nullable RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener, @NotNull h9.a<com.moloco.sdk.internal.ortb.model.q> provideSdkEvents) {
        kotlin.jvm.internal.t.i(provideSdkEvents, "provideSdkEvents");
        return new p(rewardedInterstitialAdShowListener, provideSdkEvents, com.moloco.sdk.internal.w.a());
    }

    @NotNull
    public static final RewardedInterstitialAdShowListener d(@NotNull RewardedInterstitialAdShowListener listenerTracker, boolean z10, @NotNull h9.a<Boolean> isAdForciblyClosed) {
        kotlin.jvm.internal.t.i(listenerTracker, "listenerTracker");
        kotlin.jvm.internal.t.i(isAdForciblyClosed, "isAdForciblyClosed");
        return new b(isAdForciblyClosed, listenerTracker, z10);
    }
}

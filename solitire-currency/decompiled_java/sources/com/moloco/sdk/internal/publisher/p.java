package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.internal.u;
import com.moloco.sdk.publisher.AdShowListener;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.RewardedInterstitialAdShowListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class p implements RewardedInterstitialAdShowListener, AdShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final RewardedInterstitialAdShowListener f18265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final h9.a<com.moloco.sdk.internal.ortb.model.q> f18266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.u f18267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AdShowListener f18268d;

    public p(@Nullable RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener, @NotNull h9.a<com.moloco.sdk.internal.ortb.model.q> provideSdkEvents, @NotNull com.moloco.sdk.internal.u sdkEventUrlTracker) {
        kotlin.jvm.internal.t.i(provideSdkEvents, "provideSdkEvents");
        kotlin.jvm.internal.t.i(sdkEventUrlTracker, "sdkEventUrlTracker");
        this.f18265a = rewardedInterstitialAdShowListener;
        this.f18266b = provideSdkEvents;
        this.f18267c = sdkEventUrlTracker;
        this.f18268d = q.a(rewardedInterstitialAdShowListener);
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdClicked(@NotNull MolocoAd molocoAd) {
        kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
        this.f18268d.onAdClicked(molocoAd);
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdHidden(@NotNull MolocoAd molocoAd) {
        kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
        this.f18268d.onAdHidden(molocoAd);
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdShowFailed(@NotNull MolocoAdError molocoAdError) {
        kotlin.jvm.internal.t.i(molocoAdError, "molocoAdError");
        RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener = this.f18265a;
        if (rewardedInterstitialAdShowListener != null) {
            rewardedInterstitialAdShowListener.onAdShowFailed(molocoAdError);
        }
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdShowSuccess(@NotNull MolocoAd molocoAd) {
        kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
        this.f18268d.onAdShowSuccess(molocoAd);
    }

    @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
    public void onRewardedVideoCompleted(@NotNull MolocoAd molocoAd) {
        String strI;
        kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
        com.moloco.sdk.internal.ortb.model.q qVarInvoke = this.f18266b.invoke();
        if (qVarInvoke != null && (strI = qVarInvoke.i()) != null) {
            u.a.a(this.f18267c, strI, System.currentTimeMillis(), null, 4, null);
        }
        RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener = this.f18265a;
        if (rewardedInterstitialAdShowListener != null) {
            rewardedInterstitialAdShowListener.onRewardedVideoCompleted(molocoAd);
        }
    }

    @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
    public void onRewardedVideoStarted(@NotNull MolocoAd molocoAd) {
        String strJ;
        kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
        com.moloco.sdk.internal.ortb.model.q qVarInvoke = this.f18266b.invoke();
        if (qVarInvoke != null && (strJ = qVarInvoke.j()) != null) {
            u.a.a(this.f18267c, strJ, System.currentTimeMillis(), null, 4, null);
        }
        RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener = this.f18265a;
        if (rewardedInterstitialAdShowListener != null) {
            rewardedInterstitialAdShowListener.onRewardedVideoStarted(molocoAd);
        }
    }

    @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
    public void onUserRewarded(@NotNull MolocoAd molocoAd) {
        String strK;
        kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
        com.moloco.sdk.internal.ortb.model.q qVarInvoke = this.f18266b.invoke();
        if (qVarInvoke != null && (strK = qVarInvoke.k()) != null) {
            u.a.a(this.f18267c, strK, System.currentTimeMillis(), null, 4, null);
        }
        RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener = this.f18265a;
        if (rewardedInterstitialAdShowListener != null) {
            rewardedInterstitialAdShowListener.onUserRewarded(molocoAd);
        }
    }
}

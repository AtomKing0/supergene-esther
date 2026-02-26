package com.moloco.sdk.publisher;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface RewardedInterstitialAdShowListener extends InterstitialAdShowListener {
    void onRewardedVideoCompleted(@NotNull MolocoAd molocoAd);

    void onRewardedVideoStarted(@NotNull MolocoAd molocoAd);

    void onUserRewarded(@NotNull MolocoAd molocoAd);
}

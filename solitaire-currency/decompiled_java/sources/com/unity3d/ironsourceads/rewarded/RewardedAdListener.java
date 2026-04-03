package com.unity3d.ironsourceads.rewarded;

import com.ironsource.mediationsdk.logger.IronSourceError;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface RewardedAdListener {
    void onRewardedAdClicked(@NotNull RewardedAd rewardedAd);

    void onRewardedAdDismissed(@NotNull RewardedAd rewardedAd);

    void onRewardedAdFailedToShow(@NotNull RewardedAd rewardedAd, @NotNull IronSourceError ironSourceError);

    void onRewardedAdShown(@NotNull RewardedAd rewardedAd);

    void onUserEarnedReward(@NotNull RewardedAd rewardedAd);
}

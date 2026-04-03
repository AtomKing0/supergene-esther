package com.unity3d.ironsourceads.rewarded;

import com.ironsource.mediationsdk.logger.IronSourceError;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface RewardedAdLoaderListener {
    void onRewardedAdLoadFailed(@NotNull IronSourceError ironSourceError);

    void onRewardedAdLoaded(@NotNull RewardedAd rewardedAd);
}

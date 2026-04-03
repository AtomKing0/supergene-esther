package com.unity3d.ironsourceads.interstitial;

import com.ironsource.mediationsdk.logger.IronSourceError;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface InterstitialAdListener {
    void onInterstitialAdClicked(@NotNull InterstitialAd interstitialAd);

    void onInterstitialAdDismissed(@NotNull InterstitialAd interstitialAd);

    void onInterstitialAdFailedToShow(@NotNull InterstitialAd interstitialAd, @NotNull IronSourceError ironSourceError);

    void onInterstitialAdShown(@NotNull InterstitialAd interstitialAd);
}

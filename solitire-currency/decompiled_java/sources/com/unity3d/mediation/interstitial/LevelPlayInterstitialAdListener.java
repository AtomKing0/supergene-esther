package com.unity3d.mediation.interstitial;

import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface LevelPlayInterstitialAdListener {
    void onAdClicked(@NotNull LevelPlayAdInfo levelPlayAdInfo);

    void onAdClosed(@NotNull LevelPlayAdInfo levelPlayAdInfo);

    void onAdDisplayFailed(@NotNull LevelPlayAdError levelPlayAdError, @NotNull LevelPlayAdInfo levelPlayAdInfo);

    void onAdDisplayed(@NotNull LevelPlayAdInfo levelPlayAdInfo);

    void onAdInfoChanged(@NotNull LevelPlayAdInfo levelPlayAdInfo);

    void onAdLoadFailed(@NotNull LevelPlayAdError levelPlayAdError);

    void onAdLoaded(@NotNull LevelPlayAdInfo levelPlayAdInfo);
}

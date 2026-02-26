package com.unity3d.mediation.banner;

import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface LevelPlayBannerAdViewListener {
    void onAdClicked(@NotNull LevelPlayAdInfo levelPlayAdInfo);

    void onAdCollapsed(@NotNull LevelPlayAdInfo levelPlayAdInfo);

    void onAdDisplayFailed(@NotNull LevelPlayAdInfo levelPlayAdInfo, @NotNull LevelPlayAdError levelPlayAdError);

    void onAdDisplayed(@NotNull LevelPlayAdInfo levelPlayAdInfo);

    void onAdExpanded(@NotNull LevelPlayAdInfo levelPlayAdInfo);

    void onAdLeftApplication(@NotNull LevelPlayAdInfo levelPlayAdInfo);

    void onAdLoadFailed(@NotNull LevelPlayAdError levelPlayAdError);

    void onAdLoaded(@NotNull LevelPlayAdInfo levelPlayAdInfo);
}

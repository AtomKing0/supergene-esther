package com.unity3d.ironsourceads.banner;

import com.ironsource.mediationsdk.logger.IronSourceError;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface BannerAdLoaderListener {
    void onBannerAdLoadFailed(@NotNull IronSourceError ironSourceError);

    void onBannerAdLoaded(@NotNull BannerAdView bannerAdView);
}

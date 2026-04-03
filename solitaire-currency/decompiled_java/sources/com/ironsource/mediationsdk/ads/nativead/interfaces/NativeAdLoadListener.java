package com.ironsource.mediationsdk.ads.nativead.interfaces;

import com.ironsource.mediationsdk.ads.nativead.LevelPlayNativeAd;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface NativeAdLoadListener {
    void onAdLoadFailed(@Nullable LevelPlayNativeAd levelPlayNativeAd, @Nullable IronSourceError ironSourceError);

    void onAdLoaded(@Nullable LevelPlayNativeAd levelPlayNativeAd, @Nullable AdInfo adInfo);
}

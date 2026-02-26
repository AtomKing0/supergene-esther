package com.applovin.impl.sdk.nativeAd;

import com.applovin.impl.sdk.AppLovinError;

/* JADX INFO: loaded from: classes2.dex */
public interface AppLovinNativeAdLoadListener {
    void onNativeAdLoadFailed(AppLovinError appLovinError);

    void onNativeAdLoaded(AppLovinNativeAd appLovinNativeAd);
}

package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: loaded from: classes4.dex */
public interface ISDemandOnlyBannerListener {
    void onBannerAdClicked(String str);

    void onBannerAdLeftApplication(String str);

    void onBannerAdLoadFailed(String str, IronSourceError ironSourceError);

    void onBannerAdLoaded(String str);

    void onBannerAdShown(String str);
}

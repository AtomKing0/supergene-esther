package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: loaded from: classes4.dex */
public interface LevelPlayBannerListener {
    @Deprecated
    void onAdClicked(AdInfo adInfo);

    @Deprecated
    void onAdLeftApplication(AdInfo adInfo);

    @Deprecated
    void onAdLoadFailed(IronSourceError ironSourceError);

    @Deprecated
    void onAdLoaded(AdInfo adInfo);

    @Deprecated
    void onAdScreenDismissed(AdInfo adInfo);

    @Deprecated
    void onAdScreenPresented(AdInfo adInfo);
}

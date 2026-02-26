package com.ironsource.mediationsdk.ads.nativead.interfaces;

import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.logger.IronSourceError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface NativeAdSmashListener {
    void onNativeAdClicked();

    void onNativeAdInitFailed(@Nullable IronSourceError ironSourceError);

    void onNativeAdInitSuccess();

    void onNativeAdLoadFailed(@Nullable IronSourceError ironSourceError);

    void onNativeAdLoaded(@NotNull AdapterNativeAdData adapterNativeAdData, @NotNull AdapterNativeAdViewBinder adapterNativeAdViewBinder);

    void onNativeAdShown();
}

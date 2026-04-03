package com.ironsource.adapters.ironsource.nativeAd;

import com.ironsource.dg;
import com.ironsource.fg;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class IronSourceNativeAdListener implements fg.a {

    @NotNull
    private final IronSourceNativeAdViewBinder binder;

    @NotNull
    private final NativeAdSmashListener smashListener;

    public IronSourceNativeAdListener(@NotNull IronSourceNativeAdViewBinder binder, @NotNull NativeAdSmashListener smashListener) {
        t.i(binder, "binder");
        t.i(smashListener, "smashListener");
        this.binder = binder;
        this.smashListener = smashListener;
    }

    @Override // com.ironsource.fg.a
    public void onNativeAdClicked() {
        this.smashListener.onNativeAdClicked();
    }

    @Override // com.ironsource.fg.a
    public void onNativeAdLoadFailed(@NotNull String reason) {
        t.i(reason, "reason");
        this.smashListener.onNativeAdLoadFailed(new IronSourceError(510, "Load failed - " + reason));
    }

    @Override // com.ironsource.fg.a
    public void onNativeAdLoadSuccess(@NotNull dg adData) {
        t.i(adData, "adData");
        this.smashListener.onNativeAdLoaded(new IronSourceNativeAdData(adData), this.binder);
    }

    @Override // com.ironsource.fg.a
    public void onNativeAdShown() {
        this.smashListener.onNativeAdShown();
    }
}

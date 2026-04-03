package com.facebook.ads.redexgen.core;

import com.facebook.ads.RewardedInterstitialAd;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RY implements RewardedInterstitialAd.RewardedInterstitialAdShowConfigBuilder, RewardedInterstitialAd.RewardedInterstitialShowAdConfig {
    public final C1955Rb A00;

    public RY(C1955Rb c1955Rb) {
        this.A00 = c1955Rb;
    }

    public final C1955Rb A00() {
        return this.A00;
    }

    @Override // com.facebook.ads.RewardedInterstitialAd.RewardedInterstitialAdShowConfigBuilder, com.facebook.ads.FullScreenAd.ShowConfigBuilder
    public final RewardedInterstitialAd.RewardedInterstitialShowAdConfig build() {
        return this;
    }

    @Override // com.facebook.ads.RewardedInterstitialAd.RewardedInterstitialAdShowConfigBuilder
    public final RewardedInterstitialAd.RewardedInterstitialAdShowConfigBuilder withAppOrientation(int i10) {
        this.A00.withAppOrientation(i10);
        return this;
    }
}

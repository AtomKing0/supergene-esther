package com.applovin.mediation.rtb;

import android.content.Context;
import androidx.annotation.NonNull;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.mediation.AppLovinExtras;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinSdk;
import com.google.ads.mediation.applovin.a;
import com.google.ads.mediation.applovin.d;
import com.google.ads.mediation.applovin.g;
import com.google.ads.mediation.applovin.h;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public final class AppLovinRtbRewardedRenderer extends g {
    private AppLovinAd appLovinAd;

    public AppLovinRtbRewardedRenderer(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback, @NonNull d dVar, @NonNull a aVar, @NonNull h hVar) {
        super(mediationRewardedAdConfiguration, mediationAdLoadCallback, dVar, aVar, hVar);
    }

    @Override // com.google.ads.mediation.applovin.g, com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(@NonNull AppLovinAd appLovinAd) {
        this.appLovinAd = appLovinAd;
        super.adReceived(appLovinAd);
    }

    @Override // com.google.ads.mediation.applovin.g
    public void loadAd() {
        AppLovinSdk appLovinSdkC = this.appLovinInitializer.c(this.adConfiguration.getContext());
        this.appLovinSdk = appLovinSdkC;
        AppLovinIncentivizedInterstitial appLovinIncentivizedInterstitialB = this.appLovinAdFactory.b(appLovinSdkC);
        this.incentivizedInterstitial = appLovinIncentivizedInterstitialB;
        appLovinIncentivizedInterstitialB.setExtraInfo(AppLovinExtras.Keys.KEY_WATERMARK, this.adConfiguration.getWatermark());
        this.appLovinSdk.getAdService().loadNextAdForAdToken(this.adConfiguration.getBidResponse(), this);
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(@NonNull Context context) {
        this.appLovinSdk.getSettings().setMuted(AppLovinUtils.shouldMuteAudio(this.adConfiguration.getMediationExtras()));
        this.incentivizedInterstitial.show(this.appLovinAd, context, this, this, this, this);
    }
}

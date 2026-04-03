package com.applovin.mediation.rtb;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.mediation.AppLovinExtras;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinSdk;
import com.google.ads.mediation.applovin.a;
import com.google.ads.mediation.applovin.d;
import com.google.ads.mediation.applovin.e;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public final class AppLovinRtbInterstitialRenderer extends e {

    @Nullable
    private AppLovinInterstitialAdDialog interstitialAd;
    private final AppLovinSdk sdk;

    public AppLovinRtbInterstitialRenderer(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, @NonNull MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback, @NonNull d dVar, @NonNull a aVar) {
        super(mediationInterstitialAdConfiguration, mediationAdLoadCallback, dVar, aVar);
        this.sdk = dVar.c(mediationInterstitialAdConfiguration.getContext());
    }

    @Override // com.google.ads.mediation.applovin.e
    public void loadAd() {
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialogD = this.appLovinAdFactory.d(this.sdk, this.interstitialAdConfiguration.getContext());
        this.interstitialAd = appLovinInterstitialAdDialogD;
        appLovinInterstitialAdDialogD.setAdDisplayListener(this);
        this.interstitialAd.setAdClickListener(this);
        this.interstitialAd.setAdVideoPlaybackListener(this);
        this.interstitialAd.setExtraInfo(AppLovinExtras.Keys.KEY_WATERMARK, this.interstitialAdConfiguration.getWatermark());
        this.sdk.getAdService().loadNextAdForAdToken(this.interstitialAdConfiguration.getBidResponse(), this);
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAd
    public void showAd(@NonNull Context context) {
        this.sdk.getSettings().setMuted(AppLovinUtils.shouldMuteAudio(this.interstitialAdConfiguration.getMediationExtras()));
        this.interstitialAd.showAndRender(this.appLovinInterstitialAd);
    }
}

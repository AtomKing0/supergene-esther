package com.google.ads.mediation.applovin;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;

/* JADX INFO: compiled from: AppLovinInterstitialRenderer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e implements MediationInterstitialAd, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener, AppLovinAdLoadListener {

    @VisibleForTesting
    public static final String ERROR_MSG_MULTIPLE_INTERSTITIAL_AD = " Cannot load multiple interstitial ads with the same Zone ID. Display one ad before attempting to load another. ";
    protected static final String TAG = "e";
    protected final a appLovinAdFactory;
    protected final d appLovinInitializer;

    @Nullable
    protected AppLovinAd appLovinInterstitialAd;

    @Nullable
    private MediationInterstitialAdCallback interstitialAdCallback;
    protected final MediationInterstitialAdConfiguration interstitialAdConfiguration;
    protected final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> interstitialAdLoadCallback;

    @Nullable
    protected String zoneId;

    public e(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, @NonNull MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback, @NonNull d dVar, @NonNull a aVar) {
        this.interstitialAdConfiguration = mediationInterstitialAdConfiguration;
        this.interstitialAdLoadCallback = mediationAdLoadCallback;
        this.appLovinInitializer = dVar;
        this.appLovinAdFactory = aVar;
    }

    @Override // com.applovin.sdk.AppLovinAdClickListener
    public void adClicked(AppLovinAd appLovinAd) {
        Log.d(TAG, "Interstitial clicked.");
        this.interstitialAdCallback.reportAdClicked();
        this.interstitialAdCallback.onAdLeftApplication();
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adDisplayed(AppLovinAd appLovinAd) {
        Log.d(TAG, "Interstitial displayed.");
        this.interstitialAdCallback.onAdOpened();
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adHidden(AppLovinAd appLovinAd) {
        Log.d(TAG, "Interstitial dismissed.");
        this.interstitialAdCallback.onAdClosed();
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        Log.d(TAG, "Interstitial did load ad for zone: " + this.zoneId);
        this.appLovinInterstitialAd = appLovinAd;
        this.interstitialAdCallback = this.interstitialAdLoadCallback.onSuccess(this);
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i10) {
        AdError adError = AppLovinUtils.getAdError(i10);
        Log.w(TAG, adError.getMessage());
        this.interstitialAdLoadCallback.onFailure(adError);
    }

    public abstract void loadAd();

    @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        Log.d(TAG, "Interstitial video playback began.");
    }

    @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d10, boolean z10) {
        Log.d(TAG, "Interstitial video playback ended at playback percent: " + d10 + "%.");
    }
}

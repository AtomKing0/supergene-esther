package com.google.ads.mediation.applovin;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinSdk;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import java.util.Map;

/* JADX INFO: compiled from: AppLovinRewardedRenderer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class g implements MediationRewardedAd, AppLovinAdLoadListener, AppLovinAdRewardListener, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener {

    @VisibleForTesting
    protected static final String ERROR_MSG_AD_NOT_READY = "Ad not ready to show.";

    @VisibleForTesting
    protected static final String ERROR_MSG_MULTIPLE_REWARDED_AD = "Cannot load multiple rewarded ads with the same Zone ID. Display one ad before attempting to load another.";
    protected static final String TAG = "g";
    protected final MediationRewardedAdConfiguration adConfiguration;
    protected final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> adLoadCallback;
    protected final com.google.ads.mediation.applovin.a appLovinAdFactory;
    protected final d appLovinInitializer;

    @Nullable
    protected AppLovinSdk appLovinSdk;
    protected final h appLovinSdkUtilsWrapper;
    private boolean fullyWatched;

    @Nullable
    protected AppLovinIncentivizedInterstitial incentivizedInterstitial;
    private f rewardItem;

    @Nullable
    protected MediationRewardedAdCallback rewardedAdCallback;

    /* JADX INFO: compiled from: AppLovinRewardedRenderer.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.rewardedAdCallback = gVar.adLoadCallback.onSuccess(gVar);
        }
    }

    /* JADX INFO: compiled from: AppLovinRewardedRenderer.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdError f8271a;

        b(AdError adError) {
            this.f8271a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.adLoadCallback.onFailure(this.f8271a);
        }
    }

    protected g(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback, @NonNull d dVar, @NonNull com.google.ads.mediation.applovin.a aVar, @NonNull h hVar) {
        this.adConfiguration = mediationRewardedAdConfiguration;
        this.adLoadCallback = mediationAdLoadCallback;
        this.appLovinInitializer = dVar;
        this.appLovinAdFactory = aVar;
        this.appLovinSdkUtilsWrapper = hVar;
    }

    @Override // com.applovin.sdk.AppLovinAdClickListener
    public void adClicked(@NonNull AppLovinAd appLovinAd) {
        Log.d(TAG, "Rewarded video clicked.");
        MediationRewardedAdCallback mediationRewardedAdCallback = this.rewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.reportAdClicked();
        }
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adDisplayed(@NonNull AppLovinAd appLovinAd) {
        Log.d(TAG, "Rewarded video displayed.");
        MediationRewardedAdCallback mediationRewardedAdCallback = this.rewardedAdCallback;
        if (mediationRewardedAdCallback == null) {
            return;
        }
        mediationRewardedAdCallback.onAdOpened();
        this.rewardedAdCallback.reportAdImpression();
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adHidden(@NonNull AppLovinAd appLovinAd) {
        Log.d(TAG, "Rewarded video dismissed.");
        MediationRewardedAdCallback mediationRewardedAdCallback = this.rewardedAdCallback;
        if (mediationRewardedAdCallback == null) {
            return;
        }
        if (this.fullyWatched) {
            mediationRewardedAdCallback.onUserEarnedReward(this.rewardItem);
        }
        this.rewardedAdCallback.onAdClosed();
    }

    public void adReceived(@NonNull AppLovinAd appLovinAd) {
        Log.i(TAG, "Rewarded video did load ad.");
        this.appLovinSdkUtilsWrapper.a(new a());
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i10) {
        AdError adError = AppLovinUtils.getAdError(i10);
        Log.w(TAG, adError.toString());
        this.appLovinSdkUtilsWrapper.a(new b(adError));
    }

    public abstract void loadAd();

    @Override // com.applovin.sdk.AppLovinAdRewardListener
    public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
        Log.e(TAG, "Rewarded video validation request for ad did exceed quota with response: " + map);
    }

    @Override // com.applovin.sdk.AppLovinAdRewardListener
    public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
        Log.e(TAG, "Rewarded video validation request was rejected with response: " + map);
    }

    @Override // com.applovin.sdk.AppLovinAdRewardListener
    public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
        String str = map.get("currency");
        int i10 = (int) Double.parseDouble(map.get(AppLovinEventParameters.REVENUE_AMOUNT));
        Log.d(TAG, "Rewarded " + i10 + " " + str);
        this.rewardItem = new f(i10, str);
    }

    @Override // com.applovin.sdk.AppLovinAdRewardListener
    public void validationRequestFailed(AppLovinAd appLovinAd, int i10) {
        Log.e(TAG, "Rewarded video validation request for ad failed with error code: " + i10);
    }

    @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        Log.d(TAG, "Rewarded video playback began.");
        MediationRewardedAdCallback mediationRewardedAdCallback = this.rewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onVideoStart();
        }
    }

    @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d10, boolean z10) {
        Log.d(TAG, "Rewarded video playback ended at playback percent: " + d10 + "%.");
        this.fullyWatched = z10;
        MediationRewardedAdCallback mediationRewardedAdCallback = this.rewardedAdCallback;
        if (mediationRewardedAdCallback == null || !z10) {
            return;
        }
        mediationRewardedAdCallback.onVideoComplete();
    }
}

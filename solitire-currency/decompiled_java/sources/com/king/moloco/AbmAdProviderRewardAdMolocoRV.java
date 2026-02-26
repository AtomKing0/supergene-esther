package com.king.moloco;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.ironsource.v8;
import com.king.amp.sa.AbmAdProviderRewardAd;
import com.king.amp.sa.AdProviderNameValuePairs;
import com.king.amp.sa.o;
import com.king.amp.sa.p;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.Moloco;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.RewardedInterstitialAd;
import com.moloco.sdk.publisher.RewardedInterstitialAdShowListener;
import java.util.Locale;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AbmAdProviderRewardAdMolocoRV implements AbmAdProviderRewardAd, AdLoad.Listener, RewardedInterstitialAdShowListener {
    private String TAG;
    private Activity mActivity;
    private p mListener;
    private boolean mPlayCompleted;
    private RewardedInterstitialAd mRewardedAd;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ k0 lambda$load$0(String str, RewardedInterstitialAd rewardedInterstitialAd, MolocoAdError.AdCreateError adCreateError) {
        if (rewardedInterstitialAd != null) {
            this.mRewardedAd = rewardedInterstitialAd;
            this.mListener.logBreadcrumb(this.TAG, "Moloco RV - create success");
            rewardedInterstitialAd.load(str, this);
        } else {
            String str2 = String.format(Locale.getDefault(), "Moloco RV - create failed: (%d) %s", Integer.valueOf(adCreateError.getErrorCode()), adCreateError.getDescription());
            Log.e(this.TAG, str2);
            this.mListener.onLoadFailed(adCreateError.getErrorCode(), str2);
        }
        return k0.f35197a;
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public /* synthetic */ String getProperty(String str) {
        return o.a(this, str);
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void load(AdProviderNameValuePairs adProviderNameValuePairs) {
        final String str;
        this.mListener.logBreadcrumb("External", "Moloco RV - load");
        Object value = adProviderNameValuePairs.getValue("targetingKeyValues");
        if (value != null) {
            this.mListener.logBreadcrumb(this.TAG, "fetch payload from config");
            String[] strArr = (String[]) value;
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                if (i11 >= strArr.length) {
                    break;
                }
                if (strArr[i10].equals("moloco_bid_payload")) {
                    str = strArr[i11];
                    break;
                }
                i10 += 2;
            }
        } else {
            str = "";
        }
        if (str == null || str.isEmpty()) {
            this.mListener.onLoadFailed(0, "bidPayload is null or empty");
            return;
        }
        String str2 = (String) adProviderNameValuePairs.getValue("adUnitId", "");
        if (str2 == null || str2.isEmpty()) {
            this.mListener.onLoadFailed(0, "instanceID is null or empty");
        } else {
            Moloco.createRewardedInterstitial(str2, null, new h9.p() { // from class: n6.c
                @Override // h9.p
                /* JADX INFO: renamed from: invoke */
                public final Object mo4invoke(Object obj, Object obj2) {
                    return this.f31702a.lambda$load$0(str, (RewardedInterstitialAd) obj, (MolocoAdError.AdCreateError) obj2);
                }
            });
        }
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdClicked(@NonNull MolocoAd molocoAd) {
        this.mListener.logBreadcrumb(this.TAG, "Internal Moloco RV - onAdClicked");
        this.mListener.onEndCardInfoClicked();
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdHidden(@NonNull MolocoAd molocoAd) {
        this.mListener.logBreadcrumb(this.TAG, "Internal Moloco RV - onAdHidden");
        if (this.mPlayCompleted) {
            this.mListener.onPlayCompleted();
        }
        this.mListener.onClosed(this.mPlayCompleted);
    }

    @Override // com.moloco.sdk.publisher.AdLoad.Listener
    public void onAdLoadFailed(@NonNull MolocoAdError molocoAdError) {
        int errorCode = molocoAdError.getErrorType().getErrorCode();
        String str = String.format(Locale.getDefault(), "Moloco RV - onAdLoadFailed: (%d) %s", Integer.valueOf(errorCode), molocoAdError.getDescription());
        this.mListener.logBreadcrumb(this.TAG, "Internal Moloco RV - onAdLoadFailed, " + str);
        this.mListener.onLoadFailed(errorCode, str);
    }

    @Override // com.moloco.sdk.publisher.AdLoad.Listener
    public void onAdLoadSuccess(@NonNull MolocoAd molocoAd) {
        this.mListener.logBreadcrumb(this.TAG, "Internal Moloco RV - onAdLoadSuccess");
        AdProviderNameValuePairs adProviderNameValuePairs = new AdProviderNameValuePairs();
        adProviderNameValuePairs.add(v8.f15659j, molocoAd.getAdUnitId());
        this.mListener.onAdLoaded(adProviderNameValuePairs);
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdShowFailed(@NonNull MolocoAdError molocoAdError) {
        int errorCode = molocoAdError.getErrorType().getErrorCode();
        String str = String.format(Locale.getDefault(), "Moloco RV - onAdShowFailed: (%d) %s", Integer.valueOf(errorCode), molocoAdError.getDescription());
        this.mListener.logBreadcrumb(this.TAG, "Internal Moloco RV - onAdShowFailed, " + str);
        this.mListener.onShowFailed(errorCode, str);
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdShowSuccess(@NonNull MolocoAd molocoAd) {
        this.mListener.logBreadcrumb(this.TAG, "Internal Moloco RV - onAdShowSuccess");
    }

    @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
    public void onRewardedVideoCompleted(@NonNull MolocoAd molocoAd) {
        this.mListener.logBreadcrumb(this.TAG, "Internal Moloco RV - onRewardedVideoCompleted");
    }

    @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
    public void onRewardedVideoStarted(@NonNull MolocoAd molocoAd) {
        this.mListener.logBreadcrumb(this.TAG, "Internal Moloco RV - onRewardedVideoStarted");
    }

    @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
    public void onUserRewarded(@NonNull MolocoAd molocoAd) {
        this.mListener.logBreadcrumb(this.TAG, "Internal Moloco RV - onUserRewarded");
        this.mPlayCompleted = true;
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void setListener(p pVar) {
        this.mListener = pVar;
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void setLogTag(String str) {
        this.TAG = str;
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void show() {
        this.mListener.logBreadcrumb("External", "MolocoRV - show");
        RewardedInterstitialAd rewardedInterstitialAd = this.mRewardedAd;
        if (rewardedInterstitialAd == null) {
            this.mListener.onShowFailed(0, "No ad loaded");
        } else {
            rewardedInterstitialAd.show(this);
        }
    }
}

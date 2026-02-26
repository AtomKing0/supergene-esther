package com.king.ironsource;

import android.app.Activity;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.v8;
import com.king.amp.sa.AbmAdProviderRewardAd;
import com.king.amp.sa.AdProviderNameValuePairs;
import com.king.amp.sa.o;
import com.king.amp.sa.p;
import com.unity3d.ironsourceads.rewarded.RewardedAd;
import com.unity3d.ironsourceads.rewarded.RewardedAdListener;
import com.unity3d.ironsourceads.rewarded.RewardedAdLoader;
import com.unity3d.ironsourceads.rewarded.RewardedAdLoaderListener;
import com.unity3d.ironsourceads.rewarded.RewardedAdRequest;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AbmAdProviderRewardAdIronSourceRV implements AbmAdProviderRewardAd {
    private String TAG;
    private Activity mActivity;
    private p mListener;
    private RewardedAd mRewardedAd;

    class a implements RewardedAdLoaderListener {
        a() {
        }

        @Override // com.unity3d.ironsourceads.rewarded.RewardedAdLoaderListener
        public void onRewardedAdLoadFailed(@NonNull IronSourceError ironSourceError) {
            AbmAdProviderRewardAdIronSourceRV.this.mListener.logBreadcrumb(AbmAdProviderRewardAdIronSourceRV.this.TAG, "Internal IronSource RV - onRewardedAdLoadFailed, " + ironSourceError.getErrorMessage());
            AbmAdProviderRewardAdIronSourceRV.this.mListener.onLoadFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }

        @Override // com.unity3d.ironsourceads.rewarded.RewardedAdLoaderListener
        public void onRewardedAdLoaded(@NonNull RewardedAd rewardedAd) {
            AbmAdProviderRewardAdIronSourceRV.this.mListener.logBreadcrumb(AbmAdProviderRewardAdIronSourceRV.this.TAG, "Internal IronSource RV - onRewardedAdLoaded");
            AbmAdProviderRewardAdIronSourceRV.this.mRewardedAd = rewardedAd;
            AdProviderNameValuePairs adProviderNameValuePairs = new AdProviderNameValuePairs();
            adProviderNameValuePairs.add(v8.f15659j, rewardedAd.getAdInfo().getInstanceId());
            AbmAdProviderRewardAdIronSourceRV.this.mListener.onAdLoaded(adProviderNameValuePairs);
        }
    }

    class b implements RewardedAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f17115a = false;

        b() {
        }

        @Override // com.unity3d.ironsourceads.rewarded.RewardedAdListener
        public void onRewardedAdClicked(@NonNull RewardedAd rewardedAd) {
            AbmAdProviderRewardAdIronSourceRV.this.mListener.logBreadcrumb(AbmAdProviderRewardAdIronSourceRV.this.TAG, "Internal IronSourceRV - onRewardedAdClicked");
            AbmAdProviderRewardAdIronSourceRV.this.mListener.onEndCardInfoClicked();
        }

        @Override // com.unity3d.ironsourceads.rewarded.RewardedAdListener
        public void onRewardedAdDismissed(@NonNull RewardedAd rewardedAd) {
            AbmAdProviderRewardAdIronSourceRV.this.mListener.logBreadcrumb(AbmAdProviderRewardAdIronSourceRV.this.TAG, "Internal IronSourceRV - onRewardedAdDismissed");
            if (this.f17115a) {
                AbmAdProviderRewardAdIronSourceRV.this.mListener.onPlayCompleted();
            }
            AbmAdProviderRewardAdIronSourceRV.this.mListener.onClosed(this.f17115a);
        }

        @Override // com.unity3d.ironsourceads.rewarded.RewardedAdListener
        public void onRewardedAdFailedToShow(@NonNull RewardedAd rewardedAd, @NonNull IronSourceError ironSourceError) {
            AbmAdProviderRewardAdIronSourceRV.this.mListener.logBreadcrumb(AbmAdProviderRewardAdIronSourceRV.this.TAG, "Internal IronSourceRV - onRewardedAdFailedToShow, " + ironSourceError.getErrorMessage());
            AbmAdProviderRewardAdIronSourceRV.this.mListener.onShowFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }

        @Override // com.unity3d.ironsourceads.rewarded.RewardedAdListener
        public void onRewardedAdShown(@NonNull RewardedAd rewardedAd) {
            AbmAdProviderRewardAdIronSourceRV.this.mListener.logBreadcrumb(AbmAdProviderRewardAdIronSourceRV.this.TAG, "Internal IronSourceRV - onRewardedAdShown");
        }

        @Override // com.unity3d.ironsourceads.rewarded.RewardedAdListener
        public void onUserEarnedReward(@NonNull RewardedAd rewardedAd) {
            AbmAdProviderRewardAdIronSourceRV.this.mListener.logBreadcrumb(AbmAdProviderRewardAdIronSourceRV.this.TAG, "Internal IronSourceRV - onUserEarnedReward");
            this.f17115a = true;
        }
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public /* synthetic */ String getProperty(String str) {
        return o.a(this, str);
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void load(AdProviderNameValuePairs adProviderNameValuePairs) {
        String str;
        this.mListener.logBreadcrumb("External", "IronSource RV - load");
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
                if (strArr[i10].equals("ironsource_bid_payload")) {
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
            RewardedAdLoader.loadAd(new RewardedAdRequest.Builder(str2, str).build(), new a());
        }
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
        this.mListener.logBreadcrumb("External", "IronSourceRV - show");
        RewardedAd rewardedAd = this.mRewardedAd;
        if (rewardedAd == null) {
            this.mListener.onShowFailed(0, "No ad loaded");
        } else {
            rewardedAd.setListener(new b());
            this.mRewardedAd.show(this.mActivity);
        }
    }
}

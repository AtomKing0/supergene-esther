package com.king.fan;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.v8;
import com.king.amp.sa.AbmAdProviderRewardAd;
import com.king.amp.sa.AdProviderNameValuePairs;
import com.king.amp.sa.n0;
import com.king.amp.sa.o;
import com.king.amp.sa.p;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AbmAdProviderRewardAdFanRV implements AbmAdProviderRewardAd, RewardedVideoAdListener, Application.ActivityLifecycleCallbacks {
    private String LOG_TAG;
    private Activity mActivity;
    private p mListener;
    private RewardedVideoAd mRewardedVideoAd;
    private boolean mIsShowing = false;
    private boolean mIsCompleted = false;

    class a extends n0 {
        a(String str) {
            super(str);
        }

        @Override // com.king.amp.sa.n0
        public void b() {
            if (AbmAdProviderRewardAdFanRV.this.mRewardedVideoAd != null) {
                AbmAdProviderRewardAdFanRV.this.mListener.logBreadcrumb("External", "Fan RV - destroy");
                AbmAdProviderRewardAdFanRV.this.mRewardedVideoAd.destroy();
            }
        }
    }

    class b extends n0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AdProviderNameValuePairs f17049c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ RewardedVideoAdListener f17050d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, AdProviderNameValuePairs adProviderNameValuePairs, RewardedVideoAdListener rewardedVideoAdListener) {
            super(str);
            this.f17049c = adProviderNameValuePairs;
            this.f17050d = rewardedVideoAdListener;
        }

        @Override // com.king.amp.sa.n0
        public void b() throws Exception {
            if (AbmAdProviderRewardAdFanRV.this.mRewardedVideoAd != null) {
                AbmAdProviderRewardAdFanRV.this.mRewardedVideoAd.destroy();
            }
            Log.i(AbmAdProviderRewardAdFanRV.this.LOG_TAG, "FB wants you to be flexible!");
            String str = "";
            String str2 = (String) this.f17049c.getValue("adUnitId", "");
            Object value = this.f17049c.getValue("targetingKeyValues");
            if (value != null) {
                AbmAdProviderRewardAdFanRV.this.mListener.logBreadcrumb(AbmAdProviderRewardAdFanRV.this.LOG_TAG, "fetch payload ");
                String[] strArr = (String[]) value;
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    if (i11 >= strArr.length) {
                        break;
                    }
                    if (strArr[i10].equals("fb_bid_payload")) {
                        str = strArr[i11];
                        break;
                    }
                    i10 += 2;
                }
            }
            AbmAdProviderRewardAdFanRV abmAdProviderRewardAdFanRV = AbmAdProviderRewardAdFanRV.this;
            abmAdProviderRewardAdFanRV.mRewardedVideoAd = new RewardedVideoAd(abmAdProviderRewardAdFanRV.mActivity, str2);
            RewardedVideoAd.RewardedVideoAdLoadConfigBuilder rewardedVideoAdLoadConfigBuilderBuildLoadAdConfig = AbmAdProviderRewardAdFanRV.this.mRewardedVideoAd.buildLoadAdConfig();
            rewardedVideoAdLoadConfigBuilderBuildLoadAdConfig.withAdListener(this.f17050d);
            if (str.isEmpty()) {
                rewardedVideoAdLoadConfigBuilderBuildLoadAdConfig.withFailOnCacheFailureEnabled(true);
            } else {
                rewardedVideoAdLoadConfigBuilderBuildLoadAdConfig.withBid(str);
            }
            RewardedVideoAd.RewardedVideoLoadAdConfig rewardedVideoLoadAdConfigBuild = rewardedVideoAdLoadConfigBuilderBuildLoadAdConfig.build();
            AbmAdProviderRewardAdFanRV.this.mListener.logBreadcrumb("External", "Fan RV - loadAd");
            AbmAdProviderRewardAdFanRV.this.mRewardedVideoAd.loadAd(rewardedVideoLoadAdConfigBuild);
        }
    }

    public void destroy() {
        synchronized (this) {
            this.mListener = null;
            new a(this.LOG_TAG).a();
        }
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public /* synthetic */ String getProperty(String str) {
        return o.a(this, str);
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void load(AdProviderNameValuePairs adProviderNameValuePairs) {
        if (AudienceNetworkAds.isInitialized(this.mActivity.getApplicationContext())) {
            new b(this.LOG_TAG, adProviderNameValuePairs, this).a();
        } else {
            this.mListener.onLoadFailed(IronSourceConstants.errorCode_showFailed, "provider not ready");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Activity activity2 = this.mActivity;
        if (activity != activity2) {
            return;
        }
        Intent intent = activity2.getIntent();
        if (!this.mIsShowing || intent == null || intent.getAction() == null || intent.getAction().compareTo("android.intent.action.MAIN") != 0 || intent.getCategories() == null || !intent.getCategories().contains("android.intent.category.LAUNCHER")) {
            return;
        }
        synchronized (this) {
            this.mIsShowing = false;
            this.mListener.logBreadcrumb("Internal", "Fan RV - onAdClosed");
            this.mListener.onClosed(true);
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onAdClicked(Ad ad) {
        synchronized (this) {
            this.mListener.logBreadcrumb("Internal", "Fan RV - onAdClicked");
            this.mListener.onEndCardInfoClicked();
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onAdLoaded(Ad ad) {
        synchronized (this) {
            this.mListener.logBreadcrumb("Internal", "Fan RV - onAdLoaded");
            this.mIsCompleted = false;
            AdProviderNameValuePairs adProviderNameValuePairs = new AdProviderNameValuePairs();
            adProviderNameValuePairs.add(v8.f15659j, this.mRewardedVideoAd.getPlacementId());
            adProviderNameValuePairs.add("adDuration", Double.valueOf(((double) this.mRewardedVideoAd.getVideoDuration()) / 1000.0d));
            this.mListener.onAdLoaded(adProviderNameValuePairs);
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onError(Ad ad, AdError adError) {
        synchronized (this) {
            this.mListener.logBreadcrumb("Internal", "Fan RV - onAdError");
            if (this.mIsShowing) {
                this.mIsShowing = false;
                this.mListener.onShowFailed(adError.getErrorCode(), adError.getErrorMessage());
            } else {
                this.mListener.onLoadFailed(adError.getErrorCode(), adError.getErrorMessage());
            }
        }
    }

    @Override // com.facebook.ads.RewardedVideoAdListener
    public void onRewardedVideoClosed() {
        synchronized (this) {
            this.mIsShowing = false;
            this.mListener.logBreadcrumb("Internal", "Fan RV - onAdClosed");
            this.mListener.onClosed(this.mIsCompleted);
        }
    }

    @Override // com.facebook.ads.RewardedVideoAdListener
    public void onRewardedVideoCompleted() {
        synchronized (this) {
            this.mIsCompleted = true;
            this.mListener.logBreadcrumb("Internal", "Fan RV - onAdCompleted");
            this.mListener.onPlayCompleted();
        }
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void setActivity(Activity activity) {
        this.mActivity = activity;
        if (activity != null) {
            activity.getApplication().registerActivityLifecycleCallbacks(this);
        }
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void setListener(p pVar) {
        this.mListener = pVar;
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void setLogTag(String str) {
        this.LOG_TAG = "ads_provider_" + str;
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void show() {
        RewardedVideoAd rewardedVideoAd = this.mRewardedVideoAd;
        if (rewardedVideoAd == null) {
            Log.w(this.LOG_TAG, "RV ad is null.");
            synchronized (this) {
                this.mListener.onShowFailed(8888, "RV ad is null.");
            }
            return;
        }
        try {
            if (rewardedVideoAd.isAdLoaded()) {
                this.mIsShowing = true;
                RewardedVideoAd.RewardedVideoAdShowConfigBuilder rewardedVideoAdShowConfigBuilderBuildShowAdConfig = this.mRewardedVideoAd.buildShowAdConfig();
                this.mListener.logBreadcrumb("External", "Fan RV - show");
                this.mRewardedVideoAd.show(rewardedVideoAdShowConfigBuilderBuildShowAdConfig.build());
            } else {
                Log.w(this.LOG_TAG, "RV is not loaded.");
            }
        } catch (Exception e10) {
            Log.e(this.LOG_TAG, " exception in show " + e10.toString());
            synchronized (this) {
                this.mIsShowing = false;
                this.mListener.onShowFailed(8889, "exception in show .");
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // com.facebook.ads.AdListener
    public void onLoggingImpression(Ad ad) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}

package com.king.vungle;

import android.app.Activity;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.ironsource.v8;
import com.king.amp.sa.AbmAdProviderRewardAd;
import com.king.amp.sa.AdProviderNameValuePairs;
import com.king.amp.sa.o;
import com.king.amp.sa.p;
import com.vungle.ads.b2;
import com.vungle.ads.c;
import com.vungle.ads.q1;
import com.vungle.ads.s1;
import com.vungle.ads.u;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AbmAdProviderRewardAdVungleRV implements AbmAdProviderRewardAd, s1 {
    private String ERR_TAG;
    private String LOG_TAG;
    private Activity mActivity;
    private p mListener;
    private String mObjectId;
    private String mPlacementId;

    @NonNull
    private final AtomicBoolean mPlayCompleted = new AtomicBoolean(false);
    private q1 mRewardedAd;

    public void destroy() {
        this.mListener = null;
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public /* synthetic */ String getProperty(String str) {
        return o.a(this, str);
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void load(AdProviderNameValuePairs adProviderNameValuePairs) {
        int i10;
        synchronized (this) {
            i10 = 0;
            this.mPlayCompleted.set(false);
        }
        this.mPlacementId = (String) adProviderNameValuePairs.getValue("adUnitId", "");
        String str = "";
        Object value = adProviderNameValuePairs.getValue("targetingKeyValues");
        if (value instanceof String[]) {
            this.mListener.logBreadcrumb(this.LOG_TAG, "fetch payload from config");
            String[] strArr = (String[]) value;
            while (true) {
                if (i10 >= strArr.length) {
                    break;
                }
                if (strArr[i10].equals("liftoff_bid_payload")) {
                    str = strArr[i10 + 1];
                    break;
                }
                i10 += 2;
            }
        }
        q1 q1Var = new q1(this.mActivity.getApplicationContext(), this.mPlacementId, new c());
        this.mRewardedAd = q1Var;
        q1Var.setAdListener(this);
        this.mRewardedAd.load(str);
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdClicked(@NonNull u uVar) {
        synchronized (this) {
            this.mListener.logBreadcrumb("Internal", "Vungle RV - onAdClicked " + uVar.getCreativeId());
            this.mListener.onEndCardInfoClicked();
        }
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdEnd(@NonNull u uVar) {
        this.mListener.logBreadcrumb(this.LOG_TAG, "External Vungle RV IVungleAdsShowListener - onAdEnd " + uVar.getCreativeId());
        if (this.mPlayCompleted.get()) {
            this.mListener.onPlayCompleted();
        }
        this.mListener.onClosed(this.mPlayCompleted.get());
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdFailedToLoad(@NonNull u uVar, @NonNull b2 b2Var) {
        this.mListener.logBreadcrumb(this.LOG_TAG, "Internal Vungle RV - onAdFailedToLoad " + uVar.getCreativeId());
        this.mListener.onLoadFailed(b2Var.getCode(), this.ERR_TAG + ": " + b2Var.getErrorMessage());
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdFailedToPlay(@NonNull u uVar, @NonNull b2 b2Var) {
        this.mListener.logBreadcrumb(this.LOG_TAG, "External Vungle RV IVungleAdsShowListener - onAdFailedToPlay " + uVar.getCreativeId());
        this.mListener.onShowFailed(b2Var.getCode(), this.ERR_TAG + ": " + b2Var.getErrorMessage());
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdImpression(@NonNull u uVar) {
        this.mListener.logBreadcrumb(this.LOG_TAG, "Internal Vungle RV - onAdImpression " + uVar.getCreativeId());
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdLoaded(@NonNull u uVar) {
        synchronized (this) {
            this.mListener.logBreadcrumb(this.LOG_TAG, "Internal Vungle RV - onAdLoaded " + uVar.getCreativeId());
            AdProviderNameValuePairs adProviderNameValuePairs = new AdProviderNameValuePairs();
            adProviderNameValuePairs.add(v8.f15659j, uVar.getCreativeId());
            this.mListener.onAdLoaded(adProviderNameValuePairs);
        }
    }

    @Override // com.vungle.ads.s1
    public void onAdRewarded(@NonNull u uVar) {
        this.mListener.logBreadcrumb(this.LOG_TAG, "External Vungle RV IVungleAdsShowListener - onAdRewarded " + uVar.getCreativeId());
        this.mPlayCompleted.set(true);
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdStart(@NonNull u uVar) {
        this.mListener.logBreadcrumb(this.LOG_TAG, "External Vungle RV IVungleAdsShowListener - onAdStart " + uVar.getCreativeId());
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
        this.LOG_TAG = "ads_provider_" + str;
        this.ERR_TAG = str;
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void show() {
        q1 q1Var = this.mRewardedAd;
        if (q1Var == null || !q1Var.canPlayAd().booleanValue()) {
            return;
        }
        this.mRewardedAd.play(this.mActivity.getApplicationContext());
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdLeftApplication(@NonNull u uVar) {
    }
}

package com.applovin.mediation.nativeAds;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.mediation.ads.MaxNativeAdLoaderImpl;
import com.applovin.impl.sdk.j;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.sdk.AppLovinSdk;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MaxNativeAdLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxNativeAdLoaderImpl f7970a;

    public MaxNativeAdLoader(String str) {
        this(str, j.n());
    }

    public void a(List<View> list, ViewGroup viewGroup, MaxAd maxAd) {
        this.f7970a.logApiCall("a()");
        this.f7970a.registerClickableViews(list, viewGroup, maxAd);
    }

    public void b(MaxAd maxAd) {
        this.f7970a.logApiCall("b()");
        this.f7970a.handleNativeAdViewRendered(maxAd);
    }

    public void destroy() {
        this.f7970a.logApiCall("destroy()");
        this.f7970a.destroy();
    }

    public String getAdUnitId() {
        return this.f7970a.getAdUnitId();
    }

    public String getPlacement() {
        this.f7970a.logApiCall("getPlacement()");
        return this.f7970a.getPlacement();
    }

    public void loadAd() {
        loadAd(null);
    }

    public boolean render(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        this.f7970a.logApiCall("render(adView=" + maxNativeAdView + ", ad=" + maxAd + ")");
        return this.f7970a.render(maxNativeAdView, maxAd);
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f7970a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f7970a.setAdReviewListener(maxAdReviewListener);
    }

    public void setCustomData(String str) {
        this.f7970a.logApiCall("setCustomData(value=" + str + ")");
        this.f7970a.setCustomData(str);
    }

    public void setExtraParameter(String str, String str2) {
        this.f7970a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f7970a.setExtraParameter(str, str2);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.f7970a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f7970a.setLocalExtraParameter(str, obj);
    }

    public void setNativeAdListener(MaxNativeAdListener maxNativeAdListener) {
        this.f7970a.logApiCall("setNativeAdListener(listener=" + maxNativeAdListener + ")");
        this.f7970a.setNativeAdListener(maxNativeAdListener);
    }

    public void setPlacement(String str) {
        this.f7970a.logApiCall("setPlacement(placement=" + str + ")");
        this.f7970a.setPlacement(str);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.f7970a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f7970a.setRevenueListener(maxAdRevenueListener);
    }

    @Deprecated
    public MaxNativeAdLoader(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    public void loadAd(MaxNativeAdView maxNativeAdView) {
        this.f7970a.logApiCall("loadAd(adView=" + maxNativeAdView + ")");
        this.f7970a.loadAd(maxNativeAdView);
    }

    @Deprecated
    public MaxNativeAdLoader(String str, AppLovinSdk appLovinSdk, Context context) {
        com.applovin.impl.mediation.ads.a.logApiCall("MaxNativeAdLoader", "MaxNativeAdLoader(adUnitId=" + str + ", sdk=" + appLovinSdk + ")");
        if (str != null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Empty ad unit ID specified");
            }
            if (appLovinSdk == null) {
                throw new IllegalArgumentException("No sdk specified");
            }
            if (context != null) {
                this.f7970a = new MaxNativeAdLoaderImpl(str, appLovinSdk.a());
                return;
            }
            throw new IllegalArgumentException("No context specified");
        }
        throw new IllegalArgumentException("No ad unit ID specified");
    }

    public void destroy(MaxAd maxAd) {
        this.f7970a.logApiCall("destroy(nativeAd=" + maxAd + ")");
        this.f7970a.destroy(maxAd);
    }
}

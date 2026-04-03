package com.applovin.mediation.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.j;
import com.applovin.impl.z6;
import com.applovin.mediation.MaxAdExpirationListener;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.sdk.AppLovinSdk;

/* JADX INFO: loaded from: classes2.dex */
public class MaxAppOpenAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxFullscreenAdImpl f7949a;

    public MaxAppOpenAd(@NonNull String str) {
        this(str, j.n());
    }

    public void destroy() {
        this.f7949a.logApiCall("destroy()");
        this.f7949a.destroy();
    }

    @NonNull
    public String getAdUnitId() {
        return this.f7949a.getAdUnitId();
    }

    public boolean isReady() {
        boolean zIsReady = this.f7949a.isReady();
        this.f7949a.logApiCall("isReady() " + zIsReady + " for ad unit id " + this.f7949a.getAdUnitId());
        return zIsReady;
    }

    public void loadAd() {
        this.f7949a.logApiCall("loadAd()");
        this.f7949a.loadAd();
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f7949a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f7949a.setAdReviewListener(maxAdReviewListener);
    }

    public void setExpirationListener(MaxAdExpirationListener maxAdExpirationListener) {
        this.f7949a.logApiCall("setExpirationListener(listener=" + maxAdExpirationListener + ")");
        this.f7949a.setExpirationListener(maxAdExpirationListener);
    }

    public void setExtraParameter(@NonNull String str, @Nullable String str2) {
        this.f7949a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f7949a.setExtraParameter(str, str2);
    }

    public void setListener(@Nullable MaxAdListener maxAdListener) {
        this.f7949a.logApiCall("setListener(listener=" + maxAdListener + ")");
        this.f7949a.setListener(maxAdListener);
    }

    public void setLocalExtraParameter(@NonNull String str, @Nullable Object obj) {
        this.f7949a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f7949a.setLocalExtraParameter(str, obj);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        this.f7949a.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.f7949a.setRequestListener(maxAdRequestListener);
    }

    public void setRevenueListener(@Nullable MaxAdRevenueListener maxAdRevenueListener) {
        this.f7949a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f7949a.setRevenueListener(maxAdRevenueListener);
    }

    public void showAd() {
        showAd(null);
    }

    @NonNull
    public String toString() {
        return "" + this.f7949a;
    }

    @Deprecated
    public MaxAppOpenAd(@NonNull String str, @NonNull Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    public void showAd(@Nullable String str) {
        showAd(str, null);
    }

    @Deprecated
    public MaxAppOpenAd(@NonNull String str, @NonNull AppLovinSdk appLovinSdk) {
        this(str, appLovinSdk, j.n());
    }

    public void showAd(@Nullable String str, @Nullable String str2) {
        this.f7949a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ")");
        z6.b(str2, "MaxAppOpenAd");
        this.f7949a.showAd(str, str2, null);
    }

    private MaxAppOpenAd(String str, AppLovinSdk appLovinSdk, Context context) {
        a.logApiCall("MaxAppOpenAd", "MaxAppOpenAd(adUnitId=" + str + ", sdk=" + appLovinSdk + ", context=" + context + ")");
        this.f7949a = new MaxFullscreenAdImpl(str.trim(), MaxAdFormat.APP_OPEN, null, "MaxAppOpenAd", appLovinSdk.a(), context);
    }
}

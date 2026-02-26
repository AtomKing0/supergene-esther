package com.applovin.mediation.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.mediation.ads.MaxRewardedAdImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.j;
import com.applovin.impl.z6;
import com.applovin.mediation.MaxAdExpirationListener;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MaxRewardedAd implements MaxFullscreenAdImpl.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f7952b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f7953c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static WeakReference f7954d = new WeakReference(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxRewardedAdImpl f7955a;

    private MaxRewardedAd(String str, AppLovinSdk appLovinSdk, Context context) {
        this.f7955a = new MaxRewardedAdImpl(str.trim(), MaxAdFormat.REWARDED, this, "MaxRewardedAd", appLovinSdk.a(), context);
    }

    public static MaxRewardedAd getInstance(String str) {
        return getInstance(str, j.n());
    }

    public void destroy() {
        this.f7955a.logApiCall("destroy()");
        synchronized (f7953c) {
            f7952b.remove(this.f7955a.getAdUnitId());
        }
        this.f7955a.destroy();
    }

    @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.a
    public Activity getActivity() {
        this.f7955a.logApiCall("getActivity()");
        return (Activity) f7954d.get();
    }

    public String getAdUnitId() {
        return this.f7955a.getAdUnitId();
    }

    public boolean isReady() {
        boolean zIsReady = this.f7955a.isReady();
        this.f7955a.logApiCall("isReady() " + zIsReady + " for ad unit id " + this.f7955a.getAdUnitId());
        return zIsReady;
    }

    public void loadAd() {
        this.f7955a.logApiCall("loadAd()");
        this.f7955a.loadAd();
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f7955a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f7955a.setAdReviewListener(maxAdReviewListener);
    }

    public void setExpirationListener(@Nullable MaxAdExpirationListener maxAdExpirationListener) {
        this.f7955a.logApiCall("setExpirationListener(listener=" + maxAdExpirationListener + ")");
        this.f7955a.setExpirationListener(maxAdExpirationListener);
    }

    public void setExtraParameter(String str, String str2) {
        this.f7955a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f7955a.setExtraParameter(str, str2);
    }

    public void setListener(MaxRewardedAdListener maxRewardedAdListener) {
        this.f7955a.logApiCall("setListener(listener=" + maxRewardedAdListener + ")");
        this.f7955a.setListener(maxRewardedAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.f7955a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f7955a.setLocalExtraParameter(str, obj);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        this.f7955a.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.f7955a.setRequestListener(maxAdRequestListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.f7955a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f7955a.setRevenueListener(maxAdRevenueListener);
    }

    public void showAd(Activity activity) {
        showAd((String) null, activity);
    }

    public String toString() {
        return "" + this.f7955a;
    }

    @Deprecated
    public static MaxRewardedAd getInstance(String str, Context context) {
        return getInstance(str, AppLovinSdk.getInstance(context), context);
    }

    public void showAd(String str, Activity activity) {
        showAd(str, (String) null, activity);
    }

    @Deprecated
    public static MaxRewardedAd getInstance(String str, AppLovinSdk appLovinSdk, Context context) {
        a.logApiCall("MaxRewardedAd", "getInstance(adUnitId=" + str + ", sdk=" + appLovinSdk + ", context=" + context + ")");
        if (str != null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Empty ad unit ID specified");
            }
            if (context == null) {
                throw new IllegalArgumentException("No context specified");
            }
            if (appLovinSdk != null) {
                if (context instanceof Activity) {
                    f7954d = new WeakReference((Activity) context);
                }
                synchronized (f7953c) {
                    Map map = f7952b;
                    MaxRewardedAd maxRewardedAd = (MaxRewardedAd) map.get(str);
                    if (maxRewardedAd != null) {
                        return maxRewardedAd;
                    }
                    MaxRewardedAd maxRewardedAd2 = new MaxRewardedAd(str, appLovinSdk, context);
                    map.put(str, maxRewardedAd2);
                    return maxRewardedAd2;
                }
            }
            throw new IllegalArgumentException("No sdk specified");
        }
        throw new IllegalArgumentException("No ad unit ID specified");
    }

    public void showAd(String str, String str2, Activity activity) {
        this.f7955a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", activity=" + activity + ")");
        z6.b(str2, "MaxRewardedAd");
        this.f7955a.showAd(str, str2, activity);
    }

    public void showAd(ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        showAd((String) null, viewGroup, lifecycle, activity);
    }

    public void showAd(String str, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        showAd(str, null, viewGroup, lifecycle, activity);
    }

    public void showAd(String str, String str2, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        this.f7955a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", containerView=" + viewGroup + ", lifecycle=" + lifecycle + ", activity=" + activity + ")");
        this.f7955a.showAd(str, str2, viewGroup, lifecycle, activity);
    }

    @Deprecated
    public void showAd() {
        showAd((String) null);
    }

    @Deprecated
    public void showAd(String str) {
        showAd(str, (String) null);
    }

    @Deprecated
    public void showAd(String str, String str2) {
        this.f7955a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ")");
        z6.b(str2, "MaxRewardedAd");
        this.f7955a.showAd(str, str2, getActivity());
    }

    @Deprecated
    public void showAd(ViewGroup viewGroup, Lifecycle lifecycle) {
        showAd((String) null, viewGroup, lifecycle);
    }

    @Deprecated
    public void showAd(String str, ViewGroup viewGroup, Lifecycle lifecycle) {
        showAd(str, (String) null, viewGroup, lifecycle);
    }

    @Deprecated
    public void showAd(String str, String str2, ViewGroup viewGroup, Lifecycle lifecycle) {
        this.f7955a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", containerView=" + viewGroup + ", lifecycle=" + lifecycle + ")");
        this.f7955a.showAd(str, str2, viewGroup, lifecycle, getActivity());
    }
}

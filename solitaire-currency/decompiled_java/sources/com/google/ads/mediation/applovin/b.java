package com.google.ads.mediation.applovin;

import android.content.Context;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;

/* JADX INFO: compiled from: AppLovinAdViewWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppLovinAdView f8247a;

    private b(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, Context context) {
        this.f8247a = new AppLovinAdView(appLovinSdk, appLovinAdSize, context);
    }

    public static b b(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, Context context) {
        return new b(appLovinSdk, appLovinAdSize, context);
    }

    public AppLovinAdView a() {
        return this.f8247a;
    }

    public void c(AppLovinAd appLovinAd) {
        this.f8247a.renderAd(appLovinAd);
    }

    public void d(AppLovinAdClickListener appLovinAdClickListener) {
        this.f8247a.setAdClickListener(appLovinAdClickListener);
    }

    public void e(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f8247a.setAdDisplayListener(appLovinAdDisplayListener);
    }

    public void f(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        this.f8247a.setAdViewEventListener(appLovinAdViewEventListener);
    }
}

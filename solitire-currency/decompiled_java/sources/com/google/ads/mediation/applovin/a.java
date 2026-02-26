package com.google.ads.mediation.applovin;

import android.content.Context;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;

/* JADX INFO: compiled from: AppLovinAdFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    b a(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, Context context) {
        return b.b(appLovinSdk, appLovinAdSize, context);
    }

    public AppLovinIncentivizedInterstitial b(AppLovinSdk appLovinSdk) {
        return AppLovinIncentivizedInterstitial.create(appLovinSdk);
    }

    public AppLovinIncentivizedInterstitial c(String str, AppLovinSdk appLovinSdk) {
        return AppLovinIncentivizedInterstitial.create(str, appLovinSdk);
    }

    public AppLovinInterstitialAdDialog d(AppLovinSdk appLovinSdk, Context context) {
        return AppLovinInterstitialAd.create(appLovinSdk, context);
    }
}

package com.applovin.adview;

import android.content.Context;
import com.applovin.impl.h2;
import com.applovin.impl.sdk.j;
import com.applovin.sdk.AppLovinSdk;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinInterstitialAd {
    public static AppLovinInterstitialAdDialog create() {
        return create(AppLovinSdk.getInstance(j.n()), j.n());
    }

    public String toString() {
        return "AppLovinInterstitialAd{}";
    }

    @Deprecated
    public static AppLovinInterstitialAdDialog create(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (context != null) {
            return new h2(appLovinSdk, context);
        }
        throw new IllegalArgumentException("No context specified");
    }
}

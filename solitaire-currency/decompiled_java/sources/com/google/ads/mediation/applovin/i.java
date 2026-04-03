package com.google.ads.mediation.applovin;

import android.content.Context;
import com.applovin.sdk.AppLovinSdk;

/* JADX INFO: compiled from: AppLovinSdkWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {
    public AppLovinSdk a(Context context) {
        return AppLovinSdk.getInstance(context);
    }

    public String b() {
        return AppLovinSdk.VERSION;
    }
}

package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n5 extends f5 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AppLovinNativeAdLoadListener f6407i;

    public n5(s sVar, String str, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super(sVar, str, jVar);
        this.f6407i = appLovinNativeAdLoadListener;
    }

    @Override // com.applovin.impl.f5
    protected w4 a(JSONObject jSONObject) {
        return new u5(jSONObject, this.f6407i, this.f7677a);
    }

    @Override // com.applovin.impl.f5
    protected String e() {
        return n0.d(this.f7677a);
    }

    @Override // com.applovin.impl.f5
    protected String f() {
        return n0.e(this.f7677a);
    }

    @Override // com.applovin.impl.f5
    protected void a(int i10, String str) {
        super.a(i10, str);
        this.f6407i.onNativeAdLoadFailed(new AppLovinError(i10, str));
    }
}

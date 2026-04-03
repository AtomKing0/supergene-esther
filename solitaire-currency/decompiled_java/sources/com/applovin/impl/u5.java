package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class u5 extends w4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final JSONObject f7531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AppLovinNativeAdLoadListener f7532h;

    public u5(JSONObject jSONObject, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskProcessNativeAdResponse", jVar);
        this.f7531g = jSONObject;
        this.f7532h = appLovinNativeAdLoadListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray = JsonUtils.getJSONArray(this.f7531g, "ads", new JSONArray());
        if (jSONArray.length() > 0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Processing ad...");
            }
            this.f7677a.j0().a(new com.applovin.impl.sdk.nativeAd.b(JsonUtils.getJSONObject(jSONArray, 0, new JSONObject()), this.f7531g, this.f7532h, this.f7677a));
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.k(this.f7678b, "No ads were returned from the server");
        }
        z6.a("native_native", MaxAdFormat.NATIVE, this.f7531g, this.f7677a);
        this.f7532h.onNativeAdLoadFailed(AppLovinError.NO_FILL);
    }
}

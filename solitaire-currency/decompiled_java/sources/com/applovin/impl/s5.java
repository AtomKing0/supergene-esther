package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class s5 extends w4 implements g2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final JSONObject f6812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final s f6813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AppLovinAdLoadListener f6814i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f6815j;

    public s5(JSONObject jSONObject, s sVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        this(jSONObject, sVar, false, appLovinAdLoadListener, jVar);
    }

    private void a(JSONObject jSONObject) {
        String string = JsonUtils.getString(jSONObject, "type", "undefined");
        if ("applovin".equalsIgnoreCase(string)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Starting task for AppLovin ad...");
            }
            this.f7677a.j0().a(new x5(jSONObject, this.f6812g, this, this.f7677a));
            return;
        }
        if ("vast".equalsIgnoreCase(string)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Starting task for VAST ad...");
            }
            this.f7677a.j0().a(v5.a(jSONObject, this.f6812g, this, this.f7677a));
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.b(this.f7678b, "Unable to process ad of unknown type: " + string);
        }
        failedToReceiveAdV2(new AppLovinError(AppLovinErrorCodes.INVALID_RESPONSE, "Unknown ad type: " + string));
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f6814i;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(appLovinAd);
        }
        if (this.f6815j || !(appLovinAd instanceof com.applovin.impl.sdk.ad.b)) {
            return;
        }
        this.f7677a.g().a(y1.f7791l, (com.applovin.impl.sdk.ad.b) appLovinAd);
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i10) {
        failedToReceiveAdV2(new AppLovinError(i10, ""));
    }

    @Override // com.applovin.impl.g2
    public void failedToReceiveAdV2(AppLovinError appLovinError) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f6814i;
        if (appLovinAdLoadListener == null) {
            return;
        }
        if (appLovinAdLoadListener instanceof g2) {
            ((g2) appLovinAdLoadListener).failedToReceiveAdV2(appLovinError);
        } else {
            appLovinAdLoadListener.failedToReceiveAd(appLovinError.getCode());
        }
        if (this.f6815j) {
            return;
        }
        this.f7677a.g().a(y1.f7793m, this.f6813h, appLovinError);
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray = JsonUtils.getJSONArray(this.f6812g, "ads", new JSONArray());
        if (jSONArray.length() > 0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Processing ad...");
            }
            a(JsonUtils.getJSONObject(jSONArray, 0, new JSONObject()));
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.k(this.f7678b, "No ads were returned from the server");
            }
            z6.a(this.f6813h.e(), this.f6813h.d(), this.f6812g, this.f7677a);
            failedToReceiveAdV2(AppLovinError.NO_FILL);
        }
    }

    public s5(JSONObject jSONObject, s sVar, boolean z10, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskProcessAdResponse", jVar);
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        }
        if (sVar == null) {
            throw new IllegalArgumentException("No zone specified");
        }
        this.f6812g = jSONObject;
        this.f6813h = sVar;
        this.f6814i = appLovinAdLoadListener;
        this.f6815j = z10;
    }
}

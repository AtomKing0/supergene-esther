package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m5 extends f5 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AppLovinAdLoadListener f5877i;

    public m5(s sVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        this(sVar, appLovinAdLoadListener, "TaskFetchNextAd", jVar);
    }

    @Override // com.applovin.impl.f5
    protected w4 a(JSONObject jSONObject) {
        return new s5(jSONObject, this.f5187g, this.f5877i, this.f7677a);
    }

    @Override // com.applovin.impl.f5
    protected String e() {
        return n0.a(this.f7677a);
    }

    @Override // com.applovin.impl.f5
    protected String f() {
        return n0.b(this.f7677a);
    }

    public m5(s sVar, AppLovinAdLoadListener appLovinAdLoadListener, String str, com.applovin.impl.sdk.j jVar) {
        super(sVar, str, jVar);
        this.f5877i = appLovinAdLoadListener;
    }

    @Override // com.applovin.impl.f5
    protected void a(int i10, String str) {
        super.a(i10, str);
        AppLovinAdLoadListener appLovinAdLoadListener = this.f5877i;
        if (!(appLovinAdLoadListener instanceof g2)) {
            appLovinAdLoadListener.failedToReceiveAd(i10);
        } else {
            ((g2) this.f5877i).failedToReceiveAdV2(new AppLovinError(i10, str));
        }
    }
}

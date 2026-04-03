package com.applovin.impl;

import com.applovin.impl.r5;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x5 extends w4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final JSONObject f7745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final JSONObject f7746h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AppLovinAdLoadListener f7747i;

    public x5(JSONObject jSONObject, JSONObject jSONObject2, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskRenderAppLovinAd", jVar);
        this.f7745g = jSONObject;
        this.f7746h = jSONObject2;
        this.f7747i = appLovinAdLoadListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Rendering ad...");
        }
        com.applovin.impl.sdk.ad.a aVar = new com.applovin.impl.sdk.ad.a(this.f7745g, this.f7746h, this.f7677a);
        boolean zBooleanValue = JsonUtils.getBoolean(this.f7745g, "gs_load_immediately", Boolean.FALSE).booleanValue();
        boolean zBooleanValue2 = JsonUtils.getBoolean(this.f7745g, "vs_load_immediately", Boolean.TRUE).booleanValue();
        a5 a5Var = new a5(aVar, this.f7677a, this.f7747i);
        a5Var.c(zBooleanValue2);
        a5Var.b(zBooleanValue);
        this.f7677a.j0().a((w4) a5Var, r5.b.CACHING);
    }
}

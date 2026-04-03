package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class v2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NetworkSettings f15640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f15641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IronSource.AD_UNIT f15642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f15643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f15644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f15646g;

    public v2(NetworkSettings networkSettings, JSONObject jSONObject, IronSource.AD_UNIT ad_unit) {
        this.f15640a = networkSettings;
        this.f15641b = jSONObject;
        int iOptInt = jSONObject.optInt("instanceType");
        this.f15645f = iOptInt;
        this.f15643d = iOptInt == 2;
        this.f15644e = jSONObject.optBoolean(IronSourceConstants.EARLY_INIT_FIELD);
        this.f15646g = jSONObject.optInt("maxAdsPerSession", 99);
        this.f15642c = ad_unit;
    }

    public String a() {
        return this.f15640a.getAdSourceNameForEvents();
    }

    public IronSource.AD_UNIT b() {
        return this.f15642c;
    }

    public JSONObject c() {
        return this.f15641b;
    }

    public int d() {
        return this.f15645f;
    }

    public int e() {
        return this.f15646g;
    }

    public String f() {
        return this.f15640a.getProviderName();
    }

    public String g() {
        return this.f15640a.getProviderTypeForReflection();
    }

    public NetworkSettings h() {
        return this.f15640a;
    }

    public String i() {
        return this.f15640a.getSubProviderId();
    }

    public boolean j() {
        return this.f15643d;
    }

    public boolean k() {
        return this.f15644e;
    }
}

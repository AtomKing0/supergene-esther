package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.AppLovinUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a6 extends c6 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.applovin.impl.sdk.ad.b f4700g;

    public a6(com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.j jVar) {
        super("TaskReportAppLovinReward", jVar);
        this.f4700g = bVar;
    }

    @Override // com.applovin.impl.e6
    protected void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, AppLovinUtils.ServerParameterKeys.ZONE_ID, this.f4700g.getAdZone().e());
        JsonUtils.putInt(jSONObject, "fire_percent", this.f4700g.U());
        String clCode = this.f4700g.getClCode();
        if (!StringUtils.isValidString(clCode)) {
            clCode = "NO_CLCODE";
        }
        JsonUtils.putString(jSONObject, "clcode", clCode);
    }

    @Override // com.applovin.impl.c6
    protected void b(JSONObject jSONObject) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Reported reward successfully for ad: " + this.f4700g);
        }
    }

    @Override // com.applovin.impl.e6
    protected String f() {
        return "2.0/cr";
    }

    @Override // com.applovin.impl.c6
    protected b4 h() {
        return this.f4700g.f();
    }

    @Override // com.applovin.impl.c6
    protected void i() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.b(this.f7678b, "No reward result was found for ad: " + this.f4700g);
        }
    }

    @Override // com.applovin.impl.e6
    protected void a(int i10) {
        super.a(i10);
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.b(this.f7678b, "Failed to report reward for ad: " + this.f4700g + " - error code: " + i10);
        }
        this.f7677a.g().a(y1.f7799p, this.f4700g);
    }
}

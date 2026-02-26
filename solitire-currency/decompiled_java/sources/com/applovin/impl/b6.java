package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b6 extends c6 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final t2 f4905g;

    public b6(t2 t2Var, com.applovin.impl.sdk.j jVar) {
        super("TaskReportMaxReward", jVar);
        this.f4905g = t2Var;
    }

    @Override // com.applovin.impl.e6
    protected void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "ad_unit_id", this.f4905g.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.f4905g.getPlacement());
        JsonUtils.putString(jSONObject, "custom_data", this.f4905g.e());
        String strK0 = this.f4905g.k0();
        if (!StringUtils.isValidString(strK0)) {
            strK0 = "NO_MCODE";
        }
        JsonUtils.putString(jSONObject, "mcode", strK0);
        String strC = this.f4905g.C();
        if (!StringUtils.isValidString(strC)) {
            strC = "NO_BCODE";
        }
        JsonUtils.putString(jSONObject, "bcode", strC);
    }

    @Override // com.applovin.impl.c6
    protected void b(JSONObject jSONObject) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Reported reward successfully for mediated ad: " + this.f4905g);
        }
    }

    @Override // com.applovin.impl.e6
    protected String f() {
        return "2.0/mcr";
    }

    @Override // com.applovin.impl.c6
    protected b4 h() {
        return this.f4905g.g0();
    }

    @Override // com.applovin.impl.c6
    protected void i() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.b(this.f7678b, "No reward result was found for mediated ad: " + this.f4905g);
        }
    }

    @Override // com.applovin.impl.e6
    protected void a(int i10) {
        super.a(i10);
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Failed to report reward for mediated ad: " + this.f4905g + " - error code: " + i10);
        }
        this.f7677a.J().a(y1.Y, this.f4905g);
    }
}

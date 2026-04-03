package com.applovin.impl;

import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h6 extends i6 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final t2 f5340g;

    public h6(t2 t2Var, com.applovin.impl.sdk.j jVar) {
        super("TaskValidateMaxReward", jVar);
        this.f5340g = t2Var;
    }

    @Override // com.applovin.impl.e6
    protected void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "ad_unit_id", this.f5340g.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.f5340g.getPlacement());
        JsonUtils.putString(jSONObject, "custom_data", this.f5340g.e());
        JsonUtils.putString(jSONObject, "ad_format", this.f5340g.getFormat().getLabel());
        String strK0 = this.f5340g.k0();
        if (!StringUtils.isValidString(strK0)) {
            strK0 = "NO_MCODE";
        }
        JsonUtils.putString(jSONObject, "mcode", strK0);
        String strC = this.f5340g.C();
        if (!StringUtils.isValidString(strC)) {
            strC = "NO_BCODE";
        }
        JsonUtils.putString(jSONObject, "bcode", strC);
    }

    @Override // com.applovin.impl.e6
    protected String f() {
        return "2.0/mvr";
    }

    @Override // com.applovin.impl.i6
    protected boolean h() {
        return this.f5340g.m0();
    }

    @Override // com.applovin.impl.i6
    protected void a(b4 b4Var) {
        this.f5340g.a(b4Var);
    }

    @Override // com.applovin.impl.e6
    protected void a(int i10) {
        super.a(i10);
        String str = (i10 < 400 || i10 >= 500) ? "network_timeout" : "rejected";
        this.f5340g.a(b4.a(str));
        this.f7677a.J().a(y1.Z, this.f5340g, CollectionUtils.hashMap("error_message", str));
    }
}

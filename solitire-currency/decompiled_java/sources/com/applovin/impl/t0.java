package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class t0 extends q0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map f7406c;

    public t0(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        super(jSONObject, jVar);
    }

    public Map d() {
        return this.f7406c;
    }

    public String e() {
        return JsonUtils.getString(this.f6628b, "name", null);
    }

    @Override // com.applovin.impl.q0
    public String toString() {
        return "ConsentFlowState{id=" + b() + ", type=" + c() + ", name=" + e() + "}";
    }
}

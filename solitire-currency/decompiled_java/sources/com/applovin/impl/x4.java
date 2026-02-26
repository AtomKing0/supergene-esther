package com.applovin.impl;

import com.applovin.impl.i4;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class x4 extends w4 {
    x4(com.applovin.impl.sdk.j jVar) {
        super("TaskApiSubmitData", jVar);
    }

    private void b(JSONObject jSONObject) {
        if (((Boolean) this.f7677a.a(l4.f5643g4)).booleanValue()) {
            JsonUtils.putJSONObjectIfValid(jSONObject, "stats", this.f7677a.E().c());
        }
    }

    private void c(JSONObject jSONObject) {
        com.applovin.impl.sdk.k kVarY = this.f7677a.y();
        Map mapN = kVarY.n();
        z6.a("platform", "type", mapN);
        z6.a("api_level", "sdk_version", mapN);
        JsonUtils.putObject(jSONObject, "device_info", new JSONObject(mapN));
        Map mapC = kVarY.C();
        z6.a("sdk_version", "applovin_sdk_version", mapC);
        z6.a("ia", "installed_at", mapC);
        JsonUtils.putObject(jSONObject, "app_info", new JSONObject(mapC));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.d(this.f7678b, "Submitting user data...");
        }
        Map mapC = n0.c(this.f7677a);
        JSONObject jSONObject = new JSONObject();
        c(jSONObject);
        b(jSONObject);
        if (((Boolean) this.f7677a.a(l4.Y4)).booleanValue() || ((Boolean) this.f7677a.a(l4.S4)).booleanValue()) {
            JsonUtils.putAll(jSONObject, (Map<String, ?>) mapC);
            mapC = null;
        }
        a(mapC, jSONObject);
    }

    class a extends z5 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
            super(aVar, jVar);
        }

        @Override // com.applovin.impl.z5, com.applovin.impl.m0.e
        public void a(String str, JSONObject jSONObject, int i10) {
            x4.this.a(jSONObject);
        }

        @Override // com.applovin.impl.z5, com.applovin.impl.m0.e
        public void a(String str, int i10, String str2, JSONObject jSONObject) {
            n0.a(i10, this.f7677a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(JsonUtils.getJSONArray(jSONObject, "results", new JSONArray()), 0, new JSONObject());
        this.f7677a.h0().a(l4.f5630f, JsonUtils.getString(jSONObject2, "device_id", ""));
        this.f7677a.h0().a(l4.f5662j, JsonUtils.getString(jSONObject2, "device_token", ""));
        n0.a(jSONObject2, this.f7677a);
        this.f7677a.E().b();
    }

    private void a(Map map, JSONObject jSONObject) {
        a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f7677a).b(n0.b("2.0/device", this.f7677a)).a(n0.a("2.0/device", this.f7677a)).b(map).a(jSONObject).c("POST").b(((Boolean) this.f7677a.a(l4.f5636f5)).booleanValue()).a((Object) new JSONObject()).a(((Integer) this.f7677a.a(l4.M2)).intValue()).a(i4.a.a(((Integer) this.f7677a.a(l4.Q4)).intValue())).a(), this.f7677a);
        aVar.c(l4.f5727r0);
        aVar.b(l4.f5735s0);
        this.f7677a.j0().a(aVar);
    }
}

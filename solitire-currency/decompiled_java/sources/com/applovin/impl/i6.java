package com.applovin.impl;

import com.applovin.impl.m0;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Collections;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i6 extends e6 {
    protected i6(String str, com.applovin.impl.sdk.j jVar) {
        super(str, jVar);
    }

    private b4 b(JSONObject jSONObject) {
        Map<String, String> mapEmptyMap;
        String string;
        JSONObject jSONObject2 = JsonUtils.getJSONObject(JsonUtils.getJSONArray(jSONObject, "results", new JSONArray()), 0, new JSONObject());
        n0.c(jSONObject2, this.f7677a);
        n0.b(jSONObject, this.f7677a);
        n0.a(jSONObject, this.f7677a);
        try {
            mapEmptyMap = JsonUtils.toStringMap((JSONObject) jSONObject2.get("params"));
        } catch (Throwable unused) {
            mapEmptyMap = Collections.emptyMap();
        }
        try {
            string = jSONObject2.getString("result");
        } catch (Throwable unused2) {
            string = "network_timeout";
        }
        return b4.a(string, mapEmptyMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject) {
        b4 b4VarB = b(jSONObject);
        a(b4VarB);
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Pending reward handled: " + b4VarB);
        }
    }

    protected abstract void a(b4 b4Var);

    @Override // com.applovin.impl.e6
    protected int g() {
        return ((Integer) this.f7677a.a(l4.X0)).intValue();
    }

    protected abstract boolean h();

    @Override // java.lang.Runnable
    public void run() {
        a(e(), new a());
    }

    class a implements m0.e {
        a() {
        }

        @Override // com.applovin.impl.m0.e
        public void a(String str, JSONObject jSONObject, int i10) {
            if (i6.this.h()) {
                com.applovin.impl.sdk.n nVar = i6.this.f7679c;
                if (com.applovin.impl.sdk.n.a()) {
                    i6 i6Var = i6.this;
                    i6Var.f7679c.b(i6Var.f7678b, "Reward validation succeeded with code " + i10 + " but task was cancelled already");
                }
                com.applovin.impl.sdk.n nVar2 = i6.this.f7679c;
                if (com.applovin.impl.sdk.n.a()) {
                    i6 i6Var2 = i6.this;
                    i6Var2.f7679c.b(i6Var2.f7678b, "Response: " + jSONObject);
                    return;
                }
                return;
            }
            com.applovin.impl.sdk.n nVar3 = i6.this.f7679c;
            if (com.applovin.impl.sdk.n.a()) {
                i6 i6Var3 = i6.this;
                i6Var3.f7679c.a(i6Var3.f7678b, "Reward validation succeeded with code " + i10 + " and response: " + jSONObject);
            }
            i6.this.c(jSONObject);
        }

        @Override // com.applovin.impl.m0.e
        public void a(String str, int i10, String str2, JSONObject jSONObject) {
            if (i6.this.h()) {
                com.applovin.impl.sdk.n nVar = i6.this.f7679c;
                if (com.applovin.impl.sdk.n.a()) {
                    i6 i6Var = i6.this;
                    i6Var.f7679c.b(i6Var.f7678b, "Reward validation failed with error code " + i10 + " but task was cancelled already");
                    return;
                }
                return;
            }
            com.applovin.impl.sdk.n nVar2 = i6.this.f7679c;
            if (com.applovin.impl.sdk.n.a()) {
                i6 i6Var2 = i6.this;
                i6Var2.f7679c.b(i6Var2.f7678b, "Reward validation failed with code " + i10 + " and error: " + str2);
            }
            i6.this.a(i10);
        }
    }
}

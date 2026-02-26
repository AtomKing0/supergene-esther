package com.applovin.impl;

import com.applovin.impl.m0;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c6 extends e6 {
    protected c6(String str, com.applovin.impl.sdk.j jVar) {
        super(str, jVar);
    }

    private JSONObject a(b4 b4Var) {
        JSONObject jSONObjectE = e();
        JsonUtils.putString(jSONObjectE, "result", b4Var.b());
        Map mapA = b4Var.a();
        if (mapA != null) {
            JsonUtils.putJSONObject(jSONObjectE, "params", new JSONObject(mapA));
        }
        return jSONObjectE;
    }

    protected abstract void b(JSONObject jSONObject);

    @Override // com.applovin.impl.e6
    protected int g() {
        return ((Integer) this.f7677a.a(l4.Y0)).intValue();
    }

    protected abstract b4 h();

    protected abstract void i();

    @Override // java.lang.Runnable
    public void run() {
        b4 b4VarH = h();
        if (b4VarH == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.b(this.f7678b, "Pending reward not found");
            }
            i();
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Reporting pending reward: " + b4VarH + "...");
        }
        a(a(b4VarH), new a());
    }

    class a implements m0.e {
        a() {
        }

        @Override // com.applovin.impl.m0.e
        public void a(String str, JSONObject jSONObject, int i10) {
            c6.this.b(jSONObject);
        }

        @Override // com.applovin.impl.m0.e
        public void a(String str, int i10, String str2, JSONObject jSONObject) {
            c6.this.a(i10);
        }
    }
}

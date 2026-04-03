package com.applovin.impl;

import com.applovin.impl.i4;
import com.applovin.impl.m0;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e6 extends w4 {
    protected e6(String str, com.applovin.impl.sdk.j jVar) {
        super(str, jVar);
    }

    protected abstract void a(JSONObject jSONObject);

    void a(JSONObject jSONObject, m0.e eVar) {
        Map mapC = n0.c(this.f7677a);
        if (((Boolean) this.f7677a.a(l4.Z4)).booleanValue() || ((Boolean) this.f7677a.a(l4.S4)).booleanValue()) {
            JsonUtils.putAll(jSONObject, (Map<String, ?>) mapC);
            mapC = null;
        }
        a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f7677a).b(n0.b(f(), this.f7677a)).a(n0.a(f(), this.f7677a)).b(mapC).a(jSONObject).c("POST").b(((Boolean) this.f7677a.a(l4.f5660i5)).booleanValue()).a((Object) new JSONObject()).a(g()).a(i4.a.a(((Integer) this.f7677a.a(l4.R4)).intValue())).a(), this.f7677a, eVar);
        aVar.c(l4.f5727r0);
        aVar.b(l4.f5735s0);
        this.f7677a.j0().a(aVar);
    }

    protected JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        String strC = this.f7677a.p0().c();
        if (((Boolean) this.f7677a.a(l4.f5698n3)).booleanValue() && StringUtils.isValidString(strC)) {
            JsonUtils.putString(jSONObject, "cuid", strC);
        }
        if (((Boolean) this.f7677a.a(l4.f5714p3)).booleanValue()) {
            JsonUtils.putString(jSONObject, "compass_random_token", this.f7677a.s());
        }
        if (((Boolean) this.f7677a.a(l4.f5730r3)).booleanValue()) {
            JsonUtils.putString(jSONObject, "applovin_random_token", this.f7677a.a0());
        }
        a(jSONObject);
        return jSONObject;
    }

    protected abstract String f();

    protected abstract int g();

    class a extends z5 {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ m0.e f5141m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar, m0.e eVar) {
            super(aVar, jVar);
            this.f5141m = eVar;
        }

        @Override // com.applovin.impl.z5, com.applovin.impl.m0.e
        public void a(String str, JSONObject jSONObject, int i10) {
            this.f5141m.a(str, jSONObject, i10);
        }

        @Override // com.applovin.impl.z5, com.applovin.impl.m0.e
        public void a(String str, int i10, String str2, JSONObject jSONObject) {
            this.f5141m.a(str, i10, str2, jSONObject);
        }
    }

    protected void a(int i10) {
        n0.a(i10, this.f7677a);
    }
}

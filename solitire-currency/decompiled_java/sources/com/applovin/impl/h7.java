package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h7 implements d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5342b;

    private h7(String str, String str2) {
        this.f5341a = str;
        this.f5342b = str2;
    }

    public static h7 a(b8 b8Var, com.applovin.impl.sdk.j jVar) {
        if (b8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        try {
            return new h7((String) b8Var.a().get("apiFramework"), b8Var.d());
        } catch (Throwable th) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("VastJavaScriptResource", "Error occurred while initializing", th);
            }
            jVar.A().a("VastJavaScriptResource", th);
            return null;
        }
    }

    public String b() {
        return this.f5341a;
    }

    public String c() {
        return this.f5342b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h7 h7Var = (h7) obj;
        String str = this.f5341a;
        if (str == null ? h7Var.f5341a != null : !str.equals(h7Var.f5341a)) {
            return false;
        }
        String str2 = this.f5342b;
        String str3 = h7Var.f5342b;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public int hashCode() {
        String str = this.f5341a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f5342b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "VastJavaScriptResource{apiFramework='" + this.f5341a + "', javascriptResourceUrl='" + this.f5342b + "'}";
    }

    public static h7 a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            return null;
        }
        return new h7(JsonUtils.getString(jSONObject, "api_framework", null), JsonUtils.getString(jSONObject, "javascript_resource_url", null));
    }

    @Override // com.applovin.impl.d4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "api_framework", this.f5341a);
        JsonUtils.putString(jSONObject, "javascript_resource_url", this.f5342b);
        return jSONObject;
    }
}

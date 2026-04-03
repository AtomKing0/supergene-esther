package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class j7 implements d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5494b;

    private j7() {
    }

    public static j7 a(b8 b8Var, j7 j7Var, com.applovin.impl.sdk.j jVar) {
        if (b8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (j7Var == null) {
            try {
                j7Var = new j7();
            } catch (Throwable th) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("VastSystemInfo", "Error occurred while initializing", th);
                }
                jVar.A().a("VastSystemInfo", th);
                return null;
            }
        }
        if (!StringUtils.isValidString(j7Var.f5493a)) {
            String strD = b8Var.d();
            if (StringUtils.isValidString(strD)) {
                j7Var.f5493a = strD;
            }
        }
        if (!StringUtils.isValidString(j7Var.f5494b)) {
            String str = (String) b8Var.a().get("version");
            if (StringUtils.isValidString(str)) {
                j7Var.f5494b = str;
            }
        }
        return j7Var;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j7)) {
            return false;
        }
        j7 j7Var = (j7) obj;
        String str = this.f5493a;
        if (str == null ? j7Var.f5493a != null : !str.equals(j7Var.f5493a)) {
            return false;
        }
        String str2 = this.f5494b;
        String str3 = j7Var.f5494b;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public int hashCode() {
        String str = this.f5493a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f5494b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "VastSystemInfo{name='" + this.f5493a + "', version='" + this.f5494b + "'}";
    }

    public static j7 a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            return null;
        }
        j7 j7Var = new j7();
        j7Var.f5493a = JsonUtils.getString(jSONObject, "name", null);
        j7Var.f5494b = JsonUtils.getString(jSONObject, "version", null);
        return j7Var;
    }

    @Override // com.applovin.impl.d4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "name", this.f5493a);
        JsonUtils.putString(jSONObject, "version", this.f5494b);
        return jSONObject;
    }
}

package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c7 implements d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f4960a;

    private c7(List list) {
        this.f4960a = list;
    }

    public static c7 a(b8 b8Var, c7 c7Var, e7 e7Var, com.applovin.impl.sdk.j jVar) {
        try {
            List listB = c7Var != null ? c7Var.b() : new ArrayList();
            Iterator it = b8Var.a("Verification").iterator();
            while (it.hasNext()) {
                b7 b7VarA = b7.a((b8) it.next(), e7Var, jVar);
                if (b7VarA != null) {
                    listB.add(b7VarA);
                }
            }
            return new c7(listB);
        } catch (Throwable th) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("VastAdVerifications", "Error occurred while initializing", th);
            }
            jVar.A().a("VastAdVerifications", th);
            return null;
        }
    }

    public List b() {
        return this.f4960a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c7) {
            return this.f4960a.equals(((c7) obj).f4960a);
        }
        return false;
    }

    public int hashCode() {
        return this.f4960a.hashCode();
    }

    public String toString() {
        return "VastAdVerification{verifications='" + this.f4960a + "'}";
    }

    static c7 a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "verifications", new JSONArray());
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            b7 b7VarA = b7.a(JsonUtils.getJSONObject(jSONArray, i10, (JSONObject) null), jVar);
            if (b7VarA != null) {
                arrayList.add(b7VarA);
            }
        }
        return new c7(arrayList);
    }

    @Override // com.applovin.impl.d4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        if (this.f4960a != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.f4960a.iterator();
            while (it.hasNext()) {
                jSONArray.put(((b7) it.next()).a());
            }
            JsonUtils.putJsonArray(jSONObject, "verifications", jSONArray);
        }
        return jSONObject;
    }
}

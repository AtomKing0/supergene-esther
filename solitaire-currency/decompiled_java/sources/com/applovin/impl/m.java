package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final w7 f5842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f5843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f5844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5845f = false;

    m(JSONObject jSONObject, Map map, MaxAdFormat maxAdFormat, com.applovin.impl.sdk.j jVar) {
        this.f5840a = JsonUtils.getString(jSONObject, "name", "");
        this.f5841b = JsonUtils.getString(jSONObject, "experiment", null);
        this.f5842c = a(jSONObject);
        this.f5843d = a("bidders", jSONObject, map, maxAdFormat, jVar);
        this.f5844e = a(com.ironsource.mediationsdk.d.f13326g, jSONObject, map, maxAdFormat, jVar);
    }

    public List a() {
        return this.f5843d;
    }

    public String b() {
        return this.f5841b;
    }

    public String c() {
        return this.f5840a;
    }

    public w7 d() {
        return this.f5842c;
    }

    public List e() {
        return this.f5844e;
    }

    public boolean f() {
        return this.f5845f;
    }

    private w7 a(JSONObject jSONObject) {
        return new w7(JsonUtils.getJSONObject(jSONObject, "targeting"));
    }

    private List a(String str, JSONObject jSONObject, Map map, MaxAdFormat maxAdFormat, com.applovin.impl.sdk.j jVar) {
        v2 v2Var;
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, str, new JSONArray());
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i10, (JSONObject) null);
            if (jSONObject2 != null && (v2Var = (v2) map.get(JsonUtils.getString(jSONObject2, "adapter_class", ""))) != null) {
                if (v2Var.D()) {
                    this.f5845f = true;
                }
                arrayList.add(new u7(jSONObject2, maxAdFormat, v2Var, jVar));
            }
        }
        return arrayList;
    }
}

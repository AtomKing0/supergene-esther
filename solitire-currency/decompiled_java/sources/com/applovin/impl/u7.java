package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.ironsource.jo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class u7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m2 f7534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p3 f7535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f7536c;

    public u7(JSONObject jSONObject, MaxAdFormat maxAdFormat, v2 v2Var, com.applovin.impl.sdk.j jVar) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "bidder_placement", (JSONObject) null);
        if (jSONObject2 != null) {
            this.f7535b = new p3(jSONObject2, jVar);
        } else {
            this.f7535b = null;
        }
        this.f7534a = new m2(JsonUtils.getString(jSONObject, "name", ""), JsonUtils.getString(jSONObject, "display_name", ""), jSONObject2 != null, v2Var);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, jo.f12765c, new JSONArray());
        this.f7536c = new ArrayList(jSONArray.length());
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray, i10, (JSONObject) null);
            if (jSONObject3 != null) {
                this.f7536c.add(new p3(jSONObject3, jVar));
            }
        }
    }

    public p3 a() {
        return this.f7535b;
    }

    public m2 b() {
        return this.f7534a;
    }

    public List c() {
        return this.f7536c;
    }

    public boolean d() {
        return this.f7535b != null;
    }
}

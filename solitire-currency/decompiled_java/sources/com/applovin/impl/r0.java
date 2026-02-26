package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class r0 extends q0 {
    public r0(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        super(jSONObject, jVar);
    }

    public List d() {
        s0 s0VarA;
        JSONArray jSONArray = JsonUtils.getJSONArray(this.f6628b, "transitions", null);
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i10, (JSONObject) null);
            if (jSONObject != null && (s0VarA = s0.a(jSONObject, this.f6627a)) != null) {
                arrayList.add(s0VarA);
            }
        }
        return arrayList;
    }

    public String e() {
        return b("message");
    }

    public String f() {
        return b("title");
    }

    @Override // com.applovin.impl.q0
    public String toString() {
        return "ConsentFlowState{id=" + b() + ", type=" + c() + ", title=" + f() + ", message=" + e() + ", actions=" + d() + "}";
    }
}

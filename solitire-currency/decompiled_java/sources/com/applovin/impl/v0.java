package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v0 {
    public static List a(com.applovin.impl.sdk.j jVar) {
        jVar.I();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.I().a("ConsentFlowStateProvider", "Generating consent flow states...");
        }
        String strA = z6.a(R.raw.applovin_consent_flow_unified_cmp, com.applovin.impl.sdk.j.n(), jVar);
        if (TextUtils.isEmpty(strA)) {
            throw new IllegalStateException("Unable to retrieve consent flow data! Please ensure that the AppLovin SDK resources are bundled correctly!");
        }
        JSONObject jSONObjectJsonObjectFromJsonString = JsonUtils.jsonObjectFromJsonString(strA, null);
        if (jSONObjectJsonObjectFromJsonString == null) {
            throw new IllegalStateException("Unable to parse consent flow data! Please ensure that the AppLovin SDK resources are bundled correctly!");
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObjectJsonObjectFromJsonString, "states", new JSONArray());
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            arrayList.add(q0.a(JsonUtils.getJSONObject(jSONArray, i10, new JSONObject()), jVar));
        }
        return arrayList;
    }
}

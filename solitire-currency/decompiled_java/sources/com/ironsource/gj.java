package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
class gj extends e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f12309i = "https://o-sdk.mediation.unity3d.com/mediation?adUnit=2";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f12310j = "super.dwh.mediation_events";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f12311k = nb.Q;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f12312l = "data";

    gj(int i10) {
        this.f11879g = i10;
    }

    @Override // com.ironsource.e
    public String a() {
        return "https://o-sdk.mediation.unity3d.com/mediation?adUnit=2";
    }

    @Override // com.ironsource.e
    public String c() {
        return "ironbeast";
    }

    @Override // com.ironsource.e
    public String a(ArrayList<kb> arrayList, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        this.f11878f = jSONObject;
        try {
            JSONArray jSONArray = new JSONArray();
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<kb> it = arrayList.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObjectA = a(it.next());
                    if (jSONObjectA != null) {
                        jSONArray.put(jSONObjectA);
                    }
                }
            }
            jSONObject2.put(nb.Q, "super.dwh.mediation_events");
            jSONObject2.put("data", a(jSONArray));
            return jSONObject2.toString();
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return "";
        }
    }
}

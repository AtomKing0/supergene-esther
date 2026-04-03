package com.ironsource;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
class nn extends e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f14158i = bo.f11442a;

    nn(int i10) {
        this.f11879g = i10;
    }

    @Override // com.ironsource.e
    public String a() {
        return bo.f11442a;
    }

    @Override // com.ironsource.e
    public String c() {
        return "outcome";
    }

    @Override // com.ironsource.e
    public String a(ArrayList<kb> arrayList, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        this.f11878f = jSONObject;
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
        return a(jSONArray);
    }
}

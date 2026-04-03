package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.v8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class nj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f14144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14146d;

    public nj(JSONObject jSONObject) {
        this.f14143a = jSONObject.optString(v8.f.f15745b);
        this.f14144b = jSONObject.optJSONObject(v8.f.f15746c);
        this.f14145c = jSONObject.optString("success");
        this.f14146d = jSONObject.optString(v8.f.f15748e);
    }

    public String a() {
        return this.f14146d;
    }

    public String b() {
        return this.f14143a;
    }

    public JSONObject c() {
        return this.f14144b;
    }

    public String d() {
        return this.f14145c;
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(v8.f.f15745b, this.f14143a);
            jSONObject.put(v8.f.f15746c, this.f14144b);
            jSONObject.put("success", this.f14145c);
            jSONObject.put(v8.f.f15748e, this.f14146d);
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
        return jSONObject;
    }
}

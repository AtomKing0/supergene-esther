package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11873a = "eventId";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11874b = "timestamp";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f11875c = "InterstitialEvents";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f11876d = "events";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f11877e = "events";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    JSONObject f11878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f11879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f11880h;

    e() {
    }

    private String a(int i10) {
        return i10 != 2 ? "events" : "InterstitialEvents";
    }

    protected abstract String a();

    public abstract String a(ArrayList<kb> arrayList, JSONObject jSONObject);

    String b() {
        return TextUtils.isEmpty(this.f11880h) ? a() : this.f11880h;
    }

    public abstract String c();

    String a(JSONArray jSONArray) {
        try {
            if (this.f11878f != null) {
                JSONObject jSONObject = new JSONObject(this.f11878f.toString());
                jSONObject.put("timestamp", IronSourceUtils.getTimestamp());
                jSONObject.put(a(this.f11879g), jSONArray);
                return jSONObject.toString();
            }
        } catch (Exception e10) {
            i9.d().a(e10);
        }
        return "";
    }

    JSONObject a(kb kbVar) {
        try {
            String strA = kbVar.a();
            JSONObject jSONObject = !TextUtils.isEmpty(strA) ? new JSONObject(strA) : new JSONObject();
            jSONObject.put("eventId", kbVar.c());
            jSONObject.put("timestamp", kbVar.d());
            return jSONObject;
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return null;
        }
    }

    void a(String str) {
        this.f11880h = str;
    }
}

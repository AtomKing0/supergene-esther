package com.applovin.impl;

import android.net.Uri;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d7 implements d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f5034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private i7 f5035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f5036e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f5037f = new HashMap();

    private d7() {
    }

    public static d7 a(b8 b8Var, d7 d7Var, e7 e7Var, com.applovin.impl.sdk.j jVar) {
        b8 b8VarC;
        if (b8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (d7Var == null) {
            try {
                d7Var = new d7();
            } catch (Throwable th) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("VastCompanionAd", "Error occurred while initializing", th);
                }
                jVar.A().a("VastCompanionAd", th);
                return null;
            }
        }
        if (d7Var.f5032a == 0 && d7Var.f5033b == 0) {
            int i10 = StringUtils.parseInt((String) b8Var.a().get("width"));
            int i11 = StringUtils.parseInt((String) b8Var.a().get("height"));
            if (i10 > 0 && i11 > 0) {
                d7Var.f5032a = i10;
                d7Var.f5033b = i11;
            }
        }
        d7Var.f5035d = i7.a(b8Var, d7Var.f5035d, jVar);
        if (d7Var.f5034c == null && (b8VarC = b8Var.c("CompanionClickThrough")) != null) {
            String strD = b8VarC.d();
            if (StringUtils.isValidString(strD)) {
                d7Var.f5034c = Uri.parse(strD);
            }
        }
        m7.a(b8Var.a("CompanionClickTracking"), d7Var.f5036e, e7Var, jVar);
        m7.a(b8Var, d7Var.f5037f, e7Var, jVar);
        return d7Var;
    }

    public Set b() {
        return this.f5036e;
    }

    public Uri c() {
        return this.f5034c;
    }

    public Map d() {
        return this.f5037f;
    }

    public i7 e() {
        return this.f5035d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d7)) {
            return false;
        }
        d7 d7Var = (d7) obj;
        if (this.f5032a != d7Var.f5032a || this.f5033b != d7Var.f5033b) {
            return false;
        }
        Uri uri = this.f5034c;
        if (uri == null ? d7Var.f5034c != null : !uri.equals(d7Var.f5034c)) {
            return false;
        }
        i7 i7Var = this.f5035d;
        if (i7Var == null ? d7Var.f5035d != null : !i7Var.equals(d7Var.f5035d)) {
            return false;
        }
        Set set = this.f5036e;
        if (set == null ? d7Var.f5036e != null : !set.equals(d7Var.f5036e)) {
            return false;
        }
        Map map = this.f5037f;
        Map map2 = d7Var.f5037f;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public int hashCode() {
        int i10 = ((this.f5032a * 31) + this.f5033b) * 31;
        Uri uri = this.f5034c;
        int iHashCode = (i10 + (uri != null ? uri.hashCode() : 0)) * 31;
        i7 i7Var = this.f5035d;
        int iHashCode2 = (iHashCode + (i7Var != null ? i7Var.hashCode() : 0)) * 31;
        Set set = this.f5036e;
        int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map map = this.f5037f;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "VastCompanionAd{width=" + this.f5032a + ", height=" + this.f5033b + ", destinationUri=" + this.f5034c + ", nonVideoResource=" + this.f5035d + ", clickTrackers=" + this.f5036e + ", eventTrackers=" + this.f5037f + '}';
    }

    public static d7 a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            return null;
        }
        int i10 = JsonUtils.getInt(jSONObject, "width", 0);
        int i11 = JsonUtils.getInt(jSONObject, "height", 0);
        String string = JsonUtils.getString(jSONObject, "destination_uri", null);
        Uri uri = StringUtils.isValidString(string) ? Uri.parse(string) : null;
        i7 i7VarA = i7.a(JsonUtils.getJSONObject(jSONObject, "non_video_resource", (JSONObject) null), jVar);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "click_trackers", new JSONArray());
        HashSet hashSet = new HashSet();
        for (int i12 = 0; i12 < jSONArray.length(); i12++) {
            k7 k7VarA = k7.a(JsonUtils.getJSONObject(jSONArray, i12, (JSONObject) null), jVar);
            if (k7VarA != null) {
                hashSet.add(k7VarA);
            }
        }
        d7 d7Var = new d7();
        d7Var.f5032a = i10;
        d7Var.f5033b = i11;
        d7Var.f5034c = uri;
        d7Var.f5035d = i7VarA;
        d7Var.f5036e.addAll(hashSet);
        return d7Var;
    }

    @Override // com.applovin.impl.d4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putInt(jSONObject, "width", this.f5032a);
        JsonUtils.putInt(jSONObject, "height", this.f5033b);
        Uri uri = this.f5034c;
        JsonUtils.putString(jSONObject, "destination_uri", uri == null ? null : uri.toString());
        i7 i7Var = this.f5035d;
        JsonUtils.putJSONObject(jSONObject, "non_video_resource", i7Var != null ? i7Var.a() : null);
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.f5036e.iterator();
        while (it.hasNext()) {
            jSONArray.put(((k7) it.next()).a());
        }
        JsonUtils.putJsonArray(jSONObject, "click_trackers", jSONArray);
        return jSONObject;
    }
}

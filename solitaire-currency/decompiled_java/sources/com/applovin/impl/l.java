package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class l implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MaxAdFormat f5571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final m f5572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f5573e;

    public l(JSONObject jSONObject, Map map, com.applovin.impl.sdk.j jVar) {
        this.f5569a = JsonUtils.getString(jSONObject, "name", "");
        this.f5570b = JsonUtils.getString(jSONObject, "display_name", "");
        this.f5571c = MaxAdFormat.formatFromString(JsonUtils.getString(jSONObject, "format", null));
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "waterfalls", new JSONArray());
        this.f5573e = new ArrayList(jSONArray.length());
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i10, (JSONObject) null);
            if (jSONObject2 != null) {
                this.f5573e.add(new m(jSONObject2, map, this.f5571c, jVar));
            }
        }
        this.f5572d = this.f5573e.isEmpty() ? null : (m) this.f5573e.get(0);
    }

    public MaxAdFormat a() {
        return this.f5571c;
    }

    public String b() {
        MaxAdFormat maxAdFormat = this.f5571c;
        return maxAdFormat != null ? maxAdFormat.getLabel() : "Unknown";
    }

    public String c() {
        return this.f5569a;
    }

    public String d() {
        return this.f5570b;
    }

    public String e() {
        return "\n---------- " + this.f5570b + " ----------\nIdentifier - " + this.f5569a + "\nFormat     - " + b();
    }

    public m f() {
        return this.f5572d;
    }

    public List g() {
        return this.f5573e;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(l lVar) {
        return this.f5570b.compareToIgnoreCase(lVar.f5570b);
    }
}

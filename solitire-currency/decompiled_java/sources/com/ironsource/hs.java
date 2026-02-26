package com.ironsource;

import com.ironsource.v8;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class hs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f12510a;

    public hs(JSONObject jSONObject) {
        this.f12510a = jSONObject == null ? new JSONObject() : jSONObject;
    }

    public boolean a() {
        return this.f12510a.optBoolean("uxt", false);
    }

    public boolean b() {
        return this.f12510a.optBoolean(v8.a.f15687n, false);
    }

    public boolean c() {
        return this.f12510a.optBoolean(v8.a.f15688o, false);
    }

    public boolean d() {
        return this.f12510a.optBoolean(v8.a.f15684k, false);
    }

    public boolean e() {
        return this.f12510a.optBoolean(v8.a.f15686m, false);
    }
}

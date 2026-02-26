package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class w7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f7690c;

    public w7(JSONObject jSONObject) {
        this.f7688a = JsonUtils.getString(jSONObject, "user_type", "all");
        this.f7689b = JsonUtils.getString(jSONObject, "device_type", "all");
        this.f7690c = JsonUtils.getStringList(jSONObject, "segments", null);
    }

    public String a() {
        return this.f7688a;
    }

    public String b() {
        return this.f7689b;
    }

    public List c() {
        return this.f7690c;
    }
}

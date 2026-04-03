package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class p3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6544b;

    public p3(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        this.f6543a = JsonUtils.getString(jSONObject, "id", "");
        this.f6544b = JsonUtils.getString(jSONObject, "price", null);
    }

    public String a() {
        return this.f6543a;
    }

    public String b() {
        return this.f6544b;
    }
}

package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f5011c;

    d1(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        this.f5009a = JsonUtils.getString(jSONObject, "name", "");
        this.f5010b = JsonUtils.getString(jSONObject, "description", "");
        List list = JsonUtils.getList(jSONObject, "existence_classes", null);
        if (list != null) {
            this.f5011c = z6.a(list);
        } else {
            this.f5011c = z6.a(JsonUtils.getString(jSONObject, "existence_class", ""));
        }
    }

    public String a() {
        return this.f5010b;
    }

    public String b() {
        return this.f5009a;
    }

    public boolean c() {
        return this.f5011c;
    }

    public static boolean a(String str, String str2, String str3) {
        if (str == null) {
            return true;
        }
        if (str2 == null || z6.a(str2, str) != 1) {
            return str3 == null || z6.a(str3, str) != -1;
        }
        return false;
    }
}

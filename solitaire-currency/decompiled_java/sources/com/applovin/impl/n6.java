package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class n6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f6408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f6409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f6410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f6411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Boolean f6412e;

    public enum a {
        TCF_VENDOR,
        ATP_NETWORK,
        OTHER;

        /* JADX INFO: Access modifiers changed from: private */
        public static a b(int i10) {
            return i10 != 0 ? i10 != 1 ? OTHER : ATP_NETWORK : TCF_VENDOR;
        }
    }

    public n6(JSONObject jSONObject, String str) {
        this.f6411d = str;
        this.f6408a = a.b(JsonUtils.getInt(jSONObject, "type", a.OTHER.ordinal()));
        this.f6409b = JsonUtils.getInteger(jSONObject, "id", null);
        this.f6410c = JsonUtils.getString(jSONObject, "name", null);
    }

    public void a(Boolean bool) {
        this.f6412e = bool;
    }

    public String b() {
        return this.f6411d;
    }

    public String c() {
        return this.f6410c;
    }

    public Integer d() {
        return this.f6409b;
    }

    public String e() {
        Boolean bool = this.f6412e;
        return "\n" + this.f6411d + " - " + (bool != null ? String.valueOf(bool) : l0.b().a(com.applovin.impl.sdk.j.n()));
    }

    public a f() {
        return this.f6408a;
    }

    public Boolean a() {
        return this.f6412e;
    }
}

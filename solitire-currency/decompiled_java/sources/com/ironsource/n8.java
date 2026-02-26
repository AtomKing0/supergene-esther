package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class n8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final op f14097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final gi f14098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final m6 f14099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final kl f14100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final s3 f14101e;

    public n8(@NotNull JSONObject configurations) {
        kotlin.jvm.internal.t.i(configurations, "configurations");
        this.f14097a = new op(a(configurations, "rewarded"));
        this.f14098b = new gi(a(configurations, "interstitial"));
        this.f14099c = new m6(a(configurations, "banner"));
        this.f14100d = new kl(a(configurations, kq.f12892i));
        JSONObject jSONObjectOptJSONObject = configurations.optJSONObject("application");
        this.f14101e = new s3(jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject);
    }

    @NotNull
    public final s3 a() {
        return this.f14101e;
    }

    @NotNull
    public final m6 b() {
        return this.f14099c;
    }

    @NotNull
    public final gi c() {
        return this.f14098b;
    }

    @NotNull
    public final kl d() {
        return this.f14100d;
    }

    @NotNull
    public final op e() {
        return this.f14097a;
    }

    private final JSONObject a(JSONObject jSONObject, String str) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("adFormats");
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject(str) : null;
        return jSONObjectOptJSONObject2 == null ? new JSONObject() : jSONObjectOptJSONObject2;
    }
}

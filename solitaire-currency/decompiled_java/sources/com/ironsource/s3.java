package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class s3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final yk f14787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f14788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final w3 f14789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final d4 f14790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final q3 f14791e;

    public s3(@NotNull JSONObject applicationConfigurations) {
        kotlin.jvm.internal.t.i(applicationConfigurations, "applicationConfigurations");
        JSONObject jSONObjectOptJSONObject = applicationConfigurations.optJSONObject(u3.f15548a);
        this.f14787a = new yk(jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject);
        this.f14788b = applicationConfigurations.optBoolean(u3.f15554g, false);
        JSONObject jSONObjectOptJSONObject2 = applicationConfigurations.optJSONObject(u3.f15555h);
        this.f14789c = new w3(jSONObjectOptJSONObject2 == null ? new JSONObject() : jSONObjectOptJSONObject2);
        JSONObject jSONObjectOptJSONObject3 = applicationConfigurations.optJSONObject("settings");
        this.f14790d = new d4(jSONObjectOptJSONObject3 == null ? new JSONObject() : jSONObjectOptJSONObject3);
        JSONObject jSONObjectOptJSONObject4 = applicationConfigurations.optJSONObject(u3.f15553f);
        this.f14791e = new q3(jSONObjectOptJSONObject4 == null ? new JSONObject() : jSONObjectOptJSONObject4);
    }

    @NotNull
    public final q3 a() {
        return this.f14791e;
    }

    @NotNull
    public final w3 b() {
        return this.f14789c;
    }

    @NotNull
    public final d4 c() {
        return this.f14790d;
    }

    public final boolean d() {
        return this.f14788b;
    }

    @NotNull
    public final yk e() {
        return this.f14787a;
    }
}

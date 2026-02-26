package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class jq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final cr f12768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final po f12769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final ro f12770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final n8 f12771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final xb f12772e;

    public jq(@NotNull cr fullResponse) {
        kotlin.jvm.internal.t.i(fullResponse, "fullResponse");
        this.f12768a = fullResponse;
        JSONObject jSONObjectOptJSONObject = fullResponse.i().optJSONObject(kq.f12884a);
        this.f12769b = new po(jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject);
        JSONObject jSONObjectOptJSONObject2 = fullResponse.i().optJSONObject(kq.f12885b);
        this.f12770c = new ro(jSONObjectOptJSONObject2 == null ? new JSONObject() : jSONObjectOptJSONObject2);
        JSONObject jSONObjectOptJSONObject3 = fullResponse.i().optJSONObject("configurations");
        this.f12771d = new n8(jSONObjectOptJSONObject3 == null ? new JSONObject() : jSONObjectOptJSONObject3);
        JSONObject jSONObjectOptJSONObject4 = fullResponse.i().optJSONObject(kq.f12887d);
        this.f12772e = new xb(jSONObjectOptJSONObject4 == null ? new JSONObject() : jSONObjectOptJSONObject4);
    }

    @NotNull
    public final n8 a() {
        return this.f12771d;
    }

    @NotNull
    public final xb b() {
        return this.f12772e;
    }

    @NotNull
    public final cr c() {
        return this.f12768a;
    }

    @NotNull
    public final po d() {
        return this.f12769b;
    }

    @NotNull
    public final ro e() {
        return this.f12770c;
    }
}

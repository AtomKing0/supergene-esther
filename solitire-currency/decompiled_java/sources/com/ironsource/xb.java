package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class xb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final JSONObject f16182a;

    public xb(@Nullable JSONObject jSONObject) {
        this.f16182a = jSONObject;
    }

    @Nullable
    public final Boolean a(@NotNull String key) {
        kotlin.jvm.internal.t.i(key, "key");
        JSONObject jSONObject = this.f16182a;
        Object objOpt = jSONObject != null ? jSONObject.opt(key) : null;
        if (objOpt instanceof Boolean) {
            return (Boolean) objOpt;
        }
        return null;
    }

    @Nullable
    public final Integer b(@NotNull String key) {
        kotlin.jvm.internal.t.i(key, "key");
        JSONObject jSONObject = this.f16182a;
        Object objOpt = jSONObject != null ? jSONObject.opt(key) : null;
        if (objOpt instanceof Integer) {
            return (Integer) objOpt;
        }
        return null;
    }

    @Nullable
    public final String c(@NotNull String key) {
        kotlin.jvm.internal.t.i(key, "key");
        JSONObject jSONObject = this.f16182a;
        Object objOpt = jSONObject != null ? jSONObject.opt(key) : null;
        if (objOpt instanceof String) {
            return (String) objOpt;
        }
        return null;
    }
}

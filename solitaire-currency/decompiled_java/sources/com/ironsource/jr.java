package com.ironsource;

import com.ironsource.v8;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class jr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private kr f12773a;

    public jr(@NotNull JSONObject config) {
        kotlin.jvm.internal.t.i(config, "config");
        this.f12773a = kr.f12896b.a(config.optInt(v8.a.f15692s, kr.CurrentlyLoadedAds.b()));
    }

    @NotNull
    public final kr a() {
        return this.f12773a;
    }
}

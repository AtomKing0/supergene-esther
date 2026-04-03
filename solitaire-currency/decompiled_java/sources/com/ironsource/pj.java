package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class pj implements br<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final br<String> f14348a;

    public pj(@NotNull br<String> serverResponse) {
        kotlin.jvm.internal.t.i(serverResponse, "serverResponse");
        this.f14348a = serverResponse;
    }

    @Override // com.ironsource.br
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONObject a() {
        return new JSONObject(this.f14348a.a());
    }
}

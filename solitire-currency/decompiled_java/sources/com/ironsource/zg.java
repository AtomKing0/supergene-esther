package com.ironsource;

import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class zg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ArrayList<String> f16418a = new ArrayList<>(new yg().a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final cd f16419b = new cd();

    @NotNull
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = this.f16419b.a(this.f16418a);
        kotlin.jvm.internal.t.h(jSONObjectA, "mGlobalDataReader.getDataByKeys(mInitKeyList)");
        return jSONObjectA;
    }
}

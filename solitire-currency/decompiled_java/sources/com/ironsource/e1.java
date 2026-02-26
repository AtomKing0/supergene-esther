package com.ironsource;

import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ArrayList<String> f11883a = new ArrayList<>(new d1().a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final cd f11884b = new cd();

    @NotNull
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = this.f11884b.a(this.f11883a);
        kotlin.jvm.internal.t.h(jSONObjectA, "mGlobalDataReader.getDataByKeys(mAdQualityKeyList)");
        return jSONObjectA;
    }
}

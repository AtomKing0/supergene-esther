package com.ironsource;

import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class tb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ArrayList<String> f15394a = new ArrayList<>(new sb().a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final cd f15395b = new cd();

    @NotNull
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = this.f15395b.a(this.f15394a);
        kotlin.jvm.internal.t.h(jSONObjectA, "mGlobalDataReader.getDataByKeys(mEventsKeyList)");
        return jSONObjectA;
    }
}

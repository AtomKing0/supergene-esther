package com.ironsource;

import android.content.Context;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class rt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String[] f14729a = qt.f14599a.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final cd f14730b = new cd();

    @NotNull
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = this.f14730b.a(this.f14729a);
        kotlin.jvm.internal.t.h(jSONObjectA, "mGlobalDataReader.getDataByKeys(mTokenKeyList)");
        return a(jSONObjectA);
    }

    @NotNull
    public final JSONObject a(@NotNull Context context) throws JSONException {
        kotlin.jvm.internal.t.i(context, "context");
        JSONObject jSONObjectA = this.f14730b.a(context, this.f14729a);
        kotlin.jvm.internal.t.h(jSONObjectA, "mGlobalDataReader.getDat…s(context, mTokenKeyList)");
        return a(jSONObjectA);
    }

    private final JSONObject a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectB = dd.b(jSONObject.optJSONObject(ad.f11264s));
        if (jSONObjectB != null) {
            jSONObject.put(ad.f11264s, jSONObjectB);
        }
        return jSONObject;
    }
}

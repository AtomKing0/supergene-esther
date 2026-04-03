package com.ironsource;

import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class xg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ArrayList<String> f16189a = new ArrayList<>(new wg().a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final cd f16190b = new cd();

    @NotNull
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = this.f16190b.a(this.f16189a);
        kotlin.jvm.internal.t.h(jSONObjectA, "mGlobalDataReader.getDat…mInitDeferredDataKeyList)");
        return jSONObjectA;
    }
}

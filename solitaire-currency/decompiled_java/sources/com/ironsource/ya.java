package com.ironsource;

import com.ironsource.mediationsdk.d;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ya implements dl<String, d.a> {
    @Override // com.ironsource.dl
    @NotNull
    public d.a a(@NotNull String input) throws JSONException {
        kotlin.jvm.internal.t.i(input, "input");
        d.a aVarA = com.ironsource.mediationsdk.d.b().a(new JSONObject(input));
        kotlin.jvm.internal.t.h(aVarA, "getInstance().getAuction…sponse(JSONObject(input))");
        return aVarA;
    }
}

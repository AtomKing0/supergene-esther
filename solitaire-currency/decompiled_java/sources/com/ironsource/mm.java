package com.ironsource;

import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class mm implements wr<JSONObject>, ur<km> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<String, a3> f14033a = new LinkedHashMap();

    @Override // com.ironsource.od
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONObject a(@NotNull vr mode) throws JSONException {
        kotlin.jvm.internal.t.i(mode, "mode");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, a3> entry : this.f14033a.entrySet()) {
            String key = entry.getKey();
            JSONArray jSONArrayA = entry.getValue().a(mode);
            if (jSONArrayA.length() > 0) {
                jSONObject.put(key, jSONArrayA);
            }
        }
        return jSONObject;
    }

    @Override // com.ironsource.ur
    public void a(@NotNull km record) {
        kotlin.jvm.internal.t.i(record, "record");
        String strC = record.c();
        Map<String, a3> map = this.f14033a;
        a3 a3Var = map.get(strC);
        if (a3Var == null) {
            a3Var = new a3();
            map.put(strC, a3Var);
        }
        a3Var.a(record.a(new lm()));
    }
}

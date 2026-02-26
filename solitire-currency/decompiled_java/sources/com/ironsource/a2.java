package com.ironsource;

import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a2 implements wr<JSONObject>, ur<y1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<String, mm> f11181a = new LinkedHashMap();

    @Override // com.ironsource.od
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONObject a(@NotNull vr mode) throws JSONException {
        kotlin.jvm.internal.t.i(mode, "mode");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, mm> entry : this.f11181a.entrySet()) {
            String key = entry.getKey();
            JSONObject jSONObjectA = entry.getValue().a(mode);
            if (jSONObjectA.length() > 0) {
                jSONObject.put(p9.r.R0(key, "_", null, 2, null), jSONObjectA);
            }
        }
        return jSONObject;
    }

    @Override // com.ironsource.ur
    public void a(@NotNull y1 record) {
        kotlin.jvm.internal.t.i(record, "record");
        String strD = record.d();
        Map<String, mm> map = this.f11181a;
        mm mmVar = map.get(strD);
        if (mmVar == null) {
            mmVar = new mm();
            map.put(strD, mmVar);
        }
        mmVar.a(record.a(new z1()));
    }
}

package com.ironsource;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class r2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f14624b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final String f14625c = "adUnits";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final JSONObject f14626a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public r2(@NotNull JSONObject configurations) {
        kotlin.jvm.internal.t.i(configurations, "configurations");
        this.f14626a = configurations.optJSONObject(f14625c);
    }

    @NotNull
    public final <T> Map<String, T> a(@NotNull h9.l<? super JSONObject, ? extends T> valueExtractor) throws JSONException {
        kotlin.jvm.internal.t.i(valueExtractor, "valueExtractor");
        JSONObject jSONObject = this.f14626a;
        if (jSONObject == null) {
            return kotlin.collections.r0.g();
        }
        Iterator<String> itKeys = jSONObject.keys();
        kotlin.jvm.internal.t.h(itKeys, "adUnits.keys()");
        o9.g gVarC = o9.m.c(itKeys);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t10 : gVarC) {
            JSONObject jSONObject2 = jSONObject.getJSONObject((String) t10);
            kotlin.jvm.internal.t.h(jSONObject2, "adUnits.getJSONObject(adUnitId)");
            linkedHashMap.put(t10, valueExtractor.invoke(jSONObject2));
        }
        return linkedHashMap;
    }
}

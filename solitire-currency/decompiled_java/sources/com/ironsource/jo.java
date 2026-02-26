package com.ironsource;

import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class jo {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f12764b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final String f12765c = "placements";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final String f12766d = "placementName";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final JSONArray f12767a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public jo(@NotNull JSONObject configuration) {
        kotlin.jvm.internal.t.i(configuration, "configuration");
        this.f12767a = configuration.optJSONArray(f12765c);
    }

    @NotNull
    public final <T> Map<String, T> a(@NotNull h9.l<? super JSONObject, ? extends T> valueExtractor) throws JSONException {
        kotlin.jvm.internal.t.i(valueExtractor, "valueExtractor");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONArray jSONArray = this.f12767a;
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jsonObject = jSONArray.getJSONObject(i10);
                String key = jsonObject.optString(f12766d);
                kotlin.jvm.internal.t.h(jsonObject, "jsonObject");
                T tInvoke = valueExtractor.invoke(jsonObject);
                kotlin.jvm.internal.t.h(key, "key");
                linkedHashMap.put(key, tInvoke);
            }
        }
        return linkedHashMap;
    }
}

package com.ironsource;

import com.unity3d.mediation.LevelPlay;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class po {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<LevelPlay.AdFormat, a> f14372a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final Map<String, b> f14373a;

        public a(@NotNull JSONObject adFormatProviderOrder) throws JSONException {
            kotlin.jvm.internal.t.i(adFormatProviderOrder, "adFormatProviderOrder");
            List<String> listB = hj.b(adFormatProviderOrder.names());
            listB = listB == null ? kotlin.collections.v.l() : listB;
            LinkedHashMap linkedHashMap = new LinkedHashMap(n9.o.e(kotlin.collections.q0.d(kotlin.collections.w.v(listB, 10)), 16));
            for (Object obj : listB) {
                JSONArray jSONArrayOptJSONArray = adFormatProviderOrder.optJSONArray((String) obj);
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                } else {
                    kotlin.jvm.internal.t.h(jSONArrayOptJSONArray, "adFormatProviderOrder.op…(adUnitId) ?: JSONArray()");
                }
                linkedHashMap.put(obj, new b(jSONArrayOptJSONArray));
            }
            this.f14373a = linkedHashMap;
        }

        @NotNull
        public final Map<String, b> a() {
            return this.f14373a;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final List<String> f14374a;

        public b(@NotNull JSONArray providerOrder) throws JSONException {
            kotlin.jvm.internal.t.i(providerOrder, "providerOrder");
            List<String> listB = hj.b(providerOrder);
            kotlin.jvm.internal.t.h(listB, "jsonArrayToStringList(providerOrder)");
            this.f14374a = listB;
        }

        @NotNull
        public final List<String> a() {
            return this.f14374a;
        }
    }

    public po(@NotNull JSONObject providerOrder) {
        kotlin.jvm.internal.t.i(providerOrder, "providerOrder");
        LevelPlay.AdFormat[] adFormatArrValues = LevelPlay.AdFormat.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(n9.o.e(kotlin.collections.q0.d(adFormatArrValues.length), 16));
        for (LevelPlay.AdFormat adFormat : adFormatArrValues) {
            JSONObject jSONObjectOptJSONObject = providerOrder.optJSONObject(ks.a(adFormat));
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            } else {
                kotlin.jvm.internal.t.h(jSONObjectOptJSONObject, "providerOrder.optJSONObj…dFormat)) ?: JSONObject()");
            }
            linkedHashMap.put(adFormat, new a(jSONObjectOptJSONObject));
        }
        this.f14372a = linkedHashMap;
    }

    @NotNull
    public final Map<LevelPlay.AdFormat, a> a() {
        return this.f14372a;
    }
}

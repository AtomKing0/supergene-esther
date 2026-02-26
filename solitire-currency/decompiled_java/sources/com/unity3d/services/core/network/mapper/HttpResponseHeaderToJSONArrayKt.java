package com.unity3d.services.core.network.mapper;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

/* JADX INFO: compiled from: HttpResponseHeaderToJSONArray.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class HttpResponseHeaderToJSONArrayKt {
    @NotNull
    public static final JSONArray toResponseHeadersMap(@Nullable Map<String, ? extends List<String>> map) {
        Set<Map.Entry<String, ? extends List<String>>> setEntrySet;
        if (map != null && (setEntrySet = map.entrySet()) != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it = setEntrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                jSONArray = jSONArray.put(new JSONArray((Collection) v.n((String) entry.getKey(), (List) entry.getValue())));
                t.h(jSONArray, "acc.put(JSONArray(listOf(key, value)))");
            }
            if (jSONArray != null) {
                return jSONArray;
            }
        }
        return new JSONArray();
    }
}

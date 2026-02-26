package com.braze.support;

import android.os.Bundle;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;

/* JADX INFO: loaded from: classes2.dex */
public final class BundleUtils {
    public static final Bundle toBundle(Map<String, String> map) {
        t.i(map, "<this>");
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    public static final Map<String, String> toStringMap(Bundle bundle) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (bundle == null) {
            return linkedHashMap;
        }
        Set<String> setKeySet = bundle.keySet();
        t.h(setKeySet, "this.keySet()");
        for (String str : setKeySet) {
            try {
                Object obj = bundle.get(str);
                if (obj != null && (obj instanceof String)) {
                    linkedHashMap.put(str, obj);
                }
            } catch (Exception unused) {
            }
        }
        Map<String, String> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        t.h(mapUnmodifiableMap, "unmodifiableMap(mapForm)");
        return mapUnmodifiableMap;
    }
}

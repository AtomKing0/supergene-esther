package com.unity3d.ads.core.extensions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.l0;
import kotlin.collections.w;
import kotlin.jvm.internal.t;
import n9.i;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: JSONArrayExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JSONArrayExtensionsKt {
    @NotNull
    public static final Map<String, List<String>> getHeadersMap(@NotNull JSONArray jSONArray) throws JSONException {
        t.i(jSONArray, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            Object obj = jSONArray.get(i10);
            t.g(obj, "null cannot be cast to non-null type org.json.JSONArray");
            JSONArray jSONArray2 = (JSONArray) obj;
            List arrayList = (List) linkedHashMap.get(jSONArray2.getString(0));
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            String string = jSONArray2.getString(1);
            t.h(string, "header.getString(1)");
            arrayList.add(string);
            String string2 = jSONArray2.getString(0);
            t.h(string2, "header.getString(0)");
            linkedHashMap.put(string2, arrayList);
        }
        return linkedHashMap;
    }

    @NotNull
    public static final Object[] toTypedArray(@NotNull JSONArray jSONArray) {
        t.i(jSONArray, "<this>");
        i iVarU = o.u(0, jSONArray.length());
        ArrayList arrayList = new ArrayList(w.v(iVarU, 10));
        Iterator<Integer> it = iVarU.iterator();
        while (it.hasNext()) {
            arrayList.add(jSONArray.get(((l0) it).nextInt()));
        }
        return arrayList.toArray(new Object[0]);
    }
}

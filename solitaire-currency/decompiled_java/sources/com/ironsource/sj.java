package com.ironsource;

import java.util.Collection;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class sj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f15315a = 100;

    private static final boolean a(Object obj, Object obj2, int i10) {
        return ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) ? a((JSONObject) obj, (JSONObject) obj2, i10 + 1) : ((obj instanceof JSONArray) && (obj2 instanceof JSONArray)) ? a((JSONArray) obj, (JSONArray) obj2, i10 + 1) : ((obj instanceof Number) && (obj2 instanceof Number)) ? ((Number) obj).doubleValue() == ((Number) obj2).doubleValue() : kotlin.jvm.internal.t.d(obj, obj2);
    }

    public static final boolean a(@NotNull JSONArray lhs, @NotNull JSONArray rhs) {
        kotlin.jvm.internal.t.i(lhs, "lhs");
        kotlin.jvm.internal.t.i(rhs, "rhs");
        return a(lhs, rhs, 0);
    }

    private static final boolean a(JSONArray jSONArray, JSONArray jSONArray2, int i10) {
        if (jSONArray == jSONArray2) {
            return true;
        }
        if (jSONArray.length() != jSONArray2.length() || i10 > 100) {
            return false;
        }
        Iterable iterableU = n9.o.u(0, jSONArray.length());
        if (!(iterableU instanceof Collection) || !((Collection) iterableU).isEmpty()) {
            Iterator it = iterableU.iterator();
            while (it.hasNext()) {
                int iNextInt = ((kotlin.collections.l0) it).nextInt();
                if (!a(jSONArray.get(iNextInt), jSONArray2.get(iNextInt), i10)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static final boolean a(@NotNull JSONObject lhs, @NotNull JSONObject rhs) {
        kotlin.jvm.internal.t.i(lhs, "lhs");
        kotlin.jvm.internal.t.i(rhs, "rhs");
        return a(lhs, rhs, 0);
    }

    private static final boolean a(JSONObject jSONObject, JSONObject jSONObject2, int i10) {
        if (jSONObject == jSONObject2) {
            return true;
        }
        if (jSONObject.length() != jSONObject2.length() || i10 > 100) {
            return false;
        }
        Iterator<String> itKeys = jSONObject.keys();
        kotlin.jvm.internal.t.h(itKeys, "lhs.keys()");
        for (String str : o9.m.c(itKeys)) {
            if (!(jSONObject2.has(str) && a(jSONObject.get(str), jSONObject2.get(str), i10))) {
                return false;
            }
        }
        return true;
    }
}

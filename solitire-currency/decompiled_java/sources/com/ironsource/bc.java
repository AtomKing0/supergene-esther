package com.ironsource;

import android.os.Bundle;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class bc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bc f11389a = new bc();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final String f11390b = "ext_";

    private bc() {
    }

    @NotNull
    public final Map<String, String> a(@Nullable Bundle bundle) {
        Set<String> setKeySet = bundle != null ? bundle.keySet() : null;
        if (setKeySet == null) {
            return kotlin.collections.r0.g();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(n9.o.e(kotlin.collections.q0.d(kotlin.collections.w.v(setKeySet, 10)), 16));
        for (String str : setKeySet) {
            String str2 = f11390b + str;
            Object obj = bundle.get(str);
            v8.s sVarA = v8.y.a(str2, obj instanceof Iterable ? kotlin.collections.d0.r0((Iterable) obj, ", ", null, null, 0, null, null, 62, null) : obj == null ? null : obj.toString());
            linkedHashMap.put(sVarA.c(), sVarA.d());
        }
        return linkedHashMap;
    }
}

package com.unity3d.ads.core.extensions;

import com.unity3d.services.store.JsonSerializable;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

/* JADX INFO: compiled from: JsonSerializableExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JsonSerializableExtensionsKt {
    @NotNull
    public static final JSONArray toJsonArray(@NotNull List<? extends JsonSerializable> list) {
        t.i(list, "<this>");
        JSONArray jSONArray = new JSONArray();
        Iterator<? extends JsonSerializable> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toJson());
        }
        return jSONArray;
    }
}

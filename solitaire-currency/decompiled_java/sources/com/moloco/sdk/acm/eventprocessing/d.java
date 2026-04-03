package com.moloco.sdk.acm.eventprocessing;

import android.util.Log;
import androidx.work.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.s;
import v8.y;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    @Nullable
    public static final Data a(@NotNull Map<String, ? extends Object> map) throws Throwable {
        t.i(map, "<this>");
        try {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                arrayList.add(y.a(entry.getKey(), entry.getValue()));
            }
            s[] sVarArr = (s[]) arrayList.toArray(new s[0]);
            s[] sVarArr2 = (s[]) Arrays.copyOf(sVarArr, sVarArr.length);
            Data.Builder builder = new Data.Builder();
            for (s sVar : sVarArr2) {
                builder.put((String) sVar.c(), sVar.d());
            }
            Data dataBuild = builder.build();
            t.h(dataBuild, "dataBuilder.build()");
            return dataBuild;
        } catch (Exception e10) {
            Log.e("DBPeriodicRequest", e10.getMessage() + ". Data: " + map);
            return null;
        }
    }
}

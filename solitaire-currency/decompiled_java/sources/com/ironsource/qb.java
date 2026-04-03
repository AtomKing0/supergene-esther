package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class qb implements w1 {
    @NotNull
    public final Map<String, Object> a(@NotNull b1 adProperties) {
        kotlin.jvm.internal.t.i(adProperties, "adProperties");
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
        String string = adProperties.a().toString();
        kotlin.jvm.internal.t.h(string, "adProperties.adFormat.toString()");
        map.put(bk.f11421f, string);
        map.put("adf", Integer.valueOf(ks.b(adProperties.a())));
        map.put(bk.f11424i, adProperties.d().b());
        map.put("mediationAdUnitId", adProperties.b());
        map.put("isMultipleAdUnits", 1);
        return map;
    }
}

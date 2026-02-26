package com.ironsource;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class ho implements w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f12507a;

    public ho(@NotNull String placementName) {
        kotlin.jvm.internal.t.i(placementName, "placementName");
        this.f12507a = placementName;
    }

    @Override // com.ironsource.w1
    @NotNull
    public Map<String, Object> a(@Nullable u1 u1Var) {
        HashMap map = new HashMap();
        map.put("placement", this.f12507a);
        return map;
    }
}

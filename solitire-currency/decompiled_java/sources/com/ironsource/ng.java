package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface ng {

    public interface a {
        void a(@NotNull mr mrVar);
    }

    int a(@NotNull IronSource.AD_UNIT ad_unit);

    @NotNull
    List<String> a();

    @NotNull
    Map<String, JSONObject> a(@NotNull jr jrVar);

    @NotNull
    JSONObject a(@NotNull vr vrVar);
}

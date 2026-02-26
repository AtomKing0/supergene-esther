package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.IronSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface AdapterNetworkData {
    @NotNull
    JSONObject allData();

    @Nullable
    <T> T dataByKeyIgnoreCase(@NotNull String str, @NotNull Class<T> cls);

    @NotNull
    JSONObject networkDataByAdUnit(@NotNull IronSource.AD_UNIT ad_unit);
}

package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.IronSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface ReleaseMemoryAdapterInterface {
    void releaseMemory(@NotNull IronSource.AD_UNIT ad_unit, @Nullable JSONObject jSONObject);
}

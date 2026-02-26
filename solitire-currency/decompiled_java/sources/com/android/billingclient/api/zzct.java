package com.android.billingclient.api;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzct {
    private final String zza;

    @Nullable
    private final String zzb;

    zzct(JSONObject jSONObject) throws JSONException {
        this.zza = jSONObject.getString("rentalPeriod");
        String strOptString = jSONObject.optString("rentalExpirationPeriod");
        this.zzb = true == strOptString.isEmpty() ? null : strOptString;
    }
}

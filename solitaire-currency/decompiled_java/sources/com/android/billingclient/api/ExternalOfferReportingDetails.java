package com.android.billingclient.api;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes2.dex */
@zzh
public final class ExternalOfferReportingDetails {
    private final String externalTransactionToken;

    ExternalOfferReportingDetails(String str) throws JSONException {
        this.externalTransactionToken = new JSONObject(str).optString("externalTransactionToken");
    }

    @NonNull
    public String getExternalTransactionToken() {
        return this.externalTransactionToken;
    }
}

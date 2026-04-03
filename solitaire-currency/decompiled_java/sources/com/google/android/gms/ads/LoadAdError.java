package com.google.android.gms.ads;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class LoadAdError extends AdError {

    @Nullable
    private final ResponseInfo zza;

    public LoadAdError(int i10, @NonNull String str, @NonNull String str2, @Nullable AdError adError, @Nullable ResponseInfo responseInfo) {
        super(i10, str, str2, adError);
        this.zza = responseInfo;
    }

    @Nullable
    public ResponseInfo getResponseInfo() {
        return this.zza;
    }

    @Override // com.google.android.gms.ads.AdError
    @NonNull
    public String toString() {
        try {
            return zzb().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    @Override // com.google.android.gms.ads.AdError
    @NonNull
    public final JSONObject zzb() throws JSONException {
        JSONObject jSONObjectZzb = super.zzb();
        ResponseInfo responseInfo = getResponseInfo();
        if (responseInfo == null) {
            jSONObjectZzb.put("Response Info", "null");
        } else {
            jSONObjectZzb.put("Response Info", responseInfo.zzd());
        }
        return jSONObjectZzb;
    }
}

package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import androidx.annotation.Nullable;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfeq {

    @Nullable
    public final String zza;

    @Nullable
    public final String zzb;
    public final JSONObject zzc;
    public final JSONObject zzd;

    zzfeq(JsonReader jsonReader) throws IllegalStateException, JSONException, IOException, NumberFormatException {
        JSONObject jSONObjectZzi = com.google.android.gms.ads.internal.util.zzbs.zzi(jsonReader);
        this.zzd = jSONObjectZzi;
        this.zza = jSONObjectZzi.optString("ad_html", null);
        this.zzb = jSONObjectZzi.optString("ad_base_url", null);
        this.zzc = jSONObjectZzi.optJSONObject("ad_json");
    }
}

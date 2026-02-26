package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.util.concurrent.m;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzebq {
    private final zzbuv zza;

    zzebq(zzbuv zzbuvVar) {
        this.zza = zzbuvVar;
    }

    public static void zza(Map map, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("pii");
        if (jSONObjectOptJSONObject == null) {
            com.google.android.gms.ads.internal.util.zze.zza("DSID signal does not exist.");
            return;
        }
        if (!TextUtils.isEmpty(jSONObjectOptJSONObject.optString("doritos", ""))) {
            map.put("x-afma-drt-cookie", jSONObjectOptJSONObject.optString("doritos", ""));
        }
        if (TextUtils.isEmpty(jSONObjectOptJSONObject.optString("doritos_v2", ""))) {
            return;
        }
        map.put("x-afma-drt-v2-cookie", jSONObjectOptJSONObject.optString("doritos_v2", ""));
    }

    public final void zzb() {
        m mVarZza = this.zza.zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgT)).booleanValue()) {
            zzbzr.zzb(mVarZza, "persistFlags");
        } else {
            zzbzr.zza(mVarZza, "persistFlags");
        }
    }
}

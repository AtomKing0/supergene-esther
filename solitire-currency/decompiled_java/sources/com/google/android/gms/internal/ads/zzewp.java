package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzewp implements zzevn {

    @Nullable
    private final AdvertisingIdClient.Info zza;

    @Nullable
    private final String zzb;
    private final zzfry zzc;

    public zzewp(@Nullable AdvertisingIdClient.Info info, @Nullable String str, zzfry zzfryVar) {
        this.zza = info;
        this.zzb = str;
        this.zzc = zzfryVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        try {
            JSONObject jSONObjectZzg = com.google.android.gms.ads.internal.util.zzbs.zzg((JSONObject) obj, "pii");
            AdvertisingIdClient.Info info = this.zza;
            if (info == null || TextUtils.isEmpty(info.getId())) {
                String str = this.zzb;
                if (str != null) {
                    jSONObjectZzg.put("pdid", str);
                    jSONObjectZzg.put("pdidtype", "ssaid");
                    return;
                }
                return;
            }
            jSONObjectZzg.put("rdid", this.zza.getId());
            jSONObjectZzg.put("is_lat", this.zza.isLimitAdTrackingEnabled());
            jSONObjectZzg.put("idtype", "adid");
            zzfry zzfryVar = this.zzc;
            if (zzfryVar.zzc()) {
                jSONObjectZzg.put("paidv1_id_android_3p", zzfryVar.zzb());
                jSONObjectZzg.put("paidv1_creation_time_android_3p", this.zzc.zza());
            }
        } catch (JSONException e10) {
            com.google.android.gms.ads.internal.util.zze.zzb("Failed putting Ad ID.", e10);
        }
    }
}

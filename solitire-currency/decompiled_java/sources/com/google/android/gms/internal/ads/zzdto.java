package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdto {

    @Nullable
    private Long zza;
    private final String zzb;

    @Nullable
    private String zzc;

    @Nullable
    private Integer zzd;

    @Nullable
    private String zze;

    @Nullable
    private Integer zzf;

    /* synthetic */ zzdto(String str, zzdtn zzdtnVar) {
        this.zzb = str;
    }

    static /* bridge */ /* synthetic */ String zza(zzdto zzdtoVar) {
        String str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjd);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("objectId", zzdtoVar.zza);
            jSONObject.put("eventCategory", zzdtoVar.zzb);
            jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, zzdtoVar.zzc);
            jSONObject.putOpt(IronSourceConstants.EVENTS_ERROR_CODE, zzdtoVar.zzd);
            jSONObject.putOpt("rewardType", zzdtoVar.zze);
            jSONObject.putOpt(IronSourceConstants.EVENTS_REWARD_AMOUNT, zzdtoVar.zzf);
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Could not convert parameters to JSON.");
        }
        return str + "(\"h5adsEvent\"," + jSONObject.toString() + ");";
    }
}

package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeaw implements zzbnh {
    zzeaw() {
    }

    @Override // com.google.android.gms.internal.ads.zzbnh
    public final /* bridge */ /* synthetic */ JSONObject zzb(Object obj) throws JSONException {
        zzeax zzeaxVar = (zzeax) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzit)).booleanValue()) {
            jSONObject2.put("ad_request_url", zzeaxVar.zzd.zzg());
            jSONObject2.put("ad_request_post_body", zzeaxVar.zzd.zzf());
        }
        jSONObject2.put("base_url", zzeaxVar.zzd.zzd());
        jSONObject2.put("signals", zzeaxVar.zzc);
        jSONObject3.put("body", zzeaxVar.zzb.zzc);
        jSONObject3.put("headers", com.google.android.gms.ads.internal.client.zzay.zzb().zzj(zzeaxVar.zzb.zzb));
        jSONObject3.put("response_code", zzeaxVar.zzb.zza);
        jSONObject3.put("latency", zzeaxVar.zzb.zzd);
        jSONObject.put(com.vungle.ads.internal.ui.a.REQUEST_KEY_EXTRA, jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzeaxVar.zzd.zzi());
        return jSONObject;
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbcw extends QueryInfoGenerationCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbcx zzb;

    zzbcw(zzbcx zzbcxVar, String str) {
        this.zza = str;
        this.zzb = zzbcxVar;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        com.google.android.gms.ads.internal.util.client.zzm.zzj("Failed to generate query info for Custom Tab error: ".concat(String.valueOf(str)));
        try {
            zzbcx zzbcxVar = this.zzb;
            zzbcxVar.zze.postMessage(zzbcxVar.zzc(this.zza, str).toString(), null);
        } catch (JSONException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Error creating PACT Error Response JSON: ", e10);
        }
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        String query = queryInfo.getQuery();
        try {
            zzbcx zzbcxVar = this.zzb;
            zzbcxVar.zze.postMessage(zzbcxVar.zzd(this.zza, query).toString(), null);
        } catch (JSONException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Error creating PACT Signal Response JSON: ", e10);
        }
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeya implements zzevo {
    private final JSONObject zza;

    zzeya(Context context) {
        this.zza = zzbux.zzc(context, VersionInfoParcel.forPackage());
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 46;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkX)).booleanValue() ? zzgcj.zzh(new zzevn() { // from class: com.google.android.gms.internal.ads.zzexy
            @Override // com.google.android.gms.internal.ads.zzevn
            public final void zzj(Object obj) {
            }
        }) : zzgcj.zzh(new zzevn() { // from class: com.google.android.gms.internal.ads.zzexz
            @Override // com.google.android.gms.internal.ads.zzevn
            public final void zzj(Object obj) {
                this.zza.zzc((JSONObject) obj);
            }
        });
    }

    final /* synthetic */ void zzc(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.zza);
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed putting version constants.");
        }
    }
}

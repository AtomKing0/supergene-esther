package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.google.common.util.concurrent.m;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdzs {
    private final zzgcu zza;
    private final zzdzn zzb;
    private final zzfjl zzc;

    zzdzs(zzgcu zzgcuVar, zzdzn zzdznVar, zzfjl zzfjlVar) {
        this.zza = zzgcuVar;
        this.zzb = zzdznVar;
        this.zzc = zzfjlVar;
    }

    public final m zza(final zzbvb zzbvbVar) {
        zzfjc zzfjcVarZzb = this.zzc.zzb(zzfjf.GMS_SIGNALS, zzgcj.zzm(zzgcj.zzh(null), new zzful() { // from class: com.google.android.gms.internal.ads.zzdzp
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                zzbvb zzbvbVar2 = zzbvbVar;
                String strZzc = zzfvj.zzc(zzbvbVar2.zza.getString("ms"));
                ApplicationInfo applicationInfo = zzbvbVar2.zzc;
                String str = zzbvbVar2.zzh;
                return new zzbuc(applicationInfo, zzbvbVar2.zzd, zzbvbVar2.zzf, strZzc, -1, str, zzbvbVar2.zze, zzbvbVar2.zzk, zzbvbVar2.zzl);
            }
        }, this.zza));
        final zzdzn zzdznVar = this.zzb;
        Objects.requireNonNull(zzdznVar);
        return zzgcj.zzm(zzfjcVarZzb.zzf(new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdzq
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return zzdznVar.zzb((zzbuc) obj);
            }
        }).zza(), new zzful(this) { // from class: com.google.android.gms.internal.ads.zzdzr
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                Bundle bundle = zzbvbVar.zza;
                if (bundle == null) {
                    return jSONObject;
                }
                try {
                    JSONObject jSONObjectZzi = com.google.android.gms.ads.internal.client.zzay.zzb().zzi(bundle);
                    try {
                        com.google.android.gms.ads.internal.client.zzay.zzb().zzl(jSONObject, jSONObjectZzi);
                        return jSONObject;
                    } catch (JSONException unused) {
                        return jSONObjectZzi;
                    }
                } catch (JSONException unused2) {
                    return jSONObject;
                }
            }
        }, this.zza);
    }
}

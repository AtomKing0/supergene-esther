package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzejy implements zzeev {
    private final zzelc zza;
    private final zzdqb zzb;

    zzejy(zzelc zzelcVar, zzdqb zzdqbVar) {
        this.zza = zzelcVar;
        this.zzb = zzdqbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeev
    @Nullable
    public final zzeew zza(String str, JSONObject jSONObject) throws zzffn {
        zzbql zzbqlVarZzb;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbu)).booleanValue()) {
            try {
                zzbqlVarZzb = this.zzb.zzb(str);
            } catch (RemoteException e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("Coundn't create RTB adapter: ", e10);
                zzbqlVarZzb = null;
            }
        } else {
            zzbqlVarZzb = this.zza.zza(str);
        }
        if (zzbqlVarZzb == null) {
            return null;
        }
        return new zzeew(zzbqlVarZzb, new zzegp(), str);
    }
}

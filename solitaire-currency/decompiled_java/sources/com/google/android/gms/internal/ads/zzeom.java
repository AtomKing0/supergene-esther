package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.m;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeom implements zzevo {
    private final zzgcu zza;
    private final zzdqb zzb;
    private final zzdun zzc;
    private final zzeoo zzd;

    public zzeom(zzgcu zzgcuVar, zzdqb zzdqbVar, zzdun zzdunVar, zzeoo zzeooVar) {
        this.zza = zzgcuVar;
        this.zzb = zzdqbVar;
        this.zzc = zzdunVar;
        this.zzd = zzeooVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        zzbbn zzbbnVar = zzbbw.zzkL;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar)).booleanValue() && this.zzd.zza() != null) {
            zzeon zzeonVarZza = this.zzd.zza();
            zzeonVarZza.getClass();
            return zzgcj.zzh(zzeonVarZza);
        }
        if (zzfvj.zzd((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbh)) || (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar)).booleanValue() && (this.zzd.zzd() || !this.zzc.zzt()))) {
            return zzgcj.zzh(new zzeon(new Bundle()));
        }
        this.zzd.zzc(true);
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeol
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    final /* synthetic */ zzeon zzc() throws Exception {
        List<String> listAsList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbh)).split(";"));
        Bundle bundle = new Bundle();
        for (String str : listAsList) {
            try {
                zzfge zzfgeVarZzc = this.zzb.zzc(str, new JSONObject());
                zzfgeVarZzc.zzC();
                boolean zZzt = this.zzc.zzt();
                Bundle bundle2 = new Bundle();
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkL)).booleanValue() || zZzt) {
                    try {
                        zzbra zzbraVarZzf = zzfgeVarZzc.zzf();
                        if (zzbraVarZzf != null) {
                            bundle2.putString("sdk_version", zzbraVarZzf.toString());
                        }
                    } catch (zzffn unused) {
                    }
                }
                try {
                    zzbra zzbraVarZze = zzfgeVarZzc.zze();
                    if (zzbraVarZze != null) {
                        bundle2.putString("adapter_version", zzbraVarZze.toString());
                    }
                } catch (zzffn unused2) {
                }
                bundle.putBundle(str, bundle2);
            } catch (zzffn unused3) {
            }
        }
        zzeon zzeonVar = new zzeon(bundle);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkL)).booleanValue()) {
            this.zzd.zzb(zzeonVar);
        }
        return zzeonVar;
    }
}

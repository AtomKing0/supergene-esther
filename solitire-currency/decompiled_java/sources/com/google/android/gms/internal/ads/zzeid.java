package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeid extends zzeic {
    private final zzcgj zza;
    private final zzcvy zzb;
    private final zzdck zzc;
    private final zzein zzd;
    private final zzeey zze;

    zzeid(zzcgj zzcgjVar, zzcvy zzcvyVar, zzdck zzdckVar, zzein zzeinVar, zzeey zzeeyVar) {
        this.zza = zzcgjVar;
        this.zzb = zzcvyVar;
        this.zzc = zzdckVar;
        this.zzd = zzeinVar;
        this.zze = zzeeyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeic
    protected final m zzc(zzffg zzffgVar, Bundle bundle, zzfel zzfelVar, zzfex zzfexVar) {
        zzcvy zzcvyVar = this.zzb;
        zzcvyVar.zzi(zzffgVar);
        zzcvyVar.zzf(bundle);
        zzcvyVar.zzg(new zzcvs(zzfexVar, zzfelVar, this.zzd));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdi)).booleanValue()) {
            this.zzb.zzd(this.zze);
        }
        zzcgj zzcgjVar = this.zza;
        zzcvy zzcvyVar2 = this.zzb;
        zzcox zzcoxVarZzd = zzcgjVar.zzd();
        zzcoxVarZzd.zzd(zzcvyVar2.zzj());
        zzcoxVarZzd.zzc(this.zzc);
        zzctc zzctcVarZzb = zzcoxVarZzd.zze().zzb();
        return zzctcVarZzb.zzi(zzctcVarZzb.zzj());
    }
}

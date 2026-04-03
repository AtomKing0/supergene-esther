package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeia extends zzeic {
    private final zzcgj zza;
    private final zzdhg zzb;
    private final zzcvy zzc;
    private final zzdck zzd;
    private final zzein zze;
    private final zzeey zzf;

    public zzeia(zzcgj zzcgjVar, zzdhg zzdhgVar, zzcvy zzcvyVar, zzdck zzdckVar, zzein zzeinVar, zzeey zzeeyVar) {
        this.zza = zzcgjVar;
        this.zzb = zzdhgVar;
        this.zzc = zzcvyVar;
        this.zzd = zzdckVar;
        this.zze = zzeinVar;
        this.zzf = zzeeyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeic
    protected final m zzc(zzffg zzffgVar, Bundle bundle, zzfel zzfelVar, zzfex zzfexVar) {
        zzcvy zzcvyVar = this.zzc;
        zzcvyVar.zzi(zzffgVar);
        zzcvyVar.zzf(bundle);
        zzcvyVar.zzg(new zzcvs(zzfexVar, zzfelVar, this.zze));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdi)).booleanValue()) {
            this.zzc.zzd(this.zzf);
        }
        zzcgj zzcgjVar = this.zza;
        zzcvy zzcvyVar2 = this.zzc;
        zzdhk zzdhkVarZzh = zzcgjVar.zzh();
        zzdhkVarZzh.zzf(zzcvyVar2.zzj());
        zzdhkVarZzh.zze(this.zzd);
        zzdhkVarZzh.zzd(this.zzb);
        zzdhkVarZzh.zzc(new zzcph(null));
        zzctc zzctcVarZza = zzdhkVarZzh.zzg().zza();
        return zzctcVarZza.zzi(zzctcVarZza.zzj());
    }
}

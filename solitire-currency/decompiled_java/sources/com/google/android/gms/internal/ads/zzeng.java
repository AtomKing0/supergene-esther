package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeng implements zzgcf {
    final /* synthetic */ zzemz zza;
    final /* synthetic */ zzfkf zzb;
    final /* synthetic */ zzfju zzc;
    final /* synthetic */ zzdhl zzd;
    final /* synthetic */ zzenh zze;

    zzeng(zzenh zzenhVar, zzemz zzemzVar, zzfkf zzfkfVar, zzfju zzfjuVar, zzdhl zzdhlVar) {
        this.zza = zzemzVar;
        this.zzb = zzfkfVar;
        this.zzc = zzfjuVar;
        this.zzd = zzdhlVar;
        this.zze = zzenhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        zzfkf zzfkfVar;
        final com.google.android.gms.ads.internal.client.zze zzeVarZza = this.zzd.zza().zza(th);
        this.zzd.zzb().zzdB(zzeVarZza);
        this.zze.zzb.zzB().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzenf
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zze.zzd.zza().zzdB(zzeVarZza);
            }
        });
        zzfgd.zzb(zzeVarZza.zza, th, "NativeAdLoader.onFailure");
        this.zza.zza();
        if (((Boolean) zzbdl.zzc.zze()).booleanValue() && (zzfkfVar = this.zzb) != null) {
            zzfkfVar.zzc(zzeVarZza);
            zzfju zzfjuVar = this.zzc;
            zzfjuVar.zzh(th);
            zzfjuVar.zzg(false);
            zzfkfVar.zza(zzfjuVar);
            zzfkfVar.zzh();
            return;
        }
        zzenh zzenhVar = this.zze;
        zzfju zzfjuVar2 = this.zzc;
        zzfki zzfkiVar = zzenhVar.zze;
        zzfjuVar2.zza(zzeVarZza);
        zzfjuVar2.zzh(th);
        zzfjuVar2.zzg(false);
        zzfkiVar.zzb(zzfjuVar2.zzm());
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfkf zzfkfVar;
        zzcru zzcruVar = (zzcru) obj;
        synchronized (this.zze) {
            zzcruVar.zzo().zza(this.zze.zzd.zzd());
            this.zza.zzb(zzcruVar);
            this.zze.zzb.zzB().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzene
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zze.zzd.zzb().zzs();
                }
            });
            if (!((Boolean) zzbdl.zzc.zze()).booleanValue() || (zzfkfVar = this.zzb) == null) {
                zzfki zzfkiVar = this.zze.zze;
                zzfju zzfjuVar = this.zzc;
                zzfjuVar.zzb(zzcruVar.zzq().zzb);
                zzfjuVar.zzd(zzcruVar.zzm().zzg());
                zzfjuVar.zzg(true);
                zzfkiVar.zzb(zzfjuVar.zzm());
            } else {
                zzfkfVar.zzg(zzcruVar.zzq().zzb);
                zzfkfVar.zze(zzcruVar.zzm().zzg());
                zzfju zzfjuVar2 = this.zzc;
                zzfjuVar2.zzg(true);
                zzfkfVar.zza(zzfjuVar2);
                zzfkfVar.zzh();
            }
        }
    }
}

package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfcn implements zzgcf {
    final /* synthetic */ zzemz zza;
    final /* synthetic */ zzfkf zzb;
    final /* synthetic */ zzfju zzc;
    final /* synthetic */ zzdgp zzd;
    final /* synthetic */ zzfco zze;

    zzfcn(zzfco zzfcoVar, zzemz zzemzVar, zzfkf zzfkfVar, zzfju zzfjuVar, zzdgp zzdgpVar) {
        this.zza = zzemzVar;
        this.zzb = zzfkfVar;
        this.zzc = zzfjuVar;
        this.zzd = zzdgpVar;
        this.zze = zzfcoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        zzfkf zzfkfVar;
        final com.google.android.gms.ads.internal.client.zze zzeVarZza = this.zzd.zza().zza(th);
        synchronized (this.zze) {
            this.zze.zzi = null;
            this.zzd.zzb().zzdB(zzeVarZza);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhr)).booleanValue()) {
                this.zze.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfcj
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zze.zzd.zzdB(zzeVarZza);
                    }
                });
                this.zze.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfck
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zze.zze.zzdB(zzeVarZza);
                    }
                });
            }
            zzfgd.zzb(zzeVarZza.zza, th, "InterstitialAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbdl.zzc.zze()).booleanValue() || (zzfkfVar = this.zzb) == null) {
                zzfki zzfkiVar = this.zze.zzg;
                zzfju zzfjuVar = this.zzc;
                zzfjuVar.zza(zzeVarZza);
                zzfjuVar.zzh(th);
                zzfjuVar.zzg(false);
                zzfkiVar.zzb(zzfjuVar.zzm());
            } else {
                zzfkfVar.zzc(zzeVarZza);
                zzfju zzfjuVar2 = this.zzc;
                zzfjuVar2.zzh(th);
                zzfjuVar2.zzg(false);
                zzfkfVar.zza(zzfjuVar2);
                zzfkfVar.zzh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfkf zzfkfVar;
        zzdfo zzdfoVar = (zzdfo) obj;
        synchronized (this.zze) {
            this.zze.zzi = null;
            zzbbn zzbbnVar = zzbbw.zzhr;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar)).booleanValue()) {
                zzday zzdayVarZzo = zzdfoVar.zzo();
                zzdayVarZzo.zza(this.zze.zzd);
                zzdayVarZzo.zzd(this.zze.zze);
            }
            this.zza.zzb(zzdfoVar);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar)).booleanValue()) {
                this.zze.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfcl
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zze.zzd.zzs();
                    }
                });
                this.zze.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfcm
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zze.zze.zzs();
                    }
                });
            }
            if (!((Boolean) zzbdl.zzc.zze()).booleanValue() || (zzfkfVar = this.zzb) == null) {
                zzfki zzfkiVar = this.zze.zzg;
                zzfju zzfjuVar = this.zzc;
                zzfjuVar.zzb(zzdfoVar.zzq().zzb);
                zzfjuVar.zzd(zzdfoVar.zzm().zzg());
                zzfjuVar.zzg(true);
                zzfkiVar.zzb(zzfjuVar.zzm());
            } else {
                zzfkfVar.zzg(zzdfoVar.zzq().zzb);
                zzfkfVar.zze(zzdfoVar.zzm().zzg());
                zzfju zzfjuVar2 = this.zzc;
                zzfjuVar2.zzg(true);
                zzfkfVar.zza(zzfjuVar2);
                zzfkfVar.zzh();
            }
        }
    }
}

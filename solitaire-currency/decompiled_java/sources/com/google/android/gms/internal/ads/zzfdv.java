package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfdv implements zzgcf {
    final /* synthetic */ zzemz zza;
    final /* synthetic */ zzfkf zzb;
    final /* synthetic */ zzfju zzc;
    final /* synthetic */ zzfdx zzd;
    final /* synthetic */ zzfdy zze;

    zzfdv(zzfdy zzfdyVar, zzemz zzemzVar, zzfkf zzfkfVar, zzfju zzfjuVar, zzfdx zzfdxVar) {
        this.zza = zzemzVar;
        this.zzb = zzfkfVar;
        this.zzc = zzfjuVar;
        this.zzd = zzfdxVar;
        this.zze = zzfdyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        zzfkf zzfkfVar;
        zzdou zzdouVar = (zzdou) this.zze.zze.zzd();
        final com.google.android.gms.ads.internal.client.zze zzeVarZzb = zzdouVar == null ? zzfgi.zzb(th, null) : zzdouVar.zzb().zza(th);
        synchronized (this.zze) {
            if (zzdouVar != null) {
                zzdouVar.zza().zzdB(zzeVarZzb);
                this.zze.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfdt
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zze.zzd.zzdB(zzeVarZzb);
                    }
                });
            } else {
                this.zze.zzd.zzdB(zzeVarZzb);
                this.zze.zzk(this.zzd).zzh().zzb().zzc().zzh();
            }
            zzfgd.zzb(zzeVarZzb.zza, th, "RewardedAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbdl.zzc.zze()).booleanValue() || (zzfkfVar = this.zzb) == null) {
                zzfki zzfkiVar = this.zze.zzg;
                zzfju zzfjuVar = this.zzc;
                zzfjuVar.zza(zzeVarZzb);
                zzfjuVar.zzh(th);
                zzfjuVar.zzg(false);
                zzfkiVar.zzb(zzfjuVar.zzm());
            } else {
                zzfkfVar.zzc(zzeVarZzb);
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
        zzdop zzdopVar = (zzdop) obj;
        synchronized (this.zze) {
            zzdopVar.zzo().zzd(this.zze.zzd);
            this.zza.zzb(zzdopVar);
            zzfdy zzfdyVar = this.zze;
            Executor executor = zzfdyVar.zzb;
            final zzfdo zzfdoVar = zzfdyVar.zzd;
            Objects.requireNonNull(zzfdoVar);
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfdu
                @Override // java.lang.Runnable
                public final void run() {
                    zzfdoVar.zzs();
                }
            });
            this.zze.zzd.onAdMetadataChanged();
            if (!((Boolean) zzbdl.zzc.zze()).booleanValue() || (zzfkfVar = this.zzb) == null) {
                zzfki zzfkiVar = this.zze.zzg;
                zzfju zzfjuVar = this.zzc;
                zzfjuVar.zzb(zzdopVar.zzq().zzb);
                zzfjuVar.zzd(zzdopVar.zzm().zzg());
                zzfjuVar.zzg(true);
                zzfkiVar.zzb(zzfjuVar.zzm());
            } else {
                zzfkfVar.zzg(zzdopVar.zzq().zzb);
                zzfkfVar.zze(zzdopVar.zzm().zzg());
                zzfju zzfjuVar2 = this.zzc;
                zzfjuVar2.zzg(true);
                zzfkfVar.zza(zzfjuVar2);
                zzfkfVar.zzh();
            }
        }
    }
}

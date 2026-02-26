package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzehw implements zzgcf {
    final /* synthetic */ zzfel zza;
    final /* synthetic */ zzehx zzb;

    zzehw(zzehx zzehxVar, zzfel zzfelVar) {
        this.zza = zzfelVar;
        this.zzb = zzehxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        synchronized (this.zzb) {
            this.zzb.zzh.zzb(th, this.zza);
            zzfel zzfelVarZza = this.zzb.zzh.zza();
            if (this.zza.zzav) {
                while (zzfelVarZza != null) {
                    this.zzb.zze(zzfelVarZza);
                    zzfelVarZza = this.zzb.zzh.zza();
                }
            } else if (zzfelVarZza != null) {
                this.zzb.zze(zzfelVarZza);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzeio zzeioVar = (zzeio) obj;
        synchronized (this.zzb) {
            this.zzb.zzh.zzc(zzeioVar, this.zza);
            zzfel zzfelVarZza = this.zzb.zzh.zza();
            if (zzfelVarZza != null) {
                this.zzb.zze(zzfelVarZza);
            }
        }
    }
}

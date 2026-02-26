package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfhm implements zzgcf {
    final /* synthetic */ zzfhp zza;
    final /* synthetic */ zzfhq zzb;

    zzfhm(zzfhq zzfhqVar, zzfhp zzfhpVar) {
        this.zza = zzfhpVar;
        this.zzb = zzfhqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        synchronized (this.zzb) {
            this.zzb.zze = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        synchronized (this.zzb) {
            this.zzb.zze = null;
            this.zzb.zzd.addFirst(this.zza);
            zzfhq zzfhqVar = this.zzb;
            if (zzfhqVar.zzf == 1) {
                zzfhqVar.zzh();
            }
        }
    }
}

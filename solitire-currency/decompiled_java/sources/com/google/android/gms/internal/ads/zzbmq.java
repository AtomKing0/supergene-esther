package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbmq implements zzbzv {
    final /* synthetic */ zzbmz zza;
    final /* synthetic */ zzfju zzb;
    final /* synthetic */ zzbna zzc;

    zzbmq(zzbna zzbnaVar, zzbmz zzbmzVar, zzfju zzfjuVar) {
        this.zza = zzbmzVar;
        this.zzb = zzfjuVar;
        this.zzc = zzbnaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzv
    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Trying to acquire lock");
        synchronized (this.zzc.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Lock acquired");
            this.zzc.zzi = 1;
            com.google.android.gms.ads.internal.util.zze.zza("Failed loading new engine. Marking new engine destroyable.");
            this.zza.zzb();
            if (((Boolean) zzbdl.zzd.zze()).booleanValue()) {
                zzbna zzbnaVar = this.zzc;
                if (zzbnaVar.zze != null) {
                    zzfki zzfkiVar = zzbnaVar.zze;
                    zzfju zzfjuVar = this.zzb;
                    zzfjuVar.zzc("Failed loading new engine");
                    zzfjuVar.zzg(false);
                    zzfkiVar.zzb(zzfjuVar.zzm());
                }
            }
        }
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Lock released");
    }
}

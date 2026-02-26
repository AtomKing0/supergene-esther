package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbmu extends zzcaa {
    private final Object zza = new Object();
    private final zzbmz zzb;
    private boolean zzc;

    public zzbmu(zzbmz zzbmzVar) {
        this.zzb = zzbmzVar;
    }

    public final void zzb() {
        com.google.android.gms.ads.internal.util.zze.zza("release: Trying to acquire lock");
        synchronized (this.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("release: Lock acquired");
            if (this.zzc) {
                com.google.android.gms.ads.internal.util.zze.zza("release: Lock already released");
                return;
            }
            this.zzc = true;
            zzj(new zzbmr(this), new zzbzw());
            zzj(new zzbms(this), new zzbmt(this));
            com.google.android.gms.ads.internal.util.zze.zza("release: Lock released");
        }
    }
}

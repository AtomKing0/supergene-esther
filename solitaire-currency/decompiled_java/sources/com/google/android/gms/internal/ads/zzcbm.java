package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcbm implements Runnable {
    private final zzcay zza;
    private boolean zzb = false;

    zzcbm(zzcay zzcayVar) {
        this.zza = zzcayVar;
    }

    private final void zzc() {
        zzfru zzfruVar = com.google.android.gms.ads.internal.util.zzt.zza;
        zzfruVar.removeCallbacks(this);
        zzfruVar.postDelayed(this, 250L);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzb) {
            return;
        }
        this.zza.zzt();
        zzc();
    }

    public final void zza() {
        this.zzb = true;
        this.zza.zzt();
    }

    public final void zzb() {
        this.zzb = false;
        zzc();
    }
}

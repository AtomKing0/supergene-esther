package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcak implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzcao zzc;

    zzcak(zzcao zzcaoVar, int i10, int i11) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = zzcaoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcao zzcaoVar = this.zzc;
        if (zzcaoVar.zzq != null) {
            zzcaoVar.zzq.zzj(this.zza, this.zzb);
        }
    }
}

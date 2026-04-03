package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcan implements Runnable {
    final /* synthetic */ zzcao zza;

    zzcan(zzcao zzcaoVar) {
        this.zza = zzcaoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcao zzcaoVar = this.zza;
        if (zzcaoVar.zzq != null) {
            zzcaoVar.zzq.zzd();
        }
    }
}

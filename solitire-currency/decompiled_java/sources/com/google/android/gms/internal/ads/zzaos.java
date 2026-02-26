package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaos implements Runnable {
    final /* synthetic */ zzaph zza;
    final /* synthetic */ zzaot zzb;

    zzaos(zzaot zzaotVar, zzaph zzaphVar) {
        this.zza = zzaphVar;
        this.zzb = zzaotVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzb.zzc.put(this.zza);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}

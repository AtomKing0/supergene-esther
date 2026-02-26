package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkz implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzkv zzb;

    zzkz(zzkv zzkvVar, long j10) {
        this.zza = j10;
        this.zzb = zzkvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc().zza(this.zza);
        this.zzb.zza = null;
    }
}

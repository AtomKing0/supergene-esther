package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzky implements Runnable {
    private final /* synthetic */ zzks zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zzkv zzc;

    zzky(zzkv zzkvVar, zzks zzksVar, long j10) {
        this.zza = zzksVar;
        this.zzb = j10;
        this.zzc = zzkvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza(this.zza, false, this.zzb);
        zzkv zzkvVar = this.zzc;
        zzkvVar.zza = null;
        zzkvVar.zzo().zza((zzks) null);
    }
}

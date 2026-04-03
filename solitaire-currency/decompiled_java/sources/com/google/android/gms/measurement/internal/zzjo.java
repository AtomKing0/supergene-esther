package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzjo implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zziy zzb;

    zzjo(zziy zziyVar, long j10) {
        this.zza = j10;
        this.zzb = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzk().zzf.zza(this.zza);
        this.zzb.zzj().zzc().zza("Session timeout duration set", Long.valueOf(this.zza));
    }
}

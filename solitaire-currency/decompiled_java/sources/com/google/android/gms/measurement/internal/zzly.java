package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzly implements Runnable {
    private final /* synthetic */ zzfq zza;
    private final /* synthetic */ zzlx zzb;

    zzly(zzlx zzlxVar, zzfq zzfqVar) {
        this.zza = zzfqVar;
        this.zzb = zzlxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb) {
            this.zzb.zzb = false;
            if (!this.zzb.zza.zzah()) {
                this.zzb.zza.zzj().zzc().zza("Connected to remote service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}

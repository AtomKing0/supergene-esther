package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhy implements Runnable {
    private final /* synthetic */ zzac zza;
    private final /* synthetic */ zzhs zzb;

    zzhy(zzhs zzhsVar, zzac zzacVar) {
        this.zza = zzacVar;
        this.zzb = zzhsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzr();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zza(this.zza);
        } else {
            this.zzb.zza.zzb(this.zza);
        }
    }
}

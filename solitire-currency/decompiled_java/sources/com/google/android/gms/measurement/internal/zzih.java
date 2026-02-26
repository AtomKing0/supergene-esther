package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzih implements Runnable {
    private final /* synthetic */ zzno zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzhs zzc;

    zzih(zzhs zzhsVar, zzno zznoVar, zzn zznVar) {
        this.zza = zznoVar;
        this.zzb = zznVar;
        this.zzc = zzhsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzr();
        if (this.zza.zza() == null) {
            this.zzc.zza.zza(this.zza.zza, this.zzb);
        } else {
            this.zzc.zza.zza(this.zza, this.zzb);
        }
    }
}

package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzht implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzhs zzb;

    zzht(zzhs zzhsVar, zzn zznVar) {
        this.zza = zznVar;
        this.zzb = zzhsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzr();
        this.zzb.zza.zzc(this.zza);
    }
}

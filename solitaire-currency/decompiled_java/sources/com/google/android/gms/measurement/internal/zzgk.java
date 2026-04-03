package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgk implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzgl zzb;

    zzgk(zzgl zzglVar, boolean z10) {
        this.zza = z10;
        this.zzb = zzglVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb.zza(this.zza);
    }
}

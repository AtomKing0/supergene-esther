package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzmk implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzmi zzb;

    zzmk(zzmi zzmiVar, long j10) {
        this.zza = j10;
        this.zzb = zzmiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzmi.zza(this.zzb, this.zza);
    }
}

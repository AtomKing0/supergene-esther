package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkw implements Runnable {
    private final /* synthetic */ zzkv zza;

    zzkw(zzkv zzkvVar) {
        this.zza = zzkvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkv zzkvVar = this.zza;
        zzkvVar.zza = zzkvVar.zzh;
    }
}

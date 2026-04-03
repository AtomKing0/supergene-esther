package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzmg implements Runnable {
    private final /* synthetic */ zznd zza;
    private final /* synthetic */ Runnable zzb;

    zzmg(zzmf zzmfVar, zznd zzndVar, Runnable runnable) {
        this.zza = zzndVar;
        this.zzb = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzr();
        this.zza.zza(this.zzb);
        this.zza.zzw();
    }
}

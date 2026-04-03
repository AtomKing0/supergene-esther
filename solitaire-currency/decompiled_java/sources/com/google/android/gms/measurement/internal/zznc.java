package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zznc implements Runnable {
    private final /* synthetic */ zznn zza;
    private final /* synthetic */ zznd zzb;

    zznc(zznd zzndVar, zznn zznnVar) {
        this.zza = zznnVar;
        this.zzb = zzndVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznd.zza(this.zzb, this.zza);
        this.zzb.zzv();
    }
}

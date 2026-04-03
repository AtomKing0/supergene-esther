package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzjp implements Runnable {
    private final /* synthetic */ zziy zza;

    zzjp(zziy zziyVar) {
        this.zza = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb.zza();
    }
}

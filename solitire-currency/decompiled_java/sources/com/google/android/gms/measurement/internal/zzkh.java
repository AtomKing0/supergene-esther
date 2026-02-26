package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkh implements Runnable {
    private final /* synthetic */ Boolean zza;
    private final /* synthetic */ zziy zzb;

    zzkh(zziy zziyVar, Boolean bool) {
        this.zza = bool;
        this.zzb = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza, true);
    }
}

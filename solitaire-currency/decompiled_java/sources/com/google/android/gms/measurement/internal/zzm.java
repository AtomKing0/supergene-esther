package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzm implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdi zza;
    private final /* synthetic */ AppMeasurementDynamiteService zzb;

    zzm(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzdi zzdiVar) {
        this.zza = zzdiVar;
        this.zzb = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzt().zza(this.zza, this.zzb.zza.zzab());
    }
}

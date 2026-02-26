package com.google.android.gms.measurement.internal;

import com.google.common.util.concurrent.h;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzjn implements h<Object> {
    private final /* synthetic */ zzmv zza;
    private final /* synthetic */ zziy zzb;

    zzjn(zziy zziyVar, zzmv zzmvVar) {
        this.zza = zzmvVar;
        this.zzb = zziyVar;
    }

    @Override // com.google.common.util.concurrent.h
    public final void onFailure(Throwable th) {
        this.zzb.zzt();
        this.zzb.zzh = false;
        this.zzb.zzao();
        this.zzb.zzj().zzg().zza("registerTriggerAsync failed with throwable", th);
    }

    @Override // com.google.common.util.concurrent.h
    public final void onSuccess(Object obj) {
        this.zzb.zzt();
        this.zzb.zzh = false;
        this.zzb.zzao();
        this.zzb.zzj().zzc().zza("registerTriggerAsync ran. uri", this.zza.zza);
    }
}

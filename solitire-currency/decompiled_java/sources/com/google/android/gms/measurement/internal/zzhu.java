package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhu implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzhs zzb;

    zzhu(zzhs zzhsVar, zzn zznVar) {
        this.zza = zznVar;
        this.zzb = zzhsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzr();
        zznd zzndVar = this.zzb.zza;
        zzn zznVar = this.zza;
        zzndVar.zzl().zzt();
        zzndVar.zzs();
        Preconditions.checkNotEmpty(zznVar.zza);
        zzndVar.zza(zznVar);
    }
}

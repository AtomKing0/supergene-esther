package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzku implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzks zzb;
    private final /* synthetic */ zzks zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzkv zze;

    zzku(zzkv zzkvVar, Bundle bundle, zzks zzksVar, zzks zzksVar2, long j10) {
        this.zza = bundle;
        this.zzb = zzksVar;
        this.zzc = zzksVar2;
        this.zzd = j10;
        this.zze = zzkvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkv.zza(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}

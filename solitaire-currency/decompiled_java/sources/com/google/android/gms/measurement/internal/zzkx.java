package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkx implements Runnable {
    private final /* synthetic */ zzks zza;
    private final /* synthetic */ zzks zzb;
    private final /* synthetic */ long zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ zzkv zze;

    zzkx(zzkv zzkvVar, zzks zzksVar, zzks zzksVar2, long j10, boolean z10) {
        this.zza = zzksVar;
        this.zzb = zzksVar2;
        this.zzc = j10;
        this.zzd = z10;
        this.zze = zzkvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd, (Bundle) null);
    }
}

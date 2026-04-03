package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzqk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzki implements Runnable {
    private final /* synthetic */ zziq zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zziq zzd;
    private final /* synthetic */ zziy zze;

    zzki(zziy zziyVar, zziq zziqVar, long j10, boolean z10, zziq zziqVar2) {
        this.zza = zziqVar;
        this.zzb = j10;
        this.zzc = z10;
        this.zzd = zziqVar2;
        this.zze = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zza(this.zza);
        zziy.zza(this.zze, this.zza, this.zzb, false, this.zzc);
        if (zzqk.zza() && this.zze.zze().zza(zzbh.zzbr)) {
            zziy.zza(this.zze, this.zza, this.zzd);
        }
    }
}

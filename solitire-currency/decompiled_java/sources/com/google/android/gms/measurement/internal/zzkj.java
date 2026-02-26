package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzqk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkj implements Runnable {
    private final /* synthetic */ zziq zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ long zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ zziq zze;
    private final /* synthetic */ zziy zzf;

    zzkj(zziy zziyVar, zziq zziqVar, long j10, long j11, boolean z10, zziq zziqVar2) {
        this.zza = zziqVar;
        this.zzb = j10;
        this.zzc = j11;
        this.zzd = z10;
        this.zze = zziqVar2;
        this.zzf = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzf.zza(this.zza);
        this.zzf.zza(this.zzb, false);
        zziy.zza(this.zzf, this.zza, this.zzc, true, this.zzd);
        if (zzqk.zza() && this.zzf.zze().zza(zzbh.zzbr)) {
            zziy.zza(this.zzf, this.zza, this.zze);
        }
    }
}

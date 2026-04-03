package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzon;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzie implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzhs zzb;

    zzie(zzhs zzhsVar, zzn zznVar) {
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
        zziq zziqVarZza = zziq.zza(zznVar.zzt, (zzon.zza() && zzndVar.zze().zza(zzbh.zzco)) ? zznVar.zzy : 100);
        zziq zziqVarZzb = zzndVar.zzb(zznVar.zza);
        zzndVar.zzj().zzp().zza("Setting consent, package, consent", zznVar.zza, zziqVarZza);
        zzndVar.zza(zznVar.zza, zziqVarZza);
        if (zziqVarZza.zzc(zziqVarZzb)) {
            zzndVar.zzd(zznVar);
        }
        if (zzon.zza() && zzndVar.zze().zza(zzbh.zzco)) {
            zzax zzaxVarZza = zzax.zza(zznVar.zzz);
            if (zzax.zza.equals(zzaxVarZza)) {
                return;
            }
            zzndVar.zzj().zzp().zza("Setting DMA consent. package, consent", zznVar.zza, zzaxVarZza);
            zzndVar.zza(zznVar.zza, zzaxVarZza);
        }
    }
}

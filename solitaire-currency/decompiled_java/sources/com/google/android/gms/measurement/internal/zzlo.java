package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlo implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzla zzb;

    zzlo(zzla zzlaVar, zzn zznVar) {
        this.zza = zznVar;
        this.zzb = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfq zzfqVar = this.zzb.zzb;
        if (zzfqVar == null) {
            this.zzb.zzj().zzg().zza("Failed to send measurementEnabled to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzfqVar.zzf(this.zza);
            this.zzb.zzam();
        } catch (RemoteException e10) {
            this.zzb.zzj().zzg().zza("Failed to send measurementEnabled to the service", e10);
        }
    }
}

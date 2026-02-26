package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlk implements Runnable {
    private final /* synthetic */ zzks zza;
    private final /* synthetic */ zzla zzb;

    zzlk(zzla zzlaVar, zzks zzksVar) {
        this.zza = zzksVar;
        this.zzb = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfq zzfqVar = this.zzb.zzb;
        if (zzfqVar == null) {
            this.zzb.zzj().zzg().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzks zzksVar = this.zza;
            if (zzksVar == null) {
                zzfqVar.zza(0L, (String) null, (String) null, this.zzb.zza().getPackageName());
            } else {
                zzfqVar.zza(zzksVar.zzc, zzksVar.zza, zzksVar.zzb, this.zzb.zza().getPackageName());
            }
            this.zzb.zzam();
        } catch (RemoteException e10) {
            this.zzb.zzj().zzg().zza("Failed to send current screen to the service", e10);
        }
    }
}

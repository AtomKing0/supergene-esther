package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlg implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzla zzb;

    zzlg(zzla zzlaVar, zzn zznVar) {
        this.zza = zznVar;
        this.zzb = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfq zzfqVar = this.zzb.zzb;
        if (zzfqVar == null) {
            this.zzb.zzj().zzg().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzfqVar.zzd(this.zza);
        } catch (RemoteException e10) {
            this.zzb.zzj().zzg().zza("Failed to reset data on the service: remote exception", e10);
        }
        this.zzb.zzam();
    }
}

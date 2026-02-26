package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzll implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzla zzb;

    zzll(zzla zzlaVar, zzn zznVar) {
        this.zza = zznVar;
        this.zzb = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzfq zzfqVar = this.zzb.zzb;
        if (zzfqVar == null) {
            this.zzb.zzj().zzg().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzfqVar.zzc(this.zza);
            this.zzb.zzh().zzac();
            this.zzb.zza(zzfqVar, (AbstractSafeParcelable) null, this.zza);
            this.zzb.zzam();
        } catch (RemoteException e10) {
            this.zzb.zzj().zzg().zza("Failed to send app launch to the service", e10);
        }
    }
}

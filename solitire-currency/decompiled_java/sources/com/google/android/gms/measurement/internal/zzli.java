package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzli implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdi zzb;
    private final /* synthetic */ zzla zzc;

    zzli(zzla zzlaVar, zzn zznVar, com.google.android.gms.internal.measurement.zzdi zzdiVar) {
        this.zza = zznVar;
        this.zzb = zzdiVar;
        this.zzc = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (!this.zzc.zzk().zzn().zzj()) {
                this.zzc.zzj().zzv().zza("Analytics storage consent denied; will not get app instance id");
                this.zzc.zzm().zza((String) null);
                this.zzc.zzk().zze.zza(null);
                return;
            }
            zzfq zzfqVar = this.zzc.zzb;
            if (zzfqVar == null) {
                this.zzc.zzj().zzg().zza("Failed to get app instance id");
                return;
            }
            Preconditions.checkNotNull(this.zza);
            String strZzb = zzfqVar.zzb(this.zza);
            if (strZzb != null) {
                this.zzc.zzm().zza(strZzb);
                this.zzc.zzk().zze.zza(strZzb);
            }
            this.zzc.zzam();
            this.zzc.zzq().zza(this.zzb, strZzb);
        } catch (RemoteException e10) {
            this.zzc.zzj().zzg().zza("Failed to get app instance id", e10);
        } finally {
            this.zzc.zzq().zza(this.zzb, (String) null);
        }
    }
}

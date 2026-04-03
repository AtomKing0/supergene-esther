package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlc implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzn zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdi zze;
    private final /* synthetic */ zzla zzf;

    zzlc(zzla zzlaVar, String str, String str2, zzn zznVar, boolean z10, com.google.android.gms.internal.measurement.zzdi zzdiVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zznVar;
        this.zzd = z10;
        this.zze = zzdiVar;
        this.zzf = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle = new Bundle();
        try {
            zzfq zzfqVar = this.zzf.zzb;
            if (zzfqVar == null) {
                this.zzf.zzj().zzg().zza("Failed to get user properties; not connected to service", this.zza, this.zzb);
                return;
            }
            Preconditions.checkNotNull(this.zzc);
            Bundle bundleZza = zznt.zza(zzfqVar.zza(this.zza, this.zzb, this.zzd, this.zzc));
            this.zzf.zzam();
            this.zzf.zzq().zza(this.zze, bundleZza);
        } catch (RemoteException e10) {
            this.zzf.zzj().zzg().zza("Failed to get user properties; remote exception", this.zza, e10);
        } finally {
            this.zzf.zzq().zza(this.zze, bundle);
        }
    }
}

package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlp implements Runnable {
    private final /* synthetic */ zzbf zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdi zzc;
    private final /* synthetic */ zzla zzd;

    zzlp(zzla zzlaVar, zzbf zzbfVar, String str, com.google.android.gms.internal.measurement.zzdi zzdiVar) {
        this.zza = zzbfVar;
        this.zzb = str;
        this.zzc = zzdiVar;
        this.zzd = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzfq zzfqVar = this.zzd.zzb;
            if (zzfqVar == null) {
                this.zzd.zzj().zzg().zza("Discarding data. Failed to send event to service to bundle");
                return;
            }
            byte[] bArrZza = zzfqVar.zza(this.zza, this.zzb);
            this.zzd.zzam();
            this.zzd.zzq().zza(this.zzc, bArrZza);
        } catch (RemoteException e10) {
            this.zzd.zzj().zzg().zza("Failed to send event to the service to bundle", e10);
        } finally {
            this.zzd.zzq().zza(this.zzc, (byte[]) null);
        }
    }
}

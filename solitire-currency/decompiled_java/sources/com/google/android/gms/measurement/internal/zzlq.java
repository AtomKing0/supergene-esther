package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlq implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzbf zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ zzla zzf;

    zzlq(zzla zzlaVar, boolean z10, zzn zznVar, boolean z11, zzbf zzbfVar, String str) {
        this.zza = z10;
        this.zzb = zznVar;
        this.zzc = z11;
        this.zzd = zzbfVar;
        this.zze = str;
        this.zzf = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzfq zzfqVar = this.zzf.zzb;
        if (zzfqVar == null) {
            this.zzf.zzj().zzg().zza("Discarding data. Failed to send event to service");
            return;
        }
        if (this.zza) {
            Preconditions.checkNotNull(this.zzb);
            this.zzf.zza(zzfqVar, this.zzc ? null : this.zzd, this.zzb);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze)) {
                    Preconditions.checkNotNull(this.zzb);
                    zzfqVar.zza(this.zzd, this.zzb);
                } else {
                    zzfqVar.zza(this.zzd, this.zze, this.zzf.zzj().zzx());
                }
            } catch (RemoteException e10) {
                this.zzf.zzj().zzg().zza("Failed to send event to the service", e10);
            }
        }
        this.zzf.zzam();
    }
}

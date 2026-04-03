package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlf implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzla zzd;

    zzlf(zzla zzlaVar, AtomicReference atomicReference, zzn zznVar, boolean z10) {
        this.zza = atomicReference;
        this.zzb = zznVar;
        this.zzc = z10;
        this.zzd = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfq zzfqVar;
        synchronized (this.zza) {
            try {
                try {
                    zzfqVar = this.zzd.zzb;
                } catch (RemoteException e10) {
                    this.zzd.zzj().zzg().zza("Failed to get all user properties; remote exception", e10);
                }
                if (zzfqVar == null) {
                    this.zzd.zzj().zzg().zza("Failed to get all user properties; not connected to service");
                    return;
                }
                Preconditions.checkNotNull(this.zzb);
                this.zza.set(zzfqVar.zza(this.zzb, this.zzc));
                this.zzd.zzam();
                this.zza.notify();
            } finally {
                this.zza.notify();
            }
        }
    }
}

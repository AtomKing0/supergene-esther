package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzle implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzla zzd;

    zzle(zzla zzlaVar, AtomicReference atomicReference, zzn zznVar, Bundle bundle) {
        this.zza = atomicReference;
        this.zzb = zznVar;
        this.zzc = bundle;
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
                    this.zzd.zzj().zzg().zza("Failed to get trigger URIs; remote exception", e10);
                }
                if (zzfqVar == null) {
                    this.zzd.zzj().zzg().zza("Failed to get trigger URIs; not connected to service");
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

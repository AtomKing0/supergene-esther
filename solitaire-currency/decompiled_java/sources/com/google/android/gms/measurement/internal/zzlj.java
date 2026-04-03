package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlj implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzla zzc;

    zzlj(zzla zzlaVar, AtomicReference atomicReference, zzn zznVar) {
        this.zza = atomicReference;
        this.zzb = zznVar;
        this.zzc = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                try {
                } catch (RemoteException e10) {
                    this.zzc.zzj().zzg().zza("Failed to get app instance id", e10);
                }
                if (!this.zzc.zzk().zzn().zzj()) {
                    this.zzc.zzj().zzv().zza("Analytics storage consent denied; will not get app instance id");
                    this.zzc.zzm().zza((String) null);
                    this.zzc.zzk().zze.zza(null);
                    this.zza.set(null);
                    return;
                }
                zzfq zzfqVar = this.zzc.zzb;
                if (zzfqVar == null) {
                    this.zzc.zzj().zzg().zza("Failed to get app instance id");
                    return;
                }
                Preconditions.checkNotNull(this.zzb);
                this.zza.set(zzfqVar.zzb(this.zzb));
                String str = (String) this.zza.get();
                if (str != null) {
                    this.zzc.zzm().zza(str);
                    this.zzc.zzk().zze.zza(str);
                }
                this.zzc.zzam();
                this.zza.notify();
            } finally {
                this.zza.notify();
            }
        }
    }
}

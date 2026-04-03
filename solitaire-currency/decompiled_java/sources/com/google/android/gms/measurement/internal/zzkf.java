package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkf implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zziy zzb;

    zzkf(zziy zziyVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
        this.zzb = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Integer.valueOf(this.zzb.zze().zzb(this.zzb.zzg().zzad(), zzbh.zzan)));
            } finally {
                this.zza.notify();
            }
        }
    }
}

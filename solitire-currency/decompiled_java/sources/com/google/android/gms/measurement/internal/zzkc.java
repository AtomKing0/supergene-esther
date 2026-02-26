package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkc implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zziy zzb;

    zzkc(zziy zziyVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
        this.zzb = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Long.valueOf(this.zzb.zze().zzc(this.zzb.zzg().zzad(), zzbh.zzam)));
            } finally {
                this.zza.notify();
            }
        }
    }
}

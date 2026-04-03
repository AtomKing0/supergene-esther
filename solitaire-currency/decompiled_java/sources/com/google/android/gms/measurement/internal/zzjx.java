package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzjx implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zziy zzb;

    zzjx(zziy zziyVar, long j10) {
        this.zza = j10;
        this.zzb = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza, true);
        this.zzb.zzo().zza(new AtomicReference<>());
    }
}

package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzid implements Callable<zzal> {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzhs zzb;

    zzid(zzhs zzhsVar, zzn zznVar) {
        this.zza = zznVar;
        this.zzb = zzhsVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzal call() throws Exception {
        this.zzb.zza.zzr();
        return new zzal(this.zzb.zza.zza(this.zza.zza));
    }
}

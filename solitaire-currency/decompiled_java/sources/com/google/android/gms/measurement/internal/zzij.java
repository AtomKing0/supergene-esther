package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzij implements Callable<List<zznq>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzhs zzb;

    zzij(zzhs zzhsVar, String str) {
        this.zza = str;
        this.zzb = zzhsVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zznq> call() throws Exception {
        this.zzb.zza.zzr();
        return this.zzb.zza.zzf().zzj(this.zza);
    }
}

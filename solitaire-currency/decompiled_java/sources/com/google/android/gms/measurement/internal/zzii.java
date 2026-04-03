package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzii implements Callable<byte[]> {
    private final /* synthetic */ zzbf zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzhs zzc;

    zzii(zzhs zzhsVar, zzbf zzbfVar, String str) {
        this.zza = zzbfVar;
        this.zzb = str;
        this.zzc = zzhsVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() throws Exception {
        this.zzc.zza.zzr();
        return this.zzc.zza.zzm().zza(this.zza, this.zzb);
    }
}

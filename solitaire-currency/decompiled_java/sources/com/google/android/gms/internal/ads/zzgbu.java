package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgbu extends zzgbv {
    final /* synthetic */ zzgbw zza;
    private final Callable zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgbu(zzgbw zzgbwVar, Callable callable, Executor executor) {
        super(zzgbwVar, executor);
        this.zza = zzgbwVar;
        this.zzc = callable;
    }

    @Override // com.google.android.gms.internal.ads.zzgcs
    final Object zza() throws Exception {
        return this.zzc.call();
    }

    @Override // com.google.android.gms.internal.ads.zzgcs
    final String zzb() {
        return this.zzc.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgbv
    final void zzc(Object obj) {
        this.zza.zzc(obj);
    }
}

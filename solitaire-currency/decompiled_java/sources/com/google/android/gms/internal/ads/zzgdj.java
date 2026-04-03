package com.google.android.gms.internal.ads;

import com.ironsource.v8;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgdj extends zzgbz implements RunnableFuture {
    private volatile zzgcs zza;

    zzgdj(zzgbp zzgbpVar) {
        this.zza = new zzgdh(this, zzgbpVar);
    }

    static zzgdj zze(Runnable runnable, Object obj) {
        return new zzgdj(Executors.callable(runnable, obj));
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzgcs zzgcsVar = this.zza;
        if (zzgcsVar != null) {
            zzgcsVar.run();
        }
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    protected final String zza() {
        zzgcs zzgcsVar = this.zza;
        if (zzgcsVar == null) {
            return super.zza();
        }
        return "task=[" + zzgcsVar.toString() + v8.i.f15839e;
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    protected final void zzb() {
        zzgcs zzgcsVar;
        if (zzt() && (zzgcsVar = this.zza) != null) {
            zzgcsVar.zzh();
        }
        this.zza = null;
    }

    zzgdj(Callable callable) {
        this.zza = new zzgdi(this, callable);
    }
}

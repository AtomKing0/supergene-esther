package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgcv implements Executor {
    final /* synthetic */ Executor zza;
    final /* synthetic */ zzgax zzb;

    zzgcv(Executor executor, zzgax zzgaxVar) {
        this.zza = executor;
        this.zzb = zzgaxVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        try {
            this.zza.execute(runnable);
        } catch (RejectedExecutionException e10) {
            this.zzb.zzd(e10);
        }
    }
}

package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgda {
    public static zzgcu zza(ExecutorService executorService) {
        if (executorService instanceof zzgcu) {
            return (zzgcu) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new zzgcz((ScheduledExecutorService) executorService) : new zzgcw(executorService);
    }

    public static Executor zzb() {
        return zzgbx.INSTANCE;
    }

    static Executor zzc(Executor executor, zzgax zzgaxVar) {
        executor.getClass();
        return executor == zzgbx.INSTANCE ? executor : new zzgcv(executor, zzgaxVar);
    }
}

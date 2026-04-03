package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzavl implements ThreadFactory {
    private final ThreadFactory zza = Executors.defaultThreadFactory();
    private final AtomicInteger zzb = new AtomicInteger(1);

    zzavl() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger = this.zzb;
        Thread threadNewThread = this.zza.newThread(runnable);
        threadNewThread.setName("gads-" + atomicInteger.getAndIncrement());
        return threadNewThread;
    }
}

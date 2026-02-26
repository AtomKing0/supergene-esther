package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzfrq {
    ExecutorService zza(int i10);

    ExecutorService zzb(ThreadFactory threadFactory, int i10);

    ExecutorService zzc(int i10, ThreadFactory threadFactory, int i11);
}

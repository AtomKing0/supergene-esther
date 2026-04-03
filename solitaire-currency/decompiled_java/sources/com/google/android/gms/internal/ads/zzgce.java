package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgce extends zzgcc implements m {
    protected zzgce() {
    }

    @Override // com.google.common.util.concurrent.m
    public final void addListener(Runnable runnable, Executor executor) {
        zzc().addListener(runnable, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzgcc
    protected /* bridge */ /* synthetic */ Future zzb() {
        throw null;
    }

    protected abstract m zzc();
}

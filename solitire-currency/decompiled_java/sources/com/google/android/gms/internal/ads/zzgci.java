package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgci {
    private final boolean zza;
    private final zzfxr zzb;

    /* synthetic */ zzgci(boolean z10, zzfxr zzfxrVar, zzgch zzgchVar) {
        this.zza = z10;
        this.zzb = zzfxrVar;
    }

    public final m zza(Callable callable, Executor executor) {
        return new zzgbw(this.zzb, this.zza, executor, callable);
    }
}

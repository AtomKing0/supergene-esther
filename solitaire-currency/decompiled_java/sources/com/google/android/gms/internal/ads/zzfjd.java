package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfjd {
    private static final m zza = zzgcj.zzh(null);
    private final zzgcu zzb;
    private final ScheduledExecutorService zzc;
    private final zzfje zzd;

    public zzfjd(zzgcu zzgcuVar, ScheduledExecutorService scheduledExecutorService, zzfje zzfjeVar) {
        this.zzb = zzgcuVar;
        this.zzc = scheduledExecutorService;
        this.zzd = zzfjeVar;
    }

    public final zzfit zza(Object obj, m... mVarArr) {
        return new zzfit(this, obj, Arrays.asList(mVarArr), null);
    }

    public final zzfjc zzb(Object obj, m mVar) {
        return new zzfjc(this, obj, mVar, Collections.singletonList(mVar), mVar);
    }

    protected abstract String zzf(Object obj);
}

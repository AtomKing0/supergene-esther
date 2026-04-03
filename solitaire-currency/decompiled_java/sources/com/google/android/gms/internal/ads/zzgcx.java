package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgcx extends zzgcd implements ScheduledFuture {
    private final ScheduledFuture zza;

    public zzgcx(m mVar, ScheduledFuture scheduledFuture) {
        super(mVar);
        this.zza = scheduledFuture;
    }

    @Override // com.google.android.gms.internal.ads.zzgcc, java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        boolean zCancel = zzb().cancel(z10);
        if (zCancel) {
            this.zza.cancel(z10);
        }
        return zCancel;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Delayed delayed) {
        return this.zza.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.zza.getDelay(timeUnit);
    }
}

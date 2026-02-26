package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import com.ironsource.v8;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgdg extends zzgbz {
    private m zza;
    private ScheduledFuture zzb;

    private zzgdg(m mVar) {
        mVar.getClass();
        this.zza = mVar;
    }

    static m zzf(m mVar, long j10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzgdg zzgdgVar = new zzgdg(mVar);
        zzgdd zzgddVar = new zzgdd(zzgdgVar);
        zzgdgVar.zzb = scheduledExecutorService.schedule(zzgddVar, j10, timeUnit);
        mVar.addListener(zzgddVar, zzgbx.INSTANCE);
        return zzgdgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    protected final String zza() {
        m mVar = this.zza;
        ScheduledFuture scheduledFuture = this.zzb;
        if (mVar == null) {
            return null;
        }
        String str = "inputFuture=[" + mVar.toString() + v8.i.f15839e;
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    protected final void zzb() {
        zzr(this.zza);
        ScheduledFuture scheduledFuture = this.zzb;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zza = null;
        this.zzb = null;
    }
}

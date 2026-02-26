package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgdd implements Runnable {
    zzgdg zza;

    zzgdd(zzgdg zzgdgVar) {
        this.zza = zzgdgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m mVar;
        zzgdg zzgdgVar = this.zza;
        if (zzgdgVar == null || (mVar = zzgdgVar.zza) == null) {
            return;
        }
        this.zza = null;
        if (mVar.isDone()) {
            zzgdgVar.zzs(mVar);
            return;
        }
        try {
            ScheduledFuture scheduledFuture = zzgdgVar.zzb;
            zzgdgVar.zzb = null;
            String str = "Timed out";
            if (scheduledFuture != null) {
                try {
                    long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (jAbs > 10) {
                        str = "Timed out (timeout delayed by " + jAbs + " ms after scheduled time)";
                    }
                } catch (Throwable th) {
                    zzgdgVar.zzd(new zzgdf(str, null));
                    throw th;
                }
            }
            zzgdgVar.zzd(new zzgdf(str + ": " + mVar.toString(), null));
        } finally {
            mVar.cancel(true);
        }
    }
}

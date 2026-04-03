package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeyz {
    public static zzevo zza(zzeyd zzeydVar, zzeto zzetoVar, ScheduledExecutorService scheduledExecutorService, int i10) {
        zzevo zzevoVar = zzeydVar;
        if (i10 == 0) {
            zzevoVar = zzetoVar;
        }
        return new zzetw(zzevoVar, 0L, scheduledExecutorService);
    }

    public static zzevo zzb(zzeyn zzeynVar, ScheduledExecutorService scheduledExecutorService) {
        return new zzetw(zzeynVar, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdK)).longValue(), scheduledExecutorService);
    }

    public static zzevo zzc(zzezi zzeziVar, ScheduledExecutorService scheduledExecutorService) {
        return new zzetw(zzeziVar, 0L, scheduledExecutorService);
    }
}

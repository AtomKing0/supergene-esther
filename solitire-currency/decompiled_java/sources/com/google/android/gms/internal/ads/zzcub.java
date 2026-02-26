package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcub {
    private final Object zza = new Object();
    private final ConcurrentHashMap zzb = new ConcurrentHashMap();
    private final ConcurrentHashMap zzc = new ConcurrentHashMap();
    private final ConcurrentHashMap zzd = new ConcurrentHashMap();

    @VisibleForTesting
    public zzcub() {
    }

    public final int zza(String str) {
        Integer num = (Integer) this.zzb.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public final long zzb(String str) {
        Long l10 = (Long) this.zzd.get(str);
        if (l10 == null) {
            return -1L;
        }
        return l10.longValue();
    }

    public final void zzc(String str) {
        synchronized (this.zza) {
            Integer num = (Integer) this.zzb.get(str);
            this.zzb.put(str, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
        }
    }

    public final void zzd(String str, String str2, long j10) {
        Long l10 = (Long) this.zzc.get(str2);
        if (l10 == null) {
            return;
        }
        this.zzc.remove(str2);
        this.zzd.put(str, Long.valueOf(j10 - l10.longValue()));
    }

    public final void zze(String str, long j10) {
        this.zzc.put(str, Long.valueOf(j10));
    }
}

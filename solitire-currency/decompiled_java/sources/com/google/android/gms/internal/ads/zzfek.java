package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfek {
    private final Clock zza;
    private final Object zzb = new Object();
    private volatile int zzd = 1;
    private volatile long zzc = 0;

    public zzfek(Clock clock) {
        this.zza = clock;
    }

    private final void zze() {
        long jCurrentTimeMillis = this.zza.currentTimeMillis();
        synchronized (this.zzb) {
            if (this.zzd == 3) {
                if (this.zzc + ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfp)).longValue() <= jCurrentTimeMillis) {
                    this.zzd = 1;
                }
            }
        }
    }

    private final void zzf(int i10, int i11) {
        zze();
        Object obj = this.zzb;
        long jCurrentTimeMillis = this.zza.currentTimeMillis();
        synchronized (obj) {
            if (this.zzd != i10) {
                return;
            }
            this.zzd = i11;
            if (this.zzd == 3) {
                this.zzc = jCurrentTimeMillis;
            }
        }
    }

    public final void zza() {
        zzf(2, 3);
    }

    public final void zzb(boolean z10) {
        if (z10) {
            zzf(1, 2);
        } else {
            zzf(2, 1);
        }
    }

    public final boolean zzc() {
        boolean z10;
        synchronized (this.zzb) {
            zze();
            z10 = this.zzd == 3;
        }
        return z10;
    }

    public final boolean zzd() {
        boolean z10;
        synchronized (this.zzb) {
            zze();
            z10 = this.zzd == 2;
        }
        return z10;
    }
}

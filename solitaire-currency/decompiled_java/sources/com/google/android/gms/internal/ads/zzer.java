package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.media3.common.C;
import androidx.media3.common.util.TimestampAdjuster;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzer {

    @GuardedBy("this")
    private long zza;

    @GuardedBy("this")
    private long zzb;

    @GuardedBy("this")
    private long zzc;
    private final ThreadLocal zzd = new ThreadLocal();

    public zzer(long j10) {
        zzi(0L);
    }

    public static long zzg(long j10) {
        return (j10 * 1000000) / 90000;
    }

    public static long zzh(long j10) {
        return (j10 * 90000) / 1000000;
    }

    public final synchronized long zza(long j10) {
        if (!zzj()) {
            long jLongValue = this.zza;
            if (jLongValue == TimestampAdjuster.MODE_SHARED) {
                Long l10 = (Long) this.zzd.get();
                l10.getClass();
                jLongValue = l10.longValue();
            }
            this.zzb = jLongValue - j10;
            notifyAll();
        }
        this.zzc = j10;
        return j10 + this.zzb;
    }

    public final synchronized long zzb(long j10) {
        if (j10 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long j11 = this.zzc;
        if (j11 != C.TIME_UNSET) {
            long jZzh = zzh(j11);
            long j12 = (4294967296L + jZzh) / 8589934592L;
            long j13 = (((-1) + j12) * 8589934592L) + j10;
            j10 += j12 * 8589934592L;
            if (Math.abs(j13 - jZzh) < Math.abs(j10 - jZzh)) {
                j10 = j13;
            }
        }
        return zza(zzg(j10));
    }

    public final synchronized long zzc(long j10) {
        if (j10 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long j11 = this.zzc;
        if (j11 != C.TIME_UNSET) {
            long jZzh = zzh(j11);
            long j12 = jZzh / 8589934592L;
            Long.signum(j12);
            long j13 = (j12 * 8589934592L) + j10;
            j10 += (j12 + 1) * 8589934592L;
            if (j13 >= jZzh) {
                j10 = j13;
            }
        }
        return zza(zzg(j10));
    }

    public final synchronized long zzd() {
        long j10 = this.zza;
        return (j10 == Long.MAX_VALUE || j10 == TimestampAdjuster.MODE_SHARED) ? C.TIME_UNSET : j10;
    }

    public final synchronized long zze() {
        long j10;
        j10 = this.zzc;
        return j10 != C.TIME_UNSET ? j10 + this.zzb : zzd();
    }

    public final synchronized long zzf() {
        return this.zzb;
    }

    public final synchronized void zzi(long j10) {
        this.zza = j10;
        this.zzb = j10 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.zzc = C.TIME_UNSET;
    }

    public final synchronized boolean zzj() {
        return this.zzb != C.TIME_UNSET;
    }
}

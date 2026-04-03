package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhq {
    private final long zza;
    private final long zzb;
    private long zzc = C.TIME_UNSET;
    private long zzd = C.TIME_UNSET;
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private float zzj = 0.97f;
    private float zzi = 1.03f;
    private float zzk = 1.0f;
    private long zzl = C.TIME_UNSET;
    private long zze = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;
    private long zzm = C.TIME_UNSET;
    private long zzn = C.TIME_UNSET;

    /* synthetic */ zzhq(float f10, float f11, long j10, float f12, long j11, long j12, float f13, zzhp zzhpVar) {
        this.zza = j11;
        this.zzb = j12;
    }

    private static long zzf(long j10, long j11, float f10) {
        return (long) ((j10 * 0.999f) + (j11 * 9.999871E-4f));
    }

    private final void zzg() {
        long j10;
        long j11 = this.zzc;
        if (j11 != C.TIME_UNSET) {
            j10 = this.zzd;
            if (j10 == C.TIME_UNSET) {
                long j12 = this.zzf;
                if (j12 != C.TIME_UNSET && j11 < j12) {
                    j11 = j12;
                }
                j10 = this.zzg;
                if (j10 == C.TIME_UNSET || j11 <= j10) {
                    j10 = j11;
                }
            }
        } else {
            j10 = -9223372036854775807L;
        }
        if (this.zze == j10) {
            return;
        }
        this.zze = j10;
        this.zzh = j10;
        this.zzm = C.TIME_UNSET;
        this.zzn = C.TIME_UNSET;
        this.zzl = C.TIME_UNSET;
    }

    public final float zza(long j10, long j11) {
        if (this.zzc == C.TIME_UNSET) {
            return 1.0f;
        }
        long j12 = j10 - j11;
        long j13 = this.zzm;
        if (j13 == C.TIME_UNSET) {
            this.zzm = j12;
            this.zzn = 0L;
        } else {
            long jMax = Math.max(j12, zzf(j13, j12, 0.999f));
            this.zzm = jMax;
            this.zzn = zzf(this.zzn, Math.abs(j12 - jMax), 0.999f);
        }
        if (this.zzl != C.TIME_UNSET && SystemClock.elapsedRealtime() - this.zzl < 1000) {
            return this.zzk;
        }
        this.zzl = SystemClock.elapsedRealtime();
        long jMax2 = this.zzm + (this.zzn * 3);
        if (this.zzh > jMax2) {
            float fZzr = zzet.zzr(1000L);
            long[] jArr = {jMax2, this.zze, this.zzh - (((long) ((this.zzk - 1.0f) * fZzr)) + ((long) ((this.zzi - 1.0f) * fZzr)))};
            for (int i10 = 1; i10 < 3; i10++) {
                long j14 = jArr[i10];
                if (j14 > jMax2) {
                    jMax2 = j14;
                }
            }
            this.zzh = jMax2;
        } else {
            jMax2 = Math.max(this.zzh, Math.min(j10 - ((long) (Math.max(0.0f, this.zzk - 1.0f) / 1.0E-7f)), jMax2));
            this.zzh = jMax2;
            long j15 = this.zzg;
            if (j15 != C.TIME_UNSET && jMax2 > j15) {
                this.zzh = j15;
                jMax2 = j15;
            }
        }
        long j16 = j10 - jMax2;
        if (Math.abs(j16) < this.zza) {
            this.zzk = 1.0f;
            return 1.0f;
        }
        float fMax = Math.max(this.zzj, Math.min((j16 * 1.0E-7f) + 1.0f, this.zzi));
        this.zzk = fMax;
        return fMax;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final void zzc() {
        long j10 = this.zzh;
        if (j10 == C.TIME_UNSET) {
            return;
        }
        long j11 = j10 + this.zzb;
        this.zzh = j11;
        long j12 = this.zzg;
        if (j12 != C.TIME_UNSET && j11 > j12) {
            this.zzh = j12;
        }
        this.zzl = C.TIME_UNSET;
    }

    public final void zzd(zzav zzavVar) {
        long j10 = zzavVar.zza;
        this.zzc = zzet.zzr(C.TIME_UNSET);
        this.zzf = zzet.zzr(C.TIME_UNSET);
        this.zzg = zzet.zzr(C.TIME_UNSET);
        this.zzj = 0.97f;
        this.zzi = 1.03f;
        zzg();
    }

    public final void zze(long j10) {
        this.zzd = j10;
        zzg();
    }
}

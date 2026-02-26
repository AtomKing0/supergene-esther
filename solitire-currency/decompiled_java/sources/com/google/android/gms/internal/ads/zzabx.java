package com.google.android.gms.internal.ads;

import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzabx implements zzadi {
    private final long zza;
    private final long zzb;
    private final int zzc;
    private final long zzd;
    private final int zze;
    private final long zzf;

    public zzabx(long j10, long j11, int i10, int i11, boolean z10) {
        long jZzc;
        this.zza = j10;
        this.zzb = j11;
        this.zzc = i11 == -1 ? 1 : i11;
        this.zze = i10;
        if (j10 == -1) {
            this.zzd = -1L;
            jZzc = C.TIME_UNSET;
        } else {
            this.zzd = j10 - j11;
            jZzc = zzc(j10, j11, i10);
        }
        this.zzf = jZzc;
    }

    private static long zzc(long j10, long j11, int i10) {
        return (Math.max(0L, j10 - j11) * 8000000) / ((long) i10);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final long zza() {
        return this.zzf;
    }

    public final long zzb(long j10) {
        return zzc(j10, this.zzb, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j10) {
        long j11 = this.zzd;
        if (j11 == -1) {
            zzadj zzadjVar = new zzadj(0L, this.zzb);
            return new zzadg(zzadjVar, zzadjVar);
        }
        long j12 = ((long) this.zze) * j10;
        long j13 = this.zzc;
        long jMin = ((j12 / 8000000) / j13) * j13;
        if (j11 != -1) {
            jMin = Math.min(jMin, j11 - j13);
        }
        long jMax = this.zzb + Math.max(jMin, 0L);
        long jZzb = zzb(jMax);
        zzadj zzadjVar2 = new zzadj(jZzb, jMax);
        if (this.zzd != -1 && jZzb < j10) {
            long j14 = jMax + ((long) this.zzc);
            if (j14 < this.zza) {
                return new zzadg(zzadjVar2, new zzadj(zzb(j14), j14));
            }
        }
        return new zzadg(zzadjVar2, zzadjVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final boolean zzh() {
        return this.zzd != -1;
    }
}

package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzahu implements zzahr {
    private final long zza;
    private final int zzb;
    private final long zzc;
    private final int zzd;
    private final long zze;
    private final long zzf;

    @Nullable
    private final long[] zzg;

    private zzahu(long j10, int i10, long j11, int i11, long j12, @Nullable long[] jArr) {
        this.zza = j10;
        this.zzb = i10;
        this.zzc = j11;
        this.zzd = i11;
        this.zze = j12;
        this.zzg = jArr;
        this.zzf = j12 != -1 ? j10 + j12 : -1L;
    }

    @Nullable
    public static zzahu zzb(zzaht zzahtVar, long j10) {
        long[] jArr;
        long jZza = zzahtVar.zza();
        if (jZza == C.TIME_UNSET) {
            return null;
        }
        long j11 = zzahtVar.zzc;
        if (j11 == -1 || (jArr = zzahtVar.zzf) == null) {
            zzadc zzadcVar = zzahtVar.zza;
            return new zzahu(j10, zzadcVar.zzc, jZza, zzadcVar.zzf, -1L, null);
        }
        zzadc zzadcVar2 = zzahtVar.zza;
        return new zzahu(j10, zzadcVar2.zzc, jZza, zzadcVar2.zzf, j11, jArr);
    }

    private final long zzf(int i10) {
        return (this.zzc * ((long) i10)) / 100;
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzahr
    public final int zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzahr
    public final long zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzahr
    public final long zze(long j10) {
        if (!zzh()) {
            return 0L;
        }
        long j11 = j10 - this.zza;
        if (j11 <= this.zzb) {
            return 0L;
        }
        long[] jArr = this.zzg;
        zzdi.zzb(jArr);
        double d10 = (j11 * 256.0d) / this.zze;
        int iZzc = zzet.zzc(jArr, (long) d10, true, true);
        long jZzf = zzf(iZzc);
        long j12 = jArr[iZzc];
        int i10 = iZzc + 1;
        long jZzf2 = zzf(i10);
        return jZzf + Math.round((j12 == (iZzc == 99 ? 256L : jArr[i10]) ? 0.0d : (d10 - j12) / (r0 - j12)) * (jZzf2 - jZzf));
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j10) {
        if (!zzh()) {
            zzadj zzadjVar = new zzadj(0L, this.zza + ((long) this.zzb));
            return new zzadg(zzadjVar, zzadjVar);
        }
        long jMax = Math.max(0L, Math.min(j10, this.zzc));
        double d10 = (jMax * 100.0d) / this.zzc;
        double d11 = 0.0d;
        if (d10 > 0.0d) {
            if (d10 >= 100.0d) {
                d11 = 256.0d;
            } else {
                int i10 = (int) d10;
                long[] jArr = this.zzg;
                zzdi.zzb(jArr);
                double d12 = jArr[i10];
                d11 = d12 + ((d10 - ((double) i10)) * ((i10 == 99 ? 256.0d : jArr[i10 + 1]) - d12));
            }
        }
        long j11 = this.zze;
        zzadj zzadjVar2 = new zzadj(jMax, this.zza + Math.max(this.zzb, Math.min(Math.round((d11 / 256.0d) * j11), j11 - 1)));
        return new zzadg(zzadjVar2, zzadjVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final boolean zzh() {
        return this.zzg != null;
    }
}

package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.math.RoundingMode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzahs implements zzahr {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;
    private final int zze;

    private zzahs(long[] jArr, long[] jArr2, long j10, long j11, int i10) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j10;
        this.zzd = j11;
        this.zze = i10;
    }

    @Nullable
    public static zzahs zzb(long j10, long j11, zzadc zzadcVar, zzek zzekVar) {
        int iZzm;
        zzekVar.zzL(10);
        int iZzg = zzekVar.zzg();
        if (iZzg <= 0) {
            return null;
        }
        int i10 = zzadcVar.zzd;
        long jZzt = zzet.zzt(iZzg, ((long) (i10 >= 32000 ? 1152 : 576)) * 1000000, i10, RoundingMode.FLOOR);
        int iZzq = zzekVar.zzq();
        int iZzq2 = zzekVar.zzq();
        int iZzq3 = zzekVar.zzq();
        zzekVar.zzL(2);
        long j12 = j11 + ((long) zzadcVar.zzc);
        long[] jArr = new long[iZzq];
        long[] jArr2 = new long[iZzq];
        int i11 = 0;
        long j13 = j11;
        while (i11 < iZzq) {
            long j14 = jZzt;
            jArr[i11] = (((long) i11) * jZzt) / ((long) iZzq);
            jArr2[i11] = Math.max(j13, j12);
            if (iZzq3 == 1) {
                iZzm = zzekVar.zzm();
            } else if (iZzq3 == 2) {
                iZzm = zzekVar.zzq();
            } else if (iZzq3 == 3) {
                iZzm = zzekVar.zzo();
            } else {
                if (iZzq3 != 4) {
                    return null;
                }
                iZzm = zzekVar.zzp();
            }
            j13 += ((long) iZzm) * ((long) iZzq2);
            i11++;
            jZzt = j14;
        }
        long j15 = jZzt;
        if (j10 != -1 && j10 != j13) {
            zzea.zzf("VbriSeeker", "VBRI data size mismatch: " + j10 + ", " + j13);
        }
        return new zzahs(jArr, jArr2, j15, j13, zzadcVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzahr
    public final int zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzahr
    public final long zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzahr
    public final long zze(long j10) {
        return this.zza[zzet.zzc(this.zzb, j10, true, true)];
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j10) {
        long[] jArr = this.zza;
        int iZzc = zzet.zzc(jArr, j10, true, true);
        zzadj zzadjVar = new zzadj(jArr[iZzc], this.zzb[iZzc]);
        if (zzadjVar.zzb < j10) {
            long[] jArr2 = this.zza;
            if (iZzc != jArr2.length - 1) {
                int i10 = iZzc + 1;
                return new zzadg(zzadjVar, new zzadj(jArr2[i10], this.zzb[i10]));
            }
        }
        return new zzadg(zzadjVar, zzadjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final boolean zzh() {
        return true;
    }
}

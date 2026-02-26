package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzabw implements zzadi {
    public final int zza;
    public final int[] zzb;
    public final long[] zzc;
    public final long[] zzd;
    public final long[] zze;
    private final long zzf;

    public zzabw(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzb = iArr;
        this.zzc = jArr;
        this.zzd = jArr2;
        this.zze = jArr3;
        int length = iArr.length;
        this.zza = length;
        if (length <= 0) {
            this.zzf = 0L;
        } else {
            int i10 = length - 1;
            this.zzf = jArr2[i10] + jArr3[i10];
        }
    }

    public final String toString() {
        long[] jArr = this.zzd;
        long[] jArr2 = this.zze;
        long[] jArr3 = this.zzc;
        return "ChunkIndex(length=" + this.zza + ", sizes=" + Arrays.toString(this.zzb) + ", offsets=" + Arrays.toString(jArr3) + ", timeUs=" + Arrays.toString(jArr2) + ", durationsUs=" + Arrays.toString(jArr) + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final long zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j10) {
        long[] jArr = this.zze;
        int iZzc = zzet.zzc(jArr, j10, true, true);
        zzadj zzadjVar = new zzadj(jArr[iZzc], this.zzc[iZzc]);
        if (zzadjVar.zzb >= j10 || iZzc == this.zza - 1) {
            return new zzadg(zzadjVar, zzadjVar);
        }
        int i10 = iZzc + 1;
        return new zzadg(zzadjVar, new zzadj(this.zze[i10], this.zzc[i10]));
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final boolean zzh() {
        return true;
    }
}

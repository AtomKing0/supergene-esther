package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaht {
    public final zzadc zza;
    public final long zzb;
    public final long zzc;
    public final int zzd;
    public final int zze;

    @Nullable
    public final long[] zzf;

    private zzaht(zzadc zzadcVar, long j10, long j11, @Nullable long[] jArr, int i10, int i11) {
        this.zza = new zzadc(zzadcVar);
        this.zzb = j10;
        this.zzc = j11;
        this.zzf = jArr;
        this.zzd = i10;
        this.zze = i11;
    }

    public static zzaht zzb(zzadc zzadcVar, zzek zzekVar) {
        long[] jArr;
        int i10;
        int i11;
        int iZzg = zzekVar.zzg();
        int iZzp = (iZzg & 1) != 0 ? zzekVar.zzp() : -1;
        long jZzu = (iZzg & 2) != 0 ? zzekVar.zzu() : -1L;
        if ((iZzg & 4) == 4) {
            long[] jArr2 = new long[100];
            for (int i12 = 0; i12 < 100; i12++) {
                jArr2[i12] = zzekVar.zzm();
            }
            jArr = jArr2;
        } else {
            jArr = null;
        }
        if ((iZzg & 8) != 0) {
            zzekVar.zzL(4);
        }
        if (zzekVar.zzb() >= 24) {
            zzekVar.zzL(21);
            int iZzo = zzekVar.zzo();
            i11 = iZzo & 4095;
            i10 = iZzo >> 12;
        } else {
            i10 = -1;
            i11 = -1;
        }
        return new zzaht(zzadcVar, iZzp, jZzu, jArr, i10, i11);
    }

    public final long zza() {
        long j10 = this.zzb;
        if (j10 == -1 || j10 == 0) {
            return C.TIME_UNSET;
        }
        return zzet.zzs((j10 * ((long) r4.zzg)) - 1, this.zza.zzd);
    }
}

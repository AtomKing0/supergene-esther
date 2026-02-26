package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzxx {
    private final int[] zza;
    private final zzwi[] zzb;
    private final int[] zzc;
    private final int[][][] zzd;
    private final zzwi zze;

    @VisibleForTesting
    zzxx(String[] strArr, int[] iArr, zzwi[] zzwiVarArr, int[] iArr2, int[][][] iArr3, zzwi zzwiVar) {
        this.zza = iArr;
        this.zzb = zzwiVarArr;
        this.zzd = iArr3;
        this.zzc = iArr2;
        this.zze = zzwiVar;
    }

    public final int zza(int i10, int i11, boolean z10) {
        int i12 = this.zzb[i10].zzb(i11).zza;
        int[] iArr = new int[i12];
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < i12; i15++) {
            if ((this.zzd[i10][i11][i15] & 7) == 4) {
                iArr[i14] = i15;
                i14++;
            }
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, i14);
        String str = null;
        int i16 = 0;
        int iMin = 16;
        boolean z11 = false;
        while (i13 < iArrCopyOf.length) {
            String str2 = this.zzb[i10].zzb(i11).zzb(iArrCopyOf[i13]).zzm;
            int i17 = i16 + 1;
            if (i16 == 0) {
                str = str2;
            } else {
                z11 |= !zzet.zzG(str, str2);
            }
            iMin = Math.min(iMin, this.zzd[i10][i11][i13] & 24);
            i13++;
            i16 = i17;
        }
        return z11 ? Math.min(iMin, this.zzc[i10]) : iMin;
    }

    public final int zzb(int i10, int i11, int i12) {
        return this.zzd[i10][i11][i12];
    }

    public final int zzc(int i10) {
        return this.zza[i10];
    }

    public final zzwi zzd(int i10) {
        return this.zzb[i10];
    }

    public final zzwi zze() {
        return this.zze;
    }
}

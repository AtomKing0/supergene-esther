package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzwp extends zzwr {
    protected zzwp(zzcd zzcdVar, int[] iArr, int i10, zzyj zzyjVar, long j10, long j11, long j12, int i11, int i12, float f10, float f11, List list, zzdj zzdjVar) {
        super(zzcdVar, iArr, 0);
        zzfxr.zzk(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* bridge */ /* synthetic */ zzfxr zzf(zzxu[] zzxuVarArr) {
        int i10;
        int i11;
        ArrayList arrayList = new ArrayList();
        int i12 = 0;
        int i13 = 0;
        while (true) {
            i10 = 2;
            i11 = 1;
            if (i13 >= 2) {
                break;
            }
            zzxu zzxuVar = zzxuVarArr[i13];
            if (zzxuVar == null || zzxuVar.zzb.length <= 1) {
                arrayList.add(null);
            } else {
                zzfxo zzfxoVar = new zzfxo();
                zzfxoVar.zzf(new zzwn(0L, 0L));
                arrayList.add(zzfxoVar);
            }
            i13++;
        }
        long[][] jArr = new long[2][];
        for (int i14 = 0; i14 < 2; i14++) {
            zzxu zzxuVar2 = zzxuVarArr[i14];
            if (zzxuVar2 == null) {
                jArr[i14] = new long[0];
            } else {
                jArr[i14] = new long[zzxuVar2.zzb.length];
                int i15 = 0;
                while (true) {
                    int[] iArr = zzxuVar2.zzb;
                    if (i15 >= iArr.length) {
                        break;
                    }
                    long j10 = zzxuVar2.zza.zzb(iArr[i15]).zzi;
                    long[] jArr2 = jArr[i14];
                    if (j10 == -1) {
                        j10 = 0;
                    }
                    jArr2[i15] = j10;
                    i15++;
                }
                Arrays.sort(jArr[i14]);
            }
        }
        int[] iArr2 = new int[2];
        long[] jArr3 = new long[2];
        for (int i16 = 0; i16 < 2; i16++) {
            long[] jArr4 = jArr[i16];
            jArr3[i16] = jArr4.length == 0 ? 0L : jArr4[0];
        }
        zzg(arrayList, jArr3);
        zzfyc zzfycVarZza = zzfyx.zzc(zzfzc.zzc()).zzb(2).zza();
        int i17 = 0;
        while (i17 < i10) {
            int length = jArr[i17].length;
            if (length > i11) {
                double[] dArr = new double[length];
                int i18 = i12;
                while (true) {
                    long[] jArr5 = jArr[i17];
                    double dLog = 0.0d;
                    if (i18 >= jArr5.length) {
                        break;
                    }
                    long j11 = jArr5[i18];
                    if (j11 != -1) {
                        dLog = Math.log(j11);
                    }
                    dArr[i18] = dLog;
                    i18++;
                }
                int i19 = length - 1;
                double d10 = dArr[i19] - dArr[i12];
                int i20 = i12;
                while (i20 < i19) {
                    double d11 = dArr[i20];
                    i20++;
                    zzfycVarZza.zzq(Double.valueOf(d10 == 0.0d ? 1.0d : (((d11 + dArr[i20]) * 0.5d) - dArr[i12]) / d10), Integer.valueOf(i17));
                    i12 = 0;
                }
            }
            i17++;
            i12 = 0;
            i10 = 2;
            i11 = 1;
        }
        zzfxr zzfxrVarZzk = zzfxr.zzk(zzfycVarZza.zzr());
        for (int i21 = 0; i21 < zzfxrVarZzk.size(); i21++) {
            int iIntValue = ((Integer) zzfxrVarZzk.get(i21)).intValue();
            int i22 = iArr2[iIntValue] + 1;
            iArr2[iIntValue] = i22;
            jArr3[iIntValue] = jArr[iIntValue][i22];
            zzg(arrayList, jArr3);
        }
        for (int i23 = 0; i23 < 2; i23++) {
            if (arrayList.get(i23) != null) {
                long j12 = jArr3[i23];
                jArr3[i23] = j12 + j12;
            }
        }
        zzg(arrayList, jArr3);
        zzfxo zzfxoVar2 = new zzfxo();
        for (int i24 = 0; i24 < arrayList.size(); i24++) {
            zzfxo zzfxoVar3 = (zzfxo) arrayList.get(i24);
            zzfxoVar2.zzf(zzfxoVar3 == null ? zzfxr.zzm() : zzfxoVar3.zzi());
        }
        return zzfxoVar2.zzi();
    }

    private static void zzg(List list, long[] jArr) {
        long j10 = 0;
        for (int i10 = 0; i10 < 2; i10++) {
            j10 += jArr[i10];
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            zzfxo zzfxoVar = (zzfxo) list.get(i11);
            if (zzfxoVar != null) {
                zzfxoVar.zzf(new zzwn(j10, jArr[i11]));
            }
        }
    }
}

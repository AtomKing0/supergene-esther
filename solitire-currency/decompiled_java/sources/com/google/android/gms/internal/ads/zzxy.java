package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzxy extends zzyb {
    protected abstract Pair zzd(zzxx zzxxVar, int[][][] iArr, int[] iArr2, zzui zzuiVar, zzcc zzccVar) throws zzhw;

    @Override // com.google.android.gms.internal.ads.zzyb
    public final zzyc zzo(zzlh[] zzlhVarArr, zzwi zzwiVar, zzui zzuiVar, zzcc zzccVar) throws zzhw {
        boolean z10;
        int[] iArr;
        int[] iArr2 = new int[3];
        zzcd[][] zzcdVarArr = new zzcd[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i10 = 0; i10 < 3; i10++) {
            int i11 = zzwiVar.zzb;
            zzcdVarArr[i10] = new zzcd[i11];
            iArr3[i10] = new int[i11][];
        }
        int i12 = 2;
        int[] iArr4 = new int[2];
        for (int i13 = 0; i13 < 2; i13++) {
            iArr4[i13] = zzlhVarArr[i13].zze();
        }
        int i14 = 0;
        while (i14 < zzwiVar.zzb) {
            zzcd zzcdVarZzb = zzwiVar.zzb(i14);
            int i15 = zzcdVarZzb.zzc;
            int i16 = i12;
            int i17 = 0;
            int i18 = 0;
            boolean z11 = true;
            while (i17 < i12) {
                zzlh zzlhVar = zzlhVarArr[i17];
                int iMax = 0;
                for (int i19 = 0; i19 < zzcdVarZzb.zza; i19++) {
                    iMax = Math.max(iMax, zzlhVar.zzY(zzcdVarZzb.zzb(i19)) & 7);
                }
                boolean z12 = iArr2[i17] == 0;
                if (iMax > i18) {
                    z11 = z12;
                    i16 = i17;
                    i18 = iMax;
                } else if (iMax == i18 && i15 == 5 && !z11 && z12) {
                    i16 = i17;
                    i18 = iMax;
                    z11 = true;
                }
                i17++;
                i12 = 2;
            }
            if (i16 == i12) {
                iArr = new int[zzcdVarZzb.zza];
            } else {
                zzlh zzlhVar2 = zzlhVarArr[i16];
                int[] iArr5 = new int[zzcdVarZzb.zza];
                for (int i20 = 0; i20 < zzcdVarZzb.zza; i20++) {
                    iArr5[i20] = zzlhVar2.zzY(zzcdVarZzb.zzb(i20));
                }
                iArr = iArr5;
            }
            int i21 = iArr2[i16];
            zzcdVarArr[i16][i21] = zzcdVarZzb;
            iArr3[i16][i21] = iArr;
            iArr2[i16] = i21 + 1;
            i14++;
            i12 = 2;
        }
        int i22 = i12;
        boolean z13 = true;
        zzwi[] zzwiVarArr = new zzwi[i22];
        String[] strArr = new String[i22];
        int[] iArr6 = new int[i22];
        int i23 = 0;
        while (i23 < i22) {
            int i24 = iArr2[i23];
            zzwiVarArr[i23] = new zzwi((zzcd[]) zzet.zzP(zzcdVarArr[i23], i24));
            iArr3[i23] = (int[][]) zzet.zzP(iArr3[i23], i24);
            strArr[i23] = zzlhVarArr[i23].zzU();
            iArr6[i23] = zzlhVarArr[i23].zzb();
            i23++;
            i22 = 2;
        }
        int i25 = i22;
        zzxx zzxxVar = new zzxx(strArr, iArr6, zzwiVarArr, iArr4, iArr3, new zzwi((zzcd[]) zzet.zzP(zzcdVarArr[i25], iArr2[i25])));
        Pair pairZzd = zzd(zzxxVar, iArr3, iArr4, zzuiVar, zzccVar);
        zzxz[] zzxzVarArr = (zzxz[]) pairZzd.second;
        List[] listArr = new List[zzxzVarArr.length];
        for (int i26 = 0; i26 < zzxzVarArr.length; i26++) {
            zzxz zzxzVar = zzxzVarArr[i26];
            listArr[i26] = zzxzVar != null ? zzfxr.zzn(zzxzVar) : zzfxr.zzm();
        }
        zzfxo zzfxoVar = new zzfxo();
        int i27 = 0;
        while (i27 < 2) {
            zzwi zzwiVarZzd = zzxxVar.zzd(i27);
            List list = listArr[i27];
            int i28 = 0;
            while (i28 < zzwiVarZzd.zzb) {
                zzcd zzcdVarZzb2 = zzwiVarZzd.zzb(i28);
                boolean z14 = zzxxVar.zza(i27, i28, false) != 0 ? z13 : false;
                int i29 = zzcdVarZzb2.zza;
                int[] iArr7 = new int[i29];
                boolean[] zArr = new boolean[i29];
                for (int i30 = 0; i30 < zzcdVarZzb2.zza; i30++) {
                    iArr7[i30] = zzxxVar.zzb(i27, i28, i30) & 7;
                    int i31 = 0;
                    while (true) {
                        if (i31 >= list.size()) {
                            z10 = false;
                            break;
                        }
                        zzxz zzxzVar2 = (zzxz) list.get(i31);
                        if (zzxzVar2.zze().equals(zzcdVarZzb2) && zzxzVar2.zzb(i30) != -1) {
                            z10 = true;
                            break;
                        }
                        i31++;
                    }
                    zArr[i30] = z10;
                }
                zzfxoVar.zzf(new zzcj(zzcdVarZzb2, z14, iArr7, zArr));
                i28++;
                z13 = true;
            }
            i27++;
            z13 = true;
        }
        zzwi zzwiVarZze = zzxxVar.zze();
        for (int i32 = 0; i32 < zzwiVarZze.zzb; i32++) {
            zzcd zzcdVarZzb3 = zzwiVarZze.zzb(i32);
            int[] iArr8 = new int[zzcdVarZzb3.zza];
            Arrays.fill(iArr8, 0);
            zzfxoVar.zzf(new zzcj(zzcdVarZzb3, false, iArr8, new boolean[zzcdVarZzb3.zza]));
        }
        return new zzyc((zzli[]) pairZzd.first, (zzxv[]) pairZzd.second, new zzck(zzfxoVar.zzi()), zzxxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzyb
    public final void zzp(@Nullable Object obj) {
    }
}

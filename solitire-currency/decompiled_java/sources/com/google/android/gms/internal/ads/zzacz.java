package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzacz {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final float zzh;

    @Nullable
    public final String zzi;

    private zzacz(List list, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, float f10, @Nullable String str) {
        this.zza = list;
        this.zzb = i10;
        this.zzc = i13;
        this.zzd = i14;
        this.zze = i15;
        this.zzf = i16;
        this.zzg = i17;
        this.zzh = f10;
        this.zzi = str;
    }

    public static zzacz zza(zzek zzekVar) throws zzbo {
        int i10;
        int i11;
        int i12;
        try {
            zzekVar.zzL(21);
            int iZzm = zzekVar.zzm() & 3;
            int iZzm2 = zzekVar.zzm();
            int iZzd = zzekVar.zzd();
            int i13 = 0;
            int i14 = 0;
            for (int i15 = 0; i15 < iZzm2; i15++) {
                zzekVar.zzL(1);
                int iZzq = zzekVar.zzq();
                for (int i16 = 0; i16 < iZzq; i16++) {
                    int iZzq2 = zzekVar.zzq();
                    i14 += iZzq2 + 4;
                    zzekVar.zzL(iZzq2);
                }
            }
            zzekVar.zzK(iZzd);
            byte[] bArr = new byte[i14];
            int i17 = -1;
            int i18 = -1;
            int i19 = -1;
            int i20 = -1;
            int i21 = -1;
            int i22 = -1;
            int i23 = -1;
            String strZzb = null;
            float f10 = 1.0f;
            int i24 = 0;
            int i25 = 0;
            while (i24 < iZzm2) {
                int iZzm3 = zzekVar.zzm() & 63;
                int iZzq3 = zzekVar.zzq();
                int i26 = i13;
                while (i26 < iZzq3) {
                    int iZzq4 = zzekVar.zzq();
                    int i27 = iZzm2;
                    System.arraycopy(zzfh.zza, i13, bArr, i25, 4);
                    int i28 = i25 + 4;
                    System.arraycopy(zzekVar.zzM(), zzekVar.zzd(), bArr, i28, iZzq4);
                    int i29 = i28 + iZzq4;
                    if (iZzm3 == 33 && i26 == 0) {
                        zzfe zzfeVarZzc = zzfh.zzc(bArr, i28 + 2, i29);
                        i17 = zzfeVarZzc.zzi;
                        i18 = zzfeVarZzc.zzj;
                        i19 = zzfeVarZzc.zze + 8;
                        i20 = zzfeVarZzc.zzf + 8;
                        int i30 = zzfeVarZzc.zzl;
                        int i31 = zzfeVarZzc.zzm;
                        int i32 = zzfeVarZzc.zzn;
                        i10 = i29;
                        float f11 = zzfeVarZzc.zzk;
                        i11 = iZzm3;
                        i12 = iZzq3;
                        strZzb = zzdk.zzb(zzfeVarZzc.zza, zzfeVarZzc.zzb, zzfeVarZzc.zzc, zzfeVarZzc.zzd, zzfeVarZzc.zzg, zzfeVarZzc.zzh);
                        f10 = f11;
                        i21 = i30;
                        i23 = i32;
                        i22 = i31;
                        i26 = 0;
                    } else {
                        i10 = i29;
                        i11 = iZzm3;
                        i12 = iZzq3;
                    }
                    zzekVar.zzL(iZzq4);
                    i26++;
                    iZzm2 = i27;
                    i25 = i10;
                    iZzm3 = i11;
                    iZzq3 = i12;
                    i13 = 0;
                }
                i24++;
                i13 = 0;
            }
            return new zzacz(i14 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), iZzm + 1, i17, i18, i19, i20, i21, i22, i23, f10, strZzb);
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw zzbo.zza("Error parsing HEVC config", e10);
        }
    }
}

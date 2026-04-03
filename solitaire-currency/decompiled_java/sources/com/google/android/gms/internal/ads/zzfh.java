package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfh {
    public static final byte[] zza = {0, 0, 0, 1};
    public static final float[] zzb = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object zzc = new Object();
    private static int[] zzd = new int[10];

    public static int zza(byte[] bArr, int i10, int i11, boolean[] zArr) {
        int i12 = i11 - i10;
        zzdi.zzf(i12 >= 0);
        if (i12 == 0) {
            return i11;
        }
        if (zArr[0]) {
            zzf(zArr);
            return i10 - 3;
        }
        if (i12 > 1 && zArr[1] && bArr[i10] == 1) {
            zzf(zArr);
            return i10 - 2;
        }
        if (i12 > 2 && zArr[2] && bArr[i10] == 0 && bArr[i10 + 1] == 1) {
            zzf(zArr);
            return i10 - 1;
        }
        int i13 = i11 - 1;
        int i14 = i10 + 2;
        while (i14 < i13) {
            byte b10 = bArr[i14];
            if ((b10 & 254) == 0) {
                int i15 = i14 - 2;
                if (bArr[i15] == 0 && bArr[i14 - 1] == 0 && b10 == 1) {
                    zzf(zArr);
                    return i15;
                }
                i14 = i15;
            }
            i14 += 3;
        }
        zArr[0] = i12 <= 2 ? !(i12 != 2 ? !(zArr[1] && bArr[i13] == 1) : !(zArr[2] && bArr[i11 + (-2)] == 0 && bArr[i13] == 1)) : bArr[i11 + (-3)] == 0 && bArr[i11 + (-2)] == 0 && bArr[i13] == 1;
        zArr[1] = i12 <= 1 ? zArr[2] && bArr[i13] == 0 : bArr[i11 + (-2)] == 0 && bArr[i13] == 0;
        zArr[2] = bArr[i13] == 0;
        return i11;
    }

    public static int zzb(byte[] bArr, int i10) {
        int i11;
        synchronized (zzc) {
            int i12 = 0;
            int i13 = 0;
            while (i12 < i10) {
                while (true) {
                    try {
                        if (i12 >= i10 - 2) {
                            i12 = i10;
                            break;
                        }
                        int i14 = i12 + 1;
                        if (bArr[i12] == 0 && bArr[i14] == 0 && bArr[i12 + 2] == 3) {
                            break;
                        }
                        i12 = i14;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i12 < i10) {
                    int[] iArr = zzd;
                    int length = iArr.length;
                    if (length <= i13) {
                        zzd = Arrays.copyOf(iArr, length + length);
                    }
                    zzd[i13] = i12;
                    i12 += 3;
                    i13++;
                }
            }
            i11 = i10 - i13;
            int i15 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < i13; i17++) {
                int i18 = zzd[i17] - i15;
                System.arraycopy(bArr, i15, bArr, i16, i18);
                int i19 = i16 + i18;
                int i20 = i19 + 1;
                bArr[i19] = 0;
                i16 = i20 + 1;
                bArr[i20] = 0;
                i15 += i18 + 3;
            }
            System.arraycopy(bArr, i15, bArr, i16, i11 - i16);
        }
        return i11;
    }

    public static zzfe zzc(byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int iZzb;
        int i15;
        int i16;
        int i17;
        int[] iArr;
        int i18;
        int i19;
        zzfi zzfiVar = new zzfi(bArr, i10, i11);
        int i20 = 4;
        zzfiVar.zze(4);
        int iZza = zzfiVar.zza(3);
        zzfiVar.zzd();
        int iZza2 = zzfiVar.zza(2);
        boolean zZzf = zzfiVar.zzf();
        int iZza3 = zzfiVar.zza(5);
        int i21 = 0;
        for (int i22 = 0; i22 < 32; i22++) {
            if (zzfiVar.zzf()) {
                i21 |= 1 << i22;
            }
        }
        int i23 = 6;
        int[] iArr2 = new int[6];
        for (int i24 = 0; i24 < 6; i24++) {
            iArr2[i24] = zzfiVar.zza(8);
        }
        int iZza4 = zzfiVar.zza(8);
        int i25 = 0;
        for (int i26 = 0; i26 < iZza; i26++) {
            if (zzfiVar.zzf()) {
                i25 += 89;
            }
            if (zzfiVar.zzf()) {
                i25 += 8;
            }
        }
        zzfiVar.zze(i25);
        if (iZza > 0) {
            int i27 = 8 - iZza;
            zzfiVar.zze(i27 + i27);
        }
        int iZzc = zzfiVar.zzc();
        int iZzc2 = zzfiVar.zzc();
        if (iZzc2 == 3) {
            zzfiVar.zzd();
            iZzc2 = 3;
        }
        int iZzc3 = zzfiVar.zzc();
        int iZzc4 = zzfiVar.zzc();
        if (zzfiVar.zzf()) {
            int iZzc5 = zzfiVar.zzc();
            int iZzc6 = zzfiVar.zzc();
            int iZzc7 = zzfiVar.zzc();
            int iZzc8 = zzfiVar.zzc();
            if (iZzc2 == 1) {
                i19 = 2;
            } else if (iZzc2 == 2) {
                iZzc2 = 2;
                i19 = 2;
            } else {
                i19 = 1;
            }
            iZzc3 -= i19 * (iZzc5 + iZzc6);
            iZzc4 -= (iZzc2 == 1 ? 2 : 1) * (iZzc7 + iZzc8);
        }
        int i28 = iZzc3;
        int i29 = iZzc2;
        int i30 = iZzc4;
        int iZzc9 = zzfiVar.zzc();
        int iZzc10 = zzfiVar.zzc();
        int iZzc11 = zzfiVar.zzc();
        for (int i31 = true != zzfiVar.zzf() ? iZza : 0; i31 <= iZza; i31++) {
            zzfiVar.zzc();
            zzfiVar.zzc();
            zzfiVar.zzc();
        }
        zzfiVar.zzc();
        zzfiVar.zzc();
        zzfiVar.zzc();
        zzfiVar.zzc();
        zzfiVar.zzc();
        zzfiVar.zzc();
        if (zzfiVar.zzf() && zzfiVar.zzf()) {
            int i32 = 0;
            while (i32 < i20) {
                int i33 = 0;
                while (i33 < i23) {
                    if (zzfiVar.zzf()) {
                        int iMin = Math.min(64, 1 << ((i32 + i32) + 4));
                        if (i32 > 1) {
                            zzfiVar.zzb();
                        }
                        for (int i34 = 0; i34 < iMin; i34++) {
                            zzfiVar.zzb();
                        }
                    } else {
                        zzfiVar.zzc();
                    }
                    i33 += i32 == 3 ? 3 : 1;
                    i23 = 6;
                }
                i32++;
                i20 = 4;
                i23 = 6;
            }
        }
        zzfiVar.zze(2);
        if (zzfiVar.zzf()) {
            zzfiVar.zze(8);
            zzfiVar.zzc();
            zzfiVar.zzc();
            zzfiVar.zzd();
        }
        int iZzc12 = zzfiVar.zzc();
        int i35 = 0;
        int[] iArr3 = new int[0];
        int[] iArrCopyOf = new int[0];
        int i36 = -1;
        int i37 = -1;
        int i38 = -1;
        while (i35 < iZzc12) {
            if (i35 == 0 || !zzfiVar.zzf()) {
                i15 = iZzc12;
                i16 = i21;
                i17 = i29;
                iArr = iArr2;
                int iZzc13 = zzfiVar.zzc();
                int iZzc14 = zzfiVar.zzc();
                int[] iArr4 = new int[iZzc13];
                int i39 = 0;
                while (i39 < iZzc13) {
                    iArr4[i39] = (i39 > 0 ? iArr4[i39 - 1] : 0) - (zzfiVar.zzc() + 1);
                    zzfiVar.zzd();
                    i39++;
                }
                int[] iArr5 = new int[iZzc14];
                int i40 = 0;
                while (i40 < iZzc14) {
                    iArr5[i40] = (i40 > 0 ? iArr5[i40 - 1] : 0) + zzfiVar.zzc() + 1;
                    zzfiVar.zzd();
                    i40++;
                }
                i38 = iZzc14;
                iArrCopyOf = iArr5;
                i37 = iZzc13;
                iArr3 = iArr4;
            } else {
                int i41 = i37 + i38;
                boolean zZzf2 = zzfiVar.zzf();
                int iZzc15 = zzfiVar.zzc() + 1;
                int i42 = 1 - ((zZzf2 ? 1 : 0) + (zZzf2 ? 1 : 0));
                int i43 = i41 + 1;
                i15 = iZzc12;
                boolean[] zArr = new boolean[i43];
                iArr = iArr2;
                for (int i44 = 0; i44 <= i41; i44++) {
                    if (zzfiVar.zzf()) {
                        zArr[i44] = true;
                    } else {
                        zArr[i44] = zzfiVar.zzf();
                    }
                }
                int i45 = i38 - 1;
                int[] iArr6 = new int[i43];
                int[] iArr7 = new int[i43];
                int i46 = 0;
                while (true) {
                    i18 = i42 * iZzc15;
                    if (i45 < 0) {
                        break;
                    }
                    int i47 = iArrCopyOf[i45] + i18;
                    if (i47 < 0 && zArr[i37 + i45]) {
                        iArr6[i46] = i47;
                        i46++;
                    }
                    i45--;
                }
                if (i18 < 0 && zArr[i41]) {
                    iArr6[i46] = i18;
                    i46++;
                }
                i16 = i21;
                i17 = i29;
                int i48 = i46;
                for (int i49 = 0; i49 < i37; i49++) {
                    int i50 = iArr3[i49] + i18;
                    if (i50 < 0 && zArr[i49]) {
                        iArr6[i48] = i50;
                        i48++;
                    }
                }
                int[] iArrCopyOf2 = Arrays.copyOf(iArr6, i48);
                int i51 = 0;
                for (int i52 = i37 - 1; i52 >= 0; i52--) {
                    int i53 = iArr3[i52] + i18;
                    if (i53 > 0 && zArr[i52]) {
                        iArr7[i51] = i53;
                        i51++;
                    }
                }
                if (i18 > 0 && zArr[i41]) {
                    iArr7[i51] = i18;
                    i51++;
                }
                int i54 = i51;
                for (int i55 = 0; i55 < i38; i55++) {
                    int i56 = iArrCopyOf[i55] + i18;
                    if (i56 > 0 && zArr[i37 + i55]) {
                        iArr7[i54] = i56;
                        i54++;
                    }
                }
                iArrCopyOf = Arrays.copyOf(iArr7, i54);
                i38 = i54;
                iArr3 = iArrCopyOf2;
                i37 = i48;
            }
            i35++;
            i29 = i17;
            i21 = i16;
            iZzc12 = i15;
            iArr2 = iArr;
        }
        int i57 = i21;
        int i58 = i29;
        int[] iArr8 = iArr2;
        if (zzfiVar.zzf()) {
            int iZzc16 = zzfiVar.zzc();
            for (int i59 = 0; i59 < iZzc16; i59++) {
                zzfiVar.zze(iZzc11 + 5);
            }
        }
        zzfiVar.zze(2);
        float f10 = 1.0f;
        if (zzfiVar.zzf()) {
            if (zzfiVar.zzf()) {
                int iZza5 = zzfiVar.zza(8);
                if (iZza5 == 255) {
                    int iZza6 = zzfiVar.zza(16);
                    int iZza7 = zzfiVar.zza(16);
                    if (iZza6 != 0 && iZza7 != 0) {
                        f10 = iZza6 / iZza7;
                    }
                } else if (iZza5 < 17) {
                    f10 = zzb[iZza5];
                } else {
                    zzea.zzf("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iZza5);
                }
            }
            if (zzfiVar.zzf()) {
                zzfiVar.zzd();
            }
            if (zzfiVar.zzf()) {
                zzfiVar.zze(3);
                int i60 = true != zzfiVar.zzf() ? 2 : 1;
                if (zzfiVar.zzf()) {
                    int iZza8 = zzfiVar.zza(8);
                    int iZza9 = zzfiVar.zza(8);
                    zzfiVar.zze(8);
                    int iZza10 = zzo.zza(iZza8);
                    iZzb = zzo.zzb(iZza9);
                    i13 = iZza10;
                } else {
                    i13 = -1;
                    iZzb = -1;
                }
                i36 = i60;
            } else {
                i13 = -1;
                iZzb = -1;
            }
            if (zzfiVar.zzf()) {
                zzfiVar.zzc();
                zzfiVar.zzc();
            }
            zzfiVar.zzd();
            if (zzfiVar.zzf()) {
                i30 += i30;
            }
            i14 = iZzb;
            i12 = i30;
        } else {
            i12 = i30;
            i13 = -1;
            i14 = -1;
        }
        return new zzfe(iZza2, zZzf, iZza3, i57, i58, iZzc9, iZzc10, iArr8, iZza4, iZzc, i28, i12, f10, i13, i36, i14);
    }

    public static zzff zzd(byte[] bArr, int i10, int i11) {
        zzfi zzfiVar = new zzfi(bArr, 4, i11);
        int iZzc = zzfiVar.zzc();
        int iZzc2 = zzfiVar.zzc();
        zzfiVar.zzd();
        return new zzff(iZzc, iZzc2, zzfiVar.zzf());
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzfg zze(byte[] r26, int r27, int r28) {
        /*
            Method dump skipped, instruction units count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfh.zze(byte[], int, int):com.google.android.gms.internal.ads.zzfg");
    }

    public static void zzf(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }
}

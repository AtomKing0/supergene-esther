package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgki {
    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        long jZzb = zzb(bArr, 0, 0);
        long jZzb2 = zzb(bArr, 3, 2) & 67108611;
        long jZzb3 = zzb(bArr, 6, 4) & 67092735;
        long jZzb4 = zzb(bArr, 9, 6) & 66076671;
        long jZzb5 = zzb(bArr, 12, 8) & 1048575;
        int i10 = 17;
        byte[] bArr3 = new byte[17];
        long j10 = 0;
        int i11 = 0;
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        long j14 = 0;
        while (true) {
            int length = bArr2.length;
            if (i11 >= length) {
                long j15 = j10 + (j11 >> 26);
                long j16 = j15 & 67108863;
                long j17 = j12 + (j15 >> 26);
                long j18 = j17 & 67108863;
                long j19 = j13 + (j17 >> 26);
                long j20 = j19 & 67108863;
                long j21 = j14 + ((j19 >> 26) * 5);
                long j22 = j21 & 67108863;
                long j23 = j22 + 5;
                long j24 = (j11 & 67108863) + (j21 >> 26);
                long j25 = j24 + (j23 >> 26);
                long j26 = (j25 >> 26) + j16;
                long j27 = j18 + (j26 >> 26);
                long j28 = (j20 + (j27 >> 26)) - 67108864;
                long j29 = j28 >> 63;
                long j30 = ~j29;
                long j31 = (j24 & j29) | (j25 & 67108863 & j30);
                long j32 = (j16 & j29) | (j26 & 67108863 & j30);
                long j33 = (j18 & j29) | (j27 & 67108863 & j30);
                long j34 = (j20 & j29) | (j28 & j30);
                long jZzc = (((j29 & j22) | (j23 & 67108863 & j30) | (j31 << 26)) & 4294967295L) + zzc(bArr, 16);
                long jZzc2 = (((j31 >> 6) | (j32 << 20)) & 4294967295L) + zzc(bArr, 20);
                long jZzc3 = (((j32 >> 12) | (j33 << 14)) & 4294967295L) + zzc(bArr, 24);
                long jZzc4 = (((j33 >> 18) | (j34 << 8)) & 4294967295L) + zzc(bArr, 28);
                byte[] bArr4 = new byte[16];
                zzd(bArr4, jZzc & 4294967295L, 0);
                long j35 = jZzc2 + (jZzc >> 32);
                zzd(bArr4, j35 & 4294967295L, 4);
                long j36 = jZzc3 + (j35 >> 32);
                zzd(bArr4, j36 & 4294967295L, 8);
                zzd(bArr4, (jZzc4 + (j36 >> 32)) & 4294967295L, 12);
                return bArr4;
            }
            int iMin = Math.min(16, length - i11);
            System.arraycopy(bArr2, i11, bArr3, 0, iMin);
            bArr3[iMin] = 1;
            if (iMin != 16) {
                Arrays.fill(bArr3, iMin + 1, i10, (byte) 0);
            }
            long j37 = jZzb5 * 5;
            long j38 = jZzb4 * 5;
            long j39 = jZzb3 * 5;
            long jZzb6 = j14 + zzb(bArr3, 0, 0);
            long jZzb7 = j11 + zzb(bArr3, 3, 2);
            long jZzb8 = j10 + zzb(bArr3, 6, 4);
            long jZzb9 = j12 + zzb(bArr3, 9, 6);
            long jZzb10 = j13 + (zzb(bArr3, 12, 8) | ((long) (bArr3[16] << 24)));
            long j40 = jZzb7 * jZzb;
            long j41 = jZzb7 * jZzb2;
            long j42 = jZzb7 * jZzb3;
            long j43 = jZzb9 * jZzb;
            long j44 = jZzb7 * jZzb4;
            long j45 = jZzb10 * jZzb;
            long j46 = (jZzb6 * jZzb) + (jZzb7 * j37) + (jZzb8 * j38) + (jZzb9 * j39) + (jZzb2 * 5 * jZzb10);
            long j47 = (jZzb6 * jZzb2) + j40 + (jZzb8 * j37) + (jZzb9 * j38) + (j39 * jZzb10) + (j46 >> 26);
            long j48 = (jZzb6 * jZzb3) + j41 + (jZzb8 * jZzb) + (jZzb9 * j37) + (j38 * jZzb10) + (j47 >> 26);
            long j49 = (jZzb6 * jZzb4) + j42 + (jZzb8 * jZzb2) + j43 + (jZzb10 * j37) + (j48 >> 26);
            long j50 = (jZzb6 * jZzb5) + j44 + (jZzb8 * jZzb3) + (jZzb9 * jZzb2) + j45 + (j49 >> 26);
            long j51 = (j46 & 67108863) + ((j50 >> 26) * 5);
            j11 = (j47 & 67108863) + (j51 >> 26);
            i11 += 16;
            j10 = j48 & 67108863;
            j12 = j49 & 67108863;
            j13 = j50 & 67108863;
            i10 = 17;
            j14 = j51 & 67108863;
        }
    }

    private static long zzb(byte[] bArr, int i10, int i11) {
        return (zzc(bArr, i10) >> i11) & 67108863;
    }

    private static long zzc(byte[] bArr, int i10) {
        int i11 = bArr[i10] & 255;
        int i12 = bArr[i10 + 1] & 255;
        int i13 = bArr[i10 + 2] & 255;
        return ((long) (((bArr[i10 + 3] & 255) << 24) | (i12 << 8) | i11 | (i13 << 16))) & 4294967295L;
    }

    private static void zzd(byte[] bArr, long j10, int i10) {
        for (int i11 = 0; i11 < 4; i11++) {
            bArr[i10 + i11] = (byte) (255 & j10);
            j10 >>= 8;
        }
    }
}

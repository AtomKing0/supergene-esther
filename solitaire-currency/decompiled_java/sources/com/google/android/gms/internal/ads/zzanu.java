package com.google.android.gms.internal.ads;

import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzanu {
    public static int zza(byte[] bArr, int i10, int i11) {
        while (i10 < i11 && bArr[i10] != 71) {
            i10++;
        }
        return i10;
    }

    public static long zzb(zzek zzekVar, int i10, int i11) {
        zzekVar.zzK(i10);
        if (zzekVar.zzb() < 5) {
            return C.TIME_UNSET;
        }
        int iZzg = zzekVar.zzg();
        if ((8388608 & iZzg) != 0 || ((iZzg >> 8) & 8191) != i11 || (iZzg & 32) == 0 || zzekVar.zzm() < 7 || zzekVar.zzb() < 7 || (zzekVar.zzm() & 16) != 16) {
            return C.TIME_UNSET;
        }
        byte[] bArr = new byte[6];
        zzekVar.zzG(bArr, 0, 6);
        long j10 = bArr[0];
        long j11 = bArr[1];
        long j12 = bArr[2];
        long j13 = bArr[3] & 255;
        return ((j10 & 255) << 25) | ((j11 & 255) << 17) | ((j12 & 255) << 9) | (j13 + j13) | ((((long) bArr[4]) & 255) >> 7);
    }
}

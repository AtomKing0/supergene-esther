package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zznc {
    private static boolean zza(byte b10) {
        return b10 > -65;
    }

    static /* synthetic */ void zza(byte b10, byte b11, byte b12, byte b13, char[] cArr, int i10) throws zzkb {
        if (zza(b11) || (((b10 << 28) + (b11 + 112)) >> 30) != 0 || zza(b12) || zza(b13)) {
            throw zzkb.zzd();
        }
        int i11 = ((b10 & 7) << 18) | ((b11 & 63) << 12) | ((b12 & 63) << 6) | (b13 & 63);
        cArr[i10] = (char) ((i11 >>> 10) + 55232);
        cArr[i10 + 1] = (char) ((i11 & 1023) + 56320);
    }

    static /* synthetic */ void zza(byte b10, char[] cArr, int i10) {
        cArr[i10] = (char) b10;
    }

    static /* synthetic */ void zza(byte b10, byte b11, byte b12, char[] cArr, int i10) throws zzkb {
        if (!zza(b11) && ((b10 != -32 || b11 >= -96) && ((b10 != -19 || b11 < -96) && !zza(b12)))) {
            cArr[i10] = (char) (((b10 & 15) << 12) | ((b11 & 63) << 6) | (b12 & 63));
            return;
        }
        throw zzkb.zzd();
    }

    static /* synthetic */ void zza(byte b10, byte b11, char[] cArr, int i10) throws zzkb {
        if (b10 >= -62 && !zza(b11)) {
            cArr[i10] = (char) (((b10 & 31) << 6) | (b11 & 63));
            return;
        }
        throw zzkb.zzd();
    }
}

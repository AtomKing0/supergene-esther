package com.google.android.gms.internal.drive;

/* JADX INFO: loaded from: classes3.dex */
final class zzng {
    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(byte b10, char[] cArr, int i10) {
        cArr[i10] = (char) b10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzd(byte b10) {
        return b10 >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zze(byte b10) {
        return b10 < -32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzf(byte b10) {
        return b10 < -16;
    }

    private static boolean zzg(byte b10) {
        return b10 > -65;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(byte b10, byte b11, char[] cArr, int i10) throws zzkq {
        if (b10 < -62 || zzg(b11)) {
            throw zzkq.zzdn();
        }
        cArr[i10] = (char) (((b10 & 31) << 6) | (b11 & 63));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(byte b10, byte b11, byte b12, char[] cArr, int i10) throws zzkq {
        if (!zzg(b11) && ((b10 != -32 || b11 >= -96) && ((b10 != -19 || b11 < -96) && !zzg(b12)))) {
            cArr[i10] = (char) (((b10 & 15) << 12) | ((b11 & 63) << 6) | (b12 & 63));
            return;
        }
        throw zzkq.zzdn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(byte b10, byte b11, byte b12, byte b13, char[] cArr, int i10) throws zzkq {
        if (!zzg(b11) && (((b10 << 28) + (b11 + 112)) >> 30) == 0 && !zzg(b12) && !zzg(b13)) {
            int i11 = ((b10 & 7) << 18) | ((b11 & 63) << 12) | ((b12 & 63) << 6) | (b13 & 63);
            cArr[i10] = (char) ((i11 >>> 10) + 55232);
            cArr[i10 + 1] = (char) ((i11 & 1023) + 56320);
            return;
        }
        throw zzkq.zzdn();
    }
}

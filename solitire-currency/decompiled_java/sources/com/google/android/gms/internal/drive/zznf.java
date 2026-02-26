package com.google.android.gms.internal.drive;

/* JADX INFO: loaded from: classes3.dex */
final class zznf {
    private static final zznh zzwt;

    static {
        zzwt = (!(zznd.zzfd() && zznd.zzfe()) || zzix.zzbr()) ? new zzni() : new zznk();
    }

    static int zza(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        int i11 = 0;
        while (i11 < length && charSequence.charAt(i11) < 128) {
            i11++;
        }
        int i12 = length;
        while (true) {
            if (i11 >= length) {
                break;
            }
            char cCharAt = charSequence.charAt(i11);
            if (cCharAt < 2048) {
                i12 += (127 - cCharAt) >>> 31;
                i11++;
            } else {
                int length2 = charSequence.length();
                while (i11 < length2) {
                    char cCharAt2 = charSequence.charAt(i11);
                    if (cCharAt2 < 2048) {
                        i10 += (127 - cCharAt2) >>> 31;
                    } else {
                        i10 += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i11) < 65536) {
                                throw new zznj(i11, length2);
                            }
                            i11++;
                        }
                    }
                    i11++;
                }
                i12 += i10;
            }
        }
        if (i12 >= length) {
            return i12;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(((long) i12) + 4294967296L);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzay(int i10) {
        if (i10 > -12) {
            return -1;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzc(int i10, int i11, int i12) {
        if (i10 > -12 || i11 > -65 || i12 > -65) {
            return -1;
        }
        return (i10 ^ (i11 << 8)) ^ (i12 << 16);
    }

    public static boolean zzd(byte[] bArr) {
        return zzwt.zze(bArr, 0, bArr.length);
    }

    public static boolean zze(byte[] bArr, int i10, int i11) {
        return zzwt.zze(bArr, i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzf(byte[] bArr, int i10, int i11) {
        byte b10 = bArr[i10 - 1];
        int i12 = i11 - i10;
        if (i12 == 0) {
            return zzay(b10);
        }
        if (i12 == 1) {
            return zzr(b10, bArr[i10]);
        }
        if (i12 == 2) {
            return zzc(b10, bArr[i10], bArr[i10 + 1]);
        }
        throw new AssertionError();
    }

    static String zzg(byte[] bArr, int i10, int i11) throws zzkq {
        return zzwt.zzg(bArr, i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzr(int i10, int i11) {
        if (i10 > -12 || i11 > -65) {
            return -1;
        }
        return i10 ^ (i11 << 8);
    }

    static int zza(CharSequence charSequence, byte[] bArr, int i10, int i11) {
        return zzwt.zzb(charSequence, bArr, i10, i11);
    }
}

package com.google.android.gms.internal.ads;

import androidx.media3.extractor.ts.PsExtractor;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhbe {
    private static final zzhbb zza;

    static {
        if (zzhaz.zzA() && zzhaz.zzB()) {
            int i10 = zzgvz.zza;
        }
        zza = new zzhbc();
    }

    static /* bridge */ /* synthetic */ int zzc(byte[] bArr, int i10, int i11) {
        int i12 = i11 - i10;
        byte b10 = bArr[i10 - 1];
        if (i12 == 0) {
            if (b10 > -12) {
                return -1;
            }
            return b10;
        }
        if (i12 == 1) {
            return zzj(b10, bArr[i10]);
        }
        if (i12 == 2) {
            return zzk(b10, bArr[i10], bArr[i10 + 1]);
        }
        throw new AssertionError();
    }

    static int zzd(String str, byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        char cCharAt;
        int length = str.length();
        int i15 = 0;
        while (true) {
            i12 = i10 + i11;
            if (i15 >= length || (i14 = i15 + i10) >= i12 || (cCharAt = str.charAt(i15)) >= 128) {
                break;
            }
            bArr[i14] = (byte) cCharAt;
            i15++;
        }
        if (i15 == length) {
            return i10 + length;
        }
        int i16 = i10 + i15;
        while (i15 < length) {
            char cCharAt2 = str.charAt(i15);
            if (cCharAt2 < 128 && i16 < i12) {
                bArr[i16] = (byte) cCharAt2;
                i16++;
            } else if (cCharAt2 < 2048 && i16 <= i12 - 2) {
                int i17 = i16 + 1;
                bArr[i16] = (byte) ((cCharAt2 >>> 6) | 960);
                bArr[i17] = (byte) ((cCharAt2 & '?') | 128);
                i16 = i17 + 1;
            } else {
                if ((cCharAt2 >= 55296 && cCharAt2 <= 57343) || i16 > i12 - 3) {
                    if (i16 > i12 - 4) {
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343 && ((i13 = i15 + 1) == str.length() || !Character.isSurrogatePair(cCharAt2, str.charAt(i13)))) {
                            throw new zzhbd(i15, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i16);
                    }
                    int i18 = i15 + 1;
                    if (i18 != str.length()) {
                        char cCharAt3 = str.charAt(i18);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int i19 = i16 + 1;
                            int i20 = i19 + 1;
                            int i21 = i20 + 1;
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i16] = (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK);
                            bArr[i19] = (byte) (((codePoint >>> 12) & 63) | 128);
                            bArr[i20] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i16 = i21 + 1;
                            bArr[i21] = (byte) ((codePoint & 63) | 128);
                            i15 = i18;
                        } else {
                            i15 = i18;
                        }
                    }
                    throw new zzhbd(i15 - 1, length);
                }
                int i22 = i16 + 1;
                int i23 = i22 + 1;
                bArr[i16] = (byte) ((cCharAt2 >>> '\f') | 480);
                bArr[i22] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                bArr[i23] = (byte) ((cCharAt2 & '?') | 128);
                i16 = i23 + 1;
            }
            i15++;
        }
        return i16;
    }

    static int zze(String str) {
        int length = str.length();
        int i10 = 0;
        int i11 = 0;
        while (i11 < length && str.charAt(i11) < 128) {
            i11++;
        }
        int i12 = length;
        while (true) {
            if (i11 >= length) {
                break;
            }
            char cCharAt = str.charAt(i11);
            if (cCharAt < 2048) {
                i12 += (127 - cCharAt) >>> 31;
                i11++;
            } else {
                int length2 = str.length();
                while (i11 < length2) {
                    char cCharAt2 = str.charAt(i11);
                    if (cCharAt2 < 2048) {
                        i10 += (127 - cCharAt2) >>> 31;
                    } else {
                        i10 += 2;
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i11) < 65536) {
                                throw new zzhbd(i11, length2);
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
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i12) + 4294967296L));
    }

    static int zzf(int i10, byte[] bArr, int i11, int i12) {
        return zza.zza(i10, bArr, i11, i12);
    }

    static String zzg(ByteBuffer byteBuffer, int i10, int i11) throws zzgyn {
        zzhbb zzhbbVar = zza;
        if (byteBuffer.hasArray()) {
            return zzhbbVar.zzb(byteBuffer.array(), byteBuffer.arrayOffset() + i10, i11);
        }
        return byteBuffer.isDirect() ? zzhbb.zzc(byteBuffer, i10, i11) : zzhbb.zzc(byteBuffer, i10, i11);
    }

    static String zzh(byte[] bArr, int i10, int i11) throws zzgyn {
        return zza.zzb(bArr, i10, i11);
    }

    static boolean zzi(byte[] bArr, int i10, int i11) {
        return zza.zza(0, bArr, i10, i11) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzj(int i10, int i11) {
        if (i10 > -12 || i11 > -65) {
            return -1;
        }
        return i10 ^ (i11 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzk(int i10, int i11, int i12) {
        if (i10 > -12 || i11 > -65 || i12 > -65) {
            return -1;
        }
        return (i10 ^ (i11 << 8)) ^ (i12 << 16);
    }
}

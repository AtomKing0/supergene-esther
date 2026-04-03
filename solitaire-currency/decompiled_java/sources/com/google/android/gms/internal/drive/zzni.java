package com.google.android.gms.internal.drive;

import androidx.media3.extractor.ts.PsExtractor;

/* JADX INFO: loaded from: classes3.dex */
final class zzni extends zznh {
    zzni() {
    }

    @Override // com.google.android.gms.internal.drive.zznh
    final int zzb(int i10, byte[] bArr, int i11, int i12) {
        while (i11 < i12 && bArr[i11] >= 0) {
            i11++;
        }
        if (i11 >= i12) {
            return 0;
        }
        while (i11 < i12) {
            int i13 = i11 + 1;
            byte b10 = bArr[i11];
            if (b10 < 0) {
                if (b10 < -32) {
                    if (i13 >= i12) {
                        return b10;
                    }
                    if (b10 >= -62) {
                        i11 = i13 + 1;
                        if (bArr[i13] > -65) {
                        }
                    }
                    return -1;
                }
                if (b10 >= -16) {
                    if (i13 >= i12 - 2) {
                        return zznf.zzf(bArr, i13, i12);
                    }
                    int i14 = i13 + 1;
                    byte b11 = bArr[i13];
                    if (b11 <= -65 && (((b10 << 28) + (b11 + 112)) >> 30) == 0) {
                        int i15 = i14 + 1;
                        if (bArr[i14] <= -65) {
                            i13 = i15 + 1;
                            if (bArr[i15] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                if (i13 >= i12 - 1) {
                    return zznf.zzf(bArr, i13, i12);
                }
                int i16 = i13 + 1;
                byte b12 = bArr[i13];
                if (b12 <= -65 && ((b10 != -32 || b12 >= -96) && (b10 != -19 || b12 < -96))) {
                    i11 = i16 + 1;
                    if (bArr[i16] > -65) {
                    }
                }
                return -1;
            }
            i11 = i13;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.drive.zznh
    final String zzg(byte[] bArr, int i10, int i11) throws zzkq {
        if ((i10 | i11 | ((bArr.length - i10) - i11)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
        }
        int i12 = i10 + i11;
        char[] cArr = new char[i11];
        int i13 = 0;
        while (i10 < i12) {
            byte b10 = bArr[i10];
            if (!zzng.zzd(b10)) {
                break;
            }
            i10++;
            zzng.zza(b10, cArr, i13);
            i13++;
        }
        int i14 = i13;
        while (i10 < i12) {
            int i15 = i10 + 1;
            byte b11 = bArr[i10];
            if (zzng.zzd(b11)) {
                int i16 = i14 + 1;
                zzng.zza(b11, cArr, i14);
                while (i15 < i12) {
                    byte b12 = bArr[i15];
                    if (!zzng.zzd(b12)) {
                        break;
                    }
                    i15++;
                    zzng.zza(b12, cArr, i16);
                    i16++;
                }
                i10 = i15;
                i14 = i16;
            } else if (zzng.zze(b11)) {
                if (i15 >= i12) {
                    throw zzkq.zzdn();
                }
                zzng.zza(b11, bArr[i15], cArr, i14);
                i10 = i15 + 1;
                i14++;
            } else if (zzng.zzf(b11)) {
                if (i15 >= i12 - 1) {
                    throw zzkq.zzdn();
                }
                int i17 = i15 + 1;
                zzng.zza(b11, bArr[i15], bArr[i17], cArr, i14);
                i10 = i17 + 1;
                i14++;
            } else {
                if (i15 >= i12 - 2) {
                    throw zzkq.zzdn();
                }
                int i18 = i15 + 1;
                byte b13 = bArr[i15];
                int i19 = i18 + 1;
                zzng.zza(b11, b13, bArr[i18], bArr[i19], cArr, i14);
                i10 = i19 + 1;
                i14 = i14 + 1 + 1;
            }
        }
        return new String(cArr, 0, i14);
    }

    @Override // com.google.android.gms.internal.drive.zznh
    final int zzb(CharSequence charSequence, byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        char cCharAt;
        int length = charSequence.length();
        int i15 = i11 + i10;
        int i16 = 0;
        while (i16 < length && (i14 = i16 + i10) < i15 && (cCharAt = charSequence.charAt(i16)) < 128) {
            bArr[i14] = (byte) cCharAt;
            i16++;
        }
        if (i16 == length) {
            return i10 + length;
        }
        int i17 = i10 + i16;
        while (i16 < length) {
            char cCharAt2 = charSequence.charAt(i16);
            if (cCharAt2 >= 128 || i17 >= i15) {
                if (cCharAt2 < 2048 && i17 <= i15 - 2) {
                    int i18 = i17 + 1;
                    bArr[i17] = (byte) ((cCharAt2 >>> 6) | 960);
                    i17 = i18 + 1;
                    bArr[i18] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i17 > i15 - 3) {
                        if (i17 <= i15 - 4) {
                            int i19 = i16 + 1;
                            if (i19 != charSequence.length()) {
                                char cCharAt3 = charSequence.charAt(i19);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    int i20 = i17 + 1;
                                    bArr[i17] = (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK);
                                    int i21 = i20 + 1;
                                    bArr[i20] = (byte) (((codePoint >>> 12) & 63) | 128);
                                    int i22 = i21 + 1;
                                    bArr[i21] = (byte) (((codePoint >>> 6) & 63) | 128);
                                    i17 = i22 + 1;
                                    bArr[i22] = (byte) ((codePoint & 63) | 128);
                                    i16 = i19;
                                } else {
                                    i16 = i19;
                                }
                            }
                            throw new zznj(i16 - 1, length);
                        }
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i13 = i16 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i13)))) {
                            throw new zznj(i16, length);
                        }
                        StringBuilder sb = new StringBuilder(37);
                        sb.append("Failed writing ");
                        sb.append(cCharAt2);
                        sb.append(" at index ");
                        sb.append(i17);
                        throw new ArrayIndexOutOfBoundsException(sb.toString());
                    }
                    int i23 = i17 + 1;
                    bArr[i17] = (byte) ((cCharAt2 >>> '\f') | 480);
                    int i24 = i23 + 1;
                    bArr[i23] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    i12 = i24 + 1;
                    bArr[i24] = (byte) ((cCharAt2 & '?') | 128);
                }
                i16++;
            } else {
                i12 = i17 + 1;
                bArr[i17] = (byte) cCharAt2;
            }
            i17 = i12;
            i16++;
        }
        return i17;
    }
}

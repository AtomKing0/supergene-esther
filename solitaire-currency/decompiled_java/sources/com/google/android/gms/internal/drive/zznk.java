package com.google.android.gms.internal.drive;

import androidx.media3.extractor.ts.PsExtractor;

/* JADX INFO: loaded from: classes3.dex */
final class zznk extends zznh {
    zznk() {
    }

    private static int zza(byte[] bArr, int i10, long j10, int i11) {
        if (i11 == 0) {
            return zznf.zzay(i10);
        }
        if (i11 == 1) {
            return zznf.zzr(i10, zznd.zza(bArr, j10));
        }
        if (i11 == 2) {
            return zznf.zzc(i10, zznd.zza(bArr, j10), zznd.zza(bArr, j10 + 1));
        }
        throw new AssertionError();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008f, code lost:
    
        return -1;
     */
    @Override // com.google.android.gms.internal.drive.zznh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int zzb(int r18, byte[] r19, int r20, int r21) {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zznk.zzb(int, byte[], int, int):int");
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
            byte bZza = zznd.zza(bArr, i10);
            if (!zzng.zzd(bZza)) {
                break;
            }
            i10++;
            zzng.zza(bZza, cArr, i13);
            i13++;
        }
        int i14 = i13;
        while (i10 < i12) {
            int i15 = i10 + 1;
            byte bZza2 = zznd.zza(bArr, i10);
            if (zzng.zzd(bZza2)) {
                int i16 = i14 + 1;
                zzng.zza(bZza2, cArr, i14);
                while (i15 < i12) {
                    byte bZza3 = zznd.zza(bArr, i15);
                    if (!zzng.zzd(bZza3)) {
                        break;
                    }
                    i15++;
                    zzng.zza(bZza3, cArr, i16);
                    i16++;
                }
                i10 = i15;
                i14 = i16;
            } else if (zzng.zze(bZza2)) {
                if (i15 >= i12) {
                    throw zzkq.zzdn();
                }
                zzng.zza(bZza2, zznd.zza(bArr, i15), cArr, i14);
                i10 = i15 + 1;
                i14++;
            } else if (zzng.zzf(bZza2)) {
                if (i15 >= i12 - 1) {
                    throw zzkq.zzdn();
                }
                int i17 = i15 + 1;
                zzng.zza(bZza2, zznd.zza(bArr, i15), zznd.zza(bArr, i17), cArr, i14);
                i10 = i17 + 1;
                i14++;
            } else {
                if (i15 >= i12 - 2) {
                    throw zzkq.zzdn();
                }
                int i18 = i15 + 1;
                byte bZza4 = zznd.zza(bArr, i15);
                int i19 = i18 + 1;
                zzng.zza(bZza2, bZza4, zznd.zza(bArr, i18), zznd.zza(bArr, i19), cArr, i14);
                i10 = i19 + 1;
                i14 = i14 + 1 + 1;
            }
        }
        return new String(cArr, 0, i14);
    }

    @Override // com.google.android.gms.internal.drive.zznh
    final int zzb(CharSequence charSequence, byte[] bArr, int i10, int i11) {
        char c10;
        long j10;
        long j11;
        long j12;
        char c11;
        int i12;
        char cCharAt;
        long j13 = i10;
        long j14 = ((long) i11) + j13;
        int length = charSequence.length();
        if (length > i11 || bArr.length - i11 < i10) {
            char cCharAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(cCharAt2);
            sb.append(" at index ");
            sb.append(i10 + i11);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i13 = 0;
        while (true) {
            c10 = 128;
            j10 = 1;
            if (i13 >= length || (cCharAt = charSequence.charAt(i13)) >= 128) {
                break;
            }
            zznd.zza(bArr, j13, (byte) cCharAt);
            i13++;
            j13 = 1 + j13;
        }
        if (i13 == length) {
            return (int) j13;
        }
        while (i13 < length) {
            char cCharAt3 = charSequence.charAt(i13);
            if (cCharAt3 < c10 && j13 < j14) {
                long j15 = j13 + j10;
                zznd.zza(bArr, j13, (byte) cCharAt3);
                j12 = j10;
                j11 = j15;
                c11 = c10;
            } else if (cCharAt3 < 2048 && j13 <= j14 - 2) {
                long j16 = j13 + j10;
                zznd.zza(bArr, j13, (byte) ((cCharAt3 >>> 6) | 960));
                long j17 = j16 + j10;
                zznd.zza(bArr, j16, (byte) ((cCharAt3 & '?') | 128));
                long j18 = j10;
                c11 = 128;
                j11 = j17;
                j12 = j18;
            } else {
                if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || j13 > j14 - 3) {
                    if (j13 <= j14 - 4) {
                        int i14 = i13 + 1;
                        if (i14 != length) {
                            char cCharAt4 = charSequence.charAt(i14);
                            if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                long j19 = j13 + 1;
                                zznd.zza(bArr, j13, (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK));
                                long j20 = j19 + 1;
                                c11 = 128;
                                zznd.zza(bArr, j19, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j21 = j20 + 1;
                                zznd.zza(bArr, j20, (byte) (((codePoint >>> 6) & 63) | 128));
                                j12 = 1;
                                j11 = j21 + 1;
                                zznd.zza(bArr, j21, (byte) ((codePoint & 63) | 128));
                                i13 = i14;
                            } else {
                                i13 = i14;
                            }
                        }
                        throw new zznj(i13 - 1, length);
                    }
                    if (55296 <= cCharAt3 && cCharAt3 <= 57343 && ((i12 = i13 + 1) == length || !Character.isSurrogatePair(cCharAt3, charSequence.charAt(i12)))) {
                        throw new zznj(i13, length);
                    }
                    StringBuilder sb2 = new StringBuilder(46);
                    sb2.append("Failed writing ");
                    sb2.append(cCharAt3);
                    sb2.append(" at index ");
                    sb2.append(j13);
                    throw new ArrayIndexOutOfBoundsException(sb2.toString());
                }
                long j22 = j13 + j10;
                zznd.zza(bArr, j13, (byte) ((cCharAt3 >>> '\f') | 480));
                long j23 = j22 + j10;
                zznd.zza(bArr, j22, (byte) (((cCharAt3 >>> 6) & 63) | 128));
                zznd.zza(bArr, j23, (byte) ((cCharAt3 & '?') | 128));
                j11 = j23 + 1;
                j12 = 1;
                c11 = 128;
            }
            i13++;
            c10 = c11;
            long j24 = j12;
            j13 = j11;
            j10 = j24;
        }
        return (int) j13;
    }
}

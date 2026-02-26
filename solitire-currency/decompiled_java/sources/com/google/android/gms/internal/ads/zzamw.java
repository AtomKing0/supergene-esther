package com.google.android.gms.internal.ads;

import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.OpusUtil;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzamw {
    public static zzamv zza(zzej zzejVar) throws zzbo {
        int iZzd;
        int i10;
        char c10;
        int i11;
        int iZzd2;
        char c11;
        int iZzd3 = zzejVar.zzd(8);
        int i12 = 5;
        int iZzd4 = zzejVar.zzd(5);
        if (iZzd4 != 31) {
            switch (iZzd4) {
                case 0:
                    iZzd = 96000;
                    break;
                case 1:
                    iZzd = 88200;
                    break;
                case 2:
                    iZzd = 64000;
                    break;
                case 3:
                    iZzd = OpusUtil.SAMPLE_RATE;
                    break;
                case 4:
                    iZzd = 44100;
                    break;
                case 5:
                    iZzd = 32000;
                    break;
                case 6:
                    iZzd = 24000;
                    break;
                case 7:
                    iZzd = 22050;
                    break;
                case 8:
                    iZzd = 16000;
                    break;
                case 9:
                    iZzd = 12000;
                    break;
                case 10:
                    iZzd = 11025;
                    break;
                case 11:
                    iZzd = 8000;
                    break;
                case 12:
                    iZzd = 7350;
                    break;
                case 13:
                case 14:
                default:
                    throw zzbo.zzc("Unsupported sampling rate index " + iZzd4);
                case 15:
                    iZzd = 57600;
                    break;
                case 16:
                    iZzd = 51200;
                    break;
                case 17:
                    iZzd = MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND;
                    break;
                case 18:
                    iZzd = 38400;
                    break;
                case 19:
                    iZzd = 34150;
                    break;
                case 20:
                    iZzd = 28800;
                    break;
                case 21:
                    iZzd = 25600;
                    break;
                case 22:
                    iZzd = 20000;
                    break;
                case 23:
                    iZzd = 19200;
                    break;
                case 24:
                    iZzd = 17075;
                    break;
                case 25:
                    iZzd = 14400;
                    break;
                case 26:
                    iZzd = 12800;
                    break;
                case 27:
                    iZzd = 9600;
                    break;
            }
        } else {
            iZzd = zzejVar.zzd(24);
        }
        int iZzd5 = zzejVar.zzd(3);
        int i13 = 1;
        if (iZzd5 == 0) {
            i10 = 768;
        } else if (iZzd5 == 1) {
            i10 = 1024;
        } else if (iZzd5 == 2 || iZzd5 == 3) {
            i10 = 2048;
        } else {
            if (iZzd5 != 4) {
                throw zzbo.zzc("Unsupported coreSbrFrameLengthIndex " + iZzd5);
            }
            i10 = 4096;
        }
        if (iZzd5 == 0 || iZzd5 == 1) {
            c10 = 0;
        } else if (iZzd5 == 2) {
            c10 = 2;
        } else if (iZzd5 == 3) {
            c10 = 3;
        } else {
            if (iZzd5 != 4) {
                throw zzbo.zzc("Unsupported coreSbrFrameLengthIndex " + iZzd5);
            }
            c10 = 1;
        }
        zzejVar.zzn(2);
        zze(zzejVar);
        int iZzd6 = zzejVar.zzd(5);
        int i14 = 0;
        int iZzc = 0;
        while (true) {
            int i15 = 16;
            if (i14 < iZzd6 + 1) {
                int iZzd7 = zzejVar.zzd(3);
                iZzc += zzc(zzejVar, 5, 8, 16) + 1;
                if ((iZzd7 == 0 || iZzd7 == 2) && zzejVar.zzp()) {
                    zze(zzejVar);
                }
                i14++;
            } else {
                int iZzc2 = zzc(zzejVar, 4, 8, 16) + 1;
                zzejVar.zzm();
                int i16 = 0;
                while (true) {
                    double d10 = 2.0d;
                    if (i16 >= iZzc2) {
                        int i17 = iZzd3;
                        byte[] bArr = null;
                        if (zzejVar.zzp()) {
                            int iZzc3 = zzc(zzejVar, 2, 4, 8) + 1;
                            for (int i18 = 0; i18 < iZzc3; i18++) {
                                int iZzc4 = zzc(zzejVar, 4, 8, 16);
                                int iZzc5 = zzc(zzejVar, 4, 8, 16);
                                if (iZzc4 == 7) {
                                    int iZzd8 = zzejVar.zzd(4) + 1;
                                    zzejVar.zzn(4);
                                    byte[] bArr2 = new byte[iZzd8];
                                    for (int i19 = 0; i19 < iZzd8; i19++) {
                                        bArr2[i19] = (byte) zzejVar.zzd(8);
                                    }
                                    bArr = bArr2;
                                } else {
                                    zzejVar.zzn(iZzc5 * 8);
                                }
                            }
                        }
                        byte[] bArr3 = bArr;
                        switch (iZzd) {
                            case 14700:
                            case 16000:
                                d10 = 3.0d;
                                break;
                            case 22050:
                            case 24000:
                                break;
                            case 29400:
                            case 32000:
                            case 58800:
                            case 64000:
                                d10 = 1.5d;
                                break;
                            case 44100:
                            case OpusUtil.SAMPLE_RATE /* 48000 */:
                            case 88200:
                            case 96000:
                                d10 = 1.0d;
                                break;
                            default:
                                throw zzbo.zzc("Unsupported sampling rate " + iZzd);
                        }
                        return new zzamv(i17, (int) (((double) iZzd) * d10), (int) (((double) i10) * d10), bArr3, null);
                    }
                    int iZzd9 = zzejVar.zzd(2);
                    if (iZzd9 == 0) {
                        i11 = iZzd3;
                        zzf(zzejVar);
                        if (c10 > 0) {
                            zzd(zzejVar);
                        }
                    } else if (iZzd9 != i13) {
                        if (iZzd9 == 3) {
                            zzc(zzejVar, 4, 8, i15);
                            int iZzc6 = zzc(zzejVar, 4, 8, i15);
                            if (zzejVar.zzp()) {
                                zzc(zzejVar, 8, i15, 0);
                            }
                            zzejVar.zzm();
                            if (iZzc6 > 0) {
                                zzejVar.zzn(iZzc6 * 8);
                            }
                        }
                        i11 = iZzd3;
                    } else {
                        if (zzf(zzejVar)) {
                            zzejVar.zzm();
                        }
                        if (c10 > 0) {
                            zzd(zzejVar);
                            iZzd2 = zzejVar.zzd(2);
                            c11 = c10;
                        } else {
                            iZzd2 = 0;
                            c11 = 0;
                        }
                        if (iZzd2 > 0) {
                            zzejVar.zzn(6);
                            int iZzd10 = zzejVar.zzd(2);
                            zzejVar.zzn(4);
                            if (zzejVar.zzp()) {
                                zzejVar.zzn(i12);
                            }
                            if (iZzd2 == 2 || iZzd2 == 3) {
                                zzejVar.zzn(6);
                            }
                            if (iZzd10 == 2) {
                                zzejVar.zzm();
                            }
                        }
                        i11 = iZzd3;
                        int iFloor = ((int) Math.floor(Math.log(iZzc - 1) / Math.log(2.0d))) + 1;
                        int iZzd11 = zzejVar.zzd(2);
                        if (iZzd11 > 0 && zzejVar.zzp()) {
                            zzejVar.zzn(iFloor);
                        }
                        if (zzejVar.zzp()) {
                            zzejVar.zzn(iFloor);
                        }
                        if (c11 == 0 && iZzd11 == 0) {
                            zzejVar.zzm();
                        }
                    }
                    i16++;
                    iZzd3 = i11;
                    i12 = 5;
                    i13 = 1;
                    i15 = 16;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zzb(com.google.android.gms.internal.ads.zzej r17, com.google.android.gms.internal.ads.zzamt r18) throws com.google.android.gms.internal.ads.zzbo {
        /*
            r0 = r17
            r1 = r18
            r17.zzb()
            r2 = 3
            r3 = 8
            int r2 = zzc(r0, r2, r3, r3)
            r1.zza = r2
            r4 = 0
            r5 = -1
            if (r2 == r5) goto Lc3
            r2 = 2
            int r6 = java.lang.Math.max(r2, r3)
            r7 = 32
            int r6 = java.lang.Math.max(r6, r7)
            r8 = 63
            r9 = 1
            if (r6 > r8) goto L26
            r6 = r9
            goto L27
        L26:
            r6 = r4
        L27:
            com.google.android.gms.internal.ads.zzdi.zzd(r6)
            r10 = 3
            r12 = 255(0xff, double:1.26E-321)
            long r14 = com.google.android.gms.internal.ads.zzgaj.zza(r10, r12)
            r5 = 4294967296(0x100000000, double:2.121995791E-314)
            com.google.android.gms.internal.ads.zzgaj.zza(r14, r5)
            int r5 = r17.zza()
            r14 = -1
            if (r5 >= r2) goto L44
        L42:
            r5 = r14
            goto L6a
        L44:
            long r5 = r0.zze(r2)
            int r16 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r16 != 0) goto L6a
            int r5 = r17.zza()
            if (r5 >= r3) goto L53
            goto L42
        L53:
            long r5 = r0.zze(r3)
            long r10 = r10 + r5
            int r3 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r3 != 0) goto L69
            int r3 = r17.zza()
            if (r3 >= r7) goto L63
            goto L42
        L63:
            long r5 = r0.zze(r7)
            long r5 = r5 + r10
            goto L6a
        L69:
            r5 = r10
        L6a:
            r1.zzb = r5
            int r3 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r3 != 0) goto L71
            return r4
        L71:
            r10 = 16
            int r3 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r3 > 0) goto Lad
            r10 = 0
            int r3 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r3 != 0) goto L9e
            int r3 = r1.zza
            r5 = 0
            if (r3 == r9) goto L97
            if (r3 == r2) goto L90
            r2 = 17
            if (r3 == r2) goto L89
            goto L9e
        L89:
            java.lang.String r0 = "AudioTruncation packet with invalid packet label 0"
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zza(r0, r5)
            throw r0
        L90:
            java.lang.String r0 = "Mpegh3daFrame packet with invalid packet label 0"
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zza(r0, r5)
            throw r0
        L97:
            java.lang.String r0 = "Mpegh3daConfig packet with invalid packet label 0"
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zza(r0, r5)
            throw r0
        L9e:
            r2 = 11
            r3 = 24
            int r0 = zzc(r0, r2, r3, r3)
            r1.zzc = r0
            r1 = -1
            if (r0 == r1) goto Lac
            return r9
        Lac:
            return r4
        Lad:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Contains sub-stream with an invalid packet label "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zzc(r0)
            throw r0
        Lc3:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamw.zzb(com.google.android.gms.internal.ads.zzej, com.google.android.gms.internal.ads.zzamt):boolean");
    }

    private static int zzc(zzej zzejVar, int i10, int i11, int i12) {
        zzdi.zzd(Math.max(Math.max(i10, i11), i12) <= 31);
        int i13 = (1 << i10) - 1;
        int i14 = (1 << i11) - 1;
        zzgah.zza(zzgah.zza(i13, i14), 1 << i12);
        if (zzejVar.zza() < i10) {
            return -1;
        }
        int iZzd = zzejVar.zzd(i10);
        if (iZzd != i13) {
            return iZzd;
        }
        if (zzejVar.zza() < i11) {
            return -1;
        }
        int iZzd2 = zzejVar.zzd(i11);
        int i15 = iZzd + iZzd2;
        if (iZzd2 != i14) {
            return i15;
        }
        if (zzejVar.zza() < i12) {
            return -1;
        }
        return i15 + zzejVar.zzd(i12);
    }

    private static void zzd(zzej zzejVar) {
        zzejVar.zzn(3);
        zzejVar.zzn(8);
        boolean zZzp = zzejVar.zzp();
        boolean zZzp2 = zzejVar.zzp();
        if (zZzp) {
            zzejVar.zzn(5);
        }
        if (zZzp2) {
            zzejVar.zzn(6);
        }
    }

    private static void zze(zzej zzejVar) {
        int iZzd;
        int iZzd2 = zzejVar.zzd(2);
        if (iZzd2 == 0) {
            zzejVar.zzn(6);
            return;
        }
        int iZzc = zzc(zzejVar, 5, 8, 16) + 1;
        if (iZzd2 == 1) {
            zzejVar.zzn(iZzc * 7);
            return;
        }
        if (iZzd2 == 2) {
            boolean zZzp = zzejVar.zzp();
            int i10 = true != zZzp ? 5 : 1;
            int i11 = true == zZzp ? 7 : 5;
            int i12 = true == zZzp ? 8 : 6;
            int i13 = 0;
            while (i13 < iZzc) {
                if (zzejVar.zzp()) {
                    zzejVar.zzn(7);
                    iZzd = 0;
                } else {
                    if (zzejVar.zzd(2) == 3 && zzejVar.zzd(i11) * i10 != 0) {
                        zzejVar.zzm();
                    }
                    iZzd = zzejVar.zzd(i12) * i10;
                    if (iZzd != 0 && iZzd != 180) {
                        zzejVar.zzm();
                    }
                    zzejVar.zzm();
                }
                if (iZzd != 0 && iZzd != 180 && zzejVar.zzp()) {
                    i13++;
                }
                i13++;
            }
        }
    }

    private static boolean zzf(zzej zzejVar) {
        zzejVar.zzn(3);
        boolean zZzp = zzejVar.zzp();
        if (zZzp) {
            zzejVar.zzn(13);
        }
        return zZzp;
    }
}

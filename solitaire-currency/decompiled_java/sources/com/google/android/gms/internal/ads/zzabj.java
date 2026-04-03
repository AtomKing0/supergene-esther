package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.OpusUtil;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzabj {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {OpusUtil.SAMPLE_RATE, 44100, 32000};
    private static final int[] zzd = {24000, 22050, 16000};
    private static final int[] zze = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzf = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, Sdk$SDKError.b.WEBVIEW_ERROR_VALUE, RendererCapabilities.DECODER_SUPPORT_MASK, 448, 512, 576, 640};
    private static final int[] zzg = {69, 87, 104, 121, TsExtractor.TS_STREAM_TYPE_DTS_UHD, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int zza(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return zzb[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static int zzb(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) <= 10) {
            byte b10 = bArr[4];
            return zzf((b10 & 192) >> 6, b10 & 63);
        }
        int i10 = bArr[2] & 7;
        int i11 = ((bArr[3] & 255) | (i10 << 8)) + 1;
        return i11 + i11;
    }

    public static zzaf zzc(zzek zzekVar, String str, String str2, @Nullable zzy zzyVar) {
        zzej zzejVar = new zzej();
        zzejVar.zzj(zzekVar);
        int i10 = zzc[zzejVar.zzd(2)];
        zzejVar.zzn(8);
        int i11 = zze[zzejVar.zzd(3)];
        if (zzejVar.zzd(1) != 0) {
            i11++;
        }
        int i12 = zzf[zzejVar.zzd(5)] * 1000;
        zzejVar.zzf();
        zzekVar.zzK(zzejVar.zzb());
        zzad zzadVar = new zzad();
        zzadVar.zzK(str);
        zzadVar.zzX(MimeTypes.AUDIO_AC3);
        zzadVar.zzy(i11);
        zzadVar.zzY(i10);
        zzadVar.zzE(zzyVar);
        zzadVar.zzO(str2);
        zzadVar.zzx(i12);
        zzadVar.zzS(i12);
        return zzadVar.zzad();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzaf zzd(com.google.android.gms.internal.ads.zzek r7, java.lang.String r8, java.lang.String r9, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzy r10) {
        /*
            com.google.android.gms.internal.ads.zzej r0 = new com.google.android.gms.internal.ads.zzej
            r0.<init>()
            r0.zzj(r7)
            r1 = 13
            int r1 = r0.zzd(r1)
            int r1 = r1 * 1000
            r2 = 3
            r0.zzn(r2)
            r3 = 2
            int r3 = r0.zzd(r3)
            int[] r4 = com.google.android.gms.internal.ads.zzabj.zzc
            r3 = r4[r3]
            r4 = 10
            r0.zzn(r4)
            int[] r4 = com.google.android.gms.internal.ads.zzabj.zze
            int r5 = r0.zzd(r2)
            r4 = r4[r5]
            r5 = 1
            int r6 = r0.zzd(r5)
            if (r6 == 0) goto L33
            int r4 = r4 + 1
        L33:
            r0.zzn(r2)
            r2 = 4
            int r2 = r0.zzd(r2)
            r0.zzn(r5)
            if (r2 <= 0) goto L4f
            r2 = 6
            r0.zzn(r2)
            int r2 = r0.zzd(r5)
            if (r2 == 0) goto L4c
            int r4 = r4 + 2
        L4c:
            r0.zzn(r5)
        L4f:
            int r2 = r0.zza()
            r6 = 7
            if (r2 <= r6) goto L62
            r0.zzn(r6)
            int r2 = r0.zzd(r5)
            if (r2 == 0) goto L62
            java.lang.String r2 = "audio/eac3-joc"
            goto L64
        L62:
            java.lang.String r2 = "audio/eac3"
        L64:
            r0.zzf()
            int r0 = r0.zzb()
            r7.zzK(r0)
            com.google.android.gms.internal.ads.zzad r7 = new com.google.android.gms.internal.ads.zzad
            r7.<init>()
            r7.zzK(r8)
            r7.zzX(r2)
            r7.zzy(r4)
            r7.zzY(r3)
            r7.zzE(r10)
            r7.zzO(r9)
            r7.zzS(r1)
            com.google.android.gms.internal.ads.zzaf r7 = r7.zzad()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabj.zzd(com.google.android.gms.internal.ads.zzek, java.lang.String, java.lang.String, com.google.android.gms.internal.ads.zzy):com.google.android.gms.internal.ads.zzaf");
    }

    public static zzabi zze(zzej zzejVar) {
        int i10;
        int i11;
        String str;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int iZzc = zzejVar.zzc();
        zzejVar.zzn(40);
        int iZzd = zzejVar.zzd(5);
        zzejVar.zzl(iZzc);
        int i21 = -1;
        if (iZzd > 10) {
            zzejVar.zzn(16);
            int iZzd2 = zzejVar.zzd(2);
            if (iZzd2 == 0) {
                i21 = 0;
            } else if (iZzd2 == 1) {
                i21 = 1;
            } else if (iZzd2 == 2) {
                i21 = 2;
            }
            zzejVar.zzn(3);
            int iZzd3 = zzejVar.zzd(11) + 1;
            int iZzd4 = zzejVar.zzd(2);
            if (iZzd4 == 3) {
                i17 = zzd[zzejVar.zzd(2)];
                i18 = 6;
                i16 = 3;
            } else {
                int iZzd5 = zzejVar.zzd(2);
                int i22 = zzb[iZzd5];
                i16 = iZzd5;
                i17 = zzc[iZzd4];
                i18 = i22;
            }
            int i23 = iZzd3 + iZzd3;
            int i24 = (i23 * i17) / (i18 * 32);
            int iZzd6 = zzejVar.zzd(3);
            boolean zZzp = zzejVar.zzp();
            i10 = zze[iZzd6] + (zZzp ? 1 : 0);
            zzejVar.zzn(10);
            if (zzejVar.zzp()) {
                zzejVar.zzn(8);
            }
            if (iZzd6 == 0) {
                zzejVar.zzn(5);
                if (zzejVar.zzp()) {
                    zzejVar.zzn(8);
                }
                i19 = 0;
                iZzd6 = 0;
            } else {
                i19 = iZzd6;
            }
            if (i21 == 1) {
                if (zzejVar.zzp()) {
                    zzejVar.zzn(16);
                }
                i20 = 1;
            } else {
                i20 = i21;
            }
            if (zzejVar.zzp()) {
                if (i19 > 2) {
                    zzejVar.zzn(2);
                }
                if ((i19 & 1) != 0 && i19 > 2) {
                    zzejVar.zzn(6);
                }
                if ((i19 & 4) != 0) {
                    zzejVar.zzn(6);
                }
                if (zZzp && zzejVar.zzp()) {
                    zzejVar.zzn(5);
                }
                if (i20 == 0) {
                    if (zzejVar.zzp()) {
                        zzejVar.zzn(6);
                    }
                    if (i19 == 0 && zzejVar.zzp()) {
                        zzejVar.zzn(6);
                    }
                    if (zzejVar.zzp()) {
                        zzejVar.zzn(6);
                    }
                    int iZzd7 = zzejVar.zzd(2);
                    if (iZzd7 == 1) {
                        zzejVar.zzn(5);
                    } else if (iZzd7 == 2) {
                        zzejVar.zzn(12);
                    } else if (iZzd7 == 3) {
                        int iZzd8 = zzejVar.zzd(5);
                        if (zzejVar.zzp()) {
                            zzejVar.zzn(5);
                            if (zzejVar.zzp()) {
                                zzejVar.zzn(4);
                            }
                            if (zzejVar.zzp()) {
                                zzejVar.zzn(4);
                            }
                            if (zzejVar.zzp()) {
                                zzejVar.zzn(4);
                            }
                            if (zzejVar.zzp()) {
                                zzejVar.zzn(4);
                            }
                            if (zzejVar.zzp()) {
                                zzejVar.zzn(4);
                            }
                            if (zzejVar.zzp()) {
                                zzejVar.zzn(4);
                            }
                            if (zzejVar.zzp()) {
                                zzejVar.zzn(4);
                            }
                            if (zzejVar.zzp()) {
                                if (zzejVar.zzp()) {
                                    zzejVar.zzn(4);
                                }
                                if (zzejVar.zzp()) {
                                    zzejVar.zzn(4);
                                }
                            }
                        }
                        if (zzejVar.zzp()) {
                            zzejVar.zzn(5);
                            if (zzejVar.zzp()) {
                                zzejVar.zzn(7);
                                if (zzejVar.zzp()) {
                                    zzejVar.zzn(8);
                                }
                            }
                        }
                        zzejVar.zzn((iZzd8 + 2) * 8);
                        zzejVar.zzf();
                    }
                    if (i19 < 2) {
                        if (zzejVar.zzp()) {
                            zzejVar.zzn(14);
                        }
                        if (iZzd6 == 0 && zzejVar.zzp()) {
                            zzejVar.zzn(14);
                        }
                    }
                    if (!zzejVar.zzp()) {
                        i20 = 0;
                    } else if (i16 == 0) {
                        zzejVar.zzn(5);
                        i20 = 0;
                        i16 = 0;
                    } else {
                        for (int i25 = 0; i25 < i18; i25++) {
                            if (zzejVar.zzp()) {
                                zzejVar.zzn(5);
                            }
                        }
                        i20 = 0;
                    }
                }
            }
            if (zzejVar.zzp()) {
                zzejVar.zzn(5);
                if (i19 == 2) {
                    zzejVar.zzn(4);
                    i19 = 2;
                }
                if (i19 >= 6) {
                    zzejVar.zzn(2);
                }
                if (zzejVar.zzp()) {
                    zzejVar.zzn(8);
                }
                if (i19 == 0 && zzejVar.zzp()) {
                    zzejVar.zzn(8);
                }
                if (iZzd4 < 3) {
                    zzejVar.zzm();
                }
            }
            if (i20 == 0 && i16 != 3) {
                zzejVar.zzm();
            }
            if (i20 == 2 && (i16 == 3 || zzejVar.zzp())) {
                zzejVar.zzn(6);
            }
            str = (zzejVar.zzp() && zzejVar.zzd(6) == 1 && zzejVar.zzd(8) == 1) ? MimeTypes.AUDIO_E_AC3_JOC : MimeTypes.AUDIO_E_AC3;
            i11 = i21;
            i13 = i23;
            i14 = i17;
            i15 = i18 * 256;
            i12 = i24;
        } else {
            zzejVar.zzn(32);
            int iZzd9 = zzejVar.zzd(2);
            String str2 = iZzd9 == 3 ? null : MimeTypes.AUDIO_AC3;
            int iZzd10 = zzejVar.zzd(6);
            int i26 = zzf[iZzd10 / 2] * 1000;
            int iZzf = zzf(iZzd9, iZzd10);
            zzejVar.zzn(8);
            int iZzd11 = zzejVar.zzd(3);
            if ((iZzd11 & 1) != 0 && iZzd11 != 1) {
                zzejVar.zzn(2);
            }
            if ((iZzd11 & 4) != 0) {
                zzejVar.zzn(2);
            }
            if (iZzd11 == 2) {
                zzejVar.zzn(2);
            }
            int i27 = iZzd9 < 3 ? zzc[iZzd9] : -1;
            i10 = zze[iZzd11] + (zzejVar.zzp() ? 1 : 0);
            i11 = -1;
            str = str2;
            i12 = i26;
            i13 = iZzf;
            i14 = i27;
            i15 = 1536;
        }
        return new zzabi(str, i11, i10, i14, i13, i15, i12, null);
    }

    private static int zzf(int i10, int i11) {
        int i12;
        if (i10 < 0 || i10 >= 3 || i11 < 0 || (i12 = i11 >> 1) >= 19) {
            return -1;
        }
        int i13 = zzc[i10];
        if (i13 == 44100) {
            int i14 = zzg[i12] + (i11 & 1);
            return i14 + i14;
        }
        int i15 = zzf[i12];
        return i13 == 32000 ? i15 * 6 : i15 * 4;
    }
}

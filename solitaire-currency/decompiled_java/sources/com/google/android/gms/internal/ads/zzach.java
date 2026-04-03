package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.DtsUtil;
import androidx.media3.extractor.OpusUtil;
import androidx.media3.extractor.ts.PsExtractor;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzach {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzc = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, OpusUtil.SAMPLE_RATE, -1, -1};
    private static final int[] zzd = {64, 112, 128, PsExtractor.AUDIO_STREAM, 224, 256, RendererCapabilities.DECODER_SUPPORT_MASK, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, IronSourceConstants.IS_AD_UNIT_CAPPED, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};
    private static final int[] zze = {8000, 16000, 32000, 64000, 128000, 22050, 44100, 88200, 176400, 352800, 12000, 24000, OpusUtil.SAMPLE_RATE, 96000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 384000};
    private static final int[] zzf = {5, 8, 10, 12};
    private static final int[] zzg = {6, 9, 12, 15};
    private static final int[] zzh = {2, 4, 6, 8};
    private static final int[] zzi = {9, 11, 13, 16};
    private static final int[] zzj = {5, 8, 10, 12};

    public static int zza(byte[] bArr) {
        zzej zzejVarZzg = zzg(bArr);
        zzejVarZzg.zzn(42);
        return zzejVarZzg.zzd(true != zzejVarZzg.zzp() ? 8 : 12) + 1;
    }

    public static int zzb(byte[] bArr) {
        zzej zzejVarZzg = zzg(bArr);
        zzejVarZzg.zzn(32);
        return zzf(zzejVarZzg, zzj, true) + 1;
    }

    public static zzaf zzc(byte[] bArr, @Nullable String str, @Nullable String str2, int i10, @Nullable zzy zzyVar) {
        zzej zzejVarZzg = zzg(bArr);
        zzejVarZzg.zzn(60);
        int i11 = zzb[zzejVarZzg.zzd(6)];
        int i12 = zzc[zzejVarZzg.zzd(4)];
        int iZzd = zzejVarZzg.zzd(5);
        int i13 = iZzd >= 29 ? -1 : (zzd[iZzd] * 1000) / 2;
        zzejVarZzg.zzn(10);
        int i14 = i11 + (zzejVarZzg.zzd(2) > 0 ? 1 : 0);
        zzad zzadVar = new zzad();
        zzadVar.zzK(str);
        zzadVar.zzX(MimeTypes.AUDIO_DTS);
        zzadVar.zzx(i13);
        zzadVar.zzy(i14);
        zzadVar.zzY(i12);
        zzadVar.zzE(null);
        zzadVar.zzO(str2);
        zzadVar.zzV(i10);
        return zzadVar.zzad();
    }

    public static zzacg zzd(byte[] bArr) throws zzbo {
        int iZzd;
        int i10;
        int iZzd2;
        long jZzt;
        int i11;
        zzej zzejVarZzg = zzg(bArr);
        zzejVarZzg.zzn(40);
        int iZzd3 = zzejVarZzg.zzd(2);
        boolean zZzp = zzejVarZzg.zzp();
        int i12 = true != zZzp ? 16 : 20;
        zzejVarZzg.zzn(true != zZzp ? 8 : 12);
        int iZzd4 = zzejVarZzg.zzd(i12) + 1;
        boolean zZzp2 = zzejVarZzg.zzp();
        int i13 = 0;
        if (zZzp2) {
            iZzd = zzejVarZzg.zzd(2);
            int iZzd5 = zzejVarZzg.zzd(3) + 1;
            if (zzejVarZzg.zzp()) {
                zzejVarZzg.zzn(36);
            }
            int iZzd6 = zzejVarZzg.zzd(3) + 1;
            int iZzd7 = zzejVarZzg.zzd(3) + 1;
            if (iZzd6 != 1 || iZzd7 != 1) {
                throw zzbo.zzc("Multiple audio presentations or assets not supported");
            }
            int i14 = iZzd3 + 1;
            int iZzd8 = zzejVarZzg.zzd(i14);
            for (int i15 = 0; i15 < i14; i15++) {
                if (((iZzd8 >> i15) & 1) == 1) {
                    zzejVarZzg.zzn(8);
                }
            }
            int i16 = iZzd5 * 512;
            if (zzejVarZzg.zzp()) {
                zzejVarZzg.zzn(2);
                int iZzd9 = (zzejVarZzg.zzd(2) + 1) << 2;
                int iZzd10 = zzejVarZzg.zzd(2) + 1;
                while (i13 < iZzd10) {
                    zzejVarZzg.zzn(iZzd9);
                    i13++;
                }
            }
            i13 = i16;
        } else {
            iZzd = -1;
        }
        zzejVarZzg.zzn(i12);
        zzejVarZzg.zzn(12);
        if (zZzp2) {
            if (zzejVarZzg.zzp()) {
                zzejVarZzg.zzn(4);
            }
            if (zzejVarZzg.zzp()) {
                zzejVarZzg.zzn(24);
            }
            if (zzejVarZzg.zzp()) {
                zzejVarZzg.zzo(zzejVarZzg.zzd(10) + 1);
            }
            zzejVarZzg.zzn(5);
            int i17 = zze[zzejVarZzg.zzd(4)];
            iZzd2 = zzejVarZzg.zzd(8) + 1;
            i10 = i17;
        } else {
            i10 = -2147483647;
            iZzd2 = -1;
        }
        if (zZzp2) {
            if (iZzd == 0) {
                i11 = 32000;
            } else if (iZzd == 1) {
                i11 = 44100;
            } else {
                if (iZzd != 2) {
                    throw zzbo.zza("Unsupported reference clock code in DTS HD header: " + iZzd, null);
                }
                i11 = OpusUtil.SAMPLE_RATE;
            }
            jZzt = zzet.zzt(i13, 1000000L, i11, RoundingMode.FLOOR);
        } else {
            jZzt = C.TIME_UNSET;
        }
        return new zzacg(MimeTypes.AUDIO_DTS_EXPRESS, iZzd2, i10, iZzd4, jZzt, 0, null);
    }

    public static zzacg zze(byte[] bArr, AtomicInteger atomicInteger) throws zzbo {
        long jZzt;
        int iZzd;
        int i10;
        int i11;
        zzej zzejVarZzg = zzg(bArr);
        int iZzd2 = zzejVarZzg.zzd(32);
        int iZzf = zzf(zzejVarZzg, zzf, true) + 1;
        char c10 = iZzd2 == 1078008818 ? (char) 1 : (char) 0;
        if (c10 == 0) {
            jZzt = C.TIME_UNSET;
            iZzd = C.RATE_UNSET_INT;
        } else {
            if (!zzejVarZzg.zzp()) {
                throw zzbo.zzc("Only supports full channel mask-based audio presentation");
            }
            int i12 = iZzf - 2;
            if ((((char) (bArr[i12] << 8)) | (bArr[iZzf - 1] & 255)) != zzet.zzd(bArr, 0, i12, 65535)) {
                throw zzbo.zza("CRC check failed", null);
            }
            int iZzd3 = zzejVarZzg.zzd(2);
            if (iZzd3 == 0) {
                i10 = 512;
            } else if (iZzd3 == 1) {
                i10 = 480;
            } else {
                if (iZzd3 != 2) {
                    throw zzbo.zza("Unsupported base duration index in DTS UHD header: " + iZzd3, null);
                }
                i10 = RendererCapabilities.DECODER_SUPPORT_MASK;
            }
            int iZzd4 = zzejVarZzg.zzd(3) + 1;
            int iZzd5 = zzejVarZzg.zzd(2);
            if (iZzd5 == 0) {
                i11 = 32000;
            } else if (iZzd5 == 1) {
                i11 = 44100;
            } else {
                if (iZzd5 != 2) {
                    throw zzbo.zza("Unsupported clock rate index in DTS UHD header: " + iZzd5, null);
                }
                i11 = OpusUtil.SAMPLE_RATE;
            }
            if (zzejVarZzg.zzp()) {
                zzejVarZzg.zzn(36);
            }
            iZzd = (1 << zzejVarZzg.zzd(2)) * i11;
            jZzt = zzet.zzt(i10 * iZzd4, 1000000L, i11, RoundingMode.FLOOR);
        }
        int i13 = iZzd;
        long j10 = jZzt;
        int iZzf2 = 0;
        for (char c11 = 0; c11 < c10; c11 = 1) {
            iZzf2 += zzf(zzejVarZzg, zzg, true);
        }
        for (int i14 = 0; i14 <= 0; i14++) {
            if (c10 != 0) {
                atomicInteger.set(zzf(zzejVarZzg, zzh, true));
            }
            iZzf2 += atomicInteger.get() != 0 ? zzf(zzejVarZzg, zzi, true) : 0;
        }
        return new zzacg(MimeTypes.AUDIO_DTS_X, 2, i13, iZzf + iZzf2, j10, 0, null);
    }

    private static int zzf(zzej zzejVar, int[] iArr, boolean z10) {
        int i10 = 0;
        for (int i11 = 0; i11 < 3 && zzejVar.zzp(); i11++) {
            i10++;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            i12 += 1 << iArr[i13];
        }
        return i12 + zzejVar.zzd(iArr[i10]);
    }

    private static zzej zzg(byte[] bArr) {
        byte b10 = bArr[0];
        if (b10 == 127 || b10 == 100 || b10 == 64 || b10 == 113) {
            return new zzej(bArr, bArr.length);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        byte b11 = bArrCopyOf[0];
        if (b11 == -2 || b11 == -1 || b11 == 37 || b11 == -14 || b11 == -24) {
            for (int i10 = 0; i10 < bArrCopyOf.length - 1; i10 += 2) {
                byte b12 = bArrCopyOf[i10];
                int i11 = i10 + 1;
                bArrCopyOf[i10] = bArrCopyOf[i11];
                bArrCopyOf[i11] = b12;
            }
        }
        int length = bArrCopyOf.length;
        zzej zzejVar = new zzej(bArrCopyOf, length);
        if (bArrCopyOf[0] == 31) {
            zzej zzejVar2 = new zzej(bArrCopyOf, length);
            while (zzejVar2.zza() >= 16) {
                zzejVar2.zzn(2);
                zzejVar.zzg(zzejVar2.zzd(14), 14);
            }
        }
        zzejVar.zzk(bArrCopyOf, bArrCopyOf.length);
        return zzejVar;
    }
}

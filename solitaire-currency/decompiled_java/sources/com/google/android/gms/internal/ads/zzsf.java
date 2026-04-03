package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.MimeTypes;
import com.ironsource.v8;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzsf {
    public final String zza;
    public final String zzb;
    public final String zzc;

    @Nullable
    public final MediaCodecInfo.CodecCapabilities zzd;
    public final boolean zze;
    public final boolean zzf;
    public final boolean zzg;
    private final boolean zzh;

    @VisibleForTesting
    zzsf(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        str.getClass();
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = codecCapabilities;
        this.zzg = z10;
        this.zze = z13;
        this.zzf = z15;
        this.zzh = zzbn.zzi(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzsf zzc(java.lang.String r12, java.lang.String r13, java.lang.String r14, @androidx.annotation.Nullable android.media.MediaCodecInfo.CodecCapabilities r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20) {
        /*
            r1 = r12
            r4 = r15
            com.google.android.gms.internal.ads.zzsf r11 = new com.google.android.gms.internal.ads.zzsf
            r0 = 1
            r2 = 0
            if (r4 == 0) goto L3b
            java.lang.String r3 = "adaptive-playback"
            boolean r3 = r15.isFeatureSupported(r3)
            if (r3 == 0) goto L3b
            int r3 = com.google.android.gms.internal.ads.zzet.zza
            r5 = 22
            if (r3 > r5) goto L39
            java.lang.String r3 = com.google.android.gms.internal.ads.zzet.zzd
            java.lang.String r5 = "ODROID-XU3"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L28
            java.lang.String r5 = "Nexus 10"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L39
        L28:
            java.lang.String r3 = "OMX.Exynos.AVC.Decoder"
            boolean r3 = r3.equals(r12)
            if (r3 != 0) goto L3b
            java.lang.String r3 = "OMX.Exynos.AVC.Decoder.secure"
            boolean r3 = r3.equals(r12)
            if (r3 == 0) goto L39
            goto L3b
        L39:
            r8 = r0
            goto L3c
        L3b:
            r8 = r2
        L3c:
            if (r4 == 0) goto L4a
            int r3 = com.google.android.gms.internal.ads.zzet.zza
            java.lang.String r3 = "tunneled-playback"
            boolean r3 = r15.isFeatureSupported(r3)
            if (r3 == 0) goto L4a
            r9 = r0
            goto L4b
        L4a:
            r9 = r2
        L4b:
            if (r20 != 0) goto L5c
            if (r4 == 0) goto L5a
            int r3 = com.google.android.gms.internal.ads.zzet.zza
            java.lang.String r3 = "secure-playback"
            boolean r3 = r15.isFeatureSupported(r3)
            if (r3 == 0) goto L5a
            goto L5c
        L5a:
            r10 = r2
            goto L5d
        L5c:
            r10 = r0
        L5d:
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsf.zzc(java.lang.String, java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.internal.ads.zzsf");
    }

    @RequiresApi(21)
    private static Point zzi(MediaCodecInfo.VideoCapabilities videoCapabilities, int i10, int i11) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        int i12 = zzet.zza;
        return new Point((((i10 + widthAlignment) - 1) / widthAlignment) * widthAlignment, (((i11 + heightAlignment) - 1) / heightAlignment) * heightAlignment);
    }

    private final void zzj(String str) {
        zzea.zzb(androidx.media3.exoplayer.mediacodec.MediaCodecInfo.TAG, "NoSupport [" + str + "] [" + this.zza + ", " + this.zzb + "] [" + zzet.zze + v8.i.f15839e);
    }

    @RequiresApi(21)
    private static boolean zzk(MediaCodecInfo.VideoCapabilities videoCapabilities, int i10, int i11, double d10) {
        Point pointZzi = zzi(videoCapabilities, i10, i11);
        int i12 = pointZzi.x;
        int i13 = pointZzi.y;
        return (d10 == -1.0d || d10 < 1.0d) ? videoCapabilities.isSizeSupported(i12, i13) : videoCapabilities.areSizeAndRateSupported(i12, i13, Math.floor(d10));
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zzl(com.google.android.gms.internal.ads.zzaf r12, boolean r13) {
        /*
            Method dump skipped, instruction units count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsf.zzl(com.google.android.gms.internal.ads.zzaf, boolean):boolean");
    }

    private final boolean zzm(zzaf zzafVar) {
        return this.zzb.equals(zzafVar.zzm) || this.zzb.equals(zztc.zzc(zzafVar));
    }

    public final String toString() {
        return this.zza;
    }

    @Nullable
    @RequiresApi(21)
    public final Point zza(int i10, int i11) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return zzi(videoCapabilities, i10, i11);
    }

    public final zzho zzb(zzaf zzafVar, zzaf zzafVar2) {
        int i10 = true != zzet.zzG(zzafVar.zzm, zzafVar2.zzm) ? 8 : 0;
        if (this.zzh) {
            if (zzafVar.zzu != zzafVar2.zzu) {
                i10 |= 1024;
            }
            if (!this.zze && (zzafVar.zzr != zzafVar2.zzr || zzafVar.zzs != zzafVar2.zzs)) {
                i10 |= 512;
            }
            if ((!zzo.zzg(zzafVar.zzy) || !zzo.zzg(zzafVar2.zzy)) && !zzet.zzG(zzafVar.zzy, zzafVar2.zzy)) {
                i10 |= 2048;
            }
            String str = this.zza;
            if (zzet.zzd.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str) && !zzafVar.zzd(zzafVar2)) {
                i10 |= 2;
            }
            if (i10 == 0) {
                return new zzho(this.zza, zzafVar, zzafVar2, true != zzafVar.zzd(zzafVar2) ? 2 : 3, 0);
            }
        } else {
            if (zzafVar.zzz != zzafVar2.zzz) {
                i10 |= 4096;
            }
            if (zzafVar.zzA != zzafVar2.zzA) {
                i10 |= 8192;
            }
            if (zzafVar.zzB != zzafVar2.zzB) {
                i10 |= 16384;
            }
            if (i10 == 0 && MimeTypes.AUDIO_AAC.equals(this.zzb)) {
                Pair pairZza = zztc.zza(zzafVar);
                Pair pairZza2 = zztc.zza(zzafVar2);
                if (pairZza != null && pairZza2 != null) {
                    int iIntValue = ((Integer) pairZza.first).intValue();
                    int iIntValue2 = ((Integer) pairZza2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new zzho(this.zza, zzafVar, zzafVar2, 3, 0);
                    }
                }
            }
            if (!zzafVar.zzd(zzafVar2)) {
                i10 |= 32;
            }
            if (MimeTypes.AUDIO_OPUS.equals(this.zzb)) {
                i10 |= 2;
            }
            if (i10 == 0) {
                return new zzho(this.zza, zzafVar, zzafVar2, 1, 0);
            }
        }
        return new zzho(this.zza, zzafVar, zzafVar2, 0, i10);
    }

    public final boolean zzd(zzaf zzafVar) {
        return zzm(zzafVar) && zzl(zzafVar, false);
    }

    public final boolean zze(zzaf zzafVar) throws zzsw {
        int i10;
        if (!zzm(zzafVar) || !zzl(zzafVar, true)) {
            return false;
        }
        if (this.zzh) {
            int i11 = zzafVar.zzr;
            if (i11 <= 0 || (i10 = zzafVar.zzs) <= 0) {
                return true;
            }
            int i12 = zzet.zza;
            return zzg(i11, i10, zzafVar.zzt);
        }
        int i13 = zzet.zza;
        int i14 = zzafVar.zzA;
        if (i14 != -1) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
            if (codecCapabilities == null) {
                zzj("sampleRate.caps");
                return false;
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                zzj("sampleRate.aCaps");
                return false;
            }
            if (!audioCapabilities.isSampleRateSupported(i14)) {
                zzj("sampleRate.support, " + i14);
                return false;
            }
        }
        int i15 = zzafVar.zzz;
        if (i15 != -1) {
            MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.zzd;
            if (codecCapabilities2 == null) {
                zzj("channelCount.caps");
            } else {
                MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities2.getAudioCapabilities();
                if (audioCapabilities2 == null) {
                    zzj("channelCount.aCaps");
                } else {
                    String str = this.zza;
                    String str2 = this.zzb;
                    int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                    if (maxInputChannelCount <= 1 && ((zzet.zza < 26 || maxInputChannelCount <= 0) && !MimeTypes.AUDIO_MPEG.equals(str2) && !MimeTypes.AUDIO_AMR_NB.equals(str2) && !MimeTypes.AUDIO_AMR_WB.equals(str2) && !MimeTypes.AUDIO_AAC.equals(str2) && !MimeTypes.AUDIO_VORBIS.equals(str2) && !MimeTypes.AUDIO_OPUS.equals(str2) && !MimeTypes.AUDIO_RAW.equals(str2) && !MimeTypes.AUDIO_FLAC.equals(str2) && !MimeTypes.AUDIO_ALAW.equals(str2) && !MimeTypes.AUDIO_MLAW.equals(str2) && !MimeTypes.AUDIO_MSGSM.equals(str2))) {
                        int i16 = MimeTypes.AUDIO_AC3.equals(str2) ? 6 : MimeTypes.AUDIO_E_AC3.equals(str2) ? 16 : 30;
                        zzea.zzf(androidx.media3.exoplayer.mediacodec.MediaCodecInfo.TAG, "AssumedMaxChannelAdjustment: " + str + ", [" + maxInputChannelCount + " to " + i16 + v8.i.f15839e);
                        maxInputChannelCount = i16;
                    }
                    if (maxInputChannelCount < i15) {
                        zzj("channelCount.support, " + i15);
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final boolean zzf(zzaf zzafVar) {
        if (this.zzh) {
            return this.zze;
        }
        Pair pairZza = zztc.zza(zzafVar);
        return pairZza != null && ((Integer) pairZza.first).intValue() == 42;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    @androidx.annotation.RequiresApi(21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzg(int r8, int r9, double r10) {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsf.zzg(int, int, double):boolean");
    }

    public final MediaCodecInfo.CodecProfileLevel[] zzh() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }
}

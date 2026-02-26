package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.avi.AviExtractor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaef implements zzadx {
    public final zzfxr zza;
    private final int zzb;

    private zzaef(int i10, zzfxr zzfxrVar) {
        this.zzb = i10;
        this.zza = zzfxrVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static zzaef zzc(int i10, zzek zzekVar) {
        zzadx zzaegVar;
        String str;
        zzfxo zzfxoVar = new zzfxo();
        int iZze = zzekVar.zze();
        int i11 = -2;
        while (zzekVar.zzb() > 8) {
            int iZzi = zzekVar.zzi();
            int iZzd = zzekVar.zzd() + zzekVar.zzi();
            zzekVar.zzJ(iZzd);
            if (iZzi != 1414744396) {
                zzaeg zzaegVar2 = null;
                switch (iZzi) {
                    case AviExtractor.FOURCC_strf /* 1718776947 */:
                        if (i11 != 2) {
                            if (i11 == 1) {
                                int iZzk = zzekVar.zzk();
                                String str2 = iZzk != 1 ? iZzk != 85 ? iZzk != 255 ? iZzk != 8192 ? iZzk != 8193 ? null : MimeTypes.AUDIO_DTS : MimeTypes.AUDIO_AC3 : MimeTypes.AUDIO_AAC : MimeTypes.AUDIO_MPEG : MimeTypes.AUDIO_RAW;
                                if (str2 != null) {
                                    int iZzk2 = zzekVar.zzk();
                                    int iZzi2 = zzekVar.zzi();
                                    zzekVar.zzL(6);
                                    int iZzl = zzet.zzl(zzekVar.zzq());
                                    int iZzk3 = zzekVar.zzk();
                                    byte[] bArr = new byte[iZzk3];
                                    zzekVar.zzG(bArr, 0, iZzk3);
                                    zzad zzadVar = new zzad();
                                    zzadVar.zzX(str2);
                                    zzadVar.zzy(iZzk2);
                                    zzadVar.zzY(iZzi2);
                                    if (MimeTypes.AUDIO_RAW.equals(str2) && iZzl != 0) {
                                        zzadVar.zzR(iZzl);
                                    }
                                    if (MimeTypes.AUDIO_AAC.equals(str2) && iZzk3 > 0) {
                                        zzadVar.zzL(zzfxr.zzn(bArr));
                                    }
                                    zzaegVar = new zzaeg(zzadVar.zzad());
                                } else {
                                    zzea.zzf("StreamFormatChunk", "Ignoring track with unsupported format tag " + iZzk);
                                }
                            } else {
                                zzea.zzf("StreamFormatChunk", "Ignoring strf box for unsupported track type: ".concat(zzet.zzC(i11)));
                            }
                            break;
                        } else {
                            zzekVar.zzL(4);
                            int iZzi3 = zzekVar.zzi();
                            int iZzi4 = zzekVar.zzi();
                            zzekVar.zzL(4);
                            int iZzi5 = zzekVar.zzi();
                            switch (iZzi5) {
                                case 808802372:
                                case 877677894:
                                case 1145656883:
                                case 1145656920:
                                case 1482049860:
                                case 1684633208:
                                case 2021026148:
                                    str = MimeTypes.VIDEO_MP4V;
                                    break;
                                case 826496577:
                                case 828601953:
                                case 875967048:
                                    str = "video/avc";
                                    break;
                                case 842289229:
                                    str = MimeTypes.VIDEO_MP42;
                                    break;
                                case 859066445:
                                    str = MimeTypes.VIDEO_MP43;
                                    break;
                                case 1196444237:
                                case 1735420525:
                                    str = MimeTypes.VIDEO_MJPEG;
                                    break;
                                default:
                                    str = null;
                                    break;
                            }
                            if (str == null) {
                                zzea.zzf("StreamFormatChunk", "Ignoring track with unsupported compression " + iZzi5);
                            } else {
                                zzad zzadVar2 = new zzad();
                                zzadVar2.zzac(iZzi3);
                                zzadVar2.zzI(iZzi4);
                                zzadVar2.zzX(str);
                                zzaegVar2 = new zzaeg(zzadVar2.zzad());
                            }
                        }
                        zzaegVar = zzaegVar2;
                        break;
                    case AviExtractor.FOURCC_avih /* 1751742049 */:
                        zzaegVar = zzaec.zzb(zzekVar);
                        break;
                    case AviExtractor.FOURCC_strh /* 1752331379 */:
                        zzaegVar = zzaed.zzb(zzekVar);
                        break;
                    case AviExtractor.FOURCC_strn /* 1852994675 */:
                        zzaegVar = zzaeh.zzb(zzekVar);
                        break;
                    default:
                        zzaegVar = zzaegVar2;
                        break;
                }
            } else {
                zzaegVar = zzc(zzekVar.zzi(), zzekVar);
            }
            if (zzaegVar != null) {
                if (zzaegVar.zza() == 1752331379) {
                    int i12 = ((zzaed) zzaegVar).zza;
                    if (i12 == 1935960438) {
                        i11 = 2;
                    } else if (i12 == 1935963489) {
                        i11 = 1;
                    } else if (i12 != 1937012852) {
                        zzea.zzf("AviStreamHeaderChunk", "Found unsupported streamType fourCC: ".concat(String.valueOf(Integer.toHexString(i12))));
                        i11 = -1;
                    } else {
                        i11 = 3;
                    }
                }
                zzfxoVar.zzf(zzaegVar);
            }
            zzekVar.zzK(iZzd);
            zzekVar.zzJ(iZze);
        }
        return new zzaef(i10, zzfxoVar.zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final int zza() {
        return this.zzb;
    }

    @Nullable
    public final zzadx zzb(Class cls) {
        zzfxr zzfxrVar = this.zza;
        int size = zzfxrVar.size();
        int i10 = 0;
        while (i10 < size) {
            zzadx zzadxVar = (zzadx) zzfxrVar.get(i10);
            i10++;
            if (zzadxVar.getClass() == cls) {
                return zzadxVar;
            }
        }
        return null;
    }
}

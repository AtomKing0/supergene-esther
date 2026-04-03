package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"InlinedApi"})
public final class zztc {
    public static final /* synthetic */ int zza = 0;
    private static final Pattern zzb = Pattern.compile("^\\D?(\\d+)$");

    @GuardedBy("MediaCodecUtil.class")
    private static final HashMap zzc = new HashMap();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0606  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0615  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0119  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair zza(com.google.android.gms.internal.ads.zzaf r21) {
        /*
            Method dump skipped, instruction units count: 2474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztc.zza(com.google.android.gms.internal.ads.zzaf):android.util.Pair");
    }

    @Nullable
    public static zzsf zzb() throws zzsw {
        List listZze = zze(MimeTypes.AUDIO_RAW, false, false);
        if (listZze.isEmpty()) {
            return null;
        }
        return (zzsf) listZze.get(0);
    }

    @Nullable
    public static String zzc(zzaf zzafVar) {
        Pair pairZza;
        if (MimeTypes.AUDIO_E_AC3_JOC.equals(zzafVar.zzm)) {
            return MimeTypes.AUDIO_E_AC3;
        }
        if (!MimeTypes.VIDEO_DOLBY_VISION.equals(zzafVar.zzm) || (pairZza = zza(zzafVar)) == null) {
            return null;
        }
        int iIntValue = ((Integer) pairZza.first).intValue();
        if (iIntValue == 16 || iIntValue == 256) {
            return "video/hevc";
        }
        if (iIntValue == 512) {
            return "video/avc";
        }
        if (iIntValue == 1024) {
            return "video/av01";
        }
        return null;
    }

    public static List zzd(zzsq zzsqVar, zzaf zzafVar, boolean z10, boolean z11) throws zzsw {
        String strZzc = zzc(zzafVar);
        return strZzc == null ? zzfxr.zzm() : zze(strZzc, z10, z11);
    }

    public static synchronized List zze(String str, boolean z10, boolean z11) throws zzsw {
        zzsu zzsuVar = new zzsu(str, z10, z11);
        HashMap map = zzc;
        List list = (List) map.get(zzsuVar);
        if (list != null) {
            return list;
        }
        int i10 = zzet.zza;
        ArrayList arrayListZzh = zzh(zzsuVar, new zzta(z10, z11));
        if (z10 && arrayListZzh.isEmpty() && zzet.zza <= 23) {
            arrayListZzh = zzh(zzsuVar, new zzsz(null));
            if (!arrayListZzh.isEmpty()) {
                zzea.zzf("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((zzsf) arrayListZzh.get(0)).zza);
            }
        }
        if (MimeTypes.AUDIO_RAW.equals(str)) {
            if (zzet.zza < 26 && zzet.zzb.equals("R9") && arrayListZzh.size() == 1 && ((zzsf) arrayListZzh.get(0)).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                arrayListZzh.add(zzsf.zzc("OMX.google.raw.decoder", MimeTypes.AUDIO_RAW, MimeTypes.AUDIO_RAW, null, false, true, false, false, false));
            }
            zzi(arrayListZzh, new zztb() { // from class: com.google.android.gms.internal.ads.zzss
                @Override // com.google.android.gms.internal.ads.zztb
                public final int zza(Object obj) {
                    int i11 = zztc.zza;
                    String str2 = ((zzsf) obj).zza;
                    if (str2.startsWith("OMX.google") || str2.startsWith("c2.android")) {
                        return 1;
                    }
                    return (zzet.zza >= 26 || !str2.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
                }
            });
        }
        if (zzet.zza < 32 && arrayListZzh.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzsf) arrayListZzh.get(0)).zza)) {
            arrayListZzh.add((zzsf) arrayListZzh.remove(0));
        }
        zzfxr zzfxrVarZzk = zzfxr.zzk(arrayListZzh);
        map.put(zzsuVar, zzfxrVarZzk);
        return zzfxrVarZzk;
    }

    public static List zzf(zzsq zzsqVar, zzaf zzafVar, boolean z10, boolean z11) throws zzsw {
        List listZze = zze(zzafVar.zzm, z10, z11);
        List listZzd = zzd(zzsqVar, zzafVar, z10, z11);
        zzfxo zzfxoVar = new zzfxo();
        zzfxoVar.zzh(listZze);
        zzfxoVar.zzh(listZzd);
        return zzfxoVar.zzi();
    }

    @CheckResult
    public static List zzg(List list, final zzaf zzafVar) {
        ArrayList arrayList = new ArrayList(list);
        zzi(arrayList, new zztb() { // from class: com.google.android.gms.internal.ads.zzst
            @Override // com.google.android.gms.internal.ads.zztb
            public final int zza(Object obj) {
                int i10 = zztc.zza;
                return ((zzsf) obj).zzd(zzafVar) ? 1 : 0;
            }
        });
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x017d A[Catch: Exception -> 0x020f, TryCatch #1 {Exception -> 0x020f, blocks: (B:80:0x0133, B:86:0x014a, B:92:0x015f, B:94:0x0165, B:99:0x0175, B:101:0x017d, B:111:0x01a9, B:102:0x0182, B:104:0x0192, B:106:0x019a, B:95:0x016a), top: B:152:0x0133 }] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0182 A[Catch: Exception -> 0x020f, TryCatch #1 {Exception -> 0x020f, blocks: (B:80:0x0133, B:86:0x014a, B:92:0x015f, B:94:0x0165, B:99:0x0175, B:101:0x017d, B:111:0x01a9, B:102:0x0182, B:104:0x0192, B:106:0x019a, B:95:0x016a), top: B:152:0x0133 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x021e A[Catch: Exception -> 0x026c, TRY_ENTER, TryCatch #3 {Exception -> 0x026c, blocks: (B:3:0x0008, B:5:0x001d, B:7:0x0027, B:10:0x0034, B:14:0x0042, B:18:0x004c, B:20:0x0054, B:22:0x005c, B:24:0x0066, B:26:0x0070, B:28:0x0078, B:30:0x0080, B:32:0x0088, B:34:0x0090, B:36:0x0098, B:38:0x00a0, B:42:0x00ac, B:44:0x00b4, B:46:0x00bc, B:48:0x00c5, B:137:0x0216, B:140:0x021e, B:142:0x0224, B:143:0x023e, B:144:0x025f, B:51:0x00ce, B:52:0x00d1, B:54:0x00d9, B:57:0x00e4, B:59:0x00ec, B:62:0x00f7, B:64:0x00ff, B:67:0x010a, B:69:0x0112, B:72:0x011d, B:74:0x0125), top: B:156:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x023e A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0165 A[Catch: Exception -> 0x020f, TryCatch #1 {Exception -> 0x020f, blocks: (B:80:0x0133, B:86:0x014a, B:92:0x015f, B:94:0x0165, B:99:0x0175, B:101:0x017d, B:111:0x01a9, B:102:0x0182, B:104:0x0192, B:106:0x019a, B:95:0x016a), top: B:152:0x0133 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x016a A[Catch: Exception -> 0x020f, TryCatch #1 {Exception -> 0x020f, blocks: (B:80:0x0133, B:86:0x014a, B:92:0x015f, B:94:0x0165, B:99:0x0175, B:101:0x017d, B:111:0x01a9, B:102:0x0182, B:104:0x0192, B:106:0x019a, B:95:0x016a), top: B:152:0x0133 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.ArrayList zzh(com.google.android.gms.internal.ads.zzsu r23, com.google.android.gms.internal.ads.zzsx r24) throws com.google.android.gms.internal.ads.zzsw {
        /*
            Method dump skipped, instruction units count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztc.zzh(com.google.android.gms.internal.ads.zzsu, com.google.android.gms.internal.ads.zzsx):java.util.ArrayList");
    }

    private static void zzi(List list, final zztb zztbVar) {
        Collections.sort(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zzsr
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int i10 = zztc.zza;
                zztb zztbVar2 = zztbVar;
                return zztbVar2.zza(obj2) - zztbVar2.zza(obj);
            }
        });
    }

    private static boolean zzj(MediaCodecInfo mediaCodecInfo, String str) {
        if (zzet.zza >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (zzbn.zzg(str)) {
            return true;
        }
        String strZza = zzfuf.zza(mediaCodecInfo.getName());
        if (strZza.startsWith("arc.")) {
            return false;
        }
        if (strZza.startsWith("omx.google.") || strZza.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((strZza.startsWith("omx.sec.") && strZza.contains(".sw.")) || strZza.equals("omx.qcom.video.decoder.hevcswvdec") || strZza.startsWith("c2.android.") || strZza.startsWith("c2.google.")) {
            return true;
        }
        return (strZza.startsWith("omx.") || strZza.startsWith("c2.")) ? false : true;
    }
}

package b3;

import a4.o0;
import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.MimeTypes;
import com.google.common.collect.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k2.o1;

/* JADX INFO: compiled from: MediaCodecUtil.java */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"InlinedApi"})
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f2058a = Pattern.compile("^\\D?(\\d+)$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("MediaCodecUtil.class")
    private static final HashMap<b, List<n>> f2059b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f2060c = -1;

    /* JADX INFO: compiled from: MediaCodecUtil.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f2062b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f2063c;

        public b(String str, boolean z10, boolean z11) {
            this.f2061a = str;
            this.f2062b = z10;
            this.f2063c = z11;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != b.class) {
                return false;
            }
            b bVar = (b) obj;
            return TextUtils.equals(this.f2061a, bVar.f2061a) && this.f2062b == bVar.f2062b && this.f2063c == bVar.f2063c;
        }

        public int hashCode() {
            return ((((this.f2061a.hashCode() + 31) * 31) + (this.f2062b ? 1231 : 1237)) * 31) + (this.f2063c ? 1231 : 1237);
        }
    }

    /* JADX INFO: compiled from: MediaCodecUtil.java */
    public static class c extends Exception {
        private c(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    /* JADX INFO: compiled from: MediaCodecUtil.java */
    private interface d {
        int getCodecCount();

        MediaCodecInfo getCodecInfoAt(int i10);

        boolean isFeatureRequired(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean isFeatureSupported(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean secureDecodersExplicit();
    }

    /* JADX INFO: compiled from: MediaCodecUtil.java */
    private static final class e implements d {
        private e() {
        }

        @Override // b3.v.d
        public int getCodecCount() {
            return MediaCodecList.getCodecCount();
        }

        @Override // b3.v.d
        public MediaCodecInfo getCodecInfoAt(int i10) {
            return MediaCodecList.getCodecInfoAt(i10);
        }

        @Override // b3.v.d
        public boolean isFeatureRequired(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // b3.v.d
        public boolean isFeatureSupported(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && "video/avc".equals(str2);
        }

        @Override // b3.v.d
        public boolean secureDecodersExplicit() {
            return false;
        }
    }

    /* JADX INFO: compiled from: MediaCodecUtil.java */
    @RequiresApi(21)
    private static final class f implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f2064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private MediaCodecInfo[] f2065b;

        public f(boolean z10, boolean z11) {
            this.f2064a = (z10 || z11) ? 1 : 0;
        }

        private void a() {
            if (this.f2065b == null) {
                this.f2065b = new MediaCodecList(this.f2064a).getCodecInfos();
            }
        }

        @Override // b3.v.d
        public int getCodecCount() {
            a();
            return this.f2065b.length;
        }

        @Override // b3.v.d
        public MediaCodecInfo getCodecInfoAt(int i10) {
            a();
            return this.f2065b[i10];
        }

        @Override // b3.v.d
        public boolean isFeatureRequired(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        @Override // b3.v.d
        public boolean isFeatureSupported(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // b3.v.d
        public boolean secureDecodersExplicit() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: MediaCodecUtil.java */
    interface g<T> {
        int getScore(T t10);
    }

    private static boolean A(MediaCodecInfo mediaCodecInfo) {
        return o0.f214a >= 29 && B(mediaCodecInfo);
    }

    @RequiresApi(29)
    private static boolean B(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    private static boolean C(MediaCodecInfo mediaCodecInfo, String str, boolean z10, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z10 && str.endsWith(".secure"))) {
            return false;
        }
        int i10 = o0.f214a;
        if (i10 < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i10 < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = o0.f215b;
            if ("a70".equals(str3) || ("Xiaomi".equals(o0.f216c) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i10 == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = o0.f215b;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i10 == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = o0.f215b;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i10 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(o0.f216c))) {
            String str6 = o0.f215b;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i10 <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(o0.f216c)) {
            String str7 = o0.f215b;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i10 <= 19 && o0.f215b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return (i10 <= 23 && MimeTypes.AUDIO_E_AC3_JOC.equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    private static boolean D(MediaCodecInfo mediaCodecInfo, String str) {
        return o0.f214a >= 29 ? E(mediaCodecInfo) : !F(mediaCodecInfo, str);
    }

    @RequiresApi(29)
    private static boolean E(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    private static boolean F(MediaCodecInfo mediaCodecInfo, String str) {
        if (o0.f214a >= 29) {
            return G(mediaCodecInfo);
        }
        if (a4.x.l(str)) {
            return true;
        }
        String strE = e5.c.e(mediaCodecInfo.getName());
        if (strE.startsWith("arc.")) {
            return false;
        }
        if (strE.startsWith("omx.google.") || strE.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((strE.startsWith("omx.sec.") && strE.contains(".sw.")) || strE.equals("omx.qcom.video.decoder.hevcswvdec") || strE.startsWith("c2.android.") || strE.startsWith("c2.google.")) {
            return true;
        }
        return (strE.startsWith("omx.") || strE.startsWith("c2.")) ? false : true;
    }

    @RequiresApi(29)
    private static boolean G(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    private static boolean H(MediaCodecInfo mediaCodecInfo) {
        if (o0.f214a >= 29) {
            return I(mediaCodecInfo);
        }
        String strE = e5.c.e(mediaCodecInfo.getName());
        return (strE.startsWith("omx.google.") || strE.startsWith("c2.android.") || strE.startsWith("c2.google.")) ? false : true;
    }

    @RequiresApi(29)
    private static boolean I(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int J(n nVar) {
        String str = nVar.f2000a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (o0.f214a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int K(n nVar) {
        return nVar.f2000a.startsWith("OMX.google") ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int L(o1 o1Var, n nVar) {
        try {
            return nVar.m(o1Var) ? 1 : 0;
        } catch (c unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int M(g gVar, Object obj, Object obj2) {
        return gVar.getScore(obj2) - gVar.getScore(obj);
    }

    public static int N() throws c {
        if (f2060c == -1) {
            int iMax = 0;
            n nVarR = r("video/avc", false, false);
            if (nVarR != null) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrG = nVarR.g();
                int length = codecProfileLevelArrG.length;
                int iMax2 = 0;
                while (iMax < length) {
                    iMax2 = Math.max(h(codecProfileLevelArrG[iMax].level), iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, o0.f214a >= 21 ? 345600 : 172800);
            }
            f2060c = iMax;
        }
        return f2060c;
    }

    private static int O(int i10) {
        int i11 = 17;
        if (i10 != 17) {
            i11 = 20;
            if (i10 != 20) {
                i11 = 23;
                if (i10 != 23) {
                    i11 = 29;
                    if (i10 != 29) {
                        i11 = 39;
                        if (i10 != 39) {
                            i11 = 42;
                            if (i10 != 42) {
                                switch (i10) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i11;
    }

    private static <T> void P(List<T> list, final g<T> gVar) {
        Collections.sort(list, new Comparator() { // from class: b3.u
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return v.M(gVar, obj, obj2);
            }
        });
    }

    private static int Q(int i10) {
        if (i10 == 10) {
            return 1;
        }
        if (i10 == 11) {
            return 2;
        }
        if (i10 == 20) {
            return 4;
        }
        if (i10 == 21) {
            return 8;
        }
        if (i10 == 30) {
            return 16;
        }
        if (i10 == 31) {
            return 32;
        }
        if (i10 == 40) {
            return 64;
        }
        if (i10 == 41) {
            return 128;
        }
        if (i10 == 50) {
            return 256;
        }
        if (i10 == 51) {
            return 512;
        }
        switch (i10) {
            case 60:
                return 2048;
            case 61:
                return 4096;
            case 62:
                return 8192;
            default:
                return -1;
        }
    }

    private static int R(int i10) {
        if (i10 == 0) {
            return 1;
        }
        if (i10 == 1) {
            return 2;
        }
        if (i10 != 2) {
            return i10 != 3 ? -1 : 8;
        }
        return 4;
    }

    private static void e(String str, List<n> list) {
        if (MimeTypes.AUDIO_RAW.equals(str)) {
            if (o0.f214a < 26 && o0.f215b.equals("R9") && list.size() == 1 && list.get(0).f2000a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(n.C("OMX.google.raw.decoder", MimeTypes.AUDIO_RAW, MimeTypes.AUDIO_RAW, null, false, true, false, false, false));
            }
            P(list, new g() { // from class: b3.r
                @Override // b3.v.g
                public final int getScore(Object obj) {
                    return v.J((n) obj);
                }
            });
        }
        int i10 = o0.f214a;
        if (i10 < 21 && list.size() > 1) {
            String str2 = list.get(0).f2000a;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                P(list, new g() { // from class: b3.s
                    @Override // b3.v.g
                    public final int getScore(Object obj) {
                        return v.K((n) obj);
                    }
                });
            }
        }
        if (i10 >= 32 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(list.get(0).f2000a)) {
            return;
        }
        list.add(list.remove(0));
    }

    private static int f(int i10) {
        switch (i10) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 8192;
            case 14:
                return 16384;
            case 15:
                return 32768;
            case 16:
                return 65536;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    private static int g(int i10) {
        switch (i10) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i10) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i10) {
                            case 30:
                                return 256;
                            case 31:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i10) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return 4096;
                                    case 42:
                                        return 8192;
                                    default:
                                        switch (i10) {
                                            case 50:
                                                return 16384;
                                            case 51:
                                                return 32768;
                                            case 52:
                                                return 65536;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    private static int h(int i10) {
        if (i10 == 1 || i10 == 2) {
            return 25344;
        }
        switch (i10) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            case 131072:
            case 262144:
            case 524288:
                return 35651584;
            default:
                return -1;
        }
    }

    private static int i(int i10) {
        if (i10 == 66) {
            return 1;
        }
        if (i10 == 77) {
            return 2;
        }
        if (i10 == 88) {
            return 4;
        }
        if (i10 == 100) {
            return 8;
        }
        if (i10 == 110) {
            return 16;
        }
        if (i10 != 122) {
            return i10 != 244 ? -1 : 64;
        }
        return 32;
    }

    @Nullable
    private static Integer j(@Nullable String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }

    @Nullable
    private static Integer k(@Nullable String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }

    @Nullable
    private static Pair<Integer, Integer> l(String str, String[] strArr) {
        int iO;
        if (strArr.length != 3) {
            a4.t.i("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if (MimeTypes.AUDIO_AAC.equals(a4.x.f(Integer.parseInt(strArr[1], 16))) && (iO = O(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair<>(Integer.valueOf(iO), 0);
            }
        } catch (NumberFormatException unused) {
            a4.t.i("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    @Nullable
    public static String m(o1 o1Var) {
        Pair<Integer, Integer> pairQ;
        if (MimeTypes.AUDIO_E_AC3_JOC.equals(o1Var.f29347l)) {
            return MimeTypes.AUDIO_E_AC3;
        }
        if (!MimeTypes.VIDEO_DOLBY_VISION.equals(o1Var.f29347l) || (pairQ = q(o1Var)) == null) {
            return null;
        }
        int iIntValue = ((Integer) pairQ.first).intValue();
        if (iIntValue == 16 || iIntValue == 256) {
            return "video/hevc";
        }
        if (iIntValue == 512) {
            return "video/avc";
        }
        return null;
    }

    @Nullable
    private static Pair<Integer, Integer> n(String str, String[] strArr, @Nullable b4.c cVar) {
        int i10;
        if (strArr.length < 4) {
            a4.t.i("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
        try {
            int i11 = Integer.parseInt(strArr[1]);
            int i12 = Integer.parseInt(strArr[2].substring(0, 2));
            int i13 = Integer.parseInt(strArr[3]);
            if (i11 != 0) {
                a4.t.i("MediaCodecUtil", "Unknown AV1 profile: " + i11);
                return null;
            }
            if (i13 != 8 && i13 != 10) {
                a4.t.i("MediaCodecUtil", "Unknown AV1 bit depth: " + i13);
                return null;
            }
            int i14 = i13 != 8 ? (cVar == null || !(cVar.f2088d != null || (i10 = cVar.f2087c) == 7 || i10 == 6)) ? 2 : 4096 : 1;
            int iF = f(i12);
            if (iF != -1) {
                return new Pair<>(Integer.valueOf(i14), Integer.valueOf(iF));
            }
            a4.t.i("MediaCodecUtil", "Unknown AV1 level: " + i12);
            return null;
        } catch (NumberFormatException unused) {
            a4.t.i("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
    }

    @Nullable
    private static Pair<Integer, Integer> o(String str, String[] strArr) {
        int i10;
        int i11;
        if (strArr.length < 2) {
            a4.t.i("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i11 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                i10 = Integer.parseInt(strArr[1].substring(4), 16);
            } else {
                if (strArr.length < 3) {
                    a4.t.i("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                    return null;
                }
                int i12 = Integer.parseInt(strArr[1]);
                i10 = Integer.parseInt(strArr[2]);
                i11 = i12;
            }
            int i13 = i(i11);
            if (i13 == -1) {
                a4.t.i("MediaCodecUtil", "Unknown AVC profile: " + i11);
                return null;
            }
            int iG = g(i10);
            if (iG != -1) {
                return new Pair<>(Integer.valueOf(i13), Integer.valueOf(iG));
            }
            a4.t.i("MediaCodecUtil", "Unknown AVC level: " + i10);
            return null;
        } catch (NumberFormatException unused) {
            a4.t.i("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    @Nullable
    private static String p(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals(MimeTypes.VIDEO_DOLBY_VISION)) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals(MimeTypes.AUDIO_ALAC) && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals(MimeTypes.AUDIO_FLAC) && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        if (str2.equals(MimeTypes.AUDIO_AC3) && "OMX.lge.ac3.decoder".equals(str)) {
            return "audio/lg-ac3";
        }
        return null;
    }

    @Nullable
    public static Pair<Integer, Integer> q(o1 o1Var) {
        String str = o1Var.f29344i;
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("\\.");
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(o1Var.f29347l)) {
            return w(o1Var.f29344i, strArrSplit);
        }
        String str2 = strArrSplit[0];
        str2.hashCode();
        switch (str2) {
            case "av01":
                return n(o1Var.f29344i, strArrSplit, o1Var.f29359x);
            case "avc1":
            case "avc2":
                return o(o1Var.f29344i, strArrSplit);
            case "hev1":
            case "hvc1":
                return x(o1Var.f29344i, strArrSplit);
            case "mp4a":
                return l(o1Var.f29344i, strArrSplit);
            case "vp09":
                return y(o1Var.f29344i, strArrSplit);
            default:
                return null;
        }
    }

    @Nullable
    public static n r(String str, boolean z10, boolean z11) throws c {
        List<n> listS = s(str, z10, z11);
        if (listS.isEmpty()) {
            return null;
        }
        return listS.get(0);
    }

    public static synchronized List<n> s(String str, boolean z10, boolean z11) throws c {
        b bVar = new b(str, z10, z11);
        HashMap<b, List<n>> map = f2059b;
        List<n> list = map.get(bVar);
        if (list != null) {
            return list;
        }
        int i10 = o0.f214a;
        ArrayList<n> arrayListT = t(bVar, i10 >= 21 ? new f(z10, z11) : new e());
        if (z10 && arrayListT.isEmpty() && 21 <= i10 && i10 <= 23) {
            arrayListT = t(bVar, new e());
            if (!arrayListT.isEmpty()) {
                a4.t.i("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + arrayListT.get(0).f2000a);
            }
        }
        e(str, arrayListT);
        y yVarM = y.m(arrayListT);
        map.put(bVar, yVarM);
        return yVarM;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0101 A[Catch: Exception -> 0x014f, TRY_ENTER, TryCatch #1 {Exception -> 0x014f, blocks: (B:3:0x0008, B:5:0x001b, B:60:0x0120, B:8:0x002d, B:11:0x0038, B:54:0x00f9, B:57:0x0101, B:59:0x0107, B:61:0x012a, B:62:0x014d), top: B:69:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x012a A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.ArrayList<b3.n> t(b3.v.b r24, b3.v.d r25) throws b3.v.c {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.v.t(b3.v$b, b3.v$d):java.util.ArrayList");
    }

    @CheckResult
    public static List<n> u(List<n> list, final o1 o1Var) {
        ArrayList arrayList = new ArrayList(list);
        P(arrayList, new g() { // from class: b3.t
            @Override // b3.v.g
            public final int getScore(Object obj) {
                return v.L(o1Var, (n) obj);
            }
        });
        return arrayList;
    }

    @Nullable
    public static n v() throws c {
        return r(MimeTypes.AUDIO_RAW, false, false);
    }

    @Nullable
    private static Pair<Integer, Integer> w(String str, String[] strArr) {
        if (strArr.length < 3) {
            a4.t.i("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        Matcher matcher = f2058a.matcher(strArr[1]);
        if (!matcher.matches()) {
            a4.t.i("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        Integer numK = k(strGroup);
        if (numK == null) {
            a4.t.i("MediaCodecUtil", "Unknown Dolby Vision profile string: " + strGroup);
            return null;
        }
        String str2 = strArr[2];
        Integer numJ = j(str2);
        if (numJ != null) {
            return new Pair<>(numK, numJ);
        }
        a4.t.i("MediaCodecUtil", "Unknown Dolby Vision level string: " + str2);
        return null;
    }

    @Nullable
    private static Pair<Integer, Integer> x(String str, String[] strArr) {
        if (strArr.length < 4) {
            a4.t.i("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        int i10 = 1;
        Matcher matcher = f2058a.matcher(strArr[1]);
        if (!matcher.matches()) {
            a4.t.i("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        if (!"1".equals(strGroup)) {
            if (!"2".equals(strGroup)) {
                a4.t.i("MediaCodecUtil", "Unknown HEVC profile string: " + strGroup);
                return null;
            }
            i10 = 2;
        }
        String str2 = strArr[3];
        Integer numZ = z(str2);
        if (numZ != null) {
            return new Pair<>(Integer.valueOf(i10), numZ);
        }
        a4.t.i("MediaCodecUtil", "Unknown HEVC level string: " + str2);
        return null;
    }

    @Nullable
    private static Pair<Integer, Integer> y(String str, String[] strArr) {
        if (strArr.length < 3) {
            a4.t.i("MediaCodecUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
        try {
            int i10 = Integer.parseInt(strArr[1]);
            int i11 = Integer.parseInt(strArr[2]);
            int iR = R(i10);
            if (iR == -1) {
                a4.t.i("MediaCodecUtil", "Unknown VP9 profile: " + i10);
                return null;
            }
            int iQ = Q(i11);
            if (iQ != -1) {
                return new Pair<>(Integer.valueOf(iR), Integer.valueOf(iQ));
            }
            a4.t.i("MediaCodecUtil", "Unknown VP9 level: " + i11);
            return null;
        } catch (NumberFormatException unused) {
            a4.t.i("MediaCodecUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
    }

    @Nullable
    private static Integer z(@Nullable String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }
}

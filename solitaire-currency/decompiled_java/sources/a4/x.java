package a4;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.ts.TsExtractor;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: MimeTypes.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ArrayList<a> f251a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f252b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    /* JADX INFO: compiled from: MimeTypes.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f255c;
    }

    /* JADX INFO: compiled from: MimeTypes.java */
    @VisibleForTesting
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f257b;

        public b(int i10, int i11) {
            this.f256a = i10;
            this.f257b = i11;
        }

        public int a() {
            int i10 = this.f257b;
            if (i10 == 2) {
                return 10;
            }
            if (i10 == 5) {
                return 11;
            }
            if (i10 == 29) {
                return 12;
            }
            if (i10 == 42) {
                return 16;
            }
            if (i10 != 22) {
                return i10 != 23 ? 0 : 15;
            }
            return 1073741824;
        }
    }

    public static boolean a(@Nullable String str, @Nullable String str2) {
        b bVarG;
        int iA;
        if (str == null) {
            return false;
        }
        switch (str) {
            case "audio/mp4a-latm":
                if (str2 != null && (bVarG = g(str2)) != null && (iA = bVarG.a()) != 0 && iA != 16) {
                    break;
                }
                break;
        }
        return false;
    }

    @Nullable
    public static String b(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : o0.J0(str)) {
            String strE = e(str2);
            if (strE != null && l(strE)) {
                return strE;
            }
        }
        return null;
    }

    @Nullable
    private static String c(String str) {
        int size = f251a.size();
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = f251a.get(i10);
            if (str.startsWith(aVar.f254b)) {
                return aVar.f253a;
            }
        }
        return null;
    }

    public static int d(String str, @Nullable String str2) {
        b bVarG;
        str.hashCode();
        switch (str) {
            case "audio/eac3-joc":
                return 18;
            case "audio/vnd.dts":
                return 7;
            case "audio/mp4a-latm":
                if (str2 == null || (bVarG = g(str2)) == null) {
                    return 0;
                }
                return bVarG.a();
            case "audio/ac3":
                return 5;
            case "audio/ac4":
                return 17;
            case "audio/eac3":
                return 6;
            case "audio/mpeg":
                return 9;
            case "audio/vnd.dts.hd":
                return 8;
            case "audio/true-hd":
                return 14;
            default:
                return 0;
        }
    }

    @Nullable
    public static String e(@Nullable String str) {
        b bVarG;
        String strF = null;
        if (str == null) {
            return null;
        }
        String strE = e5.c.e(str.trim());
        if (strE.startsWith("avc1") || strE.startsWith("avc3")) {
            return "video/avc";
        }
        if (strE.startsWith("hev1") || strE.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (strE.startsWith("dvav") || strE.startsWith("dva1") || strE.startsWith("dvhe") || strE.startsWith("dvh1")) {
            return MimeTypes.VIDEO_DOLBY_VISION;
        }
        if (strE.startsWith("av01")) {
            return "video/av01";
        }
        if (strE.startsWith("vp9") || strE.startsWith("vp09")) {
            return MimeTypes.VIDEO_VP9;
        }
        if (strE.startsWith("vp8") || strE.startsWith("vp08")) {
            return MimeTypes.VIDEO_VP8;
        }
        if (!strE.startsWith("mp4a")) {
            return strE.startsWith("mha1") ? MimeTypes.AUDIO_MPEGH_MHA1 : strE.startsWith("mhm1") ? MimeTypes.AUDIO_MPEGH_MHM1 : (strE.startsWith("ac-3") || strE.startsWith("dac3")) ? MimeTypes.AUDIO_AC3 : (strE.startsWith("ec-3") || strE.startsWith("dec3")) ? MimeTypes.AUDIO_E_AC3 : strE.startsWith(MimeTypes.CODEC_E_AC3_JOC) ? MimeTypes.AUDIO_E_AC3_JOC : (strE.startsWith("ac-4") || strE.startsWith("dac4")) ? MimeTypes.AUDIO_AC4 : strE.startsWith("dtsc") ? MimeTypes.AUDIO_DTS : strE.startsWith("dtse") ? MimeTypes.AUDIO_DTS_EXPRESS : (strE.startsWith("dtsh") || strE.startsWith("dtsl")) ? MimeTypes.AUDIO_DTS_HD : strE.startsWith("dtsx") ? MimeTypes.AUDIO_DTS_X : strE.startsWith("opus") ? MimeTypes.AUDIO_OPUS : strE.startsWith("vorbis") ? MimeTypes.AUDIO_VORBIS : strE.startsWith("flac") ? MimeTypes.AUDIO_FLAC : strE.startsWith("stpp") ? MimeTypes.APPLICATION_TTML : strE.startsWith("wvtt") ? MimeTypes.TEXT_VTT : strE.contains("cea708") ? MimeTypes.APPLICATION_CEA708 : (strE.contains("eia608") || strE.contains("cea608")) ? MimeTypes.APPLICATION_CEA608 : c(strE);
        }
        if (strE.startsWith("mp4a.") && (bVarG = g(strE)) != null) {
            strF = f(bVarG.f256a);
        }
        return strF == null ? MimeTypes.AUDIO_AAC : strF;
    }

    @Nullable
    public static String f(int i10) {
        if (i10 == 32) {
            return MimeTypes.VIDEO_MP4V;
        }
        if (i10 == 33) {
            return "video/avc";
        }
        if (i10 == 35) {
            return "video/hevc";
        }
        if (i10 == 64) {
            return MimeTypes.AUDIO_AAC;
        }
        if (i10 == 163) {
            return MimeTypes.VIDEO_VC1;
        }
        if (i10 == 177) {
            return MimeTypes.VIDEO_VP9;
        }
        if (i10 == 165) {
            return MimeTypes.AUDIO_AC3;
        }
        if (i10 == 166) {
            return MimeTypes.AUDIO_E_AC3;
        }
        switch (i10) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return MimeTypes.VIDEO_MPEG2;
            case 102:
            case 103:
            case 104:
                return MimeTypes.AUDIO_AAC;
            case 105:
            case 107:
                return MimeTypes.AUDIO_MPEG;
            case 106:
                return MimeTypes.VIDEO_MPEG;
            default:
                switch (i10) {
                    case 169:
                    case TsExtractor.TS_STREAM_TYPE_AC4 /* 172 */:
                        return MimeTypes.AUDIO_DTS;
                    case 170:
                    case 171:
                        return MimeTypes.AUDIO_DTS_HD;
                    case 173:
                        return MimeTypes.AUDIO_OPUS;
                    case 174:
                        return MimeTypes.AUDIO_AC4;
                    default:
                        return null;
                }
        }
    }

    @Nullable
    @VisibleForTesting
    static b g(String str) {
        Matcher matcher = f252b.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String str2 = (String) a4.a.e(matcher.group(1));
        String strGroup = matcher.group(2);
        try {
            return new b(Integer.parseInt(str2, 16), strGroup != null ? Integer.parseInt(strGroup) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Nullable
    private static String h(@Nullable String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, iIndexOf);
    }

    public static int i(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (l(str)) {
            return 1;
        }
        if (o(str)) {
            return 2;
        }
        if (n(str)) {
            return 3;
        }
        if (m(str)) {
            return 4;
        }
        if (MimeTypes.APPLICATION_ID3.equals(str) || MimeTypes.APPLICATION_EMSG.equals(str) || MimeTypes.APPLICATION_SCTE35.equals(str)) {
            return 5;
        }
        if (MimeTypes.APPLICATION_CAMERA_MOTION.equals(str)) {
            return 6;
        }
        return j(str);
    }

    private static int j(String str) {
        int size = f251a.size();
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = f251a.get(i10);
            if (str.equals(aVar.f253a)) {
                return aVar.f255c;
            }
        }
        return -1;
    }

    @Nullable
    public static String k(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : o0.J0(str)) {
            String strE = e(str2);
            if (strE != null && o(strE)) {
                return strE;
            }
        }
        return null;
    }

    public static boolean l(@Nullable String str) {
        return "audio".equals(h(str));
    }

    public static boolean m(@Nullable String str) {
        return "image".equals(h(str));
    }

    public static boolean n(@Nullable String str) {
        return "text".equals(h(str)) || MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str) || MimeTypes.APPLICATION_MP4CEA608.equals(str) || MimeTypes.APPLICATION_SUBRIP.equals(str) || MimeTypes.APPLICATION_TTML.equals(str) || MimeTypes.APPLICATION_TX3G.equals(str) || MimeTypes.APPLICATION_MP4VTT.equals(str) || MimeTypes.APPLICATION_RAWCC.equals(str) || MimeTypes.APPLICATION_VOBSUB.equals(str) || MimeTypes.APPLICATION_PGS.equals(str) || MimeTypes.APPLICATION_DVBSUBS.equals(str);
    }

    public static boolean o(@Nullable String str) {
        return "video".equals(h(str));
    }

    public static String p(String str) {
        str.hashCode();
        switch (str) {
            case "audio/x-flac":
                return MimeTypes.AUDIO_FLAC;
            case "audio/x-wav":
                return MimeTypes.AUDIO_WAV;
            case "audio/mp3":
                return MimeTypes.AUDIO_MPEG;
            default:
                return str;
        }
    }
}

package b3;

import a4.o0;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.MimeTypes;
import b3.v;
import com.ironsource.v8;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.List;
import k2.o1;

/* JADX INFO: compiled from: MediaCodecInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final MediaCodecInfo.CodecCapabilities f2003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f2004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f2005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f2006g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f2007h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f2008i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f2009j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f2010k;

    /* JADX INFO: compiled from: MediaCodecInfo.java */
    @RequiresApi(29)
    private static final class a {
        @DoNotInline
        public static int a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i10, int i11, double d10) {
            List supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
            if (supportedPerformancePoints == null || supportedPerformancePoints.isEmpty()) {
                return 0;
            }
            MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint = new MediaCodecInfo.VideoCapabilities.PerformancePoint(i10, i11, (int) d10);
            for (int i12 = 0; i12 < supportedPerformancePoints.size(); i12++) {
                if (((MediaCodecInfo.VideoCapabilities.PerformancePoint) supportedPerformancePoints.get(i12)).covers(performancePoint)) {
                    return 2;
                }
            }
            return 1;
        }
    }

    @VisibleForTesting
    n(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        this.f2000a = (String) a4.a.e(str);
        this.f2001b = str2;
        this.f2002c = str3;
        this.f2003d = codecCapabilities;
        this.f2007h = z10;
        this.f2008i = z11;
        this.f2009j = z12;
        this.f2004e = z13;
        this.f2005f = z14;
        this.f2006g = z15;
        this.f2010k = a4.x.o(str2);
    }

    private static boolean A(String str, int i10) {
        if ("video/hevc".equals(str) && 2 == i10) {
            String str2 = o0.f215b;
            if ("sailfish".equals(str2) || "marlin".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean B(String str) {
        return ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) && "mcv5a".equals(o0.f215b)) ? false : true;
    }

    public static n C(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        return new n(str, str2, str3, codecCapabilities, z10, z11, z12, (z13 || codecCapabilities == null || !h(codecCapabilities) || z(str)) ? false : true, codecCapabilities != null && s(codecCapabilities), z14 || (codecCapabilities != null && q(codecCapabilities)));
    }

    private static int a(String str, String str2, int i10) {
        if (i10 > 1 || ((o0.f214a >= 26 && i10 > 0) || MimeTypes.AUDIO_MPEG.equals(str2) || MimeTypes.AUDIO_AMR_NB.equals(str2) || MimeTypes.AUDIO_AMR_WB.equals(str2) || MimeTypes.AUDIO_AAC.equals(str2) || MimeTypes.AUDIO_VORBIS.equals(str2) || MimeTypes.AUDIO_OPUS.equals(str2) || MimeTypes.AUDIO_RAW.equals(str2) || MimeTypes.AUDIO_FLAC.equals(str2) || MimeTypes.AUDIO_ALAW.equals(str2) || MimeTypes.AUDIO_MLAW.equals(str2) || MimeTypes.AUDIO_MSGSM.equals(str2))) {
            return i10;
        }
        int i11 = MimeTypes.AUDIO_AC3.equals(str2) ? 6 : MimeTypes.AUDIO_E_AC3.equals(str2) ? 16 : 30;
        a4.t.i(androidx.media3.exoplayer.mediacodec.MediaCodecInfo.TAG, "AssumedMaxChannelAdjustment: " + str + ", [" + i10 + " to " + i11 + v8.i.f15839e);
        return i11;
    }

    @RequiresApi(21)
    private static Point c(MediaCodecInfo.VideoCapabilities videoCapabilities, int i10, int i11) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(o0.l(i10, widthAlignment) * widthAlignment, o0.l(i11, heightAlignment) * heightAlignment);
    }

    @RequiresApi(21)
    private static boolean d(MediaCodecInfo.VideoCapabilities videoCapabilities, int i10, int i11, double d10) {
        Point pointC = c(videoCapabilities, i10, i11);
        int i12 = pointC.x;
        int i13 = pointC.y;
        return (d10 == -1.0d || d10 < 1.0d) ? videoCapabilities.isSizeSupported(i12, i13) : videoCapabilities.areSizeAndRateSupported(i12, i13, Math.floor(d10));
    }

    private static MediaCodecInfo.CodecProfileLevel[] f(@Nullable MediaCodecInfo.CodecCapabilities codecCapabilities) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int iIntValue = (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) ? 0 : ((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue();
        int i10 = iIntValue >= 180000000 ? 1024 : iIntValue >= 120000000 ? 512 : iIntValue >= 60000000 ? 256 : iIntValue >= 30000000 ? 128 : iIntValue >= 18000000 ? 64 : iIntValue >= 12000000 ? 32 : iIntValue >= 7200000 ? 16 : iIntValue >= 3600000 ? 8 : iIntValue >= 1800000 ? 4 : iIntValue >= 800000 ? 2 : 1;
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = 1;
        codecProfileLevel.level = i10;
        return new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
    }

    private static boolean h(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return o0.f214a >= 19 && i(codecCapabilities);
    }

    @RequiresApi(19)
    private static boolean i(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private boolean l(o1 o1Var) {
        Pair<Integer, Integer> pairQ;
        if (o1Var.f29344i == null || (pairQ = v.q(o1Var)) == null) {
            return true;
        }
        int iIntValue = ((Integer) pairQ.first).intValue();
        int iIntValue2 = ((Integer) pairQ.second).intValue();
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(o1Var.f29347l)) {
            if (!"video/avc".equals(this.f2001b)) {
                iIntValue = "video/hevc".equals(this.f2001b) ? 2 : 8;
            }
            iIntValue2 = 0;
        }
        if (!this.f2010k && iIntValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrG = g();
        if (o0.f214a <= 23 && MimeTypes.VIDEO_VP9.equals(this.f2001b) && codecProfileLevelArrG.length == 0) {
            codecProfileLevelArrG = f(this.f2003d);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArrG) {
            if (codecProfileLevel.profile == iIntValue && codecProfileLevel.level >= iIntValue2 && !A(this.f2001b, iIntValue)) {
                return true;
            }
        }
        w("codec.profileLevel, " + o1Var.f29344i + ", " + this.f2002c);
        return false;
    }

    private boolean o(o1 o1Var) {
        return this.f2001b.equals(o1Var.f29347l) || this.f2001b.equals(v.m(o1Var));
    }

    private static boolean q(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return o0.f214a >= 21 && r(codecCapabilities);
    }

    @RequiresApi(21)
    private static boolean r(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private static boolean s(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return o0.f214a >= 21 && t(codecCapabilities);
    }

    @RequiresApi(21)
    private static boolean t(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private void v(String str) {
        a4.t.b(androidx.media3.exoplayer.mediacodec.MediaCodecInfo.TAG, "AssumedSupport [" + str + "] [" + this.f2000a + ", " + this.f2001b + "] [" + o0.f218e + v8.i.f15839e);
    }

    private void w(String str) {
        a4.t.b(androidx.media3.exoplayer.mediacodec.MediaCodecInfo.TAG, "NoSupport [" + str + "] [" + this.f2000a + ", " + this.f2001b + "] [" + o0.f218e + v8.i.f15839e);
    }

    private static boolean x(String str) {
        return MimeTypes.AUDIO_OPUS.equals(str);
    }

    private static boolean y(String str) {
        return o0.f217d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    private static boolean z(String str) {
        if (o0.f214a <= 22) {
            String str2 = o0.f217d;
            if (("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    @RequiresApi(21)
    public Point b(int i10, int i11) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f2003d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return c(videoCapabilities, i10, i11);
    }

    public n2.i e(o1 o1Var, o1 o1Var2) {
        int i10 = !o0.c(o1Var.f29347l, o1Var2.f29347l) ? 8 : 0;
        if (this.f2010k) {
            if (o1Var.f29355t != o1Var2.f29355t) {
                i10 |= 1024;
            }
            if (!this.f2004e && (o1Var.f29352q != o1Var2.f29352q || o1Var.f29353r != o1Var2.f29353r)) {
                i10 |= 512;
            }
            if (!o0.c(o1Var.f29359x, o1Var2.f29359x)) {
                i10 |= 2048;
            }
            if (y(this.f2000a) && !o1Var.g(o1Var2)) {
                i10 |= 2;
            }
            if (i10 == 0) {
                return new n2.i(this.f2000a, o1Var, o1Var2, o1Var.g(o1Var2) ? 3 : 2, 0);
            }
        } else {
            if (o1Var.f29360y != o1Var2.f29360y) {
                i10 |= 4096;
            }
            if (o1Var.f29361z != o1Var2.f29361z) {
                i10 |= 8192;
            }
            if (o1Var.A != o1Var2.A) {
                i10 |= 16384;
            }
            if (i10 == 0 && MimeTypes.AUDIO_AAC.equals(this.f2001b)) {
                Pair<Integer, Integer> pairQ = v.q(o1Var);
                Pair<Integer, Integer> pairQ2 = v.q(o1Var2);
                if (pairQ != null && pairQ2 != null) {
                    int iIntValue = ((Integer) pairQ.first).intValue();
                    int iIntValue2 = ((Integer) pairQ2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new n2.i(this.f2000a, o1Var, o1Var2, 3, 0);
                    }
                }
            }
            if (!o1Var.g(o1Var2)) {
                i10 |= 32;
            }
            if (x(this.f2001b)) {
                i10 |= 2;
            }
            if (i10 == 0) {
                return new n2.i(this.f2000a, o1Var, o1Var2, 1, 0);
            }
        }
        return new n2.i(this.f2000a, o1Var, o1Var2, 0, i10);
    }

    public MediaCodecInfo.CodecProfileLevel[] g() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f2003d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    @RequiresApi(21)
    public boolean j(int i10) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f2003d;
        if (codecCapabilities == null) {
            w("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            w("channelCount.aCaps");
            return false;
        }
        if (a(this.f2000a, this.f2001b, audioCapabilities.getMaxInputChannelCount()) >= i10) {
            return true;
        }
        w("channelCount.support, " + i10);
        return false;
    }

    @RequiresApi(21)
    public boolean k(int i10) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f2003d;
        if (codecCapabilities == null) {
            w("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            w("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i10)) {
            return true;
        }
        w("sampleRate.support, " + i10);
        return false;
    }

    public boolean m(o1 o1Var) throws v.c {
        int i10;
        if (!o(o1Var) || !l(o1Var)) {
            return false;
        }
        if (!this.f2010k) {
            if (o0.f214a >= 21) {
                int i11 = o1Var.f29361z;
                if (i11 != -1 && !k(i11)) {
                    return false;
                }
                int i12 = o1Var.f29360y;
                if (i12 != -1 && !j(i12)) {
                    return false;
                }
            }
            return true;
        }
        int i13 = o1Var.f29352q;
        if (i13 <= 0 || (i10 = o1Var.f29353r) <= 0) {
            return true;
        }
        if (o0.f214a >= 21) {
            return u(i13, i10, o1Var.f29354s);
        }
        boolean z10 = i13 * i10 <= v.N();
        if (!z10) {
            w("legacyFrameSize, " + o1Var.f29352q + ViewHierarchyNode.JsonKeys.X + o1Var.f29353r);
        }
        return z10;
    }

    public boolean n() {
        if (o0.f214a >= 29 && MimeTypes.VIDEO_VP9.equals(this.f2001b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : g()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean p(o1 o1Var) {
        if (this.f2010k) {
            return this.f2004e;
        }
        Pair<Integer, Integer> pairQ = v.q(o1Var);
        return pairQ != null && ((Integer) pairQ.first).intValue() == 42;
    }

    public String toString() {
        return this.f2000a;
    }

    @RequiresApi(21)
    public boolean u(int i10, int i11, double d10) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f2003d;
        if (codecCapabilities == null) {
            w("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            w("sizeAndRate.vCaps");
            return false;
        }
        if (o0.f214a >= 29) {
            int iA = a.a(videoCapabilities, i10, i11, d10);
            if (iA == 2) {
                return true;
            }
            if (iA == 1) {
                w("sizeAndRate.cover, " + i10 + ViewHierarchyNode.JsonKeys.X + i11 + "@" + d10);
                return false;
            }
        }
        if (!d(videoCapabilities, i10, i11, d10)) {
            if (i10 >= i11 || !B(this.f2000a) || !d(videoCapabilities, i11, i10, d10)) {
                w("sizeAndRate.support, " + i10 + ViewHierarchyNode.JsonKeys.X + i11 + "@" + d10);
                return false;
            }
            v("sizeAndRate.rotated, " + i10 + ViewHierarchyNode.JsonKeys.X + i11 + "@" + d10);
        }
        return true;
    }
}

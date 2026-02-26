package m2;

import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.DtsUtil;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.OpusUtil;

/* JADX INFO: compiled from: MpegAudioUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f31280a = {MimeTypes.AUDIO_MPEG_L1, MimeTypes.AUDIO_MPEG_L2, MimeTypes.AUDIO_MPEG};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f31281b = {44100, OpusUtil.SAMPLE_RATE, 32000};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f31282c = {32000, 64000, 96000, 128000, 160000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND, 288000, 320000, 352000, 384000, 416000, 448000};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f31283d = {32000, OpusUtil.SAMPLE_RATE, 56000, 64000, Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND, 96000, 112000, 128000, 144000, 160000, 176000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f31284e = {32000, OpusUtil.SAMPLE_RATE, 56000, 64000, Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND, 96000, 112000, 128000, 160000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND, 320000, 384000};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f31285f = {32000, MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND, OpusUtil.SAMPLE_RATE, 56000, 64000, Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND, 96000, 112000, 128000, 160000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND, 320000};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f31286g = {8000, 16000, 24000, 32000, MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND, OpusUtil.SAMPLE_RATE, 56000, 64000, Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND, 96000, 112000, 128000, 144000, 160000};

    /* JADX INFO: compiled from: MpegAudioUtil.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public String f31288b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f31289c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f31290d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f31291e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f31292f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f31293g;

        public boolean a(int i10) {
            int i11;
            int i12;
            int i13;
            int i14;
            if (!h0.l(i10) || (i11 = (i10 >>> 19) & 3) == 1 || (i12 = (i10 >>> 17) & 3) == 0 || (i13 = (i10 >>> 12) & 15) == 0 || i13 == 15 || (i14 = (i10 >>> 10) & 3) == 3) {
                return false;
            }
            this.f31287a = i11;
            this.f31288b = h0.f31280a[3 - i12];
            int i15 = h0.f31281b[i14];
            this.f31290d = i15;
            if (i11 == 2) {
                this.f31290d = i15 / 2;
            } else if (i11 == 0) {
                this.f31290d = i15 / 4;
            }
            int i16 = (i10 >>> 9) & 1;
            this.f31293g = h0.k(i11, i12);
            if (i12 == 3) {
                int i17 = i11 == 3 ? h0.f31282c[i13 - 1] : h0.f31283d[i13 - 1];
                this.f31292f = i17;
                this.f31289c = (((i17 * 12) / this.f31290d) + i16) * 4;
            } else {
                if (i11 == 3) {
                    int i18 = i12 == 2 ? h0.f31284e[i13 - 1] : h0.f31285f[i13 - 1];
                    this.f31292f = i18;
                    this.f31289c = ((i18 * 144) / this.f31290d) + i16;
                } else {
                    int i19 = h0.f31286g[i13 - 1];
                    this.f31292f = i19;
                    this.f31289c = (((i12 == 1 ? 72 : 144) * i19) / this.f31290d) + i16;
                }
            }
            this.f31291e = ((i10 >> 6) & 3) == 3 ? 1 : 2;
            return true;
        }
    }

    public static int j(int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (!l(i10) || (i11 = (i10 >>> 19) & 3) == 1 || (i12 = (i10 >>> 17) & 3) == 0 || (i13 = (i10 >>> 12) & 15) == 0 || i13 == 15 || (i14 = (i10 >>> 10) & 3) == 3) {
            return -1;
        }
        int i15 = f31281b[i14];
        if (i11 == 2) {
            i15 /= 2;
        } else if (i11 == 0) {
            i15 /= 4;
        }
        int i16 = (i10 >>> 9) & 1;
        if (i12 == 3) {
            return ((((i11 == 3 ? f31282c[i13 - 1] : f31283d[i13 - 1]) * 12) / i15) + i16) * 4;
        }
        int i17 = i11 == 3 ? i12 == 2 ? f31284e[i13 - 1] : f31285f[i13 - 1] : f31286g[i13 - 1];
        if (i11 == 3) {
            return ((i17 * 144) / i15) + i16;
        }
        return (((i12 == 1 ? 72 : 144) * i17) / i15) + i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(int i10, int i11) {
        if (i11 == 1) {
            return i10 == 3 ? 1152 : 576;
        }
        if (i11 == 2) {
            return 1152;
        }
        if (i11 == 3) {
            return RendererCapabilities.DECODER_SUPPORT_MASK;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(int i10) {
        return (i10 & (-2097152)) == -2097152;
    }

    public static int m(int i10) {
        int i11;
        int i12;
        if (!l(i10) || (i11 = (i10 >>> 19) & 3) == 1 || (i12 = (i10 >>> 17) & 3) == 0) {
            return -1;
        }
        int i13 = (i10 >>> 12) & 15;
        int i14 = (i10 >>> 10) & 3;
        if (i13 == 0 || i13 == 15 || i14 == 3) {
            return -1;
        }
        return k(i11, i12);
    }
}

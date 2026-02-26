package m2;

import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.DtsUtil;
import androidx.media3.extractor.MpegAudioUtil;
import m2.c0;

/* JADX INFO: compiled from: DefaultAudioTrackBufferSizeProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public class d0 implements c0.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final int f31237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int f31238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final int f31239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final int f31240e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final int f31241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f31242g;

    /* JADX INFO: compiled from: DefaultAudioTrackBufferSizeProvider.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f31243a = 250000;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f31244b = 750000;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f31245c = 4;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f31246d = 250000;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f31247e = 50000000;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f31248f = 2;

        public d0 g() {
            return new d0(this);
        }
    }

    protected d0(a aVar) {
        this.f31237b = aVar.f31243a;
        this.f31238c = aVar.f31244b;
        this.f31239d = aVar.f31245c;
        this.f31240e = aVar.f31246d;
        this.f31241f = aVar.f31247e;
        this.f31242g = aVar.f31248f;
    }

    protected static int b(int i10, int i11, int i12) {
        return g5.e.d(((((long) i10) * ((long) i11)) * ((long) i12)) / 1000000);
    }

    protected static int d(int i10) {
        switch (i10) {
            case 5:
                return Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND;
            case 6:
            case 18:
                return 768000;
            case 7:
                return DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND;
            case 8:
                return DtsUtil.DTS_HD_MAX_RATE_BYTES_PER_SECOND;
            case 9:
                return MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 13:
            default:
                throw new IllegalArgumentException();
            case 14:
                return Ac3Util.TRUEHD_MAX_RATE_BYTES_PER_SECOND;
            case 15:
                return 8000;
            case 16:
                return AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND;
            case 17:
                return Ac4Util.MAX_RATE_BYTES_PER_SECOND;
        }
    }

    @Override // m2.c0.e
    public int a(int i10, int i11, int i12, int i13, int i14, double d10) {
        return (((Math.max(i10, (int) (((double) c(i10, i11, i12, i13, i14)) * d10)) + i13) - 1) / i13) * i13;
    }

    protected int c(int i10, int i11, int i12, int i13, int i14) {
        if (i12 == 0) {
            return g(i10, i14, i13);
        }
        if (i12 == 1) {
            return e(i11);
        }
        if (i12 == 2) {
            return f(i11);
        }
        throw new IllegalArgumentException();
    }

    protected int e(int i10) {
        return g5.e.d((((long) this.f31241f) * ((long) d(i10))) / 1000000);
    }

    protected int f(int i10) {
        int i11 = this.f31240e;
        if (i10 == 5) {
            i11 *= this.f31242g;
        }
        return g5.e.d((((long) i11) * ((long) d(i10))) / 1000000);
    }

    protected int g(int i10, int i11, int i12) {
        return a4.o0.p(i10 * this.f31239d, b(this.f31237b, i11, i12), b(this.f31238c, i11, i12));
    }
}

package r2;

import a4.c0;
import a4.o0;
import a4.t;
import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.avi.AviExtractor;
import com.google.common.collect.y;
import k2.o1;

/* JADX INFO: compiled from: StreamFormatChunk.java */
/* JADX INFO: loaded from: classes2.dex */
final class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o1 f33300a;

    public g(o1 o1Var) {
        this.f33300a = o1Var;
    }

    @Nullable
    private static String a(int i10) {
        switch (i10) {
            case 808802372:
            case 877677894:
            case 1145656883:
            case 1145656920:
            case 1482049860:
            case 1684633208:
            case 2021026148:
                return MimeTypes.VIDEO_MP4V;
            case 826496577:
            case 828601953:
            case 875967048:
                return "video/avc";
            case 842289229:
                return MimeTypes.VIDEO_MP42;
            case 859066445:
                return MimeTypes.VIDEO_MP43;
            case 1196444237:
            case 1735420525:
                return MimeTypes.VIDEO_MJPEG;
            default:
                return null;
        }
    }

    @Nullable
    private static String b(int i10) {
        if (i10 == 1) {
            return MimeTypes.AUDIO_RAW;
        }
        if (i10 == 85) {
            return MimeTypes.AUDIO_MPEG;
        }
        if (i10 == 255) {
            return MimeTypes.AUDIO_AAC;
        }
        if (i10 == 8192) {
            return MimeTypes.AUDIO_AC3;
        }
        if (i10 != 8193) {
            return null;
        }
        return MimeTypes.AUDIO_DTS;
    }

    @Nullable
    private static a c(c0 c0Var) {
        c0Var.Q(4);
        int iQ = c0Var.q();
        int iQ2 = c0Var.q();
        c0Var.Q(4);
        int iQ3 = c0Var.q();
        String strA = a(iQ3);
        if (strA != null) {
            o1.b bVar = new o1.b();
            bVar.j0(iQ).Q(iQ2).e0(strA);
            return new g(bVar.E());
        }
        t.i("StreamFormatChunk", "Ignoring track with unsupported compression " + iQ3);
        return null;
    }

    @Nullable
    public static a d(int i10, c0 c0Var) {
        if (i10 == 2) {
            return c(c0Var);
        }
        if (i10 == 1) {
            return e(c0Var);
        }
        t.i("StreamFormatChunk", "Ignoring strf box for unsupported track type: " + o0.g0(i10));
        return null;
    }

    @Nullable
    private static a e(c0 c0Var) {
        int iV = c0Var.v();
        String strB = b(iV);
        if (strB == null) {
            t.i("StreamFormatChunk", "Ignoring track with unsupported format tag " + iV);
            return null;
        }
        int iV2 = c0Var.v();
        int iQ = c0Var.q();
        c0Var.Q(6);
        int iW = o0.W(c0Var.J());
        int iV3 = c0Var.v();
        byte[] bArr = new byte[iV3];
        c0Var.j(bArr, 0, iV3);
        o1.b bVar = new o1.b();
        bVar.e0(strB).H(iV2).f0(iQ);
        if (MimeTypes.AUDIO_RAW.equals(strB) && iW != 0) {
            bVar.Y(iW);
        }
        if (MimeTypes.AUDIO_AAC.equals(strB) && iV3 > 0) {
            bVar.T(y.r(bArr));
        }
        return new g(bVar.E());
    }

    @Override // r2.a
    public int getType() {
        return AviExtractor.FOURCC_strf;
    }
}

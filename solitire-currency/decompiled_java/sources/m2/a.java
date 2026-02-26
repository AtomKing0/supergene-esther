package m2;

import androidx.media3.extractor.OpusUtil;
import k2.j2;

/* JADX INFO: compiled from: AacUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f31142a = {96000, 88200, 64000, OpusUtil.SAMPLE_RATE, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f31143b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* JADX INFO: compiled from: AacUtil.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f31145b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f31146c;

        private b(int i10, int i11, String str) {
            this.f31144a = i10;
            this.f31145b = i11;
            this.f31146c = str;
        }
    }

    public static byte[] a(int i10, int i11, int i12) {
        return new byte[]{(byte) (((i10 << 3) & 248) | ((i11 >> 1) & 7)), (byte) (((i11 << 7) & 128) | ((i12 << 3) & 120))};
    }

    private static int b(a4.b0 b0Var) {
        int iH = b0Var.h(5);
        return iH == 31 ? b0Var.h(6) + 32 : iH;
    }

    private static int c(a4.b0 b0Var) throws j2 {
        int iH = b0Var.h(4);
        if (iH == 15) {
            return b0Var.h(24);
        }
        if (iH < 13) {
            return f31142a[iH];
        }
        throw j2.a(null, null);
    }

    public static b d(a4.b0 b0Var, boolean z10) throws j2 {
        int iB = b(b0Var);
        int iC = c(b0Var);
        int iH = b0Var.h(4);
        String str = "mp4a.40." + iB;
        if (iB == 5 || iB == 29) {
            iC = c(b0Var);
            iB = b(b0Var);
            if (iB == 22) {
                iH = b0Var.h(4);
            }
        }
        if (z10) {
            if (iB != 1 && iB != 2 && iB != 3 && iB != 4 && iB != 6 && iB != 7 && iB != 17) {
                switch (iB) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw j2.c("Unsupported audio object type: " + iB);
                }
            }
            f(b0Var, iB, iH);
            switch (iB) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int iH2 = b0Var.h(2);
                    if (iH2 == 2 || iH2 == 3) {
                        throw j2.c("Unsupported epConfig: " + iH2);
                    }
                    break;
            }
        }
        int i10 = f31143b[iH];
        if (i10 != -1) {
            return new b(iC, i10, str);
        }
        throw j2.a(null, null);
    }

    public static b e(byte[] bArr) throws j2 {
        return d(new a4.b0(bArr), false);
    }

    private static void f(a4.b0 b0Var, int i10, int i11) {
        if (b0Var.g()) {
            a4.t.i("AacUtil", "Unexpected frameLengthFlag = 1");
        }
        if (b0Var.g()) {
            b0Var.r(14);
        }
        boolean zG = b0Var.g();
        if (i11 == 0) {
            throw new UnsupportedOperationException();
        }
        if (i10 == 6 || i10 == 20) {
            b0Var.r(3);
        }
        if (zG) {
            if (i10 == 22) {
                b0Var.r(16);
            }
            if (i10 == 17 || i10 == 19 || i10 == 20 || i10 == 23) {
                b0Var.r(3);
            }
            b0Var.r(1);
        }
    }
}

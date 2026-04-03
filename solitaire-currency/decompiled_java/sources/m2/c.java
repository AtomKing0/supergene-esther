package m2;

import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.OpusUtil;
import java.nio.ByteBuffer;
import k2.o1;

/* JADX INFO: compiled from: Ac4Util.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f31163a = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* JADX INFO: compiled from: Ac4Util.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f31165b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f31166c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f31167d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f31168e;

        private b(int i10, int i11, int i12, int i13, int i14) {
            this.f31164a = i10;
            this.f31166c = i11;
            this.f31165b = i12;
            this.f31167d = i13;
            this.f31168e = i14;
        }
    }

    public static void a(int i10, a4.c0 c0Var) {
        c0Var.L(7);
        byte[] bArrD = c0Var.d();
        bArrD[0] = -84;
        bArrD[1] = 64;
        bArrD[2] = -1;
        bArrD[3] = -1;
        bArrD[4] = (byte) ((i10 >> 16) & 255);
        bArrD[5] = (byte) ((i10 >> 8) & 255);
        bArrD[6] = (byte) (i10 & 255);
    }

    public static o1 b(a4.c0 c0Var, String str, String str2, @Nullable o2.m mVar) {
        c0Var.Q(1);
        return new o1.b().S(str).e0(MimeTypes.AUDIO_AC4).H(2).f0(((c0Var.D() & 32) >> 5) == 1 ? OpusUtil.SAMPLE_RATE : 44100).M(mVar).V(str2).E();
    }

    public static int c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        return d(new a4.b0(bArr)).f31168e;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static m2.c.b d(a4.b0 r11) {
        /*
            r0 = 16
            int r1 = r11.h(r0)
            int r0 = r11.h(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L18
            r0 = 24
            int r0 = r11.h(r0)
            r2 = 7
            goto L19
        L18:
            r2 = r3
        L19:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L21
            int r0 = r0 + 2
        L21:
            r8 = r0
            r0 = 2
            int r1 = r11.h(r0)
            r2 = 3
            if (r1 != r2) goto L2f
            int r4 = f(r11, r0)
            int r1 = r1 + r4
        L2f:
            r5 = r1
            r1 = 10
            int r1 = r11.h(r1)
            boolean r4 = r11.g()
            if (r4 == 0) goto L45
            int r4 = r11.h(r2)
            if (r4 <= 0) goto L45
            r11.r(r0)
        L45:
            boolean r4 = r11.g()
            r6 = 48000(0xbb80, float:6.7262E-41)
            r7 = 44100(0xac44, float:6.1797E-41)
            if (r4 == 0) goto L53
            r9 = r6
            goto L54
        L53:
            r9 = r7
        L54:
            int r11 = r11.h(r3)
            if (r9 != r7) goto L63
            r4 = 13
            if (r11 != r4) goto L63
            int[] r0 = m2.c.f31163a
            r11 = r0[r11]
            goto L93
        L63:
            if (r9 != r6) goto L92
            int[] r4 = m2.c.f31163a
            int r6 = r4.length
            if (r11 >= r6) goto L92
            r4 = r4[r11]
            int r1 = r1 % 5
            r6 = 8
            r7 = 1
            if (r1 == r7) goto L88
            r7 = 11
            if (r1 == r0) goto L83
            if (r1 == r2) goto L88
            if (r1 == r3) goto L7c
            goto L8d
        L7c:
            if (r11 == r2) goto L8f
            if (r11 == r6) goto L8f
            if (r11 != r7) goto L8d
            goto L8f
        L83:
            if (r11 == r6) goto L8f
            if (r11 != r7) goto L8d
            goto L8f
        L88:
            if (r11 == r2) goto L8f
            if (r11 != r6) goto L8d
            goto L8f
        L8d:
            r11 = r4
            goto L93
        L8f:
            int r4 = r4 + 1
            goto L8d
        L92:
            r11 = 0
        L93:
            m2.c$b r0 = new m2.c$b
            r6 = 2
            r10 = 0
            r4 = r0
            r7 = r9
            r9 = r11
            r4.<init>(r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.c.d(a4.b0):m2.c$b");
    }

    public static int e(byte[] bArr, int i10) {
        int i11 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        int i12 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (i12 == 65535) {
            i12 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i11 = 4;
        }
        if (i10 == 44097) {
            i11 += 2;
        }
        return i12 + i11;
    }

    private static int f(a4.b0 b0Var, int i10) {
        int i11 = 0;
        while (true) {
            int iH = i11 + b0Var.h(i10);
            if (!b0Var.g()) {
                return iH;
            }
            i11 = (iH + 1) << i10;
        }
    }
}

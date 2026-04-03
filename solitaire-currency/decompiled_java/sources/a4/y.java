package a4;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: NalUnitUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f258a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[] f259b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f260c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int[] f261d = new int[10];

    /* JADX INFO: compiled from: NalUnitUtil.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f264c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f265d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f266e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f267f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f268g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f269h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f270i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final float f271j;

        public a(int i10, boolean z10, int i11, int i12, int[] iArr, int i13, int i14, int i15, int i16, float f10) {
            this.f262a = i10;
            this.f263b = z10;
            this.f264c = i11;
            this.f265d = i12;
            this.f266e = iArr;
            this.f267f = i13;
            this.f268g = i14;
            this.f269h = i15;
            this.f270i = i16;
            this.f271j = f10;
        }
    }

    /* JADX INFO: compiled from: NalUnitUtil.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f273b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f274c;

        public b(int i10, int i11, boolean z10) {
            this.f272a = i10;
            this.f273b = i11;
            this.f274c = z10;
        }
    }

    /* JADX INFO: compiled from: NalUnitUtil.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f276b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f277c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f278d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f279e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f280f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f281g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f282h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f283i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f284j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f285k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f286l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f287m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f288n;

        public c(int i10, int i11, int i12, int i13, int i14, int i15, int i16, float f10, boolean z10, boolean z11, int i17, int i18, int i19, boolean z12) {
            this.f275a = i10;
            this.f276b = i11;
            this.f277c = i12;
            this.f278d = i13;
            this.f279e = i14;
            this.f280f = i15;
            this.f281g = i16;
            this.f282h = f10;
            this.f283i = z10;
            this.f284j = z11;
            this.f285k = i17;
            this.f286l = i18;
            this.f287m = i19;
            this.f288n = z12;
        }
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static void b(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int i12 = i10 + 1;
            if (i12 >= iPosition) {
                byteBuffer.clear();
                return;
            }
            int i13 = byteBuffer.get(i10) & 255;
            if (i11 == 3) {
                if (i13 == 1 && (byteBuffer.get(i12) & 31) == 7) {
                    ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                    byteBufferDuplicate.position(i10 - 3);
                    byteBufferDuplicate.limit(iPosition);
                    byteBuffer.position(0);
                    byteBuffer.put(byteBufferDuplicate);
                    return;
                }
            } else if (i13 == 0) {
                i11++;
            }
            if (i13 != 0) {
                i11 = 0;
            }
            i10 = i12;
        }
    }

    public static int c(byte[] bArr, int i10, int i11, boolean[] zArr) {
        int i12 = i11 - i10;
        a4.a.g(i12 >= 0);
        if (i12 == 0) {
            return i11;
        }
        if (zArr[0]) {
            a(zArr);
            return i10 - 3;
        }
        if (i12 > 1 && zArr[1] && bArr[i10] == 1) {
            a(zArr);
            return i10 - 2;
        }
        if (i12 > 2 && zArr[2] && bArr[i10] == 0 && bArr[i10 + 1] == 1) {
            a(zArr);
            return i10 - 1;
        }
        int i13 = i11 - 1;
        int i14 = i10 + 2;
        while (i14 < i13) {
            byte b10 = bArr[i14];
            if ((b10 & 254) == 0) {
                int i15 = i14 - 2;
                if (bArr[i15] == 0 && bArr[i14 - 1] == 0 && b10 == 1) {
                    a(zArr);
                    return i15;
                }
                i14 -= 2;
            }
            i14 += 3;
        }
        zArr[0] = i12 <= 2 ? !(i12 != 2 ? !(zArr[1] && bArr[i13] == 1) : !(zArr[2] && bArr[i11 + (-2)] == 0 && bArr[i13] == 1)) : bArr[i11 + (-3)] == 0 && bArr[i11 + (-2)] == 0 && bArr[i13] == 1;
        zArr[1] = i12 <= 1 ? zArr[2] && bArr[i13] == 0 : bArr[i11 + (-2)] == 0 && bArr[i13] == 0;
        zArr[2] = bArr[i13] == 0;
        return i11;
    }

    private static int d(byte[] bArr, int i10, int i11) {
        while (i10 < i11 - 2) {
            if (bArr[i10] == 0 && bArr[i10 + 1] == 0 && bArr[i10 + 2] == 3) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static int e(byte[] bArr, int i10) {
        return (bArr[i10 + 3] & 126) >> 1;
    }

    public static int f(byte[] bArr, int i10) {
        return bArr[i10 + 3] & 31;
    }

    public static boolean g(@Nullable String str, byte b10) {
        if ("video/avc".equals(str) && (b10 & 31) == 6) {
            return true;
        }
        return "video/hevc".equals(str) && ((b10 & 126) >> 1) == 39;
    }

    public static a h(byte[] bArr, int i10, int i11) {
        return i(bArr, i10 + 2, i11);
    }

    public static a i(byte[] bArr, int i10, int i11) {
        d0 d0Var = new d0(bArr, i10, i11);
        d0Var.l(4);
        int iE = d0Var.e(3);
        d0Var.k();
        int iE2 = d0Var.e(2);
        boolean zD = d0Var.d();
        int iE3 = d0Var.e(5);
        int i12 = 0;
        for (int i13 = 0; i13 < 32; i13++) {
            if (d0Var.d()) {
                i12 |= 1 << i13;
            }
        }
        int[] iArr = new int[6];
        for (int i14 = 0; i14 < 6; i14++) {
            iArr[i14] = d0Var.e(8);
        }
        int iE4 = d0Var.e(8);
        int i15 = 0;
        for (int i16 = 0; i16 < iE; i16++) {
            if (d0Var.d()) {
                i15 += 89;
            }
            if (d0Var.d()) {
                i15 += 8;
            }
        }
        d0Var.l(i15);
        if (iE > 0) {
            d0Var.l((8 - iE) * 2);
        }
        int iH = d0Var.h();
        int iH2 = d0Var.h();
        if (iH2 == 3) {
            d0Var.k();
        }
        int iH3 = d0Var.h();
        int iH4 = d0Var.h();
        if (d0Var.d()) {
            int iH5 = d0Var.h();
            int iH6 = d0Var.h();
            int iH7 = d0Var.h();
            int iH8 = d0Var.h();
            iH3 -= ((iH2 == 1 || iH2 == 2) ? 2 : 1) * (iH5 + iH6);
            iH4 -= (iH2 == 1 ? 2 : 1) * (iH7 + iH8);
        }
        d0Var.h();
        d0Var.h();
        int iH9 = d0Var.h();
        for (int i17 = d0Var.d() ? 0 : iE; i17 <= iE; i17++) {
            d0Var.h();
            d0Var.h();
            d0Var.h();
        }
        d0Var.h();
        d0Var.h();
        d0Var.h();
        d0Var.h();
        d0Var.h();
        d0Var.h();
        if (d0Var.d() && d0Var.d()) {
            n(d0Var);
        }
        d0Var.l(2);
        if (d0Var.d()) {
            d0Var.l(8);
            d0Var.h();
            d0Var.h();
            d0Var.k();
        }
        p(d0Var);
        if (d0Var.d()) {
            for (int i18 = 0; i18 < d0Var.h(); i18++) {
                d0Var.l(iH9 + 4 + 1);
            }
        }
        d0Var.l(2);
        float f10 = 1.0f;
        if (d0Var.d()) {
            if (d0Var.d()) {
                int iE5 = d0Var.e(8);
                if (iE5 == 255) {
                    int iE6 = d0Var.e(16);
                    int iE7 = d0Var.e(16);
                    if (iE6 != 0 && iE7 != 0) {
                        f10 = iE6 / iE7;
                    }
                } else {
                    float[] fArr = f259b;
                    if (iE5 < fArr.length) {
                        f10 = fArr[iE5];
                    } else {
                        t.i("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iE5);
                    }
                }
            }
            if (d0Var.d()) {
                d0Var.k();
            }
            if (d0Var.d()) {
                d0Var.l(4);
                if (d0Var.d()) {
                    d0Var.l(24);
                }
            }
            if (d0Var.d()) {
                d0Var.h();
                d0Var.h();
            }
            d0Var.k();
            if (d0Var.d()) {
                iH4 *= 2;
            }
        }
        return new a(iE2, zD, iE3, i12, iArr, iE4, iH, iH3, iH4, f10);
    }

    public static b j(byte[] bArr, int i10, int i11) {
        return k(bArr, i10 + 1, i11);
    }

    public static b k(byte[] bArr, int i10, int i11) {
        d0 d0Var = new d0(bArr, i10, i11);
        int iH = d0Var.h();
        int iH2 = d0Var.h();
        d0Var.k();
        return new b(iH, iH2, d0Var.d());
    }

    public static c l(byte[] bArr, int i10, int i11) {
        return m(bArr, i10 + 1, i11);
    }

    public static c m(byte[] bArr, int i10, int i11) {
        int iH;
        boolean zD;
        int i12;
        boolean z10;
        boolean z11;
        int iH2;
        float f10;
        int i13;
        d0 d0Var = new d0(bArr, i10, i11);
        int iE = d0Var.e(8);
        int iE2 = d0Var.e(8);
        int iE3 = d0Var.e(8);
        int iH3 = d0Var.h();
        if (iE == 100 || iE == 110 || iE == 122 || iE == 244 || iE == 44 || iE == 83 || iE == 86 || iE == 118 || iE == 128 || iE == 138) {
            iH = d0Var.h();
            zD = iH == 3 ? d0Var.d() : false;
            d0Var.h();
            d0Var.h();
            d0Var.k();
            if (d0Var.d()) {
                int i14 = iH != 3 ? 8 : 12;
                int i15 = 0;
                while (i15 < i14) {
                    if (d0Var.d()) {
                        o(d0Var, i15 < 6 ? 16 : 64);
                    }
                    i15++;
                }
            }
        } else {
            iH = 1;
            zD = false;
        }
        int iH4 = d0Var.h() + 4;
        int iH5 = d0Var.h();
        if (iH5 == 0) {
            i12 = iH;
            z10 = zD;
            iH2 = d0Var.h() + 4;
            z11 = false;
        } else {
            if (iH5 == 1) {
                boolean zD2 = d0Var.d();
                d0Var.g();
                d0Var.g();
                z10 = zD;
                long jH = d0Var.h();
                i12 = iH;
                for (int i16 = 0; i16 < jH; i16++) {
                    d0Var.h();
                }
                z11 = zD2;
            } else {
                i12 = iH;
                z10 = zD;
                z11 = false;
            }
            iH2 = 0;
        }
        int iH6 = d0Var.h();
        d0Var.k();
        int iH7 = d0Var.h() + 1;
        int iH8 = d0Var.h() + 1;
        boolean zD3 = d0Var.d();
        int i17 = (2 - (zD3 ? 1 : 0)) * iH8;
        if (!zD3) {
            d0Var.k();
        }
        d0Var.k();
        int i18 = iH7 * 16;
        int i19 = i17 * 16;
        if (d0Var.d()) {
            int iH9 = d0Var.h();
            int iH10 = d0Var.h();
            int iH11 = d0Var.h();
            int iH12 = d0Var.h();
            if (i12 == 0) {
                i13 = 2 - (zD3 ? 1 : 0);
            } else {
                int i20 = i12;
                i = i20 == 3 ? 1 : 2;
                i13 = (2 - (zD3 ? 1 : 0)) * (i20 == 1 ? 2 : 1);
            }
            i18 -= (iH9 + iH10) * i;
            i19 -= (iH11 + iH12) * i13;
        }
        int i21 = i18;
        int i22 = i19;
        float f11 = 1.0f;
        if (d0Var.d() && d0Var.d()) {
            int iE4 = d0Var.e(8);
            if (iE4 == 255) {
                int iE5 = d0Var.e(16);
                int iE6 = d0Var.e(16);
                if (iE5 != 0 && iE6 != 0) {
                    f11 = iE5 / iE6;
                }
            } else {
                float[] fArr = f259b;
                if (iE4 < fArr.length) {
                    f10 = fArr[iE4];
                } else {
                    t.i("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iE4);
                }
            }
            f10 = f11;
        } else {
            f10 = f11;
        }
        return new c(iE, iE2, iE3, iH3, iH6, i21, i22, f10, z10, zD3, iH4, iH5, iH2, z11);
    }

    private static void n(d0 d0Var) {
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = 0;
            while (i11 < 6) {
                int i12 = 1;
                if (d0Var.d()) {
                    int iMin = Math.min(64, 1 << ((i10 << 1) + 4));
                    if (i10 > 1) {
                        d0Var.g();
                    }
                    for (int i13 = 0; i13 < iMin; i13++) {
                        d0Var.g();
                    }
                } else {
                    d0Var.h();
                }
                if (i10 == 3) {
                    i12 = 3;
                }
                i11 += i12;
            }
        }
    }

    private static void o(d0 d0Var, int i10) {
        int iG = 8;
        int i11 = 8;
        for (int i12 = 0; i12 < i10; i12++) {
            if (iG != 0) {
                iG = ((d0Var.g() + i11) + 256) % 256;
            }
            if (iG != 0) {
                i11 = iG;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void p(d0 d0Var) {
        int iH = d0Var.h();
        int[] iArr = new int[0];
        int[] iArrCopyOf = new int[0];
        int i10 = -1;
        int i11 = 0;
        int i12 = -1;
        while (i11 < iH) {
            if ((i11 != 0 && d0Var.d()) == true) {
                int i13 = i10 + i12;
                int iH2 = (1 - ((d0Var.d() ? 1 : 0) * 2)) * (d0Var.h() + 1);
                int i14 = i13 + 1;
                boolean[] zArr = new boolean[i14];
                for (int i15 = 0; i15 <= i13; i15++) {
                    if (d0Var.d()) {
                        zArr[i15] = true;
                    } else {
                        zArr[i15] = d0Var.d();
                    }
                }
                int[] iArr2 = new int[i14];
                int[] iArr3 = new int[i14];
                int i16 = 0;
                for (int i17 = i12 - 1; i17 >= 0; i17--) {
                    int i18 = iArrCopyOf[i17] + iH2;
                    if (i18 < 0 && zArr[i10 + i17]) {
                        iArr2[i16] = i18;
                        i16++;
                    }
                }
                if (iH2 < 0 && zArr[i13]) {
                    iArr2[i16] = iH2;
                    i16++;
                }
                for (int i19 = 0; i19 < i10; i19++) {
                    int i20 = iArr[i19] + iH2;
                    if (i20 < 0 && zArr[i19]) {
                        iArr2[i16] = i20;
                        i16++;
                    }
                }
                int[] iArrCopyOf2 = Arrays.copyOf(iArr2, i16);
                int i21 = 0;
                for (int i22 = i10 - 1; i22 >= 0; i22--) {
                    int i23 = iArr[i22] + iH2;
                    if (i23 > 0 && zArr[i22]) {
                        iArr3[i21] = i23;
                        i21++;
                    }
                }
                if (iH2 > 0 && zArr[i13]) {
                    iArr3[i21] = iH2;
                    i21++;
                }
                for (int i24 = 0; i24 < i12; i24++) {
                    int i25 = iArrCopyOf[i24] + iH2;
                    if (i25 > 0 && zArr[i10 + i24]) {
                        iArr3[i21] = i25;
                        i21++;
                    }
                }
                iArrCopyOf = Arrays.copyOf(iArr3, i21);
                iArr = iArrCopyOf2;
                i10 = i16;
                i12 = i21;
            } else {
                int iH3 = d0Var.h();
                int iH4 = d0Var.h();
                int[] iArr4 = new int[iH3];
                for (int i26 = 0; i26 < iH3; i26++) {
                    iArr4[i26] = d0Var.h() + 1;
                    d0Var.k();
                }
                int[] iArr5 = new int[iH4];
                for (int i27 = 0; i27 < iH4; i27++) {
                    iArr5[i27] = d0Var.h() + 1;
                    d0Var.k();
                }
                i10 = iH3;
                iArr = iArr4;
                i12 = iH4;
                iArrCopyOf = iArr5;
            }
            i11++;
        }
    }

    public static int q(byte[] bArr, int i10) {
        int i11;
        synchronized (f260c) {
            int iD = 0;
            int i12 = 0;
            while (iD < i10) {
                try {
                    iD = d(bArr, iD, i10);
                    if (iD < i10) {
                        int[] iArr = f261d;
                        if (iArr.length <= i12) {
                            f261d = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        f261d[i12] = iD;
                        iD += 3;
                        i12++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            i11 = i10 - i12;
            int i13 = 0;
            int i14 = 0;
            for (int i15 = 0; i15 < i12; i15++) {
                int i16 = f261d[i15] - i14;
                System.arraycopy(bArr, i14, bArr, i13, i16);
                int i17 = i13 + i16;
                int i18 = i17 + 1;
                bArr[i17] = 0;
                i13 = i18 + 1;
                bArr[i18] = 0;
                i14 += i16 + 3;
            }
            System.arraycopy(bArr, i14, bArr, i13, i11 - i13);
        }
        return i11;
    }
}

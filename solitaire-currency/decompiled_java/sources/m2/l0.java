package m2;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: Sonic.java */
/* JADX INFO: loaded from: classes2.dex */
final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f31313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f31314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f31315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f31316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f31317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f31318f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f31319g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f31320h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final short[] f31321i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private short[] f31322j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f31323k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private short[] f31324l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f31325m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private short[] f31326n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f31327o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f31328p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f31329q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f31330r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f31331s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f31332t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f31333u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f31334v;

    public l0(int i10, int i11, float f10, float f11, int i12) {
        this.f31313a = i10;
        this.f31314b = i11;
        this.f31315c = f10;
        this.f31316d = f11;
        this.f31317e = i10 / i12;
        this.f31318f = i10 / 400;
        int i13 = i10 / 65;
        this.f31319g = i13;
        int i14 = i13 * 2;
        this.f31320h = i14;
        this.f31321i = new short[i14];
        this.f31322j = new short[i14 * i11];
        this.f31324l = new short[i14 * i11];
        this.f31326n = new short[i14 * i11];
    }

    private void a(float f10, int i10) {
        int i11;
        int i12;
        if (this.f31325m == i10) {
            return;
        }
        int i13 = this.f31313a;
        int i14 = (int) (i13 / f10);
        while (true) {
            if (i14 <= 16384 && i13 <= 16384) {
                break;
            }
            i14 /= 2;
            i13 /= 2;
        }
        o(i10);
        int i15 = 0;
        while (true) {
            int i16 = this.f31327o;
            if (i15 >= i16 - 1) {
                u(i16 - 1);
                return;
            }
            while (true) {
                i11 = this.f31328p;
                int i17 = (i11 + 1) * i14;
                i12 = this.f31329q;
                if (i17 <= i12 * i13) {
                    break;
                }
                this.f31324l = f(this.f31324l, this.f31325m, 1);
                int i18 = 0;
                while (true) {
                    int i19 = this.f31314b;
                    if (i18 < i19) {
                        this.f31324l[(this.f31325m * i19) + i18] = n(this.f31326n, (i19 * i15) + i18, i13, i14);
                        i18++;
                    }
                }
                this.f31329q++;
                this.f31325m++;
            }
            int i20 = i11 + 1;
            this.f31328p = i20;
            if (i20 == i13) {
                this.f31328p = 0;
                a4.a.g(i12 == i14);
                this.f31329q = 0;
            }
            i15++;
        }
    }

    private void b(float f10) {
        int iW;
        int i10 = this.f31323k;
        if (i10 < this.f31320h) {
            return;
        }
        int i11 = 0;
        do {
            if (this.f31330r > 0) {
                iW = c(i11);
            } else {
                int iG = g(this.f31322j, i11);
                iW = ((double) f10) > 1.0d ? iG + w(this.f31322j, i11, f10, iG) : m(this.f31322j, i11, f10, iG);
            }
            i11 += iW;
        } while (this.f31320h + i11 <= i10);
        v(i11);
    }

    private int c(int i10) {
        int iMin = Math.min(this.f31320h, this.f31330r);
        d(this.f31322j, i10, iMin);
        this.f31330r -= iMin;
        return iMin;
    }

    private void d(short[] sArr, int i10, int i11) {
        short[] sArrF = f(this.f31324l, this.f31325m, i11);
        this.f31324l = sArrF;
        int i12 = this.f31314b;
        System.arraycopy(sArr, i10 * i12, sArrF, this.f31325m * i12, i12 * i11);
        this.f31325m += i11;
    }

    private void e(short[] sArr, int i10, int i11) {
        int i12 = this.f31320h / i11;
        int i13 = this.f31314b;
        int i14 = i11 * i13;
        int i15 = i10 * i13;
        for (int i16 = 0; i16 < i12; i16++) {
            int i17 = 0;
            for (int i18 = 0; i18 < i14; i18++) {
                i17 += sArr[(i16 * i14) + i15 + i18];
            }
            this.f31321i[i16] = (short) (i17 / i14);
        }
    }

    private short[] f(short[] sArr, int i10, int i11) {
        int length = sArr.length;
        int i12 = this.f31314b;
        int i13 = length / i12;
        return i10 + i11 <= i13 ? sArr : Arrays.copyOf(sArr, (((i13 * 3) / 2) + i11) * i12);
    }

    private int g(short[] sArr, int i10) {
        int iH;
        int i11 = this.f31313a;
        int i12 = i11 > 4000 ? i11 / 4000 : 1;
        if (this.f31314b == 1 && i12 == 1) {
            iH = h(sArr, i10, this.f31318f, this.f31319g);
        } else {
            e(sArr, i10, i12);
            int iH2 = h(this.f31321i, 0, this.f31318f / i12, this.f31319g / i12);
            if (i12 != 1) {
                int i13 = iH2 * i12;
                int i14 = i12 * 4;
                int i15 = i13 - i14;
                int i16 = i13 + i14;
                int i17 = this.f31318f;
                if (i15 < i17) {
                    i15 = i17;
                }
                int i18 = this.f31319g;
                if (i16 > i18) {
                    i16 = i18;
                }
                if (this.f31314b == 1) {
                    iH = h(sArr, i10, i15, i16);
                } else {
                    e(sArr, i10, 1);
                    iH = h(this.f31321i, 0, i15, i16);
                }
            } else {
                iH = iH2;
            }
        }
        int i19 = q(this.f31333u, this.f31334v) ? this.f31331s : iH;
        this.f31332t = this.f31333u;
        this.f31331s = iH;
        return i19;
    }

    private int h(short[] sArr, int i10, int i11, int i12) {
        int i13 = i10 * this.f31314b;
        int i14 = 255;
        int i15 = 1;
        int i16 = 0;
        int i17 = 0;
        while (i11 <= i12) {
            int iAbs = 0;
            for (int i18 = 0; i18 < i11; i18++) {
                iAbs += Math.abs(sArr[i13 + i18] - sArr[(i13 + i11) + i18]);
            }
            if (iAbs * i16 < i15 * i11) {
                i16 = i11;
                i15 = iAbs;
            }
            if (iAbs * i14 > i17 * i11) {
                i14 = i11;
                i17 = iAbs;
            }
            i11++;
        }
        this.f31333u = i15 / i16;
        this.f31334v = i17 / i14;
        return i16;
    }

    private int m(short[] sArr, int i10, float f10, int i11) {
        int i12;
        if (f10 < 0.5f) {
            i12 = (int) ((i11 * f10) / (1.0f - f10));
        } else {
            this.f31330r = (int) ((i11 * ((2.0f * f10) - 1.0f)) / (1.0f - f10));
            i12 = i11;
        }
        int i13 = i11 + i12;
        short[] sArrF = f(this.f31324l, this.f31325m, i13);
        this.f31324l = sArrF;
        int i14 = this.f31314b;
        System.arraycopy(sArr, i10 * i14, sArrF, this.f31325m * i14, i14 * i11);
        p(i12, this.f31314b, this.f31324l, this.f31325m + i11, sArr, i10 + i11, sArr, i10);
        this.f31325m += i13;
        return i12;
    }

    private short n(short[] sArr, int i10, int i11, int i12) {
        short s10 = sArr[i10];
        short s11 = sArr[i10 + this.f31314b];
        int i13 = this.f31329q * i11;
        int i14 = this.f31328p;
        int i15 = i14 * i12;
        int i16 = (i14 + 1) * i12;
        int i17 = i16 - i13;
        int i18 = i16 - i15;
        return (short) (((s10 * i17) + ((i18 - i17) * s11)) / i18);
    }

    private void o(int i10) {
        int i11 = this.f31325m - i10;
        short[] sArrF = f(this.f31326n, this.f31327o, i11);
        this.f31326n = sArrF;
        short[] sArr = this.f31324l;
        int i12 = this.f31314b;
        System.arraycopy(sArr, i10 * i12, sArrF, this.f31327o * i12, i12 * i11);
        this.f31325m = i10;
        this.f31327o += i11;
    }

    private static void p(int i10, int i11, short[] sArr, int i12, short[] sArr2, int i13, short[] sArr3, int i14) {
        for (int i15 = 0; i15 < i11; i15++) {
            int i16 = (i12 * i11) + i15;
            int i17 = (i14 * i11) + i15;
            int i18 = (i13 * i11) + i15;
            for (int i19 = 0; i19 < i10; i19++) {
                sArr[i16] = (short) (((sArr2[i18] * (i10 - i19)) + (sArr3[i17] * i19)) / i10);
                i16 += i11;
                i18 += i11;
                i17 += i11;
            }
        }
    }

    private boolean q(int i10, int i11) {
        return i10 != 0 && this.f31331s != 0 && i11 <= i10 * 3 && i10 * 2 > this.f31332t * 3;
    }

    private void r() {
        int i10 = this.f31325m;
        float f10 = this.f31315c;
        float f11 = this.f31316d;
        float f12 = f10 / f11;
        float f13 = this.f31317e * f11;
        double d10 = f12;
        if (d10 > 1.00001d || d10 < 0.99999d) {
            b(f12);
        } else {
            d(this.f31322j, 0, this.f31323k);
            this.f31323k = 0;
        }
        if (f13 != 1.0f) {
            a(f13, i10);
        }
    }

    private void u(int i10) {
        if (i10 == 0) {
            return;
        }
        short[] sArr = this.f31326n;
        int i11 = this.f31314b;
        System.arraycopy(sArr, i10 * i11, sArr, 0, (this.f31327o - i10) * i11);
        this.f31327o -= i10;
    }

    private void v(int i10) {
        int i11 = this.f31323k - i10;
        short[] sArr = this.f31322j;
        int i12 = this.f31314b;
        System.arraycopy(sArr, i10 * i12, sArr, 0, i12 * i11);
        this.f31323k = i11;
    }

    private int w(short[] sArr, int i10, float f10, int i11) {
        int i12;
        if (f10 >= 2.0f) {
            i12 = (int) (i11 / (f10 - 1.0f));
        } else {
            this.f31330r = (int) ((i11 * (2.0f - f10)) / (f10 - 1.0f));
            i12 = i11;
        }
        short[] sArrF = f(this.f31324l, this.f31325m, i12);
        this.f31324l = sArrF;
        p(i12, this.f31314b, sArrF, this.f31325m, sArr, i10, sArr, i10 + i11);
        this.f31325m += i12;
        return i12;
    }

    public void i() {
        this.f31323k = 0;
        this.f31325m = 0;
        this.f31327o = 0;
        this.f31328p = 0;
        this.f31329q = 0;
        this.f31330r = 0;
        this.f31331s = 0;
        this.f31332t = 0;
        this.f31333u = 0;
        this.f31334v = 0;
    }

    public void j(ShortBuffer shortBuffer) {
        int iMin = Math.min(shortBuffer.remaining() / this.f31314b, this.f31325m);
        shortBuffer.put(this.f31324l, 0, this.f31314b * iMin);
        int i10 = this.f31325m - iMin;
        this.f31325m = i10;
        short[] sArr = this.f31324l;
        int i11 = this.f31314b;
        System.arraycopy(sArr, iMin * i11, sArr, 0, i10 * i11);
    }

    public int k() {
        return this.f31325m * this.f31314b * 2;
    }

    public int l() {
        return this.f31323k * this.f31314b * 2;
    }

    public void s() {
        int i10;
        int i11 = this.f31323k;
        float f10 = this.f31315c;
        float f11 = this.f31316d;
        int i12 = this.f31325m + ((int) ((((i11 / (f10 / f11)) + this.f31327o) / (this.f31317e * f11)) + 0.5f));
        this.f31322j = f(this.f31322j, i11, (this.f31320h * 2) + i11);
        int i13 = 0;
        while (true) {
            i10 = this.f31320h;
            int i14 = this.f31314b;
            if (i13 >= i10 * 2 * i14) {
                break;
            }
            this.f31322j[(i14 * i11) + i13] = 0;
            i13++;
        }
        this.f31323k += i10 * 2;
        r();
        if (this.f31325m > i12) {
            this.f31325m = i12;
        }
        this.f31323k = 0;
        this.f31330r = 0;
        this.f31327o = 0;
    }

    public void t(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i10 = this.f31314b;
        int i11 = iRemaining / i10;
        short[] sArrF = f(this.f31322j, this.f31323k, i11);
        this.f31322j = sArrF;
        shortBuffer.get(sArrF, this.f31323k * this.f31314b, ((i10 * i11) * 2) / 2);
        this.f31323k += i11;
        r();
    }
}

package z2;

import a4.l0;
import a4.o0;
import androidx.media3.common.C;
import java.io.IOException;

/* JADX INFO: compiled from: PsDurationReader.java */
/* JADX INFO: loaded from: classes2.dex */
final class y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f37356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f37357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f37358e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l0 f37354a = new l0(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f37359f = C.TIME_UNSET;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f37360g = C.TIME_UNSET;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f37361h = C.TIME_UNSET;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a4.c0 f37355b = new a4.c0();

    y() {
    }

    private static boolean a(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    private int b(p2.m mVar) {
        this.f37355b.M(o0.f219f);
        this.f37356c = true;
        mVar.resetPeekPosition();
        return 0;
    }

    private int f(byte[] bArr, int i10) {
        return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
    }

    private int h(p2.m mVar, p2.a0 a0Var) throws IOException {
        int iMin = (int) Math.min(20000L, mVar.getLength());
        long j10 = 0;
        if (mVar.getPosition() != j10) {
            a0Var.f32443a = j10;
            return 1;
        }
        this.f37355b.L(iMin);
        mVar.resetPeekPosition();
        mVar.peekFully(this.f37355b.d(), 0, iMin);
        this.f37359f = i(this.f37355b);
        this.f37357d = true;
        return 0;
    }

    private long i(a4.c0 c0Var) {
        int iF = c0Var.f();
        for (int iE = c0Var.e(); iE < iF - 3; iE++) {
            if (f(c0Var.d(), iE) == 442) {
                c0Var.P(iE + 4);
                long jL = l(c0Var);
                if (jL != C.TIME_UNSET) {
                    return jL;
                }
            }
        }
        return C.TIME_UNSET;
    }

    private int j(p2.m mVar, p2.a0 a0Var) throws IOException {
        long length = mVar.getLength();
        int iMin = (int) Math.min(20000L, length);
        long j10 = length - ((long) iMin);
        if (mVar.getPosition() != j10) {
            a0Var.f32443a = j10;
            return 1;
        }
        this.f37355b.L(iMin);
        mVar.resetPeekPosition();
        mVar.peekFully(this.f37355b.d(), 0, iMin);
        this.f37360g = k(this.f37355b);
        this.f37358e = true;
        return 0;
    }

    private long k(a4.c0 c0Var) {
        int iE = c0Var.e();
        for (int iF = c0Var.f() - 4; iF >= iE; iF--) {
            if (f(c0Var.d(), iF) == 442) {
                c0Var.P(iF + 4);
                long jL = l(c0Var);
                if (jL != C.TIME_UNSET) {
                    return jL;
                }
            }
        }
        return C.TIME_UNSET;
    }

    public static long l(a4.c0 c0Var) {
        int iE = c0Var.e();
        if (c0Var.a() < 9) {
            return C.TIME_UNSET;
        }
        byte[] bArr = new byte[9];
        c0Var.j(bArr, 0, 9);
        c0Var.P(iE);
        return !a(bArr) ? C.TIME_UNSET : m(bArr);
    }

    private static long m(byte[] bArr) {
        byte b10 = bArr[0];
        long j10 = (((((long) b10) & 56) >> 3) << 30) | ((((long) b10) & 3) << 28) | ((((long) bArr[1]) & 255) << 20);
        byte b11 = bArr[2];
        return j10 | (((((long) b11) & 248) >> 3) << 15) | ((((long) b11) & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
    }

    public long c() {
        return this.f37361h;
    }

    public l0 d() {
        return this.f37354a;
    }

    public boolean e() {
        return this.f37356c;
    }

    public int g(p2.m mVar, p2.a0 a0Var) throws IOException {
        if (!this.f37358e) {
            return j(mVar, a0Var);
        }
        if (this.f37360g == C.TIME_UNSET) {
            return b(mVar);
        }
        if (!this.f37357d) {
            return h(mVar, a0Var);
        }
        long j10 = this.f37359f;
        if (j10 == C.TIME_UNSET) {
            return b(mVar);
        }
        long jB = this.f37354a.b(this.f37360g) - this.f37354a.b(j10);
        this.f37361h = jB;
        if (jB < 0) {
            a4.t.i("PsDurationReader", "Invalid duration: " + this.f37361h + ". Using TIME_UNSET instead.");
            this.f37361h = C.TIME_UNSET;
        }
        return b(mVar);
    }
}

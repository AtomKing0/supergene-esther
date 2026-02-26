package w2;

import a4.c0;
import a4.o0;
import a4.t;
import androidx.annotation.Nullable;
import m2.h0;
import p2.b0;

/* JADX INFO: compiled from: XingSeeker.java */
/* JADX INFO: loaded from: classes2.dex */
final class i implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f35361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f35362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f35363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f35364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f35365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final long[] f35366f;

    private i(long j10, int i10, long j11) {
        this(j10, i10, j11, -1L, null);
    }

    @Nullable
    public static i a(long j10, long j11, h0.a aVar, c0 c0Var) {
        int iH;
        int i10 = aVar.f31293g;
        int i11 = aVar.f31290d;
        int iN = c0Var.n();
        if ((iN & 1) != 1 || (iH = c0Var.H()) == 0) {
            return null;
        }
        long jF0 = o0.F0(iH, ((long) i10) * 1000000, i11);
        if ((iN & 6) != 6) {
            return new i(j11, aVar.f31289c, jF0);
        }
        long jF = c0Var.F();
        long[] jArr = new long[100];
        for (int i12 = 0; i12 < 100; i12++) {
            jArr[i12] = c0Var.D();
        }
        if (j10 != -1) {
            long j12 = j11 + jF;
            if (j10 != j12) {
                t.i("XingSeeker", "XING data size mismatch: " + j10 + ", " + j12);
            }
        }
        return new i(j11, aVar.f31289c, jF0, jF, jArr);
    }

    private long b(int i10) {
        return (this.f35363c * ((long) i10)) / 100;
    }

    @Override // w2.g
    public long getDataEndPosition() {
        return this.f35365e;
    }

    @Override // p2.b0
    public long getDurationUs() {
        return this.f35363c;
    }

    @Override // p2.b0
    public b0.a getSeekPoints(long j10) {
        if (!isSeekable()) {
            return new b0.a(new p2.c0(0L, this.f35361a + ((long) this.f35362b)));
        }
        long jQ = o0.q(j10, 0L, this.f35363c);
        double d10 = (jQ * 100.0d) / this.f35363c;
        double d11 = 0.0d;
        if (d10 > 0.0d) {
            if (d10 >= 100.0d) {
                d11 = 256.0d;
            } else {
                int i10 = (int) d10;
                double d12 = ((long[]) a4.a.i(this.f35366f))[i10];
                d11 = d12 + ((d10 - ((double) i10)) * ((i10 == 99 ? 256.0d : r3[i10 + 1]) - d12));
            }
        }
        return new b0.a(new p2.c0(jQ, this.f35361a + o0.q(Math.round((d11 / 256.0d) * this.f35364d), this.f35362b, this.f35364d - 1)));
    }

    @Override // w2.g
    public long getTimeUs(long j10) {
        long j11 = j10 - this.f35361a;
        if (!isSeekable() || j11 <= this.f35362b) {
            return 0L;
        }
        long[] jArr = (long[]) a4.a.i(this.f35366f);
        double d10 = (j11 * 256.0d) / this.f35364d;
        int i10 = o0.i(jArr, (long) d10, true, true);
        long jB = b(i10);
        long j12 = jArr[i10];
        int i11 = i10 + 1;
        long jB2 = b(i11);
        return jB + Math.round((j12 == (i10 == 99 ? 256L : jArr[i11]) ? 0.0d : (d10 - j12) / (r0 - j12)) * (jB2 - jB));
    }

    @Override // p2.b0
    public boolean isSeekable() {
        return this.f35366f != null;
    }

    private i(long j10, int i10, long j11, long j12, @Nullable long[] jArr) {
        this.f35361a = j10;
        this.f35362b = i10;
        this.f35363c = j11;
        this.f35366f = jArr;
        this.f35364d = j12;
        this.f35365e = j12 != -1 ? j10 + j12 : -1L;
    }
}

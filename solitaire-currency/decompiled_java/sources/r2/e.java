package r2;

import a4.o0;
import java.io.IOException;
import java.util.Arrays;
import p2.b0;
import p2.c0;
import p2.e0;
import p2.m;

/* JADX INFO: compiled from: ChunkReader.java */
/* JADX INFO: loaded from: classes2.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final e0 f33286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f33287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f33288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f33289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f33290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f33291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f33292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f33293h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f33294i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f33295j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long[] f33296k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int[] f33297l;

    public e(int i10, int i11, long j10, int i12, e0 e0Var) {
        boolean z10 = true;
        if (i11 != 1 && i11 != 2) {
            z10 = false;
        }
        a4.a.a(z10);
        this.f33289d = j10;
        this.f33290e = i12;
        this.f33286a = e0Var;
        this.f33287b = d(i10, i11 == 2 ? 1667497984 : 1651965952);
        this.f33288c = i11 == 2 ? d(i10, 1650720768) : -1;
        this.f33296k = new long[512];
        this.f33297l = new int[512];
    }

    private static int d(int i10, int i11) {
        return (((i10 % 10) + 48) << 8) | ((i10 / 10) + 48) | i11;
    }

    private long e(int i10) {
        return (this.f33289d * ((long) i10)) / ((long) this.f33290e);
    }

    private c0 h(int i10) {
        return new c0(((long) this.f33297l[i10]) * g(), this.f33296k[i10]);
    }

    public void a() {
        this.f33293h++;
    }

    public void b(long j10) {
        if (this.f33295j == this.f33297l.length) {
            long[] jArr = this.f33296k;
            this.f33296k = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.f33297l;
            this.f33297l = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.f33296k;
        int i10 = this.f33295j;
        jArr2[i10] = j10;
        this.f33297l[i10] = this.f33294i;
        this.f33295j = i10 + 1;
    }

    public void c() {
        this.f33296k = Arrays.copyOf(this.f33296k, this.f33295j);
        this.f33297l = Arrays.copyOf(this.f33297l, this.f33295j);
    }

    public long f() {
        return e(this.f33293h);
    }

    public long g() {
        return e(1);
    }

    public b0.a i(long j10) {
        int iG = (int) (j10 / g());
        int iH = o0.h(this.f33297l, iG, true, true);
        if (this.f33297l[iH] == iG) {
            return new b0.a(h(iH));
        }
        c0 c0VarH = h(iH);
        int i10 = iH + 1;
        return i10 < this.f33296k.length ? new b0.a(c0VarH, h(i10)) : new b0.a(c0VarH);
    }

    public boolean j(int i10) {
        return this.f33287b == i10 || this.f33288c == i10;
    }

    public void k() {
        this.f33294i++;
    }

    public boolean l() {
        return Arrays.binarySearch(this.f33297l, this.f33293h) >= 0;
    }

    public boolean m(m mVar) throws IOException {
        int i10 = this.f33292g;
        int iC = i10 - this.f33286a.c(mVar, i10, false);
        this.f33292g = iC;
        boolean z10 = iC == 0;
        if (z10) {
            if (this.f33291f > 0) {
                this.f33286a.a(f(), l() ? 1 : 0, this.f33291f, 0, null);
            }
            a();
        }
        return z10;
    }

    public void n(int i10) {
        this.f33291f = i10;
        this.f33292g = i10;
    }

    public void o(long j10) {
        if (this.f33295j == 0) {
            this.f33293h = 0;
        } else {
            this.f33293h = this.f33297l[o0.i(this.f33296k, j10, true, true)];
        }
    }
}

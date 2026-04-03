package l3;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import k2.f3;
import k2.o1;
import k2.p1;
import l3.g0;
import l3.x;
import z3.f0;
import z3.g0;
import z3.k;

/* JADX INFO: compiled from: SingleSampleMediaPeriod.java */
/* JADX INFO: loaded from: classes2.dex */
final class y0 implements x, g0.b<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z3.o f30783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k.a f30784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final z3.m0 f30785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final z3.f0 f30786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final g0.a f30787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e1 f30788f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f30790h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final o1 f30792j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f30793k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f30794l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    byte[] f30795m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f30796n;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayList<b> f30789g = new ArrayList<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final z3.g0 f30791i = new z3.g0("SingleSampleMediaPeriod");

    /* JADX INFO: compiled from: SingleSampleMediaPeriod.java */
    private final class b implements u0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f30797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f30798b;

        private b() {
        }

        private void b() {
            if (this.f30798b) {
                return;
            }
            y0.this.f30787e.h(a4.x.i(y0.this.f30792j.f29347l), y0.this.f30792j, 0, null, 0L);
            this.f30798b = true;
        }

        @Override // l3.u0
        public int a(p1 p1Var, n2.g gVar, int i10) {
            b();
            y0 y0Var = y0.this;
            boolean z10 = y0Var.f30794l;
            if (z10 && y0Var.f30795m == null) {
                this.f30797a = 2;
            }
            int i11 = this.f30797a;
            if (i11 == 2) {
                gVar.a(4);
                return -4;
            }
            if ((i10 & 2) != 0 || i11 == 0) {
                p1Var.f29409b = y0Var.f30792j;
                this.f30797a = 1;
                return -5;
            }
            if (!z10) {
                return -3;
            }
            a4.a.e(y0Var.f30795m);
            gVar.a(1);
            gVar.f31588e = 0L;
            if ((i10 & 4) == 0) {
                gVar.m(y0.this.f30796n);
                ByteBuffer byteBuffer = gVar.f31586c;
                y0 y0Var2 = y0.this;
                byteBuffer.put(y0Var2.f30795m, 0, y0Var2.f30796n);
            }
            if ((i10 & 1) == 0) {
                this.f30797a = 2;
            }
            return -4;
        }

        public void c() {
            if (this.f30797a == 2) {
                this.f30797a = 1;
            }
        }

        @Override // l3.u0
        public boolean isReady() {
            return y0.this.f30794l;
        }

        @Override // l3.u0
        public void maybeThrowError() throws IOException {
            y0 y0Var = y0.this;
            if (y0Var.f30793k) {
                return;
            }
            y0Var.f30791i.j();
        }

        @Override // l3.u0
        public int skipData(long j10) {
            b();
            if (j10 <= 0 || this.f30797a == 2) {
                return 0;
            }
            this.f30797a = 2;
            return 1;
        }
    }

    public y0(z3.o oVar, k.a aVar, @Nullable z3.m0 m0Var, o1 o1Var, long j10, z3.f0 f0Var, g0.a aVar2, boolean z10) {
        this.f30783a = oVar;
        this.f30784b = aVar;
        this.f30785c = m0Var;
        this.f30792j = o1Var;
        this.f30790h = j10;
        this.f30786d = f0Var;
        this.f30787e = aVar2;
        this.f30793k = z10;
        this.f30788f = new e1(new c1(o1Var));
    }

    @Override // l3.x, l3.v0
    public boolean a(long j10) {
        if (this.f30794l || this.f30791i.i() || this.f30791i.h()) {
            return false;
        }
        z3.k kVarCreateDataSource = this.f30784b.createDataSource();
        z3.m0 m0Var = this.f30785c;
        if (m0Var != null) {
            kVarCreateDataSource.b(m0Var);
        }
        c cVar = new c(this.f30783a, kVarCreateDataSource);
        this.f30787e.u(new t(cVar.f30800a, this.f30783a, this.f30791i.n(cVar, this, this.f30786d.getMinimumLoadableRetryCount(1))), 1, -1, this.f30792j, 0, null, 0L, this.f30790h);
        return true;
    }

    @Override // l3.x
    public void b(x.a aVar, long j10) {
        aVar.d(this);
    }

    @Override // l3.x
    public long g(x3.s[] sVarArr, boolean[] zArr, u0[] u0VarArr, boolean[] zArr2, long j10) {
        for (int i10 = 0; i10 < sVarArr.length; i10++) {
            u0 u0Var = u0VarArr[i10];
            if (u0Var != null && (sVarArr[i10] == null || !zArr[i10])) {
                this.f30789g.remove(u0Var);
                u0VarArr[i10] = null;
            }
            if (u0VarArr[i10] == null && sVarArr[i10] != null) {
                b bVar = new b();
                this.f30789g.add(bVar);
                u0VarArr[i10] = bVar;
                zArr2[i10] = true;
            }
        }
        return j10;
    }

    @Override // l3.x, l3.v0
    public long getBufferedPositionUs() {
        return this.f30794l ? Long.MIN_VALUE : 0L;
    }

    @Override // l3.x, l3.v0
    public long getNextLoadPositionUs() {
        return (this.f30794l || this.f30791i.i()) ? Long.MIN_VALUE : 0L;
    }

    @Override // l3.x
    public e1 getTrackGroups() {
        return this.f30788f;
    }

    @Override // z3.g0.b
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void e(c cVar, long j10, long j11, boolean z10) {
        z3.l0 l0Var = cVar.f30802c;
        t tVar = new t(cVar.f30800a, cVar.f30801b, l0Var.d(), l0Var.e(), j10, j11, l0Var.c());
        this.f30786d.onLoadTaskConcluded(cVar.f30800a);
        this.f30787e.o(tVar, 1, -1, null, 0, null, 0L, this.f30790h);
    }

    @Override // l3.x, l3.v0
    public boolean isLoading() {
        return this.f30791i.i();
    }

    @Override // z3.g0.b
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public void d(c cVar, long j10, long j11) {
        this.f30796n = (int) cVar.f30802c.c();
        this.f30795m = (byte[]) a4.a.e(cVar.f30803d);
        this.f30794l = true;
        z3.l0 l0Var = cVar.f30802c;
        t tVar = new t(cVar.f30800a, cVar.f30801b, l0Var.d(), l0Var.e(), j10, j11, this.f30796n);
        this.f30786d.onLoadTaskConcluded(cVar.f30800a);
        this.f30787e.q(tVar, 1, -1, this.f30792j, 0, null, 0L, this.f30790h);
    }

    @Override // z3.g0.b
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public g0.c c(c cVar, long j10, long j11, IOException iOException, int i10) {
        g0.c cVarG;
        z3.l0 l0Var = cVar.f30802c;
        t tVar = new t(cVar.f30800a, cVar.f30801b, l0Var.d(), l0Var.e(), j10, j11, l0Var.c());
        long jA = this.f30786d.a(new f0.a(tVar, new w(1, -1, this.f30792j, 0, null, 0L, a4.o0.P0(this.f30790h)), iOException, i10));
        boolean z10 = jA == C.TIME_UNSET || i10 >= this.f30786d.getMinimumLoadableRetryCount(1);
        if (this.f30793k && z10) {
            a4.t.j("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", iOException);
            this.f30794l = true;
            cVarG = z3.g0.f37402f;
        } else {
            cVarG = jA != C.TIME_UNSET ? z3.g0.g(false, jA) : z3.g0.f37403g;
        }
        g0.c cVar2 = cVarG;
        boolean z11 = !cVar2.c();
        this.f30787e.s(tVar, 1, -1, this.f30792j, 0, null, 0L, this.f30790h, iOException, z11);
        if (z11) {
            this.f30786d.onLoadTaskConcluded(cVar.f30800a);
        }
        return cVar2;
    }

    public void l() {
        this.f30791i.l();
    }

    @Override // l3.x
    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    @Override // l3.x
    public long seekToUs(long j10) {
        for (int i10 = 0; i10 < this.f30789g.size(); i10++) {
            this.f30789g.get(i10).c();
        }
        return j10;
    }

    /* JADX INFO: compiled from: SingleSampleMediaPeriod.java */
    static final class c implements g0.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30800a = t.a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z3.o f30801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final z3.l0 f30802c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private byte[] f30803d;

        public c(z3.o oVar, z3.k kVar) {
            this.f30801b = oVar;
            this.f30802c = new z3.l0(kVar);
        }

        @Override // z3.g0.e
        public void load() throws IOException {
            this.f30802c.f();
            try {
                this.f30802c.a(this.f30801b);
                int i10 = 0;
                while (i10 != -1) {
                    int iC = (int) this.f30802c.c();
                    byte[] bArr = this.f30803d;
                    if (bArr == null) {
                        this.f30803d = new byte[1024];
                    } else if (iC == bArr.length) {
                        this.f30803d = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    z3.l0 l0Var = this.f30802c;
                    byte[] bArr2 = this.f30803d;
                    i10 = l0Var.read(bArr2, iC, bArr2.length - iC);
                }
            } finally {
                z3.n.a(this.f30802c);
            }
        }

        @Override // z3.g0.e
        public void cancelLoad() {
        }
    }

    @Override // l3.x
    public void maybeThrowPrepareError() {
    }

    @Override // l3.x, l3.v0
    public void reevaluateBuffer(long j10) {
    }

    @Override // l3.x
    public void discardBuffer(long j10, boolean z10) {
    }

    @Override // l3.x
    public long i(long j10, f3 f3Var) {
        return j10;
    }
}

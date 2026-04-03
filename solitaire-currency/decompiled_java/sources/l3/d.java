package l3;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.io.IOException;
import java.util.ArrayList;
import k2.n3;
import l3.a0;

/* JADX INFO: compiled from: ClippingMediaSource.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends g1 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f30487m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f30488n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f30489o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f30490p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f30491q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final ArrayList<c> f30492r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final n3.d f30493s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private a f30494t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private b f30495u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f30496v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f30497w;

    /* JADX INFO: compiled from: ClippingMediaSource.java */
    private static final class a extends r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f30498d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f30499e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f30500f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f30501g;

        public a(n3 n3Var, long j10, long j11) throws b {
            super(n3Var);
            boolean z10 = false;
            if (n3Var.m() != 1) {
                throw new b(0);
            }
            n3.d dVarR = n3Var.r(0, new n3.d());
            long jMax = Math.max(0L, j10);
            if (!dVarR.f29324l && jMax != 0 && !dVarR.f29320h) {
                throw new b(1);
            }
            long jMax2 = j11 == Long.MIN_VALUE ? dVarR.f29326n : Math.max(0L, j11);
            long j12 = dVarR.f29326n;
            if (j12 != C.TIME_UNSET) {
                jMax2 = jMax2 > j12 ? j12 : jMax2;
                if (jMax > jMax2) {
                    throw new b(2);
                }
            }
            this.f30498d = jMax;
            this.f30499e = jMax2;
            this.f30500f = jMax2 == C.TIME_UNSET ? -9223372036854775807L : jMax2 - jMax;
            if (dVarR.f29321i && (jMax2 == C.TIME_UNSET || (j12 != C.TIME_UNSET && jMax2 == j12))) {
                z10 = true;
            }
            this.f30501g = z10;
        }

        @Override // l3.r, k2.n3
        public n3.b k(int i10, n3.b bVar, boolean z10) {
            this.f30676c.k(0, bVar, z10);
            long jQ = bVar.q() - this.f30498d;
            long j10 = this.f30500f;
            return bVar.v(bVar.f29298a, bVar.f29299b, 0, j10 == C.TIME_UNSET ? -9223372036854775807L : j10 - jQ, jQ);
        }

        @Override // l3.r, k2.n3
        public n3.d s(int i10, n3.d dVar, long j10) {
            this.f30676c.s(0, dVar, 0L);
            long j11 = dVar.f29329q;
            long j12 = this.f30498d;
            dVar.f29329q = j11 + j12;
            dVar.f29326n = this.f30500f;
            dVar.f29321i = this.f30501g;
            long j13 = dVar.f29325m;
            if (j13 != C.TIME_UNSET) {
                long jMax = Math.max(j13, j12);
                dVar.f29325m = jMax;
                long j14 = this.f30499e;
                if (j14 != C.TIME_UNSET) {
                    jMax = Math.min(jMax, j14);
                }
                dVar.f29325m = jMax - this.f30498d;
            }
            long jP0 = a4.o0.P0(this.f30498d);
            long j15 = dVar.f29317e;
            if (j15 != C.TIME_UNSET) {
                dVar.f29317e = j15 + jP0;
            }
            long j16 = dVar.f29318f;
            if (j16 != C.TIME_UNSET) {
                dVar.f29318f = j16 + jP0;
            }
            return dVar;
        }
    }

    /* JADX INFO: compiled from: ClippingMediaSource.java */
    public static final class b extends IOException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30502a;

        public b(int i10) {
            super("Illegal clipping: " + a(i10));
            this.f30502a = i10;
        }

        private static String a(int i10) {
            return i10 != 0 ? i10 != 1 ? i10 != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count";
        }
    }

    public d(a0 a0Var, long j10, long j11, boolean z10, boolean z11, boolean z12) {
        super((a0) a4.a.e(a0Var));
        a4.a.a(j10 >= 0);
        this.f30487m = j10;
        this.f30488n = j11;
        this.f30489o = z10;
        this.f30490p = z11;
        this.f30491q = z12;
        this.f30492r = new ArrayList<>();
        this.f30493s = new n3.d();
    }

    private void M(n3 n3Var) {
        long j10;
        long j11;
        n3Var.r(0, this.f30493s);
        long jH = this.f30493s.h();
        if (this.f30494t == null || this.f30492r.isEmpty() || this.f30490p) {
            long j12 = this.f30487m;
            long j13 = this.f30488n;
            if (this.f30491q) {
                long jF = this.f30493s.f();
                j12 += jF;
                j13 += jF;
            }
            this.f30496v = jH + j12;
            this.f30497w = this.f30488n != Long.MIN_VALUE ? jH + j13 : Long.MIN_VALUE;
            int size = this.f30492r.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f30492r.get(i10).l(this.f30496v, this.f30497w);
            }
            j10 = j12;
            j11 = j13;
        } else {
            long j14 = this.f30496v - jH;
            j11 = this.f30488n != Long.MIN_VALUE ? this.f30497w - jH : Long.MIN_VALUE;
            j10 = j14;
        }
        try {
            a aVar = new a(n3Var, j10, j11);
            this.f30494t = aVar;
            t(aVar);
        } catch (b e10) {
            this.f30495u = e10;
            for (int i11 = 0; i11 < this.f30492r.size(); i11++) {
                this.f30492r.get(i11).j(this.f30495u);
            }
        }
    }

    @Override // l3.g1
    protected void J(n3 n3Var) {
        if (this.f30495u != null) {
            return;
        }
        M(n3Var);
    }

    @Override // l3.a0
    public void e(x xVar) {
        a4.a.g(this.f30492r.remove(xVar));
        this.f30543k.e(((c) xVar).f30468a);
        if (!this.f30492r.isEmpty() || this.f30490p) {
            return;
        }
        M(((a) a4.a.e(this.f30494t)).f30676c);
    }

    @Override // l3.a0
    public x j(a0.b bVar, z3.b bVar2, long j10) {
        c cVar = new c(this.f30543k.j(bVar, bVar2, j10), this.f30489o, this.f30496v, this.f30497w);
        this.f30492r.add(cVar);
        return cVar;
    }

    @Override // l3.f, l3.a0
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        b bVar = this.f30495u;
        if (bVar != null) {
            throw bVar;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override // l3.f, l3.a
    protected void u() {
        super.u();
        this.f30495u = null;
        this.f30494t = null;
    }
}

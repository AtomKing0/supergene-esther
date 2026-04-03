package y2;

import a4.c0;
import a4.o0;
import androidx.media3.common.C;
import java.io.IOException;
import k2.o1;
import p2.a0;
import p2.b0;
import p2.e0;
import p2.m;
import p2.n;

/* JADX INFO: compiled from: StreamReader.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e0 f36477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private n f36478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private g f36479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f36480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f36481f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f36482g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f36483h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f36484i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f36486k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f36487l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f36488m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f36476a = new e();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private b f36485j = new b();

    /* JADX INFO: compiled from: StreamReader.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        o1 f36489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        g f36490b;

        b() {
        }
    }

    private void a() {
        a4.a.i(this.f36477b);
        o0.j(this.f36478c);
    }

    private boolean i(m mVar) throws IOException {
        while (this.f36476a.d(mVar)) {
            this.f36486k = mVar.getPosition() - this.f36481f;
            if (!h(this.f36476a.c(), this.f36481f, this.f36485j)) {
                return true;
            }
            this.f36481f = mVar.getPosition();
        }
        this.f36483h = 3;
        return false;
    }

    private int j(m mVar) throws IOException {
        if (!i(mVar)) {
            return -1;
        }
        o1 o1Var = this.f36485j.f36489a;
        this.f36484i = o1Var.f29361z;
        if (!this.f36488m) {
            this.f36477b.f(o1Var);
            this.f36488m = true;
        }
        g gVar = this.f36485j.f36490b;
        if (gVar != null) {
            this.f36479d = gVar;
        } else if (mVar.getLength() == -1) {
            this.f36479d = new c();
        } else {
            f fVarB = this.f36476a.b();
            this.f36479d = new y2.a(this, this.f36481f, mVar.getLength(), fVarB.f36469h + fVarB.f36470i, fVarB.f36464c, (fVarB.f36463b & 4) != 0);
        }
        this.f36483h = 2;
        this.f36476a.f();
        return 0;
    }

    private int k(m mVar, a0 a0Var) throws IOException {
        long jA = this.f36479d.a(mVar);
        if (jA >= 0) {
            a0Var.f32443a = jA;
            return 1;
        }
        if (jA < -1) {
            e(-(jA + 2));
        }
        if (!this.f36487l) {
            this.f36478c.h((b0) a4.a.i(this.f36479d.createSeekMap()));
            this.f36487l = true;
        }
        if (this.f36486k <= 0 && !this.f36476a.d(mVar)) {
            this.f36483h = 3;
            return -1;
        }
        this.f36486k = 0L;
        c0 c0VarC = this.f36476a.c();
        long jF = f(c0VarC);
        if (jF >= 0) {
            long j10 = this.f36482g;
            if (j10 + jF >= this.f36480e) {
                long jB = b(j10);
                this.f36477b.e(c0VarC, c0VarC.f());
                this.f36477b.a(jB, 1, c0VarC.f(), 0, null);
                this.f36480e = -1L;
            }
        }
        this.f36482g += jF;
        return 0;
    }

    protected long b(long j10) {
        return (j10 * 1000000) / ((long) this.f36484i);
    }

    protected long c(long j10) {
        return (((long) this.f36484i) * j10) / 1000000;
    }

    void d(n nVar, e0 e0Var) {
        this.f36478c = nVar;
        this.f36477b = e0Var;
        l(true);
    }

    protected void e(long j10) {
        this.f36482g = j10;
    }

    protected abstract long f(c0 c0Var);

    final int g(m mVar, a0 a0Var) throws IOException {
        a();
        int i10 = this.f36483h;
        if (i10 == 0) {
            return j(mVar);
        }
        if (i10 == 1) {
            mVar.skipFully((int) this.f36481f);
            this.f36483h = 2;
            return 0;
        }
        if (i10 == 2) {
            o0.j(this.f36479d);
            return k(mVar, a0Var);
        }
        if (i10 == 3) {
            return -1;
        }
        throw new IllegalStateException();
    }

    protected abstract boolean h(c0 c0Var, long j10, b bVar) throws IOException;

    protected void l(boolean z10) {
        if (z10) {
            this.f36485j = new b();
            this.f36481f = 0L;
            this.f36483h = 0;
        } else {
            this.f36483h = 1;
        }
        this.f36480e = -1L;
        this.f36482g = 0L;
    }

    final void m(long j10, long j11) {
        this.f36476a.e();
        if (j10 == 0) {
            l(!this.f36487l);
        } else if (this.f36483h != 0) {
            this.f36480e = c(j11);
            ((g) o0.j(this.f36479d)).startSeek(this.f36480e);
            this.f36483h = 2;
        }
    }

    /* JADX INFO: compiled from: StreamReader.java */
    private static final class c implements g {
        private c() {
        }

        @Override // y2.g
        public long a(m mVar) {
            return -1L;
        }

        @Override // y2.g
        public b0 createSeekMap() {
            return new b0.b(C.TIME_UNSET);
        }

        @Override // y2.g
        public void startSeek(long j10) {
        }
    }
}

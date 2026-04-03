package s2;

import a4.c0;
import a4.o0;
import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Map;
import p2.a0;
import p2.b0;
import p2.e0;
import p2.l;
import p2.m;
import p2.n;
import p2.q;
import p2.r;
import p2.s;
import p2.t;
import p2.u;
import p2.v;

/* JADX INFO: compiled from: FlacExtractor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements l {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final r f33478o = new r() { // from class: s2.c
        @Override // p2.r
        public final l[] createExtractors() {
            return d.i();
        }

        @Override // p2.r
        public /* synthetic */ l[] createExtractors(Uri uri, Map map) {
            return q.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f33479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c0 f33480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f33481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final s.a f33482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private n f33483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e0 f33484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f33485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private c3.a f33486h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private v f33487i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f33488j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f33489k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private b f33490l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f33491m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f33492n;

    public d() {
        this(0);
    }

    private long e(c0 c0Var, boolean z10) {
        boolean zD;
        a4.a.e(this.f33487i);
        int iE = c0Var.e();
        while (iE <= c0Var.f() - 16) {
            c0Var.P(iE);
            if (s.d(c0Var, this.f33487i, this.f33489k, this.f33482d)) {
                c0Var.P(iE);
                return this.f33482d.f32528a;
            }
            iE++;
        }
        if (!z10) {
            c0Var.P(iE);
            return -1L;
        }
        while (iE <= c0Var.f() - this.f33488j) {
            c0Var.P(iE);
            try {
                zD = s.d(c0Var, this.f33487i, this.f33489k, this.f33482d);
            } catch (IndexOutOfBoundsException unused) {
                zD = false;
            }
            if (c0Var.e() <= c0Var.f() ? zD : false) {
                c0Var.P(iE);
                return this.f33482d.f32528a;
            }
            iE++;
        }
        c0Var.P(c0Var.f());
        return -1L;
    }

    private void f(m mVar) throws IOException {
        this.f33489k = t.b(mVar);
        ((n) o0.j(this.f33483e)).h(g(mVar.getPosition(), mVar.getLength()));
        this.f33485g = 5;
    }

    private b0 g(long j10, long j11) {
        a4.a.e(this.f33487i);
        v vVar = this.f33487i;
        if (vVar.f32542k != null) {
            return new u(vVar, j10);
        }
        if (j11 == -1 || vVar.f32541j <= 0) {
            return new b0.b(vVar.f());
        }
        b bVar = new b(vVar, this.f33489k, j10, j11);
        this.f33490l = bVar;
        return bVar.b();
    }

    private void h(m mVar) throws IOException {
        byte[] bArr = this.f33479a;
        mVar.peekFully(bArr, 0, bArr.length);
        mVar.resetPeekPosition();
        this.f33485g = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] i() {
        return new l[]{new d()};
    }

    private void j() {
        ((e0) o0.j(this.f33484f)).a((this.f33492n * 1000000) / ((long) ((v) o0.j(this.f33487i)).f32536e), 1, this.f33491m, 0, null);
    }

    private int k(m mVar, a0 a0Var) throws IOException {
        boolean z10;
        a4.a.e(this.f33484f);
        a4.a.e(this.f33487i);
        b bVar = this.f33490l;
        if (bVar != null && bVar.d()) {
            return this.f33490l.c(mVar, a0Var);
        }
        if (this.f33492n == -1) {
            this.f33492n = s.i(mVar, this.f33487i);
            return 0;
        }
        int iF = this.f33480b.f();
        if (iF < 32768) {
            int i10 = mVar.read(this.f33480b.d(), iF, 32768 - iF);
            z10 = i10 == -1;
            if (!z10) {
                this.f33480b.O(iF + i10);
            } else if (this.f33480b.a() == 0) {
                j();
                return -1;
            }
        } else {
            z10 = false;
        }
        int iE = this.f33480b.e();
        int i11 = this.f33491m;
        int i12 = this.f33488j;
        if (i11 < i12) {
            c0 c0Var = this.f33480b;
            c0Var.Q(Math.min(i12 - i11, c0Var.a()));
        }
        long jE = e(this.f33480b, z10);
        int iE2 = this.f33480b.e() - iE;
        this.f33480b.P(iE);
        this.f33484f.e(this.f33480b, iE2);
        this.f33491m += iE2;
        if (jE != -1) {
            j();
            this.f33491m = 0;
            this.f33492n = jE;
        }
        if (this.f33480b.a() < 16) {
            int iA = this.f33480b.a();
            System.arraycopy(this.f33480b.d(), this.f33480b.e(), this.f33480b.d(), 0, iA);
            this.f33480b.P(0);
            this.f33480b.O(iA);
        }
        return 0;
    }

    private void l(m mVar) throws IOException {
        this.f33486h = t.d(mVar, !this.f33481c);
        this.f33485g = 1;
    }

    private void m(m mVar) throws IOException {
        t.a aVar = new t.a(this.f33487i);
        boolean zE = false;
        while (!zE) {
            zE = t.e(mVar, aVar);
            this.f33487i = (v) o0.j(aVar.f32529a);
        }
        a4.a.e(this.f33487i);
        this.f33488j = Math.max(this.f33487i.f32534c, 6);
        ((e0) o0.j(this.f33484f)).f(this.f33487i.g(this.f33479a, this.f33486h));
        this.f33485g = 4;
    }

    private void n(m mVar) throws IOException {
        t.i(mVar);
        this.f33485g = 3;
    }

    @Override // p2.l
    public int a(m mVar, a0 a0Var) throws IOException {
        int i10 = this.f33485g;
        if (i10 == 0) {
            l(mVar);
            return 0;
        }
        if (i10 == 1) {
            h(mVar);
            return 0;
        }
        if (i10 == 2) {
            n(mVar);
            return 0;
        }
        if (i10 == 3) {
            m(mVar);
            return 0;
        }
        if (i10 == 4) {
            f(mVar);
            return 0;
        }
        if (i10 == 5) {
            return k(mVar, a0Var);
        }
        throw new IllegalStateException();
    }

    @Override // p2.l
    public void b(n nVar) {
        this.f33483e = nVar;
        this.f33484f = nVar.track(0, 1);
        nVar.endTracks();
    }

    @Override // p2.l
    public boolean c(m mVar) throws IOException {
        t.c(mVar, false);
        return t.a(mVar);
    }

    @Override // p2.l
    public void seek(long j10, long j11) {
        if (j10 == 0) {
            this.f33485g = 0;
        } else {
            b bVar = this.f33490l;
            if (bVar != null) {
                bVar.h(j11);
            }
        }
        this.f33492n = j11 != 0 ? -1L : 0L;
        this.f33491m = 0;
        this.f33480b.L(0);
    }

    public d(int i10) {
        this.f33479a = new byte[42];
        this.f33480b = new c0(new byte[32768], 0);
        this.f33481c = (i10 & 1) != 0;
        this.f33482d = new s.a();
        this.f33485g = 0;
    }

    @Override // p2.l
    public void release() {
    }
}

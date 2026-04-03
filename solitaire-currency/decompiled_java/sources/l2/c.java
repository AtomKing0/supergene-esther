package l2;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import k2.b2;
import k2.n2;
import k2.n3;
import k2.q2;
import k2.r2;
import k2.s3;
import k2.w1;
import l3.a0;

/* JADX INFO: compiled from: AnalyticsListener.java */
/* JADX INFO: loaded from: classes2.dex */
public interface c {

    /* JADX INFO: compiled from: AnalyticsListener.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n3 f30241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f30242c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final a0.b f30243d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f30244e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final n3 f30245f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f30246g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public final a0.b f30247h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f30248i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f30249j;

        public a(long j10, n3 n3Var, int i10, @Nullable a0.b bVar, long j11, n3 n3Var2, int i11, @Nullable a0.b bVar2, long j12, long j13) {
            this.f30240a = j10;
            this.f30241b = n3Var;
            this.f30242c = i10;
            this.f30243d = bVar;
            this.f30244e = j11;
            this.f30245f = n3Var2;
            this.f30246g = i11;
            this.f30247h = bVar2;
            this.f30248i = j12;
            this.f30249j = j13;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f30240a == aVar.f30240a && this.f30242c == aVar.f30242c && this.f30244e == aVar.f30244e && this.f30246g == aVar.f30246g && this.f30248i == aVar.f30248i && this.f30249j == aVar.f30249j && e5.k.a(this.f30241b, aVar.f30241b) && e5.k.a(this.f30243d, aVar.f30243d) && e5.k.a(this.f30245f, aVar.f30245f) && e5.k.a(this.f30247h, aVar.f30247h);
        }

        public int hashCode() {
            return e5.k.b(Long.valueOf(this.f30240a), this.f30241b, Integer.valueOf(this.f30242c), this.f30243d, Long.valueOf(this.f30244e), this.f30245f, Integer.valueOf(this.f30246g), this.f30247h, Long.valueOf(this.f30248i), Long.valueOf(this.f30249j));
        }
    }

    /* JADX INFO: compiled from: AnalyticsListener.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a4.m f30250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SparseArray<a> f30251b;

        public b(a4.m mVar, SparseArray<a> sparseArray) {
            this.f30250a = mVar;
            SparseArray<a> sparseArray2 = new SparseArray<>(mVar.d());
            for (int i10 = 0; i10 < mVar.d(); i10++) {
                int iC = mVar.c(i10);
                sparseArray2.append(iC, (a) a4.a.e(sparseArray.get(iC)));
            }
            this.f30251b = sparseArray2;
        }

        public boolean a(int i10) {
            return this.f30250a.a(i10);
        }

        public int b(int i10) {
            return this.f30250a.c(i10);
        }

        public a c(int i10) {
            return (a) a4.a.e(this.f30251b.get(i10));
        }

        public int d() {
            return this.f30250a.d();
        }
    }

    void A(a aVar, int i10, boolean z10);

    void B(a aVar, int i10);

    void C(a aVar, Exception exc);

    void D(a aVar, String str, long j10, long j11);

    void E(a aVar, String str);

    void F(a aVar, n2 n2Var);

    void G(a aVar, int i10);

    void H(a aVar, k2.o oVar);

    void I(a aVar, int i10, long j10, long j11);

    void J(a aVar, long j10);

    void K(a aVar, boolean z10, int i10);

    void L(a aVar, Exception exc);

    void M(a aVar, int i10);

    void N(a aVar, Exception exc);

    void O(r2 r2Var, b bVar);

    void P(a aVar, boolean z10);

    void Q(a aVar, int i10, long j10, long j11);

    void R(a aVar, int i10, long j10);

    void S(a aVar, int i10);

    void T(a aVar, @Nullable n2 n2Var);

    void V(a aVar);

    void W(a aVar, String str);

    @Deprecated
    void X(a aVar, int i10, String str, long j10);

    void Y(a aVar, r2.b bVar);

    @Deprecated
    void Z(a aVar, k2.o1 o1Var);

    void a(a aVar, x3.z zVar);

    @Deprecated
    void a0(a aVar);

    void b(a aVar, Exception exc);

    @Deprecated
    void b0(a aVar, int i10, int i11, int i12, float f10);

    void c(a aVar, boolean z10);

    void c0(a aVar, l3.t tVar, l3.w wVar);

    void d(a aVar, q2 q2Var);

    @Deprecated
    void d0(a aVar, boolean z10);

    @Deprecated
    void e(a aVar);

    @Deprecated
    void e0(a aVar, k2.o1 o1Var);

    void f(a aVar, l3.w wVar);

    void f0(a aVar);

    void g(a aVar, n2.e eVar);

    void g0(a aVar, l3.t tVar, l3.w wVar, IOException iOException, boolean z10);

    void h(a aVar, k2.o1 o1Var, @Nullable n2.i iVar);

    void h0(a aVar, Object obj, long j10);

    void i(a aVar, l3.t tVar, l3.w wVar);

    void i0(a aVar, String str, long j10, long j11);

    void j(a aVar);

    @Deprecated
    void j0(a aVar);

    void k(a aVar, long j10, int i10);

    void k0(a aVar);

    void l(a aVar, r2.e eVar, r2.e eVar2, int i10);

    void l0(a aVar, n2.e eVar);

    void m(a aVar, b2 b2Var);

    @Deprecated
    void m0(a aVar, int i10, k2.o1 o1Var);

    @Deprecated
    void n(a aVar, int i10);

    void n0(a aVar, k2.o1 o1Var, @Nullable n2.i iVar);

    void o(a aVar, int i10, int i11);

    void p(a aVar, boolean z10);

    @Deprecated
    void p0(a aVar, String str, long j10);

    void q(a aVar, boolean z10);

    void q0(a aVar, n2.e eVar);

    @Deprecated
    void r(a aVar, List<n3.b> list);

    @Deprecated
    void r0(a aVar, int i10, n2.e eVar);

    void s(a aVar, b4.b0 b0Var);

    void s0(a aVar, c3.a aVar2);

    void t(a aVar);

    void t0(a aVar, l3.t tVar, l3.w wVar);

    void u(a aVar, float f10);

    void u0(a aVar, s3 s3Var);

    @Deprecated
    void v(a aVar, boolean z10, int i10);

    @Deprecated
    void w(a aVar, String str, long j10);

    void x(a aVar, n2.e eVar);

    void x0(a aVar, int i10);

    @Deprecated
    void y(a aVar, int i10, n2.e eVar);

    void y0(a aVar, @Nullable w1 w1Var, int i10);

    void z(a aVar, n3.f fVar);
}

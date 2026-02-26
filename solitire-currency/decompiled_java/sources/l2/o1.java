package l2;

import a4.s;
import android.os.Looper;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.common.collect.a0;
import java.io.IOException;
import java.util.List;
import k2.b2;
import k2.n2;
import k2.n3;
import k2.q2;
import k2.r2;
import k2.s3;
import k2.w1;
import l2.c;
import l3.a0;

/* JADX INFO: compiled from: DefaultAnalyticsCollector.java */
/* JADX INFO: loaded from: classes2.dex */
public class o1 implements l2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a4.d f30328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n3.b f30329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n3.d f30330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f30331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SparseArray<c.a> f30332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a4.s<c> f30333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private r2 f30334g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a4.p f30335h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f30336i;

    /* JADX INFO: compiled from: DefaultAnalyticsCollector.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final n3.b f30337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.google.common.collect.y<a0.b> f30338b = com.google.common.collect.y.q();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.google.common.collect.a0<a0.b, n3> f30339c = com.google.common.collect.a0.k();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private a0.b f30340d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private a0.b f30341e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private a0.b f30342f;

        public a(n3.b bVar) {
            this.f30337a = bVar;
        }

        private void b(a0.a<a0.b, n3> aVar, @Nullable a0.b bVar, n3 n3Var) {
            if (bVar == null) {
                return;
            }
            if (n3Var.f(bVar.f30778a) != -1) {
                aVar.f(bVar, n3Var);
                return;
            }
            n3 n3Var2 = this.f30339c.get(bVar);
            if (n3Var2 != null) {
                aVar.f(bVar, n3Var2);
            }
        }

        @Nullable
        private static a0.b c(r2 r2Var, com.google.common.collect.y<a0.b> yVar, @Nullable a0.b bVar, n3.b bVar2) {
            n3 currentTimeline = r2Var.getCurrentTimeline();
            int currentPeriodIndex = r2Var.getCurrentPeriodIndex();
            Object objQ = currentTimeline.u() ? null : currentTimeline.q(currentPeriodIndex);
            int iG = (r2Var.isPlayingAd() || currentTimeline.u()) ? -1 : currentTimeline.j(currentPeriodIndex, bVar2).g(a4.o0.w0(r2Var.getCurrentPosition()) - bVar2.q());
            for (int i10 = 0; i10 < yVar.size(); i10++) {
                a0.b bVar3 = yVar.get(i10);
                if (i(bVar3, objQ, r2Var.isPlayingAd(), r2Var.getCurrentAdGroupIndex(), r2Var.getCurrentAdIndexInAdGroup(), iG)) {
                    return bVar3;
                }
            }
            if (yVar.isEmpty() && bVar != null) {
                if (i(bVar, objQ, r2Var.isPlayingAd(), r2Var.getCurrentAdGroupIndex(), r2Var.getCurrentAdIndexInAdGroup(), iG)) {
                    return bVar;
                }
            }
            return null;
        }

        private static boolean i(a0.b bVar, @Nullable Object obj, boolean z10, int i10, int i11, int i12) {
            if (bVar.f30778a.equals(obj)) {
                return (z10 && bVar.f30779b == i10 && bVar.f30780c == i11) || (!z10 && bVar.f30779b == -1 && bVar.f30782e == i12);
            }
            return false;
        }

        private void m(n3 n3Var) {
            a0.a<a0.b, n3> aVarA = com.google.common.collect.a0.a();
            if (this.f30338b.isEmpty()) {
                b(aVarA, this.f30341e, n3Var);
                if (!e5.k.a(this.f30342f, this.f30341e)) {
                    b(aVarA, this.f30342f, n3Var);
                }
                if (!e5.k.a(this.f30340d, this.f30341e) && !e5.k.a(this.f30340d, this.f30342f)) {
                    b(aVarA, this.f30340d, n3Var);
                }
            } else {
                for (int i10 = 0; i10 < this.f30338b.size(); i10++) {
                    b(aVarA, this.f30338b.get(i10), n3Var);
                }
                if (!this.f30338b.contains(this.f30340d)) {
                    b(aVarA, this.f30340d, n3Var);
                }
            }
            this.f30339c = aVarA.c();
        }

        @Nullable
        public a0.b d() {
            return this.f30340d;
        }

        @Nullable
        public a0.b e() {
            if (this.f30338b.isEmpty()) {
                return null;
            }
            return (a0.b) com.google.common.collect.g0.d(this.f30338b);
        }

        @Nullable
        public n3 f(a0.b bVar) {
            return this.f30339c.get(bVar);
        }

        @Nullable
        public a0.b g() {
            return this.f30341e;
        }

        @Nullable
        public a0.b h() {
            return this.f30342f;
        }

        public void j(r2 r2Var) {
            this.f30340d = c(r2Var, this.f30338b, this.f30341e, this.f30337a);
        }

        public void k(List<a0.b> list, @Nullable a0.b bVar, r2 r2Var) {
            this.f30338b = com.google.common.collect.y.m(list);
            if (!list.isEmpty()) {
                this.f30341e = list.get(0);
                this.f30342f = (a0.b) a4.a.e(bVar);
            }
            if (this.f30340d == null) {
                this.f30340d = c(r2Var, this.f30338b, this.f30341e, this.f30337a);
            }
            m(r2Var.getCurrentTimeline());
        }

        public void l(r2 r2Var) {
            this.f30340d = c(r2Var, this.f30338b, this.f30341e, this.f30337a);
            m(r2Var.getCurrentTimeline());
        }
    }

    public o1(a4.d dVar) {
        this.f30328a = (a4.d) a4.a.e(dVar);
        this.f30333f = new a4.s<>(a4.o0.K(), dVar, new s.b() { // from class: l2.f0
            @Override // a4.s.b
            public final void a(Object obj, a4.m mVar) {
                o1.e1((c) obj, mVar);
            }
        });
        n3.b bVar = new n3.b();
        this.f30329b = bVar;
        this.f30330c = new n3.d();
        this.f30331d = new a(bVar);
        this.f30332e = new SparseArray<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D1(c.a aVar, boolean z10, c cVar) {
        cVar.d0(aVar, z10);
        cVar.q(aVar, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T1(c.a aVar, int i10, r2.e eVar, r2.e eVar2, c cVar) {
        cVar.n(aVar, i10);
        cVar.l(aVar, eVar, eVar2, i10);
    }

    private c.a Y0(@Nullable a0.b bVar) {
        a4.a.e(this.f30334g);
        n3 n3VarF = bVar == null ? null : this.f30331d.f(bVar);
        if (bVar != null && n3VarF != null) {
            return X0(n3VarF, n3VarF.l(bVar.f30778a, this.f30329b).f29300c, bVar);
        }
        int currentMediaItemIndex = this.f30334g.getCurrentMediaItemIndex();
        n3 currentTimeline = this.f30334g.getCurrentTimeline();
        if (!(currentMediaItemIndex < currentTimeline.t())) {
            currentTimeline = n3.f29295a;
        }
        return X0(currentTimeline, currentMediaItemIndex, null);
    }

    private c.a Z0() {
        return Y0(this.f30331d.e());
    }

    private c.a a1(int i10, @Nullable a0.b bVar) {
        a4.a.e(this.f30334g);
        if (bVar != null) {
            return this.f30331d.f(bVar) != null ? Y0(bVar) : X0(n3.f29295a, i10, bVar);
        }
        n3 currentTimeline = this.f30334g.getCurrentTimeline();
        if (!(i10 < currentTimeline.t())) {
            currentTimeline = n3.f29295a;
        }
        return X0(currentTimeline, i10, null);
    }

    private c.a b1() {
        return Y0(this.f30331d.g());
    }

    private c.a c1() {
        return Y0(this.f30331d.h());
    }

    private c.a d1(@Nullable n2 n2Var) {
        l3.y yVar;
        return (!(n2Var instanceof k2.q) || (yVar = ((k2.q) n2Var).f29416i) == null) ? W0() : Y0(new a0.b(yVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e2(c.a aVar, String str, long j10, long j11, c cVar) {
        cVar.p0(aVar, str, j10);
        cVar.i0(aVar, str, j11, j10);
        cVar.X(aVar, 2, str, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g2(c.a aVar, n2.e eVar, c cVar) {
        cVar.q0(aVar, eVar);
        cVar.y(aVar, 2, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h1(c.a aVar, String str, long j10, long j11, c cVar) {
        cVar.w(aVar, str, j10);
        cVar.D(aVar, str, j11, j10);
        cVar.X(aVar, 1, str, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h2(c.a aVar, n2.e eVar, c cVar) {
        cVar.g(aVar, eVar);
        cVar.r0(aVar, 2, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j1(c.a aVar, n2.e eVar, c cVar) {
        cVar.x(aVar, eVar);
        cVar.y(aVar, 1, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j2(c.a aVar, k2.o1 o1Var, n2.i iVar, c cVar) {
        cVar.e0(aVar, o1Var);
        cVar.n0(aVar, o1Var, iVar);
        cVar.m0(aVar, 2, o1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k1(c.a aVar, n2.e eVar, c cVar) {
        cVar.l0(aVar, eVar);
        cVar.r0(aVar, 1, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k2(c.a aVar, b4.b0 b0Var, c cVar) {
        cVar.s(aVar, b0Var);
        cVar.b0(aVar, b0Var.f2079a, b0Var.f2080b, b0Var.f2081c, b0Var.f2082d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l1(c.a aVar, k2.o1 o1Var, n2.i iVar, c cVar) {
        cVar.Z(aVar, o1Var);
        cVar.h(aVar, o1Var, iVar);
        cVar.m0(aVar, 1, o1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n2(r2 r2Var, c cVar, a4.m mVar) {
        cVar.O(r2Var, new c.b(mVar, this.f30332e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o2() {
        final c.a aVarW0 = W0();
        p2(aVarW0, 1028, new s.a() { // from class: l2.w0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).k0(aVarW0);
            }
        });
        this.f30333f.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z1(c.a aVar, int i10, c cVar) {
        cVar.a0(aVar);
        cVar.G(aVar, i10);
    }

    @Override // o2.w
    public final void A(int i10, @Nullable a0.b bVar) {
        final c.a aVarA1 = a1(i10, bVar);
        p2(aVarA1, 1027, new s.a() { // from class: l2.c1
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).j(aVarA1);
            }
        });
    }

    @Override // k2.r2.d
    public void B(final k2.o oVar) {
        final c.a aVarW0 = W0();
        p2(aVarW0, 29, new s.a() { // from class: l2.o
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).H(aVarW0, oVar);
            }
        });
    }

    @Override // o2.w
    public final void C(int i10, @Nullable a0.b bVar, final int i11) {
        final c.a aVarA1 = a1(i10, bVar);
        p2(aVarA1, 1022, new s.a() { // from class: l2.e1
            @Override // a4.s.a
            public final void invoke(Object obj) {
                o1.z1(aVarA1, i11, (c) obj);
            }
        });
    }

    @Override // k2.r2.d
    public final void D(final r2.e eVar, final r2.e eVar2, final int i10) {
        if (i10 == 1) {
            this.f30336i = false;
        }
        this.f30331d.j((r2) a4.a.e(this.f30334g));
        final c.a aVarW0 = W0();
        p2(aVarW0, 11, new s.a() { // from class: l2.p0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                o1.T1(aVarW0, i10, eVar, eVar2, (c) obj);
            }
        });
    }

    @Override // k2.r2.d
    public void E(@Nullable final n2 n2Var) {
        final c.a aVarD1 = d1(n2Var);
        p2(aVarD1, 10, new s.a() { // from class: l2.e
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).T(aVarD1, n2Var);
            }
        });
    }

    @Override // k2.r2.d
    public void F(final r2.b bVar) {
        final c.a aVarW0 = W0();
        p2(aVarW0, 13, new s.a() { // from class: l2.b0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).Y(aVarW0, bVar);
            }
        });
    }

    @Override // k2.r2.d
    public void G(final s3 s3Var) {
        final c.a aVarW0 = W0();
        p2(aVarW0, 2, new s.a() { // from class: l2.q
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).u0(aVarW0, s3Var);
            }
        });
    }

    @Override // k2.r2.d
    public void H(final x3.z zVar) {
        final c.a aVarW0 = W0();
        p2(aVarW0, 19, new s.a() { // from class: l2.r0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).a(aVarW0, zVar);
            }
        });
    }

    @Override // l2.a
    @CallSuper
    public void I(c cVar) {
        a4.a.e(cVar);
        this.f30333f.c(cVar);
    }

    @Override // l3.g0
    public final void J(int i10, @Nullable a0.b bVar, final l3.t tVar, final l3.w wVar) {
        final c.a aVarA1 = a1(i10, bVar);
        p2(aVarA1, 1002, new s.a() { // from class: l2.t0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).t0(aVarA1, tVar, wVar);
            }
        });
    }

    @Override // l3.g0
    public final void K(int i10, @Nullable a0.b bVar, final l3.w wVar) {
        final c.a aVarA1 = a1(i10, bVar);
        p2(aVarA1, 1004, new s.a() { // from class: l2.x0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).f(aVarA1, wVar);
            }
        });
    }

    protected final c.a W0() {
        return Y0(this.f30331d.d());
    }

    protected final c.a X0(n3 n3Var, int i10, @Nullable a0.b bVar) {
        long contentPosition;
        a0.b bVar2 = n3Var.u() ? null : bVar;
        long jElapsedRealtime = this.f30328a.elapsedRealtime();
        boolean z10 = n3Var.equals(this.f30334g.getCurrentTimeline()) && i10 == this.f30334g.getCurrentMediaItemIndex();
        long jE = 0;
        if (bVar2 != null && bVar2.b()) {
            if (z10 && this.f30334g.getCurrentAdGroupIndex() == bVar2.f30779b && this.f30334g.getCurrentAdIndexInAdGroup() == bVar2.f30780c) {
                jE = this.f30334g.getCurrentPosition();
            }
        } else {
            if (z10) {
                contentPosition = this.f30334g.getContentPosition();
                return new c.a(jElapsedRealtime, n3Var, i10, bVar2, contentPosition, this.f30334g.getCurrentTimeline(), this.f30334g.getCurrentMediaItemIndex(), this.f30331d.d(), this.f30334g.getCurrentPosition(), this.f30334g.getTotalBufferedDuration());
            }
            if (!n3Var.u()) {
                jE = n3Var.r(i10, this.f30330c).e();
            }
        }
        contentPosition = jE;
        return new c.a(jElapsedRealtime, n3Var, i10, bVar2, contentPosition, this.f30334g.getCurrentTimeline(), this.f30334g.getCurrentMediaItemIndex(), this.f30331d.d(), this.f30334g.getCurrentPosition(), this.f30334g.getTotalBufferedDuration());
    }

    @Override // k2.r2.d
    public void a(final n3.f fVar) {
        final c.a aVarW0 = W0();
        p2(aVarW0, 27, new s.a() { // from class: l2.e0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).z(aVarW0, fVar);
            }
        });
    }

    @Override // l2.a
    public final void b(final n2.e eVar) {
        final c.a aVarB1 = b1();
        p2(aVarB1, 1013, new s.a() { // from class: l2.h0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                o1.j1(aVarB1, eVar, (c) obj);
            }
        });
    }

    @Override // l2.a
    public final void c(final n2.e eVar) {
        final c.a aVarC1 = c1();
        p2(aVarC1, 1015, new s.a() { // from class: l2.i
            @Override // a4.s.a
            public final void invoke(Object obj) {
                o1.h2(aVarC1, eVar, (c) obj);
            }
        });
    }

    @Override // l2.a
    public final void d(final k2.o1 o1Var, @Nullable final n2.i iVar) {
        final c.a aVarC1 = c1();
        p2(aVarC1, 1017, new s.a() { // from class: l2.i0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                o1.j2(aVarC1, o1Var, iVar, (c) obj);
            }
        });
    }

    @Override // l2.a
    public final void e(final k2.o1 o1Var, @Nullable final n2.i iVar) {
        final c.a aVarC1 = c1();
        p2(aVarC1, 1009, new s.a() { // from class: l2.x
            @Override // a4.s.a
            public final void invoke(Object obj) {
                o1.l1(aVarC1, o1Var, iVar, (c) obj);
            }
        });
    }

    @Override // k2.r2.d
    public final void f(final b4.b0 b0Var) {
        final c.a aVarC1 = c1();
        p2(aVarC1, 25, new s.a() { // from class: l2.u0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                o1.k2(aVarC1, b0Var, (c) obj);
            }
        });
    }

    @Override // l2.a
    public final void g(final n2.e eVar) {
        final c.a aVarC1 = c1();
        p2(aVarC1, 1007, new s.a() { // from class: l2.y
            @Override // a4.s.a
            public final void invoke(Object obj) {
                o1.k1(aVarC1, eVar, (c) obj);
            }
        });
    }

    @Override // k2.r2.d
    public final void h(final q2 q2Var) {
        final c.a aVarW0 = W0();
        p2(aVarW0, 12, new s.a() { // from class: l2.l0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).d(aVarW0, q2Var);
            }
        });
    }

    @Override // l2.a
    public final void i(final n2.e eVar) {
        final c.a aVarB1 = b1();
        p2(aVarB1, 1020, new s.a() { // from class: l2.w
            @Override // a4.s.a
            public final void invoke(Object obj) {
                o1.g2(aVarB1, eVar, (c) obj);
            }
        });
    }

    @Override // k2.r2.d
    public final void j(final c3.a aVar) {
        final c.a aVarW0 = W0();
        p2(aVarW0, 28, new s.a() { // from class: l2.d
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).s0(aVarW0, aVar);
            }
        });
    }

    @Override // l3.g0
    public final void k(int i10, @Nullable a0.b bVar, final l3.t tVar, final l3.w wVar) {
        final c.a aVarA1 = a1(i10, bVar);
        p2(aVarA1, 1000, new s.a() { // from class: l2.z0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).c0(aVarA1, tVar, wVar);
            }
        });
    }

    @Override // l2.a
    @CallSuper
    public void l(final r2 r2Var, Looper looper) {
        a4.a.g(this.f30334g == null || this.f30331d.f30338b.isEmpty());
        this.f30334g = (r2) a4.a.e(r2Var);
        this.f30335h = this.f30328a.createHandler(looper, null);
        this.f30333f = this.f30333f.e(looper, new s.b() { // from class: l2.m
            @Override // a4.s.b
            public final void a(Object obj, a4.m mVar) {
                this.f30312a.n2(r2Var, (c) obj, mVar);
            }
        });
    }

    @Override // k2.r2.d
    public void m(final b2 b2Var) {
        final c.a aVarW0 = W0();
        p2(aVarW0, 14, new s.a() { // from class: l2.g1
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).m(aVarW0, b2Var);
            }
        });
    }

    @Override // l3.g0
    public final void n(int i10, @Nullable a0.b bVar, final l3.t tVar, final l3.w wVar) {
        final c.a aVarA1 = a1(i10, bVar);
        p2(aVarA1, 1001, new s.a() { // from class: l2.a1
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).i(aVarA1, tVar, wVar);
            }
        });
    }

    @Override // l2.a
    public final void notifySeekStarted() {
        if (this.f30336i) {
            return;
        }
        final c.a aVarW0 = W0();
        this.f30336i = true;
        p2(aVarW0, -1, new s.a() { // from class: l2.m1
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).j0(aVarW0);
            }
        });
    }

    @Override // l3.g0
    public final void o(int i10, @Nullable a0.b bVar, final l3.t tVar, final l3.w wVar, final IOException iOException, final boolean z10) {
        final c.a aVarA1 = a1(i10, bVar);
        p2(aVarA1, 1003, new s.a() { // from class: l2.y0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).g0(aVarA1, tVar, wVar, iOException, z10);
            }
        });
    }

    @Override // l2.a
    public final void onAudioCodecError(final Exception exc) {
        final c.a aVarC1 = c1();
        p2(aVarC1, 1029, new s.a() { // from class: l2.g0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).b(aVarC1, exc);
            }
        });
    }

    @Override // l2.a
    public final void onAudioDecoderInitialized(final String str, final long j10, final long j11) {
        final c.a aVarC1 = c1();
        p2(aVarC1, 1008, new s.a() { // from class: l2.l
            @Override // a4.s.a
            public final void invoke(Object obj) {
                o1.h1(aVarC1, str, j11, j10, (c) obj);
            }
        });
    }

    @Override // l2.a
    public final void onAudioDecoderReleased(final String str) {
        final c.a aVarC1 = c1();
        p2(aVarC1, 1012, new s.a() { // from class: l2.n
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).W(aVarC1, str);
            }
        });
    }

    @Override // l2.a
    public final void onAudioPositionAdvancing(final long j10) {
        final c.a aVarC1 = c1();
        p2(aVarC1, 1010, new s.a() { // from class: l2.p
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).J(aVarC1, j10);
            }
        });
    }

    @Override // l2.a
    public final void onAudioSinkError(final Exception exc) {
        final c.a aVarC1 = c1();
        p2(aVarC1, 1014, new s.a() { // from class: l2.s
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).N(aVarC1, exc);
            }
        });
    }

    @Override // l2.a
    public final void onAudioUnderrun(final int i10, final long j10, final long j11) {
        final c.a aVarC1 = c1();
        p2(aVarC1, 1011, new s.a() { // from class: l2.q0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).I(aVarC1, i10, j10, j11);
            }
        });
    }

    @Override // z3.e.a
    public final void onBandwidthSample(final int i10, final long j10, final long j11) {
        final c.a aVarZ0 = Z0();
        p2(aVarZ0, 1006, new s.a() { // from class: l2.d1
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).Q(aVarZ0, i10, j10, j11);
            }
        });
    }

    @Override // k2.r2.d
    public void onCues(final List<n3.b> list) {
        final c.a aVarW0 = W0();
        p2(aVarW0, 27, new s.a() { // from class: l2.o0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).r(aVarW0, list);
            }
        });
    }

    @Override // k2.r2.d
    public void onDeviceVolumeChanged(final int i10, final boolean z10) {
        final c.a aVarW0 = W0();
        p2(aVarW0, 30, new s.a() { // from class: l2.h
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).A(aVarW0, i10, z10);
            }
        });
    }

    @Override // l2.a
    public final void onDroppedFrames(final int i10, final long j10) {
        final c.a aVarB1 = b1();
        p2(aVarB1, 1018, new s.a() { // from class: l2.v
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).R(aVarB1, i10, j10);
            }
        });
    }

    @Override // k2.r2.d
    public final void onIsLoadingChanged(final boolean z10) {
        final c.a aVarW0 = W0();
        p2(aVarW0, 3, new s.a() { // from class: l2.j0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                o1.D1(aVarW0, z10, (c) obj);
            }
        });
    }

    @Override // k2.r2.d
    public void onIsPlayingChanged(final boolean z10) {
        final c.a aVarW0 = W0();
        p2(aVarW0, 7, new s.a() { // from class: l2.r
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).c(aVarW0, z10);
            }
        });
    }

    @Override // k2.r2.d
    public final void onPlayWhenReadyChanged(final boolean z10, final int i10) {
        final c.a aVarW0 = W0();
        p2(aVarW0, 5, new s.a() { // from class: l2.d0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).K(aVarW0, z10, i10);
            }
        });
    }

    @Override // k2.r2.d
    public final void onPlaybackStateChanged(final int i10) {
        final c.a aVarW0 = W0();
        p2(aVarW0, 4, new s.a() { // from class: l2.v0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).M(aVarW0, i10);
            }
        });
    }

    @Override // k2.r2.d
    public final void onPlaybackSuppressionReasonChanged(final int i10) {
        final c.a aVarW0 = W0();
        p2(aVarW0, 6, new s.a() { // from class: l2.t
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).B(aVarW0, i10);
            }
        });
    }

    @Override // k2.r2.d
    public final void onPlayerStateChanged(final boolean z10, final int i10) {
        final c.a aVarW0 = W0();
        p2(aVarW0, -1, new s.a() { // from class: l2.u
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).v(aVarW0, z10, i10);
            }
        });
    }

    @Override // k2.r2.d
    public void onRenderedFirstFrame() {
    }

    @Override // k2.r2.d
    public final void onRepeatModeChanged(final int i10) {
        final c.a aVarW0 = W0();
        p2(aVarW0, 8, new s.a() { // from class: l2.a0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).x0(aVarW0, i10);
            }
        });
    }

    @Override // k2.r2.d
    public final void onShuffleModeEnabledChanged(final boolean z10) {
        final c.a aVarW0 = W0();
        p2(aVarW0, 9, new s.a() { // from class: l2.g
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).P(aVarW0, z10);
            }
        });
    }

    @Override // k2.r2.d
    public final void onSkipSilenceEnabledChanged(final boolean z10) {
        final c.a aVarC1 = c1();
        p2(aVarC1, 23, new s.a() { // from class: l2.b1
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).p(aVarC1, z10);
            }
        });
    }

    @Override // k2.r2.d
    public final void onSurfaceSizeChanged(final int i10, final int i11) {
        final c.a aVarC1 = c1();
        p2(aVarC1, 24, new s.a() { // from class: l2.c0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).o(aVarC1, i10, i11);
            }
        });
    }

    @Override // l2.a
    public final void onVideoCodecError(final Exception exc) {
        final c.a aVarC1 = c1();
        p2(aVarC1, 1030, new s.a() { // from class: l2.k1
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).L(aVarC1, exc);
            }
        });
    }

    @Override // l2.a
    public final void onVideoDecoderInitialized(final String str, final long j10, final long j11) {
        final c.a aVarC1 = c1();
        p2(aVarC1, 1016, new s.a() { // from class: l2.n1
            @Override // a4.s.a
            public final void invoke(Object obj) {
                o1.e2(aVarC1, str, j11, j10, (c) obj);
            }
        });
    }

    @Override // l2.a
    public final void onVideoDecoderReleased(final String str) {
        final c.a aVarC1 = c1();
        p2(aVarC1, 1019, new s.a() { // from class: l2.f
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).E(aVarC1, str);
            }
        });
    }

    @Override // l2.a
    public final void onVideoFrameProcessingOffset(final long j10, final int i10) {
        final c.a aVarB1 = b1();
        p2(aVarB1, 1021, new s.a() { // from class: l2.l1
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).k(aVarB1, j10, i10);
            }
        });
    }

    @Override // k2.r2.d
    public final void onVolumeChanged(final float f10) {
        final c.a aVarC1 = c1();
        p2(aVarC1, 22, new s.a() { // from class: l2.k0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).u(aVarC1, f10);
            }
        });
    }

    @Override // o2.w
    public final void p(int i10, @Nullable a0.b bVar) {
        final c.a aVarA1 = a1(i10, bVar);
        p2(aVarA1, 1026, new s.a() { // from class: l2.i1
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).f0(aVarA1);
            }
        });
    }

    protected final void p2(c.a aVar, int i10, s.a<c> aVar2) {
        this.f30332e.put(i10, aVar);
        this.f30333f.l(i10, aVar2);
    }

    @Override // o2.w
    public /* synthetic */ void q(int i10, a0.b bVar) {
        o2.p.a(this, i10, bVar);
    }

    @Override // l2.a
    public final void r(List<a0.b> list, @Nullable a0.b bVar) {
        this.f30331d.k(list, bVar, (r2) a4.a.e(this.f30334g));
    }

    @Override // l2.a
    @CallSuper
    public void release() {
        ((a4.p) a4.a.i(this.f30335h)).post(new Runnable() { // from class: l2.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f30293a.o2();
            }
        });
    }

    @Override // o2.w
    public final void s(int i10, @Nullable a0.b bVar) {
        final c.a aVarA1 = a1(i10, bVar);
        p2(aVarA1, 1025, new s.a() { // from class: l2.j1
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).V(aVarA1);
            }
        });
    }

    @Override // k2.r2.d
    public final void u(final n2 n2Var) {
        final c.a aVarD1 = d1(n2Var);
        p2(aVarD1, 10, new s.a() { // from class: l2.k
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).F(aVarD1, n2Var);
            }
        });
    }

    @Override // o2.w
    public final void v(int i10, @Nullable a0.b bVar) {
        final c.a aVarA1 = a1(i10, bVar);
        p2(aVarA1, 1023, new s.a() { // from class: l2.h1
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).t(aVarA1);
            }
        });
    }

    @Override // o2.w
    public final void w(int i10, @Nullable a0.b bVar, final Exception exc) {
        final c.a aVarA1 = a1(i10, bVar);
        p2(aVarA1, 1024, new s.a() { // from class: l2.f1
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).C(aVarA1, exc);
            }
        });
    }

    @Override // k2.r2.d
    public final void x(@Nullable final w1 w1Var, final int i10) {
        final c.a aVarW0 = W0();
        p2(aVarW0, 1, new s.a() { // from class: l2.z
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).y0(aVarW0, w1Var, i10);
            }
        });
    }

    @Override // k2.r2.d
    public final void y() {
        final c.a aVarW0 = W0();
        p2(aVarW0, -1, new s.a() { // from class: l2.n0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).e(aVarW0);
            }
        });
    }

    @Override // k2.r2.d
    public final void z(n3 n3Var, final int i10) {
        this.f30331d.l((r2) a4.a.e(this.f30334g));
        final c.a aVarW0 = W0();
        p2(aVarW0, 0, new s.a() { // from class: l2.m0
            @Override // a4.s.a
            public final void invoke(Object obj) {
                ((c) obj).S(aVarW0, i10);
            }
        });
    }

    @Override // l2.a
    public final void onRenderedFirstFrame(final Object obj, final long j10) {
        final c.a aVarC1 = c1();
        p2(aVarC1, 26, new s.a() { // from class: l2.s0
            @Override // a4.s.a
            public final void invoke(Object obj2) {
                ((c) obj2).h0(aVarC1, obj, j10);
            }
        });
    }

    @Override // k2.r2.d
    public void onLoadingChanged(boolean z10) {
    }

    @Override // k2.r2.d
    public void onPositionDiscontinuity(int i10) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e1(c cVar, a4.m mVar) {
    }

    @Override // k2.r2.d
    public void t(r2 r2Var, r2.c cVar) {
    }
}

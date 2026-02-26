package l3;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.C;
import k2.n3;
import k2.w1;
import l3.a0;

/* JADX INFO: compiled from: MaskingMediaSource.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v extends g1 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f30741m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final n3.d f30742n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final n3.b f30743o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private a f30744p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private u f30745q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f30746r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f30747s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f30748t;

    /* JADX INFO: compiled from: MaskingMediaSource.java */
    private static final class a extends r {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Object f30749f = new Object();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private final Object f30750d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private final Object f30751e;

        private a(n3 n3Var, @Nullable Object obj, @Nullable Object obj2) {
            super(n3Var);
            this.f30750d = obj;
            this.f30751e = obj2;
        }

        public static a A(w1 w1Var) {
            return new a(new b(w1Var), n3.d.f29309r, f30749f);
        }

        public static a B(n3 n3Var, @Nullable Object obj, @Nullable Object obj2) {
            return new a(n3Var, obj, obj2);
        }

        @Override // l3.r, k2.n3
        public int f(Object obj) {
            Object obj2;
            n3 n3Var = this.f30676c;
            if (f30749f.equals(obj) && (obj2 = this.f30751e) != null) {
                obj = obj2;
            }
            return n3Var.f(obj);
        }

        @Override // l3.r, k2.n3
        public n3.b k(int i10, n3.b bVar, boolean z10) {
            this.f30676c.k(i10, bVar, z10);
            if (a4.o0.c(bVar.f29299b, this.f30751e) && z10) {
                bVar.f29299b = f30749f;
            }
            return bVar;
        }

        @Override // l3.r, k2.n3
        public Object q(int i10) {
            Object objQ = this.f30676c.q(i10);
            return a4.o0.c(objQ, this.f30751e) ? f30749f : objQ;
        }

        @Override // l3.r, k2.n3
        public n3.d s(int i10, n3.d dVar, long j10) {
            this.f30676c.s(i10, dVar, j10);
            if (a4.o0.c(dVar.f29313a, this.f30750d)) {
                dVar.f29313a = n3.d.f29309r;
            }
            return dVar;
        }

        public a z(n3 n3Var) {
            return new a(n3Var, this.f30750d, this.f30751e);
        }
    }

    /* JADX INFO: compiled from: MaskingMediaSource.java */
    @VisibleForTesting
    public static final class b extends n3 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final w1 f30752c;

        public b(w1 w1Var) {
            this.f30752c = w1Var;
        }

        @Override // k2.n3
        public int f(Object obj) {
            return obj == a.f30749f ? 0 : -1;
        }

        @Override // k2.n3
        public n3.b k(int i10, n3.b bVar, boolean z10) {
            bVar.w(z10 ? 0 : null, z10 ? a.f30749f : null, 0, C.TIME_UNSET, 0L, m3.c.f31432g, true);
            return bVar;
        }

        @Override // k2.n3
        public int m() {
            return 1;
        }

        @Override // k2.n3
        public Object q(int i10) {
            return a.f30749f;
        }

        @Override // k2.n3
        public n3.d s(int i10, n3.d dVar, long j10) {
            dVar.k(n3.d.f29309r, this.f30752c, null, C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, false, true, null, 0L, C.TIME_UNSET, 0, 0, 0L);
            dVar.f29324l = true;
            return dVar;
        }

        @Override // k2.n3
        public int t() {
            return 1;
        }
    }

    public v(a0 a0Var, boolean z10) {
        super(a0Var);
        this.f30741m = z10 && a0Var.isSingleWindow();
        this.f30742n = new n3.d();
        this.f30743o = new n3.b();
        n3 initialTimeline = a0Var.getInitialTimeline();
        if (initialTimeline == null) {
            this.f30744p = a.A(a0Var.getMediaItem());
        } else {
            this.f30744p = a.B(initialTimeline, null, null);
            this.f30748t = true;
        }
    }

    private Object N(Object obj) {
        return (this.f30744p.f30751e == null || !this.f30744p.f30751e.equals(obj)) ? obj : a.f30749f;
    }

    private Object O(Object obj) {
        return (this.f30744p.f30751e == null || !obj.equals(a.f30749f)) ? obj : this.f30744p.f30751e;
    }

    private void Q(long j10) {
        u uVar = this.f30745q;
        int iF = this.f30744p.f(uVar.f30732a.f30778a);
        if (iF == -1) {
            return;
        }
        long j11 = this.f30744p.j(iF, this.f30743o).f29301d;
        if (j11 != C.TIME_UNSET && j10 >= j11) {
            j10 = Math.max(0L, j11 - 1);
        }
        uVar.l(j10);
    }

    @Override // l3.g1
    @Nullable
    protected a0.b D(a0.b bVar) {
        return bVar.c(N(bVar.f30778a));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // l3.g1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void J(k2.n3 r15) {
        /*
            r14 = this;
            boolean r0 = r14.f30747s
            if (r0 == 0) goto L19
            l3.v$a r0 = r14.f30744p
            l3.v$a r15 = r0.z(r15)
            r14.f30744p = r15
            l3.u r15 = r14.f30745q
            if (r15 == 0) goto Lae
            long r0 = r15.f()
            r14.Q(r0)
            goto Lae
        L19:
            boolean r0 = r15.u()
            if (r0 == 0) goto L36
            boolean r0 = r14.f30748t
            if (r0 == 0) goto L2a
            l3.v$a r0 = r14.f30744p
            l3.v$a r15 = r0.z(r15)
            goto L32
        L2a:
            java.lang.Object r0 = k2.n3.d.f29309r
            java.lang.Object r1 = l3.v.a.f30749f
            l3.v$a r15 = l3.v.a.B(r15, r0, r1)
        L32:
            r14.f30744p = r15
            goto Lae
        L36:
            k2.n3$d r0 = r14.f30742n
            r1 = 0
            r15.r(r1, r0)
            k2.n3$d r0 = r14.f30742n
            long r2 = r0.f()
            k2.n3$d r0 = r14.f30742n
            java.lang.Object r0 = r0.f29313a
            l3.u r4 = r14.f30745q
            if (r4 == 0) goto L74
            long r4 = r4.h()
            l3.v$a r6 = r14.f30744p
            l3.u r7 = r14.f30745q
            l3.a0$b r7 = r7.f30732a
            java.lang.Object r7 = r7.f30778a
            k2.n3$b r8 = r14.f30743o
            r6.l(r7, r8)
            k2.n3$b r6 = r14.f30743o
            long r6 = r6.q()
            long r6 = r6 + r4
            l3.v$a r4 = r14.f30744p
            k2.n3$d r5 = r14.f30742n
            k2.n3$d r1 = r4.r(r1, r5)
            long r4 = r1.f()
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 == 0) goto L74
            r12 = r6
            goto L75
        L74:
            r12 = r2
        L75:
            k2.n3$d r9 = r14.f30742n
            k2.n3$b r10 = r14.f30743o
            r11 = 0
            r8 = r15
            android.util.Pair r1 = r8.n(r9, r10, r11, r12)
            java.lang.Object r2 = r1.first
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r3 = r1.longValue()
            boolean r1 = r14.f30748t
            if (r1 == 0) goto L94
            l3.v$a r0 = r14.f30744p
            l3.v$a r15 = r0.z(r15)
            goto L98
        L94:
            l3.v$a r15 = l3.v.a.B(r15, r0, r2)
        L98:
            r14.f30744p = r15
            l3.u r15 = r14.f30745q
            if (r15 == 0) goto Lae
            r14.Q(r3)
            l3.a0$b r15 = r15.f30732a
            java.lang.Object r0 = r15.f30778a
            java.lang.Object r0 = r14.O(r0)
            l3.a0$b r15 = r15.c(r0)
            goto Laf
        Lae:
            r15 = 0
        Laf:
            r0 = 1
            r14.f30748t = r0
            r14.f30747s = r0
            l3.v$a r0 = r14.f30744p
            r14.t(r0)
            if (r15 == 0) goto Lc6
            l3.u r0 = r14.f30745q
            java.lang.Object r0 = a4.a.e(r0)
            l3.u r0 = (l3.u) r0
            r0.e(r15)
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.v.J(k2.n3):void");
    }

    @Override // l3.g1
    public void L() {
        if (this.f30741m) {
            return;
        }
        this.f30746r = true;
        K();
    }

    @Override // l3.a0
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public u j(a0.b bVar, z3.b bVar2, long j10) {
        u uVar = new u(bVar, bVar2, j10);
        uVar.n(this.f30543k);
        if (this.f30747s) {
            uVar.e(bVar.c(O(bVar.f30778a)));
        } else {
            this.f30745q = uVar;
            if (!this.f30746r) {
                this.f30746r = true;
                K();
            }
        }
        return uVar;
    }

    public n3 P() {
        return this.f30744p;
    }

    @Override // l3.a0
    public void e(x xVar) {
        ((u) xVar).m();
        if (xVar == this.f30745q) {
            this.f30745q = null;
        }
    }

    @Override // l3.f, l3.a
    public void u() {
        this.f30747s = false;
        this.f30746r = false;
        super.u();
    }

    @Override // l3.f, l3.a0
    public void maybeThrowSourceInfoRefreshError() {
    }
}

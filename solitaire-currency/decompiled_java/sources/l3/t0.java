package l3;

import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.io.IOException;
import k2.o1;
import k2.p1;
import l3.t0;
import o2.o;
import o2.w;
import o2.y;
import p2.e0;

/* JADX INFO: compiled from: SampleQueue.java */
/* JADX INFO: loaded from: classes2.dex */
public class t0 implements p2.e0 {

    @Nullable
    private o1 A;

    @Nullable
    private o1 B;
    private int C;
    private boolean D;
    private boolean E;
    private long F;
    private boolean G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r0 f30701a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final o2.y f30704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final w.a f30705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private d f30706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private o1 f30707g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private o2.o f30708h;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f30716p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f30717q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f30718r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f30719s;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f30723w;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f30726z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f30702b = new b();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f30709i = 1000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f30710j = new int[1000];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long[] f30711k = new long[1000];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long[] f30714n = new long[1000];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int[] f30713m = new int[1000];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int[] f30712l = new int[1000];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private e0.a[] f30715o = new e0.a[1000];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a1<c> f30703c = new a1<>(new a4.h() { // from class: l3.s0
        @Override // a4.h
        public final void accept(Object obj) {
            t0.E((t0.c) obj);
        }
    });

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f30720t = Long.MIN_VALUE;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f30721u = Long.MIN_VALUE;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f30722v = Long.MIN_VALUE;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f30725y = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f30724x = true;

    /* JADX INFO: compiled from: SampleQueue.java */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f30728b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public e0.a f30729c;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SampleQueue.java */
    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o1 f30730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final y.b f30731b;

        private c(o1 o1Var, y.b bVar) {
            this.f30730a = o1Var;
            this.f30731b = bVar;
        }
    }

    /* JADX INFO: compiled from: SampleQueue.java */
    public interface d {
        void f(o1 o1Var);
    }

    protected t0(z3.b bVar, @Nullable o2.y yVar, @Nullable w.a aVar) {
        this.f30704d = yVar;
        this.f30705e = aVar;
        this.f30701a = new r0(bVar);
    }

    private boolean B() {
        return this.f30719s != this.f30716p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(c cVar) {
        cVar.f30731b.release();
    }

    private boolean F(int i10) {
        o2.o oVar = this.f30708h;
        return oVar == null || oVar.getState() == 4 || ((this.f30713m[i10] & 1073741824) == 0 && this.f30708h.playClearSamplesWithoutKeys());
    }

    private void H(o1 o1Var, p1 p1Var) {
        o1 o1Var2 = this.f30707g;
        boolean z10 = o1Var2 == null;
        o2.m mVar = z10 ? null : o1Var2.f29350o;
        this.f30707g = o1Var;
        o2.m mVar2 = o1Var.f29350o;
        o2.y yVar = this.f30704d;
        p1Var.f29409b = yVar != null ? o1Var.c(yVar.b(o1Var)) : o1Var;
        p1Var.f29408a = this.f30708h;
        if (this.f30704d == null) {
            return;
        }
        if (z10 || !a4.o0.c(mVar, mVar2)) {
            o2.o oVar = this.f30708h;
            o2.o oVarA = this.f30704d.a(this.f30705e, o1Var);
            this.f30708h = oVarA;
            p1Var.f29408a = oVarA;
            if (oVar != null) {
                oVar.b(this.f30705e);
            }
        }
    }

    private synchronized int I(p1 p1Var, n2.g gVar, boolean z10, boolean z11, b bVar) {
        gVar.f31587d = false;
        if (!B()) {
            if (!z11 && !this.f30723w) {
                o1 o1Var = this.B;
                if (o1Var == null || (!z10 && o1Var == this.f30707g)) {
                    return -3;
                }
                H((o1) a4.a.e(o1Var), p1Var);
                return -5;
            }
            gVar.k(4);
            return -4;
        }
        o1 o1Var2 = this.f30703c.e(w()).f30730a;
        if (!z10 && o1Var2 == this.f30707g) {
            int iX = x(this.f30719s);
            if (!F(iX)) {
                gVar.f31587d = true;
                return -3;
            }
            gVar.k(this.f30713m[iX]);
            long j10 = this.f30714n[iX];
            gVar.f31588e = j10;
            if (j10 < this.f30720t) {
                gVar.a(Integer.MIN_VALUE);
            }
            bVar.f30727a = this.f30712l[iX];
            bVar.f30728b = this.f30711k[iX];
            bVar.f30729c = this.f30715o[iX];
            return -4;
        }
        H(o1Var2, p1Var);
        return -5;
    }

    private void M() {
        o2.o oVar = this.f30708h;
        if (oVar != null) {
            oVar.b(this.f30705e);
            this.f30708h = null;
            this.f30707g = null;
        }
    }

    private synchronized void P() {
        this.f30719s = 0;
        this.f30701a.n();
    }

    private synchronized boolean S(o1 o1Var) {
        this.f30725y = false;
        if (a4.o0.c(o1Var, this.B)) {
            return false;
        }
        if (this.f30703c.g() || !this.f30703c.f().f30730a.equals(o1Var)) {
            this.B = o1Var;
        } else {
            this.B = this.f30703c.f().f30730a;
        }
        o1 o1Var2 = this.B;
        this.D = a4.x.a(o1Var2.f29347l, o1Var2.f29344i);
        this.E = false;
        return true;
    }

    private synchronized boolean h(long j10) {
        if (this.f30716p == 0) {
            return j10 > this.f30721u;
        }
        if (u() >= j10) {
            return false;
        }
        q(this.f30717q + j(j10));
        return true;
    }

    private synchronized void i(long j10, int i10, long j11, int i11, @Nullable e0.a aVar) {
        int i12 = this.f30716p;
        if (i12 > 0) {
            int iX = x(i12 - 1);
            a4.a.a(this.f30711k[iX] + ((long) this.f30712l[iX]) <= j11);
        }
        this.f30723w = (536870912 & i10) != 0;
        this.f30722v = Math.max(this.f30722v, j10);
        int iX2 = x(this.f30716p);
        this.f30714n[iX2] = j10;
        this.f30711k[iX2] = j11;
        this.f30712l[iX2] = i11;
        this.f30713m[iX2] = i10;
        this.f30715o[iX2] = aVar;
        this.f30710j[iX2] = this.C;
        if (this.f30703c.g() || !this.f30703c.f().f30730a.equals(this.B)) {
            o2.y yVar = this.f30704d;
            this.f30703c.a(A(), new c((o1) a4.a.e(this.B), yVar != null ? yVar.d(this.f30705e, this.B) : y.b.f31951a));
        }
        int i13 = this.f30716p + 1;
        this.f30716p = i13;
        int i14 = this.f30709i;
        if (i13 == i14) {
            int i15 = i14 + 1000;
            int[] iArr = new int[i15];
            long[] jArr = new long[i15];
            long[] jArr2 = new long[i15];
            int[] iArr2 = new int[i15];
            int[] iArr3 = new int[i15];
            e0.a[] aVarArr = new e0.a[i15];
            int i16 = this.f30718r;
            int i17 = i14 - i16;
            System.arraycopy(this.f30711k, i16, jArr, 0, i17);
            System.arraycopy(this.f30714n, this.f30718r, jArr2, 0, i17);
            System.arraycopy(this.f30713m, this.f30718r, iArr2, 0, i17);
            System.arraycopy(this.f30712l, this.f30718r, iArr3, 0, i17);
            System.arraycopy(this.f30715o, this.f30718r, aVarArr, 0, i17);
            System.arraycopy(this.f30710j, this.f30718r, iArr, 0, i17);
            int i18 = this.f30718r;
            System.arraycopy(this.f30711k, 0, jArr, i17, i18);
            System.arraycopy(this.f30714n, 0, jArr2, i17, i18);
            System.arraycopy(this.f30713m, 0, iArr2, i17, i18);
            System.arraycopy(this.f30712l, 0, iArr3, i17, i18);
            System.arraycopy(this.f30715o, 0, aVarArr, i17, i18);
            System.arraycopy(this.f30710j, 0, iArr, i17, i18);
            this.f30711k = jArr;
            this.f30714n = jArr2;
            this.f30713m = iArr2;
            this.f30712l = iArr3;
            this.f30715o = aVarArr;
            this.f30710j = iArr;
            this.f30718r = 0;
            this.f30709i = i15;
        }
    }

    private int j(long j10) {
        int i10 = this.f30716p;
        int iX = x(i10 - 1);
        while (i10 > this.f30719s && this.f30714n[iX] >= j10) {
            i10--;
            iX--;
            if (iX == -1) {
                iX = this.f30709i - 1;
            }
        }
        return i10;
    }

    public static t0 k(z3.b bVar, o2.y yVar, w.a aVar) {
        return new t0(bVar, (o2.y) a4.a.e(yVar), (w.a) a4.a.e(aVar));
    }

    private synchronized long l(long j10, boolean z10, boolean z11) {
        int i10;
        int i11 = this.f30716p;
        if (i11 != 0) {
            long[] jArr = this.f30714n;
            int i12 = this.f30718r;
            if (j10 >= jArr[i12]) {
                if (z11 && (i10 = this.f30719s) != i11) {
                    i11 = i10 + 1;
                }
                int iR = r(i12, i11, j10, z10);
                if (iR == -1) {
                    return -1L;
                }
                return n(iR);
            }
        }
        return -1L;
    }

    private synchronized long m() {
        int i10 = this.f30716p;
        if (i10 == 0) {
            return -1L;
        }
        return n(i10);
    }

    @GuardedBy("this")
    private long n(int i10) {
        this.f30721u = Math.max(this.f30721u, v(i10));
        this.f30716p -= i10;
        int i11 = this.f30717q + i10;
        this.f30717q = i11;
        int i12 = this.f30718r + i10;
        this.f30718r = i12;
        int i13 = this.f30709i;
        if (i12 >= i13) {
            this.f30718r = i12 - i13;
        }
        int i14 = this.f30719s - i10;
        this.f30719s = i14;
        if (i14 < 0) {
            this.f30719s = 0;
        }
        this.f30703c.d(i11);
        if (this.f30716p != 0) {
            return this.f30711k[this.f30718r];
        }
        int i15 = this.f30718r;
        if (i15 == 0) {
            i15 = this.f30709i;
        }
        int i16 = i15 - 1;
        return this.f30711k[i16] + ((long) this.f30712l[i16]);
    }

    private long q(int i10) {
        int iA = A() - i10;
        boolean z10 = false;
        a4.a.a(iA >= 0 && iA <= this.f30716p - this.f30719s);
        int i11 = this.f30716p - iA;
        this.f30716p = i11;
        this.f30722v = Math.max(this.f30721u, v(i11));
        if (iA == 0 && this.f30723w) {
            z10 = true;
        }
        this.f30723w = z10;
        this.f30703c.c(i10);
        int i12 = this.f30716p;
        if (i12 == 0) {
            return 0L;
        }
        int iX = x(i12 - 1);
        return this.f30711k[iX] + ((long) this.f30712l[iX]);
    }

    private int r(int i10, int i11, long j10, boolean z10) {
        int i12 = -1;
        for (int i13 = 0; i13 < i11; i13++) {
            long j11 = this.f30714n[i10];
            if (j11 > j10) {
                return i12;
            }
            if (!z10 || (this.f30713m[i10] & 1) != 0) {
                if (j11 == j10) {
                    return i13;
                }
                i12 = i13;
            }
            i10++;
            if (i10 == this.f30709i) {
                i10 = 0;
            }
        }
        return i12;
    }

    private long v(int i10) {
        long jMax = Long.MIN_VALUE;
        if (i10 == 0) {
            return Long.MIN_VALUE;
        }
        int iX = x(i10 - 1);
        for (int i11 = 0; i11 < i10; i11++) {
            jMax = Math.max(jMax, this.f30714n[iX]);
            if ((this.f30713m[iX] & 1) != 0) {
                break;
            }
            iX--;
            if (iX == -1) {
                iX = this.f30709i - 1;
            }
        }
        return jMax;
    }

    private int x(int i10) {
        int i11 = this.f30718r + i10;
        int i12 = this.f30709i;
        return i11 < i12 ? i11 : i11 - i12;
    }

    public final int A() {
        return this.f30717q + this.f30716p;
    }

    public final synchronized boolean C() {
        return this.f30723w;
    }

    @CallSuper
    public synchronized boolean D(boolean z10) {
        o1 o1Var;
        boolean z11 = true;
        if (B()) {
            if (this.f30703c.e(w()).f30730a != this.f30707g) {
                return true;
            }
            return F(x(this.f30719s));
        }
        if (!z10 && !this.f30723w && ((o1Var = this.B) == null || o1Var == this.f30707g)) {
            z11 = false;
        }
        return z11;
    }

    @CallSuper
    public void G() throws IOException {
        o2.o oVar = this.f30708h;
        if (oVar != null && oVar.getState() == 1) {
            throw ((o.a) a4.a.e(this.f30708h.getError()));
        }
    }

    @CallSuper
    public void J() {
        p();
        M();
    }

    @CallSuper
    public int K(p1 p1Var, n2.g gVar, int i10, boolean z10) {
        int I = I(p1Var, gVar, (i10 & 2) != 0, z10, this.f30702b);
        if (I == -4 && !gVar.h()) {
            boolean z11 = (i10 & 1) != 0;
            if ((i10 & 4) == 0) {
                if (z11) {
                    this.f30701a.e(gVar, this.f30702b);
                } else {
                    this.f30701a.l(gVar, this.f30702b);
                }
            }
            if (!z11) {
                this.f30719s++;
            }
        }
        return I;
    }

    @CallSuper
    public void L() {
        O(true);
        M();
    }

    public final void N() {
        O(false);
    }

    @CallSuper
    public void O(boolean z10) {
        this.f30701a.m();
        this.f30716p = 0;
        this.f30717q = 0;
        this.f30718r = 0;
        this.f30719s = 0;
        this.f30724x = true;
        this.f30720t = Long.MIN_VALUE;
        this.f30721u = Long.MIN_VALUE;
        this.f30722v = Long.MIN_VALUE;
        this.f30723w = false;
        this.f30703c.b();
        if (z10) {
            this.A = null;
            this.B = null;
            this.f30725y = true;
        }
    }

    public final synchronized boolean Q(long j10, boolean z10) {
        P();
        int iX = x(this.f30719s);
        if (B() && j10 >= this.f30714n[iX] && (j10 <= this.f30722v || z10)) {
            int iR = r(iX, this.f30716p - this.f30719s, j10, true);
            if (iR == -1) {
                return false;
            }
            this.f30720t = j10;
            this.f30719s += iR;
            return true;
        }
        return false;
    }

    public final void R(long j10) {
        this.f30720t = j10;
    }

    public final void T(@Nullable d dVar) {
        this.f30706f = dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void U(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 < 0) goto Le
            int r0 = r2.f30719s     // Catch: java.lang.Throwable -> Lc
            int r0 = r0 + r3
            int r1 = r2.f30716p     // Catch: java.lang.Throwable -> Lc
            if (r0 > r1) goto Le
            r0 = 1
            goto Lf
        Lc:
            r3 = move-exception
            goto L19
        Le:
            r0 = 0
        Lf:
            a4.a.a(r0)     // Catch: java.lang.Throwable -> Lc
            int r0 = r2.f30719s     // Catch: java.lang.Throwable -> Lc
            int r0 = r0 + r3
            r2.f30719s = r0     // Catch: java.lang.Throwable -> Lc
            monitor-exit(r2)
            return
        L19:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.t0.U(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    @Override // p2.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(long r12, int r14, int r15, int r16, @androidx.annotation.Nullable p2.e0.a r17) {
        /*
            r11 = this;
            r8 = r11
            boolean r0 = r8.f30726z
            if (r0 == 0) goto L10
            k2.o1 r0 = r8.A
            java.lang.Object r0 = a4.a.i(r0)
            k2.o1 r0 = (k2.o1) r0
            r11.f(r0)
        L10:
            r0 = r14 & 1
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L18
            r3 = r2
            goto L19
        L18:
            r3 = r1
        L19:
            boolean r4 = r8.f30724x
            if (r4 == 0) goto L22
            if (r3 != 0) goto L20
            return
        L20:
            r8.f30724x = r1
        L22:
            long r4 = r8.F
            long r4 = r4 + r12
            boolean r6 = r8.D
            if (r6 == 0) goto L54
            long r6 = r8.f30720t
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 >= 0) goto L30
            return
        L30:
            if (r0 != 0) goto L54
            boolean r0 = r8.E
            if (r0 != 0) goto L50
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "Overriding unexpected non-sync sample for format: "
            r0.append(r6)
            k2.o1 r6 = r8.B
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = "SampleQueue"
            a4.t.i(r6, r0)
            r8.E = r2
        L50:
            r0 = r14 | 1
            r6 = r0
            goto L55
        L54:
            r6 = r14
        L55:
            boolean r0 = r8.G
            if (r0 == 0) goto L66
            if (r3 == 0) goto L65
            boolean r0 = r11.h(r4)
            if (r0 != 0) goto L62
            goto L65
        L62:
            r8.G = r1
            goto L66
        L65:
            return
        L66:
            l3.r0 r0 = r8.f30701a
            long r0 = r0.d()
            r7 = r15
            long r2 = (long) r7
            long r0 = r0 - r2
            r2 = r16
            long r2 = (long) r2
            long r9 = r0 - r2
            r0 = r11
            r1 = r4
            r3 = r6
            r4 = r9
            r6 = r15
            r7 = r17
            r0.i(r1, r3, r4, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.t0.a(long, int, int, int, p2.e0$a):void");
    }

    @Override // p2.e0
    public final void b(a4.c0 c0Var, int i10, int i11) {
        this.f30701a.p(c0Var, i10);
    }

    @Override // p2.e0
    public /* synthetic */ int c(z3.h hVar, int i10, boolean z10) {
        return p2.d0.a(this, hVar, i10, z10);
    }

    @Override // p2.e0
    public final int d(z3.h hVar, int i10, boolean z10, int i11) throws IOException {
        return this.f30701a.o(hVar, i10, z10);
    }

    @Override // p2.e0
    public /* synthetic */ void e(a4.c0 c0Var, int i10) {
        p2.d0.b(this, c0Var, i10);
    }

    @Override // p2.e0
    public final void f(o1 o1Var) {
        o1 o1VarS = s(o1Var);
        this.f30726z = false;
        this.A = o1Var;
        boolean zS = S(o1VarS);
        d dVar = this.f30706f;
        if (dVar == null || !zS) {
            return;
        }
        dVar.f(o1VarS);
    }

    public final void o(long j10, boolean z10, boolean z11) {
        this.f30701a.b(l(j10, z10, z11));
    }

    public final void p() {
        this.f30701a.b(m());
    }

    @CallSuper
    protected o1 s(o1 o1Var) {
        return (this.F == 0 || o1Var.f29351p == Long.MAX_VALUE) ? o1Var : o1Var.b().i0(o1Var.f29351p + this.F).E();
    }

    public final synchronized long t() {
        return this.f30722v;
    }

    public final synchronized long u() {
        return Math.max(this.f30721u, v(this.f30719s));
    }

    public final int w() {
        return this.f30717q + this.f30719s;
    }

    public final synchronized int y(long j10, boolean z10) {
        int iX = x(this.f30719s);
        if (B() && j10 >= this.f30714n[iX]) {
            if (j10 > this.f30722v && z10) {
                return this.f30716p - this.f30719s;
            }
            int iR = r(iX, this.f30716p - this.f30719s, j10, true);
            if (iR == -1) {
                return 0;
            }
            return iR;
        }
        return 0;
    }

    @Nullable
    public final synchronized o1 z() {
        return this.f30725y ? null : this.B;
    }
}

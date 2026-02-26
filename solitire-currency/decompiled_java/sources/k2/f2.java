package k2;

import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.exoplayer.MediaPeriodQueue;
import com.google.common.collect.y;
import k2.n3;
import l3.a0;

/* JADX INFO: compiled from: MediaPeriodQueue.java */
/* JADX INFO: loaded from: classes2.dex */
final class f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n3.b f29096a = new n3.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n3.d f29097b = new n3.d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l2.a f29098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f29099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f29100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f29101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f29102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private c2 f29103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private c2 f29104i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private c2 f29105j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f29106k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private Object f29107l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f29108m;

    public f2(l2.a aVar, Handler handler) {
        this.f29098c = aVar;
        this.f29099d = handler;
    }

    private static a0.b A(n3 n3Var, Object obj, long j10, long j11, n3.d dVar, n3.b bVar) {
        n3Var.l(obj, bVar);
        n3Var.r(bVar.f29300c, dVar);
        int iF = n3Var.f(obj);
        Object objE = obj;
        while (bVar.f29301d == 0 && bVar.f() > 0 && bVar.t(bVar.r()) && bVar.h(0L) == -1) {
            int i10 = iF + 1;
            if (iF >= dVar.f29328p) {
                break;
            }
            n3Var.k(i10, bVar, true);
            objE = a4.a.e(bVar.f29299b);
            iF = i10;
        }
        n3Var.l(objE, bVar);
        int iH = bVar.h(j10);
        return iH == -1 ? new a0.b(objE, j11, bVar.g(j10)) : new a0.b(objE, iH, bVar.n(iH), j11);
    }

    private long C(n3 n3Var, Object obj) {
        int iF;
        int i10 = n3Var.l(obj, this.f29096a).f29300c;
        Object obj2 = this.f29107l;
        if (obj2 != null && (iF = n3Var.f(obj2)) != -1 && n3Var.j(iF, this.f29096a).f29300c == i10) {
            return this.f29108m;
        }
        for (c2 c2VarJ = this.f29103h; c2VarJ != null; c2VarJ = c2VarJ.j()) {
            if (c2VarJ.f29036b.equals(obj)) {
                return c2VarJ.f29040f.f29065a.f30781d;
            }
        }
        for (c2 c2VarJ2 = this.f29103h; c2VarJ2 != null; c2VarJ2 = c2VarJ2.j()) {
            int iF2 = n3Var.f(c2VarJ2.f29036b);
            if (iF2 != -1 && n3Var.j(iF2, this.f29096a).f29300c == i10) {
                return c2VarJ2.f29040f.f29065a.f30781d;
            }
        }
        long j10 = this.f29100e;
        this.f29100e = 1 + j10;
        if (this.f29103h == null) {
            this.f29107l = obj;
            this.f29108m = j10;
        }
        return j10;
    }

    private boolean E(n3 n3Var) {
        c2 c2VarJ = this.f29103h;
        if (c2VarJ == null) {
            return true;
        }
        int iF = n3Var.f(c2VarJ.f29036b);
        while (true) {
            iF = n3Var.h(iF, this.f29096a, this.f29097b, this.f29101f, this.f29102g);
            while (c2VarJ.j() != null && !c2VarJ.f29040f.f29071g) {
                c2VarJ = c2VarJ.j();
            }
            c2 c2VarJ2 = c2VarJ.j();
            if (iF == -1 || c2VarJ2 == null || n3Var.f(c2VarJ2.f29036b) != iF) {
                break;
            }
            c2VarJ = c2VarJ2;
        }
        boolean z10 = z(c2VarJ);
        c2VarJ.f29040f = r(n3Var, c2VarJ.f29040f);
        return !z10;
    }

    private boolean d(long j10, long j11) {
        return j10 == C.TIME_UNSET || j10 == j11;
    }

    private boolean e(d2 d2Var, d2 d2Var2) {
        return d2Var.f29066b == d2Var2.f29066b && d2Var.f29065a.equals(d2Var2.f29065a);
    }

    @Nullable
    private d2 h(o2 o2Var) {
        return k(o2Var.f29389a, o2Var.f29390b, o2Var.f29391c, o2Var.f29406r);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e3  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private k2.d2 i(k2.n3 r20, k2.c2 r21, long r22) {
        /*
            Method dump skipped, instruction units count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.f2.i(k2.n3, k2.c2, long):k2.d2");
    }

    @Nullable
    private d2 k(n3 n3Var, a0.b bVar, long j10, long j11) {
        n3Var.l(bVar.f30778a, this.f29096a);
        return bVar.b() ? l(n3Var, bVar.f30778a, bVar.f30779b, bVar.f30780c, j10, bVar.f30781d) : m(n3Var, bVar.f30778a, j11, j10, bVar.f30781d);
    }

    private d2 l(n3 n3Var, Object obj, int i10, int i11, long j10, long j11) {
        a0.b bVar = new a0.b(obj, i10, i11, j11);
        long jE = n3Var.l(bVar.f30778a, this.f29096a).e(bVar.f30779b, bVar.f30780c);
        long j12 = i11 == this.f29096a.n(i10) ? this.f29096a.j() : 0L;
        return new d2(bVar, (jE == C.TIME_UNSET || j12 < jE) ? j12 : Math.max(0L, jE - 1), j10, C.TIME_UNSET, jE, this.f29096a.t(bVar.f30779b), false, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private k2.d2 m(k2.n3 r25, java.lang.Object r26, long r27, long r29, long r31) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            r3 = r27
            k2.n3$b r5 = r0.f29096a
            r1.l(r2, r5)
            k2.n3$b r5 = r0.f29096a
            int r5 = r5.g(r3)
            r6 = 1
            r7 = 0
            r8 = -1
            if (r5 != r8) goto L2e
            k2.n3$b r9 = r0.f29096a
            int r9 = r9.f()
            if (r9 <= 0) goto L4d
            k2.n3$b r9 = r0.f29096a
            int r10 = r9.r()
            boolean r9 = r9.t(r10)
            if (r9 == 0) goto L4d
            r9 = r6
            goto L4e
        L2e:
            k2.n3$b r9 = r0.f29096a
            boolean r9 = r9.t(r5)
            if (r9 == 0) goto L4d
            k2.n3$b r9 = r0.f29096a
            long r9 = r9.i(r5)
            k2.n3$b r11 = r0.f29096a
            long r12 = r11.f29301d
            int r9 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r9 != 0) goto L4d
            boolean r9 = r11.s(r5)
            if (r9 == 0) goto L4d
            r9 = r6
            r5 = r8
            goto L4e
        L4d:
            r9 = r7
        L4e:
            l3.a0$b r11 = new l3.a0$b
            r12 = r31
            r11.<init>(r2, r12, r5)
            boolean r2 = r0.s(r11)
            boolean r22 = r0.u(r1, r11)
            boolean r23 = r0.t(r1, r11, r2)
            if (r5 == r8) goto L6e
            k2.n3$b r1 = r0.f29096a
            boolean r1 = r1.t(r5)
            if (r1 == 0) goto L6e
            r20 = r6
            goto L70
        L6e:
            r20 = r7
        L70:
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r5 == r8) goto L80
            k2.n3$b r1 = r0.f29096a
            long r14 = r1.i(r5)
        L7d:
            r16 = r14
            goto L89
        L80:
            if (r9 == 0) goto L87
            k2.n3$b r1 = r0.f29096a
            long r14 = r1.f29301d
            goto L7d
        L87:
            r16 = r12
        L89:
            int r1 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1))
            if (r1 == 0) goto L97
            r14 = -9223372036854775808
            int r1 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r1 != 0) goto L94
            goto L97
        L94:
            r18 = r16
            goto L9d
        L97:
            k2.n3$b r1 = r0.f29096a
            long r14 = r1.f29301d
            r18 = r14
        L9d:
            int r1 = (r18 > r12 ? 1 : (r18 == r12 ? 0 : -1))
            if (r1 == 0) goto Lb4
            int r1 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r1 < 0) goto Lb4
            if (r23 != 0) goto Lab
            if (r9 != 0) goto Laa
            goto Lab
        Laa:
            r6 = r7
        Lab:
            long r3 = (long) r6
            long r3 = r18 - r3
            r5 = 0
            long r3 = java.lang.Math.max(r5, r3)
        Lb4:
            r12 = r3
            k2.d2 r1 = new k2.d2
            r10 = r1
            r14 = r29
            r21 = r2
            r10.<init>(r11, r12, r14, r16, r18, r20, r21, r22, r23)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.f2.m(k2.n3, java.lang.Object, long, long, long):k2.d2");
    }

    private long n(n3 n3Var, Object obj, int i10) {
        n3Var.l(obj, this.f29096a);
        long jI = this.f29096a.i(i10);
        return jI == Long.MIN_VALUE ? this.f29096a.f29301d : jI + this.f29096a.l(i10);
    }

    private boolean s(a0.b bVar) {
        return !bVar.b() && bVar.f30782e == -1;
    }

    private boolean t(n3 n3Var, a0.b bVar, boolean z10) {
        int iF = n3Var.f(bVar.f30778a);
        return !n3Var.r(n3Var.j(iF, this.f29096a).f29300c, this.f29097b).f29321i && n3Var.v(iF, this.f29096a, this.f29097b, this.f29101f, this.f29102g) && z10;
    }

    private boolean u(n3 n3Var, a0.b bVar) {
        if (s(bVar)) {
            return n3Var.r(n3Var.l(bVar.f30778a, this.f29096a).f29300c, this.f29097b).f29328p == n3Var.f(bVar.f30778a);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(y.a aVar, a0.b bVar) {
        this.f29098c.r(aVar.k(), bVar);
    }

    private void x() {
        final y.a aVarK = com.google.common.collect.y.k();
        for (c2 c2VarJ = this.f29103h; c2VarJ != null; c2VarJ = c2VarJ.j()) {
            aVarK.a(c2VarJ.f29040f.f29065a);
        }
        c2 c2Var = this.f29104i;
        final a0.b bVar = c2Var == null ? null : c2Var.f29040f.f29065a;
        this.f29099d.post(new Runnable() { // from class: k2.e2
            @Override // java.lang.Runnable
            public final void run() {
                this.f29079a.w(aVarK, bVar);
            }
        });
    }

    public a0.b B(n3 n3Var, Object obj, long j10) {
        long jC = C(n3Var, obj);
        n3Var.l(obj, this.f29096a);
        n3Var.r(this.f29096a.f29300c, this.f29097b);
        boolean z10 = false;
        for (int iF = n3Var.f(obj); iF >= this.f29097b.f29327o; iF--) {
            n3Var.k(iF, this.f29096a, true);
            boolean z11 = this.f29096a.f() > 0;
            z10 |= z11;
            n3.b bVar = this.f29096a;
            if (bVar.h(bVar.f29301d) != -1) {
                obj = a4.a.e(this.f29096a.f29299b);
            }
            if (z10 && (!z11 || this.f29096a.f29301d != 0)) {
                break;
            }
        }
        return A(n3Var, obj, j10, jC, this.f29097b, this.f29096a);
    }

    public boolean D() {
        c2 c2Var = this.f29105j;
        return c2Var == null || (!c2Var.f29040f.f29073i && c2Var.q() && this.f29105j.f29040f.f29069e != C.TIME_UNSET && this.f29106k < 100);
    }

    public boolean F(n3 n3Var, long j10, long j11) {
        d2 d2VarR;
        c2 c2VarJ = this.f29103h;
        c2 c2Var = null;
        while (c2VarJ != null) {
            d2 d2Var = c2VarJ.f29040f;
            if (c2Var == null) {
                d2VarR = r(n3Var, d2Var);
            } else {
                d2 d2VarI = i(n3Var, c2Var, j10);
                if (d2VarI == null) {
                    return !z(c2Var);
                }
                if (!e(d2Var, d2VarI)) {
                    return !z(c2Var);
                }
                d2VarR = d2VarI;
            }
            c2VarJ.f29040f = d2VarR.a(d2Var.f29067c);
            if (!d(d2Var.f29069e, d2VarR.f29069e)) {
                c2VarJ.A();
                long j12 = d2VarR.f29069e;
                return (z(c2VarJ) || (c2VarJ == this.f29104i && !c2VarJ.f29040f.f29070f && ((j11 > Long.MIN_VALUE ? 1 : (j11 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j11 > ((j12 > C.TIME_UNSET ? 1 : (j12 == C.TIME_UNSET ? 0 : -1)) == 0 ? Long.MAX_VALUE : c2VarJ.z(j12)) ? 1 : (j11 == ((j12 > C.TIME_UNSET ? 1 : (j12 == C.TIME_UNSET ? 0 : -1)) == 0 ? Long.MAX_VALUE : c2VarJ.z(j12)) ? 0 : -1)) >= 0))) ? false : true;
            }
            c2Var = c2VarJ;
            c2VarJ = c2VarJ.j();
        }
        return true;
    }

    public boolean G(n3 n3Var, int i10) {
        this.f29101f = i10;
        return E(n3Var);
    }

    public boolean H(n3 n3Var, boolean z10) {
        this.f29102g = z10;
        return E(n3Var);
    }

    @Nullable
    public c2 b() {
        c2 c2Var = this.f29103h;
        if (c2Var == null) {
            return null;
        }
        if (c2Var == this.f29104i) {
            this.f29104i = c2Var.j();
        }
        this.f29103h.t();
        int i10 = this.f29106k - 1;
        this.f29106k = i10;
        if (i10 == 0) {
            this.f29105j = null;
            c2 c2Var2 = this.f29103h;
            this.f29107l = c2Var2.f29036b;
            this.f29108m = c2Var2.f29040f.f29065a.f30781d;
        }
        this.f29103h = this.f29103h.j();
        x();
        return this.f29103h;
    }

    public c2 c() {
        c2 c2Var = this.f29104i;
        a4.a.g((c2Var == null || c2Var.j() == null) ? false : true);
        this.f29104i = this.f29104i.j();
        x();
        return this.f29104i;
    }

    public void f() {
        if (this.f29106k == 0) {
            return;
        }
        c2 c2VarJ = (c2) a4.a.i(this.f29103h);
        this.f29107l = c2VarJ.f29036b;
        this.f29108m = c2VarJ.f29040f.f29065a.f30781d;
        while (c2VarJ != null) {
            c2VarJ.t();
            c2VarJ = c2VarJ.j();
        }
        this.f29103h = null;
        this.f29105j = null;
        this.f29104i = null;
        this.f29106k = 0;
        x();
    }

    public c2 g(c3[] c3VarArr, x3.b0 b0Var, z3.b bVar, i2 i2Var, d2 d2Var, x3.c0 c0Var) {
        c2 c2Var = this.f29105j;
        c2 c2Var2 = new c2(c3VarArr, c2Var == null ? MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US : (c2Var.l() + this.f29105j.f29040f.f29069e) - d2Var.f29066b, b0Var, bVar, i2Var, d2Var, c0Var);
        c2 c2Var3 = this.f29105j;
        if (c2Var3 != null) {
            c2Var3.w(c2Var2);
        } else {
            this.f29103h = c2Var2;
            this.f29104i = c2Var2;
        }
        this.f29107l = null;
        this.f29105j = c2Var2;
        this.f29106k++;
        x();
        return c2Var2;
    }

    @Nullable
    public c2 j() {
        return this.f29105j;
    }

    @Nullable
    public d2 o(long j10, o2 o2Var) {
        c2 c2Var = this.f29105j;
        return c2Var == null ? h(o2Var) : i(o2Var.f29389a, c2Var, j10);
    }

    @Nullable
    public c2 p() {
        return this.f29103h;
    }

    @Nullable
    public c2 q() {
        return this.f29104i;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public k2.d2 r(k2.n3 r19, k2.d2 r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            l3.a0$b r3 = r2.f29065a
            boolean r12 = r0.s(r3)
            boolean r13 = r0.u(r1, r3)
            boolean r14 = r0.t(r1, r3, r12)
            l3.a0$b r4 = r2.f29065a
            java.lang.Object r4 = r4.f30778a
            k2.n3$b r5 = r0.f29096a
            r1.l(r4, r5)
            boolean r1 = r3.b()
            r4 = -1
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L35
            int r1 = r3.f30782e
            if (r1 != r4) goto L2e
            goto L35
        L2e:
            k2.n3$b r7 = r0.f29096a
            long r7 = r7.i(r1)
            goto L36
        L35:
            r7 = r5
        L36:
            boolean r1 = r3.b()
            if (r1 == 0) goto L48
            k2.n3$b r1 = r0.f29096a
            int r5 = r3.f30779b
            int r6 = r3.f30780c
            long r5 = r1.e(r5, r6)
        L46:
            r9 = r5
            goto L5c
        L48:
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 == 0) goto L55
            r5 = -9223372036854775808
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 != 0) goto L53
            goto L55
        L53:
            r9 = r7
            goto L5c
        L55:
            k2.n3$b r1 = r0.f29096a
            long r5 = r1.m()
            goto L46
        L5c:
            boolean r1 = r3.b()
            if (r1 == 0) goto L6c
            k2.n3$b r1 = r0.f29096a
            int r4 = r3.f30779b
            boolean r1 = r1.t(r4)
        L6a:
            r11 = r1
            goto L7c
        L6c:
            int r1 = r3.f30782e
            if (r1 == r4) goto L7a
            k2.n3$b r4 = r0.f29096a
            boolean r1 = r4.t(r1)
            if (r1 == 0) goto L7a
            r1 = 1
            goto L6a
        L7a:
            r1 = 0
            goto L6a
        L7c:
            k2.d2 r15 = new k2.d2
            long r4 = r2.f29066b
            long r1 = r2.f29067c
            r16 = r1
            r1 = r15
            r2 = r3
            r3 = r4
            r5 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.f2.r(k2.n3, k2.d2):k2.d2");
    }

    public boolean v(l3.x xVar) {
        c2 c2Var = this.f29105j;
        return c2Var != null && c2Var.f29035a == xVar;
    }

    public void y(long j10) {
        c2 c2Var = this.f29105j;
        if (c2Var != null) {
            c2Var.s(j10);
        }
    }

    public boolean z(c2 c2Var) {
        boolean z10 = false;
        a4.a.g(c2Var != null);
        if (c2Var.equals(this.f29105j)) {
            return false;
        }
        this.f29105j = c2Var;
        while (c2Var.j() != null) {
            c2Var = c2Var.j();
            if (c2Var == this.f29104i) {
                this.f29104i = this.f29103h;
                z10 = true;
            }
            c2Var.t();
            this.f29106k--;
        }
        this.f29105j.w(null);
        x();
        return z10;
    }
}

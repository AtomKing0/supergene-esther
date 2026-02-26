package k2;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import l3.a0;

/* JADX INFO: compiled from: MediaPeriodHolder.java */
/* JADX INFO: loaded from: classes2.dex */
final class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l3.x f29035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f29036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l3.u0[] f29037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f29038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f29039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d2 f29040f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f29041g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean[] f29042h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final c3[] f29043i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final x3.b0 f29044j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final i2 f29045k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private c2 f29046l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private l3.e1 f29047m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private x3.c0 f29048n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f29049o;

    public c2(c3[] c3VarArr, long j10, x3.b0 b0Var, z3.b bVar, i2 i2Var, d2 d2Var, x3.c0 c0Var) {
        this.f29043i = c3VarArr;
        this.f29049o = j10;
        this.f29044j = b0Var;
        this.f29045k = i2Var;
        a0.b bVar2 = d2Var.f29065a;
        this.f29036b = bVar2.f30778a;
        this.f29040f = d2Var;
        this.f29047m = l3.e1.f30515d;
        this.f29048n = c0Var;
        this.f29037c = new l3.u0[c3VarArr.length];
        this.f29042h = new boolean[c3VarArr.length];
        this.f29035a = e(bVar2, i2Var, bVar, d2Var.f29066b, d2Var.f29068d);
    }

    private void c(l3.u0[] u0VarArr) {
        int i10 = 0;
        while (true) {
            c3[] c3VarArr = this.f29043i;
            if (i10 >= c3VarArr.length) {
                return;
            }
            if (c3VarArr[i10].getTrackType() == -2 && this.f29048n.c(i10)) {
                u0VarArr[i10] = new l3.q();
            }
            i10++;
        }
    }

    private static l3.x e(a0.b bVar, i2 i2Var, z3.b bVar2, long j10, long j11) {
        l3.x xVarH = i2Var.h(bVar, bVar2, j10);
        return j11 != C.TIME_UNSET ? new l3.c(xVarH, true, 0L, j11) : xVarH;
    }

    private void f() {
        if (!r()) {
            return;
        }
        int i10 = 0;
        while (true) {
            x3.c0 c0Var = this.f29048n;
            if (i10 >= c0Var.f35933a) {
                return;
            }
            boolean zC = c0Var.c(i10);
            x3.s sVar = this.f29048n.f35935c[i10];
            if (zC && sVar != null) {
                sVar.disable();
            }
            i10++;
        }
    }

    private void g(l3.u0[] u0VarArr) {
        int i10 = 0;
        while (true) {
            c3[] c3VarArr = this.f29043i;
            if (i10 >= c3VarArr.length) {
                return;
            }
            if (c3VarArr[i10].getTrackType() == -2) {
                u0VarArr[i10] = null;
            }
            i10++;
        }
    }

    private void h() {
        if (!r()) {
            return;
        }
        int i10 = 0;
        while (true) {
            x3.c0 c0Var = this.f29048n;
            if (i10 >= c0Var.f35933a) {
                return;
            }
            boolean zC = c0Var.c(i10);
            x3.s sVar = this.f29048n.f35935c[i10];
            if (zC && sVar != null) {
                sVar.enable();
            }
            i10++;
        }
    }

    private boolean r() {
        return this.f29046l == null;
    }

    private static void u(i2 i2Var, l3.x xVar) {
        try {
            if (xVar instanceof l3.c) {
                i2Var.z(((l3.c) xVar).f30468a);
            } else {
                i2Var.z(xVar);
            }
        } catch (RuntimeException e10) {
            a4.t.d("MediaPeriodHolder", "Period release failed.", e10);
        }
    }

    public void A() {
        l3.x xVar = this.f29035a;
        if (xVar instanceof l3.c) {
            long j10 = this.f29040f.f29068d;
            if (j10 == C.TIME_UNSET) {
                j10 = Long.MIN_VALUE;
            }
            ((l3.c) xVar).l(0L, j10);
        }
    }

    public long a(x3.c0 c0Var, long j10, boolean z10) {
        return b(c0Var, j10, z10, new boolean[this.f29043i.length]);
    }

    public long b(x3.c0 c0Var, long j10, boolean z10, boolean[] zArr) {
        int i10 = 0;
        while (true) {
            boolean z11 = true;
            if (i10 >= c0Var.f35933a) {
                break;
            }
            boolean[] zArr2 = this.f29042h;
            if (z10 || !c0Var.b(this.f29048n, i10)) {
                z11 = false;
            }
            zArr2[i10] = z11;
            i10++;
        }
        g(this.f29037c);
        f();
        this.f29048n = c0Var;
        h();
        long jG = this.f29035a.g(c0Var.f35935c, this.f29042h, this.f29037c, zArr, j10);
        c(this.f29037c);
        this.f29039e = false;
        int i11 = 0;
        while (true) {
            l3.u0[] u0VarArr = this.f29037c;
            if (i11 >= u0VarArr.length) {
                return jG;
            }
            if (u0VarArr[i11] != null) {
                a4.a.g(c0Var.c(i11));
                if (this.f29043i[i11].getTrackType() != -2) {
                    this.f29039e = true;
                }
            } else {
                a4.a.g(c0Var.f35935c[i11] == null);
            }
            i11++;
        }
    }

    public void d(long j10) {
        a4.a.g(r());
        this.f29035a.a(y(j10));
    }

    public long i() {
        if (!this.f29038d) {
            return this.f29040f.f29066b;
        }
        long bufferedPositionUs = this.f29039e ? this.f29035a.getBufferedPositionUs() : Long.MIN_VALUE;
        return bufferedPositionUs == Long.MIN_VALUE ? this.f29040f.f29069e : bufferedPositionUs;
    }

    @Nullable
    public c2 j() {
        return this.f29046l;
    }

    public long k() {
        if (this.f29038d) {
            return this.f29035a.getNextLoadPositionUs();
        }
        return 0L;
    }

    public long l() {
        return this.f29049o;
    }

    public long m() {
        return this.f29040f.f29066b + this.f29049o;
    }

    public l3.e1 n() {
        return this.f29047m;
    }

    public x3.c0 o() {
        return this.f29048n;
    }

    public void p(float f10, n3 n3Var) throws q {
        this.f29038d = true;
        this.f29047m = this.f29035a.getTrackGroups();
        x3.c0 c0VarV = v(f10, n3Var);
        d2 d2Var = this.f29040f;
        long jMax = d2Var.f29066b;
        long j10 = d2Var.f29069e;
        if (j10 != C.TIME_UNSET && jMax >= j10) {
            jMax = Math.max(0L, j10 - 1);
        }
        long jA = a(c0VarV, jMax, false);
        long j11 = this.f29049o;
        d2 d2Var2 = this.f29040f;
        this.f29049o = j11 + (d2Var2.f29066b - jA);
        this.f29040f = d2Var2.b(jA);
    }

    public boolean q() {
        return this.f29038d && (!this.f29039e || this.f29035a.getBufferedPositionUs() == Long.MIN_VALUE);
    }

    public void s(long j10) {
        a4.a.g(r());
        if (this.f29038d) {
            this.f29035a.reevaluateBuffer(y(j10));
        }
    }

    public void t() {
        f();
        u(this.f29045k, this.f29035a);
    }

    public x3.c0 v(float f10, n3 n3Var) throws q {
        x3.c0 c0VarH = this.f29044j.h(this.f29043i, n(), this.f29040f.f29065a, n3Var);
        for (x3.s sVar : c0VarH.f35935c) {
            if (sVar != null) {
                sVar.onPlaybackSpeed(f10);
            }
        }
        return c0VarH;
    }

    public void w(@Nullable c2 c2Var) {
        if (c2Var == this.f29046l) {
            return;
        }
        f();
        this.f29046l = c2Var;
        h();
    }

    public void x(long j10) {
        this.f29049o = j10;
    }

    public long y(long j10) {
        return j10 - l();
    }

    public long z(long j10) {
        return j10 + l();
    }
}

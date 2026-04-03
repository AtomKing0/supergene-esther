package z2;

import a4.o0;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import k2.o1;
import m2.b;
import z2.i0;

/* JADX INFO: compiled from: Ac3Reader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a4.b0 f37024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a4.c0 f37025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final String f37026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f37027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private p2.e0 f37028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f37029f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f37030g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f37031h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f37032i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private o1 f37033j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f37034k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f37035l;

    public c() {
        this(null);
    }

    private boolean d(a4.c0 c0Var, byte[] bArr, int i10) {
        int iMin = Math.min(c0Var.a(), i10 - this.f37030g);
        c0Var.j(bArr, this.f37030g, iMin);
        int i11 = this.f37030g + iMin;
        this.f37030g = i11;
        return i11 == i10;
    }

    private void e() {
        this.f37024a.p(0);
        b.C0627b c0627bE = m2.b.e(this.f37024a);
        o1 o1Var = this.f37033j;
        if (o1Var == null || c0627bE.f31158d != o1Var.f29360y || c0627bE.f31157c != o1Var.f29361z || !o0.c(c0627bE.f31155a, o1Var.f29347l)) {
            o1 o1VarE = new o1.b().S(this.f37027d).e0(c0627bE.f31155a).H(c0627bE.f31158d).f0(c0627bE.f31157c).V(this.f37026c).E();
            this.f37033j = o1VarE;
            this.f37028e.f(o1VarE);
        }
        this.f37034k = c0627bE.f31159e;
        this.f37032i = (((long) c0627bE.f31160f) * 1000000) / ((long) this.f37033j.f29361z);
    }

    private boolean f(a4.c0 c0Var) {
        while (true) {
            if (c0Var.a() <= 0) {
                return false;
            }
            if (this.f37031h) {
                int iD = c0Var.D();
                if (iD == 119) {
                    this.f37031h = false;
                    return true;
                }
                this.f37031h = iD == 11;
            } else {
                this.f37031h = c0Var.D() == 11;
            }
        }
    }

    @Override // z2.m
    public void a(a4.c0 c0Var) {
        a4.a.i(this.f37028e);
        while (c0Var.a() > 0) {
            int i10 = this.f37029f;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        int iMin = Math.min(c0Var.a(), this.f37034k - this.f37030g);
                        this.f37028e.e(c0Var, iMin);
                        int i11 = this.f37030g + iMin;
                        this.f37030g = i11;
                        int i12 = this.f37034k;
                        if (i11 == i12) {
                            long j10 = this.f37035l;
                            if (j10 != C.TIME_UNSET) {
                                this.f37028e.a(j10, 1, i12, 0, null);
                                this.f37035l += this.f37032i;
                            }
                            this.f37029f = 0;
                        }
                    }
                } else if (d(c0Var, this.f37025b.d(), 128)) {
                    e();
                    this.f37025b.P(0);
                    this.f37028e.e(this.f37025b, 128);
                    this.f37029f = 2;
                }
            } else if (f(c0Var)) {
                this.f37029f = 1;
                this.f37025b.d()[0] = 11;
                this.f37025b.d()[1] = 119;
                this.f37030g = 2;
            }
        }
    }

    @Override // z2.m
    public void c(p2.n nVar, i0.d dVar) {
        dVar.a();
        this.f37027d = dVar.b();
        this.f37028e = nVar.track(dVar.c(), 1);
    }

    @Override // z2.m
    public void packetStarted(long j10, int i10) {
        if (j10 != C.TIME_UNSET) {
            this.f37035l = j10;
        }
    }

    @Override // z2.m
    public void seek() {
        this.f37029f = 0;
        this.f37030g = 0;
        this.f37031h = false;
        this.f37035l = C.TIME_UNSET;
    }

    public c(@Nullable String str) {
        a4.b0 b0Var = new a4.b0(new byte[128]);
        this.f37024a = b0Var;
        this.f37025b = new a4.c0(b0Var.f141a);
        this.f37029f = 0;
        this.f37035l = C.TIME_UNSET;
        this.f37026c = str;
    }

    @Override // z2.m
    public void b() {
    }
}

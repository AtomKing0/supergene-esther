package z2;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import java.util.Collections;
import k2.j2;
import k2.o1;
import m2.a;
import z2.i0;

/* JADX INFO: compiled from: LatmReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f37299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a4.c0 f37300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a4.b0 f37301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private p2.e0 f37302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f37303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private o1 f37304f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f37305g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f37306h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f37307i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f37308j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f37309k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f37310l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f37311m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f37312n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f37313o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f37314p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f37315q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f37316r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f37317s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f37318t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private String f37319u;

    public s(@Nullable String str) {
        this.f37299a = str;
        a4.c0 c0Var = new a4.c0(1024);
        this.f37300b = c0Var;
        this.f37301c = new a4.b0(c0Var.d());
        this.f37309k = C.TIME_UNSET;
    }

    private static long d(a4.b0 b0Var) {
        return b0Var.h((b0Var.h(2) + 1) * 8);
    }

    private void e(a4.b0 b0Var) throws j2 {
        if (!b0Var.g()) {
            this.f37310l = true;
            j(b0Var);
        } else if (!this.f37310l) {
            return;
        }
        if (this.f37311m != 0) {
            throw j2.a(null, null);
        }
        if (this.f37312n != 0) {
            throw j2.a(null, null);
        }
        i(b0Var, h(b0Var));
        if (this.f37314p) {
            b0Var.r((int) this.f37315q);
        }
    }

    private int f(a4.b0 b0Var) throws j2 {
        int iB = b0Var.b();
        a.b bVarD = m2.a.d(b0Var, true);
        this.f37319u = bVarD.f31146c;
        this.f37316r = bVarD.f31144a;
        this.f37318t = bVarD.f31145b;
        return iB - b0Var.b();
    }

    private void g(a4.b0 b0Var) {
        int iH = b0Var.h(3);
        this.f37313o = iH;
        if (iH == 0) {
            b0Var.r(8);
            return;
        }
        if (iH == 1) {
            b0Var.r(9);
            return;
        }
        if (iH == 3 || iH == 4 || iH == 5) {
            b0Var.r(6);
        } else {
            if (iH != 6 && iH != 7) {
                throw new IllegalStateException();
            }
            b0Var.r(1);
        }
    }

    private int h(a4.b0 b0Var) throws j2 {
        int iH;
        if (this.f37313o != 0) {
            throw j2.a(null, null);
        }
        int i10 = 0;
        do {
            iH = b0Var.h(8);
            i10 += iH;
        } while (iH == 255);
        return i10;
    }

    private void i(a4.b0 b0Var, int i10) {
        int iE = b0Var.e();
        if ((iE & 7) == 0) {
            this.f37300b.P(iE >> 3);
        } else {
            b0Var.i(this.f37300b.d(), 0, i10 * 8);
            this.f37300b.P(0);
        }
        this.f37302d.e(this.f37300b, i10);
        long j10 = this.f37309k;
        if (j10 != C.TIME_UNSET) {
            this.f37302d.a(j10, 1, i10, 0, null);
            this.f37309k += this.f37317s;
        }
    }

    private void j(a4.b0 b0Var) throws j2 {
        boolean zG;
        int iH = b0Var.h(1);
        int iH2 = iH == 1 ? b0Var.h(1) : 0;
        this.f37311m = iH2;
        if (iH2 != 0) {
            throw j2.a(null, null);
        }
        if (iH == 1) {
            d(b0Var);
        }
        if (!b0Var.g()) {
            throw j2.a(null, null);
        }
        this.f37312n = b0Var.h(6);
        int iH3 = b0Var.h(4);
        int iH4 = b0Var.h(3);
        if (iH3 != 0 || iH4 != 0) {
            throw j2.a(null, null);
        }
        if (iH == 0) {
            int iE = b0Var.e();
            int iF = f(b0Var);
            b0Var.p(iE);
            byte[] bArr = new byte[(iF + 7) / 8];
            b0Var.i(bArr, 0, iF);
            o1 o1VarE = new o1.b().S(this.f37303e).e0(MimeTypes.AUDIO_AAC).I(this.f37319u).H(this.f37318t).f0(this.f37316r).T(Collections.singletonList(bArr)).V(this.f37299a).E();
            if (!o1VarE.equals(this.f37304f)) {
                this.f37304f = o1VarE;
                this.f37317s = 1024000000 / ((long) o1VarE.f29361z);
                this.f37302d.f(o1VarE);
            }
        } else {
            b0Var.r(((int) d(b0Var)) - f(b0Var));
        }
        g(b0Var);
        boolean zG2 = b0Var.g();
        this.f37314p = zG2;
        this.f37315q = 0L;
        if (zG2) {
            if (iH == 1) {
                this.f37315q = d(b0Var);
            } else {
                do {
                    zG = b0Var.g();
                    this.f37315q = (this.f37315q << 8) + ((long) b0Var.h(8));
                } while (zG);
            }
        }
        if (b0Var.g()) {
            b0Var.r(8);
        }
    }

    private void k(int i10) {
        this.f37300b.L(i10);
        this.f37301c.n(this.f37300b.d());
    }

    @Override // z2.m
    public void a(a4.c0 c0Var) throws j2 {
        a4.a.i(this.f37302d);
        while (c0Var.a() > 0) {
            int i10 = this.f37305g;
            if (i10 != 0) {
                if (i10 == 1) {
                    int iD = c0Var.D();
                    if ((iD & 224) == 224) {
                        this.f37308j = iD;
                        this.f37305g = 2;
                    } else if (iD != 86) {
                        this.f37305g = 0;
                    }
                } else if (i10 == 2) {
                    int iD2 = ((this.f37308j & (-225)) << 8) | c0Var.D();
                    this.f37307i = iD2;
                    if (iD2 > this.f37300b.d().length) {
                        k(this.f37307i);
                    }
                    this.f37306h = 0;
                    this.f37305g = 3;
                } else {
                    if (i10 != 3) {
                        throw new IllegalStateException();
                    }
                    int iMin = Math.min(c0Var.a(), this.f37307i - this.f37306h);
                    c0Var.j(this.f37301c.f141a, this.f37306h, iMin);
                    int i11 = this.f37306h + iMin;
                    this.f37306h = i11;
                    if (i11 == this.f37307i) {
                        this.f37301c.p(0);
                        e(this.f37301c);
                        this.f37305g = 0;
                    }
                }
            } else if (c0Var.D() == 86) {
                this.f37305g = 1;
            }
        }
    }

    @Override // z2.m
    public void c(p2.n nVar, i0.d dVar) {
        dVar.a();
        this.f37302d = nVar.track(dVar.c(), 1);
        this.f37303e = dVar.b();
    }

    @Override // z2.m
    public void packetStarted(long j10, int i10) {
        if (j10 != C.TIME_UNSET) {
            this.f37309k = j10;
        }
    }

    @Override // z2.m
    public void seek() {
        this.f37305g = 0;
        this.f37309k = C.TIME_UNSET;
        this.f37310l = false;
    }

    @Override // z2.m
    public void b() {
    }
}

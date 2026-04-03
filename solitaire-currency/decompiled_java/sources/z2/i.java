package z2;

import a4.o0;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import java.util.Arrays;
import java.util.Collections;
import k2.j2;
import k2.o1;
import m2.a;
import z2.i0;

/* JADX INFO: compiled from: AdtsReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements m {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final byte[] f37114v = {73, 68, 51};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f37115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a4.b0 f37116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a4.c0 f37117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final String f37118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f37119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private p2.e0 f37120f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private p2.e0 f37121g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f37122h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f37123i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f37124j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f37125k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f37126l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f37127m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f37128n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f37129o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f37130p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f37131q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f37132r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f37133s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private p2.e0 f37134t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f37135u;

    public i(boolean z10) {
        this(z10, null);
    }

    private void d() {
        a4.a.e(this.f37120f);
        o0.j(this.f37134t);
        o0.j(this.f37121g);
    }

    private void e(a4.c0 c0Var) {
        if (c0Var.a() == 0) {
            return;
        }
        this.f37116b.f141a[0] = c0Var.d()[c0Var.e()];
        this.f37116b.p(2);
        int iH = this.f37116b.h(4);
        int i10 = this.f37128n;
        if (i10 != -1 && iH != i10) {
            o();
            return;
        }
        if (!this.f37126l) {
            this.f37126l = true;
            this.f37127m = this.f37129o;
            this.f37128n = iH;
        }
        r();
    }

    private boolean f(a4.c0 c0Var, int i10) {
        c0Var.P(i10 + 1);
        if (!u(c0Var, this.f37116b.f141a, 1)) {
            return false;
        }
        this.f37116b.p(4);
        int iH = this.f37116b.h(1);
        int i11 = this.f37127m;
        if (i11 != -1 && iH != i11) {
            return false;
        }
        if (this.f37128n != -1) {
            if (!u(c0Var, this.f37116b.f141a, 1)) {
                return true;
            }
            this.f37116b.p(2);
            if (this.f37116b.h(4) != this.f37128n) {
                return false;
            }
            c0Var.P(i10 + 2);
        }
        if (!u(c0Var, this.f37116b.f141a, 4)) {
            return true;
        }
        this.f37116b.p(14);
        int iH2 = this.f37116b.h(13);
        if (iH2 < 7) {
            return false;
        }
        byte[] bArrD = c0Var.d();
        int iF = c0Var.f();
        int i12 = i10 + iH2;
        if (i12 >= iF) {
            return true;
        }
        byte b10 = bArrD[i12];
        if (b10 == -1) {
            int i13 = i12 + 1;
            if (i13 == iF) {
                return true;
            }
            return j((byte) -1, bArrD[i13]) && ((bArrD[i13] & 8) >> 3) == iH;
        }
        if (b10 != 73) {
            return false;
        }
        int i14 = i12 + 1;
        if (i14 == iF) {
            return true;
        }
        if (bArrD[i14] != 68) {
            return false;
        }
        int i15 = i12 + 2;
        return i15 == iF || bArrD[i15] == 51;
    }

    private boolean g(a4.c0 c0Var, byte[] bArr, int i10) {
        int iMin = Math.min(c0Var.a(), i10 - this.f37123i);
        c0Var.j(bArr, this.f37123i, iMin);
        int i11 = this.f37123i + iMin;
        this.f37123i = i11;
        return i11 == i10;
    }

    private void h(a4.c0 c0Var) {
        byte[] bArrD = c0Var.d();
        int iE = c0Var.e();
        int iF = c0Var.f();
        while (iE < iF) {
            int i10 = iE + 1;
            int i11 = bArrD[iE] & 255;
            if (this.f37124j == 512 && j((byte) -1, (byte) i11) && (this.f37126l || f(c0Var, i10 - 2))) {
                this.f37129o = (i11 & 8) >> 3;
                this.f37125k = (i11 & 1) == 0;
                if (this.f37126l) {
                    r();
                } else {
                    p();
                }
                c0Var.P(i10);
                return;
            }
            int i12 = this.f37124j;
            int i13 = i11 | i12;
            if (i13 == 329) {
                this.f37124j = 768;
            } else if (i13 == 511) {
                this.f37124j = 512;
            } else if (i13 == 836) {
                this.f37124j = 1024;
            } else if (i13 == 1075) {
                s();
                c0Var.P(i10);
                return;
            } else if (i12 != 256) {
                this.f37124j = 256;
                i10--;
            }
            iE = i10;
        }
        c0Var.P(iE);
    }

    private boolean j(byte b10, byte b11) {
        return k(((b10 & 255) << 8) | (b11 & 255));
    }

    public static boolean k(int i10) {
        return (i10 & 65526) == 65520;
    }

    private void l() throws j2 {
        this.f37116b.p(0);
        if (this.f37130p) {
            this.f37116b.r(10);
        } else {
            int iH = this.f37116b.h(2) + 1;
            if (iH != 2) {
                a4.t.i("AdtsReader", "Detected audio object type: " + iH + ", but assuming AAC LC.");
                iH = 2;
            }
            this.f37116b.r(5);
            byte[] bArrA = m2.a.a(iH, this.f37128n, this.f37116b.h(3));
            a.b bVarE = m2.a.e(bArrA);
            o1 o1VarE = new o1.b().S(this.f37119e).e0(MimeTypes.AUDIO_AAC).I(bVarE.f31146c).H(bVarE.f31145b).f0(bVarE.f31144a).T(Collections.singletonList(bArrA)).V(this.f37118d).E();
            this.f37131q = 1024000000 / ((long) o1VarE.f29361z);
            this.f37120f.f(o1VarE);
            this.f37130p = true;
        }
        this.f37116b.r(4);
        int iH2 = (this.f37116b.h(13) - 2) - 5;
        if (this.f37125k) {
            iH2 -= 2;
        }
        t(this.f37120f, this.f37131q, 0, iH2);
    }

    private void m() {
        this.f37121g.e(this.f37117c, 10);
        this.f37117c.P(6);
        t(this.f37121g, 0L, 10, this.f37117c.C() + 10);
    }

    private void n(a4.c0 c0Var) {
        int iMin = Math.min(c0Var.a(), this.f37132r - this.f37123i);
        this.f37134t.e(c0Var, iMin);
        int i10 = this.f37123i + iMin;
        this.f37123i = i10;
        int i11 = this.f37132r;
        if (i10 == i11) {
            long j10 = this.f37133s;
            if (j10 != C.TIME_UNSET) {
                this.f37134t.a(j10, 1, i11, 0, null);
                this.f37133s += this.f37135u;
            }
            q();
        }
    }

    private void o() {
        this.f37126l = false;
        q();
    }

    private void p() {
        this.f37122h = 1;
        this.f37123i = 0;
    }

    private void q() {
        this.f37122h = 0;
        this.f37123i = 0;
        this.f37124j = 256;
    }

    private void r() {
        this.f37122h = 3;
        this.f37123i = 0;
    }

    private void s() {
        this.f37122h = 2;
        this.f37123i = f37114v.length;
        this.f37132r = 0;
        this.f37117c.P(0);
    }

    private void t(p2.e0 e0Var, long j10, int i10, int i11) {
        this.f37122h = 4;
        this.f37123i = i10;
        this.f37134t = e0Var;
        this.f37135u = j10;
        this.f37132r = i11;
    }

    private boolean u(a4.c0 c0Var, byte[] bArr, int i10) {
        if (c0Var.a() < i10) {
            return false;
        }
        c0Var.j(bArr, 0, i10);
        return true;
    }

    @Override // z2.m
    public void a(a4.c0 c0Var) throws j2 {
        d();
        while (c0Var.a() > 0) {
            int i10 = this.f37122h;
            if (i10 == 0) {
                h(c0Var);
            } else if (i10 == 1) {
                e(c0Var);
            } else if (i10 != 2) {
                if (i10 == 3) {
                    if (g(c0Var, this.f37116b.f141a, this.f37125k ? 7 : 5)) {
                        l();
                    }
                } else {
                    if (i10 != 4) {
                        throw new IllegalStateException();
                    }
                    n(c0Var);
                }
            } else if (g(c0Var, this.f37117c.d(), 10)) {
                m();
            }
        }
    }

    @Override // z2.m
    public void c(p2.n nVar, i0.d dVar) {
        dVar.a();
        this.f37119e = dVar.b();
        p2.e0 e0VarTrack = nVar.track(dVar.c(), 1);
        this.f37120f = e0VarTrack;
        this.f37134t = e0VarTrack;
        if (!this.f37115a) {
            this.f37121g = new p2.k();
            return;
        }
        dVar.a();
        p2.e0 e0VarTrack2 = nVar.track(dVar.c(), 5);
        this.f37121g = e0VarTrack2;
        e0VarTrack2.f(new o1.b().S(dVar.b()).e0(MimeTypes.APPLICATION_ID3).E());
    }

    public long i() {
        return this.f37131q;
    }

    @Override // z2.m
    public void packetStarted(long j10, int i10) {
        if (j10 != C.TIME_UNSET) {
            this.f37133s = j10;
        }
    }

    @Override // z2.m
    public void seek() {
        this.f37133s = C.TIME_UNSET;
        o();
    }

    public i(boolean z10, @Nullable String str) {
        this.f37116b = new a4.b0(new byte[7]);
        this.f37117c = new a4.c0(Arrays.copyOf(f37114v, 10));
        q();
        this.f37127m = -1;
        this.f37128n = -1;
        this.f37131q = C.TIME_UNSET;
        this.f37133s = C.TIME_UNSET;
        this.f37115a = z10;
        this.f37118d = str;
    }

    @Override // z2.m
    public void b() {
    }
}

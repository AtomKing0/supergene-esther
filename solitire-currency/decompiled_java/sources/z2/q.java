package z2;

import a4.o0;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.util.Collections;
import k2.o1;
import z2.i0;

/* JADX INFO: compiled from: H265Reader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d0 f37266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f37267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p2.e0 f37268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f37269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f37270e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f37277l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean[] f37271f = new boolean[3];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final u f37272g = new u(32, 128);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final u f37273h = new u(33, 128);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final u f37274i = new u(34, 128);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final u f37275j = new u(39, 128);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final u f37276k = new u(40, 128);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f37278m = C.TIME_UNSET;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final a4.c0 f37279n = new a4.c0();

    /* JADX INFO: compiled from: H265Reader.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final p2.e0 f37280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f37281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f37282c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f37283d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f37284e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f37285f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f37286g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f37287h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f37288i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f37289j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f37290k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f37291l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f37292m;

        public a(p2.e0 e0Var) {
            this.f37280a = e0Var;
        }

        private static boolean b(int i10) {
            return (32 <= i10 && i10 <= 35) || i10 == 39;
        }

        private static boolean c(int i10) {
            return i10 < 32 || i10 == 40;
        }

        private void d(int i10) {
            long j10 = this.f37291l;
            if (j10 == C.TIME_UNSET) {
                return;
            }
            boolean z10 = this.f37292m;
            this.f37280a.a(j10, z10 ? 1 : 0, (int) (this.f37281b - this.f37290k), i10, null);
        }

        public void a(long j10, int i10, boolean z10) {
            if (this.f37289j && this.f37286g) {
                this.f37292m = this.f37282c;
                this.f37289j = false;
            } else if (this.f37287h || this.f37286g) {
                if (z10 && this.f37288i) {
                    d(i10 + ((int) (j10 - this.f37281b)));
                }
                this.f37290k = this.f37281b;
                this.f37291l = this.f37284e;
                this.f37292m = this.f37282c;
                this.f37288i = true;
            }
        }

        public void e(byte[] bArr, int i10, int i11) {
            if (this.f37285f) {
                int i12 = this.f37283d;
                int i13 = (i10 + 2) - i12;
                if (i13 >= i11) {
                    this.f37283d = i12 + (i11 - i10);
                } else {
                    this.f37286g = (bArr[i13] & 128) != 0;
                    this.f37285f = false;
                }
            }
        }

        public void f() {
            this.f37285f = false;
            this.f37286g = false;
            this.f37287h = false;
            this.f37288i = false;
            this.f37289j = false;
        }

        public void g(long j10, int i10, int i11, long j11, boolean z10) {
            this.f37286g = false;
            this.f37287h = false;
            this.f37284e = j11;
            this.f37283d = 0;
            this.f37281b = j10;
            if (!c(i11)) {
                if (this.f37288i && !this.f37289j) {
                    if (z10) {
                        d(i10);
                    }
                    this.f37288i = false;
                }
                if (b(i11)) {
                    this.f37287h = !this.f37289j;
                    this.f37289j = true;
                }
            }
            boolean z11 = i11 >= 16 && i11 <= 21;
            this.f37282c = z11;
            this.f37285f = z11 || i11 <= 9;
        }
    }

    public q(d0 d0Var) {
        this.f37266a = d0Var;
    }

    private void d() {
        a4.a.i(this.f37268c);
        o0.j(this.f37269d);
    }

    private void e(long j10, int i10, int i11, long j11) {
        this.f37269d.a(j10, i10, this.f37270e);
        if (!this.f37270e) {
            this.f37272g.b(i11);
            this.f37273h.b(i11);
            this.f37274i.b(i11);
            if (this.f37272g.c() && this.f37273h.c() && this.f37274i.c()) {
                this.f37268c.f(g(this.f37267b, this.f37272g, this.f37273h, this.f37274i));
                this.f37270e = true;
            }
        }
        if (this.f37275j.b(i11)) {
            u uVar = this.f37275j;
            this.f37279n.N(this.f37275j.f37335d, a4.y.q(uVar.f37335d, uVar.f37336e));
            this.f37279n.Q(5);
            this.f37266a.a(j11, this.f37279n);
        }
        if (this.f37276k.b(i11)) {
            u uVar2 = this.f37276k;
            this.f37279n.N(this.f37276k.f37335d, a4.y.q(uVar2.f37335d, uVar2.f37336e));
            this.f37279n.Q(5);
            this.f37266a.a(j11, this.f37279n);
        }
    }

    private void f(byte[] bArr, int i10, int i11) {
        this.f37269d.e(bArr, i10, i11);
        if (!this.f37270e) {
            this.f37272g.a(bArr, i10, i11);
            this.f37273h.a(bArr, i10, i11);
            this.f37274i.a(bArr, i10, i11);
        }
        this.f37275j.a(bArr, i10, i11);
        this.f37276k.a(bArr, i10, i11);
    }

    private static o1 g(@Nullable String str, u uVar, u uVar2, u uVar3) {
        int i10 = uVar.f37336e;
        byte[] bArr = new byte[uVar2.f37336e + i10 + uVar3.f37336e];
        System.arraycopy(uVar.f37335d, 0, bArr, 0, i10);
        System.arraycopy(uVar2.f37335d, 0, bArr, uVar.f37336e, uVar2.f37336e);
        System.arraycopy(uVar3.f37335d, 0, bArr, uVar.f37336e + uVar2.f37336e, uVar3.f37336e);
        a4.d0 d0Var = new a4.d0(uVar2.f37335d, 0, uVar2.f37336e);
        d0Var.l(44);
        int iE = d0Var.e(3);
        d0Var.k();
        int iE2 = d0Var.e(2);
        boolean zD = d0Var.d();
        int iE3 = d0Var.e(5);
        int i11 = 0;
        for (int i12 = 0; i12 < 32; i12++) {
            if (d0Var.d()) {
                i11 |= 1 << i12;
            }
        }
        int[] iArr = new int[6];
        for (int i13 = 0; i13 < 6; i13++) {
            iArr[i13] = d0Var.e(8);
        }
        int iE4 = d0Var.e(8);
        int i14 = 0;
        for (int i15 = 0; i15 < iE; i15++) {
            if (d0Var.d()) {
                i14 += 89;
            }
            if (d0Var.d()) {
                i14 += 8;
            }
        }
        d0Var.l(i14);
        if (iE > 0) {
            d0Var.l((8 - iE) * 2);
        }
        d0Var.h();
        int iH = d0Var.h();
        if (iH == 3) {
            d0Var.k();
        }
        int iH2 = d0Var.h();
        int iH3 = d0Var.h();
        if (d0Var.d()) {
            int iH4 = d0Var.h();
            int iH5 = d0Var.h();
            int iH6 = d0Var.h();
            int iH7 = d0Var.h();
            iH2 -= ((iH == 1 || iH == 2) ? 2 : 1) * (iH4 + iH5);
            iH3 -= (iH == 1 ? 2 : 1) * (iH6 + iH7);
        }
        d0Var.h();
        d0Var.h();
        int iH8 = d0Var.h();
        for (int i16 = d0Var.d() ? 0 : iE; i16 <= iE; i16++) {
            d0Var.h();
            d0Var.h();
            d0Var.h();
        }
        d0Var.h();
        d0Var.h();
        d0Var.h();
        d0Var.h();
        d0Var.h();
        d0Var.h();
        if (d0Var.d() && d0Var.d()) {
            h(d0Var);
        }
        d0Var.l(2);
        if (d0Var.d()) {
            d0Var.l(8);
            d0Var.h();
            d0Var.h();
            d0Var.k();
        }
        i(d0Var);
        if (d0Var.d()) {
            for (int i17 = 0; i17 < d0Var.h(); i17++) {
                d0Var.l(iH8 + 4 + 1);
            }
        }
        d0Var.l(2);
        float f10 = 1.0f;
        if (d0Var.d()) {
            if (d0Var.d()) {
                int iE5 = d0Var.e(8);
                if (iE5 == 255) {
                    int iE6 = d0Var.e(16);
                    int iE7 = d0Var.e(16);
                    if (iE6 != 0 && iE7 != 0) {
                        f10 = iE6 / iE7;
                    }
                } else {
                    float[] fArr = a4.y.f259b;
                    if (iE5 < fArr.length) {
                        f10 = fArr[iE5];
                    } else {
                        a4.t.i("H265Reader", "Unexpected aspect_ratio_idc value: " + iE5);
                    }
                }
            }
            if (d0Var.d()) {
                d0Var.k();
            }
            if (d0Var.d()) {
                d0Var.l(4);
                if (d0Var.d()) {
                    d0Var.l(24);
                }
            }
            if (d0Var.d()) {
                d0Var.h();
                d0Var.h();
            }
            d0Var.k();
            if (d0Var.d()) {
                iH3 *= 2;
            }
        }
        return new o1.b().S(str).e0("video/hevc").I(a4.e.c(iE2, zD, iE3, i11, iArr, iE4)).j0(iH2).Q(iH3).a0(f10).T(Collections.singletonList(bArr)).E();
    }

    private static void h(a4.d0 d0Var) {
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = 0;
            while (i11 < 6) {
                int i12 = 1;
                if (d0Var.d()) {
                    int iMin = Math.min(64, 1 << ((i10 << 1) + 4));
                    if (i10 > 1) {
                        d0Var.g();
                    }
                    for (int i13 = 0; i13 < iMin; i13++) {
                        d0Var.g();
                    }
                } else {
                    d0Var.h();
                }
                if (i10 == 3) {
                    i12 = 3;
                }
                i11 += i12;
            }
        }
    }

    private static void i(a4.d0 d0Var) {
        int iH = d0Var.h();
        boolean zD = false;
        int i10 = 0;
        for (int i11 = 0; i11 < iH; i11++) {
            if (i11 != 0) {
                zD = d0Var.d();
            }
            if (zD) {
                d0Var.k();
                d0Var.h();
                for (int i12 = 0; i12 <= i10; i12++) {
                    if (d0Var.d()) {
                        d0Var.k();
                    }
                }
            } else {
                int iH2 = d0Var.h();
                int iH3 = d0Var.h();
                int i13 = iH2 + iH3;
                for (int i14 = 0; i14 < iH2; i14++) {
                    d0Var.h();
                    d0Var.k();
                }
                for (int i15 = 0; i15 < iH3; i15++) {
                    d0Var.h();
                    d0Var.k();
                }
                i10 = i13;
            }
        }
    }

    private void j(long j10, int i10, int i11, long j11) {
        this.f37269d.g(j10, i10, i11, j11, this.f37270e);
        if (!this.f37270e) {
            this.f37272g.e(i11);
            this.f37273h.e(i11);
            this.f37274i.e(i11);
        }
        this.f37275j.e(i11);
        this.f37276k.e(i11);
    }

    @Override // z2.m
    public void a(a4.c0 c0Var) {
        d();
        while (c0Var.a() > 0) {
            int iE = c0Var.e();
            int iF = c0Var.f();
            byte[] bArrD = c0Var.d();
            this.f37277l += (long) c0Var.a();
            this.f37268c.e(c0Var, c0Var.a());
            while (iE < iF) {
                int iC = a4.y.c(bArrD, iE, iF, this.f37271f);
                if (iC == iF) {
                    f(bArrD, iE, iF);
                    return;
                }
                int iE2 = a4.y.e(bArrD, iC);
                int i10 = iC - iE;
                if (i10 > 0) {
                    f(bArrD, iE, iC);
                }
                int i11 = iF - iC;
                long j10 = this.f37277l - ((long) i11);
                e(j10, i11, i10 < 0 ? -i10 : 0, this.f37278m);
                j(j10, i11, iE2, this.f37278m);
                iE = iC + 3;
            }
        }
    }

    @Override // z2.m
    public void c(p2.n nVar, i0.d dVar) {
        dVar.a();
        this.f37267b = dVar.b();
        p2.e0 e0VarTrack = nVar.track(dVar.c(), 2);
        this.f37268c = e0VarTrack;
        this.f37269d = new a(e0VarTrack);
        this.f37266a.b(nVar, dVar);
    }

    @Override // z2.m
    public void packetStarted(long j10, int i10) {
        if (j10 != C.TIME_UNSET) {
            this.f37278m = j10;
        }
    }

    @Override // z2.m
    public void seek() {
        this.f37277l = 0L;
        this.f37278m = C.TIME_UNSET;
        a4.y.a(this.f37271f);
        this.f37272g.d();
        this.f37273h.d();
        this.f37274i.d();
        this.f37275j.d();
        this.f37276k.d();
        a aVar = this.f37269d;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // z2.m
    public void b() {
    }
}

package z2;

import a4.o0;
import a4.y;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.util.ArrayList;
import java.util.Arrays;
import k2.o1;
import z2.i0;

/* JADX INFO: compiled from: H264Reader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d0 f37217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f37218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f37219c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f37223g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f37225i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private p2.e0 f37226j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private b f37227k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f37228l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f37230n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean[] f37224h = new boolean[3];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final u f37220d = new u(7, 128);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final u f37221e = new u(8, 128);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final u f37222f = new u(6, 128);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f37229m = C.TIME_UNSET;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final a4.c0 f37231o = new a4.c0();

    /* JADX INFO: compiled from: H264Reader.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final p2.e0 f37232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f37233b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f37234c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final SparseArray<y.c> f37235d = new SparseArray<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final SparseArray<y.b> f37236e = new SparseArray<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final a4.d0 f37237f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private byte[] f37238g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f37239h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f37240i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f37241j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f37242k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f37243l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private a f37244m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private a f37245n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f37246o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private long f37247p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private long f37248q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private boolean f37249r;

        /* JADX INFO: compiled from: H264Reader.java */
        private static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f37250a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f37251b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @Nullable
            private y.c f37252c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f37253d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private int f37254e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private int f37255f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f37256g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private boolean f37257h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private boolean f37258i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private boolean f37259j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private boolean f37260k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            private int f37261l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            private int f37262m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            private int f37263n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            private int f37264o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            private int f37265p;

            private a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean c(a aVar) {
                int i10;
                int i11;
                int i12;
                boolean z10;
                if (!this.f37250a) {
                    return false;
                }
                if (!aVar.f37250a) {
                    return true;
                }
                y.c cVar = (y.c) a4.a.i(this.f37252c);
                y.c cVar2 = (y.c) a4.a.i(aVar.f37252c);
                return (this.f37255f == aVar.f37255f && this.f37256g == aVar.f37256g && this.f37257h == aVar.f37257h && (!this.f37258i || !aVar.f37258i || this.f37259j == aVar.f37259j) && (((i10 = this.f37253d) == (i11 = aVar.f37253d) || (i10 != 0 && i11 != 0)) && (((i12 = cVar.f286l) != 0 || cVar2.f286l != 0 || (this.f37262m == aVar.f37262m && this.f37263n == aVar.f37263n)) && ((i12 != 1 || cVar2.f286l != 1 || (this.f37264o == aVar.f37264o && this.f37265p == aVar.f37265p)) && (z10 = this.f37260k) == aVar.f37260k && (!z10 || this.f37261l == aVar.f37261l))))) ? false : true;
            }

            public void b() {
                this.f37251b = false;
                this.f37250a = false;
            }

            public boolean d() {
                int i10;
                return this.f37251b && ((i10 = this.f37254e) == 7 || i10 == 2);
            }

            public void e(y.c cVar, int i10, int i11, int i12, int i13, boolean z10, boolean z11, boolean z12, boolean z13, int i14, int i15, int i16, int i17, int i18) {
                this.f37252c = cVar;
                this.f37253d = i10;
                this.f37254e = i11;
                this.f37255f = i12;
                this.f37256g = i13;
                this.f37257h = z10;
                this.f37258i = z11;
                this.f37259j = z12;
                this.f37260k = z13;
                this.f37261l = i14;
                this.f37262m = i15;
                this.f37263n = i16;
                this.f37264o = i17;
                this.f37265p = i18;
                this.f37250a = true;
                this.f37251b = true;
            }

            public void f(int i10) {
                this.f37254e = i10;
                this.f37251b = true;
            }
        }

        public b(p2.e0 e0Var, boolean z10, boolean z11) {
            this.f37232a = e0Var;
            this.f37233b = z10;
            this.f37234c = z11;
            this.f37244m = new a();
            this.f37245n = new a();
            byte[] bArr = new byte[128];
            this.f37238g = bArr;
            this.f37237f = new a4.d0(bArr, 0, 0);
            g();
        }

        private void d(int i10) {
            long j10 = this.f37248q;
            if (j10 == C.TIME_UNSET) {
                return;
            }
            boolean z10 = this.f37249r;
            this.f37232a.a(j10, z10 ? 1 : 0, (int) (this.f37241j - this.f37247p), i10, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x00ff  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0106  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0118  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x011e  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0152  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(byte[] r24, int r25, int r26) {
            /*
                Method dump skipped, instruction units count: 414
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: z2.p.b.a(byte[], int, int):void");
        }

        public boolean b(long j10, int i10, boolean z10, boolean z11) {
            boolean z12 = false;
            if (this.f37240i == 9 || (this.f37234c && this.f37245n.c(this.f37244m))) {
                if (z10 && this.f37246o) {
                    d(i10 + ((int) (j10 - this.f37241j)));
                }
                this.f37247p = this.f37241j;
                this.f37248q = this.f37243l;
                this.f37249r = false;
                this.f37246o = true;
            }
            if (this.f37233b) {
                z11 = this.f37245n.d();
            }
            boolean z13 = this.f37249r;
            int i11 = this.f37240i;
            if (i11 == 5 || (z11 && i11 == 1)) {
                z12 = true;
            }
            boolean z14 = z13 | z12;
            this.f37249r = z14;
            return z14;
        }

        public boolean c() {
            return this.f37234c;
        }

        public void e(y.b bVar) {
            this.f37236e.append(bVar.f272a, bVar);
        }

        public void f(y.c cVar) {
            this.f37235d.append(cVar.f278d, cVar);
        }

        public void g() {
            this.f37242k = false;
            this.f37246o = false;
            this.f37245n.b();
        }

        public void h(long j10, int i10, long j11) {
            this.f37240i = i10;
            this.f37243l = j11;
            this.f37241j = j10;
            if (!this.f37233b || i10 != 1) {
                if (!this.f37234c) {
                    return;
                }
                if (i10 != 5 && i10 != 1 && i10 != 2) {
                    return;
                }
            }
            a aVar = this.f37244m;
            this.f37244m = this.f37245n;
            this.f37245n = aVar;
            aVar.b();
            this.f37239h = 0;
            this.f37242k = true;
        }
    }

    public p(d0 d0Var, boolean z10, boolean z11) {
        this.f37217a = d0Var;
        this.f37218b = z10;
        this.f37219c = z11;
    }

    private void d() {
        a4.a.i(this.f37226j);
        o0.j(this.f37227k);
    }

    private void e(long j10, int i10, int i11, long j11) {
        if (!this.f37228l || this.f37227k.c()) {
            this.f37220d.b(i11);
            this.f37221e.b(i11);
            if (this.f37228l) {
                if (this.f37220d.c()) {
                    u uVar = this.f37220d;
                    this.f37227k.f(a4.y.l(uVar.f37335d, 3, uVar.f37336e));
                    this.f37220d.d();
                } else if (this.f37221e.c()) {
                    u uVar2 = this.f37221e;
                    this.f37227k.e(a4.y.j(uVar2.f37335d, 3, uVar2.f37336e));
                    this.f37221e.d();
                }
            } else if (this.f37220d.c() && this.f37221e.c()) {
                ArrayList arrayList = new ArrayList();
                u uVar3 = this.f37220d;
                arrayList.add(Arrays.copyOf(uVar3.f37335d, uVar3.f37336e));
                u uVar4 = this.f37221e;
                arrayList.add(Arrays.copyOf(uVar4.f37335d, uVar4.f37336e));
                u uVar5 = this.f37220d;
                y.c cVarL = a4.y.l(uVar5.f37335d, 3, uVar5.f37336e);
                u uVar6 = this.f37221e;
                y.b bVarJ = a4.y.j(uVar6.f37335d, 3, uVar6.f37336e);
                this.f37226j.f(new o1.b().S(this.f37225i).e0("video/avc").I(a4.e.a(cVarL.f275a, cVarL.f276b, cVarL.f277c)).j0(cVarL.f280f).Q(cVarL.f281g).a0(cVarL.f282h).T(arrayList).E());
                this.f37228l = true;
                this.f37227k.f(cVarL);
                this.f37227k.e(bVarJ);
                this.f37220d.d();
                this.f37221e.d();
            }
        }
        if (this.f37222f.b(i11)) {
            u uVar7 = this.f37222f;
            this.f37231o.N(this.f37222f.f37335d, a4.y.q(uVar7.f37335d, uVar7.f37336e));
            this.f37231o.P(4);
            this.f37217a.a(j11, this.f37231o);
        }
        if (this.f37227k.b(j10, i10, this.f37228l, this.f37230n)) {
            this.f37230n = false;
        }
    }

    private void f(byte[] bArr, int i10, int i11) {
        if (!this.f37228l || this.f37227k.c()) {
            this.f37220d.a(bArr, i10, i11);
            this.f37221e.a(bArr, i10, i11);
        }
        this.f37222f.a(bArr, i10, i11);
        this.f37227k.a(bArr, i10, i11);
    }

    private void g(long j10, int i10, long j11) {
        if (!this.f37228l || this.f37227k.c()) {
            this.f37220d.e(i10);
            this.f37221e.e(i10);
        }
        this.f37222f.e(i10);
        this.f37227k.h(j10, i10, j11);
    }

    @Override // z2.m
    public void a(a4.c0 c0Var) {
        d();
        int iE = c0Var.e();
        int iF = c0Var.f();
        byte[] bArrD = c0Var.d();
        this.f37223g += (long) c0Var.a();
        this.f37226j.e(c0Var, c0Var.a());
        while (true) {
            int iC = a4.y.c(bArrD, iE, iF, this.f37224h);
            if (iC == iF) {
                f(bArrD, iE, iF);
                return;
            }
            int iF2 = a4.y.f(bArrD, iC);
            int i10 = iC - iE;
            if (i10 > 0) {
                f(bArrD, iE, iC);
            }
            int i11 = iF - iC;
            long j10 = this.f37223g - ((long) i11);
            e(j10, i11, i10 < 0 ? -i10 : 0, this.f37229m);
            g(j10, iF2, this.f37229m);
            iE = iC + 3;
        }
    }

    @Override // z2.m
    public void c(p2.n nVar, i0.d dVar) {
        dVar.a();
        this.f37225i = dVar.b();
        p2.e0 e0VarTrack = nVar.track(dVar.c(), 2);
        this.f37226j = e0VarTrack;
        this.f37227k = new b(e0VarTrack, this.f37218b, this.f37219c);
        this.f37217a.b(nVar, dVar);
    }

    @Override // z2.m
    public void packetStarted(long j10, int i10) {
        if (j10 != C.TIME_UNSET) {
            this.f37229m = j10;
        }
        this.f37230n |= (i10 & 2) != 0;
    }

    @Override // z2.m
    public void seek() {
        this.f37223g = 0L;
        this.f37230n = false;
        this.f37229m = C.TIME_UNSET;
        a4.y.a(this.f37224h);
        this.f37220d.d();
        this.f37221e.d();
        this.f37222f.d();
        b bVar = this.f37227k;
        if (bVar != null) {
            bVar.g();
        }
    }

    @Override // z2.m
    public void b() {
    }
}

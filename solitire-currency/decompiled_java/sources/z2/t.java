package z2;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import k2.o1;
import m2.h0;
import z2.i0;

/* JADX INFO: compiled from: MpegAudioReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a4.c0 f37320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h0.a f37321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final String f37322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private p2.e0 f37323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f37324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f37325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f37326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f37327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f37328i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f37329j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f37330k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f37331l;

    public t() {
        this(null);
    }

    private void d(a4.c0 c0Var) {
        byte[] bArrD = c0Var.d();
        int iF = c0Var.f();
        for (int iE = c0Var.e(); iE < iF; iE++) {
            byte b10 = bArrD[iE];
            boolean z10 = (b10 & 255) == 255;
            boolean z11 = this.f37328i && (b10 & 224) == 224;
            this.f37328i = z10;
            if (z11) {
                c0Var.P(iE + 1);
                this.f37328i = false;
                this.f37320a.d()[1] = bArrD[iE];
                this.f37326g = 2;
                this.f37325f = 1;
                return;
            }
        }
        c0Var.P(iF);
    }

    private void e(a4.c0 c0Var) {
        int iMin = Math.min(c0Var.a(), this.f37330k - this.f37326g);
        this.f37323d.e(c0Var, iMin);
        int i10 = this.f37326g + iMin;
        this.f37326g = i10;
        int i11 = this.f37330k;
        if (i10 < i11) {
            return;
        }
        long j10 = this.f37331l;
        if (j10 != C.TIME_UNSET) {
            this.f37323d.a(j10, 1, i11, 0, null);
            this.f37331l += this.f37329j;
        }
        this.f37326g = 0;
        this.f37325f = 0;
    }

    private void f(a4.c0 c0Var) {
        int iMin = Math.min(c0Var.a(), 4 - this.f37326g);
        c0Var.j(this.f37320a.d(), this.f37326g, iMin);
        int i10 = this.f37326g + iMin;
        this.f37326g = i10;
        if (i10 < 4) {
            return;
        }
        this.f37320a.P(0);
        if (!this.f37321b.a(this.f37320a.n())) {
            this.f37326g = 0;
            this.f37325f = 1;
            return;
        }
        h0.a aVar = this.f37321b;
        this.f37330k = aVar.f31289c;
        if (!this.f37327h) {
            this.f37329j = (((long) aVar.f31293g) * 1000000) / ((long) aVar.f31290d);
            this.f37323d.f(new o1.b().S(this.f37324e).e0(this.f37321b.f31288b).W(4096).H(this.f37321b.f31291e).f0(this.f37321b.f31290d).V(this.f37322c).E());
            this.f37327h = true;
        }
        this.f37320a.P(0);
        this.f37323d.e(this.f37320a, 4);
        this.f37325f = 2;
    }

    @Override // z2.m
    public void a(a4.c0 c0Var) {
        a4.a.i(this.f37323d);
        while (c0Var.a() > 0) {
            int i10 = this.f37325f;
            if (i10 == 0) {
                d(c0Var);
            } else if (i10 == 1) {
                f(c0Var);
            } else {
                if (i10 != 2) {
                    throw new IllegalStateException();
                }
                e(c0Var);
            }
        }
    }

    @Override // z2.m
    public void c(p2.n nVar, i0.d dVar) {
        dVar.a();
        this.f37324e = dVar.b();
        this.f37323d = nVar.track(dVar.c(), 1);
    }

    @Override // z2.m
    public void packetStarted(long j10, int i10) {
        if (j10 != C.TIME_UNSET) {
            this.f37331l = j10;
        }
    }

    @Override // z2.m
    public void seek() {
        this.f37325f = 0;
        this.f37326g = 0;
        this.f37328i = false;
        this.f37331l = C.TIME_UNSET;
    }

    public t(@Nullable String str) {
        this.f37325f = 0;
        a4.c0 c0Var = new a4.c0(4);
        this.f37320a = c0Var;
        c0Var.d()[0] = -1;
        this.f37321b = new h0.a();
        this.f37331l = C.TIME_UNSET;
        this.f37322c = str;
    }

    @Override // z2.m
    public void b() {
    }
}

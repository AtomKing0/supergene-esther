package t2;

import a4.c0;
import a4.y;
import k2.j2;
import k2.o1;
import p2.e0;
import t2.e;

/* JADX INFO: compiled from: VideoTagPayloadReader.java */
/* JADX INFO: loaded from: classes2.dex */
final class f extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c0 f34058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c0 f34059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f34060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f34061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f34062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f34063g;

    public f(e0 e0Var) {
        super(e0Var);
        this.f34058b = new c0(y.f258a);
        this.f34059c = new c0(4);
    }

    @Override // t2.e
    protected boolean b(c0 c0Var) throws e.a {
        int iD = c0Var.D();
        int i10 = (iD >> 4) & 15;
        int i11 = iD & 15;
        if (i11 == 7) {
            this.f34063g = i10;
            return i10 != 5;
        }
        throw new e.a("Video format not supported: " + i11);
    }

    @Override // t2.e
    protected boolean c(c0 c0Var, long j10) throws j2 {
        int iD = c0Var.D();
        long jO = j10 + (((long) c0Var.o()) * 1000);
        if (iD == 0 && !this.f34061e) {
            c0 c0Var2 = new c0(new byte[c0Var.a()]);
            c0Var.j(c0Var2.d(), 0, c0Var.a());
            b4.a aVarB = b4.a.b(c0Var2);
            this.f34060d = aVarB.f2072b;
            this.f34057a.f(new o1.b().e0("video/avc").I(aVarB.f2076f).j0(aVarB.f2073c).Q(aVarB.f2074d).a0(aVarB.f2075e).T(aVarB.f2071a).E());
            this.f34061e = true;
            return false;
        }
        if (iD != 1 || !this.f34061e) {
            return false;
        }
        int i10 = this.f34063g == 1 ? 1 : 0;
        if (!this.f34062f && i10 == 0) {
            return false;
        }
        byte[] bArrD = this.f34059c.d();
        bArrD[0] = 0;
        bArrD[1] = 0;
        bArrD[2] = 0;
        int i11 = 4 - this.f34060d;
        int i12 = 0;
        while (c0Var.a() > 0) {
            c0Var.j(this.f34059c.d(), i11, this.f34060d);
            this.f34059c.P(0);
            int iH = this.f34059c.H();
            this.f34058b.P(0);
            this.f34057a.e(this.f34058b, 4);
            this.f34057a.e(c0Var, iH);
            i12 = i12 + 4 + iH;
        }
        this.f34057a.a(jO, i10, i12, 0, null);
        this.f34062f = true;
        return true;
    }
}

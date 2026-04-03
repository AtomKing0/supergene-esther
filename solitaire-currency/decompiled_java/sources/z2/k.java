package z2;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import k2.o1;
import z2.i0;

/* JADX INFO: compiled from: DtsReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f37151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f37152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private p2.e0 f37153d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f37155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f37156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f37157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private o1 f37158i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f37159j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a4.c0 f37150a = new a4.c0(new byte[18]);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f37154e = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f37160k = C.TIME_UNSET;

    public k(@Nullable String str) {
        this.f37151b = str;
    }

    private boolean d(a4.c0 c0Var, byte[] bArr, int i10) {
        int iMin = Math.min(c0Var.a(), i10 - this.f37155f);
        c0Var.j(bArr, this.f37155f, iMin);
        int i11 = this.f37155f + iMin;
        this.f37155f = i11;
        return i11 == i10;
    }

    private void e() {
        byte[] bArrD = this.f37150a.d();
        if (this.f37158i == null) {
            o1 o1VarG = m2.e0.g(bArrD, this.f37152c, this.f37151b, null);
            this.f37158i = o1VarG;
            this.f37153d.f(o1VarG);
        }
        this.f37159j = m2.e0.a(bArrD);
        this.f37157h = (int) ((((long) m2.e0.f(bArrD)) * 1000000) / ((long) this.f37158i.f29361z));
    }

    private boolean f(a4.c0 c0Var) {
        while (c0Var.a() > 0) {
            int i10 = this.f37156g << 8;
            this.f37156g = i10;
            int iD = i10 | c0Var.D();
            this.f37156g = iD;
            if (m2.e0.d(iD)) {
                byte[] bArrD = this.f37150a.d();
                int i11 = this.f37156g;
                bArrD[0] = (byte) ((i11 >> 24) & 255);
                bArrD[1] = (byte) ((i11 >> 16) & 255);
                bArrD[2] = (byte) ((i11 >> 8) & 255);
                bArrD[3] = (byte) (i11 & 255);
                this.f37155f = 4;
                this.f37156g = 0;
                return true;
            }
        }
        return false;
    }

    @Override // z2.m
    public void a(a4.c0 c0Var) {
        a4.a.i(this.f37153d);
        while (c0Var.a() > 0) {
            int i10 = this.f37154e;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        throw new IllegalStateException();
                    }
                    int iMin = Math.min(c0Var.a(), this.f37159j - this.f37155f);
                    this.f37153d.e(c0Var, iMin);
                    int i11 = this.f37155f + iMin;
                    this.f37155f = i11;
                    int i12 = this.f37159j;
                    if (i11 == i12) {
                        long j10 = this.f37160k;
                        if (j10 != C.TIME_UNSET) {
                            this.f37153d.a(j10, 1, i12, 0, null);
                            this.f37160k += this.f37157h;
                        }
                        this.f37154e = 0;
                    }
                } else if (d(c0Var, this.f37150a.d(), 18)) {
                    e();
                    this.f37150a.P(0);
                    this.f37153d.e(this.f37150a, 18);
                    this.f37154e = 2;
                }
            } else if (f(c0Var)) {
                this.f37154e = 1;
            }
        }
    }

    @Override // z2.m
    public void c(p2.n nVar, i0.d dVar) {
        dVar.a();
        this.f37152c = dVar.b();
        this.f37153d = nVar.track(dVar.c(), 1);
    }

    @Override // z2.m
    public void packetStarted(long j10, int i10) {
        if (j10 != C.TIME_UNSET) {
            this.f37160k = j10;
        }
    }

    @Override // z2.m
    public void seek() {
        this.f37154e = 0;
        this.f37155f = 0;
        this.f37156g = 0;
        this.f37160k = C.TIME_UNSET;
    }

    @Override // z2.m
    public void b() {
    }
}

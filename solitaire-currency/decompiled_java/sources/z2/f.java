package z2;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import k2.o1;
import m2.c;
import z2.i0;

/* JADX INFO: compiled from: Ac4Reader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a4.b0 f37052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a4.c0 f37053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final String f37054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f37055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private p2.e0 f37056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f37057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f37058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f37059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f37060i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f37061j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private o1 f37062k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f37063l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f37064m;

    public f() {
        this(null);
    }

    private boolean d(a4.c0 c0Var, byte[] bArr, int i10) {
        int iMin = Math.min(c0Var.a(), i10 - this.f37058g);
        c0Var.j(bArr, this.f37058g, iMin);
        int i11 = this.f37058g + iMin;
        this.f37058g = i11;
        return i11 == i10;
    }

    private void e() {
        this.f37052a.p(0);
        c.b bVarD = m2.c.d(this.f37052a);
        o1 o1Var = this.f37062k;
        if (o1Var == null || bVarD.f31166c != o1Var.f29360y || bVarD.f31165b != o1Var.f29361z || !MimeTypes.AUDIO_AC4.equals(o1Var.f29347l)) {
            o1 o1VarE = new o1.b().S(this.f37055d).e0(MimeTypes.AUDIO_AC4).H(bVarD.f31166c).f0(bVarD.f31165b).V(this.f37054c).E();
            this.f37062k = o1VarE;
            this.f37056e.f(o1VarE);
        }
        this.f37063l = bVarD.f31167d;
        this.f37061j = (((long) bVarD.f31168e) * 1000000) / ((long) this.f37062k.f29361z);
    }

    private boolean f(a4.c0 c0Var) {
        int iD;
        while (true) {
            if (c0Var.a() <= 0) {
                return false;
            }
            if (this.f37059h) {
                iD = c0Var.D();
                this.f37059h = iD == 172;
                if (iD == 64 || iD == 65) {
                    break;
                }
            } else {
                this.f37059h = c0Var.D() == 172;
            }
        }
        this.f37060i = iD == 65;
        return true;
    }

    @Override // z2.m
    public void a(a4.c0 c0Var) {
        a4.a.i(this.f37056e);
        while (c0Var.a() > 0) {
            int i10 = this.f37057f;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        int iMin = Math.min(c0Var.a(), this.f37063l - this.f37058g);
                        this.f37056e.e(c0Var, iMin);
                        int i11 = this.f37058g + iMin;
                        this.f37058g = i11;
                        int i12 = this.f37063l;
                        if (i11 == i12) {
                            long j10 = this.f37064m;
                            if (j10 != C.TIME_UNSET) {
                                this.f37056e.a(j10, 1, i12, 0, null);
                                this.f37064m += this.f37061j;
                            }
                            this.f37057f = 0;
                        }
                    }
                } else if (d(c0Var, this.f37053b.d(), 16)) {
                    e();
                    this.f37053b.P(0);
                    this.f37056e.e(this.f37053b, 16);
                    this.f37057f = 2;
                }
            } else if (f(c0Var)) {
                this.f37057f = 1;
                this.f37053b.d()[0] = -84;
                this.f37053b.d()[1] = (byte) (this.f37060i ? 65 : 64);
                this.f37058g = 2;
            }
        }
    }

    @Override // z2.m
    public void c(p2.n nVar, i0.d dVar) {
        dVar.a();
        this.f37055d = dVar.b();
        this.f37056e = nVar.track(dVar.c(), 1);
    }

    @Override // z2.m
    public void packetStarted(long j10, int i10) {
        if (j10 != C.TIME_UNSET) {
            this.f37064m = j10;
        }
    }

    @Override // z2.m
    public void seek() {
        this.f37057f = 0;
        this.f37058g = 0;
        this.f37059h = false;
        this.f37060i = false;
        this.f37064m = C.TIME_UNSET;
    }

    public f(@Nullable String str) {
        a4.b0 b0Var = new a4.b0(new byte[16]);
        this.f37052a = b0Var;
        this.f37053b = new a4.c0(b0Var.f141a);
        this.f37057f = 0;
        this.f37058g = 0;
        this.f37059h = false;
        this.f37060i = false;
        this.f37064m = C.TIME_UNSET;
        this.f37054c = str;
    }

    @Override // z2.m
    public void b() {
    }
}

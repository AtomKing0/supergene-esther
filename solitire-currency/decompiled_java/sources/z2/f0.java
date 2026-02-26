package z2;

import a4.l0;
import a4.o0;
import androidx.media3.common.C;
import java.io.IOException;

/* JADX INFO: compiled from: TsDurationReader.java */
/* JADX INFO: loaded from: classes2.dex */
final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f37065a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f37068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f37069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f37070f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l0 f37066b = new l0(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f37071g = C.TIME_UNSET;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f37072h = C.TIME_UNSET;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f37073i = C.TIME_UNSET;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a4.c0 f37067c = new a4.c0();

    f0(int i10) {
        this.f37065a = i10;
    }

    private int a(p2.m mVar) {
        this.f37067c.M(o0.f219f);
        this.f37068d = true;
        mVar.resetPeekPosition();
        return 0;
    }

    private int f(p2.m mVar, p2.a0 a0Var, int i10) throws IOException {
        int iMin = (int) Math.min(this.f37065a, mVar.getLength());
        long j10 = 0;
        if (mVar.getPosition() != j10) {
            a0Var.f32443a = j10;
            return 1;
        }
        this.f37067c.L(iMin);
        mVar.resetPeekPosition();
        mVar.peekFully(this.f37067c.d(), 0, iMin);
        this.f37071g = g(this.f37067c, i10);
        this.f37069e = true;
        return 0;
    }

    private long g(a4.c0 c0Var, int i10) {
        int iF = c0Var.f();
        for (int iE = c0Var.e(); iE < iF; iE++) {
            if (c0Var.d()[iE] == 71) {
                long jC = j0.c(c0Var, iE, i10);
                if (jC != C.TIME_UNSET) {
                    return jC;
                }
            }
        }
        return C.TIME_UNSET;
    }

    private int h(p2.m mVar, p2.a0 a0Var, int i10) throws IOException {
        long length = mVar.getLength();
        int iMin = (int) Math.min(this.f37065a, length);
        long j10 = length - ((long) iMin);
        if (mVar.getPosition() != j10) {
            a0Var.f32443a = j10;
            return 1;
        }
        this.f37067c.L(iMin);
        mVar.resetPeekPosition();
        mVar.peekFully(this.f37067c.d(), 0, iMin);
        this.f37072h = i(this.f37067c, i10);
        this.f37070f = true;
        return 0;
    }

    private long i(a4.c0 c0Var, int i10) {
        int iE = c0Var.e();
        int iF = c0Var.f();
        for (int i11 = iF - 188; i11 >= iE; i11--) {
            if (j0.b(c0Var.d(), iE, iF, i11)) {
                long jC = j0.c(c0Var, i11, i10);
                if (jC != C.TIME_UNSET) {
                    return jC;
                }
            }
        }
        return C.TIME_UNSET;
    }

    public long b() {
        return this.f37073i;
    }

    public l0 c() {
        return this.f37066b;
    }

    public boolean d() {
        return this.f37068d;
    }

    public int e(p2.m mVar, p2.a0 a0Var, int i10) throws IOException {
        if (i10 <= 0) {
            return a(mVar);
        }
        if (!this.f37070f) {
            return h(mVar, a0Var, i10);
        }
        if (this.f37072h == C.TIME_UNSET) {
            return a(mVar);
        }
        if (!this.f37069e) {
            return f(mVar, a0Var, i10);
        }
        long j10 = this.f37071g;
        if (j10 == C.TIME_UNSET) {
            return a(mVar);
        }
        long jB = this.f37066b.b(this.f37072h) - this.f37066b.b(j10);
        this.f37073i = jB;
        if (jB < 0) {
            a4.t.i("TsDurationReader", "Invalid duration: " + this.f37073i + ". Using TIME_UNSET instead.");
            this.f37073i = C.TIME_UNSET;
        }
        return a(mVar);
    }
}

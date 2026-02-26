package l3;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.io.IOException;
import k2.f3;
import l3.a0;
import l3.x;

/* JADX INFO: compiled from: MaskingMediaPeriod.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u implements x, x.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0.b f30732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f30733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final z3.b f30734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a0 f30735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private x f30736e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private x.a f30737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private a f30738g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f30739h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f30740i = C.TIME_UNSET;

    /* JADX INFO: compiled from: MaskingMediaPeriod.java */
    public interface a {
        void a(a0.b bVar, IOException iOException);

        void b(a0.b bVar);
    }

    public u(a0.b bVar, z3.b bVar2, long j10) {
        this.f30732a = bVar;
        this.f30734c = bVar2;
        this.f30733b = j10;
    }

    private long j(long j10) {
        long j11 = this.f30740i;
        return j11 != C.TIME_UNSET ? j11 : j10;
    }

    @Override // l3.x, l3.v0
    public boolean a(long j10) {
        x xVar = this.f30736e;
        return xVar != null && xVar.a(j10);
    }

    @Override // l3.x
    public void b(x.a aVar, long j10) {
        this.f30737f = aVar;
        x xVar = this.f30736e;
        if (xVar != null) {
            xVar.b(this, j(this.f30733b));
        }
    }

    @Override // l3.x.a
    public void d(x xVar) {
        ((x.a) a4.o0.j(this.f30737f)).d(this);
        a aVar = this.f30738g;
        if (aVar != null) {
            aVar.b(this.f30732a);
        }
    }

    @Override // l3.x
    public void discardBuffer(long j10, boolean z10) {
        ((x) a4.o0.j(this.f30736e)).discardBuffer(j10, z10);
    }

    public void e(a0.b bVar) {
        long j10 = j(this.f30733b);
        x xVarJ = ((a0) a4.a.e(this.f30735d)).j(bVar, this.f30734c, j10);
        this.f30736e = xVarJ;
        if (this.f30737f != null) {
            xVarJ.b(this, j10);
        }
    }

    public long f() {
        return this.f30740i;
    }

    @Override // l3.x
    public long g(x3.s[] sVarArr, boolean[] zArr, u0[] u0VarArr, boolean[] zArr2, long j10) {
        long j11;
        long j12 = this.f30740i;
        if (j12 == C.TIME_UNSET || j10 != this.f30733b) {
            j11 = j10;
        } else {
            this.f30740i = C.TIME_UNSET;
            j11 = j12;
        }
        return ((x) a4.o0.j(this.f30736e)).g(sVarArr, zArr, u0VarArr, zArr2, j11);
    }

    @Override // l3.x, l3.v0
    public long getBufferedPositionUs() {
        return ((x) a4.o0.j(this.f30736e)).getBufferedPositionUs();
    }

    @Override // l3.x, l3.v0
    public long getNextLoadPositionUs() {
        return ((x) a4.o0.j(this.f30736e)).getNextLoadPositionUs();
    }

    @Override // l3.x
    public e1 getTrackGroups() {
        return ((x) a4.o0.j(this.f30736e)).getTrackGroups();
    }

    public long h() {
        return this.f30733b;
    }

    @Override // l3.x
    public long i(long j10, f3 f3Var) {
        return ((x) a4.o0.j(this.f30736e)).i(j10, f3Var);
    }

    @Override // l3.x, l3.v0
    public boolean isLoading() {
        x xVar = this.f30736e;
        return xVar != null && xVar.isLoading();
    }

    @Override // l3.v0.a
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void c(x xVar) {
        ((x.a) a4.o0.j(this.f30737f)).c(this);
    }

    public void l(long j10) {
        this.f30740i = j10;
    }

    public void m() {
        if (this.f30736e != null) {
            ((a0) a4.a.e(this.f30735d)).e(this.f30736e);
        }
    }

    @Override // l3.x
    public void maybeThrowPrepareError() throws IOException {
        try {
            x xVar = this.f30736e;
            if (xVar != null) {
                xVar.maybeThrowPrepareError();
            } else {
                a0 a0Var = this.f30735d;
                if (a0Var != null) {
                    a0Var.maybeThrowSourceInfoRefreshError();
                }
            }
        } catch (IOException e10) {
            a aVar = this.f30738g;
            if (aVar == null) {
                throw e10;
            }
            if (this.f30739h) {
                return;
            }
            this.f30739h = true;
            aVar.a(this.f30732a, e10);
        }
    }

    public void n(a0 a0Var) {
        a4.a.g(this.f30735d == null);
        this.f30735d = a0Var;
    }

    @Override // l3.x
    public long readDiscontinuity() {
        return ((x) a4.o0.j(this.f30736e)).readDiscontinuity();
    }

    @Override // l3.x, l3.v0
    public void reevaluateBuffer(long j10) {
        ((x) a4.o0.j(this.f30736e)).reevaluateBuffer(j10);
    }

    @Override // l3.x
    public long seekToUs(long j10) {
        return ((x) a4.o0.j(this.f30736e)).seekToUs(j10);
    }
}

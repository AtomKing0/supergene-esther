package k2;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: BaseRenderer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f implements a3, c3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29082a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private d3 f29084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f29085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private l2.t1 f29086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f29087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private l3.u0 f29088g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private o1[] f29089h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f29090i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f29091j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f29093l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f29094m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p1 f29083b = new p1();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f29092k = Long.MIN_VALUE;

    public f(int i10) {
        this.f29082a = i10;
    }

    private void v(long j10, boolean z10) throws q {
        this.f29093l = false;
        this.f29091j = j10;
        this.f29092k = j10;
        p(j10, z10);
    }

    @Override // k2.a3
    public final void c(d3 d3Var, o1[] o1VarArr, l3.u0 u0Var, long j10, boolean z10, boolean z11, long j11, long j12) throws q {
        a4.a.g(this.f29087f == 0);
        this.f29084c = d3Var;
        this.f29087f = 1;
        o(z10, z11);
        e(o1VarArr, u0Var, j11, j12);
        v(j10, z10);
    }

    @Override // k2.a3
    public final void d(int i10, l2.t1 t1Var) {
        this.f29085d = i10;
        this.f29086e = t1Var;
    }

    @Override // k2.a3
    public final void disable() {
        a4.a.g(this.f29087f == 1);
        this.f29083b.a();
        this.f29087f = 0;
        this.f29088g = null;
        this.f29089h = null;
        this.f29093l = false;
        n();
    }

    @Override // k2.a3
    public final void e(o1[] o1VarArr, l3.u0 u0Var, long j10, long j11) throws q {
        a4.a.g(!this.f29093l);
        this.f29088g = u0Var;
        if (this.f29092k == Long.MIN_VALUE) {
            this.f29092k = j10;
        }
        this.f29089h = o1VarArr;
        this.f29090i = j11;
        t(o1VarArr, j10, j11);
    }

    protected final q f(Throwable th, @Nullable o1 o1Var, int i10) {
        return g(th, o1Var, false, i10);
    }

    protected final q g(Throwable th, @Nullable o1 o1Var, boolean z10, int i10) {
        int iF;
        if (o1Var == null || this.f29094m) {
            iF = 4;
        } else {
            this.f29094m = true;
            try {
                iF = b3.f(a(o1Var));
            } catch (q unused) {
                iF = 4;
            } finally {
                this.f29094m = false;
            }
        }
        return q.g(th, getName(), j(), o1Var, iF, z10, i10);
    }

    @Override // k2.a3
    @Nullable
    public a4.v getMediaClock() {
        return null;
    }

    @Override // k2.a3
    public final long getReadingPositionUs() {
        return this.f29092k;
    }

    @Override // k2.a3
    public final int getState() {
        return this.f29087f;
    }

    @Override // k2.a3
    @Nullable
    public final l3.u0 getStream() {
        return this.f29088g;
    }

    @Override // k2.a3, k2.c3
    public final int getTrackType() {
        return this.f29082a;
    }

    protected final d3 h() {
        return (d3) a4.a.e(this.f29084c);
    }

    @Override // k2.a3
    public final boolean hasReadStreamToEnd() {
        return this.f29092k == Long.MIN_VALUE;
    }

    protected final p1 i() {
        this.f29083b.a();
        return this.f29083b;
    }

    @Override // k2.a3
    public final boolean isCurrentStreamFinal() {
        return this.f29093l;
    }

    protected final int j() {
        return this.f29085d;
    }

    protected final l2.t1 k() {
        return (l2.t1) a4.a.e(this.f29086e);
    }

    protected final o1[] l() {
        return (o1[]) a4.a.e(this.f29089h);
    }

    protected final boolean m() {
        return hasReadStreamToEnd() ? this.f29093l : ((l3.u0) a4.a.e(this.f29088g)).isReady();
    }

    @Override // k2.a3
    public final void maybeThrowStreamError() throws IOException {
        ((l3.u0) a4.a.e(this.f29088g)).maybeThrowError();
    }

    protected abstract void n();

    protected abstract void p(long j10, boolean z10) throws q;

    @Override // k2.a3
    public final void reset() {
        a4.a.g(this.f29087f == 0);
        this.f29083b.a();
        q();
    }

    @Override // k2.a3
    public final void resetPosition(long j10) throws q {
        v(j10, false);
    }

    @Override // k2.a3
    public final void setCurrentStreamFinal() {
        this.f29093l = true;
    }

    @Override // k2.a3
    public /* synthetic */ void setPlaybackSpeed(float f10, float f11) throws q {
        z2.a(this, f10, f11);
    }

    @Override // k2.a3
    public final void start() throws q {
        a4.a.g(this.f29087f == 1);
        this.f29087f = 2;
        r();
    }

    @Override // k2.a3
    public final void stop() {
        a4.a.g(this.f29087f == 2);
        this.f29087f = 1;
        s();
    }

    public int supportsMixedMimeTypeAdaptation() throws q {
        return 0;
    }

    protected abstract void t(o1[] o1VarArr, long j10, long j11) throws q;

    protected final int u(p1 p1Var, n2.g gVar, int i10) {
        int iA = ((l3.u0) a4.a.e(this.f29088g)).a(p1Var, gVar, i10);
        if (iA == -4) {
            if (gVar.h()) {
                this.f29092k = Long.MIN_VALUE;
                return this.f29093l ? -4 : -3;
            }
            long j10 = gVar.f31588e + this.f29090i;
            gVar.f31588e = j10;
            this.f29092k = Math.max(this.f29092k, j10);
        } else if (iA == -5) {
            o1 o1Var = (o1) a4.a.e(p1Var.f29409b);
            if (o1Var.f29351p != Long.MAX_VALUE) {
                p1Var.f29409b = o1Var.b().i0(o1Var.f29351p + this.f29090i).E();
            }
        }
        return iA;
    }

    protected int w(long j10) {
        return ((l3.u0) a4.a.e(this.f29088g)).skipData(j10 - this.f29090i);
    }

    @Override // k2.a3
    public final c3 getCapabilities() {
        return this;
    }

    protected void q() {
    }

    protected void r() throws q {
    }

    protected void s() {
    }

    @Override // k2.v2.b
    public void handleMessage(int i10, @Nullable Object obj) throws q {
    }

    protected void o(boolean z10, boolean z11) throws q {
    }
}

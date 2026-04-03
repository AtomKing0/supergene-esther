package n3;

import a4.o0;
import a4.t;
import a4.x;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import com.google.common.collect.y;
import k2.b3;
import k2.o1;
import k2.p1;

/* JADX INFO: compiled from: TextRenderer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q extends k2.f implements Handler.Callback {
    private int A;
    private long B;
    private long C;
    private long D;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private final Handler f31686n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final p f31687o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final l f31688p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final p1 f31689q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f31690r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f31691s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f31692t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f31693u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private o1 f31694v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    private j f31695w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    private n f31696x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    private o f31697y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    private o f31698z;

    public q(p pVar, @Nullable Looper looper) {
        this(pVar, looper, l.f31671a);
    }

    private long A(long j10) {
        a4.a.g(j10 != C.TIME_UNSET);
        a4.a.g(this.C != C.TIME_UNSET);
        return j10 - this.C;
    }

    private void B(k kVar) {
        t.d("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.f31694v, kVar);
        x();
        G();
    }

    private void C() {
        this.f31692t = true;
        this.f31695w = this.f31688p.b((o1) a4.a.e(this.f31694v));
    }

    private void D(f fVar) {
        this.f31687o.onCues(fVar.f31659a);
        this.f31687o.a(fVar);
    }

    private void E() {
        this.f31696x = null;
        this.A = -1;
        o oVar = this.f31697y;
        if (oVar != null) {
            oVar.l();
            this.f31697y = null;
        }
        o oVar2 = this.f31698z;
        if (oVar2 != null) {
            oVar2.l();
            this.f31698z = null;
        }
    }

    private void F() {
        E();
        ((j) a4.a.e(this.f31695w)).release();
        this.f31695w = null;
        this.f31693u = 0;
    }

    private void G() {
        F();
        C();
    }

    private void I(f fVar) {
        Handler handler = this.f31686n;
        if (handler != null) {
            handler.obtainMessage(0, fVar).sendToTarget();
        } else {
            D(fVar);
        }
    }

    private void x() {
        I(new f(y.q(), A(this.D)));
    }

    private long y(long j10) {
        int nextEventTimeIndex = this.f31697y.getNextEventTimeIndex(j10);
        if (nextEventTimeIndex == 0) {
            return this.f31697y.f31594b;
        }
        if (nextEventTimeIndex != -1) {
            return this.f31697y.getEventTime(nextEventTimeIndex - 1);
        }
        return this.f31697y.getEventTime(r2.getEventTimeCount() - 1);
    }

    private long z() {
        if (this.A == -1) {
            return Long.MAX_VALUE;
        }
        a4.a.e(this.f31697y);
        if (this.A >= this.f31697y.getEventTimeCount()) {
            return Long.MAX_VALUE;
        }
        return this.f31697y.getEventTime(this.A);
    }

    public void H(long j10) {
        a4.a.g(isCurrentStreamFinal());
        this.B = j10;
    }

    @Override // k2.c3
    public int a(o1 o1Var) {
        if (this.f31688p.a(o1Var)) {
            return b3.a(o1Var.E == 0 ? 4 : 2);
        }
        return x.n(o1Var.f29347l) ? b3.a(1) : b3.a(0);
    }

    @Override // k2.a3, k2.c3
    public String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        D((f) message.obj);
        return true;
    }

    @Override // k2.a3
    public boolean isEnded() {
        return this.f31691s;
    }

    @Override // k2.a3
    public boolean isReady() {
        return true;
    }

    @Override // k2.f
    protected void n() {
        this.f31694v = null;
        this.B = C.TIME_UNSET;
        x();
        this.C = C.TIME_UNSET;
        this.D = C.TIME_UNSET;
        F();
    }

    @Override // k2.f
    protected void p(long j10, boolean z10) {
        this.D = j10;
        x();
        this.f31690r = false;
        this.f31691s = false;
        this.B = C.TIME_UNSET;
        if (this.f31693u != 0) {
            G();
        } else {
            E();
            ((j) a4.a.e(this.f31695w)).flush();
        }
    }

    @Override // k2.a3
    public void render(long j10, long j11) throws n2.f {
        boolean z10;
        this.D = j10;
        if (isCurrentStreamFinal()) {
            long j12 = this.B;
            if (j12 != C.TIME_UNSET && j10 >= j12) {
                E();
                this.f31691s = true;
            }
        }
        if (this.f31691s) {
            return;
        }
        if (this.f31698z == null) {
            ((j) a4.a.e(this.f31695w)).setPositionUs(j10);
            try {
                this.f31698z = ((j) a4.a.e(this.f31695w)).dequeueOutputBuffer();
            } catch (k e10) {
                B(e10);
                return;
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.f31697y != null) {
            long jZ = z();
            z10 = false;
            while (jZ <= j10) {
                this.A++;
                jZ = z();
                z10 = true;
            }
        } else {
            z10 = false;
        }
        o oVar = this.f31698z;
        if (oVar != null) {
            if (oVar.h()) {
                if (!z10 && z() == Long.MAX_VALUE) {
                    if (this.f31693u == 2) {
                        G();
                    } else {
                        E();
                        this.f31691s = true;
                    }
                }
            } else if (oVar.f31594b <= j10) {
                o oVar2 = this.f31697y;
                if (oVar2 != null) {
                    oVar2.l();
                }
                this.A = oVar.getNextEventTimeIndex(j10);
                this.f31697y = oVar;
                this.f31698z = null;
                z10 = true;
            }
        }
        if (z10) {
            a4.a.e(this.f31697y);
            I(new f(this.f31697y.getCues(j10), A(y(j10))));
        }
        if (this.f31693u == 2) {
            return;
        }
        while (!this.f31690r) {
            try {
                n nVarDequeueInputBuffer = this.f31696x;
                if (nVarDequeueInputBuffer == null) {
                    nVarDequeueInputBuffer = ((j) a4.a.e(this.f31695w)).dequeueInputBuffer();
                    if (nVarDequeueInputBuffer == null) {
                        return;
                    } else {
                        this.f31696x = nVarDequeueInputBuffer;
                    }
                }
                if (this.f31693u == 1) {
                    nVarDequeueInputBuffer.k(4);
                    ((j) a4.a.e(this.f31695w)).queueInputBuffer(nVarDequeueInputBuffer);
                    this.f31696x = null;
                    this.f31693u = 2;
                    return;
                }
                int iU = u(this.f31689q, nVarDequeueInputBuffer, 0);
                if (iU == -4) {
                    if (nVarDequeueInputBuffer.h()) {
                        this.f31690r = true;
                        this.f31692t = false;
                    } else {
                        o1 o1Var = this.f31689q.f29409b;
                        if (o1Var == null) {
                            return;
                        }
                        nVarDequeueInputBuffer.f31683i = o1Var.f29351p;
                        nVarDequeueInputBuffer.n();
                        this.f31692t &= !nVarDequeueInputBuffer.j();
                    }
                    if (!this.f31692t) {
                        ((j) a4.a.e(this.f31695w)).queueInputBuffer(nVarDequeueInputBuffer);
                        this.f31696x = null;
                    }
                } else if (iU == -3) {
                    return;
                }
            } catch (k e11) {
                B(e11);
                return;
            }
        }
    }

    @Override // k2.f
    protected void t(o1[] o1VarArr, long j10, long j11) {
        this.C = j11;
        this.f31694v = o1VarArr[0];
        if (this.f31695w != null) {
            this.f31693u = 1;
        } else {
            C();
        }
    }

    public q(p pVar, @Nullable Looper looper, l lVar) {
        super(3);
        this.f31687o = (p) a4.a.e(pVar);
        this.f31686n = looper == null ? null : o0.t(looper, this);
        this.f31688p = lVar;
        this.f31689q = new p1();
        this.B = C.TIME_UNSET;
        this.C = C.TIME_UNSET;
        this.D = C.TIME_UNSET;
    }
}

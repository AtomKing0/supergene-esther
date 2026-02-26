package k2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.PlaybackException;
import androidx.media3.exoplayer.MediaPeriodQueue;
import c3.a;
import com.google.common.collect.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import k2.a3;
import k2.i2;
import k2.l;
import k2.n3;
import k2.v2;
import k2.w1;
import l3.a0;
import l3.x;
import o2.o;
import x3.b0;

/* JADX INFO: compiled from: ExoPlayerImplInternal.java */
/* JADX INFO: loaded from: classes2.dex */
final class k1 implements Handler.Callback, x.a, b0.a, i2.d, l.a, v2.a {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private int E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private int J;

    @Nullable
    private h K;
    private long L;
    private int M;
    private boolean N;

    @Nullable
    private q O;
    private long P;
    private long Q = C.TIME_UNSET;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a3[] f29210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<a3> f29211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c3[] f29212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final x3.b0 f29213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final x3.c0 f29214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final u1 f29215f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final z3.e f29216g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a4.p f29217h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final HandlerThread f29218i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Looper f29219j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final n3.d f29220k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final n3.b f29221l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f29222m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f29223n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final l f29224o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ArrayList<d> f29225p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final a4.d f29226q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final f f29227r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final f2 f29228s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final i2 f29229t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final t1 f29230u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final long f29231v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private f3 f29232w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private o2 f29233x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private e f29234y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f29235z;

    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    class a implements a3.a {
        a() {
        }

        @Override // k2.a3.a
        public void onSleep() {
            k1.this.H = true;
        }

        @Override // k2.a3.a
        public void onWakeup() {
            k1.this.f29217h.sendEmptyMessage(2);
        }
    }

    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<i2.c> f29237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final l3.w0 f29238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f29239c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f29240d;

        /* synthetic */ b(List list, l3.w0 w0Var, int i10, long j10, a aVar) {
            this(list, w0Var, i10, j10);
        }

        private b(List<i2.c> list, l3.w0 w0Var, int i10, long j10) {
            this.f29237a = list;
            this.f29238b = w0Var;
            this.f29239c = i10;
            this.f29240d = j10;
        }
    }

    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f29241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f29242b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f29243c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final l3.w0 f29244d;
    }

    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    private static final class d implements Comparable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v2 f29245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f29246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f29247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public Object f29248d;

        public d(v2 v2Var) {
            this.f29245a = v2Var;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            Object obj = this.f29248d;
            if ((obj == null) != (dVar.f29248d == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i10 = this.f29246b - dVar.f29246b;
            return i10 != 0 ? i10 : a4.o0.n(this.f29247c, dVar.f29247c);
        }

        public void c(int i10, long j10, Object obj) {
            this.f29246b = i10;
            this.f29247c = j10;
            this.f29248d = obj;
        }
    }

    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f29249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public o2 f29250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f29251c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f29252d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f29253e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f29254f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f29255g;

        public e(o2 o2Var) {
            this.f29250b = o2Var;
        }

        public void b(int i10) {
            this.f29249a |= i10 > 0;
            this.f29251c += i10;
        }

        public void c(int i10) {
            this.f29249a = true;
            this.f29254f = true;
            this.f29255g = i10;
        }

        public void d(o2 o2Var) {
            this.f29249a |= this.f29250b != o2Var;
            this.f29250b = o2Var;
        }

        public void e(int i10) {
            if (this.f29252d && this.f29253e != 5) {
                a4.a.a(i10 == 5);
                return;
            }
            this.f29249a = true;
            this.f29252d = true;
            this.f29253e = i10;
        }
    }

    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    public interface f {
        void a(e eVar);
    }

    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    private static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a0.b f29256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f29257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f29258c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f29259d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f29260e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f29261f;

        public g(a0.b bVar, long j10, long j11, boolean z10, boolean z11, boolean z12) {
            this.f29256a = bVar;
            this.f29257b = j10;
            this.f29258c = j11;
            this.f29259d = z10;
            this.f29260e = z11;
            this.f29261f = z12;
        }
    }

    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    private static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n3 f29262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f29263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f29264c;

        public h(n3 n3Var, int i10, long j10) {
            this.f29262a = n3Var;
            this.f29263b = i10;
            this.f29264c = j10;
        }
    }

    public k1(a3[] a3VarArr, x3.b0 b0Var, x3.c0 c0Var, u1 u1Var, z3.e eVar, int i10, boolean z10, l2.a aVar, f3 f3Var, t1 t1Var, long j10, boolean z11, Looper looper, a4.d dVar, f fVar, l2.t1 t1Var2) {
        this.f29227r = fVar;
        this.f29210a = a3VarArr;
        this.f29213d = b0Var;
        this.f29214e = c0Var;
        this.f29215f = u1Var;
        this.f29216g = eVar;
        this.E = i10;
        this.F = z10;
        this.f29232w = f3Var;
        this.f29230u = t1Var;
        this.f29231v = j10;
        this.P = j10;
        this.A = z11;
        this.f29226q = dVar;
        this.f29222m = u1Var.getBackBufferDurationUs();
        this.f29223n = u1Var.retainBackBufferFromKeyframe();
        o2 o2VarJ = o2.j(c0Var);
        this.f29233x = o2VarJ;
        this.f29234y = new e(o2VarJ);
        this.f29212c = new c3[a3VarArr.length];
        for (int i11 = 0; i11 < a3VarArr.length; i11++) {
            a3VarArr[i11].d(i11, t1Var2);
            this.f29212c[i11] = a3VarArr[i11].getCapabilities();
        }
        this.f29224o = new l(this, dVar);
        this.f29225p = new ArrayList<>();
        this.f29211b = com.google.common.collect.c1.h();
        this.f29220k = new n3.d();
        this.f29221l = new n3.b();
        b0Var.c(this, eVar);
        this.N = true;
        Handler handler = new Handler(looper);
        this.f29228s = new f2(aVar, handler);
        this.f29229t = new i2(this, aVar, handler, t1Var2);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.f29218i = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.f29219j = looper2;
        this.f29217h = dVar.createHandler(looper2, this);
    }

    private long A(long j10) {
        c2 c2VarJ = this.f29228s.j();
        if (c2VarJ == null) {
            return 0L;
        }
        return Math.max(0L, j10 - c2VarJ.y(this.L));
    }

    private long A0(a0.b bVar, long j10, boolean z10) throws q {
        return B0(bVar, j10, this.f29228s.p() != this.f29228s.q(), z10);
    }

    private void B(l3.x xVar) {
        if (this.f29228s.v(xVar)) {
            this.f29228s.y(this.L);
            S();
        }
    }

    private long B0(a0.b bVar, long j10, boolean z10, boolean z11) throws q {
        f1();
        this.C = false;
        if (z11 || this.f29233x.f29393e == 3) {
            W0(2);
        }
        c2 c2VarP = this.f29228s.p();
        c2 c2VarJ = c2VarP;
        while (c2VarJ != null && !bVar.equals(c2VarJ.f29040f.f29065a)) {
            c2VarJ = c2VarJ.j();
        }
        if (z10 || c2VarP != c2VarJ || (c2VarJ != null && c2VarJ.z(j10) < 0)) {
            for (a3 a3Var : this.f29210a) {
                l(a3Var);
            }
            if (c2VarJ != null) {
                while (this.f29228s.p() != c2VarJ) {
                    this.f29228s.b();
                }
                this.f29228s.z(c2VarJ);
                c2VarJ.x(MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US);
                o();
            }
        }
        if (c2VarJ != null) {
            this.f29228s.z(c2VarJ);
            if (!c2VarJ.f29038d) {
                c2VarJ.f29040f = c2VarJ.f29040f.b(j10);
            } else if (c2VarJ.f29039e) {
                long jSeekToUs = c2VarJ.f29035a.seekToUs(j10);
                c2VarJ.f29035a.discardBuffer(jSeekToUs - this.f29222m, this.f29223n);
                j10 = jSeekToUs;
            }
            p0(j10);
            S();
        } else {
            this.f29228s.f();
            p0(j10);
        }
        D(false);
        this.f29217h.sendEmptyMessage(2);
        return j10;
    }

    private void C(IOException iOException, int i10) {
        q qVarH = q.h(iOException, i10);
        c2 c2VarP = this.f29228s.p();
        if (c2VarP != null) {
            qVarH = qVarH.f(c2VarP.f29040f.f29065a);
        }
        a4.t.d("ExoPlayerImplInternal", "Playback error", qVarH);
        e1(false, false);
        this.f29233x = this.f29233x.e(qVarH);
    }

    private void C0(v2 v2Var) throws q {
        if (v2Var.f() == C.TIME_UNSET) {
            D0(v2Var);
            return;
        }
        if (this.f29233x.f29389a.u()) {
            this.f29225p.add(new d(v2Var));
            return;
        }
        d dVar = new d(v2Var);
        n3 n3Var = this.f29233x.f29389a;
        if (!r0(dVar, n3Var, n3Var, this.E, this.F, this.f29220k, this.f29221l)) {
            v2Var.k(false);
        } else {
            this.f29225p.add(dVar);
            Collections.sort(this.f29225p);
        }
    }

    private void D(boolean z10) {
        c2 c2VarJ = this.f29228s.j();
        a0.b bVar = c2VarJ == null ? this.f29233x.f29390b : c2VarJ.f29040f.f29065a;
        boolean z11 = !this.f29233x.f29399k.equals(bVar);
        if (z11) {
            this.f29233x = this.f29233x.b(bVar);
        }
        o2 o2Var = this.f29233x;
        o2Var.f29404p = c2VarJ == null ? o2Var.f29406r : c2VarJ.i();
        this.f29233x.f29405q = z();
        if ((z11 || z10) && c2VarJ != null && c2VarJ.f29038d) {
            h1(c2VarJ.n(), c2VarJ.o());
        }
    }

    private void D0(v2 v2Var) throws q {
        if (v2Var.c() != this.f29219j) {
            this.f29217h.obtainMessage(15, v2Var).sendToTarget();
            return;
        }
        k(v2Var);
        int i10 = this.f29233x.f29393e;
        if (i10 == 3 || i10 == 2) {
            this.f29217h.sendEmptyMessage(2);
        }
    }

    private void E(n3 n3Var, boolean z10) throws Throwable {
        int i10;
        int i11;
        boolean z11;
        g gVarT0 = t0(n3Var, this.f29233x, this.K, this.f29228s, this.E, this.F, this.f29220k, this.f29221l);
        a0.b bVar = gVarT0.f29256a;
        long j10 = gVarT0.f29258c;
        boolean z12 = gVarT0.f29259d;
        long jA0 = gVarT0.f29257b;
        boolean z13 = (this.f29233x.f29390b.equals(bVar) && jA0 == this.f29233x.f29406r) ? false : true;
        h hVar = null;
        long j11 = C.TIME_UNSET;
        try {
            if (gVarT0.f29260e) {
                if (this.f29233x.f29393e != 1) {
                    W0(4);
                }
                n0(false, false, false, true);
            }
            try {
                if (z13) {
                    i11 = 4;
                    z11 = false;
                    if (!n3Var.u()) {
                        for (c2 c2VarP = this.f29228s.p(); c2VarP != null; c2VarP = c2VarP.j()) {
                            if (c2VarP.f29040f.f29065a.equals(bVar)) {
                                c2VarP.f29040f = this.f29228s.r(n3Var, c2VarP.f29040f);
                                c2VarP.A();
                            }
                        }
                        jA0 = A0(bVar, jA0, z12);
                    }
                } else {
                    try {
                        i11 = 4;
                        z11 = false;
                        if (!this.f29228s.F(n3Var, this.L, w())) {
                            y0(false);
                        }
                    } catch (Throwable th) {
                        th = th;
                        i10 = 4;
                        o2 o2Var = this.f29233x;
                        n3 n3Var2 = o2Var.f29389a;
                        a0.b bVar2 = o2Var.f29390b;
                        if (gVarT0.f29261f) {
                            j11 = jA0;
                        }
                        h hVar2 = hVar;
                        k1(n3Var, bVar, n3Var2, bVar2, j11);
                        if (z13 || j10 != this.f29233x.f29391c) {
                            o2 o2Var2 = this.f29233x;
                            Object obj = o2Var2.f29390b.f30778a;
                            n3 n3Var3 = o2Var2.f29389a;
                            this.f29233x = I(bVar, jA0, j10, this.f29233x.f29392d, z13 && z10 && !n3Var3.u() && !n3Var3.l(obj, this.f29221l).f29303f, n3Var.f(obj) == -1 ? i10 : 3);
                        }
                        o0();
                        s0(n3Var, this.f29233x.f29389a);
                        this.f29233x = this.f29233x.i(n3Var);
                        if (!n3Var.u()) {
                            this.K = hVar2;
                        }
                        D(false);
                        throw th;
                    }
                }
                o2 o2Var3 = this.f29233x;
                k1(n3Var, bVar, o2Var3.f29389a, o2Var3.f29390b, gVarT0.f29261f ? jA0 : -9223372036854775807L);
                if (z13 || j10 != this.f29233x.f29391c) {
                    o2 o2Var4 = this.f29233x;
                    Object obj2 = o2Var4.f29390b.f30778a;
                    n3 n3Var4 = o2Var4.f29389a;
                    this.f29233x = I(bVar, jA0, j10, this.f29233x.f29392d, (!z13 || !z10 || n3Var4.u() || n3Var4.l(obj2, this.f29221l).f29303f) ? z11 : true, n3Var.f(obj2) == -1 ? i11 : 3);
                }
                o0();
                s0(n3Var, this.f29233x.f29389a);
                this.f29233x = this.f29233x.i(n3Var);
                if (!n3Var.u()) {
                    this.K = null;
                }
                D(z11);
            } catch (Throwable th2) {
                th = th2;
                hVar = null;
            }
        } catch (Throwable th3) {
            th = th3;
            i10 = 4;
        }
    }

    private void E0(final v2 v2Var) {
        Looper looperC = v2Var.c();
        if (looperC.getThread().isAlive()) {
            this.f29226q.createHandler(looperC, null).post(new Runnable() { // from class: k2.j1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f29193a.R(v2Var);
                }
            });
        } else {
            a4.t.i("TAG", "Trying to send message on a dead thread.");
            v2Var.k(false);
        }
    }

    private void F(l3.x xVar) throws q {
        if (this.f29228s.v(xVar)) {
            c2 c2VarJ = this.f29228s.j();
            c2VarJ.p(this.f29224o.getPlaybackParameters().f29421a, this.f29233x.f29389a);
            h1(c2VarJ.n(), c2VarJ.o());
            if (c2VarJ == this.f29228s.p()) {
                p0(c2VarJ.f29040f.f29066b);
                o();
                o2 o2Var = this.f29233x;
                a0.b bVar = o2Var.f29390b;
                long j10 = c2VarJ.f29040f.f29066b;
                this.f29233x = I(bVar, j10, o2Var.f29391c, j10, false, 5);
            }
            S();
        }
    }

    private void F0(long j10) {
        for (a3 a3Var : this.f29210a) {
            if (a3Var.getStream() != null) {
                G0(a3Var, j10);
            }
        }
    }

    private void G(q2 q2Var, float f10, boolean z10, boolean z11) throws q {
        if (z10) {
            if (z11) {
                this.f29234y.b(1);
            }
            this.f29233x = this.f29233x.f(q2Var);
        }
        l1(q2Var.f29421a);
        for (a3 a3Var : this.f29210a) {
            if (a3Var != null) {
                a3Var.setPlaybackSpeed(f10, q2Var.f29421a);
            }
        }
    }

    private void G0(a3 a3Var, long j10) {
        a3Var.setCurrentStreamFinal();
        if (a3Var instanceof n3.q) {
            ((n3.q) a3Var).H(j10);
        }
    }

    private void H(q2 q2Var, boolean z10) throws q {
        G(q2Var, q2Var.f29421a, true, z10);
    }

    private void H0(boolean z10, @Nullable AtomicBoolean atomicBoolean) {
        if (this.G != z10) {
            this.G = z10;
            if (!z10) {
                for (a3 a3Var : this.f29210a) {
                    if (!N(a3Var) && this.f29211b.remove(a3Var)) {
                        a3Var.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    @CheckResult
    private o2 I(a0.b bVar, long j10, long j11, long j12, boolean z10, int i10) {
        List<c3.a> listQ;
        l3.e1 e1Var;
        x3.c0 c0Var;
        this.N = (!this.N && j10 == this.f29233x.f29406r && bVar.equals(this.f29233x.f29390b)) ? false : true;
        o0();
        o2 o2Var = this.f29233x;
        l3.e1 e1Var2 = o2Var.f29396h;
        x3.c0 c0Var2 = o2Var.f29397i;
        List<c3.a> list = o2Var.f29398j;
        if (this.f29229t.s()) {
            c2 c2VarP = this.f29228s.p();
            l3.e1 e1VarN = c2VarP == null ? l3.e1.f30515d : c2VarP.n();
            x3.c0 c0VarO = c2VarP == null ? this.f29214e : c2VarP.o();
            com.google.common.collect.y<c3.a> yVarS = s(c0VarO.f35935c);
            if (c2VarP != null) {
                d2 d2Var = c2VarP.f29040f;
                if (d2Var.f29067c != j11) {
                    c2VarP.f29040f = d2Var.a(j11);
                }
            }
            e1Var = e1VarN;
            c0Var = c0VarO;
            listQ = yVarS;
        } else if (bVar.equals(this.f29233x.f29390b)) {
            listQ = list;
            e1Var = e1Var2;
            c0Var = c0Var2;
        } else {
            e1Var = l3.e1.f30515d;
            c0Var = this.f29214e;
            listQ = com.google.common.collect.y.q();
        }
        if (z10) {
            this.f29234y.e(i10);
        }
        return this.f29233x.c(bVar, j10, j11, j12, z(), e1Var, c0Var, listQ);
    }

    private void I0(b bVar) throws Throwable {
        this.f29234y.b(1);
        if (bVar.f29239c != -1) {
            this.K = new h(new w2(bVar.f29237a, bVar.f29238b), bVar.f29239c, bVar.f29240d);
        }
        E(this.f29229t.C(bVar.f29237a, bVar.f29238b), false);
    }

    private boolean J(a3 a3Var, c2 c2Var) {
        c2 c2VarJ = c2Var.j();
        return c2Var.f29040f.f29070f && c2VarJ.f29038d && ((a3Var instanceof n3.q) || (a3Var instanceof c3.g) || a3Var.getReadingPositionUs() >= c2VarJ.m());
    }

    private boolean K() {
        c2 c2VarQ = this.f29228s.q();
        if (!c2VarQ.f29038d) {
            return false;
        }
        int i10 = 0;
        while (true) {
            a3[] a3VarArr = this.f29210a;
            if (i10 >= a3VarArr.length) {
                return true;
            }
            a3 a3Var = a3VarArr[i10];
            l3.u0 u0Var = c2VarQ.f29037c[i10];
            if (a3Var.getStream() != u0Var || (u0Var != null && !a3Var.hasReadStreamToEnd() && !J(a3Var, c2VarQ))) {
                break;
            }
            i10++;
        }
        return false;
    }

    private void K0(boolean z10) {
        if (z10 == this.I) {
            return;
        }
        this.I = z10;
        if (z10 || !this.f29233x.f29403o) {
            return;
        }
        this.f29217h.sendEmptyMessage(2);
    }

    private static boolean L(boolean z10, a0.b bVar, long j10, a0.b bVar2, n3.b bVar3, long j11) {
        if (!z10 && j10 == j11 && bVar.f30778a.equals(bVar2.f30778a)) {
            return (bVar.b() && bVar3.t(bVar.f30779b)) ? (bVar3.k(bVar.f30779b, bVar.f30780c) == 4 || bVar3.k(bVar.f30779b, bVar.f30780c) == 2) ? false : true : bVar2.b() && bVar3.t(bVar2.f30779b);
        }
        return false;
    }

    private void L0(boolean z10) throws q {
        this.A = z10;
        o0();
        if (!this.B || this.f29228s.q() == this.f29228s.p()) {
            return;
        }
        y0(true);
        D(false);
    }

    private boolean M() {
        c2 c2VarJ = this.f29228s.j();
        return (c2VarJ == null || c2VarJ.k() == Long.MIN_VALUE) ? false : true;
    }

    private static boolean N(a3 a3Var) {
        return a3Var.getState() != 0;
    }

    private void N0(boolean z10, int i10, boolean z11, int i11) throws q {
        this.f29234y.b(z11 ? 1 : 0);
        this.f29234y.c(i11);
        this.f29233x = this.f29233x.d(z10, i10);
        this.C = false;
        c0(z10);
        if (!Z0()) {
            f1();
            j1();
            return;
        }
        int i12 = this.f29233x.f29393e;
        if (i12 == 3) {
            c1();
            this.f29217h.sendEmptyMessage(2);
        } else if (i12 == 2) {
            this.f29217h.sendEmptyMessage(2);
        }
    }

    private boolean O() {
        c2 c2VarP = this.f29228s.p();
        long j10 = c2VarP.f29040f.f29069e;
        return c2VarP.f29038d && (j10 == C.TIME_UNSET || this.f29233x.f29406r < j10 || !Z0());
    }

    private static boolean P(o2 o2Var, n3.b bVar) {
        a0.b bVar2 = o2Var.f29390b;
        n3 n3Var = o2Var.f29389a;
        return n3Var.u() || n3Var.l(bVar2.f30778a, bVar).f29303f;
    }

    private void P0(q2 q2Var) throws q {
        this.f29224o.b(q2Var);
        H(this.f29224o.getPlaybackParameters(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean Q() {
        return Boolean.valueOf(this.f29235z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(v2 v2Var) {
        try {
            k(v2Var);
        } catch (q e10) {
            a4.t.d("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e10);
            throw new RuntimeException(e10);
        }
    }

    private void R0(int i10) throws q {
        this.E = i10;
        if (!this.f29228s.G(this.f29233x.f29389a, i10)) {
            y0(true);
        }
        D(false);
    }

    private void S() {
        boolean zY0 = Y0();
        this.D = zY0;
        if (zY0) {
            this.f29228s.j().d(this.L);
        }
        g1();
    }

    private void S0(f3 f3Var) {
        this.f29232w = f3Var;
    }

    private void T() {
        this.f29234y.d(this.f29233x);
        if (this.f29234y.f29249a) {
            this.f29227r.a(this.f29234y);
            this.f29234y = new e(this.f29233x);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0045, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0074, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void U(long r8, long r10) throws k2.q {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.k1.U(long, long):void");
    }

    private void U0(boolean z10) throws q {
        this.F = z10;
        if (!this.f29228s.H(this.f29233x.f29389a, z10)) {
            y0(true);
        }
        D(false);
    }

    private void V() throws q {
        d2 d2VarO;
        this.f29228s.y(this.L);
        if (this.f29228s.D() && (d2VarO = this.f29228s.o(this.L, this.f29233x)) != null) {
            c2 c2VarG = this.f29228s.g(this.f29212c, this.f29213d, this.f29215f.getAllocator(), this.f29229t, d2VarO, this.f29214e);
            c2VarG.f29035a.b(this, d2VarO.f29066b);
            if (this.f29228s.p() == c2VarG) {
                p0(d2VarO.f29066b);
            }
            D(false);
        }
        if (!this.D) {
            S();
        } else {
            this.D = M();
            g1();
        }
    }

    private void V0(l3.w0 w0Var) throws Throwable {
        this.f29234y.b(1);
        E(this.f29229t.D(w0Var), false);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void W() throws k2.q {
        /*
            r14 = this;
            r0 = 0
            r1 = r0
        L2:
            boolean r2 = r14.X0()
            if (r2 == 0) goto L61
            if (r1 == 0) goto Ld
            r14.T()
        Ld:
            k2.f2 r1 = r14.f29228s
            k2.c2 r1 = r1.b()
            java.lang.Object r1 = a4.a.e(r1)
            k2.c2 r1 = (k2.c2) r1
            k2.o2 r2 = r14.f29233x
            l3.a0$b r2 = r2.f29390b
            java.lang.Object r2 = r2.f30778a
            k2.d2 r3 = r1.f29040f
            l3.a0$b r3 = r3.f29065a
            java.lang.Object r3 = r3.f30778a
            boolean r2 = r2.equals(r3)
            r3 = 1
            if (r2 == 0) goto L45
            k2.o2 r2 = r14.f29233x
            l3.a0$b r2 = r2.f29390b
            int r4 = r2.f30779b
            r5 = -1
            if (r4 != r5) goto L45
            k2.d2 r4 = r1.f29040f
            l3.a0$b r4 = r4.f29065a
            int r6 = r4.f30779b
            if (r6 != r5) goto L45
            int r2 = r2.f30782e
            int r4 = r4.f30782e
            if (r2 == r4) goto L45
            r2 = r3
            goto L46
        L45:
            r2 = r0
        L46:
            k2.d2 r1 = r1.f29040f
            l3.a0$b r5 = r1.f29065a
            long r10 = r1.f29066b
            long r8 = r1.f29067c
            r12 = r2 ^ 1
            r13 = 0
            r4 = r14
            r6 = r10
            k2.o2 r1 = r4.I(r5, r6, r8, r10, r12, r13)
            r14.f29233x = r1
            r14.o0()
            r14.j1()
            r1 = r3
            goto L2
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.k1.W():void");
    }

    private void W0(int i10) {
        o2 o2Var = this.f29233x;
        if (o2Var.f29393e != i10) {
            if (i10 != 2) {
                this.Q = C.TIME_UNSET;
            }
            this.f29233x = o2Var.g(i10);
        }
    }

    private void X() {
        c2 c2VarQ = this.f29228s.q();
        if (c2VarQ == null) {
            return;
        }
        int i10 = 0;
        if (c2VarQ.j() != null && !this.B) {
            if (K()) {
                if (c2VarQ.j().f29038d || this.L >= c2VarQ.j().m()) {
                    x3.c0 c0VarO = c2VarQ.o();
                    c2 c2VarC = this.f29228s.c();
                    x3.c0 c0VarO2 = c2VarC.o();
                    n3 n3Var = this.f29233x.f29389a;
                    k1(n3Var, c2VarC.f29040f.f29065a, n3Var, c2VarQ.f29040f.f29065a, C.TIME_UNSET);
                    if (c2VarC.f29038d && c2VarC.f29035a.readDiscontinuity() != C.TIME_UNSET) {
                        F0(c2VarC.m());
                        return;
                    }
                    for (int i11 = 0; i11 < this.f29210a.length; i11++) {
                        boolean zC = c0VarO.c(i11);
                        boolean zC2 = c0VarO2.c(i11);
                        if (zC && !this.f29210a[i11].isCurrentStreamFinal()) {
                            boolean z10 = this.f29212c[i11].getTrackType() == -2;
                            d3 d3Var = c0VarO.f35934b[i11];
                            d3 d3Var2 = c0VarO2.f35934b[i11];
                            if (!zC2 || !d3Var2.equals(d3Var) || z10) {
                                G0(this.f29210a[i11], c2VarC.m());
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (!c2VarQ.f29040f.f29073i && !this.B) {
            return;
        }
        while (true) {
            a3[] a3VarArr = this.f29210a;
            if (i10 >= a3VarArr.length) {
                return;
            }
            a3 a3Var = a3VarArr[i10];
            l3.u0 u0Var = c2VarQ.f29037c[i10];
            if (u0Var != null && a3Var.getStream() == u0Var && a3Var.hasReadStreamToEnd()) {
                long j10 = c2VarQ.f29040f.f29069e;
                G0(a3Var, (j10 == C.TIME_UNSET || j10 == Long.MIN_VALUE) ? -9223372036854775807L : c2VarQ.l() + c2VarQ.f29040f.f29069e);
            }
            i10++;
        }
    }

    private boolean X0() {
        c2 c2VarP;
        c2 c2VarJ;
        return Z0() && !this.B && (c2VarP = this.f29228s.p()) != null && (c2VarJ = c2VarP.j()) != null && this.L >= c2VarJ.m() && c2VarJ.f29041g;
    }

    private void Y() throws q {
        c2 c2VarQ = this.f29228s.q();
        if (c2VarQ == null || this.f29228s.p() == c2VarQ || c2VarQ.f29041g || !l0()) {
            return;
        }
        o();
    }

    private boolean Y0() {
        if (!M()) {
            return false;
        }
        c2 c2VarJ = this.f29228s.j();
        long jA = A(c2VarJ.k());
        long jY = c2VarJ == this.f29228s.p() ? c2VarJ.y(this.L) : c2VarJ.y(this.L) - c2VarJ.f29040f.f29066b;
        boolean zShouldContinueLoading = this.f29215f.shouldContinueLoading(jY, jA, this.f29224o.getPlaybackParameters().f29421a);
        if (zShouldContinueLoading || jA >= 500000) {
            return zShouldContinueLoading;
        }
        if (this.f29222m <= 0 && !this.f29223n) {
            return zShouldContinueLoading;
        }
        this.f29228s.p().f29035a.discardBuffer(this.f29233x.f29406r, false);
        return this.f29215f.shouldContinueLoading(jY, jA, this.f29224o.getPlaybackParameters().f29421a);
    }

    private void Z() throws Throwable {
        E(this.f29229t.i(), true);
    }

    private boolean Z0() {
        o2 o2Var = this.f29233x;
        return o2Var.f29400l && o2Var.f29401m == 0;
    }

    private void a0(c cVar) throws Throwable {
        this.f29234y.b(1);
        E(this.f29229t.v(cVar.f29241a, cVar.f29242b, cVar.f29243c, cVar.f29244d), false);
    }

    private boolean a1(boolean z10) {
        if (this.J == 0) {
            return O();
        }
        if (!z10) {
            return false;
        }
        o2 o2Var = this.f29233x;
        if (!o2Var.f29395g) {
            return true;
        }
        long targetLiveOffsetUs = b1(o2Var.f29389a, this.f29228s.p().f29040f.f29065a) ? this.f29230u.getTargetLiveOffsetUs() : C.TIME_UNSET;
        c2 c2VarJ = this.f29228s.j();
        return (c2VarJ.q() && c2VarJ.f29040f.f29073i) || (c2VarJ.f29040f.f29065a.b() && !c2VarJ.f29038d) || this.f29215f.shouldStartPlayback(z(), this.f29224o.getPlaybackParameters().f29421a, this.C, targetLiveOffsetUs);
    }

    private void b0() {
        for (c2 c2VarP = this.f29228s.p(); c2VarP != null; c2VarP = c2VarP.j()) {
            for (x3.s sVar : c2VarP.o().f35935c) {
                if (sVar != null) {
                    sVar.onDiscontinuity();
                }
            }
        }
    }

    private boolean b1(n3 n3Var, a0.b bVar) {
        if (bVar.b() || n3Var.u()) {
            return false;
        }
        n3Var.r(n3Var.l(bVar.f30778a, this.f29221l).f29300c, this.f29220k);
        if (!this.f29220k.i()) {
            return false;
        }
        n3.d dVar = this.f29220k;
        return dVar.f29321i && dVar.f29318f != C.TIME_UNSET;
    }

    private void c0(boolean z10) {
        for (c2 c2VarP = this.f29228s.p(); c2VarP != null; c2VarP = c2VarP.j()) {
            for (x3.s sVar : c2VarP.o().f35935c) {
                if (sVar != null) {
                    sVar.onPlayWhenReadyChanged(z10);
                }
            }
        }
    }

    private void c1() throws q {
        this.C = false;
        this.f29224o.f();
        for (a3 a3Var : this.f29210a) {
            if (N(a3Var)) {
                a3Var.start();
            }
        }
    }

    private void d0() {
        for (c2 c2VarP = this.f29228s.p(); c2VarP != null; c2VarP = c2VarP.j()) {
            for (x3.s sVar : c2VarP.o().f35935c) {
                if (sVar != null) {
                    sVar.onRebuffer();
                }
            }
        }
    }

    private void e1(boolean z10, boolean z11) {
        n0(z10 || !this.G, false, true, false);
        this.f29234y.b(z11 ? 1 : 0);
        this.f29215f.onStopped();
        W0(1);
    }

    private void f1() throws q {
        this.f29224o.g();
        for (a3 a3Var : this.f29210a) {
            if (N(a3Var)) {
                q(a3Var);
            }
        }
    }

    private void g0() {
        this.f29234y.b(1);
        n0(false, false, false, true);
        this.f29215f.onPrepared();
        W0(this.f29233x.f29389a.u() ? 4 : 2);
        this.f29229t.w(this.f29216g.getTransferListener());
        this.f29217h.sendEmptyMessage(2);
    }

    private void g1() {
        c2 c2VarJ = this.f29228s.j();
        boolean z10 = this.D || (c2VarJ != null && c2VarJ.f29035a.isLoading());
        o2 o2Var = this.f29233x;
        if (z10 != o2Var.f29395g) {
            this.f29233x = o2Var.a(z10);
        }
    }

    private void h1(l3.e1 e1Var, x3.c0 c0Var) {
        this.f29215f.a(this.f29210a, e1Var, c0Var.f35935c);
    }

    private void i(b bVar, int i10) throws Throwable {
        this.f29234y.b(1);
        i2 i2Var = this.f29229t;
        if (i10 == -1) {
            i10 = i2Var.q();
        }
        E(i2Var.f(i10, bVar.f29237a, bVar.f29238b), false);
    }

    private void i0() {
        n0(true, false, true, false);
        this.f29215f.onReleased();
        W0(1);
        this.f29218i.quit();
        synchronized (this) {
            this.f29235z = true;
            notifyAll();
        }
    }

    private void i1() throws IOException, q {
        if (this.f29233x.f29389a.u() || !this.f29229t.s()) {
            return;
        }
        V();
        X();
        Y();
        W();
    }

    private void j() throws q {
        y0(true);
    }

    private void j0(int i10, int i11, l3.w0 w0Var) throws Throwable {
        this.f29234y.b(1);
        E(this.f29229t.A(i10, i11, w0Var), false);
    }

    private void j1() throws q {
        c2 c2VarP = this.f29228s.p();
        if (c2VarP == null) {
            return;
        }
        long discontinuity = c2VarP.f29038d ? c2VarP.f29035a.readDiscontinuity() : -9223372036854775807L;
        if (discontinuity != C.TIME_UNSET) {
            p0(discontinuity);
            if (discontinuity != this.f29233x.f29406r) {
                o2 o2Var = this.f29233x;
                this.f29233x = I(o2Var.f29390b, discontinuity, o2Var.f29391c, discontinuity, true, 5);
            }
        } else {
            long jH = this.f29224o.h(c2VarP != this.f29228s.q());
            this.L = jH;
            long jY = c2VarP.y(jH);
            U(this.f29233x.f29406r, jY);
            this.f29233x.f29406r = jY;
        }
        this.f29233x.f29404p = this.f29228s.j().i();
        this.f29233x.f29405q = z();
        o2 o2Var2 = this.f29233x;
        if (o2Var2.f29400l && o2Var2.f29393e == 3 && b1(o2Var2.f29389a, o2Var2.f29390b) && this.f29233x.f29402n.f29421a == 1.0f) {
            float adjustedPlaybackSpeed = this.f29230u.getAdjustedPlaybackSpeed(t(), z());
            if (this.f29224o.getPlaybackParameters().f29421a != adjustedPlaybackSpeed) {
                this.f29224o.b(this.f29233x.f29402n.e(adjustedPlaybackSpeed));
                G(this.f29233x.f29402n, this.f29224o.getPlaybackParameters().f29421a, false, false);
            }
        }
    }

    private void k(v2 v2Var) throws q {
        if (v2Var.j()) {
            return;
        }
        try {
            v2Var.g().handleMessage(v2Var.i(), v2Var.e());
        } finally {
            v2Var.k(true);
        }
    }

    private void k1(n3 n3Var, a0.b bVar, n3 n3Var2, a0.b bVar2, long j10) {
        if (!b1(n3Var, bVar)) {
            q2 q2Var = bVar.b() ? q2.f29419d : this.f29233x.f29402n;
            if (this.f29224o.getPlaybackParameters().equals(q2Var)) {
                return;
            }
            this.f29224o.b(q2Var);
            return;
        }
        n3Var.r(n3Var.l(bVar.f30778a, this.f29221l).f29300c, this.f29220k);
        this.f29230u.a((w1.g) a4.o0.j(this.f29220k.f29323k));
        if (j10 != C.TIME_UNSET) {
            this.f29230u.setTargetLiveOffsetOverrideUs(v(n3Var, bVar.f30778a, j10));
            return;
        }
        if (a4.o0.c(!n3Var2.u() ? n3Var2.r(n3Var2.l(bVar2.f30778a, this.f29221l).f29300c, this.f29220k).f29313a : null, this.f29220k.f29313a)) {
            return;
        }
        this.f29230u.setTargetLiveOffsetOverrideUs(C.TIME_UNSET);
    }

    private void l(a3 a3Var) throws q {
        if (N(a3Var)) {
            this.f29224o.a(a3Var);
            q(a3Var);
            a3Var.disable();
            this.J--;
        }
    }

    private boolean l0() throws q {
        c2 c2VarQ = this.f29228s.q();
        x3.c0 c0VarO = c2VarQ.o();
        int i10 = 0;
        boolean z10 = false;
        while (true) {
            a3[] a3VarArr = this.f29210a;
            if (i10 >= a3VarArr.length) {
                return !z10;
            }
            a3 a3Var = a3VarArr[i10];
            if (N(a3Var)) {
                boolean z11 = a3Var.getStream() != c2VarQ.f29037c[i10];
                if (!c0VarO.c(i10) || z11) {
                    if (!a3Var.isCurrentStreamFinal()) {
                        a3Var.e(u(c0VarO.f35935c[i10]), c2VarQ.f29037c[i10], c2VarQ.m(), c2VarQ.l());
                    } else if (a3Var.isEnded()) {
                        l(a3Var);
                    } else {
                        z10 = true;
                    }
                }
            }
            i10++;
        }
    }

    private void l1(float f10) {
        for (c2 c2VarP = this.f29228s.p(); c2VarP != null; c2VarP = c2VarP.j()) {
            for (x3.s sVar : c2VarP.o().f35935c) {
                if (sVar != null) {
                    sVar.onPlaybackSpeed(f10);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m() throws java.io.IOException, k2.q {
        /*
            Method dump skipped, instruction units count: 504
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.k1.m():void");
    }

    private void m0() throws q {
        float f10 = this.f29224o.getPlaybackParameters().f29421a;
        c2 c2VarQ = this.f29228s.q();
        boolean z10 = true;
        for (c2 c2VarP = this.f29228s.p(); c2VarP != null && c2VarP.f29038d; c2VarP = c2VarP.j()) {
            x3.c0 c0VarV = c2VarP.v(f10, this.f29233x.f29389a);
            if (!c0VarV.a(c2VarP.o())) {
                if (z10) {
                    c2 c2VarP2 = this.f29228s.p();
                    boolean z11 = this.f29228s.z(c2VarP2);
                    boolean[] zArr = new boolean[this.f29210a.length];
                    long jB = c2VarP2.b(c0VarV, this.f29233x.f29406r, z11, zArr);
                    o2 o2Var = this.f29233x;
                    boolean z12 = (o2Var.f29393e == 4 || jB == o2Var.f29406r) ? false : true;
                    o2 o2Var2 = this.f29233x;
                    this.f29233x = I(o2Var2.f29390b, jB, o2Var2.f29391c, o2Var2.f29392d, z12, 5);
                    if (z12) {
                        p0(jB);
                    }
                    boolean[] zArr2 = new boolean[this.f29210a.length];
                    int i10 = 0;
                    while (true) {
                        a3[] a3VarArr = this.f29210a;
                        if (i10 >= a3VarArr.length) {
                            break;
                        }
                        a3 a3Var = a3VarArr[i10];
                        boolean zN = N(a3Var);
                        zArr2[i10] = zN;
                        l3.u0 u0Var = c2VarP2.f29037c[i10];
                        if (zN) {
                            if (u0Var != a3Var.getStream()) {
                                l(a3Var);
                            } else if (zArr[i10]) {
                                a3Var.resetPosition(this.L);
                            }
                        }
                        i10++;
                    }
                    p(zArr2);
                } else {
                    this.f29228s.z(c2VarP);
                    if (c2VarP.f29038d) {
                        c2VarP.a(c0VarV, Math.max(c2VarP.f29040f.f29066b, c2VarP.y(this.L)), false);
                    }
                }
                D(true);
                if (this.f29233x.f29393e != 4) {
                    S();
                    j1();
                    this.f29217h.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            if (c2VarP == c2VarQ) {
                z10 = false;
            }
        }
    }

    private synchronized void m1(e5.u<Boolean> uVar, long j10) {
        long jElapsedRealtime = this.f29226q.elapsedRealtime() + j10;
        boolean z10 = false;
        while (!uVar.get().booleanValue() && j10 > 0) {
            try {
                this.f29226q.onThreadBlocked();
                wait(j10);
            } catch (InterruptedException unused) {
                z10 = true;
            }
            j10 = jElapsedRealtime - this.f29226q.elapsedRealtime();
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    private void n(int i10, boolean z10) throws q {
        a3 a3Var = this.f29210a[i10];
        if (N(a3Var)) {
            return;
        }
        c2 c2VarQ = this.f29228s.q();
        boolean z11 = c2VarQ == this.f29228s.p();
        x3.c0 c0VarO = c2VarQ.o();
        d3 d3Var = c0VarO.f35934b[i10];
        o1[] o1VarArrU = u(c0VarO.f35935c[i10]);
        boolean z12 = Z0() && this.f29233x.f29393e == 3;
        boolean z13 = !z10 && z12;
        this.J++;
        this.f29211b.add(a3Var);
        a3Var.c(d3Var, o1VarArrU, c2VarQ.f29037c[i10], this.L, z13, z11, c2VarQ.m(), c2VarQ.l());
        a3Var.handleMessage(11, new a());
        this.f29224o.c(a3Var);
        if (z12) {
            a3Var.start();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a2 A[PHI: r4 r5 r7
      0x00a2: PHI (r4v3 l3.a0$b) = (r4v2 l3.a0$b), (r4v9 l3.a0$b) binds: [B:30:0x0079, B:32:0x009e] A[DONT_GENERATE, DONT_INLINE]
      0x00a2: PHI (r5v2 long) = (r5v1 long), (r5v5 long) binds: [B:30:0x0079, B:32:0x009e] A[DONT_GENERATE, DONT_INLINE]
      0x00a2: PHI (r7v3 long) = (r7v2 long), (r7v5 long) binds: [B:30:0x0079, B:32:0x009e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void n0(boolean r29, boolean r30, boolean r31, boolean r32) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.k1.n0(boolean, boolean, boolean, boolean):void");
    }

    private void o() throws q {
        p(new boolean[this.f29210a.length]);
    }

    private void o0() {
        c2 c2VarP = this.f29228s.p();
        this.B = c2VarP != null && c2VarP.f29040f.f29072h && this.A;
    }

    private void p(boolean[] zArr) throws q {
        c2 c2VarQ = this.f29228s.q();
        x3.c0 c0VarO = c2VarQ.o();
        for (int i10 = 0; i10 < this.f29210a.length; i10++) {
            if (!c0VarO.c(i10) && this.f29211b.remove(this.f29210a[i10])) {
                this.f29210a[i10].reset();
            }
        }
        for (int i11 = 0; i11 < this.f29210a.length; i11++) {
            if (c0VarO.c(i11)) {
                n(i11, zArr[i11]);
            }
        }
        c2VarQ.f29041g = true;
    }

    private void p0(long j10) throws q {
        c2 c2VarP = this.f29228s.p();
        long jZ = c2VarP == null ? j10 + MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US : c2VarP.z(j10);
        this.L = jZ;
        this.f29224o.d(jZ);
        for (a3 a3Var : this.f29210a) {
            if (N(a3Var)) {
                a3Var.resetPosition(this.L);
            }
        }
        b0();
    }

    private void q(a3 a3Var) throws q {
        if (a3Var.getState() == 2) {
            a3Var.stop();
        }
    }

    private static void q0(n3 n3Var, d dVar, n3.d dVar2, n3.b bVar) {
        int i10 = n3Var.r(n3Var.l(dVar.f29248d, bVar).f29300c, dVar2).f29328p;
        Object obj = n3Var.k(i10, bVar, true).f29299b;
        long j10 = bVar.f29301d;
        dVar.c(i10, j10 != C.TIME_UNSET ? j10 - 1 : Long.MAX_VALUE, obj);
    }

    private static boolean r0(d dVar, n3 n3Var, n3 n3Var2, int i10, boolean z10, n3.d dVar2, n3.b bVar) {
        Object obj = dVar.f29248d;
        if (obj == null) {
            Pair<Object, Long> pairU0 = u0(n3Var, new h(dVar.f29245a.h(), dVar.f29245a.d(), dVar.f29245a.f() == Long.MIN_VALUE ? C.TIME_UNSET : a4.o0.w0(dVar.f29245a.f())), false, i10, z10, dVar2, bVar);
            if (pairU0 == null) {
                return false;
            }
            dVar.c(n3Var.f(pairU0.first), ((Long) pairU0.second).longValue(), pairU0.first);
            if (dVar.f29245a.f() == Long.MIN_VALUE) {
                q0(n3Var, dVar, dVar2, bVar);
            }
            return true;
        }
        int iF = n3Var.f(obj);
        if (iF == -1) {
            return false;
        }
        if (dVar.f29245a.f() == Long.MIN_VALUE) {
            q0(n3Var, dVar, dVar2, bVar);
            return true;
        }
        dVar.f29246b = iF;
        n3Var2.l(dVar.f29248d, bVar);
        if (bVar.f29303f && n3Var2.r(bVar.f29300c, dVar2).f29327o == n3Var2.f(dVar.f29248d)) {
            Pair<Object, Long> pairN = n3Var.n(dVar2, bVar, n3Var.l(dVar.f29248d, bVar).f29300c, dVar.f29247c + bVar.q());
            dVar.c(n3Var.f(pairN.first), ((Long) pairN.second).longValue(), pairN.first);
        }
        return true;
    }

    private com.google.common.collect.y<c3.a> s(x3.s[] sVarArr) {
        y.a aVar = new y.a();
        boolean z10 = false;
        for (x3.s sVar : sVarArr) {
            if (sVar != null) {
                c3.a aVar2 = sVar.getFormat(0).f29345j;
                if (aVar2 == null) {
                    aVar.a(new c3.a(new a.b[0]));
                } else {
                    aVar.a(aVar2);
                    z10 = true;
                }
            }
        }
        return z10 ? aVar.k() : com.google.common.collect.y.q();
    }

    private void s0(n3 n3Var, n3 n3Var2) {
        if (n3Var.u() && n3Var2.u()) {
            return;
        }
        for (int size = this.f29225p.size() - 1; size >= 0; size--) {
            if (!r0(this.f29225p.get(size), n3Var, n3Var2, this.E, this.F, this.f29220k, this.f29221l)) {
                this.f29225p.get(size).f29245a.k(false);
                this.f29225p.remove(size);
            }
        }
        Collections.sort(this.f29225p);
    }

    private long t() {
        o2 o2Var = this.f29233x;
        return v(o2Var.f29389a, o2Var.f29390b.f30778a, o2Var.f29406r);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static k2.k1.g t0(k2.n3 r30, k2.o2 r31, @androidx.annotation.Nullable k2.k1.h r32, k2.f2 r33, int r34, boolean r35, k2.n3.d r36, k2.n3.b r37) {
        /*
            Method dump skipped, instruction units count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.k1.t0(k2.n3, k2.o2, k2.k1$h, k2.f2, int, boolean, k2.n3$d, k2.n3$b):k2.k1$g");
    }

    private static o1[] u(x3.s sVar) {
        int length = sVar != null ? sVar.length() : 0;
        o1[] o1VarArr = new o1[length];
        for (int i10 = 0; i10 < length; i10++) {
            o1VarArr[i10] = sVar.getFormat(i10);
        }
        return o1VarArr;
    }

    @Nullable
    private static Pair<Object, Long> u0(n3 n3Var, h hVar, boolean z10, int i10, boolean z11, n3.d dVar, n3.b bVar) {
        Pair<Object, Long> pairN;
        Object objV0;
        n3 n3Var2 = hVar.f29262a;
        if (n3Var.u()) {
            return null;
        }
        n3 n3Var3 = n3Var2.u() ? n3Var : n3Var2;
        try {
            pairN = n3Var3.n(dVar, bVar, hVar.f29263b, hVar.f29264c);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (n3Var.equals(n3Var3)) {
            return pairN;
        }
        if (n3Var.f(pairN.first) != -1) {
            return (n3Var3.l(pairN.first, bVar).f29303f && n3Var3.r(bVar.f29300c, dVar).f29327o == n3Var3.f(pairN.first)) ? n3Var.n(dVar, bVar, n3Var.l(pairN.first, bVar).f29300c, hVar.f29264c) : pairN;
        }
        if (z10 && (objV0 = v0(dVar, bVar, i10, z11, pairN.first, n3Var3, n3Var)) != null) {
            return n3Var.n(dVar, bVar, n3Var.l(objV0, bVar).f29300c, C.TIME_UNSET);
        }
        return null;
    }

    private long v(n3 n3Var, Object obj, long j10) {
        n3Var.r(n3Var.l(obj, this.f29221l).f29300c, this.f29220k);
        n3.d dVar = this.f29220k;
        if (dVar.f29318f != C.TIME_UNSET && dVar.i()) {
            n3.d dVar2 = this.f29220k;
            if (dVar2.f29321i) {
                return a4.o0.w0(dVar2.d() - this.f29220k.f29318f) - (j10 + this.f29221l.q());
            }
        }
        return C.TIME_UNSET;
    }

    @Nullable
    static Object v0(n3.d dVar, n3.b bVar, int i10, boolean z10, Object obj, n3 n3Var, n3 n3Var2) {
        int iF = n3Var.f(obj);
        int iM = n3Var.m();
        int iH = iF;
        int iF2 = -1;
        for (int i11 = 0; i11 < iM && iF2 == -1; i11++) {
            iH = n3Var.h(iH, bVar, dVar, i10, z10);
            if (iH == -1) {
                break;
            }
            iF2 = n3Var2.f(n3Var.q(iH));
        }
        if (iF2 == -1) {
            return null;
        }
        return n3Var2.q(iF2);
    }

    private long w() {
        c2 c2VarQ = this.f29228s.q();
        if (c2VarQ == null) {
            return 0L;
        }
        long jL = c2VarQ.l();
        if (!c2VarQ.f29038d) {
            return jL;
        }
        int i10 = 0;
        while (true) {
            a3[] a3VarArr = this.f29210a;
            if (i10 >= a3VarArr.length) {
                return jL;
            }
            if (N(a3VarArr[i10]) && this.f29210a[i10].getStream() == c2VarQ.f29037c[i10]) {
                long readingPositionUs = this.f29210a[i10].getReadingPositionUs();
                if (readingPositionUs == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                jL = Math.max(readingPositionUs, jL);
            }
            i10++;
        }
    }

    private void w0(long j10, long j11) {
        this.f29217h.sendEmptyMessageAtTime(2, j10 + j11);
    }

    private Pair<a0.b, Long> x(n3 n3Var) {
        if (n3Var.u()) {
            return Pair.create(o2.k(), 0L);
        }
        Pair<Object, Long> pairN = n3Var.n(this.f29220k, this.f29221l, n3Var.e(this.F), C.TIME_UNSET);
        a0.b bVarB = this.f29228s.B(n3Var, pairN.first, 0L);
        long jLongValue = ((Long) pairN.second).longValue();
        if (bVarB.b()) {
            n3Var.l(bVarB.f30778a, this.f29221l);
            jLongValue = bVarB.f30780c == this.f29221l.n(bVarB.f30779b) ? this.f29221l.j() : 0L;
        }
        return Pair.create(bVarB, Long.valueOf(jLongValue));
    }

    private void y0(boolean z10) throws q {
        a0.b bVar = this.f29228s.p().f29040f.f29065a;
        long jB0 = B0(bVar, this.f29233x.f29406r, true, false);
        if (jB0 != this.f29233x.f29406r) {
            o2 o2Var = this.f29233x;
            this.f29233x = I(bVar, jB0, o2Var.f29391c, o2Var.f29392d, z10, 5);
        }
    }

    private long z() {
        return A(this.f29233x.f29404p);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac A[Catch: all -> 0x0148, TryCatch #1 {all -> 0x0148, blocks: (B:22:0x00a2, B:24:0x00ac, B:27:0x00b2, B:29:0x00b8, B:30:0x00bb, B:32:0x00c1, B:34:0x00cb, B:36:0x00d3, B:40:0x00db, B:42:0x00e5, B:44:0x00f5, B:48:0x00ff, B:52:0x0111, B:56:0x011a), top: B:74:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void z0(k2.k1.h r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.k1.z0(k2.k1$h):void");
    }

    public void J0(List<i2.c> list, int i10, long j10, l3.w0 w0Var) {
        this.f29217h.obtainMessage(17, new b(list, w0Var, i10, j10, null)).sendToTarget();
    }

    public void M0(boolean z10, int i10) {
        this.f29217h.obtainMessage(1, z10 ? 1 : 0, i10).sendToTarget();
    }

    public void O0(q2 q2Var) {
        this.f29217h.obtainMessage(4, q2Var).sendToTarget();
    }

    public void Q0(int i10) {
        this.f29217h.obtainMessage(11, i10, 0).sendToTarget();
    }

    public void T0(boolean z10) {
        this.f29217h.obtainMessage(12, z10 ? 1 : 0, 0).sendToTarget();
    }

    @Override // k2.v2.a
    public synchronized void a(v2 v2Var) {
        if (!this.f29235z && this.f29218i.isAlive()) {
            this.f29217h.obtainMessage(14, v2Var).sendToTarget();
            return;
        }
        a4.t.i("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        v2Var.k(false);
    }

    @Override // l3.x.a
    public void d(l3.x xVar) {
        this.f29217h.obtainMessage(8, xVar).sendToTarget();
    }

    public void d1() {
        this.f29217h.obtainMessage(6).sendToTarget();
    }

    @Override // l3.v0.a
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public void c(l3.x xVar) {
        this.f29217h.obtainMessage(9, xVar).sendToTarget();
    }

    public void f0() {
        this.f29217h.obtainMessage(0).sendToTarget();
    }

    @Override // k2.l.a
    public void h(q2 q2Var) {
        this.f29217h.obtainMessage(16, q2Var).sendToTarget();
    }

    public synchronized boolean h0() {
        if (!this.f29235z && this.f29218i.isAlive()) {
            this.f29217h.sendEmptyMessage(7);
            m1(new e5.u() { // from class: k2.i1
                @Override // e5.u
                public final Object get() {
                    return this.f29132a.Q();
                }
            }, this.f29231v);
            return this.f29235z;
        }
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        c2 c2VarQ;
        int i10;
        try {
            switch (message.what) {
                case 0:
                    g0();
                    break;
                case 1:
                    N0(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    m();
                    break;
                case 3:
                    z0((h) message.obj);
                    break;
                case 4:
                    P0((q2) message.obj);
                    break;
                case 5:
                    S0((f3) message.obj);
                    break;
                case 6:
                    e1(false, true);
                    break;
                case 7:
                    i0();
                    return true;
                case 8:
                    F((l3.x) message.obj);
                    break;
                case 9:
                    B((l3.x) message.obj);
                    break;
                case 10:
                    m0();
                    break;
                case 11:
                    R0(message.arg1);
                    break;
                case 12:
                    U0(message.arg1 != 0);
                    break;
                case 13:
                    H0(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    C0((v2) message.obj);
                    break;
                case 15:
                    E0((v2) message.obj);
                    break;
                case 16:
                    H((q2) message.obj, false);
                    break;
                case 17:
                    I0((b) message.obj);
                    break;
                case 18:
                    i((b) message.obj, message.arg1);
                    break;
                case 19:
                    a0((c) message.obj);
                    break;
                case 20:
                    j0(message.arg1, message.arg2, (l3.w0) message.obj);
                    break;
                case 21:
                    V0((l3.w0) message.obj);
                    break;
                case 22:
                    Z();
                    break;
                case 23:
                    L0(message.arg1 != 0);
                    break;
                case 24:
                    K0(message.arg1 == 1);
                    break;
                case 25:
                    j();
                    break;
                default:
                    return false;
            }
        } catch (RuntimeException e10) {
            q qVarJ = q.j(e10, ((e10 instanceof IllegalStateException) || (e10 instanceof IllegalArgumentException)) ? 1004 : 1000);
            a4.t.d("ExoPlayerImplInternal", "Playback error", qVarJ);
            e1(true, false);
            this.f29233x = this.f29233x.e(qVarJ);
        } catch (j2 e11) {
            int i11 = e11.f29196b;
            if (i11 == 1) {
                i10 = e11.f29195a ? 3001 : PlaybackException.ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED;
            } else {
                if (i11 == 4) {
                    i10 = e11.f29195a ? 3002 : PlaybackException.ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED;
                }
                C(e11, i);
            }
            i = i10;
            C(e11, i);
        } catch (q e12) {
            e = e12;
            if (e.f29411d == 1 && (c2VarQ = this.f29228s.q()) != null) {
                e = e.f(c2VarQ.f29040f.f29065a);
            }
            if (e.f29417j && this.O == null) {
                a4.t.j("ExoPlayerImplInternal", "Recoverable renderer error", e);
                this.O = e;
                a4.p pVar = this.f29217h;
                pVar.a(pVar.obtainMessage(25, e));
            } else {
                q qVar = this.O;
                if (qVar != null) {
                    qVar.addSuppressed(e);
                    e = this.O;
                }
                a4.t.d("ExoPlayerImplInternal", "Playback error", e);
                e1(true, false);
                this.f29233x = this.f29233x.e(e);
            }
        } catch (o.a e13) {
            C(e13, e13.f31924a);
        } catch (z3.l e14) {
            C(e14, e14.f37443a);
        } catch (IOException e15) {
            C(e15, 2000);
        }
        T();
        return true;
    }

    public void k0(int i10, int i11, l3.w0 w0Var) {
        this.f29217h.obtainMessage(20, i10, i11, w0Var).sendToTarget();
    }

    @Override // k2.i2.d
    public void onPlaylistUpdateRequested() {
        this.f29217h.sendEmptyMessage(22);
    }

    @Override // x3.b0.a
    public void onTrackSelectionsInvalidated() {
        this.f29217h.sendEmptyMessage(10);
    }

    public void r(long j10) {
        this.P = j10;
    }

    public void x0(n3 n3Var, int i10, long j10) {
        this.f29217h.obtainMessage(3, new h(n3Var, i10, j10)).sendToTarget();
    }

    public Looper y() {
        return this.f29219j;
    }
}

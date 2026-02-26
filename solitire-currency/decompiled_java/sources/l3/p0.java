package l3;

import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import k2.n3;
import k2.w1;
import l2.t1;
import l3.a0;
import l3.j0;
import l3.o0;
import l3.p0;
import z3.k;

/* JADX INFO: compiled from: ProgressiveMediaSource.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p0 extends l3.a implements o0.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final w1 f30656h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final w1.h f30657i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final k.a f30658j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final j0.a f30659k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final o2.y f30660l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final z3.f0 f30661m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f30662n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f30663o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f30664p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f30665q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f30666r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private z3.m0 f30667s;

    /* JADX INFO: compiled from: ProgressiveMediaSource.java */
    class a extends r {
        a(p0 p0Var, n3 n3Var) {
            super(n3Var);
        }

        @Override // l3.r, k2.n3
        public n3.b k(int i10, n3.b bVar, boolean z10) {
            super.k(i10, bVar, z10);
            bVar.f29303f = true;
            return bVar;
        }

        @Override // l3.r, k2.n3
        public n3.d s(int i10, n3.d dVar, long j10) {
            super.s(i10, dVar, j10);
            dVar.f29324l = true;
            return dVar;
        }
    }

    /* JADX INFO: compiled from: ProgressiveMediaSource.java */
    public static final class b implements a0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k.a f30668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private j0.a f30669b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private o2.b0 f30670c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private z3.f0 f30671d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f30672e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        private String f30673f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        private Object f30674g;

        public b(k.a aVar, final p2.r rVar) {
            this(aVar, new j0.a() { // from class: l3.q0
                @Override // l3.j0.a
                public final j0 a(t1 t1Var) {
                    return p0.b.f(rVar, t1Var);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ j0 f(p2.r rVar, t1 t1Var) {
            return new l3.b(rVar);
        }

        @Override // l3.a0.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public p0 b(w1 w1Var) {
            a4.a.e(w1Var.f29517b);
            w1.h hVar = w1Var.f29517b;
            boolean z10 = hVar.f29587h == null && this.f30674g != null;
            boolean z11 = hVar.f29584e == null && this.f30673f != null;
            if (z10 && z11) {
                w1Var = w1Var.b().f(this.f30674g).b(this.f30673f).a();
            } else if (z10) {
                w1Var = w1Var.b().f(this.f30674g).a();
            } else if (z11) {
                w1Var = w1Var.b().b(this.f30673f).a();
            }
            w1 w1Var2 = w1Var;
            return new p0(w1Var2, this.f30668a, this.f30669b, this.f30670c.a(w1Var2), this.f30671d, this.f30672e, null);
        }

        @Override // l3.a0.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public b c(o2.b0 b0Var) {
            this.f30670c = (o2.b0) a4.a.f(b0Var, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // l3.a0.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public b a(z3.f0 f0Var) {
            this.f30671d = (z3.f0) a4.a.f(f0Var, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public b(k.a aVar, j0.a aVar2) {
            this(aVar, aVar2, new o2.l(), new z3.w(), 1048576);
        }

        public b(k.a aVar, j0.a aVar2, o2.b0 b0Var, z3.f0 f0Var, int i10) {
            this.f30668a = aVar;
            this.f30669b = aVar2;
            this.f30670c = b0Var;
            this.f30671d = f0Var;
            this.f30672e = i10;
        }
    }

    /* synthetic */ p0(w1 w1Var, k.a aVar, j0.a aVar2, o2.y yVar, z3.f0 f0Var, int i10, a aVar3) {
        this(w1Var, aVar, aVar2, yVar, f0Var, i10);
    }

    private void v() {
        n3 x0Var = new x0(this.f30664p, this.f30665q, false, this.f30666r, null, this.f30656h);
        if (this.f30663o) {
            x0Var = new a(this, x0Var);
        }
        t(x0Var);
    }

    @Override // l3.a0
    public void e(x xVar) {
        ((o0) xVar).T();
    }

    @Override // l3.a0
    public w1 getMediaItem() {
        return this.f30656h;
    }

    @Override // l3.a0
    public x j(a0.b bVar, z3.b bVar2, long j10) {
        z3.k kVarCreateDataSource = this.f30658j.createDataSource();
        z3.m0 m0Var = this.f30667s;
        if (m0Var != null) {
            kVarCreateDataSource.b(m0Var);
        }
        return new o0(this.f30657i.f29580a, kVarCreateDataSource, this.f30659k.a(q()), this.f30660l, l(bVar), this.f30661m, n(bVar), this, bVar2, this.f30657i.f29584e, this.f30662n);
    }

    @Override // l3.o0.b
    public void onSourceInfoRefreshed(long j10, boolean z10, boolean z11) {
        if (j10 == C.TIME_UNSET) {
            j10 = this.f30664p;
        }
        if (!this.f30663o && this.f30664p == j10 && this.f30665q == z10 && this.f30666r == z11) {
            return;
        }
        this.f30664p = j10;
        this.f30665q = z10;
        this.f30666r = z11;
        this.f30663o = false;
        v();
    }

    @Override // l3.a
    protected void s(@Nullable z3.m0 m0Var) {
        this.f30667s = m0Var;
        this.f30660l.prepare();
        this.f30660l.c((Looper) a4.a.e(Looper.myLooper()), q());
        v();
    }

    @Override // l3.a
    protected void u() {
        this.f30660l.release();
    }

    private p0(w1 w1Var, k.a aVar, j0.a aVar2, o2.y yVar, z3.f0 f0Var, int i10) {
        this.f30657i = (w1.h) a4.a.e(w1Var.f29517b);
        this.f30656h = w1Var;
        this.f30658j = aVar;
        this.f30659k = aVar2;
        this.f30660l = yVar;
        this.f30661m = f0Var;
        this.f30662n = i10;
        this.f30663o = true;
        this.f30664p = C.TIME_UNSET;
    }

    @Override // l3.a0
    public void maybeThrowSourceInfoRefreshError() {
    }
}

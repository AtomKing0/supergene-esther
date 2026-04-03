package l3;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import k2.n3;
import k2.o1;
import k2.w1;
import l3.a0;
import z3.k;
import z3.o;

/* JADX INFO: compiled from: SingleSampleMediaSource.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z0 extends l3.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final z3.o f30804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final k.a f30805i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final o1 f30806j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f30807k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final z3.f0 f30808l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f30809m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final n3 f30810n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final w1 f30811o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private z3.m0 f30812p;

    /* JADX INFO: compiled from: SingleSampleMediaSource.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k.a f30813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private z3.f0 f30814b = new z3.w();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f30815c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private Object f30816d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private String f30817e;

        public b(k.a aVar) {
            this.f30813a = (k.a) a4.a.e(aVar);
        }

        public z0 a(w1.l lVar, long j10) {
            return new z0(this.f30817e, lVar, this.f30813a, j10, this.f30814b, this.f30815c, this.f30816d);
        }

        public b b(@Nullable z3.f0 f0Var) {
            if (f0Var == null) {
                f0Var = new z3.w();
            }
            this.f30814b = f0Var;
            return this;
        }
    }

    @Override // l3.a0
    public void e(x xVar) {
        ((y0) xVar).l();
    }

    @Override // l3.a0
    public w1 getMediaItem() {
        return this.f30811o;
    }

    @Override // l3.a0
    public x j(a0.b bVar, z3.b bVar2, long j10) {
        return new y0(this.f30804h, this.f30805i, this.f30812p, this.f30806j, this.f30807k, this.f30808l, n(bVar), this.f30809m);
    }

    @Override // l3.a
    protected void s(@Nullable z3.m0 m0Var) {
        this.f30812p = m0Var;
        t(this.f30810n);
    }

    private z0(@Nullable String str, w1.l lVar, k.a aVar, long j10, z3.f0 f0Var, boolean z10, @Nullable Object obj) {
        this.f30805i = aVar;
        this.f30807k = j10;
        this.f30808l = f0Var;
        this.f30809m = z10;
        w1 w1VarA = new w1.c().g(Uri.EMPTY).d(lVar.f29596a.toString()).e(com.google.common.collect.y.r(lVar)).f(obj).a();
        this.f30811o = w1VarA;
        o1.b bVarU = new o1.b().e0((String) e5.i.a(lVar.f29597b, MimeTypes.TEXT_UNKNOWN)).V(lVar.f29598c).g0(lVar.f29599d).c0(lVar.f29600e).U(lVar.f29601f);
        String str2 = lVar.f29602g;
        this.f30806j = bVarU.S(str2 == null ? str : str2).E();
        this.f30804h = new o.b().h(lVar.f29596a).b(1).a();
        this.f30810n = new x0(j10, true, false, false, null, w1VarA);
    }

    @Override // l3.a0
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // l3.a
    protected void u() {
    }
}

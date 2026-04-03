package ja;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ironsource.nb;
import ga.a0;
import ga.b0;
import ga.d0;
import ga.e0;
import ga.r;
import ga.u;
import ga.w;
import ja.c;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import ma.f;
import ma.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;
import ua.a1;
import ua.k0;
import ua.x0;
import ua.z0;

/* JADX INFO: compiled from: CacheInterceptor.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final C0598a f28809b = new C0598a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final ga.c f28810a;

    /* JADX INFO: renamed from: ja.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CacheInterceptor.kt */
    public static final class C0598a {
        private C0598a() {
        }

        public /* synthetic */ C0598a(k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final u c(u uVar, u uVar2) {
            u.a aVar = new u.a();
            int size = uVar.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                int i12 = i11 + 1;
                String strE = uVar.e(i11);
                String strI = uVar.i(i11);
                if ((!q.x("Warning", strE, true) || !q.K(strI, "1", false, 2, null)) && (d(strE) || !e(strE) || uVar2.a(strE) == null)) {
                    aVar.d(strE, strI);
                }
                i11 = i12;
            }
            int size2 = uVar2.size();
            while (i10 < size2) {
                int i13 = i10 + 1;
                String strE2 = uVar2.e(i10);
                if (!d(strE2) && e(strE2)) {
                    aVar.d(strE2, uVar2.i(i10));
                }
                i10 = i13;
            }
            return aVar.f();
        }

        private final boolean d(String str) {
            return q.x("Content-Length", str, true) || q.x("Content-Encoding", str, true) || q.x(nb.K, str, true);
        }

        private final boolean e(String str) {
            return (q.x("Connection", str, true) || q.x("Keep-Alive", str, true) || q.x("Proxy-Authenticate", str, true) || q.x("Proxy-Authorization", str, true) || q.x("TE", str, true) || q.x("Trailers", str, true) || q.x("Transfer-Encoding", str, true) || q.x("Upgrade", str, true)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final d0 f(d0 d0Var) {
            return (d0Var == null ? null : d0Var.a()) != null ? d0Var.W().b(null).c() : d0Var;
        }
    }

    /* JADX INFO: compiled from: CacheInterceptor.kt */
    public static final class b implements z0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f28811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ua.e f28812b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ja.b f28813c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ua.d f28814d;

        b(ua.e eVar, ja.b bVar, ua.d dVar) {
            this.f28812b = eVar;
            this.f28813c = bVar;
            this.f28814d = dVar;
        }

        @Override // ua.z0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f28811a && !ha.d.s(this, 100, TimeUnit.MILLISECONDS)) {
                this.f28811a = true;
                this.f28813c.a();
            }
            this.f28812b.close();
        }

        @Override // ua.z0
        public long read(@NotNull ua.c sink, long j10) throws IOException {
            t.i(sink, "sink");
            try {
                long j11 = this.f28812b.read(sink, j10);
                if (j11 != -1) {
                    sink.z(this.f28814d.g(), sink.size() - j11, j11);
                    this.f28814d.w();
                    return j11;
                }
                if (!this.f28811a) {
                    this.f28811a = true;
                    this.f28814d.close();
                }
                return -1L;
            } catch (IOException e10) {
                if (!this.f28811a) {
                    this.f28811a = true;
                    this.f28813c.a();
                }
                throw e10;
            }
        }

        @Override // ua.z0
        @NotNull
        public a1 timeout() {
            return this.f28812b.timeout();
        }
    }

    public a(@Nullable ga.c cVar) {
        this.f28810a = cVar;
    }

    private final d0 a(ja.b bVar, d0 d0Var) throws IOException {
        if (bVar == null) {
            return d0Var;
        }
        x0 x0VarB = bVar.b();
        e0 e0VarA = d0Var.a();
        t.f(e0VarA);
        b bVar2 = new b(e0VarA.source(), bVar, k0.c(x0VarB));
        return d0Var.W().b(new h(d0.J(d0Var, nb.K, null, 2, null), d0Var.a().contentLength(), k0.d(bVar2))).c();
    }

    @Override // ga.w
    @NotNull
    public d0 intercept(@NotNull w.a chain) throws IOException {
        e0 e0VarA;
        e0 e0VarA2;
        t.i(chain, "chain");
        ga.e eVarCall = chain.call();
        ga.c cVar = this.f28810a;
        d0 d0VarC = cVar == null ? null : cVar.c(chain.a());
        c cVarB = new c.b(System.currentTimeMillis(), chain.a(), d0VarC).b();
        b0 b0VarB = cVarB.b();
        d0 d0VarA = cVarB.a();
        ga.c cVar2 = this.f28810a;
        if (cVar2 != null) {
            cVar2.L(cVarB);
        }
        la.e eVar = eVarCall instanceof la.e ? (la.e) eVarCall : null;
        r rVarM = eVar != null ? eVar.m() : null;
        if (rVarM == null) {
            rVarM = r.f26197b;
        }
        if (d0VarC != null && d0VarA == null && (e0VarA2 = d0VarC.a()) != null) {
            ha.d.m(e0VarA2);
        }
        if (b0VarB == null && d0VarA == null) {
            d0 d0VarC2 = new d0.a().s(chain.a()).q(a0.HTTP_1_1).g(TypedValues.PositionType.TYPE_PERCENT_HEIGHT).n("Unsatisfiable Request (only-if-cached)").b(ha.d.f26510c).t(-1L).r(System.currentTimeMillis()).c();
            rVarM.A(eVarCall, d0VarC2);
            return d0VarC2;
        }
        if (b0VarB == null) {
            t.f(d0VarA);
            d0 d0VarC3 = d0VarA.W().d(f28809b.f(d0VarA)).c();
            rVarM.b(eVarCall, d0VarC3);
            return d0VarC3;
        }
        if (d0VarA != null) {
            rVarM.a(eVarCall, d0VarA);
        } else if (this.f28810a != null) {
            rVarM.c(eVarCall);
        }
        try {
            d0 d0VarB = chain.b(b0VarB);
            if (d0VarB == null && d0VarC != null && e0VarA != null) {
            }
            if (d0VarA != null) {
                boolean z10 = false;
                if (d0VarB != null && d0VarB.q() == 304) {
                    z10 = true;
                }
                if (z10) {
                    d0.a aVarW = d0VarA.W();
                    C0598a c0598a = f28809b;
                    d0 d0VarC4 = aVarW.l(c0598a.c(d0VarA.L(), d0VarB.L())).t(d0VarB.J0()).r(d0VarB.G0()).d(c0598a.f(d0VarA)).o(c0598a.f(d0VarB)).c();
                    e0 e0VarA3 = d0VarB.a();
                    t.f(e0VarA3);
                    e0VarA3.close();
                    ga.c cVar3 = this.f28810a;
                    t.f(cVar3);
                    cVar3.J();
                    this.f28810a.O(d0VarA, d0VarC4);
                    rVarM.b(eVarCall, d0VarC4);
                    return d0VarC4;
                }
                e0 e0VarA4 = d0VarA.a();
                if (e0VarA4 != null) {
                    ha.d.m(e0VarA4);
                }
            }
            t.f(d0VarB);
            d0.a aVarW2 = d0VarB.W();
            C0598a c0598a2 = f28809b;
            d0 d0VarC5 = aVarW2.d(c0598a2.f(d0VarA)).o(c0598a2.f(d0VarB)).c();
            if (this.f28810a != null) {
                if (ma.e.b(d0VarC5) && c.f28815c.a(d0VarC5, b0VarB)) {
                    d0 d0VarA2 = a(this.f28810a.q(d0VarC5), d0VarC5);
                    if (d0VarA != null) {
                        rVarM.c(eVarCall);
                    }
                    return d0VarA2;
                }
                if (f.f31482a.a(b0VarB.h())) {
                    try {
                        this.f28810a.x(b0VarB);
                    } catch (IOException unused) {
                    }
                }
            }
            return d0VarC5;
        } finally {
            if (d0VarC != null && (e0VarA = d0VarC.a()) != null) {
                ha.d.m(e0VarA);
            }
        }
    }
}

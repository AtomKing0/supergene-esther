package ga;

import ga.e;
import ga.r;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qa.j;
import ta.c;

/* JADX INFO: compiled from: OkHttpClient.kt */
/* JADX INFO: loaded from: classes5.dex */
public class z implements Cloneable, e.a {

    @NotNull
    public static final b E = new b(null);

    @NotNull
    private static final List<a0> F = ha.d.w(a0.HTTP_2, a0.HTTP_1_1);

    @NotNull
    private static final List<l> G = ha.d.w(l.f26157i, l.f26159k);
    private final int A;
    private final int B;
    private final long C;

    @NotNull
    private final la.h D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final p f26264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final k f26265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<w> f26266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final List<w> f26267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final r.c f26268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f26269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final ga.b f26270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f26271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f26272i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final n f26273j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private final c f26274k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private final q f26275l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private final Proxy f26276m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    private final ProxySelector f26277n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    private final ga.b f26278o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NotNull
    private final SocketFactory f26279p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private final SSLSocketFactory f26280q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private final X509TrustManager f26281r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NotNull
    private final List<l> f26282s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NotNull
    private final List<a0> f26283t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NotNull
    private final HostnameVerifier f26284u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NotNull
    private final g f26285v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    private final ta.c f26286w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f26287x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int f26288y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final int f26289z;

    /* JADX INFO: compiled from: OkHttpClient.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final List<l> a() {
            return z.G;
        }

        @NotNull
        public final List<a0> b() {
            return z.F;
        }
    }

    public z(@NotNull a builder) throws NoSuchAlgorithmException, KeyStoreException {
        ProxySelector proxySelectorC;
        kotlin.jvm.internal.t.i(builder, "builder");
        this.f26264a = builder.p();
        this.f26265b = builder.m();
        this.f26266c = ha.d.T(builder.v());
        this.f26267d = ha.d.T(builder.x());
        this.f26268e = builder.r();
        this.f26269f = builder.E();
        this.f26270g = builder.g();
        this.f26271h = builder.s();
        this.f26272i = builder.t();
        this.f26273j = builder.o();
        this.f26274k = builder.h();
        this.f26275l = builder.q();
        this.f26276m = builder.A();
        if (builder.A() != null) {
            proxySelectorC = sa.a.f33928a;
        } else {
            proxySelectorC = builder.C();
            proxySelectorC = proxySelectorC == null ? ProxySelector.getDefault() : proxySelectorC;
            if (proxySelectorC == null) {
                proxySelectorC = sa.a.f33928a;
            }
        }
        this.f26277n = proxySelectorC;
        this.f26278o = builder.B();
        this.f26279p = builder.G();
        List<l> listN = builder.n();
        this.f26282s = listN;
        this.f26283t = builder.z();
        this.f26284u = builder.u();
        this.f26287x = builder.i();
        this.f26288y = builder.l();
        this.f26289z = builder.D();
        this.A = builder.I();
        this.B = builder.y();
        this.C = builder.w();
        la.h hVarF = builder.F();
        this.D = hVarF == null ? new la.h() : hVarF;
        List<l> list = listN;
        boolean z10 = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((l) it.next()).f()) {
                    z10 = false;
                    break;
                }
            }
        }
        if (z10) {
            this.f26280q = null;
            this.f26286w = null;
            this.f26281r = null;
            this.f26285v = g.f26061d;
        } else if (builder.H() != null) {
            this.f26280q = builder.H();
            ta.c cVarJ = builder.j();
            kotlin.jvm.internal.t.f(cVarJ);
            this.f26286w = cVarJ;
            X509TrustManager x509TrustManagerJ = builder.J();
            kotlin.jvm.internal.t.f(x509TrustManagerJ);
            this.f26281r = x509TrustManagerJ;
            g gVarK = builder.k();
            kotlin.jvm.internal.t.f(cVarJ);
            this.f26285v = gVarK.e(cVarJ);
        } else {
            j.a aVar = qa.j.f33228a;
            X509TrustManager x509TrustManagerP = aVar.g().p();
            this.f26281r = x509TrustManagerP;
            qa.j jVarG = aVar.g();
            kotlin.jvm.internal.t.f(x509TrustManagerP);
            this.f26280q = jVarG.o(x509TrustManagerP);
            c.a aVar2 = ta.c.f34195a;
            kotlin.jvm.internal.t.f(x509TrustManagerP);
            ta.c cVarA = aVar2.a(x509TrustManagerP);
            this.f26286w = cVarA;
            g gVarK2 = builder.k();
            kotlin.jvm.internal.t.f(cVarA);
            this.f26285v = gVarK2.e(cVarA);
        }
        J();
    }

    private final void J() {
        boolean z10;
        if (!(!this.f26266c.contains(null))) {
            throw new IllegalStateException(kotlin.jvm.internal.t.r("Null interceptor: ", w()).toString());
        }
        if (!(!this.f26267d.contains(null))) {
            throw new IllegalStateException(kotlin.jvm.internal.t.r("Null network interceptor: ", y()).toString());
        }
        List<l> list = this.f26282s;
        if ((list instanceof Collection) && list.isEmpty()) {
            z10 = true;
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((l) it.next()).f()) {
                    z10 = false;
                    break;
                }
            }
            z10 = true;
        }
        if (!z10) {
            if (this.f26280q == null) {
                throw new IllegalStateException("sslSocketFactory == null".toString());
            }
            if (this.f26286w == null) {
                throw new IllegalStateException("certificateChainCleaner == null".toString());
            }
            if (this.f26281r == null) {
                throw new IllegalStateException("x509TrustManager == null".toString());
            }
            return;
        }
        if (!(this.f26280q == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.f26286w == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.f26281r == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!kotlin.jvm.internal.t.d(this.f26285v, g.f26061d)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public final int A() {
        return this.B;
    }

    @NotNull
    public final List<a0> B() {
        return this.f26283t;
    }

    @Nullable
    public final Proxy C() {
        return this.f26276m;
    }

    @NotNull
    public final ga.b D() {
        return this.f26278o;
    }

    @NotNull
    public final ProxySelector E() {
        return this.f26277n;
    }

    public final int F() {
        return this.f26289z;
    }

    public final boolean G() {
        return this.f26269f;
    }

    @NotNull
    public final SocketFactory H() {
        return this.f26279p;
    }

    @NotNull
    public final SSLSocketFactory I() {
        SSLSocketFactory sSLSocketFactory = this.f26280q;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    public final int K() {
        return this.A;
    }

    @Nullable
    public final X509TrustManager L() {
        return this.f26281r;
    }

    @Override // ga.e.a
    @NotNull
    public e b(@NotNull b0 request) {
        kotlin.jvm.internal.t.i(request, "request");
        return new la.e(this, request, false);
    }

    @NotNull
    public Object clone() {
        return super.clone();
    }

    @NotNull
    public final ga.b f() {
        return this.f26270g;
    }

    @Nullable
    public final c g() {
        return this.f26274k;
    }

    public final int h() {
        return this.f26287x;
    }

    @Nullable
    public final ta.c i() {
        return this.f26286w;
    }

    @NotNull
    public final g j() {
        return this.f26285v;
    }

    public final int k() {
        return this.f26288y;
    }

    @NotNull
    public final k l() {
        return this.f26265b;
    }

    @NotNull
    public final List<l> m() {
        return this.f26282s;
    }

    @NotNull
    public final n o() {
        return this.f26273j;
    }

    @NotNull
    public final p p() {
        return this.f26264a;
    }

    @NotNull
    public final q q() {
        return this.f26275l;
    }

    @NotNull
    public final r.c r() {
        return this.f26268e;
    }

    public final boolean s() {
        return this.f26271h;
    }

    public final boolean t() {
        return this.f26272i;
    }

    @NotNull
    public final la.h u() {
        return this.D;
    }

    @NotNull
    public final HostnameVerifier v() {
        return this.f26284u;
    }

    @NotNull
    public final List<w> w() {
        return this.f26266c;
    }

    public final long x() {
        return this.C;
    }

    @NotNull
    public final List<w> y() {
        return this.f26267d;
    }

    @NotNull
    public a z() {
        return new a(this);
    }

    /* JADX INFO: compiled from: OkHttpClient.kt */
    public static final class a {
        private int A;
        private int B;
        private long C;

        @Nullable
        private la.h D;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private p f26290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private k f26291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final List<w> f26292c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private final List<w> f26293d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        private r.c f26294e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f26295f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NotNull
        private ga.b f26296g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f26297h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f26298i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @NotNull
        private n f26299j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        private c f26300k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @NotNull
        private q f26301l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @Nullable
        private Proxy f26302m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @Nullable
        private ProxySelector f26303n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        @NotNull
        private ga.b f26304o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        @NotNull
        private SocketFactory f26305p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        @Nullable
        private SSLSocketFactory f26306q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        @Nullable
        private X509TrustManager f26307r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @NotNull
        private List<l> f26308s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        @NotNull
        private List<? extends a0> f26309t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        @NotNull
        private HostnameVerifier f26310u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        @NotNull
        private g f26311v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        @Nullable
        private ta.c f26312w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private int f26313x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private int f26314y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private int f26315z;

        public a() {
            this.f26290a = new p();
            this.f26291b = new k();
            this.f26292c = new ArrayList();
            this.f26293d = new ArrayList();
            this.f26294e = ha.d.g(r.f26197b);
            this.f26295f = true;
            ga.b bVar = ga.b.f25944b;
            this.f26296g = bVar;
            this.f26297h = true;
            this.f26298i = true;
            this.f26299j = n.f26183b;
            this.f26301l = q.f26194b;
            this.f26304o = bVar;
            SocketFactory socketFactory = SocketFactory.getDefault();
            kotlin.jvm.internal.t.h(socketFactory, "getDefault()");
            this.f26305p = socketFactory;
            b bVar2 = z.E;
            this.f26308s = bVar2.a();
            this.f26309t = bVar2.b();
            this.f26310u = ta.d.f34196a;
            this.f26311v = g.f26061d;
            this.f26314y = 10000;
            this.f26315z = 10000;
            this.A = 10000;
            this.C = 1024L;
        }

        @Nullable
        public final Proxy A() {
            return this.f26302m;
        }

        @NotNull
        public final ga.b B() {
            return this.f26304o;
        }

        @Nullable
        public final ProxySelector C() {
            return this.f26303n;
        }

        public final int D() {
            return this.f26315z;
        }

        public final boolean E() {
            return this.f26295f;
        }

        @Nullable
        public final la.h F() {
            return this.D;
        }

        @NotNull
        public final SocketFactory G() {
            return this.f26305p;
        }

        @Nullable
        public final SSLSocketFactory H() {
            return this.f26306q;
        }

        public final int I() {
            return this.A;
        }

        @Nullable
        public final X509TrustManager J() {
            return this.f26307r;
        }

        @NotNull
        public final a K(@NotNull ProxySelector proxySelector) {
            kotlin.jvm.internal.t.i(proxySelector, "proxySelector");
            if (!kotlin.jvm.internal.t.d(proxySelector, C())) {
                S(null);
            }
            Q(proxySelector);
            return this;
        }

        @NotNull
        public final a L(long j10, @NotNull TimeUnit unit) {
            kotlin.jvm.internal.t.i(unit, "unit");
            R(ha.d.k("timeout", j10, unit));
            return this;
        }

        public final void M(@Nullable c cVar) {
            this.f26300k = cVar;
        }

        public final void N(int i10) {
            this.f26314y = i10;
        }

        public final void O(boolean z10) {
            this.f26297h = z10;
        }

        public final void P(boolean z10) {
            this.f26298i = z10;
        }

        public final void Q(@Nullable ProxySelector proxySelector) {
            this.f26303n = proxySelector;
        }

        public final void R(int i10) {
            this.f26315z = i10;
        }

        public final void S(@Nullable la.h hVar) {
            this.D = hVar;
        }

        @NotNull
        public final a a(@NotNull w interceptor) {
            kotlin.jvm.internal.t.i(interceptor, "interceptor");
            v().add(interceptor);
            return this;
        }

        @NotNull
        public final z b() {
            return new z(this);
        }

        @NotNull
        public final a c(@Nullable c cVar) {
            M(cVar);
            return this;
        }

        @NotNull
        public final a d(long j10, @NotNull TimeUnit unit) {
            kotlin.jvm.internal.t.i(unit, "unit");
            N(ha.d.k("timeout", j10, unit));
            return this;
        }

        @NotNull
        public final a e(boolean z10) {
            O(z10);
            return this;
        }

        @NotNull
        public final a f(boolean z10) {
            P(z10);
            return this;
        }

        @NotNull
        public final ga.b g() {
            return this.f26296g;
        }

        @Nullable
        public final c h() {
            return this.f26300k;
        }

        public final int i() {
            return this.f26313x;
        }

        @Nullable
        public final ta.c j() {
            return this.f26312w;
        }

        @NotNull
        public final g k() {
            return this.f26311v;
        }

        public final int l() {
            return this.f26314y;
        }

        @NotNull
        public final k m() {
            return this.f26291b;
        }

        @NotNull
        public final List<l> n() {
            return this.f26308s;
        }

        @NotNull
        public final n o() {
            return this.f26299j;
        }

        @NotNull
        public final p p() {
            return this.f26290a;
        }

        @NotNull
        public final q q() {
            return this.f26301l;
        }

        @NotNull
        public final r.c r() {
            return this.f26294e;
        }

        public final boolean s() {
            return this.f26297h;
        }

        public final boolean t() {
            return this.f26298i;
        }

        @NotNull
        public final HostnameVerifier u() {
            return this.f26310u;
        }

        @NotNull
        public final List<w> v() {
            return this.f26292c;
        }

        public final long w() {
            return this.C;
        }

        @NotNull
        public final List<w> x() {
            return this.f26293d;
        }

        public final int y() {
            return this.B;
        }

        @NotNull
        public final List<a0> z() {
            return this.f26309t;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(@NotNull z okHttpClient) {
            this();
            kotlin.jvm.internal.t.i(okHttpClient, "okHttpClient");
            this.f26290a = okHttpClient.p();
            this.f26291b = okHttpClient.l();
            kotlin.collections.a0.B(this.f26292c, okHttpClient.w());
            kotlin.collections.a0.B(this.f26293d, okHttpClient.y());
            this.f26294e = okHttpClient.r();
            this.f26295f = okHttpClient.G();
            this.f26296g = okHttpClient.f();
            this.f26297h = okHttpClient.s();
            this.f26298i = okHttpClient.t();
            this.f26299j = okHttpClient.o();
            this.f26300k = okHttpClient.g();
            this.f26301l = okHttpClient.q();
            this.f26302m = okHttpClient.C();
            this.f26303n = okHttpClient.E();
            this.f26304o = okHttpClient.D();
            this.f26305p = okHttpClient.H();
            this.f26306q = okHttpClient.f26280q;
            this.f26307r = okHttpClient.L();
            this.f26308s = okHttpClient.m();
            this.f26309t = okHttpClient.B();
            this.f26310u = okHttpClient.v();
            this.f26311v = okHttpClient.j();
            this.f26312w = okHttpClient.i();
            this.f26313x = okHttpClient.h();
            this.f26314y = okHttpClient.k();
            this.f26315z = okHttpClient.F();
            this.A = okHttpClient.K();
            this.B = okHttpClient.A();
            this.C = okHttpClient.x();
            this.D = okHttpClient.u();
        }
    }

    public z() {
        this(new a());
    }
}

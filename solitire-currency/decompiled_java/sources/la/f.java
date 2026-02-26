package la;

import com.ironsource.c3;
import ga.a0;
import ga.b0;
import ga.d0;
import ga.f0;
import ga.l;
import ga.r;
import ga.t;
import ga.z;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.collections.w;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.v;
import oa.f;
import oa.m;
import oa.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;
import ua.a1;
import ua.k0;

/* JADX INFO: compiled from: RealConnection.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class f extends f.c implements ga.j {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NotNull
    public static final a f31036t = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final g f31037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final f0 f31038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private Socket f31039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Socket f31040f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private t f31041g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private a0 f31042h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private oa.f f31043i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private ua.e f31044j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private ua.d f31045k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f31046l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f31047m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f31048n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f31049o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f31050p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f31051q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NotNull
    private final List<Reference<e>> f31052r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f31053s;

    /* JADX INFO: compiled from: RealConnection.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: RealConnection.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31054a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            iArr[Proxy.Type.HTTP.ordinal()] = 2;
            f31054a = iArr;
        }
    }

    /* JADX INFO: compiled from: RealConnection.kt */
    static final class c extends v implements h9.a<List<? extends Certificate>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ga.g f31055g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ t f31056h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ ga.a f31057i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ga.g gVar, t tVar, ga.a aVar) {
            super(0);
            this.f31055g = gVar;
            this.f31056h = tVar;
            this.f31057i = aVar;
        }

        @Override // h9.a
        @NotNull
        public final List<? extends Certificate> invoke() {
            ta.c cVarD = this.f31055g.d();
            kotlin.jvm.internal.t.f(cVarD);
            return cVarD.a(this.f31056h.d(), this.f31057i.l().i());
        }
    }

    /* JADX INFO: compiled from: RealConnection.kt */
    static final class d extends v implements h9.a<List<? extends X509Certificate>> {
        d() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final List<? extends X509Certificate> invoke() {
            t tVar = f.this.f31041g;
            kotlin.jvm.internal.t.f(tVar);
            List<Certificate> listD = tVar.d();
            ArrayList arrayList = new ArrayList(w.v(listD, 10));
            Iterator<T> it = listD.iterator();
            while (it.hasNext()) {
                arrayList.add((X509Certificate) ((Certificate) it.next()));
            }
            return arrayList;
        }
    }

    public f(@NotNull g connectionPool, @NotNull f0 route) {
        kotlin.jvm.internal.t.i(connectionPool, "connectionPool");
        kotlin.jvm.internal.t.i(route, "route");
        this.f31037c = connectionPool;
        this.f31038d = route;
        this.f31051q = 1;
        this.f31052r = new ArrayList();
        this.f31053s = Long.MAX_VALUE;
    }

    private final boolean A(List<f0> list) {
        List<f0> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        for (f0 f0Var : list2) {
            if (f0Var.b().type() == Proxy.Type.DIRECT && this.f31038d.b().type() == Proxy.Type.DIRECT && kotlin.jvm.internal.t.d(this.f31038d.d(), f0Var.d())) {
                return true;
            }
        }
        return false;
    }

    private final void E(int i10) throws IOException {
        Socket socket = this.f31040f;
        kotlin.jvm.internal.t.f(socket);
        ua.e eVar = this.f31044j;
        kotlin.jvm.internal.t.f(eVar);
        ua.d dVar = this.f31045k;
        kotlin.jvm.internal.t.f(dVar);
        socket.setSoTimeout(0);
        oa.f fVarA = new f.a(true, ka.e.f29730i).s(socket, this.f31038d.a().l().i(), eVar, dVar).k(this).l(i10).a();
        this.f31043i = fVarA;
        this.f31051q = oa.f.C.a().d();
        oa.f.n1(fVarA, false, null, 3, null);
    }

    private final boolean F(ga.v vVar) {
        t tVar;
        if (ha.d.f26515h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        ga.v vVarL = this.f31038d.a().l();
        if (vVar.n() != vVarL.n()) {
            return false;
        }
        if (kotlin.jvm.internal.t.d(vVar.i(), vVarL.i())) {
            return true;
        }
        if (this.f31047m || (tVar = this.f31041g) == null) {
            return false;
        }
        kotlin.jvm.internal.t.f(tVar);
        return e(vVar, tVar);
    }

    private final boolean e(ga.v vVar, t tVar) {
        List<Certificate> listD = tVar.d();
        return (listD.isEmpty() ^ true) && ta.d.f34196a.e(vVar.i(), (X509Certificate) listD.get(0));
    }

    private final void h(int i10, int i11, ga.e eVar, r rVar) throws IOException {
        Socket socketCreateSocket;
        Proxy proxyB = this.f31038d.b();
        ga.a aVarA = this.f31038d.a();
        Proxy.Type type = proxyB.type();
        int i12 = type == null ? -1 : b.f31054a[type.ordinal()];
        if (i12 == 1 || i12 == 2) {
            socketCreateSocket = aVarA.j().createSocket();
            kotlin.jvm.internal.t.f(socketCreateSocket);
        } else {
            socketCreateSocket = new Socket(proxyB);
        }
        this.f31039e = socketCreateSocket;
        rVar.j(eVar, this.f31038d.d(), proxyB);
        socketCreateSocket.setSoTimeout(i11);
        try {
            qa.j.f33228a.g().f(socketCreateSocket, this.f31038d.d(), i10);
            try {
                this.f31044j = k0.d(k0.m(socketCreateSocket));
                this.f31045k = k0.c(k0.i(socketCreateSocket));
            } catch (NullPointerException e10) {
                if (kotlin.jvm.internal.t.d(e10.getMessage(), "throw with null exception")) {
                    throw new IOException(e10);
                }
            }
        } catch (ConnectException e11) {
            ConnectException connectException = new ConnectException(kotlin.jvm.internal.t.r("Failed to connect to ", this.f31038d.d()));
            connectException.initCause(e11);
            throw connectException;
        }
    }

    private final void i(la.b bVar) throws Throwable {
        ga.a aVarA = this.f31038d.a();
        SSLSocketFactory sSLSocketFactoryK = aVarA.k();
        SSLSocket sSLSocket = null;
        try {
            kotlin.jvm.internal.t.f(sSLSocketFactoryK);
            Socket socketCreateSocket = sSLSocketFactoryK.createSocket(this.f31039e, aVarA.l().i(), aVarA.l().n(), true);
            if (socketCreateSocket == null) {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            }
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            try {
                l lVarA = bVar.a(sSLSocket2);
                if (lVarA.h()) {
                    qa.j.f33228a.g().e(sSLSocket2, aVarA.l().i(), aVarA.f());
                }
                sSLSocket2.startHandshake();
                SSLSession sslSocketSession = sSLSocket2.getSession();
                t.a aVar = t.f26205e;
                kotlin.jvm.internal.t.h(sslSocketSession, "sslSocketSession");
                t tVarB = aVar.b(sslSocketSession);
                HostnameVerifier hostnameVerifierE = aVarA.e();
                kotlin.jvm.internal.t.f(hostnameVerifierE);
                if (hostnameVerifierE.verify(aVarA.l().i(), sslSocketSession)) {
                    ga.g gVarA = aVarA.a();
                    kotlin.jvm.internal.t.f(gVarA);
                    this.f31041g = new t(tVarB.e(), tVarB.a(), tVarB.c(), new c(gVarA, tVarB, aVarA));
                    gVarA.b(aVarA.l().i(), new d());
                    String strH = lVarA.h() ? qa.j.f33228a.g().h(sSLSocket2) : null;
                    this.f31040f = sSLSocket2;
                    this.f31044j = k0.d(k0.m(sSLSocket2));
                    this.f31045k = k0.c(k0.i(sSLSocket2));
                    this.f31042h = strH != null ? a0.f25934b.a(strH) : a0.HTTP_1_1;
                    qa.j.f33228a.g().b(sSLSocket2);
                    return;
                }
                List<Certificate> listD = tVarB.d();
                if (!(!listD.isEmpty())) {
                    throw new SSLPeerUnverifiedException("Hostname " + aVarA.l().i() + " not verified (no certificates)");
                }
                X509Certificate x509Certificate = (X509Certificate) listD.get(0);
                throw new SSLPeerUnverifiedException(p9.j.h("\n              |Hostname " + aVarA.l().i() + " not verified:\n              |    certificate: " + ga.g.f26060c.a(x509Certificate) + "\n              |    DN: " + ((Object) x509Certificate.getSubjectDN().getName()) + "\n              |    subjectAltNames: " + ta.d.f34196a.a(x509Certificate) + "\n              ", null, 1, null));
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    qa.j.f33228a.g().b(sSLSocket);
                }
                if (sSLSocket != null) {
                    ha.d.n(sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final void j(int i10, int i11, int i12, ga.e eVar, r rVar) throws IOException {
        b0 b0VarL = l();
        ga.v vVarK = b0VarL.k();
        int i13 = 0;
        while (i13 < 21) {
            i13++;
            h(i10, i11, eVar, rVar);
            b0VarL = k(i11, i12, b0VarL, vVarK);
            if (b0VarL == null) {
                return;
            }
            Socket socket = this.f31039e;
            if (socket != null) {
                ha.d.n(socket);
            }
            this.f31039e = null;
            this.f31045k = null;
            this.f31044j = null;
            rVar.h(eVar, this.f31038d.d(), this.f31038d.b(), null);
        }
    }

    private final b0 k(int i10, int i11, b0 b0Var, ga.v vVar) throws IOException {
        String str = "CONNECT " + ha.d.R(vVar, true) + " HTTP/1.1";
        while (true) {
            ua.e eVar = this.f31044j;
            kotlin.jvm.internal.t.f(eVar);
            ua.d dVar = this.f31045k;
            kotlin.jvm.internal.t.f(dVar);
            na.b bVar = new na.b(null, this, eVar, dVar);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            eVar.timeout().g(i10, timeUnit);
            dVar.timeout().g(i11, timeUnit);
            bVar.A(b0Var.e(), str);
            bVar.a();
            d0.a aVarF = bVar.f(false);
            kotlin.jvm.internal.t.f(aVarF);
            d0 d0VarC = aVarF.s(b0Var).c();
            bVar.z(d0VarC);
            int iQ = d0VarC.q();
            if (iQ == 200) {
                if (eVar.g().m0() && dVar.g().m0()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iQ != 407) {
                throw new IOException(kotlin.jvm.internal.t.r("Unexpected response code for CONNECT: ", Integer.valueOf(d0VarC.q())));
            }
            b0 b0VarA = this.f31038d.a().h().a(this.f31038d, d0VarC);
            if (b0VarA == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if (q.x("close", d0.J(d0VarC, "Connection", null, 2, null), true)) {
                return b0VarA;
            }
            b0Var = b0VarA;
        }
    }

    private final b0 l() throws IOException {
        b0 b0VarB = new b0.a().r(this.f31038d.a().l()).i("CONNECT", null).g("Host", ha.d.R(this.f31038d.a().l(), true)).g("Proxy-Connection", "Keep-Alive").g("User-Agent", "okhttp/4.10.0").b();
        b0 b0VarA = this.f31038d.a().h().a(this.f31038d, new d0.a().s(b0VarB).q(a0.HTTP_1_1).g(c3.a.b.f11498g).n("Preemptive Authenticate").b(ha.d.f26510c).t(-1L).r(-1L).k("Proxy-Authenticate", "OkHttp-Preemptive").c());
        return b0VarA == null ? b0VarB : b0VarA;
    }

    private final void m(la.b bVar, int i10, ga.e eVar, r rVar) throws Throwable {
        if (this.f31038d.a().k() != null) {
            rVar.C(eVar);
            i(bVar);
            rVar.B(eVar, this.f31041g);
            if (this.f31042h == a0.HTTP_2) {
                E(i10);
                return;
            }
            return;
        }
        List<a0> listF = this.f31038d.a().f();
        a0 a0Var = a0.H2_PRIOR_KNOWLEDGE;
        if (!listF.contains(a0Var)) {
            this.f31040f = this.f31039e;
            this.f31042h = a0.HTTP_1_1;
        } else {
            this.f31040f = this.f31039e;
            this.f31042h = a0Var;
            E(i10);
        }
    }

    public final void B(long j10) {
        this.f31053s = j10;
    }

    public final void C(boolean z10) {
        this.f31046l = z10;
    }

    @NotNull
    public Socket D() {
        Socket socket = this.f31040f;
        kotlin.jvm.internal.t.f(socket);
        return socket;
    }

    public final synchronized void G(@NotNull e call, @Nullable IOException iOException) {
        kotlin.jvm.internal.t.i(call, "call");
        if (iOException instanceof n) {
            if (((n) iOException).f32305a == oa.b.REFUSED_STREAM) {
                int i10 = this.f31050p + 1;
                this.f31050p = i10;
                if (i10 > 1) {
                    this.f31046l = true;
                    this.f31048n++;
                }
            } else if (((n) iOException).f32305a != oa.b.CANCEL || !call.isCanceled()) {
                this.f31046l = true;
                this.f31048n++;
            }
        } else if (!v() || (iOException instanceof oa.a)) {
            this.f31046l = true;
            if (this.f31049o == 0) {
                if (iOException != null) {
                    g(call.k(), this.f31038d, iOException);
                }
                this.f31048n++;
            }
        }
    }

    @Override // oa.f.c
    public synchronized void a(@NotNull oa.f connection, @NotNull m settings) {
        kotlin.jvm.internal.t.i(connection, "connection");
        kotlin.jvm.internal.t.i(settings, "settings");
        this.f31051q = settings.d();
    }

    @Override // oa.f.c
    public void b(@NotNull oa.i stream) throws IOException {
        kotlin.jvm.internal.t.i(stream, "stream");
        stream.d(oa.b.REFUSED_STREAM, null);
    }

    public final void d() {
        Socket socket = this.f31039e;
        if (socket == null) {
            return;
        }
        ha.d.n(socket);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(int r17, int r18, int r19, int r20, boolean r21, @org.jetbrains.annotations.NotNull ga.e r22, @org.jetbrains.annotations.NotNull ga.r r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: la.f.f(int, int, int, int, boolean, ga.e, ga.r):void");
    }

    public final void g(@NotNull z client, @NotNull f0 failedRoute, @NotNull IOException failure) {
        kotlin.jvm.internal.t.i(client, "client");
        kotlin.jvm.internal.t.i(failedRoute, "failedRoute");
        kotlin.jvm.internal.t.i(failure, "failure");
        if (failedRoute.b().type() != Proxy.Type.DIRECT) {
            ga.a aVarA = failedRoute.a();
            aVarA.i().connectFailed(aVarA.l().s(), failedRoute.b().address(), failure);
        }
        client.u().b(failedRoute);
    }

    @NotNull
    public final List<Reference<e>> n() {
        return this.f31052r;
    }

    public final long o() {
        return this.f31053s;
    }

    public final boolean p() {
        return this.f31046l;
    }

    public final int q() {
        return this.f31048n;
    }

    @Nullable
    public t r() {
        return this.f31041g;
    }

    public final synchronized void s() {
        this.f31049o++;
    }

    public final boolean t(@NotNull ga.a address, @Nullable List<f0> list) {
        kotlin.jvm.internal.t.i(address, "address");
        if (ha.d.f26515h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        if (this.f31052r.size() >= this.f31051q || this.f31046l || !this.f31038d.a().d(address)) {
            return false;
        }
        if (kotlin.jvm.internal.t.d(address.l().i(), z().a().l().i())) {
            return true;
        }
        if (this.f31043i == null || list == null || !A(list) || address.e() != ta.d.f34196a || !F(address.l())) {
            return false;
        }
        try {
            ga.g gVarA = address.a();
            kotlin.jvm.internal.t.f(gVarA);
            String strI = address.l().i();
            t tVarR = r();
            kotlin.jvm.internal.t.f(tVarR);
            gVarA.a(strI, tVarR.d());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    @NotNull
    public String toString() {
        ga.i iVarA;
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f31038d.a().l().i());
        sb.append(':');
        sb.append(this.f31038d.a().l().n());
        sb.append(", proxy=");
        sb.append(this.f31038d.b());
        sb.append(" hostAddress=");
        sb.append(this.f31038d.d());
        sb.append(" cipherSuite=");
        t tVar = this.f31041g;
        Object obj = "none";
        if (tVar != null && (iVarA = tVar.a()) != null) {
            obj = iVarA;
        }
        sb.append(obj);
        sb.append(" protocol=");
        sb.append(this.f31042h);
        sb.append('}');
        return sb.toString();
    }

    public final boolean u(boolean z10) {
        long jO;
        if (ha.d.f26515h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        long jNanoTime = System.nanoTime();
        Socket socket = this.f31039e;
        kotlin.jvm.internal.t.f(socket);
        Socket socket2 = this.f31040f;
        kotlin.jvm.internal.t.f(socket2);
        ua.e eVar = this.f31044j;
        kotlin.jvm.internal.t.f(eVar);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        oa.f fVar = this.f31043i;
        if (fVar != null) {
            return fVar.Y0(jNanoTime);
        }
        synchronized (this) {
            jO = jNanoTime - o();
        }
        if (jO < 10000000000L || !z10) {
            return true;
        }
        return ha.d.G(socket2, eVar);
    }

    public final boolean v() {
        return this.f31043i != null;
    }

    @NotNull
    public final ma.d w(@NotNull z client, @NotNull ma.g chain) throws SocketException {
        kotlin.jvm.internal.t.i(client, "client");
        kotlin.jvm.internal.t.i(chain, "chain");
        Socket socket = this.f31040f;
        kotlin.jvm.internal.t.f(socket);
        ua.e eVar = this.f31044j;
        kotlin.jvm.internal.t.f(eVar);
        ua.d dVar = this.f31045k;
        kotlin.jvm.internal.t.f(dVar);
        oa.f fVar = this.f31043i;
        if (fVar != null) {
            return new oa.g(client, this, chain, fVar);
        }
        socket.setSoTimeout(chain.k());
        a1 a1VarTimeout = eVar.timeout();
        long jH = chain.h();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a1VarTimeout.g(jH, timeUnit);
        dVar.timeout().g(chain.j(), timeUnit);
        return new na.b(client, this, eVar, dVar);
    }

    public final synchronized void x() {
        this.f31047m = true;
    }

    public final synchronized void y() {
        this.f31046l = true;
    }

    @NotNull
    public f0 z() {
        return this.f31038d;
    }
}

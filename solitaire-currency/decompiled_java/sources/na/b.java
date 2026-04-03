package na;

import ga.b0;
import ga.d0;
import ga.u;
import ga.v;
import ga.z;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import ma.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;
import p9.r;
import ua.a1;
import ua.n;
import ua.x0;
import ua.z0;

/* JADX INFO: compiled from: Http1ExchangeCodec.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements ma.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final d f31744h = new d(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final z f31745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final la.f f31746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final ua.e f31747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final ua.d f31748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f31749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final na.a f31750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private u f31751g;

    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    private abstract class a implements z0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final n f31752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f31753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f31754c;

        public a(b this$0) {
            t.i(this$0, "this$0");
            this.f31754c = this$0;
            this.f31752a = new n(this$0.f31747c.timeout());
        }

        protected final boolean a() {
            return this.f31753b;
        }

        public final void c() {
            if (this.f31754c.f31749e == 6) {
                return;
            }
            if (this.f31754c.f31749e != 5) {
                throw new IllegalStateException(t.r("state: ", Integer.valueOf(this.f31754c.f31749e)));
            }
            this.f31754c.r(this.f31752a);
            this.f31754c.f31749e = 6;
        }

        protected final void i(boolean z10) {
            this.f31753b = z10;
        }

        @Override // ua.z0
        public long read(@NotNull ua.c sink, long j10) throws IOException {
            t.i(sink, "sink");
            try {
                return this.f31754c.f31747c.read(sink, j10);
            } catch (IOException e10) {
                this.f31754c.b().y();
                c();
                throw e10;
            }
        }

        @Override // ua.z0
        @NotNull
        public a1 timeout() {
            return this.f31752a;
        }
    }

    /* JADX INFO: renamed from: na.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    private final class C0634b implements x0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final n f31755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f31756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f31757c;

        public C0634b(b this$0) {
            t.i(this$0, "this$0");
            this.f31757c = this$0;
            this.f31755a = new n(this$0.f31748d.timeout());
        }

        @Override // ua.x0
        public void G(@NotNull ua.c source, long j10) throws IOException {
            t.i(source, "source");
            if (!(!this.f31756b)) {
                throw new IllegalStateException("closed".toString());
            }
            if (j10 == 0) {
                return;
            }
            this.f31757c.f31748d.v0(j10);
            this.f31757c.f31748d.E("\r\n");
            this.f31757c.f31748d.G(source, j10);
            this.f31757c.f31748d.E("\r\n");
        }

        @Override // ua.x0, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.f31756b) {
                return;
            }
            this.f31756b = true;
            this.f31757c.f31748d.E("0\r\n\r\n");
            this.f31757c.r(this.f31755a);
            this.f31757c.f31749e = 3;
        }

        @Override // ua.x0, java.io.Flushable
        public synchronized void flush() {
            if (this.f31756b) {
                return;
            }
            this.f31757c.f31748d.flush();
        }

        @Override // ua.x0
        @NotNull
        public a1 timeout() {
            return this.f31755a;
        }
    }

    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    private final class c extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private final v f31758d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f31759e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f31760f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f31761g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull b this$0, v url) {
            super(this$0);
            t.i(this$0, "this$0");
            t.i(url, "url");
            this.f31761g = this$0;
            this.f31758d = url;
            this.f31759e = -1L;
            this.f31760f = true;
        }

        private final void n() throws IOException {
            if (this.f31759e != -1) {
                this.f31761g.f31747c.N();
            }
            try {
                this.f31759e = this.f31761g.f31747c.E0();
                String string = r.b1(this.f31761g.f31747c.N()).toString();
                if (this.f31759e >= 0) {
                    if (!(string.length() > 0) || q.K(string, ";", false, 2, null)) {
                        if (this.f31759e == 0) {
                            this.f31760f = false;
                            b bVar = this.f31761g;
                            bVar.f31751g = bVar.f31750f.a();
                            z zVar = this.f31761g.f31745a;
                            t.f(zVar);
                            ga.n nVarO = zVar.o();
                            v vVar = this.f31758d;
                            u uVar = this.f31761g.f31751g;
                            t.f(uVar);
                            ma.e.f(nVarO, vVar, uVar);
                            c();
                            return;
                        }
                        return;
                    }
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f31759e + string + '\"');
            } catch (NumberFormatException e10) {
                throw new ProtocolException(e10.getMessage());
            }
        }

        @Override // ua.z0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (a()) {
                return;
            }
            if (this.f31760f && !ha.d.s(this, 100, TimeUnit.MILLISECONDS)) {
                this.f31761g.b().y();
                c();
            }
            i(true);
        }

        @Override // na.b.a, ua.z0
        public long read(@NotNull ua.c sink, long j10) throws IOException {
            t.i(sink, "sink");
            if (!(j10 >= 0)) {
                throw new IllegalArgumentException(t.r("byteCount < 0: ", Long.valueOf(j10)).toString());
            }
            if (!(!a())) {
                throw new IllegalStateException("closed".toString());
            }
            if (!this.f31760f) {
                return -1L;
            }
            long j11 = this.f31759e;
            if (j11 == 0 || j11 == -1) {
                n();
                if (!this.f31760f) {
                    return -1L;
                }
            }
            long j12 = super.read(sink, Math.min(j10, this.f31759e));
            if (j12 != -1) {
                this.f31759e -= j12;
                return j12;
            }
            this.f31761g.b().y();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            c();
            throw protocolException;
        }
    }

    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    private final class e extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f31762d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f31763e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(b this$0, long j10) {
            super(this$0);
            t.i(this$0, "this$0");
            this.f31763e = this$0;
            this.f31762d = j10;
            if (j10 == 0) {
                c();
            }
        }

        @Override // ua.z0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (a()) {
                return;
            }
            if (this.f31762d != 0 && !ha.d.s(this, 100, TimeUnit.MILLISECONDS)) {
                this.f31763e.b().y();
                c();
            }
            i(true);
        }

        @Override // na.b.a, ua.z0
        public long read(@NotNull ua.c sink, long j10) throws IOException {
            t.i(sink, "sink");
            if (!(j10 >= 0)) {
                throw new IllegalArgumentException(t.r("byteCount < 0: ", Long.valueOf(j10)).toString());
            }
            if (!(!a())) {
                throw new IllegalStateException("closed".toString());
            }
            long j11 = this.f31762d;
            if (j11 == 0) {
                return -1L;
            }
            long j12 = super.read(sink, Math.min(j11, j10));
            if (j12 == -1) {
                this.f31763e.b().y();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                c();
                throw protocolException;
            }
            long j13 = this.f31762d - j12;
            this.f31762d = j13;
            if (j13 == 0) {
                c();
            }
            return j12;
        }
    }

    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    private final class f implements x0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final n f31764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f31765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f31766c;

        public f(b this$0) {
            t.i(this$0, "this$0");
            this.f31766c = this$0;
            this.f31764a = new n(this$0.f31748d.timeout());
        }

        @Override // ua.x0
        public void G(@NotNull ua.c source, long j10) throws IOException {
            t.i(source, "source");
            if (!(!this.f31765b)) {
                throw new IllegalStateException("closed".toString());
            }
            ha.d.l(source.size(), 0L, j10);
            this.f31766c.f31748d.G(source, j10);
        }

        @Override // ua.x0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f31765b) {
                return;
            }
            this.f31765b = true;
            this.f31766c.r(this.f31764a);
            this.f31766c.f31749e = 3;
        }

        @Override // ua.x0, java.io.Flushable
        public void flush() throws IOException {
            if (this.f31765b) {
                return;
            }
            this.f31766c.f31748d.flush();
        }

        @Override // ua.x0
        @NotNull
        public a1 timeout() {
            return this.f31764a;
        }
    }

    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    private final class g extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f31767d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f31768e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(b this$0) {
            super(this$0);
            t.i(this$0, "this$0");
            this.f31768e = this$0;
        }

        @Override // ua.z0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (a()) {
                return;
            }
            if (!this.f31767d) {
                c();
            }
            i(true);
        }

        @Override // na.b.a, ua.z0
        public long read(@NotNull ua.c sink, long j10) throws IOException {
            t.i(sink, "sink");
            if (!(j10 >= 0)) {
                throw new IllegalArgumentException(t.r("byteCount < 0: ", Long.valueOf(j10)).toString());
            }
            if (!(!a())) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.f31767d) {
                return -1L;
            }
            long j11 = super.read(sink, j10);
            if (j11 != -1) {
                return j11;
            }
            this.f31767d = true;
            c();
            return -1L;
        }
    }

    public b(@Nullable z zVar, @NotNull la.f connection, @NotNull ua.e source, @NotNull ua.d sink) {
        t.i(connection, "connection");
        t.i(source, "source");
        t.i(sink, "sink");
        this.f31745a = zVar;
        this.f31746b = connection;
        this.f31747c = source;
        this.f31748d = sink;
        this.f31750f = new na.a(source);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(n nVar) {
        a1 a1VarI = nVar.i();
        nVar.j(a1.f34734e);
        a1VarI.a();
        a1VarI.b();
    }

    private final boolean s(b0 b0Var) {
        return q.x("chunked", b0Var.d("Transfer-Encoding"), true);
    }

    private final boolean t(d0 d0Var) {
        return q.x("chunked", d0.J(d0Var, "Transfer-Encoding", null, 2, null), true);
    }

    private final x0 u() {
        int i10 = this.f31749e;
        if (!(i10 == 1)) {
            throw new IllegalStateException(t.r("state: ", Integer.valueOf(i10)).toString());
        }
        this.f31749e = 2;
        return new C0634b(this);
    }

    private final z0 v(v vVar) {
        int i10 = this.f31749e;
        if (!(i10 == 4)) {
            throw new IllegalStateException(t.r("state: ", Integer.valueOf(i10)).toString());
        }
        this.f31749e = 5;
        return new c(this, vVar);
    }

    private final z0 w(long j10) {
        int i10 = this.f31749e;
        if (!(i10 == 4)) {
            throw new IllegalStateException(t.r("state: ", Integer.valueOf(i10)).toString());
        }
        this.f31749e = 5;
        return new e(this, j10);
    }

    private final x0 x() {
        int i10 = this.f31749e;
        if (!(i10 == 1)) {
            throw new IllegalStateException(t.r("state: ", Integer.valueOf(i10)).toString());
        }
        this.f31749e = 2;
        return new f(this);
    }

    private final z0 y() {
        int i10 = this.f31749e;
        if (!(i10 == 4)) {
            throw new IllegalStateException(t.r("state: ", Integer.valueOf(i10)).toString());
        }
        this.f31749e = 5;
        b().y();
        return new g(this);
    }

    public final void A(@NotNull u headers, @NotNull String requestLine) {
        t.i(headers, "headers");
        t.i(requestLine, "requestLine");
        int i10 = this.f31749e;
        if (!(i10 == 0)) {
            throw new IllegalStateException(t.r("state: ", Integer.valueOf(i10)).toString());
        }
        this.f31748d.E(requestLine).E("\r\n");
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f31748d.E(headers.e(i11)).E(": ").E(headers.i(i11)).E("\r\n");
        }
        this.f31748d.E("\r\n");
        this.f31749e = 1;
    }

    @Override // ma.d
    public void a() {
        this.f31748d.flush();
    }

    @Override // ma.d
    @NotNull
    public la.f b() {
        return this.f31746b;
    }

    @Override // ma.d
    public long c(@NotNull d0 response) {
        t.i(response, "response");
        if (!ma.e.b(response)) {
            return 0L;
        }
        if (t(response)) {
            return -1L;
        }
        return ha.d.v(response);
    }

    @Override // ma.d
    public void cancel() {
        b().d();
    }

    @Override // ma.d
    public void d(@NotNull b0 request) {
        t.i(request, "request");
        i iVar = i.f31495a;
        Proxy.Type type = b().z().b().type();
        t.h(type, "connection.route().proxy.type()");
        A(request.e(), iVar.a(request, type));
    }

    @Override // ma.d
    @NotNull
    public x0 e(@NotNull b0 request, long j10) throws ProtocolException {
        t.i(request, "request");
        if (request.a() != null && request.a().isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (s(request)) {
            return u();
        }
        if (j10 != -1) {
            return x();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // ma.d
    @Nullable
    public d0.a f(boolean z10) {
        int i10 = this.f31749e;
        boolean z11 = true;
        if (i10 != 1 && i10 != 3) {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalStateException(t.r("state: ", Integer.valueOf(i10)).toString());
        }
        try {
            ma.k kVarA = ma.k.f31498d.a(this.f31750f.b());
            d0.a aVarL = new d0.a().q(kVarA.f31499a).g(kVarA.f31500b).n(kVarA.f31501c).l(this.f31750f.a());
            if (z10 && kVarA.f31500b == 100) {
                return null;
            }
            if (kVarA.f31500b == 100) {
                this.f31749e = 3;
                return aVarL;
            }
            this.f31749e = 4;
            return aVarL;
        } catch (EOFException e10) {
            throw new IOException(t.r("unexpected end of stream on ", b().z().a().l().p()), e10);
        }
    }

    @Override // ma.d
    public void g() throws IOException {
        this.f31748d.flush();
    }

    @Override // ma.d
    @NotNull
    public z0 h(@NotNull d0 response) {
        t.i(response, "response");
        if (!ma.e.b(response)) {
            return w(0L);
        }
        if (t(response)) {
            return v(response.I0().k());
        }
        long jV = ha.d.v(response);
        return jV != -1 ? w(jV) : y();
    }

    public final void z(@NotNull d0 response) {
        t.i(response, "response");
        long jV = ha.d.v(response);
        if (jV == -1) {
            return;
        }
        z0 z0VarW = w(jV);
        ha.d.M(z0VarW, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        z0VarW.close();
    }
}

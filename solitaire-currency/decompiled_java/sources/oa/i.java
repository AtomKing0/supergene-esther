package oa;

import ga.u;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.a1;
import ua.x0;
import ua.z0;
import v8.k0;

/* JADX INFO: compiled from: Http2Stream.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    public static final a f32256o = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f32257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final f f32258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f32259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f32260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f32261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f32262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final ArrayDeque<u> f32263g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f32264h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final c f32265i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final b f32266j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final d f32267k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private final d f32268l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private oa.b f32269m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private IOException f32270n;

    /* JADX INFO: compiled from: Http2Stream.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: Http2Stream.kt */
    public final class b implements x0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f32271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final ua.c f32272b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private u f32273c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f32274d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ i f32275e;

        public b(i this$0, boolean z10) {
            t.i(this$0, "this$0");
            this.f32275e = this$0;
            this.f32271a = z10;
            this.f32272b = new ua.c();
        }

        private final void a(boolean z10) throws IOException {
            long jMin;
            boolean z11;
            i iVar = this.f32275e;
            synchronized (iVar) {
                iVar.s().t();
                while (iVar.r() >= iVar.q() && !i() && !c() && iVar.h() == null) {
                    try {
                        iVar.F();
                    } finally {
                        iVar.s().A();
                    }
                }
                iVar.s().A();
                iVar.c();
                jMin = Math.min(iVar.q() - iVar.r(), this.f32272b.size());
                iVar.D(iVar.r() + jMin);
                z11 = z10 && jMin == this.f32272b.size();
                k0 k0Var = k0.f35197a;
            }
            this.f32275e.s().t();
            try {
                this.f32275e.g().p1(this.f32275e.j(), z11, this.f32272b, jMin);
            } finally {
                iVar = this.f32275e;
            }
        }

        @Override // ua.x0
        public void G(@NotNull ua.c source, long j10) throws IOException {
            t.i(source, "source");
            i iVar = this.f32275e;
            if (!ha.d.f26515h || !Thread.holdsLock(iVar)) {
                this.f32272b.G(source, j10);
                while (this.f32272b.size() >= 16384) {
                    a(false);
                }
            } else {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + iVar);
            }
        }

        public final boolean c() {
            return this.f32274d;
        }

        @Override // ua.x0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            i iVar = this.f32275e;
            if (ha.d.f26515h && Thread.holdsLock(iVar)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + iVar);
            }
            i iVar2 = this.f32275e;
            synchronized (iVar2) {
                if (c()) {
                    return;
                }
                boolean z10 = iVar2.h() == null;
                k0 k0Var = k0.f35197a;
                if (!this.f32275e.o().f32271a) {
                    boolean z11 = this.f32272b.size() > 0;
                    if (this.f32273c != null) {
                        while (this.f32272b.size() > 0) {
                            a(false);
                        }
                        f fVarG = this.f32275e.g();
                        int iJ = this.f32275e.j();
                        u uVar = this.f32273c;
                        t.f(uVar);
                        fVarG.q1(iJ, z10, ha.d.P(uVar));
                    } else if (z11) {
                        while (this.f32272b.size() > 0) {
                            a(true);
                        }
                    } else if (z10) {
                        this.f32275e.g().p1(this.f32275e.j(), true, null, 0L);
                    }
                }
                synchronized (this.f32275e) {
                    n(true);
                    k0 k0Var2 = k0.f35197a;
                }
                this.f32275e.g().flush();
                this.f32275e.b();
            }
        }

        @Override // ua.x0, java.io.Flushable
        public void flush() throws IOException {
            i iVar = this.f32275e;
            if (ha.d.f26515h && Thread.holdsLock(iVar)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + iVar);
            }
            i iVar2 = this.f32275e;
            synchronized (iVar2) {
                iVar2.c();
                k0 k0Var = k0.f35197a;
            }
            while (this.f32272b.size() > 0) {
                a(false);
                this.f32275e.g().flush();
            }
        }

        public final boolean i() {
            return this.f32271a;
        }

        public final void n(boolean z10) {
            this.f32274d = z10;
        }

        @Override // ua.x0
        @NotNull
        public a1 timeout() {
            return this.f32275e.s();
        }
    }

    /* JADX INFO: compiled from: Http2Stream.kt */
    public final class c implements z0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f32276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f32277b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final ua.c f32278c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private final ua.c f32279d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private u f32280e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f32281f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ i f32282g;

        public c(i this$0, long j10, boolean z10) {
            t.i(this$0, "this$0");
            this.f32282g = this$0;
            this.f32276a = j10;
            this.f32277b = z10;
            this.f32278c = new ua.c();
            this.f32279d = new ua.c();
        }

        private final void J(long j10) {
            i iVar = this.f32282g;
            if (!ha.d.f26515h || !Thread.holdsLock(iVar)) {
                this.f32282g.g().o1(j10);
                return;
            }
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + iVar);
        }

        public final void B(@Nullable u uVar) {
            this.f32280e = uVar;
        }

        public final boolean a() {
            return this.f32281f;
        }

        public final boolean c() {
            return this.f32277b;
        }

        @Override // ua.z0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            i iVar = this.f32282g;
            synchronized (iVar) {
                x(true);
                size = i().size();
                i().c();
                iVar.notifyAll();
                k0 k0Var = k0.f35197a;
            }
            if (size > 0) {
                J(size);
            }
            this.f32282g.b();
        }

        @NotNull
        public final ua.c i() {
            return this.f32279d;
        }

        @NotNull
        public final ua.c n() {
            return this.f32278c;
        }

        public final void q(@NotNull ua.e source, long j10) throws IOException {
            boolean zC;
            boolean z10;
            boolean z11;
            long size;
            t.i(source, "source");
            i iVar = this.f32282g;
            if (ha.d.f26515h && Thread.holdsLock(iVar)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + iVar);
            }
            while (j10 > 0) {
                synchronized (this.f32282g) {
                    zC = c();
                    z10 = true;
                    z11 = i().size() + j10 > this.f32276a;
                    k0 k0Var = k0.f35197a;
                }
                if (z11) {
                    source.skip(j10);
                    this.f32282g.f(oa.b.FLOW_CONTROL_ERROR);
                    return;
                }
                if (zC) {
                    source.skip(j10);
                    return;
                }
                long j11 = source.read(this.f32278c, j10);
                if (j11 == -1) {
                    throw new EOFException();
                }
                j10 -= j11;
                i iVar2 = this.f32282g;
                synchronized (iVar2) {
                    if (a()) {
                        size = n().size();
                        n().c();
                    } else {
                        if (i().size() != 0) {
                            z10 = false;
                        }
                        i().s(n());
                        if (z10) {
                            iVar2.notifyAll();
                        }
                        size = 0;
                    }
                }
                if (size > 0) {
                    J(size);
                }
            }
        }

        @Override // ua.z0
        public long read(@NotNull ua.c sink, long j10) throws IOException {
            IOException iOExceptionI;
            long j11;
            boolean z10;
            t.i(sink, "sink");
            long j12 = 0;
            if (!(j10 >= 0)) {
                throw new IllegalArgumentException(t.r("byteCount < 0: ", Long.valueOf(j10)).toString());
            }
            while (true) {
                i iVar = this.f32282g;
                synchronized (iVar) {
                    iVar.m().t();
                    try {
                        if (iVar.h() != null) {
                            iOExceptionI = iVar.i();
                            if (iOExceptionI == null) {
                                oa.b bVarH = iVar.h();
                                t.f(bVarH);
                                iOExceptionI = new n(bVarH);
                            }
                        } else {
                            iOExceptionI = null;
                        }
                        if (a()) {
                            throw new IOException("stream closed");
                        }
                        if (i().size() > j12) {
                            j11 = i().read(sink, Math.min(j10, i().size()));
                            iVar.C(iVar.l() + j11);
                            long jL = iVar.l() - iVar.k();
                            if (iOExceptionI == null && jL >= iVar.g().Q0().c() / 2) {
                                iVar.g().u1(iVar.j(), jL);
                                iVar.B(iVar.l());
                            }
                        } else if (c() || iOExceptionI != null) {
                            j11 = -1;
                        } else {
                            iVar.F();
                            j11 = -1;
                            z10 = true;
                            iVar.m().A();
                            k0 k0Var = k0.f35197a;
                        }
                        z10 = false;
                        iVar.m().A();
                        k0 k0Var2 = k0.f35197a;
                    } finally {
                    }
                }
                if (!z10) {
                    if (j11 != -1) {
                        J(j11);
                        return j11;
                    }
                    if (iOExceptionI == null) {
                        return -1L;
                    }
                    throw iOExceptionI;
                }
                j12 = 0;
            }
        }

        @Override // ua.z0
        @NotNull
        public a1 timeout() {
            return this.f32282g.m();
        }

        public final void x(boolean z10) {
            this.f32281f = z10;
        }

        public final void z(boolean z10) {
            this.f32277b = z10;
        }
    }

    /* JADX INFO: compiled from: Http2Stream.kt */
    public final class d extends ua.a {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ i f32283m;

        public d(i this$0) {
            t.i(this$0, "this$0");
            this.f32283m = this$0;
        }

        public final void A() throws IOException {
            if (u()) {
                throw v(null);
            }
        }

        @Override // ua.a
        @NotNull
        protected IOException v(@Nullable IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // ua.a
        protected void z() {
            this.f32283m.f(oa.b.CANCEL);
            this.f32283m.g().h1();
        }
    }

    public i(int i10, @NotNull f connection, boolean z10, boolean z11, @Nullable u uVar) {
        t.i(connection, "connection");
        this.f32257a = i10;
        this.f32258b = connection;
        this.f32262f = connection.R0().c();
        ArrayDeque<u> arrayDeque = new ArrayDeque<>();
        this.f32263g = arrayDeque;
        this.f32265i = new c(this, connection.Q0().c(), z11);
        this.f32266j = new b(this, z10);
        this.f32267k = new d(this);
        this.f32268l = new d(this);
        if (uVar == null) {
            if (!t()) {
                throw new IllegalStateException("remotely-initiated streams should have headers".toString());
            }
        } else {
            if (!(!t())) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            }
            arrayDeque.add(uVar);
        }
    }

    private final boolean e(oa.b bVar, IOException iOException) {
        if (ha.d.f26515h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (h() != null) {
                return false;
            }
            if (p().c() && o().i()) {
                return false;
            }
            z(bVar);
            A(iOException);
            notifyAll();
            k0 k0Var = k0.f35197a;
            this.f32258b.g1(this.f32257a);
            return true;
        }
    }

    public final void A(@Nullable IOException iOException) {
        this.f32270n = iOException;
    }

    public final void B(long j10) {
        this.f32260d = j10;
    }

    public final void C(long j10) {
        this.f32259c = j10;
    }

    public final void D(long j10) {
        this.f32261e = j10;
    }

    @NotNull
    public final synchronized u E() throws IOException {
        u uVarRemoveFirst;
        this.f32267k.t();
        while (this.f32263g.isEmpty() && this.f32269m == null) {
            try {
                F();
            } catch (Throwable th) {
                this.f32267k.A();
                throw th;
            }
        }
        this.f32267k.A();
        if (!(!this.f32263g.isEmpty())) {
            IOException iOException = this.f32270n;
            if (iOException != null) {
                throw iOException;
            }
            oa.b bVar = this.f32269m;
            t.f(bVar);
            throw new n(bVar);
        }
        uVarRemoveFirst = this.f32263g.removeFirst();
        t.h(uVarRemoveFirst, "headersQueue.removeFirst()");
        return uVarRemoveFirst;
    }

    public final void F() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    @NotNull
    public final a1 G() {
        return this.f32268l;
    }

    public final void a(long j10) {
        this.f32262f += j10;
        if (j10 > 0) {
            notifyAll();
        }
    }

    public final void b() throws IOException {
        boolean z10;
        boolean zU;
        if (ha.d.f26515h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            z10 = !p().c() && p().a() && (o().i() || o().c());
            zU = u();
            k0 k0Var = k0.f35197a;
        }
        if (z10) {
            d(oa.b.CANCEL, null);
        } else {
            if (zU) {
                return;
            }
            this.f32258b.g1(this.f32257a);
        }
    }

    public final void c() throws IOException {
        if (this.f32266j.c()) {
            throw new IOException("stream closed");
        }
        if (this.f32266j.i()) {
            throw new IOException("stream finished");
        }
        if (this.f32269m != null) {
            IOException iOException = this.f32270n;
            if (iOException != null) {
                throw iOException;
            }
            oa.b bVar = this.f32269m;
            t.f(bVar);
            throw new n(bVar);
        }
    }

    public final void d(@NotNull oa.b rstStatusCode, @Nullable IOException iOException) throws IOException {
        t.i(rstStatusCode, "rstStatusCode");
        if (e(rstStatusCode, iOException)) {
            this.f32258b.s1(this.f32257a, rstStatusCode);
        }
    }

    public final void f(@NotNull oa.b errorCode) {
        t.i(errorCode, "errorCode");
        if (e(errorCode, null)) {
            this.f32258b.t1(this.f32257a, errorCode);
        }
    }

    @NotNull
    public final f g() {
        return this.f32258b;
    }

    @Nullable
    public final synchronized oa.b h() {
        return this.f32269m;
    }

    @Nullable
    public final IOException i() {
        return this.f32270n;
    }

    public final int j() {
        return this.f32257a;
    }

    public final long k() {
        return this.f32260d;
    }

    public final long l() {
        return this.f32259c;
    }

    @NotNull
    public final d m() {
        return this.f32267k;
    }

    @NotNull
    public final x0 n() {
        synchronized (this) {
            if (!(this.f32264h || t())) {
                throw new IllegalStateException("reply before requesting the sink".toString());
            }
            k0 k0Var = k0.f35197a;
        }
        return this.f32266j;
    }

    @NotNull
    public final b o() {
        return this.f32266j;
    }

    @NotNull
    public final c p() {
        return this.f32265i;
    }

    public final long q() {
        return this.f32262f;
    }

    public final long r() {
        return this.f32261e;
    }

    @NotNull
    public final d s() {
        return this.f32268l;
    }

    public final boolean t() {
        return this.f32258b.L0() == ((this.f32257a & 1) == 1);
    }

    public final synchronized boolean u() {
        if (this.f32269m != null) {
            return false;
        }
        if ((this.f32265i.c() || this.f32265i.a()) && (this.f32266j.i() || this.f32266j.c())) {
            if (this.f32264h) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public final a1 v() {
        return this.f32267k;
    }

    public final void w(@NotNull ua.e source, int i10) throws IOException {
        t.i(source, "source");
        if (!ha.d.f26515h || !Thread.holdsLock(this)) {
            this.f32265i.q(source, i10);
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
    }

    public final void x(@NotNull u headers, boolean z10) {
        boolean zU;
        t.i(headers, "headers");
        if (ha.d.f26515h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (this.f32264h && z10) {
                p().B(headers);
            } else {
                this.f32264h = true;
                this.f32263g.add(headers);
            }
            if (z10) {
                p().z(true);
            }
            zU = u();
            notifyAll();
            k0 k0Var = k0.f35197a;
        }
        if (zU) {
            return;
        }
        this.f32258b.g1(this.f32257a);
    }

    public final synchronized void y(@NotNull oa.b errorCode) {
        t.i(errorCode, "errorCode");
        if (this.f32269m == null) {
            this.f32269m = errorCode;
            notifyAll();
        }
    }

    public final void z(@Nullable oa.b bVar) {
        this.f32269m = bVar;
    }
}

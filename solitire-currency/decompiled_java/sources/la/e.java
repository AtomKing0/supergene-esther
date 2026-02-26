package la;

import androidx.core.app.NotificationCompat;
import ga.b0;
import ga.d0;
import ga.p;
import ga.r;
import ga.v;
import ga.z;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: RealCall.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e implements ga.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final z f31013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final b0 f31014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f31015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final g f31016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final r f31017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final c f31018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final AtomicBoolean f31019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private Object f31020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private d f31021i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private f f31022j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f31023k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private la.c f31024l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f31025m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f31026n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f31027o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private volatile boolean f31028p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private volatile la.c f31029q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private volatile f f31030r;

    /* JADX INFO: compiled from: RealCall.kt */
    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final ga.f f31031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private volatile AtomicInteger f31032b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f31033c;

        public a(@NotNull e this$0, ga.f responseCallback) {
            t.i(this$0, "this$0");
            t.i(responseCallback, "responseCallback");
            this.f31033c = this$0;
            this.f31031a = responseCallback;
            this.f31032b = new AtomicInteger(0);
        }

        public final void a(@NotNull ExecutorService executorService) {
            t.i(executorService, "executorService");
            p pVarP = this.f31033c.k().p();
            if (ha.d.f26515h && Thread.holdsLock(pVarP)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + pVarP);
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e10) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e10);
                    this.f31033c.u(interruptedIOException);
                    this.f31031a.onFailure(this.f31033c, interruptedIOException);
                    this.f31033c.k().p().f(this);
                }
            } catch (Throwable th) {
                this.f31033c.k().p().f(this);
                throw th;
            }
        }

        @NotNull
        public final e b() {
            return this.f31033c;
        }

        @NotNull
        public final AtomicInteger c() {
            return this.f31032b;
        }

        @NotNull
        public final String d() {
            return this.f31033c.q().k().i();
        }

        public final void e(@NotNull a other) {
            t.i(other, "other");
            this.f31032b = other.f31032b;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            Throwable th;
            IOException e10;
            p pVarP;
            String strR = t.r("OkHttp ", this.f31033c.v());
            e eVar = this.f31033c;
            Thread threadCurrentThread = Thread.currentThread();
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(strR);
            try {
                eVar.f31018f.t();
                try {
                    try {
                        z10 = true;
                        try {
                            this.f31031a.onResponse(eVar, eVar.r());
                            pVarP = eVar.k().p();
                        } catch (IOException e11) {
                            e10 = e11;
                            if (z10) {
                                qa.j.f33228a.g().k(t.r("Callback failure for ", eVar.B()), 4, e10);
                            } else {
                                this.f31031a.onFailure(eVar, e10);
                            }
                            pVarP = eVar.k().p();
                        } catch (Throwable th2) {
                            th = th2;
                            eVar.cancel();
                            if (!z10) {
                                IOException iOException = new IOException(t.r("canceled due to ", th));
                                v8.f.a(iOException, th);
                                this.f31031a.onFailure(eVar, iOException);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        eVar.k().p().f(this);
                        throw th3;
                    }
                } catch (IOException e12) {
                    z10 = false;
                    e10 = e12;
                } catch (Throwable th4) {
                    z10 = false;
                    th = th4;
                }
                pVarP.f(this);
            } finally {
                threadCurrentThread.setName(name);
            }
        }
    }

    /* JADX INFO: compiled from: RealCall.kt */
    public static final class b extends WeakReference<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final Object f31034a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull e referent, @Nullable Object obj) {
            super(referent);
            t.i(referent, "referent");
            this.f31034a = obj;
        }

        @Nullable
        public final Object a() {
            return this.f31034a;
        }
    }

    /* JADX INFO: compiled from: RealCall.kt */
    public static final class c extends ua.a {
        c() {
        }

        @Override // ua.a
        protected void z() {
            e.this.cancel();
        }
    }

    public e(@NotNull z client, @NotNull b0 originalRequest, boolean z10) {
        t.i(client, "client");
        t.i(originalRequest, "originalRequest");
        this.f31013a = client;
        this.f31014b = originalRequest;
        this.f31015c = z10;
        this.f31016d = client.l().a();
        this.f31017e = client.r().a(this);
        c cVar = new c();
        cVar.g(k().h(), TimeUnit.MILLISECONDS);
        this.f31018f = cVar;
        this.f31019g = new AtomicBoolean();
        this.f31027o = true;
    }

    private final <E extends IOException> E A(E e10) {
        if (this.f31023k || !this.f31018f.u()) {
            return e10;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (e10 != null) {
            interruptedIOException.initCause(e10);
        }
        return interruptedIOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String B() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.f31015c ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(v());
        return sb.toString();
    }

    private final <E extends IOException> E e(E e10) {
        Socket socketW;
        boolean z10 = ha.d.f26515h;
        if (z10 && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        f fVar = this.f31022j;
        if (fVar != null) {
            if (z10 && Thread.holdsLock(fVar)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + fVar);
            }
            synchronized (fVar) {
                socketW = w();
            }
            if (this.f31022j == null) {
                if (socketW != null) {
                    ha.d.n(socketW);
                }
                this.f31017e.l(this, fVar);
            } else {
                if (!(socketW == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        E e11 = (E) A(e10);
        if (e10 != null) {
            r rVar = this.f31017e;
            t.f(e11);
            rVar.e(this, e11);
        } else {
            this.f31017e.d(this);
        }
        return e11;
    }

    private final void f() {
        this.f31020h = qa.j.f33228a.g().i("response.body().close()");
        this.f31017e.f(this);
    }

    private final ga.a h(v vVar) {
        SSLSocketFactory sSLSocketFactoryI;
        HostnameVerifier hostnameVerifierV;
        ga.g gVarJ;
        if (vVar.j()) {
            sSLSocketFactoryI = this.f31013a.I();
            hostnameVerifierV = this.f31013a.v();
            gVarJ = this.f31013a.j();
        } else {
            sSLSocketFactoryI = null;
            hostnameVerifierV = null;
            gVarJ = null;
        }
        return new ga.a(vVar.i(), vVar.n(), this.f31013a.q(), this.f31013a.H(), sSLSocketFactoryI, hostnameVerifierV, gVarJ, this.f31013a.D(), this.f31013a.C(), this.f31013a.B(), this.f31013a.m(), this.f31013a.E());
    }

    @Override // ga.e
    @NotNull
    public b0 a() {
        return this.f31014b;
    }

    @Override // ga.e
    public void cancel() {
        if (this.f31028p) {
            return;
        }
        this.f31028p = true;
        la.c cVar = this.f31029q;
        if (cVar != null) {
            cVar.b();
        }
        f fVar = this.f31030r;
        if (fVar != null) {
            fVar.d();
        }
        this.f31017e.g(this);
    }

    public final void d(@NotNull f connection) {
        t.i(connection, "connection");
        if (!ha.d.f26515h || Thread.holdsLock(connection)) {
            if (!(this.f31022j == null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            this.f31022j = connection;
            connection.n().add(new b(this, this.f31020h));
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + connection);
    }

    @Override // ga.e
    @NotNull
    public d0 execute() {
        if (!this.f31019g.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        this.f31018f.t();
        f();
        try {
            this.f31013a.p().b(this);
            return r();
        } finally {
            this.f31013a.p().g(this);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public e clone() {
        return new e(this.f31013a, this.f31014b, this.f31015c);
    }

    public final void i(@NotNull b0 request, boolean z10) {
        t.i(request, "request");
        if (!(this.f31024l == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        synchronized (this) {
            if (!(!this.f31026n)) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
            }
            if (!(!this.f31025m)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            k0 k0Var = k0.f35197a;
        }
        if (z10) {
            this.f31021i = new d(this.f31016d, h(request.k()), this, this.f31017e);
        }
    }

    @Override // ga.e
    public boolean isCanceled() {
        return this.f31028p;
    }

    public final void j(boolean z10) {
        la.c cVar;
        synchronized (this) {
            if (!this.f31027o) {
                throw new IllegalStateException("released".toString());
            }
            k0 k0Var = k0.f35197a;
        }
        if (z10 && (cVar = this.f31029q) != null) {
            cVar.d();
        }
        this.f31024l = null;
    }

    @NotNull
    public final z k() {
        return this.f31013a;
    }

    @Nullable
    public final f l() {
        return this.f31022j;
    }

    @NotNull
    public final r m() {
        return this.f31017e;
    }

    @Override // ga.e
    public void n(@NotNull ga.f responseCallback) {
        t.i(responseCallback, "responseCallback");
        if (!this.f31019g.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        f();
        this.f31013a.p().a(new a(this, responseCallback));
    }

    public final boolean o() {
        return this.f31015c;
    }

    @Nullable
    public final la.c p() {
        return this.f31024l;
    }

    @NotNull
    public final b0 q() {
        return this.f31014b;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a7  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ga.d0 r() throws java.lang.Throwable {
        /*
            r11 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            ga.z r0 = r11.f31013a
            java.util.List r0 = r0.w()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            kotlin.collections.t.B(r2, r0)
            ma.j r0 = new ma.j
            ga.z r1 = r11.f31013a
            r0.<init>(r1)
            r2.add(r0)
            ma.a r0 = new ma.a
            ga.z r1 = r11.f31013a
            ga.n r1 = r1.o()
            r0.<init>(r1)
            r2.add(r0)
            ja.a r0 = new ja.a
            ga.z r1 = r11.f31013a
            ga.c r1 = r1.g()
            r0.<init>(r1)
            r2.add(r0)
            la.a r0 = la.a.f30981a
            r2.add(r0)
            boolean r0 = r11.f31015c
            if (r0 != 0) goto L4a
            ga.z r0 = r11.f31013a
            java.util.List r0 = r0.y()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            kotlin.collections.t.B(r2, r0)
        L4a:
            ma.b r0 = new ma.b
            boolean r1 = r11.f31015c
            r0.<init>(r1)
            r2.add(r0)
            ma.g r9 = new ma.g
            r3 = 0
            r4 = 0
            ga.b0 r5 = r11.f31014b
            ga.z r0 = r11.f31013a
            int r6 = r0.k()
            ga.z r0 = r11.f31013a
            int r7 = r0.F()
            ga.z r0 = r11.f31013a
            int r8 = r0.K()
            r0 = r9
            r1 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            r1 = 0
            ga.b0 r2 = r11.f31014b     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L90
            ga.d0 r2 = r9.b(r2)     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L90
            boolean r3 = r11.isCanceled()     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L90
            if (r3 != 0) goto L83
            r11.u(r0)
            return r2
        L83:
            ha.d.m(r2)     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L90
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L90
            java.lang.String r3 = "Canceled"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L90
            throw r2     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L90
        L8e:
            r2 = move-exception
            goto La5
        L90:
            r1 = move-exception
            r2 = 1
            java.io.IOException r1 = r11.u(r1)     // Catch: java.lang.Throwable -> La1
            if (r1 != 0) goto La0
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> La1
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Throwable"
            r1.<init>(r3)     // Catch: java.lang.Throwable -> La1
            throw r1     // Catch: java.lang.Throwable -> La1
        La0:
            throw r1     // Catch: java.lang.Throwable -> La1
        La1:
            r1 = move-exception
            r10 = r2
            r2 = r1
            r1 = r10
        La5:
            if (r1 != 0) goto Laa
            r11.u(r0)
        Laa:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: la.e.r():ga.d0");
    }

    @NotNull
    public final la.c s(@NotNull ma.g chain) throws IOException {
        t.i(chain, "chain");
        synchronized (this) {
            if (!this.f31027o) {
                throw new IllegalStateException("released".toString());
            }
            if (!(!this.f31026n)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!(!this.f31025m)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            k0 k0Var = k0.f35197a;
        }
        d dVar = this.f31021i;
        t.f(dVar);
        la.c cVar = new la.c(this, this.f31017e, dVar, dVar.a(this.f31013a, chain));
        this.f31024l = cVar;
        this.f31029q = cVar;
        synchronized (this) {
            this.f31025m = true;
            this.f31026n = true;
        }
        if (this.f31028p) {
            throw new IOException("Canceled");
        }
        return cVar;
    }

    public final <E extends IOException> E t(@NotNull la.c exchange, boolean z10, boolean z11, E e10) {
        boolean z12;
        boolean z13;
        t.i(exchange, "exchange");
        if (!t.d(exchange, this.f31029q)) {
            return e10;
        }
        synchronized (this) {
            z12 = false;
            if (z10) {
                try {
                    if (!this.f31025m) {
                        if (z11 || !this.f31026n) {
                            z13 = false;
                        }
                    }
                    if (z10) {
                        this.f31025m = false;
                    }
                    if (z11) {
                        this.f31026n = false;
                    }
                    boolean z14 = this.f31025m;
                    boolean z15 = (z14 || this.f31026n) ? false : true;
                    if (!z14 && !this.f31026n && !this.f31027o) {
                        z12 = true;
                    }
                    z13 = z12;
                    z12 = z15;
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                if (z11) {
                }
                z13 = false;
            }
            k0 k0Var = k0.f35197a;
        }
        if (z12) {
            this.f31029q = null;
            f fVar = this.f31022j;
            if (fVar != null) {
                fVar.s();
            }
        }
        return z13 ? (E) e(e10) : e10;
    }

    @Nullable
    public final IOException u(@Nullable IOException iOException) {
        boolean z10;
        synchronized (this) {
            z10 = false;
            if (this.f31027o) {
                this.f31027o = false;
                if (!this.f31025m && !this.f31026n) {
                    z10 = true;
                }
            }
            k0 k0Var = k0.f35197a;
        }
        return z10 ? e(iOException) : iOException;
    }

    @NotNull
    public final String v() {
        return this.f31014b.k().p();
    }

    @Nullable
    public final Socket w() {
        f fVar = this.f31022j;
        t.f(fVar);
        if (ha.d.f26515h && !Thread.holdsLock(fVar)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + fVar);
        }
        List<Reference<e>> listN = fVar.n();
        Iterator<Reference<e>> it = listN.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            if (t.d(it.next().get(), this)) {
                break;
            }
            i10++;
        }
        if (!(i10 != -1)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        listN.remove(i10);
        this.f31022j = null;
        if (listN.isEmpty()) {
            fVar.B(System.nanoTime());
            if (this.f31016d.c(fVar)) {
                return fVar.D();
            }
        }
        return null;
    }

    public final boolean x() {
        d dVar = this.f31021i;
        t.f(dVar);
        return dVar.e();
    }

    public final void y(@Nullable f fVar) {
        this.f31030r = fVar;
    }

    public final void z() {
        if (!(!this.f31023k)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f31023k = true;
        this.f31018f.u();
    }
}

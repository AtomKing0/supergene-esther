package io.sentry.transport;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.c4;
import io.sentry.l0;
import io.sentry.o5;
import io.sentry.p5;
import io.sentry.util.m;
import io.sentry.w0;
import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AsyncHttpTransport.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final x f28268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final io.sentry.cache.g f28269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final SentryOptions f28270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final b0 f28271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final s f28272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final o f28273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private volatile Runnable f28274g;

    /* JADX INFO: compiled from: AsyncHttpTransport.java */
    private static final class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f28275a;

        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        @NotNull
        public Thread newThread(@NotNull Runnable runnable) {
            StringBuilder sb = new StringBuilder();
            sb.append("SentryAsyncConnection-");
            int i10 = this.f28275a;
            this.f28275a = i10 + 1;
            sb.append(i10);
            Thread thread = new Thread(runnable, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AsyncHttpTransport.java */
    final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final p5 f28276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final l0 f28277b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final io.sentry.cache.g f28278c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final d0 f28279d = d0.a();

        c(@NotNull p5 p5Var, @NotNull l0 l0Var, @NotNull io.sentry.cache.g gVar) {
            this.f28276a = (p5) io.sentry.util.w.c(p5Var, "Envelope is required.");
            this.f28277b = l0Var;
            this.f28278c = (io.sentry.cache.g) io.sentry.util.w.c(gVar, "EnvelopeCache is required.");
        }

        @NotNull
        private d0 j() {
            d0 d0Var = this.f28279d;
            this.f28276a.b().d(null);
            this.f28278c.L(this.f28276a, this.f28277b);
            io.sentry.util.m.o(this.f28277b, io.sentry.hints.f.class, new m.a() { // from class: io.sentry.transport.g
                @Override // io.sentry.util.m.a
                public final void accept(Object obj) {
                    this.f28283a.k((io.sentry.hints.f) obj);
                }
            });
            if (!e.this.f28272e.isConnected()) {
                io.sentry.util.m.p(this.f28277b, io.sentry.hints.k.class, new m.a() { // from class: io.sentry.transport.k
                    @Override // io.sentry.util.m.a
                    public final void accept(Object obj) {
                        ((io.sentry.hints.k) obj).d(true);
                    }
                }, new m.b() { // from class: io.sentry.transport.l
                    @Override // io.sentry.util.m.b
                    public final void a(Object obj, Class cls) {
                        this.f28288a.p(obj, cls);
                    }
                });
                return d0Var;
            }
            final p5 p5VarE = e.this.f28270c.getClientReportRecorder().e(this.f28276a);
            try {
                p5VarE.b().d(io.sentry.n.k(e.this.f28270c.getDateProvider().a().g()));
                d0 d0VarH = e.this.f28273f.h(p5VarE);
                if (d0VarH.d()) {
                    this.f28278c.c(this.f28276a);
                    return d0VarH;
                }
                String str = "The transport failed to send the envelope with response code " + d0VarH.c();
                e.this.f28270c.getLogger().c(SentryLevel.ERROR, str, new Object[0]);
                if (d0VarH.c() >= 400 && d0VarH.c() != 429) {
                    io.sentry.util.m.n(this.f28277b, io.sentry.hints.k.class, new m.c() { // from class: io.sentry.transport.h
                        @Override // io.sentry.util.m.c
                        public final void accept(Object obj) {
                            this.f28284a.l(p5VarE, obj);
                        }
                    });
                }
                throw new IllegalStateException(str);
            } catch (IOException e10) {
                io.sentry.util.m.p(this.f28277b, io.sentry.hints.k.class, new m.a() { // from class: io.sentry.transport.i
                    @Override // io.sentry.util.m.a
                    public final void accept(Object obj) {
                        ((io.sentry.hints.k) obj).d(true);
                    }
                }, new m.b() { // from class: io.sentry.transport.j
                    @Override // io.sentry.util.m.b
                    public final void a(Object obj, Class cls) {
                        this.f28286a.n(p5VarE, obj, cls);
                    }
                });
                throw new IllegalStateException("Sending the event failed.", e10);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(io.sentry.hints.f fVar) {
            if (!fVar.b(this.f28276a.b().a())) {
                e.this.f28270c.getLogger().c(SentryLevel.DEBUG, "Not firing envelope flush as there's an ongoing transaction", new Object[0]);
            } else {
                fVar.d();
                e.this.f28270c.getLogger().c(SentryLevel.DEBUG, "Disk flush envelope fired", new Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(p5 p5Var, Object obj) {
            e.this.f28270c.getClientReportRecorder().b(io.sentry.clientreport.f.NETWORK_ERROR, p5Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(p5 p5Var, Object obj, Class cls) {
            io.sentry.util.t.a(cls, obj, e.this.f28270c.getLogger());
            e.this.f28270c.getClientReportRecorder().b(io.sentry.clientreport.f.NETWORK_ERROR, p5Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(Object obj, Class cls) {
            io.sentry.util.t.a(cls, obj, e.this.f28270c.getLogger());
            e.this.f28270c.getClientReportRecorder().b(io.sentry.clientreport.f.NETWORK_ERROR, this.f28276a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(d0 d0Var, io.sentry.hints.p pVar) {
            e.this.f28270c.getLogger().c(SentryLevel.DEBUG, "Marking envelope submission result: %s", Boolean.valueOf(d0Var.d()));
            pVar.c(d0Var.d());
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f28274g = this;
            final d0 d0VarJ = this.f28279d;
            try {
                d0VarJ = j();
                e.this.f28270c.getLogger().c(SentryLevel.DEBUG, "Envelope flushed", new Object[0]);
            } finally {
            }
        }
    }

    public e(@NotNull SentryOptions sentryOptions, @NotNull b0 b0Var, @NotNull s sVar, @NotNull c4 c4Var) {
        this(J(sentryOptions.getMaxQueueSize(), sentryOptions.getEnvelopeDiskCache(), sentryOptions.getLogger(), sentryOptions.getDateProvider()), sentryOptions, b0Var, sVar, new o(sentryOptions, c4Var, b0Var));
    }

    private static x J(int i10, @NotNull final io.sentry.cache.g gVar, @NotNull final w0 w0Var, @NotNull o5 o5Var) {
        return new x(1, i10, new b(), new RejectedExecutionHandler() { // from class: io.sentry.transport.b
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                e.L(gVar, w0Var, runnable, threadPoolExecutor);
            }
        }, w0Var, o5Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L(io.sentry.cache.g gVar, w0 w0Var, Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        if (runnable instanceof c) {
            c cVar = (c) runnable;
            if (!io.sentry.util.m.h(cVar.f28277b, io.sentry.hints.e.class)) {
                gVar.L(cVar.f28276a, cVar.f28277b);
            }
            W(cVar.f28277b, true);
            w0Var.c(SentryLevel.WARNING, "Envelope rejected", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(io.sentry.hints.g gVar) {
        gVar.b();
        this.f28270c.getLogger().c(SentryLevel.DEBUG, "Envelope enqueued", new Object[0]);
    }

    private static void W(@NotNull l0 l0Var, final boolean z10) {
        io.sentry.util.m.o(l0Var, io.sentry.hints.p.class, new m.a() { // from class: io.sentry.transport.c
            @Override // io.sentry.util.m.a
            public final void accept(Object obj) {
                ((io.sentry.hints.p) obj).c(false);
            }
        });
        io.sentry.util.m.o(l0Var, io.sentry.hints.k.class, new m.a() { // from class: io.sentry.transport.d
            @Override // io.sentry.util.m.a
            public final void accept(Object obj) {
                ((io.sentry.hints.k) obj).d(z10);
            }
        });
    }

    @Override // io.sentry.transport.r
    public void b(boolean z10) throws IOException {
        long flushTimeoutMillis;
        this.f28271d.close();
        this.f28268a.shutdown();
        this.f28270c.getLogger().c(SentryLevel.DEBUG, "Shutting down", new Object[0]);
        if (z10) {
            flushTimeoutMillis = 0;
        } else {
            try {
                flushTimeoutMillis = this.f28270c.getFlushTimeoutMillis();
            } catch (InterruptedException unused) {
                this.f28270c.getLogger().c(SentryLevel.DEBUG, "Thread interrupted while closing the connection.", new Object[0]);
                Thread.currentThread().interrupt();
                return;
            }
        }
        if (this.f28268a.awaitTermination(flushTimeoutMillis, TimeUnit.MILLISECONDS)) {
            return;
        }
        this.f28270c.getLogger().c(SentryLevel.WARNING, "Failed to shutdown the async connection async sender  within " + flushTimeoutMillis + " ms. Trying to force it now.", new Object[0]);
        this.f28268a.shutdownNow();
        if (this.f28274g != null) {
            this.f28268a.getRejectedExecutionHandler().rejectedExecution(this.f28274g, this.f28268a);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        b(false);
    }

    @Override // io.sentry.transport.r
    public boolean d() {
        return (this.f28271d.L() || this.f28268a.a()) ? false : true;
    }

    @Override // io.sentry.transport.r
    @NotNull
    public b0 e() {
        return this.f28271d;
    }

    @Override // io.sentry.transport.r
    public void f(long j10) {
        this.f28268a.c(j10);
    }

    @Override // io.sentry.transport.r
    public void v(@NotNull p5 p5Var, @NotNull l0 l0Var) throws IOException {
        io.sentry.cache.g gVarA = this.f28269b;
        boolean z10 = false;
        if (io.sentry.util.m.h(l0Var, io.sentry.hints.e.class)) {
            gVarA = t.a();
            this.f28270c.getLogger().c(SentryLevel.DEBUG, "Captured Envelope is already cached", new Object[0]);
            z10 = true;
        }
        p5 p5VarZ = this.f28271d.z(p5Var, l0Var);
        if (p5VarZ == null) {
            if (z10) {
                this.f28269b.c(p5Var);
                return;
            }
            return;
        }
        if (io.sentry.util.m.h(l0Var, UncaughtExceptionHandlerIntegration.a.class)) {
            p5VarZ = this.f28270c.getClientReportRecorder().e(p5VarZ);
        }
        Future<?> futureSubmit = this.f28268a.submit(new c(p5VarZ, l0Var, gVarA));
        if (futureSubmit == null || !futureSubmit.isCancelled()) {
            io.sentry.util.m.o(l0Var, io.sentry.hints.g.class, new m.a() { // from class: io.sentry.transport.a
                @Override // io.sentry.util.m.a
                public final void accept(Object obj) {
                    this.f28253a.S((io.sentry.hints.g) obj);
                }
            });
        } else {
            this.f28270c.getClientReportRecorder().b(io.sentry.clientreport.f.QUEUE_OVERFLOW, p5VarZ);
        }
    }

    @Override // io.sentry.transport.r
    public /* synthetic */ void z0(p5 p5Var) throws IOException {
        q.b(this, p5Var);
    }

    public e(@NotNull x xVar, @NotNull SentryOptions sentryOptions, @NotNull b0 b0Var, @NotNull s sVar, @NotNull o oVar) {
        this.f28274g = null;
        this.f28268a = (x) io.sentry.util.w.c(xVar, "executor is required");
        this.f28269b = (io.sentry.cache.g) io.sentry.util.w.c(sentryOptions.getEnvelopeDiskCache(), "envelopeCache is required");
        this.f28270c = (SentryOptions) io.sentry.util.w.c(sentryOptions, "options is required");
        this.f28271d = (b0) io.sentry.util.w.c(b0Var, "rateLimiter is required");
        this.f28272e = (s) io.sentry.util.w.c(sVar, "transportGate is required");
        this.f28273f = (o) io.sentry.util.w.c(oVar, "httpConnection is required");
    }
}

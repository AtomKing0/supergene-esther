package io.sentry;

import java.net.InetAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HostnameCache.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class o0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private static volatile o0 f28019i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f28021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private volatile String f28022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long f28023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final AtomicBoolean f28024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final Callable<InetAddress> f28025e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final ExecutorService f28026f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f28017g = TimeUnit.HOURS.toMillis(5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f28018h = TimeUnit.SECONDS.toMillis(1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private static final io.sentry.util.a f28020j = new io.sentry.util.a();

    /* JADX INFO: compiled from: HostnameCache.java */
    private static final class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f28027a;

        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        @NotNull
        public Thread newThread(@NotNull Runnable runnable) {
            StringBuilder sb = new StringBuilder();
            sb.append("SentryHostnameCache-");
            int i10 = this.f28027a;
            this.f28027a = i10 + 1;
            sb.append(i10);
            Thread thread = new Thread(runnable, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    private o0() {
        this(f28017g);
    }

    @NotNull
    public static o0 e() {
        if (f28019i == null) {
            k1 k1VarA = f28020j.a();
            try {
                if (f28019i == null) {
                    f28019i = new o0();
                }
                if (k1VarA != null) {
                    k1VarA.close();
                }
            } catch (Throwable th) {
                if (k1VarA != null) {
                    try {
                        k1VarA.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return f28019i;
    }

    private void f() {
        this.f28023c = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void h() throws Exception {
        try {
            this.f28022b = this.f28025e.call().getCanonicalHostName();
            this.f28023c = System.currentTimeMillis() + this.f28021a;
            this.f28024d.set(false);
            return null;
        } catch (Throwable th) {
            this.f28024d.set(false);
            throw th;
        }
    }

    private void i() {
        try {
            this.f28026f.submit(new Callable() { // from class: io.sentry.n0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f28009a.h();
                }
            }).get(f28018h, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            f();
        } catch (RuntimeException | ExecutionException | TimeoutException unused2) {
            f();
        }
    }

    void c() {
        this.f28026f.shutdown();
    }

    @Nullable
    public String d() {
        if (this.f28023c < System.currentTimeMillis() && this.f28024d.compareAndSet(false, true)) {
            i();
        }
        return this.f28022b;
    }

    o0(long j10) {
        this(j10, new Callable() { // from class: io.sentry.m0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return InetAddress.getLocalHost();
            }
        });
    }

    o0(long j10, @NotNull Callable<InetAddress> callable) {
        this.f28024d = new AtomicBoolean(false);
        this.f28026f = Executors.newSingleThreadExecutor(new b());
        this.f28021a = j10;
        this.f28025e = (Callable) io.sentry.util.w.c(callable, "getLocalhost is required");
        i();
    }
}

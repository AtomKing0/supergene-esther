package io.sentry;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: compiled from: SentryExecutorService.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class t6 implements j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ScheduledExecutorService f28248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f28249b;

    /* JADX INFO: compiled from: SentryExecutorService.java */
    private static final class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f28250a;

        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        @NotNull
        public Thread newThread(@NotNull Runnable runnable) {
            StringBuilder sb = new StringBuilder();
            sb.append("SentryExecutorServiceThreadFactory-");
            int i10 = this.f28250a;
            this.f28250a = i10 + 1;
            sb.append(i10);
            Thread thread = new Thread(runnable, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    @TestOnly
    t6(@NotNull ScheduledExecutorService scheduledExecutorService) {
        this.f28249b = new io.sentry.util.a();
        this.f28248a = scheduledExecutorService;
    }

    @Override // io.sentry.j1
    public void a(long j10) {
        k1 k1VarA = this.f28249b.a();
        try {
            if (!this.f28248a.isShutdown()) {
                this.f28248a.shutdown();
                try {
                    if (!this.f28248a.awaitTermination(j10, TimeUnit.MILLISECONDS)) {
                        this.f28248a.shutdownNow();
                    }
                } catch (InterruptedException unused) {
                    this.f28248a.shutdownNow();
                    Thread.currentThread().interrupt();
                }
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

    @Override // io.sentry.j1
    @NotNull
    public Future<?> b(@NotNull Runnable runnable, long j10) {
        return this.f28248a.schedule(runnable, j10, TimeUnit.MILLISECONDS);
    }

    @Override // io.sentry.j1
    public boolean isClosed() {
        k1 k1VarA = this.f28249b.a();
        try {
            boolean zIsShutdown = this.f28248a.isShutdown();
            if (k1VarA != null) {
                k1VarA.close();
            }
            return zIsShutdown;
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

    @Override // io.sentry.j1
    @NotNull
    public Future<?> submit(@NotNull Runnable runnable) {
        return this.f28248a.submit(runnable);
    }

    public t6() {
        this(Executors.newSingleThreadScheduledExecutor(new b()));
    }
}

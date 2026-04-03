package io.sentry.transport;

import androidx.media3.exoplayer.ExoPlayer;
import io.sentry.SentryLevel;
import io.sentry.n5;
import io.sentry.o5;
import io.sentry.w0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: QueuedThreadPoolExecutor.java */
/* JADX INFO: loaded from: classes5.dex */
final class x extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f28301f = io.sentry.n.i(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f28302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private n5 f28303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final w0 f28304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final o5 f28305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final c0 f28306e;

    /* JADX INFO: compiled from: QueuedThreadPoolExecutor.java */
    static final class a<T> implements Future<T> {
        a() {
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            return true;
        }

        @Override // java.util.concurrent.Future
        public T get() {
            throw new CancellationException();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public T get(long j10, @NotNull TimeUnit timeUnit) {
            throw new CancellationException();
        }
    }

    public x(int i10, int i11, @NotNull ThreadFactory threadFactory, @NotNull RejectedExecutionHandler rejectedExecutionHandler, @NotNull w0 w0Var, @NotNull o5 o5Var) {
        super(i10, i10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory, rejectedExecutionHandler);
        this.f28303b = null;
        this.f28306e = new c0();
        this.f28302a = i11;
        this.f28304c = w0Var;
        this.f28305d = o5Var;
    }

    public boolean a() {
        n5 n5Var = this.f28303b;
        return n5Var != null && this.f28305d.a().c(n5Var) < f28301f;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(@NotNull Runnable runnable, @Nullable Throwable th) {
        try {
            super.afterExecute(runnable, th);
        } finally {
            this.f28306e.a();
        }
    }

    public boolean b() {
        return this.f28306e.b() < this.f28302a;
    }

    void c(long j10) {
        try {
            this.f28306e.d(j10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            this.f28304c.b(SentryLevel.ERROR, "Failed to wait till idle", e10);
            Thread.currentThread().interrupt();
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(@NotNull Runnable runnable) {
        if (b()) {
            this.f28306e.c();
            return super.submit(runnable);
        }
        this.f28303b = this.f28305d.a();
        this.f28304c.c(SentryLevel.WARNING, "Submit cancelled", new Object[0]);
        return new a();
    }
}

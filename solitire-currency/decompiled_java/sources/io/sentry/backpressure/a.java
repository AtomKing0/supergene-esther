package io.sentry.backpressure;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.f1;
import io.sentry.j1;
import io.sentry.k1;
import java.util.concurrent.Future;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BackpressureMonitor.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements b, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryOptions f27621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final f1 f27622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f27623c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private volatile Future<?> f27624d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f27625e = new io.sentry.util.a();

    public a(@NotNull SentryOptions sentryOptions, @NotNull f1 f1Var) {
        this.f27621a = sentryOptions;
        this.f27622b = f1Var;
    }

    private boolean c() {
        return this.f27622b.d();
    }

    private void d(int i10) {
        j1 executorService = this.f27621a.getExecutorService();
        if (executorService.isClosed()) {
            return;
        }
        k1 k1VarA = this.f27625e.a();
        try {
            this.f27624d = executorService.b(this, i10);
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

    @Override // io.sentry.backpressure.b
    public int a() {
        return this.f27623c;
    }

    void b() {
        if (c()) {
            if (this.f27623c > 0) {
                this.f27621a.getLogger().c(SentryLevel.DEBUG, "Health check positive, reverting to normal sampling.", new Object[0]);
            }
            this.f27623c = 0;
        } else {
            int i10 = this.f27623c;
            if (i10 < 10) {
                this.f27623c = i10 + 1;
                this.f27621a.getLogger().c(SentryLevel.DEBUG, "Health check negative, downsampling with a factor of %d", Integer.valueOf(this.f27623c));
            }
        }
    }

    @Override // io.sentry.backpressure.b
    public void close() {
        Future<?> future = this.f27624d;
        if (future != null) {
            k1 k1VarA = this.f27625e.a();
            try {
                future.cancel(true);
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
    }

    @Override // java.lang.Runnable
    public void run() {
        b();
        d(10000);
    }

    @Override // io.sentry.backpressure.b
    public void start() {
        d(500);
    }
}

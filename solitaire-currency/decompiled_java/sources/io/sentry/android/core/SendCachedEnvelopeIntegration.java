package io.sentry.android.core;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.r0;
import io.sentry.t4;
import io.sentry.x4;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
final class SendCachedEnvelopeIntegration implements io.sentry.v1, r0.b, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final x4 f27078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.r<Boolean> f27079b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private io.sentry.r0 f27081d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private io.sentry.f1 f27082e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private SentryAndroidOptions f27083f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private t4 f27084g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f27080c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f27085h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f27086i = new AtomicBoolean(false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f27087j = new io.sentry.util.a();

    public SendCachedEnvelopeIntegration(@NotNull x4 x4Var, @NotNull io.sentry.util.r<Boolean> rVar) {
        this.f27078a = (x4) io.sentry.util.w.c(x4Var, "SendFireAndForgetFactory is required");
        this.f27079b = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(SentryAndroidOptions sentryAndroidOptions, io.sentry.f1 f1Var) {
        try {
            if (this.f27086i.get()) {
                sentryAndroidOptions.getLogger().c(SentryLevel.INFO, "SendCachedEnvelopeIntegration, not trying to send after closing.", new Object[0]);
                return;
            }
            if (!this.f27085h.getAndSet(true)) {
                io.sentry.r0 connectionStatusProvider = sentryAndroidOptions.getConnectionStatusProvider();
                this.f27081d = connectionStatusProvider;
                connectionStatusProvider.b(this);
                this.f27084g = this.f27078a.a(f1Var, sentryAndroidOptions);
            }
            io.sentry.r0 r0Var = this.f27081d;
            if (r0Var != null && r0Var.a() == r0.a.DISCONNECTED) {
                sentryAndroidOptions.getLogger().c(SentryLevel.INFO, "SendCachedEnvelopeIntegration, no connection.", new Object[0]);
                return;
            }
            io.sentry.transport.b0 b0VarE = f1Var.e();
            if (b0VarE != null && b0VarE.J(io.sentry.m.All)) {
                sentryAndroidOptions.getLogger().c(SentryLevel.INFO, "SendCachedEnvelopeIntegration, rate limiting active.", new Object[0]);
                return;
            }
            t4 t4Var = this.f27084g;
            if (t4Var == null) {
                sentryAndroidOptions.getLogger().c(SentryLevel.ERROR, "SendCachedEnvelopeIntegration factory is null.", new Object[0]);
            } else {
                t4Var.a();
            }
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Failed trying to send cached events.", th);
        }
    }

    private void q(@NotNull final io.sentry.f1 f1Var, @NotNull final SentryAndroidOptions sentryAndroidOptions) {
        try {
            io.sentry.k1 k1VarA = this.f27087j.a();
            try {
                Future<?> futureSubmit = sentryAndroidOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.core.c2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f27138a.n(sentryAndroidOptions, f1Var);
                    }
                });
                if (this.f27079b.a().booleanValue() && this.f27080c.compareAndSet(false, true)) {
                    sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "Startup Crash marker exists, blocking flush.", new Object[0]);
                    try {
                        futureSubmit.get(sentryAndroidOptions.getStartupCrashFlushTimeoutMillis(), TimeUnit.MILLISECONDS);
                    } catch (TimeoutException unused) {
                        sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "Synchronous send timed out, continuing in the background.", new Object[0]);
                    }
                }
                sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "SendCachedEnvelopeIntegration installed.", new Object[0]);
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
        } catch (RejectedExecutionException e10) {
            sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Failed to call the executor. Cached events will not be sent. Did you call Sentry.close()?", e10);
        } catch (Throwable th3) {
            sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Failed to call the executor. Cached events will not be sent", th3);
        }
    }

    @Override // io.sentry.r0.b
    public void a(@NotNull r0.a aVar) {
        SentryAndroidOptions sentryAndroidOptions;
        io.sentry.f1 f1Var = this.f27082e;
        if (f1Var == null || (sentryAndroidOptions = this.f27083f) == null) {
            return;
        }
        q(f1Var, sentryAndroidOptions);
    }

    @Override // io.sentry.v1
    public void c(@NotNull io.sentry.f1 f1Var, @NotNull SentryOptions sentryOptions) {
        this.f27082e = (io.sentry.f1) io.sentry.util.w.c(f1Var, "Scopes are required");
        this.f27083f = (SentryAndroidOptions) io.sentry.util.w.c(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        if (!this.f27078a.b(sentryOptions.getCacheDirPath(), sentryOptions.getLogger())) {
            sentryOptions.getLogger().c(SentryLevel.ERROR, "No cache dir path is defined in options.", new Object[0]);
        } else {
            io.sentry.util.p.a("SendCachedEnvelope");
            q(f1Var, this.f27083f);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f27086i.set(true);
        io.sentry.r0 r0Var = this.f27081d;
        if (r0Var != null) {
            r0Var.c(this);
        }
    }
}

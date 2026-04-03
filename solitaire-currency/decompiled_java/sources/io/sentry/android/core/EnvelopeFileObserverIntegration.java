package io.sentry.android.core;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.q3;
import java.io.Closeable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: loaded from: classes5.dex */
public abstract class EnvelopeFileObserverIntegration implements io.sentry.v1, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private l1 f27047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private io.sentry.w0 f27048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f27049c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    protected final io.sentry.util.a f27050d = new io.sentry.util.a();

    private static final class OutboxEnvelopeFileObserverIntegration extends EnvelopeFileObserverIntegration {
        private OutboxEnvelopeFileObserverIntegration() {
        }

        @Override // io.sentry.android.core.EnvelopeFileObserverIntegration
        @Nullable
        protected String n(@NotNull SentryOptions sentryOptions) {
            return sentryOptions.getOutboxPath();
        }
    }

    @NotNull
    public static EnvelopeFileObserverIntegration i() {
        return new OutboxEnvelopeFileObserverIntegration();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(io.sentry.f1 f1Var, SentryOptions sentryOptions, String str) {
        io.sentry.k1 k1VarA = this.f27050d.a();
        try {
            if (!this.f27049c) {
                x(f1Var, sentryOptions, str);
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

    private void x(@NotNull io.sentry.f1 f1Var, @NotNull SentryOptions sentryOptions, @NotNull String str) {
        l1 l1Var = new l1(str, new q3(f1Var, sentryOptions.getEnvelopeReader(), sentryOptions.getSerializer(), sentryOptions.getLogger(), sentryOptions.getFlushTimeoutMillis(), sentryOptions.getMaxQueueSize()), sentryOptions.getLogger(), sentryOptions.getFlushTimeoutMillis());
        this.f27047a = l1Var;
        try {
            l1Var.startWatching();
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "EnvelopeFileObserverIntegration installed.", new Object[0]);
            io.sentry.util.p.a("EnvelopeFileObserver");
        } catch (Throwable th) {
            sentryOptions.getLogger().b(SentryLevel.ERROR, "Failed to initialize EnvelopeFileObserverIntegration.", th);
        }
    }

    @Override // io.sentry.v1
    public final void c(@NotNull final io.sentry.f1 f1Var, @NotNull final SentryOptions sentryOptions) {
        io.sentry.util.w.c(f1Var, "Scopes are required");
        io.sentry.util.w.c(sentryOptions, "SentryOptions is required");
        this.f27048b = sentryOptions.getLogger();
        final String strN = n(sentryOptions);
        if (strN == null) {
            this.f27048b.c(SentryLevel.WARNING, "Null given as a path to EnvelopeFileObserverIntegration. Nothing will be registered.", new Object[0]);
            return;
        }
        this.f27048b.c(SentryLevel.DEBUG, "Registering EnvelopeFileObserverIntegration for path: %s", strN);
        try {
            sentryOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.core.m1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f27408a.q(f1Var, sentryOptions, strN);
                }
            });
        } catch (Throwable th) {
            this.f27048b.b(SentryLevel.DEBUG, "Failed to start EnvelopeFileObserverIntegration on executor thread.", th);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        io.sentry.k1 k1VarA = this.f27050d.a();
        try {
            this.f27049c = true;
            if (k1VarA != null) {
                k1VarA.close();
            }
            l1 l1Var = this.f27047a;
            if (l1Var != null) {
                l1Var.stopWatching();
                io.sentry.w0 w0Var = this.f27048b;
                if (w0Var != null) {
                    w0Var.c(SentryLevel.DEBUG, "EnvelopeFileObserverIntegration removed.", new Object[0]);
                }
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

    @TestOnly
    @Nullable
    abstract String n(@NotNull SentryOptions sentryOptions);
}

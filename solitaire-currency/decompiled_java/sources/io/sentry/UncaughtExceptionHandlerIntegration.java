package io.sentry;

import io.sentry.b9;
import io.sentry.protocol.Mechanism;
import io.sentry.protocol.SentryId;
import java.io.Closeable;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: loaded from: classes5.dex */
public final class UncaughtExceptionHandlerIntegration implements v1, Thread.UncaughtExceptionHandler, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private Thread.UncaughtExceptionHandler f26967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private f1 f26968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private SentryOptions f26969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f26970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final b9 f26971e;

    @ApiStatus.Internal
    public static class a extends io.sentry.hints.d implements io.sentry.hints.l, io.sentry.hints.q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final AtomicReference<SentryId> f26972d;

        public a(long j10, @NotNull w0 w0Var) {
            super(j10, w0Var);
            this.f26972d = new AtomicReference<>();
        }

        @Override // io.sentry.hints.f
        public boolean b(@Nullable SentryId sentryId) {
            SentryId sentryId2 = this.f26972d.get();
            return sentryId2 != null && sentryId2.equals(sentryId);
        }

        @Override // io.sentry.hints.f
        public void c(@NotNull SentryId sentryId) {
            this.f26972d.set(sentryId);
        }
    }

    public UncaughtExceptionHandlerIntegration() {
        this(b9.a.c());
    }

    @TestOnly
    @NotNull
    static Throwable a(@NotNull Thread thread, @NotNull Throwable th) {
        Mechanism mechanism = new Mechanism();
        mechanism.setHandled(Boolean.FALSE);
        mechanism.setType("UncaughtExceptionHandler");
        return new io.sentry.exception.a(mechanism, th, thread);
    }

    @Override // io.sentry.v1
    public final void c(@NotNull f1 f1Var, @NotNull SentryOptions sentryOptions) {
        if (this.f26970d) {
            sentryOptions.getLogger().c(SentryLevel.ERROR, "Attempt to register a UncaughtExceptionHandlerIntegration twice.", new Object[0]);
            return;
        }
        this.f26970d = true;
        this.f26968b = (f1) io.sentry.util.w.c(f1Var, "Scopes are required");
        SentryOptions sentryOptions2 = (SentryOptions) io.sentry.util.w.c(sentryOptions, "SentryOptions is required");
        this.f26969c = sentryOptions2;
        w0 logger = sentryOptions2.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "UncaughtExceptionHandlerIntegration enabled: %s", Boolean.valueOf(this.f26969c.isEnableUncaughtExceptionHandler()));
        if (this.f26969c.isEnableUncaughtExceptionHandler()) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandlerB = this.f26971e.b();
            if (uncaughtExceptionHandlerB != null) {
                this.f26969c.getLogger().c(sentryLevel, "default UncaughtExceptionHandler class='" + uncaughtExceptionHandlerB.getClass().getName() + "'", new Object[0]);
                if (uncaughtExceptionHandlerB instanceof UncaughtExceptionHandlerIntegration) {
                    this.f26967a = ((UncaughtExceptionHandlerIntegration) uncaughtExceptionHandlerB).f26967a;
                } else {
                    this.f26967a = uncaughtExceptionHandlerB;
                }
            }
            this.f26971e.a(this);
            this.f26969c.getLogger().c(sentryLevel, "UncaughtExceptionHandlerIntegration installed.", new Object[0]);
            io.sentry.util.p.a("UncaughtExceptionHandler");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this == this.f26971e.b()) {
            this.f26971e.a(this.f26967a);
            SentryOptions sentryOptions = this.f26969c;
            if (sentryOptions != null) {
                sentryOptions.getLogger().c(SentryLevel.DEBUG, "UncaughtExceptionHandlerIntegration removed.", new Object[0]);
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        SentryOptions sentryOptions = this.f26969c;
        if (sentryOptions == null || this.f26968b == null) {
            return;
        }
        sentryOptions.getLogger().c(SentryLevel.INFO, "Uncaught exception received.", new Object[0]);
        try {
            a aVar = new a(this.f26969c.getFlushTimeoutMillis(), this.f26969c.getLogger());
            r6 r6Var = new r6(a(thread, th));
            r6Var.v(SentryLevel.FATAL);
            if (this.f26968b.getTransaction() == null && r6Var.getEventId() != null) {
                aVar.c(r6Var.getEventId());
            }
            l0 l0VarE = io.sentry.util.m.e(aVar);
            boolean zEquals = this.f26968b.E(r6Var, l0VarE).equals(SentryId.EMPTY_ID);
            io.sentry.hints.h hVarF = io.sentry.util.m.f(l0VarE);
            if ((!zEquals || io.sentry.hints.h.MULTITHREADED_DEDUPLICATION.equals(hVarF)) && !aVar.g()) {
                this.f26969c.getLogger().c(SentryLevel.WARNING, "Timed out waiting to flush event to disk before crashing. Event: %s", r6Var.getEventId());
            }
        } catch (Throwable th2) {
            this.f26969c.getLogger().b(SentryLevel.ERROR, "Error sending uncaught exception to Sentry.", th2);
        }
        if (this.f26967a != null) {
            this.f26969c.getLogger().c(SentryLevel.INFO, "Invoking inner uncaught exception handler.", new Object[0]);
            this.f26967a.uncaughtException(thread, th);
        } else if (this.f26969c.isPrintUncaughtStackTrace()) {
            th.printStackTrace();
        }
    }

    UncaughtExceptionHandlerIntegration(@NotNull b9 b9Var) {
        this.f26970d = false;
        this.f26971e = (b9) io.sentry.util.w.c(b9Var, "threadAdapter is required.");
    }
}

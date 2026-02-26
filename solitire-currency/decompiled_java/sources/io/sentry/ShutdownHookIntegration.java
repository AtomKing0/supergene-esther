package io.sentry;

import java.io.Closeable;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: loaded from: classes5.dex */
public final class ShutdownHookIntegration implements v1, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Runtime f26962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private Thread f26963b;

    @TestOnly
    public ShutdownHookIntegration(@NotNull Runtime runtime) {
        this.f26962a = (Runtime) io.sentry.util.w.c(runtime, "Runtime is required");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(SentryOptions sentryOptions) {
        this.f26962a.addShutdownHook(this.f26963b);
        sentryOptions.getLogger().c(SentryLevel.DEBUG, "ShutdownHookIntegration installed.", new Object[0]);
        io.sentry.util.p.a("ShutdownHook");
    }

    private void q(@NotNull Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalStateException e10) {
            String message = e10.getMessage();
            if (message == null || !(message.equals("Shutdown in progress") || message.equals("VM already shutting down"))) {
                throw e10;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x() {
        this.f26962a.removeShutdownHook(this.f26963b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(f1 f1Var, SentryOptions sentryOptions) {
        f1Var.f(sentryOptions.getFlushTimeoutMillis());
    }

    @Override // io.sentry.v1
    public void c(@NotNull final f1 f1Var, @NotNull final SentryOptions sentryOptions) {
        io.sentry.util.w.c(f1Var, "Scopes are required");
        io.sentry.util.w.c(sentryOptions, "SentryOptions is required");
        if (!sentryOptions.isEnableShutdownHook()) {
            sentryOptions.getLogger().c(SentryLevel.INFO, "enableShutdownHook is disabled.", new Object[0]);
        } else {
            this.f26963b = new Thread(new Runnable() { // from class: io.sentry.f8
                @Override // java.lang.Runnable
                public final void run() {
                    ShutdownHookIntegration.z(f1Var, sentryOptions);
                }
            });
            q(new Runnable() { // from class: io.sentry.g8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f27840a.B(sentryOptions);
                }
            });
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f26963b != null) {
            q(new Runnable() { // from class: io.sentry.h8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f27851a.x();
                }
            });
        }
    }

    public ShutdownHookIntegration() {
        this(Runtime.getRuntime());
    }
}

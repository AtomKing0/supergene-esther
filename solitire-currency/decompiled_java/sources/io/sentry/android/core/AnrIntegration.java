package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.content.Context;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.c;
import io.sentry.protocol.Mechanism;
import io.sentry.r6;
import java.io.Closeable;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: loaded from: classes5.dex */
public final class AnrIntegration implements io.sentry.v1, Closeable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    @Nullable
    private static c f27016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    protected static final io.sentry.util.a f27017f = new io.sentry.util.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f27018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f27019b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f27020c = new io.sentry.util.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private SentryOptions f27021d;

    static final class a implements io.sentry.hints.a, io.sentry.hints.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f27022a;

        a(boolean z10) {
            this.f27022a = z10;
        }

        @Override // io.sentry.hints.a
        @Nullable
        public Long e() {
            return null;
        }

        @Override // io.sentry.hints.a
        public boolean f() {
            return true;
        }

        @Override // io.sentry.hints.a
        public String h() {
            return this.f27022a ? "anr_background" : "anr_foreground";
        }
    }

    public AnrIntegration(@NotNull Context context) {
        this.f27018a = e1.h(context);
    }

    private void J(@NotNull final io.sentry.f1 f1Var, @NotNull final SentryAndroidOptions sentryAndroidOptions) {
        io.sentry.k1 k1VarA = f27017f.a();
        try {
            if (f27016e == null) {
                io.sentry.w0 logger = sentryAndroidOptions.getLogger();
                SentryLevel sentryLevel = SentryLevel.DEBUG;
                logger.c(sentryLevel, "ANR timeout in milliseconds: %d", Long.valueOf(sentryAndroidOptions.getAnrTimeoutIntervalMillis()));
                c cVar = new c(sentryAndroidOptions.getAnrTimeoutIntervalMillis(), sentryAndroidOptions.isAnrReportInDebug(), new c.a() { // from class: io.sentry.android.core.l0
                    @Override // io.sentry.android.core.c.a
                    public final void a(ApplicationNotResponding applicationNotResponding) {
                        this.f27392a.x(f1Var, sentryAndroidOptions, applicationNotResponding);
                    }
                }, sentryAndroidOptions.getLogger(), this.f27018a);
                f27016e = cVar;
                cVar.start();
                sentryAndroidOptions.getLogger().c(sentryLevel, "AnrIntegration installed.", new Object[0]);
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
        } catch (Throwable th) {
            if (k1VarA == null) {
                throw th;
            }
            try {
                k1VarA.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    @NotNull
    private Throwable n(boolean z10, @NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull ApplicationNotResponding applicationNotResponding) {
        String str = "ANR for at least " + sentryAndroidOptions.getAnrTimeoutIntervalMillis() + " ms.";
        if (z10) {
            str = "Background " + str;
        }
        ApplicationNotResponding applicationNotResponding2 = new ApplicationNotResponding(str, applicationNotResponding.a());
        Mechanism mechanism = new Mechanism();
        mechanism.setType("ANR");
        return new io.sentry.exception.a(mechanism, applicationNotResponding2, applicationNotResponding2.a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(io.sentry.f1 f1Var, SentryAndroidOptions sentryAndroidOptions) {
        io.sentry.k1 k1VarA = this.f27020c.a();
        try {
            if (!this.f27019b) {
                J(f1Var, sentryAndroidOptions);
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

    private void z(@NotNull final io.sentry.f1 f1Var, @NotNull final SentryAndroidOptions sentryAndroidOptions) {
        sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "AnrIntegration enabled: %s", Boolean.valueOf(sentryAndroidOptions.isAnrEnabled()));
        if (sentryAndroidOptions.isAnrEnabled()) {
            io.sentry.util.p.a("Anr");
            try {
                sentryAndroidOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.core.k0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f27371a.q(f1Var, sentryAndroidOptions);
                    }
                });
            } catch (Throwable th) {
                sentryAndroidOptions.getLogger().b(SentryLevel.DEBUG, "Failed to start AnrIntegration on executor thread.", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TestOnly
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void x(@NotNull io.sentry.f1 f1Var, @NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull ApplicationNotResponding applicationNotResponding) {
        sentryAndroidOptions.getLogger().c(SentryLevel.INFO, "ANR triggered with message: %s", applicationNotResponding.getMessage());
        boolean zEquals = Boolean.TRUE.equals(v0.a().b());
        r6 r6Var = new r6(n(zEquals, sentryAndroidOptions, applicationNotResponding));
        r6Var.v(SentryLevel.ERROR);
        f1Var.E(r6Var, io.sentry.util.m.e(new a(zEquals)));
    }

    @Override // io.sentry.v1
    public final void c(@NotNull io.sentry.f1 f1Var, @NotNull SentryOptions sentryOptions) {
        this.f27021d = (SentryOptions) io.sentry.util.w.c(sentryOptions, "SentryOptions is required");
        z(f1Var, (SentryAndroidOptions) sentryOptions);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        io.sentry.k1 k1VarA = this.f27020c.a();
        try {
            this.f27019b = true;
            if (k1VarA != null) {
                k1VarA.close();
            }
            k1VarA = f27017f.a();
            try {
                c cVar = f27016e;
                if (cVar != null) {
                    cVar.interrupt();
                    f27016e = null;
                    SentryOptions sentryOptions = this.f27021d;
                    if (sentryOptions != null) {
                        sentryOptions.getLogger().c(SentryLevel.DEBUG, "AnrIntegration removed.", new Object[0]);
                    }
                }
                if (k1VarA != null) {
                    k1VarA.close();
                }
            } finally {
            }
        } finally {
        }
    }
}

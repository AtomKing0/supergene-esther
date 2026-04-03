package io.sentry.android.core;

import com.ironsource.v8;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.io.Closeable;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class NdkIntegration implements io.sentry.v1, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Class<?> f27051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private SentryAndroidOptions f27052b;

    public NdkIntegration(@Nullable Class<?> cls) {
        this.f27051a = cls;
    }

    private void a(@NotNull SentryAndroidOptions sentryAndroidOptions) {
        sentryAndroidOptions.setEnableNdk(false);
        sentryAndroidOptions.setEnableScopeSync(false);
    }

    @Override // io.sentry.v1
    public final void c(@NotNull io.sentry.f1 f1Var, @NotNull SentryOptions sentryOptions) {
        io.sentry.util.w.c(f1Var, "Scopes are required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) io.sentry.util.w.c(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        this.f27052b = sentryAndroidOptions;
        boolean zIsEnableNdk = sentryAndroidOptions.isEnableNdk();
        io.sentry.w0 logger = this.f27052b.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "NdkIntegration enabled: %s", Boolean.valueOf(zIsEnableNdk));
        if (!zIsEnableNdk || this.f27051a == null) {
            a(this.f27052b);
            return;
        }
        if (this.f27052b.getCacheDirPath() == null) {
            this.f27052b.getLogger().c(SentryLevel.ERROR, "No cache dir path is defined in options.", new Object[0]);
            a(this.f27052b);
            return;
        }
        try {
            this.f27051a.getMethod(v8.a.f15678e, SentryAndroidOptions.class).invoke(null, this.f27052b);
            this.f27052b.getLogger().c(sentryLevel, "NdkIntegration installed.", new Object[0]);
            io.sentry.util.p.a("Ndk");
        } catch (NoSuchMethodException e10) {
            a(this.f27052b);
            this.f27052b.getLogger().b(SentryLevel.ERROR, "Failed to invoke the SentryNdk.init method.", e10);
        } catch (Throwable th) {
            a(this.f27052b);
            this.f27052b.getLogger().b(SentryLevel.ERROR, "Failed to initialize SentryNdk.", th);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        SentryAndroidOptions sentryAndroidOptions = this.f27052b;
        if (sentryAndroidOptions == null || !sentryAndroidOptions.isEnableNdk()) {
            return;
        }
        Class<?> cls = this.f27051a;
        try {
            if (cls != null) {
                try {
                    try {
                        cls.getMethod("close", new Class[0]).invoke(null, new Object[0]);
                        this.f27052b.getLogger().c(SentryLevel.DEBUG, "NdkIntegration removed.", new Object[0]);
                    } catch (NoSuchMethodException e10) {
                        this.f27052b.getLogger().b(SentryLevel.ERROR, "Failed to invoke the SentryNdk.close method.", e10);
                    }
                } finally {
                }
                a(this.f27052b);
            }
        } catch (Throwable th) {
            a(this.f27052b);
        }
    }
}

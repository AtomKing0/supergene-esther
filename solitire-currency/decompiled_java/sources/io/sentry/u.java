package io.sentry;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DiagnosticLogger.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class u implements w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryOptions f28308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final w0 f28309b;

    public u(@NotNull SentryOptions sentryOptions, @Nullable w0 w0Var) {
        this.f28308a = (SentryOptions) io.sentry.util.w.c(sentryOptions, "SentryOptions is required.");
        this.f28309b = w0Var;
    }

    @Override // io.sentry.w0
    public void a(@NotNull SentryLevel sentryLevel, @Nullable Throwable th, @NotNull String str, @Nullable Object... objArr) {
        if (this.f28309b == null || !d(sentryLevel)) {
            return;
        }
        this.f28309b.a(sentryLevel, th, str, objArr);
    }

    @Override // io.sentry.w0
    public void b(@NotNull SentryLevel sentryLevel, @NotNull String str, @Nullable Throwable th) {
        if (this.f28309b == null || !d(sentryLevel)) {
            return;
        }
        this.f28309b.b(sentryLevel, str, th);
    }

    @Override // io.sentry.w0
    public void c(@NotNull SentryLevel sentryLevel, @NotNull String str, @Nullable Object... objArr) {
        if (this.f28309b == null || !d(sentryLevel)) {
            return;
        }
        this.f28309b.c(sentryLevel, str, objArr);
    }

    @Override // io.sentry.w0
    public boolean d(@Nullable SentryLevel sentryLevel) {
        return sentryLevel != null && this.f28308a.isDebug() && sentryLevel.ordinal() >= this.f28308a.getDiagnosticLevel().ordinal();
    }
}

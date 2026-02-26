package io.sentry;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ILogger.java */
/* JADX INFO: loaded from: classes5.dex */
public interface w0 {
    void a(@NotNull SentryLevel sentryLevel, @Nullable Throwable th, @NotNull String str, @Nullable Object... objArr);

    void b(@NotNull SentryLevel sentryLevel, @NotNull String str, @Nullable Throwable th);

    void c(@NotNull SentryLevel sentryLevel, @NotNull String str, @Nullable Object... objArr);

    boolean d(@Nullable SentryLevel sentryLevel);
}

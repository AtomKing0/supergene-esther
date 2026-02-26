package io.sentry;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NoOpLogger.java */
/* JADX INFO: loaded from: classes5.dex */
public final class s2 implements w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final s2 f28218a = new s2();

    private s2() {
    }

    public static s2 e() {
        return f28218a;
    }

    @Override // io.sentry.w0
    public boolean d(@Nullable SentryLevel sentryLevel) {
        return false;
    }

    @Override // io.sentry.w0
    public void b(@NotNull SentryLevel sentryLevel, @NotNull String str, @Nullable Throwable th) {
    }

    @Override // io.sentry.w0
    public void c(@NotNull SentryLevel sentryLevel, @NotNull String str, @Nullable Object... objArr) {
    }

    @Override // io.sentry.w0
    public void a(@NotNull SentryLevel sentryLevel, @Nullable Throwable th, @NotNull String str, @Nullable Object... objArr) {
    }
}

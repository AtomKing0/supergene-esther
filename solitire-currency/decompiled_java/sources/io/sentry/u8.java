package io.sentry;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SystemOutLogger.java */
/* JADX INFO: loaded from: classes5.dex */
public final class u8 implements w0 {
    @NotNull
    private String e(@NotNull Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @Override // io.sentry.w0
    public void a(@NotNull SentryLevel sentryLevel, @Nullable Throwable th, @NotNull String str, @Nullable Object... objArr) {
        if (th == null) {
            c(sentryLevel, str, objArr);
        } else {
            System.out.println(String.format("%s: %s \n %s\n%s", sentryLevel, String.format(str, objArr), th.toString(), e(th)));
        }
    }

    @Override // io.sentry.w0
    public void b(@NotNull SentryLevel sentryLevel, @NotNull String str, @Nullable Throwable th) {
        if (th == null) {
            c(sentryLevel, str, new Object[0]);
        } else {
            System.out.println(String.format("%s: %s\n%s", sentryLevel, String.format(str, th.toString()), e(th)));
        }
    }

    @Override // io.sentry.w0
    public void c(@NotNull SentryLevel sentryLevel, @NotNull String str, @Nullable Object... objArr) {
        System.out.println(String.format("%s: %s", sentryLevel, String.format(str, objArr)));
    }

    @Override // io.sentry.w0
    public boolean d(@Nullable SentryLevel sentryLevel) {
        return true;
    }
}

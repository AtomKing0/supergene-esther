package io.sentry.android.core;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
final class ApplicationNotResponding extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Thread f27046a;

    ApplicationNotResponding(@Nullable String str, @NotNull Thread thread) {
        super(str);
        Thread thread2 = (Thread) io.sentry.util.w.c(thread, "Thread must be provided.");
        this.f27046a = thread2;
        setStackTrace(thread2.getStackTrace());
    }

    @NotNull
    public Thread a() {
        return this.f27046a;
    }
}

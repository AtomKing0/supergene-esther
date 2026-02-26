package io.sentry.exception;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InvalidSentryTraceHeaderException.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f27804a;

    public b(@NotNull String str) {
        this(str, null);
    }

    public b(@NotNull String str, @Nullable Throwable th) {
        super("sentry-trace header does not conform to expected format: " + str, th);
        this.f27804a = str;
    }
}

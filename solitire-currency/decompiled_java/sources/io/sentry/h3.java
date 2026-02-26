package io.sentry;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NoOpTransactionProfiler.java */
/* JADX INFO: loaded from: classes5.dex */
public final class h3 implements q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final h3 f27847a = new h3();

    private h3() {
    }

    public static h3 c() {
        return f27847a;
    }

    @Override // io.sentry.q1
    @Nullable
    public x3 b(@NotNull p1 p1Var, @Nullable List<r3> list, @NotNull SentryOptions sentryOptions) {
        return null;
    }

    @Override // io.sentry.q1
    public boolean isRunning() {
        return false;
    }

    @Override // io.sentry.q1
    public void close() {
    }

    @Override // io.sentry.q1
    public void start() {
    }

    @Override // io.sentry.q1
    public void a(@NotNull p1 p1Var) {
    }
}

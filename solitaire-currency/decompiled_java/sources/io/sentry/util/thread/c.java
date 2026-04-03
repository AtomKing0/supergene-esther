package io.sentry.util.thread;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ThreadChecker.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f28371a = Thread.currentThread().getId();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f28372b = new c();

    private c() {
    }

    public static c d() {
        return f28372b;
    }

    @Override // io.sentry.util.thread.a
    public boolean a() {
        return f(Thread.currentThread());
    }

    @Override // io.sentry.util.thread.a
    @NotNull
    public String b() {
        return Thread.currentThread().getName();
    }

    @Override // io.sentry.util.thread.a
    public long c() {
        return Thread.currentThread().getId();
    }

    public boolean e(long j10) {
        return f28371a == j10;
    }

    public boolean f(@NotNull Thread thread) {
        return e(thread.getId());
    }
}

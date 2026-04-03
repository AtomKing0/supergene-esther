package io.sentry;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: NoOpSentryExecutorService.java */
/* JADX INFO: loaded from: classes5.dex */
final class b3 implements j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b3 f27589a = new b3();

    private b3() {
    }

    @NotNull
    public static j1 e() {
        return f27589a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object f() throws Exception {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object g() throws Exception {
        return null;
    }

    @Override // io.sentry.j1
    @NotNull
    public Future<?> b(@NotNull Runnable runnable, long j10) {
        return new FutureTask(new Callable() { // from class: io.sentry.a3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return b3.f();
            }
        });
    }

    @Override // io.sentry.j1
    public boolean isClosed() {
        return false;
    }

    @Override // io.sentry.j1
    @NotNull
    public Future<?> submit(@NotNull Runnable runnable) {
        return new FutureTask(new Callable() { // from class: io.sentry.z2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return b3.g();
            }
        });
    }

    @Override // io.sentry.j1
    public void a(long j10) {
    }
}

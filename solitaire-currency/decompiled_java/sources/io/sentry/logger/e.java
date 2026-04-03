package io.sentry.logger;

import io.sentry.SentryOptions;
import io.sentry.d7;
import io.sentry.f7;
import io.sentry.i1;
import io.sentry.j1;
import io.sentry.k1;
import io.sentry.t6;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LoggerBatchProcessor.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e implements io.sentry.logger.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final io.sentry.util.a f27988g = new io.sentry.util.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryOptions f27989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final i1 f27990b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private volatile Future<?> f27993e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f27994f = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final Queue<d7> f27991c = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final j1 f27992d = new t6();

    /* JADX INFO: compiled from: LoggerBatchProcessor.java */
    private class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.d();
        }
    }

    public e(@NotNull SentryOptions sentryOptions, @NotNull i1 i1Var) {
        this.f27989a = sentryOptions;
        this.f27990b = i1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        f();
        k1 k1VarA = f27988g.a();
        try {
            if (this.f27991c.isEmpty()) {
                this.f27994f = false;
            } else {
                h(true, false);
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void e() {
        ArrayList arrayList = new ArrayList(100);
        do {
            d7 d7VarPoll = this.f27991c.poll();
            if (d7VarPoll != null) {
                arrayList.add(d7VarPoll);
            }
            if (this.f27991c.isEmpty()) {
                break;
            }
        } while (arrayList.size() < 100);
        this.f27990b.k(new f7(arrayList));
    }

    private void f() {
        do {
            e();
        } while (this.f27991c.size() >= 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        this.f27992d.a(this.f27989a.getShutdownTimeoutMillis());
    }

    private void h(boolean z10, boolean z11) {
        if (!this.f27994f || z10) {
            k1 k1VarA = f27988g.a();
            try {
                Future<?> future = this.f27993e;
                if (z10 || future == null || future.isDone() || future.isCancelled()) {
                    this.f27994f = true;
                    this.f27993e = this.f27992d.b(new b(), z11 ? 0 : 5000);
                }
                if (k1VarA != null) {
                    k1VarA.close();
                }
            } catch (Throwable th) {
                if (k1VarA != null) {
                    try {
                        k1VarA.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    @Override // io.sentry.logger.b
    public void b(boolean z10) {
        if (z10) {
            h(true, true);
            this.f27992d.submit(new Runnable() { // from class: io.sentry.logger.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f27987a.g();
                }
            });
        } else {
            this.f27992d.a(this.f27989a.getShutdownTimeoutMillis());
            while (!this.f27991c.isEmpty()) {
                e();
            }
        }
    }
}

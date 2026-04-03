package com.google.common.util.concurrent;

import com.google.common.util.concurrent.a;
import com.google.common.util.concurrent.g;
import com.ironsource.v8;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: MoreExecutors.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: compiled from: MoreExecutors.java */
    private static class a extends com.google.common.util.concurrent.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ExecutorService f10207a;

        a(ExecutorService executorService) {
            this.f10207a = (ExecutorService) e5.o.j(executorService);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
            return this.f10207a.awaitTermination(j10, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f10207a.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isShutdown() {
            return this.f10207a.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isTerminated() {
            return this.f10207a.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public final void shutdown() {
            this.f10207a.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final List<Runnable> shutdownNow() {
            return this.f10207a.shutdownNow();
        }

        public final String toString() {
            return super.toString() + v8.i.f15837d + this.f10207a + v8.i.f15839e;
        }
    }

    /* JADX INFO: compiled from: MoreExecutors.java */
    private static final class b extends a implements ScheduledExecutorService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ScheduledExecutorService f10208b;

        /* JADX INFO: compiled from: MoreExecutors.java */
        private static final class a<V> extends g.a<V> implements n<V> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final ScheduledFuture<?> f10209b;

            public a(m<V> mVar, ScheduledFuture<?> scheduledFuture) {
                super(mVar);
                this.f10209b = scheduledFuture;
            }

            @Override // com.google.common.util.concurrent.f, java.util.concurrent.Future
            public boolean cancel(boolean z10) {
                boolean zCancel = super.cancel(z10);
                if (zCancel) {
                    this.f10209b.cancel(z10);
                }
                return zCancel;
            }

            @Override // java.lang.Comparable
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public int compareTo(Delayed delayed) {
                return this.f10209b.compareTo(delayed);
            }

            @Override // java.util.concurrent.Delayed
            public long getDelay(TimeUnit timeUnit) {
                return this.f10209b.getDelay(timeUnit);
            }
        }

        /* JADX INFO: renamed from: com.google.common.util.concurrent.p$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MoreExecutors.java */
        private static final class RunnableC0227b extends a.j<Void> implements Runnable {

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final Runnable f10210h;

            public RunnableC0227b(Runnable runnable) {
                this.f10210h = (Runnable) e5.o.j(runnable);
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f10210h.run();
                } catch (Error | RuntimeException e10) {
                    B(e10);
                    throw e10;
                }
            }

            @Override // com.google.common.util.concurrent.a
            protected String x() {
                return "task=[" + this.f10210h + v8.i.f15839e;
            }
        }

        b(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.f10208b = (ScheduledExecutorService) e5.o.j(scheduledExecutorService);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public n<?> schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            u uVarE = u.E(runnable, null);
            return new a(uVarE, this.f10208b.schedule(uVarE, j10, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public <V> n<V> schedule(Callable<V> callable, long j10, TimeUnit timeUnit) {
            u uVarF = u.F(callable);
            return new a(uVarF, this.f10208b.schedule(uVarF, j10, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public n<?> scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            RunnableC0227b runnableC0227b = new RunnableC0227b(runnable);
            return new a(runnableC0227b, this.f10208b.scheduleAtFixedRate(runnableC0227b, j10, j11, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public n<?> scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            RunnableC0227b runnableC0227b = new RunnableC0227b(runnable);
            return new a(runnableC0227b, this.f10208b.scheduleWithFixedDelay(runnableC0227b, j10, j11, timeUnit));
        }
    }

    public static Executor a() {
        return d.INSTANCE;
    }

    public static o b(ExecutorService executorService) {
        if (executorService instanceof o) {
            return (o) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new b((ScheduledExecutorService) executorService) : new a(executorService);
    }
}

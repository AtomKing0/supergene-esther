package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class r1 extends q1 implements x0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Executor f29977b;

    public r1(@NotNull Executor executor) {
        this.f29977b = executor;
        u9.c.a(I0());
    }

    private final void J0(z8.g gVar, RejectedExecutionException rejectedExecutionException) {
        f2.d(gVar, p1.a("The task was rejected", rejectedExecutionException));
    }

    private final ScheduledFuture<?> K0(ScheduledExecutorService scheduledExecutorService, Runnable runnable, z8.g gVar, long j10) {
        try {
            return scheduledExecutorService.schedule(runnable, j10, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e10) {
            J0(gVar, e10);
            return null;
        }
    }

    @Override // kotlinx.coroutines.q1
    @NotNull
    public Executor I0() {
        return this.f29977b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executorI0 = I0();
        ExecutorService executorService = executorI0 instanceof ExecutorService ? (ExecutorService) executorI0 : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.k0
    public void dispatch(@NotNull z8.g gVar, @NotNull Runnable runnable) {
        try {
            Executor executorI0 = I0();
            c.a();
            executorI0.execute(runnable);
        } catch (RejectedExecutionException e10) {
            c.a();
            J0(gVar, e10);
            e1.b().dispatch(gVar, runnable);
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof r1) && ((r1) obj).I0() == I0();
    }

    public int hashCode() {
        return System.identityHashCode(I0());
    }

    @Override // kotlinx.coroutines.x0
    @NotNull
    public g1 invokeOnTimeout(long j10, @NotNull Runnable runnable, @NotNull z8.g gVar) {
        Executor executorI0 = I0();
        ScheduledExecutorService scheduledExecutorService = executorI0 instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorI0 : null;
        ScheduledFuture<?> scheduledFutureK0 = scheduledExecutorService != null ? K0(scheduledExecutorService, runnable, gVar, j10) : null;
        return scheduledFutureK0 != null ? new f1(scheduledFutureK0) : t0.f29980g.invokeOnTimeout(j10, runnable, gVar);
    }

    @Override // kotlinx.coroutines.x0
    public void scheduleResumeAfterDelay(long j10, @NotNull o<? super v8.k0> oVar) {
        Executor executorI0 = I0();
        ScheduledExecutorService scheduledExecutorService = executorI0 instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorI0 : null;
        ScheduledFuture<?> scheduledFutureK0 = scheduledExecutorService != null ? K0(scheduledExecutorService, new v2(this, oVar), oVar.getContext(), j10) : null;
        if (scheduledFutureK0 != null) {
            f2.h(oVar, scheduledFutureK0);
        } else {
            t0.f29980g.scheduleResumeAfterDelay(j10, oVar);
        }
    }

    @Override // kotlinx.coroutines.k0
    @NotNull
    public String toString() {
        return I0().toString();
    }
}

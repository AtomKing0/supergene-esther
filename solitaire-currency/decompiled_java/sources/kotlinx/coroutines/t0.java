package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.l1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DefaultExecutor.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class t0 extends l1 implements Runnable {

    @Nullable
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final t0 f29980g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f29981h;

    static {
        Long l10;
        t0 t0Var = new t0();
        f29980g = t0Var;
        k1.O0(t0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        f29981h = timeUnit.toNanos(l10.longValue());
    }

    private t0() {
    }

    private final synchronized void k1() {
        if (n1()) {
            debugStatus = 3;
            e1();
            kotlin.jvm.internal.t.g(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    private final synchronized Thread l1() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean m1() {
        return debugStatus == 4;
    }

    private final boolean n1() {
        int i10 = debugStatus;
        return i10 == 2 || i10 == 3;
    }

    private final synchronized boolean o1() {
        if (n1()) {
            return false;
        }
        debugStatus = 1;
        kotlin.jvm.internal.t.g(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    private final void p1() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // kotlinx.coroutines.m1
    @NotNull
    protected Thread U0() {
        Thread thread = _thread;
        return thread == null ? l1() : thread;
    }

    @Override // kotlinx.coroutines.m1
    protected void V0(long j10, @NotNull l1.c cVar) {
        p1();
    }

    @Override // kotlinx.coroutines.l1
    public void a1(@NotNull Runnable runnable) {
        if (m1()) {
            p1();
        }
        super.a1(runnable);
    }

    @Override // kotlinx.coroutines.l1, kotlinx.coroutines.x0
    @NotNull
    public g1 invokeOnTimeout(long j10, @NotNull Runnable runnable, @NotNull z8.g gVar) {
        return h1(j10, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zC1;
        b3.f29862a.d(this);
        c.a();
        try {
            if (!o1()) {
                if (zC1) {
                    return;
                } else {
                    return;
                }
            }
            long j10 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jR0 = R0();
                if (jR0 == Long.MAX_VALUE) {
                    c.a();
                    long jNanoTime = System.nanoTime();
                    if (j10 == Long.MAX_VALUE) {
                        j10 = f29981h + jNanoTime;
                    }
                    long j11 = j10 - jNanoTime;
                    if (j11 <= 0) {
                        _thread = null;
                        k1();
                        c.a();
                        if (c1()) {
                            return;
                        }
                        U0();
                        return;
                    }
                    jR0 = n9.o.k(jR0, j11);
                } else {
                    j10 = Long.MAX_VALUE;
                }
                if (jR0 > 0) {
                    if (n1()) {
                        _thread = null;
                        k1();
                        c.a();
                        if (c1()) {
                            return;
                        }
                        U0();
                        return;
                    }
                    c.a();
                    LockSupport.parkNanos(this, jR0);
                }
            }
        } finally {
            _thread = null;
            k1();
            c.a();
            if (!c1()) {
                U0();
            }
        }
    }

    @Override // kotlinx.coroutines.l1, kotlinx.coroutines.k1
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}

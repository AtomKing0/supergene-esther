package u9;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.u0;
import kotlinx.coroutines.x0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LimitedDispatcher.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class o extends kotlinx.coroutines.k0 implements x0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f34683f = AtomicIntegerFieldUpdater.newUpdater(o.class, "runningWorkers");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlinx.coroutines.k0 f34684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f34685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ x0 f34686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final t<Runnable> f34687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final Object f34688e;
    private volatile int runningWorkers;

    /* JADX INFO: compiled from: LimitedDispatcher.kt */
    private final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private Runnable f34689a;

        public a(@NotNull Runnable runnable) {
            this.f34689a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = 0;
            while (true) {
                try {
                    this.f34689a.run();
                } catch (Throwable th) {
                    kotlinx.coroutines.m0.a(z8.h.f37608a, th);
                }
                Runnable runnableK0 = o.this.K0();
                if (runnableK0 == null) {
                    return;
                }
                this.f34689a = runnableK0;
                i10++;
                if (i10 >= 16 && o.this.f34684a.isDispatchNeeded(o.this)) {
                    o.this.f34684a.dispatch(o.this, this);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(@NotNull kotlinx.coroutines.k0 k0Var, int i10) {
        this.f34684a = k0Var;
        this.f34685b = i10;
        x0 x0Var = k0Var instanceof x0 ? (x0) k0Var : null;
        this.f34686c = x0Var == null ? u0.a() : x0Var;
        this.f34687d = new t<>(false);
        this.f34688e = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable K0() {
        while (true) {
            Runnable runnableD = this.f34687d.d();
            if (runnableD != null) {
                return runnableD;
            }
            synchronized (this.f34688e) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f34683f;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f34687d.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    private final boolean L0() {
        synchronized (this.f34688e) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f34683f;
            if (atomicIntegerFieldUpdater.get(this) >= this.f34685b) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // kotlinx.coroutines.k0
    public void dispatch(@NotNull z8.g gVar, @NotNull Runnable runnable) {
        Runnable runnableK0;
        this.f34687d.a(runnable);
        if (f34683f.get(this) >= this.f34685b || !L0() || (runnableK0 = K0()) == null) {
            return;
        }
        this.f34684a.dispatch(this, new a(runnableK0));
    }

    @Override // kotlinx.coroutines.k0
    public void dispatchYield(@NotNull z8.g gVar, @NotNull Runnable runnable) {
        Runnable runnableK0;
        this.f34687d.a(runnable);
        if (f34683f.get(this) >= this.f34685b || !L0() || (runnableK0 = K0()) == null) {
            return;
        }
        this.f34684a.dispatchYield(this, new a(runnableK0));
    }

    @Override // kotlinx.coroutines.x0
    @NotNull
    public g1 invokeOnTimeout(long j10, @NotNull Runnable runnable, @NotNull z8.g gVar) {
        return this.f34686c.invokeOnTimeout(j10, runnable, gVar);
    }

    @Override // kotlinx.coroutines.k0
    @NotNull
    public kotlinx.coroutines.k0 limitedParallelism(int i10) {
        p.a(i10);
        return i10 >= this.f34685b ? this : super.limitedParallelism(i10);
    }

    @Override // kotlinx.coroutines.x0
    public void scheduleResumeAfterDelay(long j10, @NotNull kotlinx.coroutines.o<? super v8.k0> oVar) {
        this.f34686c.scheduleResumeAfterDelay(j10, oVar);
    }
}

package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Interruptible.kt */
/* JADX INFO: loaded from: classes5.dex */
final class c3 implements h9.l<Throwable, v8.k0> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f29867d = AtomicIntegerFieldUpdater.newUpdater(c3.class, "_state");
    private volatile int _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final b2 f29868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Thread f29869b = Thread.currentThread();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private g1 f29870c;

    public c3(@NotNull b2 b2Var) {
        this.f29868a = b2Var;
    }

    private final Void b(int i10) {
        throw new IllegalStateException(("Illegal state " + i10).toString());
    }

    public final void a() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f29867d;
        while (true) {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        b(i10);
                        throw new v8.h();
                    }
                }
            } else if (f29867d.compareAndSet(this, i10, 1)) {
                g1 g1Var = this.f29870c;
                if (g1Var != null) {
                    g1Var.dispose();
                    return;
                }
                return;
            }
        }
    }

    public void c(@Nullable Throwable th) {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = f29867d;
        do {
            i10 = atomicIntegerFieldUpdater2.get(this);
            if (i10 != 0) {
                if (i10 == 1 || i10 == 2 || i10 == 3) {
                    return;
                }
                b(i10);
                throw new v8.h();
            }
            atomicIntegerFieldUpdater = f29867d;
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 2));
        this.f29869b.interrupt();
        atomicIntegerFieldUpdater.set(this, 3);
    }

    public final void d() {
        int i10;
        this.f29870c = this.f29868a.h0(true, true, this);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f29867d;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 2 || i10 == 3) {
                    return;
                }
                b(i10);
                throw new v8.h();
            }
        } while (!f29867d.compareAndSet(this, i10, 0));
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(Throwable th) {
        c(th);
        return v8.k0.f35197a;
    }
}

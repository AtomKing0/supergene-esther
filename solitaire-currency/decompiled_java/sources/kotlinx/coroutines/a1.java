package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a1<T> extends u9.d0<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f29850e = AtomicIntegerFieldUpdater.newUpdater(a1.class, "_decision");
    private volatile int _decision;

    public a1(@NotNull z8.g gVar, @NotNull z8.d<? super T> dVar) {
        super(gVar, dVar);
    }

    private final boolean V0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f29850e;
        do {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f29850e.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean W0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f29850e;
        do {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f29850e.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // u9.d0, kotlinx.coroutines.j2
    protected void C(@Nullable Object obj) {
        Q0(obj);
    }

    @Override // u9.d0, kotlinx.coroutines.a
    protected void Q0(@Nullable Object obj) {
        if (V0()) {
            return;
        }
        u9.k.c(a9.c.c(this.f34650d), g0.a(obj, this.f34650d), null, 2, null);
    }

    @Nullable
    public final Object U0() {
        if (W0()) {
            return a9.d.e();
        }
        Object objH = k2.h(f0());
        if (objH instanceof c0) {
            throw ((c0) objH).f29865a;
        }
        return objH;
    }
}

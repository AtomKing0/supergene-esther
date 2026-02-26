package w9;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.n0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WorkQueue.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f35552b = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f35553c = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f35554d = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f35555e = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final AtomicReferenceArray<h> f35556a = new AtomicReferenceArray<>(128);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;

    @Nullable
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    private final h b(h hVar) {
        if (d() == 127) {
            return hVar;
        }
        if (hVar.f35540b.b() == 1) {
            f35555e.incrementAndGet(this);
        }
        int i10 = f35553c.get(this) & 127;
        while (this.f35556a.get(i10) != null) {
            Thread.yield();
        }
        this.f35556a.lazySet(i10, hVar);
        f35553c.incrementAndGet(this);
        return null;
    }

    private final void c(h hVar) {
        if (hVar != null) {
            if (hVar.f35540b.b() == 1) {
                f35555e.decrementAndGet(this);
            }
        }
    }

    private final int d() {
        return f35553c.get(this) - f35554d.get(this);
    }

    private final h i() {
        h andSet;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f35554d;
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 - f35553c.get(this) == 0) {
                return null;
            }
            int i11 = i10 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 + 1) && (andSet = this.f35556a.getAndSet(i11, null)) != null) {
                c(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(d dVar) {
        h hVarI = i();
        if (hVarI == null) {
            return false;
        }
        dVar.a(hVarI);
        return true;
    }

    private final h k(boolean z10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        h hVar;
        do {
            atomicReferenceFieldUpdater = f35552b;
            hVar = (h) atomicReferenceFieldUpdater.get(this);
            if (hVar != null) {
                if ((hVar.f35540b.b() == 1) == z10) {
                }
            }
            int i10 = f35554d.get(this);
            int i11 = f35553c.get(this);
            while (i10 != i11) {
                if (z10 && f35555e.get(this) == 0) {
                    return null;
                }
                i11--;
                h hVarM = m(i11, z10);
                if (hVarM != null) {
                    return hVarM;
                }
            }
            return null;
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, hVar, null));
        return hVar;
    }

    private final h l(int i10) {
        int i11 = f35554d.get(this);
        int i12 = f35553c.get(this);
        boolean z10 = i10 == 1;
        while (i11 != i12) {
            if (z10 && f35555e.get(this) == 0) {
                return null;
            }
            int i13 = i11 + 1;
            h hVarM = m(i11, z10);
            if (hVarM != null) {
                return hVarM;
            }
            i11 = i13;
        }
        return null;
    }

    private final h m(int i10, boolean z10) {
        int i11 = i10 & 127;
        h hVar = this.f35556a.get(i11);
        if (hVar != null) {
            if ((hVar.f35540b.b() == 1) == z10 && s8.c.a(this.f35556a, i11, hVar, null)) {
                if (z10) {
                    f35555e.decrementAndGet(this);
                }
                return hVar;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object, w9.h] */
    private final long o(int i10, n0<h> n0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ?? r12;
        do {
            atomicReferenceFieldUpdater = f35552b;
            r12 = (h) atomicReferenceFieldUpdater.get(this);
            if (r12 == 0) {
                return -2L;
            }
            if (((r12.f35540b.b() == 1 ? 1 : 2) & i10) == 0) {
                return -2L;
            }
            long jA = l.f35548f.a() - r12.f35539a;
            long j10 = l.f35544b;
            if (jA < j10) {
                return j10 - jA;
            }
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, r12, null));
        n0Var.f29834a = r12;
        return -1L;
    }

    @Nullable
    public final h a(@NotNull h hVar, boolean z10) {
        if (z10) {
            return b(hVar);
        }
        h hVar2 = (h) f35552b.getAndSet(this, hVar);
        if (hVar2 == null) {
            return null;
        }
        return b(hVar2);
    }

    public final int e() {
        return f35552b.get(this) != null ? d() + 1 : d();
    }

    public final void f(@NotNull d dVar) {
        h hVar = (h) f35552b.getAndSet(this, null);
        if (hVar != null) {
            dVar.a(hVar);
        }
        while (j(dVar)) {
        }
    }

    @Nullable
    public final h g() {
        h hVar = (h) f35552b.getAndSet(this, null);
        return hVar == null ? i() : hVar;
    }

    @Nullable
    public final h h() {
        return k(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long n(int i10, @NotNull n0<h> n0Var) {
        T tI = i10 == 3 ? i() : l(i10);
        if (tI == 0) {
            return o(i10, n0Var);
        }
        n0Var.f29834a = tI;
        return -1L;
    }
}

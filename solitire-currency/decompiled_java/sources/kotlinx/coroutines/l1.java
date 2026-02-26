package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.x0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class l1 extends m1 implements x0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f29946d = AtomicReferenceFieldUpdater.newUpdater(l1.class, Object.class, "_queue");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f29947e = AtomicReferenceFieldUpdater.newUpdater(l1.class, Object.class, "_delayed");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f29948f = AtomicIntegerFieldUpdater.newUpdater(l1.class, "_isCompleted");

    @Nullable
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;

    @Nullable
    private volatile Object _queue;

    /* JADX INFO: compiled from: EventLoop.common.kt */
    private final class a extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final o<v8.k0> f29949c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(long j10, @NotNull o<? super v8.k0> oVar) {
            super(j10);
            this.f29949c = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f29949c.o(l1.this, v8.k0.f35197a);
        }

        @Override // kotlinx.coroutines.l1.c
        @NotNull
        public String toString() {
            return super.toString() + this.f29949c;
        }
    }

    /* JADX INFO: compiled from: EventLoop.common.kt */
    private static final class b extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final Runnable f29951c;

        public b(long j10, @NotNull Runnable runnable) {
            super(j10);
            this.f29951c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f29951c.run();
        }

        @Override // kotlinx.coroutines.l1.c
        @NotNull
        public String toString() {
            return super.toString() + this.f29951c;
        }
    }

    /* JADX INFO: compiled from: EventLoop.common.kt */
    public static abstract class c implements Runnable, Comparable<c>, g1, u9.q0 {

        @Nullable
        private volatile Object _heap;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f29952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f29953b = -1;

        public c(long j10) {
            this.f29952a = j10;
        }

        @Override // u9.q0
        @Nullable
        public u9.p0<?> c() {
            Object obj = this._heap;
            if (obj instanceof u9.p0) {
                return (u9.p0) obj;
            }
            return null;
        }

        @Override // u9.q0
        public void d(@Nullable u9.p0<?> p0Var) {
            if (!(this._heap != o1.f29959a)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this._heap = p0Var;
        }

        @Override // kotlinx.coroutines.g1
        public final void dispose() {
            synchronized (this) {
                Object obj = this._heap;
                if (obj == o1.f29959a) {
                    return;
                }
                d dVar = obj instanceof d ? (d) obj : null;
                if (dVar != null) {
                    dVar.g(this);
                }
                this._heap = o1.f29959a;
                v8.k0 k0Var = v8.k0.f35197a;
            }
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NotNull c cVar) {
            long j10 = this.f29952a - cVar.f29952a;
            if (j10 > 0) {
                return 1;
            }
            return j10 < 0 ? -1 : 0;
        }

        public final int f(long j10, @NotNull d dVar, @NotNull l1 l1Var) {
            synchronized (this) {
                if (this._heap == o1.f29959a) {
                    return 2;
                }
                synchronized (dVar) {
                    c cVarB = dVar.b();
                    if (l1Var.i()) {
                        return 1;
                    }
                    if (cVarB == null) {
                        dVar.f29954c = j10;
                    } else {
                        long j11 = cVarB.f29952a;
                        if (j11 - j10 < 0) {
                            j10 = j11;
                        }
                        if (j10 - dVar.f29954c > 0) {
                            dVar.f29954c = j10;
                        }
                    }
                    long j12 = this.f29952a;
                    long j13 = dVar.f29954c;
                    if (j12 - j13 < 0) {
                        this.f29952a = j13;
                    }
                    dVar.a(this);
                    return 0;
                }
            }
        }

        public final boolean g(long j10) {
            return j10 - this.f29952a >= 0;
        }

        @Override // u9.q0
        public int getIndex() {
            return this.f29953b;
        }

        @Override // u9.q0
        public void setIndex(int i10) {
            this.f29953b = i10;
        }

        @NotNull
        public String toString() {
            return "Delayed[nanos=" + this.f29952a + ']';
        }
    }

    /* JADX INFO: compiled from: EventLoop.common.kt */
    public static final class d extends u9.p0<c> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f29954c;

        public d(long j10) {
            this.f29954c = j10;
        }
    }

    private final void Y0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29946d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (androidx.concurrent.futures.a.a(f29946d, this, null, o1.f29960b)) {
                    return;
                }
            } else if (obj instanceof u9.u) {
                ((u9.u) obj).d();
                return;
            } else {
                if (obj == o1.f29960b) {
                    return;
                }
                u9.u uVar = new u9.u(8, true);
                kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                uVar.a((Runnable) obj);
                if (androidx.concurrent.futures.a.a(f29946d, this, obj, uVar)) {
                    return;
                }
            }
        }
    }

    private final Runnable Z0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29946d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof u9.u) {
                kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                u9.u uVar = (u9.u) obj;
                Object objJ = uVar.j();
                if (objJ != u9.u.f34707h) {
                    return (Runnable) objJ;
                }
                androidx.concurrent.futures.a.a(f29946d, this, obj, uVar.i());
            } else {
                if (obj == o1.f29960b) {
                    return null;
                }
                if (androidx.concurrent.futures.a.a(f29946d, this, obj, null)) {
                    kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean b1(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29946d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (i()) {
                return false;
            }
            if (obj == null) {
                if (androidx.concurrent.futures.a.a(f29946d, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof u9.u) {
                kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                u9.u uVar = (u9.u) obj;
                int iA = uVar.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    androidx.concurrent.futures.a.a(f29946d, this, obj, uVar.i());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == o1.f29960b) {
                    return false;
                }
                u9.u uVar2 = new u9.u(8, true);
                kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                uVar2.a((Runnable) obj);
                uVar2.a(runnable);
                if (androidx.concurrent.futures.a.a(f29946d, this, obj, uVar2)) {
                    return true;
                }
            }
        }
    }

    private final void d1() {
        c cVarI;
        kotlinx.coroutines.c.a();
        long jNanoTime = System.nanoTime();
        while (true) {
            d dVar = (d) f29947e.get(this);
            if (dVar == null || (cVarI = dVar.i()) == null) {
                return;
            } else {
                V0(jNanoTime, cVarI);
            }
        }
    }

    private final int g1(long j10, c cVar) {
        if (i()) {
            return 1;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29947e;
        d dVar = (d) atomicReferenceFieldUpdater.get(this);
        if (dVar == null) {
            androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, null, new d(j10));
            Object obj = atomicReferenceFieldUpdater.get(this);
            kotlin.jvm.internal.t.f(obj);
            dVar = (d) obj;
        }
        return cVar.f(j10, dVar, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i() {
        return f29948f.get(this) != 0;
    }

    private final void i1(boolean z10) {
        f29948f.set(this, z10 ? 1 : 0);
    }

    private final boolean j1(c cVar) {
        d dVar = (d) f29947e.get(this);
        return (dVar != null ? dVar.e() : null) == cVar;
    }

    @Override // kotlinx.coroutines.k1
    protected long M0() {
        c cVarE;
        if (super.M0() == 0) {
            return 0L;
        }
        Object obj = f29946d.get(this);
        if (obj != null) {
            if (!(obj instanceof u9.u)) {
                return obj == o1.f29960b ? Long.MAX_VALUE : 0L;
            }
            if (!((u9.u) obj).g()) {
                return 0L;
            }
        }
        d dVar = (d) f29947e.get(this);
        if (dVar == null || (cVarE = dVar.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j10 = cVarE.f29952a;
        kotlinx.coroutines.c.a();
        return n9.o.f(j10 - System.nanoTime(), 0L);
    }

    @Override // kotlinx.coroutines.k1
    public long R0() {
        c cVarH;
        if (S0()) {
            return 0L;
        }
        d dVar = (d) f29947e.get(this);
        if (dVar != null && !dVar.d()) {
            kotlinx.coroutines.c.a();
            long jNanoTime = System.nanoTime();
            do {
                synchronized (dVar) {
                    c cVarB = dVar.b();
                    if (cVarB != null) {
                        c cVar = cVarB;
                        cVarH = cVar.g(jNanoTime) ? b1(cVar) : false ? dVar.h(0) : null;
                    }
                }
            } while (cVarH != null);
        }
        Runnable runnableZ0 = Z0();
        if (runnableZ0 == null) {
            return M0();
        }
        runnableZ0.run();
        return 0L;
    }

    public void a1(@NotNull Runnable runnable) {
        if (b1(runnable)) {
            W0();
        } else {
            t0.f29980g.a1(runnable);
        }
    }

    protected boolean c1() {
        if (!Q0()) {
            return false;
        }
        d dVar = (d) f29947e.get(this);
        if (dVar != null && !dVar.d()) {
            return false;
        }
        Object obj = f29946d.get(this);
        if (obj != null) {
            if (obj instanceof u9.u) {
                return ((u9.u) obj).g();
            }
            if (obj != o1.f29960b) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.coroutines.k0
    public final void dispatch(@NotNull z8.g gVar, @NotNull Runnable runnable) {
        a1(runnable);
    }

    protected final void e1() {
        f29946d.set(this, null);
        f29947e.set(this, null);
    }

    public final void f1(long j10, @NotNull c cVar) {
        int iG1 = g1(j10, cVar);
        if (iG1 == 0) {
            if (j1(cVar)) {
                W0();
            }
        } else if (iG1 == 1) {
            V0(j10, cVar);
        } else if (iG1 != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    @NotNull
    protected final g1 h1(long j10, @NotNull Runnable runnable) {
        long jC = o1.c(j10);
        if (jC >= 4611686018427387903L) {
            return q2.f29976a;
        }
        kotlinx.coroutines.c.a();
        long jNanoTime = System.nanoTime();
        b bVar = new b(jC + jNanoTime, runnable);
        f1(jNanoTime, bVar);
        return bVar;
    }

    @Override // kotlinx.coroutines.x0
    @NotNull
    public g1 invokeOnTimeout(long j10, @NotNull Runnable runnable, @NotNull z8.g gVar) {
        return x0.a.b(this, j10, runnable, gVar);
    }

    @Override // kotlinx.coroutines.x0
    public void scheduleResumeAfterDelay(long j10, @NotNull o<? super v8.k0> oVar) {
        long jC = o1.c(j10);
        if (jC < 4611686018427387903L) {
            kotlinx.coroutines.c.a();
            long jNanoTime = System.nanoTime();
            a aVar = new a(jC + jNanoTime, oVar);
            f1(jNanoTime, aVar);
            r.a(oVar, aVar);
        }
    }

    @Override // kotlinx.coroutines.k1
    public void shutdown() {
        b3.f29862a.c();
        i1(true);
        Y0();
        while (R0() <= 0) {
        }
        d1();
    }
}

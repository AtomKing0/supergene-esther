package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
public class p<T> extends b1<T> implements o<T>, kotlin.coroutines.jvm.internal.e, j3 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f29961f = AtomicIntegerFieldUpdater.newUpdater(p.class, "_decisionAndIndex");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f29962g = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_state");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f29963h = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_parentHandle");
    private volatile int _decisionAndIndex;

    @Nullable
    private volatile Object _parentHandle;

    @Nullable
    private volatile Object _state;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final z8.d<T> f29964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final z8.g f29965e;

    /* JADX WARN: Multi-variable type inference failed */
    public p(@NotNull z8.d<? super T> dVar, int i10) {
        super(i10);
        this.f29964d = dVar;
        this.f29965e = dVar.getContext();
        this._decisionAndIndex = 536870911;
        this._state = d.f29871a;
    }

    private final String B() {
        Object objA = A();
        return objA instanceof r2 ? "Active" : objA instanceof s ? "Cancelled" : "Completed";
    }

    private final g1 D() {
        b2 b2Var = (b2) getContext().get(b2.O7);
        if (b2Var == null) {
            return null;
        }
        g1 g1VarD = b2.a.d(b2Var, true, false, new t(this), 2, null);
        androidx.concurrent.futures.a.a(f29963h, this, null, g1VarD);
        return g1VarD;
    }

    private final void E(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29962g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof d)) {
                if (obj2 instanceof m ? true : obj2 instanceof u9.e0) {
                    H(obj, obj2);
                } else {
                    boolean z10 = obj2 instanceof c0;
                    if (z10) {
                        c0 c0Var = (c0) obj2;
                        if (!c0Var.b()) {
                            H(obj, obj2);
                        }
                        if (obj2 instanceof s) {
                            if (!z10) {
                                c0Var = null;
                            }
                            Throwable th = c0Var != null ? c0Var.f29865a : null;
                            if (obj instanceof m) {
                                p((m) obj, th);
                                return;
                            } else {
                                kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                                r((u9.e0) obj, th);
                                return;
                            }
                        }
                        return;
                    }
                    if (obj2 instanceof b0) {
                        b0 b0Var = (b0) obj2;
                        if (b0Var.f29856b != null) {
                            H(obj, obj2);
                        }
                        if (obj instanceof u9.e0) {
                            return;
                        }
                        kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        m mVar = (m) obj;
                        if (b0Var.c()) {
                            p(mVar, b0Var.f29859e);
                            return;
                        } else {
                            if (androidx.concurrent.futures.a.a(f29962g, this, obj2, b0.b(b0Var, null, mVar, null, null, null, 29, null))) {
                                return;
                            }
                        }
                    } else {
                        if (obj instanceof u9.e0) {
                            return;
                        }
                        kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        if (androidx.concurrent.futures.a.a(f29962g, this, obj2, new b0(obj2, (m) obj, null, null, null, 28, null))) {
                            return;
                        }
                    }
                }
            } else if (androidx.concurrent.futures.a.a(f29962g, this, obj2, obj)) {
                return;
            }
        }
    }

    private final boolean F() {
        if (c1.c(this.f29860c)) {
            z8.d<T> dVar = this.f29964d;
            kotlin.jvm.internal.t.g(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (((u9.j) dVar).s()) {
                return true;
            }
        }
        return false;
    }

    private final m G(h9.l<? super Throwable, v8.k0> lVar) {
        return lVar instanceof m ? (m) lVar : new y1(lVar);
    }

    private final void H(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    private final void M(Object obj, int i10, h9.l<? super Throwable, v8.k0> lVar) {
        Object obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29962g;
        do {
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof r2)) {
                if (obj2 instanceof s) {
                    s sVar = (s) obj2;
                    if (sVar.c()) {
                        if (lVar != null) {
                            q(lVar, sVar.f29865a);
                            return;
                        }
                        return;
                    }
                }
                n(obj);
                throw new v8.h();
            }
        } while (!androidx.concurrent.futures.a.a(f29962g, this, obj2, O((r2) obj2, obj, i10, lVar, null)));
        v();
        w(i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void N(p pVar, Object obj, int i10, h9.l lVar, int i11, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        pVar.M(obj, i10, lVar);
    }

    private final Object O(r2 r2Var, Object obj, int i10, h9.l<? super Throwable, v8.k0> lVar, Object obj2) {
        if (obj instanceof c0) {
            return obj;
        }
        if (!c1.b(i10) && obj2 == null) {
            return obj;
        }
        if (lVar == null && !(r2Var instanceof m) && obj2 == null) {
            return obj;
        }
        return new b0(obj, r2Var instanceof m ? (m) r2Var : null, lVar, obj2, null, 16, null);
    }

    private final boolean P() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f29961f;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f29961f.compareAndSet(this, i10, 1073741824 + (536870911 & i10)));
        return true;
    }

    private final u9.h0 Q(Object obj, Object obj2, h9.l<? super Throwable, v8.k0> lVar) {
        Object obj3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29962g;
        do {
            obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof r2)) {
                if ((obj3 instanceof b0) && obj2 != null && ((b0) obj3).f29858d == obj2) {
                    return q.f29967a;
                }
                return null;
            }
        } while (!androidx.concurrent.futures.a.a(f29962g, this, obj3, O((r2) obj3, obj, this.f29860c, lVar, obj2)));
        v();
        return q.f29967a;
    }

    private final boolean R() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f29961f;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f29961f.compareAndSet(this, i10, 536870912 + (536870911 & i10)));
        return true;
    }

    private final Void n(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void r(u9.e0<?> e0Var, Throwable th) {
        int i10 = f29961f.get(this) & 536870911;
        if (!(i10 != 536870911)) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
        }
        try {
            e0Var.o(i10, th, getContext());
        } catch (Throwable th2) {
            m0.a(getContext(), new f0("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    private final boolean s(Throwable th) {
        if (!F()) {
            return false;
        }
        z8.d<T> dVar = this.f29964d;
        kotlin.jvm.internal.t.g(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((u9.j) dVar).t(th);
    }

    private final void v() {
        if (F()) {
            return;
        }
        t();
    }

    private final void w(int i10) {
        if (P()) {
            return;
        }
        c1.a(this, i10);
    }

    private final g1 y() {
        return (g1) f29963h.get(this);
    }

    @Nullable
    public final Object A() {
        return f29962g.get(this);
    }

    public void C() {
        g1 g1VarD = D();
        if (g1VarD != null && i()) {
            g1VarD.dispose();
            f29963h.set(this, q2.f29976a);
        }
    }

    @NotNull
    protected String I() {
        return "CancellableContinuation";
    }

    public final void J(@NotNull Throwable th) {
        if (s(th)) {
            return;
        }
        b(th);
        v();
    }

    public final void K() {
        Throwable thW;
        z8.d<T> dVar = this.f29964d;
        u9.j jVar = dVar instanceof u9.j ? (u9.j) dVar : null;
        if (jVar == null || (thW = jVar.w(this)) == null) {
            return;
        }
        t();
        b(thW);
    }

    public final boolean L() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29962g;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if ((obj instanceof b0) && ((b0) obj).f29858d != null) {
            t();
            return false;
        }
        f29961f.set(this, 536870911);
        atomicReferenceFieldUpdater.set(this, d.f29871a);
        return true;
    }

    @Override // kotlinx.coroutines.j3
    public void a(@NotNull u9.e0<?> e0Var, int i10) {
        int i11;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f29961f;
        do {
            i11 = atomicIntegerFieldUpdater.get(this);
            if (!((i11 & 536870911) == 536870911)) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i11, ((i11 >> 29) << 29) + i10));
        E(e0Var);
    }

    @Override // kotlinx.coroutines.o
    public boolean b(@Nullable Throwable th) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29962g;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof r2)) {
                return false;
            }
        } while (!androidx.concurrent.futures.a.a(f29962g, this, obj, new s(this, th, (obj instanceof m) || (obj instanceof u9.e0))));
        r2 r2Var = (r2) obj;
        if (r2Var instanceof m) {
            p((m) obj, th);
        } else if (r2Var instanceof u9.e0) {
            r((u9.e0) obj, th);
        }
        v();
        w(this.f29860c);
        return true;
    }

    @Override // kotlinx.coroutines.b1
    public void c(@Nullable Object obj, @NotNull Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29962g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof r2) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof c0) {
                return;
            }
            if (obj2 instanceof b0) {
                b0 b0Var = (b0) obj2;
                if (!(!b0Var.c())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (androidx.concurrent.futures.a.a(f29962g, this, obj2, b0.b(b0Var, null, null, null, null, th, 15, null))) {
                    b0Var.d(this, th);
                    return;
                }
            } else if (androidx.concurrent.futures.a.a(f29962g, this, obj2, new b0(obj2, null, null, null, th, 14, null))) {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.b1
    @NotNull
    public final z8.d<T> d() {
        return this.f29964d;
    }

    @Override // kotlinx.coroutines.b1
    @Nullable
    public Throwable e(@Nullable Object obj) {
        Throwable thE = super.e(obj);
        if (thE != null) {
            return thE;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.b1
    public <T> T f(@Nullable Object obj) {
        return obj instanceof b0 ? (T) ((b0) obj).f29855a : obj;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @Nullable
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        z8.d<T> dVar = this.f29964d;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // z8.d
    @NotNull
    public z8.g getContext() {
        return this.f29965e;
    }

    @Override // kotlinx.coroutines.b1
    @Nullable
    public Object h() {
        return A();
    }

    @Override // kotlinx.coroutines.o
    public boolean i() {
        return !(A() instanceof r2);
    }

    @Override // kotlinx.coroutines.o
    public boolean isActive() {
        return A() instanceof r2;
    }

    @Override // kotlinx.coroutines.o
    @Nullable
    public Object j(@NotNull Throwable th) {
        return Q(new c0(th, false, 2, null), null, null);
    }

    @Override // kotlinx.coroutines.o
    @Nullable
    public Object k(T t10, @Nullable Object obj, @Nullable h9.l<? super Throwable, v8.k0> lVar) {
        return Q(t10, obj, lVar);
    }

    @Override // kotlinx.coroutines.o
    public void l(T t10, @Nullable h9.l<? super Throwable, v8.k0> lVar) {
        M(t10, this.f29860c, lVar);
    }

    @Override // kotlinx.coroutines.o
    public void m(@NotNull h9.l<? super Throwable, v8.k0> lVar) {
        E(G(lVar));
    }

    @Override // kotlinx.coroutines.o
    public void o(@NotNull k0 k0Var, T t10) {
        z8.d<T> dVar = this.f29964d;
        u9.j jVar = dVar instanceof u9.j ? (u9.j) dVar : null;
        N(this, t10, (jVar != null ? jVar.f34663d : null) == k0Var ? 4 : this.f29860c, null, 4, null);
    }

    public final void p(@NotNull m mVar, @Nullable Throwable th) {
        try {
            mVar.d(th);
        } catch (Throwable th2) {
            m0.a(getContext(), new f0("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void q(@NotNull h9.l<? super Throwable, v8.k0> lVar, @NotNull Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            m0.a(getContext(), new f0("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    @Override // z8.d
    public void resumeWith(@NotNull Object obj) {
        N(this, g0.c(obj, this), this.f29860c, null, 4, null);
    }

    public final void t() {
        g1 g1VarY = y();
        if (g1VarY == null) {
            return;
        }
        g1VarY.dispose();
        f29963h.set(this, q2.f29976a);
    }

    @NotNull
    public String toString() {
        return I() + '(' + s0.c(this.f29964d) + "){" + B() + "}@" + s0.b(this);
    }

    @Override // kotlinx.coroutines.o
    public void u(@NotNull Object obj) {
        w(this.f29860c);
    }

    @NotNull
    public Throwable x(@NotNull b2 b2Var) {
        return b2Var.x();
    }

    @Nullable
    public final Object z() throws Throwable {
        b2 b2Var;
        boolean zF = F();
        if (R()) {
            if (y() == null) {
                D();
            }
            if (zF) {
                K();
            }
            return a9.d.e();
        }
        if (zF) {
            K();
        }
        Object objA = A();
        if (objA instanceof c0) {
            throw ((c0) objA).f29865a;
        }
        if (!c1.b(this.f29860c) || (b2Var = (b2) getContext().get(b2.O7)) == null || b2Var.isActive()) {
            return f(objA);
        }
        CancellationException cancellationExceptionX = b2Var.x();
        c(objA, cancellationExceptionX);
        throw cancellationExceptionX;
    }
}

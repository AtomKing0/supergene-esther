package u9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.b3;
import kotlinx.coroutines.k1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DispatchedContinuation.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class j<T> extends b1<T> implements kotlin.coroutines.jvm.internal.e, z8.d<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f34662h = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_reusableCancellableContinuation");

    @Nullable
    private volatile Object _reusableCancellableContinuation;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final kotlinx.coroutines.k0 f34663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final z8.d<T> f34664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public Object f34665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final Object f34666g;

    /* JADX WARN: Multi-variable type inference failed */
    public j(@NotNull kotlinx.coroutines.k0 k0Var, @NotNull z8.d<? super T> dVar) {
        super(-1);
        this.f34663d = k0Var;
        this.f34664e = dVar;
        this.f34665f = k.f34668a;
        this.f34666g = l0.b(getContext());
    }

    private final kotlinx.coroutines.p<?> r() {
        Object obj = f34662h.get(this);
        if (obj instanceof kotlinx.coroutines.p) {
            return (kotlinx.coroutines.p) obj;
        }
        return null;
    }

    @Override // kotlinx.coroutines.b1
    public void c(@Nullable Object obj, @NotNull Throwable th) {
        if (obj instanceof kotlinx.coroutines.d0) {
            ((kotlinx.coroutines.d0) obj).f29873b.invoke(th);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @Nullable
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        z8.d<T> dVar = this.f34664e;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // z8.d
    @NotNull
    public z8.g getContext() {
        return this.f34664e.getContext();
    }

    @Override // kotlinx.coroutines.b1
    @Nullable
    public Object h() {
        Object obj = this.f34665f;
        this.f34665f = k.f34668a;
        return obj;
    }

    public final void n() {
        while (f34662h.get(this) == k.f34669b) {
        }
    }

    @Nullable
    public final kotlinx.coroutines.p<T> p() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34662h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                f34662h.set(this, k.f34669b);
                return null;
            }
            if (obj instanceof kotlinx.coroutines.p) {
                if (androidx.concurrent.futures.a.a(f34662h, this, obj, k.f34669b)) {
                    return (kotlinx.coroutines.p) obj;
                }
            } else if (obj != k.f34669b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void q(@NotNull z8.g gVar, T t10) {
        this.f34665f = t10;
        this.f29860c = 1;
        this.f34663d.dispatchYield(gVar, this);
    }

    @Override // z8.d
    public void resumeWith(@NotNull Object obj) {
        z8.g context = this.f34664e.getContext();
        Object objD = kotlinx.coroutines.g0.d(obj, null, 1, null);
        if (this.f34663d.isDispatchNeeded(context)) {
            this.f34665f = objD;
            this.f29860c = 0;
            this.f34663d.dispatch(context, this);
            return;
        }
        k1 k1VarB = b3.f29862a.b();
        if (k1VarB.P0()) {
            this.f34665f = objD;
            this.f29860c = 0;
            k1VarB.L0(this);
            return;
        }
        k1VarB.N0(true);
        try {
            z8.g context2 = getContext();
            Object objC = l0.c(context2, this.f34666g);
            try {
                this.f34664e.resumeWith(obj);
                v8.k0 k0Var = v8.k0.f35197a;
                while (k1VarB.S0()) {
                }
            } finally {
                l0.a(context2, objC);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final boolean s() {
        return f34662h.get(this) != null;
    }

    public final boolean t(@NotNull Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34662h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            h0 h0Var = k.f34669b;
            if (kotlin.jvm.internal.t.d(obj, h0Var)) {
                if (androidx.concurrent.futures.a.a(f34662h, this, h0Var, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (androidx.concurrent.futures.a.a(f34662h, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    @NotNull
    public String toString() {
        return "DispatchedContinuation[" + this.f34663d + ", " + kotlinx.coroutines.s0.c(this.f34664e) + ']';
    }

    public final void v() {
        n();
        kotlinx.coroutines.p<?> pVarR = r();
        if (pVarR != null) {
            pVarR.t();
        }
    }

    @Nullable
    public final Throwable w(@NotNull kotlinx.coroutines.o<?> oVar) {
        h0 h0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34662h;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            h0Var = k.f34669b;
            if (obj != h0Var) {
                if (obj instanceof Throwable) {
                    if (androidx.concurrent.futures.a.a(f34662h, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!androidx.concurrent.futures.a.a(f34662h, this, h0Var, oVar));
        return null;
    }

    @Override // kotlinx.coroutines.b1
    @NotNull
    public z8.d<T> d() {
        return this;
    }
}

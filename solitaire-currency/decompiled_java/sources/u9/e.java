package u9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u9.e;

/* JADX INFO: compiled from: ConcurrentLinkedList.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class e<N extends e<N>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f34651a = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f34652b = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_prev");

    @Nullable
    private volatile Object _next;

    @Nullable
    private volatile Object _prev;

    public e(@Nullable N n10) {
        this._prev = n10;
    }

    private final N c() {
        N n10 = (N) g();
        while (n10 != null && n10.h()) {
            n10 = (N) f34652b.get(n10);
        }
        return n10;
    }

    private final N d() {
        e eVarE;
        N n10 = (N) e();
        kotlin.jvm.internal.t.f(n10);
        while (n10.h() && (eVarE = n10.e()) != null) {
            n10 = (N) eVarE;
        }
        return n10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f() {
        return f34651a.get(this);
    }

    public final void b() {
        f34652b.lazySet(this, null);
    }

    @Nullable
    public final N e() {
        Object objF = f();
        if (objF == d.f34649a) {
            return null;
        }
        return (N) objF;
    }

    @Nullable
    public final N g() {
        return (N) f34652b.get(this);
    }

    public abstract boolean h();

    public final boolean i() {
        return e() == null;
    }

    public final boolean j() {
        return androidx.concurrent.futures.a.a(f34651a, this, null, d.f34649a);
    }

    public final void k() {
        Object obj;
        if (i()) {
            return;
        }
        while (true) {
            e eVarC = c();
            e eVarD = d();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34652b;
            do {
                obj = atomicReferenceFieldUpdater.get(eVarD);
            } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, eVarD, obj, ((e) obj) == null ? null : eVarC));
            if (eVarC != null) {
                f34651a.set(eVarC, eVarD);
            }
            if (!eVarD.h() || eVarD.i()) {
                if (eVarC == null || !eVarC.h()) {
                    return;
                }
            }
        }
    }

    public final boolean l(@NotNull N n10) {
        return androidx.concurrent.futures.a.a(f34651a, this, null, n10);
    }
}

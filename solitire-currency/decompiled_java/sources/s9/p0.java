package s9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: compiled from: StateFlow.kt */
/* JADX INFO: loaded from: classes5.dex */
final class p0 extends t9.d<n0<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f33771a = AtomicReferenceFieldUpdater.newUpdater(p0.class, Object.class, "_state");

    @Nullable
    private volatile Object _state;

    @Override // t9.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull n0<?> n0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f33771a;
        if (atomicReferenceFieldUpdater.get(this) != null) {
            return false;
        }
        atomicReferenceFieldUpdater.set(this, o0.f33751a);
        return true;
    }

    @Nullable
    public final Object e(@NotNull z8.d<? super v8.k0> dVar) throws Throwable {
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(a9.c.c(dVar), 1);
        pVar.C();
        if (!androidx.concurrent.futures.a.a(f33771a, this, o0.f33751a, pVar)) {
            t.a aVar = v8.t.f35208b;
            pVar.resumeWith(v8.t.b(v8.k0.f35197a));
        }
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ == a9.d.e() ? objZ : v8.k0.f35197a;
    }

    @Override // t9.d
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public z8.d<v8.k0>[] b(@NotNull n0<?> n0Var) {
        f33771a.set(this, null);
        return t9.c.f34112a;
    }

    public final void g() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f33771a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null || obj == o0.f33752b) {
                return;
            }
            if (obj == o0.f33751a) {
                if (androidx.concurrent.futures.a.a(f33771a, this, obj, o0.f33752b)) {
                    return;
                }
            } else if (androidx.concurrent.futures.a.a(f33771a, this, obj, o0.f33751a)) {
                t.a aVar = v8.t.f35208b;
                ((kotlinx.coroutines.p) obj).resumeWith(v8.t.b(v8.k0.f35197a));
                return;
            }
        }
    }

    public final boolean h() {
        Object andSet = f33771a.getAndSet(this, o0.f33751a);
        kotlin.jvm.internal.t.f(andSet);
        return andSet == o0.f33752b;
    }
}

package u9;

import kotlinx.coroutines.z2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: ThreadContext.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class m0<T> implements z2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f34679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final ThreadLocal<T> f34680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final g.c<?> f34681c;

    public m0(T t10, @NotNull ThreadLocal<T> threadLocal) {
        this.f34679a = t10;
        this.f34680b = threadLocal;
        this.f34681c = new n0(threadLocal);
    }

    @Override // z8.g.b, z8.g
    public <R> R fold(R r10, @NotNull h9.p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) z2.a.a(this, r10, pVar);
    }

    @Override // z8.g.b, z8.g
    @Nullable
    public <E extends g.b> E get(@NotNull g.c<E> cVar) {
        if (!kotlin.jvm.internal.t.d(getKey(), cVar)) {
            return null;
        }
        kotlin.jvm.internal.t.g(this, "null cannot be cast to non-null type E of kotlinx.coroutines.internal.ThreadLocalElement.get");
        return this;
    }

    @Override // z8.g.b
    @NotNull
    public g.c<?> getKey() {
        return this.f34681c;
    }

    @Override // z8.g.b, z8.g
    @NotNull
    public z8.g minusKey(@NotNull g.c<?> cVar) {
        return kotlin.jvm.internal.t.d(getKey(), cVar) ? z8.h.f37608a : this;
    }

    @Override // z8.g
    @NotNull
    public z8.g plus(@NotNull z8.g gVar) {
        return z2.a.b(this, gVar);
    }

    @Override // kotlinx.coroutines.z2
    public void restoreThreadContext(@NotNull z8.g gVar, T t10) {
        this.f34680b.set(t10);
    }

    @NotNull
    public String toString() {
        return "ThreadLocal(value=" + this.f34679a + ", threadLocal = " + this.f34680b + ')';
    }

    @Override // kotlinx.coroutines.z2
    public T updateThreadContext(@NotNull z8.g gVar) {
        T t10 = this.f34680b.get();
        this.f34680b.set(this.f34679a);
        return t10;
    }
}

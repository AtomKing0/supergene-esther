package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.e;
import z8.g;

/* JADX INFO: compiled from: CoroutineDispatcher.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class k0 extends z8.a implements z8.e {

    @NotNull
    public static final a Key = new a(null);

    /* JADX INFO: compiled from: CoroutineDispatcher.kt */
    public static final class a extends z8.b<z8.e, k0> {

        /* JADX INFO: renamed from: kotlinx.coroutines.k0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CoroutineDispatcher.kt */
        static final class C0605a extends kotlin.jvm.internal.v implements h9.l<g.b, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0605a f29931g = new C0605a();

            C0605a() {
                super(1);
            }

            @Override // h9.l
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final k0 invoke(@NotNull g.b bVar) {
                if (bVar instanceof k0) {
                    return (k0) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        private a() {
            super(z8.e.R7, C0605a.f29931g);
        }
    }

    public k0() {
        super(z8.e.R7);
    }

    public abstract void dispatch(@NotNull z8.g gVar, @NotNull Runnable runnable);

    public void dispatchYield(@NotNull z8.g gVar, @NotNull Runnable runnable) {
        dispatch(gVar, runnable);
    }

    @Override // z8.a, z8.g.b, z8.g
    @Nullable
    public <E extends g.b> E get(@NotNull g.c<E> cVar) {
        return (E) e.a.a(this, cVar);
    }

    @Override // z8.e
    @NotNull
    public final <T> z8.d<T> interceptContinuation(@NotNull z8.d<? super T> dVar) {
        return new u9.j(this, dVar);
    }

    public boolean isDispatchNeeded(@NotNull z8.g gVar) {
        return true;
    }

    @NotNull
    public k0 limitedParallelism(int i10) {
        u9.p.a(i10);
        return new u9.o(this, i10);
    }

    @Override // z8.a, z8.g.b, z8.g
    @NotNull
    public z8.g minusKey(@NotNull g.c<?> cVar) {
        return e.a.b(this, cVar);
    }

    @Override // z8.e
    public final void releaseInterceptedContinuation(@NotNull z8.d<?> dVar) {
        kotlin.jvm.internal.t.g(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((u9.j) dVar).v();
    }

    @NotNull
    public String toString() {
        return s0.a(this) + '@' + s0.b(this);
    }

    @NotNull
    public final k0 plus(@NotNull k0 k0Var) {
        return k0Var;
    }
}

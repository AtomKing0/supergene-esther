package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface l0 extends g.b {

    @NotNull
    public static final b N7 = b.f29945a;

    /* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
    public static final class a {
        public static <R> R a(@NotNull l0 l0Var, R r10, @NotNull h9.p<? super R, ? super g.b, ? extends R> pVar) {
            return (R) g.b.a.a(l0Var, r10, pVar);
        }

        @Nullable
        public static <E extends g.b> E b(@NotNull l0 l0Var, @NotNull g.c<E> cVar) {
            return (E) g.b.a.b(l0Var, cVar);
        }

        @NotNull
        public static z8.g c(@NotNull l0 l0Var, @NotNull g.c<?> cVar) {
            return g.b.a.c(l0Var, cVar);
        }

        @NotNull
        public static z8.g d(@NotNull l0 l0Var, @NotNull z8.g gVar) {
            return g.b.a.d(l0Var, gVar);
        }
    }

    /* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
    public static final class b implements g.c<l0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f29945a = new b();

        private b() {
        }
    }

    void handleException(@NotNull z8.g gVar, @NotNull Throwable th);
}

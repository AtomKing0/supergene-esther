package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class f2 {
    @NotNull
    public static final a0 a(@Nullable b2 b2Var) {
        return h2.a(b2Var);
    }

    public static final void c(@NotNull b2 b2Var, @NotNull String str, @Nullable Throwable th) {
        h2.c(b2Var, str, th);
    }

    public static final void d(@NotNull z8.g gVar, @Nullable CancellationException cancellationException) {
        h2.d(gVar, cancellationException);
    }

    @Nullable
    public static final Object g(@NotNull b2 b2Var, @NotNull z8.d<? super v8.k0> dVar) {
        return h2.g(b2Var, dVar);
    }

    public static final void h(@NotNull o<?> oVar, @NotNull Future<?> future) {
        g2.a(oVar, future);
    }

    @NotNull
    public static final g1 i(@NotNull b2 b2Var, @NotNull g1 g1Var) {
        return h2.h(b2Var, g1Var);
    }

    public static final void j(@NotNull b2 b2Var) {
        h2.i(b2Var);
    }

    public static final void k(@NotNull z8.g gVar) {
        h2.j(gVar);
    }

    @NotNull
    public static final b2 l(@NotNull z8.g gVar) {
        return h2.k(gVar);
    }

    public static final boolean m(@NotNull z8.g gVar) {
        return h2.l(gVar);
    }
}

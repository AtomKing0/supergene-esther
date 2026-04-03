package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CoroutineScope.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class p0 {
    @NotNull
    public static final o0 a(@NotNull z8.g gVar) {
        if (gVar.get(b2.O7) == null) {
            gVar = gVar.plus(h2.b(null, 1, null));
        }
        return new u9.f(gVar);
    }

    @NotNull
    public static final o0 b() {
        return new u9.f(y2.b(null, 1, null).plus(e1.c()));
    }

    public static final void c(@NotNull o0 o0Var, @NotNull String str, @Nullable Throwable th) {
        d(o0Var, p1.a(str, th));
    }

    public static final void d(@NotNull o0 o0Var, @Nullable CancellationException cancellationException) {
        b2 b2Var = (b2) o0Var.getCoroutineContext().get(b2.O7);
        if (b2Var != null) {
            b2Var.cancel(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + o0Var).toString());
    }

    public static /* synthetic */ void e(o0 o0Var, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        d(o0Var, cancellationException);
    }

    @Nullable
    public static final <R> Object f(@NotNull h9.p<? super o0, ? super z8.d<? super R>, ? extends Object> pVar, @NotNull z8.d<? super R> dVar) {
        u9.d0 d0Var = new u9.d0(dVar.getContext(), dVar);
        Object objB = v9.b.b(d0Var, d0Var, pVar);
        if (objB == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objB;
    }

    public static final void g(@NotNull o0 o0Var) {
        f2.k(o0Var.getCoroutineContext());
    }

    public static final boolean h(@NotNull o0 o0Var) {
        b2 b2Var = (b2) o0Var.getCoroutineContext().get(b2.O7);
        if (b2Var != null) {
            return b2Var.isActive();
        }
        return true;
    }

    @NotNull
    public static final o0 i(@NotNull o0 o0Var, @NotNull z8.g gVar) {
        return new u9.f(o0Var.getCoroutineContext().plus(gVar));
    }
}

package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Job.kt */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class h2 {
    @NotNull
    public static final a0 a(@Nullable b2 b2Var) {
        return new e2(b2Var);
    }

    public static /* synthetic */ a0 b(b2 b2Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            b2Var = null;
        }
        return f2.a(b2Var);
    }

    public static final void c(@NotNull b2 b2Var, @NotNull String str, @Nullable Throwable th) {
        b2Var.cancel(p1.a(str, th));
    }

    public static final void d(@NotNull z8.g gVar, @Nullable CancellationException cancellationException) {
        b2 b2Var = (b2) gVar.get(b2.O7);
        if (b2Var != null) {
            b2Var.cancel(cancellationException);
        }
    }

    public static /* synthetic */ void e(b2 b2Var, String str, Throwable th, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            th = null;
        }
        f2.c(b2Var, str, th);
    }

    public static /* synthetic */ void f(z8.g gVar, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        f2.d(gVar, cancellationException);
    }

    @Nullable
    public static final Object g(@NotNull b2 b2Var, @NotNull z8.d<? super v8.k0> dVar) {
        b2.a.a(b2Var, null, 1, null);
        Object objZ = b2Var.z(dVar);
        return objZ == a9.d.e() ? objZ : v8.k0.f35197a;
    }

    @NotNull
    public static final g1 h(@NotNull b2 b2Var, @NotNull g1 g1Var) {
        return b2Var.J(new i1(g1Var));
    }

    public static final void i(@NotNull b2 b2Var) {
        if (!b2Var.isActive()) {
            throw b2Var.x();
        }
    }

    public static final void j(@NotNull z8.g gVar) {
        b2 b2Var = (b2) gVar.get(b2.O7);
        if (b2Var != null) {
            f2.j(b2Var);
        }
    }

    @NotNull
    public static final b2 k(@NotNull z8.g gVar) {
        b2 b2Var = (b2) gVar.get(b2.O7);
        if (b2Var != null) {
            return b2Var;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + gVar).toString());
    }

    public static final boolean l(@NotNull z8.g gVar) {
        b2 b2Var = (b2) gVar.get(b2.O7);
        if (b2Var != null) {
            return b2Var.isActive();
        }
        return true;
    }
}

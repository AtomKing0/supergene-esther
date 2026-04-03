package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import v8.t;

/* JADX INFO: compiled from: DispatchedTask.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c1 {
    public static final <T> void a(@NotNull b1<? super T> b1Var, int i10) {
        z8.d<? super T> dVarD = b1Var.d();
        boolean z10 = i10 == 4;
        if (z10 || !(dVarD instanceof u9.j) || b(i10) != b(b1Var.f29860c)) {
            d(b1Var, dVarD, z10);
            return;
        }
        k0 k0Var = ((u9.j) dVarD).f34663d;
        z8.g context = dVarD.getContext();
        if (k0Var.isDispatchNeeded(context)) {
            k0Var.dispatch(context, b1Var);
        } else {
            e(b1Var);
        }
    }

    public static final boolean b(int i10) {
        return i10 == 1 || i10 == 2;
    }

    public static final boolean c(int i10) {
        return i10 == 2;
    }

    public static final <T> void d(@NotNull b1<? super T> b1Var, @NotNull z8.d<? super T> dVar, boolean z10) {
        Object objF;
        Object objH = b1Var.h();
        Throwable thE = b1Var.e(objH);
        if (thE != null) {
            t.a aVar = v8.t.f35208b;
            objF = v8.u.a(thE);
        } else {
            t.a aVar2 = v8.t.f35208b;
            objF = b1Var.f(objH);
        }
        Object objB = v8.t.b(objF);
        if (!z10) {
            dVar.resumeWith(objB);
            return;
        }
        kotlin.jvm.internal.t.g(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        u9.j jVar = (u9.j) dVar;
        z8.d<T> dVar2 = jVar.f34664e;
        Object obj = jVar.f34666g;
        z8.g context = dVar2.getContext();
        Object objC = u9.l0.c(context, obj);
        h3<?> h3VarG = objC != u9.l0.f34671a ? j0.g(dVar2, context, objC) : null;
        try {
            jVar.f34664e.resumeWith(objB);
            v8.k0 k0Var = v8.k0.f35197a;
        } finally {
            if (h3VarG == null || h3VarG.U0()) {
                u9.l0.a(context, objC);
            }
        }
    }

    private static final void e(b1<?> b1Var) {
        k1 k1VarB = b3.f29862a.b();
        if (k1VarB.P0()) {
            k1VarB.L0(b1Var);
            return;
        }
        k1VarB.N0(true);
        try {
            d(b1Var, b1Var.d(), true);
            do {
            } while (k1VarB.S0());
        } finally {
            try {
            } finally {
            }
        }
    }
}

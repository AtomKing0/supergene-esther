package u9;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.b3;
import kotlinx.coroutines.h3;
import kotlinx.coroutines.k1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: compiled from: DispatchedContinuation.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final h0 f34668a = new h0("UNDEFINED");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final h0 f34669b = new h0("REUSABLE_CLAIMED");

    /* JADX WARN: Finally extract failed */
    public static final <T> void b(@NotNull z8.d<? super T> dVar, @NotNull Object obj, @Nullable h9.l<? super Throwable, v8.k0> lVar) {
        boolean z10;
        if (!(dVar instanceof j)) {
            dVar.resumeWith(obj);
            return;
        }
        j jVar = (j) dVar;
        Object objB = kotlinx.coroutines.g0.b(obj, lVar);
        if (jVar.f34663d.isDispatchNeeded(jVar.getContext())) {
            jVar.f34665f = objB;
            jVar.f29860c = 1;
            jVar.f34663d.dispatch(jVar.getContext(), jVar);
            return;
        }
        k1 k1VarB = b3.f29862a.b();
        if (k1VarB.P0()) {
            jVar.f34665f = objB;
            jVar.f29860c = 1;
            k1VarB.L0(jVar);
            return;
        }
        k1VarB.N0(true);
        try {
            b2 b2Var = (b2) jVar.getContext().get(b2.O7);
            if (b2Var == null || b2Var.isActive()) {
                z10 = false;
            } else {
                CancellationException cancellationExceptionX = b2Var.x();
                jVar.c(objB, cancellationExceptionX);
                t.a aVar = v8.t.f35208b;
                jVar.resumeWith(v8.t.b(v8.u.a(cancellationExceptionX)));
                z10 = true;
            }
            if (!z10) {
                z8.d<T> dVar2 = jVar.f34664e;
                Object obj2 = jVar.f34666g;
                z8.g context = dVar2.getContext();
                Object objC = l0.c(context, obj2);
                h3<?> h3VarG = objC != l0.f34671a ? kotlinx.coroutines.j0.g(dVar2, context, objC) : null;
                try {
                    jVar.f34664e.resumeWith(obj);
                    v8.k0 k0Var = v8.k0.f35197a;
                    if (h3VarG == null || h3VarG.U0()) {
                        l0.a(context, objC);
                    }
                } catch (Throwable th) {
                    if (h3VarG == null || h3VarG.U0()) {
                        l0.a(context, objC);
                    }
                    throw th;
                }
            }
            while (k1VarB.S0()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static /* synthetic */ void c(z8.d dVar, Object obj, h9.l lVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        b(dVar, obj, lVar);
    }

    public static final boolean d(@NotNull j<? super v8.k0> jVar) {
        v8.k0 k0Var = v8.k0.f35197a;
        k1 k1VarB = b3.f29862a.b();
        if (k1VarB.Q0()) {
            return false;
        }
        if (k1VarB.P0()) {
            jVar.f34665f = k0Var;
            jVar.f29860c = 1;
            k1VarB.L0(jVar);
            return true;
        }
        k1VarB.N0(true);
        try {
            jVar.run();
            do {
            } while (k1VarB.S0());
        } finally {
            try {
            } finally {
            }
        }
        return false;
    }
}

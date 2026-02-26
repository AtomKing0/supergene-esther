package v9;

import h9.p;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.t0;
import kotlinx.coroutines.c0;
import kotlinx.coroutines.d3;
import kotlinx.coroutines.k2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u9.d0;
import u9.l0;
import v8.t;
import v8.u;
import z8.d;
import z8.g;

/* JADX INFO: compiled from: Undispatched.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b {
    public static final <R, T> void a(@NotNull p<? super R, ? super d<? super T>, ? extends Object> pVar, R r10, @NotNull d<? super T> dVar) {
        d dVarA = h.a(dVar);
        try {
            g context = dVar.getContext();
            Object objC = l0.c(context, null);
            try {
                Object objMo4invoke = ((p) t0.f(pVar, 2)).mo4invoke(r10, dVarA);
                if (objMo4invoke != a9.d.e()) {
                    dVarA.resumeWith(t.b(objMo4invoke));
                }
            } finally {
                l0.a(context, objC);
            }
        } catch (Throwable th) {
            t.a aVar = t.f35208b;
            dVarA.resumeWith(t.b(u.a(th)));
        }
    }

    @Nullable
    public static final <T, R> Object b(@NotNull d0<? super T> d0Var, R r10, @NotNull p<? super R, ? super d<? super T>, ? extends Object> pVar) {
        Object c0Var;
        Object objR0;
        try {
            c0Var = ((p) t0.f(pVar, 2)).mo4invoke(r10, d0Var);
        } catch (Throwable th) {
            c0Var = new c0(th, false, 2, null);
        }
        if (c0Var != a9.d.e() && (objR0 = d0Var.r0(c0Var)) != k2.f29936b) {
            if (objR0 instanceof c0) {
                throw ((c0) objR0).f29865a;
            }
            return k2.h(objR0);
        }
        return a9.d.e();
    }

    @Nullable
    public static final <T, R> Object c(@NotNull d0<? super T> d0Var, R r10, @NotNull p<? super R, ? super d<? super T>, ? extends Object> pVar) throws Throwable {
        Object c0Var;
        Object objR0;
        try {
            c0Var = ((p) t0.f(pVar, 2)).mo4invoke(r10, d0Var);
        } catch (Throwable th) {
            c0Var = new c0(th, false, 2, null);
        }
        if (c0Var != a9.d.e() && (objR0 = d0Var.r0(c0Var)) != k2.f29936b) {
            if (objR0 instanceof c0) {
                Throwable th2 = ((c0) objR0).f29865a;
                if (((th2 instanceof d3) && ((d3) th2).f29875a == d0Var) ? false : true) {
                    throw th2;
                }
                if (c0Var instanceof c0) {
                    throw ((c0) c0Var).f29865a;
                }
            } else {
                c0Var = k2.h(objR0);
            }
            return c0Var;
        }
        return a9.d.e();
    }
}

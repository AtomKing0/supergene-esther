package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class k {
    @NotNull
    public static final <T> v0<T> a(@NotNull o0 o0Var, @NotNull z8.g gVar, @NotNull q0 q0Var, @NotNull h9.p<? super o0, ? super z8.d<? super T>, ? extends Object> pVar) {
        z8.g gVarD = j0.d(o0Var, gVar);
        w0 l2Var = q0Var.d() ? new l2(gVarD, pVar) : new w0(gVarD, true);
        ((a) l2Var).T0(q0Var, l2Var, pVar);
        return (v0<T>) l2Var;
    }

    public static /* synthetic */ v0 b(o0 o0Var, z8.g gVar, q0 q0Var, h9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = z8.h.f37608a;
        }
        if ((i10 & 2) != 0) {
            q0Var = q0.DEFAULT;
        }
        return i.a(o0Var, gVar, q0Var, pVar);
    }

    @NotNull
    public static final b2 c(@NotNull o0 o0Var, @NotNull z8.g gVar, @NotNull q0 q0Var, @NotNull h9.p<? super o0, ? super z8.d<? super v8.k0>, ? extends Object> pVar) {
        z8.g gVarD = j0.d(o0Var, gVar);
        a m2Var = q0Var.d() ? new m2(gVarD, pVar) : new w2(gVarD, true);
        m2Var.T0(q0Var, m2Var, pVar);
        return m2Var;
    }

    public static /* synthetic */ b2 d(o0 o0Var, z8.g gVar, q0 q0Var, h9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = z8.h.f37608a;
        }
        if ((i10 & 2) != 0) {
            q0Var = q0.DEFAULT;
        }
        return i.c(o0Var, gVar, q0Var, pVar);
    }

    @Nullable
    public static final <T> Object e(@NotNull z8.g gVar, @NotNull h9.p<? super o0, ? super z8.d<? super T>, ? extends Object> pVar, @NotNull z8.d<? super T> dVar) throws Throwable {
        Object objU0;
        z8.g context = dVar.getContext();
        z8.g gVarE = j0.e(context, gVar);
        f2.k(gVarE);
        if (gVarE == context) {
            u9.d0 d0Var = new u9.d0(gVarE, dVar);
            objU0 = v9.b.b(d0Var, d0Var, pVar);
        } else {
            e.b bVar = z8.e.R7;
            if (kotlin.jvm.internal.t.d(gVarE.get(bVar), context.get(bVar))) {
                h3 h3Var = new h3(gVarE, dVar);
                z8.g context2 = h3Var.getContext();
                Object objC = u9.l0.c(context2, null);
                try {
                    Object objB = v9.b.b(h3Var, h3Var, pVar);
                    u9.l0.a(context2, objC);
                    objU0 = objB;
                } catch (Throwable th) {
                    u9.l0.a(context2, objC);
                    throw th;
                }
            } else {
                a1 a1Var = new a1(gVarE, dVar);
                v9.a.d(pVar, a1Var, a1Var, null, 4, null);
                objU0 = a1Var.U0();
            }
        }
        if (objU0 == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objU0;
    }
}

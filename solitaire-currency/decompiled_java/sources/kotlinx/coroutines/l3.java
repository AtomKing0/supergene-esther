package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Yield.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class l3 {
    @Nullable
    public static final Object a(@NotNull z8.d<? super v8.k0> dVar) {
        Object objE;
        z8.g context = dVar.getContext();
        f2.k(context);
        z8.d dVarC = a9.c.c(dVar);
        u9.j jVar = dVarC instanceof u9.j ? (u9.j) dVarC : null;
        if (jVar == null) {
            objE = v8.k0.f35197a;
        } else {
            if (jVar.f34663d.isDispatchNeeded(context)) {
                jVar.q(context, v8.k0.f35197a);
            } else {
                k3 k3Var = new k3();
                z8.g gVarPlus = context.plus(k3Var);
                v8.k0 k0Var = v8.k0.f35197a;
                jVar.q(gVarPlus, k0Var);
                objE = (!k3Var.f29943a || u9.k.d(jVar)) ? a9.d.e() : k0Var;
            }
            objE = a9.d.e();
        }
        if (objE == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objE == a9.d.e() ? objE : v8.k0.f35197a;
    }
}

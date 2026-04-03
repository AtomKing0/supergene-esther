package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: Delay.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class y0 {
    @Nullable
    public static final Object a(long j10, @NotNull z8.d<? super v8.k0> dVar) throws Throwable {
        if (j10 <= 0) {
            return v8.k0.f35197a;
        }
        p pVar = new p(a9.c.c(dVar), 1);
        pVar.C();
        if (j10 < Long.MAX_VALUE) {
            b(pVar.getContext()).scheduleResumeAfterDelay(j10, pVar);
        }
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ == a9.d.e() ? objZ : v8.k0.f35197a;
    }

    @NotNull
    public static final x0 b(@NotNull z8.g gVar) {
        g.b bVar = gVar.get(z8.e.R7);
        x0 x0Var = bVar instanceof x0 ? (x0) bVar : null;
        return x0Var == null ? u0.a() : x0Var;
    }

    public static final long c(long j10) {
        if (q9.b.i(j10, q9.b.f33177b.c()) > 0) {
            return n9.o.f(q9.b.q(j10), 1L);
        }
        return 0L;
    }
}

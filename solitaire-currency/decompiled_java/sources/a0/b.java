package a0;

import ga.d0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Calls.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    @Nullable
    public static final Object a(@NotNull ga.e eVar, @NotNull z8.d<? super d0> dVar) throws Throwable {
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(a9.c.c(dVar), 1);
        pVar.C();
        k kVar = new k(eVar, pVar);
        eVar.n(kVar);
        pVar.m(kVar);
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ;
    }
}

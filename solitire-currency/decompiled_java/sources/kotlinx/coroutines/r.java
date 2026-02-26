package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CancellableContinuation.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class r {
    public static final void a(@NotNull o<?> oVar, @NotNull g1 g1Var) {
        oVar.m(new h1(g1Var));
    }

    @NotNull
    public static final <T> p<T> b(@NotNull z8.d<? super T> dVar) {
        if (!(dVar instanceof u9.j)) {
            return new p<>(dVar, 1);
        }
        p<T> pVarP = ((u9.j) dVar).p();
        if (pVarP != null) {
            if (!pVarP.L()) {
                pVarP = null;
            }
            if (pVarP != null) {
                return pVarP;
            }
        }
        return new p<>(dVar, 2);
    }
}

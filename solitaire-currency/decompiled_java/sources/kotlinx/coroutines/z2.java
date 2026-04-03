package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import z8.g;

/* JADX INFO: compiled from: ThreadContextElement.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface z2<S> extends g.b {

    /* JADX INFO: compiled from: ThreadContextElement.kt */
    public static final class a {
        public static <S, R> R a(@NotNull z2<S> z2Var, R r10, @NotNull h9.p<? super R, ? super g.b, ? extends R> pVar) {
            return (R) g.b.a.a(z2Var, r10, pVar);
        }

        @NotNull
        public static <S> z8.g b(@NotNull z2<S> z2Var, @NotNull z8.g gVar) {
            return g.b.a.d(z2Var, gVar);
        }
    }

    void restoreThreadContext(@NotNull z8.g gVar, S s10);

    S updateThreadContext(@NotNull z8.g gVar);
}

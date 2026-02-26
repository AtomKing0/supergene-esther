package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class i {
    @NotNull
    public static final <T> v0<T> a(@NotNull o0 o0Var, @NotNull z8.g gVar, @NotNull q0 q0Var, @NotNull h9.p<? super o0, ? super z8.d<? super T>, ? extends Object> pVar) {
        return k.a(o0Var, gVar, q0Var, pVar);
    }

    @NotNull
    public static final b2 c(@NotNull o0 o0Var, @NotNull z8.g gVar, @NotNull q0 q0Var, @NotNull h9.p<? super o0, ? super z8.d<? super v8.k0>, ? extends Object> pVar) {
        return k.c(o0Var, gVar, q0Var, pVar);
    }

    public static final <T> T e(@NotNull z8.g gVar, @NotNull h9.p<? super o0, ? super z8.d<? super T>, ? extends Object> pVar) throws InterruptedException {
        return (T) j.a(gVar, pVar);
    }

    @Nullable
    public static final <T> Object g(@NotNull z8.g gVar, @NotNull h9.p<? super o0, ? super z8.d<? super T>, ? extends Object> pVar, @NotNull z8.d<? super T> dVar) {
        return k.e(gVar, pVar, dVar);
    }
}

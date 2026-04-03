package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CompletableDeferred.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class z {
    @NotNull
    public static final <T> x<T> a(@Nullable b2 b2Var) {
        return new y(b2Var);
    }

    public static /* synthetic */ x b(b2 b2Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            b2Var = null;
        }
        return a(b2Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean c(@NotNull x<T> xVar, @NotNull Object obj) {
        Throwable thE = v8.t.e(obj);
        return thE == null ? xVar.O(obj) : xVar.c(thE);
    }
}

package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class s1 {
    @NotNull
    public static final Executor a(@NotNull k0 k0Var) {
        Executor executorI0;
        q1 q1Var = k0Var instanceof q1 ? (q1) k0Var : null;
        return (q1Var == null || (executorI0 = q1Var.I0()) == null) ? new d1(k0Var) : executorI0;
    }

    @NotNull
    public static final k0 b(@NotNull Executor executor) {
        k0 k0Var;
        d1 d1Var = executor instanceof d1 ? (d1) executor : null;
        return (d1Var == null || (k0Var = d1Var.f29874a) == null) ? new r1(executor) : k0Var;
    }

    @NotNull
    public static final q1 c(@NotNull ExecutorService executorService) {
        return new r1(executorService);
    }
}

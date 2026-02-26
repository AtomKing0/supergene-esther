package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Supervisor.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class y2 {
    @NotNull
    public static final a0 a(@Nullable b2 b2Var) {
        return new x2(b2Var);
    }

    public static /* synthetic */ a0 b(b2 b2Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            b2Var = null;
        }
        return a(b2Var);
    }
}

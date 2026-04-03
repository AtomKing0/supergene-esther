package g8;

import kotlinx.coroutines.b2;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.y2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CoroutinesUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class m {
    @NotNull
    public static final z8.g a(@Nullable b2 b2Var) {
        return y2.a(b2Var).plus(new a(l0.N7));
    }

    public static /* synthetic */ z8.g b(b2 b2Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            b2Var = null;
        }
        return a(b2Var);
    }

    /* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
    public static final class a extends z8.a implements l0 {
        public a(l0.b bVar) {
            super(bVar);
        }

        @Override // kotlinx.coroutines.l0
        public void handleException(@NotNull z8.g gVar, @NotNull Throwable th) {
        }
    }
}

package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class m0 {
    public static final void a(@NotNull z8.g gVar, @NotNull Throwable th) {
        try {
            l0 l0Var = (l0) gVar.get(l0.N7);
            if (l0Var != null) {
                l0Var.handleException(gVar, th);
            } else {
                u9.h.a(gVar, th);
            }
        } catch (Throwable th2) {
            u9.h.a(gVar, b(th, th2));
        }
    }

    @NotNull
    public static final Throwable b(@NotNull Throwable th, @NotNull Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        v8.f.a(runtimeException, th);
        return runtimeException;
    }
}

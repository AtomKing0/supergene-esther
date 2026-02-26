package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Delay.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface x0 {

    /* JADX INFO: compiled from: Delay.kt */
    public static final class a {
        @Nullable
        public static Object a(@NotNull x0 x0Var, long j10, @NotNull z8.d<? super v8.k0> dVar) throws Throwable {
            if (j10 <= 0) {
                return v8.k0.f35197a;
            }
            p pVar = new p(a9.c.c(dVar), 1);
            pVar.C();
            x0Var.scheduleResumeAfterDelay(j10, pVar);
            Object objZ = pVar.z();
            if (objZ == a9.d.e()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            return objZ == a9.d.e() ? objZ : v8.k0.f35197a;
        }

        @NotNull
        public static g1 b(@NotNull x0 x0Var, long j10, @NotNull Runnable runnable, @NotNull z8.g gVar) {
            return u0.a().invokeOnTimeout(j10, runnable, gVar);
        }
    }

    @NotNull
    g1 invokeOnTimeout(long j10, @NotNull Runnable runnable, @NotNull z8.g gVar);

    void scheduleResumeAfterDelay(long j10, @NotNull o<? super v8.k0> oVar);
}

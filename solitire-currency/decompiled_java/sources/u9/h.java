package u9;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CoroutineExceptionHandlerImpl.common.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h {
    public static final void a(@NotNull z8.g gVar, @NotNull Throwable th) {
        Iterator<kotlinx.coroutines.l0> it = g.a().iterator();
        while (it.hasNext()) {
            try {
                it.next().handleException(gVar, th);
            } catch (Throwable th2) {
                g.b(kotlinx.coroutines.m0.b(th, th2));
            }
        }
        try {
            v8.f.a(th, new i(gVar));
        } catch (Throwable unused) {
        }
        g.b(th);
    }
}

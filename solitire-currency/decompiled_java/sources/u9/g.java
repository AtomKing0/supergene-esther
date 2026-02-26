package u9;

import java.util.Collection;
import java.util.ServiceLoader;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CoroutineExceptionHandlerImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Collection<kotlinx.coroutines.l0> f34656a = o9.o.w(o9.m.c(ServiceLoader.load(kotlinx.coroutines.l0.class, kotlinx.coroutines.l0.class.getClassLoader()).iterator()));

    @NotNull
    public static final Collection<kotlinx.coroutines.l0> a() {
        return f34656a;
    }

    public static final void b(@NotNull Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }
}

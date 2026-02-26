package w9;

import java.util.concurrent.Executor;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.q1;
import n9.o;
import org.jetbrains.annotations.NotNull;
import u9.i0;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends q1 implements Executor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b f35530b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final k0 f35531c = m.f35551a.limitedParallelism(u9.k0.e("kotlinx.coroutines.io.parallelism", o.e(64, i0.a()), 0, 0, 12, null));

    private b() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // kotlinx.coroutines.k0
    public void dispatch(@NotNull z8.g gVar, @NotNull Runnable runnable) {
        f35531c.dispatch(gVar, runnable);
    }

    @Override // kotlinx.coroutines.k0
    public void dispatchYield(@NotNull z8.g gVar, @NotNull Runnable runnable) {
        f35531c.dispatchYield(gVar, runnable);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        dispatch(z8.h.f37608a, runnable);
    }

    @Override // kotlinx.coroutines.k0
    @NotNull
    public k0 limitedParallelism(int i10) {
        return m.f35551a.limitedParallelism(i10);
    }

    @Override // kotlinx.coroutines.k0
    @NotNull
    public String toString() {
        return "Dispatchers.IO";
    }

    @Override // kotlinx.coroutines.q1
    @NotNull
    public Executor I0() {
        return this;
    }
}

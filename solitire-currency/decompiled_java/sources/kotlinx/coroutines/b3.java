package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b3 f29862a = new b3();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final ThreadLocal<k1> f29863b = u9.o0.a(new u9.h0("ThreadLocalEventLoop"));

    private b3() {
    }

    @Nullable
    public final k1 a() {
        return f29863b.get();
    }

    @NotNull
    public final k1 b() {
        ThreadLocal<k1> threadLocal = f29863b;
        k1 k1Var = threadLocal.get();
        if (k1Var != null) {
            return k1Var;
        }
        k1 k1VarA = n1.a();
        threadLocal.set(k1VarA);
        return k1VarA;
    }

    public final void c() {
        f29863b.set(null);
    }

    public final void d(@NotNull k1 k1Var) {
        f29863b.set(k1Var);
    }
}

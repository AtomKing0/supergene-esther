package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DefaultExecutor.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f29984a = u9.i0.f("kotlinx.coroutines.main.delay", false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final x0 f29985b = b();

    @NotNull
    public static final x0 a() {
        return f29985b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final x0 b() {
        if (!f29984a) {
            return t0.f29980g;
        }
        n2 n2VarC = e1.c();
        return (u9.x.c(n2VarC) || !(n2VarC instanceof x0)) ? t0.f29980g : (x0) n2VarC;
    }
}

package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes5.dex */
final class v2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final k0 f29989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final o<v8.k0> f29990b;

    /* JADX WARN: Multi-variable type inference failed */
    public v2(@NotNull k0 k0Var, @NotNull o<? super v8.k0> oVar) {
        this.f29989a = k0Var;
        this.f29990b = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f29990b.o(this.f29989a, v8.k0.f35197a);
    }
}

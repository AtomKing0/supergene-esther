package kotlinx.coroutines;

import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes5.dex */
final class d1 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final k0 f29874a;

    public d1(@NotNull k0 k0Var) {
        this.f29874a = k0Var;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        k0 k0Var = this.f29874a;
        z8.h hVar = z8.h.f37608a;
        if (k0Var.isDispatchNeeded(hVar)) {
            this.f29874a.dispatch(hVar, runnable);
        } else {
            runnable.run();
        }
    }

    @NotNull
    public String toString() {
        return this.f29874a.toString();
    }
}

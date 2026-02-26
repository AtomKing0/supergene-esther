package kotlinx.coroutines;

import java.util.concurrent.Future;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes5.dex */
final class f1 implements g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Future<?> f29893a;

    public f1(@NotNull Future<?> future) {
        this.f29893a = future;
    }

    @Override // kotlinx.coroutines.g1
    public void dispose() {
        this.f29893a.cancel(false);
    }

    @NotNull
    public String toString() {
        return "DisposableFutureHandle[" + this.f29893a + ']';
    }
}

package kotlinx.coroutines;

import java.util.concurrent.Future;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Future.kt */
/* JADX INFO: loaded from: classes5.dex */
final class l extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Future<?> f29944a;

    public l(@NotNull Future<?> future) {
        this.f29944a = future;
    }

    @Override // kotlinx.coroutines.n
    public void d(@Nullable Throwable th) {
        if (th != null) {
            this.f29944a.cancel(false);
        }
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(Throwable th) {
        d(th);
        return v8.k0.f35197a;
    }

    @NotNull
    public String toString() {
        return "CancelFutureOnCancel[" + this.f29944a + ']';
    }
}

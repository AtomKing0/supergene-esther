package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CancellableContinuation.kt */
/* JADX INFO: loaded from: classes5.dex */
final class h1 extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final g1 f29903a;

    public h1(@NotNull g1 g1Var) {
        this.f29903a = g1Var;
    }

    @Override // kotlinx.coroutines.n
    public void d(@Nullable Throwable th) {
        this.f29903a.dispose();
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(Throwable th) {
        d(th);
        return v8.k0.f35197a;
    }

    @NotNull
    public String toString() {
        return "DisposeOnCancel[" + this.f29903a + ']';
    }
}

package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
final class y1 extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final h9.l<Throwable, v8.k0> f29995a;

    /* JADX WARN: Multi-variable type inference failed */
    public y1(@NotNull h9.l<? super Throwable, v8.k0> lVar) {
        this.f29995a = lVar;
    }

    @Override // kotlinx.coroutines.n
    public void d(@Nullable Throwable th) {
        this.f29995a.invoke(th);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(Throwable th) {
        d(th);
        return v8.k0.f35197a;
    }

    @NotNull
    public String toString() {
        return "InvokeOnCancel[" + s0.a(this.f29995a) + '@' + s0.b(this) + ']';
    }
}

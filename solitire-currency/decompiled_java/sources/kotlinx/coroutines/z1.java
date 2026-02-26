package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes5.dex */
final class z1 extends d2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f29996f = AtomicIntegerFieldUpdater.newUpdater(z1.class, "_invoked");
    private volatile int _invoked;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final h9.l<Throwable, v8.k0> f29997e;

    /* JADX WARN: Multi-variable type inference failed */
    public z1(@NotNull h9.l<? super Throwable, v8.k0> lVar) {
        this.f29997e = lVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(Throwable th) {
        q(th);
        return v8.k0.f35197a;
    }

    @Override // kotlinx.coroutines.e0
    public void q(@Nullable Throwable th) {
        if (f29996f.compareAndSet(this, 0, 1)) {
            this.f29997e.invoke(th);
        }
    }
}

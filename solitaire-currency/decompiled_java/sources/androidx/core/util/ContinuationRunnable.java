package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import v8.k0;
import v8.t;

/* JADX INFO: compiled from: Runnable.kt */
/* JADX INFO: loaded from: classes.dex */
final class ContinuationRunnable extends AtomicBoolean implements Runnable {

    @NotNull
    private final z8.d<k0> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationRunnable(@NotNull z8.d<? super k0> dVar) {
        super(false);
        this.continuation = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (compareAndSet(false, true)) {
            z8.d<k0> dVar = this.continuation;
            t.a aVar = t.f35208b;
            dVar.resumeWith(t.b(k0.f35197a));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    @NotNull
    public String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }
}

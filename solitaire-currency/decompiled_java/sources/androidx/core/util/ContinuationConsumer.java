package androidx.core.util;

import androidx.annotation.RequiresApi;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import v8.t;

/* JADX INFO: compiled from: PlatformConsumer.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
final class ContinuationConsumer<T> extends AtomicBoolean implements java.util.function.Consumer<T> {

    @NotNull
    private final z8.d<T> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationConsumer(@NotNull z8.d<? super T> dVar) {
        super(false);
        this.continuation = dVar;
    }

    @Override // java.util.function.Consumer
    public void accept(T t10) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(t.b(t10));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    @NotNull
    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}

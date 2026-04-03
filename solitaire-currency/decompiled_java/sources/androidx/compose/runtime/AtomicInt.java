package androidx.compose.runtime;

import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ActualJvm.jvm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AtomicInt {

    @NotNull
    private final AtomicInteger delegate;

    public AtomicInt(int i10) {
        this.delegate = new AtomicInteger(i10);
    }

    public final int add(int i10) {
        return this.delegate.addAndGet(i10);
    }

    public final int get() {
        return this.delegate.get();
    }

    @NotNull
    public final AtomicInteger getDelegate() {
        return this.delegate;
    }

    public final void set(int i10) {
        this.delegate.set(i10);
    }
}

package androidx.compose.runtime;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.l;
import v8.n;

/* JADX INFO: compiled from: ValueHolders.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyValueHolder<T> implements State<T> {

    @NotNull
    private final l current$delegate;

    public LazyValueHolder(@NotNull h9.a<? extends T> valueProducer) {
        t.i(valueProducer, "valueProducer");
        this.current$delegate = n.a(valueProducer);
    }

    private final T getCurrent() {
        return (T) this.current$delegate.getValue();
    }

    @Override // androidx.compose.runtime.State
    public T getValue() {
        return getCurrent();
    }
}

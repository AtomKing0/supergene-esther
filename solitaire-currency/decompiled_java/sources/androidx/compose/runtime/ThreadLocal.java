package androidx.compose.runtime;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ActualJvm.jvm.kt */
/* JADX INFO: loaded from: classes.dex */
public class ThreadLocal<T> extends java.lang.ThreadLocal<T> {

    @NotNull
    private final h9.a<T> initialValue;

    /* JADX WARN: Multi-variable type inference failed */
    public ThreadLocal(@NotNull h9.a<? extends T> initialValue) {
        t.i(initialValue, "initialValue");
        this.initialValue = initialValue;
    }

    @Override // java.lang.ThreadLocal
    public T get() {
        return (T) super.get();
    }

    @Override // java.lang.ThreadLocal
    @Nullable
    protected T initialValue() {
        return this.initialValue.invoke();
    }

    @Override // java.lang.ThreadLocal
    public void remove() {
        super.remove();
    }

    @Override // java.lang.ThreadLocal
    public void set(T t10) {
        super.set(t10);
    }
}

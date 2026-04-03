package androidx.compose.runtime;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ValueHolders.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StaticValueHolder<T> implements State<T> {
    private final T value;

    public StaticValueHolder(T t10) {
        this.value = t10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StaticValueHolder copy$default(StaticValueHolder staticValueHolder, Object obj, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = staticValueHolder.getValue();
        }
        return staticValueHolder.copy(obj);
    }

    public final T component1() {
        return getValue();
    }

    @NotNull
    public final StaticValueHolder<T> copy(T t10) {
        return new StaticValueHolder<>(t10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StaticValueHolder) && t.d(getValue(), ((StaticValueHolder) obj).getValue());
    }

    @Override // androidx.compose.runtime.State
    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        if (getValue() == null) {
            return 0;
        }
        return getValue().hashCode();
    }

    @NotNull
    public String toString() {
        return "StaticValueHolder(value=" + getValue() + ')';
    }
}

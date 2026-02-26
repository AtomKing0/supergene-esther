package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PersistentOrderedMap.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LinkedValue<V> {

    @Nullable
    private final Object next;

    @Nullable
    private final Object previous;
    private final V value;

    public LinkedValue(V v10, @Nullable Object obj, @Nullable Object obj2) {
        this.value = v10;
        this.previous = obj;
        this.next = obj2;
    }

    public final boolean getHasNext() {
        return this.next != EndOfChain.INSTANCE;
    }

    public final boolean getHasPrevious() {
        return this.previous != EndOfChain.INSTANCE;
    }

    @Nullable
    public final Object getNext() {
        return this.next;
    }

    @Nullable
    public final Object getPrevious() {
        return this.previous;
    }

    public final V getValue() {
        return this.value;
    }

    @NotNull
    public final LinkedValue<V> withNext(@Nullable Object obj) {
        return new LinkedValue<>(this.value, this.previous, obj);
    }

    @NotNull
    public final LinkedValue<V> withPrevious(@Nullable Object obj) {
        return new LinkedValue<>(this.value, obj, this.next);
    }

    @NotNull
    public final LinkedValue<V> withValue(V v10) {
        return new LinkedValue<>(v10, this.previous, this.next);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LinkedValue(V v10) {
        EndOfChain endOfChain = EndOfChain.INSTANCE;
        this(v10, endOfChain, endOfChain);
    }

    public LinkedValue(V v10, @Nullable Object obj) {
        this(v10, obj, EndOfChain.INSTANCE);
    }
}

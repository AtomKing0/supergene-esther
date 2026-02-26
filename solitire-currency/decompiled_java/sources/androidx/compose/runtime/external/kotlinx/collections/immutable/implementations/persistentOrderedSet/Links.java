package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PersistentOrderedSet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Links {

    @Nullable
    private final Object next;

    @Nullable
    private final Object previous;

    public Links(@Nullable Object obj, @Nullable Object obj2) {
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

    @NotNull
    public final Links withNext(@Nullable Object obj) {
        return new Links(this.previous, obj);
    }

    @NotNull
    public final Links withPrevious(@Nullable Object obj) {
        return new Links(obj, this.next);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Links() {
        EndOfChain endOfChain = EndOfChain.INSTANCE;
        this(endOfChain, endOfChain);
    }

    public Links(@Nullable Object obj) {
        this(obj, EndOfChain.INSTANCE);
    }
}

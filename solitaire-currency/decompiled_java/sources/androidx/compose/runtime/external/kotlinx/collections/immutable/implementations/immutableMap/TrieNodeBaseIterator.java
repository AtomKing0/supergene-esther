package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import i9.a;
import java.util.Iterator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PersistentHashMapContentIterators.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class TrieNodeBaseIterator<K, V, T> implements Iterator<T>, a {

    @NotNull
    private Object[] buffer = TrieNode.Companion.getEMPTY$runtime_release().getBuffer$runtime_release();
    private int dataSize;
    private int index;

    public final K currentKey() {
        CommonFunctionsKt.m1270assert(hasNextKey());
        return (K) this.buffer[this.index];
    }

    @NotNull
    public final TrieNode<? extends K, ? extends V> currentNode() {
        CommonFunctionsKt.m1270assert(hasNextNode());
        Object obj = this.buffer[this.index];
        if (obj != null) {
            return (TrieNode) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator>");
    }

    @NotNull
    protected final Object[] getBuffer() {
        return this.buffer;
    }

    protected final int getIndex() {
        return this.index;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return hasNextKey();
    }

    public final boolean hasNextKey() {
        return this.index < this.dataSize;
    }

    public final boolean hasNextNode() {
        CommonFunctionsKt.m1270assert(this.index >= this.dataSize);
        return this.index < this.buffer.length;
    }

    public final void moveToNextKey() {
        CommonFunctionsKt.m1270assert(hasNextKey());
        this.index += 2;
    }

    public final void moveToNextNode() {
        CommonFunctionsKt.m1270assert(hasNextNode());
        this.index++;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void reset(@NotNull Object[] buffer, int i10, int i11) {
        t.i(buffer, "buffer");
        this.buffer = buffer;
        this.dataSize = i10;
        this.index = i11;
    }

    protected final void setIndex(int i10) {
        this.index = i10;
    }

    public final void reset(@NotNull Object[] buffer, int i10) {
        t.i(buffer, "buffer");
        reset(buffer, i10, 0);
    }
}

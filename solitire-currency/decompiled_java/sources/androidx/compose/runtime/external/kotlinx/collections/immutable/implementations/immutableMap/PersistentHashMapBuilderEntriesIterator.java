package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import i9.a;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PersistentHashMapBuilderContentIterators.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentHashMapBuilderEntriesIterator<K, V> implements Iterator<Map.Entry<K, V>>, a {

    @NotNull
    private final PersistentHashMapBuilderBaseIterator<K, V, Map.Entry<K, V>> base;

    public PersistentHashMapBuilderEntriesIterator(@NotNull PersistentHashMapBuilder<K, V> builder) {
        t.i(builder, "builder");
        TrieNodeBaseIterator[] trieNodeBaseIteratorArr = new TrieNodeBaseIterator[8];
        for (int i10 = 0; i10 < 8; i10++) {
            trieNodeBaseIteratorArr[i10] = new TrieNodeMutableEntriesIterator(this);
        }
        this.base = new PersistentHashMapBuilderBaseIterator<>(builder, trieNodeBaseIteratorArr);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.base.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.base.remove();
    }

    public final void setValue(K k10, V v10) {
        this.base.setValue(k10, v10);
    }

    @Override // java.util.Iterator
    @NotNull
    public Map.Entry<K, V> next() {
        return this.base.next();
    }
}

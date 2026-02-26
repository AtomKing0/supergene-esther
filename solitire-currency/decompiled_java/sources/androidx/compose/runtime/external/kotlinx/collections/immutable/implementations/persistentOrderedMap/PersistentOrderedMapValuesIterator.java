package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import i9.a;
import java.util.Iterator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PersistentOrderedMapContentIterators.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentOrderedMapValuesIterator<K, V> implements Iterator<V>, a {

    @NotNull
    private final PersistentOrderedMapLinksIterator<K, V> internal;

    public PersistentOrderedMapValuesIterator(@NotNull PersistentOrderedMap<K, V> map) {
        t.i(map, "map");
        this.internal = new PersistentOrderedMapLinksIterator<>(map.getFirstKey$runtime_release(), map.getHashMap$runtime_release());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.internal.hasNext();
    }

    @Override // java.util.Iterator
    public V next() {
        return this.internal.next().getValue();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

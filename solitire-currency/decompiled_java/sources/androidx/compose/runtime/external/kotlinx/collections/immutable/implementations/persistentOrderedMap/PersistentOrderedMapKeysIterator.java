package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import i9.a;
import java.util.Iterator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PersistentOrderedMapContentIterators.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentOrderedMapKeysIterator<K, V> implements Iterator<K>, a {

    @NotNull
    private final PersistentOrderedMapLinksIterator<K, V> internal;

    public PersistentOrderedMapKeysIterator(@NotNull PersistentOrderedMap<K, V> map) {
        t.i(map, "map");
        this.internal = new PersistentOrderedMapLinksIterator<>(map.getFirstKey$runtime_release(), map.getHashMap$runtime_release());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.internal.hasNext();
    }

    @Override // java.util.Iterator
    public K next() {
        K k10 = (K) this.internal.getNextKey$runtime_release();
        this.internal.next();
        return k10;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

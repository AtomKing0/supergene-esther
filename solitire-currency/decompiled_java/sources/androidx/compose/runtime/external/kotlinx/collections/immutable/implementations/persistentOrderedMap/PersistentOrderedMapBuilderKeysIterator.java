package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import i9.a;
import java.util.Iterator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PersistentOrderedMapBuilderContentIterators.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentOrderedMapBuilderKeysIterator<K, V> implements Iterator<K>, a {

    @NotNull
    private final PersistentOrderedMapBuilderLinksIterator<K, V> internal;

    public PersistentOrderedMapBuilderKeysIterator(@NotNull PersistentOrderedMapBuilder<K, V> map) {
        t.i(map, "map");
        this.internal = new PersistentOrderedMapBuilderLinksIterator<>(map.getFirstKey$runtime_release(), map);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.internal.hasNext();
    }

    @Override // java.util.Iterator
    public K next() {
        this.internal.next();
        return (K) this.internal.getLastIteratedKey$runtime_release();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.internal.remove();
    }
}

package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import i9.e;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PersistentHashMapBuilderContentIterators.kt */
/* JADX INFO: loaded from: classes.dex */
final class MutableMapEntry<K, V> extends MapEntry<K, V> implements e.a {

    @NotNull
    private final PersistentHashMapBuilderEntriesIterator<K, V> parentIterator;
    private V value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableMapEntry(@NotNull PersistentHashMapBuilderEntriesIterator<K, V> parentIterator, K k10, V v10) {
        super(k10, v10);
        t.i(parentIterator, "parentIterator");
        this.parentIterator = parentIterator;
        this.value = v10;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.MapEntry, java.util.Map.Entry
    public V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public void setValue(V v10) {
        this.value = v10;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.MapEntry, java.util.Map.Entry
    public V setValue(V v10) {
        V value = getValue();
        setValue((Object) v10);
        this.parentIterator.setValue(getKey(), v10);
        return value;
    }
}

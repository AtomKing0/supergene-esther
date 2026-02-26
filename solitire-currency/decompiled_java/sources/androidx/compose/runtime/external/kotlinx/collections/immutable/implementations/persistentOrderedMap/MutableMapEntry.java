package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.MapEntry;
import i9.e;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PersistentOrderedMapBuilderContentIterators.kt */
/* JADX INFO: loaded from: classes.dex */
final class MutableMapEntry<K, V> extends MapEntry<K, V> implements e.a {

    @NotNull
    private LinkedValue<V> links;

    @NotNull
    private final Map<K, LinkedValue<V>> mutableMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableMapEntry(@NotNull Map<K, LinkedValue<V>> mutableMap, K k10, @NotNull LinkedValue<V> links) {
        super(k10, links.getValue());
        t.i(mutableMap, "mutableMap");
        t.i(links, "links");
        this.mutableMap = mutableMap;
        this.links = links;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.MapEntry, java.util.Map.Entry
    public V getValue() {
        return this.links.getValue();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.MapEntry, java.util.Map.Entry
    public V setValue(V v10) {
        V value = this.links.getValue();
        this.links = this.links.withValue(v10);
        this.mutableMap.put(getKey(), this.links);
        return value;
    }
}

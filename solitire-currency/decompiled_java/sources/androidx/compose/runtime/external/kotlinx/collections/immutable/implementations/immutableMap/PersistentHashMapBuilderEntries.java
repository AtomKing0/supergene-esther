package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PersistentHashMapBuilderContentViews.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentHashMapBuilderEntries<K, V> extends AbstractMapBuilderEntries<Map.Entry<K, V>, K, V> {

    @NotNull
    private final PersistentHashMapBuilder<K, V> builder;

    public PersistentHashMapBuilderEntries(@NotNull PersistentHashMapBuilder<K, V> builder) {
        t.i(builder, "builder");
        this.builder = builder;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.builder.clear();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.AbstractMapBuilderEntries
    public boolean containsEntry(@NotNull Map.Entry<? extends K, ? extends V> element) {
        t.i(element, "element");
        V v10 = this.builder.get(element.getKey());
        return v10 != null ? t.d(v10, element.getValue()) : element.getValue() == null && this.builder.containsKey(element.getKey());
    }

    @Override // kotlin.collections.h
    public int getSize() {
        return this.builder.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @NotNull
    public Iterator<Map.Entry<K, V>> iterator() {
        return new PersistentHashMapBuilderEntriesIterator(this.builder);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.AbstractMapBuilderEntries
    public boolean removeEntry(@NotNull Map.Entry<? extends K, ? extends V> element) {
        t.i(element, "element");
        return this.builder.remove(element.getKey(), element.getValue());
    }

    @Override // kotlin.collections.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(@NotNull Map.Entry<K, V> element) {
        t.i(element, "element");
        throw new UnsupportedOperationException();
    }
}

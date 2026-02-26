package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.collections.g;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PersistentOrderedMapBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentOrderedMapBuilder<K, V> extends g<K, V> implements PersistentMap.Builder<K, V> {

    @Nullable
    private Object firstKey;

    @NotNull
    private final PersistentHashMapBuilder<K, LinkedValue<V>> hashMapBuilder;

    @Nullable
    private Object lastKey;

    @NotNull
    private PersistentOrderedMap<K, V> map;

    public PersistentOrderedMapBuilder(@NotNull PersistentOrderedMap<K, V> map) {
        t.i(map, "map");
        this.map = map;
        this.firstKey = map.getFirstKey$runtime_release();
        this.lastKey = this.map.getLastKey$runtime_release();
        this.hashMapBuilder = this.map.getHashMap$runtime_release().builder();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
    @NotNull
    public PersistentMap<K, V> build() {
        PersistentOrderedMap<K, V> persistentOrderedMap;
        PersistentHashMap<K, LinkedValue<V>> persistentHashMapBuild = this.hashMapBuilder.build();
        if (persistentHashMapBuild == this.map.getHashMap$runtime_release()) {
            CommonFunctionsKt.m1270assert(this.firstKey == this.map.getFirstKey$runtime_release());
            CommonFunctionsKt.m1270assert(this.lastKey == this.map.getLastKey$runtime_release());
            persistentOrderedMap = this.map;
        } else {
            persistentOrderedMap = new PersistentOrderedMap<>(this.firstKey, this.lastKey, persistentHashMapBuild);
        }
        this.map = persistentOrderedMap;
        return persistentOrderedMap;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.hashMapBuilder.clear();
        EndOfChain endOfChain = EndOfChain.INSTANCE;
        this.firstKey = endOfChain;
        this.lastKey = endOfChain;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.hashMapBuilder.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V get(Object obj) {
        LinkedValue<V> linkedValue = this.hashMapBuilder.get(obj);
        if (linkedValue != null) {
            return linkedValue.getValue();
        }
        return null;
    }

    @Override // kotlin.collections.g
    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        return new PersistentOrderedMapBuilderEntries(this);
    }

    @Nullable
    public final Object getFirstKey$runtime_release() {
        return this.firstKey;
    }

    @NotNull
    public final PersistentHashMapBuilder<K, LinkedValue<V>> getHashMapBuilder$runtime_release() {
        return this.hashMapBuilder;
    }

    @Override // kotlin.collections.g
    @NotNull
    public Set<K> getKeys() {
        return new PersistentOrderedMapBuilderKeys(this);
    }

    @Override // kotlin.collections.g
    public int getSize() {
        return this.hashMapBuilder.size();
    }

    @Override // kotlin.collections.g
    @NotNull
    public Collection<V> getValues() {
        return new PersistentOrderedMapBuilderValues(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.g, java.util.AbstractMap, java.util.Map
    @Nullable
    public V put(K k10, V v10) {
        LinkedValue<V> linkedValue = this.hashMapBuilder.get(k10);
        if (linkedValue != null) {
            if (linkedValue.getValue() == v10) {
                return v10;
            }
            this.hashMapBuilder.put(k10, linkedValue.withValue(v10));
            return linkedValue.getValue();
        }
        if (isEmpty()) {
            this.firstKey = k10;
            this.lastKey = k10;
            this.hashMapBuilder.put(k10, new LinkedValue<>(v10));
            return null;
        }
        Object obj = this.lastKey;
        LinkedValue<V> linkedValue2 = this.hashMapBuilder.get(obj);
        t.f(linkedValue2);
        CommonFunctionsKt.m1270assert(!r2.getHasNext());
        this.hashMapBuilder.put(obj, linkedValue2.withNext(k10));
        this.hashMapBuilder.put(k10, new LinkedValue<>(v10, obj));
        this.lastKey = k10;
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V remove(Object obj) {
        LinkedValue<V> linkedValueRemove = this.hashMapBuilder.remove(obj);
        if (linkedValueRemove == null) {
            return null;
        }
        if (linkedValueRemove.getHasPrevious()) {
            LinkedValue<V> linkedValue = this.hashMapBuilder.get(linkedValueRemove.getPrevious());
            t.f(linkedValue);
            this.hashMapBuilder.put(linkedValueRemove.getPrevious(), linkedValue.withNext(linkedValueRemove.getNext()));
        } else {
            this.firstKey = linkedValueRemove.getNext();
        }
        if (linkedValueRemove.getHasNext()) {
            LinkedValue<V> linkedValue2 = this.hashMapBuilder.get(linkedValueRemove.getNext());
            t.f(linkedValue2);
            this.hashMapBuilder.put(linkedValueRemove.getNext(), linkedValue2.withPrevious(linkedValueRemove.getPrevious()));
        } else {
            this.lastKey = linkedValueRemove.getPrevious();
        }
        return linkedValueRemove.getValue();
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        LinkedValue<V> linkedValue = this.hashMapBuilder.get(obj);
        if (linkedValue == null || !t.d(linkedValue.getValue(), obj2)) {
            return false;
        }
        remove(obj);
        return true;
    }
}

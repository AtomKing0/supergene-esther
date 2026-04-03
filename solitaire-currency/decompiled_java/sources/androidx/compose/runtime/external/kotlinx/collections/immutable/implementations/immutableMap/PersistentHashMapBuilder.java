package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.collections.g;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PersistentHashMapBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentHashMapBuilder<K, V> extends g<K, V> implements PersistentMap.Builder<K, V> {

    @NotNull
    private PersistentHashMap<K, V> map;
    private int modCount;

    @NotNull
    private TrieNode<K, V> node;

    @Nullable
    private V operationResult;

    @NotNull
    private MutabilityOwnership ownership;
    private int size;

    public PersistentHashMapBuilder(@NotNull PersistentHashMap<K, V> map) {
        t.i(map, "map");
        this.map = map;
        this.ownership = new MutabilityOwnership();
        this.node = this.map.getNode$runtime_release();
        this.size = this.map.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.node = TrieNode.Companion.getEMPTY$runtime_release();
        setSize(0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.node.containsKey(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V get(Object obj) {
        return this.node.get(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    @Override // kotlin.collections.g
    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        return new PersistentHashMapBuilderEntries(this);
    }

    @Override // kotlin.collections.g
    @NotNull
    public Set<K> getKeys() {
        return new PersistentHashMapBuilderKeys(this);
    }

    public final int getModCount$runtime_release() {
        return this.modCount;
    }

    @NotNull
    public final TrieNode<K, V> getNode$runtime_release() {
        return this.node;
    }

    @Nullable
    public final V getOperationResult$runtime_release() {
        return this.operationResult;
    }

    @NotNull
    public final MutabilityOwnership getOwnership$runtime_release() {
        return this.ownership;
    }

    @Override // kotlin.collections.g
    public int getSize() {
        return this.size;
    }

    @Override // kotlin.collections.g
    @NotNull
    public Collection<V> getValues() {
        return new PersistentHashMapBuilderValues(this);
    }

    @Override // kotlin.collections.g, java.util.AbstractMap, java.util.Map
    @Nullable
    public V put(K k10, V v10) {
        this.operationResult = null;
        this.node = this.node.mutablePut(k10 != null ? k10.hashCode() : 0, k10, v10, 0, this);
        return this.operationResult;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(@NotNull Map<? extends K, ? extends V> from) {
        t.i(from, "from");
        PersistentHashMap<K, V> persistentHashMapBuild = from instanceof PersistentHashMap ? (PersistentHashMap) from : null;
        if (persistentHashMapBuild == null) {
            PersistentHashMapBuilder persistentHashMapBuilder = from instanceof PersistentHashMapBuilder ? (PersistentHashMapBuilder) from : null;
            persistentHashMapBuild = persistentHashMapBuilder != null ? persistentHashMapBuilder.build() : null;
        }
        if (persistentHashMapBuild == null) {
            super.putAll(from);
            return;
        }
        DeltaCounter deltaCounter = new DeltaCounter(0, 1, null);
        int size = size();
        this.node = this.node.mutablePutAll(persistentHashMapBuild.getNode$runtime_release(), 0, deltaCounter, this);
        int size2 = (persistentHashMapBuild.size() + size) - deltaCounter.getCount();
        if (size != size2) {
            setSize(size2);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V remove(Object obj) {
        this.operationResult = null;
        TrieNode trieNodeMutableRemove = this.node.mutableRemove(obj != null ? obj.hashCode() : 0, obj, 0, this);
        if (trieNodeMutableRemove == null) {
            trieNodeMutableRemove = TrieNode.Companion.getEMPTY$runtime_release();
        }
        this.node = trieNodeMutableRemove;
        return this.operationResult;
    }

    public final void setModCount$runtime_release(int i10) {
        this.modCount = i10;
    }

    public final void setNode$runtime_release(@NotNull TrieNode<K, V> trieNode) {
        t.i(trieNode, "<set-?>");
        this.node = trieNode;
    }

    public final void setOperationResult$runtime_release(@Nullable V v10) {
        this.operationResult = v10;
    }

    public void setSize(int i10) {
        this.size = i10;
        this.modCount++;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
    @NotNull
    public PersistentHashMap<K, V> build() {
        PersistentHashMap<K, V> persistentHashMap;
        if (this.node == this.map.getNode$runtime_release()) {
            persistentHashMap = this.map;
        } else {
            this.ownership = new MutabilityOwnership();
            persistentHashMap = new PersistentHashMap<>(this.node, size());
        }
        this.map = persistentHashMap;
        return persistentHashMap;
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        int size = size();
        TrieNode trieNodeMutableRemove = this.node.mutableRemove(obj != null ? obj.hashCode() : 0, obj, obj2, 0, this);
        if (trieNodeMutableRemove == null) {
            trieNodeMutableRemove = TrieNode.Companion.getEMPTY$runtime_release();
        }
        this.node = trieNodeMutableRemove;
        return size != size();
    }
}

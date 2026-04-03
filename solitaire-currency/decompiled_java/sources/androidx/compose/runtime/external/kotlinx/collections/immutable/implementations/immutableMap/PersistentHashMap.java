package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
import java.util.Map;
import java.util.Set;
import kotlin.collections.d;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PersistentHashMap.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentHashMap<K, V> extends d<K, V> implements PersistentMap<K, V> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final PersistentHashMap EMPTY = new PersistentHashMap(TrieNode.Companion.getEMPTY$runtime_release(), 0);

    @NotNull
    private final TrieNode<K, V> node;
    private final int size;

    /* JADX INFO: compiled from: PersistentHashMap.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final <K, V> PersistentHashMap<K, V> emptyOf$runtime_release() {
            return PersistentHashMap.EMPTY;
        }
    }

    public PersistentHashMap(@NotNull TrieNode<K, V> node, int i10) {
        t.i(node, "node");
        this.node = node;
        this.size = i10;
    }

    private final ImmutableSet<Map.Entry<K, V>> createEntries() {
        return new PersistentHashMapEntries(this);
    }

    @Override // java.util.Map, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    @NotNull
    public PersistentMap<K, V> clear() {
        return Companion.emptyOf$runtime_release();
    }

    @Override // kotlin.collections.d, java.util.Map
    public boolean containsKey(Object obj) {
        return this.node.containsKey(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    @Override // kotlin.collections.d, java.util.Map
    public final /* bridge */ ImmutableSet<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // kotlin.collections.d, java.util.Map
    @Nullable
    public V get(Object obj) {
        return this.node.get(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    @Override // kotlin.collections.d, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap
    @NotNull
    public ImmutableSet<Map.Entry<K, V>> getEntries() {
        return createEntries();
    }

    @NotNull
    public final TrieNode<K, V> getNode$runtime_release() {
        return this.node;
    }

    @Override // kotlin.collections.d
    public int getSize() {
        return this.size;
    }

    @Override // kotlin.collections.d, java.util.Map
    public final /* bridge */ ImmutableSet<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    @NotNull
    public PersistentMap<K, V> putAll(@NotNull Map<? extends K, ? extends V> m10) {
        t.i(m10, "m");
        PersistentMap.Builder<K, V> builder = builder();
        builder.putAll(m10);
        return builder.build();
    }

    @Override // kotlin.collections.d, java.util.Map
    public final /* bridge */ ImmutableCollection<V> values() {
        return getValues();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    @NotNull
    public PersistentHashMapBuilder<K, V> builder() {
        return new PersistentHashMapBuilder<>(this);
    }

    @Override // kotlin.collections.d, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap
    @NotNull
    public final Set<Map.Entry<K, V>> getEntries() {
        return createEntries();
    }

    @Override // kotlin.collections.d, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap
    @NotNull
    public ImmutableSet<K> getKeys() {
        return new PersistentHashMapKeys(this);
    }

    @Override // kotlin.collections.d, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap
    @NotNull
    public ImmutableCollection<V> getValues() {
        return new PersistentHashMapValues(this);
    }

    @Override // kotlin.collections.d, java.util.Map, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    @NotNull
    public PersistentHashMap<K, V> put(K k10, V v10) {
        TrieNode.ModificationResult<K, V> modificationResultPut = this.node.put(k10 != null ? k10.hashCode() : 0, k10, v10, 0);
        return modificationResultPut == null ? this : new PersistentHashMap<>(modificationResultPut.getNode(), size() + modificationResultPut.getSizeDelta());
    }

    @Override // kotlin.collections.d, java.util.Map, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    @NotNull
    public PersistentHashMap<K, V> remove(K k10) {
        TrieNode<K, V> trieNodeRemove = this.node.remove(k10 != null ? k10.hashCode() : 0, k10, 0);
        if (this.node == trieNodeRemove) {
            return this;
        }
        if (trieNodeRemove == null) {
            return Companion.emptyOf$runtime_release();
        }
        return new PersistentHashMap<>(trieNodeRemove, size() - 1);
    }

    @Override // java.util.Map, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    @NotNull
    public PersistentHashMap<K, V> remove(K k10, V v10) {
        TrieNode<K, V> trieNodeRemove = this.node.remove(k10 != null ? k10.hashCode() : 0, k10, v10, 0);
        if (this.node == trieNodeRemove) {
            return this;
        }
        if (trieNodeRemove == null) {
            return Companion.emptyOf$runtime_release();
        }
        return new PersistentHashMap<>(trieNodeRemove, size() - 1);
    }
}

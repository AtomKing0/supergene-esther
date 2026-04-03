package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Map;
import java.util.Set;
import kotlin.collections.d;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PersistentOrderedMap.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentOrderedMap<K, V> extends d<K, V> implements PersistentMap<K, V> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final PersistentOrderedMap EMPTY;

    @Nullable
    private final Object firstKey;

    @NotNull
    private final PersistentHashMap<K, LinkedValue<V>> hashMap;

    @Nullable
    private final Object lastKey;

    /* JADX INFO: compiled from: PersistentOrderedMap.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final <K, V> PersistentOrderedMap<K, V> emptyOf$runtime_release() {
            return PersistentOrderedMap.EMPTY;
        }
    }

    static {
        EndOfChain endOfChain = EndOfChain.INSTANCE;
        EMPTY = new PersistentOrderedMap(endOfChain, endOfChain, PersistentHashMap.Companion.emptyOf$runtime_release());
    }

    public PersistentOrderedMap(@Nullable Object obj, @Nullable Object obj2, @NotNull PersistentHashMap<K, LinkedValue<V>> hashMap) {
        t.i(hashMap, "hashMap");
        this.firstKey = obj;
        this.lastKey = obj2;
        this.hashMap = hashMap;
    }

    private final ImmutableSet<Map.Entry<K, V>> createEntries() {
        return new PersistentOrderedMapEntries(this);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    @NotNull
    public PersistentMap.Builder<K, V> builder() {
        return new PersistentOrderedMapBuilder(this);
    }

    @Override // java.util.Map, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    @NotNull
    public PersistentMap<K, V> clear() {
        return Companion.emptyOf$runtime_release();
    }

    @Override // kotlin.collections.d, java.util.Map
    public boolean containsKey(Object obj) {
        return this.hashMap.containsKey(obj);
    }

    @Override // kotlin.collections.d, java.util.Map
    public final /* bridge */ ImmutableSet<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // kotlin.collections.d, java.util.Map
    @Nullable
    public V get(Object obj) {
        LinkedValue<V> linkedValue = this.hashMap.get(obj);
        if (linkedValue != null) {
            return linkedValue.getValue();
        }
        return null;
    }

    @Override // kotlin.collections.d, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap
    @NotNull
    public ImmutableSet<Map.Entry<K, V>> getEntries() {
        return createEntries();
    }

    @Nullable
    public final Object getFirstKey$runtime_release() {
        return this.firstKey;
    }

    @NotNull
    public final PersistentHashMap<K, LinkedValue<V>> getHashMap$runtime_release() {
        return this.hashMap;
    }

    @Nullable
    public final Object getLastKey$runtime_release() {
        return this.lastKey;
    }

    @Override // kotlin.collections.d
    public int getSize() {
        return this.hashMap.size();
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

    @Override // kotlin.collections.d, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap
    @NotNull
    public final Set<Map.Entry<K, V>> getEntries() {
        return createEntries();
    }

    @Override // kotlin.collections.d, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap
    @NotNull
    public ImmutableSet<K> getKeys() {
        return new PersistentOrderedMapKeys(this);
    }

    @Override // kotlin.collections.d, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap
    @NotNull
    public ImmutableCollection<V> getValues() {
        return new PersistentOrderedMapValues(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.d, java.util.Map, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    @NotNull
    public PersistentOrderedMap<K, V> put(K k10, V v10) {
        if (isEmpty()) {
            return new PersistentOrderedMap<>(k10, k10, this.hashMap.put((Object) k10, new LinkedValue<>(v10)));
        }
        LinkedValue<V> linkedValue = this.hashMap.get(k10);
        if (linkedValue != null) {
            if (linkedValue.getValue() == v10) {
                return this;
            }
            return new PersistentOrderedMap<>(this.firstKey, this.lastKey, this.hashMap.put((Object) k10, linkedValue.withValue(v10)));
        }
        Object obj = this.lastKey;
        LinkedValue<V> linkedValue2 = this.hashMap.get(obj);
        t.f(linkedValue2);
        return new PersistentOrderedMap<>(this.firstKey, k10, this.hashMap.put(obj, linkedValue2.withNext(k10)).put((Object) k10, new LinkedValue(v10, obj)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // kotlin.collections.d, java.util.Map, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    @NotNull
    public PersistentOrderedMap<K, V> remove(K k10) {
        LinkedValue<V> linkedValue = this.hashMap.get(k10);
        if (linkedValue == null) {
            return this;
        }
        PersistentHashMap<K, LinkedValue<V>> persistentHashMapRemove = this.hashMap.remove((Object) k10);
        ?? r52 = persistentHashMapRemove;
        if (linkedValue.getHasPrevious()) {
            Object obj = persistentHashMapRemove.get(linkedValue.getPrevious());
            t.f(obj);
            r52 = (PersistentHashMap<K, LinkedValue<V>>) persistentHashMapRemove.put(linkedValue.getPrevious(), ((LinkedValue) obj).withNext(linkedValue.getNext()));
        }
        ?? Put = r52;
        if (linkedValue.getHasNext()) {
            Object obj2 = r52.get(linkedValue.getNext());
            t.f(obj2);
            Put = r52.put(linkedValue.getNext(), ((LinkedValue) obj2).withPrevious(linkedValue.getPrevious()));
        }
        return new PersistentOrderedMap<>(!linkedValue.getHasPrevious() ? linkedValue.getNext() : this.firstKey, !linkedValue.getHasNext() ? linkedValue.getPrevious() : this.lastKey, Put);
    }

    @Override // java.util.Map, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    @NotNull
    public PersistentOrderedMap<K, V> remove(K k10, V v10) {
        LinkedValue<V> linkedValue = this.hashMap.get(k10);
        if (linkedValue != null && t.d(linkedValue.getValue(), v10)) {
            return remove((Object) k10);
        }
        return this;
    }
}

package kotlin.collections;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AbstractMutableMap.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class g<K, V> extends AbstractMap<K, V> implements Map<K, V>, i9.e {
    protected g() {
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    public abstract Set getEntries();

    public /* bridge */ Set<Object> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Object> getValues() {
        return super.values();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return (Set<K>) getKeys();
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public abstract V put(K k10, V v10);

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<V> values() {
        return (Collection<V>) getValues();
    }
}

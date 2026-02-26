package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableCollection;
import java.util.Iterator;
import kotlin.collections.a;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PersistentHashMapContentViews.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentHashMapValues<K, V> extends a<V> implements ImmutableCollection<V> {

    @NotNull
    private final PersistentHashMap<K, V> map;

    public PersistentHashMapValues(@NotNull PersistentHashMap<K, V> map) {
        t.i(map, "map");
        this.map = map;
    }

    @Override // kotlin.collections.a, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.map.containsValue(obj);
    }

    @Override // kotlin.collections.a
    public int getSize() {
        return this.map.size();
    }

    @Override // kotlin.collections.a, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<V> iterator() {
        return new PersistentHashMapValuesIterator(this.map.getNode$runtime_release());
    }
}

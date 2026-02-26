package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import java.util.Iterator;
import kotlin.collections.i;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PersistentHashMapContentViews.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentHashMapKeys<K, V> extends i<K> implements ImmutableSet<K> {

    @NotNull
    private final PersistentHashMap<K, V> map;

    public PersistentHashMapKeys(@NotNull PersistentHashMap<K, V> map) {
        t.i(map, "map");
        this.map = map;
    }

    @Override // kotlin.collections.a, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // kotlin.collections.a
    public int getSize() {
        return this.map.size();
    }

    @Override // kotlin.collections.i, kotlin.collections.a, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<K> iterator() {
        return new PersistentHashMapKeysIterator(this.map.getNode$runtime_release());
    }
}

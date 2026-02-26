package androidx.compose.runtime.snapshots;

import i9.f;
import java.util.Set;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SnapshotStateMap.kt */
/* JADX INFO: loaded from: classes.dex */
abstract class SnapshotMapSet<K, V, E> implements Set<E>, f {

    @NotNull
    private final SnapshotStateMap<K, V> map;

    public SnapshotMapSet(@NotNull SnapshotStateMap<K, V> map) {
        t.i(map, "map");
        this.map = map;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.map.clear();
    }

    @NotNull
    public final SnapshotStateMap<K, V> getMap() {
        return this.map;
    }

    public int getSize() {
        return this.map.size();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return j.a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] array) {
        t.i(array, "array");
        return (T[]) j.b(this, array);
    }
}

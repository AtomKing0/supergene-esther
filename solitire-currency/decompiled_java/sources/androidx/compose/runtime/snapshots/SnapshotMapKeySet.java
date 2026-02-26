package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.h;
import v8.k0;

/* JADX INFO: compiled from: SnapshotStateMap.kt */
/* JADX INFO: loaded from: classes.dex */
final class SnapshotMapKeySet<K, V> extends SnapshotMapSet<K, V, K> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapshotMapKeySet(@NotNull SnapshotStateMap<K, V> map) {
        super(map);
        t.i(map, "map");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return ((Boolean) add(obj)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return ((Boolean) addAll(collection)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return getMap().containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        t.i(elements, "elements");
        Collection<? extends Object> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!getMap().containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        return getMap().remove(obj) != null;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        t.i(elements, "elements");
        Iterator<T> it = elements.iterator();
        while (true) {
            boolean z10 = false;
            while (it.hasNext()) {
                if (getMap().remove(it.next()) != null || z10) {
                    z10 = true;
                }
            }
            return z10;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        PersistentMap<K, V> map$runtime_release;
        int modification$runtime_release;
        boolean z10;
        Snapshot current;
        t.i(elements, "elements");
        Set setT0 = d0.T0(elements);
        SnapshotStateMap<K, V> map = getMap();
        boolean z11 = false;
        do {
            synchronized (SnapshotStateMapKt.sync) {
                SnapshotStateMap.StateMapStateRecord stateMapStateRecord = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.current((SnapshotStateMap.StateMapStateRecord) map.getFirstStateRecord(), Snapshot.Companion.getCurrent());
                map$runtime_release = stateMapStateRecord.getMap$runtime_release();
                modification$runtime_release = stateMapStateRecord.getModification$runtime_release();
                k0 k0Var = k0.f35197a;
            }
            t.f(map$runtime_release);
            PersistentMap.Builder<K, V> builder = map$runtime_release.builder();
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            while (true) {
                z10 = true;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<K, V> next = it.next();
                if (!setT0.contains(next.getKey())) {
                    builder.remove(next.getKey());
                    z11 = true;
                }
            }
            k0 k0Var2 = k0.f35197a;
            PersistentMap<K, V> persistentMapBuild = builder.build();
            if (t.d(persistentMapBuild, map$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateMapKt.sync) {
                SnapshotStateMap.StateMapStateRecord stateMapStateRecord2 = (SnapshotStateMap.StateMapStateRecord) map.getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    SnapshotStateMap.StateMapStateRecord stateMapStateRecord3 = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, map, current);
                    if (stateMapStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateMapStateRecord3.setMap$runtime_release(persistentMapBuild);
                        stateMapStateRecord3.setModification$runtime_release(stateMapStateRecord3.getModification$runtime_release() + 1);
                    } else {
                        z10 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, map);
            }
        } while (!z10);
        return z11;
    }

    @Override // java.util.Set, java.util.Collection
    @NotNull
    public Void add(K k10) {
        SnapshotStateMapKt.unsupported();
        throw new h();
    }

    @Override // java.util.Set, java.util.Collection
    @NotNull
    public Void addAll(@NotNull Collection<? extends K> elements) {
        t.i(elements, "elements");
        SnapshotStateMapKt.unsupported();
        throw new h();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    @NotNull
    public StateMapMutableKeysIterator<K, V> iterator() {
        return new StateMapMutableKeysIterator<>(getMap(), ((ImmutableSet) getMap().getReadable$runtime_release().getMap$runtime_release().entrySet()).iterator());
    }
}

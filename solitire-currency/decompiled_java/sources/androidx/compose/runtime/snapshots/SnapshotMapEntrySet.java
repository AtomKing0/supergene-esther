package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.q0;
import kotlin.collections.w;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.t0;
import n9.o;
import org.jetbrains.annotations.NotNull;
import v8.h;
import v8.k0;
import v8.s;
import v8.y;

/* JADX INFO: compiled from: SnapshotStateMap.kt */
/* JADX INFO: loaded from: classes.dex */
final class SnapshotMapEntrySet<K, V> extends SnapshotMapSet<K, V, Map.Entry<K, V>> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapshotMapEntrySet(@NotNull SnapshotStateMap<K, V> map) {
        super(map);
        t.i(map, "map");
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return ((Boolean) add((Map.Entry) obj)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return ((Boolean) addAll(collection)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (t0.o(obj)) {
            return contains((Map.Entry) obj);
        }
        return false;
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
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<Map.Entry<K, V>> iterator() {
        return new StateMapMutableEntriesIterator(getMap(), ((ImmutableSet) getMap().getReadable$runtime_release().getMap$runtime_release().entrySet()).iterator());
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean remove(Object obj) {
        if (t0.o(obj)) {
            return remove((Map.Entry) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        t.i(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        while (true) {
            boolean z10 = false;
            while (it.hasNext()) {
                if (getMap().remove(((Map.Entry) it.next()).getKey()) != null || z10) {
                    z10 = true;
                }
            }
            return z10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        PersistentMap<K, V> map$runtime_release;
        int modification$runtime_release;
        boolean z10;
        Snapshot current;
        t.i(elements, "elements");
        Collection<? extends Object> collection = elements;
        LinkedHashMap linkedHashMap = new LinkedHashMap(o.e(q0.d(w.v(collection, 10)), 16));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            s sVarA = y.a(entry.getKey(), entry.getValue());
            linkedHashMap.put(sVarA.c(), sVarA.d());
        }
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
            Iterator<Map.Entry<K, V>> it2 = map.entrySet().iterator();
            while (true) {
                z10 = true;
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry<K, V> next = it2.next();
                if ((linkedHashMap.containsKey(next.getKey()) && t.d(linkedHashMap.get(next.getKey()), next.getValue())) ? false : true) {
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

    @NotNull
    public Void add(@NotNull Map.Entry<K, V> element) {
        t.i(element, "element");
        SnapshotStateMapKt.unsupported();
        throw new h();
    }

    @Override // java.util.Set, java.util.Collection
    @NotNull
    public Void addAll(@NotNull Collection<? extends Map.Entry<K, V>> elements) {
        t.i(elements, "elements");
        SnapshotStateMapKt.unsupported();
        throw new h();
    }

    public boolean contains(@NotNull Map.Entry<K, V> element) {
        t.i(element, "element");
        return t.d(getMap().get(element.getKey()), element.getValue());
    }

    public boolean remove(@NotNull Map.Entry<K, V> element) {
        t.i(element, "element");
        return getMap().remove(element.getKey()) != null;
    }
}

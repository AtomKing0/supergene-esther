package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.Stable;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.snapshots.Snapshot;
import h9.l;
import i9.e;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SnapshotStateMap.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public final class SnapshotStateMap<K, V> implements Map<K, V>, StateObject, e {

    @NotNull
    private StateRecord firstStateRecord = new StateMapStateRecord(ExtensionsKt.persistentHashMapOf());

    @NotNull
    private final Set<Map.Entry<K, V>> entries = new SnapshotMapEntrySet(this);

    @NotNull
    private final Set<K> keys = new SnapshotMapKeySet(this);

    @NotNull
    private final Collection<V> values = new SnapshotMapValueSet(this);

    /* JADX INFO: compiled from: SnapshotStateMap.kt */
    public static final class StateMapStateRecord<K, V> extends StateRecord {

        @NotNull
        private PersistentMap<K, ? extends V> map;
        private int modification;

        public StateMapStateRecord(@NotNull PersistentMap<K, ? extends V> map) {
            t.i(map, "map");
            this.map = map;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(@NotNull StateRecord value) {
            t.i(value, "value");
            StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) value;
            synchronized (SnapshotStateMapKt.sync) {
                this.map = stateMapStateRecord.map;
                this.modification = stateMapStateRecord.modification;
                k0 k0Var = k0.f35197a;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        @NotNull
        public StateRecord create() {
            return new StateMapStateRecord(this.map);
        }

        @NotNull
        public final PersistentMap<K, V> getMap$runtime_release() {
            return this.map;
        }

        public final int getModification$runtime_release() {
            return this.modification;
        }

        public final void setMap$runtime_release(@NotNull PersistentMap<K, ? extends V> persistentMap) {
            t.i(persistentMap, "<set-?>");
            this.map = persistentMap;
        }

        public final void setModification$runtime_release(int i10) {
            this.modification = i10;
        }
    }

    private final <R> R mutate(l<? super Map<K, V>, ? extends R> lVar) {
        Snapshot.Companion companion;
        PersistentMap<K, V> map$runtime_release;
        int modification$runtime_release;
        R rInvoke;
        Snapshot current;
        boolean z10;
        do {
            synchronized (SnapshotStateMapKt.sync) {
                try {
                    StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) getFirstStateRecord();
                    companion = Snapshot.Companion;
                    StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.current(stateMapStateRecord, companion.getCurrent());
                    map$runtime_release = stateMapStateRecord2.getMap$runtime_release();
                    modification$runtime_release = stateMapStateRecord2.getModification$runtime_release();
                    k0 k0Var = k0.f35197a;
                    r.b(1);
                } catch (Throwable th) {
                    r.b(1);
                    r.a(1);
                    throw th;
                }
            }
            r.a(1);
            t.f(map$runtime_release);
            PersistentMap.Builder<K, V> builder = map$runtime_release.builder();
            rInvoke = lVar.invoke(builder);
            PersistentMap<K, V> persistentMapBuild = builder.build();
            if (t.d(persistentMapBuild, map$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateMapKt.sync) {
                try {
                    StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) getFirstStateRecord();
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        try {
                            current = companion.getCurrent();
                            StateMapStateRecord stateMapStateRecord4 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord3, this, current);
                            if (stateMapStateRecord4.getModification$runtime_release() == modification$runtime_release) {
                                stateMapStateRecord4.setMap$runtime_release(persistentMapBuild);
                                stateMapStateRecord4.setModification$runtime_release(stateMapStateRecord4.getModification$runtime_release() + 1);
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            r.b(1);
                        } finally {
                        }
                    }
                    r.a(1);
                    SnapshotKt.notifyWrite(current, this);
                    r.b(1);
                } catch (Throwable th2) {
                    r.b(1);
                    r.a(1);
                    throw th2;
                }
            }
            r.a(1);
        } while (!z10);
        return rInvoke;
    }

    private final void update(l<? super PersistentMap<K, ? extends V>, ? extends PersistentMap<K, ? extends V>> lVar) {
        Snapshot current;
        StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) getFirstStateRecord();
        Snapshot.Companion companion = Snapshot.Companion;
        StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.current(stateMapStateRecord, companion.getCurrent());
        PersistentMap<K, ? extends V> persistentMapInvoke = lVar.invoke(stateMapStateRecord2.getMap$runtime_release());
        if (persistentMapInvoke != stateMapStateRecord2.getMap$runtime_release()) {
            synchronized (SnapshotStateMapKt.sync) {
                try {
                    StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) getFirstStateRecord();
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        try {
                            current = companion.getCurrent();
                            StateMapStateRecord stateMapStateRecord4 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord3, this, current);
                            stateMapStateRecord4.setMap$runtime_release(persistentMapInvoke);
                            stateMapStateRecord4.setModification$runtime_release(stateMapStateRecord4.getModification$runtime_release() + 1);
                            r.b(1);
                        } catch (Throwable th) {
                            r.b(1);
                            r.a(1);
                            throw th;
                        }
                    }
                    r.a(1);
                    SnapshotKt.notifyWrite(current, this);
                    r.b(1);
                } catch (Throwable th2) {
                    r.b(1);
                    r.a(1);
                    throw th2;
                }
            }
            r.a(1);
        }
    }

    private final <R> R withCurrent(l<? super StateMapStateRecord<K, V>, ? extends R> lVar) {
        return lVar.invoke(SnapshotKt.current((StateMapStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent()));
    }

    private final <R> R writable(l<? super StateMapStateRecord<K, V>, ? extends R> lVar) {
        Snapshot current;
        R rInvoke;
        StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) getFirstStateRecord();
        SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                rInvoke = lVar.invoke(SnapshotKt.writableRecord(stateMapStateRecord, this, current));
                r.b(1);
            } catch (Throwable th) {
                r.b(1);
                r.a(1);
                throw th;
            }
        }
        r.a(1);
        SnapshotKt.notifyWrite(current, this);
        return rInvoke;
    }

    public final boolean all$runtime_release(@NotNull l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        t.i(predicate, "predicate");
        Iterator<E> it = ((ImmutableSet) getReadable$runtime_release().getMap$runtime_release().entrySet()).iterator();
        while (it.hasNext()) {
            if (!predicate.invoke((Map.Entry) it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public final boolean any$runtime_release(@NotNull l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        t.i(predicate, "predicate");
        Iterator<E> it = ((ImmutableSet) getReadable$runtime_release().getMap$runtime_release().entrySet()).iterator();
        while (it.hasNext()) {
            if (predicate.invoke((Map.Entry) it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public void clear() {
        Snapshot current;
        StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) getFirstStateRecord();
        Snapshot.Companion companion = Snapshot.Companion;
        StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.current(stateMapStateRecord, companion.getCurrent());
        stateMapStateRecord2.getMap$runtime_release();
        PersistentMap<K, V> persistentMapPersistentHashMapOf = ExtensionsKt.persistentHashMapOf();
        if (persistentMapPersistentHashMapOf != stateMapStateRecord2.getMap$runtime_release()) {
            synchronized (SnapshotStateMapKt.sync) {
                StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateMapStateRecord stateMapStateRecord4 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord3, this, current);
                    stateMapStateRecord4.setMap$runtime_release(persistentMapPersistentHashMapOf);
                    stateMapStateRecord4.setModification$runtime_release(stateMapStateRecord4.getModification$runtime_release() + 1);
                }
                SnapshotKt.notifyWrite(current, this);
            }
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return getReadable$runtime_release().getMap$runtime_release().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return getReadable$runtime_release().getMap$runtime_release().containsValue(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    @Nullable
    public V get(Object obj) {
        return getReadable$runtime_release().getMap$runtime_release().get(obj);
    }

    @NotNull
    public final Map<K, V> getDebuggerDisplayValue() {
        return ((StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent())).getMap$runtime_release();
    }

    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        return this.entries;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    @NotNull
    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    @NotNull
    public Set<K> getKeys() {
        return this.keys;
    }

    public final int getModification$runtime_release() {
        return getReadable$runtime_release().getModification$runtime_release();
    }

    @NotNull
    public final StateMapStateRecord<K, V> getReadable$runtime_release() {
        return (StateMapStateRecord) SnapshotKt.readable((StateMapStateRecord) getFirstStateRecord(), this);
    }

    public int getSize() {
        return getReadable$runtime_release().getMap$runtime_release().size();
    }

    @NotNull
    public Collection<V> getValues() {
        return this.values;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return getReadable$runtime_release().getMap$runtime_release().isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public /* synthetic */ StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return a.a(this, stateRecord, stateRecord2, stateRecord3);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(@NotNull StateRecord value) {
        t.i(value, "value");
        this.firstStateRecord = (StateMapStateRecord) value;
    }

    @Override // java.util.Map
    @Nullable
    public V put(K k10, V v10) {
        Snapshot.Companion companion;
        PersistentMap<K, V> map$runtime_release;
        int modification$runtime_release;
        V vPut;
        Snapshot current;
        boolean z10;
        do {
            synchronized (SnapshotStateMapKt.sync) {
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) getFirstStateRecord();
                companion = Snapshot.Companion;
                StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.current(stateMapStateRecord, companion.getCurrent());
                map$runtime_release = stateMapStateRecord2.getMap$runtime_release();
                modification$runtime_release = stateMapStateRecord2.getModification$runtime_release();
                k0 k0Var = k0.f35197a;
            }
            t.f(map$runtime_release);
            PersistentMap.Builder<K, V> builder = map$runtime_release.builder();
            vPut = builder.put(k10, v10);
            PersistentMap<K, V> persistentMapBuild = builder.build();
            if (t.d(persistentMapBuild, map$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateMapKt.sync) {
                StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateMapStateRecord stateMapStateRecord4 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord3, this, current);
                    if (stateMapStateRecord4.getModification$runtime_release() == modification$runtime_release) {
                        stateMapStateRecord4.setMap$runtime_release(persistentMapBuild);
                        z10 = true;
                        stateMapStateRecord4.setModification$runtime_release(stateMapStateRecord4.getModification$runtime_release() + 1);
                    } else {
                        z10 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z10);
        return vPut;
    }

    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends K, ? extends V> from) {
        Snapshot.Companion companion;
        PersistentMap<K, V> map$runtime_release;
        int modification$runtime_release;
        Snapshot current;
        boolean z10;
        t.i(from, "from");
        do {
            synchronized (SnapshotStateMapKt.sync) {
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) getFirstStateRecord();
                companion = Snapshot.Companion;
                StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.current(stateMapStateRecord, companion.getCurrent());
                map$runtime_release = stateMapStateRecord2.getMap$runtime_release();
                modification$runtime_release = stateMapStateRecord2.getModification$runtime_release();
                k0 k0Var = k0.f35197a;
            }
            t.f(map$runtime_release);
            PersistentMap.Builder<K, V> builder = map$runtime_release.builder();
            builder.putAll(from);
            PersistentMap<K, V> persistentMapBuild = builder.build();
            if (t.d(persistentMapBuild, map$runtime_release)) {
                return;
            }
            synchronized (SnapshotStateMapKt.sync) {
                StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateMapStateRecord stateMapStateRecord4 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord3, this, current);
                    if (stateMapStateRecord4.getModification$runtime_release() == modification$runtime_release) {
                        stateMapStateRecord4.setMap$runtime_release(persistentMapBuild);
                        z10 = true;
                        stateMapStateRecord4.setModification$runtime_release(stateMapStateRecord4.getModification$runtime_release() + 1);
                    } else {
                        z10 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z10);
    }

    @Override // java.util.Map
    @Nullable
    public V remove(Object obj) {
        Snapshot.Companion companion;
        PersistentMap<K, V> map$runtime_release;
        int modification$runtime_release;
        V vRemove;
        Snapshot current;
        boolean z10;
        do {
            synchronized (SnapshotStateMapKt.sync) {
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) getFirstStateRecord();
                companion = Snapshot.Companion;
                StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.current(stateMapStateRecord, companion.getCurrent());
                map$runtime_release = stateMapStateRecord2.getMap$runtime_release();
                modification$runtime_release = stateMapStateRecord2.getModification$runtime_release();
                k0 k0Var = k0.f35197a;
            }
            t.f(map$runtime_release);
            PersistentMap.Builder<K, V> builder = map$runtime_release.builder();
            vRemove = builder.remove(obj);
            PersistentMap<K, V> persistentMapBuild = builder.build();
            if (t.d(persistentMapBuild, map$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateMapKt.sync) {
                StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateMapStateRecord stateMapStateRecord4 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord3, this, current);
                    if (stateMapStateRecord4.getModification$runtime_release() == modification$runtime_release) {
                        stateMapStateRecord4.setMap$runtime_release(persistentMapBuild);
                        z10 = true;
                        stateMapStateRecord4.setModification$runtime_release(stateMapStateRecord4.getModification$runtime_release() + 1);
                    } else {
                        z10 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z10);
        return vRemove;
    }

    public final boolean removeIf$runtime_release(@NotNull l<? super Map.Entry<K, V>, Boolean> predicate) {
        PersistentMap<K, V> map$runtime_release;
        int modification$runtime_release;
        Snapshot current;
        boolean z10;
        t.i(predicate, "predicate");
        boolean z11 = false;
        do {
            synchronized (SnapshotStateMapKt.sync) {
                try {
                    StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent());
                    map$runtime_release = stateMapStateRecord.getMap$runtime_release();
                    modification$runtime_release = stateMapStateRecord.getModification$runtime_release();
                    k0 k0Var = k0.f35197a;
                    r.b(1);
                } catch (Throwable th) {
                    r.b(1);
                    r.a(1);
                    throw th;
                }
            }
            r.a(1);
            t.f(map$runtime_release);
            PersistentMap.Builder<K, V> builder = map$runtime_release.builder();
            for (Map.Entry<K, V> entry : entrySet()) {
                if (predicate.invoke(entry).booleanValue()) {
                    builder.remove(entry.getKey());
                    z11 = true;
                }
            }
            k0 k0Var2 = k0.f35197a;
            PersistentMap<K, V> persistentMapBuild = builder.build();
            if (t.d(persistentMapBuild, map$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateMapKt.sync) {
                try {
                    StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) getFirstStateRecord();
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        try {
                            current = Snapshot.Companion.getCurrent();
                            StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, this, current);
                            if (stateMapStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                                stateMapStateRecord3.setMap$runtime_release(persistentMapBuild);
                                stateMapStateRecord3.setModification$runtime_release(stateMapStateRecord3.getModification$runtime_release() + 1);
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            r.b(1);
                        } finally {
                        }
                    }
                    r.a(1);
                    SnapshotKt.notifyWrite(current, this);
                    r.b(1);
                } catch (Throwable th2) {
                    r.b(1);
                    r.a(1);
                    throw th2;
                }
            }
            r.a(1);
        } while (!z10);
        return z11;
    }

    public final boolean removeValue$runtime_release(V v10) {
        Object next;
        Iterator<T> it = entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (t.d(((Map.Entry) next).getValue(), v10)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry == null) {
            return false;
        }
        remove(entry.getKey());
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime_release$annotations() {
    }
}

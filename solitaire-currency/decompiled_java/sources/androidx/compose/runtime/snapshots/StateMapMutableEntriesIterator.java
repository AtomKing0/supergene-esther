package androidx.compose.runtime.snapshots;

import i9.e;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SnapshotStateMap.kt */
/* JADX INFO: loaded from: classes.dex */
final class StateMapMutableEntriesIterator<K, V> extends StateMapMutableIterator<K, V> implements Iterator<Map.Entry<K, V>>, i9.a {

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.StateMapMutableEntriesIterator$next$1, reason: invalid class name */
    /* JADX INFO: compiled from: SnapshotStateMap.kt */
    public static final class AnonymousClass1 implements Map.Entry<K, V>, e.a {
        private final K key;
        final /* synthetic */ StateMapMutableEntriesIterator<K, V> this$0;
        private V value;

        AnonymousClass1(StateMapMutableEntriesIterator<K, V> stateMapMutableEntriesIterator) {
            this.this$0 = stateMapMutableEntriesIterator;
            Map.Entry<K, V> current = stateMapMutableEntriesIterator.getCurrent();
            t.f(current);
            this.key = current.getKey();
            Map.Entry<K, V> current2 = stateMapMutableEntriesIterator.getCurrent();
            t.f(current2);
            this.value = current2.getValue();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public void setValue(V v10) {
            this.value = v10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            StateMapMutableEntriesIterator<K, V> stateMapMutableEntriesIterator = this.this$0;
            if (stateMapMutableEntriesIterator.getMap().getModification$runtime_release() != ((StateMapMutableIterator) stateMapMutableEntriesIterator).modification) {
                throw new ConcurrentModificationException();
            }
            V v11 = (V) getValue();
            stateMapMutableEntriesIterator.getMap().put(getKey(), v10);
            setValue((Object) v10);
            return v11;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateMapMutableEntriesIterator(@NotNull SnapshotStateMap<K, V> map, @NotNull Iterator<? extends Map.Entry<? extends K, ? extends V>> iterator) {
        super(map, iterator);
        t.i(map, "map");
        t.i(iterator, "iterator");
    }

    @Override // java.util.Iterator
    @NotNull
    public Map.Entry<K, V> next() {
        advance();
        if (getCurrent() != null) {
            return new AnonymousClass1(this);
        }
        throw new IllegalStateException();
    }
}

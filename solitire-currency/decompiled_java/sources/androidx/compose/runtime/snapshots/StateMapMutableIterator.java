package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SnapshotStateMap.kt */
/* JADX INFO: loaded from: classes.dex */
abstract class StateMapMutableIterator<K, V> {

    @Nullable
    private Map.Entry<? extends K, ? extends V> current;

    @NotNull
    private final Iterator<Map.Entry<K, V>> iterator;

    @NotNull
    private final SnapshotStateMap<K, V> map;
    private int modification;

    @Nullable
    private Map.Entry<? extends K, ? extends V> next;

    /* JADX WARN: Multi-variable type inference failed */
    public StateMapMutableIterator(@NotNull SnapshotStateMap<K, V> map, @NotNull Iterator<? extends Map.Entry<? extends K, ? extends V>> iterator) {
        t.i(map, "map");
        t.i(iterator, "iterator");
        this.map = map;
        this.iterator = iterator;
        this.modification = map.getModification$runtime_release();
        advance();
    }

    protected final void advance() {
        this.current = this.next;
        this.next = this.iterator.hasNext() ? this.iterator.next() : null;
    }

    @Nullable
    protected final Map.Entry<K, V> getCurrent() {
        return this.current;
    }

    @NotNull
    public final Iterator<Map.Entry<K, V>> getIterator() {
        return this.iterator;
    }

    @NotNull
    public final SnapshotStateMap<K, V> getMap() {
        return this.map;
    }

    protected final int getModification() {
        return this.modification;
    }

    @Nullable
    protected final Map.Entry<K, V> getNext() {
        return this.next;
    }

    public final boolean hasNext() {
        return this.next != null;
    }

    protected final <T> T modify(@NotNull h9.a<? extends T> block) {
        t.i(block, "block");
        if (getMap().getModification$runtime_release() != this.modification) {
            throw new ConcurrentModificationException();
        }
        T tInvoke = block.invoke();
        this.modification = getMap().getModification$runtime_release();
        return tInvoke;
    }

    public final void remove() {
        if (getMap().getModification$runtime_release() != this.modification) {
            throw new ConcurrentModificationException();
        }
        Map.Entry<? extends K, ? extends V> entry = this.current;
        if (entry == null) {
            throw new IllegalStateException();
        }
        this.map.remove(entry.getKey());
        this.current = null;
        k0 k0Var = k0.f35197a;
        this.modification = getMap().getModification$runtime_release();
    }

    protected final void setCurrent(@Nullable Map.Entry<? extends K, ? extends V> entry) {
        this.current = entry;
    }

    protected final void setModification(int i10) {
        this.modification = i10;
    }

    protected final void setNext(@Nullable Map.Entry<? extends K, ? extends V> entry) {
        this.next = entry;
    }
}

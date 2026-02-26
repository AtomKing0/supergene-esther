package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import i9.a;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PersistentOrderedSetIterator.kt */
/* JADX INFO: loaded from: classes.dex */
public class PersistentOrderedSetIterator<E> implements Iterator<E>, a {
    private int index;

    @NotNull
    private final Map<E, Links> map;

    @Nullable
    private Object nextElement;

    public PersistentOrderedSetIterator(@Nullable Object obj, @NotNull Map<E, Links> map) {
        t.i(map, "map");
        this.nextElement = obj;
        this.map = map;
    }

    private final void checkHasNext() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    public final int getIndex$runtime_release() {
        return this.index;
    }

    @NotNull
    public final Map<E, Links> getMap$runtime_release() {
        return this.map;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.map.size();
    }

    @Override // java.util.Iterator
    public E next() {
        checkHasNext();
        E e10 = (E) this.nextElement;
        this.index++;
        Links links = this.map.get(e10);
        if (links != null) {
            this.nextElement = links.getNext();
            return e10;
        }
        throw new ConcurrentModificationException("Hash code of an element (" + e10 + ") has changed after it was added to the persistent set.");
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex$runtime_release(int i10) {
        this.index = i10;
    }
}

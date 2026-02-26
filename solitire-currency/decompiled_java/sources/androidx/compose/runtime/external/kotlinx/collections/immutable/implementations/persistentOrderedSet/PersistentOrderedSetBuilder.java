package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Iterator;
import kotlin.collections.h;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PersistentOrderedSetBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentOrderedSetBuilder<E> extends h<E> implements PersistentSet.Builder<E> {

    @Nullable
    private Object firstElement;

    @NotNull
    private final PersistentHashMapBuilder<E, Links> hashMapBuilder;

    @Nullable
    private Object lastElement;

    @NotNull
    private PersistentOrderedSet<E> set;

    public PersistentOrderedSetBuilder(@NotNull PersistentOrderedSet<E> set) {
        t.i(set, "set");
        this.set = set;
        this.firstElement = set.getFirstElement$runtime_release();
        this.lastElement = this.set.getLastElement$runtime_release();
        this.hashMapBuilder = this.set.getHashMap$runtime_release().builder();
    }

    @Override // kotlin.collections.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e10) {
        if (this.hashMapBuilder.containsKey(e10)) {
            return false;
        }
        if (isEmpty()) {
            this.firstElement = e10;
            this.lastElement = e10;
            this.hashMapBuilder.put(e10, new Links());
            return true;
        }
        Links links = this.hashMapBuilder.get(this.lastElement);
        t.f(links);
        this.hashMapBuilder.put(this.lastElement, links.withNext(e10));
        this.hashMapBuilder.put(e10, new Links(this.lastElement));
        this.lastElement = e10;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.hashMapBuilder.clear();
        EndOfChain endOfChain = EndOfChain.INSTANCE;
        this.firstElement = endOfChain;
        this.lastElement = endOfChain;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.hashMapBuilder.containsKey(obj);
    }

    @Nullable
    public final Object getFirstElement$runtime_release() {
        return this.firstElement;
    }

    @NotNull
    public final PersistentHashMapBuilder<E, Links> getHashMapBuilder$runtime_release() {
        return this.hashMapBuilder;
    }

    @Override // kotlin.collections.h
    public int getSize() {
        return this.hashMapBuilder.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @NotNull
    public Iterator<E> iterator() {
        return new PersistentOrderedSetMutableIterator(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        Links linksRemove = this.hashMapBuilder.remove(obj);
        if (linksRemove == null) {
            return false;
        }
        if (linksRemove.getHasPrevious()) {
            Links links = this.hashMapBuilder.get(linksRemove.getPrevious());
            t.f(links);
            this.hashMapBuilder.put(linksRemove.getPrevious(), links.withNext(linksRemove.getNext()));
        } else {
            this.firstElement = linksRemove.getNext();
        }
        if (!linksRemove.getHasNext()) {
            this.lastElement = linksRemove.getPrevious();
            return true;
        }
        Links links2 = this.hashMapBuilder.get(linksRemove.getNext());
        t.f(links2);
        this.hashMapBuilder.put(linksRemove.getNext(), links2.withPrevious(linksRemove.getPrevious()));
        return true;
    }

    public final void setFirstElement$runtime_release(@Nullable Object obj) {
        this.firstElement = obj;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder
    @NotNull
    public PersistentSet<E> build() {
        PersistentOrderedSet<E> persistentOrderedSet;
        PersistentHashMap<E, Links> persistentHashMapBuild = this.hashMapBuilder.build();
        if (persistentHashMapBuild == this.set.getHashMap$runtime_release()) {
            CommonFunctionsKt.m1270assert(this.firstElement == this.set.getFirstElement$runtime_release());
            CommonFunctionsKt.m1270assert(this.lastElement == this.set.getLastElement$runtime_release());
            persistentOrderedSet = this.set;
        } else {
            persistentOrderedSet = new PersistentOrderedSet<>(this.firstElement, this.lastElement, persistentHashMapBuild);
        }
        this.set = persistentOrderedSet;
        return persistentOrderedSet;
    }
}

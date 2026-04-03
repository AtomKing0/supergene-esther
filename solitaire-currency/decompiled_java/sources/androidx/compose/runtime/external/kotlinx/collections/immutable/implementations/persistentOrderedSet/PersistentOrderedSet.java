package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import h9.l;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.a0;
import kotlin.collections.i;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PersistentOrderedSet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentOrderedSet<E> extends i<E> implements PersistentSet<E> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final PersistentOrderedSet EMPTY;

    @Nullable
    private final Object firstElement;

    @NotNull
    private final PersistentHashMap<E, Links> hashMap;

    @Nullable
    private final Object lastElement;

    /* JADX INFO: compiled from: PersistentOrderedSet.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final <E> PersistentSet<E> emptyOf$runtime_release() {
            return PersistentOrderedSet.EMPTY;
        }
    }

    static {
        EndOfChain endOfChain = EndOfChain.INSTANCE;
        EMPTY = new PersistentOrderedSet(endOfChain, endOfChain, PersistentHashMap.Companion.emptyOf$runtime_release());
    }

    public PersistentOrderedSet(@Nullable Object obj, @Nullable Object obj2, @NotNull PersistentHashMap<E, Links> hashMap) {
        t.i(hashMap, "hashMap");
        this.firstElement = obj;
        this.lastElement = obj2;
        this.hashMap = hashMap;
    }

    @Override // kotlin.collections.a, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.hashMap.containsKey(obj);
    }

    @Nullable
    public final Object getFirstElement$runtime_release() {
        return this.firstElement;
    }

    @NotNull
    public final PersistentHashMap<E, Links> getHashMap$runtime_release() {
        return this.hashMap;
    }

    @Nullable
    public final Object getLastElement$runtime_release() {
        return this.lastElement;
    }

    @Override // kotlin.collections.a
    public int getSize() {
        return this.hashMap.size();
    }

    @Override // kotlin.collections.i, kotlin.collections.a, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<E> iterator() {
        return new PersistentOrderedSetIterator(this.firstElement, this.hashMap);
    }

    @Override // java.util.Collection, java.util.Set, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentSet<E> add(E e10) {
        if (this.hashMap.containsKey(e10)) {
            return this;
        }
        if (isEmpty()) {
            return new PersistentOrderedSet(e10, e10, this.hashMap.put(e10, new Links()));
        }
        Object obj = this.lastElement;
        Links links = this.hashMap.get(obj);
        t.f(links);
        return new PersistentOrderedSet(this.firstElement, e10, this.hashMap.put(obj, links.withNext(e10)).put(e10, new Links(obj)));
    }

    @Override // java.util.Collection, java.util.Set, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentSet<E> addAll(@NotNull Collection<? extends E> elements) {
        t.i(elements, "elements");
        PersistentSet.Builder<E> builder = builder();
        builder.addAll(elements);
        return builder.build();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentSet.Builder<E> builder() {
        return new PersistentOrderedSetBuilder(this);
    }

    @Override // java.util.Collection, java.util.Set, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentSet<E> clear() {
        return Companion.emptyOf$runtime_release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.Set, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentSet<E> remove(E e10) {
        Links links = this.hashMap.get(e10);
        if (links == null) {
            return this;
        }
        PersistentHashMap persistentHashMapRemove = this.hashMap.remove(e10);
        if (links.getHasPrevious()) {
            V v10 = persistentHashMapRemove.get(links.getPrevious());
            t.f(v10);
            persistentHashMapRemove = persistentHashMapRemove.put(links.getPrevious(), ((Links) v10).withNext(links.getNext()));
        }
        if (links.getHasNext()) {
            V v11 = persistentHashMapRemove.get(links.getNext());
            t.f(v11);
            persistentHashMapRemove = persistentHashMapRemove.put(links.getNext(), ((Links) v11).withPrevious(links.getPrevious()));
        }
        return new PersistentOrderedSet(!links.getHasPrevious() ? links.getNext() : this.firstElement, !links.getHasNext() ? links.getPrevious() : this.lastElement, persistentHashMapRemove);
    }

    @Override // java.util.Collection, java.util.Set, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentSet<E> retainAll(@NotNull Collection<? extends E> elements) {
        t.i(elements, "elements");
        PersistentSet.Builder<E> builder = builder();
        builder.retainAll(elements);
        return builder.build();
    }

    @Override // java.util.Collection, java.util.Set, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentSet<E> removeAll(@NotNull Collection<? extends E> elements) {
        t.i(elements, "elements");
        PersistentSet.Builder<E> builder = builder();
        builder.removeAll(elements);
        return builder.build();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentSet<E> removeAll(@NotNull l<? super E, Boolean> predicate) {
        t.i(predicate, "predicate");
        PersistentSet.Builder<E> builder = builder();
        a0.H(builder, predicate);
        return builder.build();
    }
}

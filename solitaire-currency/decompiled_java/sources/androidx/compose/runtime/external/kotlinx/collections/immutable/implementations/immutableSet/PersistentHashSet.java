package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import h9.l;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.a0;
import kotlin.collections.i;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PersistentHashSet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentHashSet<E> extends i<E> implements PersistentSet<E> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final PersistentHashSet EMPTY = new PersistentHashSet(TrieNode.Companion.getEMPTY$runtime_release(), 0);

    @NotNull
    private final TrieNode<E> node;
    private final int size;

    /* JADX INFO: compiled from: PersistentHashSet.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final <E> PersistentSet<E> emptyOf$runtime_release() {
            return PersistentHashSet.EMPTY;
        }
    }

    public PersistentHashSet(@NotNull TrieNode<E> node, int i10) {
        t.i(node, "node");
        this.node = node;
        this.size = i10;
    }

    @Override // kotlin.collections.a, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.node.contains(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    @Override // kotlin.collections.a, java.util.Collection, java.util.List
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        t.i(elements, "elements");
        return elements instanceof PersistentHashSet ? this.node.containsAll(((PersistentHashSet) elements).node, 0) : elements instanceof PersistentHashSetBuilder ? this.node.containsAll(((PersistentHashSetBuilder) elements).getNode$runtime_release(), 0) : super.containsAll(elements);
    }

    @NotNull
    public final TrieNode<E> getNode$runtime_release() {
        return this.node;
    }

    @Override // kotlin.collections.a
    public int getSize() {
        return this.size;
    }

    @Override // kotlin.collections.i, kotlin.collections.a, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<E> iterator() {
        return new PersistentHashSetIterator(this.node);
    }

    @Override // java.util.Collection, java.util.Set, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentSet<E> add(E e10) {
        TrieNode<E> trieNodeAdd = this.node.add(e10 != null ? e10.hashCode() : 0, e10, 0);
        return this.node == trieNodeAdd ? this : new PersistentHashSet(trieNodeAdd, size() + 1);
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
        return new PersistentHashSetBuilder(this);
    }

    @Override // java.util.Collection, java.util.Set, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentSet<E> clear() {
        return Companion.emptyOf$runtime_release();
    }

    @Override // java.util.Collection, java.util.Set, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentSet<E> remove(E e10) {
        TrieNode<E> trieNodeRemove = this.node.remove(e10 != null ? e10.hashCode() : 0, e10, 0);
        return this.node == trieNodeRemove ? this : new PersistentHashSet(trieNodeRemove, size() - 1);
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

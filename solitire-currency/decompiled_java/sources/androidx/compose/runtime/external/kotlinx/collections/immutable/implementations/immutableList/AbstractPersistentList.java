package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.a;
import h9.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.collections.c;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AbstractPersistentList.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractPersistentList<E> extends c<E> implements PersistentList<E> {

    /* JADX INFO: renamed from: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList$removeAll$1, reason: invalid class name */
    /* JADX INFO: compiled from: AbstractPersistentList.kt */
    static final class AnonymousClass1 extends v implements l<E, Boolean> {
        final /* synthetic */ Collection<E> $elements;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Collection<? extends E> collection) {
            super(1);
            this.$elements = collection;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.l
        @NotNull
        public final Boolean invoke(E e10) {
            return Boolean.valueOf(this.$elements.contains(e10));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList$retainAll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AbstractPersistentList.kt */
    static final class C09901 extends v implements l<E, Boolean> {
        final /* synthetic */ Collection<E> $elements;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09901(Collection<? extends E> collection) {
            super(1);
            this.$elements = collection;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.l
        @NotNull
        public final Boolean invoke(E e10) {
            return Boolean.valueOf(!this.$elements.contains(e10));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.a, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // kotlin.collections.a, java.util.Collection, java.util.List
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

    @Override // kotlin.collections.c, kotlin.collections.a, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<E> iterator() {
        return listIterator();
    }

    @Override // kotlin.collections.c, java.util.List
    @NotNull
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentList<E> addAll(@NotNull Collection<? extends E> elements) {
        t.i(elements, "elements");
        PersistentList.Builder<E> builder = builder();
        builder.addAll(elements);
        return builder.build();
    }

    @Override // java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentList<E> clear() {
        return UtilsKt.persistentVectorOf();
    }

    @Override // java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentList<E> remove(E e10) {
        int iIndexOf = indexOf(e10);
        return iIndexOf != -1 ? removeAt(iIndexOf) : this;
    }

    @Override // java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentList<E> removeAll(@NotNull Collection<? extends E> elements) {
        t.i(elements, "elements");
        return removeAll((l) new AnonymousClass1(elements));
    }

    @Override // java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentList<E> retainAll(@NotNull Collection<? extends E> elements) {
        t.i(elements, "elements");
        return removeAll((l) new C09901(elements));
    }

    @Override // kotlin.collections.c, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList
    @NotNull
    public ImmutableList<E> subList(int i10, int i11) {
        return a.a(this, i10, i11);
    }

    @Override // java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    @NotNull
    public PersistentList<E> addAll(int i10, @NotNull Collection<? extends E> c10) {
        t.i(c10, "c");
        PersistentList.Builder<E> builder = builder();
        builder.addAll(i10, c10);
        return builder.build();
    }
}

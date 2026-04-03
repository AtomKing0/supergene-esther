package kotlin.collections;

import com.ironsource.v8;
import java.util.Collection;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AbstractCollection.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a<E> implements Collection<E>, i9.a {

    /* JADX INFO: renamed from: kotlin.collections.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractCollection.kt */
    static final class C0602a extends kotlin.jvm.internal.v implements h9.l<E, CharSequence> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a<E> f29741g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0602a(a<? extends E> aVar) {
            super(1);
            this.f29741g = aVar;
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(E e10) {
            return e10 == this.f29741g ? "(this Collection)" : String.valueOf(e10);
        }
    }

    protected a() {
    }

    @Override // java.util.Collection
    public boolean add(E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean contains(E e10) {
        if (isEmpty()) {
            return false;
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.t.d(it.next(), e10)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.List
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
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

    public abstract int getSize();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public abstract Iterator<E> iterator();

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    @NotNull
    public Object[] toArray() {
        return kotlin.jvm.internal.j.a(this);
    }

    @NotNull
    public String toString() {
        return d0.r0(this, ", ", v8.i.f15837d, v8.i.f15839e, 0, null, new C0602a(this), 24, null);
    }

    @Override // java.util.Collection
    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        kotlin.jvm.internal.t.i(array, "array");
        return (T[]) kotlin.jvm.internal.j.b(this, array);
    }
}

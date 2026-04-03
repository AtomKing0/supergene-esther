package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AbstractList.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c<E> extends kotlin.collections.a<E> implements List<E> {

    @NotNull
    public static final a Companion = new a(null);

    /* JADX INFO: compiled from: AbstractList.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final void a(int i10, int i11, int i12) {
            if (i10 < 0 || i11 > i12) {
                throw new IndexOutOfBoundsException("startIndex: " + i10 + ", endIndex: " + i11 + ", size: " + i12);
            }
            if (i10 <= i11) {
                return;
            }
            throw new IllegalArgumentException("startIndex: " + i10 + " > endIndex: " + i11);
        }

        public final void b(int i10, int i11) {
            if (i10 < 0 || i10 >= i11) {
                throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
            }
        }

        public final void c(int i10, int i11) {
            if (i10 < 0 || i10 > i11) {
                throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
            }
        }

        public final void d(int i10, int i11, int i12) {
            if (i10 < 0 || i11 > i12) {
                throw new IndexOutOfBoundsException("fromIndex: " + i10 + ", toIndex: " + i11 + ", size: " + i12);
            }
            if (i10 <= i11) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i10 + " > toIndex: " + i11);
        }

        public final boolean e(@NotNull Collection<?> c10, @NotNull Collection<?> other) {
            kotlin.jvm.internal.t.i(c10, "c");
            kotlin.jvm.internal.t.i(other, "other");
            if (c10.size() != other.size()) {
                return false;
            }
            Iterator<?> it = other.iterator();
            Iterator<?> it2 = c10.iterator();
            while (it2.hasNext()) {
                if (!kotlin.jvm.internal.t.d(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int f(@NotNull Collection<?> c10) {
            kotlin.jvm.internal.t.i(c10, "c");
            Iterator<?> it = c10.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }
    }

    /* JADX INFO: compiled from: AbstractList.kt */
    private class b implements Iterator<E>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f29755a;

        public b() {
        }

        protected final int a() {
            return this.f29755a;
        }

        protected final void b(int i10) {
            this.f29755a = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f29755a < c.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            c<E> cVar = c.this;
            int i10 = this.f29755a;
            this.f29755a = i10 + 1;
            return cVar.get(i10);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractList.kt */
    private class C0603c extends c<E>.b implements ListIterator<E> {
        public C0603c(int i10) {
            super();
            c.Companion.c(i10, c.this.size());
            b(i10);
        }

        @Override // java.util.ListIterator
        public void add(E e10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            c<E> cVar = c.this;
            b(a() - 1);
            return cVar.get(a());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: compiled from: AbstractList.kt */
    private static final class d<E> extends c<E> implements RandomAccess {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final c<E> f29758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f29759b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f29760c;

        /* JADX WARN: Multi-variable type inference failed */
        public d(@NotNull c<? extends E> list, int i10, int i11) {
            kotlin.jvm.internal.t.i(list, "list");
            this.f29758a = list;
            this.f29759b = i10;
            c.Companion.d(i10, i11, list.size());
            this.f29760c = i11 - i10;
        }

        @Override // kotlin.collections.c, java.util.List
        public E get(int i10) {
            c.Companion.b(i10, this.f29760c);
            return this.f29758a.get(this.f29759b + i10);
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int getSize() {
            return this.f29760c;
        }
    }

    protected c() {
    }

    @Override // java.util.List
    public void add(int i10, E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return Companion.e(this, (Collection) obj);
        }
        return false;
    }

    public abstract E get(int i10);

    @Override // kotlin.collections.a
    public abstract int getSize();

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return Companion.f(this);
    }

    public int indexOf(E e10) {
        Iterator<E> it = iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (kotlin.jvm.internal.t.d(it.next(), e10)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @Override // kotlin.collections.a, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<E> iterator() {
        return new b();
    }

    public int lastIndexOf(E e10) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kotlin.jvm.internal.t.d(listIterator.previous(), e10)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @NotNull
    public ListIterator<E> listIterator() {
        return new C0603c(0);
    }

    @Override // java.util.List
    public E remove(int i10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public E set(int i10, E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @NotNull
    public List<E> subList(int i10, int i11) {
        return new d(this, i10, i11);
    }

    @NotNull
    public ListIterator<E> listIterator(int i10) {
        return new C0603c(i10);
    }
}

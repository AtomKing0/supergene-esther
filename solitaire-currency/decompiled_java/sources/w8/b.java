package w8;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.o;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ListBuilder.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b<E> extends kotlin.collections.f<E> implements RandomAccess, Serializable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final a f35466g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private static final b f35467h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private E[] f35468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f35469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f35470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f35471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final b<E> f35472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final b<E> f35473f;

    /* JADX INFO: compiled from: ListBuilder.kt */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: w8.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ListBuilder.kt */
    private static final class C0719b<E> implements ListIterator<E>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final b<E> f35474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f35475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f35476c;

        public C0719b(@NotNull b<E> list, int i10) {
            t.i(list, "list");
            this.f35474a = list;
            this.f35475b = i10;
            this.f35476c = -1;
        }

        @Override // java.util.ListIterator
        public void add(E e10) {
            b<E> bVar = this.f35474a;
            int i10 = this.f35475b;
            this.f35475b = i10 + 1;
            bVar.add(i10, e10);
            this.f35476c = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f35475b < ((b) this.f35474a).f35470c;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f35475b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.f35475b >= ((b) this.f35474a).f35470c) {
                throw new NoSuchElementException();
            }
            int i10 = this.f35475b;
            this.f35475b = i10 + 1;
            this.f35476c = i10;
            return (E) ((b) this.f35474a).f35468a[((b) this.f35474a).f35469b + this.f35476c];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f35475b;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i10 = this.f35475b;
            if (i10 <= 0) {
                throw new NoSuchElementException();
            }
            int i11 = i10 - 1;
            this.f35475b = i11;
            this.f35476c = i11;
            return (E) ((b) this.f35474a).f35468a[((b) this.f35474a).f35469b + this.f35476c];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f35475b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i10 = this.f35476c;
            if (!(i10 != -1)) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            }
            this.f35474a.remove(i10);
            this.f35475b = this.f35476c;
            this.f35476c = -1;
        }

        @Override // java.util.ListIterator
        public void set(E e10) {
            int i10 = this.f35476c;
            if (!(i10 != -1)) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            }
            this.f35474a.set(i10, e10);
        }
    }

    static {
        b bVar = new b(0);
        bVar.f35471d = true;
        f35467h = bVar;
    }

    private b(E[] eArr, int i10, int i11, boolean z10, b<E> bVar, b<E> bVar2) {
        this.f35468a = eArr;
        this.f35469b = i10;
        this.f35470c = i11;
        this.f35471d = z10;
        this.f35472e = bVar;
        this.f35473f = bVar2;
    }

    private final void f(int i10, Collection<? extends E> collection, int i11) {
        b<E> bVar = this.f35472e;
        if (bVar != null) {
            bVar.f(i10, collection, i11);
            this.f35468a = this.f35472e.f35468a;
            this.f35470c += i11;
        } else {
            m(i10, i11);
            Iterator<? extends E> it = collection.iterator();
            for (int i12 = 0; i12 < i11; i12++) {
                this.f35468a[i10 + i12] = it.next();
            }
        }
    }

    private final void g(int i10, E e10) {
        b<E> bVar = this.f35472e;
        if (bVar == null) {
            m(i10, 1);
            this.f35468a[i10] = e10;
        } else {
            bVar.g(i10, e10);
            this.f35468a = this.f35472e.f35468a;
            this.f35470c++;
        }
    }

    private final void i() {
        if (n()) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean j(List<?> list) {
        return c.h(this.f35468a, this.f35469b, this.f35470c, list);
    }

    private final void k(int i10) {
        if (this.f35472e != null) {
            throw new IllegalStateException();
        }
        if (i10 < 0) {
            throw new OutOfMemoryError();
        }
        E[] eArr = this.f35468a;
        if (i10 > eArr.length) {
            this.f35468a = (E[]) c.e(this.f35468a, kotlin.collections.k.f29782d.a(eArr.length, i10));
        }
    }

    private final void l(int i10) {
        k(this.f35470c + i10);
    }

    private final void m(int i10, int i11) {
        l(i11);
        E[] eArr = this.f35468a;
        o.i(eArr, eArr, i10 + i11, i10, this.f35469b + this.f35470c);
        this.f35470c += i11;
    }

    private final boolean n() {
        b<E> bVar;
        return this.f35471d || ((bVar = this.f35473f) != null && bVar.f35471d);
    }

    private final E o(int i10) {
        b<E> bVar = this.f35472e;
        if (bVar != null) {
            this.f35470c--;
            return bVar.o(i10);
        }
        E[] eArr = this.f35468a;
        E e10 = eArr[i10];
        o.i(eArr, eArr, i10, i10 + 1, this.f35469b + this.f35470c);
        c.f(this.f35468a, (this.f35469b + this.f35470c) - 1);
        this.f35470c--;
        return e10;
    }

    private final void p(int i10, int i11) {
        b<E> bVar = this.f35472e;
        if (bVar != null) {
            bVar.p(i10, i11);
        } else {
            E[] eArr = this.f35468a;
            o.i(eArr, eArr, i10, i10 + i11, this.f35470c);
            E[] eArr2 = this.f35468a;
            int i12 = this.f35470c;
            c.g(eArr2, i12 - i11, i12);
        }
        this.f35470c -= i11;
    }

    private final int q(int i10, int i11, Collection<? extends E> collection, boolean z10) {
        b<E> bVar = this.f35472e;
        if (bVar != null) {
            int iQ = bVar.q(i10, i11, collection, z10);
            this.f35470c -= iQ;
            return iQ;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int i14 = i10 + i12;
            if (collection.contains(this.f35468a[i14]) == z10) {
                E[] eArr = this.f35468a;
                i12++;
                eArr[i13 + i10] = eArr[i14];
                i13++;
            } else {
                i12++;
            }
        }
        int i15 = i11 - i13;
        E[] eArr2 = this.f35468a;
        o.i(eArr2, eArr2, i10 + i13, i11 + i10, this.f35470c);
        E[] eArr3 = this.f35468a;
        int i16 = this.f35470c;
        c.g(eArr3, i16 - i15, i16);
        this.f35470c -= i15;
        return i15;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e10) {
        i();
        g(this.f35469b + this.f35470c, e10);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        t.i(elements, "elements");
        i();
        int size = elements.size();
        f(this.f35469b + this.f35470c, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        i();
        p(this.f35469b, this.f35470c);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(@Nullable Object obj) {
        return obj == this || ((obj instanceof List) && j((List) obj));
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        kotlin.collections.c.Companion.b(i10, this.f35470c);
        return this.f35468a[this.f35469b + i10];
    }

    @Override // kotlin.collections.f
    public int getSize() {
        return this.f35470c;
    }

    @NotNull
    public final List<E> h() {
        if (this.f35472e != null) {
            throw new IllegalStateException();
        }
        i();
        this.f35471d = true;
        return this.f35470c > 0 ? this : f35467h;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return c.i(this.f35468a, this.f35469b, this.f35470c);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i10 = 0; i10 < this.f35470c; i10++) {
            if (t.d(this.f35468a[this.f35469b + i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.f35470c == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<E> iterator() {
        return new C0719b(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i10 = this.f35470c - 1; i10 >= 0; i10--) {
            if (t.d(this.f35468a[this.f35469b + i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator() {
        return new C0719b(this, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        i();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            remove(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        t.i(elements, "elements");
        i();
        return q(this.f35469b, this.f35470c, elements, false) > 0;
    }

    @Override // kotlin.collections.f
    public E removeAt(int i10) {
        i();
        kotlin.collections.c.Companion.b(i10, this.f35470c);
        return o(this.f35469b + i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        t.i(elements, "elements");
        i();
        return q(this.f35469b, this.f35470c, elements, true) > 0;
    }

    @Override // kotlin.collections.f, java.util.AbstractList, java.util.List
    public E set(int i10, E e10) {
        i();
        kotlin.collections.c.Companion.b(i10, this.f35470c);
        E[] eArr = this.f35468a;
        int i11 = this.f35469b;
        E e11 = eArr[i11 + i10];
        eArr[i11 + i10] = e10;
        return e11;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public List<E> subList(int i10, int i11) {
        kotlin.collections.c.Companion.d(i10, i11, this.f35470c);
        E[] eArr = this.f35468a;
        int i12 = this.f35469b + i10;
        int i13 = i11 - i10;
        boolean z10 = this.f35471d;
        b<E> bVar = this.f35473f;
        return new b(eArr, i12, i13, z10, this, bVar == null ? this : bVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public <T> T[] toArray(@NotNull T[] destination) {
        t.i(destination, "destination");
        int length = destination.length;
        int i10 = this.f35470c;
        if (length < i10) {
            E[] eArr = this.f35468a;
            int i11 = this.f35469b;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr, i11, i10 + i11, destination.getClass());
            t.h(tArr, "copyOfRange(array, offse…h, destination.javaClass)");
            return tArr;
        }
        E[] eArr2 = this.f35468a;
        int i12 = this.f35469b;
        o.i(eArr2, destination, 0, i12, i10 + i12);
        int length2 = destination.length;
        int i13 = this.f35470c;
        if (length2 > i13) {
            destination[i13] = null;
        }
        return destination;
    }

    @Override // java.util.AbstractCollection
    @NotNull
    public String toString() {
        return c.j(this.f35468a, this.f35469b, this.f35470c);
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator(int i10) {
        kotlin.collections.c.Companion.c(i10, this.f35470c);
        return new C0719b(this, i10);
    }

    @Override // kotlin.collections.f, java.util.AbstractList, java.util.List
    public void add(int i10, E e10) {
        i();
        kotlin.collections.c.Companion.c(i10, this.f35470c);
        g(this.f35469b + i10, e10);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, @NotNull Collection<? extends E> elements) {
        t.i(elements, "elements");
        i();
        kotlin.collections.c.Companion.c(i10, this.f35470c);
        int size = elements.size();
        f(this.f35469b + i10, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public Object[] toArray() {
        E[] eArr = this.f35468a;
        int i10 = this.f35469b;
        return o.p(eArr, i10, this.f35470c + i10);
    }

    public b() {
        this(10);
    }

    public b(int i10) {
        this(c.d(i10), 0, 0, false, null, null);
    }
}

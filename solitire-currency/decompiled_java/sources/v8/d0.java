package v8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UIntArray.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d0 implements Collection<c0>, i9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final int[] f35176a;

    /* JADX INFO: compiled from: UIntArray.kt */
    private static final class a implements Iterator<c0>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final int[] f35177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f35178b;

        public a(@NotNull int[] array) {
            kotlin.jvm.internal.t.i(array, "array");
            this.f35177a = array;
        }

        public int a() {
            int i10 = this.f35178b;
            int[] iArr = this.f35177a;
            if (i10 >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f35178b));
            }
            this.f35178b = i10 + 1;
            return c0.c(iArr[i10]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f35178b < this.f35177a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ c0 next() {
            return c0.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ d0(int[] iArr) {
        this.f35176a = iArr;
    }

    public static final /* synthetic */ d0 a(int[] iArr) {
        return new d0(iArr);
    }

    @NotNull
    public static int[] b(int i10) {
        return e(new int[i10]);
    }

    @NotNull
    public static int[] e(@NotNull int[] storage) {
        kotlin.jvm.internal.t.i(storage, "storage");
        return storage;
    }

    public static boolean g(int[] iArr, int i10) {
        return kotlin.collections.p.F(iArr, i10);
    }

    public static boolean h(int[] iArr, @NotNull Collection<c0> elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
        Collection<c0> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!((obj instanceof c0) && kotlin.collections.p.F(iArr, ((c0) obj).g()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean i(int[] iArr, Object obj) {
        return (obj instanceof d0) && kotlin.jvm.internal.t.d(iArr, ((d0) obj).r());
    }

    public static final int j(int[] iArr, int i10) {
        return c0.c(iArr[i10]);
    }

    public static int l(int[] iArr) {
        return iArr.length;
    }

    public static int m(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static boolean n(int[] iArr) {
        return iArr.length == 0;
    }

    @NotNull
    public static Iterator<c0> o(int[] iArr) {
        return new a(iArr);
    }

    public static final void p(int[] iArr, int i10, int i11) {
        iArr[i10] = i11;
    }

    public static String q(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(c0 c0Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends c0> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof c0) {
            return f(((c0) obj).g());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
        return h(this.f35176a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return i(this.f35176a, obj);
    }

    public boolean f(int i10) {
        return g(this.f35176a, i10);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m(this.f35176a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return n(this.f35176a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<c0> iterator() {
        return o(this.f35176a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public int size() {
        return l(this.f35176a);
    }

    public final /* synthetic */ int[] r() {
        return this.f35176a;
    }

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
    public Object[] toArray() {
        return kotlin.jvm.internal.j.a(this);
    }

    public String toString() {
        return q(this.f35176a);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.t.i(array, "array");
        return (T[]) kotlin.jvm.internal.j.b(this, array);
    }
}

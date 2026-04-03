package v8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ULongArray.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class f0 implements Collection<e0>, i9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final long[] f35181a;

    /* JADX INFO: compiled from: ULongArray.kt */
    private static final class a implements Iterator<e0>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final long[] f35182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f35183b;

        public a(@NotNull long[] array) {
            kotlin.jvm.internal.t.i(array, "array");
            this.f35182a = array;
        }

        public long a() {
            int i10 = this.f35183b;
            long[] jArr = this.f35182a;
            if (i10 >= jArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f35183b));
            }
            this.f35183b = i10 + 1;
            return e0.c(jArr[i10]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f35183b < this.f35182a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ e0 next() {
            return e0.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ f0(long[] jArr) {
        this.f35181a = jArr;
    }

    public static final /* synthetic */ f0 a(long[] jArr) {
        return new f0(jArr);
    }

    @NotNull
    public static long[] b(int i10) {
        return e(new long[i10]);
    }

    @NotNull
    public static long[] e(@NotNull long[] storage) {
        kotlin.jvm.internal.t.i(storage, "storage");
        return storage;
    }

    public static boolean g(long[] jArr, long j10) {
        return kotlin.collections.p.G(jArr, j10);
    }

    public static boolean h(long[] jArr, @NotNull Collection<e0> elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
        Collection<e0> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!((obj instanceof e0) && kotlin.collections.p.G(jArr, ((e0) obj).g()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean i(long[] jArr, Object obj) {
        return (obj instanceof f0) && kotlin.jvm.internal.t.d(jArr, ((f0) obj).r());
    }

    public static final long j(long[] jArr, int i10) {
        return e0.c(jArr[i10]);
    }

    public static int l(long[] jArr) {
        return jArr.length;
    }

    public static int m(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    public static boolean n(long[] jArr) {
        return jArr.length == 0;
    }

    @NotNull
    public static Iterator<e0> o(long[] jArr) {
        return new a(jArr);
    }

    public static final void p(long[] jArr, int i10, long j10) {
        jArr[i10] = j10;
    }

    public static String q(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(e0 e0Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends e0> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof e0) {
            return f(((e0) obj).g());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
        return h(this.f35181a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return i(this.f35181a, obj);
    }

    public boolean f(long j10) {
        return g(this.f35181a, j10);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m(this.f35181a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return n(this.f35181a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<e0> iterator() {
        return o(this.f35181a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public int size() {
        return l(this.f35181a);
    }

    public final /* synthetic */ long[] r() {
        return this.f35181a;
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
        return q(this.f35181a);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.t.i(array, "array");
        return (T[]) kotlin.jvm.internal.j.b(this, array);
    }
}

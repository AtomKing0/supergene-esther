package v8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UShortArray.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i0 implements Collection<h0>, i9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final short[] f35187a;

    /* JADX INFO: compiled from: UShortArray.kt */
    private static final class a implements Iterator<h0>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final short[] f35188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f35189b;

        public a(@NotNull short[] array) {
            kotlin.jvm.internal.t.i(array, "array");
            this.f35188a = array;
        }

        public short a() {
            int i10 = this.f35189b;
            short[] sArr = this.f35188a;
            if (i10 >= sArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f35189b));
            }
            this.f35189b = i10 + 1;
            return h0.c(sArr[i10]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f35189b < this.f35188a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ h0 next() {
            return h0.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ i0(short[] sArr) {
        this.f35187a = sArr;
    }

    public static final /* synthetic */ i0 a(short[] sArr) {
        return new i0(sArr);
    }

    @NotNull
    public static short[] b(int i10) {
        return e(new short[i10]);
    }

    @NotNull
    public static short[] e(@NotNull short[] storage) {
        kotlin.jvm.internal.t.i(storage, "storage");
        return storage;
    }

    public static boolean g(short[] sArr, short s10) {
        return kotlin.collections.p.I(sArr, s10);
    }

    public static boolean h(short[] sArr, @NotNull Collection<h0> elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
        Collection<h0> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!((obj instanceof h0) && kotlin.collections.p.I(sArr, ((h0) obj).g()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean i(short[] sArr, Object obj) {
        return (obj instanceof i0) && kotlin.jvm.internal.t.d(sArr, ((i0) obj).r());
    }

    public static final short j(short[] sArr, int i10) {
        return h0.c(sArr[i10]);
    }

    public static int l(short[] sArr) {
        return sArr.length;
    }

    public static int m(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public static boolean n(short[] sArr) {
        return sArr.length == 0;
    }

    @NotNull
    public static Iterator<h0> o(short[] sArr) {
        return new a(sArr);
    }

    public static final void p(short[] sArr, int i10, short s10) {
        sArr[i10] = s10;
    }

    public static String q(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(h0 h0Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends h0> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof h0) {
            return f(((h0) obj).g());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
        return h(this.f35187a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return i(this.f35187a, obj);
    }

    public boolean f(short s10) {
        return g(this.f35187a, s10);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m(this.f35187a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return n(this.f35187a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<h0> iterator() {
        return o(this.f35187a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public int size() {
        return l(this.f35187a);
    }

    public final /* synthetic */ short[] r() {
        return this.f35187a;
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
        return q(this.f35187a);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.t.i(array, "array");
        return (T[]) kotlin.jvm.internal.j.b(this, array);
    }
}

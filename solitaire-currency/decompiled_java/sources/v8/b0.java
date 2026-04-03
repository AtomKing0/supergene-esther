package v8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UByteArray.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b0 implements Collection<a0>, i9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final byte[] f35167a;

    /* JADX INFO: compiled from: UByteArray.kt */
    private static final class a implements Iterator<a0>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final byte[] f35168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f35169b;

        public a(@NotNull byte[] array) {
            kotlin.jvm.internal.t.i(array, "array");
            this.f35168a = array;
        }

        public byte a() {
            int i10 = this.f35169b;
            byte[] bArr = this.f35168a;
            if (i10 >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f35169b));
            }
            this.f35169b = i10 + 1;
            return a0.c(bArr[i10]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f35169b < this.f35168a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ a0 next() {
            return a0.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ b0(byte[] bArr) {
        this.f35167a = bArr;
    }

    public static final /* synthetic */ b0 a(byte[] bArr) {
        return new b0(bArr);
    }

    @NotNull
    public static byte[] b(int i10) {
        return e(new byte[i10]);
    }

    @NotNull
    public static byte[] e(@NotNull byte[] storage) {
        kotlin.jvm.internal.t.i(storage, "storage");
        return storage;
    }

    public static boolean g(byte[] bArr, byte b10) {
        return kotlin.collections.p.D(bArr, b10);
    }

    public static boolean h(byte[] bArr, @NotNull Collection<a0> elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
        Collection<a0> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!((obj instanceof a0) && kotlin.collections.p.D(bArr, ((a0) obj).g()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean i(byte[] bArr, Object obj) {
        return (obj instanceof b0) && kotlin.jvm.internal.t.d(bArr, ((b0) obj).r());
    }

    public static final byte j(byte[] bArr, int i10) {
        return a0.c(bArr[i10]);
    }

    public static int l(byte[] bArr) {
        return bArr.length;
    }

    public static int m(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public static boolean n(byte[] bArr) {
        return bArr.length == 0;
    }

    @NotNull
    public static Iterator<a0> o(byte[] bArr) {
        return new a(bArr);
    }

    public static final void p(byte[] bArr, int i10, byte b10) {
        bArr[i10] = b10;
    }

    public static String q(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(a0 a0Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends a0> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof a0) {
            return f(((a0) obj).g());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
        return h(this.f35167a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return i(this.f35167a, obj);
    }

    public boolean f(byte b10) {
        return g(this.f35167a, b10);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m(this.f35167a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return n(this.f35167a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<a0> iterator() {
        return o(this.f35167a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public int size() {
        return l(this.f35167a);
    }

    public final /* synthetic */ byte[] r() {
        return this.f35167a;
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
        return q(this.f35167a);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.t.i(array, "array");
        return (T[]) kotlin.jvm.internal.j.b(this, array);
    }
}

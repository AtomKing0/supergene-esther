package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SlidingWindow.kt */
/* JADX INFO: loaded from: classes5.dex */
final class w0<T> extends c<T> implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Object[] f29797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f29798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f29799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f29800d;

    /* JADX INFO: compiled from: SlidingWindow.kt */
    public static final class a extends b<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f29801c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f29802d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ w0<T> f29803e;

        a(w0<T> w0Var) {
            this.f29803e = w0Var;
            this.f29801c = w0Var.size();
            this.f29802d = ((w0) w0Var).f29799c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.collections.b
        protected void a() {
            if (this.f29801c == 0) {
                b();
                return;
            }
            c(((w0) this.f29803e).f29797a[this.f29802d]);
            this.f29802d = (this.f29802d + 1) % ((w0) this.f29803e).f29798b;
            this.f29801c--;
        }
    }

    public w0(@NotNull Object[] buffer, int i10) {
        kotlin.jvm.internal.t.i(buffer, "buffer");
        this.f29797a = buffer;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i10).toString());
        }
        if (i10 <= buffer.length) {
            this.f29798b = buffer.length;
            this.f29800d = i10;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i10 + " cannot be larger than the buffer size: " + buffer.length).toString());
    }

    public final void f(T t10) {
        if (h()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.f29797a[(this.f29799c + size()) % this.f29798b] = t10;
        this.f29800d = size() + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final w0<T> g(int i10) {
        Object[] array;
        int i11 = this.f29798b;
        int iJ = n9.o.j(i11 + (i11 >> 1) + 1, i10);
        if (this.f29799c == 0) {
            array = Arrays.copyOf(this.f29797a, iJ);
            kotlin.jvm.internal.t.h(array, "copyOf(this, newSize)");
        } else {
            array = toArray(new Object[iJ]);
        }
        return new w0<>(array, size());
    }

    @Override // kotlin.collections.c, java.util.List
    public T get(int i10) {
        c.Companion.b(i10, size());
        return (T) this.f29797a[(this.f29799c + i10) % this.f29798b];
    }

    @Override // kotlin.collections.c, kotlin.collections.a
    public int getSize() {
        return this.f29800d;
    }

    public final boolean h() {
        return size() == this.f29798b;
    }

    public final void i(int i10) {
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i10).toString());
        }
        if (!(i10 <= size())) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i10 + ", size = " + size()).toString());
        }
        if (i10 > 0) {
            int i11 = this.f29799c;
            int i12 = (i11 + i10) % this.f29798b;
            if (i11 > i12) {
                o.s(this.f29797a, null, i11, this.f29798b);
                o.s(this.f29797a, null, 0, i12);
            } else {
                o.s(this.f29797a, null, i11, i12);
            }
            this.f29799c = i12;
            this.f29800d = size() - i10;
        }
    }

    @Override // kotlin.collections.c, kotlin.collections.a, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }

    @Override // kotlin.collections.a, java.util.Collection
    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        kotlin.jvm.internal.t.i(array, "array");
        if (array.length < size()) {
            array = (T[]) Arrays.copyOf(array, size());
            kotlin.jvm.internal.t.h(array, "copyOf(this, newSize)");
        }
        int size = size();
        int i10 = 0;
        int i11 = 0;
        for (int i12 = this.f29799c; i11 < size && i12 < this.f29798b; i12++) {
            array[i11] = this.f29797a[i12];
            i11++;
        }
        while (i11 < size) {
            array[i11] = this.f29797a[i10];
            i11++;
            i10++;
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }

    public w0(int i10) {
        this(new Object[i10], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.a, java.util.Collection
    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}

package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ArrayIterator.kt */
/* JADX INFO: loaded from: classes5.dex */
final class b<T> implements Iterator<T>, i9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final T[] f29811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f29812b;

    public b(@NotNull T[] array) {
        t.i(array, "array");
        this.f29811a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f29812b < this.f29811a.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f29811a;
            int i10 = this.f29812b;
            this.f29812b = i10 + 1;
            return tArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f29812b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

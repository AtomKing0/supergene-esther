package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes5.dex */
final class j<T> implements Collection<T>, i9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final T[] f29779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f29780b;

    public j(@NotNull T[] values, boolean z10) {
        kotlin.jvm.internal.t.i(values, "values");
        this.f29779a = values;
        this.f29780b = z10;
    }

    public int a() {
        return this.f29779a.length;
    }

    @Override // java.util.Collection
    public boolean add(T t10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return p.H(this.f29779a, obj);
    }

    @Override // java.util.Collection
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

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f29779a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return kotlin.jvm.internal.c.a(this.f29779a);
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
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.t.i(array, "array");
        return (T[]) kotlin.jvm.internal.j.b(this, array);
    }

    @Override // java.util.Collection
    @NotNull
    public final Object[] toArray() {
        return u.b(this.f29779a, this.f29780b);
    }
}

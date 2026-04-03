package kotlin.collections;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Iterators.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class k0<T> implements Iterator<i0<? extends T>>, i9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Iterator<T> f29787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f29788b;

    /* JADX WARN: Multi-variable type inference failed */
    public k0(@NotNull Iterator<? extends T> iterator) {
        kotlin.jvm.internal.t.i(iterator, "iterator");
        this.f29787a = iterator;
    }

    @Override // java.util.Iterator
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final i0<T> next() {
        int i10 = this.f29788b;
        this.f29788b = i10 + 1;
        if (i10 < 0) {
            v.u();
        }
        return new i0<>(i10, this.f29787a.next());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f29787a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

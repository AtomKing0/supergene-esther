package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReversedViews.kt */
/* JADX INFO: loaded from: classes5.dex */
class v0<T> extends c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<T> f29794a;

    /* JADX INFO: compiled from: ReversedViews.kt */
    public static final class a implements ListIterator<T>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final ListIterator<T> f29795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ v0<T> f29796b;

        /* JADX WARN: Multi-variable type inference failed */
        a(v0<? extends T> v0Var, int i10) {
            this.f29796b = v0Var;
            this.f29795a = ((v0) v0Var).f29794a.listIterator(b0.Y(v0Var, i10));
        }

        @Override // java.util.ListIterator
        public void add(T t10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f29795a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f29795a.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            return this.f29795a.previous();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return b0.X(this.f29796b, this.f29795a.previousIndex());
        }

        @Override // java.util.ListIterator
        public T previous() {
            return this.f29795a.next();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return b0.X(this.f29796b, this.f29795a.nextIndex());
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public void set(T t10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v0(@NotNull List<? extends T> delegate) {
        kotlin.jvm.internal.t.i(delegate, "delegate");
        this.f29794a = delegate;
    }

    @Override // kotlin.collections.c, java.util.List
    public T get(int i10) {
        return this.f29794a.get(b0.W(this, i10));
    }

    @Override // kotlin.collections.c, kotlin.collections.a
    public int getSize() {
        return this.f29794a.size();
    }

    @Override // kotlin.collections.c, kotlin.collections.a, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<T> iterator() {
        return listIterator(0);
    }

    @Override // kotlin.collections.c, java.util.List
    @NotNull
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // kotlin.collections.c, java.util.List
    @NotNull
    public ListIterator<T> listIterator(int i10) {
        return new a(this, i10);
    }
}

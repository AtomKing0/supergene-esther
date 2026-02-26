package o9;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class q<T> implements g<T>, c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final g<T> f32078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f32079b;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f32080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final Iterator<T> f32081b;

        a(q<T> qVar) {
            this.f32080a = ((q) qVar).f32079b;
            this.f32081b = ((q) qVar).f32078a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f32080a > 0 && this.f32081b.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            int i10 = this.f32080a;
            if (i10 == 0) {
                throw new NoSuchElementException();
            }
            this.f32080a = i10 - 1;
            return this.f32081b.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(@NotNull g<? extends T> sequence, int i10) {
        t.i(sequence, "sequence");
        this.f32078a = sequence;
        this.f32079b = i10;
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i10 + '.').toString());
    }

    @Override // o9.c
    @NotNull
    public g<T> a(int i10) {
        int i11 = this.f32079b;
        return i10 >= i11 ? m.e() : new p(this.f32078a, i10, i11);
    }

    @Override // o9.c
    @NotNull
    public g<T> b(int i10) {
        return i10 >= this.f32079b ? this : new q(this.f32078a, i10);
    }

    @Override // o9.g
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}

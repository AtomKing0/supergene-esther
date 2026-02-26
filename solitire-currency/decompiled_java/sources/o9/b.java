package o9;

import java.util.Iterator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b<T> implements g<T>, c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final g<T> f32046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f32047b;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final Iterator<T> f32048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f32049b;

        a(b<T> bVar) {
            this.f32048a = ((b) bVar).f32046a.iterator();
            this.f32049b = ((b) bVar).f32047b;
        }

        private final void a() {
            while (this.f32049b > 0 && this.f32048a.hasNext()) {
                this.f32048a.next();
                this.f32049b--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f32048a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            return this.f32048a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull g<? extends T> sequence, int i10) {
        t.i(sequence, "sequence");
        this.f32046a = sequence;
        this.f32047b = i10;
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i10 + '.').toString());
    }

    @Override // o9.c
    @NotNull
    public g<T> a(int i10) {
        int i11 = this.f32047b + i10;
        return i11 < 0 ? new b(this, i10) : new b(this.f32046a, i11);
    }

    @Override // o9.c
    @NotNull
    public g<T> b(int i10) {
        int i11 = this.f32047b;
        int i12 = i11 + i10;
        return i12 < 0 ? new q(this, i10) : new p(this.f32046a, i11, i12);
    }

    @Override // o9.g
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}

package o9;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class p<T> implements g<T>, c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final g<T> f32072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f32073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f32074c;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final Iterator<T> f32075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f32076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ p<T> f32077c;

        a(p<T> pVar) {
            this.f32077c = pVar;
            this.f32075a = ((p) pVar).f32072a.iterator();
        }

        private final void a() {
            while (this.f32076b < ((p) this.f32077c).f32073b && this.f32075a.hasNext()) {
                this.f32075a.next();
                this.f32076b++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f32076b < ((p) this.f32077c).f32074c && this.f32075a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (this.f32076b >= ((p) this.f32077c).f32074c) {
                throw new NoSuchElementException();
            }
            this.f32076b++;
            return this.f32075a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(@NotNull g<? extends T> sequence, int i10, int i11) {
        t.i(sequence, "sequence");
        this.f32072a = sequence;
        this.f32073b = i10;
        this.f32074c = i11;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i10).toString());
        }
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i11).toString());
        }
        if (i11 >= i10) {
            return;
        }
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i11 + " < " + i10).toString());
    }

    private final int f() {
        return this.f32074c - this.f32073b;
    }

    @Override // o9.c
    @NotNull
    public g<T> a(int i10) {
        return i10 >= f() ? m.e() : new p(this.f32072a, this.f32073b + i10, this.f32074c);
    }

    @Override // o9.c
    @NotNull
    public g<T> b(int i10) {
        if (i10 >= f()) {
            return this;
        }
        g<T> gVar = this.f32072a;
        int i11 = this.f32073b;
        return new p(gVar, i11, i10 + i11);
    }

    @Override // o9.g
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}

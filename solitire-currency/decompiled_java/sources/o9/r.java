package o9;

import java.util.Iterator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class r<T, R> implements g<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final g<T> f32082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final h9.l<T, R> f32083b;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<R>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final Iterator<T> f32084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ r<T, R> f32085b;

        a(r<T, R> rVar) {
            this.f32085b = rVar;
            this.f32084a = ((r) rVar).f32082a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f32084a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) ((r) this.f32085b).f32083b.invoke(this.f32084a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r(@NotNull g<? extends T> sequence, @NotNull h9.l<? super T, ? extends R> transformer) {
        t.i(sequence, "sequence");
        t.i(transformer, "transformer");
        this.f32082a = sequence;
        this.f32083b = transformer;
    }

    @Override // o9.g
    @NotNull
    public Iterator<R> iterator() {
        return new a(this);
    }
}

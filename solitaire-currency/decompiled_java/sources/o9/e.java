package o9;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e<T> implements g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final g<T> f32051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f32052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final h9.l<T, Boolean> f32053c;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final Iterator<T> f32054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f32055b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private T f32056c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ e<T> f32057d;

        a(e<T> eVar) {
            this.f32057d = eVar;
            this.f32054a = ((e) eVar).f32051a.iterator();
        }

        private final void a() {
            while (this.f32054a.hasNext()) {
                T next = this.f32054a.next();
                if (((Boolean) ((e) this.f32057d).f32053c.invoke(next)).booleanValue() == ((e) this.f32057d).f32052b) {
                    this.f32056c = next;
                    this.f32055b = 1;
                    return;
                }
            }
            this.f32055b = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f32055b == -1) {
                a();
            }
            return this.f32055b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f32055b == -1) {
                a();
            }
            if (this.f32055b == 0) {
                throw new NoSuchElementException();
            }
            T t10 = this.f32056c;
            this.f32056c = null;
            this.f32055b = -1;
            return t10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(@NotNull g<? extends T> sequence, boolean z10, @NotNull h9.l<? super T, Boolean> predicate) {
        t.i(sequence, "sequence");
        t.i(predicate, "predicate");
        this.f32051a = sequence;
        this.f32052b = z10;
        this.f32053c = predicate;
    }

    @Override // o9.g
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}

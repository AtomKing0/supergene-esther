package o9;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes5.dex */
final class f<T> implements g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final h9.a<T> f32058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final h9.l<T, T> f32059b;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private T f32060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f32061b = -2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f<T> f32062c;

        a(f<T> fVar) {
            this.f32062c = fVar;
        }

        private final void a() {
            T t10;
            if (this.f32061b == -2) {
                t10 = (T) ((f) this.f32062c).f32058a.invoke();
            } else {
                h9.l lVar = ((f) this.f32062c).f32059b;
                T t11 = this.f32060a;
                t.f(t11);
                t10 = (T) lVar.invoke(t11);
            }
            this.f32060a = t10;
            this.f32061b = t10 == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f32061b < 0) {
                a();
            }
            return this.f32061b == 1;
        }

        @Override // java.util.Iterator
        @NotNull
        public T next() {
            if (this.f32061b < 0) {
                a();
            }
            if (this.f32061b == 0) {
                throw new NoSuchElementException();
            }
            T t10 = this.f32060a;
            t.g(t10, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f32061b = -1;
            return t10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@NotNull h9.a<? extends T> getInitialValue, @NotNull h9.l<? super T, ? extends T> getNextValue) {
        t.i(getInitialValue, "getInitialValue");
        t.i(getNextValue, "getNextValue");
        this.f32058a = getInitialValue;
        this.f32059b = getNextValue;
    }

    @Override // o9.g
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}

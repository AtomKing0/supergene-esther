package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AbstractIterator.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b<T> implements Iterator<T>, i9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private c1 f29742a = c1.f29762b;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private T f29743b;

    /* JADX INFO: compiled from: AbstractIterator.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29744a;

        static {
            int[] iArr = new int[c1.values().length];
            try {
                iArr[c1.f29763c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[c1.f29761a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f29744a = iArr;
        }
    }

    private final boolean e() {
        this.f29742a = c1.f29764d;
        a();
        return this.f29742a == c1.f29761a;
    }

    protected abstract void a();

    protected final void b() {
        this.f29742a = c1.f29763c;
    }

    protected final void c(T t10) {
        this.f29743b = t10;
        this.f29742a = c1.f29761a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        c1 c1Var = this.f29742a;
        if (!(c1Var != c1.f29764d)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i10 = a.f29744a[c1Var.ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 != 2) {
            return e();
        }
        return true;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f29742a = c1.f29762b;
        return this.f29743b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
